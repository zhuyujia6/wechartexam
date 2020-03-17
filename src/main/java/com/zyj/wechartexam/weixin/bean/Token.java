package com.zyj.wechartexam.weixin.bean;

import java.io.Serializable;
/**
 * 凭证类
 */
public class Token implements Serializable{
    /**
     * serialVersionUID
     */
    // private static final long serialVersionUID = -4835642205781591045L;
    //token值
    private String accessToken;
    //token时间（7200s）
    private int expiresIn;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }

    public Token(String accessToken, int expiresIn) {
        super();
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
    }

    public Token() {
        super();
    }

    @Override
    public String toString() {
        return "Token [accessToken=" + accessToken + ", expiresIn=" + expiresIn
                + "]";
    }

}
