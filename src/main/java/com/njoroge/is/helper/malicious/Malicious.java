
package com.njoroge.is.helper.malicious;

/**
 * @author John Njoroge
 * @date 16/05/2019
 */
public class Malicious {

    public static String escapeMalicious( String text ) {

        if ( text == null ) {
            return null;
        }

        String replacedText = text.replaceAll( "<script>", "" );
        replacedText = replacedText.replaceAll( "</script>", "" );
        return replacedText;
    }
}
