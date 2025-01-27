package com.opos.cmn.func.dl.base;

import android.content.Context;
import com.opos.cmn.func.dl.base.DownloadRequest;
import com.opos.cmn.func.dl.base.c.c;
import com.opos.cmn.func.dl.base.c.d;

/* loaded from: classes4.dex */
public class d implements c {

    /* renamed from: a */
    private static final String f17292a = "d";

    /* renamed from: b */
    private boolean f17293b;

    /* renamed from: c */
    private int f17294c;

    /* renamed from: d */
    private int f17295d;

    /* renamed from: e */
    private int f17296e;

    /* renamed from: f */
    private boolean f17297f;

    /* renamed from: g */
    private float f17298g;

    /* renamed from: h */
    private int f17299h;

    /* renamed from: i */
    private int f17300i;

    /* renamed from: j */
    private Context f17301j;
    private com.opos.cmn.func.dl.base.b.c k;
    private com.opos.cmn.func.dl.base.g.b l;
    private com.opos.cmn.func.dl.base.f.a m;
    private d.a n;

    public d(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Context should not be null");
        }
        this.f17301j = context.getApplicationContext();
    }

    private void i() {
        if (this.f17293b) {
            return;
        }
        a((DownloadConfig) null);
    }

    public int a() {
        return this.f17294c;
    }

    @Override // com.opos.cmn.func.dl.base.c
    public void a(DownloadConfig downloadConfig) {
        com.opos.cmn.an.f.a.b(f17292a, "---init!");
        if (this.f17293b) {
            return;
        }
        this.f17293b = true;
        if (downloadConfig == null) {
            downloadConfig = new DownloadConfig();
        }
        this.f17294c = downloadConfig.a();
        this.f17295d = downloadConfig.b();
        this.f17296e = downloadConfig.c();
        this.f17297f = downloadConfig.d();
        this.f17298g = downloadConfig.e();
        this.f17299h = downloadConfig.f();
        this.f17300i = downloadConfig.g();
        this.f17296e = Math.min(Math.max(1, this.f17296e), 5);
        this.f17295d = Math.min(Math.max(1, this.f17295d), 3);
        this.f17294c = Math.min(Math.max(1, this.f17294c), 5);
        if (this.n == null) {
            this.n = new c.a();
        }
        this.k = new com.opos.cmn.func.dl.base.b.b(new com.opos.cmn.func.dl.base.b.a(this.f17296e));
        this.l = new com.opos.cmn.func.dl.base.g.b(this.f17297f, this.k);
        this.m = new com.opos.cmn.func.dl.base.f.a(this, this.l);
    }

    @Override // com.opos.cmn.func.dl.base.c
    public void a(DownloadRequest downloadRequest) {
        com.opos.cmn.an.f.a.b(f17292a, "---start!");
        i();
        this.m.a(downloadRequest, false);
    }

    @Override // com.opos.cmn.func.dl.base.c
    public void a(b bVar) {
        i();
        this.l.f17358a.add(bVar);
    }

    public int b() {
        return this.f17295d;
    }

    @Override // com.opos.cmn.func.dl.base.c
    public void b(DownloadRequest downloadRequest) {
        com.opos.cmn.an.f.a.b(f17292a, "---forceContinue!");
        i();
        this.m.a(downloadRequest, true);
    }

    @Override // com.opos.cmn.func.dl.base.c
    public void b(b bVar) {
        i();
        this.l.f17358a.remove(bVar);
    }

    public float c() {
        return this.f17298g;
    }

    @Override // com.opos.cmn.func.dl.base.c
    public void c(final DownloadRequest downloadRequest) {
        com.opos.cmn.an.f.a.b(f17292a, "---pause!");
        i();
        final com.opos.cmn.func.dl.base.f.a aVar = this.m;
        if (downloadRequest == null) {
            com.opos.cmn.an.f.a.d(com.opos.cmn.func.dl.base.f.a.f17333a, "Request is null,do nothing");
        } else {
            com.opos.cmn.an.j.b.a(new Runnable() { // from class: com.opos.cmn.func.dl.base.f.a.2

                /* renamed from: a */
                final /* synthetic */ DownloadRequest f17344a;

                public AnonymousClass2(final DownloadRequest downloadRequest2) {
                    downloadRequest = downloadRequest2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    com.opos.cmn.func.dl.base.a.c cVar = (com.opos.cmn.func.dl.base.a.c) a.this.f17334b.get(Integer.valueOf(downloadRequest.f17196f));
                    if (cVar != null) {
                        cVar.a();
                    }
                }
            });
        }
    }

    public int d() {
        return this.f17299h;
    }

    @Override // com.opos.cmn.func.dl.base.c
    public void d(final DownloadRequest downloadRequest) {
        com.opos.cmn.an.f.a.b(f17292a, "---cancel!");
        i();
        final com.opos.cmn.func.dl.base.f.a aVar = this.m;
        if (downloadRequest == null) {
            com.opos.cmn.an.f.a.d(com.opos.cmn.func.dl.base.f.a.f17333a, "Request is null,do nothing");
        } else {
            com.opos.cmn.an.j.b.a(new Runnable() { // from class: com.opos.cmn.func.dl.base.f.a.3

                /* renamed from: a */
                final /* synthetic */ DownloadRequest f17346a;

                public AnonymousClass3(final DownloadRequest downloadRequest2) {
                    downloadRequest = downloadRequest2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    com.opos.cmn.func.dl.base.a.c cVar = (com.opos.cmn.func.dl.base.a.c) a.this.f17334b.get(Integer.valueOf(downloadRequest.f17196f));
                    if (cVar != null) {
                        cVar.b();
                    }
                }
            });
        }
    }

    public int e() {
        return this.f17300i;
    }

    public Context f() {
        return this.f17301j;
    }

    public com.opos.cmn.func.dl.base.b.c g() {
        return this.k;
    }

    public d.a h() {
        return this.n;
    }
}
