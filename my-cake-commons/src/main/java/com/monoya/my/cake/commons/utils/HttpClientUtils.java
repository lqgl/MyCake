package com.monoya.my.cake.commons.utils;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import sun.net.www.http.HttpClient;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * HttpClient 工具类
 */
public class HttpClientUtils {

    public static final String GET = "get";
    public static final String POST = "post";

    public static final String REQUEST_HEADER_CONNECTION = "keep-alive";
    public static final String REQUEST_HEADER_USER_AGENT = "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.183 Mobile Safari/537.36 Edg/86.0.622.63";

    /**
     * GET 请求
     * @param url 请求地址
     * @return
     */
    public static String doGet(String url){

    return createRequest(url,null,GET);
    }
    /**
     * GET 请求
     * @param url 请求地址
     * @param cookie cookie
     * @return
     */
    public static String doGet(String url,String cookie){

        return createRequest(url,cookie,GET);
    }
    /**
     * POST 请求
     * @param url 请求地址
     * @param params 请求参数（可选）
     * @return
     */
    public static String doPost(String url,BasicNameValuePair... params){

        return createRequest(url,null,POST,params);
    }
    /**
     * POST 请求
     * @param url 请求地址
     * @param cookie cookie
     * @param params 请求参数（可选）
     * @return
     */
    public static String doPost(String url,String cookie,BasicNameValuePair... params){

        return createRequest(url,cookie,POST,params);
    }

    /**
     * 创建请求
     * @param url 请求地址
     * @param cookie cookie
     * @param requestMethod 请求方式 GET/POST
     * @param params 请求参数 仅限于 POST 请求用
     * @return
     */

    public static String createRequest(String url,String cookie, String requestMethod, BasicNameValuePair... params){
        //创建 Http 客户端实例，相当于打开浏览器
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //请求结果
        String result = null;
        try {
            //请求方式
            HttpGet httpGet = null;
            HttpPost httpPost = null;

            //响应
            CloseableHttpResponse httpResponse = null;

            if(GET.endsWith(requestMethod)){
                httpGet = new HttpGet(url);
                httpGet.setHeader("Connection",REQUEST_HEADER_CONNECTION);
                httpGet.setHeader("Cookie","");
                httpGet.setHeader("User-Agent",REQUEST_HEADER_USER_AGENT);

                httpResponse = httpClient.execute(httpGet);
            } else if(POST.equals(requestMethod)){
                httpPost = new HttpPost(url);
                httpPost.setHeader("Connection",REQUEST_HEADER_CONNECTION);
                httpPost.setHeader("Cookie",cookie);
                httpPost.setHeader("User-Agent",REQUEST_HEADER_USER_AGENT);
                //有参数
                if(params!=null&&params.length>0){
                    httpPost.setEntity(new UrlEncodedFormEntity(Arrays.asList(params),"UTF-8"));
                }
                httpResponse = httpClient.execute(httpPost);


            }
            HttpEntity httpEntity = httpResponse.getEntity();
            result = EntityUtils.toString(httpEntity);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(httpClient!=null){
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
