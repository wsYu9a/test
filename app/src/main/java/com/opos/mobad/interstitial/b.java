package com.opos.mobad.interstitial;

import android.app.Activity;
import android.content.Context;
import com.opos.mobad.cmn.a.a;
import com.opos.mobad.cmn.a.b.f;
import com.opos.mobad.model.b;
import com.opos.mobad.model.data.AdData;
import com.opos.mobad.model.e.a;
import com.opos.mobad.q.a.h;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public class b extends com.opos.mobad.l.c implements com.opos.mobad.ad.b.a {

    /* renamed from: a */
    com.opos.mobad.q.a.b.c f21074a;

    /* renamed from: b */
    private a f21075b;

    /* renamed from: c */
    private Context f21076c;

    /* renamed from: d */
    private String f21077d;

    /* renamed from: g */
    private a.C0457a f21078g;

    /* renamed from: h */
    private int f21079h;

    /* renamed from: i */
    private int f21080i;

    /* renamed from: j */
    private a.b f21081j;
    private com.opos.mobad.cmn.a.d k;
    private com.opos.mobad.cmn.a.a l;
    private h m;
    private com.opos.mobad.q.a.b.d n;

    /* renamed from: com.opos.mobad.interstitial.b$1 */
    class AnonymousClass1 implements b.a {

        /* renamed from: com.opos.mobad.interstitial.b$1$1 */
        class CallableC04501 implements Callable<Boolean> {

            /* renamed from: a */
            final /* synthetic */ int f21083a;

            /* renamed from: b */
            final /* synthetic */ a.C0457a f21084b;

            CallableC04501(int i2, a.C0457a c0457a) {
                i3 = i2;
                c0457a = c0457a;
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() throws Exception {
                com.opos.cmn.an.f.a.b("InterInterstitialAd", " call load succ");
                b.this.f21079h = i3;
                b.this.f21078g = c0457a;
                return Boolean.TRUE;
            }
        }

        AnonymousClass1() {
        }

        @Override // com.opos.mobad.model.b.a
        public void a(int i2, a.C0457a c0457a) {
            b.this.c(new Callable<Boolean>() { // from class: com.opos.mobad.interstitial.b.1.1

                /* renamed from: a */
                final /* synthetic */ int f21083a;

                /* renamed from: b */
                final /* synthetic */ a.C0457a f21084b;

                CallableC04501(int i22, a.C0457a c0457a2) {
                    i3 = i22;
                    c0457a = c0457a2;
                }

                @Override // java.util.concurrent.Callable
                /* renamed from: a */
                public Boolean call() throws Exception {
                    com.opos.cmn.an.f.a.b("InterInterstitialAd", " call load succ");
                    b.this.f21079h = i3;
                    b.this.f21078g = c0457a;
                    return Boolean.TRUE;
                }
            });
        }

        @Override // com.opos.mobad.model.b.a
        public void a(int i2, String str, AdData adData) {
            b.this.b(i2, str);
            if (adData != null) {
                b.this.f21079h = adData.c();
            }
        }
    }

    /* renamed from: com.opos.mobad.interstitial.b$2 */
    class AnonymousClass2 extends com.opos.mobad.q.a.b.c {
        AnonymousClass2() {
        }

        @Override // com.opos.mobad.cmn.a.a.a.b
        public void a(int i2, String str) {
            a aVar = b.this.f21075b;
            if (aVar != null) {
                aVar.a();
            }
            b.this.c(i2, str);
            b.this.i_();
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(long j2) {
            b.this.p();
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(String str) {
            b.this.q();
        }

        @Override // com.opos.mobad.cmn.a.a.a.b
        public void d() {
            a aVar = b.this.f21075b;
            if (aVar != null) {
                aVar.a();
            }
            b.this.i_();
        }
    }

    public b(Activity activity, String str, com.opos.mobad.cmn.a.d dVar, com.opos.mobad.ad.b.b bVar, h hVar) {
        super(bVar);
        this.f21074a = new com.opos.mobad.q.a.b.c() { // from class: com.opos.mobad.interstitial.b.2
            AnonymousClass2() {
            }

            @Override // com.opos.mobad.cmn.a.a.a.b
            public void a(int i2, String str2) {
                a aVar = b.this.f21075b;
                if (aVar != null) {
                    aVar.a();
                }
                b.this.c(i2, str2);
                b.this.i_();
            }

            @Override // com.opos.mobad.ad.i.b
            public void a(long j2) {
                b.this.p();
            }

            @Override // com.opos.mobad.ad.i.b
            public void a(String str2) {
                b.this.q();
            }

            @Override // com.opos.mobad.cmn.a.a.a.b
            public void d() {
                a aVar = b.this.f21075b;
                if (aVar != null) {
                    aVar.a();
                }
                b.this.i_();
            }
        };
        this.f21076c = activity.getApplicationContext();
        this.f21077d = str;
        this.k = dVar;
        this.l = new com.opos.mobad.cmn.a.a(activity, this.f21077d, this.k);
        a.b b2 = f.b(activity);
        this.f21081j = b2;
        this.l.a(b2);
        this.m = hVar;
        this.n = new InterstitialCreator();
    }

    @Override // com.opos.mobad.l.j, com.opos.mobad.ad.b
    public void b() {
        synchronized (this) {
            com.opos.cmn.an.f.a.b("InterInterstitialAd", "destroyAd");
            if (f.e()) {
                this.f21081j.a();
                a aVar = this.f21075b;
                if (aVar != null) {
                    aVar.a();
                }
                super.b();
            }
        }
    }

    @Override // com.opos.mobad.l.k
    protected boolean b(Activity activity) {
        if (activity == null) {
            return false;
        }
        a.C0457a c0457a = this.f21078g;
        if (c0457a == null) {
            com.opos.cmn.an.f.a.b("InterInterstitialAd", "show but data null");
        } else {
            if (c0457a == null || c0457a.f21743a.a() != 1) {
                a a2 = c.a(activity, this.f21077d, this.f21074a, this.m, this.l, this.n, this.f21078g, this.f21080i);
                this.f21075b = a2;
                return a2.a(activity);
            }
            com.opos.mobad.service.a.a().a(this.f21077d, 2, this.f21078g.f21744b.f(), this.f21078g.f21744b.b(), this.f21078g.f21745c.aa(), this.f21078g.f21744b.a(), this.f21078g.f21744b.J());
        }
        c(-1, com.opos.mobad.ad.a.a(-1));
        return false;
    }

    @Override // com.opos.mobad.l.j
    protected boolean b(String str) {
        return false;
    }

    @Override // com.opos.mobad.l.j
    protected boolean b(String str, int i2) {
        com.opos.cmn.an.f.a.b("InterInterstitialAd", "doLoad");
        this.f21079h = 0;
        this.f21080i = 0;
        com.opos.mobad.model.b.a(this.f21076c.getApplicationContext()).a(this.f21076c, this.f21077d, 2, str, i2, new b.a() { // from class: com.opos.mobad.interstitial.b.1

            /* renamed from: com.opos.mobad.interstitial.b$1$1 */
            class CallableC04501 implements Callable<Boolean> {

                /* renamed from: a */
                final /* synthetic */ int f21083a;

                /* renamed from: b */
                final /* synthetic */ a.C0457a f21084b;

                CallableC04501(int i22, a.C0457a c0457a2) {
                    i3 = i22;
                    c0457a = c0457a2;
                }

                @Override // java.util.concurrent.Callable
                /* renamed from: a */
                public Boolean call() throws Exception {
                    com.opos.cmn.an.f.a.b("InterInterstitialAd", " call load succ");
                    b.this.f21079h = i3;
                    b.this.f21078g = c0457a;
                    return Boolean.TRUE;
                }
            }

            AnonymousClass1() {
            }

            @Override // com.opos.mobad.model.b.a
            public void a(int i22, a.C0457a c0457a2) {
                b.this.c(new Callable<Boolean>() { // from class: com.opos.mobad.interstitial.b.1.1

                    /* renamed from: a */
                    final /* synthetic */ int f21083a;

                    /* renamed from: b */
                    final /* synthetic */ a.C0457a f21084b;

                    CallableC04501(int i222, a.C0457a c0457a22) {
                        i3 = i222;
                        c0457a = c0457a22;
                    }

                    @Override // java.util.concurrent.Callable
                    /* renamed from: a */
                    public Boolean call() throws Exception {
                        com.opos.cmn.an.f.a.b("InterInterstitialAd", " call load succ");
                        b.this.f21079h = i3;
                        b.this.f21078g = c0457a;
                        return Boolean.TRUE;
                    }
                });
            }

            @Override // com.opos.mobad.model.b.a
            public void a(int i22, String str2, AdData adData) {
                b.this.b(i22, str2);
                if (adData != null) {
                    b.this.f21079h = adData.c();
                }
            }
        });
        return true;
    }

    @Override // com.opos.mobad.ad.b
    public int c() {
        return this.f21079h;
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public void c(int i2) {
        this.f21080i = i2;
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public int f() {
        a.C0457a c0457a;
        return (!e() || (c0457a = this.f21078g) == null) ? super.f() : c0457a.f21744b.X();
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public int g() {
        a.C0457a c0457a;
        return (!e() || (c0457a = this.f21078g) == null) ? super.g() : c0457a.f21744b.Y();
    }
}
