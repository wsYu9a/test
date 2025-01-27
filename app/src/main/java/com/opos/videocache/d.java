package com.opos.videocache;

import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import org.apache.http.HttpHeaders;

/* loaded from: classes4.dex */
public class d implements i {

    /* renamed from: a */
    private final com.opos.videocache.c.b f23811a;

    /* renamed from: b */
    private final com.opos.videocache.b.b f23812b;

    /* renamed from: c */
    private j f23813c;

    /* renamed from: d */
    private HttpURLConnection f23814d;

    /* renamed from: e */
    private InputStream f23815e;

    public d(d dVar) {
        this.f23813c = dVar.f23813c;
        this.f23811a = dVar.f23811a;
        this.f23812b = dVar.f23812b;
    }

    public d(String str) {
        this(str, com.opos.videocache.c.c.a());
    }

    public d(String str, com.opos.videocache.c.b bVar) {
        this(str, bVar, new com.opos.videocache.b.a());
    }

    public d(String str, com.opos.videocache.c.b bVar, com.opos.videocache.b.b bVar2) {
        this.f23811a = (com.opos.videocache.c.b) f.a(bVar);
        this.f23812b = (com.opos.videocache.b.b) f.a(bVar2);
        j a2 = bVar.a(str);
        this.f23813c = a2 == null ? new j(str, -2147483648L, h.a(str)) : a2;
    }

    private long a(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("Content-Length");
        if (headerField == null) {
            return -1L;
        }
        return Long.parseLong(headerField);
    }

    private long a(HttpURLConnection httpURLConnection, long j2, int i2) {
        long a2 = a(httpURLConnection);
        return i2 == 200 ? a2 : i2 == 206 ? a2 + j2 : this.f23813c.f23817b;
    }

    private HttpURLConnection a(long j2, int i2) {
        String str;
        HttpURLConnection httpURLConnection;
        boolean z;
        String str2 = this.f23813c.f23816a;
        int i3 = 0;
        do {
            StringBuilder sb = new StringBuilder();
            sb.append("Open connection ");
            if (j2 > 0) {
                str = " with offset " + j2;
            } else {
                str = "";
            }
            sb.append(str);
            sb.append(" to ");
            sb.append(str2);
            com.opos.cmn.an.f.a.b("HttpUrlSource", sb.toString());
            httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
            a(httpURLConnection, str2);
            if (j2 > 0) {
                httpURLConnection.setRequestProperty(HttpHeaders.RANGE, "bytes=" + j2 + "-");
            }
            if (i2 > 0) {
                httpURLConnection.setConnectTimeout(i2);
                httpURLConnection.setReadTimeout(i2);
            }
            int responseCode = httpURLConnection.getResponseCode();
            z = responseCode == 301 || responseCode == 302 || responseCode == 303;
            if (z) {
                str2 = httpURLConnection.getHeaderField(HttpHeaders.LOCATION);
                i3++;
                httpURLConnection.disconnect();
            }
            if (i3 > 5) {
                throw new g("Too many redirects: " + i3);
            }
        } while (z);
        return httpURLConnection;
    }

    private void a(HttpURLConnection httpURLConnection, String str) {
        for (Map.Entry<String, String> entry : this.f23812b.a(str).entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v5 */
    private void e() {
        HttpURLConnection httpURLConnection;
        com.opos.cmn.an.f.a.b("HttpUrlSource", "Read content info from " + this.f23813c.f23816a);
        HttpURLConnection httpURLConnection2 = 10000;
        InputStream inputStream = null;
        try {
            try {
                httpURLConnection = a(0L, 10000);
            } catch (IOException e2) {
                e = e2;
                httpURLConnection = null;
            } catch (Throwable th) {
                th = th;
                httpURLConnection = null;
            }
            try {
                try {
                    long a2 = a(httpURLConnection);
                    String contentType = httpURLConnection.getContentType();
                    inputStream = httpURLConnection.getInputStream();
                    j jVar = new j(this.f23813c.f23816a, a2, contentType);
                    this.f23813c = jVar;
                    this.f23811a.a(jVar.f23816a, jVar);
                    com.opos.cmn.an.f.a.b("HttpUrlSource", "Source info fetched: " + this.f23813c);
                    h.a(inputStream);
                    httpURLConnection2 = httpURLConnection;
                } catch (IOException e3) {
                    e = e3;
                    com.opos.cmn.an.f.a.d("HttpUrlSource", "Error fetching info from " + this.f23813c.f23816a, e);
                    h.a((Closeable) null);
                    httpURLConnection2 = httpURLConnection;
                    if (httpURLConnection == null) {
                        return;
                    }
                    httpURLConnection2.disconnect();
                }
                httpURLConnection2.disconnect();
            } catch (Throwable th2) {
                th = th2;
                h.a(inputStream);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStream = inputStream;
            httpURLConnection = httpURLConnection2;
        }
    }

    @Override // com.opos.videocache.i
    public int a(byte[] bArr) {
        InputStream inputStream = this.f23815e;
        if (inputStream == null) {
            throw new g("Error reading data from " + this.f23813c.f23816a + ": connection is absent!");
        }
        try {
            return inputStream.read(bArr, 0, bArr.length);
        } catch (InterruptedIOException e2) {
            throw new e("Reading source " + this.f23813c.f23816a + " is interrupted", e2);
        } catch (IOException e3) {
            throw new g("Error reading data from " + this.f23813c.f23816a, e3);
        }
    }

    @Override // com.opos.videocache.i
    public long a() {
        long j2;
        synchronized (this) {
            if (this.f23813c.f23817b == -2147483648L) {
                e();
            }
            j2 = this.f23813c.f23817b;
        }
        return j2;
    }

    @Override // com.opos.videocache.i
    public void a(long j2) {
        try {
            HttpURLConnection a2 = a(j2, -1);
            this.f23814d = a2;
            String contentType = a2.getContentType();
            this.f23815e = new BufferedInputStream(this.f23814d.getInputStream(), 8192);
            HttpURLConnection httpURLConnection = this.f23814d;
            j jVar = new j(this.f23813c.f23816a, a(httpURLConnection, j2, httpURLConnection.getResponseCode()), contentType);
            this.f23813c = jVar;
            this.f23811a.a(jVar.f23816a, jVar);
        } catch (IOException e2) {
            throw new g("Error opening connection for " + this.f23813c.f23816a + " with offset " + j2, e2);
        }
    }

    @Override // com.opos.videocache.i
    public void b() {
        HttpURLConnection httpURLConnection = this.f23814d;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (ArrayIndexOutOfBoundsException e2) {
                com.opos.cmn.an.f.a.d("HttpUrlSource", "Error closing connection correctly. Should happen only on Android L. If anybody know how to fix it, please visit. Until good solution is not know, just ignore this issue :(", e2);
            } catch (IllegalArgumentException e3) {
                e = e3;
                throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing .If you read it on your device log, please, notify me danikula@gmail.com or create issue here.", e);
            } catch (NullPointerException e4) {
                e = e4;
                throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing .If you read it on your device log, please, notify me danikula@gmail.com or create issue here.", e);
            }
        }
    }

    public String c() {
        String str;
        synchronized (this) {
            if (TextUtils.isEmpty(this.f23813c.f23818c)) {
                e();
            }
            str = this.f23813c.f23818c;
        }
        return str;
    }

    public String d() {
        return this.f23813c.f23816a;
    }

    public String toString() {
        return "HttpUrlSource{sourceInfo='" + this.f23813c + "}";
    }
}
