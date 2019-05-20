
package com.njoroge.is.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.njoroge.is.service.home.HomeInitialData;
import com.njoroge.is.service.home.HomeService;

/**
 * @author John Njoroge
 * @date 16/05/2019
 */
@RestController
@RequestMapping( "/trade43/home" )
public class HomeController {

    private Logger logger = LoggerFactory.getLogger( HomeController.class );

    @Autowired
    private HomeService homeService;


    @RequestMapping( value = "/getinitialdata", method = RequestMethod.POST )
    public ResponseEntity<HomeInitialData> getHomeInitialData(
            @RequestBody String localeStr ) {


        HomeInitialData homeInitialData = homeService.getHomeInitialData();

        return ResponseEntity.status( HttpStatus.OK ).body( homeInitialData );
    }


    // @RequestMapping( value = "/viewtimeslot/loggedin/getinitialdata",
    // method = RequestMethod.POST )
    // public ResponseEntity<ViewTimeSlotInitialData>
    // getViewTimeSlotInitialDataLoggedIn(
    // @RequestBody ViewTimeSlotInitialDataRequest request ) {
    //
    // return getViewTimeSlotInitialDataInternal( request );
    // }

}
