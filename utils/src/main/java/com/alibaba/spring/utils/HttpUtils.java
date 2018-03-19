package com.alibaba.spring.utils;

import org.apache.http.*;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by jack on 2018/3/17.
 */
public class HttpUtils {

    private static final String EMPTY_RESPONSE = "";

    private static final int TIME_OUT = 6000;

    private static final RequestConfig CONFIG = RequestConfig.custom().setConnectTimeout(TIME_OUT).setSocketTimeout(
            TIME_OUT).build();

    public static String get(final String uri, TimeOutCallback timeOutCallback, final Header... headers) {
        return get(uri, null, timeOutCallback, headers);
    }

    public static String get(final String uri, final Header... headers) {
        return get(uri, null, null, headers);
    }

    public static String get(final String uri, final Map<String, String> params
            , TimeOutCallback timeOutCallback, final Header... headers) {
        URI realUri = null;
        try {
            realUri = new URIBuilder(uri).setParameters(getNvps(params)).build();
        } catch (URISyntaxException e) {
            return EMPTY_RESPONSE;
        }
        final HttpGet get = new HttpGet(realUri);
        get.setConfig(CONFIG);
        get.setHeaders(headers);
        return request(get, timeOutCallback);
    }

    public static String get(final String uri, final Map<String, String> params
            , final Header... headers) {
        URI realUri = null;
        try {
            realUri = new URIBuilder(uri).setParameters(getNvps(params)).build();
        } catch (URISyntaxException e) {
            return EMPTY_RESPONSE;
        }
        final HttpGet get = new HttpGet(realUri);
        get.setConfig(CONFIG);
        get.setHeaders(headers);
        return request(get, null);
    }

    public static String get2(final String uri, final Header... headers) {
        final HttpGet get = new HttpGet(uri);
        get.setConfig(CONFIG);
        get.setHeaders(headers);
        return request(get, null);
    }



    public static String post(final String uri, TimeOutCallback timeOutCallback, final Header... headers) {
        return post(uri, null, timeOutCallback, headers);
    }

    public static String post(final String uri, final Header... headers) {
        return post(uri, null, null, headers);
    }

    public static String post(final String uri, final Map<String, String> params, final Header... headers) {
        return post(uri, params, null, headers);
    }

    public static String post2(String url, Map<String, String> params, Charset charset, Header... headers) throws IOException {
        HttpPost post = new HttpPost(url);
        post.setConfig(CONFIG);
        post.setHeaders(headers);
        post.setEntity(new UrlEncodedFormEntity(getNvps(params), charset));
        return request2(post, charset);
    }

    private static final int SUCCESS = 200;

    private static String request2(HttpUriRequest request, Charset charset) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        try {
            response = client.execute(request);
            if (response.getStatusLine().getStatusCode() == SUCCESS) {
                return EntityUtils.toString(response.getEntity(), charset);
            } else {
                throw new IOException("请求失败");
            }
        } finally {
            if (client != null) {
                client.close();
            }
            if (response != null) {
                response.close();
            }
        }
    }


    public static String post(final String uri, final Map<String, String> params, TimeOutCallback timeOutCallback, final Header... headers) {
        final HttpPost post = new HttpPost(uri);
        post.setConfig(CONFIG);
        post.setHeaders(headers);
        post.setEntity(new UrlEncodedFormEntity(getNvps(params), Consts.UTF_8));



        return request(post, timeOutCallback);
    }

    public static String post(String url, Map<String, String> params, TimeOutCallback timeOutCallback, Charset charset, Header... headers) throws IOException {
        HttpPost post = new HttpPost(url);
        post.setConfig(CONFIG);
        post.setHeaders(headers);
        post.setEntity(new UrlEncodedFormEntity(getNvps(params), charset));
        return request(post, timeOutCallback);
    }

    public static String put(final String url, final Map<String, String> params, final Header... headers) {
        final HttpPut put = new HttpPut(url);
        put.setConfig(CONFIG);
        put.setHeaders(headers);
        put.setEntity(new UrlEncodedFormEntity(getNvps(params), Consts.UTF_8));
        return request(put, null);
    }

    private static List<NameValuePair> getNvps(Map<String, String> params) {
        if (params == null || params.isEmpty()) {
            return Collections.emptyList();
        }
        List<NameValuePair> nvps = new ArrayList<NameValuePair>(params.size());
        for (Map.Entry<String, String> entry : params.entrySet()) {
            nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        return nvps;
    }

    private static String request(final HttpRequestBase request, TimeOutCallback timeOutCallback) {
        try (final CloseableHttpClient client = HttpClients.createDefault();
             final CloseableHttpResponse response = client.execute(request)) {
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                return EntityUtils.toString(response
                        .getEntity(), Consts.UTF_8);
            }

        } catch (IOException e) {
            if (e instanceof ConnectTimeoutException || e instanceof SocketTimeoutException) {
                if (timeOutCallback != null) {
                    timeOutCallback.call();
                }
            }
        } catch (ParseException e) {
        }

        return EMPTY_RESPONSE;
    }

    public interface TimeOutCallback {

        void call();
    }
}
