package com.njoroge.is.helper.address;

import com.njoroge.is.domain.Address;

public interface AddressHelper {

    String COMMA = ",";

    String getAddressOnOneLine( String organisationName, Address address );
}
