package json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * @项目名称: commonUtil
 * @文件名称: json 版本号：1.0
 * @Description:
 * @Author lucy
 * @创建日期: 2019年01月15日
 */
public class JsonTest {
    public static void main(String[] args) {
//        parseJson();
        for (int i = 0; i < 5; i++) {
            long startTime = System.currentTimeMillis();
            stringToJson();
            long endTime = System.currentTimeMillis();
            System.out.println((endTime - startTime) / 1000);
        }
    }

    private static void stringToJson() {
        try {
//            String str = "{'name':'jack'}";
            String str = "1";
            Map result = JSON.parseObject(str, Map.class);
            System.out.println("==========result:"+result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void parseJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("system_name", "gateway");
        jsonObject.put("business_type", "receive_report");
        jsonObject.put("local", "172.16.4.119");
        jsonObject.put("gmt_create", "2018-12-29T12:58:17");
        jsonObject.put("message_id", "18121716404332069");
        jsonObject.put("sp_number", "1069");
        jsonObject.put("mobile", "13032151172");
        jsonObject.put("account", "zengcj");
        jsonObject.put("content", "InsertHttpMessageThread task: IP:\" + filterChain.getUserData().getClientIp() + \",account:\" + account\n" +
                "                + \",msg:\" + params.getMsg() + \",product:\" + params.getProduct() + \",extno:\" + params.getExtno()\n" +
                "                + \",messageId:\" + messageId + \",短信总条数:\" + filterChain.getMsgCount() + \",电话个数:\" + phones.size()");
        jsonObject.put("status", "DELIVER");

        String str = jsonObject.toJSONString();
        System.out.println(str);
    }
}
