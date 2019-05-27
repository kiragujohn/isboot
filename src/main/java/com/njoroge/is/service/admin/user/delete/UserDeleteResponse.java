/*
    ============================================================================
    This code is part of 43Kare Software Systems.

    The 43Kare software has a proprietary license. Please look at or request
    43_KARE_LICENSE.txt for further details.

    Copyright (C) 2018 43 Kare

    Email:  rk@43kare.de

    ============================================================================
    Author : Ronald Kasaija
    ============================================================================
*/
package com.njoroge.is.service.admin.user.delete;

/**
 * @author Ronald Kasaija
 * @date 13/10/2018
 */
public class UserDeleteResponse {

    private Boolean deleted;
    private String error;


    public UserDeleteResponse() {

    }


    public UserDeleteResponse( Boolean deleted, String error ) {

        this.deleted = deleted;
        this.error = error;
    }


    public Boolean getDeleted() {

        return deleted;
    }


    public void setDeleted( Boolean deleted ) {

        this.deleted = deleted;
    }


    public String getError() {

        return error;
    }


    public void setError( String error ) {

        this.error = error;
    }
}
