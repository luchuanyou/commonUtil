package com.lcy.util.http;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONObject;


/*
 * 利用HttpClient进行post请求的工具类
 */
public class HttpClientUtil {

    /**
     * 发送post请求
     * @param url
     * @param map
     * @param charset
     * @return
     */
    public static String doPost(String url, Map<String, String> map, String charset) {

        HttpClient httpClient = null;
        HttpPost httpPost = null;
        String result = null;
        try {
            httpClient = HttpClients.createDefault();
            httpPost = new HttpPost(url);
            
            //设置超时时间
            RequestConfig requestConfig = RequestConfig.custom()
                    .setSocketTimeout(5000)
                    .setConnectTimeout(5000)
                    .setConnectionRequestTimeout(5000)
                    .build();
            httpPost.setConfig(requestConfig);
            
            //设置参数
            List<NameValuePair> list = new ArrayList<NameValuePair>();
            Iterator iterator = map.entrySet().iterator();
            while(iterator.hasNext()) {
                Entry<String, String> elem = (Entry<String, String>)iterator.next();
                list.add(new BasicNameValuePair(elem.getKey(), elem.getValue()));
            }
            if(list.size() > 0) {
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, charset);
                httpPost.setEntity(entity);
            }
            HttpResponse response = httpClient.execute(httpPost);
            if(response != null) {
                HttpEntity resEntity = response.getEntity();
                if(resEntity != null) {
                    result = EntityUtils.toString(resEntity, charset);
                }
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
    /**
     * 发送post#json请求
     * @param url
     * @param json
     * @return
     */
    public static String doPostWithJson(String url, String json) {

        String returnValue = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        ResponseHandler<String> responseHandler = new BasicResponseHandler();
        try {
            //第一步：创建HttpClient对象
            httpClient = HttpClients.createDefault();

            //第二步：创建httpPost对象
            HttpPost httpPost = new HttpPost(url);
            
            //设置超时时间
            RequestConfig requestConfig = RequestConfig.custom()
                    .setSocketTimeout(5000)
                    .setConnectTimeout(5000)
                    .setConnectionRequestTimeout(5000)
                    .build();
            httpPost.setConfig(requestConfig);

            //第三步：给httpPost设置JSON格式的参数
            StringEntity requestEntity = new StringEntity(json, "utf-8");
            requestEntity.setContentEncoding("UTF-8");
            httpPost.setHeader("Content-type", "application/json");
            httpPost.setEntity(requestEntity);

            //第四步：发送HttpPost请求，获取返回值
            returnValue = httpClient.execute(httpPost, responseHandler); //调接口获取返回值时，必须用此方法
            //         CloseableHttpResponse httpResonse = httpClient.execute(httpPost);
            //         int statusCode = httpResonse.getStatusLine().getStatusCode();
            //         if(statusCode!=200)
            //         {
            //              System.out.println("请求发送失败，失败的返回参数为："+httpResonse.getStatusLine());
            //              returnValue = httpResonse.getStatusLine().toString();     
            //         }
            //         

        } catch(Exception e) {
            e.printStackTrace();
        }finally {
            try {
                httpClient.close();
            } catch(IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        //第五步：处理返回值
        return returnValue;
    }
    /**
     * 发送post请求
     * @param url 地址
     * @param json 内容
     * @param signKey 加密秘钥
     * @return
     */
    public static String doPostWithJsonAndSign(String url, String json, String signKey) {
        
        /*String returnValue = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        ResponseHandler<String> responseHandler = new BasicResponseHandler();
        try {
            //第一步：创建HttpClient对象
            httpClient = HttpClients.createDefault();

            //第二步：创建httpPost对象
            HttpPost httpPost = new HttpPost(url);

            //设置超时时间
            RequestConfig requestConfig = RequestConfig.custom()
                    .setSocketTimeout(5000)
                    .setConnectTimeout(5000)
                    .setConnectionRequestTimeout(5000)
                    .build();
            httpPost.setConfig(requestConfig);

            //第三步：给httpPost设置JSON格式的参数
            StringEntity requestEntity = new StringEntity(json, "utf-8");
            requestEntity.setContentEncoding("UTF-8");
            httpPost.setHeader("Content-type", "application/json");
            httpPost.setEntity(requestEntity);

            String sign = ApiInterfaceValid.sign(signKey, json);
            httpPost.setHeader("sign", sign);

            //第四步：发送HttpPost请求，获取返回值
            returnValue = httpClient.execute(httpPost, responseHandler); //调接口获取返回值时，必须用此方法
            //         CloseableHttpResponse httpResonse = httpClient.execute(httpPost);
            //         int statusCode = httpResonse.getStatusLine().getStatusCode();
            //         if(statusCode!=200)
            //         {
            //              System.out.println("请求发送失败，失败的返回参数为："+httpResonse.getStatusLine());
            //              returnValue = httpResonse.getStatusLine().toString();
            //         }
            //

        } catch(Exception e) {
            e.printStackTrace();
        }finally {
            try {
                httpClient.close();
            } catch(IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        //第五步：处理返回值
        return returnValue;*/


        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        HttpPost post = new HttpPost(url);
//        JsonObject jsonObject = null;
        String result = null;
        try (CloseableHttpClient closeableHttpClient = httpClientBuilder.build()) {
            //设置超时时间
            RequestConfig requestConfig = RequestConfig.custom()
                    .setSocketTimeout(5000)
                    .setConnectTimeout(5000)
                    .setConnectionRequestTimeout(5000)
                    .build();
            post.setConfig(requestConfig);
            // 修复 POST json 导致中文乱码
            HttpEntity entity = new StringEntity(json, "UTF-8");
            post.setEntity(entity);
            post.setHeader("content-type", "application/json");
            String sign = ApiInterfaceValid.sign(signKey, json);
            post.setHeader("sign", sign);
            HttpResponse resp = closeableHttpClient.execute(post);
            
            InputStream respIs = resp.getEntity().getContent();
            byte[] respBytes = IOUtils.toByteArray(respIs);
            result = new String(respBytes, Charset.forName("UTF-8"));
            
//            jsonObject = convertResponseBytes2JsonObj(resp);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Header 为 application/json POST 请求数据
     *
     * @param resp
     * @return {@link JSONObject}
     */
    private static JSONObject convertResponseBytes2JsonObj(HttpResponse resp) {

        JSONObject jsonObject = null;
        try {
            InputStream respIs = resp.getEntity().getContent();
            byte[] respBytes = IOUtils.toByteArray(respIs);
            String result = new String(respBytes, Charset.forName("UTF-8"));
            if (null == result || result.length() == 0) {
                // TODO
                System.err.println("无响应");
            } else {
                System.out.println(result);
                if (result.startsWith("{") && result.endsWith("}")) {
                    jsonObject = JSONObject.parseObject(result);
                } else {
                    // TODO
                    System.err.println("不能转成JSON对象");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
    
    public static void main(String[] args) {

        //        String charset = "utf-8";
        ////        String url = "http://www.baidu.com";
        //        String url = "http://localhost:8080/autoPay/v3/pay/send";
        //        Map<String, String> map = new HashMap<String, String>();
        //        map.put("name", "hello");
        //        String result = doPost(url, map, charset);
        //        System.out.println("+++++++++++++"+result);

        try {
            JSONObject json = new JSONObject();
            json.put("platformUserNo", "3000000001015");
            json.put("orderType", "4001");
            json.put("orderSource", "1");
            json.put("orgCode", "xwbank");
            String url = "http://10.1.20.113:8096/ordersys/v2/order/selectDownOrder";
            String result = doPostWithJson(url, json.toString());
            System.out.println("result++++++++++++" + result);
        } catch(Exception e) {
            System.out.println("error+++++++++++++++++");
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}