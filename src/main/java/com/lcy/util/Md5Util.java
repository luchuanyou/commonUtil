package com.lcy.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 */
public class Md5Util {
    public static void main(String[] args) {
        try {
            System.out.println(encoderByMd5("123"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 利用MD5进行加密
     * @param data 待加密字符串
     * @return 加密后的字符串
     * @throws Exception
     */
    public static String encoderByMd5(String data) throws Exception{
        /*//确定计算方法
        MessageDigest md5=MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        //加密后的字符串
        String newstr=base64en.encode(md5.digest(data.getBytes("utf-8")));*/
        return DigestUtils.md5Hex(data);
    }
}
