
package com.njoroge.is.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author John Njoroge
 * @date 16/05/2019
 */
@Entity
@Table( name = "currency" )
public class Currency extends AbstractPersistentEntity {

    private static final long serialVersionUID = -8282856656442549951L;

    @Column( name = "name", nullable = false, unique = true, length = 5 )
    private String name;


    public String getName() {

        return name;
    }


    public void setName( String name ) {

        this.name = name;
    }
}
