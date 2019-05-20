
package com.njoroge.is.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author John Njoroge
 * @date 16/05/2019
 */
@Entity
@Table( name = "payment_method" )
public class TransactionPaymentMethod extends AbstractPersistentEntity {

    private static final long serialVersionUID = 6041286902366782114L;

    @Column( name = "name", nullable = true, unique = false, length = 20 )
    private String name;


    public String getName() {

        return name;
    }


    public void setName( String name ) {

        this.name = name;
    }
}
