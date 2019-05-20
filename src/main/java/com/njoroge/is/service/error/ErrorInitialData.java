
package com.njoroge.is.service.error;

/**
 * @author John Njoroge
 * @date 16/05/2019
 */
public class ErrorInitialData {

    private OrganisationDetails organisationDetails;


    public ErrorInitialData(
            OrganisationDetails organisationDetails ) {

        this.organisationDetails = organisationDetails;
    }


    public ErrorInitialData() {

        super();
    }


    public OrganisationDetails getOrganisationDetails() {

        return organisationDetails;
    }


    public void setOrganisationDetails(
            OrganisationDetails organisationDetails ) {

        this.organisationDetails = organisationDetails;
    }
}
