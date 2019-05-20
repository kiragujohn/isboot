
package com.njoroge.is.repository;

import org.springframework.data.repository.CrudRepository;

import com.njoroge.is.domain.User;

/**
 * @author John Njoroge
 * @date 16/05/2019
 */
public interface UserRepository extends CrudRepository<User, Long> {

    User findByEmail( String email );

}
