
package com.njoroge.is.exception.handling;

import java.util.Calendar;

/**
 * @author John Njoroge
 * @date 16/05/2019
 */

public class ErrorDetails {

    private String errorId;
    private String message;
    private Calendar timestamp;


    public ErrorDetails( String errorId, String message, Calendar timestamp ) {

        super();
        this.errorId = errorId;
        this.message = message;
        this.timestamp = timestamp;
    }


    public String getMessage() {

        return message;
    }


    public void setMessage( String message ) {

        this.message = message;
    }


    public String getErrorId() {

        return errorId;
    }


    public void setErrorId( String errorId ) {

        this.errorId = errorId;
    }


    public Calendar getTimestamp() {

        return timestamp;
    }


    public void setTimestamp( Calendar timestamp ) {

        this.timestamp = timestamp;
    }

}
