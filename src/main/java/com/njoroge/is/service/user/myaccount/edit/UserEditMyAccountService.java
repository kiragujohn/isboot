
package com.njoroge.is.service.user.myaccount.edit;

import com.njoroge.is.domain.User;
import com.njoroge.is.service.shared.SaveResponse;

/**
 * @author John Njoroge
 * @date 23/05/2019
 */
public interface UserEditMyAccountService {

    SaveResponse editMyEmailAndPassword( User user,
            UserEditMyAccountEmailAndPasswordRequest editMyAccountEmailAndPasswordRequest );


    UserEditMyAccountInitialData getEditMyAccountInitialData( User user );


    SaveResponse editMyPersonalDetails( User user,
            UserEditMyAccountUserDetailsRequest adminEditMyAccountUserDetailsRequest );

}
