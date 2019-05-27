
package com.njoroge.is.service.user.myaccount.edit;

/**
 * @author John Njoroge
 * @date 23/05/2019
 */
public class UserEditMyAccountInitialData {

    private UserTransfer user;


    public UserEditMyAccountInitialData( UserTransfer user ) {

        this.user = user;
    }


    public UserEditMyAccountInitialData() {

        super();
    }


    public UserTransfer getUser() {

        return user;
    }


    public void setUser( UserTransfer user ) {

        this.user = user;
    }

}
