
package com.njoroge.is.helper.email.buyer.registrationsuccess;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;

import com.njoroge.is.domain.User;
import com.njoroge.is.helper.email.AbstractEmailHelper;
import com.njoroge.is.service.email.EmailSentResponse;

/**
 * @author John Njoroge
 * @date 16/05/2019
 */
@Component
public class BuyerRegistrationSuccessEmailHelperImpl extends AbstractEmailHelper
        implements BuyerRegistrationSuccessEmailHelper {

    protected BuyerRegistrationSuccessEmailHelperImpl(
            FreeMarkerConfigurationFactoryBean freeMarkerConfigurationFactoryBean,
            SimpleMailMessage doNotReplyTemplateMessage ) {

        super( freeMarkerConfigurationFactoryBean, doNotReplyTemplateMessage );
        // TODO Auto-generated constructor stub
    }

    private Logger logger = LoggerFactory.getLogger(
            BuyerRegistrationSuccessEmailHelperImpl.class );


    @Override
    public EmailSentResponse sendEmailCreateBuyerAccount( String organisation,
            User user, Locale locale, String contextPath, String domain,
            int serverPort, String protocol ) {

        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public EmailSentResponse sendEmailCreateBuyerAccountWithoutActivation(
            String organisation, User user, Locale locale, String domain,
            int serverPort, String protocol ) {

        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public EmailSentResponse sendEmailPendingBuyerAccountActivated(
            String currentOrganisation, String organisationToActivate,
            User user, Locale locale, String domain, int serverPort ) {

        // TODO Auto-generated method stub
        return null;
    }

    //
    // protected BuyerRegistrationSuccessEmailHelperImpl(
    // FreeMarkerConfigurationFactoryBean freeMarkerConfigurationFactoryBean,
    // SimpleMailMessage doNotReplyTemplateMessage ) {
    //
    // super( freeMarkerConfigurationFactoryBean, doNotReplyTemplateMessage );
    // }
    //
    //
    // private void createSubjectModel( Map<String, Object> model,
    // String organisation, Locale locale, String messageType ) {
    //
    // String subject = createSubject( locale, messageType );
    //
    // String formattedSubject = MessageFormat.format( subject,
    // "organisation" );
    //
    // model.put( "subject", formattedSubject );
    // }
    //
    //
    // private String createBody( Locale locale, String messageyTpe ) {
    //
    // String body = null;
    //
    // if ( messageyTpe.equals( ACCOUNT_ACTIVATION_LINK ) ) {
    //
    // body = resourceBundleMessageSource.getMessage(
    // "BuyerRegistrationSuccessEmailHelperImpl.createMember.body",
    // new Object[] {}, locale );
    // }
    // else if ( messageyTpe.equals( PENDING_ACCOUNT_ACTIVATED ) ) {
    //
    // body = resourceBundleMessageSource.getMessage(
    // "BuyerRegistrationSuccessEmailHelperImpl.sendPendingBuyerAccountActivated.body",
    // new Object[] {}, locale );
    // }
    // else {
    //
    // body = resourceBundleMessageSource.getMessage(
    // "BuyerRegistrationSuccessEmailHelperImpl.createMemberWithoutActivation.body",
    // new Object[] {}, locale );
    // }
    //
    // return body;
    //
    // }
    //
    //
    // private String createSubject( Locale locale, String messageyTpe ) {
    //
    // String subject = null;
    //
    // if ( messageyTpe.equals( ACCOUNT_ACTIVATION_LINK ) ) {
    //
    // subject = resourceBundleMessageSource.getMessage(
    // "BuyerRegistrationSuccessEmailHelperImpl.createMember.subject",
    // new Object[] {}, locale );
    // }
    // else if ( messageyTpe.equals( PENDING_ACCOUNT_ACTIVATED ) ) {
    //
    // subject = resourceBundleMessageSource.getMessage(
    // "BuyerRegistrationSuccessEmailHelperImpl.accountActivated.subject",
    // new Object[] {}, locale );
    // }
    // else {
    //
    // subject = resourceBundleMessageSource.getMessage(
    // "BuyerRegistrationSuccessEmailHelperImpl.accountActivated.subject",
    // new Object[] {}, locale );
    // }
    //
    // return subject;
    //
    // }
    //
    //
    // private void createBodyModel( Map<String, Object> model, Locale locale,
    // User user,
    // String bodyType ) {
    //
    // String dear = resourceBundleMessageSource.getMessage(
    // "BuyerRegistrationSuccessEmailHelperImpl.dear", new Object[] {},
    // locale );
    //
    // model.put( "dear", dear );
    // model.put( "name", user.getFirstName() );
    //
    // String body = createBody( locale, bodyType );
    //
    // String formattedBody = MessageFormat.format( body,
    // "Organisation name" );
    //
    // model.put( "body", formattedBody );
    // }
    //
    //
    // private void createBodyForPendingActivationModel( Map<String, Object>
    // model,
    // Organisation currentOrganisation,
    // Organisation organisationToActivate, Locale locale, User user,
    // String messageyTpe ) {
    //
    // String dear = resourceBundleMessageSource.getMessage(
    // "BuyerRegistrationSuccessEmailHelperImpl.dear", new Object[] {},
    // locale );
    //
    // model.put( "dear", dear );
    // model.put( "name", user.getFirstName() );
    //
    // String body = createBody( locale, messageyTpe );
    //
    // String formattedBody = MessageFormat.format( body,
    // organisationToActivate.getName(), currentOrganisation
    // .getName() );
    //
    // model.put( "body", formattedBody );
    // }
    //
    //
    // private String getFormattedProtocol( String protocol ) {
    //
    // StringBuilder link = new StringBuilder();
    // link.append( protocol );
    // link.append( "//" );
    // return link.toString();
    // }
    //
    //
    // private void createActivateAccountLinkModel( Map<String, Object> model,
    // User user, String contextPath, String domain, int serverPort,
    // String protocol ) {
    //
    // String code = user.getEmailValidationCode();
    //
    // String link = getFormattedProtocol( protocol ) + domain + ":"
    // + serverPort + contextPath
    // + "?code=" + code;
    //
    // model.put( "link", link );
    // }
    //
    //
    // @Override
    // public EmailSentResponse sendEmailCreateBuyerAccount(
    // Organisation organisation, User user, Locale locale,
    // String contextPath, String domain, int serverPort,
    // String protocol ) {
    //
    // String messageType = ACCOUNT_ACTIVATION_LINK;
    //
    // String templateName = "sendBuyerAccountCreatedWithActivationLink.tfl";
    // EmailSentResponse emailSentResponse;
    //
    // try {
    // Template freeMarkerTemplate = this.configuration.getTemplate(
    // templateName );
    //
    // Map<String, Object> model = new HashMap<String, Object>();
    // // createDateModel( model, locale );
    // createSubjectModel( model, organisation, locale, messageType );
    // createBodyModel( model, organisation, locale, user, messageType );
    //
    // createActivateAccountLinkModel( model, user, contextPath, domain,
    // serverPort, protocol );
    //
    // createFooterModel( model, organisation, locale );
    // doNotReplyTemplateMessage.setTo( user.getEmail() );
    // File emailLogoFile = getOrganisationLogo( organisation );
    //
    // sendMessageInThread( doNotReplyTemplateMessage, model,
    // freeMarkerTemplate, emailLogoFile );
    //
    // emailSentResponse = new EmailSentResponse( Boolean.TRUE, "" );
    // }
    // catch ( IOException e ) {
    //
    // emailSentResponse = new EmailSentResponse( Boolean.FALSE, e
    // .getMessage() );
    //
    // logger.error( "An I/O error occurred during composition "
    // + "of email", e );
    //
    // throw new MailPreparationException(
    // "An I/O error occurred during composition " + "of email",
    // e );
    // }
    // return emailSentResponse;
    // }
    //
    //
    // @Override
    // public EmailSentResponse sendEmailCreateBuyerAccountWithoutActivation(
    // Organisation organisation, User user, Locale locale, String domain,
    // int serverPort, String protocol ) {
    //
    // String messageType = ACCOUNT_ACTIVATION_WITHOUT_LINK;
    // String templateName =
    // "sendBuyerAccountCreatedWithoutActivationLink.tfl";
    //
    // EmailSentResponse emailSentResponse;
    //
    // try {
    // Template freeMarkerTemplate = this.configuration.getTemplate(
    // templateName );
    //
    // Map<String, Object> model = new HashMap<String, Object>();
    // // createDateModel( model, locale );
    // createSubjectModel( model, organisation, locale, messageType );
    // createBodyModel( model, organisation, locale, user, messageType );
    //
    // createFooterModel( model, organisation, locale );
    // doNotReplyTemplateMessage.setTo( user.getEmail() );
    // File emailLogoFile = getOrganisationLogo( organisation );
    //
    // sendMessageInThread( doNotReplyTemplateMessage, model,
    // freeMarkerTemplate, emailLogoFile );
    //
    // emailSentResponse = new EmailSentResponse( Boolean.TRUE, "" );
    // }
    // catch ( IOException e ) {
    //
    // emailSentResponse = new EmailSentResponse( Boolean.FALSE, e
    // .getMessage() );
    //
    // logger.error( "An I/O error occurred during composition "
    // + "of email", e );
    //
    // throw new MailPreparationException(
    // "An I/O error occurred during composition " + "of email",
    // e );
    // }
    // return emailSentResponse;
    // }
    //
    //
    // @Override
    // public EmailSentResponse sendEmailPendingBuyerAccountActivated(
    // Organisation currentOrganisation,
    // Organisation organisationToActivate, User user, Locale locale,
    // String domain, int serverPort ) {
    //
    // String messageType = PENDING_ACCOUNT_ACTIVATED;
    //
    // String templateName = "sendPendingBuyerAccountActivated.tfl";
    //
    // EmailSentResponse emailSentResponse;
    //
    // try {
    // Template freeMarkerTemplate = this.configuration.getTemplate(
    // templateName );
    //
    // Map<String, Object> model = new HashMap<String, Object>();
    // // createDateModel( model, locale );
    //
    // createSubjectModel( model, organisationToActivate, locale,
    // messageType );
    //
    // createBodyForPendingActivationModel( model, currentOrganisation,
    // organisationToActivate, locale, user, messageType );
    //
    // createFooterModel( model, organisationToActivate, locale );
    // doNotReplyTemplateMessage.setTo( user.getEmail() );
    // File emailLogoFile = getOrganisationLogo( organisationToActivate );
    //
    // sendMessageInThread( doNotReplyTemplateMessage, model,
    // freeMarkerTemplate, emailLogoFile );
    //
    // emailSentResponse = new EmailSentResponse( Boolean.TRUE, "" );
    // }
    // catch ( IOException e ) {
    //
    // emailSentResponse = new EmailSentResponse( Boolean.FALSE, e
    // .getMessage() );
    //
    // logger.error( "An I/O error occurred during composition "
    // + "of email", e );
    //
    // throw new MailPreparationException(
    // "An I/O error occurred during composition " + "of email",
    // e );
    // }
    // return emailSentResponse;
    // }

}
