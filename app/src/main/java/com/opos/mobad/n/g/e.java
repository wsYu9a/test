package com.opos.mobad.n.g;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.c.a;
import com.opos.mobad.c.d.a;
import com.opos.mobad.n.a;
import com.opos.mobad.n.c.j;
import java.util.List;

/* loaded from: classes4.dex */
public class e implements com.opos.mobad.n.a {

    /* renamed from: d */
    private int f22518d;

    /* renamed from: e */
    private int f22519e;

    /* renamed from: g */
    private Context f22521g;

    /* renamed from: h */
    private a.InterfaceC0458a f22522h;

    /* renamed from: i */
    private int f22523i;

    /* renamed from: j */
    private int f22524j;
    private com.opos.mobad.n.d.d k;
    private ImageView l;
    private af m;
    private com.opos.mobad.n.c.h n;
    private RelativeLayout o;
    private t p;
    private z q;
    private RelativeLayout r;
    private y s;
    private com.opos.mobad.n.c.j u;
    private com.opos.mobad.c.a v;

    /* renamed from: a */
    private volatile boolean f22515a = false;

    /* renamed from: b */
    private int f22516b = 256;

    /* renamed from: c */
    private int f22517c = 144;

    /* renamed from: f */
    private int f22520f = 64;
    private boolean t = false;

