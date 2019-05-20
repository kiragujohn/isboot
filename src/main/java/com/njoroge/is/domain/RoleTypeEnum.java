
package com.njoroge.is.domain;

/**
 * @author John Njoroge
 * @date 16/05/2019
 */
public enum RoleTypeEnum {

    USER( 1, "USER" ), CASH( 2, "ADMIN" ), CHEQUE( 3, "GUEST" );

    private long id;
    private String name;


    private RoleTypeEnum( long id, String name ) {

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
