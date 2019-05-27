
package com.njoroge.is.service.admin.user.edit;

/**
 * @author John Njoroge
 * @date 23/05/2019
 */
public class AdminUserEditInitialData {

    private UserTransfer user;


    public AdminUserEditInitialData( UserTransfer user ) {

        this.user = user;
    }


    public AdminUserEditInitialData() {

        super();
    }


    public UserTransfer getUser() {

        return user;
    }


    public void setUser( UserTransfer user ) {

        this.user = user;
    }

}
