package string;

import com.alibaba.fastjson.JSONObject;
import com.lcy.util.Md5Util;
import sort.User;

import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: lucy
 * @date: 2019/07/17
 */
public class String05Test {
    public static void main(String[] args) throws Exception {
//        contains();
        /*String password = "a.123456";
        String result = getMd5(password);
        System.out.println(result);
        result = Md5Util.encoderByMd5(password);
        System.out.println(result);*/

//        decode();
//        equalss();
        subString();
//        stringNull();
//        split();
//        stringBuild();
        /*String str = "a,,b";
        System.out.println(str.split(",").length);

        User u = new User();
        u.setName(null);
        System.out.println(JSONObject.toJSONString(u));*/

        String str = "短信[尊敬的会员：网易严选购买不参加返券  https://ai.taobao.com/?pid=mm_112628724_11936611_53304806  最小为面值40 元百货券，惊喜多多！";
        System.out.println(str.length());

        Map<String, String> deliver = new HashMap<>();
        deliver.put("name", null);
        System.out.println(deliver);
    }

    private static void stringBuild() {
        String str = null;
        StringBuilder sb = new StringBuilder();
        sb.append("a").append(",");
        sb.append(str).append(",");
        sb.append("b").append(",");
        sb.append(str);

        String re = sb.toString();//会默认拼接null
        System.out.println(re);
        System.out.println(sb.toString());

        System.out.println("abc" + str + "e");//会拼接null

        System.out.println("null".equals(re.split(",")[1]));
    }

    private static void split() {
        String str = "a,null,,,,";
        String[] ary = str.split(",");
        System.out.println(Arrays.toString(ary));
        System.out.println(ary.length);

        String[] messageArr = new String[14];
        System.out.println(messageArr.length);
    }

    private static void stringNull() {
        String str = null;
        //空字符串默认会拼接null
        str = str + "word";//等价于str = String.valueOf(str)+"word"
        System.out.println(str);//nullword
    }

    private static void subString(){
        String str = "9876543210";
        System.out.println(str.substring(str.length() - 6, str.length()));
        System.out.println("123".substring(1));
        System.out.println(String.format("%01d", 3));
    }

    private static void equalss() {
        int num = 1;
        System.out.println("1".equals(num));//false
        System.out.println("1".equals(num+""));//true
        Integer num2 = 1;
        System.out.println("1".equals(num2));

        String str = "1";
        System.out.println("1".equals(str));
    }

    private static void decode() {
        String data = URLDecoder.decode("%E6%9C%AA%E7%9F%A5%E9%94%99%E8%AF%AF");
        System.out.println(data);
    }

    public static String getMd5(String plainText) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            //32位加密
            return buf.toString();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }
    private static void contains() {
        String str = "178.*";
        System.out.println(str.contains("178.*{$var}来电话"));
    }
}
