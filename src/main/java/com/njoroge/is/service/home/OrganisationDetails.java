
package com.njoroge.is.service.home;

import java.util.Map;

/**
 * @author John Njoroge
 * @date 16/05/2019
 */
public class OrganisationDetails {

    private Map<String, OrganisationDetail> organisationDetailsByLocale;
    public String defaultLocale;


    public OrganisationDetails( Map<String,
            OrganisationDetail> organisationDetailsByLocale,
            String defaultLocale ) {

        this.organisationDetailsByLocale = organisationDetailsByLocale;
        this.defaultLocale = defaultLocale;
    }


    public OrganisationDetails() {

        super();
    }


    public Map<String, OrganisationDetail> getOrganisationDetailsByLocale() {

        return organisationDetailsByLocale;
    }


    public void setOrganisationDetailsByLocale( Map<String,
            OrganisationDetail> organisationDetailsByLocale,
            String defaultLocale ) {

        this.organisationDetailsByLocale = organisationDetailsByLocale;
    }


    public String getDefaultLocale() {

        return defaultLocale;
    }


    public void setDefaultLocale( String defaultLocale ) {

        this.defaultLocale = defaultLocale;
    }
}
