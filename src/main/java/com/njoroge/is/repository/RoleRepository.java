
package com.njoroge.is.repository;

import org.springframework.data.repository.CrudRepository;

import com.njoroge.is.domain.Role;

/**
 * @author John Njoroge
 * @date 16/05/2019
 */
public interface RoleRepository extends CrudRepository<Role, Long> {

    Role[] findByIdIn( Long[] roleIds );


    Role findByRoleName( String roleName );
}
