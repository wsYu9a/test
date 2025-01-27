package com.opos.mobad.j;

import android.content.Context;
import com.opos.mobad.cmn.a.a.a;
import com.opos.mobad.cmn.a.b.f;
import com.opos.mobad.cmn.a.d;
import com.opos.mobad.l.h;
import com.opos.mobad.model.b;
import com.opos.mobad.model.data.AdData;
import com.opos.mobad.model.e.a;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public class a extends h {

    /* renamed from: a */
    private static final String f21108a = "a";

    /* renamed from: b */
    private Context f21109b;

    /* renamed from: c */
    private String f21110c;

    /* renamed from: d */
    private a.C0457a f21111d;

    /* renamed from: g */
    private int f21112g;

    /* renamed from: h */
    private com.opos.mobad.ad.d.b f21113h;

    /* renamed from: i */
    private a.InterfaceC0430a f21114i;

    /* renamed from: j */
    private int f21115j;

    /* renamed from: com.opos.mobad.j.a$1 */
    class AnonymousClass1 implements b.a {

        /* renamed from: com.opos.mobad.j.a$1$1 */
        class CallableC04511 implements Callable<Boolean> {

            /* renamed from: a */
            final /* synthetic */ a.C0457a f21117a;

            /* renamed from: b */
            final /* synthetic */ int f21118b;

            CallableC04511(a.C0457a c0457a, int i2) {
                c0457a = c0457a;
                i3 = i2;
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() throws Exception {
                com.opos.cmn.an.f.a.b(a.f21108a, " call load succ");
                a.this.f21111d = c0457a;
                a.this.f21112g = i3;
                return Boolean.TRUE;
            }
        }

        AnonymousClass1() {
        }

        @Override // com.opos.mobad.model.b.a
        public void a(int i2, a.C0457a c0457a) {
            a.this.c(new Callable<Boolean>() { // from class: com.opos.mobad.j.a.1.1

                /* renamed from: a */
                final /* synthetic */ a.C0457a f21117a;

                /* renamed from: b */
                final /* synthetic */ int f21118b;

                CallableC04511(a.C0457a c0457a2, int i22) {
                    c0457a = c0457a2;
                    i3 = i22;
                }

                @Override // java.util.concurrent.Callable
                /* renamed from: a */
                public Boolean call() throws Exception {
                    com.opos.cmn.an.f.a.b(a.f21108a, " call load succ");
                    a.this.f21111d = c0457a;
                    a.this.f21112g = i3;
                    return Boolean.TRUE;
                }
            });
        }

        @Override // com.opos.mobad.model.b.a
        public void a(int i2, String str, AdData adData) {
            if (adData != null) {
                a.this.f21112g = adData.c();
            }
            a.this.b(i2, str);
        }
    }

    /* renamed from: com.opos.mobad.j.a$2 */
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

    public a(Context context, String str, d dVar, com.opos.mobad.q.a.h hVar, com.opos.mobad.ad.d.b bVar) {
        super(bVar);
        this.f21109b = context.getApplicationContext();
        this.f21110c = str;
        this.f21113h = bVar == null ? com.opos.mobad.ad.d.b.f19486a : bVar;
        this.f21114i = new b(context, str, this.f21113h, dVar, hVar);
    }

    @Override // com.opos.mobad.l.j, com.opos.mobad.ad.b
    public void b() {
        com.opos.cmn.an.f.a.b(f21108a, "destroyAd");
        if (f.e()) {
            this.f21114i.a();
            super.b();
        }
    }

    @Override // com.opos.mobad.l.j
    protected boolean b(String str) {
        return false;
    }

    @Override // com.opos.mobad.l.j
    protected boolean b(String str, int i2) {
        this.f21112g = 0;
        this.f21115j = 0;
        com.opos.mobad.model.b.a(this.f21109b.getApplicationContext()).a(this.f21109b, this.f21110c, 5, str, i2, new b.a() { // from class: com.opos.mobad.j.a.1

            /* renamed from: com.opos.mobad.j.a$1$1 */
            class CallableC04511 implements Callable<Boolean> {

                /* renamed from: a */
                final /* synthetic */ a.C0457a f21117a;

                /* renamed from: b */
                final /* synthetic */ int f21118b;

                CallableC04511(a.C0457a c0457a2, int i22) {
                    c0457a = c0457a2;
                    i3 = i22;
                }

                @Override // java.util.concurrent.Callable
                /* renamed from: a */
                public Boolean call() throws Exception {
                    com.opos.cmn.an.f.a.b(a.f21108a, " call load succ");
                    a.this.f21111d = c0457a;
                    a.this.f21112g = i3;
                    return Boolean.TRUE;
                }
            }

            AnonymousClass1() {
            }

            @Override // com.opos.mobad.model.b.a
            public void a(int i22, a.C0457a c0457a2) {
                a.this.c(new Callable<Boolean>() { // from class: com.opos.mobad.j.a.1.1

                    /* renamed from: a */
                    final /* synthetic */ a.C0457a f21117a;

                    /* renamed from: b */
                    final /* synthetic */ int f21118b;

                    CallableC04511(a.C0457a c0457a22, int i222) {
                        c0457a = c0457a22;
                        i3 = i222;
                    }

                    @Override // java.util.concurrent.Callable
                    /* renamed from: a */
                    public Boolean call() throws Exception {
                        com.opos.cmn.an.f.a.b(a.f21108a, " call load succ");
                        a.this.f21111d = c0457a;
                        a.this.f21112g = i3;
                        return Boolean.TRUE;
                    }
                });
            }

            @Override // com.opos.mobad.model.b.a
            public void a(int i22, String str2, AdData adData) {
                if (adData != null) {
                    a.this.f21112g = adData.c();
                }
                a.this.b(i22, str2);
            }
        });
        return true;
    }

    @Override // com.opos.mobad.l.h
    protected boolean b(boolean z) {
        return this.f21114i.a(this.f21111d, this.f21115j, new a.b() { // from class: com.opos.mobad.j.a.2
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

    @Override // com.opos.mobad.ad.b
    public int c() {
        return this.f21112g;
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public void c(int i2) {
        this.f21115j = i2;
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public int f() {
        a.C0457a c0457a;
        return (!e() || (c0457a = this.f21111d) == null) ? super.f() : c0457a.f21744b.X();
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public int g() {
        a.C0457a c0457a;
        return (!e() || (c0457a = this.f21111d) == null) ? super.g() : c0457a.f21744b.Y();
    }
}
