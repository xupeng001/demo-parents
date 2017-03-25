package com.example.http;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import com.example.encode.AESUtils;

public class HttpClientTool {
    private final static Log     LggerUtil         = LogFactory.getLog(HttpClientTool.class);

    public static final String   HTTP_REQUEST_GET  = "GET";
    public static final String   HTTP_REQUEST_POST = "POST";
    public static HttpClientTool instance;
    private boolean              switchProxy;
    private String               host;
    private int                  port;

    public void init() {
        instance = this;
    }

    public static HttpClientTool getInstance() {
        return instance;
    }

    public boolean isSwitchProxy() {
        return switchProxy;
    }

    public void setSwitchProxy(boolean switchProxy) {
        this.switchProxy = switchProxy;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String sendRequest(String url, String requestMethod, Map<String, String> parameterMap, Integer timeout)
            throws Exception {
        HttpResponse response = sendRequestImpl(url, requestMethod, parameterMap, timeout, switchProxy);
        if (null != response) {
            String result = EntityUtils.toString(response.getEntity(), "UTF-8");
            return result;
        } else
            return "";
    }

    public String sendRequest(String url, String requestMethod, Map<String, String> parameterMap) throws Exception {
        LggerUtil.info("url:" + url);
        Date startTime = new Date();
        LggerUtil.info("parameterMap:" + parameterMap);
        HttpResponse response = sendRequestImpl(url, requestMethod, parameterMap, null, switchProxy);
        if (null != response) {
            String result = EntityUtils.toString(response.getEntity(), "UTF-8");

            LggerUtil.info("result:" + result);
            LggerUtil.info("-----------------------调用" + url + "的总时间:" + (new Date().getTime() - startTime.getTime())
                    + "------------------------");
            return result;
        } else
            return "";
    }

    public String sendRequestByProxy(String url, String requestMethod, Map<String, String> parameterMap, boolean isProxy)
            throws Exception {
        HttpResponse response = sendRequestImpl(url, requestMethod, parameterMap, null, isProxy);
        if (null != response) {
            String result = EntityUtils.toString(response.getEntity(), "UTF-8");
            return result;
        } else
            return "";
    }

    public byte[] sendRequestReturnByteArray(String url, String requestMethod, Map<String, String> parameterMap,
                                             Integer timeout) throws Exception {
        HttpResponse response = sendRequestImpl(url, requestMethod, parameterMap, timeout, switchProxy);
        if (null != response) {
            return EntityUtils.toByteArray(response.getEntity());
        } else
            return new byte[0];
    }

    public byte[] sendRequestReturnByteArray(String url, String requestMethod, Map<String, String> parameterMap)
            throws Exception {
        HttpResponse response = sendRequestImpl(url, requestMethod, parameterMap, null, switchProxy);
        if (null != response) {
            return EntityUtils.toByteArray(response.getEntity());
        } else
            return new byte[0];
    }

    /**
     * @param requestMethod
     * @param parameterMap
     * @return
     * @throws Exception
     */
    private HttpResponse sendRequestImpl(String url, String requestMethod, Map<String, String> parameterMap,
                                         Integer timeout, boolean isProxy) throws Exception {
        //      System.out.println(url);
        StringBuffer urlString = new StringBuffer(url);
        String urlforGet = urlString.toString();

        if (HTTP_REQUEST_GET.equalsIgnoreCase(requestMethod) && parameterMap != null) {
            for (String key : parameterMap.keySet()) {
                if (null != parameterMap.get(key) && parameterMap.get(key).length() > 0) {
                    urlString.append(key).append("=").append(parameterMap.get(key)).append("&");
                }
            }
            urlforGet = urlString.substring(0, urlString.length() - 1);
            System.out.println(urlforGet);
        }
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        HttpClient httpClient = httpClientBuilder.build();

        //        @SuppressWarnings("resource")
        //        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> data = new ArrayList<NameValuePair>();
        if (parameterMap != null) {
            Iterator<String> it = parameterMap.keySet().iterator();
            String key = "";
            while (it.hasNext()) {
                key = it.next().toString();
                data.add(new BasicNameValuePair(key, parameterMap.get(key) != null ? parameterMap.get(key).toString()
                        : ""));
            }
        }
        if (timeout != null && timeout != 0) {
            httpClient.getParams().setParameter("http.socket.timeout", timeout * 1000);
            httpClient.getParams().setParameter("http.connection.timeout", timeout * 1000);
            httpClient.getParams().setParameter("http.connection-manager.timeout", new Long(timeout * 1000));
            httpClient.getParams().setParameter("http.protocol.head-body-timeout", timeout * 1000);
        }

        int statusCode;
        if (HTTP_REQUEST_POST.equalsIgnoreCase(requestMethod)) {
            HttpPost postMethod = new HttpPost(urlString.toString());
            // 设置代理，测试环境使
            if (isProxy) {
                HttpHost proxy = new HttpHost(this.host, this.port);
                httpClient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, proxy);
            }

            postMethod.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
            postMethod.addHeader("Connection", "close");

            postMethod.setEntity(new UrlEncodedFormEntity(data, HTTP.UTF_8));

            HttpResponse response = httpClient.execute(postMethod);
            statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                throw new Exception("POST请求失败" + urlString.toString());
            } else if (statusCode == 404) {
                throw new Exception("404");
            } else if (statusCode == HttpStatus.SC_MOVED_PERMANENTLY || statusCode == HttpStatus.SC_MOVED_TEMPORARILY) {
                // 从头中取出转向的地址
                Header[] locationHeader = postMethod.getHeaders("location");
                String location = null;
                if (locationHeader != null) {
                    location = locationHeader[0].getValue();
                    throw new Exception("访问地址被重定向" + location);
                } else {
                    throw new Exception("访问地址被重定向" + location);
                }
            } else {
                return response;
            }
        } else {
            HttpGet getMethod = new HttpGet(urlforGet);
            if (isProxy) {
                HttpHost proxy = new HttpHost(this.host, this.port);
                httpClient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, proxy);
            }
            getMethod.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
            getMethod.addHeader("Connection", "close");

            HttpResponse response = httpClient.execute(getMethod);
            statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                throw new Exception("GET请求失败: " + urlString.toString());
            } else {
                return response;
            }
        }
    }

    // /**
    // * 从request中获得参数Map，并返回可读的Map. 在这个项目中只取第一个相同key的参数值
    // *
    // * @param request
    // * @return
    // */
    // @SuppressWarnings("unchecked")
    // public static Map<String,String> getParameterMap(HttpServletRequest
    // request) {
    // // 参数Map
    // Map<String,String> properties = request.getParameterMap();
    // // 返回值Map
    // Map<String,String> returnMap = new HashMap<String,String>();
    // Iterator<Map.Entry<String,String>> entries =
    // properties.entrySet().iterator();
    // Map.Entry<String,String> entry;
    // String name = "";
    // String value = "";
    // while (entries.hasNext()) {
    // entry = (Map.Entry<String,String>) entries.next();
    // name = (String) entry.getKey();
    // Object valueObj = entry.getValue();
    // if(null == valueObj){
    // value = "";
    // }else if(valueObj instanceof String[]){
    // String[] values = (String[])valueObj;
    // // for(int i=0;i<values.length;i++){
    // // value = values[i] + ",";
    // // }
    // // value = value.substring(0, value.length()-1);
    // value=values[0];
    // }else{
    // value = valueObj.toString();
    // }
    // returnMap.put(name, value);
    // }
    // return returnMap;
    // }
}
