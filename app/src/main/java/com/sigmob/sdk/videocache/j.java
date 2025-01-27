package com.sigmob.sdk.videocache;

import android.text.TextUtils;
import com.czhj.sdk.logger.SigmobLog;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.Map;

/* loaded from: classes4.dex */
public class j implements u {

    /* renamed from: f */
    public static final int f20636f = 5;

    /* renamed from: a */
    public final com.sigmob.sdk.videocache.sourcestorage.c f20637a;

    /* renamed from: b */
    public final com.sigmob.sdk.videocache.headers.b f20638b;

    /* renamed from: c */
    public v f20639c;

    /* renamed from: d */
    public HttpURLConnection f20640d;

    /* renamed from: e */
    public InputStream f20641e;

    public j(u uVar) {
        this.f20639c = uVar.b();
        this.f20637a = uVar.e();
        this.f20638b = uVar.f();
    }

    public final long a(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("Content-Length");
        if (headerField == null) {
            return -1L;
        }
        return Long.parseLong(headerField);
    }

    @Override // com.sigmob.sdk.videocache.u
    public v b() {
        return this.f20639c;
    }

    @Override // com.sigmob.sdk.videocache.u
    public String c() {
        return this.f20639c.f20685a;
    }

    @Override // com.sigmob.sdk.videocache.u
    public void close() throws q {
        HttpURLConnection httpURLConnection = this.f20640d;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (ArrayIndexOutOfBoundsException e10) {
                SigmobLog.e("Error closing connection correctly. Should happen only on SigmobAndroid L. Until good solution is not know, just ignore this issue :(", e10);
            } catch (IllegalArgumentException e11) {
                e = e11;
                throw new RuntimeException("Wait... but why? WTF!? ", e);
            } catch (NullPointerException e12) {
                e = e12;
                throw new RuntimeException("Wait... but why? WTF!? ", e);
            }
        }
    }

    @Override // com.sigmob.sdk.videocache.u
    public synchronized long d() throws q {
        try {
            if (this.f20639c.f20686b == -2147483648L) {
                g();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.f20639c.f20686b;
    }

    @Override // com.sigmob.sdk.videocache.u
    public com.sigmob.sdk.videocache.sourcestorage.c e() {
        return this.f20637a;
    }

    @Override // com.sigmob.sdk.videocache.u
    public com.sigmob.sdk.videocache.headers.b f() {
        return this.f20638b;
    }

    public final void g() throws q {
        SigmobLog.d("Read content info from " + this.f20639c.f20685a);
        try {
            HttpURLConnection a10 = a(0L, 3000);
            v vVar = new v(this.f20639c.f20685a, a(a10), a10.getContentType());
            this.f20639c = vVar;
            this.f20637a.a(vVar.f20685a, vVar);
            SigmobLog.d("Source info fetched: " + this.f20639c);
        } catch (IOException e10) {
            SigmobLog.e("Error fetching info from " + this.f20639c.f20685a, e10);
        }
    }

    @Override // com.sigmob.sdk.videocache.u
    public int read(byte[] bArr) throws q {
        InputStream inputStream = this.f20641e;
        if (inputStream == null) {
            throw new q("Error reading data from " + this.f20639c.f20685a + ": connection is absent!");
        }
        try {
            return inputStream.read(bArr, 0, bArr.length);
        } catch (InterruptedIOException e10) {
            throw new l("Reading source " + this.f20639c.f20685a + " is interrupted", e10);
        } catch (IOException e11) {
            throw new q("Error reading data from " + this.f20639c.f20685a, e11);
        }
    }

    public String toString() {
        return "HttpUrlSource{sourceInfo='" + this.f20639c + p3.f.f29748d;
    }

    public j(String str) {
        this(str, com.sigmob.sdk.videocache.sourcestorage.d.a());
    }

    @Override // com.sigmob.sdk.videocache.u
    public synchronized String a() throws q {
        try {
            if (TextUtils.isEmpty(this.f20639c.f20687c)) {
                g();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.f20639c.f20687c;
    }

    public j(String str, com.sigmob.sdk.videocache.sourcestorage.c cVar) {
        this(str, cVar, new com.sigmob.sdk.videocache.headers.a());
    }

    public final void a(HttpURLConnection httpURLConnection, String str) {
        for (Map.Entry<String, String> entry : this.f20638b.a(str).entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    public j(String str, com.sigmob.sdk.videocache.sourcestorage.c cVar, com.sigmob.sdk.videocache.headers.b bVar) {
        this.f20637a = (com.sigmob.sdk.videocache.sourcestorage.c) o.a(cVar);
        this.f20638b = (com.sigmob.sdk.videocache.headers.b) o.a(bVar);
        v vVar = cVar.get(str);
        this.f20639c = vVar == null ? new v(str, -2147483648L, r.d(str)) : vVar;
    }

    @Override // com.sigmob.sdk.videocache.u
    public void a(long j10) throws q {
        try {
            HttpURLConnection a10 = a(j10, 3000);
            this.f20640d = a10;
            String contentType = a10.getContentType();
            this.f20641e = new BufferedInputStream(this.f20640d.getInputStream(), 8192);
            HttpURLConnection httpURLConnection = this.f20640d;
            v vVar = new v(this.f20639c.f20685a, a(httpURLConnection, j10, httpURLConnection.getResponseCode()), contentType);
            this.f20639c = vVar;
            this.f20637a.a(vVar.f20685a, vVar);
        } catch (IOException e10) {
            throw new q("Error opening connection for " + this.f20639c.f20685a + " with offset " + j10, e10);
        }
    }

    public final HttpURLConnection a(long j10, int i10) throws IOException, q {
        String str;
        boolean z10;
        String str2 = this.f20639c.f20685a;
        HttpURLConnection httpURLConnection = this.f20640d;
        if (httpURLConnection != null && j10 > 0) {
            try {
                httpURLConnection.disconnect();
            } catch (Throwable unused) {
            }
            this.f20640d = null;
            r.a(this.f20641e);
        }
        if (this.f20640d == null) {
            int i11 = 0;
            do {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Open connection ");
                if (j10 > 0) {
                    str = " with offset " + j10;
                } else {
                    str = "";
                }
                sb2.append(str);
                sb2.append(" to ");
                sb2.append(str2);
                SigmobLog.d(sb2.toString());
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str2).openConnection();
                this.f20640d = httpURLConnection2;
                a(httpURLConnection2, str2);
                if (j10 > 0) {
                    this.f20640d.setRequestProperty("Range", "bytes=" + j10 + "-");
                }
                if (i10 > 0) {
                    this.f20640d.setConnectTimeout(i10);
                    this.f20640d.setReadTimeout(i10);
                }
                int responseCode = this.f20640d.getResponseCode();
                z10 = responseCode == 301 || responseCode == 302 || responseCode == 303;
                if (z10) {
                    String headerField = this.f20640d.getHeaderField(m5.c.f28347t0);
                    URI create = URI.create(headerField);
                    if (create != null && !create.isAbsolute()) {
                        try {
                            URI create2 = URI.create(str2);
                            if (create2 != null) {
                                headerField = create2.resolve(create).toString();
                            }
                        } catch (Throwable unused2) {
                        }
                    }
                    i11++;
                    this.f20640d.disconnect();
                    str2 = headerField;
                }
                if (i11 > 5) {
                    throw new q("Too many redirects: " + i11);
                }
            } while (z10);
        }
        return this.f20640d;
    }

    public final long a(HttpURLConnection httpURLConnection, long j10, int i10) throws IOException {
        long a10 = a(httpURLConnection);
        return i10 == 200 ? a10 : i10 == 206 ? a10 + j10 : this.f20639c.f20686b;
    }
}
