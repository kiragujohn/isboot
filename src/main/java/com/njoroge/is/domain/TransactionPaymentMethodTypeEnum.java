
package com.njoroge.is.domain;

/**
 * @author John Njoroge
 * @date 16/05/2019
 */
public enum TransactionPaymentMethodTypeEnum {

    BANK( 1, "BANK" ),
    CASH( 2, "CASH" ),
    CHEQUE( 3,"CHEQUE" ),
    CREDIT_CARD( 4, "CREDIT_CARD" );

    private long id;
    private String name;

    private TransactionPaymentMethodTypeEnum( long id, String name ) {

        this.id = id;
        this.name = name;
    }


    public long getId() {

        return id;
    }


    public void setId( long id ) {

        this.id = id;
    }


    public String getName() {

        return name;
    }


    public void setName( String name ) {

        this.name = name;
    }
}
