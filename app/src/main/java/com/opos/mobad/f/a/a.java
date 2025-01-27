package com.opos.mobad.f.a;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.opos.mobad.ad.b;
import com.opos.mobad.f.a.i;
import com.opos.mobad.service.a.e;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public class a extends com.opos.mobad.l.a {

    /* renamed from: g */
    private static Map<String, Boolean> f20540g = new ConcurrentHashMap();

    /* renamed from: a */
    private String f20541a;

    /* renamed from: b */
    private com.opos.mobad.f.a.a.m<com.opos.mobad.ad.a.a> f20542b;

    /* renamed from: c */
    private b f20543c;

    /* renamed from: d */
    private n f20544d;

    /* renamed from: h */
    private Context f20545h;

    /* renamed from: i */
    private String f20546i;

    /* renamed from: j */
    private int f20547j;
    private boolean k;

    /* renamed from: com.opos.mobad.f.a.a$1 */
    class AnonymousClass1 implements i.a {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.f.a.i.a
        public void a(int i2, int i3) {
            a.this.b(i2, i3);
        }
    }

    /* renamed from: com.opos.mobad.f.a.a$2 */
    class AnonymousClass2 implements com.opos.mobad.f.a.b.b<com.opos.mobad.ad.a.a> {

        /* renamed from: a */
        final /* synthetic */ com.opos.mobad.f.b f20549a;

        /* renamed from: b */
        final /* synthetic */ Activity f20550b;

        /* renamed from: c */
        final /* synthetic */ String f20551c;

        /* renamed from: d */
        final /* synthetic */ boolean f20552d;

        AnonymousClass2(com.opos.mobad.f.b bVar, Activity activity, String str, boolean z) {
            bVar2 = bVar;
            activity = activity;
            str = str;
            z = z;
        }

        @Override // com.opos.mobad.f.a.b.a
        /* renamed from: a */
        public com.opos.mobad.ad.a.a b(e.a aVar, com.opos.mobad.f.a.a.n nVar) {
            com.opos.mobad.ad.c b2 = bVar2.b(aVar.f23520a);
            if (b2 != null) {
                return b2.a(activity, str, aVar.f23521b, z, a.this.new C0442a(aVar.f23520a, nVar));
            }
            a.this.c("new banner ad but creator = null,channel is =" + aVar.f23520a);
            return null;
        }
    }

    /* renamed from: com.opos.mobad.f.a.a$3 */
    class AnonymousClass3 implements b.a {
        AnonymousClass3() {
        }

        @Override // com.opos.mobad.ad.b.a
        public void a() {
            a.this.c("onAdReady");
            a.this.o();
            a.this.k();
        }

        @Override // com.opos.mobad.ad.b.a
        public void a(int i2, String str) {
            a.this.c("onAdFailed code=" + i2 + ",msg =" + str);
            a.this.b(com.opos.mobad.f.a.a.l.a(i2), str);
        }

        @Override // com.opos.mobad.ad.b.a
        public void b() {
            a.this.c("onAdClose");
            a.this.i_();
        }
    }

    /* renamed from: com.opos.mobad.f.a.a$4 */
    class AnonymousClass4 implements Runnable {
        AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f20543c == null || !a.this.f20543c.c()) {
                a.this.c("banner is invisibile");
            } else {
                if (a.this.r() || com.opos.cmn.i.j.a(a.this.f20545h, a.this.h())) {
                    a.this.p();
                    a.this.c(11004, "you should't play ad on the top in the shaped screen mobile");
                    return;
                }
                a.this.a();
            }
            if (a.this.f20544d != null) {
                a.this.f20544d.a(com.opos.mobad.service.f.a().a(a.this.f20541a));
            }
        }
    }

    /* renamed from: com.opos.mobad.f.a.a$a */
    private class C0442a extends com.opos.mobad.f.a.a.b implements com.opos.mobad.ad.a.b {

        /* renamed from: c */
        private final int f20562c;

        public C0442a(int i2, com.opos.mobad.f.a.a.n nVar) {
            super(i2, nVar);
            this.f20562c = i2;
        }

        @Override // com.opos.mobad.f.a.a.b, com.opos.mobad.ad.b.a
        public void a(int i2, String str) {
            if (1 == a.this.d()) {
                super.a(i2, str);
            } else {
                if (this.f20562c != a.this.f20542b.j()) {
                    return;
                }
                a.this.c(i2, str);
            }
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(long j2) {
            if (this.f20562c != a.this.f20542b.j()) {
                return;
            }
            com.opos.mobad.service.j.n.a().b(a.this.f20541a);
            a.this.i();
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(String str) {
            if (this.f20562c != a.this.f20542b.j()) {
                return;
            }
            com.opos.mobad.service.j.n.a().a(a.this.f20541a);
            a.this.g_();
        }

        @Override // com.opos.mobad.f.a.a.b, com.opos.mobad.ad.b.a
        public void b() {
            if (this.f20562c == a.this.f20547j) {
                a.this.f20547j = -1;
                a.this.i_();
                a.this.q();
                return;
            }
            a.this.c("channel is diff =" + this.f20562c + ", " + a.this.f20542b.j());
        }
    }

    public a(Activity activity, String str, com.opos.mobad.f.a.d.a aVar, boolean z, com.opos.mobad.ad.a.b bVar, List<e.a> list, e.a aVar2, long j2, com.opos.mobad.f.b bVar2) {
        super(bVar);
        this.f20547j = -1;
        this.k = false;
        this.f20541a = str;
        this.f20545h = activity.getApplicationContext();
        this.f20543c = new b(this.f20545h, new i.a() { // from class: com.opos.mobad.f.a.a.1
            AnonymousClass1() {
            }

            @Override // com.opos.mobad.f.a.i.a
            public void a(int i2, int i3) {
                a.this.b(i2, i3);
            }
        });
        this.f20542b = a(str, aVar, list, aVar2, j2, new com.opos.mobad.f.a.b.b<com.opos.mobad.ad.a.a>() { // from class: com.opos.mobad.f.a.a.2

            /* renamed from: a */
            final /* synthetic */ com.opos.mobad.f.b f20549a;

            /* renamed from: b */
            final /* synthetic */ Activity f20550b;

            /* renamed from: c */
            final /* synthetic */ String f20551c;

            /* renamed from: d */
            final /* synthetic */ boolean f20552d;

            AnonymousClass2(com.opos.mobad.f.b bVar22, Activity activity2, String str2, boolean z2) {
                bVar2 = bVar22;
                activity = activity2;
                str = str2;
                z = z2;
            }

            @Override // com.opos.mobad.f.a.b.a
            /* renamed from: a */
            public com.opos.mobad.ad.a.a b(e.a aVar3, com.opos.mobad.f.a.a.n nVar) {
                com.opos.mobad.ad.c b2 = bVar2.b(aVar3.f23520a);
                if (b2 != null) {
                    return b2.a(activity, str, aVar3.f23521b, z, a.this.new C0442a(aVar3.f23520a, nVar));
                }
                a.this.c("new banner ad but creator = null,channel is =" + aVar3.f23520a);
                return null;
            }
        }, new com.opos.mobad.f.a.c.a(activity2));
    }

    private com.opos.mobad.f.a.a.m<com.opos.mobad.ad.a.a> a(String str, com.opos.mobad.f.a.d.a aVar, List<e.a> list, e.a aVar2, long j2, com.opos.mobad.f.a.b.b<com.opos.mobad.ad.a.a> bVar, com.opos.mobad.f.a.c.a aVar3) {
        return com.opos.mobad.f.a.a.k.a(this.f20545h, str, aVar, list, aVar2, j2, bVar, aVar3, new b.a() { // from class: com.opos.mobad.f.a.a.3
            AnonymousClass3() {
            }

            @Override // com.opos.mobad.ad.b.a
            public void a() {
                a.this.c("onAdReady");
                a.this.o();
                a.this.k();
            }

            @Override // com.opos.mobad.ad.b.a
            public void a(int i2, String str2) {
                a.this.c("onAdFailed code=" + i2 + ",msg =" + str2);
                a.this.b(com.opos.mobad.f.a.a.l.a(i2), str2);
            }

            @Override // com.opos.mobad.ad.b.a
            public void b() {
                a.this.c("onAdClose");
                a.this.i_();
            }
        });
    }

    public void b(int i2, int i3) {
        com.opos.mobad.f.a.a.m<com.opos.mobad.ad.a.a> mVar = this.f20542b;
        if (mVar != null) {
            mVar.a(i2, i3);
        }
        c("notify banner size change w = " + i2 + ",h =" + i3);
    }

    public void k() {
        c("banner showView");
        com.opos.mobad.ad.a.a i2 = this.f20542b.i();
        this.f20547j = this.f20542b.j();
        this.f20543c.a(i2.h());
    }

    private void m() {
        if (this.f20544d == null) {
            n nVar = new n(new Runnable() { // from class: com.opos.mobad.f.a.a.4
                AnonymousClass4() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.f20543c == null || !a.this.f20543c.c()) {
                        a.this.c("banner is invisibile");
                    } else {
                        if (a.this.r() || com.opos.cmn.i.j.a(a.this.f20545h, a.this.h())) {
                            a.this.p();
                            a.this.c(11004, "you should't play ad on the top in the shaped screen mobile");
                            return;
                        }
                        a.this.a();
                    }
                    if (a.this.f20544d != null) {
                        a.this.f20544d.a(com.opos.mobad.service.f.a().a(a.this.f20541a));
                    }
                }
            });
            this.f20544d = nVar;
            nVar.a(com.opos.mobad.service.f.a().a(this.f20541a));
        }
    }

    public void p() {
        try {
            c("setBannerCovered posId=" + this.f20541a);
            f20540g.put(this.f20541a, Boolean.TRUE);
            q();
            b bVar = this.f20543c;
            if (bVar != null) {
                bVar.b();
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.b("delegator banner", "", e2);
        }
    }

    public void q() {
        n nVar = this.f20544d;
        if (nVar != null) {
            nVar.a();
            this.f20544d.b();
            this.f20544d = null;
        }
    }

    public boolean r() {
        boolean z;
        try {
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.b("delegator banner", "", e2);
        }
        if (f20540g.containsKey(this.f20541a)) {
            z = f20540g.get(this.f20541a).booleanValue();
            c("isBannerCovered=" + z);
            return z;
        }
        z = false;
        c("isBannerCovered=" + z);
        return z;
    }

    @Override // com.opos.mobad.l.j, com.opos.mobad.ad.b
    public void a() {
        a(com.opos.mobad.service.f.b().i());
    }

    @Override // com.opos.mobad.ad.a.a
    public void a(int i2, int i3) {
        b(i2, i3);
        c("setBannerWidthAndHeight width = " + i2 + ", height = " + i3);
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public void a(int i2, String str, int i3) {
        if (com.opos.mobad.service.f.b().b(this.f20541a) && d() == 2 && !this.k) {
            this.k = true;
            com.opos.mobad.service.i.d.a().a(this.f20541a, this.f20546i, i2, str, this.f20542b.j(), g(), i3);
        }
    }

    @Override // com.opos.mobad.l.a, com.opos.mobad.l.j, com.opos.mobad.ad.b
    public void b() {
        super.b();
        q();
        this.f20542b.b();
        this.f20543c.b();
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public void b(int i2) {
        if (com.opos.mobad.service.f.b().b(this.f20541a) && d() == 2 && !this.k) {
            this.k = true;
            com.opos.mobad.service.i.d.a().a(this.f20541a, this.f20546i, this.f20542b.j(), g(), i2);
        }
    }

    @Override // com.opos.mobad.l.j
    protected boolean b(String str) {
        return false;
    }

    @Override // com.opos.mobad.l.j
    protected boolean b(String str, int i2) {
        c("doload");
        this.k = false;
        this.f20546i = str;
        if (r() || com.opos.cmn.i.j.a(this.f20545h, h())) {
            p();
            c(11004, "you should't play ad on the top in the shaped screen mobile");
            return false;
        }
        this.f20542b.a(str, i2);
        m();
        return true;
    }

    @Override // com.opos.mobad.ad.b
    public int c() {
        return 0;
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public void c(int i2) {
        com.opos.mobad.ad.a.a i3;
        if (com.opos.mobad.service.f.b().b(this.f20541a) && (i3 = this.f20542b.i()) != null) {
            i3.c(i2);
        }
    }

    public void c(String str) {
        com.opos.cmn.an.f.a.b("delegator banner", str);
    }

    @Override // com.opos.mobad.l.j, com.opos.mobad.ad.b
    public boolean e() {
        com.opos.mobad.ad.a.a i2 = this.f20542b.i();
        if (i2 != null) {
            return i2.e();
        }
        return false;
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public int g() {
        com.opos.mobad.ad.a.a i2;
        int i3;
        if (com.opos.mobad.service.f.b().b(this.f20541a) && (i2 = this.f20542b.i()) != null) {
            int g2 = i2.g();
            if (g2 > 0) {
                return g2;
            }
            e.a k = this.f20542b.k();
            if (k != null && (i3 = k.f23526g) > 0) {
                return i3;
            }
        }
        return 0;
    }

    @Override // com.opos.mobad.ad.a.a
    public View h() {
        return this.f20543c.a();
    }
}
