package com.opos.mobad.n.g;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.c.d.a;
import com.opos.mobad.n.a;
import com.opos.mobad.n.c.j;
import com.opos.mobad.n.g.af;
import com.opos.mobad.n.g.ag;

/* loaded from: classes4.dex */
public class k implements com.opos.mobad.n.a {

    /* renamed from: b */
    private int f22619b;

    /* renamed from: c */
    private int f22620c;

    /* renamed from: d */
    private int f22621d;

    /* renamed from: e */
    private int f22622e;

    /* renamed from: g */
    private Context f22624g;

    /* renamed from: h */
    private a.InterfaceC0458a f22625h;

    /* renamed from: i */
    private int f22626i;

    /* renamed from: j */
    private af f22627j;
    private com.opos.mobad.n.c.h k;
    private RelativeLayout l;
    private t m;
    private z n;
    private RelativeLayout o;
    private ag p;
    private com.opos.mobad.n.c.j q;
    private com.opos.mobad.c.a r;
    private com.opos.mobad.n.d.e t;

    /* renamed from: a */
    private volatile boolean f22618a = false;

    /* renamed from: f */
    private int f22623f = 64;
    private boolean u = false;
    private Runnable v = new Runnable() { // from class: com.opos.mobad.n.g.k.1
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (k.this.f22618a) {
                return;
            }
            int g2 = k.this.p.g();
            int h2 = k.this.p.h();
            if (k.this.f22625h != null) {
                k.this.f22625h.d(g2, h2);
            }
            k.this.p.f();
            k.this.s.postDelayed(this, 500L);
        }
    };
    private Handler s = new Handler(Looper.getMainLooper());

    /* renamed from: com.opos.mobad.n.g.k$1 */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (k.this.f22618a) {
                return;
            }
            int g2 = k.this.p.g();
            int h2 = k.this.p.h();
            if (k.this.f22625h != null) {
                k.this.f22625h.d(g2, h2);
            }
            k.this.p.f();
            k.this.s.postDelayed(this, 500L);
        }
    }

    /* renamed from: com.opos.mobad.n.g.k$2 */
    class AnonymousClass2 implements af.a {
        AnonymousClass2() {
        }

        @Override // com.opos.mobad.n.g.af.a
        public void a(int i2) {
            k.this.p.a(i2);
        }
    }

    /* renamed from: com.opos.mobad.n.g.k$3 */
    class AnonymousClass3 extends com.opos.mobad.n.c.g {
        AnonymousClass3() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            if (k.this.f22625h != null) {
                k.this.f22625h.g(view, iArr);
            }
        }
    }

    /* renamed from: com.opos.mobad.n.g.k$4 */
    class AnonymousClass4 implements ag.a {
        AnonymousClass4() {
        }

        @Override // com.opos.mobad.n.g.ag.a
        public void a() {
            k.this.s.removeCallbacks(k.this.v);
            k.this.s.postDelayed(k.this.v, 500L);
        }

        @Override // com.opos.mobad.n.g.ag.a
        public void b() {
            k.this.s.removeCallbacks(k.this.v);
        }
    }

    /* renamed from: com.opos.mobad.n.g.k$5 */
    class AnonymousClass5 implements a.InterfaceC0428a {
        AnonymousClass5() {
        }

        @Override // com.opos.mobad.c.d.a.InterfaceC0428a
        public void a(boolean z) {
            if (k.this.t == null) {
                return;
            }
            if (z && !k.this.u) {
                k.this.u = true;
                k.this.l();
                if (k.this.f22625h != null) {
                    k.this.f22625h.b();
                }
            }
            if (z) {
                k.this.p.d();
            } else {
                k.this.p.e();
            }
        }
    }

    private k(Context context, aj ajVar, int i2, com.opos.mobad.c.c.a aVar, com.opos.mobad.c.a aVar2) {
        this.f22624g = context;
        this.f22626i = i2;
        this.r = aVar2;
        f();
        a(ajVar, aVar);
        k();
    }

    public static k a(Context context, aj ajVar, int i2, com.opos.mobad.c.c.a aVar, com.opos.mobad.c.a aVar2) {
        return new k(context, ajVar, i2, aVar, aVar2);
    }

    private void a(com.opos.mobad.c.c.a aVar) {
        RelativeLayout relativeLayout = new RelativeLayout(this.f22624g);
        this.l = relativeLayout;
        relativeLayout.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f22619b, this.f22620c);
        this.l.setVisibility(4);
        this.k.addView(this.l, layoutParams);
        b(aVar);
        h();
        i();
    }

    private void a(com.opos.mobad.n.d.e eVar) {
        b(eVar);
        c(eVar);
        d(eVar);
    }

    private void a(aj ajVar, com.opos.mobad.c.c.a aVar) {
        if (ajVar == null) {
            ajVar = aj.a(this.f22624g);
        }
        Context context = this.f22624g;
        int i2 = ajVar.f22455a;
        int i3 = ajVar.f22456b;
        int i4 = this.f22619b;
        this.q = new com.opos.mobad.n.c.j(context, new j.a(i2, i3, i4, i4 / this.f22621d));
        com.opos.mobad.n.c.h hVar = new com.opos.mobad.n.c.h(this.f22624g);
        this.k = hVar;
        hVar.a(com.opos.cmn.an.h.f.a.a(this.f22624g, 14.0f));
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.f22619b, this.f22621d);
        layoutParams.width = this.f22619b;
        layoutParams.height = this.f22621d;
        this.k.setId(View.generateViewId());
        this.k.setBackgroundColor(this.f22624g.getResources().getColor(R.color.opos_mobad_root_bg_color));
        this.k.setLayoutParams(layoutParams);
        this.k.setVisibility(8);
        this.q.addView(this.k, layoutParams);
        this.q.setLayoutParams(layoutParams);
        a(aVar);
        j();
        AnonymousClass3 anonymousClass3 = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.g.k.3
            AnonymousClass3() {
            }

            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (k.this.f22625h != null) {
                    k.this.f22625h.g(view, iArr);
                }
            }
        };
        this.k.setOnClickListener(anonymousClass3);
        this.k.setOnTouchListener(anonymousClass3);
    }

    private void b(com.opos.mobad.c.c.a aVar) {
        this.p = ag.a(this.f22624g, this.f22619b, this.f22620c, aVar);
        this.l.addView(this.p, new RelativeLayout.LayoutParams(this.f22619b, this.f22620c));
        this.p.a(new ag.a() { // from class: com.opos.mobad.n.g.k.4
            AnonymousClass4() {
            }

            @Override // com.opos.mobad.n.g.ag.a
            public void a() {
                k.this.s.removeCallbacks(k.this.v);
                k.this.s.postDelayed(k.this.v, 500L);
            }

            @Override // com.opos.mobad.n.g.ag.a
            public void b() {
                k.this.s.removeCallbacks(k.this.v);
            }
        });
    }

    private void b(com.opos.mobad.n.d.e eVar) {
        this.m.a(eVar.m, eVar.l, eVar.f22074f, eVar.f22073e, this.r, this.f22618a);
    }

    private void c(com.opos.mobad.n.d.e eVar) {
        this.f22627j.a(eVar.r, eVar.s, eVar.f22077i, eVar.f22078j, eVar.k, eVar.B);
    }

    private void d(com.opos.mobad.n.d.e eVar) {
        com.opos.mobad.n.d.a aVar = eVar.v;
        if (aVar == null || TextUtils.isEmpty(aVar.f22065a) || TextUtils.isEmpty(aVar.f22066b)) {
            return;
        }
        RelativeLayout relativeLayout = this.o;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
        z zVar = this.n;
        if (zVar != null) {
            zVar.setVisibility(0);
            this.n.a(aVar.f22065a, aVar.f22066b);
        }
    }

    private void f() {
        this.f22619b = com.opos.cmn.an.h.f.a.a(this.f22624g, 256.0f);
        this.f22620c = com.opos.cmn.an.h.f.a.a(this.f22624g, 144.0f);
        this.f22621d = com.opos.cmn.an.h.f.a.a(this.f22624g, 218.0f);
        this.f22622e = this.f22619b;
        this.f22623f = com.opos.cmn.an.h.f.a.a(this.f22624g, 64.0f);
    }

    private void g() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f22624g);
        this.o = relativeLayout;
        relativeLayout.setBackgroundResource(R.drawable.opos_mobad_drawable_shape_gradient);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f22619b, this.f22623f);
        this.o.setVisibility(4);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f22624g, 2.0f);
        this.l.addView(this.o, layoutParams);
    }

    private void h() {
        this.f22627j = af.a(this.f22624g, true);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f22619b, -2);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f22624g, 16.0f);
        this.f22627j.setVisibility(4);
        this.l.addView(this.f22627j, layoutParams);
    }

    private void i() {
        g();
        this.n = z.a(this.f22624g);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f22619b, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f22624g, 10.0f);
        this.n.setGravity(1);
        this.n.setVisibility(4);
        this.l.addView(this.n, layoutParams);
    }

    private void j() {
        t a2 = t.a(this.f22624g);
        this.m = a2;
        a2.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f22622e, com.opos.cmn.an.h.f.a.a(this.f22624g, 74.0f));
        RelativeLayout relativeLayout = this.l;
        if (relativeLayout != null) {
            layoutParams.addRule(3, relativeLayout.getId());
        }
        this.m.setVisibility(4);
        this.k.addView(this.m, layoutParams);
    }

    private void k() {
        com.opos.mobad.c.d.a aVar = new com.opos.mobad.c.d.a(this.f22624g);
        aVar.a(new a.InterfaceC0428a() { // from class: com.opos.mobad.n.g.k.5
            AnonymousClass5() {
            }

            @Override // com.opos.mobad.c.d.a.InterfaceC0428a
            public void a(boolean z) {
                if (k.this.t == null) {
                    return;
                }
                if (z && !k.this.u) {
                    k.this.u = true;
                    k.this.l();
                    if (k.this.f22625h != null) {
                        k.this.f22625h.b();
                    }
                }
                if (z) {
                    k.this.p.d();
                } else {
                    k.this.p.e();
                }
            }
        });
        this.k.addView(aVar, new RelativeLayout.LayoutParams(0, 0));
    }

    public void l() {
        this.l.setVisibility(0);
        this.m.setVisibility(0);
        this.f22627j.setVisibility(0);
    }

    @Override // com.opos.mobad.n.a
    public void a() {
        if (!this.f22618a) {
            this.p.a();
            return;
        }
        com.opos.cmn.an.f.a.b("BlockBigImageVideo1", "current state has stop mDestroy = " + this.f22618a);
    }

    @Override // com.opos.mobad.n.a
    public void a(a.InterfaceC0458a interfaceC0458a) {
        this.f22625h = interfaceC0458a;
        this.n.a(interfaceC0458a);
        this.m.a(interfaceC0458a);
        this.f22627j.a(interfaceC0458a);
        this.p.a(interfaceC0458a);
        this.f22627j.a(new af.a() { // from class: com.opos.mobad.n.g.k.2
            AnonymousClass2() {
            }

            @Override // com.opos.mobad.n.g.af.a
            public void a(int i2) {
                k.this.p.a(i2);
            }
        });
    }

    @Override // com.opos.mobad.n.a
    public void a(com.opos.mobad.n.d.h hVar) {
        a.InterfaceC0458a interfaceC0458a;
        com.opos.mobad.n.d.e b2 = hVar.b();
        if (b2 == null) {
            com.opos.cmn.an.f.a.d("", "render with data null");
            a.InterfaceC0458a interfaceC0458a2 = this.f22625h;
            if (interfaceC0458a2 != null) {
                interfaceC0458a2.b(1);
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(b2.f22079a.f22084a) && this.t == null) {
            this.p.a(b2);
        }
        if (this.t == null && (interfaceC0458a = this.f22625h) != null) {
            interfaceC0458a.e();
        }
        this.t = b2;
        com.opos.mobad.n.c.j jVar = this.q;
        if (jVar != null && jVar.getVisibility() != 0) {
            this.q.setVisibility(0);
        }
        com.opos.mobad.n.c.h hVar2 = this.k;
        if (hVar2 != null && hVar2.getVisibility() != 0) {
            this.k.setVisibility(0);
        }
        a(b2);
    }

    @Override // com.opos.mobad.n.a
    public void b() {
        com.opos.cmn.an.f.a.b("BlockBigImageVideo1", "start countdown...");
        if (!this.f22618a) {
            this.p.b();
            return;
        }
        com.opos.cmn.an.f.a.b("BlockBigImageVideo1", "error state mDestroy " + this.f22618a);
    }

    @Override // com.opos.mobad.n.a
    public View c() {
        return this.q;
    }

    @Override // com.opos.mobad.n.a
    public void d() {
        com.opos.cmn.an.f.a.b("BlockBigImageVideo1", "destroy");
        this.f22618a = true;
        this.p.c();
        this.t = null;
        this.s.removeCallbacks(this.v);
        com.opos.mobad.n.c.j jVar = this.q;
        if (jVar != null) {
            jVar.removeAllViews();
        }
    }

    @Override // com.opos.mobad.n.a
    public int e() {
        return this.f22626i;
    }
}
