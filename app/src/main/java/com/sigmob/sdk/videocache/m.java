package com.sigmob.sdk.videocache;

import android.text.TextUtils;
import androidx.media3.common.MimeTypes;
import com.czhj.sdk.logger.SigmobLog;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* loaded from: classes4.dex */
public class m implements u {

    /* renamed from: h */
    public static final int f20646h = 5;

    /* renamed from: i */
    public static OkHttpClient f20647i;

    /* renamed from: a */
    public InputStream f20648a;

    /* renamed from: b */
    public v f20649b;

    /* renamed from: c */
    public volatile long f20650c;

    /* renamed from: d */
    public volatile String f20651d;

    /* renamed from: e */
    public final com.sigmob.sdk.videocache.sourcestorage.c f20652e;

    /* renamed from: f */
    public final com.sigmob.sdk.videocache.headers.b f20653f;

    /* renamed from: g */
    public Response f20654g;

    public m(u uVar) {
        this.f20650c = -2147483648L;
        this.f20651d = MimeTypes.VIDEO_MP4;
        this.f20649b = uVar.b();
        this.f20652e = uVar.e();
        this.f20653f = uVar.f();
    }

    @Override // com.sigmob.sdk.videocache.u
    public synchronized String a() throws q {
        try {
            if (TextUtils.isEmpty(this.f20649b.f20687c)) {
                g();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.f20649b.f20687c;
    }

    @Override // com.sigmob.sdk.videocache.u
    public v b() {
        return this.f20649b;
    }

    @Override // com.sigmob.sdk.videocache.u
    public String c() {
        return this.f20649b.f20685a;
    }

    @Override // com.sigmob.sdk.videocache.u
    public void close() throws q {
        try {
            r.a(this.f20648a);
        } catch (ArrayIndexOutOfBoundsException e10) {
            SigmobLog.e("Error closing connection correctly. Should happen only on SigmobAndroid L. Until good solution is not know, just ignore this issue :(", e10);
        } catch (IllegalArgumentException e11) {
            e = e11;
            throw new RuntimeException("Wait... but why? WTF!? If you read it on your device log, please", e);
        } catch (NullPointerException e12) {
            e = e12;
            throw new RuntimeException("Wait... but why? WTF!? If you read it on your device log, please", e);
        }
    }

    @Override // com.sigmob.sdk.videocache.u
    public long d() throws q {
        if (this.f20650c == -2147483648L) {
            g();
        }
        return this.f20650c;
    }

    @Override // com.sigmob.sdk.videocache.u
    public com.sigmob.sdk.videocache.sourcestorage.c e() {
        return this.f20652e;
    }

    @Override // com.sigmob.sdk.videocache.u
    public com.sigmob.sdk.videocache.headers.b f() {
        return this.f20653f;
    }

    public final void g() throws q {
        try {
            SigmobLog.d("Read content info from " + this.f20649b.f20685a);
            Response a10 = a(0L, 10000);
            if (a10 == null || !a10.isSuccessful()) {
                throw new q("Fail to fetchContentInfo: " + this.f20649b.f20685a);
            }
            ResponseBody body = a10.body();
            if (body != null) {
                this.f20650c = (int) body.getContentLength();
                if (body.get$contentType() != null) {
                    this.f20651d = body.get$contentType().getMediaType();
                }
            }
            v vVar = new v(this.f20649b.f20685a, this.f20650c, this.f20651d);
            this.f20649b = vVar;
            this.f20652e.a(vVar.f20685a, vVar);
        } catch (IOException e10) {
            SigmobLog.e("Error fetching info from " + this.f20649b.f20685a, e10);
        } finally {
        }
    }

    @Override // com.sigmob.sdk.videocache.u
    public int read(byte[] bArr) throws q {
        InputStream inputStream = this.f20648a;
        if (inputStream == null) {
            throw new q("Error reading data from " + this.f20649b.f20685a + ": connection is absent!");
        }
        try {
            return inputStream.read(bArr, 0, bArr.length);
        } catch (InterruptedIOException e10) {
            throw new l("Reading source " + this.f20649b.f20685a + " is interrupted", e10);
        } catch (IOException e11) {
            throw new q("Error reading data from " + this.f20649b.f20685a, e11);
        }
    }

    public String toString() {
        return "HttpUrlSource{sourceInfo='" + this.f20649b + p3.f.f29748d;
    }

    public m(String str) {
        this(str, com.sigmob.sdk.videocache.sourcestorage.d.a());
    }

    public final void a(Request.Builder builder, String str) {
        for (Map.Entry<String, String> entry : this.f20653f.a(str).entrySet()) {
            builder.addHeader(entry.getKey(), entry.getValue());
        }
    }

    public m(String str, com.sigmob.sdk.videocache.sourcestorage.c cVar) {
        this(str, cVar, new com.sigmob.sdk.videocache.headers.a());
    }

    @Override // com.sigmob.sdk.videocache.u
    public void a(long j10) throws q {
        try {
            Response a10 = a(j10, -1);
            this.f20654g = a10;
            ResponseBody body = a10.body();
            if (body != null && body.get$contentType() != null) {
                this.f20651d = body.get$contentType().getMediaType();
            }
            this.f20650c = a(this.f20654g, j10);
            this.f20648a = new BufferedInputStream(body.byteStream(), 8192);
            v vVar = new v(this.f20649b.f20685a, this.f20650c, this.f20651d);
            this.f20649b = vVar;
            this.f20652e.a(vVar.f20685a, vVar);
        } catch (IOException e10) {
            throw new q("Error opening connection for " + this.f20649b.f20685a + " with offset " + j10, e10);
        }
    }

    public m(String str, com.sigmob.sdk.videocache.sourcestorage.c cVar, com.sigmob.sdk.videocache.headers.b bVar) {
        this.f20650c = -2147483648L;
        this.f20651d = MimeTypes.VIDEO_MP4;
        this.f20652e = (com.sigmob.sdk.videocache.sourcestorage.c) o.a(cVar);
        this.f20653f = (com.sigmob.sdk.videocache.headers.b) o.a(bVar);
        v vVar = cVar.get(str);
        this.f20649b = vVar == null ? new v(str, -2147483648L, r.d(str)) : vVar;
    }

    public final Response a(long j10, int i10) throws IOException, q {
        if (f20647i == null) {
            OkHttpClient.Builder connectionPool = new OkHttpClient().newBuilder().connectionPool(new ConnectionPool());
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            f20647i = connectionPool.connectTimeout(10000L, timeUnit).readTimeout(10000L, timeUnit).writeTimeout(10000L, timeUnit).build();
        }
        String str = this.f20649b.f20685a;
        Response response = this.f20654g;
        if (response != null && j10 > 0) {
            try {
                response.close();
            } catch (Throwable unused) {
            }
            this.f20654g = null;
            r.a(this.f20648a);
        }
        if (this.f20654g == null) {
            int i11 = 0;
            boolean z10 = false;
            do {
                Request.Builder builder = new Request.Builder();
                builder.get();
                builder.url(str);
                a(builder, str);
                if (j10 > 0) {
                    builder.addHeader("Range", "bytes=" + j10 + "-");
                }
                Response execute = f20647i.newCall(builder.build()).execute();
                this.f20654g = execute;
                if (execute.isRedirect()) {
                    str = this.f20654g.header(m5.c.f28347t0);
                    z10 = this.f20654g.isRedirect();
                    i11++;
                }
                if (i11 > 5) {
                    throw new q("Too many redirects: " + i11);
                }
            } while (z10);
        }
        return this.f20654g;
    }

    public final long a(Response response, long j10) throws IOException {
        int code = response.code();
        int contentLength = (int) response.body().getContentLength();
        return code == 200 ? contentLength : code == 206 ? contentLength + j10 : this.f20650c;
    }
}
