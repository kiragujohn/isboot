
package com.njoroge.is.service.email;

/**
 * @author John Njoroge
 * @date 16/05/2019
 */
public class ResendEmailActivationRequest {

    private String email;
    private String localeStr;


    public ResendEmailActivationRequest( String email, String localeStr ) {

        this.email = email;
        this.localeStr = localeStr;
    }


    public ResendEmailActivationRequest() {

        super();
    }


    public String getEmail() {

        return email;
    }


    public void setEmail( String email ) {

        this.email = email;
    }


    public String getLocaleStr() {

        return localeStr;
    }


    public void setLocaleStr( String localeStr ) {

        this.localeStr = localeStr;
    }
}
