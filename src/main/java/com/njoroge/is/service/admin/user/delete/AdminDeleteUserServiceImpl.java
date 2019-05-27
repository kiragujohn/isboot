
package com.njoroge.is.service.admin.user.delete;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.njoroge.is.domain.Account;
import com.njoroge.is.domain.User;
import com.njoroge.is.repository.AccountRepository;
import com.njoroge.is.repository.UserRepository;

@Service
public class AdminDeleteUserServiceImpl implements AdminDeleteUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public UserDeleteResponse deleteUser( Long userId ) {

        UserDeleteResponse userDeleteResponse;

        User user = userRepository.findOne( userId );

        Account[] accounts = accountRepository.findByUser( user );

        List<Account> activeAccounts = new ArrayList<Account>();

        if(accounts.length > 0) {

            for ( Account account : accounts ) {

                if ( account.getActive() ) {
                    activeAccounts.add(account);
                }
            }

            if(activeAccounts.isEmpty())
                userRepository.delete( user );

            userDeleteResponse = new UserDeleteResponse( Boolean.TRUE,
                    null );

            }else {

            userDeleteResponse = new UserDeleteResponse( Boolean.FALSE,
                    "Delete failed because this User already has an active account" );
            }
        return userDeleteResponse;
    }
}
