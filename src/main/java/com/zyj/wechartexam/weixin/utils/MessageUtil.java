package com.zyj.wechartexam.weixin.utils;

import com.google.gson.Gson;
import com.zyj.wechartexam.weixin.message.responseMessage.*;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.ByteArrayRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import sun.plugin.dom.exception.WrongDocumentException;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.*;


/**
 *
 * Title: MessageUtil Description: 消息处理工具类
 *
 * @author Zhu YuJia
 * @date 2018年12月27日
 */
public class MessageUtil {

    Logger logger= LoggerFactory.getLogger(MessageUtil.class);

    @Autowired
    HttpsRequestUtil httpsRequestUtil;
    public static final String REQUEST_MESSAGE_TYPE_TEXT = "text";
    public static final String REQUEST_MESSAGE_TYPE_IMAGE = "image";
    public static final String REQUEST_MESSAGE_TYPE_VOICE = "voice";
    public static final String REQUEST_MESSAGE_TYPE_VIDEO = "video";
    public static final String REQUEST_MESSAGE_TYPE_LOCATION = "location";
    public static final String REQUEST_MESSAGE_TYPE_LINK = "link";
    public static final String REQUEST_MESSAGE_TYPE_EVENT = "event";

    // 订阅
    public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";
    public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";
    public static final String EVENT_TYPE_SCAN = "scan";
    public static final String EVENT_TYPE_LOCATION = "location";
    public static final String EVENT_TYPE_CLICK = "CLICK";

    public static final String RESPONSE_MESSAGE_TYPE_TEXT = "text";
    public static final String RESPONSE_MESSAGE_TYPE_IMAGE = "image";
    public static final String RESPONSE_MESSAGE_TYPE_VOICE = "voice";
    public static final String RESPONSE_MESSAGE_TYPE_VIDEO = "video";
    public static final String RESPONSE_MESSAGE_TYPE_MUSIC = "music";
    public static final String RESPONSE_MESSAGE_TYPE_NEWS = "news";

