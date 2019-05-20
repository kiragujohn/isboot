
package com.njoroge.is.service.home;

/**
 * @author John Njoroge
 * @date 16/05/2019
 */
public class OrganisationDetail {

    private String name;
    private String description;


    public OrganisationDetail( String name, String description ) {

        this.name = name;
        this.description = description;
    }


    public String getName() {

        return name;
    }


    public void setName( String name ) {

        this.name = name;
    }


    public String getDescription() {

        return description;
    }


    public void setDescription( String description ) {

        this.description = description;
    }

}
