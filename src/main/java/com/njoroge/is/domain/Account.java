
package com.njoroge.is.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author John Njoroge
 * @date 16/05/2019
 */
@Entity
@Table( name = "account" )
public class Account extends AbstractPersistentEntity {

    private static final long serialVersionUID = 3747537648568724966L;

    @Column( name = "account_number", nullable = false, unique = true,
            length = 250 )
    private Integer accountNumber;

    @ManyToOne( )
    @JoinColumn( name = "fk_account_type", nullable = false )
    private AccountType accountType;

    @ManyToOne( )
    @JoinColumn( name = "fk_user", nullable = false )
    private User user;


    public AccountType getAccountType() {

        return accountType;
    }


    public void setAccountType( AccountType accountType ) {

        this.accountType = accountType;
    }


    public User getUser() {

        return user;
    }


    public void setUser( User user ) {

        this.user = user;
    }


    public Integer getAccountNumber() {

        return accountNumber;
    }


    public void setAccountNumber( Integer accountNumber ) {

        this.accountNumber = accountNumber;
    }
}
