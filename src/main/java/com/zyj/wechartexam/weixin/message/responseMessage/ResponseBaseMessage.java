package com.zyj.wechartexam.weixin.message.responseMessage;

import com.sun.xml.internal.txw2.annotation.XmlCDATA;

import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;


/**
 * 响应消息基类( 公众号 -> 普通用户)
 * @author Zhu YuJia
 */
public class ResponseBaseMessage implements Serializable {
	
	private static final long serialVersionUID = 7436421526132006180L;
	//接收方帐号（收到的OpenID）
	private String toUserName;
	//开发者微信号
	private String fromUserName;
	//消息创建时间 （整型）
	private long createTime;
	//消息类型
	private String msgType;

	public ResponseBaseMessage() {
		super();
	}

	public ResponseBaseMessage(String toUserName, String fromUserName, long createTime,
			String msgType) {
		super();
		this.toUserName = toUserName;
		this.fromUserName = fromUserName;
		this.createTime = createTime;
		this.msgType = msgType;
	}

	@XmlElement(name = "ToUserName")
	@XmlCDATA
	public String getToUserName() {
		return toUserName;
	}

	public void setToUserName(String fromUserName) {
		this.toUserName = fromUserName;
	}

	@XmlElement(name = "FromUserName")
	@XmlCDATA
	public String getFromUserName() {
		return fromUserName;
	}

	public void setFromUserName(String toUserName) {
		this.fromUserName = toUserName;
	}

	@XmlElement(name = "CreateTime")
	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	@XmlElement(name = "MsgType")
	@XmlCDATA
	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	@Override
	public String toString() {
		return "BaseMessage [toUserName=" + toUserName + ", fromUserName="
				+ fromUserName + ", createTime=" + createTime + ", msgType="
				+ msgType + "]";
	}

}
