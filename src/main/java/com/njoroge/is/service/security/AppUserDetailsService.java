
package com.njoroge.is.service.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.njoroge.is.domain.Role;
import com.njoroge.is.domain.User;
import com.njoroge.is.repository.RoleRepository;
import com.njoroge.is.repository.UserRepository;
import com.njoroge.is.service.role.RoleService;

/**
 * @author John Njoroge
 * @date 16/05/2019
 */
@Component
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleService roleService;

    @Override
    public UserDetails loadUserByUsername( String email )
            throws UsernameNotFoundException {

        String emailToLower = email.toLowerCase();

        User user = userRepository.findByEmail( emailToLower );

        if ( user == null ) {
            throw new UsernameNotFoundException( String.format(
                    "The username %s doesn't exist", emailToLower ) );
        }

        Role[] roles = roleService.getRolesByUserEmail( emailToLower );

                if ( roles == null ) {
                    throw new RuntimeException( String.format(
                            "The username %s has no roles attached"
                                    + " to it for the following domain %s",
                    emailToLower ) );
                }


        List<GrantedAuthority> authorities = new ArrayList<>();

        for ( Role role : roles ) {

            authorities.add( new SimpleGrantedAuthority( role.getRoleName() ) );

        }

        UserDetails userDetails =
                new org.springframework.security.core.userdetails.User(
                        emailToLower, user.getPassword(), authorities );


        return userDetails;
    }
}
