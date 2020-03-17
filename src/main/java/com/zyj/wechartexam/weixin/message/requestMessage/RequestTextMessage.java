package com.zyj.wechartexam.weixin.message.requestMessage;

/**
 * 文本消息( 普通用户 -> 公众号)
 * @author Zhu YuJia
 */
public class RequestTextMessage extends RequestBaseMessage {
	
	private static final long serialVersionUID = -438155639160659332L;
	//文本消息内容
	private String content;

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
