package com.opos.cmn.an.g.a.a;

import android.content.Context;
import android.net.Proxy;
import android.os.Build;
import com.opos.cmn.an.g.f;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes4.dex */
public abstract class a {

    /* renamed from: a */
    protected Context f16478a;

    /* renamed from: b */
    protected f f16479b;

    /* renamed from: c */
    protected HttpURLConnection f16480c = a();

    public a(Context context, f fVar) {
        this.f16478a = context;
        this.f16479b = fVar;
        com.opos.cmn.an.f.a.b("HttpURLBaseTask", "init HttpURLBaseTask");
    }

    private HttpURLConnection a() {
        com.opos.cmn.an.f.a.b("HttpURLBaseTask", "start openConnection");
        c();
        HttpURLConnection httpURLConnection = null;
        if (!com.opos.cmn.an.c.a.a(this.f16479b.f16495c)) {
            try {
                URL url = new URL(this.f16479b.f16495c);
                httpURLConnection = (HttpURLConnection) (com.opos.cmn.an.h.c.a.c(this.f16478a) ? !com.opos.cmn.an.c.a.a(Proxy.getDefaultHost()) ? url.openConnection(b()) : url.openConnection() : url.openConnection());
                c(httpURLConnection);
                a(httpURLConnection);
                b(httpURLConnection);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("HttpURLBaseTask", "", e2);
            }
        }
        com.opos.cmn.an.f.a.b("HttpURLBaseTask", "end openConnection");
        return httpURLConnection;
    }

    private void a(HttpURLConnection httpURLConnection) throws ProtocolException {
        if (httpURLConnection != null) {
            httpURLConnection.setConnectTimeout(this.f16479b.f16497e);
            httpURLConnection.setReadTimeout(this.f16479b.f16498f);
            httpURLConnection.setDoInput(true);
            if ("GET".equals(this.f16479b.f16494b)) {
                httpURLConnection.setUseCaches(true);
            } else if ("POST".equals(this.f16479b.f16494b)) {
                httpURLConnection.setDoOutput(true);
            }
            httpURLConnection.setRequestMethod(this.f16479b.f16494b);
        }
    }

    private java.net.Proxy b() {
        return new java.net.Proxy(Proxy.Type.HTTP, new InetSocketAddress(android.net.Proxy.getDefaultHost(), android.net.Proxy.getDefaultPort()));
    }

    private void b(HttpURLConnection httpURLConnection) {
        Map<String, String> map;
        if (httpURLConnection == null || (map = this.f16479b.f16496d) == null || map.size() <= 0) {
            return;
        }
        for (Map.Entry<String, String> entry : this.f16479b.f16496d.entrySet()) {
            if (entry != null) {
                String key = entry.getKey();
                String value = entry.getValue();
                StringBuilder sb = new StringBuilder();
                sb.append("setRequestHeader key=");
                sb.append(key != null ? key : "null");
                sb.append(",value=");
                sb.append(value != null ? value : "null");
                com.opos.cmn.an.f.a.b("HttpURLBaseTask", sb.toString());
                httpURLConnection.setRequestProperty(key, value);
            }
        }
    }

    private void c() {
        if (Build.VERSION.SDK_INT < 8) {
            System.setProperty("http.keepAlive", "false");
        }
    }

    private void c(HttpURLConnection httpURLConnection) {
        if (httpURLConnection instanceof HttpsURLConnection) {
            try {
                SSLSocketFactory sSLSocketFactory = this.f16479b.f16500h;
                if (sSLSocketFactory != null) {
                    ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(sSLSocketFactory);
                } else {
                    long currentTimeMillis = System.currentTimeMillis();
                    SSLSocketFactory d2 = d();
                    if (d2 != null) {
                        ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(d2);
                    }
                    com.opos.cmn.an.f.a.b("HttpURLBaseTask", "setHttpsPropertyIfNeed sslSocketFactory == null, time = " + (System.currentTimeMillis() - currentTimeMillis));
                }
                HostnameVerifier hostnameVerifier = this.f16479b.f16501i;
                if (hostnameVerifier != null) {
                    ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(hostnameVerifier);
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("HttpURLBaseTask", "setHttpsPropertyIfNeed", e2);
            }
        }
    }

    private static SSLSocketFactory d() {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, null, null);
            return sSLContext.getSocketFactory();
        } catch (GeneralSecurityException unused) {
            return null;
        }
    }
}
