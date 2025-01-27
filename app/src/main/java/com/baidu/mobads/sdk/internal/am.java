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
import org.apache.http.HttpHeaders;

/* loaded from: classes.dex */
public class am {

    /* renamed from: a */
    public static final String f5517a = "OAdURLConnection";

    /* renamed from: b */
    public static final String f5518b = "POST";

    /* renamed from: c */
    public static final String f5519c = "GET";

    /* renamed from: d */
    public static final String f5520d = "application/json";

    /* renamed from: e */
    public static final String f5521e = "text/plain";

    /* renamed from: f */
    private HttpURLConnection f5522f;

    /* renamed from: g */
    private bq f5523g;

    /* renamed from: h */
    private b f5524h;

    /* renamed from: i */
    private c f5525i;

    /* renamed from: j */
    private String f5526j;
    private String k;
    private String l;
    private String m;
    private int n;
    private int o;
    private boolean p;
    private Uri.Builder q;

    class a extends h {
        a() {
        }

        @Override // com.baidu.mobads.sdk.internal.h
        public Object i() {
            am.this.e();
            am.this.f();
            return null;
        }
    }

    public interface b {
        void a(String str, int i2);

        void a(String str, String str2);
    }

    public interface c {
        void a(InputStream inputStream, String str);

        void a(String str, int i2);
    }

    public am(String str) {
        this(str, "GET");
    }

    public void e() {
        if (TextUtils.isEmpty(this.f5526j)) {
            return;
        }
        try {
            HttpURLConnection a2 = cn.a().a(new URL(this.f5526j));
            this.f5522f = a2;
            a2.setConnectTimeout(this.n);
            if (Integer.parseInt(bj.a((Context) null).b()) < 8) {
                System.setProperty("http.keepAlive", "false");
            }
            this.f5522f.setRequestMethod(this.k);
            this.f5522f.setUseCaches(this.p);
            if (!TextUtils.isEmpty(this.l)) {
                this.f5522f.setRequestProperty("User-Agent", this.l);
            }
            this.f5522f.setRequestProperty("Content-type", this.m);
            this.f5522f.setRequestProperty("Connection", "keep-alive");
            this.f5522f.setRequestProperty("Cache-Control", "no-cache");
            if (this.k.equals("POST")) {
                this.f5522f.setDoInput(true);
                this.f5522f.setDoOutput(true);
                Uri.Builder builder = this.q;
                if (builder != null) {
                    a(builder.build().getEncodedQuery(), this.f5522f);
                }
            }
        } catch (Exception e2) {
            b bVar = this.f5524h;
            if (bVar != null) {
                bVar.a("Net Create RuntimeError: " + e2.toString(), 0);
            }
            c cVar = this.f5525i;
            if (cVar != null) {
                cVar.a("Net Create RuntimeError: " + e2.toString(), 0);
            }
        }
    }

    public void f() {
        HttpURLConnection httpURLConnection;
        try {
            try {
                this.f5522f.connect();
                this.f5523g.a(f5517a, this.f5522f.getRequestMethod() + " connect code :" + this.f5522f.getResponseCode());
                int responseCode = this.f5522f.getResponseCode();
                if (responseCode == 302 || responseCode == 301) {
                    this.f5522f.setInstanceFollowRedirects(false);
                    HttpURLConnection a2 = a(this.f5522f);
                    this.f5522f = a2;
                    responseCode = a2.getResponseCode();
                }
                if (responseCode / 100 != 2) {
                    b bVar = this.f5524h;
                    if (bVar != null) {
                        bVar.a(this.f5522f.getResponseMessage(), responseCode);
                    }
                    c cVar = this.f5525i;
                    if (cVar != null) {
                        cVar.a(this.f5522f.getResponseMessage(), responseCode);
                    }
                } else {
                    String f2 = cn.a().f(this.f5526j);
                    b bVar2 = this.f5524h;
                    if (bVar2 != null) {
                        bVar2.a(c(), f2);
                    }
                    c cVar2 = this.f5525i;
                    if (cVar2 != null) {
                        cVar2.a(this.f5522f.getInputStream(), f2);
                    }
                }
                httpURLConnection = this.f5522f;
                if (httpURLConnection == null) {
                    return;
                }
            } catch (Exception e2) {
                b bVar3 = this.f5524h;
                if (bVar3 != null) {
                    bVar3.a("Net Connect RuntimeError: " + e2.toString(), 0);
                }
                c cVar3 = this.f5525i;
                if (cVar3 != null) {
                    cVar3.a("Net Connect RuntimeError: " + e2.toString(), 0);
                }
                httpURLConnection = this.f5522f;
                if (httpURLConnection == null) {
                    return;
                }
            }
            httpURLConnection.disconnect();
        } catch (Throwable th) {
            HttpURLConnection httpURLConnection2 = this.f5522f;
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            throw th;
        }
    }

