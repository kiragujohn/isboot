
package com.njoroge.is.helper.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author John Njoroge
 * @date 16/05/2019
 */
public class StartAndEnd {

    private static SimpleDateFormat TIMESTAMP_FORMAT = new SimpleDateFormat(
            "dd-MM-yyyy HH:mm:ss.SSS" );

    private Calendar start;
    private Calendar end;


    public StartAndEnd( Calendar start, Calendar end ) {

        this.start = start;
        this.end = end;
    }


    public Calendar getStart() {

        return start;
    }


    public void setStart( Calendar start ) {

        this.start = start;
    }


    public Calendar getEnd() {

        return end;
    }


    public void setEnd( Calendar end ) {

        this.end = end;
    }


    private String debugCalendar( Calendar calendar ) {

        return TIMESTAMP_FORMAT.format( calendar.getTime() );
    }


    @Override
    public String toString() {

        return "StartAndEnd [start=" + debugCalendar( start ) + ", end="
                + debugCalendar( end ) + "]";
    }
}
