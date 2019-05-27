
package com.njoroge.is.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.njoroge.is.service.admin.user.edit.AdminUserEditInitialData;
import com.njoroge.is.service.admin.user.edit.AdminUserEditService;
import com.njoroge.is.service.admin.user.select.AdminUSerSelectService;
import com.njoroge.is.service.admin.user.select.AdminUserSelectInitialData;

/**
 * @author John Njoroge
 * @date 16/05/2019
 */
@RestController
@RequestMapping( "/is/admin" )
public class AdminController {

    public Logger logger = LoggerFactory.getLogger( AdminController.class );

    @Autowired
    private AdminUSerSelectService adminUSerSelectService;

    @Autowired
    private AdminUserEditService adminUserEditService;

    @RequestMapping( value = "/user/select/getinitialdata",
            method = RequestMethod.POST )
    @PreAuthorize( "hasAuthority('ADMIN')" )
    public ResponseEntity<AdminUserSelectInitialData>
            getAdminUsersInitialData() {

        AdminUserSelectInitialData adminUserSelectInitialData =
                adminUSerSelectService.getInitialData();

        return ResponseEntity.status( HttpStatus.OK ).body(
                adminUserSelectInitialData );
    }


    @RequestMapping( value = "/user/edit/getinitialdata",
            method = RequestMethod.POST )
    @PreAuthorize( "hasAuthority('ADMIN')" )
    public ResponseEntity<AdminUserEditInitialData>
            getAdminUserEditInitialData( @RequestBody Long userId ) {

        AdminUserEditInitialData adminUserEditInitialData =
                adminUserEditService.getEditMyAccountInitialData( userId );

        return ResponseEntity.status( HttpStatus.OK ).body(
                adminUserEditInitialData );
    }

}
