
package com.njoroge.is.service.admin.user.edit;

import com.njoroge.is.domain.User;
import com.njoroge.is.service.shared.SaveResponse;

/**
 * @author John Njoroge
 * @date 23/05/2019
 */
public interface AdminUserEditService {

    AdminUserEditInitialData getEditMyAccountInitialData( Long userId );


    SaveResponse editUserDetails( User user,
            AdminUserEditRequest adminUserEditRequest );

}
