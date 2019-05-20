
package com.njoroge.is.service.shared;

/**
 * @author John Njoroge
 * @date 16/05/2019
 */
public class SaveResponse {

    private boolean saved;
    private String error;


    public SaveResponse() {

    }


    public SaveResponse( boolean saved, String error ) {

        this.saved = saved;
        this.error = error;
    }


    public String getError() {

        return error;
    }


    public void setError( String error ) {

        this.error = error;
    }


    public boolean isSaved() {

        return saved;
    }


    public void setSaved( boolean saved ) {

        this.saved = saved;
    }
}
