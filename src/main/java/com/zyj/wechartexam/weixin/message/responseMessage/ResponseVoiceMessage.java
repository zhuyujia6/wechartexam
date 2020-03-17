package com.zyj.wechartexam.weixin.message.responseMessage;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 声音消息( 公众号 -> 普通用户)
 * @author Zhu YuJia
 */
@XmlRootElement(name = "xml")
public class ResponseVoiceMessage extends ResponseBaseMessage {
	
	private static final long serialVersionUID = -4231819887126618962L;
	private ResponseVoice voice;

	@XmlElement(name="Voice")
	public ResponseVoice getVoice() {
		return voice;
	}

	public void setVoice(ResponseVoice voice) {
		this.voice = voice;
	}

	@Override
	public String toString() {
		return "VoiceMessage [voice=" + voice + ", toString()="
				+ super.toString() + "]";
	}

	public ResponseVoiceMessage(String toUserName, String fromUserName,
			long createTime, String msgType, ResponseVoice voice) {
		super(toUserName, fromUserName, createTime, msgType);
		this.voice = voice;
	}

	public ResponseVoiceMessage() {
		super();
	}
	
	
}