    /* renamed from: com.opos.mobad.n.g.e$1 */
    class AnonymousClass1 extends com.opos.mobad.n.c.g {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            if (e.this.f22522h != null) {
                e.this.f22522h.g(view, iArr);
            }
        }
    }

    /* renamed from: com.opos.mobad.n.g.e$2 */
    class AnonymousClass2 implements a.InterfaceC0428a {

        /* renamed from: a */
        final /* synthetic */ com.opos.mobad.c.d.a f22526a;

        AnonymousClass2(com.opos.mobad.c.d.a aVar) {
            aVar = aVar;
        }

        @Override // com.opos.mobad.c.d.a.InterfaceC0428a
        public void a(boolean z) {
            if (e.this.k == null) {
                return;
            }
            if (z) {
                e.this.o();
                if (e.this.f22522h != null) {
                    e.this.f22522h.b();
                }
                aVar.a((a.InterfaceC0428a) null);
            }
            com.opos.cmn.an.f.a.b("BlockBigImage2", "blockBigImage2 onWindowVisibilityChanged：" + z);
        }
    }

    /* renamed from: com.opos.mobad.n.g.e$3 */
    class AnonymousClass3 implements a.InterfaceC0426a {

        /* renamed from: a */
        final /* synthetic */ com.opos.mobad.n.d.d f22528a;

        /* renamed from: com.opos.mobad.n.g.e$3$1 */
        class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Bitmap f22530a;

            AnonymousClass1(Bitmap bitmap) {
                bitmap = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Bitmap bitmap;
                if (e.this.f22515a || (bitmap = bitmap) == null || bitmap.isRecycled()) {
                    return;
                }
                e.this.l.setImageBitmap(bitmap);
            }
        }

        AnonymousClass3(com.opos.mobad.n.d.d dVar) {
            dVar = dVar;
        }

        @Override // com.opos.mobad.c.a.InterfaceC0426a
        public void a(int i2, Bitmap bitmap) {
            if (e.this.f22515a) {
                return;
            }
            if (dVar.f22075g.get(0) == null) {
                com.opos.cmn.an.f.a.b("BlockBigImage2", "null imgList");
                return;
            }
            if (i2 != 0 && i2 != 1) {
                if (e.this.f22522h != null) {
                    e.this.f22522h.c(i2);
                }
            } else {
                if (i2 == 1 && e.this.f22522h != null) {
                    e.this.f22522h.c(i2);
                }
                com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.g.e.3.1

                    /* renamed from: a */
                    final /* synthetic */ Bitmap f22530a;

                    AnonymousClass1(Bitmap bitmap2) {
                        bitmap = bitmap2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Bitmap bitmap2;
                        if (e.this.f22515a || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                            return;
                        }
                        e.this.l.setImageBitmap(bitmap);
                    }
                });
            }
        }
    }

    private e(Context context, aj ajVar, int i2, int i3, com.opos.mobad.c.a aVar) {
        this.f22521g = context;
        this.f22524j = i3;
        this.f22523i = i2;
        this.v = aVar;
        f();
        a(ajVar);
        n();
    }

    public static e a(Context context, aj ajVar, int i2, com.opos.mobad.c.a aVar) {
        return new e(context, ajVar, i2, 0, aVar);
    }

    private void a(com.opos.mobad.n.d.d dVar) {
        c(dVar);
        if (this.t) {
            b(dVar);
        } else {
            d(dVar);
        }
        e(dVar);
        f(dVar);
    }

    private void a(aj ajVar) {
        if (ajVar == null) {
            ajVar = aj.a(this.f22521g);
        }
        Context context = this.f22521g;
        int i2 = ajVar.f22455a;
        int i3 = ajVar.f22456b;
        int i4 = this.f22516b;
        this.u = new com.opos.mobad.n.c.j(context, new j.a(i2, i3, i4, i4 / this.f22518d));
        com.opos.mobad.n.c.h hVar = new com.opos.mobad.n.c.h(this.f22521g);
        this.n = hVar;
        hVar.a(com.opos.cmn.an.h.f.a.a(this.f22521g, 14.0f));
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.f22516b, this.f22518d);
        layoutParams.width = this.f22516b;
        layoutParams.height = this.f22518d;
        this.n.setId(View.generateViewId());
        this.n.setBackgroundColor(this.f22521g.getResources().getColor(R.color.opos_mobad_root_bg_color));
        this.n.setLayoutParams(layoutParams);
        this.n.setVisibility(8);
        this.u.addView(this.n, layoutParams);
        this.u.setLayoutParams(layoutParams);
        m();
        g();
        AnonymousClass1 anonymousClass1 = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.g.e.1
            AnonymousClass1() {
            }

            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (e.this.f22522h != null) {
                    e.this.f22522h.g(view, iArr);
                }
            }
        };
        this.n.setOnClickListener(anonymousClass1);
        this.n.setOnTouchListener(anonymousClass1);
    }

    public static e b(Context context, aj ajVar, int i2, com.opos.mobad.c.a aVar) {
        return new e(context, ajVar, i2, 1, aVar);
    }

    private void b(com.opos.mobad.n.d.d dVar) {
        y yVar;
        List<com.opos.mobad.n.d.g> list = dVar.f22075g;
        if (list == null || list.size() == 0 || (yVar = this.s) == null) {
            return;
        }
        yVar.a(dVar, this.v, this.f22515a, dVar.z);
    }

    public static e c(Context context, aj ajVar, int i2, com.opos.mobad.c.a aVar) {
        return new e(context, ajVar, i2, 2, aVar);
    }

    private void c(com.opos.mobad.n.d.d dVar) {
        this.p.a(dVar.m, dVar.l, dVar.f22074f, dVar.f22073e, this.v, this.f22515a);
    }

    private void d(com.opos.mobad.n.d.d dVar) {
        ImageView imageView;
        List<com.opos.mobad.n.d.g> list = dVar.f22075g;
        if (list == null || list.size() == 0 || (imageView = this.l) == null) {
            return;
        }
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.v.a(dVar.f22075g.get(0).f22084a, dVar.f22075g.get(0).f22085b, this.f22516b, this.f22517c, new a.InterfaceC0426a() { // from class: com.opos.mobad.n.g.e.3

            /* renamed from: a */
            final /* synthetic */ com.opos.mobad.n.d.d f22528a;

            /* renamed from: com.opos.mobad.n.g.e$3$1 */
            class AnonymousClass1 implements Runnable {

                /* renamed from: a */
                final /* synthetic */ Bitmap f22530a;

                AnonymousClass1(Bitmap bitmap2) {
                    bitmap = bitmap2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Bitmap bitmap2;
                    if (e.this.f22515a || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                        return;
                    }
                    e.this.l.setImageBitmap(bitmap);
                }
            }

            AnonymousClass3(com.opos.mobad.n.d.d dVar2) {
                dVar = dVar2;
            }

            @Override // com.opos.mobad.c.a.InterfaceC0426a
            public void a(int i2, Bitmap bitmap2) {
                if (e.this.f22515a) {
                    return;
                }
                if (dVar.f22075g.get(0) == null) {
                    com.opos.cmn.an.f.a.b("BlockBigImage2", "null imgList");
                    return;
                }
                if (i2 != 0 && i2 != 1) {
                    if (e.this.f22522h != null) {
                        e.this.f22522h.c(i2);
                    }
                } else {
                    if (i2 == 1 && e.this.f22522h != null) {
                        e.this.f22522h.c(i2);
                    }
                    com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.g.e.3.1

                        /* renamed from: a */
                        final /* synthetic */ Bitmap f22530a;

                        AnonymousClass1(Bitmap bitmap22) {
                            bitmap = bitmap22;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Bitmap bitmap22;
                            if (e.this.f22515a || (bitmap22 = bitmap) == null || bitmap22.isRecycled()) {
                                return;
                            }
                            e.this.l.setImageBitmap(bitmap);
                        }
                    });
                }
            }
        });
    }

    private void e(com.opos.mobad.n.d.d dVar) {
        this.m.a(dVar.r, dVar.s, dVar.f22077i, dVar.f22078j, dVar.k, dVar.B);
    }

    private void f() {
        int a2;
        int i2 = this.f22524j;
        if (i2 == 0) {
            this.f22516b = com.opos.cmn.an.h.f.a.a(this.f22521g, 256.0f);
            this.f22517c = com.opos.cmn.an.h.f.a.a(this.f22521g, 144.0f);
            a2 = com.opos.cmn.an.h.f.a.a(this.f22521g, 218.0f);
        } else {
            if (i2 != 1) {
                if (i2 != 2) {
                    return;
                }
                this.f22516b = com.opos.cmn.an.h.f.a.a(this.f22521g, 256.0f);
                this.f22517c = com.opos.cmn.an.h.f.a.a(this.f22521g, 168.0f);
                this.f22518d = com.opos.cmn.an.h.f.a.a(this.f22521g, 242.0f);
                this.f22519e = this.f22516b;
                this.f22520f = com.opos.cmn.an.h.f.a.a(this.f22521g, 64.0f);
                this.t = true;
                return;
            }
            this.f22516b = com.opos.cmn.an.h.f.a.a(this.f22521g, 256.0f);
            this.f22517c = com.opos.cmn.an.h.f.a.a(this.f22521g, 168.0f);
            a2 = com.opos.cmn.an.h.f.a.a(this.f22521g, 242.0f);
        }
        this.f22518d = a2;
        this.f22519e = this.f22516b;
        this.f22520f = com.opos.cmn.an.h.f.a.a(this.f22521g, 64.0f);
    }

    private void f(com.opos.mobad.n.d.d dVar) {
        com.opos.mobad.n.d.a aVar = dVar.v;
        if (aVar == null || TextUtils.isEmpty(aVar.f22065a) || TextUtils.isEmpty(aVar.f22066b)) {
            return;
        }
        RelativeLayout relativeLayout = this.r;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
        z zVar = this.q;
        if (zVar != null) {
            zVar.setVisibility(0);
            this.q.a(aVar.f22065a, aVar.f22066b);
        }
    }

    private void g() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f22521g);
        this.o = relativeLayout;
        relativeLayout.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f22516b, this.f22517c);
        t tVar = this.p;
        if (tVar != null) {
            layoutParams.addRule(3, tVar.getId());
        }
        this.o.setVisibility(4);
        this.n.addView(this.o, layoutParams);
        if (this.t) {
            h();
        } else {
            j();
        }
        k();
        l();
    }

    private void h() {
        this.s = y.a(this.f22521g, this.f22516b, this.f22517c, true);
        this.o.addView(this.s, new RelativeLayout.LayoutParams(this.f22516b, this.f22517c));
    }

    private void i() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f22521g);
        this.r = relativeLayout;
        relativeLayout.setBackgroundResource(R.drawable.opos_mobad_drawable_shape_gradient);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f22516b, this.f22520f);
        this.r.setVisibility(4);
        layoutParams.addRule(12);
        this.o.addView(this.r, layoutParams);
    }

    private void j() {
        this.l = new ImageView(this.f22521g);
        this.o.addView(this.l, new RelativeLayout.LayoutParams(this.f22516b, this.f22517c));
    }

    private void k() {
        this.m = af.a(this.f22521g, false);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f22516b, -2);
        this.m.setVisibility(4);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f22521g, 16.0f);
        this.o.addView(this.m, layoutParams);
    }

    private void l() {
        i();
        this.q = z.a(this.f22521g);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f22516b, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f22521g, 10.0f);
        this.q.setGravity(1);
        this.q.setVisibility(4);
        this.o.addView(this.q, layoutParams);
    }

    private void m() {
        t a2 = t.a(this.f22521g);
        this.p = a2;
        a2.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f22519e, com.opos.cmn.an.h.f.a.a(this.f22521g, 74.0f));
        this.p.setVisibility(4);
        this.n.addView(this.p, layoutParams);
    }

    private void n() {
        com.opos.mobad.c.d.a aVar = new com.opos.mobad.c.d.a(this.f22521g);
        aVar.a(new a.InterfaceC0428a() { // from class: com.opos.mobad.n.g.e.2

            /* renamed from: a */
            final /* synthetic */ com.opos.mobad.c.d.a f22526a;

            AnonymousClass2(com.opos.mobad.c.d.a aVar2) {
                aVar = aVar2;
            }

            @Override // com.opos.mobad.c.d.a.InterfaceC0428a
            public void a(boolean z) {
                if (e.this.k == null) {
                    return;
                }
                if (z) {
                    e.this.o();
                    if (e.this.f22522h != null) {
                        e.this.f22522h.b();
                    }
                    aVar.a((a.InterfaceC0428a) null);
                }
                com.opos.cmn.an.f.a.b("BlockBigImage2", "blockBigImage2 onWindowVisibilityChanged：" + z);
            }
        });
        this.n.addView(aVar2, new RelativeLayout.LayoutParams(0, 0));
    }

    public void o() {
        this.o.setVisibility(0);
        this.p.setVisibility(0);
        this.m.setVisibility(0);
    }

    @Override // com.opos.mobad.n.a
    public void a() {
    }

    @Override // com.opos.mobad.n.a
    public void a(a.InterfaceC0458a interfaceC0458a) {
        this.f22522h = interfaceC0458a;
        this.q.a(interfaceC0458a);
        this.p.a(interfaceC0458a);
        this.m.a(interfaceC0458a);
        y yVar = this.s;
        if (yVar != null) {
            yVar.a(interfaceC0458a);
        }
    }

    @Override // com.opos.mobad.n.a
    public void a(com.opos.mobad.n.d.h hVar) {
        String str;
        a.InterfaceC0458a interfaceC0458a;
        if (hVar == null) {
            str = "data is null";
        } else {
            com.opos.mobad.n.d.d a2 = hVar.a();
            if (a2 == null) {
                str = "adShowData is null";
            } else {
                List<com.opos.mobad.n.d.g> list = a2.f22075g;
                if (list != null && list.size() > 0) {
                    com.opos.cmn.an.f.a.b("BlockBigImage2", "render");
                    if (this.k == null && (interfaceC0458a = this.f22522h) != null) {
                        interfaceC0458a.e();
                    }
                    this.k = a2;
                    com.opos.mobad.n.c.j jVar = this.u;
                    if (jVar != null && jVar.getVisibility() != 0) {
                        this.u.setVisibility(0);
                    }
                    com.opos.mobad.n.c.h hVar2 = this.n;
                    if (hVar2 != null && hVar2.getVisibility() != 0) {
                        this.n.setVisibility(0);
                    }
                    a(a2);
                    return;
                }
                str = "imgList is null";
            }
        }
        com.opos.cmn.an.f.a.b("BlockBigImage2", str);
        this.f22522h.b(1);
    }

    @Override // com.opos.mobad.n.a
    public void b() {
    }

    @Override // com.opos.mobad.n.a
    public View c() {
        return this.u;
    }

    @Override // com.opos.mobad.n.a
    public void d() {
        com.opos.cmn.an.f.a.b("BlockBigImage2", "destroy");
        this.k = null;
        this.f22515a = true;
        com.opos.mobad.n.c.j jVar = this.u;
        if (jVar != null) {
            jVar.removeAllViews();
        }
    }

    @Override // com.opos.mobad.n.a
    public int e() {
        return this.f22523i;
    }
}
