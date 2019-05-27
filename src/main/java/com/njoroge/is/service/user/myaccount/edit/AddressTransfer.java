
package com.njoroge.is.service.user.myaccount.edit;

/**
 * @author John Njoroge
 * @date 23/05/2019
 */
public class AddressTransfer {

    private String firstLine;
    private String secondLine;
    private String thirdLine;
    private String fourthLine;
    private String townOrCity;
    private String postCode;
    private Long addressTypeId;
    private Long countryId;
    private String country;


    public AddressTransfer() {

    }


    public AddressTransfer( String firstLine, String secondLine,
            String thirdLine, String fourthLine, String townOrCity,
            String postCode, Long addressTypeId, Long countryId,
            String country ) {

        this.firstLine = firstLine;
        this.secondLine = secondLine;
        this.thirdLine = thirdLine;
        this.fourthLine = fourthLine;
        this.townOrCity = townOrCity;
        this.postCode = postCode;
        this.addressTypeId = addressTypeId;
        this.countryId = countryId;
        this.country = country;
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


    public Long getAddressTypeId() {

        return addressTypeId;
    }


    public void setAddressTypeId( Long addressTypeId ) {

        this.addressTypeId = addressTypeId;
    }


    public Long getCountryId() {

        return countryId;
    }


    public void setCountryId( Long countryId ) {

        this.countryId = countryId;
    }


    public String getCountry() {

        return country;
    }


    public void setCountry( String country ) {

        this.country = country;
    }

}