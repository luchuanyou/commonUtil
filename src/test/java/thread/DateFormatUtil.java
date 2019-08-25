package thread;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * @Description:
 * @Author: lucy
 * @date: 2019/04/26
 */
public class DateFormatUtil {
    public static final ThreadLocal<DateFormat> threadLocalFormat = new ThreadLocal<>();

    public static DateFormat getDateFormat(){
        if(threadLocalFormat.get() == null){
            return new SimpleDateFormat("");
        }
        return threadLocalFormat.get();
    }
}
