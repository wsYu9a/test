package com.opos.mobad.service.j;

import android.content.Context;
import android.text.TextUtils;
import com.opos.cmn.i.a;
import com.opos.mobad.provider.record.CacheEntity;
import com.opos.mobad.service.i.f;
import com.opos.mobad.service.j.m;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class o {

    /* renamed from: a */
    private Context f23748a;

    /* renamed from: b */
    private m f23749b = new m(1, 1, 80, 0.0d, new m.a() { // from class: com.opos.mobad.service.j.o.1
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.service.j.m.a
        public void a(m mVar) {
            o.this.f23751d.a();
        }
    });

    /* renamed from: c */
    private m f23750c = new m(1, 1, 30, 0.0d, new m.a() { // from class: com.opos.mobad.service.j.o.2
        AnonymousClass2() {
        }

        @Override // com.opos.mobad.service.j.m.a
        public void a(m mVar) {
            o.this.f23751d.a();
        }
    });

    /* renamed from: d */
    private com.opos.cmn.i.a f23751d = new com.opos.cmn.i.a(new a.b() { // from class: com.opos.mobad.service.j.o.3
        AnonymousClass3() {
        }

        @Override // com.opos.cmn.i.a.b
        public void a(a.InterfaceC0395a interfaceC0395a) {
            o.this.c();
            interfaceC0395a.a();
        }
    }, 0, 180000);

    /* renamed from: e */
    private com.opos.cmn.i.a f23752e = new com.opos.cmn.i.a(new a.b() { // from class: com.opos.mobad.service.j.o.4
        AnonymousClass4() {
        }

        @Override // com.opos.cmn.i.a.b
        public void a(a.InterfaceC0395a interfaceC0395a) {
            o.this.d();
            interfaceC0395a.a();
        }
    });

    /* renamed from: f */
    private com.opos.mobad.provider.record.a f23753f;

    /* renamed from: g */
    private l f23754g;

    /* renamed from: h */
    private k f23755h;

    /* renamed from: i */
    private j f23756i;

    /* renamed from: j */
    private j f23757j;
    private j k;

    /* renamed from: com.opos.mobad.service.j.o$1 */
    class AnonymousClass1 implements m.a {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.service.j.m.a
        public void a(m mVar) {
            o.this.f23751d.a();
        }
    }

    /* renamed from: com.opos.mobad.service.j.o$2 */
    class AnonymousClass2 implements m.a {
        AnonymousClass2() {
        }

        @Override // com.opos.mobad.service.j.m.a
        public void a(m mVar) {
            o.this.f23751d.a();
        }
    }

    /* renamed from: com.opos.mobad.service.j.o$3 */
    class AnonymousClass3 implements a.b {
        AnonymousClass3() {
        }

        @Override // com.opos.cmn.i.a.b
        public void a(a.InterfaceC0395a interfaceC0395a) {
            o.this.c();
            interfaceC0395a.a();
        }
    }

    /* renamed from: com.opos.mobad.service.j.o$4 */
    class AnonymousClass4 implements a.b {
        AnonymousClass4() {
        }

        @Override // com.opos.cmn.i.a.b
        public void a(a.InterfaceC0395a interfaceC0395a) {
            o.this.d();
            interfaceC0395a.a();
        }
    }

    /* renamed from: com.opos.mobad.service.j.o$5 */
    class AnonymousClass5 implements Runnable {
        AnonymousClass5() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                CacheEntity a2 = o.this.f23753f.a();
                o.this.f23749b.a(a2.f23139a, a2.f23140b);
                CacheEntity b2 = o.this.f23753f.b();
                o.this.f23750c.a(b2.f23139a, b2.f23140b);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.b("", "", e2);
            }
        }
    }

    /* renamed from: com.opos.mobad.service.j.o$6 */
    class AnonymousClass6 implements Runnable {
        AnonymousClass6() {
        }

        @Override // java.lang.Runnable
        public void run() {
            o oVar;
            try {
                int f2 = o.this.f23753f.f();
                com.opos.cmn.an.f.a.b("watch", "check cr amount:" + f2);
                if (f2 >= 5) {
                    oVar = o.this;
                } else {
                    long g2 = o.this.f23753f.g();
                    com.opos.cmn.an.f.a.b("watch", "check cr time:" + g2);
                    if (g2 <= 0 || System.currentTimeMillis() - g2 <= 86400000) {
                        return;
                    } else {
                        oVar = o.this;
                    }
                }
                oVar.a(f2);
            } catch (Throwable th) {
                com.opos.cmn.an.f.a.b("watch", "report cr fail", th);
            }
        }
    }

    /* renamed from: com.opos.mobad.service.j.o$7 */
    class AnonymousClass7 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f23764a;

        /* renamed from: b */
        final /* synthetic */ int f23765b;

        AnonymousClass7(int i2, int i3) {
            i2 = i2;
            i3 = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                o.this.f23753f.a(new CacheEntity(i2, i3));
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.b("", "", e2);
            }
        }
    }

    /* renamed from: com.opos.mobad.service.j.o$8 */
    class AnonymousClass8 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f23767a;

        /* renamed from: b */
        final /* synthetic */ int f23768b;

        AnonymousClass8(int i2, int i3) {
            i2 = i2;
            i3 = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                o.this.f23753f.b(new CacheEntity(i2, i3));
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.b("", "", e2);
            }
        }
    }

    /* renamed from: com.opos.mobad.service.j.o$9 */
    class AnonymousClass9 implements Runnable {
        AnonymousClass9() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                o.this.f23753f.c();
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.b("", "", e2);
            }
        }
    }

    o(Context context) {
        this.f23748a = context.getApplicationContext();
        this.f23753f = new com.opos.mobad.provider.record.a(context);
        com.opos.cmn.an.j.b.b(new Runnable() { // from class: com.opos.mobad.service.j.o.5
            AnonymousClass5() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    CacheEntity a2 = o.this.f23753f.a();
                    o.this.f23749b.a(a2.f23139a, a2.f23140b);
                    CacheEntity b2 = o.this.f23753f.b();
                    o.this.f23750c.a(b2.f23139a, b2.f23140b);
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.b("", "", e2);
                }
            }
        });
        a();
    }

    private void a() {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.j.o.6
            AnonymousClass6() {
            }

            @Override // java.lang.Runnable
            public void run() {
                o oVar;
                try {
                    int f2 = o.this.f23753f.f();
                    com.opos.cmn.an.f.a.b("watch", "check cr amount:" + f2);
                    if (f2 >= 5) {
                        oVar = o.this;
                    } else {
                        long g2 = o.this.f23753f.g();
                        com.opos.cmn.an.f.a.b("watch", "check cr time:" + g2);
                        if (g2 <= 0 || System.currentTimeMillis() - g2 <= 86400000) {
                            return;
                        } else {
                            oVar = o.this;
                        }
                    }
                    oVar.a(f2);
                } catch (Throwable th) {
                    com.opos.cmn.an.f.a.b("watch", "report cr fail", th);
                }
            }
        });
    }

    public void a(int i2) throws Exception {
        String h2 = this.f23753f.h();
        String i3 = this.f23753f.i();
        com.opos.mobad.service.i.d.a().c().a(i2, h2, !TextUtils.isEmpty(i3) ? new JSONObject(i3) : null);
        this.f23753f.a((String) null);
    }

    private void b() {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.j.o.9
            AnonymousClass9() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    o.this.f23753f.c();
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.b("", "", e2);
                }
            }
        });
    }

    public void c() {
        com.opos.mobad.service.i.d.a().c().a(this.f23749b.c(), this.f23749b.d(), this.f23750c.c(), this.f23750c.d());
        b();
    }

    private void c(int i2, int i3) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.j.o.7

            /* renamed from: a */
            final /* synthetic */ int f23764a;

            /* renamed from: b */
            final /* synthetic */ int f23765b;

            AnonymousClass7(int i22, int i32) {
                i2 = i22;
                i3 = i32;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    o.this.f23753f.a(new CacheEntity(i2, i3));
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.b("", "", e2);
                }
            }
        });
    }

    public void d() {
        if (this.f23755h != null) {
            f.a c2 = com.opos.mobad.service.i.d.a().c();
            k kVar = this.f23755h;
            c2.b(kVar.f23721a, kVar.f23722b);
            this.f23755h = null;
            return;
        }
        if (this.f23754g != null) {
            f.a c3 = com.opos.mobad.service.i.d.a().c();
            l lVar = this.f23754g;
            c3.a(lVar.f23723a, lVar.f23724b);
            this.f23754g = null;
            return;
        }
        j jVar = this.f23756i;
        if (jVar != null) {
            com.opos.mobad.service.i.d.a().c().a(jVar.f23720a);
            this.f23756i = null;
        }
        j jVar2 = this.f23757j;
        if (jVar2 != null) {
            com.opos.mobad.service.i.d.a().c().b(jVar2.f23720a);
            this.f23757j = null;
        }
        j jVar3 = this.k;
        if (jVar3 != null) {
            com.opos.mobad.service.i.d.a().c().c(jVar3.f23720a);
            this.k = null;
        }
    }

    private void d(int i2, int i3) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.j.o.8

            /* renamed from: a */
            final /* synthetic */ int f23767a;

            /* renamed from: b */
            final /* synthetic */ int f23768b;

            AnonymousClass8(int i22, int i32) {
                i2 = i22;
                i3 = i32;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    o.this.f23753f.b(new CacheEntity(i2, i3));
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.b("", "", e2);
                }
            }
        });
    }

    public void a(int i2, int i3) {
        this.f23749b.a(i2, i3);
        c(this.f23749b.c() + i2, this.f23749b.d() + i3);
    }

    public void a(String str) {
        this.f23756i = new j(str);
        this.f23752e.a();
    }

    public void a(Throwable th) {
        try {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            this.f23753f.a(stringWriter.toString(), com.opos.mobad.p.a.a(this.f23748a));
        } catch (Throwable th2) {
            com.opos.cmn.an.f.a.b("watch", "add cr fail", th2);
        }
    }

    public void b(int i2, int i3) {
        d(this.f23750c.c() + i2, this.f23750c.d() + i3);
        this.f23750c.a(i2, i3);
    }

    public void b(String str) {
        this.f23757j = new j(str);
        this.f23752e.a();
    }

    public void c(String str) {
        this.k = new j(str);
        this.f23752e.a();
    }
}
