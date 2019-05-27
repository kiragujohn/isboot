
package com.njoroge.is.domain;

/**
 * @author John Njoroge
 * @date 16/05/2019
 */
public enum CurrencyEnum {

    EUR( 1, "EUR" ),
    USD( 2, "USD" ),
    GBP( 3, "GBP" ),
    ZAR( 5, "ZAR" );

    private long id;
    private String name;


    private CurrencyEnum( long id, String name ) {

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
