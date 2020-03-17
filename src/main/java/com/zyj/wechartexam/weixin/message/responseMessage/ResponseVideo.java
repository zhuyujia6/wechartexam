package com.zyj.wechartexam.weixin.message.responseMessage;

import com.sun.xml.internal.txw2.annotation.XmlCDATA;

import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;

/**
 * 视屏消息
 * @author Zhu YuJia
 */
public class ResponseVideo implements Serializable{
	
	private static final long serialVersionUID = -7540707269966233972L;
	//通过素材管理中的接口上传多媒体文件，得到的id
	private String mediaId;
	//缩略图的媒体id，通过素材管理中的接口上传多媒体文件，得到的id
	private String thumbMediaId;

	@XmlCDATA
	@XmlElement(name = "MediaId")
	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	@XmlCDATA
	@XmlElement(name = "ThumbMediaId")
	public String getThumbMediaId() {
		return thumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}

	@Override
	public String toString() {
		return "Video [mediaId=" + mediaId + ", thumbMediaId=" + thumbMediaId
				+ "]";
	}

	public ResponseVideo(String mediaId, String thumbMediaId) {
		super();
		this.mediaId = mediaId;
		this.thumbMediaId = thumbMediaId;
	}

	public ResponseVideo() {
		super();
	}
	
	
}
