
package com.njoroge.is.domain;

/**
 * @author John Njoroge
 * @date 16/05/2019
 */
public enum AccountTypeEnum {

    CHEQUE( ( long ) 1 ), SAVINGS( ( long ) 2 );

    private Long id;


    private AccountTypeEnum( Long id ) {

        this.id = id;
    }


    public Long getId() {

        return id;
    }
}
