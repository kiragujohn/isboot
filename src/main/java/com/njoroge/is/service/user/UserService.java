
package com.njoroge.is.service.user;

import java.util.List;

import com.njoroge.is.domain.User;

/**
 * @author John Njoroge
 * @date 16/05/2019
 */
public interface UserService {

    List<User> getAllUsers();

    String getEmailAddressById( Long userId );


    Boolean doesUserExist( Long userId );


    User getById( Long userId );
}
