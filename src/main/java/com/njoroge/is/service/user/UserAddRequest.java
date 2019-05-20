
package com.njoroge.is.service.user;

/**
 * @author John Njoroge
 * @date 16/05/2019
 */
public class UserAddRequest {

    private Long organisationId;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private Long[] roleIds;


    public UserAddRequest( Long organisationId, String firstName,
            String lastName, String email, String password, Long[] roleIds ) {

        this.organisationId = organisationId;
        this.firstname = firstName;
        this.lastname = lastName;
        this.email = email;
        this.password = password;
        this.roleIds = roleIds;
    }


    public UserAddRequest() {

        super();
    }


    public Long getOrganisationId() {

        return organisationId;
    }


    public void setOrganisationId( Long organisationId ) {

        this.organisationId = organisationId;
    }


    public String getFirstname() {

        return firstname;
    }


    public void setFirstname( String firstname ) {

        this.firstname = firstname;
    }


    public String getLastname() {

        return lastname;
    }


    public void setLastname( String lastname ) {

        this.lastname = lastname;
    }


    public String getEmail() {

        return email;
    }


    public void setEmail( String email ) {

        this.email = email;
    }


    public String getPassword() {

        return password;
    }


    public void setPassword( String password ) {

        this.password = password;
    }


    public Long[] getRoleIds() {

        return roleIds;
    }


    public void setRoleIds( Long[] roleIds ) {

        this.roleIds = roleIds;
    }

}
