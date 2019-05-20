
package com.njoroge.is.exception.handling;

import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.njoroge.is.controller.ControllerRuntimeException;

/**
 * @author John Njoroge
 * @date 16/05/2019
 */
@ControllerAdvice
@RestController
public class RestResponseEntityExceptionHandler extends
        ResponseEntityExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(
            RestResponseEntityExceptionHandler.class );

    // http://www.baeldung.com/exception-handling-for-rest-with-spring
    @ExceptionHandler( value = { Exception.class } )
    protected ResponseEntity<Object> handleConflict( Exception ex,
            WebRequest request ) {

        ControllerRuntimeException cre = new ControllerRuntimeException( ex );
        logger.error( "*********************** ERROR", cre );

        ErrorDetails errorDetails = null;

        if ( ex instanceof AccessDeniedException ) {
            errorDetails = new ErrorDetails( null, cre.getCause().getMessage(),
                    Calendar.getInstance() );
        }
        else {
            errorDetails = new ErrorDetails( cre.getMessage(), cre.getCause()
                    .getClass().getName(), Calendar.getInstance() );
        }

        return handleExceptionInternal( cre, errorDetails, new HttpHeaders(),
                HttpStatus.INTERNAL_SERVER_ERROR, request );
    }
}
