
package com.njoroge.is.service.admin.myaccount.edit;

/**
 * @author John Njoroge
 * @date 23/05/2019
 */
public class AccountTransfer {

    private Long id;
    public Long accountNumber;
    public String accountType;
    public boolean active;


    public AccountTransfer() {

        super();
    }


    public AccountTransfer( Long id, Long accountNumber, String accountType,
            boolean active ) {

        this.id = id;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.active = active;
    }



    public Long getId() {

        return id;
    }



    public void setId( Long id ) {

        this.id = id;
    }


    public Long getAccountNumber() {

        return accountNumber;
    }


    public void setAccountNumber( Long accountNumber ) {

        this.accountNumber = accountNumber;
    }


    public String getAccountType() {

        return accountType;
    }


    public void setAccountType( String accountType ) {

        this.accountType = accountType;
    }


    public boolean isActive() {

        return active;
    }


    public void setActive( boolean active ) {

        this.active = active;
    }


}
