
package com.njoroge.is.service.email;

/**
 * @author John Njoroge
 * @date 16/05/2019
 */
public class EmailActivationResponse {

    private boolean emailActivation;
    private String error;


    public EmailActivationResponse( boolean emailActivation, String error ) {

        super();
        this.emailActivation = emailActivation;
        this.error = error;
    }


    public EmailActivationResponse() {

        super();
    }


    public boolean isEmailActivation() {

        return emailActivation;
    }


    public void setEmailActivation( boolean emailActivation ) {

        this.emailActivation = emailActivation;
    }


    public String getError() {

        return error;
    }


    public void setError( String error ) {

        this.error = error;
    }
}
