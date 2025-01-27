package b.d.e.c.a.j;

import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mobads.sdk.internal.am;
import com.martian.rpauth.MartianRPUserManager;
import com.martian.ttbook.b.a.g.b;
import com.martian.ttbook.b.a.k.n;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SignatureException;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: b.d.e.c.a.j.a$a */
    static class C0026a implements g {

        /* renamed from: a */
        final /* synthetic */ f f4640a;

        C0026a(f fVar) {
            this.f4640a = fVar;
        }

        @Override // b.d.e.c.a.j.a.g
        public void a(int i2, byte[] bArr, b.d.e.c.a.f.e eVar) {
            JSONObject jSONObject = null;
            if (eVar == null) {
                if (bArr == null) {
                    return;
                }
                try {
                    jSONObject = new JSONObject(new String(bArr, "UTF-8"));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            this.f4640a.a(i2, jSONObject, eVar);
        }
    }

    static class b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f4641a;

        /* renamed from: b */
        final /* synthetic */ Map f4642b;

        /* renamed from: c */
        final /* synthetic */ byte[] f4643c;

        /* renamed from: d */
        final /* synthetic */ g f4644d;

        b(String str, Map map, byte[] bArr, g gVar) {
            this.f4641a = str;
            this.f4642b = map;
            this.f4643c = bArr;
            this.f4644d = gVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [b.d.e.c.a.j.a$g] */
        /* JADX WARN: Type inference failed for: r3v7, types: [b.d.e.c.a.f.e] */
        /* JADX WARN: Type inference failed for: r4v1, types: [b.d.e.c.a.f.e] */
        /* JADX WARN: Type inference failed for: r4v11 */
        /* JADX WARN: Type inference failed for: r4v7 */
        @Override // java.lang.Runnable
        public void run() {
            ?? r4;
            byte[] bArr;
            byte[] bArr2 = null;
            int i2 = -1;
            try {
                URL url = new URL(this.f4641a);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                a.i(url, httpURLConnection);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                Map map = this.f4642b;
                if (map != null) {
                    for (String str : map.keySet()) {
                        httpURLConnection.setRequestProperty(str, (String) this.f4642b.get(str));
                    }
                }
                httpURLConnection.setRequestProperty("Content-length", Integer.toString(this.f4643c.length));
                httpURLConnection.connect();
                httpURLConnection.getOutputStream().write(this.f4643c);
                i2 = httpURLConnection.getResponseCode();
                if (i2 == 200) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] bArr3 = new byte[1024];
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                    while (true) {
                        int read = bufferedInputStream.read(bArr3, 0, 1024);
                        if (read <= 0) {
                            break;
                        } else {
                            byteArrayOutputStream.write(bArr3, 0, read);
                        }
                    }
                    String str2 = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                    b.d.e.c.a.d.n(str2, "api response");
                    bArr = str2.getBytes();
                } else {
                    bArr = null;
                    bArr2 = new b.d.e.c.a.f.e(MartianRPUserManager.f14921h, "HTTP error，statusCode=" + i2);
                }
                r4 = bArr2;
                bArr2 = bArr;
            } catch (Exception e2) {
                r4 = new b.d.e.c.a.f.e(MartianRPUserManager.f14921h, "HTTP error, response encoding error." + e2.getMessage());
            }
            this.f4644d.a(i2, bArr2, r4);
        }
    }

    static class c implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f4645a;

        /* renamed from: b */
        final /* synthetic */ Map f4646b;

        /* renamed from: c */
        final /* synthetic */ g f4647c;

        c(String str, Map map, g gVar) {
            this.f4645a = str;
            this.f4646b = map;
            this.f4647c = gVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [b.d.e.c.a.j.a$g] */
        /* JADX WARN: Type inference failed for: r3v6, types: [b.d.e.c.a.f.e] */
        /* JADX WARN: Type inference failed for: r4v1, types: [b.d.e.c.a.f.e] */
        /* JADX WARN: Type inference failed for: r4v10 */
        /* JADX WARN: Type inference failed for: r4v7 */
        @Override // java.lang.Runnable
        public void run() {
            ?? r4;
            byte[] bArr;
            byte[] bArr2 = null;
            int i2 = -1;
            try {
                URL url = new URL(this.f4645a);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                a.i(url, httpURLConnection);
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setDoOutput(false);
                httpURLConnection.setUseCaches(false);
                Map map = this.f4646b;
                if (map != null) {
                    for (String str : map.keySet()) {
                        httpURLConnection.setRequestProperty(str, (String) this.f4646b.get(str));
                    }
                }
                httpURLConnection.connect();
                i2 = httpURLConnection.getResponseCode();
                if (i2 == 200) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] bArr3 = new byte[1024];
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                    while (true) {
                        int read = bufferedInputStream.read(bArr3, 0, 1024);
                        if (read <= 0) {
                            break;
                        } else {
                            byteArrayOutputStream.write(bArr3, 0, read);
                        }
                    }
                    bArr = byteArrayOutputStream.toByteArray();
                } else {
                    bArr = null;
                    bArr2 = new b.d.e.c.a.f.e(MartianRPUserManager.f14921h, "HTTP error，statusCode=" + i2);
                }
                r4 = bArr2;
                bArr2 = bArr;
            } catch (Exception e2) {
                r4 = new b.d.e.c.a.f.e(MartianRPUserManager.f14921h, "HTTP error, response encoding error." + e2.getMessage());
            }
            this.f4647c.a(i2, bArr2, r4);
        }
    }

    static class d implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f4648a;

        /* renamed from: b */
        final /* synthetic */ JSONObject f4649b;

        /* renamed from: c */
        final /* synthetic */ Map f4650c;

        /* renamed from: b.d.e.c.a.j.a$d$a */
        class C0027a implements b.a {
            C0027a(d dVar) {
            }
        }

        d(String str, JSONObject jSONObject, Map map, f fVar) {
            this.f4648a = str;
            this.f4649b = jSONObject;
            this.f4650c = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.martian.ttbook.b.a.g.a.f().e().b(this.f4648a, this.f4649b, this.f4650c, new C0027a(this));
        }
    }

    static class e implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f4651a;

        /* renamed from: b */
        final /* synthetic */ Map f4652b;

        /* renamed from: b.d.e.c.a.j.a$e$a */
        class C0028a implements b.a {
            C0028a(e eVar) {
            }
        }

        e(String str, Map map, g gVar) {
            this.f4651a = str;
            this.f4652b = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.martian.ttbook.b.a.g.a.f().e().a(this.f4651a, this.f4652b, new C0028a(this));
        }
    }

    public interface f {
        void a(int i2, JSONObject jSONObject, b.d.e.c.a.f.e eVar);
    }

    public interface g {
        void a(int i2, byte[] bArr, b.d.e.c.a.f.e eVar);
    }

    static class h implements X509TrustManager {

        /* renamed from: a */
        private X509TrustManager f4653a;

        /* renamed from: b */
        private X509Certificate f4654b;

        public h(X509TrustManager x509TrustManager, X509Certificate x509Certificate) {
            this.f4653a = x509TrustManager;
            this.f4654b = x509Certificate;
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
            this.f4653a.checkClientTrusted(x509CertificateArr, str);
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
            for (X509Certificate x509Certificate : x509CertificateArr) {
                if (x509Certificate.getIssuerX500Principal().equals(this.f4654b.getIssuerX500Principal())) {
                    try {
                        x509Certificate.verify(this.f4654b.getPublicKey());
                        return;
                    } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchProviderException | SignatureException unused) {
                        continue;
                    }
                }
            }
            this.f4653a.checkServerTrusted(x509CertificateArr, str);
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return this.f4653a.getAcceptedIssuers();
        }
    }

    public static SSLSocketFactory a() {
        try {
            int i2 = 0;
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Base64.decode("MIIEHjCCAwagAwIBAgIJAIz0UfswQAzYMA0GCSqGSIb3DQEBCwUAMIGbMQswCQYDVQQGEwJDTjELMAkGA1UECAwCQkoxCzAJBgNVBAcMAkJKMQswCQYDVQQLDAJPTjEgMB4GA1UECgwXT25lIHdvcmxkIG9uZSBkcmVhbSBMdGQxDTALBgNVBAsMBFRFQ0gxDzANBgNVBAMMBkNBUk9PVDEjMCEGCSqGSIb3DQEJARYUd2VibWFzdGVyQG9uZW9uZS5jb20wHhcNMjAwNzA2MjI1OTEyWhcNMzAwNzA0MjI1OTEyWjCBmzELMAkGA1UEBhMCQ04xCzAJBgNVBAgMAkJKMQswCQYDVQQHDAJCSjELMAkGA1UECwwCT04xIDAeBgNVBAoMF09uZSB3b3JsZCBvbmUgZHJlYW0gTHRkMQ0wCwYDVQQLDARURUNIMQ8wDQYDVQQDDAZDQVJPT1QxIzAhBgkqhkiG9w0BCQEWFHdlYm1hc3RlckBvbmVvbmUuY29tMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvsdCiOnGwBFIg0hk6wehDgudAQIVngYtEzwENZtRLI6kIOnHuoFwbguRM3NqJ9iqv9eDCYR8x8PDOJxQRGDU4SlVHd48PkXt1aUrBtM6ZfqJHmIRYj+y8soMklj0Q0GwKccu0xnbDmuJcvZcEReNfvHkxvZyipeMidgn5GSSbtFTS/hOfVaoIpzXezDOd8erZf2to0GVBvhchjfKUIN/WB96jc3dSBTUAEZXslhdGWpkIr5yJR7x1ct3t87feOxTskoil5QCAfVFuyG+FBfbX6zMk/54EcBvQQ/m0YomBVIRF5XpuklcNlGgg0SKr4VxDgnBdMQFPi6NQr3ewdzkGQIDAQABo2MwYTAdBgNVHQ4EFgQU8VQ9G/ONTK60LYWP3RacxQGLvw4wHwYDVR0jBBgwFoAU8VQ9G/ONTK60LYWP3RacxQGLvw4wDwYDVR0TAQH/BAUwAwEB/zAOBgNVHQ8BAf8EBAMCAYYwDQYJKoZIhvcNAQELBQADggEBAJIGfXCqOWrkfiu9+PKf4oecZw+r6fXUuz3l51NvpNpPJhdVFaW0vwkpAAjMy5Zhn7uvmZCoSxjoi17ZfSV4BS+dd5uIU6tXO/KGGGipChdBxpn+CfWBPcikaSjJuilth4EPORVzQptDo2wZPiu0M2ez8+Q4XuzzhTqyLgOMFSpvs6qUBxmVaF0+MLVwsIBMsLi1P7b6ovgVnTUnrRd0fg6xf0hGUPknxpRS2FloHH+BEcU5opDzoHc3Ddfztf6Wr5Y47LfzJimMFO7S3Cw8zbMCOvVsQSatMri5RvK/ExtllSHfyQ97OGAh+V0XkMTD7BpFS/LvZiKFSeGUJV1w4OI=", 0));
            Certificate generateCertificate = CertificateFactory.getInstance("X.509").generateCertificate(byteArrayInputStream);
            byteArrayInputStream.close();
            X509Certificate x509Certificate = (X509Certificate) generateCertificate;
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null, null);
            keyStore.setCertificateEntry("ca", generateCertificate);
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStore);
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            while (true) {
                if (i2 >= trustManagers.length) {
                    break;
                }
                if (trustManagers[i2] instanceof X509TrustManager) {
                    trustManagers[i2] = new h((X509TrustManager) trustManagers[i2], x509Certificate);
                    break;
                }
                i2++;
            }
            sSLContext.init(null, trustManagers, null);
            return sSLContext.getSocketFactory();
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        } catch (GeneralSecurityException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public static void b(String str, Map<String, String> map, g gVar) {
        if (!com.martian.ttbook.b.a.g.a.f().h() || com.martian.ttbook.b.a.g.a.f().e() == null) {
            n.b(new c(str, map, gVar));
        } else {
            g(str, map, gVar);
        }
    }

    public static void c(String str, JSONObject jSONObject, Map<String, String> map, f fVar) {
        if (com.martian.ttbook.b.a.g.a.f().h() && com.martian.ttbook.b.a.g.a.f().e() != null) {
            h(str, jSONObject, map, fVar);
            return;
        }
        try {
            byte[] bytes = jSONObject.toString().getBytes("UTF-8");
            if (map == null) {
                map = new HashMap<>();
            }
            map.put("Content-type", am.f5520d);
            d(str, bytes, map, new C0026a(fVar));
        } catch (UnsupportedEncodingException unused) {
        }
    }

    public static void d(String str, byte[] bArr, Map<String, String> map, g gVar) {
        n.b(new b(str, map, bArr, gVar));
    }

    private static boolean f(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("[0-9]*").matcher(str.replace(".", "")).matches();
    }

    private static void g(String str, Map<String, String> map, g gVar) {
        n.b(new e(str, map, gVar));
    }

    private static void h(String str, JSONObject jSONObject, Map<String, String> map, f fVar) {
        n.b(new d(str, jSONObject, map, fVar));
    }

    public static void i(URL url, HttpURLConnection httpURLConnection) {
        if (b.b.a.b.b.f4198a.equals(url.getProtocol()) && f(url.getHost())) {
            ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(a());
        }
    }
}
