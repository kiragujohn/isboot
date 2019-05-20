
package com.njoroge.is.service.login;

/**
 * @author John Njoroge
 * @date 16/05/2019
 */
public class LoginInitialData {

    private Long userId;
    private String firstName;


    public LoginInitialData( Long userId, String firstName ) {

        this.userId = userId;
        this.firstName = firstName;
    }


    public Long getUserId() {

        return userId;
    }


    public void setUserId( Long userId ) {

        this.userId = userId;
    }


    public String getFirstName() {

        return firstName;
    }


    public void setFirstName( String firstName ) {

        this.firstName = firstName;
    }

}
