package com.test;

import java.util.Date;

public class HttpMessage {

	private String messageId;
	private String account;
	private String content;
	private int state; // 0：创建中 1:等待审核 2：等待发送 3：发送中 4：发送完毕 5：审核驳回 6：取消
	private long createTime;
	private String mobile;
	private int needReport;
	private int status;
	private int productId;
	private String srcCode;
	private int originalProductId;
	private String extno;
	private int submitType; // 提交的类型 1：web提交 2:单发接口提交 3:群发接口提交 4：cmpp接口提交
	private int accountType; // 类型 1：行业，2：营销
	private int mobileCount;// 号码数量
	private Date delay;
	private String signatureLength;// 产品通道签名长度
	// 拦截敏感词
	private String interceptKeyWord;
	// 批次
	private String monthSeq;
	// 是否统计网址点击数
	private int isCountUrl;
	// 短信中的网址
	private String contentUrl;
	
	public int getIsCountUrl() {
		return isCountUrl;
	}

	public void setIsCountUrl(int isCountUrl) {
		this.isCountUrl = isCountUrl;
	}

	public String getContentUrl() {
		return contentUrl;
	}

	public void setContentUrl(String contentUrl) {
		this.contentUrl = contentUrl;
	}

	public String getMonthSeq() {
		return monthSeq;
	}

	public void setMonthSeq(String monthSeq) {
		this.monthSeq = monthSeq;
	}

	public String getInterceptKeyWord() {
		return interceptKeyWord;
	}

	public void setInterceptKeyWord(String interceptKeyWord) {
		this.interceptKeyWord = interceptKeyWord;
	}

	public String getSignatureLength() {
		return signatureLength;
	}

	public void setSignatureLength(String signatureLength) {
		this.signatureLength = signatureLength;
	}

	public Date getDelay() {
		return delay;
	}

	public void setDelay(Date delay) {
		this.delay = delay;
	}

	public int getAccountType() {
		return accountType;
	}

	public void setAccountType(int accountType) {
		this.accountType = accountType;
	}

	public int getMobileCount() {
		return mobileCount;
	}

	public void setMobileCount(int mobileCount) {
		this.mobileCount = mobileCount;
	}

	public int getSubmitType() {
		return submitType;
	}

	public void setSubmitType(int submitType) {
		this.submitType = submitType;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getNeedReport() {
		return needReport;
	}

	public void setNeedReport(int needReport) {
		this.needReport = needReport;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getSrcCode() {
		return srcCode;
	}

	public void setSrcCode(String srcCode) {
		this.srcCode = srcCode;
	}

	public int getOriginalProductId() {
		return originalProductId;
	}

	public void setOriginalProductId(int originalProductId) {
		this.originalProductId = originalProductId;
	}

	public String getExtno() {
		return extno;
	}

	public void setExtno(String extno) {
		this.extno = extno;
	}

	@Override
	public String toString() {
		return "HttpMessage{" +
				"messageId='" + messageId + '\'' +
				", account='" + account + '\'' +
				", content='" + content + '\'' +
				", state=" + state +
				", createTime=" + createTime +
				", mobile='" + mobile + '\'' +
				", needReport=" + needReport +
				", status=" + status +
				", productId=" + productId +
				", srcCode='" + srcCode + '\'' +
				", originalProductId=" + originalProductId +
				", extno='" + extno + '\'' +
				", submitType=" + submitType +
				", accountType=" + accountType +
				", mobileCount=" + mobileCount +
				", delay=" + delay +
				", signatureLength='" + signatureLength + '\'' +
				", interceptKeyWord='" + interceptKeyWord + '\'' +
				", monthSeq='" + monthSeq + '\'' +
				", isCountUrl=" + isCountUrl +
				", contentUrl='" + contentUrl + '\'' +
				'}';
	}
}
