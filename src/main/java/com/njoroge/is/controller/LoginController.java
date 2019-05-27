
package com.njoroge.is.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.njoroge.is.service.login.LoginInitialData;
import com.njoroge.is.service.login.LoginServiceImpl;

/**
 * @author John Njoroge
 * @date 16/05/2019
 */
@RestController
@RequestMapping( "/is/login" )

public class LoginController {

    @Autowired
    private LoginServiceImpl loginService;


    @RequestMapping( value = "/getinitialdata", method = RequestMethod.POST )
    public ResponseEntity<LoginInitialData> getLoginInitialData(
            @RequestBody String email ) {

        LoginInitialData loginInitialData = loginService.getLoginInitialData(
                email );

        return ResponseEntity.status( HttpStatus.OK ).body( loginInitialData );
    }
}
