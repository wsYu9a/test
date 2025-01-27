package com.opos.mobad.f.a;

import android.app.Activity;
import com.opos.mobad.ad.b;
import com.opos.mobad.service.a.e;
import java.util.List;

/* loaded from: classes4.dex */
public class d extends com.opos.mobad.l.c {

    /* renamed from: a */
    private String f20682a;

    /* renamed from: b */
    private com.opos.mobad.f.a.a.n<com.opos.mobad.ad.b.a> f20683b;

    /* renamed from: c */
    private boolean f20684c;

    /* renamed from: d */
    private String f20685d;

    /* renamed from: com.opos.mobad.f.a.d$1 */
    class AnonymousClass1 implements com.opos.mobad.f.a.b.b<com.opos.mobad.ad.b.a> {

        /* renamed from: a */
        final /* synthetic */ com.opos.mobad.f.b f20686a;

        /* renamed from: b */
        final /* synthetic */ Activity f20687b;

        /* renamed from: c */
        final /* synthetic */ String f20688c;

        AnonymousClass1(com.opos.mobad.f.b bVar, Activity activity, String str) {
            bVar2 = bVar;
            activity = activity;
            str = str;
        }

        @Override // com.opos.mobad.f.a.b.a
        /* renamed from: a */
        public com.opos.mobad.ad.b.a b(e.a aVar, com.opos.mobad.f.a.a.n nVar) {
            com.opos.mobad.ad.c b2 = bVar2.b(aVar.f23520a);
            if (b2 == null) {
                return null;
            }
            return b2.a(activity, str, aVar.f23521b, d.this.new a(aVar.f23520a, nVar));
        }
    }

    /* renamed from: com.opos.mobad.f.a.d$2 */
    class AnonymousClass2 implements b.a {
        AnonymousClass2() {
        }

        @Override // com.opos.mobad.ad.b.a
        public void a() {
            d.this.o();
        }

        @Override // com.opos.mobad.ad.b.a
        public void a(int i2, String str) {
            com.opos.cmn.an.f.a.b("delegator Interstitial", "onAdFailed code=" + i2 + ",msg =" + str);
            d.this.b(com.opos.mobad.f.a.a.l.a(i2), str);
        }

        @Override // com.opos.mobad.ad.b.a
        public void b() {
            d.this.i_();
        }
    }

    private class a extends com.opos.mobad.f.a.a.b implements com.opos.mobad.ad.b.b {

        /* renamed from: c */
        private final int f20693c;

        public a(int i2, com.opos.mobad.f.a.a.n nVar) {
            super(i2, nVar);
            this.f20693c = i2;
        }

