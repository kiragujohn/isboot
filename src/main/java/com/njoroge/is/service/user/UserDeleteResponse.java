
package com.njoroge.is.service.user;

/**
 * @author John Njoroge
 * @date 16/05/2019
 */
public class UserDeleteResponse {

    private Boolean userDeleted;
    private String message;


    public UserDeleteResponse( Boolean wasDeleted, String message ) {

        this.userDeleted = wasDeleted;
        this.message = message;
    }


    public Boolean getUserDeleted() {

        return userDeleted;
    }


    public void setUserDeleted( Boolean userDeleted ) {

        this.userDeleted = userDeleted;
    }


    public String getMessage() {

        return message;
    }


    public void setMessage( String message ) {

        this.message = message;
    }

}
