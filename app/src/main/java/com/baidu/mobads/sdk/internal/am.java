package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/* loaded from: classes2.dex */
public class am {

    /* renamed from: a */
    public static final String f6735a = "OAdURLConnection";

    /* renamed from: b */
    public static final String f6736b = "POST";

    /* renamed from: c */
    public static final String f6737c = "GET";

    /* renamed from: d */
    public static final String f6738d = "application/json";

    /* renamed from: e */
    public static final String f6739e = "text/plain";

    /* renamed from: f */
    private HttpURLConnection f6740f;

    /* renamed from: g */
    private bt f6741g;

    /* renamed from: h */
    private b f6742h;

    /* renamed from: i */
    private c f6743i;

    /* renamed from: j */
    private String f6744j;

    /* renamed from: k */
    private String f6745k;

    /* renamed from: l */
    private String f6746l;

    /* renamed from: m */
    private String f6747m;

    /* renamed from: n */
    private int f6748n;

    /* renamed from: o */
    private int f6749o;

    /* renamed from: p */
    private boolean f6750p;

    /* renamed from: q */
    private Uri.Builder f6751q;

    public class a extends j {
        public a() {
        }

        @Override // com.baidu.mobads.sdk.internal.j
        public Object i() {
            am.this.e();
            am.this.f();
            return null;
        }
    }

    public interface b {
        void a(String str, int i10);

        void a(String str, String str2);
    }

    public interface c {
        void a(InputStream inputStream, String str);

        void a(String str, int i10);
    }

    public am(String str) {
        this(str, "GET");
    }

    public void e() {
        if (TextUtils.isEmpty(this.f6744j) || !cq.a().f(this.f6744j)) {
            return;
        }
        try {
            HttpURLConnection a10 = cq.a().a(new URL(this.f6744j));
            this.f6740f = a10;
            a10.setConnectTimeout(this.f6748n);
            if (Integer.parseInt(bm.a((Context) null).b()) < 8) {
                System.setProperty("http.keepAlive", "false");
            }
            this.f6740f.setRequestMethod(this.f6745k);
            this.f6740f.setUseCaches(this.f6750p);
            if (!TextUtils.isEmpty(this.f6746l)) {
                this.f6740f.setRequestProperty("User-Agent", this.f6746l);
            }
            this.f6740f.setRequestProperty("Content-type", this.f6747m);
            this.f6740f.setRequestProperty(m5.c.f28331o, "keep-alive");
            this.f6740f.setRequestProperty("Cache-Control", "no-cache");
            if (this.f6745k.equals("POST")) {
                this.f6740f.setDoInput(true);
                this.f6740f.setDoOutput(true);
                Uri.Builder builder = this.f6751q;
                if (builder != null) {
                    a(builder.build().getEncodedQuery(), this.f6740f);
                }
            }
        } catch (Exception e10) {
            b bVar = this.f6742h;
            if (bVar != null) {
                bVar.a("Net Create RuntimeError: " + e10.toString(), 0);
            }
            c cVar = this.f6743i;
            if (cVar != null) {
                cVar.a("Net Create RuntimeError: " + e10.toString(), 0);
            }
        }
    }

    public void f() {
        HttpURLConnection httpURLConnection;
        try {
            try {
                this.f6740f.connect();
                this.f6741g.a(f6735a, this.f6740f.getRequestMethod() + " connect code :" + this.f6740f.getResponseCode());
                int responseCode = this.f6740f.getResponseCode();
                if (responseCode == 302 || responseCode == 301) {
                    this.f6740f.setInstanceFollowRedirects(false);
                    HttpURLConnection a10 = a(this.f6740f);
                    this.f6740f = a10;
                    responseCode = a10.getResponseCode();
                }
                if (responseCode / 100 != 2) {
                    b bVar = this.f6742h;
                    if (bVar != null) {
                        bVar.a(this.f6740f.getResponseMessage(), responseCode);
                    }
                    c cVar = this.f6743i;
                    if (cVar != null) {
                        cVar.a(this.f6740f.getResponseMessage(), responseCode);
                    }
                } else {
                    String g10 = cq.a().g(this.f6744j);
                    b bVar2 = this.f6742h;
                    if (bVar2 != null) {
                        bVar2.a(c(), g10);
                    }
                    c cVar2 = this.f6743i;
                    if (cVar2 != null) {
                        cVar2.a(this.f6740f.getInputStream(), g10);
                    }
                }
                httpURLConnection = this.f6740f;
                if (httpURLConnection == null) {
                    return;
                }
            } catch (Exception e10) {
                b bVar3 = this.f6742h;
                if (bVar3 != null) {
                    bVar3.a("Net Connect RuntimeError: " + e10.toString(), 0);
                }
                c cVar3 = this.f6743i;
                if (cVar3 != null) {
                    cVar3.a("Net Connect RuntimeError: " + e10.toString(), 0);
                }
                httpURLConnection = this.f6740f;
                if (httpURLConnection == null) {
                    return;
                }
            }
            httpURLConnection.disconnect();
        } catch (Throwable th2) {
            HttpURLConnection httpURLConnection2 = this.f6740f;
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            throw th2;
        }
    }

