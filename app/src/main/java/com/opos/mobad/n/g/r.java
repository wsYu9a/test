package com.opos.mobad.n.g;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.c.d.a;
import com.opos.mobad.n.a;
import com.opos.mobad.n.c.j;
import com.opos.mobad.n.g.af;
import com.opos.mobad.n.g.ag;

/* loaded from: classes4.dex */
public class r implements com.opos.mobad.n.a {

    /* renamed from: d */
    private int f22730d;

    /* renamed from: e */
    private int f22731e;

    /* renamed from: f */
    private Context f22732f;

    /* renamed from: g */
    private a.InterfaceC0458a f22733g;

    /* renamed from: h */
    private int f22734h;

    /* renamed from: i */
    private af f22735i;

    /* renamed from: j */
    private com.opos.mobad.n.c.h f22736j;
    private RelativeLayout k;
    private RelativeLayout l;
    private ag m;
    private TextView n;
    private com.opos.mobad.n.c.j o;
    private com.opos.mobad.c.a p;
    private com.opos.mobad.n.d.e r;

    /* renamed from: a */
    private volatile boolean f22727a = false;

    /* renamed from: b */
    private int f22728b = 256;

    /* renamed from: c */
    private int f22729c = 144;
    private boolean s = false;
    private Runnable t = new Runnable() { // from class: com.opos.mobad.n.g.r.1
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (r.this.f22727a) {
                return;
            }
            int g2 = r.this.m.g();
            int h2 = r.this.m.h();
            if (r.this.f22733g != null) {
                r.this.f22733g.d(g2, h2);
            }
            r.this.m.f();
            r.this.q.postDelayed(this, 500L);
        }
    };
    private Handler q = new Handler(Looper.getMainLooper());

    /* renamed from: com.opos.mobad.n.g.r$1 */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (r.this.f22727a) {
                return;
            }
            int g2 = r.this.m.g();
            int h2 = r.this.m.h();
            if (r.this.f22733g != null) {
                r.this.f22733g.d(g2, h2);
            }
            r.this.m.f();
            r.this.q.postDelayed(this, 500L);
        }
    }

    /* renamed from: com.opos.mobad.n.g.r$2 */
    class AnonymousClass2 implements af.a {
        AnonymousClass2() {
        }

        @Override // com.opos.mobad.n.g.af.a
        public void a(int i2) {
            r.this.m.a(i2);
        }
    }

    /* renamed from: com.opos.mobad.n.g.r$3 */
    class AnonymousClass3 extends com.opos.mobad.n.c.g {
        AnonymousClass3() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            if (r.this.f22733g != null) {
                r.this.f22733g.g(view, iArr);
            }
        }
    }

    /* renamed from: com.opos.mobad.n.g.r$4 */
    class AnonymousClass4 implements ag.a {
        AnonymousClass4() {
        }

        @Override // com.opos.mobad.n.g.ag.a
        public void a() {
            r.this.q.removeCallbacks(r.this.t);
            r.this.q.postDelayed(r.this.t, 500L);
        }

        @Override // com.opos.mobad.n.g.ag.a
        public void b() {
            r.this.q.removeCallbacks(r.this.t);
        }
    }

    /* renamed from: com.opos.mobad.n.g.r$5 */
    class AnonymousClass5 implements a.InterfaceC0428a {
        AnonymousClass5() {
        }

        @Override // com.opos.mobad.c.d.a.InterfaceC0428a
        public void a(boolean z) {
            if (r.this.r == null) {
                return;
            }
            if (z && !r.this.s) {
                r.this.s = true;
                r.this.j();
                if (r.this.f22733g != null) {
                    r.this.f22733g.b();
                }
            }
            com.opos.cmn.an.f.a.b("BlockBigImageVideo5", "BlockBigImageVideo5 onWindowVisibilityChanged：" + z);
            if (z) {
                r.this.m.d();
            } else {
                r.this.m.e();
            }
        }
    }

    private r(Context context, aj ajVar, int i2, com.opos.mobad.c.c.a aVar, com.opos.mobad.c.a aVar2) {
        this.f22732f = context;
        this.f22734h = i2;
        this.p = aVar2;
        f();
        a(ajVar, aVar);
        i();
    }

    public static r a(Context context, aj ajVar, int i2, com.opos.mobad.c.c.a aVar, com.opos.mobad.c.a aVar2) {
        return new r(context, ajVar, i2, aVar, aVar2);
    }

    private void a(com.opos.mobad.c.c.a aVar) {
        RelativeLayout relativeLayout = new RelativeLayout(this.f22732f);
        this.k = relativeLayout;
        relativeLayout.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f22728b, this.f22729c);
        this.k.setVisibility(4);
        RelativeLayout relativeLayout2 = this.l;
        if (relativeLayout2 != null) {
            layoutParams.addRule(3, relativeLayout2.getId());
        }
        this.f22736j.addView(this.k, layoutParams);
        b(aVar);
        g();
    }

    private void a(com.opos.mobad.n.d.e eVar) {
        b(eVar);
        c(eVar);
        d(eVar);
    }

    private void a(aj ajVar, com.opos.mobad.c.c.a aVar) {
        if (ajVar == null) {
            ajVar = aj.a(this.f22732f);
        }
        Context context = this.f22732f;
        int i2 = ajVar.f22455a;
        int i3 = ajVar.f22456b;
        int i4 = this.f22728b;
        this.o = new com.opos.mobad.n.c.j(context, new j.a(i2, i3, i4, i4 / this.f22730d));
        com.opos.mobad.n.c.h hVar = new com.opos.mobad.n.c.h(this.f22732f);
        this.f22736j = hVar;
        hVar.a(com.opos.cmn.an.h.f.a.a(this.f22732f, 14.0f));
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.f22728b, this.f22730d);
        layoutParams.width = this.f22728b;
        layoutParams.height = this.f22730d;
        this.f22736j.setId(View.generateViewId());
        this.f22736j.setBackgroundColor(this.f22732f.getResources().getColor(R.color.opos_mobad_root_bg_color));
        this.f22736j.setLayoutParams(layoutParams);
        this.f22736j.setVisibility(8);
        this.o.addView(this.f22736j, layoutParams);
        this.o.setLayoutParams(layoutParams);
        h();
        a(aVar);
        AnonymousClass3 anonymousClass3 = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.g.r.3
            AnonymousClass3() {
            }

            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (r.this.f22733g != null) {
                    r.this.f22733g.g(view, iArr);
                }
            }
        };
        this.f22736j.setOnClickListener(anonymousClass3);
        this.f22736j.setOnTouchListener(anonymousClass3);
    }

    private void b(com.opos.mobad.c.c.a aVar) {
        this.m = ag.a(this.f22732f, this.f22728b, this.f22729c, aVar);
        this.k.addView(this.m, new RelativeLayout.LayoutParams(this.f22728b, this.f22729c));
        this.m.a(new ag.a() { // from class: com.opos.mobad.n.g.r.4
            AnonymousClass4() {
            }

            @Override // com.opos.mobad.n.g.ag.a
            public void a() {
                r.this.q.removeCallbacks(r.this.t);
                r.this.q.postDelayed(r.this.t, 500L);
            }

            @Override // com.opos.mobad.n.g.ag.a
            public void b() {
                r.this.q.removeCallbacks(r.this.t);
            }
        });
    }

    private void b(com.opos.mobad.n.d.e eVar) {
        String str = eVar.f22074f;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.n.setText(str);
    }

    private void c(com.opos.mobad.n.d.e eVar) {
        this.f22735i.a(eVar.r, eVar.s, eVar.f22077i, eVar.f22078j, eVar.k, eVar.B);
    }

    private void d(com.opos.mobad.n.d.e eVar) {
        com.opos.mobad.n.d.a aVar = eVar.v;
        if (aVar == null || TextUtils.isEmpty(aVar.f22065a)) {
            return;
        }
        TextUtils.isEmpty(aVar.f22066b);
    }

    private void f() {
        this.f22728b = com.opos.cmn.an.h.f.a.a(this.f22732f, 256.0f);
        this.f22729c = com.opos.cmn.an.h.f.a.a(this.f22732f, 144.0f);
        this.f22730d = com.opos.cmn.an.h.f.a.a(this.f22732f, 188.0f);
        this.f22731e = this.f22728b;
    }

    private void g() {
        this.f22735i = af.a(this.f22732f, true);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f22728b, -2);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f22732f, 16.0f);
        this.f22735i.setVisibility(4);
        this.k.addView(this.f22735i, layoutParams);
    }

    private void h() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f22732f);
        this.l = relativeLayout;
        relativeLayout.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f22731e, com.opos.cmn.an.h.f.a.a(this.f22732f, 44.0f));
        this.l.setVisibility(4);
        TextView textView = new TextView(this.f22732f);
        this.n = textView;
        textView.setTextColor(this.f22732f.getResources().getColor(R.color.opos_mobad_title_color));
        this.n.setTextSize(1, 12.0f);
        this.n.setGravity(17);
        this.n.setMaxLines(1);
        this.n.setEllipsize(TextUtils.TruncateAt.END);
        this.n.setSingleLine();
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        int a2 = com.opos.cmn.an.h.f.a.a(this.f22732f, 16.0f);
        layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(this.f22732f, 16.0f);
        layoutParams2.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f22732f, 12.0f);
        layoutParams2.leftMargin = a2;
        layoutParams2.rightMargin = a2;
        this.l.addView(this.n, layoutParams2);
        this.f22736j.addView(this.l, layoutParams);
    }

    private void i() {
        com.opos.mobad.c.d.a aVar = new com.opos.mobad.c.d.a(this.f22732f);
        aVar.a(new a.InterfaceC0428a() { // from class: com.opos.mobad.n.g.r.5
            AnonymousClass5() {
            }

            @Override // com.opos.mobad.c.d.a.InterfaceC0428a
            public void a(boolean z) {
                if (r.this.r == null) {
                    return;
                }
                if (z && !r.this.s) {
                    r.this.s = true;
                    r.this.j();
                    if (r.this.f22733g != null) {
                        r.this.f22733g.b();
                    }
                }
                com.opos.cmn.an.f.a.b("BlockBigImageVideo5", "BlockBigImageVideo5 onWindowVisibilityChanged：" + z);
                if (z) {
                    r.this.m.d();
                } else {
                    r.this.m.e();
                }
            }
        });
        this.f22736j.addView(aVar, new RelativeLayout.LayoutParams(0, 0));
    }

    public void j() {
        this.k.setVisibility(0);
        this.l.setVisibility(0);
        this.f22735i.setVisibility(0);
    }

    @Override // com.opos.mobad.n.a
    public void a() {
        if (!this.f22727a) {
            this.m.a();
            return;
        }
        com.opos.cmn.an.f.a.b("BlockBigImageVideo5", "current state has stop mDestroy =" + this.f22727a);
    }

    @Override // com.opos.mobad.n.a
    public void a(a.InterfaceC0458a interfaceC0458a) {
        this.f22733g = interfaceC0458a;
        this.f22735i.a(interfaceC0458a);
        this.m.a(interfaceC0458a);
        this.f22735i.a(new af.a() { // from class: com.opos.mobad.n.g.r.2
            AnonymousClass2() {
            }

            @Override // com.opos.mobad.n.g.af.a
            public void a(int i2) {
                r.this.m.a(i2);
            }
        });
    }

    @Override // com.opos.mobad.n.a
    public void a(com.opos.mobad.n.d.h hVar) {
        a.InterfaceC0458a interfaceC0458a;
        com.opos.mobad.n.d.e b2 = hVar.b();
        if (b2 == null) {
            com.opos.cmn.an.f.a.d("", "render with data null");
            a.InterfaceC0458a interfaceC0458a2 = this.f22733g;
            if (interfaceC0458a2 != null) {
                interfaceC0458a2.b(1);
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(b2.f22079a.f22084a) && this.r == null) {
            this.m.a(b2);
        }
        if (this.r == null && (interfaceC0458a = this.f22733g) != null) {
            interfaceC0458a.e();
        }
        this.r = b2;
        com.opos.mobad.n.c.j jVar = this.o;
        if (jVar != null && jVar.getVisibility() != 0) {
            this.o.setVisibility(0);
        }
        com.opos.mobad.n.c.h hVar2 = this.f22736j;
        if (hVar2 != null && hVar2.getVisibility() != 0) {
            this.f22736j.setVisibility(0);
        }
        a(b2);
    }

    @Override // com.opos.mobad.n.a
    public void b() {
        com.opos.cmn.an.f.a.b("BlockBigImageVideo5", "start countdown...");
        if (!this.f22727a) {
            this.m.b();
            return;
        }
        com.opos.cmn.an.f.a.b("BlockBigImageVideo5", "error state mDestroy " + this.f22727a);
    }

    @Override // com.opos.mobad.n.a
    public View c() {
        return this.o;
    }

    @Override // com.opos.mobad.n.a
    public void d() {
        com.opos.cmn.an.f.a.b("BlockBigImageVideo5", "destroy");
        this.f22727a = true;
        this.m.c();
        this.r = null;
        this.q.removeCallbacks(this.t);
        com.opos.mobad.n.c.j jVar = this.o;
        if (jVar != null) {
            jVar.removeAllViews();
        }
    }

    @Override // com.opos.mobad.n.a
    public int e() {
        return this.f22734h;
    }
}
