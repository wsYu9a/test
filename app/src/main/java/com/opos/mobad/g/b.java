package com.opos.mobad.g;

import android.content.Context;
import android.text.TextUtils;
import com.opos.mobad.activity.webview.b.d;
import com.opos.mobad.activity.webview.b.e;
import com.opos.mobad.cmn.a.a.a;
import com.opos.mobad.cmn.service.pkginstall.b;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.e.a;
import com.opos.mobad.q.a.h;
import com.opos.mobad.service.event.EventDescription;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class b implements a.InterfaceC0430a {

    /* renamed from: a */
    private static final String f20847a = "b";

    /* renamed from: b */
    private Context f20848b;

    /* renamed from: c */
    private String f20849c;

    /* renamed from: d */
    private a.C0457a f20850d;

    /* renamed from: e */
    private com.opos.mobad.cmn.a.a f20851e;

    /* renamed from: f */
    private a f20852f;

    /* renamed from: g */
    private a.b f20853g;

    /* renamed from: h */
    private h f20854h;

    /* renamed from: i */
    private C0446b f20855i = new C0446b();

    /* renamed from: j */
    private c f20856j = new c();
    private volatile boolean k;
    private com.opos.mobad.service.event.c l;
    private com.opos.mobad.service.event.c m;

    public interface a {
        void a();

        void b();

        void c();
    }

    /* renamed from: com.opos.mobad.g.b$b */
    private class C0446b extends com.opos.mobad.q.a.e.a {

        /* renamed from: c */
        private boolean f20858c;

        private C0446b() {
            this.f20858c = false;
        }

        /* synthetic */ C0446b(b bVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.opos.mobad.cmn.a.a.a.b
        public void a(int i2, String str) {
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(long j2) {
            if (b.this.k || b.this.f20852f == null) {
                return;
            }
            b.this.f20852f.a();
        }

        @Override // com.opos.mobad.q.a.e.a, com.opos.mobad.cmn.service.pkginstall.b.InterfaceC0437b
        public void a(AdItemData adItemData, String str) {
            super.a(adItemData, str);
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(String str) {
        }

        @Override // com.opos.mobad.ad.h
        public void a(Object... objArr) {
        }

        @Override // com.opos.mobad.q.a.j.a
        public void b() {
            if (b.this.k) {
                return;
            }
            this.f20858c = false;
            b.this.f20852f.b();
        }

        @Override // com.opos.mobad.q.a.j.a
        public void b(long j2) {
            if (b.this.k) {
                return;
            }
            if (b.this.f20850d != null && b.this.f20850d.f21745c.T() == 0 && this.f20858c) {
                return;
            }
            b.this.f20853g.d();
        }

        @Override // com.opos.mobad.q.a.e.a, com.opos.mobad.cmn.service.pkginstall.b.InterfaceC0437b
        public void b(AdItemData adItemData, String str) {
            super.b(adItemData, str);
        }

        @Override // com.opos.mobad.q.a.j.a
        public void b(String str) {
        }

        @Override // com.opos.mobad.q.a.j.a
        public void c() {
            if (b.this.k) {
                return;
            }
            this.f20858c = true;
            b.this.c();
            b.this.f20852f.c();
        }

        @Override // com.opos.mobad.q.a.e.a, com.opos.mobad.cmn.service.pkginstall.b.InterfaceC0437b
        public void c(AdItemData adItemData, String str) {
            super.c(adItemData, str);
        }

        @Override // com.opos.mobad.cmn.a.a.a.b
        public void d() {
        }

        @Override // com.opos.mobad.q.a.e.a
        public void e() {
            if (b.this.l != null) {
                com.opos.mobad.service.event.b.a().b(b.this.l);
            }
        }

        @Override // com.opos.mobad.q.a.a.InterfaceC0474a
        public void j_() {
        }

        public void k_() {
            this.f20858c = false;
        }
    }

    private class c implements d {

        /* renamed from: com.opos.mobad.g.b$c$1 */
        class AnonymousClass1 implements Runnable {
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (b.this.f20853g != null) {
                    b.this.f20853g.d();
                }
            }
        }

        private c() {
        }

        /* synthetic */ c(b bVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.opos.mobad.activity.webview.b.d
        public void d() {
        }

        @Override // com.opos.mobad.activity.webview.b.d
        public void e() {
            if (b.this.k) {
                return;
            }
            if (b.this.m != null) {
                com.opos.mobad.service.event.b.a().b(b.this.m);
            }
            com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.g.b.c.1
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.f20853g != null) {
                        b.this.f20853g.d();
                    }
                }
            });
        }
    }

    public b(Context context, String str, com.opos.mobad.cmn.a.d dVar, h hVar, a aVar) {
        this.f20848b = context;
        this.f20849c = str;
        this.f20852f = aVar;
        this.f20851e = new com.opos.mobad.cmn.a.a(this.f20848b, this.f20849c, dVar);
        this.f20854h = hVar;
    }

    private int a(a.C0457a c0457a) {
        int d2 = c0457a.f21745c.d();
        if (d2 != 10 && d2 != 12 && d2 != 14) {
            com.opos.cmn.an.f.a.b(f20847a, "illegal type");
            return 10409;
        }
        if (1 != c0457a.f21744b.r() && 2 != c0457a.f21744b.r()) {
            com.opos.cmn.an.f.a.b(f20847a, "illegal mode");
            return 10407;
        }
        if (c0457a.f21744b.r() == 1 && TextUtils.isEmpty(com.opos.cmn.d.d.a(this.f20848b, c0457a.f21746d.a(), c0457a.f21746d.b()))) {
            com.opos.cmn.an.f.a.b(f20847a, "illegal cache url");
            return 10408;
        }
        if (!com.opos.cmn.an.h.c.a.d(this.f20848b)) {
            com.opos.cmn.an.f.a.b(f20847a, "no net");
            return 10403;
        }
        if (System.currentTimeMillis() <= c0457a.f21744b.s()) {
            return 10000;
        }
        com.opos.cmn.an.f.a.b(f20847a, "exp time");
        return 10404;
    }

    private void a(int i2) {
        Context context;
        String b2;
        String str;
        String c2;
        String a2;
        String str2;
        if (this.k) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("rsCode", "" + i2);
        a.C0457a c0457a = this.f20850d;
        if (c0457a == null) {
            context = this.f20848b;
            str = this.f20849c;
            b2 = "";
            str2 = "4";
            c2 = "";
            a2 = "";
        } else {
            hashMap.put("clientTemplateId", String.valueOf(c0457a.f21745c.b()));
            context = this.f20848b;
            b2 = this.f20850d.f21744b.b();
            str = this.f20849c;
            c2 = this.f20850d.f21744b.c();
            a2 = this.f20850d.f21744b.a();
            str2 = "4";
        }
        com.opos.mobad.cmn.a.b.d.a(context, b2, str, str2, c2, a2, hashMap);
        b(i2);
    }

    private boolean a(AdItemData adItemData) {
        boolean z = false;
        if (adItemData != null) {
            try {
                if (adItemData.i() != null && adItemData.i().size() > 0 && adItemData.i().get(0) != null) {
                    if (!com.opos.cmn.an.c.a.a(adItemData.i().get(0).w())) {
                        z = true;
                    }
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a(f20847a, "", (Throwable) e2);
            }
        }
        com.opos.cmn.an.f.a.b(f20847a, "hasVideoLandingPage =" + z);
        return z;
    }

    private String b() {
        return this.f20849c + "_" + System.currentTimeMillis();
    }

    private void b(int i2) {
        a.b bVar = this.f20853g;
        if (bVar != null) {
            bVar.a(i2, com.opos.mobad.ad.a.a(i2));
        }
    }

    public void c() {
        a.C0457a c0457a = this.f20850d;
        if (c0457a != null && c0457a.f21745c.T() == 0 && a(this.f20850d.f21744b) && this.f20850d.f21745c.T() == 0) {
            EventDescription eventDescription = new EventDescription(b());
            this.m = e.a(eventDescription, this.f20856j);
            this.f20851e.a(this.f20850d.f21744b, true, (b.InterfaceC0437b) this.f20855i, eventDescription);
        }
    }

    @Override // com.opos.mobad.cmn.a.a.a
    public void a() {
        this.k = true;
        com.opos.mobad.service.event.b.a().b(this.l);
        com.opos.mobad.service.event.b.a().b(this.m);
        this.f20852f = null;
    }

    @Override // com.opos.mobad.cmn.a.a.a.InterfaceC0430a
    public boolean a(a.C0457a c0457a, int i2, a.b bVar) {
        boolean z = false;
        try {
            this.f20853g = bVar;
            if (c0457a == null) {
                a(10402);
            } else {
                int a2 = a(c0457a);
                if (10000 != a2) {
                    a(a2);
                } else {
                    this.f20855i.k_();
                    this.f20851e.a(c0457a.f21744b);
                    this.f20851e.b(c0457a.f21744b);
                    this.f20850d = c0457a;
                    EventDescription eventDescription = new EventDescription(b());
                    this.l = com.opos.mobad.q.a.a.a.a(eventDescription, this.f20855i);
                    h hVar = this.f20854h;
                    Context context = this.f20848b;
                    a.C0457a c0457a2 = this.f20850d;
                    AdItemData adItemData = c0457a2.f21744b;
                    hVar.a(context, adItemData, c0457a2.f21746d, adItemData.r(), false, i2, eventDescription);
                    z = true;
                }
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a(f20847a, "", (Throwable) e2);
        }
        return z;
    }
}
