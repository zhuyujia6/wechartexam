package com.zyj.wechartexam.weixin.message.requestMessage;

/**
 * 图片消息 ( 普通用户 -> 公众号)
 * @author Zhu YuJia
 */
public class RequestImageMessage extends RequestBaseMessage {
	
	private static final long serialVersionUID = -4785487223622543535L;
	//图片链接（由系统生成）
	private String picUrl;

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	@Override
	public String toString() {
		return "ImageMessage [picUrl=" + picUrl + ", toString()="
				+ super.toString() + "]";
	}

}
