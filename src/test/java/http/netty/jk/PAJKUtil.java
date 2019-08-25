package http.netty.jk;

import com.alibaba.fastjson.JSONObject;
import http.netty.HttpAsyncClientUtil;
import http.netty.ResponseMapHandler;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;
import java.util.Map.Entry;

/**
 * @Description:
 * @Author: lucy
 * @date: 2019/08/15
 */
public class PAJKUtil {
    private static Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) {
        report(null);
    }

    public static void moReport(String[] args) {
        String baseUrl = "http://openapi.test.pajk.cn/api/v1";//测试环境

        //上行短信回调－测度环境
        String apiId = "73627b997277716c1f2fd23d946bdea3#TEST";
        String partnerId = "SP_CHANGLAN";//
        String partnerKey = "c4848058590a8adb1c93b1b19f30be36";
        String apiName = "/MessageSpCallback/upstreamReport";




        // add parameters
        JSONObject json = new JSONObject();
        json.put("content","hello");
        json.put("extCode","9999175177123");
        json.put("mobile","13761014257");
        json.put("spAccount","C177");
        json.put("spName","SP_CHANGLAN");
        json.put("time","20190817151800");


        PAJKEncoder encoder = new PAJKEncoder(partnerId, partnerKey, apiId);
        encoder.putParameter(json);
        PAJKRequestEntity requestEntity = encoder.encode();
        String postUrl = baseUrl + apiName + "?" + requestEntity.getQueryParams();
        Map<String, String> body = requestEntity.getFormParams();

        HttpAsyncClientUtil.sendPost(postUrl, body, new ResponseMapHandler());
    }

    public static void report(String[] args) {
        String baseUrl = "http://openapi.test.pajk.cn/api/v1";//测试环境

        //短信状态回调－测度环境
        String apiId = "b667876b19ea94ce0f50325e33dfdd21#TEST";
        String partnerId = "SP_CHANGLAN";//
        String partnerKey = "c4848058590a8adb1c93b1b19f30be36";
        String apiName = "/MessageSpCallback/smsReport";


        // add parameters
        JSONObject json = new JSONObject();
        json.put("length","1");
        json.put("mobile","13761014257");
        json.put("msgid","S5043203--71----000088");
        json.put("notifyTime","20190817144500");
        json.put("reportTime","20190817144400");
        json.put("spAccount","C177");
        json.put("spName","SP_CHANGLAN");
        json.put("status","0");
        json.put("statusCode","DELIVRD");
        json.put("statusDesc","%E7%9F%AD%E4%BF%A1%E5%8F%91%E9%80%81%E6%88%90%E5%8A%9F");

        List list = new ArrayList();
        list.add(json);

        PAJKEncoder encoder = new PAJKEncoder(partnerId, partnerKey, apiId);
        encoder.putParameter(list);

        PAJKRequestEntity requestEntity = encoder.encode();
        String postUrl = baseUrl + apiName + "?" + requestEntity.getQueryParams();
        Map<String, String> body = requestEntity.getFormParams();


        HttpAsyncClientUtil.sendPost(postUrl, body, new ResponseMapHandler());
    }

    public static void main2(String[] args) {
        String baseUrl = "http://openapi.test.pajk.cn/api/v1";//测试环境
        String apiName = "/MessageSpCallback/smsReport";

        String name = "SP_CHANGLAN";
        String key = "c4848058590a8adb1c93b1b19f30be36";
        String appId = "b667876b19ea94ce0f50325e33dfdd21#TEST";
        PAJKEncoder encoder = new PAJKEncoder(name, key, appId);

        JSONObject json = new JSONObject();
        json.put("length","1");
        json.put("mobile","13761014257");
        json.put("msgid","S5043203--71----000088");
        json.put("notifyTime","20190817144500");
        json.put("reportTime","20190817144400");
        json.put("spAccount","C177");
        json.put("spName","SP_CHANGLAN");
        json.put("status","0");
        json.put("statusCode","DELIVRD");
        json.put("statusDesc","%E7%9F%AD%E4%BF%A1%E5%8F%91%E9%80%81%E6%88%90%E5%8A%9F");

        encoder.putParameter(json);

        PAJKRequestEntity requestEntity = encoder.encode();
        String postUrl = baseUrl + apiName + "?" + requestEntity.getQueryParams();
//        String data = requestEntity.getFormParams();

        String realUrl = postUrl;
        HttpAsyncClientUtil.sendPost(realUrl, new HashMap(), new ResponseMapHandler());
    }

    /**
     * 参数排序
     * @param map
     * @return
     */
    public static String toSortString(Map<String, String> map){
        if (map == null) {
            return null;
        } else {
            TreeMap m = new TreeMap(map);

            try {
                StringBuilder sb = new StringBuilder();
                Iterator i$ = m.entrySet().iterator();

                while(i$.hasNext()) {
                    Entry<String, String> entry = (Entry)i$.next();
                    if (entry.getValue() != null) {
                        String key = ((String)entry.getKey()).trim();
                        String value = URLEncoder.encode(((String)entry.getValue()).trim(), "utf-8");
                        sb.append(String.format("%s=%s&", key, value));
                    }
                }

                sb.append(String.format("%s=%s", "__o_r", nextRandomTime()));
                return sb.toString();
            } catch (UnsupportedEncodingException e) {
                return null;
            }
        }
    }

    public static String nextRandomTime() {
        return System.currentTimeMillis() + "." + random.nextInt(1000);
    }

    public static String nextRandomFloat() {
        return String.valueOf(random.nextFloat());
    }










}
