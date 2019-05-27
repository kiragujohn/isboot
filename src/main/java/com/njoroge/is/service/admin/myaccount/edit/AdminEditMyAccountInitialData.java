
package com.njoroge.is.service.admin.myaccount.edit;

/**
 * @author John Njoroge
 * @date 23/05/2019
 */
public class AdminEditMyAccountInitialData {

    private UserTransfer user;


    public AdminEditMyAccountInitialData( UserTransfer user ) {

        this.user = user;
    }


    public AdminEditMyAccountInitialData() {

        super();
    }


    public UserTransfer getUser() {

        return user;
    }


    public void setUser( UserTransfer user ) {

        this.user = user;
    }

}
