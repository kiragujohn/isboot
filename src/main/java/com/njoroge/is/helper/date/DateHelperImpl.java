
package com.njoroge.is.helper.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author John Njoroge
 * @date 16/05/2019
 */
@Component
public class DateHelperImpl implements DateHelper {

    private static SimpleDateFormat TIMESTAMP_FORMAT = new SimpleDateFormat(
            "dd-MM-yyyy HH:mm:ss.SSS Z" );

    static {
        TIMESTAMP_FORMAT.setTimeZone( TimeZone.getTimeZone( "GMT" ) );
    }

    private Logger logger = LoggerFactory.getLogger( DateHelperImpl.class );


    private boolean isToday( Calendar time, TimeZone timeZone ) {

        return isSameDay( time, Calendar.getInstance( timeZone ) );
    }


    private LocalTime convertHourToLocalTime( int hour ) {

        int minute = 0;
        int second = 0;
        return LocalTime.of( hour, minute, second );
    }


    private String getHour( Calendar calendar ) {

        String hour = calendar.get( Calendar.HOUR_OF_DAY ) + "";

        if ( hour.length() == 1 ) {
            hour = "0" + hour;
        }
        return hour;
    }


    private String getMinutes( Calendar calendar ) {

        String minute = calendar.get( Calendar.MINUTE ) + "";

        if ( minute.length() == 1 ) {
            minute = "0" + minute;
        }

        return minute;
    }


    private boolean checkIfOrderDayIsAWeekend( LocalDateTime orderDayTime ) {

        if ( orderDayTime.getDayOfWeek() == DayOfWeek.SATURDAY || orderDayTime
                .getDayOfWeek() == DayOfWeek.SUNDAY ) {

            return true;
        }
        return false;
    }


    private LocalDateTime skipDaysByWeekend( LocalDateTime orderDateTime,
            LocalTime startOfDayTime, int numberOfSecondsToAdd ) {

        LocalDateTime modifiedOrderDateTime = null;

        if ( orderDateTime.getDayOfWeek() == DayOfWeek.SATURDAY ) {
            modifiedOrderDateTime = orderDateTime.plusDays( 2 );

            modifiedOrderDateTime = resetStartDate( modifiedOrderDateTime,
                    startOfDayTime );

            modifiedOrderDateTime = modifiedOrderDateTime.plusSeconds(
                    numberOfSecondsToAdd );
        }
        else {
            modifiedOrderDateTime = orderDateTime.plusDays( 1 );

            modifiedOrderDateTime = resetStartDate( modifiedOrderDateTime,
                    startOfDayTime );

            modifiedOrderDateTime = modifiedOrderDateTime.plusSeconds(
                    numberOfSecondsToAdd );
        }
        return modifiedOrderDateTime;
    }


    private LocalDateTime secondsToEndOfDayIsLessThanNumberOfSecondsToAdd(
            LocalTime startOfDayTime, int numberOfSecondsToAdd,
            int secondsToEndOfDay, LocalDateTime modifiedOrderDateTime,
            LocalDateTime orderDateTime ) {

        int secondsToAddToNextDay = numberOfSecondsToAdd - secondsToEndOfDay;
        // Add secondsToAddToNextDay to the next day check if nextDay is a
        // weekend

        modifiedOrderDateTime = orderDateTime.plusDays( 1 );

        modifiedOrderDateTime = resetStartDate( modifiedOrderDateTime,
                startOfDayTime );

        // Add seconds to the next day
        modifiedOrderDateTime = modifiedOrderDateTime.plusSeconds(
                secondsToAddToNextDay );

        if ( checkIfOrderDayIsAWeekend( modifiedOrderDateTime ) ) {
            modifiedOrderDateTime = skipDaysByWeekend( modifiedOrderDateTime,
                    startOfDayTime, secondsToAddToNextDay );
        }

        return modifiedOrderDateTime;
    }


