
package com.njoroge.is.controller;

import java.util.Random;

/**
 * @author John Njoroge
 * @date 16/05/2019
 */
public class ControllerRuntimeException extends RuntimeException {

    private static final long serialVersionUID = 5935351760077149664L;

    private static Random random = new Random();
    private static String ERROR_ID = "Error ID: ";


    public ControllerRuntimeException() {

        super( ERROR_ID + random.nextLong() );
    }


    public ControllerRuntimeException( String message ) {

        super( ERROR_ID + random.nextLong() + ", " + message );
    }


    public ControllerRuntimeException( Throwable cause ) {

        super( ERROR_ID + random.nextLong(), cause );
    }


    public ControllerRuntimeException( String message, Throwable cause ) {

        super( ERROR_ID + random.nextLong() + ", " + message, cause );
    }


    public ControllerRuntimeException( String message, Throwable cause,
            boolean enableSuppression, boolean writableStackTrace ) {

        super( ERROR_ID + random.nextLong() + ", " + message, cause,
                enableSuppression, writableStackTrace );
    }
}
