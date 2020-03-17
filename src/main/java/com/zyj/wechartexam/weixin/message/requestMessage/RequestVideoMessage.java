package com.zyj.wechartexam.weixin.message.requestMessage;

/**
 * 视频消息( 普通用户 -> 公众号)
 * @author Zhu YuJia
 */
public class RequestVideoMessage extends RequestBaseMessage {
	
	private static final long serialVersionUID = -2732941298413350183L;
	//视频消息媒体id，可以调用多媒体文件下载接口拉取数据。
	private String mediaId;
	//视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。
	private String thumbMediaId;

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getThumbMediaId() {
		return thumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}

	@Override
	public String toString() {
		return "VideoMessage [mediaId=" + mediaId + ", thumbMediaId="
				+ thumbMediaId + ", toString()=" + super.toString() + "]";
	}

}
