package string;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class StringTest {
    public static void main(String[] args) {
//        test();
//        format();
//        isNull();
//        parseNull();
//        equals();
//        String str = null;
//        System.out.println(String.valueOf(str));

//        System.out.println(getSubmiteType(null));

        String str = String.format("val:%s",null);
        System.out.println(str);

        SimpleDateFormat localObject = new SimpleDateFormat("yyyyMMddHHmmss");
        StringBuffer ps = new StringBuffer().append(((SimpleDateFormat) localObject).format(new Date())).append(",")
                .append("301,部分参数为空");
        System.out.println(ps);

        try {
            SimpleDateFormat yyMMddHHmm = new SimpleDateFormat("yyMMddHHmm");
            Date date = yyMMddHHmm.parse("1904030937");
            System.out.println(date);
            System.out.println(localObject.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Random rand = new Random();
        Long expireTime =(System.currentTimeMillis())/1000+rand.nextInt(5);

        System.out.println(expireTime);
        System.out.println(rand.nextInt(5));

        String srt = String.format("new:blacklist", new String[]{"tom" + ":" + "137"});
        System.out.println(srt);

    }

    public static int getSubmiteType(String msgId) {
        msgId = "19032014252123041";
        int accountType = 2;
        try{
            String submitType = msgId.substring(12, 13);
//            String submitType = msgId.substring(0, 1);
            accountType = Integer.parseInt(submitType);
        }catch(Exception ex){

        }
        return accountType;
    }

    private static void equals() {
        Integer num = 1;
        String str = "1";
        System.out.println(num.equals(str));//false
        System.out.println(str.equals(num));//false
    }

    private static void parseNull() {
        try {
            String str = null;
            System.out.println("==="+String.valueOf(str));//结果null
//            str.toString();//空指针异常

            String ss = null;
//            if(ss.equals("df")){
            if("df".equals(ss)){

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void isNull() {
        String str = new String();
        System.out.println("".equals(str));
        System.out.println(null == str);
    }

    private static void format() {
        Double value = 2.346342;
        String result = String.format("%.2f", value);//保留两位小数，四舍五入
        System.out.println("result:"+result);
    }

    private static void test() {
        //        String name = "Jack";
        String name = "";
        String preName = "ck";
        boolean isOk = StringUtils.startsWithIgnoreCase(name, preName);
        System.out.println("isOk:"+isOk);


//        List list = new ArrayList();
        List list = null;
        isOk = CollectionUtils.isNotEmpty(list);
        System.out.println("list isOk:"+isOk);


        Calendar cal = Calendar.getInstance();
        System.out.println(cal.get(Calendar.MINUTE));
    }

}
