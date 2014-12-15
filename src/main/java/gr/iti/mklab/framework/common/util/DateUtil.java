package gr.iti.mklab.framework.common.util;

import java.util.Calendar;
import java.util.Date;

/**
 * Class for handling date util
 * @author ailiakop
 *
 */
public class DateUtil {
	
    protected static final long HOUR = 1000L * 60L * 60;
    protected static final long DAY = 1000L * 60L * 60L * 24L;
    protected static final long MINUTE = 1000L * 60L;

    public Date addDays(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //negative number decrements the days
        return cal.getTime();
    }
    
    public Long getLifeDuration(long publicationTime) {
        Long now = new Date().getTime();
        Long difference = now - publicationTime;

        return difference / (60L * 1000L);
    }

    public String getLifeDurationText(long publicationTime) {

        Long now = new Date().getTime();
        Long difference = now - publicationTime;

        if (difference > DAY) {

            long difInDays = (difference / DAY);
            if (difInDays == 1) {
                return difInDays + " day";
            } else {
                return difInDays + " days";
            }
        } else if (difference > (2L * HOUR)) {
            long difInHours = (difference / HOUR);
            return difInHours + "h";
        } else {
            long difInMinutes = (difference / MINUTE);
            return difInMinutes + "m";
        }

    }
}