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
import com.opos.mobad.n.g.ad;
import com.opos.mobad.n.g.ag;

/* loaded from: classes4.dex */
public class l implements com.opos.mobad.n.a {

    /* renamed from: b */
    private int f22634b;

    /* renamed from: c */
    private int f22635c;

    /* renamed from: d */
    private int f22636d;

    /* renamed from: f */
    private Context f22638f;

    /* renamed from: g */
    private a.InterfaceC0458a f22639g;

    /* renamed from: h */
    private int f22640h;

    /* renamed from: i */
    private ad f22641i;

    /* renamed from: j */
    private TextView f22642j;
    private com.opos.mobad.n.d.e k;
    private RelativeLayout l;
    private com.opos.mobad.n.c.h m;
    private com.opos.mobad.n.c.j n;
    private ag o;
    private ah p;
    private com.opos.mobad.c.a r;

    /* renamed from: a */
    private volatile boolean f22633a = false;

    /* renamed from: e */
    private int f22637e = 0;
    private boolean s = false;
    private Runnable t = new Runnable() { // from class: com.opos.mobad.n.g.l.1
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (l.this.f22633a) {
                return;
            }
            int g2 = l.this.o.g();
            int h2 = l.this.o.h();
            if (l.this.f22639g != null) {
                l.this.f22639g.d(g2, h2);
            }
            l.this.o.f();
            l.this.q.postDelayed(this, 500L);
        }
    };
    private Handler q = new Handler(Looper.getMainLooper());

    /* renamed from: com.opos.mobad.n.g.l$1 */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (l.this.f22633a) {
                return;
            }
            int g2 = l.this.o.g();
            int h2 = l.this.o.h();
            if (l.this.f22639g != null) {
                l.this.f22639g.d(g2, h2);
            }
            l.this.o.f();
            l.this.q.postDelayed(this, 500L);
        }
    }

    /* renamed from: com.opos.mobad.n.g.l$2 */
    class AnonymousClass2 implements ad.a {
        AnonymousClass2() {
        }

        @Override // com.opos.mobad.n.g.ad.a
        public void a(int i2) {
            l.this.o.a(i2);
        }
    }

    /* renamed from: com.opos.mobad.n.g.l$3 */
    class AnonymousClass3 extends com.opos.mobad.n.c.g {
        AnonymousClass3() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            if (l.this.f22639g != null) {
                l.this.f22639g.g(view, iArr);
            }
        }
    }

    /* renamed from: com.opos.mobad.n.g.l$4 */
    class AnonymousClass4 implements ag.a {
        AnonymousClass4() {
        }

        @Override // com.opos.mobad.n.g.ag.a
        public void a() {
            l.this.q.removeCallbacks(l.this.t);
            l.this.q.postDelayed(l.this.t, 500L);
        }

        @Override // com.opos.mobad.n.g.ag.a
        public void b() {
            l.this.q.removeCallbacks(l.this.t);
        }
    }

    /* renamed from: com.opos.mobad.n.g.l$5 */
    class AnonymousClass5 implements a.InterfaceC0428a {
        AnonymousClass5() {
        }

        @Override // com.opos.mobad.c.d.a.InterfaceC0428a
        public void a(boolean z) {
            if (l.this.k == null) {
                return;
            }
            if (z && !l.this.s) {
                l.this.s = true;
                l.this.i();
                if (l.this.f22639g != null) {
                    l.this.f22639g.b();
                }
            }
            com.opos.cmn.an.f.a.b("BlockBigImageVideo10", "BlockBigImageVideo10 onWindowVisibilityChanged：" + z);
            if (z) {
                l.this.o.d();
            } else {
                l.this.o.e();
            }
        }
    }

    private l(Context context, aj ajVar, int i2, com.opos.mobad.c.c.a aVar, com.opos.mobad.c.a aVar2) {
        this.f22638f = context;
        this.f22640h = i2;
        this.r = aVar2;
        f();
        a(ajVar, aVar);
        h();
    }

    public static l a(Context context, aj ajVar, int i2, com.opos.mobad.c.c.a aVar, com.opos.mobad.c.a aVar2) {
        return new l(context, ajVar, i2, aVar, aVar2);
    }

    private void a(com.opos.mobad.c.c.a aVar) {
        com.opos.mobad.n.c.h hVar = new com.opos.mobad.n.c.h(this.f22638f);
        this.m = hVar;
        hVar.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f22634b, this.f22635c);
        this.m.setVisibility(4);
        this.l.addView(this.m, layoutParams);
        g();
        com.opos.mobad.n.c.h hVar2 = new com.opos.mobad.n.c.h(this.f22638f);
        hVar2.a(com.opos.cmn.an.h.f.a.a(this.f22638f, 6.0f));
        hVar2.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.f22634b, this.f22637e);
        layoutParams2.addRule(3, this.f22642j.getId());
        layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(this.f22638f, 8.0f);
        this.m.addView(hVar2, layoutParams2);
        a(aVar, hVar2);
        b(hVar2);
        a(hVar2);
    }

    private void a(com.opos.mobad.c.c.a aVar, com.opos.mobad.n.c.h hVar) {
        this.o = ag.a(this.f22638f, this.f22634b, this.f22637e, aVar);
        hVar.addView(this.o, new RelativeLayout.LayoutParams(this.f22634b, this.f22637e));
        this.o.a(new ag.a() { // from class: com.opos.mobad.n.g.l.4
            AnonymousClass4() {
            }

            @Override // com.opos.mobad.n.g.ag.a
            public void a() {
                l.this.q.removeCallbacks(l.this.t);
                l.this.q.postDelayed(l.this.t, 500L);
            }

            @Override // com.opos.mobad.n.g.ag.a
            public void b() {
                l.this.q.removeCallbacks(l.this.t);
            }
        });
    }

    private void a(com.opos.mobad.n.c.h hVar) {
        this.f22641i = ad.a(this.f22638f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f22634b, -2);
        layoutParams.addRule(3, hVar.getId());
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f22638f, 6.0f);
        this.m.addView(this.f22641i, layoutParams);
    }

    private void a(com.opos.mobad.n.d.d dVar) {
        String str = dVar.f22073e;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f22642j.setText(str);
    }

    private void a(com.opos.mobad.n.d.e eVar) {
        this.f22641i.a(eVar.r, eVar.s, eVar.f22077i, eVar.f22078j, eVar.k, eVar.B, eVar.f22074f);
        a((com.opos.mobad.n.d.d) eVar);
        this.p.a(eVar.B);
    }

    private void a(aj ajVar, com.opos.mobad.c.c.a aVar) {
        if (ajVar == null) {
            ajVar = aj.a(this.f22638f);
        }
        Context context = this.f22638f;
        int i2 = ajVar.f22455a;
        int i3 = ajVar.f22456b;
        int i4 = this.f22634b;
        this.n = new com.opos.mobad.n.c.j(context, new j.a(i2, i3, i4, i4 / this.f22636d));
        this.l = new RelativeLayout(this.f22638f);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.f22634b, -2);
        layoutParams.width = this.f22634b;
        layoutParams.height = -2;
        this.l.setId(View.generateViewId());
        this.l.setLayoutParams(layoutParams);
        this.l.setVisibility(8);
        this.n.addView(this.l, layoutParams);
        this.n.setLayoutParams(layoutParams);
        a(aVar);
        AnonymousClass3 anonymousClass3 = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.g.l.3
            AnonymousClass3() {
            }

            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (l.this.f22639g != null) {
                    l.this.f22639g.g(view, iArr);
                }
            }
        };
        this.l.setOnClickListener(anonymousClass3);
        this.l.setOnTouchListener(anonymousClass3);
    }

    private void b(com.opos.mobad.n.c.h hVar) {
        this.p = ah.a(this.f22638f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f22638f, 12.0f);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.f22638f, 10.0f);
        hVar.addView(this.p, layoutParams);
    }

    private void f() {
        this.f22634b = com.opos.cmn.an.h.f.a.a(this.f22638f, 320.0f);
        this.f22635c = com.opos.cmn.an.h.f.a.a(this.f22638f, 258.0f);
        this.f22637e = com.opos.cmn.an.h.f.a.a(this.f22638f, 180.0f);
        this.f22636d = this.f22635c;
    }

    private void g() {
        TextView textView = new TextView(this.f22638f);
        this.f22642j = textView;
        textView.setId(View.generateViewId());
        this.f22642j.setTextColor(this.f22638f.getResources().getColor(R.color.opos_mobad_small_top_title_color));
        this.f22642j.setTextSize(1, 17.0f);
        this.f22642j.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.f22642j.setMaxLines(2);
        this.m.addView(this.f22642j, new RelativeLayout.LayoutParams(-1, -2));
    }

    private void h() {
        com.opos.mobad.c.d.a aVar = new com.opos.mobad.c.d.a(this.f22638f);
        aVar.a(new a.InterfaceC0428a() { // from class: com.opos.mobad.n.g.l.5
            AnonymousClass5() {
            }

            @Override // com.opos.mobad.c.d.a.InterfaceC0428a
            public void a(boolean z) {
                if (l.this.k == null) {
                    return;
                }
                if (z && !l.this.s) {
                    l.this.s = true;
                    l.this.i();
                    if (l.this.f22639g != null) {
                        l.this.f22639g.b();
                    }
                }
                com.opos.cmn.an.f.a.b("BlockBigImageVideo10", "BlockBigImageVideo10 onWindowVisibilityChanged：" + z);
                if (z) {
                    l.this.o.d();
                } else {
                    l.this.o.e();
                }
            }
        });
        this.l.addView(aVar, new RelativeLayout.LayoutParams(0, 0));
    }

    public void i() {
        this.m.setVisibility(0);
    }

    @Override // com.opos.mobad.n.a
    public void a() {
        if (!this.f22633a) {
            this.o.a();
            return;
        }
        com.opos.cmn.an.f.a.b("BlockBigImageVideo10", "current state has stop mDestroy =" + this.f22633a);
    }

    @Override // com.opos.mobad.n.a
    public void a(a.InterfaceC0458a interfaceC0458a) {
        this.f22639g = interfaceC0458a;
        this.o.a(interfaceC0458a);
        this.f22641i.a(interfaceC0458a);
        this.p.a(interfaceC0458a);
        this.p.a(new ad.a() { // from class: com.opos.mobad.n.g.l.2
            AnonymousClass2() {
            }

            @Override // com.opos.mobad.n.g.ad.a
            public void a(int i2) {
                l.this.o.a(i2);
            }
        });
    }

    @Override // com.opos.mobad.n.a
    public void a(com.opos.mobad.n.d.h hVar) {
        a.InterfaceC0458a interfaceC0458a;
        a.InterfaceC0458a interfaceC0458a2;
        if (hVar == null) {
            com.opos.cmn.an.f.a.b("BlockBigImageVideo10", "data is null");
            interfaceC0458a2 = this.f22639g;
        } else {
            com.opos.mobad.n.d.e b2 = hVar.b();
            if (b2 != null) {
                com.opos.cmn.an.f.a.b("BlockBigImageVideo10", "render");
                if (!TextUtils.isEmpty(b2.f22079a.f22084a) && this.k == null) {
                    this.o.a(b2);
                }
                if (this.k == null && (interfaceC0458a = this.f22639g) != null) {
                    interfaceC0458a.e();
                }
                this.k = b2;
                com.opos.mobad.n.c.j jVar = this.n;
                if (jVar != null && jVar.getVisibility() != 0) {
                    this.n.setVisibility(0);
                }
                RelativeLayout relativeLayout = this.l;
                if (relativeLayout != null && relativeLayout.getVisibility() != 0) {
                    this.l.setVisibility(0);
                }
                a(b2);
                return;
            }
            com.opos.cmn.an.f.a.d("", "render with data null");
            interfaceC0458a2 = this.f22639g;
            if (interfaceC0458a2 == null) {
                return;
            }
        }
        interfaceC0458a2.b(1);
    }

    @Override // com.opos.mobad.n.a
    public void b() {
        com.opos.cmn.an.f.a.b("BlockBigImageVideo10", "start countdown...");
        if (!this.f22633a) {
            this.o.b();
            return;
        }
        com.opos.cmn.an.f.a.b("BlockBigImageVideo10", "error state mDestroy " + this.f22633a);
    }

    @Override // com.opos.mobad.n.a
    public View c() {
        return this.n;
    }

    @Override // com.opos.mobad.n.a
    public void d() {
        com.opos.cmn.an.f.a.b("BlockBigImageVideo10", "destroy");
        this.f22633a = true;
        ag agVar = this.o;
        if (agVar != null) {
            agVar.c();
        }
        this.k = null;
        this.q.removeCallbacks(this.t);
        com.opos.mobad.n.c.j jVar = this.n;
        if (jVar != null) {
            jVar.removeAllViews();
        }
    }

    @Override // com.opos.mobad.n.a
    public int e() {
        return this.f22640h;
    }
}
