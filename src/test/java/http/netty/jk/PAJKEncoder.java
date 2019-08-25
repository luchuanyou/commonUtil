package http.netty.jk;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: lucy
 * @date: 2019/08/15
 */
public class PAJKEncoder {
    /**
     * 版本号
     */
    private static final String VERSION = "0.1.0";
    /**
     * 用户名
     */
    protected String name;
    /**
     * 密钥
     */
    protected String key;
    /**
     * 平安好医生apidId
     */
    private String apiId;
    /**
     * 请求参数缓存
     */
    private Map<String, String> paramsMap;
    /**
     * 添加请求参数
     */
    private List<String> addPrams = new ArrayList();



    public PAJKEncoder(String name, String key, String apiId) {
        this.name = name;
        this.key = key;
        this.apiId = apiId;
        this.paramsMap = new HashMap();
    }

    /**
     * 加密
     * @return
     */
    public PAJKRequestEntity encode() {
        Map<String, String> m = new HashMap(this.paramsMap);
        m.put("__o_s", this.apiId);
        m.put("__o_v", this.VERSION);

        /**
         * 添加额外参数
         */
        for(int i = 0; i < this.addPrams.size(); ++i) {
            m.put("arg" + (i + 1), this.addPrams.get(i));
        }

        String qs = PAJKUtil.toSortString(m);
        String salt = PAJKUtil.nextRandomFloat();
        if (qs == null) {
            return null;
        } else {
            qs = PAJKDESUtil.encryptHex(qs, this.key);
            String hmac = null;

            try {
                hmac = PAJKSHAUtil.sha1HString(qs, this.key, salt);
            } catch (Exception var6) {
                return null;
            }

            m.clear();
            m.put("q", qs);
            return new PAJKRequestEntity(String.format("p=%s&v=%s&s=%s&h=%s", this.name, this.VERSION, salt, hmac), m);
        }
    }

    /**
     * 设置参数
     * @param value
     */
    public void putParameter(Object value) {
        String name = "arg1";
        if (value != null) {
            boolean b = ClassTypeUtil.isSimpleObject(value);
            if (b) {
                this.paramsMap.put(name, value.toString());
            } else {
                this.paramsMap.put(name, JSON.toJSONString(value));
            }
        }
    }

    /**
     * 添加参数
     * @param value
     */
    public synchronized void addParameter(Object value) {
        if (value != null) {
            boolean b = ClassTypeUtil.isSimpleObject(value);
            if (b) {
                this.addPrams.add(value.toString());
            } else {
                this.addPrams.add(JSON.toJSONString(value));
            }
        }
    }

}
