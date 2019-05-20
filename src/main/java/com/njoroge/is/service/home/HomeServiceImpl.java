
package com.njoroge.is.service.home;

import org.springframework.stereotype.Service;

/**
 * @author John Njoroge
 * @date 16/05/2019
 */
@Service
public class HomeServiceImpl implements HomeService {



    // private OrganisationDetails getOrganisationDetails(
    // Organisation organisation, Set<OrganisationRB> organisationRbs ) {
    //
    // Map<String, OrganisationDetail> organisationDetailsMap =
    // new HashMap<>();
    //
    // String defaultLocale = organisation.getDefaultLocale().getName();
    //
    // OrganisationDetail organisationDetail = new OrganisationDetail(
    // organisation.getName(), organisation.getDescription() );
    //
    // organisationDetailsMap.put( defaultLocale, organisationDetail );
    //
    // for ( OrganisationRB organisationRB : organisationRbs ) {
    //
    // organisationDetail = new OrganisationDetail( organisationRB
    // .getName(), organisationRB.getDescription() );
    //
    // organisationDetailsMap.put( organisationRB.getOrgLocale().getName(),
    // organisationDetail );
    // }
    //
    // OrganisationDetails organisationDetails = new OrganisationDetails(
    // organisationDetailsMap, defaultLocale );
    //
    // return organisationDetails;
    // }


    @Override
    public HomeInitialData getHomeInitialData() {

        // Map<String, String> localeByLocale = new HashMap<>();
        // localeByLocale.put( defaultLocale.getLanguage(), defaultLocale
        // .getLanguage() );
        //
        // for ( OrgLocale orgLocale : otherLocales ) {
        // String aLocale = orgLocale.getName();
        // localeByLocale.put( aLocale, aLocale );
        // }
        //
        // if ( localeByLocale.get( localeStr ) == null ) {
        //
        // locale = defaultLocale;
        // }
        // else {
        // locale = new Locale( localeStr );
        // }
        //
        // OrganisationDetails organisationDetails = getOrganisationDetails(
        // organisation, organisationRbs );
        //
        // ProductCategoryTransfer[] topProductCategorys =
        // getTopProductCategorys(
        // organisation.getId(), locale, defaultLocale );
        //
        // HomeInitialData homeInitialData = new HomeInitialData(
        // organisationDetails, topProductCategorys );
        //
        // return homeInitialData;
        return null;
    }
}
