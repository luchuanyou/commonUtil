package string;

import com.google.common.base.Joiner;

/**
 * @Description:
 * @Author: lucy
 * @date: 2019/06/05
 */
public class String04Test {
    public static void main(String[] args) {
//        subStringTest();
//        forNull();

        String msg = "李秋维测试模板【你好】";
        String content = "李秋维测试模板【你好】";
//        getContent(msg, content);

//        setParams("a","b","c");
//        indexOf();


//        int startIndex = content.lastIndexOf("【");
//        int endIndex = content.indexOf("】");
//        System.out.println(startIndex +"," +endIndex);
//        if (startIndex > 0 && endIndex > 0 && startIndex < endIndex) {
//            String result = content.substring(startIndex, endIndex + 1);
//            System.out.println(result);
//        }
//
//        matchSignture("11",null);
        System.out.println(System.currentTimeMillis());
        long start = 1562550632124L;
        System.out.println(System.currentTimeMillis() - start);

//        appendInt();

//        prrsetIntError();

//        checkString();
//        splitStr();
        joinTest();
    }

    private static void joinTest() {
        String[] ids = new String[]{"a","b","c"};
        String result = Joiner.on(",").join(ids);
        System.out.println(result);
    }

    private static void splitStr() {
        String str = "a:b:c:d";
        System.out.println(str.split(":").length);
    }

    private static void checkString() {
        String str = "a";
        String str2 = "a";
        System.out.println(str == str2);
        System.out.println(str != str2);

        StrTest obj = new StrTest("tom");
        StrTest obj2 = new StrTest("tom");
        System.out.println(obj.getName() == obj2.getName());
        System.out.println(obj.getName() != obj2.getName());
    }

    private static void appendInt() {
        StringBuilder sb = new StringBuilder();
        sb.append(1);
        sb.append(",name");
        System.out.println(sb.toString());
    }

    private static void prrsetIntError() {
        System.out.println(Integer.parseInt("0.5"));
    }

    private static boolean matchSignture(String sign, String[] signatures) {
        for (String signature : signatures) {
            if (sign.equals(signature)) {
                return true;
            }
        }
        return false;
    }

    private static void indexOf() {
        String msg = "abc";
        System.out.println(msg.indexOf("b"));

        String str = "0123";
        System.out.println(str.substring(0,1));
        System.out.println(str.substring(1,2));
        System.out.println(str.substring(1,1));
        System.out.println(str.substring(str.length() -2));
    }

    public static void setParams2(String... keys){
        String[] ke = keys;
        for(String str:keys){
            System.out.println(str);
        }
    }

    public static void setParams(String... keys){
        String[] ke = keys;
        for(String str:keys){
            System.out.println(str);
        }
    }

    private static String getContent(String msg, String content) {
        String signature = "";
        if(msg.startsWith("【")){
            int index = msg.indexOf("】");
            if(index > 0){
                signature = msg.substring(0, index+1);
                signature = formatSignature(signature);
                msg = content;
            }
        }else if(msg.endsWith("】")){
            int index = msg.indexOf("【");
            if(index > 0){
                signature = msg.substring(index);
                signature = formatSignature(signature);
                msg = content + signature;
            }
        }else {
            msg = content;
        }

        String conten = msg;
        System.out.println(conten);
        return conten;
    }

    private static String formatSignature(String signature) {
        char[] chars = new char[]{'^','$','(',')','[',']','{','}','.','?','+','*','|'};
        for (int i = 0; i < chars.length; i++) {
            signature = signature.replace(chars[i] + "", "\\" + chars[i]);
        }
        return signature;
    }

    private static void forNull() {
//        String[] strs = null;
        String[] strs = new String[]{};
        for(String str: strs){
            System.out.println("---"+str);
        }
        System.out.println("over");
    }

    private static void subStringTest() {
        String str = "123456";
        String result = str.substring(0, 2);
        System.out.println(result);
    }
}

class StrTest{
    private String name;

    public StrTest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}