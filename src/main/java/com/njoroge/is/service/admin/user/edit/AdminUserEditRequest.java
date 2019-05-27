
package com.njoroge.is.service.admin.user.edit;

/**
 * @author John Njoroge
 * @date 23/05/2019
 */
public class AdminUserEditRequest {

    private Long userId;
    private String name;
    private String email;
    private String phone;
    private String firstName;
    private String lastName;
    private String password;
    private String firstLine;
    private String secondLine;
    private String thirdLine;
    private String fourthLine;
    private String townOrCity;
    private String postCode;
    private Boolean isAdmin;
    private Long addressTypeId;
    private Long countryId;


    public AdminUserEditRequest( Long userId,
            String name, String email,
            String phone, String firstName, String lastName, String password,
            String firstLine,
            String secondLine, String thirdLine, String fourthLine,
            String townOrCity, String postCode, Boolean isAdmin,
            Long addressTypeId, Long countryId ) {

        this.userId = userId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.firstLine = firstLine;
        this.secondLine = secondLine;
        this.thirdLine = thirdLine;
        this.fourthLine = fourthLine;
        this.townOrCity = townOrCity;
        this.postCode = postCode;
        this.isAdmin = isAdmin;
        this.addressTypeId = addressTypeId;
        this.countryId = countryId;
    }


    public AdminUserEditRequest() {

        super();
    }


    public Long getUserId() {

        return userId;
    }


    public void setUserId( Long userId ) {

        this.userId = userId;
    }



    public String getName() {

        return name;
    }



    public void setName( String name ) {

        this.name = name;
    }



    public String getEmail() {

        return email;
    }



    public void setEmail( String email ) {

        this.email = email;
    }



    public String getPhone() {

        return phone;
    }



    public void setPhone( String phone ) {

        this.phone = phone;
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


    public Boolean getIsAdmin() {

        return isAdmin;
    }


    public void setIsAdmin( Boolean isAdmin ) {

        this.isAdmin = isAdmin;
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

}
