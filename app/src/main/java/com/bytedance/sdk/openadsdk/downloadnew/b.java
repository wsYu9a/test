package com.bytedance.sdk.openadsdk.downloadnew;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* loaded from: classes2.dex */
public class b {

    public static class a {

        /* renamed from: a */
        public InputStream f8143a;

        /* renamed from: b */
        public Map<String, String> f8144b;

        /* renamed from: c */
        public int f8145c;

        /* renamed from: d */
        public HttpURLConnection f8146d;

        public a(InputStream inputStream, Map<String, String> map, int i10, HttpURLConnection httpURLConnection) {
            this.f8143a = inputStream;
            this.f8144b = map;
            this.f8145c = i10;
            this.f8146d = httpURLConnection;
        }
    }

    public static HttpURLConnection a(String str, Map<String, String> map) {
        HttpURLConnection httpURLConnection = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection2.setInstanceFollowRedirects(false);
                httpURLConnection2.setRequestProperty("accept", "*/*");
                httpURLConnection2.setRequestProperty("connection", m5.c.f28350u0);
                if (map != null && !map.isEmpty()) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        httpURLConnection2.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                httpURLConnection2.connect();
                int responseCode = httpURLConnection2.getResponseCode();
                return ((responseCode < 200 || responseCode >= 300) && responseCode >= 300 && responseCode < 400) ? a(httpURLConnection2.getHeaderField(m5.c.f28347t0), map) : httpURLConnection2;
            } catch (Exception unused) {
                httpURLConnection = httpURLConnection2;
                return httpURLConnection;
            }
        } catch (Exception unused2) {
        }
    }

    public static Map<String, String> a(HttpURLConnection httpURLConnection) {
        HashMap hashMap = new HashMap();
        int size = httpURLConnection.getHeaderFields().size();
        for (int i10 = 0; i10 < size; i10++) {
            hashMap.put(httpURLConnection.getHeaderFieldKey(i10), httpURLConnection.getHeaderField(i10));
        }
        return hashMap;
    }

    public static a a(String str, List<HttpHeader> list) throws IOException {
        int responseCode;
        HashMap hashMap = new HashMap();
        if (list != null && !list.isEmpty()) {
            for (HttpHeader httpHeader : list) {
                hashMap.put(httpHeader.getName(), httpHeader.getValue());
            }
        }
        HttpURLConnection a10 = a(str, hashMap);
        if (a10 == null || (responseCode = a10.getResponseCode()) < 200 || responseCode >= 300) {
            return null;
        }
        Map<String, String> a11 = a(a10);
        InputStream inputStream = a10.getInputStream();
        String contentEncoding = a10.getContentEncoding();
        if (!TextUtils.isEmpty(contentEncoding) && contentEncoding.contains("gzip")) {
            inputStream = new GZIPInputStream(inputStream);
        }
        return new a(inputStream, a11, responseCode, a10);
    }
}