    public String c() {
        InputStream inputStream = null;
        try {
            inputStream = this.f6740f.getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[128];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    byteArrayOutputStream.flush();
                    String byteArrayOutputStream2 = byteArrayOutputStream.toString();
                    inputStream.close();
                    return byteArrayOutputStream2;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (Throwable th2) {
            if (inputStream != null) {
                inputStream.close();
            }
            throw th2;
        }
    }

    public void d() {
        HttpURLConnection httpURLConnection = this.f6740f;
        if (httpURLConnection != null) {
            try {
                InputStream inputStream = httpURLConnection.getInputStream();
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Exception e10) {
                ay.h(f6735a).f(e10.toString());
            }
        }
    }

    public am(String str, String str2) {
        this.f6741g = bt.a();
        this.f6742h = null;
        this.f6743i = null;
        this.f6747m = f6739e;
        this.f6748n = 10000;
        this.f6749o = 10000;
        this.f6750p = false;
        this.f6751q = null;
        this.f6744j = str;
        this.f6745k = str2;
    }

    public String a() {
        e();
        HttpURLConnection httpURLConnection = this.f6740f;
        if (httpURLConnection != null) {
            try {
                if (httpURLConnection.getResponseCode() / 100 != 2) {
                    HttpURLConnection httpURLConnection2 = this.f6740f;
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    return null;
                }
                String c10 = c();
                HttpURLConnection httpURLConnection3 = this.f6740f;
                if (httpURLConnection3 != null) {
                    httpURLConnection3.disconnect();
                }
                return c10;
            } catch (Throwable unused) {
                HttpURLConnection httpURLConnection4 = this.f6740f;
                if (httpURLConnection4 != null) {
                    httpURLConnection4.disconnect();
                }
            }
        }
        return null;
    }

    public void b() {
        try {
            bd.a().a((j) new a());
        } catch (Exception unused) {
        }
    }

    public void b(int i10) {
        this.f6749o = i10;
    }

    private void a(String str, HttpURLConnection httpURLConnection) {
        OutputStream outputStream;
        BufferedWriter bufferedWriter;
        BufferedWriter bufferedWriter2 = null;
        try {
            outputStream = httpURLConnection.getOutputStream();
            try {
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            outputStream = null;
        }
        try {
            bufferedWriter.write(str);
            bufferedWriter.flush();
            bufferedWriter.close();
            if (outputStream != null) {
                outputStream.close();
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedWriter2 = bufferedWriter;
            if (bufferedWriter2 != null) {
                bufferedWriter2.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
            throw th;
        }
    }

    public void a(Map<String, String> map) {
        if (this.f6740f != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.f6740f.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
    }

    private HttpURLConnection a(HttpURLConnection httpURLConnection) {
        while (true) {
            try {
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode != 302 && responseCode != 301) {
                    return httpURLConnection;
                }
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(httpURLConnection.getHeaderField(m5.c.f28347t0)).openConnection();
                try {
                    httpURLConnection2.setConnectTimeout(httpURLConnection2.getConnectTimeout());
                    httpURLConnection2.setInstanceFollowRedirects(false);
                    httpURLConnection2.setRequestProperty("Range", "bytes=0-");
                    httpURLConnection = httpURLConnection2;
                } catch (Exception unused) {
                    return httpURLConnection2;
                }
            } catch (Exception unused2) {
                return httpURLConnection;
            }
        }
    }

    public void a(b bVar) {
        this.f6742h = bVar;
    }

    public void a(c cVar) {
        this.f6743i = cVar;
    }

    public void a(int i10) {
        this.f6748n = i10;
    }

    public void a(Uri.Builder builder) {
        this.f6751q = builder;
    }

    public void a(String str) {
        this.f6747m = str;
    }
}
