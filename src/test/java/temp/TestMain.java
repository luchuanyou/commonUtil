package temp;

import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

/**
 * @项目名称: commonUtil
 * @文件名称: temp 版本号：1.0
 * @Description:
 * @Author lucy
 * @创建日期: 2019年01月09日
 */
public class TestMain {
    public static void main(String[] args) {
//        foreach();
//        relace();
//        match();

//        foreNull();

        uuid32();
    }

    private static void uuid32() {
        String value = UUID.randomUUID().toString();
        System.out.println(value);
        System.out.println(value.length());
        value = value.replace("-","");
        System.out.println(value);
        System.out.println(value.length());
    }

    private static void foreNull() {
        String[] signatures = null;
        String sign = "ds";
        for (String signature : signatures) {
            if (sign.equals(signature)) {
                System.out.println("true===");
            }
        }
    }

    private static void match() {
        Pattern nonRegPattern = Pattern.compile("[\\pP\\p{Punct}\\￥\\s*|\t|\r|\n]+");
        String str = "电-费";
        str = nonRegPattern.matcher(str).replaceAll("");
        System.out.println(str);


        Pattern blankRegEx = Pattern.compile("\\s*|\t|\r|\n");
        String str2 = " 电 费 3 ";
        System.out.println(blankRegEx.matcher(str2).replaceAll("").trim());
    }

    private static void relace() {
        String str = "$hello";
//        str = str.replace("$","en");//替换字符串

        int lastIndexOf = str.lastIndexOf("$");
        System.out.println("lastIndexOf:"+lastIndexOf);
        str = str.substring(0,lastIndexOf-1);

        System.out.println(str);
    }

    private static void foreach() {
        List<String> list = null;
        for (String str : list) {
            System.out.println("========");
        }
    }
}
