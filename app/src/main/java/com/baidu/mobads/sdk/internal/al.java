package com.baidu.mobads.sdk.internal;

import android.content.Context;
import com.baidu.mobads.sdk.internal.u;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Observable;
import org.apache.http.HttpHeaders;

/* loaded from: classes.dex */
public class al extends Observable implements u, Runnable {

    /* renamed from: i */
    protected static final int f5507i = 10240;

    /* renamed from: j */
    protected static final int f5508j = 10240;
    public static final String k = ".tmp";
    private static final String m = "FileDownloader";

    /* renamed from: a */
    protected Context f5509a;

    /* renamed from: b */
    protected URL f5510b;

    /* renamed from: c */
    protected String f5511c;

    /* renamed from: d */
    protected String f5512d;

    /* renamed from: e */
    protected int f5513e;

    /* renamed from: f */
    protected u.a f5514f;

    /* renamed from: g */
    protected int f5515g;

    /* renamed from: h */
    protected int f5516h;
    protected byte[] l;
    private boolean n;

    public al(Context context, URL url, String str, String str2, boolean z) {
        this.n = false;
        this.f5509a = context;
        this.f5510b = url;
        this.f5511c = str;
        this.n = z;
        if (str2 == null || str2.trim().length() <= 0) {
            String file = url.getFile();
            this.f5512d = file.substring(file.lastIndexOf(47) + 1);
        } else {
            this.f5512d = str2;
        }
        this.f5513e = -1;
        this.f5514f = u.a.DOWNLOADING;
        this.f5515g = 0;
        this.f5516h = 0;
    }

    private void s() {
        a(u.a.ERROR);
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void a() {
        a(u.a.DOWNLOADING);
        p();
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void a(boolean z) {
    }

    @Override // com.baidu.mobads.sdk.internal.u
    @Deprecated
    public void b() {
    }

    @Override // com.baidu.mobads.sdk.internal.u
    @Deprecated
    public void c() {
    }

    @Override // com.baidu.mobads.sdk.internal.u
    @Deprecated
    public void d() {
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public String e() {
        return this.f5510b.toString();
    }

    @Override // com.baidu.mobads.sdk.internal.u
    @Deprecated
    public String f() {
        return null;
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public String g() {
        return this.f5511c + this.f5512d;
    }

    @Override // com.baidu.mobads.sdk.internal.u
    @Deprecated
    public String h() {
        return null;
    }

    @Override // com.baidu.mobads.sdk.internal.u
    @Deprecated
    public String i() {
        return null;
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public int j() {
        return this.f5513e;
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public float k() {
        return Math.abs((this.f5515g / this.f5513e) * 100.0f);
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public u.a l() {
        return this.f5514f;
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public void m() {
    }

    @Override // com.baidu.mobads.sdk.internal.u
    public boolean n() {
        return false;
    }

    public byte[] o() {
        return this.l;
    }

    protected void p() {
        ba.a().a(this);
    }

    protected void q() {
        setChanged();
        notifyObservers();
    }

    protected void r() {
        bo.a(this.f5511c + this.f5512d + ".tmp", this.f5511c + this.f5512d);
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x01ba A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01a2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01d2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            Method dump skipped, instructions count: 498
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.internal.al.run():void");
    }

    protected void a(u.a aVar) {
        this.f5514f = aVar;
        q();
    }

    protected void a(int i2, float f2) {
        this.f5515g += i2;
        q();
    }

    private HttpURLConnection a(HttpURLConnection httpURLConnection) {
        while (true) {
            try {
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode != 302 && responseCode != 301) {
                    return httpURLConnection;
                }
                URL url = new URL(httpURLConnection.getHeaderField(HttpHeaders.LOCATION));
                this.f5510b = url;
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
                try {
                    httpURLConnection2.setConnectTimeout(10000);
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
}
