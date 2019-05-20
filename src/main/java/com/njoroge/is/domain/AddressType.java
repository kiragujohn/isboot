
package com.njoroge.is.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author John Njoroge
 * @date 16/05/2019
 */
@Entity
@Table( name = "address_type" )
public class AddressType extends AbstractPersistentEntity {

    private static final long serialVersionUID = -3675888742314149665L;

    @Column( name = "name", nullable = false, unique = false, length = 50 )
    private String name;


    public String getName() {

        return name;
    }


    public void setName( String name ) {

        this.name = name;
    }
}
