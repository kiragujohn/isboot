
package com.njoroge.is.helper.email.user.registrationsuccess;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.mail.MailPreparationException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;

import com.njoroge.is.domain.User;
import com.njoroge.is.helper.email.AbstractEmailHelper;
import com.njoroge.is.service.email.EmailSentResponse;

import freemarker.template.Template;

/**
 * @author John Njoroge
 * @date 16/05/2019
 */
@Component
public class UserRegistrationSuccessEmailHelperImpl extends AbstractEmailHelper
        implements UserRegistrationSuccessEmailHelper {

    protected UserRegistrationSuccessEmailHelperImpl(
            FreeMarkerConfigurationFactoryBean freeMarkerConfigurationFactoryBean,
            SimpleMailMessage doNotReplyTemplateMessage ) {

        super( freeMarkerConfigurationFactoryBean, doNotReplyTemplateMessage );
    }


    private void createSubjectModel( Map<String, Object> model,
            Locale locale ) {

        String subject = createSubject( locale );

        String formattedSubject = MessageFormat.format( subject,
                "organisation" );

        model.put( "subject", formattedSubject );
    }


    private String createBody( Locale locale ) {

        String body = null;

            body = resourceBundleMessageSource.getMessage(
                    "BuyerRegistrationSuccessEmailHelperImpl.createMemberWithoutActivation.body",
                    new Object[] {}, locale );


        return body;

    }


    private String createSubject( Locale locale ) {

        String subject = resourceBundleMessageSource.getMessage(
                    "BuyerRegistrationSuccessEmailHelperImpl.accountActivated.subject",
                    new Object[] {}, locale );

        return subject;
    }


    private void createBodyModel( Map<String, Object> model, Locale locale,
            User user ) {

        String dear = resourceBundleMessageSource.getMessage(
                "BuyerRegistrationSuccessEmailHelperImpl.dear", new Object[] {},
                locale );

        model.put( "dear", dear );
        model.put( "name", user.getFirstName() );

        String body = createBody( locale );

        String formattedBody = MessageFormat.format( body,
                "Organisation name" );

        model.put( "body", formattedBody );
    }


    @Override
    public EmailSentResponse sendEmailCreateUserAccount(
            User user ) {

        String templateName =
                "sendBuyerAccountCreatedWithoutActivationLink.tfl";

        EmailSentResponse emailSentResponse;

        try {
            Template freeMarkerTemplate = this.configuration.getTemplate(
                    templateName );

            Locale locale = Locale.ENGLISH;

            Map<String, Object> model = new HashMap<String, Object>();
            createSubjectModel( model, locale );
            createBodyModel( model, locale, user );

            createFooterModel( model );
            doNotReplyTemplateMessage.setTo( user.getEmail() );

            sendMessageInThread( doNotReplyTemplateMessage, model,
                    freeMarkerTemplate );

            emailSentResponse = new EmailSentResponse( Boolean.TRUE, "" );
        }
        catch ( IOException e ) {

            emailSentResponse = new EmailSentResponse( Boolean.FALSE, e
                    .getMessage() );

            throw new MailPreparationException(
                    "An I/O error occurred during composition " + "of email",
                    e );
        }
        return emailSentResponse;
    }

}
