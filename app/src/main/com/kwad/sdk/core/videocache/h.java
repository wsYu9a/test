package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import com.kwad.sdk.core.network.r;
import com.kwad.sdk.utils.au;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/* loaded from: classes3.dex */
public final class h extends p {
    private n aGA;
    private HttpURLConnection aGB;
    private InputStream aGC;
    private final com.kwad.sdk.core.videocache.d.c aGc;
    private final com.kwad.sdk.core.videocache.b.b aGd;

    public h(String str, com.kwad.sdk.core.videocache.d.c cVar, com.kwad.sdk.core.videocache.b.b bVar) {
        this.aGc = (com.kwad.sdk.core.videocache.d.c) au.checkNotNull(cVar);
        this.aGd = (com.kwad.sdk.core.videocache.b.b) au.checkNotNull(bVar);
        n eV = cVar.eV(str);
        this.aGA = eV == null ? new n(str, -2147483648L, l.eT(str)) : eV;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.net.URLConnection] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.net.URLConnection] */
    private void Im() {
        HttpURLConnection httpURLConnection;
        com.kwad.sdk.core.d.c.d("HttpUrlSource", "Read content info from " + this.aGA.url);
        ?? r02 = 10000;
        InputStream inputStream = null;
        try {
            try {
                httpURLConnection = c(0L, 10000);
            } catch (IOException unused) {
                httpURLConnection = null;
            } catch (Throwable th2) {
                th = th2;
                r02 = 0;
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                com.kwad.sdk.crash.utils.b.a(r02);
                throw th;
            }
            try {
                long d10 = d(httpURLConnection);
                String contentType = httpURLConnection.getContentType();
                inputStream = httpURLConnection.getInputStream();
                n nVar = new n(this.aGA.url, d10, contentType);
                this.aGA = nVar;
                this.aGc.a(nVar.url, nVar);
                com.kwad.sdk.core.d.c.d("HttpUrlSource", "Source info fetched: " + this.aGA);
                r02 = httpURLConnection;
            } catch (IOException unused2) {
                com.kwad.sdk.core.d.c.e("HttpUrlSource", "Error fetching info from " + this.aGA.url);
                r02 = httpURLConnection;
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                com.kwad.sdk.crash.utils.b.a(r02);
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
            com.kwad.sdk.crash.utils.b.a(r02);
        } catch (Throwable th3) {
            th = th3;
            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
            com.kwad.sdk.crash.utils.b.a(r02);
            throw th;
        }
    }

    private void Io() {
        n eV;
        com.kwad.sdk.core.videocache.d.c cVar = this.aGc;
        if (cVar == null || !(cVar instanceof com.kwad.sdk.core.videocache.d.b) || (eV = cVar.eV(getUrl())) == null || TextUtils.isEmpty(eV.aGR) || eV.aGQ == -2147483648L) {
            return;
        }
        this.aGA = eV;
    }

    private long a(HttpURLConnection httpURLConnection, long j10, int i10) {
        long d10 = d(httpURLConnection);
        return i10 == 200 ? d10 : i10 == 206 ? d10 + j10 : this.aGA.aGQ;
    }

    private HttpURLConnection c(long j10, int i10) {
        String str;
        HttpURLConnection httpURLConnection;
        boolean z10;
        String str2 = this.aGA.url;
        int i11 = 0;
        do {
            StringBuilder sb2 = new StringBuilder("Open connection ");
            if (j10 > 0) {
                str = " with offset " + j10;
            } else {
                str = "";
            }
            sb2.append(str);
            sb2.append(" to ");
            sb2.append(str2);
            com.kwad.sdk.core.d.c.d("HttpUrlSource", sb2.toString());
            httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
            r.wrapHttpURLConnection(httpURLConnection);
            a(httpURLConnection, str2);
            if (j10 > 0) {
                httpURLConnection.setRequestProperty("Range", "bytes=" + j10 + "-");
            }
            if (i10 > 0) {
                httpURLConnection.setConnectTimeout(i10);
                httpURLConnection.setReadTimeout(i10);
            }
            com.kwad.sdk.core.network.p.b(httpURLConnection);
            int responseCode = httpURLConnection.getResponseCode();
            z10 = responseCode == 301 || responseCode == 302 || responseCode == 303;
            if (z10) {
                str2 = httpURLConnection.getHeaderField(m5.c.f28347t0);
                i11++;
                httpURLConnection.disconnect();
            }
            if (i11 > 5) {
                throw new ProxyCacheException("Too many redirects: " + i11);
            }
        } while (z10);
        return httpURLConnection;
    }

    private static long d(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("Content-Length");
        if (headerField == null) {
            return -1L;
        }
        return Long.parseLong(headerField);
    }

    @Override // com.kwad.sdk.core.videocache.p
    public final synchronized String In() {
        try {
            if (TextUtils.isEmpty(this.aGA.aGR)) {
                Io();
            }
            if (TextUtils.isEmpty(this.aGA.aGR)) {
                Im();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.aGA.aGR;
    }

    @Override // com.kwad.sdk.core.videocache.m
    public final void aC(long j10) {
        try {
            HttpURLConnection c10 = c(j10, -1);
            this.aGB = c10;
            String contentType = c10.getContentType();
            this.aGC = new BufferedInputStream(this.aGB.getInputStream(), 1024);
            HttpURLConnection httpURLConnection = this.aGB;
            n nVar = new n(this.aGA.url, a(httpURLConnection, j10, httpURLConnection.getResponseCode()), contentType);
            this.aGA = nVar;
            this.aGc.a(nVar.url, nVar);
        } catch (IOException e10) {
            throw new ProxyCacheException("Error opening connection for " + this.aGA.url + " with offset " + j10, e10);
        }
    }

    @Override // com.kwad.sdk.core.videocache.m
    public final void close() {
        HttpURLConnection httpURLConnection = this.aGB;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (ArrayIndexOutOfBoundsException unused) {
                com.kwad.sdk.core.d.c.e("HttpUrlSource", "Error closing connection correctly. Should happen only on Android L. If anybody know how to fix it, please visit https://github.com/danikula/AndroidVideoCache/issues/88. Until good solution is not know, just ignore this issue.");
            } catch (IllegalArgumentException e10) {
                e = e10;
                throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e);
            } catch (NullPointerException e11) {
                e = e11;
                throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e);
            }
        }
    }

    @Override // com.kwad.sdk.core.videocache.p
    public final String getUrl() {
        return this.aGA.url;
    }

    @Override // com.kwad.sdk.core.videocache.m
    public final synchronized long length() {
        try {
            if (this.aGA.aGQ == -2147483648L) {
                Io();
            }
            if (this.aGA.aGQ == -2147483648L) {
                Im();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.aGA.aGQ;
    }

    @Override // com.kwad.sdk.core.videocache.m
    public final int read(byte[] bArr) {
        InputStream inputStream = this.aGC;
        if (inputStream == null) {
            throw new ProxyCacheException("Error reading data from " + this.aGA.url + ": connection is absent!");
        }
        try {
            return inputStream.read(bArr, 0, 1024);
        } catch (InterruptedIOException e10) {
            throw new InterruptedProxyCacheException("Reading source " + this.aGA.url + " is interrupted", e10);
        } catch (IOException e11) {
            throw new ProxyCacheException("Error reading data from " + this.aGA.url, e11);
        }
    }

    @Override // com.kwad.sdk.core.videocache.p
    public final String toString() {
        return "HttpUrlSource{sourceInfo='" + this.aGA + p3.f.f29748d;
    }

    private void a(HttpURLConnection httpURLConnection, String str) {
        for (Map.Entry<String, String> entry : this.aGd.Iv().entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    public h(h hVar) {
        this.aGA = hVar.aGA;
        this.aGc = hVar.aGc;
        this.aGd = hVar.aGd;
    }
}
