
package com.njoroge.is.service.register;

import com.njoroge.is.service.shared.SaveResponse;

/**
 * @author John Njoroge
 * @date 16/05/2019
 */
public interface RegisterService {

    RegisterInitialData getInitialData();


    SaveResponse save( RegisterRequest sellerAddBuyerRequest, String domain );
}
