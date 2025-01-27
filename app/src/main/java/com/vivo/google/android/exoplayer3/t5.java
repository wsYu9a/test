package com.vivo.google.android.exoplayer3;

import android.net.Uri;
import com.vivo.google.android.exoplayer3.u5;
import com.vivo.google.android.exoplayer3.util.Util;
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
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpHost;
import org.apache.http.protocol.HTTP;

/* loaded from: classes4.dex */
public class t5 implements u5 {
    public static final Pattern q = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    public static final AtomicReference<byte[]> r = new AtomicReference<>();

    /* renamed from: a */
    public final boolean f28103a;

    /* renamed from: b */
    public final int f28104b;

    /* renamed from: c */
    public final int f28105c;

    /* renamed from: d */
    public final String f28106d;

    /* renamed from: e */
    public final p6<String> f28107e;

    /* renamed from: f */
    public final u5.g f28108f;

    /* renamed from: g */
    public final u5.g f28109g = new u5.g();

    /* renamed from: h */
    public final x5<? super t5> f28110h;

    /* renamed from: i */
    public q5 f28111i;

    /* renamed from: j */
    public HttpURLConnection f28112j;
    public InputStream k;
    public boolean l;
    public long m;
    public long n;
    public long o;
    public long p;

    public t5(String str, p6<String> p6Var, x5<? super t5> x5Var, int i2, int i3, boolean z, u5.g gVar) {
        this.f28106d = g1.b(str);
        this.f28107e = p6Var;
        this.f28110h = x5Var;
        this.f28104b = i2;
        this.f28105c = i3;
        this.f28103a = z;
        this.f28108f = gVar;
    }

    public final HttpURLConnection a(q5 q5Var) {
        HttpURLConnection a2;
        URL url = new URL(q5Var.f27969a.toString());
        byte[] bArr = q5Var.f27970b;
        long j2 = q5Var.f27972d;
        long j3 = q5Var.f27973e;
        boolean a3 = q5Var.a(1);
        if (!this.f28103a) {
            return a(url, bArr, j2, j3, a3, true);
        }
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            if (i2 > 20) {
                throw new NoRouteToHostException("Too many redirects: " + i3);
            }
            long j4 = j2;
            a2 = a(url, bArr, j2, j3, a3, false);
            int responseCode = a2.getResponseCode();
            if (responseCode == 300 || responseCode == 301 || responseCode == 302 || responseCode == 303 || (bArr == null && (responseCode == 307 || responseCode == 308))) {
                bArr = null;
                String headerField = a2.getHeaderField(HttpHeaders.LOCATION);
                a2.disconnect();
                if (headerField == null) {
                    throw new ProtocolException("Null location redirect");
                }
                URL url2 = new URL(url, headerField);
                String protocol = url2.getProtocol();
                if (!b.b.a.b.b.f4198a.equals(protocol) && !HttpHost.DEFAULT_SCHEME_NAME.equals(protocol)) {
                    throw new ProtocolException("Unsupported protocol redirect: " + protocol);
                }
                url = url2;
                i2 = i3;
                j2 = j4;
            }
        }
        return a2;
    }

    public final void a() {
        HttpURLConnection httpURLConnection = this.f28112j;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception unused) {
            }
            this.f28112j = null;
        }
    }

    public final void b() {
        if (this.o == this.m) {
            return;
        }
        byte[] andSet = r.getAndSet(null);
        if (andSet == null) {
            andSet = new byte[4096];
        }
        while (true) {
            long j2 = this.o;
            long j3 = this.m;
            if (j2 == j3) {
                r.set(andSet);
                return;
            }
            int read = this.k.read(andSet, 0, (int) Math.min(j3 - j2, andSet.length));
            if (Thread.interrupted()) {
                throw new InterruptedIOException();
            }
            if (read == -1) {
                throw new EOFException();
            }
            this.o += read;
            x5<? super t5> x5Var = this.f28110h;
            if (x5Var != null) {
                x5Var.onBytesTransferred(this, read);
            }
        }
    }

    @Override // com.vivo.google.android.exoplayer3.upstream.DataSource
    public void close() {
        try {
            if (this.k != null) {
                HttpURLConnection httpURLConnection = this.f28112j;
                long j2 = this.n;
                if (j2 != -1) {
                    j2 -= this.p;
                }
                int i2 = Util.SDK_INT;
                if (i2 == 19 || i2 == 20) {
                    try {
                        InputStream inputStream = httpURLConnection.getInputStream();
                        if (j2 == -1) {
                            if (inputStream.read() == -1) {
                            }
                        } else if (j2 <= 2048) {
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
                try {
                    this.k.close();
                } catch (IOException e2) {
                    throw new u5.d(e2, this.f28111i, 3);
                }
            }
        } finally {
            this.k = null;
            a();
            if (this.l) {
                this.l = false;
                x5<? super t5> x5Var = this.f28110h;
                if (x5Var != null) {
                    x5Var.onTransferEnd(this);
                }
            }
        }
    }

    @Override // com.vivo.google.android.exoplayer3.upstream.DataSource
    public Uri getUri() {
        HttpURLConnection httpURLConnection = this.f28112j;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0045, code lost:
    
        if (r7 != 0) goto L104;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f7  */
    @Override // com.vivo.google.android.exoplayer3.upstream.DataSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long open(com.vivo.google.android.exoplayer3.q5 r18) {
        /*
            Method dump skipped, instructions count: 373
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.google.android.exoplayer3.t5.open(com.vivo.google.android.exoplayer3.q5):long");
    }

    @Override // com.vivo.google.android.exoplayer3.upstream.DataSource
    public int read(byte[] bArr, int i2, int i3) {
        try {
            b();
            if (i3 == 0) {
                return 0;
            }
            long j2 = this.n;
            if (j2 != -1) {
                long j3 = j2 - this.p;
                if (j3 == 0) {
                    return -1;
                }
                i3 = (int) Math.min(i3, j3);
            }
            int read = this.k.read(bArr, i2, i3);
            if (read == -1) {
                if (this.n == -1) {
                    return -1;
                }
                throw new EOFException();
            }
            this.p += read;
            x5<? super t5> x5Var = this.f28110h;
            if (x5Var != null) {
                x5Var.onBytesTransferred(this, read);
            }
            return read;
        } catch (IOException e2) {
            throw new u5.d(e2, this.f28111i, 2);
        }
    }

    public final HttpURLConnection a(URL url, byte[] bArr, long j2, long j3, boolean z, boolean z2) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.f28104b);
        httpURLConnection.setReadTimeout(this.f28105c);
        if (httpURLConnection instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            try {
                SSLContext sSLContext = SSLContext.getInstance("TLSv1.2");
                sSLContext.init(null, null, null);
                httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
            } catch (KeyManagementException e2) {
                e2.printStackTrace();
            } catch (NoSuchAlgorithmException e3) {
                e3.printStackTrace();
            } catch (Exception unused) {
            }
        }
        u5.g gVar = this.f28108f;
        if (gVar != null) {
            for (Map.Entry<String, String> entry : gVar.b().entrySet()) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        for (Map.Entry<String, String> entry2 : this.f28109g.b().entrySet()) {
            httpURLConnection.setRequestProperty(entry2.getKey(), entry2.getValue());
        }
        if (j2 != 0 || j3 != -1) {
            String str = "bytes=" + j2 + "-";
            if (j3 != -1) {
                str = str + ((j2 + j3) - 1);
            }
            httpURLConnection.setRequestProperty(HttpHeaders.RANGE, str);
        }
        httpURLConnection.setRequestProperty("User-Agent", this.f28106d);
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
}
