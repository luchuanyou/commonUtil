package json;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Description:
 * @Author: lucy
 * @date: 2019/07/26
 */
public class ResponseJsonDto {
    //接收请求参数首字母大写（接口请求参数）
    @JsonProperty("Mobile")
    private String Mobile;

    //输出结果首字母大写
    @JSONField(name="Mobile")
    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }
}
