
package com.njoroge.is.service.admin.user.select;

public class AdminUserSelectInitialData {

    private UserTransfer[] users;

    public AdminUserSelectInitialData() {

    }


    public AdminUserSelectInitialData( UserTransfer[] users ) {

        this.users = users;
    }


    public UserTransfer[] getUsers() {

        return users;
    }


    public void setUsers( UserTransfer[] users ) {

        this.users = users;
    }


}