package com.zyj.wechartexam.weixin.message.responseMessage;

/**
 * 文本消息( 公众号 -> 普通用户)
 * @author Zhu YuJia
 */

import com.sun.xml.internal.txw2.annotation.XmlCDATA;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "xml")
public class ResponseTextMessage extends ResponseBaseMessage {
	
	private static final long serialVersionUID = 4661170994570854546L;
	
	private String content;

	public ResponseTextMessage() {
		super();
	}

	public ResponseTextMessage(String toUserName, String fromUserName, long createTime,
			String msgType, String content) {
		super(toUserName, fromUserName, createTime, msgType);
		this.content = content;
	}
	@XmlElement(name="Content")
	@XmlCDATA
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "TextMessage [content=" + content + ", toString()="
				+ super.toString() + "]";
	}

	
	
	

}
