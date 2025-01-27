package com.baidu.mobads.sdk.internal;

import android.content.Context;
import com.baidu.mobads.sdk.internal.x;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Observable;

/* loaded from: classes2.dex */
public class al extends Observable implements x, Runnable {

    /* renamed from: i */
    protected static final int f6721i = 10240;

    /* renamed from: j */
    protected static final int f6722j = 10240;

    /* renamed from: k */
    public static final String f6723k = ".tmp";

    /* renamed from: m */
    private static final String f6724m = "FileDownloader";

    /* renamed from: a */
    protected Context f6725a;

    /* renamed from: b */
    protected URL f6726b;

    /* renamed from: c */
    protected String f6727c;

    /* renamed from: d */
    protected String f6728d;

    /* renamed from: e */
    protected int f6729e;

    /* renamed from: f */
    protected x.a f6730f;

    /* renamed from: g */
    protected int f6731g;

    /* renamed from: h */
    protected int f6732h;

    /* renamed from: l */
    protected byte[] f6733l;

    /* renamed from: n */
    private boolean f6734n;

    public al(Context context, URL url, String str, String str2, boolean z10) {
        this.f6725a = context;
        this.f6726b = url;
        this.f6727c = str;
        this.f6734n = z10;
        if (str2 == null || str2.trim().length() <= 0) {
            String file = url.getFile();
            this.f6728d = file.substring(file.lastIndexOf(47) + 1);
        } else {
            this.f6728d = str2;
        }
        this.f6729e = -1;
        this.f6730f = x.a.DOWNLOADING;
        this.f6731g = 0;
        this.f6732h = 0;
    }

    private void s() {
        a(x.a.ERROR);
    }

    @Override // com.baidu.mobads.sdk.internal.x
    public void a(boolean z10) {
    }

    @Override // com.baidu.mobads.sdk.internal.x
    @Deprecated
    public void b() {
    }

    @Override // com.baidu.mobads.sdk.internal.x
    @Deprecated
    public void c() {
    }

    @Override // com.baidu.mobads.sdk.internal.x
    @Deprecated
    public void d() {
    }

    @Override // com.baidu.mobads.sdk.internal.x
    public String e() {
        return this.f6726b.toString();
    }

    @Override // com.baidu.mobads.sdk.internal.x
    @Deprecated
    public String f() {
        return null;
    }

    @Override // com.baidu.mobads.sdk.internal.x
    public String g() {
        return this.f6727c + this.f6728d;
    }

    @Override // com.baidu.mobads.sdk.internal.x
    @Deprecated
    public String h() {
        return null;
    }

    @Override // com.baidu.mobads.sdk.internal.x
    @Deprecated
    public String i() {
        return null;
    }

    @Override // com.baidu.mobads.sdk.internal.x
    public int j() {
        return this.f6729e;
    }

    @Override // com.baidu.mobads.sdk.internal.x
    public float k() {
        return Math.abs((this.f6731g / this.f6729e) * 100.0f);
    }

    @Override // com.baidu.mobads.sdk.internal.x
    public x.a l() {
        return this.f6730f;
    }

    @Override // com.baidu.mobads.sdk.internal.x
    public void m() {
    }

    @Override // com.baidu.mobads.sdk.internal.x
    public boolean n() {
        return false;
    }

    public byte[] o() {
        return this.f6733l;
    }

    public void p() {
        bd.a().a(this);
    }

    public void q() {
        setChanged();
        notifyObservers();
    }

    public void r() {
        br.a(this.f6727c + this.f6728d + ".tmp", this.f6727c + this.f6728d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01f3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01db A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01c3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            Method dump skipped, instructions count: 529
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.internal.al.run():void");
    }

    @Override // com.baidu.mobads.sdk.internal.x
    public void a() {
        a(x.a.DOWNLOADING);
        p();
    }

    public void a(x.a aVar) {
        this.f6730f = aVar;
        q();
    }

    public void a(int i10, float f10) {
        this.f6731g += i10;
        q();
    }

    private HttpURLConnection a(HttpURLConnection httpURLConnection) {
        while (true) {
            try {
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode != 302 && responseCode != 301) {
                    return httpURLConnection;
                }
                URL url = new URL(httpURLConnection.getHeaderField(m5.c.f28347t0));
                this.f6726b = url;
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
                try {
                    httpURLConnection2.setConnectTimeout(10000);
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
}
