
package com.njoroge.is.service.role;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.njoroge.is.domain.Role;
import com.njoroge.is.domain.User;
import com.njoroge.is.repository.RoleRepository;
import com.njoroge.is.repository.UserRepository;

/**
 * @author John Njoroge
 * @date 16/05/2019
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    public Role[] findRolesByRoleIds( Long[] roleIds ) {

        return roleRepository.findByIdIn( roleIds );
    }


    @Override
    public RoleTransfer[] getRoleTransfers( Iterable<Role> roles ) {

        RoleTransfer roleTransfer;

        Set<RoleTransfer> roleTransfers = new TreeSet<>( new Comparator<
                RoleTransfer>() {

            @Override
            public int compare( RoleTransfer roleTransfer,
                    RoleTransfer otherRoleTransfer ) {

                return roleTransfer.getRoleName().compareTo( otherRoleTransfer
                        .getRoleName() );
            }
        } );

        for ( Role role : roles ) {

            roleTransfer = new RoleTransfer( role.getId(), role.getRoleName() );
            roleTransfers.add( roleTransfer );
        }

        return roleTransfers.toArray( new RoleTransfer[roleTransfers.size()] );
    }


    @Override
    public RoleTransfer[] getAllRoleTransfers() {

        Iterable<Role> roles = roleRepository.findAll();
        return getRoleTransfers( roles );
    }


    @Override
    public Role[] getRolesByUserEmail( String email ) {

        Set<Role> roles = null;

        User user = userRepository.findByEmail( email );

        if ( user != null ) {
            roles = user.getRoles();
            return roles.toArray( new Role[roles.size()] );
        }

        return null;
    }
}
