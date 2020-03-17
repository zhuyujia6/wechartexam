package com.zyj.wechartexam.weixin.message.responseMessage;

import com.sun.xml.internal.txw2.annotation.XmlCDATA;

import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;


/**
 * 图片
 * @author Zhu YuJia
 */
public class ResponseImage implements Serializable{
	
	private static final long serialVersionUID = 6032301308958053903L;
	//通过素材管理中的接口上传多媒体文件，得到的id。
	private String mediaId;

	@Override
	public String toString() {
		return "Image [mediaId=" + mediaId + "]";
	}

	public ResponseImage() {
		super();
	}

	public ResponseImage(String mediaId) {
		super();
		this.mediaId = mediaId;
	}

	@XmlCDATA
	@XmlElement(name="MediaId")
	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

}
