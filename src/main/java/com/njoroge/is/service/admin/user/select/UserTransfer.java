
package com.njoroge.is.service.admin.user.select;

/**
 * @author John Njoroge
 * @date 23/05/2019
 */
public class UserTransfer {

    private Long id;
    private String name;
    private String email;


    public UserTransfer() {

        super();
    }


    public UserTransfer( Long id, String name, String email ) {

        this.id = id;
        this.name = name;
        this.email = email;
    }


    public Long getId() {

        return id;
    }


    public void setId( Long id ) {

        this.id = id;
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

}
