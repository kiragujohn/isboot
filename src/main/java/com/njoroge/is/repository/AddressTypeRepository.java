
package com.njoroge.is.repository;

import org.springframework.data.repository.CrudRepository;

import com.njoroge.is.domain.AddressType;

/**
 * @author John Njoroge
 * @date 16/05/2019
 */
public interface AddressTypeRepository extends CrudRepository<AddressType,
        Long> {

}