    public String c() {
        InputStream inputStream = null;
        try {
            inputStream = this.f5522f.getInputStream();
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
        } catch (Throwable th) {
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }

    public void d() {
        HttpURLConnection httpURLConnection = this.f5522f;
        if (httpURLConnection != null) {
            try {
                InputStream inputStream = httpURLConnection.getInputStream();
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Exception e2) {
                av.h(f5517a).f(e2.toString());
            }
        }
    }

    public am(String str, String str2) {
        this.f5523g = bq.a();
        this.f5524h = null;
        this.f5525i = null;
        this.m = "text/plain";
        this.n = 10000;
        this.o = 10000;
        this.p = false;
        this.q = null;
        this.f5526j = str;
        this.k = str2;
    }

    public String a() {
        e();
        HttpURLConnection httpURLConnection = this.f5522f;
        if (httpURLConnection != null) {
            try {
                if (httpURLConnection.getResponseCode() / 100 != 2) {
                    HttpURLConnection httpURLConnection2 = this.f5522f;
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    return null;
                }
                String c2 = c();
                HttpURLConnection httpURLConnection3 = this.f5522f;
                if (httpURLConnection3 != null) {
                    httpURLConnection3.disconnect();
                }
                return c2;
            } catch (Throwable unused) {
                HttpURLConnection httpURLConnection4 = this.f5522f;
                if (httpURLConnection4 != null) {
                    httpURLConnection4.disconnect();
                }
            }
        }
        return null;
    }

    public void b() {
        try {
            ba.a().a((h) new a());
        } catch (Exception unused) {
        }
    }

    public void b(int i2) {
        this.o = i2;
    }

    private void a(String str, HttpURLConnection httpURLConnection) {
        OutputStream outputStream;
        BufferedWriter bufferedWriter;
        BufferedWriter bufferedWriter2 = null;
        try {
            outputStream = httpURLConnection.getOutputStream();
            try {
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            outputStream = null;
        }
        try {
            bufferedWriter.write(str);
            bufferedWriter.flush();
            bufferedWriter.close();
            if (outputStream != null) {
                outputStream.close();
            }
        } catch (Throwable th3) {
            th = th3;
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
        if (this.f5522f != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.f5522f.setRequestProperty(entry.getKey(), entry.getValue());
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
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(httpURLConnection.getHeaderField(HttpHeaders.LOCATION)).openConnection();
                try {
                    httpURLConnection2.setConnectTimeout(httpURLConnection2.getConnectTimeout());
                    httpURLConnection2.setInstanceFollowRedirects(false);
                    httpURLConnection2.setRequestProperty(HttpHeaders.RANGE, "bytes=0-");
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
        this.f5524h = bVar;
    }

    public void a(c cVar) {
        this.f5525i = cVar;
    }

    public void a(int i2) {
        this.n = i2;
    }

    public void a(Uri.Builder builder) {
        this.q = builder;
    }

    public void a(String str) {
        this.m = str;
    }
}
