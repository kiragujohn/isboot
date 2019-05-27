
package com.njoroge.is.service.admin.user.edit;

/**
 * @author John Njoroge
 * @date 23/05/2019
 */
public class UserTransfer {

    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private AddressTransfer[] addresses;
    private AccountTransfer[] accounts;


    public UserTransfer() {

        super();
    }


    public UserTransfer( Long id, String email, String firstName,
            String lastName, String phone,
            AddressTransfer[] addresses, AccountTransfer[] accounts ) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.addresses = addresses;
        this.accounts = accounts;
    }


    public Long getId() {

        return id;
    }


    public void setId( Long id ) {

        this.id = id;
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


    public String getPhone() {

        return phone;
    }


    public void setPhone( String phone ) {

        this.phone = phone;
    }



    public AddressTransfer[] getAddresses() {

        return addresses;
    }


    public void setAddresses( AddressTransfer[] addresses ) {

        this.addresses = addresses;
    }


    public AccountTransfer[] getAccounts() {

        return accounts;
    }


    public void setAccounts( AccountTransfer[] accounts ) {

        this.accounts = accounts;
    }
}
