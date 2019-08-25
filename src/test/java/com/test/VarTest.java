package com.test;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VarTest {

    public static void main(String[] args) {
        String msg = "【上{$var}海】hello{$var},{$var}";
        String[] params = new String[]{"13761014257,a,b,c,d","13761014250,1,2,3,4"};
        Map<String, Object> map = varMessage(msg, params);
        System.out.println(map);
    }
    /**
     * 变量短信拼接
     *
     * @param msg    常量模板
     * @param params 变量参数组
     * @return
     */
    public static Map<String, Object> varMessage(String msg, String[] params) {
        int k = 0;
        int index = 0;
        String findText = "{$var}";
        while ((index = msg.indexOf(findText, index)) != -1) {
            index = index + findText.length();
            k++;
        }
        Map<String, Object> map = new HashMap<String, Object>();
        // 拼接好的短信体
        List<HttpMessage> msglist = new ArrayList<HttpMessage>();
        if (0 == k || k > 100) {
            map.put("msg", msglist);
            return map;
        }
        int failNum = 0;
        // 变量短信参数
        for (String con : params) {
            String[] split = con.split(",");
            if (split.length - 1 >= k) {
                String vContent = msg;
                // 拼接出内容号码然后塞入短信体中
                HttpMessage message = new HttpMessage();

                String mobile = split[0];
                /*if (!RegexUtil.match_11(mobile) && !RegexUtil.match_13(mobile)) {
                    // 号码不对记录失败数+1
                    failNum++;
                    continue;
                } else {
                    message.setMobile(mobile);
                }*/
                message.setMobile(mobile);
                for (int j = 1; j <= k; j++) {
                    String repValue = split[j];
                    if (repValue.contains("$")) {
                        repValue = StringUtils.replace(split[j], "$", "");
                    }
                    if (repValue.contains("\\")) {
                        repValue = StringUtils.replace(split[j], "\\", "");
                    }
                    vContent = StringUtils.replaceOnce(vContent, "{$var}", repValue);
                }
                message.setContent(vContent);
                msglist.add(message);
            } else {
                // 参数组不对记录失败数+1
                failNum++;
            }
        }
        map.put("msg", msglist);
        map.put("failNum", failNum);
        return map;
    }
}
