package com.opos.mobad.q.a;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import com.opos.mobad.cmn.a.a;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.AppPrivacyData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.o.d.e;
import com.opos.mobad.q.a.d;

/* loaded from: classes4.dex */
public class c extends m {

    /* renamed from: a */
    protected Activity f23190a;

    /* renamed from: b */
    protected Context f23191b;

    /* renamed from: c */
    protected com.opos.mobad.n.a f23192c;

    /* renamed from: d */
    protected AdItemData f23193d;

    /* renamed from: e */
    protected MaterialData f23194e;

    /* renamed from: f */
    protected com.opos.mobad.n.d.h f23195f;

    /* renamed from: g */
    protected d f23196g;

    /* renamed from: h */
    protected g f23197h;

    /* renamed from: i */
    protected boolean f23198i;

    /* renamed from: j */
    protected long f23199j;
    protected com.opos.mobad.n.a k;
    private boolean p;
    private com.opos.mobad.o.a.a q;
    private int r;
    private boolean s;

    /* renamed from: com.opos.mobad.q.a.c$1 */
    class AnonymousClass1 implements d.b {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.q.a.d.b
        public void a(View view, int[] iArr) {
            c.this.a(iArr);
        }

        @Override // com.opos.mobad.q.a.d.b
        public void b(View view, int[] iArr) {
            c.this.j();
        }
    }

    /* renamed from: com.opos.mobad.q.a.c$2 */
    class AnonymousClass2 implements com.opos.mobad.o.a.b {
        AnonymousClass2() {
        }

        @Override // com.opos.mobad.o.a.b
        public void a(int i2) {
            c.this.l.c(i2);
            c.this.f23195f.b(false);
            c cVar = c.this;
            cVar.f23192c.a(cVar.f23195f);
        }

        @Override // com.opos.mobad.o.a.b
        public void a(boolean z) {
            c.this.j();
        }
    }

    /* renamed from: com.opos.mobad.q.a.c$3 */
    class AnonymousClass3 implements a.b {

        /* renamed from: com.opos.mobad.q.a.c$3$1 */
        class AnonymousClass1 implements d.a {

            /* renamed from: a */
            final /* synthetic */ a.InterfaceC0429a f23203a;

            AnonymousClass1(a.InterfaceC0429a interfaceC0429a) {
                interfaceC0429a = interfaceC0429a;
            }

            @Override // com.opos.mobad.q.a.d.a
            public void a() {
                c.this.f23192c.b();
                a.InterfaceC0429a interfaceC0429a = interfaceC0429a;
                if (interfaceC0429a != null) {
                    interfaceC0429a.a();
                }
            }

            @Override // com.opos.mobad.q.a.d.a
            public void b() {
                c.this.f23192c.b();
                a.InterfaceC0429a interfaceC0429a = interfaceC0429a;
                if (interfaceC0429a != null) {
                    interfaceC0429a.b();
                }
            }
        }

        AnonymousClass3() {
        }

        @Override // com.opos.mobad.cmn.a.a.b
        public void a() {
            c.this.f23196g.a();
        }

        @Override // com.opos.mobad.cmn.a.a.b
        public void a(a.InterfaceC0429a interfaceC0429a) {
            c.this.f23192c.a();
            c.this.f23196g.a(new d.a() { // from class: com.opos.mobad.q.a.c.3.1

                /* renamed from: a */
                final /* synthetic */ a.InterfaceC0429a f23203a;

                AnonymousClass1(a.InterfaceC0429a interfaceC0429a2) {
                    interfaceC0429a = interfaceC0429a2;
                }

                @Override // com.opos.mobad.q.a.d.a
                public void a() {
                    c.this.f23192c.b();
                    a.InterfaceC0429a interfaceC0429a2 = interfaceC0429a;
                    if (interfaceC0429a2 != null) {
                        interfaceC0429a2.a();
                    }
                }

                @Override // com.opos.mobad.q.a.d.a
                public void b() {
                    c.this.f23192c.b();
                    a.InterfaceC0429a interfaceC0429a2 = interfaceC0429a;
                    if (interfaceC0429a2 != null) {
                        interfaceC0429a2.b();
                    }
                }
            });
        }
    }

    /* renamed from: com.opos.mobad.q.a.c$4 */
    class AnonymousClass4 implements e.b {
        AnonymousClass4() {
        }

