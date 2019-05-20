
package com.njoroge.is.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author John Njoroge
 * @date 16/05/2019
 */
@Entity
@Table( name = "address" )
public class Address extends AbstractPersistentEntity {

    private static final long serialVersionUID = 5093883006598070659L;

    @Column( name = "first_line", nullable = false, unique = false,
            length = 60 )
    private String firstLine;

    @Column( name = "second_line", nullable = true, unique = false,
            length = 60 )
    private String secondLine;

    @Column( name = "third_line", nullable = true, unique = false, length = 60 )
    private String thirdLine;

    @Column( name = "fourth_line", nullable = true, unique = false,
            length = 60 )
    private String fourthLine;

    @Column( name = "town_or_city", nullable = true, unique = false,
            length = 60 )
    private String townOrCity;

    @Column( name = "post_code", nullable = true, unique = false, length = 60 )
    private String postCode;

    @ManyToOne( )
    @JoinColumn( name = "fk_country", nullable = false )
    private Country country;

    @ManyToOne( )
    @JoinColumn( name = "fk_address_type", nullable = false )
    private AddressType addressType;

    @ManyToOne( )
    @JoinColumn( name = "fk_user", nullable = false )
    private User user;


    public User getUser() {

        return user;
    }


    public void setUser( User user ) {

        this.user = user;
    }


    public String getFirstLine() {

        return firstLine;
    }


    public void setFirstLine( String firstLine ) {

        this.firstLine = firstLine;
    }


    public String getSecondLine() {

        return secondLine;
    }


    public void setSecondLine( String secondLine ) {

        this.secondLine = secondLine;
    }


    public String getThirdLine() {

        return thirdLine;
    }


    public void setThirdLine( String thirdLine ) {

        this.thirdLine = thirdLine;
    }


    public String getFourthLine() {

        return fourthLine;
    }


    public void setFourthLine( String fourthLine ) {

        this.fourthLine = fourthLine;
    }


    public String getTownOrCity() {

        return townOrCity;
    }


    public void setTownOrCity( String townOrCity ) {

        this.townOrCity = townOrCity;
    }


    public String getPostCode() {

        return postCode;
    }


    public void setPostCode( String postCode ) {

        this.postCode = postCode;
    }


    public Country getCountry() {

        return country;
    }


    public void setCountry( Country country ) {

        this.country = country;
    }


    public AddressType getAddressType() {

        return addressType;
    }


    public void setAddressType( AddressType addressType ) {

        this.addressType = addressType;
    }
}
