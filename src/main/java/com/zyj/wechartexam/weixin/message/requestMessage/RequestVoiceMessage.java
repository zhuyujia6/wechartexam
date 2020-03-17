package com.zyj.wechartexam.weixin.message.requestMessage;

/**
 * 语言消息( 普通用户 -> 公众号)
 * @author Zhu YuJia
 */
public class RequestVoiceMessage extends RequestBaseMessage {
	
	private static final long serialVersionUID = -1406155930612358773L;
	//语音消息媒体id，可以调用多媒体文件下载接口拉取该媒体
	private String mediaId;
	//语音格式：amr
	private String format;
	//语音识别结果，UTF8编码
	private String recognition;

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getRecognition() {
		return recognition;
	}

	public void setRecognition(String recognition) {
		this.recognition = recognition;
	}

	@Override
	public String toString() {
		return "VoiceMessage [mediaId=" + mediaId + ", format=" + format
				+ ", recognition=" + recognition + ", toString()="
				+ super.toString() + "]";
	}

}
