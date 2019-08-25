package http.netty.test;

import com.alibaba.fastjson.JSONObject;
import com.lcy.util.Md5Util;
import http.netty.HttpAsyncClientUtil;
import http.netty.ResponseJsonHandler;
import org.apache.pdfbox.pdmodel.graphics.predictor.Sub;

import java.awt.font.ShapeGraphicAttribute;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:
 * @Author: lucy
 * @date: 2019/07/25
 */
public class ZTOTest {
    public static void main(String[] args) throws Exception {
        sendJson();

        // 借助Executors
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    try {
//                        sendJson();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }

    }
    private static void sendJson() throws Exception {
        String url = "http://localhost:8082/msg/zto/sendJson";
//        String url = "http://172.16.40.244:8080/msg/zto/sendJson";
//        String url = "http://172.16.4.229:9091/zto/report/success";
        String Account = "C177";
        String SubCode = "";
        String Mobile = "13761014257";
        String Message = "主人来电话了";
        String MsgID = UUID.randomUUID().toString().substring(20);
        String Sign = "【好】";
        long Ts = System.currentTimeMillis() / 1000;

        String password = "bfda02c0a15fc88b2415076e6aeb1c6a";

        String data = getSortString(Account,SubCode,Mobile,Message,MsgID,Sign,Ts);
        System.out.println("加签前："+data);
        String sign = Md5Util.encoderByMd5(password.toUpperCase() + data);
        System.out.println("加签后："+sign);
        sign = sign.toUpperCase();
        System.out.println("加签后："+sign);

        JSONObject json = new JSONObject();
        json.put("Account", Account);
        json.put("Password", sign);
        json.put("SubCode", SubCode);
        json.put("Mobile", Mobile);
        json.put("Message", Message);
        json.put("MsgID", MsgID);
        json.put("Sign", Sign);
        json.put("Ts", Ts);

        HttpAsyncClientUtil.sendJson(url, json.toString(), new ResponseJsonHandler());
    }

    /**
     * 获取加签原始数据
     * @return
     */
    private static String getSortString(String Account, String SubCode, String Mobile,
                                        String Message, String MsgID, String Sign, long Ts) {
        TreeMap<String, Object> treeMap = new TreeMap<>();
        treeMap.put("Account", Account);
        treeMap.put("SubCode", SubCode);
        treeMap.put("Mobile", Mobile);
        treeMap.put("Message", Message);
        treeMap.put("MsgID", MsgID);
        treeMap.put("Sign", Sign);
        treeMap.put("Ts", Ts);

        StringBuffer sb = new StringBuffer();

        treeMap.entrySet().forEach(entry -> {
            sb.append(entry.getKey());
            sb.append(entry.getValue());
        });
        return sb.toString();
    }
}
