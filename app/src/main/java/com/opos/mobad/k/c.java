package com.opos.mobad.k;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.opos.mobad.k.f;
import com.opos.mobad.l.i;
import com.opos.mobad.model.b;
import com.opos.mobad.model.data.AdData;
import com.opos.mobad.model.e.a;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public class c extends i implements com.opos.mobad.ad.e.b {

    /* renamed from: a */
    private final Context f21161a;

    /* renamed from: b */
    private final b f21162b;

    /* renamed from: c */
    private final String f21163c;

    /* renamed from: d */
    private com.opos.mobad.ad.e.f f21164d;

    /* renamed from: g */
    private int f21165g;

    /* renamed from: h */
    private a.C0457a f21166h;

    /* renamed from: com.opos.mobad.k.c$1 */
    class AnonymousClass1 extends d {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.cmn.a.a.a.b
        public void a(int i2, String str) {
            c.this.c(i2, str);
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(long j2) {
            c.this.i();
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(String str) {
            c.this.d(str);
        }

        @Override // com.opos.mobad.cmn.a.a.a.b
        public void d() {
            c.this.i_();
        }
    }

    /* renamed from: com.opos.mobad.k.c$2 */
    class AnonymousClass2 implements b.a {

        /* renamed from: com.opos.mobad.k.c$2$1 */
        class AnonymousClass1 implements Callable<Boolean> {

            /* renamed from: a */
            final /* synthetic */ int f21169a;

            /* renamed from: b */
            final /* synthetic */ a.C0457a f21170b;

            /* renamed from: com.opos.mobad.k.c$2$1$1 */
            class RunnableC04541 implements Runnable {

                /* renamed from: a */
                final /* synthetic */ f.a f21172a;

                RunnableC04541(f.a aVar) {
                    a2 = aVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    c.this.a(a2);
                }
            }

            AnonymousClass1(int i2, a.C0457a c0457a) {
                i2 = i2;
                c0457a = c0457a;
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() throws Exception {
                c.this.f21165g = i2;
                a.C0457a c0457a = c0457a;
                if (c0457a != null) {
                    c.this.f21166h = c0457a;
                    com.opos.cmn.an.f.a.b("InterSplash$StateAd", "fetchAd success");
                    f.a a2 = f.a(c.this.f21164d, c0457a);
                    if (a2 != null) {
                        c.this.a(new Runnable() { // from class: com.opos.mobad.k.c.2.1.1

                            /* renamed from: a */
                            final /* synthetic */ f.a f21172a;

                            RunnableC04541(f.a a22) {
                                a2 = a22;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                c.this.a(a2);
                            }
                        });
                    } else {
                        com.opos.cmn.an.f.a.c("InterSplash$StateAd", "splashVo data is null!");
                    }
                }
                return Boolean.TRUE;
            }
        }

        AnonymousClass2() {
        }

        @Override // com.opos.mobad.model.b.a
        public void a(int i2, a.C0457a c0457a) {
            if (c0457a == null || c0457a.f21743a.a() != 1) {
                c.this.c(new Callable<Boolean>() { // from class: com.opos.mobad.k.c.2.1

                    /* renamed from: a */
                    final /* synthetic */ int f21169a;

                    /* renamed from: b */
                    final /* synthetic */ a.C0457a f21170b;

                    /* renamed from: com.opos.mobad.k.c$2$1$1 */
                    class RunnableC04541 implements Runnable {

                        /* renamed from: a */
                        final /* synthetic */ f.a f21172a;

                        RunnableC04541(f.a a22) {
                            a2 = a22;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.a(a2);
                        }
                    }

                    AnonymousClass1(int i22, a.C0457a c0457a2) {
                        i2 = i22;
                        c0457a = c0457a2;
                    }

                    @Override // java.util.concurrent.Callable
                    /* renamed from: a */
                    public Boolean call() throws Exception {
                        c.this.f21165g = i2;
                        a.C0457a c0457a2 = c0457a;
                        if (c0457a2 != null) {
                            c.this.f21166h = c0457a2;
                            com.opos.cmn.an.f.a.b("InterSplash$StateAd", "fetchAd success");
                            f.a a22 = f.a(c.this.f21164d, c0457a);
                            if (a22 != null) {
                                c.this.a(new Runnable() { // from class: com.opos.mobad.k.c.2.1.1

                                    /* renamed from: a */
                                    final /* synthetic */ f.a f21172a;

                                    RunnableC04541(f.a a222) {
                                        a2 = a222;
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        c.this.a(a2);
                                    }
                                });
                            } else {
                                com.opos.cmn.an.f.a.c("InterSplash$StateAd", "splashVo data is null!");
                            }
                        }
                        return Boolean.TRUE;
                    }
                });
                return;
            }
            com.opos.mobad.service.a.a().a(c.this.f21163c, 3, c0457a2.f21744b.f(), c0457a2.f21744b.b(), c0457a2.f21745c.aa(), c0457a2.f21744b.a(), c0457a2.f21744b.J());
            c.this.f21165g = c0457a2.f21743a.c();
            c.this.c(-1, com.opos.mobad.ad.a.a(-1));
        }

        @Override // com.opos.mobad.model.b.a
        public void a(int i2, String str, AdData adData) {
            com.opos.cmn.an.f.a.b("InterSplash$StateAd", "fetchAd failed,[code, msg] = " + i2 + "," + str);
            if (adData != null) {
                c.this.f21165g = adData.c();
            }
            c.this.b(i2, str);
        }
    }

    /* renamed from: com.opos.mobad.k.c$3 */
    static final class AnonymousClass3 implements com.opos.mobad.n.c {
        AnonymousClass3() {
        }

        @Override // com.opos.mobad.n.c
        public View a() {
            return com.opos.mobad.ad.e.d.this.a();
        }
    }

    public c(Activity activity, String str, com.opos.mobad.cmn.a.d dVar, com.opos.mobad.ad.e.c cVar, com.opos.mobad.ad.e.f fVar) {
        super(cVar);
        Context a2 = com.opos.mobad.service.b.a(activity.getApplicationContext());
        this.f21161a = a2;
        this.f21163c = str;
        this.f21164d = fVar;
        b bVar = new b(a2, str, new com.opos.mobad.cmn.a.a(a2, str, dVar), new d() { // from class: com.opos.mobad.k.c.1
            AnonymousClass1() {
            }

            @Override // com.opos.mobad.cmn.a.a.a.b
            public void a(int i2, String str2) {
                c.this.c(i2, str2);
            }

            @Override // com.opos.mobad.ad.i.b
            public void a(long j2) {
                c.this.i();
            }

            @Override // com.opos.mobad.ad.i.b
            public void a(String str2) {
                c.this.d(str2);
            }

            @Override // com.opos.mobad.cmn.a.a.a.b
            public void d() {
                c.this.i_();
            }
        });
        this.f21162b = bVar;
        bVar.a(activity);
    }

    public void a(f.a aVar) {
        if (this.f21162b != null) {
            this.f21162b.a(aVar, g.a(this.f21161a, aVar.f21177b, null), e.a(aVar, this.f21161a, aVar.f21176a), b(aVar));
        }
    }

    private static com.opos.mobad.n.c b(f.a aVar) {
        com.opos.mobad.ad.e.d b2 = aVar.b();
        if (b2 != null) {
            return new com.opos.mobad.n.c() { // from class: com.opos.mobad.k.c.3
                AnonymousClass3() {
                }

                @Override // com.opos.mobad.n.c
                public View a() {
                    return com.opos.mobad.ad.e.d.this.a();
                }
            };
        }
        return null;
    }

    @Override // com.opos.mobad.l.j, com.opos.mobad.ad.b
    public void a(String str) {
        super.a(str, 3000);
    }

    @Override // com.opos.mobad.l.j, com.opos.mobad.ad.b
    public void b() {
        com.opos.cmn.an.f.a.b("InterSplash$StateAd", "destroyAd");
        super.b();
        if (com.opos.mobad.cmn.a.b.f.e()) {
            this.f21162b.c();
        }
        this.f21164d = null;
    }

    @Override // com.opos.mobad.l.j
    protected boolean b(String str) {
        return false;
    }

    @Override // com.opos.mobad.l.j
    protected boolean b(String str, int i2) {
        this.f21165g = 0;
        com.opos.mobad.model.b.a(this.f21161a.getApplicationContext()).a(this.f21161a, this.f21163c, 3, str, i2, new AnonymousClass2());
        return true;
    }

    @Override // com.opos.mobad.ad.b
    public int c() {
        return this.f21165g;
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public int f() {
        a.C0457a c0457a;
        return (!e() || (c0457a = this.f21166h) == null) ? super.f() : c0457a.f21744b.X();
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public int g() {
        a.C0457a c0457a;
        return (!e() || (c0457a = this.f21166h) == null) ? super.g() : c0457a.f21744b.Y();
    }

    @Override // com.opos.mobad.ad.e.b
    public View h() {
        b bVar;
        if (!com.opos.mobad.cmn.a.b.f.e() || 5 == d() || (bVar = this.f21162b) == null) {
            return null;
        }
        return bVar.a();
    }
}
