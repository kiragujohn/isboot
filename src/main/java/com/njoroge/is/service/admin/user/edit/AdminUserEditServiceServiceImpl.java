
package com.njoroge.is.service.admin.user.edit;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.njoroge.is.domain.Account;
import com.njoroge.is.domain.Address;
import com.njoroge.is.domain.User;
import com.njoroge.is.helper.malicious.Malicious;
import com.njoroge.is.repository.UserRepository;
import com.njoroge.is.service.shared.SaveResponse;

/**
 * @author John Njoroge
 * @date 23/05/2019
 */
@Service
public class AdminUserEditServiceServiceImpl implements
        AdminUserEditService {

    @Autowired
    private UserRepository userRepository;

    private UserTransfer createUserTransfer( User user ) {

        UserTransfer userTransfer = new UserTransfer();
        userTransfer.setFirstName( user.getFirstName() );
        userTransfer.setLastName( user.getLastName() );
        userTransfer.setId( user.getId() );
        userTransfer.setEmail( user.getEmail() );
        userTransfer.setPhone( user.getPhone() );
        userTransfer.setAddresses( getAddressTransfer( user ) );
        userTransfer.setAccounts( getAccounts( user ) );
        return userTransfer;
    }


    private AccountTransfer[] getAccounts( User user ) {

        Set<Account> accounts = user.getAccounts();

        List<AccountTransfer> accountTransferList = new ArrayList<>();

        if ( !accounts.isEmpty() ) {

            for ( Account account : accounts ) {

                accountTransferList.add( new AccountTransfer( account.getId(),
                        account.getAccountNumber(), account.getAccountType()
                                .getName(), account.getActive() ) );
            }

        }

        return accountTransferList.toArray(
                new AccountTransfer[accountTransferList
                .size()] );
    }


    private AddressTransfer[] getAddressTransfer( User user ) {

        Set<Address> addresses = user.getAddresses();

        List<AddressTransfer> addressTransferList = new ArrayList<>();

        if ( !addresses.isEmpty() ) {

            for ( Address address : addresses ) {

                addressTransferList.add( new AddressTransfer( address
                        .getFirstLine(), address.getSecondLine(), address
                                .getThirdLine(), address.getFourthLine(),
                        address.getTownOrCity(), address.getPostCode(), address
                                .getAddressType().getName(), address
                                        .getCountry().getName()

                ) );
            }

        }

        return addressTransferList.toArray(
                new AddressTransfer[addressTransferList.size()] );

    }


    private void saveExistingUserPersonalDetails(
            AdminUserEditRequest adminUserEditRequest,
            User user ) {

        user.setFirstName( Malicious.escapeMalicious(
                adminUserEditRequest.getFirstName().trim() ) );

        user.setLastName( Malicious.escapeMalicious(
                adminUserEditRequest.getLastName().trim() ) );

        userRepository.save( user );
    }


    @Override
    public AdminUserEditInitialData getEditMyAccountInitialData(
            Long userId ) {

        AdminUserEditInitialData adminUserEditInitialData =
                new AdminUserEditInitialData();

        User user = userRepository.findOne( userId );

        UserTransfer userTransfer = createUserTransfer( user );

        adminUserEditInitialData.setUser( userTransfer );

        return adminUserEditInitialData;
    }


    @Override
    @Transactional
    public SaveResponse editUserDetails( User user,
            AdminUserEditRequest adminUserEditRequest ) {

        SaveResponse saveUserResponse = null;

        saveExistingUserPersonalDetails( adminUserEditRequest,
                user );

        saveUserResponse = new SaveResponse( Boolean.TRUE, null );

        return saveUserResponse;
    }
}