package com.zyj.wechartexam.weixin.message.requestMessage;

import java.io.Serializable;

/**
 * 请求消息基类 ( 普通用户 -> 公众号)
 * @author Zhu YuJia
 */
public class RequestBaseMessage implements Serializable {

	private static final long serialVersionUID = -846055746108179739L;
	//开发者微信号
	private String toUserName;
	//发送方帐号（一个OpenID）
	private String fromUserName;
	//消息创建时间 （整型）
	private long createTime;
	//text
	private String msgType;
	//消息id，64位整型
	private long msgId;

	public String getToUserName() {
		return toUserName;
	}

	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	public String getFromUserName() {
		return fromUserName;
	}

	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public long getMsgId() {
		return msgId;
	}

	public void setMsgId(long msgId) {
		this.msgId = msgId;
	}

	@Override
	public String toString() {
		return "BaseMessage [toUserName=" + toUserName + ", fromUserName="
				+ fromUserName + ", createTime=" + createTime + ", msgType="
				+ msgType + ", msgId=" + msgId + "]";
	}

}
