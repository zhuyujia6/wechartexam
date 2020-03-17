package com.zyj.wechartexam.weixin.message.requestMessage;

/**
 * 链接消息( 普通用户 -> 公众号)
 * @author Zhu YuJia
 */
public class RequestLinkMessage extends RequestBaseMessage {
	
	private static final long serialVersionUID = 6561640248454205181L;
	//消息标题
	private String title;
	//消息描述
	private String description;
	//消息链接
	private String url;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "LinkMessage [title=" + title + ", description=" + description
				+ ", url=" + url + ", toString()=" + super.toString() + "]";
	}

}
