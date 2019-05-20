
package com.njoroge.is.service.shared;

/**
 * @author John Njoroge
 * @date 16/05/2019
 */
public class VerificationResponse {

    private boolean status;
    private String response;


    public VerificationResponse( boolean status, String response ) {

        this.status = status;
        this.response = response;
    }


    public VerificationResponse() {

        super();
    }


    public boolean isStatus() {

        return status;
    }


    public void setStatus( boolean status ) {

        this.status = status;
    }


    public String getResponse() {

        return response;
    }


    public void setResponse( String response ) {

        this.response = response;
    }
}
