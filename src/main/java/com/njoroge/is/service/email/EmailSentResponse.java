
package com.njoroge.is.service.email;

/**
 * @author John Njoroge
 * @date 16/05/2019
 */
public class EmailSentResponse {

    private boolean emailSent;
    private String error;


    public EmailSentResponse( boolean emailSent, String error ) {

        super();
        this.emailSent = emailSent;
        this.error = error;
    }


    public EmailSentResponse() {

        super();
    }


    public boolean isEmailSent() {

        return emailSent;
    }


    public void setEmailSent( boolean emailSent ) {

        this.emailSent = emailSent;
    }


    public String getError() {

        return error;
    }


    public void setError( String error ) {

        this.error = error;
    }

}