        @Override // com.opos.mobad.o.d.e.b
        public void a() {
            c.this.j();
        }
    }

    /* renamed from: com.opos.mobad.q.a.c$5 */
    class AnonymousClass5 implements e.b {
        AnonymousClass5() {
        }

        @Override // com.opos.mobad.o.d.e.b
        public void a() {
            c.this.j();
        }
    }

    /* renamed from: com.opos.mobad.q.a.c$6 */
    class AnonymousClass6 implements Runnable {
        AnonymousClass6() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar = c.this;
            com.opos.mobad.n.d.h hVar = cVar.f23195f;
            if (hVar == null) {
                return;
            }
            if (cVar.o >= 0) {
                hVar.f(cVar.n.e(cVar.f23199j));
            }
            c cVar2 = c.this;
            cVar2.f23192c.a(cVar2.f23195f);
        }
    }

    /* renamed from: com.opos.mobad.q.a.c$7 */
    class AnonymousClass7 implements Runnable {
        AnonymousClass7() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g gVar = c.this.f23197h;
            if (gVar != null) {
                gVar.a();
            }
        }
    }

    /* renamed from: com.opos.mobad.q.a.c$8 */
    class AnonymousClass8 implements a.c {
        AnonymousClass8() {
        }

        @Override // com.opos.mobad.cmn.a.a.c
        public void a(int i2) {
            if (i2 == 8) {
                com.opos.mobad.n.a aVar = c.this.f23192c;
                if (aVar instanceof f) {
                    ((f) aVar).f();
                }
            }
        }

        @Override // com.opos.mobad.cmn.a.a.c
        public void a(int i2, int i3) {
        }
    }

    public c(Activity activity, String str, com.opos.mobad.cmn.a.a aVar, com.opos.mobad.n.a aVar2, d dVar, com.opos.mobad.o.a.a aVar3, com.opos.mobad.q.a.e.a aVar4) {
        this(activity, str, aVar, aVar2, dVar, aVar3, aVar4, null);
    }

    public c(Activity activity, String str, com.opos.mobad.cmn.a.a aVar, com.opos.mobad.n.a aVar2, d dVar, com.opos.mobad.o.a.a aVar3, com.opos.mobad.q.a.e.a aVar4, com.opos.mobad.n.a aVar5) {
        super(activity.getApplicationContext(), str, aVar, aVar4, aVar4);
        this.f23195f = null;
        this.p = false;
        this.f23199j = -1L;
        this.r = 2;
        this.s = false;
        this.f23191b = activity.getApplicationContext();
        this.f23190a = activity;
        this.f23192c = aVar2;
        this.f23196g = dVar;
        dVar.a(new d.b() { // from class: com.opos.mobad.q.a.c.1
            AnonymousClass1() {
            }

            @Override // com.opos.mobad.q.a.d.b
            public void a(View view, int[] iArr) {
                c.this.a(iArr);
            }

            @Override // com.opos.mobad.q.a.d.b
            public void b(View view, int[] iArr) {
                c.this.j();
            }
        });
        this.f23192c.a(this);
        if (aVar5 != null) {
            this.k = aVar5;
            aVar5.a(this);
        }
        this.q = aVar3;
        aVar3.a(new com.opos.mobad.o.a.b() { // from class: com.opos.mobad.q.a.c.2
            AnonymousClass2() {
            }

            @Override // com.opos.mobad.o.a.b
            public void a(int i2) {
                c.this.l.c(i2);
                c.this.f23195f.b(false);
                c cVar = c.this;
                cVar.f23192c.a(cVar.f23195f);
            }

            @Override // com.opos.mobad.o.a.b
            public void a(boolean z) {
                c.this.j();
            }
        });
        aVar.a(new a.b() { // from class: com.opos.mobad.q.a.c.3

            /* renamed from: com.opos.mobad.q.a.c$3$1 */
            class AnonymousClass1 implements d.a {

                /* renamed from: a */
                final /* synthetic */ a.InterfaceC0429a f23203a;

                AnonymousClass1(a.InterfaceC0429a interfaceC0429a2) {
                    interfaceC0429a = interfaceC0429a2;
                }

                @Override // com.opos.mobad.q.a.d.a
                public void a() {
                    c.this.f23192c.b();
                    a.InterfaceC0429a interfaceC0429a2 = interfaceC0429a;
                    if (interfaceC0429a2 != null) {
                        interfaceC0429a2.a();
                    }
                }

                @Override // com.opos.mobad.q.a.d.a
                public void b() {
                    c.this.f23192c.b();
                    a.InterfaceC0429a interfaceC0429a2 = interfaceC0429a;
                    if (interfaceC0429a2 != null) {
                        interfaceC0429a2.b();
                    }
                }
            }

            AnonymousClass3() {
            }

            @Override // com.opos.mobad.cmn.a.a.b
            public void a() {
                c.this.f23196g.a();
            }

            @Override // com.opos.mobad.cmn.a.a.b
            public void a(a.InterfaceC0429a interfaceC0429a2) {
                c.this.f23192c.a();
                c.this.f23196g.a(new d.a() { // from class: com.opos.mobad.q.a.c.3.1

                    /* renamed from: a */
                    final /* synthetic */ a.InterfaceC0429a f23203a;

                    AnonymousClass1(a.InterfaceC0429a interfaceC0429a22) {
                        interfaceC0429a = interfaceC0429a22;
                    }

                    @Override // com.opos.mobad.q.a.d.a
                    public void a() {
                        c.this.f23192c.b();
                        a.InterfaceC0429a interfaceC0429a22 = interfaceC0429a;
                        if (interfaceC0429a22 != null) {
                            interfaceC0429a22.a();
                        }
                    }

                    @Override // com.opos.mobad.q.a.d.a
                    public void b() {
                        c.this.f23192c.b();
                        a.InterfaceC0429a interfaceC0429a22 = interfaceC0429a;
                        if (interfaceC0429a22 != null) {
                            interfaceC0429a22.b();
                        }
                    }
                });
            }
        });
    }

    private void a(boolean z) {
        if (z) {
            try {
                if (1 == com.opos.cmn.an.h.b.a.b(this.f23191b) || com.opos.cmn.an.h.b.a.b(this.f23191b) == 0) {
                    b(false);
                    return;
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("InteractivePresenter", "", (Throwable) e2);
                return;
            }
        }
        b(true);
    }

    private void b(boolean z) {
        if (this.f23198i) {
            return;
        }
        this.f23195f.d(z ? 1 : 0);
        this.f23192c.a(this.f23195f);
    }

    private void b(int[] iArr) {
        CharSequence c2 = this.n.c(this.f23199j);
        if (TextUtils.isEmpty(c2)) {
            a(iArr);
        } else {
            this.f23192c.a();
            this.f23196g.a(c2);
        }
    }

    private void h() {
        com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.q.a.c.6
            AnonymousClass6() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c cVar = c.this;
                com.opos.mobad.n.d.h hVar = cVar.f23195f;
                if (hVar == null) {
                    return;
                }
                if (cVar.o >= 0) {
                    hVar.f(cVar.n.e(cVar.f23199j));
                }
                c cVar2 = c.this;
                cVar2.f23192c.a(cVar2.f23195f);
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x002f, code lost:
    
        if (r0.Q() == false) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void i() {
        /*
            r3 = this;
            com.opos.mobad.n.d.h r0 = r3.f23195f
            if (r0 != 0) goto L5
            goto L32
        L5:
            com.opos.mobad.q.a.l r0 = r3.n
            boolean r0 = r0.b()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L19
            int r0 = r3.r
            if (r0 != r2) goto L19
        L13:
            com.opos.mobad.n.d.h r0 = r3.f23195f
            r0.c(r1)
            goto L32
        L19:
            int r0 = r3.r
            if (r0 != r2) goto L23
        L1d:
            com.opos.mobad.n.d.h r0 = r3.f23195f
            r0.c(r2)
            goto L32
        L23:
            r2 = 2
            if (r0 != r2) goto L27
            goto L13
        L27:
            com.opos.mobad.model.data.AdItemData r0 = r3.f23193d
            if (r0 == 0) goto L13
            boolean r0 = r0.Q()
            if (r0 == 0) goto L13
            goto L1d
        L32:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.q.a.c.i():void");
    }

    public void j() {
        if (this.f23198i || this.s) {
            com.opos.cmn.an.f.a.b("InteractivePresenter", "has complete not start");
        } else {
            this.f23192c.b();
        }
    }

    public void a() {
    }

    public void a(int i2) {
        this.r = i2;
        if (this.f23195f == null) {
            return;
        }
        i();
        this.f23192c.a(this.f23195f);
    }

    @Override // com.opos.mobad.q.a.m, com.opos.mobad.n.a.InterfaceC0458a
    public void a(int i2, String str) {
        super.a(i2, str);
        this.f23196g.b();
    }

    @Override // com.opos.mobad.q.a.m, com.opos.mobad.n.a.InterfaceC0458a
    public void a(long j2, long j3) {
        super.a(j2, j3);
        this.f23195f.d(2);
        this.f23195f.f(this.n.e(this.f23199j));
        this.f23192c.a(this.f23195f);
        this.f23198i = true;
    }

    public void a(Configuration configuration) {
    }

    @Override // com.opos.mobad.n.a.InterfaceC0458a
    public void a(View view, int[] iArr) {
        if (this.q != null) {
            this.f23192c.a();
            this.q.a(this.f23192c.c());
        }
    }

    @Override // com.opos.mobad.q.a.m, com.opos.mobad.n.a.InterfaceC0458a
    public void a(View view, int[] iArr, boolean z) {
        this.f23195f.d(!z ? 1 : 0);
        this.f23192c.a(this.f23195f);
    }

    public void a(AdItemData adItemData, String str) {
        this.n.a(adItemData, str);
        h();
    }

    protected void a(int[] iArr) {
        l(null, iArr);
    }

    public boolean a(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            b((int[]) null);
            return true;
        }
        if (i2 == 24) {
            a(false);
            return false;
        }
        if (i2 != 25) {
            return false;
        }
        a(true);
        return false;
    }

    @Override // com.opos.mobad.q.a.m
    protected boolean a(View view, int[] iArr, com.opos.mobad.cmn.a.b.a aVar) {
        return a(view, iArr, aVar, true);
    }

    protected boolean a(View view, int[] iArr, com.opos.mobad.cmn.a.b.a aVar, boolean z) {
        if (!z) {
            return super.a(view, iArr, aVar);
        }
        boolean a2 = super.a(view, iArr, aVar, new a.c() { // from class: com.opos.mobad.q.a.c.8
            AnonymousClass8() {
            }

            @Override // com.opos.mobad.cmn.a.a.c
            public void a(int i2) {
                if (i2 == 8) {
                    com.opos.mobad.n.a aVar2 = c.this.f23192c;
                    if (aVar2 instanceof f) {
                        ((f) aVar2).f();
                    }
                }
            }

            @Override // com.opos.mobad.cmn.a.a.c
            public void a(int i2, int i3) {
            }
        });
        if (a2 || aVar != com.opos.mobad.cmn.a.b.a.Video || this.f23198i) {
            return a2;
        }
        if (this.s) {
            this.f23192c.b();
        } else {
            this.f23192c.a();
        }
        this.s = !this.s;
        return a2;
    }

    public boolean a(AdItemData adItemData, MaterialData materialData, int i2, g gVar) {
        this.f23193d = adItemData;
        this.f23194e = materialData;
        this.f23197h = gVar;
        long u = materialData.u();
        int e2 = this.f23192c.e();
        com.opos.mobad.n.a aVar = this.k;
        a(adItemData, materialData, u, e2, aVar != null ? aVar.e() : 0);
        d(i2);
        if (System.currentTimeMillis() > adItemData.s()) {
            com.opos.cmn.an.f.a.b("InteractivePresenter", "exp time");
            this.l.a(10003);
            return false;
        }
        this.p = false;
        this.f23195f = com.opos.mobad.model.a.a(this.f23191b, adItemData, materialData, false);
        i();
        this.f23192c.a(this.f23195f);
        com.opos.mobad.n.a aVar2 = this.k;
        if (aVar2 != null) {
            aVar2.a(this.f23195f);
            this.k.c().setVisibility(8);
        }
        this.s = false;
        this.f23198i = false;
        return true;
    }

    @Override // com.opos.mobad.n.a.InterfaceC0458a
    public void b() {
        super.a(this.f23192c.c());
    }

    @Override // com.opos.mobad.q.a.m, com.opos.mobad.n.a.InterfaceC0458a
    public void b(int i2) {
        super.b(i2);
        this.f23196g.b();
    }

    @Override // com.opos.mobad.n.a.InterfaceC0458a
    public void b(View view, int[] iArr) {
        String str;
        com.opos.cmn.an.f.a.b("InteractivePresenter", "onAppSafeClick");
        Activity activity = this.f23190a;
        if (activity == null || activity.isFinishing()) {
            str = "illegal activity";
        } else {
            AppPrivacyData O = this.f23193d.O();
            if (O != null && !TextUtils.isEmpty(O.f21706b)) {
                this.f23192c.a();
                this.f23196g.a("隐私政策", O.f21706b, new e.b() { // from class: com.opos.mobad.q.a.c.4
                    AnonymousClass4() {
                    }

                    @Override // com.opos.mobad.o.d.e.b
                    public void a() {
                        c.this.j();
                    }
                });
                return;
            }
            str = "illegal url";
        }
        com.opos.cmn.an.f.a.a("InteractivePresenter", str);
    }

    public void b(AdItemData adItemData, String str) {
        this.n.b(adItemData, str);
        this.p = true;
        com.opos.mobad.n.d.h hVar = this.f23195f;
        if (hVar == null) {
            return;
        }
        hVar.d(com.opos.mobad.model.a.a(this.f23191b, this.f23194e, true));
        h();
    }

    @Override // com.opos.mobad.q.a.m
    public void c() {
        com.opos.cmn.an.f.a.b("InteractivePresenter", "destroy");
        super.c();
        com.opos.mobad.o.a.a aVar = this.q;
        if (aVar != null) {
            aVar.a();
        }
        com.opos.mobad.n.a aVar2 = this.f23192c;
        if (aVar2 != null) {
            aVar2.d();
        }
        d dVar = this.f23196g;
        if (dVar != null) {
            dVar.c();
        }
        com.opos.mobad.n.a aVar3 = this.k;
        if (aVar3 != null) {
            aVar3.d();
        }
    }

    @Override // com.opos.mobad.n.a.InterfaceC0458a
    public void c(View view, int[] iArr) {
        String str;
        com.opos.cmn.an.f.a.b("InteractivePresenter", "onAppPermissionClick");
        Activity activity = this.f23190a;
        if (activity == null || activity.isFinishing()) {
            str = "illegal activity";
        } else {
            AppPrivacyData O = this.f23193d.O();
            if (O != null && !TextUtils.isEmpty(O.f21705a)) {
                this.f23192c.a();
                this.f23196g.a("应用权限", O.f21705a, new e.b() { // from class: com.opos.mobad.q.a.c.5
                    AnonymousClass5() {
                    }

                    @Override // com.opos.mobad.o.d.e.b
                    public void a() {
                        c.this.j();
                    }
                });
                return;
            }
            str = "illegal url";
        }
        com.opos.cmn.an.f.a.a("InteractivePresenter", str);
    }

    public void d() {
    }

    @Override // com.opos.mobad.q.a.m, com.opos.mobad.n.a.InterfaceC0458a
    public void d(long j2, long j3) {
        super.d(j2, j3);
        this.f23199j = j3;
        h();
    }

    @Override // com.opos.mobad.q.a.m, com.opos.mobad.n.a.InterfaceC0458a
    public void d(View view, int[] iArr) {
        b(iArr);
    }

    protected void f() {
        a((int[]) null);
    }

    @Override // com.opos.mobad.q.a.m, com.opos.mobad.n.a.InterfaceC0458a
    public void f(View view, int[] iArr) {
        super.f(view, iArr);
        h();
    }

    @Override // com.opos.mobad.q.a.m, com.opos.mobad.n.a.InterfaceC0458a
    public void g(View view, int[] iArr) {
        super.g(view, iArr);
        h();
    }

    @Override // com.opos.mobad.q.a.m, com.opos.mobad.n.a.InterfaceC0458a
    public void h(View view, int[] iArr) {
        super.h(view, iArr);
        h();
    }

    @Override // com.opos.mobad.q.a.m, com.opos.mobad.n.a.InterfaceC0458a
    public void i(View view, int[] iArr) {
        int i2 = this.r;
        if (i2 == 1) {
            if (this.n.d()) {
                l(view, iArr);
            }
        } else if (i2 == 0) {
            com.opos.mobad.service.a.a().e();
        }
    }

    protected void l(View view, int[] iArr) {
        super.d(view, iArr);
        com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.q.a.c.7
            AnonymousClass7() {
            }

            @Override // java.lang.Runnable
            public void run() {
                g gVar = c.this.f23197h;
                if (gVar != null) {
                    gVar.a();
                }
            }
        });
    }
}
