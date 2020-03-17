package com.zyj.wechartexam.weixin.utils;


import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.ByteArrayRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;


/**
 *
 * Title: Sendnewssucai
 * Description:上传素材
 * @author Zhu YuJia
 */
public class SendNewsSuCai {
    /**
     * 上传素材
     * @param uploadurl piurl
     * @param access_token
     *   访问token
     * @param data
     *  提交数据
     * @return
     */

    @SuppressWarnings("finally")
    public static String uploadFodder(String uploadurl, String access_token, String data) {

        HttpClient client = new HttpClient();
        String posturl = String.format("%s?access_token=%s", uploadurl, access_token);
        PostMethod post = new PostMethod(posturl);
        post.setRequestHeader("User-Agent",
                "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.9; rv:30.0) Gecko/20100101 Firefox/30.0");
        post.setRequestHeader("Host", "file.api.weixin.qq.com");
        post.setRequestHeader("Connection", "Keep-Alive");
        post.setRequestHeader("Cache-Control", "no-cache");
        String result = null;
        try {
            post.setRequestEntity(new ByteArrayRequestEntity(data.getBytes()));

            int status = client.executeMethod(post);
            if (status == HttpStatus.SC_OK) {
                String responseContent = post.getResponseBodyAsString();
                System.out.println(responseContent);
                JsonParser jsonparer = new JsonParser();// 初始化解析json格式的对象
                JsonObject json = jsonparer.parse(responseContent).getAsJsonObject();
                if (json.get("errcode") == null) {// 正确 { "type":"news",
                    // "media_id":"CsEf3ldqkAYJAU6EJeIkStVDSvffUJ54vqbThMgplD-VJXXof6ctX5fI6-aYyUiQ","created_at":1391857799}
                    result = json.get("media_id").getAsString();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return result;
        }
    }

}
