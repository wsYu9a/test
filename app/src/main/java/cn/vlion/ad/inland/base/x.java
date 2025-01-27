package cn.vlion.ad.inland.base;

import cn.vlion.ad.inland.base.util.log.LogVlion;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.OkHttpClient;

/* loaded from: classes.dex */
public final class x {

    /* renamed from: a */
    public static final OkHttpClient f3488a;

    public class a implements X509TrustManager {
        @Override // javax.net.ssl.X509TrustManager
        public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        @Override // javax.net.ssl.X509TrustManager
        public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        @Override // javax.net.ssl.X509TrustManager
        public final X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    public class b implements HostnameVerifier {
        @Override // javax.net.ssl.HostnameVerifier
        public final boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    }

    static {
        OkHttpClient.Builder newBuilder = new OkHttpClient().newBuilder();
        try {
            TrustManager[] trustManagerArr = {new a()};
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, trustManagerArr, new SecureRandom());
            newBuilder.sslSocketFactory(sSLContext.getSocketFactory(), (X509TrustManager) trustManagerArr[0]);
            newBuilder.hostnameVerifier(new b());
            TimeUnit timeUnit = TimeUnit.SECONDS;
            newBuilder.connectTimeout(5L, timeUnit);
            newBuilder.readTimeout(20L, timeUnit);
            newBuilder.writeTimeout(20L, timeUnit);
        } catch (Exception e10) {
            LogVlion.e("OkHttpClientUtils Exception:" + e10);
        }
        f3488a = newBuilder.build();
    }
}