    private LocalDateTime secondsToEndOfDayIsLessThanOrEqualToSecondsToAdd(
            LocalTime startOfDayTime, int numberOfSecondsToAdd,
            LocalTime endOfDayTime, LocalDateTime modifiedOrderDateTime,
            LocalDateTime orderDateTime ) {

        LocalTime orderTime = LocalTime.of( orderDateTime.getHour(),
                orderDateTime.getMinute(), orderDateTime.getSecond() );

        Duration duration = Duration.between( orderTime, endOfDayTime );
        int secondsToEndOfDay = ( int ) duration.getSeconds();

        if ( secondsToEndOfDay == numberOfSecondsToAdd ) {
            // Add number of seconds to add to currentDay
            modifiedOrderDateTime = orderDateTime.plusSeconds(
                    numberOfSecondsToAdd );
        }
        else if ( secondsToEndOfDay < numberOfSecondsToAdd ) {
            modifiedOrderDateTime =
                    secondsToEndOfDayIsLessThanNumberOfSecondsToAdd(
                            startOfDayTime, numberOfSecondsToAdd,
                            secondsToEndOfDay, modifiedOrderDateTime,
                            orderDateTime );
        }
        else {
            modifiedOrderDateTime = orderDateTime.plusSeconds(
                    numberOfSecondsToAdd );
        }
        return modifiedOrderDateTime;
    }


    private LocalDateTime orderSecondsIsGreaterThanEndOfDaySeconds(
            LocalTime startOfDayTime, int numberOfSecondsToAdd,
            LocalDateTime modifiedOrderDateTime, LocalDateTime orderDateTime ) {

        // Add number of hours to add to the next day
        modifiedOrderDateTime = orderDateTime.plusDays( 1 );

        modifiedOrderDateTime = resetStartDate( modifiedOrderDateTime,
                startOfDayTime );

        // check if next day is a weekend
        if ( checkIfOrderDayIsAWeekend( modifiedOrderDateTime ) ) {
            modifiedOrderDateTime = skipDaysByWeekend( modifiedOrderDateTime,
                    startOfDayTime, numberOfSecondsToAdd );
        }

        modifiedOrderDateTime = modifiedOrderDateTime.plusSeconds(
                numberOfSecondsToAdd );

        return modifiedOrderDateTime;
    }


    private LocalDateTime toLocalDateTime( Calendar calendar ) {

        if ( calendar != null ) {
            TimeZone tz = calendar.getTimeZone();
            ZoneId zid = tz == null ? ZoneId.systemDefault() : tz.toZoneId();
            return LocalDateTime.ofInstant( calendar.toInstant(), zid );
        }
        return null;
    }


    private Calendar toCalendar( LocalDateTime localDateTime ) {

        Instant instant = localDateTime.atZone( ZoneId.systemDefault() )
                .toInstant();

        Calendar calendar = Calendar.getInstance();
        Date date = Date.from( instant );
        calendar.setTime( date );
        return calendar;
    }


    private LocalDateTime resetStartDate( LocalDateTime modifiedOrderDateTime,
            LocalTime startOfDayTime ) {

        modifiedOrderDateTime = LocalDateTime.of( modifiedOrderDateTime
                .getYear(), modifiedOrderDateTime.getMonth(),
                modifiedOrderDateTime.getDayOfMonth(), startOfDayTime.getHour(),
                00 );

        return modifiedOrderDateTime;

    }


    private String debugCalendar( Calendar calendar ) {

        return TIMESTAMP_FORMAT.format( calendar.getTime() );
    }


    private Calendar roundStartTimeUpToNext15Minutes( TimeZone timeZone ) {

        Calendar now = Calendar.getInstance( timeZone );
        int minutes = now.get( Calendar.MINUTE );

        // If we can round up to the next hour without going over the end
        // date do that.
        if ( minutes > 45 ) {

            now.set( Calendar.MINUTE, 0 );
            now.add( Calendar.HOUR, 1 );

        } // Else just increase the minutes to the next 15 minute increment
        else {

            if ( minutes > 30 ) {
                minutes = 45;
            }
            else if ( minutes > 15 ) {
                minutes = 30;
            }
            else {
                minutes = 15;
            }

            now.set( Calendar.MINUTE, minutes );
        }

        return now;
    }


