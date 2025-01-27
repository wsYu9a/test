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
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.HttpHeaders;
import org.apache.http.protocol.HTTP;

/* loaded from: classes4.dex */
public class f extends d {

    /* renamed from: f */
    private static final String f28533f = Constants.PRE_TAG + "HttpUrlConnectionDownload";

    /* renamed from: g */
    private HttpURLConnection f28534g;

    /* renamed from: h */
    private l f28535h = l.j();

    public f() {
        VLog.i(f28533f, "use HttpUrlConnectionDownload");
    }

    private boolean a(Pair<String, String> pair) {
        if (!d.f28529b.equals(pair.first)) {
            return d.f28530c.equals(pair.first);
        }
        try {
            this.f28534g.setRequestMethod((String) pair.second);
        } catch (ProtocolException e2) {
            e2.printStackTrace();
        }
        return true;
    }

    private String b() {
        for (Pair<String, String> pair : this.f28531d.getHeaders()) {
            if (d.f28530c.equals(pair.first)) {
                return (String) pair.second;
            }
        }
        return null;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x003a -> B:8:0x003d). Please report as a decompilation issue!!! */
    private boolean c() {
        String b2 = b();
        if (TextUtils.isEmpty(b2)) {
            return false;
        }
        this.f28534g.setDoOutput(true);
        OutputStream outputStream = null;
        try {
            try {
                try {
                    outputStream = this.f28534g.getOutputStream();
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
                    outputStreamWriter.write(b2);
                    outputStreamWriter.flush();
                    outputStreamWriter.close();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                } catch (Throwable th) {
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e3) {
                e3.printStackTrace();
                if (outputStream != null) {
                    outputStream.close();
                }
            }
        } catch (IOException e4) {
            e4.printStackTrace();
        }
        return true;
    }

    @Override // com.vivo.ic.dm.network.IHttpDownload
    public void addRequestHeaders() {
        for (Pair<String, String> pair : this.f28531d.getHeaders()) {
            if (!a(pair)) {
                this.f28534g.addRequestProperty((String) pair.first, (String) pair.second);
            }
        }
        if (this.f28534g.getRequestProperty("User-Agent") == null) {
            this.f28534g.addRequestProperty("User-Agent", this.f28531d.getUserAgent());
        }
        this.f28532e.a("mInfo.mProxyAuth:" + this.f28531d.getProxyAuth());
        if (!TextUtils.isEmpty(this.f28531d.getProxyAuth())) {
            this.f28534g.addRequestProperty(HttpHeaders.PROXY_AUTHORIZATION, this.f28531d.getProxyAuth());
        }
        this.f28534g.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, HTTP.IDENTITY_CODING);
        this.f28534g.setRequestProperty("Connection", "close");
    }

    @Override // com.vivo.ic.dm.network.IHttpDownload
    public void addRequestProperty(String str, String str2) {
        this.f28534g.addRequestProperty(str, str2);
    }

    @Override // com.vivo.ic.dm.network.d, com.vivo.ic.dm.network.IHttpDownload
    public void attachDownloadInfo(Context context, DownloadInfo downloadInfo, String str, int i2) {
        super.attachDownloadInfo(context, downloadInfo, str, i2);
        try {
            URL url = new URL(str);
            if (a(url)) {
                VLog.i(f28533f, "attachDownloadInfo trust mode");
                this.f28534g = a(url, i2);
            } else {
                VLog.i(f28533f, "attachDownloadInfo default mode");
                this.f28534g = (HttpURLConnection) h.a().a(url, a(), i2);
            }
            this.f28534g.setInstanceFollowRedirects(false);
            this.f28534g.setConnectTimeout(this.f28535h.d());
            this.f28534g.setReadTimeout(this.f28535h.n());
        } catch (Exception e2) {
            e2.printStackTrace();
            VLog.w(f28533f, "attachDownloadInfo error", e2);
        }
        this.f28532e = new b(f28533f, downloadInfo.getId());
    }

    @Override // com.vivo.ic.dm.network.IHttpDownload
    public void close() {
        HttpURLConnection httpURLConnection = this.f28534g;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    @Override // com.vivo.ic.dm.network.IHttpDownload
    public String getHeader(String str) {
        String headerField = this.f28534g.getHeaderField(str);
        if (!"Content-Length".equals(str)) {
            this.f28532e.a("getHeader key:" + str + ",headerString:" + headerField);
            return headerField;
        }
        String headerField2 = this.f28534g.getHeaderField(str);
        if (TextUtils.isEmpty(headerField2) || headerField2.equals("0") || headerField2.equals(ErrorContants.NET_ERROR)) {
            headerField2 = String.valueOf(this.f28534g.getContentLength());
        }
        this.f28532e.a("getHeader key:" + str + ",contentLength:" + headerField2);
        return headerField2;
    }

    @Override // com.vivo.ic.dm.network.IHttpDownload
    public int getResponseCode() throws IOException {
        return this.f28534g.getResponseCode();
    }

    @Override // com.vivo.ic.dm.network.IHttpDownload
    public InputStream openResponseEntity() throws IOException {
        return this.f28534g.getInputStream();
    }

    @Override // com.vivo.ic.dm.network.IHttpDownload
    public void sendRequest() throws StopRequestException {
        if (c()) {
            this.f28532e.b("sendRequest post ");
            return;
        }
        try {
            this.f28534g.connect();
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
        this.f28534g.setRequestProperty(str, str2);
    }

    private HttpURLConnection a(URL url, int i2) throws IOException {
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) h.a().a(url, a(), i2);
        httpsURLConnection.setHostnameVerifier(g.f28537b);
        SSLSocketFactory a2 = g.a();
        if (a2 != null) {
            httpsURLConnection.setSSLSocketFactory(a2);
        }
        return httpsURLConnection;
    }

    private boolean a(URL url) {
        DownloadInfo downloadInfo;
        return url.getProtocol().toLowerCase().startsWith(b.b.a.b.b.f4198a) && (downloadInfo = this.f28531d) != null && downloadInfo.isSkipHttpsVerify();
    }
}
