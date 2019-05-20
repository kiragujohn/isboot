
package com.njoroge.is.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.njoroge.is.domain.User;
import com.njoroge.is.helper.hash.HashHelper;
import com.njoroge.is.repository.UserRepository;

/**
 * @author John Njoroge
 * @date 16/05/2019
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HashHelper hashHelper;

    @Override
    public List<User> getAllUsers() {

        return ( List<User> ) userRepository.findAll();
    }


    public String getPasswordHashWithBcrypt( String password ) {

        return hashHelper.getPasswordHashWithBcrypt( password );
    }


    @Override
    public String getEmailAddressById( Long UserID ) {

        return userRepository.findOne( UserID ).getEmail();
    }


    @Override
    public Boolean doesUserExist( Long userId ) {

        return userRepository.exists( userId );
    }


    @Override
    public User getById( Long userId ) {

        return userRepository.findOne( userId );
    }
}
