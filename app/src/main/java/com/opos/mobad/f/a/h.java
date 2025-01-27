package com.opos.mobad.f.a;

import android.content.Context;
import com.opos.mobad.ad.b;
import com.opos.mobad.service.a.e;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public class h extends com.opos.mobad.l.h {

    /* renamed from: a */
    private String f20740a;

    /* renamed from: b */
    private com.opos.mobad.f.a.a.n<com.opos.mobad.ad.d.a> f20741b;

    /* renamed from: c */
    private boolean f20742c;

    /* renamed from: d */
    private String f20743d;

    /* renamed from: g */
    private com.opos.mobad.ad.d.a f20744g;

    /* renamed from: h */
    private boolean f20745h;

    /* renamed from: com.opos.mobad.f.a.h$1 */
    class AnonymousClass1 implements com.opos.mobad.f.a.b.b<com.opos.mobad.ad.d.a> {

        /* renamed from: a */
        final /* synthetic */ com.opos.mobad.f.b f20746a;

        /* renamed from: b */
        final /* synthetic */ Context f20747b;

        /* renamed from: c */
        final /* synthetic */ String f20748c;

        /* renamed from: d */
        final /* synthetic */ boolean f20749d;

        AnonymousClass1(com.opos.mobad.f.b bVar, Context context, String str, boolean z) {
            bVar2 = bVar;
            context = context;
            str = str;
            z = z;
        }

        @Override // com.opos.mobad.f.a.b.a
        /* renamed from: a */
        public com.opos.mobad.ad.d.a b(e.a aVar, com.opos.mobad.f.a.a.n nVar) {
            com.opos.mobad.ad.c b2 = bVar2.b(aVar.f23520a);
            if (b2 == null) {
                return null;
            }
            return b2.a(context, str, aVar.f23521b, z, h.this.new a(aVar.f23520a, nVar));
        }
    }

    /* renamed from: com.opos.mobad.f.a.h$2 */
    class AnonymousClass2 implements b.a {

        /* renamed from: com.opos.mobad.f.a.h$2$1 */
        class AnonymousClass1 implements Callable<Boolean> {
            AnonymousClass1() {
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() throws Exception {
                h.this.f20745h = true;
                return Boolean.TRUE;
            }
        }

        AnonymousClass2() {
        }

        @Override // com.opos.mobad.ad.b.a
        public void a() {
            h.this.c("onAdReady");
            h.this.o();
        }

        @Override // com.opos.mobad.ad.b.a
        public void a(int i2, String str) {
            h.this.c("onAdFailed code= " + i2 + ",msg= " + str);
            if (h.this.f20744g != null && h.this.d(i2) && h.this.f20744g.d() == 2) {
                h.this.c(new Callable<Boolean>() { // from class: com.opos.mobad.f.a.h.2.1
                    AnonymousClass1() {
                    }

                    @Override // java.util.concurrent.Callable
                    /* renamed from: a */
                    public Boolean call() throws Exception {
                        h.this.f20745h = true;
                        return Boolean.TRUE;
                    }
                });
            } else {
                h.this.b(com.opos.mobad.f.a.a.l.a(i2), str);
            }
        }

        @Override // com.opos.mobad.ad.b.a
        public void b() {
            h.this.i_();
        }
    }

    /* renamed from: com.opos.mobad.f.a.h$3 */
    class AnonymousClass3 implements com.opos.mobad.ad.d.b {
        AnonymousClass3() {
        }

        @Override // com.opos.mobad.ad.b.a
        public void a() {
        }

        @Override // com.opos.mobad.ad.b.a
        public void a(int i2, String str) {
        }

        @Override // com.opos.mobad.ad.d.b, com.opos.mobad.ad.i.b
        public void a(long j2) {
            h.this.a(j2);
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(String str) {
            h.this.q();
        }

        @Override // com.opos.mobad.ad.h
        public void a(Object... objArr) {
            h.this.a(objArr);
        }

        @Override // com.opos.mobad.ad.b.a
        public void b() {
            h.this.i_();
        }

        @Override // com.opos.mobad.ad.d.b
        public void b(long j2) {
            h.this.b(j2);
        }

        @Override // com.opos.mobad.ad.d.b
        public void b(String str) {
            h.this.d(str);
        }

        @Override // com.opos.mobad.ad.d.b
        public void c() {
            h.this.i();
        }

        @Override // com.opos.mobad.ad.d.b
        public void d() {
            h.this.h_();
        }

        @Override // com.opos.mobad.ad.d.b
        public void e() {
            h.this.k();
        }

        @Override // com.opos.mobad.ad.d.b
        public void f() {
            h.this.m();
        }
    }

    private class a extends com.opos.mobad.f.a.a.b implements com.opos.mobad.ad.d.b {

        /* renamed from: c */
        private final int f20755c;

        public a(int i2, com.opos.mobad.f.a.a.n nVar) {
            super(i2, nVar);
            this.f20755c = i2;
        }

        @Override // com.opos.mobad.f.a.a.b, com.opos.mobad.ad.b.a
        public void a(int i2, String str) {
            h.this.c("onAdFailed code=" + i2 + ",msg=" + str + ",currentState=" + h.this.d());
            if (1 == h.this.d()) {
                super.a(i2, str);
                return;
            }
            h.this.c("current:" + this.f20755c + ",select=" + h.this.f20741b.j());
            if (this.f20755c != h.this.f20741b.j()) {
                return;
            }
            h.this.c(i2, str);
        }

        @Override // com.opos.mobad.ad.d.b, com.opos.mobad.ad.i.b
        public void a(long j2) {
            if (this.f20755c != h.this.f20741b.j()) {
                return;
            }
            com.opos.mobad.service.j.n.a().b(h.this.f20740a);
            h.this.a(j2);
        }

        @Override // com.opos.mobad.ad.i.b
        public void a(String str) {
            if (this.f20755c != h.this.f20741b.j()) {
                return;
            }
            h.this.q();
        }

        @Override // com.opos.mobad.ad.h
        public void a(Object... objArr) {
            if (this.f20755c != h.this.f20741b.j()) {
                return;
            }
            h.this.a(objArr);
        }

        @Override // com.opos.mobad.f.a.a.b, com.opos.mobad.ad.b.a
        public void b() {
            if (this.f20755c != h.this.f20741b.j()) {
                return;
            }
            h.this.i_();
        }

        @Override // com.opos.mobad.ad.d.b
        public void b(long j2) {
            if (this.f20755c != h.this.f20741b.j()) {
                return;
            }
            h.this.b(j2);
        }

        @Override // com.opos.mobad.ad.d.b
        public void b(String str) {
            if (this.f20755c != h.this.f20741b.j()) {
                return;
            }
            h.this.d(str);
        }

        @Override // com.opos.mobad.ad.d.b
        public void c() {
            if (this.f20755c != h.this.f20741b.j()) {
                return;
            }
            com.opos.mobad.service.j.n.a().a(h.this.f20740a);
            h.this.i();
        }

        @Override // com.opos.mobad.ad.d.b
        public void d() {
            if (this.f20755c != h.this.f20741b.j()) {
                return;
            }
            h.this.h_();
        }

        @Override // com.opos.mobad.ad.d.b
        public void e() {
            if (this.f20755c != h.this.f20741b.j()) {
                return;
            }
            h.this.k();
        }

        @Override // com.opos.mobad.ad.d.b
        public void f() {
            if (this.f20755c != h.this.f20741b.j()) {
                return;
            }
            h.this.m();
        }
    }

    public h(Context context, String str, com.opos.mobad.f.a.d.a aVar, com.opos.mobad.ad.d.b bVar, boolean z, List<e.a> list, e.a aVar2, long j2, com.opos.mobad.f.b bVar2) {
        super(bVar);
        this.f20745h = false;
        this.f20740a = str;
        AnonymousClass1 anonymousClass1 = new com.opos.mobad.f.a.b.b<com.opos.mobad.ad.d.a>() { // from class: com.opos.mobad.f.a.h.1

            /* renamed from: a */
            final /* synthetic */ com.opos.mobad.f.b f20746a;

            /* renamed from: b */
            final /* synthetic */ Context f20747b;

            /* renamed from: c */
            final /* synthetic */ String f20748c;

            /* renamed from: d */
            final /* synthetic */ boolean f20749d;

            AnonymousClass1(com.opos.mobad.f.b bVar22, Context context2, String str2, boolean z2) {
                bVar2 = bVar22;
                context = context2;
                str = str2;
                z = z2;
            }

            @Override // com.opos.mobad.f.a.b.a
            /* renamed from: a */
            public com.opos.mobad.ad.d.a b(e.a aVar3, com.opos.mobad.f.a.a.n nVar) {
                com.opos.mobad.ad.c b2 = bVar2.b(aVar3.f23520a);
                if (b2 == null) {
                    return null;
                }
                return b2.a(context, str, aVar3.f23521b, z, h.this.new a(aVar3.f23520a, nVar));
            }
        };
        this.f20744g = a(context2, bVar22, str2);
        this.f20741b = a(str2, aVar, list, aVar2, j2, anonymousClass1, new com.opos.mobad.f.a.c.a(context2));
    }

    private com.opos.mobad.ad.d.a a(Context context, com.opos.mobad.f.b bVar, String str) {
        com.opos.mobad.ad.c b2;
        if (context == null || bVar == null || (b2 = bVar.b(1000)) == null) {
            return null;
        }
        return b2.a(context, str, str, true, (com.opos.mobad.ad.d.b) new com.opos.mobad.ad.d.b() { // from class: com.opos.mobad.f.a.h.3
            AnonymousClass3() {
            }

            @Override // com.opos.mobad.ad.b.a
            public void a() {
            }

            @Override // com.opos.mobad.ad.b.a
            public void a(int i2, String str2) {
            }

            @Override // com.opos.mobad.ad.d.b, com.opos.mobad.ad.i.b
            public void a(long j2) {
                h.this.a(j2);
            }

            @Override // com.opos.mobad.ad.i.b
            public void a(String str2) {
                h.this.q();
            }

            @Override // com.opos.mobad.ad.h
            public void a(Object... objArr) {
                h.this.a(objArr);
            }

            @Override // com.opos.mobad.ad.b.a
            public void b() {
                h.this.i_();
            }

            @Override // com.opos.mobad.ad.d.b
            public void b(long j2) {
                h.this.b(j2);
            }

            @Override // com.opos.mobad.ad.d.b
            public void b(String str2) {
                h.this.d(str2);
            }

            @Override // com.opos.mobad.ad.d.b
            public void c() {
                h.this.i();
            }

            @Override // com.opos.mobad.ad.d.b
            public void d() {
                h.this.h_();
            }

            @Override // com.opos.mobad.ad.d.b
            public void e() {
                h.this.k();
            }

            @Override // com.opos.mobad.ad.d.b
            public void f() {
                h.this.m();
            }
        });
    }

    private com.opos.mobad.f.a.a.n<com.opos.mobad.ad.d.a> a(String str, com.opos.mobad.f.a.d.a aVar, List<e.a> list, e.a aVar2, long j2, com.opos.mobad.f.a.b.b<com.opos.mobad.ad.d.a> bVar, com.opos.mobad.f.a.c.a aVar3) {
        return com.opos.mobad.f.a.a.k.a(str, aVar, list, aVar2, j2, bVar, aVar3, new b.a() { // from class: com.opos.mobad.f.a.h.2

            /* renamed from: com.opos.mobad.f.a.h$2$1 */
            class AnonymousClass1 implements Callable<Boolean> {
                AnonymousClass1() {
                }

                @Override // java.util.concurrent.Callable
                /* renamed from: a */
                public Boolean call() throws Exception {
                    h.this.f20745h = true;
                    return Boolean.TRUE;
                }
            }

            AnonymousClass2() {
            }

            @Override // com.opos.mobad.ad.b.a
            public void a() {
                h.this.c("onAdReady");
                h.this.o();
            }

            @Override // com.opos.mobad.ad.b.a
            public void a(int i2, String str2) {
                h.this.c("onAdFailed code= " + i2 + ",msg= " + str2);
                if (h.this.f20744g != null && h.this.d(i2) && h.this.f20744g.d() == 2) {
                    h.this.c(new Callable<Boolean>() { // from class: com.opos.mobad.f.a.h.2.1
                        AnonymousClass1() {
                        }

                        @Override // java.util.concurrent.Callable
                        /* renamed from: a */
                        public Boolean call() throws Exception {
                            h.this.f20745h = true;
                            return Boolean.TRUE;
                        }
                    });
                } else {
                    h.this.b(com.opos.mobad.f.a.a.l.a(i2), str2);
                }
            }

            @Override // com.opos.mobad.ad.b.a
            public void b() {
                h.this.i_();
            }
        });
    }

    public boolean d(int i2) {
        if (i2 != 10011) {
            if (i2 != -1 && i2 != -2 && i2 != -5 && i2 != -8 && i2 != -3) {
                return false;
            }
            c("need to intercept check errorCode = " + i2);
        }
        return true;
    }

    @Override // com.opos.mobad.l.j, com.opos.mobad.ad.b
    public void a() {
        a(com.opos.mobad.service.f.b().q());
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public void a(int i2, String str, int i3) {
        if (com.opos.mobad.service.f.b().b(this.f20740a) && d() == 2 && !this.f20742c) {
            this.f20742c = true;
            com.opos.mobad.service.i.d.a().a(this.f20740a, this.f20743d, i2, str, this.f20741b.j(), g(), i3);
        }
    }

    @Override // com.opos.mobad.l.j, com.opos.mobad.ad.b
    public void b() {
        super.b();
        this.f20741b.b();
        com.opos.mobad.ad.d.a aVar = this.f20744g;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public void b(int i2) {
        if (com.opos.mobad.service.f.b().b(this.f20740a) && d() == 2 && !this.f20742c) {
            this.f20742c = true;
            com.opos.mobad.service.i.d.a().a(this.f20740a, this.f20743d, this.f20741b.j(), g(), i2);
        }
    }

    @Override // com.opos.mobad.l.j
    protected boolean b(String str) {
        return false;
    }

    @Override // com.opos.mobad.l.j
    protected boolean b(String str, int i2) {
        c("doload");
        this.f20742c = false;
        this.f20743d = str;
        this.f20745h = false;
        com.opos.mobad.ad.d.a aVar = this.f20744g;
        if (aVar != null) {
            aVar.a(str, i2);
        }
        this.f20741b.a(str, i2);
        return true;
    }

    @Override // com.opos.mobad.l.h
    protected boolean b(boolean z) {
        c("doShow");
        com.opos.mobad.ad.d.a i2 = this.f20745h ? this.f20744g : this.f20741b.i();
        if (i2 == null) {
            c(-1, "ad is null");
            return false;
        }
        i2.a(z);
        return i2.d() == 3;
    }

    @Override // com.opos.mobad.ad.b
    public int c() {
        return 0;
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public void c(int i2) {
        com.opos.mobad.ad.d.a i3;
        if (com.opos.mobad.service.f.b().b(this.f20740a) && (i3 = this.f20741b.i()) != null) {
            i3.c(i2);
        }
    }

    public void c(String str) {
        com.opos.cmn.an.f.a.b("delegator RWVideo", str);
    }

    @Override // com.opos.mobad.l.j, com.opos.mobad.ad.b
    public boolean e() {
        com.opos.mobad.ad.d.a i2;
        if (this.f20745h) {
            i2 = this.f20744g;
        } else {
            i2 = this.f20741b.i();
            if (i2 == null) {
                return false;
            }
        }
        return i2.e();
    }

    @Override // com.opos.mobad.ad.g.a, com.opos.mobad.ad.g
    public int g() {
        com.opos.mobad.ad.d.a i2;
        int i3;
        if (com.opos.mobad.service.f.b().b(this.f20740a) && (i2 = this.f20741b.i()) != null) {
            int g2 = i2.g();
            if (g2 > 0) {
                return g2;
            }
            e.a k = this.f20741b.k();
            if (k != null && (i3 = k.f23526g) > 0) {
                return i3;
            }
        }
        return 0;
    }
}
