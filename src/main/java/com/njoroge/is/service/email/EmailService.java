
package com.njoroge.is.service.email;

/**
 * @author John Njoroge
 * @date 16/05/2019
 */
public interface EmailService {

    EmailActivationResponse activateUserEmail( String domain, String email,
            String localeStr, int serverPort );

}

