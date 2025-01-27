package com.maritan.libweixin;

import android.util.Log;
import android.util.Xml;
import com.baidu.mobads.sdk.internal.am;
import com.baidu.mobads.sdk.internal.bu;
import com.martian.libsupport.k;
import com.tencent.mm.opensdk.modelpay.PayReq;
import java.io.IOException;
import java.io.StringReader;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import kotlin.text.Typography;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.util.EntityUtils;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes2.dex */
public class i {

    /* renamed from: a */
    private static final String f9588a = "WXUils";

    private static class a extends SSLSocketFactory {

        /* renamed from: a */
        SSLContext f9589a;

        /* renamed from: com.maritan.libweixin.i$a$a */
        class C0254a implements X509TrustManager {
            C0254a() {
            }

            @Override // javax.net.ssl.X509TrustManager
            public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            }

            @Override // javax.net.ssl.X509TrustManager
            public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException, IllegalArgumentException {
                try {
                    chain[0].checkValidity();
                } catch (Exception unused) {
                    throw new CertificateException("Certificate not valid or trusted.");
                }
            }

            @Override // javax.net.ssl.X509TrustManager
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        }

        public a(KeyStore truststore) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
            super(truststore);
            this.f9589a = SSLContext.getInstance("TLS");
            this.f9589a.init(null, new TrustManager[]{new C0254a()}, null);
        }

        @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.LayeredSocketFactory
        public Socket createSocket(Socket socket, String host, int port, boolean autoClose) throws IOException {
            return this.f9589a.getSocketFactory().createSocket(socket, host, port, autoClose);
        }

        @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.SocketFactory
        public Socket createSocket() throws IOException {
            return this.f9589a.getSocketFactory().createSocket();
        }
    }

    public static Map<String, String> a(String content) {
        try {
            HashMap hashMap = new HashMap();
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setInput(new StringReader(content));
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                String name = newPullParser.getName();
                if (eventType == 2 && !"xml".equals(name)) {
                    hashMap.put(name, newPullParser.nextText());
                }
            }
            return hashMap;
        } catch (Exception e2) {
            Log.e("orion", e2.toString());
            return null;
        }
    }

    private static String b(List<NameValuePair> params, g wxKey) {
        StringBuilder sb = new StringBuilder();
        for (NameValuePair nameValuePair : params) {
            sb.append(nameValuePair.getName());
            sb.append('=');
            sb.append(nameValuePair.getValue());
            sb.append(Typography.amp);
        }
        sb.append("key=");
        sb.append(wxKey.f9578b);
        String l = l(sb.toString().getBytes());
        return k.p(l) ? "" : l.toUpperCase();
    }

    public static String c() {
        return l(UUID.randomUUID().toString().getBytes());
    }

    public static String d() {
        return System.currentTimeMillis() + "" + new Random().nextInt(100);
    }

    private static String e(List<NameValuePair> params, String appKey) {
        StringBuilder sb = new StringBuilder();
        for (NameValuePair nameValuePair : params) {
            sb.append(nameValuePair.getName());
            sb.append('=');
            sb.append(nameValuePair.getValue());
            sb.append(Typography.amp);
        }
        sb.append("key=");
        sb.append(appKey);
        String l = l(sb.toString().getBytes());
        return k.p(l) ? "" : l.toUpperCase();
    }

    public static PayReq f(Map<String, String> resultunifiedorder, g wxKey) {
        PayReq payReq = new PayReq();
        payReq.appId = wxKey.f9577a;
        payReq.partnerId = wxKey.f9579c;
        payReq.prepayId = resultunifiedorder.get("prepay_id");
        payReq.packageValue = "Sign=WXPay";
        payReq.nonceStr = c();
        payReq.timeStamp = String.valueOf(i());
        LinkedList linkedList = new LinkedList();
        linkedList.add(new BasicNameValuePair("appid", payReq.appId));
        linkedList.add(new BasicNameValuePair("noncestr", payReq.nonceStr));
        linkedList.add(new BasicNameValuePair("package", payReq.packageValue));
        linkedList.add(new BasicNameValuePair("partnerid", payReq.partnerId));
        linkedList.add(new BasicNameValuePair("prepayid", payReq.prepayId));
        linkedList.add(new BasicNameValuePair("timestamp", payReq.timeStamp));
        payReq.sign = b(linkedList, wxKey);
        Log.e("orion", linkedList.toString());
        return payReq;
    }

    public static String g(com.maritan.libweixin.dao.a payment, g wxkey) {
        try {
            LinkedList linkedList = new LinkedList();
            linkedList.add(new BasicNameValuePair("appid", wxkey.f9577a));
            linkedList.add(new BasicNameValuePair("mch_id", wxkey.f9579c));
            linkedList.add(new BasicNameValuePair("nonce_str", c()));
            linkedList.add(new BasicNameValuePair("out_trade_no", payment.f9566e));
            linkedList.add(new BasicNameValuePair("sign", e(linkedList, wxkey.f9578b)));
            return new String(m(linkedList).getBytes(), "ISO8859-1");
        } catch (Exception unused) {
            return null;
        }
    }

    public static String h(h product, g wxkey) {
        try {
            LinkedList linkedList = new LinkedList();
            linkedList.add(new BasicNameValuePair("appid", wxkey.f9577a));
            linkedList.add(new BasicNameValuePair("body", product.f9580a));
            linkedList.add(new BasicNameValuePair("mch_id", wxkey.f9579c));
            linkedList.add(new BasicNameValuePair("nonce_str", product.f9581b));
            linkedList.add(new BasicNameValuePair("notify_url", product.f9582c));
            linkedList.add(new BasicNameValuePair("out_trade_no", product.f9583d));
            linkedList.add(new BasicNameValuePair("spbill_create_ip", product.f9584e));
            linkedList.add(new BasicNameValuePair("total_fee", "" + product.f9585f));
            linkedList.add(new BasicNameValuePair("trade_type", product.f9586g));
            linkedList.add(new BasicNameValuePair("sign", e(linkedList, wxkey.f9578b)));
            return new String(m(linkedList).getBytes(), "ISO8859-1");
        } catch (Exception unused) {
            return null;
        }
    }

    private static long i() {
        return System.currentTimeMillis() / 1000;
    }

    private static HttpClient j() {
        try {
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null, null);
            a aVar = new a(keyStore);
            aVar.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            BasicHttpParams basicHttpParams = new BasicHttpParams();
            HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
            HttpProtocolParams.setContentCharset(basicHttpParams, "UTF-8");
            SchemeRegistry schemeRegistry = new SchemeRegistry();
            schemeRegistry.register(new Scheme(HttpHost.DEFAULT_SCHEME_NAME, PlainSocketFactory.getSocketFactory(), 80));
            schemeRegistry.register(new Scheme(b.b.a.b.b.f4198a, aVar, 443));
            return new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
        } catch (Exception unused) {
            return new DefaultHttpClient();
        }
    }

    public static byte[] k(String url, String entity) {
        if (url == null || url.length() == 0) {
            Log.e(f9588a, "httpPost, url is null");
            return null;
        }
        HttpClient j2 = j();
        HttpPost httpPost = new HttpPost(url);
        try {
            httpPost.setEntity(new StringEntity(entity));
            httpPost.setHeader(HttpHeaders.ACCEPT, am.f5520d);
            httpPost.setHeader("Content-type", am.f5520d);
            HttpResponse execute = j2.execute(httpPost);
            if (execute.getStatusLine().getStatusCode() == 200) {
                return EntityUtils.toByteArray(execute.getEntity());
            }
            Log.e(f9588a, "httpGet fail, status code = " + execute.getStatusLine().getStatusCode());
            return null;
        } catch (Exception e2) {
            Log.e(f9588a, "httpPost exception, e = " + e2.getMessage());
            e2.printStackTrace();
            return null;
        }
    }

    public static String l(byte[] buffer) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(bu.f5659a);
            messageDigest.update(buffer);
            byte[] digest = messageDigest.digest();
            char[] cArr2 = new char[digest.length * 2];
            int i2 = 0;
            for (byte b2 : digest) {
                int i3 = i2 + 1;
                cArr2[i2] = cArr[(b2 >>> 4) & 15];
                i2 = i3 + 1;
                cArr2[i3] = cArr[b2 & 15];
            }
            return new String(cArr2);
        } catch (Exception unused) {
            return null;
        }
    }

    private static String m(List<NameValuePair> params) {
        StringBuilder sb = new StringBuilder();
        sb.append("<xml>");
        for (NameValuePair nameValuePair : params) {
            sb.append("<");
            sb.append(nameValuePair.getName());
            sb.append(">");
            sb.append("<![CDATA[");
            sb.append(nameValuePair.getValue());
            sb.append("]]>");
            sb.append("</");
            sb.append(nameValuePair.getName());
            sb.append(">");
        }
        sb.append("</xml>");
        Log.e("orion", sb.toString());
        return sb.toString();
    }
}
