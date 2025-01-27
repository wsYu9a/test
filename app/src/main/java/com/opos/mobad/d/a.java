package com.opos.mobad.d;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.opos.cmn.func.dl.base.DownloadConfig;
import com.opos.cmn.func.dl.base.DownloadRequest;
import com.opos.cmn.func.dl.base.DownloadResponse;
import com.opos.cmn.func.dl.base.exception.DlException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: b */
    private static volatile a f20375b;

    /* renamed from: c */
    private static final byte[] f20376c = new byte[0];

    /* renamed from: a */
    private Context f20377a;

    /* renamed from: d */
    private com.opos.cmn.func.dl.a f20378d;

    /* renamed from: e */
    private b f20379e;

    /* renamed from: f */
    private InterfaceC0439a f20380f;

    /* renamed from: g */
    private ConcurrentHashMap<String, DownloadRequest> f20381g = new ConcurrentHashMap<>();

    /* renamed from: h */
    private boolean f20382h = false;

    /* renamed from: i */
    private AtomicBoolean f20383i = new AtomicBoolean(false);

    /* renamed from: com.opos.mobad.d.a$1 */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f20384a;

        AnonymousClass1(String str) {
            str = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f20380f != null) {
                a.this.f20380f.a(str);
            }
        }
    }

    /* renamed from: com.opos.mobad.d.a$a */
    public interface InterfaceC0439a {
        void a(String str);

        void a(String str, int i2, long j2, long j3);

        void a(String str, long j2, long j3);

        void b(String str);

        void b(String str, long j2, long j3);

        void c(String str);

        void c(String str, long j2, long j3);

        void d(String str, long j2, long j3);
    }

    private class b implements com.opos.cmn.func.dl.base.b {
        private b() {
        }

        /* synthetic */ b(a aVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        private boolean a(DownloadRequest downloadRequest) {
            return (downloadRequest == null || TextUtils.isEmpty(downloadRequest.f17191a) || !a.this.f20381g.containsKey(downloadRequest.f17191a)) ? false : true;
        }

        @Override // com.opos.cmn.func.dl.base.b
        public void a(DownloadRequest downloadRequest, DownloadResponse downloadResponse) {
            if (!a(downloadRequest) || a.this.f20380f == null || downloadResponse == null) {
                return;
            }
            a.this.f20380f.a(downloadRequest.f17191a, downloadResponse.f17213c, downloadResponse.f17214d);
        }

        @Override // com.opos.cmn.func.dl.base.b
        public void a(DownloadRequest downloadRequest, DownloadResponse downloadResponse, DlException dlException) {
            com.opos.cmn.an.f.a.b("DownloadApkTool", "fail exception:" + dlException);
            if (!a(downloadRequest) || a.this.f20380f == null || downloadResponse == null || dlException == null) {
                return;
            }
            if (dlException.a() == 1013) {
                a.this.f20380f.c(downloadRequest.f17191a);
            } else {
                a.this.f20380f.a(downloadRequest.f17191a, dlException.a(), downloadResponse.f17213c, downloadResponse.f17214d);
            }
        }

        @Override // com.opos.cmn.func.dl.base.b
        public void b(DownloadRequest downloadRequest, DownloadResponse downloadResponse) {
            if (!a(downloadRequest) || a.this.f20380f == null || downloadResponse == null) {
                return;
            }
            a.this.f20380f.b(downloadRequest.f17191a, downloadResponse.f17213c, downloadResponse.f17214d);
        }

        @Override // com.opos.cmn.func.dl.base.b
        public void c(DownloadRequest downloadRequest, DownloadResponse downloadResponse) {
            if (!a(downloadRequest) || a.this.f20380f == null || downloadResponse == null) {
                return;
            }
            a.this.f20380f.b(downloadRequest.f17191a, downloadResponse.f17213c, downloadResponse.f17214d);
        }

        @Override // com.opos.cmn.func.dl.base.b
        public void d(DownloadRequest downloadRequest, DownloadResponse downloadResponse) {
            if (!a(downloadRequest) || a.this.f20380f == null || downloadResponse == null) {
                return;
            }
            a.this.f20380f.c(downloadRequest.f17191a, downloadResponse.f17213c, downloadResponse.f17214d);
        }

        @Override // com.opos.cmn.func.dl.base.b
        public void e(DownloadRequest downloadRequest, DownloadResponse downloadResponse) {
            if (!a(downloadRequest) || a.this.f20380f == null || downloadResponse == null) {
                return;
            }
            a.this.f20380f.d(downloadRequest.f17191a, downloadResponse.f17213c, downloadResponse.f17214d);
            a.this.f(downloadRequest.f17191a);
        }

        @Override // com.opos.cmn.func.dl.base.b
        public void f(DownloadRequest downloadRequest, DownloadResponse downloadResponse) {
            com.opos.cmn.an.f.a.b("DownloadApkTool", "complete ");
            if (!a(downloadRequest) || a.this.f20380f == null) {
                return;
            }
            a.this.f20380f.b(downloadRequest.f17191a);
            a.this.f(downloadRequest.f17191a);
        }
    }

    private a(Context context) {
        if (context == null) {
            return;
        }
        this.f20377a = context.getApplicationContext();
        this.f20378d = new com.opos.cmn.func.dl.a(this.f20377a);
        this.f20379e = new b();
    }

    public static a a(Context context) {
        if (f20375b == null) {
            synchronized (f20376c) {
                if (f20375b == null) {
                    f20375b = new a(context);
                }
            }
        }
        return f20375b;
    }

    private void b() {
        if (this.f20383i.get()) {
            return;
        }
        a(3, (InterfaceC0439a) null);
    }

    private void e(String str) {
        if (com.opos.cmn.an.c.a.a(str) || com.opos.cmn.an.d.b.a.b(str)) {
            return;
        }
        com.opos.cmn.an.d.b.a.f(str);
    }

    public void f(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f20381g.remove(str);
    }

    public int a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            com.opos.cmn.an.f.a.b("DownloadApkTool", "add to download but url is empty");
        } else {
            try {
                b();
                com.opos.cmn.an.f.a.b("DownloadApkTool", "add download request:" + str);
                if (!this.f20382h && !"WIFI".equalsIgnoreCase(com.opos.cmn.an.h.c.a.f(this.f20377a))) {
                    this.f20382h = true;
                }
                DownloadRequest.a c2 = new DownloadRequest.a(str).a(this.f20382h).b(com.opos.cmn.d.a.b(this.f20377a)).c(com.opos.cmn.d.b.a(str)).b(false).c(true);
                if (!TextUtils.isEmpty(str2)) {
                    c2.a(str2);
                }
                DownloadRequest a2 = c2.a(this.f20377a);
                this.f20381g.put(str, a2);
                this.f20378d.a(a2);
                if (this.f20380f != null) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.opos.mobad.d.a.1

                        /* renamed from: a */
                        final /* synthetic */ String f20384a;

                        AnonymousClass1(String str3) {
                            str = str3;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.f20380f != null) {
                                a.this.f20380f.a(str);
                            }
                        }
                    });
                }
                return a2.f17196f;
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("DownloadApkTool", "", (Throwable) e2);
            }
        }
        return -1;
    }

    public void a() {
        try {
            this.f20378d.b(this.f20379e);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("DownloadApkTool", "", (Throwable) e2);
        }
    }

    public void a(int i2, InterfaceC0439a interfaceC0439a) {
        if (this.f20383i.compareAndSet(false, true)) {
            com.opos.cmn.an.f.a.b("DownloadApkTool", "init download apk manager");
            this.f20380f = interfaceC0439a;
            e(com.opos.cmn.d.a.b(this.f20377a));
            DownloadConfig downloadConfig = new DownloadConfig();
            downloadConfig.a(i2).a(true).a(0.005f, 1000, 524288);
            this.f20378d.a(downloadConfig);
            this.f20378d.a(this.f20379e);
        }
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            com.opos.cmn.an.f.a.b("DownloadApkTool", "addMobileTask but url is empty");
            return;
        }
        b();
        this.f20382h = true;
        com.opos.cmn.an.f.a.b("DownloadApkTool", "pause download request:" + str);
        DownloadRequest downloadRequest = this.f20381g.get(str);
        if (downloadRequest != null) {
            this.f20378d.b(downloadRequest);
        }
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            com.opos.cmn.an.f.a.b("DownloadApkTool", "pause download but url is empty");
            return;
        }
        b();
        com.opos.cmn.an.f.a.b("DownloadApkTool", "pause download request:" + str);
        DownloadRequest downloadRequest = this.f20381g.get(str);
        if (downloadRequest != null) {
            this.f20378d.c(downloadRequest);
        }
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            com.opos.cmn.an.f.a.b("DownloadApkTool", "cancel download but url is empty");
            return;
        }
        b();
        com.opos.cmn.an.f.a.b("DownloadApkTool", "cancel download request:" + str);
        DownloadRequest downloadRequest = this.f20381g.get(str);
        if (downloadRequest != null) {
            this.f20378d.d(downloadRequest);
        }
    }

    public void d(String str) {
        if (TextUtils.isEmpty(str)) {
            com.opos.cmn.an.f.a.b("DownloadApkTool", "resume download but url is empty");
            return;
        }
        b();
        com.opos.cmn.an.f.a.b("DownloadApkTool", "resume download request:" + str);
        DownloadRequest downloadRequest = this.f20381g.get(str);
        if (downloadRequest != null) {
            this.f20378d.a(downloadRequest);
        }
    }
}
