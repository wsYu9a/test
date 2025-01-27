package com.vivo.ic.dm.network;

import com.vivo.ic.VLog;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes4.dex */
public class g {

    /* renamed from: a */
    private static final String f28536a = "HttpsTrustHelper";

    /* renamed from: b */
    public static final HostnameVerifier f28537b = new a();

    /* renamed from: c */
    private static TrustManager[] f28538c = {new b()};

    class a implements HostnameVerifier {
        a() {
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            VLog.d(g.f28536a, "DO_NOT_VERIFY verify()");
            return true;
        }
    }

    class b implements X509TrustManager {
        b() {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            VLog.d(g.f28536a, "TRUST_ALL getAcceptedIssuers");
            return new X509Certificate[0];
        }
    }

    public static synchronized SSLSocketFactory a() {
        SSLSocketFactory socketFactory;
        synchronized (g.class) {
            VLog.d(f28536a, "getTrustAllHostsSSLSocketFactory()");
            try {
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                sSLContext.init(null, f28538c, new SecureRandom());
                socketFactory = sSLContext.getSocketFactory();
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return socketFactory;
    }
}
