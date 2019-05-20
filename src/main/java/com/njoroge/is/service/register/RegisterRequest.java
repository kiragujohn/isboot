
package com.njoroge.is.service.register;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author John Njoroge
 * @date 16/05/2019
 */
public class RegisterRequest {

    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String phone;
    private String contactName;
    private String contactPhone;
    private String firstLine;
    private String secondLine;
    private String thirdLine;
    private String fourthLine;
    private String townOrCity;
    private String postCode;
    private Long addressTypeId;
    private Long countryId;
    private Boolean buyerActive;
    private MultipartFile buyerLogo;


    public RegisterRequest( String email, String firstName,
            String lastName, String password, String phone, String contactName,
            String contactPhone, String firstLine, String secondLine,
            String thirdLine, String fourthLine, String townOrCity,
            String postCode, Long addressTypeId, Long countryId,
            Boolean buyerActive, MultipartFile buyerLogo ) {

        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.phone = phone;
        this.contactName = contactName;
        this.contactPhone = contactPhone;
        this.firstLine = firstLine;
        this.secondLine = secondLine;
        this.thirdLine = thirdLine;
        this.fourthLine = fourthLine;
        this.townOrCity = townOrCity;
        this.postCode = postCode;
        this.addressTypeId = addressTypeId;
        this.countryId = countryId;
        this.buyerActive = buyerActive;
        this.buyerLogo = buyerLogo;
    }


    public RegisterRequest() {

        super();
    }


    public String getEmail() {

        return email;
    }


    public void setEmail( String email ) {

        this.email = email;
    }


    public String getFirstName() {

        return firstName;
    }


    public void setFirstName( String firstName ) {

        this.firstName = firstName;
    }


    public String getLastName() {

        return lastName;
    }


    public void setLastName( String lastName ) {

        this.lastName = lastName;
    }


    public String getPassword() {

        return password;
    }


    public void setPassword( String password ) {

        this.password = password;
    }


    public String getPhone() {

        return phone;
    }


    public void setPhone( String phone ) {

        this.phone = phone;
    }


    public String getContactName() {

        return contactName;
    }


    public void setContactName( String contactName ) {

        this.contactName = contactName;
    }


    public String getContactPhone() {

        return contactPhone;
    }


    public void setContactPhone( String contactPhone ) {

        this.contactPhone = contactPhone;
    }


    public void setBuyerActive( Boolean buyerActive ) {

        this.buyerActive = buyerActive;
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


    public Boolean getBuyerActive() {

        return buyerActive;
    }


    public void setMemberActive( Boolean buyerActive ) {

        this.buyerActive = buyerActive;
    }


    public MultipartFile getBuyerLogo() {

        return buyerLogo;
    }


    public void setBuyerLogo( MultipartFile buyerLogo ) {

        this.buyerLogo = buyerLogo;
    }
}
