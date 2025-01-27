package com.opos.mobad.model.d;

import android.content.Context;
import com.opos.mobad.model.d.m;
import com.opos.mobad.model.data.AdData;
import com.opos.mobad.model.data.AdItemData;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes4.dex */
public class s extends b {

    /* renamed from: a */
    private e f21648a;

    /* renamed from: b */
    private t f21649b;

    /* renamed from: c */
    private m f21650c;

    /* renamed from: d */
    private com.opos.mobad.model.b.c f21651d;

    /* renamed from: e */
    private int f21652e;

    /* renamed from: f */
    private int f21653f;

    /* renamed from: g */
    private AdData f21654g;

    /* renamed from: h */
    private AdData f21655h;

    /* renamed from: i */
    private CountDownLatch f21656i;

    /* renamed from: j */
    private CountDownLatch f21657j;
    private com.opos.cmn.i.m k;
    private boolean l;
    private k m;
    private Context n;

    /* renamed from: com.opos.mobad.model.d.s$1 */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.opos.cmn.an.f.a.b("mLoader", "total timeout");
            s.this.l = true;
            s.this.l();
        }
    }

    /* renamed from: com.opos.mobad.model.d.s$2 */
    class AnonymousClass2 implements m.a {
        AnonymousClass2() {
        }

        @Override // com.opos.mobad.model.d.m.a
        public void a() {
            com.opos.cmn.an.f.a.b("mLoader", "cache loaded");
            s.this.f21657j.countDown();
            s.this.f21657j.countDown();
        }

        @Override // com.opos.mobad.model.d.m.a
        public void a(AdData adData) {
            com.opos.cmn.an.f.a.b("mLoader", "cache load fail");
            s.this.f21655h = adData;
            s.this.f21657j.countDown();
        }

        @Override // com.opos.mobad.model.d.m.a
        public void b(AdData adData) {
            if (s.this.f21650c == s.this.f21648a) {
                s.this.k.a();
                s.this.c(adData);
            }
        }

        @Override // com.opos.mobad.model.d.m.a
        public void c(AdData adData) {
            if (s.this.f21650c == s.this.f21648a) {
                s.this.k.a();
                s.this.b(adData);
            }
        }
    }

    /* renamed from: com.opos.mobad.model.d.s$3 */
    class AnonymousClass3 implements m.a {
        AnonymousClass3() {
        }

        @Override // com.opos.mobad.model.d.m.a
        public void a() {
            com.opos.cmn.an.f.a.b("mLoader", "sync loaded");
            s.this.f21656i.countDown();
            s.this.f21657j.countDown();
            s.this.f21657j.countDown();
        }

        @Override // com.opos.mobad.model.d.m.a
        public void a(AdData adData) {
            com.opos.cmn.an.f.a.b("mLoader", "sync load fail");
            s.this.f21654g = adData;
            s.this.f21656i.countDown();
            s.this.f21657j.countDown();
        }

        @Override // com.opos.mobad.model.d.m.a
        public void b(AdData adData) {
            if (s.this.f21650c == s.this.f21649b) {
                s.this.k.a();
                s.this.c(adData);
            }
        }

        @Override // com.opos.mobad.model.d.m.a
        public void c(AdData adData) {
            k kVar;
            int i2;
            if (s.this.f21650c == s.this.f21649b) {
                s.this.k.a();
                if (s.this.l || !s.this.m()) {
                    if (s.this.l) {
                        kVar = s.this.m;
                        i2 = 4;
                    } else {
                        kVar = s.this.m;
                        i2 = 3;
                    }
                    kVar.d(i2);
                    s.this.b(adData);
                }
            }
        }
    }

    /* renamed from: com.opos.mobad.model.d.s$4 */
    class AnonymousClass4 implements Runnable {
        AnonymousClass4() {
        }

        /* JADX WARN: Can't wrap try/catch for region: R(16:0|1|(1:3)(1:46)|4|(2:5|6)|7|(2:9|(3:11|12|13)(1:15))(1:42)|16|17|18|(2:20|(3:22|12|13)(2:23|(2:25|26)(1:27)))(1:38)|28|(1:30)(2:34|(1:36)(1:37))|31|32|33) */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x009c, code lost:
        
            r1 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x009d, code lost:
        
            com.opos.cmn.an.f.a.b("mLoader", "total await", r1);
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 294
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.model.d.s.AnonymousClass4.run():void");
        }
    }

    public s(Context context, String str, String str2, com.opos.mobad.model.b.c cVar, boolean z, com.opos.mobad.model.a.b bVar, int i2, int i3, m.a aVar) {
        super(aVar);
        this.f21656i = new CountDownLatch(1);
        this.f21657j = new CountDownLatch(2);
        this.l = false;
        this.n = context;
        this.f21651d = cVar;
        this.m = new k(str, str2);
        this.f21652e = i2;
        this.f21653f = i3;
        this.k = new com.opos.cmn.i.m(com.opos.mobad.service.c.a(), new Runnable() { // from class: com.opos.mobad.model.d.s.1
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                com.opos.cmn.an.f.a.b("mLoader", "total timeout");
                s.this.l = true;
                s.this.l();
            }
        });
        this.f21648a = new e(context, str, str2, cVar, z, new m.a() { // from class: com.opos.mobad.model.d.s.2
            AnonymousClass2() {
            }

            @Override // com.opos.mobad.model.d.m.a
            public void a() {
                com.opos.cmn.an.f.a.b("mLoader", "cache loaded");
                s.this.f21657j.countDown();
                s.this.f21657j.countDown();
            }

            @Override // com.opos.mobad.model.d.m.a
            public void a(AdData adData) {
                com.opos.cmn.an.f.a.b("mLoader", "cache load fail");
                s.this.f21655h = adData;
                s.this.f21657j.countDown();
            }

            @Override // com.opos.mobad.model.d.m.a
            public void b(AdData adData) {
                if (s.this.f21650c == s.this.f21648a) {
                    s.this.k.a();
                    s.this.c(adData);
                }
            }

            @Override // com.opos.mobad.model.d.m.a
            public void c(AdData adData) {
                if (s.this.f21650c == s.this.f21648a) {
                    s.this.k.a();
                    s.this.b(adData);
                }
            }
        });
        this.f21649b = new t(context, str, str2, cVar, z, new m.a() { // from class: com.opos.mobad.model.d.s.3
            AnonymousClass3() {
            }

            @Override // com.opos.mobad.model.d.m.a
            public void a() {
                com.opos.cmn.an.f.a.b("mLoader", "sync loaded");
                s.this.f21656i.countDown();
                s.this.f21657j.countDown();
                s.this.f21657j.countDown();
            }

            @Override // com.opos.mobad.model.d.m.a
            public void a(AdData adData) {
                com.opos.cmn.an.f.a.b("mLoader", "sync load fail");
                s.this.f21654g = adData;
                s.this.f21656i.countDown();
                s.this.f21657j.countDown();
            }

            @Override // com.opos.mobad.model.d.m.a
            public void b(AdData adData) {
                if (s.this.f21650c == s.this.f21649b) {
                    s.this.k.a();
                    s.this.c(adData);
                }
            }

            @Override // com.opos.mobad.model.d.m.a
            public void c(AdData adData) {
                k kVar;
                int i22;
                if (s.this.f21650c == s.this.f21649b) {
                    s.this.k.a();
                    if (s.this.l || !s.this.m()) {
                        if (s.this.l) {
                            kVar = s.this.m;
                            i22 = 4;
                        } else {
                            kVar = s.this.m;
                            i22 = 3;
                        }
                        kVar.d(i22);
                        s.this.b(adData);
                    }
                }
            }
        }, bVar);
    }

    public void c() {
        com.opos.cmn.an.f.a.b("mLoader", "select sync");
        if (!h()) {
            com.opos.cmn.an.f.a.c("mLoader", "select fail");
        } else {
            this.f21650c = this.f21649b;
            g();
        }
    }

    public void d() {
        com.opos.cmn.an.f.a.b("mLoader", "select cache");
        if (!h()) {
            com.opos.cmn.an.f.a.c("mLoader", "select fail");
        } else {
            this.f21650c = this.f21648a;
            g();
        }
    }

    private void k() {
        e eVar = this.f21648a;
        this.f21650c = eVar;
        eVar.g();
    }

    public void l() {
        k kVar;
        int i2;
        if (j() == 5) {
            i2 = 3;
            if (this.f21648a.j() == 3 && this.f21648a.d()) {
                com.opos.cmn.an.f.a.b("mLoader", "timeout to use cache");
                k();
                kVar = this.m;
                i2 = 2;
            } else {
                kVar = this.m;
            }
        } else {
            kVar = this.m;
            i2 = 4;
        }
        kVar.c(i2);
    }

    public boolean m() {
        if (j() != 5 || this.f21648a.j() != 3) {
            return false;
        }
        com.opos.cmn.an.f.a.b("mLoader", "change to cache");
        this.m.d(2);
        k();
        return true;
    }

    @Override // com.opos.mobad.model.d.b
    protected void a() {
        m mVar = this.f21650c;
        if (mVar != null) {
            mVar.g();
        } else {
            com.opos.cmn.an.f.a.b("mLoader", "load with target null");
        }
    }

    @Override // com.opos.mobad.model.d.b
    protected void a(AdData adData) {
        com.opos.cmn.an.f.a.b("mLoader", "onLoadFail");
        if (adData == null) {
            adData = new AdData(-1, "unknown error.");
        }
        this.m.a(this.n, adData.d(), adData.e(), this.f21650c == this.f21648a, this.f21651d.i());
        super.a(adData);
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x006e, code lost:
    
        if (r8.f21648a.d() != false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0076, code lost:
    
        if (r8.f21648a.j() == 6) goto L82;
     */
    @Override // com.opos.mobad.model.d.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void b() {
        /*
            r8 = this;
            com.opos.cmn.i.m r0 = r8.k
            r0.a()
            int r0 = r8.j()
            r1 = 6
            if (r0 != r1) goto L1b
            com.opos.mobad.model.d.m r0 = r8.f21650c
            com.opos.mobad.model.d.t r2 = r8.f21649b
            if (r0 != r2) goto L16
        L12:
            r2.c()
            goto L1b
        L16:
            com.opos.mobad.model.d.e r2 = r8.f21648a
            if (r0 != r2) goto L1b
            goto L12
        L1b:
            int r0 = r8.j()
            r2 = 7
            r3 = 0
            r4 = 3
            if (r0 == r1) goto L59
            int r0 = r8.j()
            if (r0 != r2) goto L2b
            goto L59
        L2b:
            com.opos.mobad.model.d.e r0 = r8.f21648a
            int r0 = r0.j()
            if (r0 == r4) goto L53
            com.opos.mobad.model.d.e r0 = r8.f21648a
            int r0 = r0.j()
            if (r0 != r1) goto L3c
            goto L53
        L3c:
            com.opos.mobad.model.d.t r0 = r8.f21649b
            int r0 = r0.j()
            if (r0 == r4) goto La0
            com.opos.mobad.model.d.t r0 = r8.f21649b
            int r0 = r0.j()
            if (r0 != r1) goto L4d
            goto La0
        L4d:
            com.opos.mobad.model.d.e r0 = r8.f21648a
            r0.k()
            goto La5
        L53:
            com.opos.mobad.model.d.e r0 = r8.f21648a
            r0.a(r3)
            goto La5
        L59:
            com.opos.mobad.model.d.m r0 = r8.f21650c
            com.opos.mobad.model.d.t r5 = r8.f21649b
            r6 = 1
            if (r0 != r5) goto L79
            com.opos.mobad.model.d.e r0 = r8.f21648a
            int r0 = r0.j()
            if (r0 != r4) goto L70
            com.opos.mobad.model.d.e r0 = r8.f21648a
            boolean r0 = r0.d()
            if (r0 != 0) goto L53
        L70:
            com.opos.mobad.model.d.e r0 = r8.f21648a
            int r0 = r0.j()
            if (r0 != r1) goto L83
            goto L53
        L79:
            com.opos.mobad.model.d.e r7 = r8.f21648a
            if (r0 != r7) goto La5
            int r0 = r5.j()
            if (r0 != r2) goto L89
        L83:
            com.opos.mobad.model.d.t r0 = r8.f21649b
            r0.a(r6)
            goto La5
        L89:
            com.opos.mobad.model.d.t r0 = r8.f21649b
            int r0 = r0.j()
            if (r0 == r4) goto La0
            com.opos.mobad.model.d.t r0 = r8.f21649b
            int r0 = r0.j()
            if (r0 != r1) goto L9a
            goto La0
        L9a:
            com.opos.mobad.model.d.e r0 = r8.f21648a
            r0.a(r6)
            goto La5
        La0:
            com.opos.mobad.model.d.t r0 = r8.f21649b
            r0.a(r3)
        La5:
            com.opos.mobad.model.d.e r0 = r8.f21648a
            if (r0 == 0) goto Lac
            r0.i()
        Lac:
            com.opos.mobad.model.d.t r0 = r8.f21649b
            if (r0 == 0) goto Lb3
            r0.i()
        Lb3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.model.d.s.b():void");
    }

    @Override // com.opos.mobad.model.d.b
    protected void b(AdData adData) {
        com.opos.cmn.an.f.a.b("mLoader", "onLoadResourceFail");
        this.m.a(this.n, adData.d(), adData.e(), this.f21650c == this.f21648a, this.f21651d.i());
        super.b(adData);
        i();
    }

    @Override // com.opos.mobad.model.d.b
    protected void c(AdData adData) {
        String str;
        int i2;
        com.opos.cmn.an.f.a.b("mLoader", "onLoadResourceSucc");
        if (adData == null || adData.f().size() <= 0 || adData.f().get(0) == null) {
            str = "";
            i2 = 0;
        } else {
            AdItemData adItemData = adData.f().get(0);
            String c2 = adItemData.c();
            i2 = adItemData.X();
            str = c2;
        }
        this.m.a(this.n, str, this.f21650c == this.f21648a, this.f21651d.i(), i2);
        super.c(adData);
        i();
    }

    @Override // com.opos.mobad.model.d.b
    protected void e() {
        if (this.f21652e >= 30) {
            this.k.a(r0 - 30);
        }
        com.opos.cmn.an.f.a.b("mLoader", "request:" + this.f21653f + ",total:" + this.f21652e);
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.model.d.s.4
            AnonymousClass4() {
            }

            @Override // java.lang.Runnable
            public void run() {
                /*
                    Method dump skipped, instructions count: 294
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.model.d.s.AnonymousClass4.run():void");
            }
        });
    }
}