    /**
     * 解析微信服务器发过来的请求
     *
     * @param request
     * @return
     * @throws IOException
     */
    public static Map<String, String> parseXml(HttpServletRequest request) throws IOException,DocumentException, WrongDocumentException {
        Logger logger= LoggerFactory.getLogger(MessageUtil.class);
        Map<String, String> map = new HashMap<String, String>();
        InputStream inputStream = null;
        try {
            inputStream = request.getInputStream();
            SAXReader reader = new SAXReader();
            Document document = reader.read(inputStream);
            Element root = document.getRootElement();
            @SuppressWarnings("unchecked")
            List<Element> elementList = root.elements();
            for (Element e : elementList) {
                map.put(e.getName(), e.getText());
            }
        } catch (IOException e) {

            logger.error("解析微信服务器发过来的请求"+e.getMessage());
            throw e;
        } catch (DocumentException e) {
            logger.error("解析微信服务器发过来的请求"+e.getMessage());
            throw e;
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    logger.error("解析微信服务器发过来的请求错误"+e.getMessage());
                }
                inputStream = null;
            }
        }
        return map;
    }

    /**
     * 把回送给用户的信息转换成xml
     *
     * @return
     * @throws IOException
     * @throws DocumentException
     */
    private static String parseXmlStringFromObject(Object o) throws Exception {
        Logger logger= LoggerFactory.getLogger(MessageUtil.class);
        ByteArrayOutputStream baos = null;
        try {
            JAXBContext context = JAXBContext.newInstance(o.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            baos = new ByteArrayOutputStream();
            marshaller.marshal(o, baos);

            return baos.toString();
        } catch (Exception e) {
            logger.error("把回送给用户的信息转换成错误"+e.getMessage());
            throw e;
        } finally {
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    logger.error("把回送给用户的信息转换成错误"+e.getMessage());
                    throw e;
                }
            }
            baos = null;
        }
    }

    /**
     * 将文本消息转换成xml
     *
     * @param textMessage
     * @return
     * @throws Exception
     */
    public static String messageToXml(ResponseTextMessage textMessage) throws Exception {
        return parseXmlStringFromObject(textMessage);
    }

    /**
     * 将图片消息转换成xml
     *
     * @param imageMessage
     * @return
     * @throws Exception
     */
    public static String messageToXml(ResponseImageMessage imageMessage) throws Exception {
        return parseXmlStringFromObject(imageMessage);
    }

    /**
     * 将语音消息转换成xml
     *
     * @param voiceMessage
     * @return
     * @throws Exception
     */
    public static String messageToXml(ResponseVoiceMessage voiceMessage) throws Exception {
        return parseXmlStringFromObject(voiceMessage);
    }

    /**
     * 将视频消息转换成xml
     *
     * @param videoMessage
     * @return
     * @throws Exception
     */
    public static String messageToXml(ResponseVideoMessage videoMessage) throws Exception {
        return parseXmlStringFromObject(videoMessage);
    }

    /**
     * 将音乐消息转换成xml
     *
     * @param musicMessage
     * @return
     * @throws Exception
     */
    public static String messageToXml(ResponseMusicMessage musicMessage) throws Exception {
        return parseXmlStringFromObject(musicMessage);
    }

    /**
     * 将图文消息转换成xml
     *
     * @param articleMessage
     * @return
     * @throws Exception
     */
    public static String messageToXml(ResponseArticleMessage articleMessage) throws Exception {
        return parseXmlStringFromObject(articleMessage);
    }

    /**
     * emoji表情转换(hex -> utf-16)
     *
     * @param hexEmoji
     * @return
     */
    public static String emoji(int hexEmoji) {
        return String.valueOf(Character.toChars(hexEmoji));
    }

    /**
     * 内部类 实例化当前对象
     *
     */
    private static class Instance {
        private static final MessageUtil mu = new MessageUtil();
        private static String ACCESS_TOKEN = null;
    }

    /**
     * 暴露在外部的方法
     *
     * @return
     */
    public static MessageUtil getInstance() {
        return Instance.mu;
    }


    /**
     * 群发文本消息
     *
     * @param text
     * @return
     */
    public boolean messTextMessage(String text) {
        try {
            String resp = "";// 响应
            String reqUrl = "https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token="
                    + httpsRequestUtil.getToken().getAccessToken();
            try {
                // 构造httprequest设置
                HttpClient client = new HttpClient();
                PostMethod request = new PostMethod(reqUrl);

                // 添加request headers
                request.addRequestHeader("Content-type", "application/json");
                request.addRequestHeader("Accept", "application/json");

                TreeMap<String, String> params = new TreeMap<>();
                params.put("access_token", httpsRequestUtil.getToken().getAccessToken()); // post 提交的参数
                Map<String, Object> filterParams = new HashMap<>();
                filterParams.put("is_to_all", true);
                // filterParams.put("tag_id", 1);
                Map<String, Object> content = new HashMap<String, Object>();
                content.put("content", text);
                TreeMap<String, Object> dataParams = new TreeMap<>();
                dataParams.put("filter", filterParams);
                dataParams.put("text", content);
                dataParams.put("msgtype", "text");
                dataParams.put("clientmsgid", System.currentTimeMillis());
                JSONObject json = new JSONObject(dataParams);
                String json1 = json.toString();
                URLDecoder.decode(json1, "UTF-8");
                request.setRequestEntity(new ByteArrayRequestEntity(json1.getBytes()));
                client.executeMethod(request);
                resp = request.getResponseBodyAsString();
                System.err.println(resp);
                logger.debug(resp);
            } catch (Exception e) {
                logger.error("发送POST请求出现异常！" + e);
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * * 群发图文消息
     *            授权token
     *            标签
     * @param mediaId
     *            uploadMedia方法获得
     * @return
     * @throws Exception
     */
    public boolean sendMpnewsToTag(String mediaId) throws Exception {
        //String[] openids = WeiXinCommonUtil.getopenid();
        // String[] group= {openids[0],openids[1]};

        try {
            String resp = "";// 响应
            String reqUrl = "https://api.weixin.qq.com/cgi-bin/message/mass/preview?access_token="
                    + httpsRequestUtil.getToken().getAccessToken();
            try {
                // 构造httprequest设置
                HttpClient client = new HttpClient();
                PostMethod request = new PostMethod(reqUrl);
                // 添加request headers
                request.addRequestHeader("Content-type", "application/json");
                request.addRequestHeader("Accept", "application/json");
                TreeMap<String, String> params = new TreeMap<>();
                params.put("access_token", httpsRequestUtil.getToken().getAccessToken()); // post 提交的参数
                /*
                 * 根据标签群发所有用户，测试号不支持 Map<String, Object> filterParams = new HashMap<>();
                 * filterParams.put("is_to_all", true); filterParams.put("tag_id", tagId);
                 * //根据openid组发送 因权限原因，只能发一用户 Map<String, Object> openid = new HashMap<>();
                 * openid.put("touser",openids);
                 */
                Map<String, Object> mpnewsParams = new HashMap<>();
                mpnewsParams.put("media_id", mediaId);
                TreeMap<String, Object> dataParams = new TreeMap<>();
                //dataParams.put("touser", openids[1]);
                dataParams.put("mpnews", mpnewsParams);
                dataParams.put("msgtype", "mpnews");
                // dataParams.put("description", content);
                dataParams.put("send_ignore_reprint", 0);// 不能省略
                dataParams.put("clientmsgid", System.currentTimeMillis());
                JSONObject json = new JSONObject(dataParams);
                String json1 = json.toString();
                System.err.println(json1);
                URLDecoder.decode(json1, "UTF-8");
                request.setRequestEntity(new ByteArrayRequestEntity(json1.getBytes()));
                client.executeMethod(request);
                resp = request.getResponseBodyAsString();
                System.err.println(resp);
            } catch (Exception e) {
                System.err.println("发送POST请求出现异常！" + e);
                logger.error("发送POST请求出现异常！" + e);
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     *
     * Title: getMediaId Description: 获取图文信息的mediaid
     *
     * @return
     * @throws Exception
     */
    public String getMediaId(String picpath, String aouth, String source_url, String title, String content,String description)
            throws Exception {
        String mediaId = null;
        String accessToken = httpsRequestUtil.getToken().getAccessToken();// 获取token在微信接口之一中获取
        if (accessToken != null)// token成功获取
        {

            // File file = new File("f:" + File.separator + "2000.JPG"); // 获取本地文件
            String id = UploadUtil.upload(picpath, accessToken, "image");
            // java微信接口之三—上传多媒体文件 可获取
            if (id != null) {
                // 构造数据
                Map<String, String> map = new HashMap<String, String>();
                map.put("thumb_media_id", id);
                map.put("author", aouth);
                map.put("content_source_url", source_url);
                map.put("title", title);
                map.put("content", content);
                map.put("digest", description);
                map.put("show_cover_pic", "0");

				/*	Map<String, String> map2 = new HashMap<String, String>();
				map2.put("thumb_media_id", id);
				map2.put("author", "wxx");
				map2.put("content_source_url", "www.google.com");
				map2.put("title", "标题123321");
				map2.put("content", "测试fdsfdsfsdfssfdsfsdfsdfs");
				map2.put("digest", "digest");*/

                Map map3 = new HashMap();
                List<Map> list = new ArrayList<Map>();
                list.add(map);
                //list.add(map2);
                map3.put("articles", list);

                Gson gson = new Gson();
                String result = gson.toJson(map3);// 转换成json数据格式
                mediaId = SendNewsSuCai.uploadFodder(WeiXinBasicKey.UPLOAD_NEWS_MEDIA_URL, accessToken, result);
            }
        }
        return mediaId;

    }

}
