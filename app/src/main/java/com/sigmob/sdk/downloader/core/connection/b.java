package com.sigmob.sdk.downloader.core.connection;

import com.sigmob.sdk.downloader.core.connection.a;
import com.sigmob.sdk.downloader.j;
import java.io.IOException;
import java.io.InputStream;
import java.net.ProtocolException;
import java.util.List;
import java.util.Map;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* loaded from: classes4.dex */
public class b implements com.sigmob.sdk.downloader.core.connection.a, a.InterfaceC0584a {

    /* renamed from: b */
    public final OkHttpClient f19111b;

    /* renamed from: c */
    public final Request.Builder f19112c;

    /* renamed from: d */
    public Request f19113d;

    /* renamed from: e */
    public Response f19114e;

    public static class a implements a.b {

        /* renamed from: a */
        public OkHttpClient.Builder f19115a;

        /* renamed from: b */
        public volatile OkHttpClient f19116b;

        public OkHttpClient.Builder a() {
            if (this.f19115a == null) {
                this.f19115a = new OkHttpClient.Builder();
            }
            return this.f19115a;
        }

        @Override // com.sigmob.sdk.downloader.core.connection.a.b
        public com.sigmob.sdk.downloader.core.connection.a a(String str) throws IOException {
            if (this.f19116b == null) {
                synchronized (a.class) {
                    try {
                        if (this.f19116b == null) {
                            OkHttpClient.Builder builder = this.f19115a;
                            this.f19116b = builder != null ? builder.build() : new OkHttpClient();
                            this.f19115a = null;
                        }
                    } finally {
                    }
                }
            }
            return new b(this.f19116b, str);
        }

        public a a(OkHttpClient.Builder builder) {
            this.f19115a = builder;
            return this;
        }
    }

    public b(OkHttpClient okHttpClient, String str) {
        this(okHttpClient, new Request.Builder().url(str));
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a
    public void a(String str, String str2) {
        this.f19112c.addHeader(str, str2);
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a.InterfaceC0584a
    public String b() {
        Response priorResponse = this.f19114e.priorResponse();
        if (priorResponse != null && this.f19114e.isSuccessful() && j.a(priorResponse.code())) {
            return this.f19114e.request().url().getUrl();
        }
        return null;
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a.InterfaceC0584a
    public InputStream c() throws IOException {
        Response response = this.f19114e;
        if (response == null) {
            throw new IOException("Please invoke execute first!");
        }
        ResponseBody body = response.body();
        if (body != null) {
            return body.byteStream();
        }
        throw new IOException("no body found on response!");
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a
    public Map<String, List<String>> d() {
        Request request = this.f19113d;
        if (request == null) {
            request = this.f19112c.build();
        }
        return request.headers().toMultimap();
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a.InterfaceC0584a
    public Map<String, List<String>> e() {
        Response response = this.f19114e;
        if (response == null) {
            return null;
        }
        return response.headers().toMultimap();
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a
    public a.InterfaceC0584a execute() throws IOException {
        Request build = this.f19112c.build();
        this.f19113d = build;
        this.f19114e = this.f19111b.newCall(build).execute();
        return this;
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a.InterfaceC0584a
    public int f() throws IOException {
        Response response = this.f19114e;
        if (response != null) {
            return response.code();
        }
        throw new IOException("Please invoke execute first!");
    }

    public b(OkHttpClient okHttpClient, Request.Builder builder) {
        this.f19111b = okHttpClient;
        this.f19112c = builder;
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a
    public void a() {
        this.f19113d = null;
        Response response = this.f19114e;
        if (response != null) {
            response.close();
        }
        this.f19114e = null;
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a
    public String b(String str) {
        Request request = this.f19113d;
        return request != null ? request.header(str) : this.f19112c.build().header(str);
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a.InterfaceC0584a
    public String c(String str) {
        Response response = this.f19114e;
        if (response == null) {
            return null;
        }
        return response.header(str);
    }

    @Override // com.sigmob.sdk.downloader.core.connection.a
    public boolean a(String str) throws ProtocolException {
        this.f19112c.method(str, null);
        return true;
    }
}
