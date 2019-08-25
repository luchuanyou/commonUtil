package temp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestDemo {

    public static void main(String[] args) {

        getSqlStrByList();

//        test();
//        getNextReportPushTime(4);
//        System.out.println(StringUtils.startsWithIgnoreCase("", "HK"));

//        test2();
        System.out.println(1000%1000);

    }

    private static void test2() {
        String msg = "【253创蓝】{$var}审核敏感词{$var}圣诞节快乐";
        int k = 0;
        int index = 0;
        String findText = "{$var}";
        while ((index = msg.indexOf(findText, index)) != -1) {
            index = index + findText.length();
            k++;
        }
        System.out.println("index:"+index);
        System.out.println("k:"+k);

        JSONObject json = new JSONObject();
        json.remove("name");
        json.put("age",12);
        System.out.println(json);
    }

    /**
     * 推送失败获取下去推送时间
     * @param times
     * @return
     */
    private static long getNextReportPushTime(int times){
        long nextTime = 60L;
        try {
            //获取状态推送失败重推时间间隔
            String timeInterval = "60,300,500";
            String[] timeIntervalArr = timeInterval.split(",");
            if( timeIntervalArr == null || timeIntervalArr.length <= 0){
                return nextTime;
            }

            if(timeIntervalArr.length >= times){
                nextTime = Long.parseLong(timeIntervalArr[times - 1]);
            }

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        System.out.println("nextTime:"+nextTime);
        return nextTime;
    }

    public static void test(){
        String content = "【253创蓝】{$var}审核敏感词圣诞节快乐,验证码：123456";
        if (!content.contains("码")) {
            System.out.println(content);
        } else {
            String pattern = "(码.{0,4}\\d{4,6})";
            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(content);
            while (m.find()) {
                String sub = m.group(0);
                StringBuffer number = new StringBuffer(sub);
                number.replace(sub.length() - 4, sub.length() - 1, "***");
                content = content.replace(sub, number.toString());
            }
            System.out.println(content);
        }
    }
    public static void getSqlStrByList(){
        List list = new ArrayList();
        for (int i = 0; i < 2000; i++) {
            list.add(i);
        }
        String result = getSqlStrByList(list, 1000, "name");
        System.out.println("result:"+result);
    }
    private static String getSqlStrByList(List sqhList, int splitNum, String columnName) {
        if (splitNum > 1000) // 因为数据库的列表sql限制，不能超过1000.
            return null;
        StringBuffer sql = new StringBuffer("");
        if (sqhList != null) {
            sql.append(" ").append(columnName).append(" IN ( ");
            for (int i = 0; i < sqhList.size(); i++) {
                sql.append("").append(sqhList.get(i) + ",");
                if ((i + 1) % splitNum == 0 && (i + 1) < sqhList.size()) {
                    sql.deleteCharAt(sql.length() - 1);
                    sql.append(" ) OR ").append(columnName).append(" IN (");
                }
            }
            sql.deleteCharAt(sql.length() - 1);
            sql.append(" )");
        }
        return sql.toString();
    }
}
