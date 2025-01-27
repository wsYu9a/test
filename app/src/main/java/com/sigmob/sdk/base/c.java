package com.sigmob.sdk.base;

import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import com.czhj.sdk.logger.SigmobLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.CookieManager;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: b */
    public static final String f17623b = "Set-Cookie";

    /* renamed from: c */
    public static final String f17624c = "Cookie";

    /* renamed from: a */
    public CookieManager f17625a = new CookieManager();

    public final InputStream a(InputStream inputStream, String str) throws IOException {
        byte[] bArr = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                break;
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
        String str2 = new String(byteArrayOutputStream.toByteArray());
        if (str == null) {
            str = Charset.defaultCharset().displayName();
        }
        return new ByteArrayInputStream(str2.getBytes(str));
    }

    public WebResourceResponse a(String str, String str2, Map<String, String> map) {
        String str3 = "text/html";
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod(str2);
            if (map != null && map.size() > 0) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                }
            }
            String cookie = android.webkit.CookieManager.getInstance().getCookie(str);
            if (!TextUtils.isEmpty(cookie)) {
                for (String str4 : cookie.split(";")) {
                    httpURLConnection.addRequestProperty("Cookie".toLowerCase(), str4.replace(" ", ""));
                }
            }
            httpURLConnection.connect();
            String contentType = httpURLConnection.getContentType();
            String contentEncoding = httpURLConnection.getContentEncoding();
            InputStream inputStream = httpURLConnection.getInputStream();
            a(httpURLConnection, this.f17625a);
            if (contentType.contains("text/html")) {
                inputStream = a(inputStream, contentEncoding);
            } else {
                str3 = contentType;
            }
            return new WebResourceResponse(str3, contentEncoding, inputStream);
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static void a(HttpURLConnection httpURLConnection, CookieManager cookieManager) {
        if (cookieManager == null || httpURLConnection == null) {
            return;
        }
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        SigmobLog.d("headerFields : " + headerFields.toString());
        List<String> list = headerFields.get("Set-Cookie");
        if (list != null) {
            for (String str : list) {
                try {
                    List<HttpCookie> parse = HttpCookie.parse(str);
                    if (parse != null) {
                        SigmobLog.d("{0} -- Reading Cookies from the response :" + httpURLConnection.getURL().toString());
                        SigmobLog.d("{0} -- Reading Cookies from the response :" + parse.get(0));
                        for (HttpCookie httpCookie : parse) {
                            SigmobLog.d(httpCookie.toString());
                            android.webkit.CookieManager.getInstance().setCookie(httpURLConnection.getURL().toString(), httpCookie.getName() + "=" + httpCookie.getValue());
                        }
                    }
                } catch (NullPointerException unused) {
                    SigmobLog.e(MessageFormat.format("{0} -- Null header for the cookie : {1}", httpURLConnection.getURL().toString(), str.toString()));
                }
            }
            android.webkit.CookieManager.getInstance().flush();
        }
    }
}
