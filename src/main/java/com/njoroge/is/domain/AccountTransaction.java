
package com.njoroge.is.domain;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author John Njoroge
 * @date 16/05/2019
 */
@Entity
@Table( name = "account_transaction" )
public class AccountTransaction extends AbstractPersistentEntity {


    private static final long serialVersionUID = 8307835944643783601L;

    @Column( name = "transaction_id", nullable = false, unique = true,
            length = 20 )
    private String transactionId;

    @Column( name = "description", nullable = true, unique = false,
            length = 200 )
    private String description;

    @Temporal( TemporalType.TIMESTAMP )
    @Column( name = "paid_date", updatable = true, nullable = true,
            columnDefinition = "TIMESTAMP WITH TIME ZONE" )
    private Calendar paidDate;

    @Column( name = "amount", precision = 11, scale = 2, updatable = true,
            nullable = true )
    private BigDecimal amount;

    @ManyToOne( )
    @JoinColumn( name = "fk_account", nullable = false )
    private Account account;

    @ManyToOne( )
    @JoinColumn( name = "fk_currency", nullable = false )
    private Currency currency;

    @ManyToOne( )
    @JoinColumn( name = "fk_paymentMethod", nullable = false )
    private TransactionPaymentMethod transactionPaymentMethod;


    public String getTransactionId() {

        return transactionId;
    }


    public void setTransactionId( String transactionId ) {

        this.transactionId = transactionId;
    }


    public String getDescription() {

        return description;
    }


    public void setDescription( String description ) {

        this.description = description;
    }


    public Calendar getPaidDate() {

        return paidDate;
    }


    public void setPaidDate( Calendar paidDate ) {

        this.paidDate = paidDate;
    }


    public BigDecimal getAmount() {

        return amount;
    }


    public void setAmount( BigDecimal amount ) {

        this.amount = amount;
    }


    public Currency getCurrency() {

        return currency;
    }


    public void setCurrency( Currency currency ) {

        this.currency = currency;
    }


    public Account getAccount() {

        return account;
    }


    public void setAccount( Account account ) {

        this.account = account;
    }


    public TransactionPaymentMethod getTransactionPaymentMethod() {

        return transactionPaymentMethod;
    }


    public void setTransactionPaymentMethod(
            TransactionPaymentMethod transactionPaymentMethod ) {

        this.transactionPaymentMethod = transactionPaymentMethod;
    }


    @Override
    public int hashCode() {

        return super.hashCode();
    }


    @Override
    public boolean equals( Object obj ) {

        return super.equals( obj );
    }
}
