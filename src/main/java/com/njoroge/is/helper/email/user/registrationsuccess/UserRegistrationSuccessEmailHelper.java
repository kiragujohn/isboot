
package com.njoroge.is.helper.email.user.registrationsuccess;

import com.njoroge.is.domain.User;
import com.njoroge.is.service.email.EmailSentResponse;

/**
 * @author John Njoroge
 * @date 16/05/2019
 */
public interface UserRegistrationSuccessEmailHelper {

    EmailSentResponse sendEmailCreateUserAccount( User user );
}
