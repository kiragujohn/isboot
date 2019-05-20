
package com.njoroge.is.helper.hash;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Formatter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author John Njoroge
 * @date 16/05/2019
 */
@Component
public class HashHelperImpl implements HashHelper {

    private SecureRandom secureRandom = new SecureRandom();


    @Override
    public String byteToHex( final byte[] hash ) {

        Formatter formatter = new Formatter();

        for ( byte b : hash ) {
            formatter.format( "%02x", b );
        }

        String result = formatter.toString();
        formatter.close();
        return result;

    }


    @Override
    public String convertToMD5( String toConvert ) throws HashHelperException {

        try {
            if ( toConvert != null ) {
                MessageDigest digest = MessageDigest.getInstance( "MD5" );
                digest.reset();
                digest.update( toConvert.getBytes( "UTF-8" ) );
                String hash = byteToHex( digest.digest() );
                return hash;
            }
            return null;

        }
        catch ( NoSuchAlgorithmException | UnsupportedEncodingException e ) {
            throw new HashHelperException( "Cannot create Hash using SHA1", e );
        }
    }


    @Override
    public String convertToMD5( Long toConvert ) throws HashHelperException {

        try {
            if ( toConvert != null ) {
                MessageDigest digest = MessageDigest.getInstance( "MD5" );
                digest.reset();
                digest.update( toConvert.byteValue() );
                String hash = byteToHex( digest.digest() );
                return hash;
            }
            return null;

        }
        catch ( NoSuchAlgorithmException e ) {
            throw new HashHelperException( "Cannot create Hash using SHA1", e );
        }
    }


    @Override
    public String getRandomHash() {

        return secureRandom.nextLong() + "";
    }


    @Override
    public String getPasswordHashWithBcrypt( String password ) {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode( password );
        return hashedPassword;
    }


    @Override
    public String convertToBcrypt( String toConvert ) {

        if ( toConvert != null ) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String converted = passwordEncoder.encode( toConvert );
            return converted;
        }
        return null;
    }
}
