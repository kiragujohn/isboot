
package com.njoroge.is.helper.email.buyer.registrationsuccess;

import java.util.Locale;

import com.njoroge.is.domain.User;
import com.njoroge.is.service.email.EmailSentResponse;

/**
 * @author John Njoroge
 * @date 16/05/2019
 */
public interface BuyerRegistrationSuccessEmailHelper {

    String ACCOUNT_ACTIVATION_LINK = "ACCOUNT_ACTIVATION_LINK";
    String PENDING_ACCOUNT_ACTIVATED = "PENDING_ACCOUNT_ACTIVATED";
    String ACCOUNT_ACTIVATION_WITHOUT_LINK = "ACCOUNT_ACTIVATION_WITHOUT_LINK";


    EmailSentResponse sendEmailCreateBuyerAccount( String organisation,
            User user, Locale locale, String contextPath, String domain,
            int serverPort, String protocol );


    EmailSentResponse sendEmailCreateBuyerAccountWithoutActivation(
            String organisation, User user, Locale locale, String domain,
            int serverPort, String protocol );


    EmailSentResponse sendEmailPendingBuyerAccountActivated(
            String currentOrganisation, String organisationToActivate,
            User user, Locale locale,
            String domain, int serverPort );
}
