/*
 * 
 */
package mainPack;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 
 * @author Marcos Gomes
 */
public class DateTime {
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
    public String setDateFormat(Date date, String format){
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
}
