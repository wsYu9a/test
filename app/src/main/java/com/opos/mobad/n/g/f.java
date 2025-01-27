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
public class f implements com.opos.mobad.n.a {

    /* renamed from: e */
    private int f22536e;

    /* renamed from: f */
    private Context f22537f;

    /* renamed from: g */
    private a.InterfaceC0458a f22538g;

    /* renamed from: h */
    private int f22539h;

    /* renamed from: i */
    private int f22540i;

    /* renamed from: j */
    private com.opos.mobad.n.d.d f22541j;
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
    private volatile boolean f22532a = false;

    /* renamed from: b */
    private int f22533b = 256;

    /* renamed from: c */
    private int f22534c = 144;

    /* renamed from: d */
    private int f22535d = 64;
    private boolean s = false;

    /* renamed from: com.opos.mobad.n.g.f$1 */
    class AnonymousClass1 extends com.opos.mobad.n.c.g {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            if (f.this.f22538g != null) {
                f.this.f22538g.g(view, iArr);
            }
        }
    }

    /* renamed from: com.opos.mobad.n.g.f$2 */
    class AnonymousClass2 implements a.InterfaceC0428a {

        /* renamed from: a */
        final /* synthetic */ com.opos.mobad.c.d.a f22543a;

        AnonymousClass2(com.opos.mobad.c.d.a aVar) {
            aVar = aVar;
        }

        @Override // com.opos.mobad.c.d.a.InterfaceC0428a
        public void a(boolean z) {
            if (f.this.f22541j == null) {
                return;
            }
            if (z) {
                f.this.o();
                if (f.this.f22538g != null) {
                    f.this.f22538g.b();
                }
                aVar.a((a.InterfaceC0428a) null);
            }
            com.opos.cmn.an.f.a.b("BlockBigImage3", "blockBigImage3 onWindowVisibilityChanged：" + z);
        }
    }

    /* renamed from: com.opos.mobad.n.g.f$3 */
    class AnonymousClass3 implements a.InterfaceC0426a {

        /* renamed from: a */
        final /* synthetic */ com.opos.mobad.n.d.d f22545a;

        /* renamed from: com.opos.mobad.n.g.f$3$1 */
        class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Bitmap f22547a;

            AnonymousClass1(Bitmap bitmap) {
                bitmap = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Bitmap bitmap;
                if (f.this.f22532a || (bitmap = bitmap) == null || bitmap.isRecycled()) {
                    return;
                }
                f.this.k.setImageBitmap(bitmap);
            }
        }

        AnonymousClass3(com.opos.mobad.n.d.d dVar) {
            dVar = dVar;
        }

        @Override // com.opos.mobad.c.a.InterfaceC0426a
        public void a(int i2, Bitmap bitmap) {
            if (f.this.f22532a) {
                return;
            }
            if (dVar.f22075g.get(0) == null) {
                com.opos.cmn.an.f.a.b("BlockBigImage3", "null imgList");
                return;
            }
            if (i2 != 0 && i2 != 1) {
                if (f.this.f22538g != null) {
                    f.this.f22538g.c(i2);
                }
            } else {
                if (i2 == 1 && f.this.f22538g != null) {
                    f.this.f22538g.c(i2);
                }
                com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.g.f.3.1

                    /* renamed from: a */
                    final /* synthetic */ Bitmap f22547a;

                    AnonymousClass1(Bitmap bitmap2) {
                        bitmap = bitmap2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Bitmap bitmap2;
                        if (f.this.f22532a || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                            return;
                        }
                        f.this.k.setImageBitmap(bitmap);
                    }
                });
            }
        }
    }

    private f(Context context, aj ajVar, int i2, int i3, com.opos.mobad.c.a aVar) {
        this.f22537f = context;
        this.f22540i = i3;
        this.f22539h = i2;
        this.u = aVar;
        f();
        a(ajVar);
        n();
    }

    public static f a(Context context, aj ajVar, int i2, com.opos.mobad.c.a aVar) {
        return new f(context, ajVar, i2, 0, aVar);
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
            ajVar = aj.a(this.f22537f);
        }
        Context context = this.f22537f;
        int i2 = ajVar.f22455a;
        int i3 = ajVar.f22456b;
        int i4 = this.f22533b;
        this.t = new com.opos.mobad.n.c.j(context, new j.a(i2, i3, i4, i4 / this.f22536e));
        this.m = new RelativeLayout(this.f22537f);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.f22533b, -2);
        layoutParams.width = this.f22533b;
        layoutParams.height = -2;
        this.m.setId(View.generateViewId());
        this.m.setLayoutParams(layoutParams);
        this.m.setVisibility(8);
        this.t.addView(this.m, layoutParams);
        this.t.setLayoutParams(layoutParams);
        g();
        m();
        AnonymousClass1 anonymousClass1 = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.g.f.1
            AnonymousClass1() {
            }

            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (f.this.f22538g != null) {
                    f.this.f22538g.g(view, iArr);
                }
            }
        };
        this.m.setOnClickListener(anonymousClass1);
        this.m.setOnTouchListener(anonymousClass1);
    }

    public static f b(Context context, aj ajVar, int i2, com.opos.mobad.c.a aVar) {
        return new f(context, ajVar, i2, 1, aVar);
    }

    private void b(com.opos.mobad.n.d.d dVar) {
        y yVar;
        List<com.opos.mobad.n.d.g> list = dVar.f22075g;
        if (list == null || list.size() == 0 || (yVar = this.q) == null) {
            return;
        }
        yVar.a(dVar, this.u, this.f22532a, dVar.z);
    }

    public static f c(Context context, aj ajVar, int i2, com.opos.mobad.c.a aVar) {
        return new f(context, ajVar, i2, 2, aVar);
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
        this.u.a(dVar.f22075g.get(0).f22084a, dVar.f22075g.get(0).f22085b, this.f22533b, this.f22534c, new a.InterfaceC0426a() { // from class: com.opos.mobad.n.g.f.3

            /* renamed from: a */
            final /* synthetic */ com.opos.mobad.n.d.d f22545a;

            /* renamed from: com.opos.mobad.n.g.f$3$1 */
            class AnonymousClass1 implements Runnable {

                /* renamed from: a */
                final /* synthetic */ Bitmap f22547a;

                AnonymousClass1(Bitmap bitmap2) {
                    bitmap = bitmap2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Bitmap bitmap2;
                    if (f.this.f22532a || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                        return;
                    }
                    f.this.k.setImageBitmap(bitmap);
                }
            }

            AnonymousClass3(com.opos.mobad.n.d.d dVar2) {
                dVar = dVar2;
            }

            @Override // com.opos.mobad.c.a.InterfaceC0426a
            public void a(int i2, Bitmap bitmap2) {
                if (f.this.f22532a) {
                    return;
                }
                if (dVar.f22075g.get(0) == null) {
                    com.opos.cmn.an.f.a.b("BlockBigImage3", "null imgList");
                    return;
                }
                if (i2 != 0 && i2 != 1) {
                    if (f.this.f22538g != null) {
                        f.this.f22538g.c(i2);
                    }
                } else {
                    if (i2 == 1 && f.this.f22538g != null) {
                        f.this.f22538g.c(i2);
                    }
                    com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.g.f.3.1

                        /* renamed from: a */
                        final /* synthetic */ Bitmap f22547a;

                        AnonymousClass1(Bitmap bitmap22) {
                            bitmap = bitmap22;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Bitmap bitmap22;
                            if (f.this.f22532a || (bitmap22 = bitmap) == null || bitmap22.isRecycled()) {
                                return;
                            }
                            f.this.k.setImageBitmap(bitmap);
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
        this.f22535d = com.opos.cmn.an.h.f.a.a(this.f22537f, 64.0f);
        int i2 = this.f22540i;
        if (i2 == 0) {
            this.f22533b = com.opos.cmn.an.h.f.a.a(this.f22537f, 256.0f);
            a2 = com.opos.cmn.an.h.f.a.a(this.f22537f, 144.0f);
        } else {
            if (i2 != 1) {
                if (i2 == 2) {
                    this.f22533b = com.opos.cmn.an.h.f.a.a(this.f22537f, 256.0f);
                    this.f22534c = com.opos.cmn.an.h.f.a.a(this.f22537f, 168.0f);
                    this.s = true;
                }
                this.f22536e = this.f22534c + com.opos.cmn.an.h.f.a.a(this.f22537f, 24.0f);
            }
            this.f22533b = com.opos.cmn.an.h.f.a.a(this.f22537f, 256.0f);
            a2 = com.opos.cmn.an.h.f.a.a(this.f22537f, 168.0f);
        }
        this.f22534c = a2;
        this.f22536e = this.f22534c + com.opos.cmn.an.h.f.a.a(this.f22537f, 24.0f);
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
        com.opos.mobad.n.c.h hVar = new com.opos.mobad.n.c.h(this.f22537f);
        this.n = hVar;
        hVar.a(com.opos.cmn.an.h.f.a.a(this.f22537f, 14.0f));
        this.n.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f22533b, this.f22534c);
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
        u a2 = u.a(this.f22537f);
        this.o = a2;
        a2.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f22533b, com.opos.cmn.an.h.f.a.a(this.f22537f, 26.0f));
        layoutParams.addRule(12);
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f22537f, 12.0f);
        this.o.setVisibility(4);
        this.n.addView(this.o, layoutParams);
    }

    private void i() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f22537f);
        this.r = relativeLayout;
        relativeLayout.setBackgroundResource(R.drawable.opos_mobad_drawable_shape_gradient);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f22533b, this.f22535d);
        this.r.setVisibility(0);
        layoutParams.addRule(12);
        this.n.addView(this.r, layoutParams);
    }

    private void j() {
        this.q = y.a(this.f22537f, this.f22533b, this.f22534c, true);
        this.n.addView(this.q, new RelativeLayout.LayoutParams(this.f22533b, this.f22534c));
    }

    private void k() {
        this.k = new ImageView(this.f22537f);
        this.n.addView(this.k, new RelativeLayout.LayoutParams(this.f22533b, this.f22534c));
    }

    private void l() {
        this.l = af.a(this.f22537f, false);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f22533b, -2);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f22537f, 12.0f);
        this.l.setVisibility(4);
        this.n.addView(this.l, layoutParams);
    }

    private void m() {
        this.p = z.b(this.f22537f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f22533b, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(3, this.n.getId());
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f22537f, 10.0f);
        this.p.setGravity(1);
        this.p.setVisibility(4);
        this.m.addView(this.p, layoutParams);
    }

    private void n() {
        com.opos.mobad.c.d.a aVar = new com.opos.mobad.c.d.a(this.f22537f);
        aVar.a(new a.InterfaceC0428a() { // from class: com.opos.mobad.n.g.f.2

            /* renamed from: a */
            final /* synthetic */ com.opos.mobad.c.d.a f22543a;

            AnonymousClass2(com.opos.mobad.c.d.a aVar2) {
                aVar = aVar2;
            }

            @Override // com.opos.mobad.c.d.a.InterfaceC0428a
            public void a(boolean z) {
                if (f.this.f22541j == null) {
                    return;
                }
                if (z) {
                    f.this.o();
                    if (f.this.f22538g != null) {
                        f.this.f22538g.b();
                    }
                    aVar.a((a.InterfaceC0428a) null);
                }
                com.opos.cmn.an.f.a.b("BlockBigImage3", "blockBigImage3 onWindowVisibilityChanged：" + z);
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
        this.f22538g = interfaceC0458a;
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
                    com.opos.cmn.an.f.a.b("BlockBigImage3", "render");
                    if (this.f22541j == null && (interfaceC0458a = this.f22538g) != null) {
                        interfaceC0458a.e();
                    }
                    this.f22541j = a2;
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
        com.opos.cmn.an.f.a.b("BlockBigImage3", str);
        this.f22538g.b(1);
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
        com.opos.cmn.an.f.a.b("BlockBigImage3", "destroy");
        this.f22541j = null;
        this.f22532a = true;
        com.opos.mobad.n.c.j jVar = this.t;
        if (jVar != null) {
            jVar.removeAllViews();
        }
    }

    @Override // com.opos.mobad.n.a
    public int e() {
        return this.f22539h;
    }
}
