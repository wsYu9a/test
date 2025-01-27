package com.opos.mobad.j;

import android.content.Context;
import android.text.TextUtils;
import com.opos.mobad.activity.webview.b.d;
import com.opos.mobad.activity.webview.b.e;
import com.opos.mobad.cmn.a.a.a;
import com.opos.mobad.cmn.service.pkginstall.b;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.e.a;
import com.opos.mobad.q.a.h;
import com.opos.mobad.q.a.l;
import com.opos.mobad.service.event.EventDescription;
import com.opos.mobad.service.event.c;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class b implements a.InterfaceC0430a {

    /* renamed from: a */
    private static final String f21121a = "b";

    /* renamed from: b */
    private Context f21122b;

    /* renamed from: c */
    private String f21123c;

    /* renamed from: d */
    private a.C0457a f21124d;

    /* renamed from: f */
    private com.opos.mobad.cmn.a.a f21126f;

    /* renamed from: g */
    private com.opos.mobad.ad.d.b f21127g;

    /* renamed from: h */
    private a.b f21128h;

    /* renamed from: i */
    private h f21129i;

    /* renamed from: j */
    private l f21130j;
    private C0452b l;
    private c m;
    private c n;

    /* renamed from: e */
    private boolean f21125e = false;
    private d o = new d() { // from class: com.opos.mobad.j.b.1
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.activity.webview.b.d
        public void d() {
            if (b.this.f21125e) {
                return;
            }
            b.this.f21127g.e();
        }

        @Override // com.opos.mobad.activity.webview.b.d
        public void e() {
            if (b.this.f21125e) {
                return;
            }
            if (b.this.n != null) {
                com.opos.mobad.service.event.b.a().b(b.this.n);
            }
            b.this.f21127g.f();
            if (b.this.f21128h != null) {
                b.this.f21128h.d();
            }
        }
    };
    private a k = new a();

    /* renamed from: com.opos.mobad.j.b$1 */
    class AnonymousClass1 implements d {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.activity.webview.b.d
        public void d() {
            if (b.this.f21125e) {
                return;
            }
            b.this.f21127g.e();
        }

        @Override // com.opos.mobad.activity.webview.b.d
        public void e() {
            if (b.this.f21125e) {
                return;
            }
            if (b.this.n != null) {
                com.opos.mobad.service.event.b.a().b(b.this.n);
            }
            b.this.f21127g.f();
            if (b.this.f21128h != null) {
                b.this.f21128h.d();
            }
        }
    }

    private class a implements b.InterfaceC0437b {
        private a() {
        }

        /* synthetic */ a(b bVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.opos.mobad.cmn.service.pkginstall.b.InterfaceC0437b
        public void a(AdItemData adItemData, String str) {
            try {
                com.opos.cmn.an.f.a.b(b.f21121a, "notifyInstallCompletedEvent pkgName=" + str);
                if (b.this.f21125e) {
                    return;
                }
                b.this.f21130j.b(adItemData, str);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a(b.f21121a, "", (Throwable) e2);
            }
        }

        @Override // com.opos.mobad.cmn.service.pkginstall.b.InterfaceC0437b
        public void b(AdItemData adItemData, String str) {
            b.this.f21130j.a(adItemData, str);
        }

        @Override // com.opos.mobad.cmn.service.pkginstall.b.InterfaceC0437b
        public void c(AdItemData adItemData, String str) {
            b.this.f21130j.a(adItemData, str);
        }
    }

    /* renamed from: com.opos.mobad.j.b$b */
    private class C0452b extends com.opos.mobad.q.a.e.a {

        /* renamed from: c */
        private boolean f21134c;

        private C0452b() {
            this.f21134c = false;
        }

        /* synthetic */ C0452b(b bVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.opos.mobad.cmn.a.a.a.b
        public void a(int i2, String str) {
            if (b.this.f21125e) {
                return;
            }
            b.this.f21127g.a(i2, str);
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(long j2) {
            if (b.this.f21125e) {
                return;
            }
            b.this.f21127g.a(j2);
        }

        @Override // com.opos.mobad.q.a.e.a, com.opos.mobad.cmn.service.pkginstall.b.InterfaceC0437b
        public void a(AdItemData adItemData, String str) {
            super.a(adItemData, str);
            b.this.f21130j.b(adItemData, str);
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(String str) {
            if (b.this.f21125e) {
                return;
            }
            b.this.f21127g.a(str);
        }

        @Override // com.opos.mobad.ad.h
        public void a(Object... objArr) {
            if (b.this.f21125e) {
                return;
            }
            b.this.f21127g.a(objArr);
        }

        @Override // com.opos.mobad.q.a.j.a
        public void b() {
            if (b.this.f21125e) {
                return;
            }
            this.f21134c = false;
            b.this.f21127g.c();
        }

        @Override // com.opos.mobad.q.a.j.a
        public void b(long j2) {
            if (b.this.f21125e) {
                return;
            }
            if (b.this.f21124d != null && b.this.f21124d.f21745c.T() == 0 && this.f21134c) {
                return;
            }
            b.this.f21127g.b(j2);
            if (b.this.f21128h != null) {
                b.this.f21128h.d();
            }
        }

        @Override // com.opos.mobad.q.a.e.a, com.opos.mobad.cmn.service.pkginstall.b.InterfaceC0437b
        public void b(AdItemData adItemData, String str) {
            super.b(adItemData, str);
            b.this.f21130j.a(adItemData, str);
        }

        @Override // com.opos.mobad.q.a.j.a
        public void b(String str) {
            if (b.this.f21125e) {
                return;
            }
            b.this.f21127g.b(str);
        }

        @Override // com.opos.mobad.q.a.j.a
        public void c() {
            if (b.this.f21125e) {
                return;
            }
            this.f21134c = true;
            b.this.f21127g.d();
            b.this.d();
        }

        @Override // com.opos.mobad.q.a.e.a, com.opos.mobad.cmn.service.pkginstall.b.InterfaceC0437b
        public void c(AdItemData adItemData, String str) {
            super.c(adItemData, str);
            b.this.f21130j.a(adItemData, str);
        }

        @Override // com.opos.mobad.cmn.a.a.a.b
        public void d() {
        }

        @Override // com.opos.mobad.q.a.e.a
        public void e() {
            if (b.this.m != null) {
                com.opos.mobad.service.event.b.a().b(b.this.m);
            }
        }

        @Override // com.opos.mobad.q.a.a.InterfaceC0474a
        public void j_() {
        }

        public void l_() {
            this.f21134c = false;
        }
    }

    public b(Context context, String str, com.opos.mobad.ad.d.b bVar, com.opos.mobad.cmn.a.d dVar, h hVar) {
        this.f21122b = context;
        this.f21123c = str;
        this.f21127g = bVar;
        this.f21126f = new com.opos.mobad.cmn.a.a(this.f21122b, this.f21123c, dVar);
        C0452b c0452b = new C0452b();
        this.l = c0452b;
        this.f21129i = hVar;
        this.f21130j = new l(this.f21122b, c0452b);
    }

    private int a(a.C0457a c0457a) {
        int d2 = c0457a.f21745c.d();
        if (d2 != 10 && d2 != 12 && d2 != 14) {
            com.opos.cmn.an.f.a.b(f21121a, "illegal type");
            return 10409;
        }
        if (1 != c0457a.f21744b.r() && 2 != c0457a.f21744b.r()) {
            com.opos.cmn.an.f.a.b(f21121a, "illegal mode");
            return 10407;
        }
        if (c0457a.f21744b.r() == 1 && TextUtils.isEmpty(com.opos.cmn.d.d.a(this.f21122b, c0457a.f21746d.a(), c0457a.f21746d.b()))) {
            com.opos.cmn.an.f.a.b(f21121a, "illegal cache url");
            return 10408;
        }
        if (!com.opos.cmn.an.h.c.a.d(this.f21122b)) {
            com.opos.cmn.an.f.a.b(f21121a, "no net");
            return 10403;
        }
        if (System.currentTimeMillis() <= c0457a.f21744b.s()) {
            return 10000;
        }
        com.opos.cmn.an.f.a.b(f21121a, "exp time");
        return 10404;
    }

    private void a(int i2) {
        Context context;
        String b2;
        String str;
        String c2;
        String a2;
        String str2;
        if (this.f21125e) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("rsCode", "" + i2);
        a.C0457a c0457a = this.f21124d;
        if (c0457a == null) {
            context = this.f21122b;
            str = this.f21123c;
            b2 = "";
            str2 = "4";
            c2 = "";
            a2 = "";
        } else {
            hashMap.put("clientTemplateId", String.valueOf(c0457a.f21745c.b()));
            context = this.f21122b;
            b2 = this.f21124d.f21744b.b();
            str = this.f21123c;
            c2 = this.f21124d.f21744b.c();
            a2 = this.f21124d.f21744b.a();
            str2 = "4";
        }
        com.opos.mobad.cmn.a.b.d.a(context, b2, str, str2, c2, a2, hashMap);
        a.b bVar = this.f21128h;
        if (bVar != null) {
            bVar.a(i2, com.opos.mobad.ad.a.a(i2));
        }
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
                com.opos.cmn.an.f.a.a(f21121a, "", (Throwable) e2);
            }
        }
        com.opos.cmn.an.f.a.b(f21121a, "hasVideoLandingPage =" + z);
        return z;
    }

    private boolean a(a.C0457a c0457a, int i2, a.b bVar, boolean z) {
        boolean z2 = false;
        try {
            this.f21128h = bVar;
            if (c0457a == null) {
                a(10402);
            } else {
                int a2 = a(c0457a);
                if (10000 != a2) {
                    com.opos.cmn.an.f.a.b(f21121a, "illegal play video condition");
                    a(a2);
                } else {
                    this.l.l_();
                    this.f21124d = c0457a;
                    this.f21130j.a(c0457a.f21744b, c0457a.f21745c);
                    EventDescription eventDescription = new EventDescription(c());
                    this.m = com.opos.mobad.q.a.a.a.a(eventDescription, this.l);
                    h hVar = this.f21129i;
                    Context context = this.f21122b;
                    a.C0457a c0457a2 = this.f21124d;
                    AdItemData adItemData = c0457a2.f21744b;
                    hVar.a(context, adItemData, c0457a2.f21746d, adItemData.r(), z, i2, eventDescription);
                    z2 = true;
                }
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a(f21121a, "", (Throwable) e2);
        }
        return z2;
    }

    private String c() {
        return this.f21123c + "_" + System.currentTimeMillis();
    }

    public void d() {
        a.C0457a c0457a = this.f21124d;
        if (c0457a != null && c0457a.f21745c.T() == 0 && a(this.f21124d.f21744b) && this.f21124d.f21745c.T() == 0) {
            EventDescription eventDescription = new EventDescription(c());
            this.n = e.a(eventDescription, this.o);
            this.f21126f.a(this.f21124d.f21744b, true, (b.InterfaceC0437b) this.k, eventDescription);
        }
    }

    @Override // com.opos.mobad.cmn.a.a.a
    public void a() {
        this.f21125e = true;
        this.f21130j.e();
        com.opos.mobad.service.event.b.a().b(this.m);
        com.opos.mobad.service.event.b.a().b(this.n);
        com.opos.mobad.cmn.service.pkginstall.b.a(this.f21122b).a(this.k);
    }

    @Override // com.opos.mobad.cmn.a.a.a.InterfaceC0430a
    public boolean a(a.C0457a c0457a, int i2, a.b bVar) {
        return a(c0457a, i2, bVar, false);
    }
}
