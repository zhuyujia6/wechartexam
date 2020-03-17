package com.zyj.wechartexam.weixin.message.responseMessage;

import com.sun.xml.internal.txw2.annotation.XmlCDATA;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * 图文
 * @XmlType 定义映射的一些相关规则
 * @author zhuyujia
 */

@XmlRootElement(name="xml")
public class ResponseArticle implements Serializable{
	
	private static final long serialVersionUID = 1612729470156778730L;
	//图文消息名称
	private String title;
	//图文消息描述
	private String description;
	//图片链接，支持jpg，png格式，较好的效果大图为640x320，小的80x60
	private String picUrl;
	//点击图文消息跳转链接
	private String url;
	
	public ResponseArticle() {
	}
	
	@XmlElement(name="Title")
	@XmlCDATA
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	@XmlCDATA
	@XmlElement(name = "Description")
	public String getDescription() {
		return null ==description ?"":description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@XmlCDATA
	@XmlElement(name = "PicUrl")
	public String getPicUrl() {
		return null==picUrl?"":picUrl;
	}
	
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	
	@XmlCDATA
	@XmlElement(name = "Url")
	public String getUrl() {
		return null==url?"":url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	@Override
	public String toString() {
		return "Article [title=" + title + ", description=" + description
				+ ", picUrl=" + picUrl + ", url=" + url + "]";
	}
	
}
