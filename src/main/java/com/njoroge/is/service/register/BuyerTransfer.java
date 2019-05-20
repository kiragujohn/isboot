
package com.njoroge.is.service.register;

/**
 * @author John Njoroge
 * @date 16/05/2019
 */
public class BuyerTransfer {

    private Long id;
    private String name;
    private Boolean status;


    public BuyerTransfer() {

        super();
    }


    public BuyerTransfer( Long id, String name, Boolean status ) {

        this.id = id;
        this.name = name;
        this.status = status;
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


    public Boolean getStatus() {

        return status;
    }


    public void setStatus( Boolean status ) {

        this.status = status;
    }
}
