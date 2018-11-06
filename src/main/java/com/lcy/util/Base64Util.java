package com.lcy.util;

import org.apache.commons.codec.binary.Base64;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 */
public class Base64Util {

    public static void main(String[] args) throws Exception {
        //在线图片地址
        String url = "http://192.168.1.112:8888/group1/M00/00/00/wKgBcFtsARWAMlVeAACeGR3XUgM750.PNG";

        String urlStr = Base64Util.ImageToBase64ByOnline(url);

        System.out.println(urlStr);
    }

    /**
     * 在线图片转换成base64字符串
     *
     * @param imgURL
     * @return
     */
    public static String ImageToBase64ByOnline(String imgURL) {
        ByteArrayOutputStream data = new ByteArrayOutputStream();
        try {
            // 创建URL
            URL url = new URL(imgURL);
            byte[] by = new byte[1024];
            // 创建链接
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            InputStream is = conn.getInputStream();
            // 将内容读取内存中
            int len = -1;
            while ((len = is.read(by)) != -1) {
                data.write(by, 0, len);
            }
            // 关闭流
            is.close();
            String result = new String(Base64.encodeBase64(data.toByteArray()), "utf-8");
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
