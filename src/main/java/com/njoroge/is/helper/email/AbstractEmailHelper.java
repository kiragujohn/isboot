
package com.njoroge.is.helper.email;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.mail.MailPreparationException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.njoroge.is.domain.User;
import com.njoroge.is.helper.hash.HashHelper;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * @author John Njoroge
 * @date 16/05/2019
 */
public abstract class AbstractEmailHelper {

    private Logger logger = LoggerFactory.getLogger(
            AbstractEmailHelper.class );

    protected SimpleDateFormat letterDateFormat = new SimpleDateFormat(
            "EEEEE, dd MMMM yyyy, HH:mm" );

    protected SimpleMailMessage doNotReplyTemplateMessage;

    @Autowired
    protected JavaMailSender javaMailSender;

    protected Configuration configuration;

    @Autowired
    protected MessageSource resourceBundleMessageSource;

    @Autowired
    protected HashHelper hashHelper;

    @Value( "${email.disabled}" )
    protected String emailDisabled;

    @Value( "${email.do.not.reply}" )
    protected String emailDoNotReplyTo;

    @Value( "${hostname}" )
    protected String hostName;

    // @Autowired in constructor
    @SuppressWarnings( "unused" )
    protected FreeMarkerConfigurationFactoryBean freeMarkerConfigurationFactoryBean;


    @Autowired
    protected AbstractEmailHelper(
            FreeMarkerConfigurationFactoryBean freeMarkerConfigurationFactoryBean,
            SimpleMailMessage doNotReplyTemplateMessage ) {

        this.freeMarkerConfigurationFactoryBean =
                freeMarkerConfigurationFactoryBean;

        this.doNotReplyTemplateMessage = doNotReplyTemplateMessage;

        try {
            this.configuration = freeMarkerConfigurationFactoryBean
                    .createConfiguration();

            doNotReplyTemplateMessage.setFrom( emailDoNotReplyTo );
        }
        catch ( TemplateException | IOException e ) {

            throw new MailPreparationException(
                    "A FreeMarker error occurred creating configuration", e );
        }
    }


    protected void sendMessageInThread( final SimpleMailMessage templateMessage,
            final Map<String, Object> model, final Template freemarkerTemplate,
            User user, File file, List<File> attachments ) {

        logger.debug( "Spinning off sending email in seperate thread using "
                + "freemarker template :" + freemarkerTemplate.getName() );

        Runnable runnable = new Runnable() {

            @Override
            public void run() {

                try {
                    sendMessage( templateMessage, model, user,
                            freemarkerTemplate, file, attachments );
                }
                catch ( Exception e ) {

                    logger.error(
                            "Error sending email using freemarker template, "
                                    + freemarkerTemplate.getName(), e );

                    throw new RuntimeException(
                            "Error sending email using freemarker template",
                            e );
                }
            }
        };

        Thread thread = new Thread( runnable );
        thread.start();
    }


    protected void sendMessageInThread( final SimpleMailMessage templateMessage,
            final Map<String, Object> model,
            final Template freemarkerTemplate ) {

        logger.debug( "Spinning off sending email in seperate thread using "
                + "freemarker template :" + freemarkerTemplate.getName() );

        Runnable runnable = new Runnable() {

            @Override
            public void run() {

                try {
                    sendMessage( templateMessage, model, freemarkerTemplate );
                }
                catch ( Exception e ) {

                    logger.error(
                            "Error sending email using freemarker template, "
                                    + freemarkerTemplate.getName(), e );

                    throw new RuntimeException(
                            "Error sending email using freemarker template",
                            e );
                }
            }
        };

        Thread thread = new Thread( runnable );
        thread.start();
    }

    protected void sendMessage( final SimpleMailMessage templateMessage,
            final Map<String, Object> model, User user,
            final Template freemarkerTemplate, File emailLogoFile, List<
                    File> attachments ) {

        if ( emailDisabled != null && "true".equals( emailDisabled ) ) {

            logger.debug( "Email not sent because email sending disabled "
                    + "with property email.disabled" );

            return;
        }

        javaMailSender.send( new MimeMessagePreparator() {

            @Override
            public void prepare( MimeMessage mimeMessage )
                    throws MessagingException {

                try {
                    MimeMessageHelper helper = new MimeMessageHelper(
                            mimeMessage, true, "UTF-8" );

                    MimeMailMessage mimeMailMessage = new MimeMailMessage(
                            helper );

                    templateMessage.copyTo( mimeMailMessage );
                    helper.setSubject( ( String ) model.get( "subject" ) );
                    helper.setFrom( user.getEmail() );

                    String text = FreeMarkerTemplateUtils
                            .processTemplateIntoString( freemarkerTemplate,
                                    model );

                    helper.setText( text, true );

                    if ( emailLogoFile != null ) {
                        if ( emailLogoFile.exists() ) {
                            helper.addInline( "logoemail01", emailLogoFile );
                        }
                    }

                }
                catch ( IOException e ) {

                    throw new MailPreparationException(
                            "An I/O error occurred during composition "
                                    + "of email", e );
                }
                catch ( TemplateException e ) {

                    throw new MailPreparationException(
                            "A FreeMarker error occurred during "
                                    + "composition of email", e );
                }
            }
        } );
    }


    protected void sendMessage( final SimpleMailMessage templateMessage,
            final Map<String, Object> model,
            final Template freemarkerTemplate ) {

        if ( emailDisabled != null && "true".equals( emailDisabled ) ) {

            logger.debug( "Email not sent because email sending disabled "
                    + "with property email.disabled" );

            return;
        }

        javaMailSender.send( new MimeMessagePreparator() {

            @Override
            public void prepare( MimeMessage mimeMessage )
                    throws MessagingException {

                try {

                    MimeMessageHelper helper = new MimeMessageHelper(
                            mimeMessage, true, "UTF-8" );

                    MimeMailMessage mimeMailMessage = new MimeMailMessage(
                            helper );

                    templateMessage.copyTo( mimeMailMessage );
                    helper.setSubject( ( String ) model.get( "subject" ) );
                    helper.setFrom( emailDoNotReplyTo );

                    model.put( "img", "none" );

                    String text = FreeMarkerTemplateUtils
                            .processTemplateIntoString( freemarkerTemplate,
                                    model );

                    helper.setText( text, true );
                }
                catch ( IOException e ) {

                    throw new MailPreparationException(
                            "An I/O error occurred during composition "
                                    + "of email", e );
                }
                catch ( TemplateException e ) {

                    throw new MailPreparationException(
                            "A FreeMarker error occurred during "
                                    + "composition of email", e );
                }
            }
        } );
    }


    protected void createFooterModel( Map<String, Object> model ) {

        model.put( "management", "IS" );
        model.put( "alt", "IS" );
        model.put( "title", "IS" );
    }
}
