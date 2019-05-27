
package com.njoroge.is.service.admin.user.edit;

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
    private String addressType;
    private String country;


    public AddressTransfer() {

    }


    public AddressTransfer( String firstLine, String secondLine,
            String thirdLine, String fourthLine, String townOrCity,
            String postCode, String addressType, String country ) {

        this.firstLine = firstLine;
        this.secondLine = secondLine;
        this.thirdLine = thirdLine;
        this.fourthLine = fourthLine;
        this.townOrCity = townOrCity;
        this.postCode = postCode;
        this.addressType = addressType;
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


    public String getCountry() {

        return country;
    }


    public void setCountry( String country ) {

        this.country = country;
    }


    public String getAddressType() {

        return addressType;
    }


    public void setAddressType( String addressType ) {

        this.addressType = addressType;
    }


}