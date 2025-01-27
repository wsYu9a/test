package com.kwad.sdk;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.kwad.framework.filedownloader.f.c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.u;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;

/* loaded from: classes3.dex */
public final class k implements com.kwad.framework.filedownloader.a.b {
    private final OkHttpClient aoa;
    private final Request.Builder aob;
    private Request aoc;
    private Response aod;

    public static class a implements c.b {
        private volatile OkHttpClient aoa;
        private OkHttpClient.Builder aoe;

        public a() {
        }

        @Override // com.kwad.framework.filedownloader.f.c.b
        public final com.kwad.framework.filedownloader.a.b bi(String str) {
            if (this.aoa == null) {
                synchronized (a.class) {
                    try {
                        if (this.aoa == null) {
                            OkHttpClient.Builder builder = this.aoe;
                            this.aoa = builder != null ? builder.build() : new OkHttpClient();
                            this.aoe = null;
                        }
                    } finally {
                    }
                }
            }
            return new k(str, this.aoa, (byte) 0);
        }

        public a(boolean z10) {
            if (z10) {
                this.aoe = k.Aq();
            } else {
                this.aoe = k.Ap();
            }
        }
    }

    public /* synthetic */ k(String str, OkHttpClient okHttpClient, byte b10) {
        this(str, okHttpClient);
    }

    public static OkHttpClient.Builder Ap() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return builder.connectTimeout(10000L, timeUnit).addInterceptor(new com.kwad.sdk.j.a()).readTimeout(0L, timeUnit).connectionPool(new ConnectionPool(6, 60000L, timeUnit)).retryOnConnectionFailure(true);
    }

    public static OkHttpClient.Builder Aq() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return builder.connectTimeout(10000L, timeUnit).addInterceptor(new com.kwad.sdk.j.a()).protocols(Util.immutableList(new Protocol[]{Protocol.HTTP_1_1})).readTimeout(0L, timeUnit).connectionPool(new ConnectionPool(6, 60000L, timeUnit)).retryOnConnectionFailure(true);
    }

    private String ce(String str) {
        String bh2 = bh("Content-Type");
        String extension = u.getExtension(str);
        String str2 = ".apk";
        if (TextUtils.isEmpty(bh2) || !TextUtils.isEmpty(extension)) {
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
            return System.currentTimeMillis() + ".apk";
        }
        String extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(bh2);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(System.currentTimeMillis());
        if (!TextUtils.isEmpty(extensionFromMimeType)) {
            str2 = p1.b.f29697h + extensionFromMimeType;
        }
        sb2.append(str2);
        return sb2.toString();
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final void addHeader(String str, String str2) {
        this.aob.addHeader(str, str2);
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final String bh(String str) {
        String str2;
        if (!"Content-Disposition".equals(str)) {
            Response response = this.aod;
            if (response == null) {
                return null;
            }
            return response.header(str);
        }
        try {
        } catch (Exception unused) {
            str2 = "";
        }
        if (!TextUtils.isEmpty(com.kwad.framework.filedownloader.f.f.bz(this.aod.header(str)))) {
            return this.aod.header(str);
        }
        str2 = this.aod.request().url().pathSegments().get(r3.size() - 1);
        return "attachment; filename=\"" + ce(str2) + "\"";
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final void execute() {
        if (this.aoc == null) {
            this.aoc = this.aob.build();
        }
        this.aod = this.aoa.newCall(this.aoc).execute();
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final InputStream getInputStream() {
        Response response = this.aod;
        if (response == null) {
            throw new IllegalStateException("Please invoke #execute first!");
        }
        return ((com.kwad.sdk.service.a.j) ServiceProvider.get(com.kwad.sdk.service.a.j.class)).wrapInputStream(response.body().byteStream());
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final int getResponseCode() {
        Response response = this.aod;
        if (response != null) {
            return response.code();
        }
        throw new IllegalStateException("Please invoke #execute first!");
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final Map<String, List<String>> wk() {
        if (this.aoc == null) {
            this.aoc = this.aob.build();
        }
        return this.aoc.headers().toMultimap();
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final Map<String, List<String>> wl() {
        Response response = this.aod;
        if (response == null) {
            return null;
        }
        return response.headers().toMultimap();
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final void wm() {
        this.aoc = null;
        Response response = this.aod;
        if (response != null && response.body() != null) {
            com.kwad.sdk.crash.utils.b.closeQuietly(this.aod.body());
        }
        this.aod = null;
    }

    private k(Request.Builder builder, OkHttpClient okHttpClient) {
        this.aob = builder;
        this.aoa = okHttpClient;
    }

    private k(String str, OkHttpClient okHttpClient) {
        this(new Request.Builder().url(str), okHttpClient);
    }
}
