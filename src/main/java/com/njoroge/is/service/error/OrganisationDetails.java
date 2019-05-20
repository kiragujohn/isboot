
package com.njoroge.is.service.error;

/**
 * @author John Njoroge
 * @date 16/05/2019
 */
public class OrganisationDetails {

    private String infoEmail;


    public OrganisationDetails( String infoEmail ) {

        this.infoEmail = infoEmail;
    }


    public OrganisationDetails() {

        super();
    }


    public String getInfoEmail() {

        return infoEmail;
    }


    public void setInfoEmail( String infoEmail ) {

        this.infoEmail = infoEmail;
    }

}