        @Override // com.opos.mobad.f.a.a.b, com.opos.mobad.ad.b.a
        public void a(int i2, String str) {
            if (1 == d.this.d()) {
                super.a(i2, str);
            } else {
                if (this.f20693c != d.this.f20683b.j()) {
                    return;
                }
                d.this.c(i2, str);
            }
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(long j2) {
            if (this.f20693c != d.this.f20683b.j()) {
                return;
            }
            com.opos.mobad.service.j.n.a().b(d.this.f20682a);
            d.this.p();
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(String str) {
            if (this.f20693c != d.this.f20683b.j()) {
                return;
            }
            com.opos.mobad.service.j.n.a().a(d.this.f20682a);
            d.this.q();
        }

        @Override // com.opos.mobad.f.a.a.b, com.opos.mobad.ad.b.a
        public void b() {
            if (this.f20693c != d.this.f20683b.j()) {
                return;
            }
            d.this.i_();
        }
    }

    public d(Activity activity, String str, com.opos.mobad.f.a.d.a aVar, com.opos.mobad.ad.b.b bVar, List<e.a> list, e.a aVar2, long j2, com.opos.mobad.f.b bVar2) {
        super(bVar);
        this.f20682a = str;
        this.f20683b = a(str, aVar, list, aVar2, j2, new com.opos.mobad.f.a.b.b<com.opos.mobad.ad.b.a>() { // from class: com.opos.mobad.f.a.d.1

            /* renamed from: a */
            final /* synthetic */ com.opos.mobad.f.b f20686a;

            /* renamed from: b */
            final /* synthetic */ Activity f20687b;

            /* renamed from: c */
            final /* synthetic */ String f20688c;

            AnonymousClass1(com.opos.mobad.f.b bVar22, Activity activity2, String str2) {
                bVar2 = bVar22;
                activity = activity2;
                str = str2;
            }

            @Override // com.opos.mobad.f.a.b.a
            /* renamed from: a */
            public com.opos.mobad.ad.b.a b(e.a aVar3, com.opos.mobad.f.a.a.n nVar) {
                com.opos.mobad.ad.c b2 = bVar2.b(aVar3.f23520a);
                if (b2 == null) {
                    return null;
                }
                return b2.a(activity, str, aVar3.f23521b, d.this.new a(aVar3.f23520a, nVar));
            }
        }, new com.opos.mobad.f.a.c.a(activity2));
    }

    private com.opos.mobad.f.a.a.n<com.opos.mobad.ad.b.a> a(String str, com.opos.mobad.f.a.d.a aVar, List<e.a> list, e.a aVar2, long j2, com.opos.mobad.f.a.b.b<com.opos.mobad.ad.b.a> bVar, com.opos.mobad.f.a.c.a aVar3) {
        return com.opos.mobad.f.a.a.k.a(str, aVar, list, aVar2, j2, bVar, aVar3, new b.a() { // from class: com.opos.mobad.f.a.d.2
            AnonymousClass2() {
            }

            @Override // com.opos.mobad.ad.b.a
            public void a() {
                d.this.o();
            }

            @Override // com.opos.mobad.ad.b.a
            public void a(int i2, String str2) {
                com.opos.cmn.an.f.a.b("delegator Interstitial", "onAdFailed code=" + i2 + ",msg =" + str2);
                d.this.b(com.opos.mobad.f.a.a.l.a(i2), str2);
            }

            @Override // com.opos.mobad.ad.b.a
            public void b() {
                d.this.i_();
            }
        });
    }

    @Override // com.opos.mobad.l.j, com.opos.mobad.ad.b
    public void a() {
        a(com.opos.mobad.service.f.b().n());
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public void a(int i2, String str, int i3) {
        if (com.opos.mobad.service.f.b().b(this.f20682a) && d() == 2 && !this.f20684c) {
            this.f20684c = true;
            com.opos.mobad.service.i.d.a().a(this.f20682a, this.f20685d, i2, str, this.f20683b.j(), g(), i3);
        }
    }

    @Override // com.opos.mobad.l.j, com.opos.mobad.ad.b
    public void b() {
        super.b();
        this.f20683b.b();
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public void b(int i2) {
        if (com.opos.mobad.service.f.b().b(this.f20682a) && d() == 2 && !this.f20684c) {
            this.f20684c = true;
            com.opos.mobad.service.i.d.a().a(this.f20682a, this.f20685d, this.f20683b.j(), g(), i2);
        }
    }

    @Override // com.opos.mobad.l.k
    protected boolean b(Activity activity) {
        com.opos.mobad.ad.b.a i2 = this.f20683b.i();
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
        this.f20685d = str;
        this.f20684c = false;
        this.f20683b.a(str, i2);
        return true;
    }

    @Override // com.opos.mobad.ad.b
    public int c() {
        return 0;
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public void c(int i2) {
        com.opos.mobad.ad.b.a i3;
        if (com.opos.mobad.service.f.b().b(this.f20682a) && (i3 = this.f20683b.i()) != null) {
            i3.c(i2);
        }
    }

    @Override // com.opos.mobad.l.j, com.opos.mobad.ad.b
    public boolean e() {
        com.opos.mobad.ad.b.a i2 = this.f20683b.i();
        if (i2 != null) {
            return i2.e();
        }
        return false;
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public int g() {
        com.opos.mobad.ad.b.a i2;
        int i3;
        if (com.opos.mobad.service.f.b().b(this.f20682a) && (i2 = this.f20683b.i()) != null) {
            int g2 = i2.g();
            if (g2 > 0) {
                return g2;
            }
            e.a k = this.f20683b.k();
            if (k != null && (i3 = k.f23526g) > 0) {
                return i3;
            }
        }
        return 0;
    }
}
