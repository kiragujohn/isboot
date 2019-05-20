
package com.njoroge.is.service.error;

import org.springframework.stereotype.Service;

/**
 * @author John Njoroge
 * @date 16/05/2019
 */
@Service
public class ErrorServiceImpl implements ErrorService {

    @Override
    public ErrorInitialData getErrorInitialData( String domain ) {
        OrganisationDetails organisationDetails = new OrganisationDetails();

        ErrorInitialData errorInitialData = new ErrorInitialData(
                organisationDetails );

        return errorInitialData;
    }
}