    @Override
    public Calendar addMonthsToDate( int numberOfMonths ) {

        Calendar calendar = Calendar.getInstance();
        calendar.add( Calendar.MONTH, numberOfMonths );
        return calendar;
    }


    @Override
    public Date getDate() {

        Calendar calendar = Calendar.getInstance();
        return calendar.getTime();
    }


    @Override
    public boolean isSameDay( Calendar cal1, Calendar cal2 ) {

        if ( cal1 == null || cal2 == null ) {
            throw new IllegalArgumentException( "The dates must not be null" );
        }

        return ( cal1.get( Calendar.ERA ) == cal2.get( Calendar.ERA ) && cal1
                .get( Calendar.YEAR ) == cal2.get( Calendar.YEAR ) && cal1.get(
                        Calendar.DAY_OF_YEAR ) == cal2.get(
                                Calendar.DAY_OF_YEAR ) );
    }


    @Override
    public Calendar getStartOfDayCalendar( Calendar calendar ) {

        Calendar start = ( Calendar ) calendar.clone();
        start.set( Calendar.HOUR_OF_DAY, 0 );
        start.set( Calendar.MINUTE, 0 );
        start.set( Calendar.SECOND, 0 );
        start.set( Calendar.MILLISECOND, 0 );
        return start;
    }


    @Override
    public Calendar getEndOfDayCalendar( Calendar calendar ) {

        Calendar end = ( Calendar ) calendar.clone();
        end.set( Calendar.HOUR_OF_DAY, 23 );
        end.set( Calendar.MINUTE, 59 );
        end.set( Calendar.SECOND, 59 );
        end.set( Calendar.MILLISECOND, 999 );
        logger.info( "end of day = " + debugCalendar( end ) );
        return end;
    }


    @Override
    public TimeZone getTimeZoneFromJavaScriptTimeZoneOffset(
            Integer javascriptTimeZoneOffset ) {

        // The timeZoneOffset is coming from JavaScript and is expressed in
        // minutes. For example "Africa/Nairobi" is GMT + 3 but the
        // timeZoneOffset is -180.

        // In Java the offset is expressed in milliseconds and has the opposite
        // sign. For example "Africa/Nairobi" is 3 * 60 * 60 * 1000 = 10,800,000

        // Here we are converting from JavaScript timezone offset to Java
        // time zone offset.
        Integer rawOffset = -1 * javascriptTimeZoneOffset * 60 * 1000;

        // we get a list of all time zones which have the millisecond offset
        String[] ids = TimeZone.getAvailableIDs( rawOffset );
        // We take the first matching time zone
        TimeZone timeZone = TimeZone.getTimeZone( ids[0] );
        return timeZone;
    }


    @Override
    public Calendar getBrowserTimezoneCalendar( Calendar time,
            TimeZone timeZone ) {

        // We create a Calendar using that time zone
        Calendar timeInBrowserTimeZone = Calendar.getInstance( timeZone );

        // We set the time since the epoch
        timeInBrowserTimeZone.setTimeInMillis( time.getTimeInMillis() );
        return timeInBrowserTimeZone;
    }


