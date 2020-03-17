package com.zyj.wechartexam.weixin.message.responseMessage;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 音乐( 公众号 -> 普通用户)
 * @XmlRootElement 将一个Java类映射为一段XML的根节点
 * @author Zhu YuJia
 */
@XmlRootElement(name = "xml")
public class ResponseMusicMessage extends ResponseBaseMessage{

	private static final long serialVersionUID = -1719676403530219770L;
	
	private ResponseMusic music;

	@XmlElement(name = "Music")
	public ResponseMusic getMusic() {
		return music;
	}

	public void setMusic(ResponseMusic music) {
		this.music = music;
	}

	public ResponseMusicMessage(String toUserName, String fromUserName,
			long createTime, String msgType, ResponseMusic music) {
		super(toUserName, fromUserName, createTime, msgType);
		this.music = music;
	}

	public ResponseMusicMessage() {
		super();
	}

	@Override
	public String toString() {
		return "MusicMessage [music=" + music + "]";
	}
	
	
}
