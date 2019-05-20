
package com.njoroge.is;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * @author John Njoroge
 * @date 16/05/2019
 */
@EntityScan( "com.njoroge.is.domain" )
@SpringBootApplication
public class StartTradeBoot {

    public static void main( String[] args ) {

        Locale.setDefault( Locale.ENGLISH );
        SpringApplication.run( StartTradeBoot.class, args );
    }
}
