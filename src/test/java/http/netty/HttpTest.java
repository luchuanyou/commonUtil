package http.netty;

import com.alibaba.fastjson.JSONObject;
import http.netty.temp.CLDES;

import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HttpTest {
    public static void main(String[] args) throws Exception{

//        String url = "http://localhost:8081/msg/HttpVarSM";
//        String url = "https://restapi.amap.com/";
//        HttpAsyncClientUtil.sendGet(url,new ResponseHandler());

        //开户
//        createAccount();
        //子账号开户
//        createSubAccount();
        try {
            //加解密
//            encode();
            //更新账号状态
//            updateAccountStatus();
            //更新付费类型
            updateAccountFeeType();
//            sendJson();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void sendJson() {
        String url = "http://localhost:9091/test/sendJson";
        System.out.println(url);
        JSONObject json = new JSONObject();
        json.put("name","tom");
        json.put("age",12);

        List list = new ArrayList<>();
        JSONObject subJson = new JSONObject();
        subJson.put("msgId","1123");
        subJson.put("report","success");

        list.add(subJson);
        json.put("list",list);

        HttpAsyncClientUtil.sendJson(url, json.toString(), new ResponseJsonHandler());
    }

    private static void updateAccountFeeType() throws Exception {
        String url = "http://172.16.40.235:8080/admin/updateAccountFeeType";

        String account = "N7193489";
        Integer feeType = 0;//付费类型，0：预付费；1：后付费
        String cause = "禁用";

        StringBuffer sb = getBaseRequestParams();
        sb.append("&account=").append(CLDES.encode("12345678",account));
        sb.append("&feeType=").append(feeType);
        sb.append("&cause=").append(cause);


        url += sb.toString();
        System.out.println(url);
        HttpAsyncClientUtil.sendGet(url,new ResponseHandler());
    }

    private static void updateAccountStatus() throws Exception {
        String url = "http://localhost:8080/admin/updateStatusAndSendStatus";

        String account = "C177";
        Integer status = 2;//账号状态，0：正常；2禁止
        Integer sendStatus = 1;//发送状态，0：正常；1：禁止
        String cause = "禁用";

        StringBuffer sb = getBaseRequestParams();
        sb.append("&account=").append(CLDES.encode("12345678",account));
        sb.append("&status=").append(status);
        sb.append("&sendStatus=").append(sendStatus);
        sb.append("&cause=").append(cause);


        url += sb.toString();
        System.out.println(url);
        HttpAsyncClientUtil.sendGet(url,new ResponseHandler());
    }

    private static void encode() throws Exception {
        String data = CLDES.encode("12345678","aaaaaaaaaaaa");
        System.out.println(data);
        System.out.println(CLDES.encode("12345678","12345678"));
        System.out.println(URLDecoder.decode(data, "UTF-8"));
    }

    private static void createAccount() {
        String url = "http://localhost:8080/admin/UserManage";
        url += getRequestParams();
        System.out.println(url);
        HttpAsyncClientUtil.sendGet(url,new ResponseHandler());
    }
    public static String getRequestParams() {
        String name = "HKtestnm";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = sdf.format(new Date());

        StringBuffer sb = new StringBuffer();
        sb.append("?");
        sb.append("username=").append("admin");
        byte[] password = ("admin" + "ClAdmin168^&*" + timestamp).getBytes();
        sb.append("&password=").append(MD5DigestByte(password));
        sb.append("&operator=").append("lucy");
        sb.append("&account=").append("NcfrBsqSARs=");
        sb.append("&action=").append(0);
        sb.append("&timestamp=").append(timestamp);
        sb.append("&ac_password=").append("Ya875bmdAs2ZiW3ha160Ug==");
        sb.append("&true_name=").append("测试开户");
        sb.append("&type=").append(2);
        sb.append("&send_hour=").append("9,10");
        sb.append("&need_audit=").append(1);
        sb.append("&need_reportmo=").append(1);
        sb.append("&account_sms_type=").append(1);
        sb.append("&send_num=").append(12);
        sb.append("&extno=").append(102);

        return sb.toString();
    }

    private static void createSubAccount() {
        String url = "http://localhost:8080/admin/AgentUserManage";
        url += getRequestParamsSub();
        System.out.println(url);
        HttpAsyncClientUtil.sendGet(url,new ResponseHandler());
    }
    public static String getRequestParamsSub() {
        String name = "HKtestnm";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = sdf.format(new Date());

        StringBuffer sb = new StringBuffer();
        sb.append("?");
        sb.append("username=").append("admin");
        byte[] password = ("admin" + "ClAdmin168^&*" + timestamp).getBytes();
        sb.append("&password=").append(MD5DigestByte(password));
        sb.append("&operator=").append("lucy");
        sb.append("&account=").append("4IjFFISSYM90RhCJUQhayw==");
        sb.append("&action=").append(0);
        sb.append("&timestamp=").append(timestamp);
        sb.append("&ac_password=").append("Ya875bmdAs2ZiW3ha160Ug==");
        sb.append("&true_name=").append("测试开户");
        sb.append("&type=").append(3);
        sb.append("&send_hour=").append("9,10");
        sb.append("&need_audit=").append(1);
        sb.append("&need_reportmo=").append(1);
        sb.append("&account_sms_type=").append(1);
        sb.append("&send_num=").append(12);
        sb.append("&extno=").append(104);
        sb.append("&send_type=").append("B");
        sb.append("&parent=").append("D00001");

        return sb.toString();
    }


    private static String[] a = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
    public static String MD5DigestByte(byte[] paramArrayOfByte) {
        MessageDigest localMessageDigest;
        try {
            localMessageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException paramArrayOfByte1) {
            throw new RuntimeException(paramArrayOfByte1.getMessage());
        }
        localMessageDigest.update(paramArrayOfByte);

        // b EncryptionUtil
        return c(localMessageDigest.digest());
    }

    public static String c(byte[] paramArrayOfByte)
    {
        StringBuffer localStringBuffer1 = new StringBuffer();
        StringBuffer sb = null;
        for (int j = 0; j < paramArrayOfByte.length; j++)
        {
            int k = paramArrayOfByte[j];
            int i = k;
            if (i < 0) {
                k = i + 256;
            }
            int i1 = k / 16;
            k %= 16;
            sb = localStringBuffer1.append(a[i1] + a[k]);
        }
        return sb.toString();
    }

    public static StringBuffer getBaseRequestParams() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = sdf.format(new Date());

        StringBuffer sb = new StringBuffer();
        sb.append("?");
        sb.append("username=").append("admin");
        byte[] password = ("admin" + "ClAdmin168^&*" + timestamp).getBytes();
        sb.append("&password=").append(MD5DigestByte(password));
        sb.append("&timestamp=").append(timestamp);
        sb.append("&operator=").append("lucy");
        return sb;
    }
}
