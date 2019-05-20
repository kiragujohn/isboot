
package com.njoroge.is.helper.address;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.njoroge.is.domain.Address;

/**
 * @author John Njoroge
 * @date 16/05/2019
 */
@Component
public class AddressHelperImpl implements AddressHelper {

    private boolean isEmpty( String string ) {

        if ( string == null ) {
            return true;
        }
        else if ( string.trim().equals( "" ) ) {
            return true;
        }

        return false;
    }


    private List<String> getAddressComponents( String organisationName, Address address ) {

        List<String> addressComponents = new ArrayList<>();
        addressComponents.add( organisationName );
        addressComponents.add( address.getFirstLine() );

        String secondLine = address.getSecondLine();
        String thirdLine = address.getThirdLine();
        String fourthLine = address.getFourthLine();
        String postCode = address.getPostCode();
        String townOrCity =  address.getTownOrCity();


        if ( !isEmpty( secondLine ) ) {

            addressComponents.add( secondLine );
        }

        if ( !isEmpty( thirdLine ) ) {

            addressComponents.add( thirdLine );
        }

        if ( !isEmpty( fourthLine ) ) {

            addressComponents.add( fourthLine );
        }

        if ( !isEmpty( postCode ) ) {

            addressComponents.add( postCode );
        }

        if ( !isEmpty( townOrCity ) ) {

            addressComponents.add( townOrCity );
        }

        return addressComponents;
    }


    public AddressHelperImpl() {

    }


    @Override
    public String getAddressOnOneLine( String organisationName,
            Address address ) {

        List<String> addressComponents = getAddressComponents( organisationName,
                address );

        Iterator<String> addressComponentIterator = addressComponents
                .iterator();

        StringBuilder sb = new StringBuilder();

        while ( addressComponentIterator.hasNext() ) {

            sb.append( addressComponentIterator.next() );

            if ( addressComponentIterator.hasNext() ) {

                sb.append( ", " );
            }
        }

        return sb.toString();
    }
}
