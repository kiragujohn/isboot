
package com.njoroge.is.domain;

/**
 * @author John Njoroge
 * @date 16/05/2019
 */
public enum AddressTypeEnum {

    PHYSICAL( ( long ) 1 ), POSTAL( ( long ) 2 );

    private Long id;


    private AddressTypeEnum( Long id ) {

        this.id = id;
    }


    public Long getId() {

        return id;
    }
}
