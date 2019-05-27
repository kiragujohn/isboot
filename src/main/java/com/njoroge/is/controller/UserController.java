
package com.njoroge.is.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author John Njoroge
 * @date 16/05/2019
 */
@RestController
@RequestMapping( "/is/user" )
public class UserController {

    public Logger logger = LoggerFactory.getLogger( UserController.class );

}