    @Override
    public StartAndEnd getStartAndEnd( Calendar calendar,
            Integer javascriptTimeZoneOffset ) {

        TimeZone timeZone = getTimeZoneFromJavaScriptTimeZoneOffset(
                javascriptTimeZoneOffset );

        Calendar timeInBrowserTimeZone = getBrowserTimezoneCalendar( calendar,
                timeZone );

        // Now we can get the end of day for the browser time zone
        Calendar end = getEndOfDayCalendar( timeInBrowserTimeZone );
        Calendar start;

        // If we are not today we get the earliest time possible for
        // the calendar of the browser time zone
        if ( !isToday( timeInBrowserTimeZone, timeZone ) ) {

            start = getStartOfDayCalendar( timeInBrowserTimeZone );

        } // We are the same day so we get the time the user clicked
          // on the calendar rounded up to next whole number of 15
          // minute interval
        else {
            start = roundStartTimeUpToNext15Minutes( timeZone );
        }

        return new StartAndEnd( start, end );
    }


    // Note it adds 1 millisecond to endTimeSlot
    @Override
    public String getFormattedDateRange( Calendar startTimeSlot,
            Calendar endTimeSlot ) {

        String startHour = getHour( startTimeSlot );
        String startMinutes = getMinutes( startTimeSlot );

        Calendar endTimePlusOneMilli = ( Calendar ) endTimeSlot.clone();
        endTimePlusOneMilli.add( Calendar.MILLISECOND, 1 );

        String endHour = getHour( endTimePlusOneMilli );
        String endMinutes = getMinutes( endTimePlusOneMilli );

        String formattedDate = startHour + ":" + startMinutes + " - " + endHour
                + ":" + endMinutes;

        return formattedDate;
    }


    @Override
    public String getLetterDateFormatForLocale( Date date, Locale locale ) {

        String letterDateFormat = "EEEEE, dd MMMM yyyy, HH:mm";
        Locale.setDefault( locale );

        SimpleDateFormat fullMonthDateFormat = new SimpleDateFormat(
                letterDateFormat );

        return fullMonthDateFormat.format( date );

    }


    @Override
    public Calendar getCalendarWithBusinessSecondsAdded( int startOfDayHour,
            int endOfDayHour, int numberOfSecondsToAdd,
            Calendar calendarOrderDateTime ) {

        LocalTime startOfDayTime = convertHourToLocalTime( startOfDayHour );
        LocalTime endOfDayTime = convertHourToLocalTime( endOfDayHour );
        LocalDateTime orderDateTime = toLocalDateTime( calendarOrderDateTime );
        LocalDateTime modifiedOrderDateTime = null;

        if ( checkIfOrderDayIsAWeekend( orderDateTime ) ) {
            // Add number of hours to add to start time of Monday
            modifiedOrderDateTime = skipDaysByWeekend( orderDateTime,
                    startOfDayTime, numberOfSecondsToAdd );
        }
        else if ( orderDateTime.getHour() >= endOfDayHour ) {
            modifiedOrderDateTime = orderSecondsIsGreaterThanEndOfDaySeconds(
                    startOfDayTime, numberOfSecondsToAdd, modifiedOrderDateTime,
                    orderDateTime );
        }
        else if ( orderDateTime.getHour() < endOfDayHour ) {
            modifiedOrderDateTime =
                    secondsToEndOfDayIsLessThanOrEqualToSecondsToAdd(
                            startOfDayTime, numberOfSecondsToAdd, endOfDayTime,
                            modifiedOrderDateTime, orderDateTime );
        }

        return toCalendar( modifiedOrderDateTime );
    }


    public static void main( String[] args ) {

        int startOfDay = 8;
        int endOfDay = 17;
        int numberOfSecondsToAdd = 10800;

        SimpleDateFormat sdf = new SimpleDateFormat( "dd-M-yyyy hh:mm:ss" );
        String dateInString = "23-01-2019 16:00:00";
        Date date = null;
        try {
            date = sdf.parse( dateInString );
        }
        catch ( ParseException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime( date );

        DateHelper dateHelper = new DateHelperImpl();

        Calendar notificationCalendar = dateHelper
                .getCalendarWithBusinessSecondsAdded( startOfDay, endOfDay,
                        numberOfSecondsToAdd, calendar );

        System.out.println( "Notification date and time " + notificationCalendar
                .getTime() );
    }
}
