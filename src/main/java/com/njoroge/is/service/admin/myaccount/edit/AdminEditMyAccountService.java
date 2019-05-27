
package com.njoroge.is.service.admin.myaccount.edit;

import com.njoroge.is.domain.User;
import com.njoroge.is.service.shared.SaveResponse;

/**
 * @author John Njoroge
 * @date 23/05/2019
 */
public interface AdminEditMyAccountService {

    SaveResponse editMyEmailAndPassword( User user,
            AdminEditMyAccountEmailAndPasswordRequest editMyAccountEmailAndPasswordRequest );


    AdminEditMyAccountInitialData getEditMyAccountInitialData( User user );


    SaveResponse editMyPersonalDetails( User user,
            AdminEditMyAccountUserDetailsRequest adminEditMyAccountUserDetailsRequest );

}
