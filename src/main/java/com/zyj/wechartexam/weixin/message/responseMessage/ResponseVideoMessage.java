package com.zyj.wechartexam.weixin.message.responseMessage;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 视频消息( 公众号 -> 普通用户)
 * @author Zhu YuJia
 */

@XmlRootElement(name = "xml")
public class ResponseVideoMessage extends ResponseBaseMessage {
	
	private static final long serialVersionUID = 6016439185608293450L;
	private ResponseVideo video;

	@XmlElement(name = "Video")
	public ResponseVideo getVideo() {
		return video;
	}

	public void setVideo(ResponseVideo video) {
		this.video = video;
	}

	@Override
	public String toString() {
		return "VideoMessage [video=" + video + ", toString()="
				+ super.toString() + "]";
	}

	public ResponseVideoMessage() {
		super();
	}

	public ResponseVideoMessage(String toUserName, String fromUserName,
			long createTime, String msgType, ResponseVideo video) {
		super(toUserName, fromUserName, createTime, msgType);
		this.video = video;
	}

}
