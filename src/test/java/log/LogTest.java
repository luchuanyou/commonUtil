package log;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description:
 * @Author: lucy
 * @date: 2019/02/16
 */
public class LogTest {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            long startTime = System.currentTimeMillis();
            String result = getLogContentDetail("test"+i);
            System.out.println(result);
            long endTime = System.currentTimeMillis();
            System.out.println((endTime - startTime) / 1000);
        }
    }

    /**
     * 获取日志详情信息
     * @param content 日志内容
     * @return
     */
    public static String getLogContentDetail(String content){
        StackTraceElement ste = Thread.currentThread().getStackTrace()[2];
        //类名
        String className = ste.getClassName();
        //方法名
        String methodName = ste.getMethodName();
        //行数
        int lineNumber = ste.getLineNumber();
        //当前时间
        String currentDateStr = formatDate(new Date(),FORMAT_YYYY_MM_DD_HMSS);

        String result =  currentDateStr + " INFO " + className + "." +  methodName + "() Line:" + lineNumber + " - " + content;
        return result;
    }

    public static String formatDate(Date date, String pattern) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat formater = new SimpleDateFormat(pattern);
        return formater.format(date);
    }

    static String FORMAT_YYYY_MM_DD_HMSS = "yyyy-MM-dd HH:mm:ss.SSS";
}
