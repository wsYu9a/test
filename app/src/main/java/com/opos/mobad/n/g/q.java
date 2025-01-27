package com.opos.mobad.n.g;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.opos.mobad.c.d.a;
import com.opos.mobad.n.a;
import com.opos.mobad.n.c.j;
import com.opos.mobad.n.g.af;
import com.opos.mobad.n.g.ag;

/* loaded from: classes4.dex */
public class q implements com.opos.mobad.n.a {

    /* renamed from: d */
    private int f22715d;

    /* renamed from: e */
    private Context f22716e;

    /* renamed from: f */
    private a.InterfaceC0458a f22717f;

    /* renamed from: g */
    private int f22718g;

    /* renamed from: h */
    private af f22719h;

    /* renamed from: i */
    private RelativeLayout f22720i;

    /* renamed from: j */
    private com.opos.mobad.n.c.h f22721j;
    private u k;
    private z l;
    private ag m;
    private com.opos.mobad.n.c.j n;
    private com.opos.mobad.c.a o;
    private com.opos.mobad.n.d.e q;

    /* renamed from: a */
    private volatile boolean f22712a = false;

    /* renamed from: b */
    private int f22713b = 256;

    /* renamed from: c */
    private int f22714c = 144;
    private boolean r = false;
    private Runnable s = new Runnable() { // from class: com.opos.mobad.n.g.q.1
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (q.this.f22712a) {
                return;
            }
            int g2 = q.this.m.g();
            int h2 = q.this.m.h();
            if (q.this.f22717f != null) {
                q.this.f22717f.d(g2, h2);
            }
            q.this.m.f();
            q.this.p.postDelayed(this, 500L);
        }
    };
    private Handler p = new Handler(Looper.getMainLooper());

    /* renamed from: com.opos.mobad.n.g.q$1 */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (q.this.f22712a) {
                return;
            }
            int g2 = q.this.m.g();
            int h2 = q.this.m.h();
            if (q.this.f22717f != null) {
                q.this.f22717f.d(g2, h2);
            }
            q.this.m.f();
            q.this.p.postDelayed(this, 500L);
        }
    }

    /* renamed from: com.opos.mobad.n.g.q$2 */
    class AnonymousClass2 implements af.a {
        AnonymousClass2() {
        }

        @Override // com.opos.mobad.n.g.af.a
        public void a(int i2) {
            q.this.m.a(i2);
        }
    }

    /* renamed from: com.opos.mobad.n.g.q$3 */
    class AnonymousClass3 extends com.opos.mobad.n.c.g {
        AnonymousClass3() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            if (q.this.f22717f != null) {
                q.this.f22717f.g(view, iArr);
            }
        }
    }

    /* renamed from: com.opos.mobad.n.g.q$4 */
    class AnonymousClass4 implements ag.a {
        AnonymousClass4() {
        }

        @Override // com.opos.mobad.n.g.ag.a
        public void a() {
            q.this.p.removeCallbacks(q.this.s);
            q.this.p.postDelayed(q.this.s, 500L);
        }

        @Override // com.opos.mobad.n.g.ag.a
        public void b() {
            q.this.p.removeCallbacks(q.this.s);
        }
    }

    /* renamed from: com.opos.mobad.n.g.q$5 */
    class AnonymousClass5 implements a.InterfaceC0428a {
        AnonymousClass5() {
        }

        @Override // com.opos.mobad.c.d.a.InterfaceC0428a
        public void a(boolean z) {
            if (q.this.q == null) {
                return;
            }
            if (z && !q.this.r) {
                q.this.r = true;
                q.this.k();
                if (q.this.f22717f != null) {
                    q.this.f22717f.b();
                }
            }
            com.opos.cmn.an.f.a.b("BlockBigImageVideo4", "BlockBigImageVideo4 onWindowVisibilityChanged：" + z);
            if (z) {
                q.this.m.d();
            } else {
                q.this.m.e();
            }
        }
    }

    private q(Context context, aj ajVar, int i2, com.opos.mobad.c.c.a aVar, com.opos.mobad.c.a aVar2) {
        this.f22716e = context;
        this.f22718g = i2;
        this.o = aVar2;
        f();
        a(ajVar, aVar);
        j();
    }

    public static q a(Context context, aj ajVar, int i2, com.opos.mobad.c.c.a aVar, com.opos.mobad.c.a aVar2) {
        return new q(context, ajVar, i2, aVar, aVar2);
    }

    private void a(com.opos.mobad.c.c.a aVar) {
        com.opos.mobad.n.c.h hVar = new com.opos.mobad.n.c.h(this.f22716e);
        this.f22721j = hVar;
        hVar.a(com.opos.cmn.an.h.f.a.a(this.f22716e, 14.0f));
        this.f22721j.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f22713b, this.f22714c);
        this.f22721j.setVisibility(4);
        this.f22720i.addView(this.f22721j, layoutParams);
        b(aVar);
        h();
        g();
    }

    private void a(com.opos.mobad.n.d.e eVar) {
        b(eVar);
        c(eVar);
        d(eVar);
    }

    private void a(aj ajVar, com.opos.mobad.c.c.a aVar) {
        if (ajVar == null) {
            ajVar = aj.a(this.f22716e);
        }
        Context context = this.f22716e;
        int i2 = ajVar.f22455a;
        int i3 = ajVar.f22456b;
        int i4 = this.f22713b;
        this.n = new com.opos.mobad.n.c.j(context, new j.a(i2, i3, i4, i4 / this.f22715d));
        this.f22720i = new RelativeLayout(this.f22716e);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.f22713b, -2);
        layoutParams.width = this.f22713b;
        layoutParams.height = -2;
        this.f22720i.setId(View.generateViewId());
        this.f22720i.setLayoutParams(layoutParams);
        this.f22720i.setVisibility(8);
        this.n.addView(this.f22720i, layoutParams);
        this.n.setLayoutParams(layoutParams);
        a(aVar);
        i();
        AnonymousClass3 anonymousClass3 = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.g.q.3
            AnonymousClass3() {
            }

            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (q.this.f22717f != null) {
                    q.this.f22717f.g(view, iArr);
                }
            }
        };
        this.f22720i.setOnClickListener(anonymousClass3);
        this.f22720i.setOnTouchListener(anonymousClass3);
    }

    private void b(com.opos.mobad.c.c.a aVar) {
        this.m = ag.a(this.f22716e, this.f22713b, this.f22714c, aVar);
        this.f22721j.addView(this.m, new RelativeLayout.LayoutParams(this.f22713b, this.f22714c));
        this.m.a(new ag.a() { // from class: com.opos.mobad.n.g.q.4
            AnonymousClass4() {
            }

            @Override // com.opos.mobad.n.g.ag.a
            public void a() {
                q.this.p.removeCallbacks(q.this.s);
                q.this.p.postDelayed(q.this.s, 500L);
            }

            @Override // com.opos.mobad.n.g.ag.a
            public void b() {
                q.this.p.removeCallbacks(q.this.s);
            }
        });
    }

    private void b(com.opos.mobad.n.d.e eVar) {
        this.k.a(eVar.l, eVar.f22074f);
    }

    private void c(com.opos.mobad.n.d.e eVar) {
        this.f22719h.a(eVar.r, eVar.s, eVar.f22077i, eVar.f22078j, eVar.k, eVar.B);
    }

    private void d(com.opos.mobad.n.d.e eVar) {
        z zVar;
        com.opos.mobad.n.d.a aVar = eVar.v;
        if (aVar == null || TextUtils.isEmpty(aVar.f22065a) || TextUtils.isEmpty(aVar.f22066b) || (zVar = this.l) == null) {
            return;
        }
        zVar.setVisibility(0);
        this.l.a(aVar.f22065a, aVar.f22066b);
    }

    private void f() {
        this.f22713b = com.opos.cmn.an.h.f.a.a(this.f22716e, 256.0f);
        int a2 = com.opos.cmn.an.h.f.a.a(this.f22716e, 144.0f);
        this.f22714c = a2;
        this.f22715d = a2 + com.opos.cmn.an.h.f.a.a(this.f22716e, 24.0f);
    }

    private void g() {
        u a2 = u.a(this.f22716e);
        this.k = a2;
        a2.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f22713b, com.opos.cmn.an.h.f.a.a(this.f22716e, 26.0f));
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f22716e, 12.0f);
        this.k.setVisibility(4);
        this.f22721j.addView(this.k, layoutParams);
    }

    private void h() {
        this.f22719h = af.a(this.f22716e, true);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f22713b, -2);
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f22716e, 12.0f);
        layoutParams.addRule(12);
        this.f22719h.setVisibility(4);
        this.f22721j.addView(this.f22719h, layoutParams);
    }

    private void i() {
        this.l = z.b(this.f22716e);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f22713b, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(3, this.f22721j.getId());
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f22716e, 10.0f);
        this.l.setGravity(1);
        this.l.setVisibility(4);
        this.f22720i.addView(this.l, layoutParams);
    }

    private void j() {
        com.opos.mobad.c.d.a aVar = new com.opos.mobad.c.d.a(this.f22716e);
        aVar.a(new a.InterfaceC0428a() { // from class: com.opos.mobad.n.g.q.5
            AnonymousClass5() {
            }

            @Override // com.opos.mobad.c.d.a.InterfaceC0428a
            public void a(boolean z) {
                if (q.this.q == null) {
                    return;
                }
                if (z && !q.this.r) {
                    q.this.r = true;
                    q.this.k();
                    if (q.this.f22717f != null) {
                        q.this.f22717f.b();
                    }
                }
                com.opos.cmn.an.f.a.b("BlockBigImageVideo4", "BlockBigImageVideo4 onWindowVisibilityChanged：" + z);
                if (z) {
                    q.this.m.d();
                } else {
                    q.this.m.e();
                }
            }
        });
        this.f22720i.addView(aVar, new RelativeLayout.LayoutParams(0, 0));
    }

    public void k() {
        this.f22721j.setVisibility(0);
        this.k.setVisibility(0);
        this.f22719h.setVisibility(0);
    }

    @Override // com.opos.mobad.n.a
    public void a() {
        if (!this.f22712a) {
            this.m.a();
            return;
        }
        com.opos.cmn.an.f.a.b("BlockBigImageVideo4", "current state has stop mDestroy =" + this.f22712a);
    }

    @Override // com.opos.mobad.n.a
    public void a(a.InterfaceC0458a interfaceC0458a) {
        this.f22717f = interfaceC0458a;
        this.l.a(interfaceC0458a);
        this.k.a(interfaceC0458a);
        this.f22719h.a(interfaceC0458a);
        this.m.a(interfaceC0458a);
        this.f22719h.a(new af.a() { // from class: com.opos.mobad.n.g.q.2
            AnonymousClass2() {
            }

            @Override // com.opos.mobad.n.g.af.a
            public void a(int i2) {
                q.this.m.a(i2);
            }
        });
    }

    @Override // com.opos.mobad.n.a
    public void a(com.opos.mobad.n.d.h hVar) {
        a.InterfaceC0458a interfaceC0458a;
        com.opos.mobad.n.d.e b2 = hVar.b();
        if (b2 == null) {
            com.opos.cmn.an.f.a.d("", "render with data null");
            a.InterfaceC0458a interfaceC0458a2 = this.f22717f;
            if (interfaceC0458a2 != null) {
                interfaceC0458a2.b(1);
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(b2.f22079a.f22084a) && this.q == null) {
            this.m.a(b2);
        }
        if (this.q == null && (interfaceC0458a = this.f22717f) != null) {
            interfaceC0458a.e();
        }
        this.q = b2;
        com.opos.mobad.n.c.j jVar = this.n;
        if (jVar != null && jVar.getVisibility() != 0) {
            this.n.setVisibility(0);
        }
        RelativeLayout relativeLayout = this.f22720i;
        if (relativeLayout != null && relativeLayout.getVisibility() != 0) {
            this.f22720i.setVisibility(0);
        }
        a(b2);
    }

    @Override // com.opos.mobad.n.a
    public void b() {
        com.opos.cmn.an.f.a.b("BlockBigImageVideo4", "start countdown...");
        if (!this.f22712a) {
            this.m.b();
            return;
        }
        com.opos.cmn.an.f.a.b("BlockBigImageVideo4", "error state mDestroy " + this.f22712a);
    }

    @Override // com.opos.mobad.n.a
    public View c() {
        return this.n;
    }

    @Override // com.opos.mobad.n.a
    public void d() {
        com.opos.cmn.an.f.a.b("BlockBigImageVideo4", "destroy");
        this.f22712a = true;
        this.m.c();
        this.q = null;
        this.p.removeCallbacks(this.s);
        com.opos.mobad.n.c.j jVar = this.n;
        if (jVar != null) {
            jVar.removeAllViews();
        }
    }

    @Override // com.opos.mobad.n.a
    public int e() {
        return this.f22718g;
    }
}
