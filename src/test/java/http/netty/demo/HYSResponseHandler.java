package http.netty.demo;


import com.alibaba.fastjson.JSON;
import http.netty.CallbackHandler;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.util.EntityUtils;

import java.util.Map;

public class HYSResponseHandler implements CallbackHandler<Object>{
    @Override
    public void failed(Exception e) {
        System.out.println(e);
    }

    @Override
    public void completed(Object callback) {
        try {
            HttpResponse response = (HttpResponse) callback;
            //浏览器状态码
            int statusCode = response.getStatusLine().getStatusCode();
            if(statusCode == HttpStatus.SC_OK){
                String result = EntityUtils.toString(response.getEntity(), "utf-8");
                System.out.println(result);
                /*Map map = JSON.parseObject(result, Map.class);
                System.out.println("completed map:"+map);*/

                parseResult(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void cancelled() {

    }
    /**
     * 解析返回值，如果返回code值不成功，重新推送状态报告
     * @param result
     */
    private void parseResult(String result) {
        try {
            Map<?, ?> resultMap = convertStringToMap(result);
            if(MapUtils.isEmpty(resultMap)){
                return;
            }
            if ("111111".equals(String.valueOf(resultMap.get("clcode")))) {
                //返回失败，重新推送
                System.out.println("失败了===============");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * String转换成map
     * @param result
     * @return null：转换失败
     */
    private Map<?, ?> convertStringToMap(String result) {
        try {
            if(StringUtils.isEmpty(result)){
                return null;
            }
            return JSON.parseObject(result, Map.class);
        } catch (Exception e) {
            System.out.println("json转换失败");
            return null;
        }
    }
}
