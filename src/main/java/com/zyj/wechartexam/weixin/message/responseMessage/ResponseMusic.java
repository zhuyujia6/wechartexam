package com.zyj.wechartexam.weixin.message.responseMessage;

import com.sun.xml.internal.txw2.annotation.XmlCDATA;

import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;


/**
 * 音乐
 * @author Zhu YuJia
 */
public class ResponseMusic implements Serializable{

	private static final long serialVersionUID = 2446899669854170184L;
	//音乐标题
	private String title;
	//音乐描述
	private String description;
	//音乐链接
	private String musicUrl;
	//高质量音乐链接，WIFI环境优先使用该链接播放音乐
	private String hqMusicUrl;
	//缩略图的媒体id，通过素材管理中的接口上传多媒体文件，得到的id
	private String thumbMediaId;
		
	public ResponseMusic() {
		super();
	}

	public ResponseMusic(String title, String description, String musicUrl,
			String hqMusicUrl, String thumbMediaId) {
		super();
		this.title = title;
		this.description = description;
		this.musicUrl = musicUrl;
		this.hqMusicUrl = hqMusicUrl;
		this.thumbMediaId = thumbMediaId;
	}

	@XmlCDATA
	@XmlElement(name = "Title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	@XmlCDATA
	@XmlElement(name = "Description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	@XmlCDATA
	@XmlElement(name = "MusicUrl")
	public String getMusicUrl() {
		return musicUrl;
	}

	public void setMusicUrl(String musicUrl) {
		this.musicUrl = musicUrl;
	}
	@XmlCDATA
	@XmlElement(name = "HQMusicUrl")
	public String getHqMusicUrl() {
		return hqMusicUrl;
	}

	public void setHqMusicUrl(String hqMusicUrl) {
		this.hqMusicUrl = hqMusicUrl;
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
		return "Music [title=" + title + ", description=" + description
				+ ", musicUrl=" + musicUrl + ", hqMusicUrl=" + hqMusicUrl
				+ ", thumbMediaId=" + thumbMediaId + "]";
	}

}
