package enums;

/**
 * @Description:
 * @Author: lucy
 * @date: 2019/04/15
 */
public enum ResultEnum {
    SUCCESS("000000", "成功"),
    ERROR("999999", "系统异常"),
    PARAM_IS_NULL("000001", "参数不能为空"),
    PARAM_IS_ERROR("000002", "参数错误"),
    DATA_IS_EXIST("000003", "数据已存在"),
    DATA_IS_NOT_EXIST("000004", "数据不存在")
            ;

    /**
     * 响应码
     */
    private String code;
    /**
     * 响应描述
     */
    private String message;

    ResultEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage(String msg) {
        return msg;
    }
}
