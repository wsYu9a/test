package com.opos.mobad.h.b;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import com.heytap.msp.mobad.api.params.INativeTempletAdView;
import com.opos.mobad.ad.c.o;
import com.opos.mobad.ad.c.p;
import com.opos.mobad.ad.g;
import com.opos.mobad.cmn.a.a;
import com.opos.mobad.cmn.service.pkginstall.b;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.e.a;
import com.opos.mobad.q.a.m;

/* loaded from: classes4.dex */
public class e extends g.a implements p {

    /* renamed from: a */
    private Context f20918a;

    /* renamed from: b */
    private a.C0457a f20919b;

    /* renamed from: c */
    private f f20920c;

    /* renamed from: d */
    private com.opos.mobad.n.a f20921d;

    /* renamed from: e */
    private o f20922e;

    /* renamed from: f */
    private a.b f20923f;

    /* renamed from: g */
    private com.opos.mobad.ad.privacy.b f20924g;

    /* renamed from: h */
    private Object f20925h;

    /* renamed from: i */
    private b.InterfaceC0437b f20926i = new b.InterfaceC0437b() { // from class: com.opos.mobad.h.b.e.1
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.cmn.service.pkginstall.b.InterfaceC0437b
        public void a(AdItemData adItemData, String str) {
            com.opos.cmn.an.f.a.b(INativeTempletAdView.TAG, "notifyInstallCompletedEvent:" + str);
            e.this.a(str);
        }

        @Override // com.opos.mobad.cmn.service.pkginstall.b.InterfaceC0437b
        public void b(AdItemData adItemData, String str) {
        }

        @Override // com.opos.mobad.cmn.service.pkginstall.b.InterfaceC0437b
        public void c(AdItemData adItemData, String str) {
        }
    };

    /* renamed from: j */
    private m.a f20927j = new m.a() { // from class: com.opos.mobad.h.b.e.2
        AnonymousClass2() {
        }

        @Override // com.opos.mobad.cmn.a.a.a.b
        public void a(int i2, String str) {
            if (e.this.f20922e != null) {
                e.this.f20922e.a(f.a(i2), e.this);
            }
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(long j2) {
            e.this.f20922e.a(e.this);
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(String str) {
            if (e.this.f20922e != null) {
                e.this.f20922e.b(e.this);
            }
        }

        @Override // com.opos.mobad.ad.h
        public void a(Object... objArr) {
        }

        @Override // com.opos.mobad.q.a.j.a
        public void b() {
        }

        @Override // com.opos.mobad.q.a.j.a
        public void b(long j2) {
        }

        @Override // com.opos.mobad.q.a.j.a
        public void b(String str) {
        }

        @Override // com.opos.mobad.q.a.j.a
        public void c() {
        }

        @Override // com.opos.mobad.cmn.a.a.a.b
        public void d() {
            e.this.f20921d.d();
            if (e.this.f20922e != null) {
                e.this.f20922e.c(e.this);
            }
        }

        @Override // com.opos.mobad.q.a.a.InterfaceC0474a
        public void j_() {
            if (e.this.f20922e != null) {
                e.this.f20922e.d(e.this);
            }
        }
    };

    /* renamed from: com.opos.mobad.h.b.e$1 */
    class AnonymousClass1 implements b.InterfaceC0437b {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.cmn.service.pkginstall.b.InterfaceC0437b
        public void a(AdItemData adItemData, String str) {
            com.opos.cmn.an.f.a.b(INativeTempletAdView.TAG, "notifyInstallCompletedEvent:" + str);
            e.this.a(str);
        }

        @Override // com.opos.mobad.cmn.service.pkginstall.b.InterfaceC0437b
        public void b(AdItemData adItemData, String str) {
        }

        @Override // com.opos.mobad.cmn.service.pkginstall.b.InterfaceC0437b
        public void c(AdItemData adItemData, String str) {
        }
    }

    /* renamed from: com.opos.mobad.h.b.e$2 */
    class AnonymousClass2 implements m.a {
        AnonymousClass2() {
        }

        @Override // com.opos.mobad.cmn.a.a.a.b
        public void a(int i2, String str) {
            if (e.this.f20922e != null) {
                e.this.f20922e.a(f.a(i2), e.this);
            }
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(long j2) {
            e.this.f20922e.a(e.this);
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(String str) {
            if (e.this.f20922e != null) {
                e.this.f20922e.b(e.this);
            }
        }

        @Override // com.opos.mobad.ad.h
        public void a(Object... objArr) {
        }

        @Override // com.opos.mobad.q.a.j.a
        public void b() {
        }

        @Override // com.opos.mobad.q.a.j.a
        public void b(long j2) {
        }

        @Override // com.opos.mobad.q.a.j.a
        public void b(String str) {
        }

        @Override // com.opos.mobad.q.a.j.a
        public void c() {
        }

        @Override // com.opos.mobad.cmn.a.a.a.b
        public void d() {
            e.this.f20921d.d();
            if (e.this.f20922e != null) {
                e.this.f20922e.c(e.this);
            }
        }

        @Override // com.opos.mobad.q.a.a.InterfaceC0474a
        public void j_() {
            if (e.this.f20922e != null) {
                e.this.f20922e.d(e.this);
            }
        }
    }

    public e(Context context, a.C0457a c0457a, String str, com.opos.mobad.cmn.a.a aVar, com.opos.mobad.n.a aVar2, o oVar, com.opos.mobad.cmn.b.c cVar) {
        this.f20918a = context;
        this.f20919b = c0457a;
        this.f20921d = aVar2;
        this.f20922e = oVar;
        this.f20924g = new com.opos.mobad.cmn.b.e(cVar);
        this.f20920c = new f(context, c0457a, str, aVar, new com.opos.mobad.o.a.a(this.f20918a, null), aVar2, this.f20926i, this.f20927j, this.f20924g);
        a.b a2 = com.opos.mobad.cmn.a.b.f.a(context, aVar2.c());
        this.f20923f = a2;
        aVar.a(a2);
    }

    @Override // com.opos.mobad.ad.c.p
    public View a() {
        View c2 = this.f20921d.c();
        if (c2 != null && Build.VERSION.SDK_INT >= 29) {
            c2.setForceDarkAllowed(false);
            com.opos.cmn.an.f.a.b(INativeTempletAdView.TAG, "get Ad view set force");
        }
        return c2;
    }

    @Override // com.opos.mobad.ad.c.p
    public void a(Object obj) {
        this.f20925h = obj;
    }

    public void a(String str) {
        com.opos.cmn.an.f.a.b(INativeTempletAdView.TAG, "notifyInstallCompletedEvent pkgname =" + str);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.f20919b.f21745c.k()) || !this.f20919b.f21745c.k().equals(str)) {
            return;
        }
        this.f20920c.a(str);
    }

    @Override // com.opos.mobad.ad.c.p
    public void b() {
        this.f20920c.a();
    }

    @Override // com.opos.mobad.ad.c.p
    public void c() {
        this.f20921d.d();
        this.f20920c.c();
        a.b bVar = this.f20923f;
        if (bVar != null) {
            bVar.a();
        }
        this.f20924g.a();
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public void c(int i2) {
        this.f20920c.d(i2);
    }

    @Override // com.opos.mobad.ad.c.p
    public Object d() {
        return this.f20925h;
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public int f() {
        return this.f20919b.f21744b.X();
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public int g() {
        return this.f20919b.f21744b.Y();
    }
}
