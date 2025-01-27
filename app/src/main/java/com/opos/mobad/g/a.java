package com.opos.mobad.g;

import android.app.Activity;
import android.content.Context;
import com.opos.mobad.cmn.a.a.a;
import com.opos.mobad.cmn.a.b.f;
import com.opos.mobad.g.b;
import com.opos.mobad.l.d;
import com.opos.mobad.model.b;
import com.opos.mobad.model.data.AdData;
import com.opos.mobad.model.e.a;
import com.opos.mobad.q.a.h;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public class a extends d {

    /* renamed from: a */
    private Context f20835a;

    /* renamed from: b */
    private String f20836b;

    /* renamed from: c */
    private a.C0457a f20837c;

    /* renamed from: d */
    private int f20838d;

    /* renamed from: g */
    private int f20839g;

    /* renamed from: h */
    private b f20840h;

    /* renamed from: com.opos.mobad.g.a$1 */
    class AnonymousClass1 implements b.a {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.g.b.a
        public void a() {
            a.this.p();
        }

        @Override // com.opos.mobad.g.b.a
        public void b() {
            a.this.q();
        }

        @Override // com.opos.mobad.g.b.a
        public void c() {
            a.this.h();
        }
    }

    /* renamed from: com.opos.mobad.g.a$2 */
    class AnonymousClass2 implements a.b {
        AnonymousClass2() {
        }

        @Override // com.opos.mobad.cmn.a.a.a.b
        public void a(int i2, String str) {
            a.this.c(i2, str);
        }

        @Override // com.opos.mobad.cmn.a.a.a.b
        public void d() {
            a.this.i_();
        }
    }

    /* renamed from: com.opos.mobad.g.a$3 */
    class AnonymousClass3 implements b.a {

        /* renamed from: com.opos.mobad.g.a$3$1 */
        class AnonymousClass1 implements Callable<Boolean> {

            /* renamed from: a */
            final /* synthetic */ a.C0457a f20844a;

            /* renamed from: b */
            final /* synthetic */ int f20845b;

            AnonymousClass1(a.C0457a c0457a, int i2) {
                c0457a = c0457a;
                i3 = i2;
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() throws Exception {
                com.opos.cmn.an.f.a.b("InterInterstitialVideoAd", " call load succ");
                a.this.f20837c = c0457a;
                a.this.f20838d = i3;
                return Boolean.TRUE;
            }
        }

        AnonymousClass3() {
        }

        @Override // com.opos.mobad.model.b.a
        public void a(int i2, a.C0457a c0457a) {
            if (c0457a.f21745c.d() == 12 || c0457a.f21745c.d() == 14) {
                a.this.c(new Callable<Boolean>() { // from class: com.opos.mobad.g.a.3.1

                    /* renamed from: a */
                    final /* synthetic */ a.C0457a f20844a;

                    /* renamed from: b */
                    final /* synthetic */ int f20845b;

                    AnonymousClass1(a.C0457a c0457a2, int i22) {
                        c0457a = c0457a2;
                        i3 = i22;
                    }

                    @Override // java.util.concurrent.Callable
                    /* renamed from: a */
                    public Boolean call() throws Exception {
                        com.opos.cmn.an.f.a.b("InterInterstitialVideoAd", " call load succ");
                        a.this.f20837c = c0457a;
                        a.this.f20838d = i3;
                        return Boolean.TRUE;
                    }
                });
            } else {
                a.this.b(10009, "posId or posType error");
            }
        }

        @Override // com.opos.mobad.model.b.a
        public void a(int i2, String str, AdData adData) {
            if (adData != null) {
                a.this.f20838d = adData.c();
            }
            a.this.b(i2, str);
        }
    }

    public a(Activity activity, String str, com.opos.mobad.cmn.a.d dVar, h hVar, com.opos.mobad.ad.b.d dVar2) {
        super(dVar2);
        this.f20838d = 0;
        this.f20839g = 0;
        this.f20835a = activity.getApplicationContext();
        this.f20836b = str;
        this.f20840h = new b(this.f20835a, this.f20836b, dVar, hVar, new b.a() { // from class: com.opos.mobad.g.a.1
            AnonymousClass1() {
            }

            @Override // com.opos.mobad.g.b.a
            public void a() {
                a.this.p();
            }

            @Override // com.opos.mobad.g.b.a
            public void b() {
                a.this.q();
            }

            @Override // com.opos.mobad.g.b.a
            public void c() {
                a.this.h();
            }
        });
    }

    @Override // com.opos.mobad.l.d, com.opos.mobad.l.j, com.opos.mobad.ad.b
    public void b() {
        com.opos.cmn.an.f.a.b("InterInterstitialVideoAd", "destroyAd");
        if (f.e()) {
            b bVar = this.f20840h;
            if (bVar != null) {
                bVar.a();
            }
            super.b();
        }
    }

    @Override // com.opos.mobad.l.k
    protected boolean b(Activity activity) {
        a.C0457a c0457a = this.f20837c;
        if (c0457a == null) {
            com.opos.cmn.an.f.a.b("InterInterstitialVideoAd", "show but data null");
        } else {
            if (c0457a == null || c0457a.f21743a.a() != 1) {
                return this.f20840h.a(this.f20837c, this.f20839g, new a.b() { // from class: com.opos.mobad.g.a.2
                    AnonymousClass2() {
                    }

                    @Override // com.opos.mobad.cmn.a.a.a.b
                    public void a(int i2, String str) {
                        a.this.c(i2, str);
                    }

                    @Override // com.opos.mobad.cmn.a.a.a.b
                    public void d() {
                        a.this.i_();
                    }
                });
            }
            com.opos.mobad.service.a.a().a(this.f20836b, 2, this.f20837c.f21744b.f(), this.f20837c.f21744b.b(), this.f20837c.f21745c.aa(), this.f20837c.f21744b.a(), this.f20837c.f21744b.J());
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
        this.f20838d = 0;
        this.f20839g = 0;
        com.opos.mobad.model.b.a(this.f20835a.getApplicationContext()).a(this.f20835a, this.f20836b, 2, str, i2, new b.a() { // from class: com.opos.mobad.g.a.3

            /* renamed from: com.opos.mobad.g.a$3$1 */
            class AnonymousClass1 implements Callable<Boolean> {

                /* renamed from: a */
                final /* synthetic */ a.C0457a f20844a;

                /* renamed from: b */
                final /* synthetic */ int f20845b;

                AnonymousClass1(a.C0457a c0457a2, int i22) {
                    c0457a = c0457a2;
                    i3 = i22;
                }

                @Override // java.util.concurrent.Callable
                /* renamed from: a */
                public Boolean call() throws Exception {
                    com.opos.cmn.an.f.a.b("InterInterstitialVideoAd", " call load succ");
                    a.this.f20837c = c0457a;
                    a.this.f20838d = i3;
                    return Boolean.TRUE;
                }
            }

            AnonymousClass3() {
            }

            @Override // com.opos.mobad.model.b.a
            public void a(int i22, a.C0457a c0457a2) {
                if (c0457a2.f21745c.d() == 12 || c0457a2.f21745c.d() == 14) {
                    a.this.c(new Callable<Boolean>() { // from class: com.opos.mobad.g.a.3.1

                        /* renamed from: a */
                        final /* synthetic */ a.C0457a f20844a;

                        /* renamed from: b */
                        final /* synthetic */ int f20845b;

                        AnonymousClass1(a.C0457a c0457a22, int i222) {
                            c0457a = c0457a22;
                            i3 = i222;
                        }

                        @Override // java.util.concurrent.Callable
                        /* renamed from: a */
                        public Boolean call() throws Exception {
                            com.opos.cmn.an.f.a.b("InterInterstitialVideoAd", " call load succ");
                            a.this.f20837c = c0457a;
                            a.this.f20838d = i3;
                            return Boolean.TRUE;
                        }
                    });
                } else {
                    a.this.b(10009, "posId or posType error");
                }
            }

            @Override // com.opos.mobad.model.b.a
            public void a(int i22, String str2, AdData adData) {
                if (adData != null) {
                    a.this.f20838d = adData.c();
                }
                a.this.b(i22, str2);
            }
        });
        return true;
    }

    @Override // com.opos.mobad.ad.b
    public int c() {
        return this.f20838d;
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public void c(int i2) {
        this.f20839g = i2;
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public int f() {
        a.C0457a c0457a;
        return (!e() || (c0457a = this.f20837c) == null) ? super.f() : c0457a.f21744b.X();
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public int g() {
        a.C0457a c0457a;
        return (!e() || (c0457a = this.f20837c) == null) ? super.g() : c0457a.f21744b.Y();
    }
}
