package http.netty.demo;

import java.io.Serializable;

/**
 * @Auther: CHENBANGWEN103
 * @Date: 2019/8/12 10:01
 * @Description:
 */
public class SpSignAuditResult implements Serializable {
    private String spName;//短信供应商的名称缩写
    private String spAccount;//帐号
    private String signName;//签名
    private String result;//审核结果(1:通过，0:不能过）
    private String causeDesc;//原因描述（当审核不通过时，不能为空）
    private String ext;

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getSpName() {
        return spName;
    }

    public void setSpName(String spName) {
        this.spName = spName;
    }

    public String getSpAccount() {
        return spAccount;
    }

    public void setSpAccount(String spAccount) {
        this.spAccount = spAccount;
    }

    public String getSignName() {
        return signName;
    }

    public void setSignName(String signName) {
        this.signName = signName;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getCauseDesc() {
        return causeDesc;
    }

    public void setCauseDesc(String causeDesc) {
        this.causeDesc = causeDesc;
    }
}
