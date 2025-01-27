package com.opos.mobad.f.a;

import android.app.Activity;
import com.opos.mobad.ad.b;
import com.opos.mobad.service.a.e;
import java.util.List;

/* loaded from: classes4.dex */
public class e extends com.opos.mobad.l.d {

    /* renamed from: a */
    private String f20695a;

    /* renamed from: b */
    private com.opos.mobad.f.a.a.n<com.opos.mobad.ad.b.c> f20696b;

    /* renamed from: c */
    private boolean f20697c;

    /* renamed from: d */
    private String f20698d;

    /* renamed from: com.opos.mobad.f.a.e$1 */
    class AnonymousClass1 implements com.opos.mobad.f.a.b.b<com.opos.mobad.ad.b.c> {

        /* renamed from: a */
        final /* synthetic */ com.opos.mobad.f.b f20699a;

        /* renamed from: b */
        final /* synthetic */ Activity f20700b;

        /* renamed from: c */
        final /* synthetic */ String f20701c;

        /* renamed from: d */
        final /* synthetic */ boolean f20702d;

        AnonymousClass1(com.opos.mobad.f.b bVar, Activity activity, String str, boolean z) {
            bVar = bVar;
            activity = activity;
            str = str;
            z = z;
        }

        @Override // com.opos.mobad.f.a.b.a
        /* renamed from: a */
        public com.opos.mobad.ad.b.c b(e.a aVar, com.opos.mobad.f.a.a.n nVar) {
            com.opos.mobad.ad.c b2 = bVar.b(aVar.f23520a);
            if (b2 == null) {
                return null;
            }
            return b2.a(activity, str, aVar.f23521b, z, e.this.new a(aVar.f23520a, nVar));
        }
    }

    /* renamed from: com.opos.mobad.f.a.e$2 */
    class AnonymousClass2 implements b.a {
        AnonymousClass2() {
        }

        @Override // com.opos.mobad.ad.b.a
        public void a() {
            e.this.o();
        }

        @Override // com.opos.mobad.ad.b.a
        public void a(int i2, String str) {
            com.opos.cmn.an.f.a.b("delegator InterstitialVideo", "onAdFailed code=" + i2 + ",msg =" + str);
            e.this.b(com.opos.mobad.f.a.a.l.a(i2), str);
        }

        @Override // com.opos.mobad.ad.b.a
        public void b() {
            e.this.i_();
        }
    }

    private class a extends com.opos.mobad.f.a.a.b implements com.opos.mobad.ad.b.d {

        /* renamed from: b */
        private final int f20706b;

        public a(int i2, com.opos.mobad.f.a.a.n nVar) {
            super(i2, nVar);
            this.f20706b = i2;
        }

