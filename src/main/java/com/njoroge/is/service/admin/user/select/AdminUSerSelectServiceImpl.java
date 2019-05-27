
package com.njoroge.is.service.admin.user.select;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.njoroge.is.domain.User;
import com.njoroge.is.repository.UserRepository;


@Service
public class AdminUSerSelectServiceImpl implements AdminUSerSelectService {

    @Autowired
    private UserRepository userRepository;


    private UserTransfer createUserTransfer( User user ) {

        String name = user.getFirstName() + ", " + user.getLastName();

        UserTransfer userTransfer = new UserTransfer( user.getId(), name, user
                .getEmail() );

        return userTransfer;
    }


    @Override
    public AdminUserSelectInitialData getInitialData() {

        AdminUserSelectInitialData initialData =
                new AdminUserSelectInitialData();

        Iterable<User> users = userRepository.findAll();

        List<UserTransfer> userTransferList = new ArrayList<>();

        for ( User user : users ) {

            userTransferList.add( createUserTransfer( user ) );
        }

        UserTransfer[] userTransfers = userTransferList.toArray(
                new UserTransfer[userTransferList.size()] );

        initialData.setUsers( userTransfers );

        return initialData;
    }
}
