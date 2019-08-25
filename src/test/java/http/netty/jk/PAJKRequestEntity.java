package http.netty.jk;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;

/**
 * @Description:
 * @Author: lucy
 * @date: 2019/08/15
 */
public class PAJKRequestEntity implements Serializable {
    private static final long serialVersionUID = 6012628544191299319L;
    /**
     * 请求参数
     */
    private String queryParams;
    /**
     * 请求body
     */
    private Map<String, String> formParams;


    public PAJKRequestEntity(String queryParams, Map<String, String> formParams) {
        this.queryParams = queryParams;
        this.formParams = formParams;
    }

    /**
     * 格式化请求参数
     * @return
     */
    public Map<String, String> getFormParams() {
        return this.formParams;
    }

    public String getQueryParams() {
        return queryParams;
    }

    public void setQueryParams(String queryParams) {
        this.queryParams = queryParams;
    }

    public void setFormParams(Map<String, String> formParams) {
        this.formParams = formParams;
    }
}
