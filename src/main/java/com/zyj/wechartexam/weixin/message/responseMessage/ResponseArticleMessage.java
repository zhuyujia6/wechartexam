package com.zyj.wechartexam.weixin.message.responseMessage;

import com.sun.xml.internal.txw2.annotation.XmlCDATA;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


/**
 * 图文( 公众号 -> 普通用户)
 * @XmlRootElement 将一个Java类映射为一段XML的根节点
 * @author zhuyujia
 */
@XmlRootElement(name="xml")
public class ResponseArticleMessage extends ResponseBaseMessage {
	private static final long serialVersionUID = -8394757962899674624L;
	//多条图文消息信息，默认第一个item为大图,注意，如果图文数超过8，则将会无响应
	private List<ResponseArticle> articles;
	//图文消息个数，限制为8条以内
	private int articleCount;
	
	@XmlElementWrapper(name="Articles") 
	@XmlElement(name="item")
	public List<ResponseArticle> getArticles() {
		return articles;
	}

	public void setArticles(List<ResponseArticle> articles) {
		this.articles = articles;
	}
	@XmlCDATA
	@XmlElement(name="ArticleCount")
	public int getArticleCount() {
		return articleCount;
	}

	public void setArticleCount(int articleCount) {
		this.articleCount = articleCount;
	}

	@Override
	public String toString() {
		return "ResponseArticleMessage [articles=" + articles
				+ ", articleCount=" + articleCount + "]";
	}

	
}
