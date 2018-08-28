/*
 * 
 */
package mainPack;

import framesListeners.Messages;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 
 * @author Marcos Gomes
 */
public class DateTime {
    // Fields
    
    // Singleton
    private DateTime() {}
    
    public static DateTime getInstance() {return DatesHolder.INSTANCE;}
    
    private static class DatesHolder {
        private static final DateTime INSTANCE = new DateTime();
    }
    
    /**
     * @param date the date to convert
     * @param format a date String format: It can be:<br>
     * <ul>
     * <li>"yyyy-MM-dd";</li>
     * <li>"HH:mm:ss"</li>
     * <li>"yyyy-MM-dd HH:mm:ss"</li>
     * <li>"Or a combination of them"</li>
     * </ul>
     * @return a date on format yyyy-mm-dd.
     */
    public String setDateFormat(Date date, String format) throws Exception{
        //
        return new SimpleDateFormat(format).format(date);
    }
    
    /**
     * @param date the local date to convert
     * @param format a date String format: It can be:<br>
     * <ul>
     * <li>"yyyy-MM-dd";</li>
     * <li>"HH:mm:ss"</li>
     * <li>"yyyy-MM-dd HH:mm:ss"</li>
     * <li>"Or a combination of them"</li>
     * </ul>
     * @return a date on format yyyy-mm-dd.
     */
    public String setLocalDateFormat(LocalDateTime date, String format){
        //
        return date.format(DateTimeFormatter.ofPattern(format));
    }
    
    /**
     * 
     * @param date
     * @param days
     * @return 
     */
    public String addDays(String date, Integer days){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String result = "";
        try {
            Date df = sdf.parse(date);
            GregorianCalendar calendar = new GregorianCalendar();
            calendar.setTime(df);
            calendar.add (Calendar.DAY_OF_MONTH, days);
            result = sdf.format(calendar.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
                } 
}
