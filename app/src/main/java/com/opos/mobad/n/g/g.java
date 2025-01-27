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
public class g implements com.opos.mobad.n.a {

    /* renamed from: e */
    private int f22553e;

    /* renamed from: f */
    private Context f22554f;

    /* renamed from: g */
    private a.InterfaceC0458a f22555g;

    /* renamed from: h */
    private int f22556h;

    /* renamed from: i */
    private int f22557i;

    /* renamed from: j */
    private com.opos.mobad.n.d.d f22558j;
    private ImageView k;
    private af l;
    private RelativeLayout m;
    private com.opos.mobad.n.c.h n;
    private u o;
    private z p;
    private y q;
    private RelativeLayout r;
    private com.opos.mobad.n.c.j t;
    private com.opos.mobad.c.a u;

    /* renamed from: a */
    private volatile boolean f22549a = false;

    /* renamed from: b */
    private int f22550b = 256;

    /* renamed from: c */
    private int f22551c = 144;

    /* renamed from: d */
    private int f22552d = 64;
    private boolean s = false;

    /* renamed from: com.opos.mobad.n.g.g$1 */
    class AnonymousClass1 extends com.opos.mobad.n.c.g {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            if (g.this.f22555g != null) {
                g.this.f22555g.g(view, iArr);
            }
        }
    }

    /* renamed from: com.opos.mobad.n.g.g$2 */
    class AnonymousClass2 implements a.InterfaceC0428a {

        /* renamed from: a */
        final /* synthetic */ com.opos.mobad.c.d.a f22560a;

        AnonymousClass2(com.opos.mobad.c.d.a aVar) {
            aVar = aVar;
        }

        @Override // com.opos.mobad.c.d.a.InterfaceC0428a
        public void a(boolean z) {
            if (g.this.f22558j == null) {
                return;
            }
            if (z) {
                g.this.o();
                if (g.this.f22555g != null) {
                    g.this.f22555g.b();
                }
                aVar.a((a.InterfaceC0428a) null);
            }
            com.opos.cmn.an.f.a.b("BlockBigImage4", "blockBigImage4 onWindowVisibilityChanged：" + z);
        }
    }

    /* renamed from: com.opos.mobad.n.g.g$3 */
    class AnonymousClass3 implements a.InterfaceC0426a {

        /* renamed from: a */
        final /* synthetic */ com.opos.mobad.n.d.d f22562a;

        /* renamed from: com.opos.mobad.n.g.g$3$1 */
        class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Bitmap f22564a;

            AnonymousClass1(Bitmap bitmap) {
                bitmap = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Bitmap bitmap;
                if (g.this.f22549a || (bitmap = bitmap) == null || bitmap.isRecycled()) {
                    return;
                }
                g.this.k.setImageBitmap(bitmap);
            }
        }

        AnonymousClass3(com.opos.mobad.n.d.d dVar) {
            dVar = dVar;
        }

        @Override // com.opos.mobad.c.a.InterfaceC0426a
        public void a(int i2, Bitmap bitmap) {
            if (g.this.f22549a) {
                return;
            }
            if (dVar.f22075g.get(0) == null) {
                com.opos.cmn.an.f.a.b("BlockBigImage4", "null imgList");
                return;
            }
            if (i2 != 0 && i2 != 1) {
                if (g.this.f22555g != null) {
                    g.this.f22555g.c(i2);
                }
            } else {
                if (i2 == 1 && g.this.f22555g != null) {
                    g.this.f22555g.c(i2);
                }
                com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.g.g.3.1

                    /* renamed from: a */
                    final /* synthetic */ Bitmap f22564a;

                    AnonymousClass1(Bitmap bitmap2) {
                        bitmap = bitmap2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Bitmap bitmap2;
                        if (g.this.f22549a || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                            return;
                        }
                        g.this.k.setImageBitmap(bitmap);
                    }
                });
            }
        }
    }

    private g(Context context, aj ajVar, int i2, int i3, com.opos.mobad.c.a aVar) {
        this.f22554f = context;
        this.f22557i = i3;
        this.f22556h = i2;
        this.u = aVar;
        f();
        a(ajVar);
        n();
    }

    public static g a(Context context, aj ajVar, int i2, com.opos.mobad.c.a aVar) {
        return new g(context, ajVar, i2, 0, aVar);
    }

    private void a(com.opos.mobad.n.d.d dVar) {
        c(dVar);
        if (this.s) {
            b(dVar);
        } else {
            d(dVar);
        }
        e(dVar);
        f(dVar);
    }

    private void a(aj ajVar) {
        if (ajVar == null) {
            ajVar = aj.a(this.f22554f);
        }
        Context context = this.f22554f;
        int i2 = ajVar.f22455a;
        int i3 = ajVar.f22456b;
        int i4 = this.f22550b;
        this.t = new com.opos.mobad.n.c.j(context, new j.a(i2, i3, i4, i4 / this.f22553e));
        this.m = new RelativeLayout(this.f22554f);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.f22550b, -2);
        layoutParams.width = this.f22550b;
        layoutParams.height = -2;
        this.m.setId(View.generateViewId());
        this.m.setLayoutParams(layoutParams);
        this.m.setVisibility(8);
        this.t.addView(this.m, layoutParams);
        this.t.setLayoutParams(layoutParams);
        g();
        m();
        AnonymousClass1 anonymousClass1 = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.g.g.1
            AnonymousClass1() {
            }

            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (g.this.f22555g != null) {
                    g.this.f22555g.g(view, iArr);
                }
            }
        };
        this.m.setOnClickListener(anonymousClass1);
        this.m.setOnTouchListener(anonymousClass1);
    }

    public static g b(Context context, aj ajVar, int i2, com.opos.mobad.c.a aVar) {
        return new g(context, ajVar, i2, 1, aVar);
    }

    private void b(com.opos.mobad.n.d.d dVar) {
        y yVar;
        List<com.opos.mobad.n.d.g> list = dVar.f22075g;
        if (list == null || list.size() == 0 || (yVar = this.q) == null) {
            return;
        }
        yVar.a(dVar, this.u, this.f22549a, dVar.z);
    }

    public static g c(Context context, aj ajVar, int i2, com.opos.mobad.c.a aVar) {
        return new g(context, ajVar, i2, 2, aVar);
    }

    private void c(com.opos.mobad.n.d.d dVar) {
        this.o.a(dVar.l, dVar.f22074f);
    }

    private void d(com.opos.mobad.n.d.d dVar) {
        ImageView imageView;
        List<com.opos.mobad.n.d.g> list = dVar.f22075g;
        if (list == null || list.size() == 0 || (imageView = this.k) == null) {
            return;
        }
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.u.a(dVar.f22075g.get(0).f22084a, dVar.f22075g.get(0).f22085b, this.f22550b, this.f22551c, new a.InterfaceC0426a() { // from class: com.opos.mobad.n.g.g.3

            /* renamed from: a */
            final /* synthetic */ com.opos.mobad.n.d.d f22562a;

            /* renamed from: com.opos.mobad.n.g.g$3$1 */
            class AnonymousClass1 implements Runnable {

                /* renamed from: a */
                final /* synthetic */ Bitmap f22564a;

                AnonymousClass1(Bitmap bitmap2) {
                    bitmap = bitmap2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Bitmap bitmap2;
                    if (g.this.f22549a || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                        return;
                    }
                    g.this.k.setImageBitmap(bitmap);
                }
            }

            AnonymousClass3(com.opos.mobad.n.d.d dVar2) {
                dVar = dVar2;
            }

            @Override // com.opos.mobad.c.a.InterfaceC0426a
            public void a(int i2, Bitmap bitmap2) {
                if (g.this.f22549a) {
                    return;
                }
                if (dVar.f22075g.get(0) == null) {
                    com.opos.cmn.an.f.a.b("BlockBigImage4", "null imgList");
                    return;
                }
                if (i2 != 0 && i2 != 1) {
                    if (g.this.f22555g != null) {
                        g.this.f22555g.c(i2);
                    }
                } else {
                    if (i2 == 1 && g.this.f22555g != null) {
                        g.this.f22555g.c(i2);
                    }
                    com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.g.g.3.1

                        /* renamed from: a */
                        final /* synthetic */ Bitmap f22564a;

                        AnonymousClass1(Bitmap bitmap22) {
                            bitmap = bitmap22;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Bitmap bitmap22;
                            if (g.this.f22549a || (bitmap22 = bitmap) == null || bitmap22.isRecycled()) {
                                return;
                            }
                            g.this.k.setImageBitmap(bitmap);
                        }
                    });
                }
            }
        });
    }

    private void e(com.opos.mobad.n.d.d dVar) {
        this.l.a(dVar.r, dVar.s, dVar.f22077i, dVar.f22078j, dVar.k, dVar.B);
    }

    private void f() {
        int a2;
        this.f22552d = com.opos.cmn.an.h.f.a.a(this.f22554f, 64.0f);
        int i2 = this.f22557i;
        if (i2 == 0) {
            this.f22550b = com.opos.cmn.an.h.f.a.a(this.f22554f, 256.0f);
            a2 = com.opos.cmn.an.h.f.a.a(this.f22554f, 144.0f);
        } else {
            if (i2 != 1) {
                if (i2 == 2) {
                    this.f22550b = com.opos.cmn.an.h.f.a.a(this.f22554f, 256.0f);
                    this.f22551c = com.opos.cmn.an.h.f.a.a(this.f22554f, 168.0f);
                    this.s = true;
                }
                this.f22553e = this.f22551c + com.opos.cmn.an.h.f.a.a(this.f22554f, 24.0f);
            }
            this.f22550b = com.opos.cmn.an.h.f.a.a(this.f22554f, 256.0f);
            a2 = com.opos.cmn.an.h.f.a.a(this.f22554f, 168.0f);
        }
        this.f22551c = a2;
        this.f22553e = this.f22551c + com.opos.cmn.an.h.f.a.a(this.f22554f, 24.0f);
    }

    private void f(com.opos.mobad.n.d.d dVar) {
        z zVar;
        com.opos.mobad.n.d.a aVar = dVar.v;
        if (aVar == null || TextUtils.isEmpty(aVar.f22065a) || TextUtils.isEmpty(aVar.f22066b) || (zVar = this.p) == null) {
            return;
        }
        zVar.setVisibility(0);
        this.p.a(aVar.f22065a, aVar.f22066b);
    }

    private void g() {
        com.opos.mobad.n.c.h hVar = new com.opos.mobad.n.c.h(this.f22554f);
        this.n = hVar;
        hVar.a(com.opos.cmn.an.h.f.a.a(this.f22554f, 14.0f));
        this.n.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f22550b, this.f22551c);
        this.n.setVisibility(4);
        this.m.addView(this.n, layoutParams);
        if (this.s) {
            j();
        } else {
            k();
        }
        l();
        h();
    }

    private void h() {
        i();
        u a2 = u.a(this.f22554f);
        this.o = a2;
        a2.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f22550b, com.opos.cmn.an.h.f.a.a(this.f22554f, 26.0f));
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f22554f, 12.0f);
        this.o.setVisibility(4);
        this.n.addView(this.o, layoutParams);
    }

    private void i() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f22554f);
        this.r = relativeLayout;
        relativeLayout.setBackgroundResource(R.drawable.opos_mobad_drawable_shape_gradient_top);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f22550b, this.f22552d);
        this.r.setVisibility(0);
        this.n.addView(this.r, layoutParams);
    }

    private void j() {
        this.q = y.a(this.f22554f, this.f22550b, this.f22551c, true);
        this.n.addView(this.q, new RelativeLayout.LayoutParams(this.f22550b, this.f22551c));
    }

    private void k() {
        this.k = new ImageView(this.f22554f);
        this.n.addView(this.k, new RelativeLayout.LayoutParams(this.f22550b, this.f22551c));
    }

    private void l() {
        this.l = af.a(this.f22554f, false);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f22550b, -2);
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f22554f, 12.0f);
        layoutParams.addRule(12);
        this.l.setVisibility(4);
        this.n.addView(this.l, layoutParams);
    }

    private void m() {
        this.p = z.b(this.f22554f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f22550b, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(3, this.n.getId());
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f22554f, 10.0f);
        this.p.setGravity(1);
        this.p.setVisibility(4);
        this.m.addView(this.p, layoutParams);
    }

    private void n() {
        com.opos.mobad.c.d.a aVar = new com.opos.mobad.c.d.a(this.f22554f);
        aVar.a(new a.InterfaceC0428a() { // from class: com.opos.mobad.n.g.g.2

            /* renamed from: a */
            final /* synthetic */ com.opos.mobad.c.d.a f22560a;

            AnonymousClass2(com.opos.mobad.c.d.a aVar2) {
                aVar = aVar2;
            }

            @Override // com.opos.mobad.c.d.a.InterfaceC0428a
            public void a(boolean z) {
                if (g.this.f22558j == null) {
                    return;
                }
                if (z) {
                    g.this.o();
                    if (g.this.f22555g != null) {
                        g.this.f22555g.b();
                    }
                    aVar.a((a.InterfaceC0428a) null);
                }
                com.opos.cmn.an.f.a.b("BlockBigImage4", "blockBigImage4 onWindowVisibilityChanged：" + z);
            }
        });
        this.m.addView(aVar2, new RelativeLayout.LayoutParams(0, 0));
    }

    public void o() {
        this.n.setVisibility(0);
        this.o.setVisibility(0);
        this.l.setVisibility(0);
    }

    @Override // com.opos.mobad.n.a
    public void a() {
    }

    @Override // com.opos.mobad.n.a
    public void a(a.InterfaceC0458a interfaceC0458a) {
        this.f22555g = interfaceC0458a;
        this.p.a(interfaceC0458a);
        this.o.a(interfaceC0458a);
        this.l.a(interfaceC0458a);
        y yVar = this.q;
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
                    com.opos.cmn.an.f.a.b("BlockBigImage4", "render");
                    if (this.f22558j == null && (interfaceC0458a = this.f22555g) != null) {
                        interfaceC0458a.e();
                    }
                    this.f22558j = a2;
                    com.opos.mobad.n.c.j jVar = this.t;
                    if (jVar != null && jVar.getVisibility() != 0) {
                        this.t.setVisibility(0);
                    }
                    RelativeLayout relativeLayout = this.m;
                    if (relativeLayout != null && relativeLayout.getVisibility() != 0) {
                        this.m.setVisibility(0);
                    }
                    a(a2);
                    return;
                }
                str = "imgList is null";
            }
        }
        com.opos.cmn.an.f.a.b("BlockBigImage4", str);
        this.f22555g.b(1);
    }

    @Override // com.opos.mobad.n.a
    public void b() {
    }

    @Override // com.opos.mobad.n.a
    public View c() {
        return this.t;
    }

    @Override // com.opos.mobad.n.a
    public void d() {
        com.opos.cmn.an.f.a.b("BlockBigImage4", "destroy");
        this.f22558j = null;
        this.f22549a = true;
        com.opos.mobad.n.c.j jVar = this.t;
        if (jVar != null) {
            jVar.removeAllViews();
        }
    }

    @Override // com.opos.mobad.n.a
    public int e() {
        return this.f22556h;
    }
}
