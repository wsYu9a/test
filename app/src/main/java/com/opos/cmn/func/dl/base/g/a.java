package com.opos.cmn.func.dl.base.g;

import com.opos.cmn.func.dl.base.DownloadRequest;
import com.opos.cmn.func.dl.base.DownloadResponse;
import com.opos.cmn.func.dl.base.exception.DlException;
import com.opos.libs.a.a;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    private static final String f17351a = "a";

    /* renamed from: b */
    private com.opos.libs.a.a f17352b;

    /* renamed from: c */
    private b f17353c;

    /* renamed from: d */
    private DownloadRequest f17354d;

    /* renamed from: e */
    private DownloadResponse f17355e = new DownloadResponse();

    /* renamed from: f */
    private com.opos.cmn.func.dl.base.a.b f17356f;

    public a(com.opos.cmn.func.dl.base.a.b bVar, b bVar2) {
        this.f17356f = bVar;
        this.f17354d = bVar.q;
        this.f17353c = bVar2;
        a.C0418a a2 = new a.C0418a(0).a(0, 1).a(1, 2, 7, 4).a(2, 3, 4, 5).a(3, 4, 5, 6, 7).a(4, 1, 5);
        if (bVar.o) {
            a2.a(7, 1, 5, 4);
        }
        this.f17352b = a2.a();
    }

    private boolean a(int i2) {
        boolean z;
        synchronized (this) {
            int a2 = a();
            z = i2 == this.f17352b.a(i2) && i2 != a2;
            com.opos.cmn.an.f.a.b(f17351a, "Change state:" + a2 + "to " + i2 + ",result:" + z);
        }
        return z;
    }

    private void i() {
        this.f17355e.f17211a = a();
        DownloadResponse downloadResponse = this.f17355e;
        com.opos.cmn.func.dl.base.a.b bVar = this.f17356f;
        downloadResponse.f17214d = bVar.k;
        downloadResponse.f17212b = bVar.l;
        downloadResponse.f17213c = bVar.s.get();
        this.f17355e.f17215e = a() == 3 ? this.f17355e.f17215e : 0L;
    }

    public final int a() {
        int a2;
        synchronized (this) {
            a2 = this.f17352b.a();
        }
        return a2;
    }

    public final void a(long j2) {
        synchronized (this) {
            if (a() == 3) {
                i();
                DownloadResponse downloadResponse = this.f17355e;
                downloadResponse.f17215e = j2;
                this.f17353c.c(this.f17354d, downloadResponse);
            }
        }
    }

    public final void a(DlException dlException) {
        synchronized (this) {
            if (a(7)) {
                com.opos.cmn.func.dl.base.a.b bVar = this.f17356f;
                if (!bVar.m) {
                    bVar.l = 0L;
                    bVar.a(0L);
                }
                i();
                this.f17353c.a(this.f17354d, this.f17355e, dlException);
            }
        }
    }

    public final boolean b() {
        boolean z;
        synchronized (this) {
            int a2 = a();
            z = (a2 == 5 || a2 == 4) ? false : true;
        }
        return z;
    }

    public final boolean c() {
        boolean a2;
        synchronized (this) {
            a2 = a(1);
        }
        return a2;
    }

    public final boolean d() {
        boolean z;
        synchronized (this) {
            if (a(2)) {
                i();
                this.f17353c.a(this.f17354d, this.f17355e);
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public final boolean e() {
        boolean z;
        synchronized (this) {
            if (a(3)) {
                i();
                this.f17353c.b(this.f17354d, this.f17355e);
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public final boolean f() {
        boolean z;
        synchronized (this) {
            if (a(4)) {
                com.opos.cmn.func.dl.base.a.b bVar = this.f17356f;
                if (!bVar.m) {
                    bVar.l = 0L;
                    bVar.a(0L);
                }
                i();
                this.f17353c.d(this.f17354d, this.f17355e);
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public final boolean g() {
        boolean z;
        synchronized (this) {
            if (a(5)) {
                i();
                this.f17353c.e(this.f17354d, this.f17355e);
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public final void h() {
        synchronized (this) {
            if (a(6)) {
                com.opos.cmn.func.dl.base.a.b bVar = this.f17356f;
                if (bVar.k == -1) {
                    bVar.k = bVar.s.get();
                }
                i();
                this.f17353c.f(this.f17354d, this.f17355e);
            }
        }
    }
}
