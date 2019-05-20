
package com.njoroge.is.service.email;

/**
 * @author John Njoroge
 * @date 16/05/2019
 */
public class EmailActivationRequest {

    private String emailValidationCode;
    private String localeStr;


    public EmailActivationRequest( String emailValidationCode,
            String localeStr ) {

        this.emailValidationCode = emailValidationCode;
        this.localeStr = localeStr;
    }


    public EmailActivationRequest() {

        super();
    }


    public String getEmailValidationCode() {

        return emailValidationCode;
    }


    public void setEmailValidationCode( String emailValidationCode ) {

        this.emailValidationCode = emailValidationCode;
    }


    public String getLocaleStr() {

        return localeStr;
    }


    public void setLocaleStr( String localeStr ) {

        this.localeStr = localeStr;
    }
}
