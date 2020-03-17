package com.zyj.wechartexam.weixin.utils;

import com.alibaba.druid.util.StringUtils;
import com.zyj.wechartexam.weixin.bean.Token;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@Component
public class HttpsRequestUtil {
    Logger logger= LoggerFactory.getLogger(HttpsRequestUtil.class);
    /*@Autowired
    public void setCacheUtil(CacheUtil cacheUtil){
        HttpsRequestUtil.cacheUtil = cacheUtil;
    }*/



    /**
     * 发送https请求
     * @param requestUrl	请求地址
     * @param requestMethod		请求方式
     * @param message	提交的数据
     * @return
     */
    public static JSONObject httpsRequest(String requestUrl,String requestMethod,String message){
        JSONObject json=null;
        try {
            //创建SSLContext对象
            TrustManager[] tm={new MyX509TrustManager()};
            SSLContext ssl=SSLContext.getInstance("SSL", "SunJSSE");
            ssl.init(null, tm, new java.security.SecureRandom());
            //从ssl对象中得到SSLSocketFactory对象
            SSLSocketFactory ssf=ssl.getSocketFactory();

            URL urlGet = new URL(requestUrl);
            HttpsURLConnection http = (HttpsURLConnection) urlGet
                    .openConnection();
            http.setSSLSocketFactory(ssf);
            http.setDoOutput(true);
            http.setDoInput(true);
            http.setUseCaches(false);
            http.setRequestMethod(requestMethod); // 设置请求方式

            System.setProperty("sun.net.client.defaultConnectTimeout", "30000");// 连接超时30秒
            System.setProperty("sun.net.client.defaultReadTimeout", "30000"); // 读取超时30秒
            if(message!=null){
                OutputStream outputStream=http.getOutputStream();
                outputStream.write(message.getBytes("UTF-8"));
                outputStream.close();
            }
            //从输入流中读取返回内容
            InputStream is = http.getInputStream();
            InputStreamReader inputStreamReader=new InputStreamReader(is,"utf-8");
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            String str=null;
            StringBuffer buffer=new StringBuffer();
            while((str=bufferedReader.readLine())!=null){
                buffer.append(str);
            }

            //释放资源
            inputStreamReader.close();
            bufferedReader.close();
            is.close();
            is=null;
            http.disconnect();

            json=JSONObject.fromObject(buffer.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }

    /**
     * 获取接口访问凭证
     * @return
     */
    @Autowired
    CacheUtil cacheUtil;
    public  Token getToken() {
        Logger logger= LoggerFactory.getLogger(HttpsRequestUtil.class);
        // 先读取缓存，存在直接返回
        String access_token = cacheUtil.getCacheValue("wx_access_token");
        if(!StringUtils.isEmpty(access_token)) {
            Token token = new Token();
            token.setAccessToken(access_token);
            return token;
        }
        Token token = null;
        String requestUrl = WeiXinBasicKey.TOKEN_URL.replace("APPID", WeiXinBasicKey.APPID).replace("APPSECRET", WeiXinBasicKey.APPSECRET);
        // 发起GET请求获取凭证
        JSONObject jsonObject = httpsRequest(requestUrl, "GET", null);
        logger.info(jsonObject.toString());
        if (null != jsonObject) {
            try {
                token = new Token();
                token.setAccessToken(jsonObject.getString("access_token"));
                token.setExpiresIn(jsonObject.getInt("expires_in"));
                //token写入缓存
                cacheUtil.setCacheValue("wx_access_token", jsonObject.getString("access_token"), jsonObject.getInt("expires_in"), TimeUnit.SECONDS);
            } catch (JSONException e) {
                token = null;
                // 获取token失败
                logger.error("获取token失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"),jsonObject.getString("errmsg"));
            }
        }
        return token;
    }
}



