package com.zyj.wechartexam.weixin.message.responseMessage;

import com.sun.xml.internal.txw2.annotation.XmlCDATA;

import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;


/**
 * 声音消息
 * @author Zhu YuJia
 */
public class ResponseVoice implements Serializable {
	
	private static final long serialVersionUID = -3569793565568417077L;
	//通过素材管理中的接口上传多媒体文件，得到的id
	private String mediaId;

	public ResponseVoice(String mediaId) {
		super();
		this.mediaId = mediaId;
	}

	public ResponseVoice() {
		super();
	}

	@XmlCDATA
	@XmlElement(name = "MediaId")
	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	@Override
	public String toString() {
		return "Voice [mediaId=" + mediaId + "]";
	}

}
