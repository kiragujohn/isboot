package com.njoroge.is.helper.loggedincredentials;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.njoroge.is.domain.User;
import com.njoroge.is.repository.UserRepository;

/**
 * @author John Njoroge
 * @date 16/05/2019
 */
@Component
public class LoggedInCredentialsHelperImpl implements
        LoggedInCredentialsHelper {


    @Autowired
    private UserRepository userRepository;

    // @Override
    // public Buyer getLoggedInBuyer( String domain ) {
    //
    // Authentication authentication = SecurityContextHolder.getContext()
    // .getAuthentication();
    //
    // if ( authentication == null ) {
    //
    // return null;
    // }
    //
    // String email = authentication.getName();
    //
    // Organisation organisation = organisationRepository.findByDomain(
    // domain );
    //
    // Buyer buyer = buyerRepository
    // .findByMemberOrganisationIdAndMemberUserEmail( organisation
    // .getId(), email );
    // return buyer;
    // }


    // @Override
    // public String getLoggedInUserDetailsDebug() {
    //
    // return SecurityContextHolder.getContext().getAuthentication()
    // .toString();
    // }


    @Override
    public User getLoggedInUser() {

        String email = SecurityContextHolder.getContext().getAuthentication()
                .getName();

        return userRepository.findByEmail( email );

    }
}
