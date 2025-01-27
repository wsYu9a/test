package com.opos.exoplayer.core.h;

import android.net.Uri;
import com.opos.exoplayer.core.h.q;
import com.opos.exoplayer.core.i.u;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpHost;
import org.apache.http.protocol.HTTP;

/* loaded from: classes4.dex */
public class n implements q {

    /* renamed from: b */
    private static final Pattern f18960b = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");

    /* renamed from: c */
    private static final AtomicReference<byte[]> f18961c = new AtomicReference<>();

    /* renamed from: d */
    private final boolean f18962d;

    /* renamed from: e */
    private final int f18963e;

    /* renamed from: f */
    private final int f18964f;

    /* renamed from: g */
    private final String f18965g;

    /* renamed from: h */
    private final com.opos.exoplayer.core.i.o<String> f18966h;

    /* renamed from: i */
    private final q.f f18967i;

    /* renamed from: j */
    private final q.f f18968j = new q.f();
    private final t<? super n> k;
    private i l;
    private HttpURLConnection m;
    private InputStream n;
    private boolean o;
    private long p;
    private long q;
    private long r;
    private long s;

    public n(String str, com.opos.exoplayer.core.i.o<String> oVar, t<? super n> tVar, int i2, int i3, boolean z, q.f fVar) {
        this.f18965g = com.opos.exoplayer.core.i.a.a(str);
        this.f18966h = oVar;
        this.k = tVar;
        this.f18963e = i2;
        this.f18964f = i3;
        this.f18962d = z;
        this.f18967i = fVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static long a(java.net.HttpURLConnection r10) {
        /*
            java.lang.String r0 = "Content-Length"
            java.lang.String r0 = r10.getHeaderField(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r2 = "]"
            java.lang.String r3 = "DefaultHttpDataSource"
            if (r1 != 0) goto L2c
            long r4 = java.lang.Long.parseLong(r0)     // Catch: java.lang.NumberFormatException -> L15
            goto L2e
        L15:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r4 = "Unexpected Content-Length ["
            r1.append(r4)
            r1.append(r0)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.opos.cmn.an.f.a.d(r3, r1)
        L2c:
            r4 = -1
        L2e:
            java.lang.String r1 = "Content-Range"
            java.lang.String r10 = r10.getHeaderField(r1)
            boolean r1 = android.text.TextUtils.isEmpty(r10)
            if (r1 != 0) goto La3
            java.util.regex.Pattern r1 = com.opos.exoplayer.core.h.n.f18960b
            java.util.regex.Matcher r1 = r1.matcher(r10)
            boolean r6 = r1.find()
            if (r6 == 0) goto La3
            r6 = 2
            java.lang.String r6 = r1.group(r6)     // Catch: java.lang.NumberFormatException -> L8c
            long r6 = java.lang.Long.parseLong(r6)     // Catch: java.lang.NumberFormatException -> L8c
            r8 = 1
            java.lang.String r1 = r1.group(r8)     // Catch: java.lang.NumberFormatException -> L8c
            long r8 = java.lang.Long.parseLong(r1)     // Catch: java.lang.NumberFormatException -> L8c
            long r6 = r6 - r8
            r8 = 1
            long r6 = r6 + r8
            r8 = 0
            int r1 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r1 >= 0) goto L64
            r4 = r6
            goto La3
        L64:
            int r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r1 == 0) goto La3
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.NumberFormatException -> L8c
            r1.<init>()     // Catch: java.lang.NumberFormatException -> L8c
            java.lang.String r8 = "Inconsistent headers ["
            r1.append(r8)     // Catch: java.lang.NumberFormatException -> L8c
            r1.append(r0)     // Catch: java.lang.NumberFormatException -> L8c
            java.lang.String r0 = "] ["
            r1.append(r0)     // Catch: java.lang.NumberFormatException -> L8c
            r1.append(r10)     // Catch: java.lang.NumberFormatException -> L8c
            r1.append(r2)     // Catch: java.lang.NumberFormatException -> L8c
            java.lang.String r0 = r1.toString()     // Catch: java.lang.NumberFormatException -> L8c
            com.opos.cmn.an.f.a.c(r3, r0)     // Catch: java.lang.NumberFormatException -> L8c
            long r4 = java.lang.Math.max(r4, r6)     // Catch: java.lang.NumberFormatException -> L8c
            goto La3
        L8c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unexpected Content-Range ["
            r0.append(r1)
            r0.append(r10)
            r0.append(r2)
            java.lang.String r10 = r0.toString()
            com.opos.cmn.an.f.a.d(r3, r10)
        La3:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.h.n.a(java.net.HttpURLConnection):long");
    }

    private HttpURLConnection a(URL url, byte[] bArr, long j2, long j3, boolean z, boolean z2) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.f18963e);
        httpURLConnection.setReadTimeout(this.f18964f);
        q.f fVar = this.f18967i;
        if (fVar != null) {
            for (Map.Entry<String, String> entry : fVar.a().entrySet()) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        for (Map.Entry<String, String> entry2 : this.f18968j.a().entrySet()) {
            httpURLConnection.setRequestProperty(entry2.getKey(), entry2.getValue());
        }
        if (j2 != 0 || j3 != -1) {
            String str = "bytes=" + j2 + "-";
            if (j3 != -1) {
                str = str + ((j2 + j3) - 1);
            }
            httpURLConnection.setRequestProperty(HttpHeaders.RANGE, str);
        }
        httpURLConnection.setRequestProperty("User-Agent", this.f18965g);
        if (!z) {
            httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, HTTP.IDENTITY_CODING);
        }
        httpURLConnection.setInstanceFollowRedirects(z2);
        httpURLConnection.setDoOutput(bArr != null);
        if (bArr != null) {
            httpURLConnection.setRequestMethod("POST");
            if (bArr.length != 0) {
                httpURLConnection.setFixedLengthStreamingMode(bArr.length);
                httpURLConnection.connect();
                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(bArr);
                outputStream.close();
                return httpURLConnection;
            }
        }
        httpURLConnection.connect();
        return httpURLConnection;
    }

    private static URL a(URL url, String str) {
        if (str == null) {
            throw new ProtocolException("Null location redirect");
        }
        URL url2 = new URL(url, str);
        String protocol = url2.getProtocol();
        if (b.b.a.b.b.f4198a.equals(protocol) || HttpHost.DEFAULT_SCHEME_NAME.equals(protocol)) {
            return url2;
        }
        throw new ProtocolException("Unsupported protocol redirect: " + protocol);
    }

    private static void a(HttpURLConnection httpURLConnection, long j2) {
        int i2 = u.f19078a;
        if (i2 == 19 || i2 == 20) {
            try {
                InputStream inputStream = httpURLConnection.getInputStream();
                if (j2 == -1) {
                    if (inputStream.read() == -1) {
                        return;
                    }
                } else if (j2 <= 2048) {
                    return;
                }
                String name = inputStream.getClass().getName();
                if (name.equals("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream") || name.equals("com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream")) {
                    Method declaredMethod = inputStream.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(inputStream, new Object[0]);
                }
            } catch (Exception unused) {
            }
        }
    }

    private int b(byte[] bArr, int i2, int i3) {
        if (i3 == 0) {
            return 0;
        }
        long j2 = this.q;
        if (j2 != -1) {
            long j3 = j2 - this.s;
            if (j3 == 0) {
                return -1;
            }
            i3 = (int) Math.min(i3, j3);
        }
        int read = this.n.read(bArr, i2, i3);
        if (read == -1) {
            if (this.q == -1) {
                return -1;
            }
            throw new EOFException();
        }
        this.s += read;
        t<? super n> tVar = this.k;
        if (tVar != null) {
            tVar.a((t<? super n>) this, read);
        }
        return read;
    }

    private HttpURLConnection b(i iVar) {
        URL url = new URL(iVar.f18918a.toString());
        byte[] bArr = iVar.f18919b;
        long j2 = iVar.f18921d;
        long j3 = iVar.f18922e;
        boolean a2 = iVar.a(1);
        if (!this.f18962d) {
            return a(url, bArr, j2, j3, a2, true);
        }
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            if (i2 > 20) {
                throw new NoRouteToHostException("Too many redirects: " + i3);
            }
            long j4 = j2;
            HttpURLConnection a3 = a(url, bArr, j2, j3, a2, false);
            int responseCode = a3.getResponseCode();
            if (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303) {
                if (bArr != null) {
                    return a3;
                }
                if (responseCode != 307 && responseCode != 308) {
                    return a3;
                }
            }
            bArr = null;
            String headerField = a3.getHeaderField(HttpHeaders.LOCATION);
            a3.disconnect();
            url = a(url, headerField);
            i2 = i3;
            j2 = j4;
        }
    }

    private void d() {
        if (this.r == this.p) {
            return;
        }
        byte[] andSet = f18961c.getAndSet(null);
        if (andSet == null) {
            andSet = new byte[4096];
        }
        while (true) {
            long j2 = this.r;
            long j3 = this.p;
            if (j2 == j3) {
                f18961c.set(andSet);
                return;
            }
            int read = this.n.read(andSet, 0, (int) Math.min(j3 - j2, andSet.length));
            if (Thread.interrupted()) {
                throw new InterruptedIOException();
            }
            if (read == -1) {
                throw new EOFException();
            }
            this.r += read;
            t<? super n> tVar = this.k;
            if (tVar != null) {
                tVar.a((t<? super n>) this, read);
            }
        }
    }

    private void e() {
        HttpURLConnection httpURLConnection = this.m;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.d("DefaultHttpDataSource", "Unexpected error while disconnecting", e2);
            }
            this.m = null;
        }
    }

    @Override // com.opos.exoplayer.core.h.g
    public int a(byte[] bArr, int i2, int i3) {
        try {
            d();
            return b(bArr, i2, i3);
        } catch (IOException e2) {
            throw new q.c(e2, this.l, 2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0075  */
    @Override // com.opos.exoplayer.core.h.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long a(com.opos.exoplayer.core.h.i r8) {
        /*
            r7 = this;
            java.lang.String r0 = "Unable to connect to "
            r7.l = r8
            r1 = 0
            r7.s = r1
            r7.r = r1
            r3 = 1
            java.net.HttpURLConnection r4 = r7.b(r8)     // Catch: java.io.IOException -> Lc0
            r7.m = r4     // Catch: java.io.IOException -> Lc0
            int r0 = r4.getResponseCode()     // Catch: java.io.IOException -> La1
            r4 = 200(0xc8, float:2.8E-43)
            if (r0 < r4) goto L85
            r5 = 299(0x12b, float:4.19E-43)
            if (r0 <= r5) goto L1e
            goto L85
        L1e:
            java.net.HttpURLConnection r5 = r7.m
            java.lang.String r5 = r5.getContentType()
            com.opos.exoplayer.core.i.o<java.lang.String> r6 = r7.f18966h
            if (r6 == 0) goto L38
            boolean r6 = r6.a(r5)
            if (r6 == 0) goto L2f
            goto L38
        L2f:
            r7.e()
            com.opos.exoplayer.core.h.q$d r0 = new com.opos.exoplayer.core.h.q$d
            r0.<init>(r5, r8)
            throw r0
        L38:
            if (r0 != r4) goto L41
            long r4 = r8.f18921d
            int r0 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r0 == 0) goto L41
            r1 = r4
        L41:
            r7.p = r1
            boolean r0 = r8.a(r3)
            if (r0 != 0) goto L63
            long r0 = r8.f18922e
            r4 = -1
            int r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r2 == 0) goto L52
            goto L65
        L52:
            java.net.HttpURLConnection r0 = r7.m
            long r0 = a(r0)
            int r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r2 == 0) goto L60
            long r4 = r7.p
            long r4 = r0 - r4
        L60:
            r7.q = r4
            goto L67
        L63:
            long r0 = r8.f18922e
        L65:
            r7.q = r0
        L67:
            java.net.HttpURLConnection r0 = r7.m     // Catch: java.io.IOException -> L7b
            java.io.InputStream r0 = r0.getInputStream()     // Catch: java.io.IOException -> L7b
            r7.n = r0     // Catch: java.io.IOException -> L7b
            r7.o = r3
            com.opos.exoplayer.core.h.t<? super com.opos.exoplayer.core.h.n> r0 = r7.k
            if (r0 == 0) goto L78
            r0.a(r7, r8)
        L78:
            long r0 = r7.q
            return r0
        L7b:
            r0 = move-exception
            r7.e()
            com.opos.exoplayer.core.h.q$c r1 = new com.opos.exoplayer.core.h.q$c
            r1.<init>(r0, r8, r3)
            throw r1
        L85:
            java.net.HttpURLConnection r1 = r7.m
            java.util.Map r1 = r1.getHeaderFields()
            r7.e()
            com.opos.exoplayer.core.h.q$e r2 = new com.opos.exoplayer.core.h.q$e
            r2.<init>(r0, r1, r8)
            r8 = 416(0x1a0, float:5.83E-43)
            if (r0 != r8) goto La0
            com.opos.exoplayer.core.h.h r8 = new com.opos.exoplayer.core.h.h
            r0 = 0
            r8.<init>(r0)
            r2.initCause(r8)
        La0:
            throw r2
        La1:
            r1 = move-exception
            r7.e()
            com.opos.exoplayer.core.h.q$c r2 = new com.opos.exoplayer.core.h.q$c
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r0)
            android.net.Uri r0 = r8.f18918a
            java.lang.String r0 = r0.toString()
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            r2.<init>(r0, r1, r8, r3)
            throw r2
        Lc0:
            r1 = move-exception
            com.opos.exoplayer.core.h.q$c r2 = new com.opos.exoplayer.core.h.q$c
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r0)
            android.net.Uri r0 = r8.f18918a
            java.lang.String r0 = r0.toString()
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            r2.<init>(r0, r1, r8, r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.h.n.a(com.opos.exoplayer.core.h.i):long");
    }

    @Override // com.opos.exoplayer.core.h.g
    public Uri a() {
        HttpURLConnection httpURLConnection = this.m;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    @Override // com.opos.exoplayer.core.h.g
    public void b() {
        try {
            if (this.n != null) {
                a(this.m, c());
                try {
                    this.n.close();
                } catch (IOException e2) {
                    throw new q.c(e2, this.l, 3);
                }
            }
        } finally {
            this.n = null;
            e();
            if (this.o) {
                this.o = false;
                t<? super n> tVar = this.k;
                if (tVar != null) {
                    tVar.a(this);
                }
            }
        }
    }

    protected final long c() {
        long j2 = this.q;
        return j2 == -1 ? j2 : j2 - this.s;
    }
}
