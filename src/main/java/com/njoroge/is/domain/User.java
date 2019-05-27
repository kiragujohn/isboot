
package com.njoroge.is.domain;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author John Njoroge
 * @date 16/05/2019
 */
@Entity
@Table( name = "app_user" )
public class User extends AbstractPersistentEntity {

    private static final long serialVersionUID = -4851568116424920501L;

    @Column( name = "email", nullable = false, unique = true, length = 255 )
    private String email;

    @Column( name = "password", nullable = false, unique = false, length = 256 )
    @JsonIgnore
    private String password;

    @Column( name = "first_name", nullable = false, unique = false,
            length = 60 )
    private String firstName;

    @Column( name = "last_name", nullable = false, unique = false, length = 60 )
    private String lastName;

    @Column( name = "phone", nullable = false )
    private String phone;

    @Column( name = "is_admin", nullable = true )
    private Boolean isAdmin;

    @Temporal( TemporalType.TIMESTAMP )
    @Column( name = "created_date", updatable = true, nullable = false,
            columnDefinition = "TIMESTAMP WITH TIME ZONE" )
    private Calendar createdDate;

    @ManyToMany( fetch = FetchType.EAGER )
    @JoinTable( name = "user_role", joinColumns = @JoinColumn( name = "fk_user",
            referencedColumnName = "id" ), inverseJoinColumns = @JoinColumn(
                    name = "fk_role", referencedColumnName = "id" ) )
    private Set<Role> roles = new HashSet<Role>();

    @OneToMany( mappedBy = "user", fetch = FetchType.EAGER )
    private Set<Address> addresses;

    @OneToMany( mappedBy = "user", fetch = FetchType.EAGER )
    private Set<Account> accounts;


    public Boolean getIsAdmin() {

        return isAdmin;
    }


    public void setIsAdmin( Boolean isAdmin ) {

        this.isAdmin = isAdmin;
    }


    public Set<Account> getAccounts() {

        return accounts;
    }


    public void setAccounts( Set<Account> accounts ) {

        this.accounts = accounts;
    }


    public String getPhone() {

        return phone;
    }


    public void setPhone( String phone ) {

        this.phone = phone;
    }


    public Set<Role> getRoles() {

        return roles;
    }


    public void setRoles( Set<Role> roles ) {

        this.roles = roles;
    }


    public Set<Address> getAddresses() {

        return addresses;
    }


    public void setAddresses( Set<Address> addresses ) {

        this.addresses = addresses;
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


    public Calendar getCreatedDate() {

        return createdDate;
    }


    public void setCreatedDate( Calendar createdDate ) {

        this.createdDate = createdDate;
    }


    @Override
    public int hashCode() {

        return super.hashCode();
    }


    @Override
    public boolean equals( Object obj ) {

        return super.equals( obj );
    }

}
