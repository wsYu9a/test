package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import com.kwad.sdk.core.network.q;
import com.kwad.sdk.core.network.s;
import com.kwad.sdk.utils.ao;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import org.apache.http.HttpHeaders;

/* loaded from: classes2.dex */
public final class h implements l {
    private m anS;
    private HttpURLConnection anT;
    private InputStream anU;
    private final com.kwad.sdk.core.videocache.c.b anw;
    private final com.kwad.sdk.core.videocache.a.b anx;

    public h(h hVar) {
        this.anS = hVar.anS;
        this.anw = hVar.anw;
        this.anx = hVar.anx;
    }

    public h(String str, com.kwad.sdk.core.videocache.c.b bVar, com.kwad.sdk.core.videocache.a.b bVar2) {
        this.anw = (com.kwad.sdk.core.videocache.c.b) ao.checkNotNull(bVar);
        this.anx = (com.kwad.sdk.core.videocache.a.b) ao.checkNotNull(bVar2);
        m db = bVar.db(str);
        this.anS = db == null ? new m(str, -2147483648L, k.cZ(str)) : db;
    }

    private long a(HttpURLConnection httpURLConnection, long j2, int i2) {
        long c2 = c(httpURLConnection);
        return i2 == 200 ? c2 : i2 == 206 ? c2 + j2 : this.anS.aoh;
    }

    private void a(HttpURLConnection httpURLConnection, String str) {
        for (Map.Entry<String, String> entry : this.anx.yM().entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    private static long c(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("Content-Length");
        if (headerField == null) {
            return -1L;
        }
        return Long.parseLong(headerField);
    }

    private HttpURLConnection c(long j2, int i2) {
        String str;
        HttpURLConnection httpURLConnection;
        boolean z;
        String str2 = this.anS.url;
        int i3 = 0;
        do {
            StringBuilder sb = new StringBuilder("Open connection ");
            if (j2 > 0) {
                str = " with offset " + j2;
            } else {
                str = "";
            }
            sb.append(str);
            sb.append(" to ");
            sb.append(str2);
            com.kwad.sdk.core.d.b.d("HttpUrlSource", sb.toString());
            httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
            s.wrapHttpURLConnection(httpURLConnection);
            a(httpURLConnection, str2);
            if (j2 > 0) {
                httpURLConnection.setRequestProperty(HttpHeaders.RANGE, "bytes=" + j2 + "-");
            }
            if (i2 > 0) {
                httpURLConnection.setConnectTimeout(i2);
                httpURLConnection.setReadTimeout(i2);
            }
            q.b(httpURLConnection);
            int responseCode = httpURLConnection.getResponseCode();
            z = responseCode == 301 || responseCode == 302 || responseCode == 303;
            if (z) {
                str2 = httpURLConnection.getHeaderField(HttpHeaders.LOCATION);
                i3++;
                httpURLConnection.disconnect();
            }
            if (i3 > 5) {
                throw new ProxyCacheException("Too many redirects: " + i3);
            }
        } while (z);
        return httpURLConnection;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.net.URLConnection] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.net.URLConnection] */
    private void yE() {
        HttpURLConnection httpURLConnection;
        com.kwad.sdk.core.d.b.d("HttpUrlSource", "Read content info from " + this.anS.url);
        ?? r0 = 10000;
        InputStream inputStream = null;
        try {
            try {
                httpURLConnection = c(0L, 10000);
            } catch (IOException unused) {
                httpURLConnection = null;
            } catch (Throwable th) {
                th = th;
                r0 = 0;
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                com.kwad.sdk.crash.utils.b.a(r0);
                throw th;
            }
            try {
                long c2 = c(httpURLConnection);
                String contentType = httpURLConnection.getContentType();
                inputStream = httpURLConnection.getInputStream();
                m mVar = new m(this.anS.url, c2, contentType);
                this.anS = mVar;
                this.anw.a(mVar.url, mVar);
                com.kwad.sdk.core.d.b.d("HttpUrlSource", "Source info fetched: " + this.anS);
                r0 = httpURLConnection;
            } catch (IOException unused2) {
                com.kwad.sdk.core.d.b.e("HttpUrlSource", "Error fetching info from " + this.anS.url);
                r0 = httpURLConnection;
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                com.kwad.sdk.crash.utils.b.a(r0);
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
            com.kwad.sdk.crash.utils.b.a(r0);
        } catch (Throwable th2) {
            th = th2;
            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
            com.kwad.sdk.crash.utils.b.a(r0);
            throw th;
        }
    }

    @Override // com.kwad.sdk.core.videocache.l
    public final void V(long j2) {
        try {
            HttpURLConnection c2 = c(j2, -1);
            this.anT = c2;
            String contentType = c2.getContentType();
            this.anU = new BufferedInputStream(this.anT.getInputStream(), 8192);
            HttpURLConnection httpURLConnection = this.anT;
            m mVar = new m(this.anS.url, a(httpURLConnection, j2, httpURLConnection.getResponseCode()), contentType);
            this.anS = mVar;
            this.anw.a(mVar.url, mVar);
        } catch (IOException e2) {
            throw new ProxyCacheException("Error opening connection for " + this.anS.url + " with offset " + j2, e2);
        }
    }

    @Override // com.kwad.sdk.core.videocache.l
    public final void close() {
        HttpURLConnection httpURLConnection = this.anT;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (ArrayIndexOutOfBoundsException unused) {
                com.kwad.sdk.core.d.b.e("HttpUrlSource", "Error closing connection correctly. Should happen only on Android L. If anybody know how to fix it, please visit https://github.com/danikula/AndroidVideoCache/issues/88. Until good solution is not know, just ignore this issue.");
            } catch (IllegalArgumentException e2) {
                e = e2;
                throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e);
            } catch (NullPointerException e3) {
                e = e3;
                throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e);
            }
        }
    }

    @Override // com.kwad.sdk.core.videocache.l
    public final synchronized long length() {
        if (this.anS.aoh == -2147483648L) {
            yE();
        }
        return this.anS.aoh;
    }

    @Override // com.kwad.sdk.core.videocache.l
    public final int read(byte[] bArr) {
        InputStream inputStream = this.anU;
        if (inputStream == null) {
            throw new ProxyCacheException("Error reading data from " + this.anS.url + ": connection is absent!");
        }
        try {
            return inputStream.read(bArr, 0, 8192);
        } catch (InterruptedIOException e2) {
            throw new InterruptedProxyCacheException("Reading source " + this.anS.url + " is interrupted", e2);
        } catch (IOException e3) {
            throw new ProxyCacheException("Error reading data from " + this.anS.url, e3);
        }
    }

    public final String toString() {
        return "HttpUrlSource{sourceInfo='" + this.anS + "}";
    }

    public final synchronized String yF() {
        if (TextUtils.isEmpty(this.anS.aoi)) {
            yE();
        }
        return this.anS.aoi;
    }
}
