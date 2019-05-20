
package com.njoroge.is.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author John Njoroge
 * @date 22/01/2018
 */
@Entity
@Table( name = "country" )
public class Country extends AbstractPersistentEntity {

    private static final long serialVersionUID = 8776057889172694922L;

    @Column( name = "name", nullable = false, unique = true, length = 50 )
    private String name;

    @Column( name = "country_code", nullable = false, unique = true,
            length = 5 )
    private String countryCode;


    public String getName() {

        return name;
    }


    public void setName( String name ) {

        this.name = name;
    }


    public String getCountryCode() {

        return countryCode;
    }


    public void setCountryCode( String countryCode ) {

        this.countryCode = countryCode;
    }
}
