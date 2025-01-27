package com.alipay.android.phone.mrpc.core;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.CookieManager;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.Callable;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

/* loaded from: classes.dex */
public final class q implements Callable<u> {

    /* renamed from: e */
    public static final HttpRequestRetryHandler f6401e = new ad();

    /* renamed from: a */
    public l f6402a;

    /* renamed from: b */
    public Context f6403b;

    /* renamed from: c */
    public o f6404c;

    /* renamed from: d */
    public String f6405d;

    /* renamed from: f */
    public HttpUriRequest f6406f;

    /* renamed from: i */
    public CookieManager f6409i;

    /* renamed from: j */
    public AbstractHttpEntity f6410j;

    /* renamed from: k */
    public HttpHost f6411k;

    /* renamed from: l */
    public URL f6412l;

    /* renamed from: q */
    public String f6417q;

    /* renamed from: g */
    public HttpContext f6407g = new BasicHttpContext();

    /* renamed from: h */
    public CookieStore f6408h = new BasicCookieStore();

    /* renamed from: m */
    public int f6413m = 0;

    /* renamed from: n */
    public boolean f6414n = false;

    /* renamed from: o */
    public boolean f6415o = false;

    /* renamed from: p */
    public String f6416p = null;

    public q(l lVar, o oVar) {
        this.f6402a = lVar;
        this.f6403b = lVar.f6379a;
        this.f6404c = oVar;
    }

    public static long a(String[] strArr) {
        String str;
        for (int i10 = 0; i10 < strArr.length; i10++) {
            if ("max-age".equalsIgnoreCase(strArr[i10]) && (str = strArr[i10 + 1]) != null) {
                try {
                    return Long.parseLong(str);
                } catch (Exception unused) {
                    continue;
                }
            }
        }
        return 0L;
    }

    public static long b(HttpResponse httpResponse) {
        Header firstHeader = httpResponse.getFirstHeader("Cache-Control");
        if (firstHeader != null) {
            String[] split = firstHeader.getValue().split("=");
            if (split.length >= 2) {
                try {
                    return a(split);
                } catch (NumberFormatException unused) {
                }
            }
        }
        Header firstHeader2 = httpResponse.getFirstHeader(m5.c.f28338q0);
        if (firstHeader2 != null) {
            return b.b(firstHeader2.getValue()) - System.currentTimeMillis();
        }
        return 0L;
    }

