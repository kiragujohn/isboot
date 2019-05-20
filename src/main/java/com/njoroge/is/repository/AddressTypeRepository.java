
package com.njoroge.is.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.njoroge.is.domain.AddressType;

/**
 * @author John Njoroge
 * @date 16/05/2019
 */
public interface AddressTypeRepository extends CrudRepository<AddressType,
        Long> {

    @Query( "SELECT c FROM AddressType c WHERE c.name LIKE '%BUYER%'" )
    List<AddressType> findBuyerAddressTypes();


    @Query( "SELECT c FROM AddressType c WHERE c.name LIKE '%COMPANY%'" )
    List<AddressType> findCompanyAddressTypes();


    @Query( "SELECT c FROM AddressType c WHERE c.name LIKE '%PERSONALY%'" )
    List<AddressType> findPersonalAddressTypes();


    @Query( "SELECT c FROM AddressType c WHERE c.name LIKE '%SELLER%'" )
    List<AddressType> findSellerAddressTypes();

}
