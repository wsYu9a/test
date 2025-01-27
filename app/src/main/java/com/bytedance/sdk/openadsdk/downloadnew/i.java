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
import org.apache.http.HttpHeaders;
import org.apache.http.protocol.HTTP;

/* loaded from: classes.dex */
public class i {

    public static class j {

        /* renamed from: g */
        public HttpURLConnection f6467g;

        /* renamed from: i */
        public int f6468i;

        /* renamed from: j */
        public InputStream f6469j;
        public Map<String, String> zx;

        public j(InputStream inputStream, Map<String, String> map, int i2, HttpURLConnection httpURLConnection) {
            this.f6469j = inputStream;
            this.zx = map;
            this.f6468i = i2;
            this.f6467g = httpURLConnection;
        }
    }

    public static HttpURLConnection j(String str, Map<String, String> map) {
        HttpURLConnection httpURLConnection = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection2.setInstanceFollowRedirects(false);
                httpURLConnection2.setRequestProperty("accept", "*/*");
                httpURLConnection2.setRequestProperty("connection", HTTP.CONN_KEEP_ALIVE);
                if (map != null && !map.isEmpty()) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        httpURLConnection2.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                httpURLConnection2.connect();
                int responseCode = httpURLConnection2.getResponseCode();
                return ((responseCode < 200 || responseCode >= 300) && responseCode >= 300 && responseCode < 400) ? j(httpURLConnection2.getHeaderField(HttpHeaders.LOCATION), map) : httpURLConnection2;
            } catch (Exception unused) {
                httpURLConnection = httpURLConnection2;
                return httpURLConnection;
            }
        } catch (Exception unused2) {
        }
    }

    public static Map<String, String> j(HttpURLConnection httpURLConnection) {
        HashMap hashMap = new HashMap();
        int size = httpURLConnection.getHeaderFields().size();
        for (int i2 = 0; i2 < size; i2++) {
            hashMap.put(httpURLConnection.getHeaderFieldKey(i2), httpURLConnection.getHeaderField(i2));
        }
        return hashMap;
    }

    public static j j(String str, List<HttpHeader> list) throws IOException {
        int responseCode;
        HashMap hashMap = new HashMap();
        if (list != null && !list.isEmpty()) {
            for (HttpHeader httpHeader : list) {
                hashMap.put(httpHeader.getName(), httpHeader.getValue());
            }
        }
        HttpURLConnection j2 = j(str, hashMap);
        if (j2 == null || (responseCode = j2.getResponseCode()) < 200 || responseCode >= 300) {
            return null;
        }
        Map<String, String> j3 = j(j2);
        InputStream inputStream = j2.getInputStream();
        String contentEncoding = j2.getContentEncoding();
        if (!TextUtils.isEmpty(contentEncoding) && contentEncoding.contains("gzip")) {
            inputStream = new GZIPInputStream(inputStream);
        }
        return new j(inputStream, j3, responseCode, j2);
    }
}
