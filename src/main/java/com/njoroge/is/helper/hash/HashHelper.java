
package com.njoroge.is.helper.hash;

/**
 * @author John Njoroge
 * @date 16/05/2019
 */
public interface HashHelper {

    String byteToHex( final byte[] hash );


    String getRandomHash();


    String convertToMD5( String toConvert ) throws HashHelperException;


    String convertToMD5( Long toConvert ) throws HashHelperException;


    String getPasswordHashWithBcrypt( String password );


    String convertToBcrypt( String toConvert );

}
