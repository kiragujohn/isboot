
package com.njoroge.is.service.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.njoroge.is.domain.User;
import com.njoroge.is.repository.UserRepository;

/**
 * @author John Njoroge
 * @date 16/05/2019
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public LoginInitialData getLoginInitialData( String email ) {

        User user = userRepository.findByEmail( email.toLowerCase() );

        return new LoginInitialData( user.getId(), user.getFirstName() );
    }

}
