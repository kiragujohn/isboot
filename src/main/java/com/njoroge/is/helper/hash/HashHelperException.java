
package com.njoroge.is.helper.hash;

/**
 * @author John Njoroge
 * @date 16/05/2019
 */
public class HashHelperException extends Exception {

    private static final long serialVersionUID = 2967126709577356402L;


    public HashHelperException() {

        super();
    }


    public HashHelperException( String message ) {

        super( message );
    }


    public HashHelperException( Throwable cause ) {

        super( cause );
    }


    public HashHelperException( String message, Throwable cause ) {

        super( message, cause );
    }


    public HashHelperException( String message, Throwable cause,
            boolean enableSuppression, boolean writableStackTrace ) {

        super( message, cause, enableSuppression, writableStackTrace );
    }
}
