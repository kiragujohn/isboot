
package com.njoroge.is.helper.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @author John Njoroge
 * @date 16/05/2019
 */
public interface DateHelper {

    SimpleDateFormat FORMAT_yyyy_MM_dd_HH_mm_ss_SSS = new SimpleDateFormat(
            "yyyy_MM_dd_HH_mm_ss_SSS" );

    SimpleDateFormat FORMAT_EEE_d_MMMM_yyyy = new SimpleDateFormat(
            "EEEE, MMMM d, yyyy" );


    Calendar addMonthsToDate( int numberOfMonths );


    Date getDate();


    boolean isSameDay( Calendar cal1, Calendar cal2 );


    Calendar getStartOfDayCalendar( Calendar calendar );


    Calendar getEndOfDayCalendar( Calendar calendar );


    TimeZone getTimeZoneFromJavaScriptTimeZoneOffset(
            Integer javascriptTimeZoneOffset );


    Calendar getBrowserTimezoneCalendar( Calendar time, TimeZone timeZone );


    StartAndEnd getStartAndEnd( Calendar time, Integer timeZoneOffset );


    String getFormattedDateRange( Calendar startTimeSlot,
            Calendar endTimeSlot );


    String getLetterDateFormatForLocale( Date date, Locale locale );


    Calendar getCalendarWithBusinessSecondsAdded( int startOfDayHour,
            int endOfDayHour, int numberOfSecondsToAdd,
            Calendar orderDateTime );
}
