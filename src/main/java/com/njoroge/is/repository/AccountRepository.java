
package com.njoroge.is.repository;

import org.springframework.data.repository.CrudRepository;

import com.njoroge.is.domain.Account;

/**
 * @author John Njoroge
 * @date 16/05/2019
 */
public interface AccountRepository extends CrudRepository<Account, Long> {

}
