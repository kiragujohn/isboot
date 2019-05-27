
package com.njoroge.is.service.user.myaccount.edit;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.njoroge.is.domain.User;
import com.njoroge.is.helper.hash.HashHelper;
import com.njoroge.is.helper.malicious.Malicious;
import com.njoroge.is.repository.UserRepository;
import com.njoroge.is.service.shared.SaveResponse;

/**
 * @author John Njoroge
 * @date 23/05/2019
 */
@Service
public class UserEditMyAccountServiceImpl implements
        UserEditMyAccountService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HashHelper hashHelper;


    private String getPasswordHashWithBcrypt( String password ) {

        return hashHelper.getPasswordHashWithBcrypt( password );
    }


    /**
     * Checks if the email changed. If it did change, checks if another user
     * already has that email.
     *
     * @param user
     *            User we are trying to update.
     *
     * @param newEmail
     *            new email
     *
     * @return true if email has changed and another user already has that email
     */
    private boolean myEmailHasChangedButItIsAlreadyInTheDB( User user,
            String newEmail ) {

        if ( !user.getEmail().equals( newEmail ) ) {

            User usersWithSameEmail = userRepository.findByEmail( newEmail );

            if ( usersWithSameEmail != null ) {
                return true;
            }
        }

        return false;
    }


    private SaveResponse
            createErrorMessageThatEmailHasChangedButItisAlreadyInDB(
                    String email ) {

        SaveResponse saveUserResponse = new SaveResponse( Boolean.FALSE,
                "email" );

        return saveUserResponse;
    }


    private boolean hasValue( String string ) {

        if ( string != null && !string.isEmpty() ) {
            return true;
        }

        return false;
    }


    private UserTransfer createUserTransfer( User user ) {

        UserTransfer userTransfer = new UserTransfer();
        userTransfer.setFirstName( user.getFirstName() );
        userTransfer.setLastName( user.getLastName() );
        userTransfer.setId( user.getId() );
        userTransfer.setEmail( user.getEmail() );
        userTransfer.setPhone( user.getPhone() );
        return userTransfer;
    }


    private void saveExistingUserEmailAndPassword(
            UserEditMyAccountEmailAndPasswordRequest editMyAccountEmailAndPasswordRequest,
            User user ) {

        String requestPassword = editMyAccountEmailAndPasswordRequest
                .getPassword();

        if ( hasValue( requestPassword ) ) {

            String hashPassword = getPasswordHashWithBcrypt( requestPassword );
            user.setPassword( hashPassword );
        }

        userRepository.save( user );
    }


    private void saveExistingUserPersonalDetails(
            UserEditMyAccountUserDetailsRequest adminEditMyAccountUserDetailsRequest,
            User user ) {

        user.setFirstName( Malicious.escapeMalicious(
                adminEditMyAccountUserDetailsRequest.getFirstName().trim() ) );

        user.setLastName( Malicious.escapeMalicious(
                adminEditMyAccountUserDetailsRequest.getLastName().trim() ) );

        userRepository.save( user );
    }


    private Boolean checkIfPasswordMatchesExistingOne(
            UserEditMyAccountEmailAndPasswordRequest editMyAccountEmailAndPasswordRequest ) {

        User user = userRepository.findOne( editMyAccountEmailAndPasswordRequest
                .getUserId() );

        String currentPassword = editMyAccountEmailAndPasswordRequest
                .getCurrentPassword();

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        if ( user != null ) {

            if ( passwordEncoder.matches( currentPassword, user
                    .getPassword() ) ) {
                return true;
            }
        }
        return false;
    }


    @Override
    public UserEditMyAccountInitialData getEditMyAccountInitialData(
            User user ) {

        UserTransfer userTransfer = createUserTransfer( user );

        return new UserEditMyAccountInitialData( userTransfer );
    }


    @Override
    @Transactional
    public SaveResponse editMyPersonalDetails( User user,
            UserEditMyAccountUserDetailsRequest adminEditMyAccountUserDetailsRequest ) {

        SaveResponse saveUserResponse = null;

        saveExistingUserPersonalDetails( adminEditMyAccountUserDetailsRequest,
                user );

        saveUserResponse = new SaveResponse( Boolean.TRUE, null );

        return saveUserResponse;
    }


    @Override
    @Transactional
    public SaveResponse editMyEmailAndPassword( User user,
            UserEditMyAccountEmailAndPasswordRequest editMyAccountEmailAndPasswordRequest ) {

        SaveResponse saveUserResponse = null;

        if ( checkIfPasswordMatchesExistingOne(
                editMyAccountEmailAndPasswordRequest ) ) {

            String newEmail = editMyAccountEmailAndPasswordRequest.getEmail().toLowerCase();

            if ( myEmailHasChangedButItIsAlreadyInTheDB( user, newEmail ) ) {

                saveUserResponse =
                        createErrorMessageThatEmailHasChangedButItisAlreadyInDB(
                                newEmail );
            }
            else {
                user.setEmail( Malicious.escapeMalicious(
                        editMyAccountEmailAndPasswordRequest.getEmail().toLowerCase() ) );

                String password = editMyAccountEmailAndPasswordRequest
                        .getPassword();

                if ( hasValue( password ) ) {

                    String hashPassword = getPasswordHashWithBcrypt( password );
                    user.setPassword( hashPassword );
                }

                userRepository.save( user );

                saveExistingUserEmailAndPassword(
                        editMyAccountEmailAndPasswordRequest, user );

                saveUserResponse = new SaveResponse( Boolean.TRUE, null );
            }
        }
        else {
            saveUserResponse = new SaveResponse( Boolean.FALSE, "password" );
        }

        return saveUserResponse;
    }
}