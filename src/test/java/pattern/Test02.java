package pattern;

import java.util.regex.Pattern;

/**
 * @Description:
 * @Author: lucy
 * @date: 2019/06/25
 */
public class Test02 {
    public static void main(String[] args) {
        match();
    }

    private static void match() {
        String str = "你好,hello7777";
        String regexp = "";
        //数字
//        regexp = "^你好,hello\\d{4}$";
        //字母和数字
//        regexp = "^你好,\\w{9}$";

        regexp = "^你好,.*$";
        regexp = "^你好\\{,*$";

        Pattern pattern = Pattern.compile(regexp);
        boolean result = pattern.matcher(str).matches();
        System.out.println(result);

        result = str.matches(regexp);
        System.out.println(result);

        result = Pattern.matches(regexp, str);
        System.out.println(result);
    }
}
