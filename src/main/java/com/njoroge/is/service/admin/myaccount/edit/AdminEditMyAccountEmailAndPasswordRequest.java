
package com.njoroge.is.service.admin.myaccount.edit;

/**
 * @author John Njoroge
 * @date 23/05/2019
 */
public class AdminEditMyAccountEmailAndPasswordRequest {

    private Long userId;
    private String email;
    private String currentPassword;
    private String password;
    private boolean agreeTerms;


    public AdminEditMyAccountEmailAndPasswordRequest( Long userId,
            String email, String currentPassword, String password,
            boolean agreeTerms ) {

        this.userId = userId;
        this.email = email;
        this.currentPassword = currentPassword;
        this.password = password;
        this.agreeTerms = agreeTerms;
    }


    public AdminEditMyAccountEmailAndPasswordRequest() {

        super();
    }


    public Long getUserId() {

        return userId;
    }


    public void setUserId( Long userId ) {

        this.userId = userId;
    }


    public String getEmail() {

        return email;
    }


    public void setEmail( String email ) {

        this.email = email;
    }


    public String getCurrentPassword() {

        return currentPassword;
    }


    public void setCurrentPassword( String currentPassword ) {

        this.currentPassword = currentPassword;
    }


    public String getPassword() {

        return password;
    }


    public void setPassword( String password ) {

        this.password = password;
    }


    public boolean isAgreeTerms() {

        return agreeTerms;
    }


    public void setAgreeTerms( boolean agreeTerms ) {

        this.agreeTerms = agreeTerms;
    }

}