    private HttpUriRequest c() {
        HttpUriRequest httpUriRequest = this.f6406f;
        if (httpUriRequest != null) {
            return httpUriRequest;
        }
        if (this.f6410j == null) {
            byte[] b10 = this.f6404c.b();
            String b11 = this.f6404c.b("gzip");
            if (b10 != null) {
                if (TextUtils.equals(b11, "true")) {
                    this.f6410j = b.a(b10);
                } else {
                    this.f6410j = new ByteArrayEntity(b10);
                }
                this.f6410j.setContentType(this.f6404c.c());
            }
        }
        AbstractHttpEntity abstractHttpEntity = this.f6410j;
        if (abstractHttpEntity != null) {
            HttpPost httpPost = new HttpPost(b());
            httpPost.setEntity(abstractHttpEntity);
            this.f6406f = httpPost;
        } else {
            this.f6406f = new HttpGet(b());
        }
        return this.f6406f;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0133 A[Catch: Exception -> 0x004e, NullPointerException -> 0x0051, IOException -> 0x0054, UnknownHostException -> 0x0057, HttpHostConnectException -> 0x005a, NoHttpResponseException -> 0x005d, SocketTimeoutException -> 0x0060, ConnectTimeoutException -> 0x0063, ConnectionPoolTimeoutException -> 0x0066, SSLException -> 0x0069, SSLPeerUnverifiedException -> 0x006c, SSLHandshakeException -> 0x006f, URISyntaxException -> 0x0072, HttpException -> 0x0075, TryCatch #3 {HttpException -> 0x0075, NullPointerException -> 0x0051, SocketTimeoutException -> 0x0060, URISyntaxException -> 0x0072, UnknownHostException -> 0x0057, SSLHandshakeException -> 0x006f, SSLPeerUnverifiedException -> 0x006c, SSLException -> 0x0069, NoHttpResponseException -> 0x005d, ConnectionPoolTimeoutException -> 0x0066, ConnectTimeoutException -> 0x0063, HttpHostConnectException -> 0x005a, IOException -> 0x0054, Exception -> 0x004e, blocks: (B:4:0x0006, B:6:0x0014, B:8:0x0018, B:10:0x001c, B:12:0x0022, B:15:0x0028, B:17:0x0030, B:19:0x0036, B:20:0x003a, B:22:0x0040, B:24:0x0078, B:26:0x008c, B:28:0x00a1, B:30:0x00cd, B:32:0x00dc, B:34:0x00e2, B:36:0x00ec, B:38:0x00f5, B:40:0x0101, B:43:0x010b, B:46:0x012b, B:48:0x0133, B:49:0x0140, B:51:0x0166, B:52:0x016d, B:54:0x0173, B:55:0x0177, B:57:0x017d, B:60:0x0189, B:63:0x01b8, B:69:0x01d4, B:74:0x01ed, B:75:0x0206, B:77:0x0207, B:79:0x020f, B:81:0x0215, B:84:0x0221, B:86:0x0225, B:91:0x0235, B:93:0x023d, B:95:0x0247, B:98:0x0113, B:102:0x024b, B:106:0x024f, B:107:0x025b), top: B:3:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0166 A[Catch: Exception -> 0x004e, NullPointerException -> 0x0051, IOException -> 0x0054, UnknownHostException -> 0x0057, HttpHostConnectException -> 0x005a, NoHttpResponseException -> 0x005d, SocketTimeoutException -> 0x0060, ConnectTimeoutException -> 0x0063, ConnectionPoolTimeoutException -> 0x0066, SSLException -> 0x0069, SSLPeerUnverifiedException -> 0x006c, SSLHandshakeException -> 0x006f, URISyntaxException -> 0x0072, HttpException -> 0x0075, TryCatch #3 {HttpException -> 0x0075, NullPointerException -> 0x0051, SocketTimeoutException -> 0x0060, URISyntaxException -> 0x0072, UnknownHostException -> 0x0057, SSLHandshakeException -> 0x006f, SSLPeerUnverifiedException -> 0x006c, SSLException -> 0x0069, NoHttpResponseException -> 0x005d, ConnectionPoolTimeoutException -> 0x0066, ConnectTimeoutException -> 0x0063, HttpHostConnectException -> 0x005a, IOException -> 0x0054, Exception -> 0x004e, blocks: (B:4:0x0006, B:6:0x0014, B:8:0x0018, B:10:0x001c, B:12:0x0022, B:15:0x0028, B:17:0x0030, B:19:0x0036, B:20:0x003a, B:22:0x0040, B:24:0x0078, B:26:0x008c, B:28:0x00a1, B:30:0x00cd, B:32:0x00dc, B:34:0x00e2, B:36:0x00ec, B:38:0x00f5, B:40:0x0101, B:43:0x010b, B:46:0x012b, B:48:0x0133, B:49:0x0140, B:51:0x0166, B:52:0x016d, B:54:0x0173, B:55:0x0177, B:57:0x017d, B:60:0x0189, B:63:0x01b8, B:69:0x01d4, B:74:0x01ed, B:75:0x0206, B:77:0x0207, B:79:0x020f, B:81:0x0215, B:84:0x0221, B:86:0x0225, B:91:0x0235, B:93:0x023d, B:95:0x0247, B:98:0x0113, B:102:0x024b, B:106:0x024f, B:107:0x025b), top: B:3:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0173 A[Catch: Exception -> 0x004e, NullPointerException -> 0x0051, IOException -> 0x0054, UnknownHostException -> 0x0057, HttpHostConnectException -> 0x005a, NoHttpResponseException -> 0x005d, SocketTimeoutException -> 0x0060, ConnectTimeoutException -> 0x0063, ConnectionPoolTimeoutException -> 0x0066, SSLException -> 0x0069, SSLPeerUnverifiedException -> 0x006c, SSLHandshakeException -> 0x006f, URISyntaxException -> 0x0072, HttpException -> 0x0075, TryCatch #3 {HttpException -> 0x0075, NullPointerException -> 0x0051, SocketTimeoutException -> 0x0060, URISyntaxException -> 0x0072, UnknownHostException -> 0x0057, SSLHandshakeException -> 0x006f, SSLPeerUnverifiedException -> 0x006c, SSLException -> 0x0069, NoHttpResponseException -> 0x005d, ConnectionPoolTimeoutException -> 0x0066, ConnectTimeoutException -> 0x0063, HttpHostConnectException -> 0x005a, IOException -> 0x0054, Exception -> 0x004e, blocks: (B:4:0x0006, B:6:0x0014, B:8:0x0018, B:10:0x001c, B:12:0x0022, B:15:0x0028, B:17:0x0030, B:19:0x0036, B:20:0x003a, B:22:0x0040, B:24:0x0078, B:26:0x008c, B:28:0x00a1, B:30:0x00cd, B:32:0x00dc, B:34:0x00e2, B:36:0x00ec, B:38:0x00f5, B:40:0x0101, B:43:0x010b, B:46:0x012b, B:48:0x0133, B:49:0x0140, B:51:0x0166, B:52:0x016d, B:54:0x0173, B:55:0x0177, B:57:0x017d, B:60:0x0189, B:63:0x01b8, B:69:0x01d4, B:74:0x01ed, B:75:0x0206, B:77:0x0207, B:79:0x020f, B:81:0x0215, B:84:0x0221, B:86:0x0225, B:91:0x0235, B:93:0x023d, B:95:0x0247, B:98:0x0113, B:102:0x024b, B:106:0x024f, B:107:0x025b), top: B:3:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0113 A[Catch: Exception -> 0x004e, NullPointerException -> 0x0051, IOException -> 0x0054, UnknownHostException -> 0x0057, HttpHostConnectException -> 0x005a, NoHttpResponseException -> 0x005d, SocketTimeoutException -> 0x0060, ConnectTimeoutException -> 0x0063, ConnectionPoolTimeoutException -> 0x0066, SSLException -> 0x0069, SSLPeerUnverifiedException -> 0x006c, SSLHandshakeException -> 0x006f, URISyntaxException -> 0x0072, HttpException -> 0x0075, TryCatch #3 {HttpException -> 0x0075, NullPointerException -> 0x0051, SocketTimeoutException -> 0x0060, URISyntaxException -> 0x0072, UnknownHostException -> 0x0057, SSLHandshakeException -> 0x006f, SSLPeerUnverifiedException -> 0x006c, SSLException -> 0x0069, NoHttpResponseException -> 0x005d, ConnectionPoolTimeoutException -> 0x0066, ConnectTimeoutException -> 0x0063, HttpHostConnectException -> 0x005a, IOException -> 0x0054, Exception -> 0x004e, blocks: (B:4:0x0006, B:6:0x0014, B:8:0x0018, B:10:0x001c, B:12:0x0022, B:15:0x0028, B:17:0x0030, B:19:0x0036, B:20:0x003a, B:22:0x0040, B:24:0x0078, B:26:0x008c, B:28:0x00a1, B:30:0x00cd, B:32:0x00dc, B:34:0x00e2, B:36:0x00ec, B:38:0x00f5, B:40:0x0101, B:43:0x010b, B:46:0x012b, B:48:0x0133, B:49:0x0140, B:51:0x0166, B:52:0x016d, B:54:0x0173, B:55:0x0177, B:57:0x017d, B:60:0x0189, B:63:0x01b8, B:69:0x01d4, B:74:0x01ed, B:75:0x0206, B:77:0x0207, B:79:0x020f, B:81:0x0215, B:84:0x0221, B:86:0x0225, B:91:0x0235, B:93:0x023d, B:95:0x0247, B:98:0x0113, B:102:0x024b, B:106:0x024f, B:107:0x025b), top: B:3:0x0006 }] */
    @Override // java.util.concurrent.Callable
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.alipay.android.phone.mrpc.core.u call() {
        /*
            Method dump skipped, instructions count: 1008
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.android.phone.mrpc.core.q.call():com.alipay.android.phone.mrpc.core.u");
    }

    private void e() {
        HttpUriRequest httpUriRequest = this.f6406f;
        if (httpUriRequest != null) {
            httpUriRequest.abort();
        }
    }

    private String f() {
        if (!TextUtils.isEmpty(this.f6417q)) {
            return this.f6417q;
        }
        String b10 = this.f6404c.b("operationType");
        this.f6417q = b10;
        return b10;
    }

    private int g() {
        URL h10 = h();
        return h10.getPort() == -1 ? h10.getDefaultPort() : h10.getPort();
    }

    private URL h() {
        URL url = this.f6412l;
        if (url != null) {
            return url;
        }
        URL url2 = new URL(this.f6404c.a());
        this.f6412l = url2;
        return url2;
    }

    private CookieManager i() {
        CookieManager cookieManager = this.f6409i;
        if (cookieManager != null) {
            return cookieManager;
        }
        CookieManager cookieManager2 = CookieManager.getInstance();
        this.f6409i = cookieManager2;
        return cookieManager2;
    }

    public static HttpUrlHeader a(HttpResponse httpResponse) {
        HttpUrlHeader httpUrlHeader = new HttpUrlHeader();
        for (Header header : httpResponse.getAllHeaders()) {
            httpUrlHeader.setHead(header.getName(), header.getValue());
        }
        return httpUrlHeader;
    }

    private URI b() {
        String a10 = this.f6404c.a();
        String str = this.f6405d;
        if (str != null) {
            a10 = str;
        }
        if (a10 != null) {
            return new URI(a10);
        }
        throw new RuntimeException("url should not be null");
    }

    public final o a() {
        return this.f6404c;
    }

    private u a(HttpResponse httpResponse, int i10, String str) {
        ByteArrayOutputStream byteArrayOutputStream;
        String str2;
        Thread.currentThread().getId();
        HttpEntity entity = httpResponse.getEntity();
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        String str3 = null;
        if (entity == null || httpResponse.getStatusLine().getStatusCode() != 200) {
            if (entity != null) {
                return null;
            }
            httpResponse.getStatusLine().getStatusCode();
            return null;
        }
        Thread.currentThread().getId();
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            a(entity, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            this.f6415o = false;
            this.f6402a.c(System.currentTimeMillis() - currentTimeMillis);
            this.f6402a.a(byteArray.length);
            p pVar = new p(a(httpResponse), i10, str, byteArray);
            long b10 = b(httpResponse);
            Header contentType = httpResponse.getEntity().getContentType();
            if (contentType != null) {
                HashMap<String, String> a10 = a(contentType.getValue());
                str3 = a10.get(m5.h.f28414g);
                str2 = a10.get("Content-Type");
            } else {
                str2 = null;
            }
            pVar.b(str2);
            pVar.a(str3);
            pVar.a(System.currentTimeMillis());
            pVar.b(b10);
            try {
                byteArrayOutputStream.close();
                return pVar;
            } catch (IOException e10) {
                throw new RuntimeException("ArrayOutputStream close error!", e10.getCause());
            }
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream2 = byteArrayOutputStream;
            if (byteArrayOutputStream2 != null) {
                try {
                    byteArrayOutputStream2.close();
                } catch (IOException e11) {
                    throw new RuntimeException("ArrayOutputStream close error!", e11.getCause());
                }
            }
            throw th;
        }
    }

    public static HashMap<String, String> a(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        for (String str2 : str.split(";")) {
            String[] split = str2.indexOf(61) == -1 ? new String[]{"Content-Type", str2} : str2.split("=");
            hashMap.put(split[0], split[1]);
        }
        return hashMap;
    }

    private void a(HttpEntity httpEntity, OutputStream outputStream) {
        InputStream a10 = b.a(httpEntity);
        httpEntity.getContentLength();
        try {
            try {
                byte[] bArr = new byte[2048];
                while (true) {
                    int read = a10.read(bArr);
                    if (read == -1 || this.f6404c.h()) {
                        break;
                    }
                    outputStream.write(bArr, 0, read);
                    this.f6404c.f();
                }
                outputStream.flush();
                r.a(a10);
            } catch (Exception e10) {
                e10.getCause();
                throw new IOException("HttpWorker Request Error!" + e10.getLocalizedMessage());
            }
        } catch (Throwable th2) {
            r.a(a10);
            throw th2;
        }
    }
}
