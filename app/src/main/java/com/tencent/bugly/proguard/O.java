package com.tencent.bugly.proguard;

import android.content.Context;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

/* loaded from: classes4.dex */
public class O {

    /* renamed from: a */
    private static O f22635a;

    /* renamed from: b */
    protected Context f22636b;

    /* renamed from: c */
    public Map<String, String> f22637c = null;

    private O(Context context) {
        this.f22636b = context;
    }

    private Map<String, String> b(HttpURLConnection httpURLConnection) {
        HashMap hashMap = new HashMap();
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        if (headerFields == null || headerFields.size() == 0) {
            return null;
        }
        for (String str : headerFields.keySet()) {
            List<String> list = headerFields.get(str);
            if (list.size() >= 1) {
                hashMap.put(str, list.get(0));
            }
        }
        return hashMap;
    }

    public boolean a(int i10) {
        return i10 == 301 || i10 == 302 || i10 == 303 || i10 == 307;
    }

    public static O a(Context context) {
        if (f22635a == null) {
            f22635a = new O(context);
        }
        return f22635a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:69:0x016d, code lost:
    
        if (com.tencent.bugly.proguard.X.b(r7) != false) goto L237;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0196, code lost:
    
        r7.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0194, code lost:
    
        if (com.tencent.bugly.proguard.X.b(r7) != false) goto L237;
     */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0187 A[Catch: all -> 0x0175, TRY_LEAVE, TryCatch #9 {all -> 0x0175, blocks: (B:61:0x0160, B:72:0x0181, B:74:0x0187), top: B:60:0x0160 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public byte[] a(java.lang.String r21, byte[] r22, com.tencent.bugly.proguard.U r23, java.util.Map<java.lang.String, java.lang.String> r24) {
        /*
            Method dump skipped, instructions count: 447
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.O.a(java.lang.String, byte[], com.tencent.bugly.proguard.U, java.util.Map):byte[]");
    }

    public byte[] a(HttpURLConnection httpURLConnection) {
        BufferedInputStream bufferedInputStream;
        if (httpURLConnection == null) {
            return null;
        }
        try {
            bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream = null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byteArrayOutputStream.flush();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                bufferedInputStream.close();
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
            return byteArray;
        } catch (Throwable th4) {
            th = th4;
            try {
                if (!X.b(th)) {
                    th.printStackTrace();
                }
                return null;
            } finally {
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                    }
                }
            }
        }
    }

    public HttpURLConnection a(String str, byte[] bArr, String str2, Map<String, String> map) {
        if (str == null) {
            X.b("destUrl is null.", new Object[0]);
            return null;
        }
        a();
        HttpURLConnection a10 = a(str2, str);
        if (a10 == null) {
            X.b("Failed to get HttpURLConnection object.", new Object[0]);
            return null;
        }
        try {
            a10.setRequestProperty("wup_version", "3.0");
            if (map != null && map.size() > 0) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    a10.setRequestProperty(entry.getKey(), URLEncoder.encode(entry.getValue(), "utf-8"));
                }
            }
            a10.setRequestProperty("A37", URLEncoder.encode(str2, "utf-8"));
            a10.setRequestProperty("A38", URLEncoder.encode(str2, "utf-8"));
            OutputStream outputStream = a10.getOutputStream();
            if (bArr == null) {
                outputStream.write(0);
            } else {
                outputStream.write(bArr);
            }
            return a10;
        } catch (Throwable th2) {
            if (!X.b(th2)) {
                th2.printStackTrace();
            }
            X.b("Failed to upload, please check your network.", new Object[0]);
            return null;
        }
    }

    public HttpURLConnection a(String str, String str2) {
        HttpURLConnection httpURLConnection;
        try {
            URL url = new URL(str2);
            if (Y.a() != null) {
                httpURLConnection = (HttpURLConnection) url.openConnection(Y.a());
            } else if (str != null && str.toLowerCase(Locale.US).contains("wap")) {
                httpURLConnection = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(System.getProperty("http.proxyHost"), Integer.parseInt(System.getProperty("http.proxyPort")))));
            } else {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            }
            httpURLConnection.setConnectTimeout(30000);
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setInstanceFollowRedirects(false);
            return httpURLConnection;
        } catch (Throwable th2) {
            if (X.b(th2)) {
                return null;
            }
            th2.printStackTrace();
            return null;
        }
    }

    private static void a() {
        TrustManager[] trustManagerArr = {new N()};
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, trustManagerArr, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext.getSocketFactory());
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }
}
