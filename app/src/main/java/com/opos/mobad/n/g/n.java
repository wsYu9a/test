package com.opos.mobad.n.g;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.c.a;
import com.opos.mobad.c.d.a;
import com.opos.mobad.n.a;
import com.opos.mobad.n.c.j;
import com.opos.mobad.n.g.ad;
import com.opos.mobad.n.g.ag;

/* loaded from: classes4.dex */
public class n implements com.opos.mobad.n.a {

    /* renamed from: b */
    private int f22664b;

    /* renamed from: c */
    private int f22665c;

    /* renamed from: d */
    private int f22666d;

    /* renamed from: f */
    private Context f22668f;

    /* renamed from: g */
    private a.InterfaceC0458a f22669g;

    /* renamed from: h */
    private int f22670h;

    /* renamed from: i */
    private ad f22671i;

    /* renamed from: j */
    private TextView f22672j;
    private com.opos.mobad.n.d.e k;
    private com.opos.mobad.n.c.f l;
    private TextView m;
    private RelativeLayout n;
    private com.opos.mobad.n.c.h o;
    private com.opos.mobad.n.c.j p;
    private ag q;
    private ah r;
    private com.opos.mobad.c.a t;

    /* renamed from: a */
    private volatile boolean f22663a = false;

    /* renamed from: e */
    private int f22667e = 0;
    private boolean u = false;
    private Runnable v = new Runnable() { // from class: com.opos.mobad.n.g.n.1
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.f22663a) {
                return;
            }
            int g2 = n.this.q.g();
            int h2 = n.this.q.h();
            if (n.this.f22669g != null) {
                n.this.f22669g.d(g2, h2);
            }
            n.this.q.f();
            n.this.s.postDelayed(this, 500L);
        }
    };
    private Handler s = new Handler(Looper.getMainLooper());

    /* renamed from: com.opos.mobad.n.g.n$1 */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.f22663a) {
                return;
            }
            int g2 = n.this.q.g();
            int h2 = n.this.q.h();
            if (n.this.f22669g != null) {
                n.this.f22669g.d(g2, h2);
            }
            n.this.q.f();
            n.this.s.postDelayed(this, 500L);
        }
    }

    /* renamed from: com.opos.mobad.n.g.n$2 */
    class AnonymousClass2 implements ad.a {
        AnonymousClass2() {
        }

        @Override // com.opos.mobad.n.g.ad.a
        public void a(int i2) {
            n.this.q.a(i2);
        }
    }

    /* renamed from: com.opos.mobad.n.g.n$3 */
    class AnonymousClass3 extends com.opos.mobad.n.c.g {
        AnonymousClass3() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            if (n.this.f22669g != null) {
                n.this.f22669g.g(view, iArr);
            }
        }
    }

    /* renamed from: com.opos.mobad.n.g.n$4 */
    class AnonymousClass4 implements ag.a {
        AnonymousClass4() {
        }

        @Override // com.opos.mobad.n.g.ag.a
        public void a() {
            n.this.s.removeCallbacks(n.this.v);
            n.this.s.postDelayed(n.this.v, 500L);
        }

        @Override // com.opos.mobad.n.g.ag.a
        public void b() {
            n.this.s.removeCallbacks(n.this.v);
        }
    }

    /* renamed from: com.opos.mobad.n.g.n$5 */
    class AnonymousClass5 implements a.InterfaceC0428a {
        AnonymousClass5() {
        }

        @Override // com.opos.mobad.c.d.a.InterfaceC0428a
        public void a(boolean z) {
            if (n.this.k == null) {
                return;
            }
            if (z && !n.this.u) {
                n.this.u = true;
                n.this.h();
                if (n.this.f22669g != null) {
                    n.this.f22669g.b();
                }
            }
            com.opos.cmn.an.f.a.b("BlockBigImageVideo12", "BlockBigImageVideo12 onWindowVisibilityChanged：" + z);
            if (z) {
                n.this.q.d();
            } else {
                n.this.q.e();
            }
        }
    }

    /* renamed from: com.opos.mobad.n.g.n$6 */
    class AnonymousClass6 implements a.InterfaceC0426a {

        /* renamed from: a */
        final /* synthetic */ boolean f22678a;

        /* renamed from: com.opos.mobad.n.g.n$6$1 */
        class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Bitmap f22680a;

            AnonymousClass1(Bitmap bitmap) {
                bitmap = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Bitmap bitmap;
                if (z || (bitmap = bitmap) == null || bitmap.isRecycled()) {
                    return;
                }
                n.this.l.setImageBitmap(bitmap);
            }
        }

        AnonymousClass6(boolean z) {
            z = z;
        }

        @Override // com.opos.mobad.c.a.InterfaceC0426a
        public void a(int i2, Bitmap bitmap) {
            if (z) {
                return;
            }
            if (i2 != 0 && i2 != 1) {
                if (n.this.f22669g != null) {
                    n.this.f22669g.c(i2);
                }
            } else {
                if (i2 == 1 && n.this.f22669g != null) {
                    n.this.f22669g.c(i2);
                }
                com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.g.n.6.1

                    /* renamed from: a */
                    final /* synthetic */ Bitmap f22680a;

                    AnonymousClass1(Bitmap bitmap2) {
                        bitmap = bitmap2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Bitmap bitmap2;
                        if (z || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                            return;
                        }
                        n.this.l.setImageBitmap(bitmap);
                    }
                });
            }
        }
    }

    private n(Context context, aj ajVar, int i2, com.opos.mobad.c.c.a aVar, com.opos.mobad.c.a aVar2) {
        this.f22668f = context;
        this.f22670h = i2;
        this.t = aVar2;
        f();
        a(ajVar, aVar);
        g();
    }

    public static n a(Context context, aj ajVar, int i2, com.opos.mobad.c.c.a aVar, com.opos.mobad.c.a aVar2) {
        return new n(context, ajVar, i2, aVar, aVar2);
    }

    private void a(RelativeLayout relativeLayout) {
        relativeLayout.setId(View.generateViewId());
        int a2 = com.opos.cmn.an.h.f.a.a(this.f22668f, 36.0f);
        this.o.addView(relativeLayout, new RelativeLayout.LayoutParams(this.f22664b, a2));
        com.opos.mobad.n.c.f fVar = new com.opos.mobad.n.c.f(this.f22668f, com.opos.cmn.an.h.f.a.a(r2, 33.33f));
        this.l = fVar;
        fVar.setId(View.generateViewId());
        relativeLayout.addView(this.l, new RelativeLayout.LayoutParams(a2, a2));
        TextView textView = new TextView(this.f22668f);
        this.m = textView;
        textView.setTextColor(this.f22668f.getResources().getColor(R.color.opos_mobad_small_top_title_color));
        this.m.setTextSize(1, 14.0f);
        this.m.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.m.setSingleLine(true);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.f22668f, 8.0f);
        layoutParams.addRule(15);
        layoutParams.addRule(1, this.l.getId());
        relativeLayout.addView(this.m, layoutParams);
    }

    private void a(com.opos.mobad.c.c.a aVar) {
        com.opos.mobad.n.c.h hVar = new com.opos.mobad.n.c.h(this.f22668f);
        this.o = hVar;
        hVar.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f22664b, this.f22665c);
        this.o.setVisibility(4);
        this.n.addView(this.o, layoutParams);
        RelativeLayout relativeLayout = new RelativeLayout(this.f22668f);
        a(relativeLayout);
        b(relativeLayout);
        com.opos.mobad.n.c.h hVar2 = new com.opos.mobad.n.c.h(this.f22668f);
        a(hVar2);
        a(aVar, hVar2);
        c(hVar2);
        b(hVar2);
    }

    private void a(com.opos.mobad.c.c.a aVar, com.opos.mobad.n.c.h hVar) {
        this.q = ag.a(this.f22668f, this.f22664b, this.f22667e, aVar);
        hVar.addView(this.q, new RelativeLayout.LayoutParams(this.f22664b, this.f22667e));
        this.q.a(new ag.a() { // from class: com.opos.mobad.n.g.n.4
            AnonymousClass4() {
            }

            @Override // com.opos.mobad.n.g.ag.a
            public void a() {
                n.this.s.removeCallbacks(n.this.v);
                n.this.s.postDelayed(n.this.v, 500L);
            }

            @Override // com.opos.mobad.n.g.ag.a
            public void b() {
                n.this.s.removeCallbacks(n.this.v);
            }
        });
    }

    private void a(com.opos.mobad.n.c.h hVar) {
        hVar.a(com.opos.cmn.an.h.f.a.a(this.f22668f, 6.0f));
        hVar.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f22664b, this.f22667e);
        layoutParams.addRule(3, this.f22672j.getId());
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f22668f, 8.0f);
        this.o.addView(hVar, layoutParams);
    }

    private void a(com.opos.mobad.n.d.d dVar) {
        String str = dVar.f22073e;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f22672j.setText(str);
    }

    private void a(com.opos.mobad.n.d.e eVar) {
        this.f22671i.a(eVar.r, eVar.s, eVar.f22077i, eVar.f22078j, eVar.k, eVar.B, eVar.f22074f);
        a((com.opos.mobad.n.d.d) eVar);
        b(eVar);
        this.r.a(eVar.B);
    }

    private void a(com.opos.mobad.n.d.g gVar, com.opos.mobad.c.a aVar, boolean z) {
        com.opos.mobad.n.c.f fVar;
        if (gVar == null || (fVar = this.l) == null) {
            com.opos.cmn.an.f.a.b("BlockBigImageVideo12", "iconUrl is null");
            return;
        }
        fVar.setVisibility(0);
        this.l.setScaleType(ImageView.ScaleType.FIT_XY);
        int a2 = com.opos.cmn.an.h.f.a.a(this.f22668f, 36.0f);
        aVar.a(gVar.f22084a, gVar.f22085b, a2, a2, new a.InterfaceC0426a() { // from class: com.opos.mobad.n.g.n.6

            /* renamed from: a */
            final /* synthetic */ boolean f22678a;

            /* renamed from: com.opos.mobad.n.g.n$6$1 */
            class AnonymousClass1 implements Runnable {

                /* renamed from: a */
                final /* synthetic */ Bitmap f22680a;

                AnonymousClass1(Bitmap bitmap2) {
                    bitmap = bitmap2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Bitmap bitmap2;
                    if (z || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                        return;
                    }
                    n.this.l.setImageBitmap(bitmap);
                }
            }

            AnonymousClass6(boolean z2) {
                z = z2;
            }

            @Override // com.opos.mobad.c.a.InterfaceC0426a
            public void a(int i2, Bitmap bitmap2) {
                if (z) {
                    return;
                }
                if (i2 != 0 && i2 != 1) {
                    if (n.this.f22669g != null) {
                        n.this.f22669g.c(i2);
                    }
                } else {
                    if (i2 == 1 && n.this.f22669g != null) {
                        n.this.f22669g.c(i2);
                    }
                    com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.g.n.6.1

                        /* renamed from: a */
                        final /* synthetic */ Bitmap f22680a;

                        AnonymousClass1(Bitmap bitmap22) {
                            bitmap = bitmap22;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Bitmap bitmap22;
                            if (z || (bitmap22 = bitmap) == null || bitmap22.isRecycled()) {
                                return;
                            }
                            n.this.l.setImageBitmap(bitmap);
                        }
                    });
                }
            }
        });
    }

    private void a(aj ajVar, com.opos.mobad.c.c.a aVar) {
        if (ajVar == null) {
            ajVar = aj.a(this.f22668f);
        }
        Context context = this.f22668f;
        int i2 = ajVar.f22455a;
        int i3 = ajVar.f22456b;
        int i4 = this.f22664b;
        this.p = new com.opos.mobad.n.c.j(context, new j.a(i2, i3, i4, i4 / this.f22666d));
        this.n = new RelativeLayout(this.f22668f);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.f22664b, -2);
        layoutParams.width = this.f22664b;
        layoutParams.height = -2;
        this.n.setId(View.generateViewId());
        this.n.setLayoutParams(layoutParams);
        this.n.setVisibility(8);
        this.p.addView(this.n, layoutParams);
        this.p.setLayoutParams(layoutParams);
        a(aVar);
        AnonymousClass3 anonymousClass3 = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.g.n.3
            AnonymousClass3() {
            }

            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (n.this.f22669g != null) {
                    n.this.f22669g.g(view, iArr);
                }
            }
        };
        this.n.setOnClickListener(anonymousClass3);
        this.n.setOnTouchListener(anonymousClass3);
    }

    private void b(RelativeLayout relativeLayout) {
        TextView textView = new TextView(this.f22668f);
        this.f22672j = textView;
        textView.setId(View.generateViewId());
        this.f22672j.setTextColor(this.f22668f.getResources().getColor(R.color.opos_mobad_small_top_title_color));
        this.f22672j.setTextSize(1, 17.0f);
        this.f22672j.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.f22672j.setMaxLines(2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(3, relativeLayout.getId());
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f22668f, 12.0f);
        this.o.addView(this.f22672j, layoutParams);
    }

    private void b(com.opos.mobad.n.c.h hVar) {
        this.f22671i = ad.a(this.f22668f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f22664b, -2);
        layoutParams.addRule(3, hVar.getId());
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f22668f, 6.0f);
        this.o.addView(this.f22671i, layoutParams);
    }

    private void b(com.opos.mobad.n.d.d dVar) {
        com.opos.mobad.c.a aVar;
        String str = dVar.f22074f;
        if (!TextUtils.isEmpty(str)) {
            this.m.setText(str);
        }
        com.opos.mobad.n.d.g gVar = dVar.m;
        if (gVar != null && !TextUtils.isEmpty(gVar.f22084a) && (aVar = this.t) != null) {
            a(dVar.m, aVar, this.f22663a);
            return;
        }
        com.opos.cmn.an.f.a.b("BlockBigImageVideo12", "BlockBigImageVideo12 iconUrl is null");
        this.l.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
        layoutParams.leftMargin = 0;
        this.m.setLayoutParams(layoutParams);
    }

    private void c(com.opos.mobad.n.c.h hVar) {
        this.r = ah.a(this.f22668f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f22668f, 12.0f);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.f22668f, 10.0f);
        hVar.addView(this.r, layoutParams);
    }

    private void f() {
        this.f22664b = com.opos.cmn.an.h.f.a.a(this.f22668f, 320.0f);
        this.f22665c = com.opos.cmn.an.h.f.a.a(this.f22668f, 306.0f);
        this.f22667e = com.opos.cmn.an.h.f.a.a(this.f22668f, 180.0f);
        this.f22666d = this.f22665c;
    }

    private void g() {
        com.opos.mobad.c.d.a aVar = new com.opos.mobad.c.d.a(this.f22668f);
        aVar.a(new a.InterfaceC0428a() { // from class: com.opos.mobad.n.g.n.5
            AnonymousClass5() {
            }

            @Override // com.opos.mobad.c.d.a.InterfaceC0428a
            public void a(boolean z) {
                if (n.this.k == null) {
                    return;
                }
                if (z && !n.this.u) {
                    n.this.u = true;
                    n.this.h();
                    if (n.this.f22669g != null) {
                        n.this.f22669g.b();
                    }
                }
                com.opos.cmn.an.f.a.b("BlockBigImageVideo12", "BlockBigImageVideo12 onWindowVisibilityChanged：" + z);
                if (z) {
                    n.this.q.d();
                } else {
                    n.this.q.e();
                }
            }
        });
        this.n.addView(aVar, new RelativeLayout.LayoutParams(0, 0));
    }

    public void h() {
        this.o.setVisibility(0);
    }

    @Override // com.opos.mobad.n.a
    public void a() {
        if (!this.f22663a) {
            this.q.a();
            return;
        }
        com.opos.cmn.an.f.a.b("BlockBigImageVideo12", "current state has stop mDestroy =" + this.f22663a);
    }

    @Override // com.opos.mobad.n.a
    public void a(a.InterfaceC0458a interfaceC0458a) {
        this.f22669g = interfaceC0458a;
        this.q.a(interfaceC0458a);
        this.f22671i.a(interfaceC0458a);
        this.r.a(interfaceC0458a);
        this.r.a(new ad.a() { // from class: com.opos.mobad.n.g.n.2
            AnonymousClass2() {
            }

            @Override // com.opos.mobad.n.g.ad.a
            public void a(int i2) {
                n.this.q.a(i2);
            }
        });
    }

    @Override // com.opos.mobad.n.a
    public void a(com.opos.mobad.n.d.h hVar) {
        a.InterfaceC0458a interfaceC0458a;
        a.InterfaceC0458a interfaceC0458a2;
        if (hVar == null) {
            com.opos.cmn.an.f.a.b("BlockBigImageVideo12", "data is null");
            interfaceC0458a2 = this.f22669g;
        } else {
            com.opos.mobad.n.d.e b2 = hVar.b();
            if (b2 != null) {
                com.opos.cmn.an.f.a.b("BlockBigImageVideo12", "render");
                if (!TextUtils.isEmpty(b2.f22079a.f22084a) && this.k == null) {
                    this.q.a(b2);
                }
                if (this.k == null && (interfaceC0458a = this.f22669g) != null) {
                    interfaceC0458a.e();
                }
                this.k = b2;
                com.opos.mobad.n.c.j jVar = this.p;
                if (jVar != null && jVar.getVisibility() != 0) {
                    this.p.setVisibility(0);
                }
                RelativeLayout relativeLayout = this.n;
                if (relativeLayout != null && relativeLayout.getVisibility() != 0) {
                    this.n.setVisibility(0);
                }
                a(b2);
                return;
            }
            com.opos.cmn.an.f.a.d("", "render with data null");
            interfaceC0458a2 = this.f22669g;
            if (interfaceC0458a2 == null) {
                return;
            }
        }
        interfaceC0458a2.b(1);
    }

    @Override // com.opos.mobad.n.a
    public void b() {
        com.opos.cmn.an.f.a.b("BlockBigImageVideo12", "start countdown...");
        if (!this.f22663a) {
            this.q.b();
            return;
        }
        com.opos.cmn.an.f.a.b("BlockBigImageVideo12", "error state mDestroy " + this.f22663a);
    }

    @Override // com.opos.mobad.n.a
    public View c() {
        return this.p;
    }

    @Override // com.opos.mobad.n.a
    public void d() {
        com.opos.cmn.an.f.a.b("BlockBigImageVideo12", "destroy");
        this.f22663a = true;
        ag agVar = this.q;
        if (agVar != null) {
            agVar.c();
        }
        this.k = null;
        this.s.removeCallbacks(this.v);
        com.opos.mobad.n.c.j jVar = this.p;
        if (jVar != null) {
            jVar.removeAllViews();
        }
    }

    @Override // com.opos.mobad.n.a
    public int e() {
        return this.f22670h;
    }
}
