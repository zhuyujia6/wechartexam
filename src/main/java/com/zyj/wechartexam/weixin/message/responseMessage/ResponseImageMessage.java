package com.zyj.wechartexam.weixin.message.responseMessage;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 图片消息( 公众号 -> 普通用户)
 * @author zhuyujia
 */
@XmlRootElement(name = "xml")
public class ResponseImageMessage extends ResponseBaseMessage {
	
	private static final long serialVersionUID = 5647745663421692585L;
	private ResponseImage image;

   @XmlElement(name="Image")
	public ResponseImage getImage() {
		return image;
	}

	public void setImage(ResponseImage image) {
		this.image = image;
	}

	public ResponseImageMessage(String toUserName, String fromUserName,
			long createTime, String msgType, ResponseImage image) {
		super(toUserName, fromUserName, createTime, msgType);
		this.image = image;
	}

	public ResponseImageMessage() {
		super();
	}

	@Override
	public String toString() {
		return "ImageMessage [image=" + image + ", toString()="
				+ super.toString() + "]";
	}
	
	
}