        @Override // com.opos.mobad.f.a.a.b, com.opos.mobad.ad.b.a
        public void a(int i2, String str) {
            if (1 == e.this.d()) {
                super.a(i2, str);
            } else {
                if (this.f20706b != e.this.f20696b.j()) {
                    return;
                }
                e.this.c(i2, str);
            }
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(long j2) {
            if (this.f20706b != e.this.f20696b.j()) {
                return;
            }
            com.opos.mobad.service.j.n.a().b(e.this.f20695a);
            e.this.p();
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(String str) {
            if (this.f20706b != e.this.f20696b.j()) {
                return;
            }
            com.opos.mobad.service.j.n.a().a(e.this.f20695a);
            e.this.q();
        }

        @Override // com.opos.mobad.f.a.a.b, com.opos.mobad.ad.b.a
        public void b() {
            if (this.f20706b != e.this.f20696b.j()) {
                return;
            }
            e.this.i_();
        }

        @Override // com.opos.mobad.ad.b.d
        public void c() {
            if (this.f20706b != e.this.f20696b.j()) {
                return;
            }
            e.this.h();
        }
    }

    public e(Activity activity, String str, com.opos.mobad.f.a.d.a aVar, com.opos.mobad.ad.b.d dVar, boolean z, List<e.a> list, e.a aVar2, long j2, com.opos.mobad.f.b bVar) {
        super(dVar);
        this.f20695a = str;
        this.f20696b = a(str, aVar, list, aVar2, j2, new com.opos.mobad.f.a.b.b<com.opos.mobad.ad.b.c>() { // from class: com.opos.mobad.f.a.e.1

            /* renamed from: a */
            final /* synthetic */ com.opos.mobad.f.b f20699a;

            /* renamed from: b */
            final /* synthetic */ Activity f20700b;

            /* renamed from: c */
            final /* synthetic */ String f20701c;

            /* renamed from: d */
            final /* synthetic */ boolean f20702d;

            AnonymousClass1(com.opos.mobad.f.b bVar2, Activity activity2, String str2, boolean z2) {
                bVar = bVar2;
                activity = activity2;
                str = str2;
                z = z2;
            }

            @Override // com.opos.mobad.f.a.b.a
            /* renamed from: a */
            public com.opos.mobad.ad.b.c b(e.a aVar3, com.opos.mobad.f.a.a.n nVar) {
                com.opos.mobad.ad.c b2 = bVar.b(aVar3.f23520a);
                if (b2 == null) {
                    return null;
                }
                return b2.a(activity, str, aVar3.f23521b, z, e.this.new a(aVar3.f23520a, nVar));
            }
        }, new com.opos.mobad.f.a.c.a(activity2));
    }

    private com.opos.mobad.f.a.a.n<com.opos.mobad.ad.b.c> a(String str, com.opos.mobad.f.a.d.a aVar, List<e.a> list, e.a aVar2, long j2, com.opos.mobad.f.a.b.b<com.opos.mobad.ad.b.c> bVar, com.opos.mobad.f.a.c.a aVar3) {
        return com.opos.mobad.f.a.a.k.a(str, aVar, list, aVar2, j2, bVar, aVar3, new b.a() { // from class: com.opos.mobad.f.a.e.2
            AnonymousClass2() {
            }

            @Override // com.opos.mobad.ad.b.a
            public void a() {
                e.this.o();
            }

            @Override // com.opos.mobad.ad.b.a
            public void a(int i2, String str2) {
                com.opos.cmn.an.f.a.b("delegator InterstitialVideo", "onAdFailed code=" + i2 + ",msg =" + str2);
                e.this.b(com.opos.mobad.f.a.a.l.a(i2), str2);
            }

            @Override // com.opos.mobad.ad.b.a
            public void b() {
                e.this.i_();
            }
        });
    }

    @Override // com.opos.mobad.l.j, com.opos.mobad.ad.b
    public void a() {
        a(com.opos.mobad.service.f.b().p());
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public void a(int i2, String str, int i3) {
        if (com.opos.mobad.service.f.b().b(this.f20695a) && d() == 2 && !this.f20697c) {
            this.f20697c = true;
            com.opos.mobad.service.i.d.a().a(this.f20695a, this.f20698d, i2, str, this.f20696b.j(), g(), i3);
        }
    }

    @Override // com.opos.mobad.l.d, com.opos.mobad.l.j, com.opos.mobad.ad.b
    public void b() {
        super.b();
        this.f20696b.b();
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public void b(int i2) {
        if (com.opos.mobad.service.f.b().b(this.f20695a) && d() == 2 && !this.f20697c) {
            this.f20697c = true;
            com.opos.mobad.service.i.d.a().a(this.f20695a, this.f20698d, this.f20696b.j(), g(), i2);
        }
    }

    @Override // com.opos.mobad.l.k
    protected boolean b(Activity activity) {
        com.opos.mobad.ad.b.c i2 = this.f20696b.i();
        if (i2 == null) {
            c(-1, "ad is null");
            return false;
        }
        i2.a(activity);
        return i2.d() == 3;
    }

    @Override // com.opos.mobad.l.j
    protected boolean b(String str) {
        return false;
    }

    @Override // com.opos.mobad.l.j
    protected boolean b(String str, int i2) {
        this.f20697c = false;
        this.f20698d = str;
        this.f20696b.a(str, i2);
        return true;
    }

    @Override // com.opos.mobad.ad.b
    public int c() {
        return 0;
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public void c(int i2) {
        com.opos.mobad.ad.b.c i3;
        if (com.opos.mobad.service.f.b().b(this.f20695a) && (i3 = this.f20696b.i()) != null) {
            i3.c(i2);
        }
    }

    @Override // com.opos.mobad.l.j, com.opos.mobad.ad.b
    public boolean e() {
        com.opos.mobad.ad.b.c i2 = this.f20696b.i();
        if (i2 != null) {
            return i2.e();
        }
        return false;
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public int g() {
        com.opos.mobad.ad.b.c i2;
        int i3;
        if (com.opos.mobad.service.f.b().b(this.f20695a) && (i2 = this.f20696b.i()) != null) {
            int g2 = i2.g();
            if (g2 > 0) {
                return g2;
            }
            e.a k = this.f20696b.k();
            if (k != null && (i3 = k.f23526g) > 0) {
                return i3;
            }
        }
        return 0;
    }
}
