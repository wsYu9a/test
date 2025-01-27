package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import com.kwad.sdk.utils.au;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionSpec;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: classes3.dex */
public final class j extends p {
    private n aGA;
    private InputStream aGC;
    private OkHttpClient aGH = new OkHttpClient();
    private final com.kwad.sdk.core.videocache.d.c aGc;
    private final com.kwad.sdk.core.videocache.b.b aGd;

    public j(String str, com.kwad.sdk.core.videocache.d.c cVar, com.kwad.sdk.core.videocache.b.b bVar) {
        this.aGc = (com.kwad.sdk.core.videocache.d.c) au.checkNotNull(cVar);
        this.aGd = (com.kwad.sdk.core.videocache.b.b) au.checkNotNull(bVar);
        n eV = cVar.eV(str);
        this.aGA = eV == null ? new n(str, -2147483648L, l.eT(str)) : eV;
    }

    private void Im() {
        Response response = null;
        try {
            try {
                response = dy(10000);
            } catch (IOException unused) {
                com.kwad.sdk.core.d.c.e("HttpUrlSource", "Error fetching info from " + this.aGA.url);
                if (0 == 0 || response.body() == null) {
                    return;
                }
            }
            if (response == null || !response.isSuccessful()) {
                throw new ProxyCacheException("Fail to fetchContentInfo: " + getUrl());
            }
            n nVar = new n(this.aGA.url, c(response), response.header("Content-Type"));
            this.aGA = nVar;
            this.aGc.a(nVar.url, nVar);
            com.kwad.sdk.core.d.c.d("HttpUrlSource", "Source info fetched: " + this.aGA);
            if (response.body() == null) {
                return;
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(response.body());
        } catch (Throwable th2) {
            if (0 != 0 && response.body() != null) {
                com.kwad.sdk.crash.utils.b.closeQuietly(response.body());
            }
            throw th2;
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

    private long a(Response response, long j10) {
        int code = response.code();
        long contentLength = response.body().getContentLength();
        return code == 200 ? contentLength : code == 206 ? contentLength + j10 : this.aGA.aGQ;
    }

    private static long c(Response response) {
        String header = response.header("Content-Length");
        if (header == null) {
            return -1L;
        }
        return Long.parseLong(header);
    }

    private Response d(long j10, int i10) {
        Response execute;
        OkHttpClient.Builder newBuilder = this.aGH.newBuilder();
        int i11 = 0;
        newBuilder.connectionSpecs(Arrays.asList(ConnectionSpec.MODERN_TLS, ConnectionSpec.COMPATIBLE_TLS, ConnectionSpec.CLEARTEXT));
        try {
            newBuilder.dns(new com.kwad.sdk.core.network.a.d());
        } catch (Throwable th2) {
            com.kwad.sdk.core.d.c.printStackTrace(th2);
        }
        this.aGH = newBuilder.build();
        String url = getUrl();
        boolean z10 = false;
        do {
            Request.Builder builder = new Request.Builder();
            builder.get();
            builder.url(url);
            if (j10 > 0) {
                builder.addHeader("Range", "bytes=" + j10 + "-");
            }
            execute = this.aGH.newCall(builder.build()).execute();
            if (execute.isRedirect()) {
                url = execute.header(m5.c.f28347t0);
                z10 = execute.isRedirect();
                i11++;
            }
            if (i11 > 5) {
                throw new ProxyCacheException("Too many redirects: " + i11);
            }
        } while (z10);
        return execute;
    }

    private Response dy(int i10) {
        Response execute;
        OkHttpClient.Builder newBuilder = new OkHttpClient().newBuilder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        newBuilder.connectTimeout(10000L, timeUnit);
        newBuilder.readTimeout(10000L, timeUnit);
        newBuilder.writeTimeout(10000L, timeUnit);
        int i11 = 0;
        newBuilder.connectionSpecs(Arrays.asList(ConnectionSpec.MODERN_TLS, ConnectionSpec.COMPATIBLE_TLS, ConnectionSpec.CLEARTEXT));
        try {
            newBuilder.dns(new com.kwad.sdk.core.network.a.d());
        } catch (Throwable th2) {
            com.kwad.sdk.core.d.c.printStackTrace(th2);
        }
        this.aGH = newBuilder.build();
        String url = getUrl();
        boolean z10 = false;
        do {
            Request.Builder builder = new Request.Builder();
            builder.head();
            builder.url(url);
            execute = this.aGH.newCall(builder.build()).execute();
            if (execute.isRedirect()) {
                url = execute.header(m5.c.f28347t0);
                z10 = execute.isRedirect();
                i11++;
            }
            if (i11 > 5) {
                throw new ProxyCacheException("Too many redirects: " + i11);
            }
        } while (z10);
        return execute;
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
            Response d10 = d(j10, -1);
            String mediaType = d10.body().get$contentType().getMediaType();
            long a10 = a(d10, j10);
            this.aGC = new BufferedInputStream(d10.body().byteStream(), 1024);
            n nVar = new n(this.aGA.url, a10, mediaType);
            this.aGA = nVar;
            this.aGc.a(nVar.url, nVar);
        } catch (IOException e10) {
            throw new ProxyCacheException("Error opening connection for " + getUrl() + " with offset " + j10, e10);
        }
    }

    @Override // com.kwad.sdk.core.videocache.m
    public final void close() {
        com.kwad.sdk.crash.utils.b.closeQuietly(this.aGC);
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

    public j(j jVar) {
        this.aGA = jVar.aGA;
        this.aGc = jVar.aGc;
        this.aGd = jVar.aGd;
    }
}
