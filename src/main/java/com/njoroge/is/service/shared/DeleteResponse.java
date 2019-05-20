
package com.njoroge.is.service.shared;

/**
 * @author John Njoroge
 * @date 16/05/2019
 */
public class DeleteResponse {

    private String error;
    private boolean deleted;


    public DeleteResponse( boolean deleted, String error ) {

        this.deleted = deleted;
        this.error = error;
    }


    public DeleteResponse() {

    }


    public String getError() {

        return error;
    }


    public void setError( String error ) {

        this.error = error;
    }


    public boolean isDeleted() {

        return deleted;
    }


    public void setDeleted( boolean deleted ) {

        this.deleted = deleted;
    }
}
