package com.shu.priory.download.b.b;

import android.os.Process;
import com.shu.priory.config.SDKConstants;
import com.shu.priory.download.d.b;
import com.shu.priory.utils.h;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import m5.c;

/* loaded from: classes3.dex */
public class a implements Runnable {

    /* renamed from: a */
    private b f16943a;

    /* renamed from: b */
    private com.shu.priory.download.b.a f16944b;

    /* renamed from: c */
    private com.shu.priory.download.d.a f16945c;

    /* renamed from: d */
    private InterfaceC0552a f16946d;

    /* renamed from: e */
    private InputStream f16947e;

    /* renamed from: f */
    private long f16948f;

    /* renamed from: com.shu.priory.download.b.b.a$a */
    public interface InterfaceC0552a {
        void c();

        void d();

        void e();
    }

    public a(b bVar, com.shu.priory.download.b.a aVar, com.shu.priory.download.d.a aVar2, InterfaceC0552a interfaceC0552a) {
        this.f16943a = bVar;
        this.f16944b = aVar;
        this.f16945c = aVar2;
        this.f16948f = bVar.d();
        this.f16946d = interfaceC0552a;
    }

    private String a(String str) throws Exception {
        h.a(SDKConstants.TAG, "down thread preUrl-->" + str);
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setConnectTimeout(5000);
        if (httpURLConnection.getResponseCode() == 200 || httpURLConnection.getResponseCode() == 206) {
            h.a(SDKConstants.TAG, "down thread downUrl-->" + str);
            return str;
        }
        if (httpURLConnection.getResponseCode() != 302) {
            return str;
        }
        String headerField = httpURLConnection.getHeaderField(c.f28347t0);
        h.a(SDKConstants.TAG, "down thread tempUrl-->" + headerField);
        return a(headerField);
    }

    private void b() {
        com.shu.priory.download.d.a aVar = this.f16945c;
        if (aVar != null && aVar.k()) {
            throw new com.shu.priory.download.e.a(7);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        try {
            b();
            a();
        } catch (com.shu.priory.download.e.a e10) {
            this.f16946d.e();
            this.f16945c.a(e10);
            this.f16945c.a(5);
            this.f16944b.a(this.f16945c);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x015a A[Catch: all -> 0x010b, TRY_ENTER, TryCatch #9 {, blocks: (B:35:0x0106, B:47:0x0115, B:71:0x015a, B:72:0x015d), top: B:3:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized void a() {
        /*
            Method dump skipped, instructions count: 352
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shu.priory.download.b.b.a.a():void");
    }
}
