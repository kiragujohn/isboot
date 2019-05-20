
package com.njoroge.is.service.role;

import com.njoroge.is.domain.Role;

/**
 * @author John Njoroge
 * @date 16/05/2019
 */
public interface RoleService {

    Role[] findRolesByRoleIds( Long[] roleIds );


    RoleTransfer[] getAllRoleTransfers();


    RoleTransfer[] getRoleTransfers( Iterable<Role> roles );


    Role[] getRolesByUserEmail( String email );
}
