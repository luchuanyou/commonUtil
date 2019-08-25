package json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import sort.User;

import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Pattern;

import static temp.TestDemo.test;

/**
 * @Description:
 * @Author: lucy
 * @date: 2019/05/22
 */
public class Json2Test {
    public static void main(String[] args) {
//        parseJson();
//        printProperties();
//        jsonArray();
//        parseObject();
        getProperty();
    }

    public static void getProperty() {
        User u = new User();
        u.setSuccess(false);
        System.out.println(JSON.toJSONString(u));
    }

    private static void parseObject() {
        try {
            JSONObject str = JSON.parseObject(null);//空指针异常
            System.out.println(str.get("name"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void jsonArray() {
        JSONArray jsonArr = new JSONArray();
        JSONObject jsonObj = new JSONObject(true);
        jsonObj.put("name", "tom");
        jsonArr.add(jsonObj);

        System.out.println(jsonArr.toString());
    }

    private static void printProperties() {
        ResponseJsonDto dto = new ResponseJsonDto();
        dto.setMobile("13761014250");
        System.out.println(JSON.toJSONString(dto));
    }

    private static void parseJson() {
        HashMap<String, String> map = JSON.parseObject(null, HashMap.class);
        System.out.println(map);

//        String str = null;
        String str = "";
        String[] varMsgs = str.split(";");
        System.out.println(Arrays.toString(varMsgs));

        str = "0123";
        System.out.println(str.substring(0,1));
        System.out.println(str.substring(1,2));

//        boolean match = Pattern.matches("技术测试190603111退订回复TD", "技术测试190603111");
        boolean match = Pattern.matches("技术测试190603111.*", "技术测试190603111退订回复TD");
        System.out.println("match:"+match);
    }

}
