package http.netty;


import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.impl.nio.conn.PoolingNHttpClientConnectionManager;
import org.apache.http.impl.nio.reactor.DefaultConnectingIOReactor;
import org.apache.http.impl.nio.reactor.IOReactorConfig;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.nio.conn.NoopIOSessionStrategy;
import org.apache.http.nio.conn.SchemeIOSessionStrategy;
import org.apache.http.nio.conn.ssl.SSLIOSessionStrategy;
import org.apache.http.nio.reactor.ConnectingIOReactor;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

public class HttpAsyncClientUtil {
    private static CloseableHttpAsyncClient httpAsyncClient = null;
    private static PoolingNHttpClientConnectionManager pool = null;

    static {
        try {
            SSLContext sslContext = createIgnoreVerifySSL();
            // 设置协议http和https对应的处理socket链接工厂的对象
            Registry<SchemeIOSessionStrategy> sessionStrategyRegistry = RegistryBuilder
                    .<SchemeIOSessionStrategy>create().register("http", NoopIOSessionStrategy.INSTANCE).register("https", new SSLIOSessionStrategy(sslContext)).build();
            // 配置io线程
            IOReactorConfig ioReactorConfig = IOReactorConfig.custom()
                    .setIoThreadCount(Runtime.getRuntime().availableProcessors()).build();
            // 设置连接池大小
            ConnectingIOReactor ioReactor_https = new DefaultConnectingIOReactor(ioReactorConfig);
            pool = new PoolingNHttpClientConnectionManager(ioReactor_https, null,
                    sessionStrategyRegistry, null);
            pool.setMaxTotal(400); // 设置最多连接数
            pool.setDefaultMaxPerRoute(200); // 设置每个host最多600个连接数
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(30 * 1000) // 设置请求响应超时时间
                    .setConnectTimeout(15 * 1000) // 设置请求连接超时时间
                    .setConnectionRequestTimeout(60 * 1000) //从连接池获取连接的超时时间
                    .build();

            httpAsyncClient = HttpAsyncClients.custom().setConnectionManager(pool)
                    .setDefaultRequestConfig(requestConfig).build();

        } catch (Exception e) {
            e.printStackTrace();
        }
        httpAsyncClient.start(); // 启动异步连接
    }

    /**
     * 绕过验证
     */
    public static SSLContext createIgnoreVerifySSL() throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext sc = SSLContext.getInstance("SSLv3");

        // 实现一个X509TrustManager接口，用于绕过验证，不用修改里面的方法
        X509TrustManager trustManager = new X509TrustManager() {
            @Override
            public void checkClientTrusted(java.security.cert.X509Certificate[] paramArrayOfX509Certificate,
                                           String paramString) throws CertificateException {
            }

            @Override
            public void checkServerTrusted(java.security.cert.X509Certificate[] paramArrayOfX509Certificate,
                                           String paramString) throws CertificateException {
            }

            @Override
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        };

        sc.init(null, new TrustManager[]{trustManager}, null);
        return sc;
    }

    /**
     * 发送Get请求
     * @param url
     * @param handler
     * @return
     */
    public static Future<HttpResponse> sendGet(final String url, final CallbackHandler handler) {

        final HttpGet httpRequst = new HttpGet(url); // 创建get请求

        try {
            return httpAsyncClient.execute(httpRequst, new FutureCallback<HttpResponse>() {

                @Override
                public void failed(Exception ex) {
                    handler.failed(ex);
                }

                @Override
                public void completed(HttpResponse result) {
                    handler.completed(result);
                }

                @Override
                public void cancelled() {
                    handler.cancelled();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 发送json数据
     */
    public static Future<HttpResponse> sendJson(final String url, String jsonStr, final CallbackHandler handler) {
        final HttpPost httpRequst = new HttpPost(url);
        StringEntity entity = new StringEntity(jsonStr, "UTF-8");
        entity.setContentEncoding("UTF-8");
        entity.setContentType("application/json");
        httpRequst.setEntity(entity);
        return httpAsyncClient.execute(httpRequst, new FutureCallback<HttpResponse>() {
            @Override
            public void completed(HttpResponse response) {
                JSONObject responseJson = null;
                try {
                    int statusCode = response.getStatusLine().getStatusCode();

                    if (statusCode == org.apache.http.HttpStatus.SC_OK) {
                        String jsonRet = EntityUtils.toString(response.getEntity());
                        responseJson = JSONObject.parseObject(jsonRet);
                    }
                    handler.completed(responseJson);
                } catch (Exception e) {
                    handler.failed(e);
                }
            }

            @Override
            public void failed(Exception ex) {
                handler.failed(ex);
            }

            @Override
            public void cancelled() {
                handler.cancelled();
            }
        });
    }

    public static Future<HttpResponse> sendPost(final String url, Map<String, String> map, final CallbackHandler handler) {
        final HttpPost httpRequst = new HttpPost(url);
        List<NameValuePair> params = new ArrayList<>();

        for (Map.Entry<String, String> entry : map.entrySet()) {
            NameValuePair pair = new BasicNameValuePair(entry.getKey(), entry.getValue().toString());
            params.add(pair);
        }
        try {
            httpRequst.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return httpAsyncClient.execute(httpRequst, new FutureCallback<HttpResponse>() {
            @Override
            public void failed(Exception ex) {
                ex.printStackTrace();
                handler.failed(ex);
            }

            @Override
            public void completed(HttpResponse response) {
                BufferedReader in = null;
                StringBuffer sb = new StringBuffer("");
                try {
                    in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                    String line;
                    String NL = System.getProperty("line.separator");
                    while ((line = in.readLine()) != null) {
                        sb.append(line + NL);
                    }
                } catch (Exception e) {
                    handler.failed(e);
                } finally {
                    try {
                        in.close();
                    } catch (IOException e) {
                        handler.failed(e);
                    }
                }
                handler.completed(sb.toString());
            }

            @Override
            public void cancelled() {
                handler.cancelled();
            }
        });
    }
}
