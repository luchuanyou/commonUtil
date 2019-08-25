package http.netty;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;

import java.util.Map;

public class ResponseMapHandler implements CallbackHandler<Object>{
    @Override
    public void failed(Exception e) {
        System.out.println(e);
    }

    @Override
    public void completed(Object callback) {
        try {
            Map map = JSONObject.parseObject((String)callback, Map.class);
            System.out.println("返回结果:" + map);
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
