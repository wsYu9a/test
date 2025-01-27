package com.vivo.ic.dm.network;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.opos.acs.st.utils.ErrorContants;
import com.vivo.ic.VLog;
import com.vivo.ic.dm.Constants;
import com.vivo.ic.dm.DownloadInfo;
import com.vivo.ic.dm.Downloads;
import com.vivo.ic.dm.StopRequestException;
import com.vivo.ic.dm.l;
import com.vivo.network.okhttp3.MediaType;
import com.vivo.network.okhttp3.OkHttpClient;
import com.vivo.network.okhttp3.Request;
import com.vivo.network.okhttp3.RequestBody;
import com.vivo.network.okhttp3.Response;
import com.vivo.network.okhttp3.ResponseBody;
import com.vivo.network.okhttp3.vivo.monitor.DataReceivedCallback;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import org.apache.http.HttpHeaders;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class i extends d {

    /* renamed from: f */
    private static final String f28560f = Constants.PRE_TAG + "HttpUrlConnectionDownload";

    /* renamed from: g */
    private static final String f28561g = "monitor";

    /* renamed from: h */
    private static final String f28562h = "00002|211";

    /* renamed from: i */
    private l f28563i = l.j();

    /* renamed from: j */
    private Request.Builder f28564j = new Request.Builder();
    private Response k;

    class a implements DataReceivedCallback {
        a() {
        }

        public void onReportData(Response response, JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(i.f28561g, jSONObject.toString());
            com.vivo.ic.dm.datareport.a.a().a(i.f28562h, hashMap);
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
            return new X509Certificate[0];
        }
    }

    public i() {
        VLog.i(f28560f, "use HttpUrlConnectionDownload");
    }

    private TrustManager[] c() {
        return new TrustManager[]{new b()};
    }

    protected void a(Context context, DownloadInfo downloadInfo, String str) {
        if (downloadInfo.getRequestClient() != null) {
            return;
        }
        try {
            OkHttpClient.Builder applicationContext = new OkHttpClient.Builder().applicationContext(context.getApplicationContext());
            if (a(new URL(str))) {
                VLog.i(f28560f, "attachDownloadInfo trust mode");
                applicationContext.sslSocketFactory(b(), d()).hostnameVerifier(g.f28537b);
            }
            OkHttpClient.Builder proxy = applicationContext.proxy(a());
            long d2 = this.f28563i.d();
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            proxy.connectTimeout(d2, timeUnit).readTimeout(this.f28563i.n(), timeUnit).followRedirects(false);
            downloadInfo.setRequestClient(applicationContext.build());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.vivo.ic.dm.network.IHttpDownload
    public void addRequestHeaders() {
        String str = null;
        String str2 = "";
        for (Pair<String, String> pair : this.f28531d.getHeaders()) {
            if (d.f28529b.equals(pair.first)) {
                str = (String) pair.second;
            } else if (d.f28530c.equals(pair.first)) {
                str2 = (String) pair.second;
            } else {
                addRequestProperty((String) pair.first, (String) pair.second);
            }
        }
        if ("post".equalsIgnoreCase(str)) {
            this.f28564j.post(RequestBody.create(MediaType.parse("application/x-www-form-urlencoded; charset=utf-8"), str2 != null ? str2 : ""));
        } else {
            this.f28564j.get();
        }
        if (this.f28564j.build().headers().get("User-Agent") == null) {
            addRequestProperty("User-Agent", this.f28531d.getUserAgent());
        }
        this.f28532e.a("mInfo.mProxyAuth:" + this.f28531d.getProxyAuth());
        if (!TextUtils.isEmpty(this.f28531d.getProxyAuth())) {
            addRequestProperty(HttpHeaders.PROXY_AUTHORIZATION, this.f28531d.getProxyAuth());
        }
        setRequestProperty(HttpHeaders.ACCEPT_ENCODING, HTTP.IDENTITY_CODING);
        setRequestProperty("Connection", "close");
    }

    @Override // com.vivo.ic.dm.network.IHttpDownload
    public void addRequestProperty(String str, String str2) {
        this.f28564j.addHeader(str, str2);
    }

    @Override // com.vivo.ic.dm.network.d, com.vivo.ic.dm.network.IHttpDownload
    public void attachDownloadInfo(Context context, DownloadInfo downloadInfo, String str, int i2) {
        super.attachDownloadInfo(context, downloadInfo, str, i2);
        this.f28532e = new com.vivo.ic.dm.network.b(f28560f, downloadInfo.getId());
        a(context, downloadInfo, str);
        this.f28564j.url(str);
    }

    public SSLSocketFactory b() {
        try {
            SSLContext sSLContext = SSLContext.getInstance("SSL");
            sSLContext.init(null, c(), new SecureRandom());
            return sSLContext.getSocketFactory();
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // com.vivo.ic.dm.network.IHttpDownload
    public void close() {
        Response response = this.k;
        if (response != null) {
            response.close();
        }
    }

    public X509TrustManager d() {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
                return (X509TrustManager) trustManagers[0];
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // com.vivo.ic.dm.network.IHttpDownload
    public String getHeader(String str) {
        ResponseBody body;
        Response response = this.k;
        if (response == null) {
            return null;
        }
        String header = response.header(str);
        if (!"Content-Length".equals(str)) {
            this.f28532e.a("getHeader key:" + str + ",headerString:" + header);
            return header;
        }
        if ((TextUtils.isEmpty(header) || header.equals("0") || header.equals(ErrorContants.NET_ERROR)) && (body = this.k.body()) != null) {
            header = body.contentLength() + "";
        }
        this.f28532e.a("getHeader key:" + str + ",contentLength:" + header);
        return header;
    }

    @Override // com.vivo.ic.dm.network.IHttpDownload
    public int getResponseCode() throws IOException {
        Response response = this.k;
        if (response != null) {
            return response.code();
        }
        throw new IOException("get response error by response is null");
    }

    @Override // com.vivo.ic.dm.network.IHttpDownload
    public InputStream openResponseEntity() throws IOException {
        Response response = this.k;
        if (response == null) {
            throw new IOException("openResponseEntity error by response is null");
        }
        ResponseBody body = response.body();
        if (body != null) {
            return body.byteStream();
        }
        throw new IOException("responseBody is null");
    }

    @Override // com.vivo.ic.dm.network.IHttpDownload
    public void sendRequest() throws StopRequestException {
        try {
            OkHttpClient requestClient = this.f28531d.getRequestClient();
            if (requestClient == null) {
                throw new IOException("sendRequest error by okHttpClient is null");
            }
            this.k = requestClient.newCall(this.f28564j.build(), new a()).execute(true);
        } catch (IOException e2) {
            this.f28532e.a("sendRequest", e2);
            throw new StopRequestException(StopRequestException.a(this.f28531d), "while trying to execute request: " + e2, e2);
        } catch (IllegalArgumentException e3) {
            this.f28532e.a("sendRequest", e3);
            throw new StopRequestException(Downloads.Impl.STATUS_HTTP_DATA_ERROR, "while trying to execute request: " + e3, e3);
        }
    }

    @Override // com.vivo.ic.dm.network.IHttpDownload
    public void setRequestProperty(String str, String str2) {
        this.f28564j.header(str, str2);
    }

    private boolean a(URL url) {
        DownloadInfo downloadInfo;
        return url.getProtocol().toLowerCase().startsWith(b.b.a.b.b.f4198a) && (downloadInfo = this.f28531d) != null && downloadInfo.isSkipHttpsVerify();
    }
}
