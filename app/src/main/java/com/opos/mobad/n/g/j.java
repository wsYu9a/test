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
public class j implements com.opos.mobad.n.a {

    /* renamed from: e */
    private int f22604e;

    /* renamed from: f */
    private Context f22605f;

    /* renamed from: g */
    private a.InterfaceC0458a f22606g;

    /* renamed from: h */
    private int f22607h;

    /* renamed from: i */
    private int f22608i;

    /* renamed from: j */
    private com.opos.mobad.n.d.d f22609j;
    private ImageView k;
    private RelativeLayout l;
    private com.opos.mobad.n.c.h m;
    private w n;
    private z o;
    private y p;
    private RelativeLayout q;
    private com.opos.mobad.n.c.j s;
    private com.opos.mobad.c.a t;

    /* renamed from: a */
    private volatile boolean f22600a = false;

    /* renamed from: b */
    private int f22601b = 320;

    /* renamed from: c */
    private int f22602c = 60;

    /* renamed from: d */
    private int f22603d = 0;
    private boolean r = false;

    /* renamed from: com.opos.mobad.n.g.j$1 */
    class AnonymousClass1 extends com.opos.mobad.n.c.g {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            if (j.this.f22606g != null) {
                j.this.f22606g.g(view, iArr);
            }
        }
    }

    /* renamed from: com.opos.mobad.n.g.j$2 */
    class AnonymousClass2 extends com.opos.mobad.n.c.g {
        AnonymousClass2() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            if (j.this.f22606g != null) {
                j.this.f22606g.d(view, iArr);
            }
        }
    }

    /* renamed from: com.opos.mobad.n.g.j$3 */
    class AnonymousClass3 implements a.InterfaceC0428a {

        /* renamed from: a */
        final /* synthetic */ com.opos.mobad.c.d.a f22612a;

        AnonymousClass3(com.opos.mobad.c.d.a aVar) {
            aVar = aVar;
        }

        @Override // com.opos.mobad.c.d.a.InterfaceC0428a
        public void a(boolean z) {
            if (j.this.f22609j == null) {
                return;
            }
            if (z) {
                j.this.n();
                if (j.this.f22606g != null) {
                    j.this.f22606g.b();
                }
                aVar.a((a.InterfaceC0428a) null);
            }
            com.opos.cmn.an.f.a.b("BlockBigImage7", "blockBigImage7 onWindowVisibilityChanged：" + z);
        }
    }

    /* renamed from: com.opos.mobad.n.g.j$4 */
    class AnonymousClass4 implements a.InterfaceC0426a {

        /* renamed from: a */
        final /* synthetic */ com.opos.mobad.n.d.d f22614a;

        /* renamed from: com.opos.mobad.n.g.j$4$1 */
        class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Bitmap f22616a;

            AnonymousClass1(Bitmap bitmap) {
                bitmap = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Bitmap bitmap;
                if (j.this.f22600a || (bitmap = bitmap) == null || bitmap.isRecycled()) {
                    return;
                }
                j.this.k.setImageBitmap(bitmap);
            }
        }

        AnonymousClass4(com.opos.mobad.n.d.d dVar) {
            dVar = dVar;
        }

        @Override // com.opos.mobad.c.a.InterfaceC0426a
        public void a(int i2, Bitmap bitmap) {
            if (j.this.f22600a) {
                return;
            }
            if (dVar.f22075g.get(0) == null) {
                com.opos.cmn.an.f.a.b("BlockBigImage7", "null imgList");
                return;
            }
            if (i2 != 0 && i2 != 1) {
                if (j.this.f22606g != null) {
                    j.this.f22606g.c(i2);
                }
            } else {
                if (i2 == 1 && j.this.f22606g != null) {
                    j.this.f22606g.c(i2);
                }
                com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.g.j.4.1

                    /* renamed from: a */
                    final /* synthetic */ Bitmap f22616a;

                    AnonymousClass1(Bitmap bitmap2) {
                        bitmap = bitmap2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Bitmap bitmap2;
                        if (j.this.f22600a || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                            return;
                        }
                        j.this.k.setImageBitmap(bitmap);
                    }
                });
            }
        }
    }

    private j(Context context, aj ajVar, int i2, int i3, com.opos.mobad.c.a aVar) {
        this.f22605f = context;
        this.f22608i = i3;
        this.f22607h = i2;
        this.t = aVar;
        f();
        a(ajVar);
        m();
    }

    public static j a(Context context, aj ajVar, int i2, com.opos.mobad.c.a aVar) {
        return new j(context, ajVar, i2, 0, aVar);
    }

    private void a(com.opos.mobad.n.d.d dVar) {
        c(dVar);
        if (this.r) {
            b(dVar);
        } else {
            d(dVar);
        }
        e(dVar);
    }

    private void a(aj ajVar) {
        if (ajVar == null) {
            ajVar = aj.a(this.f22605f);
        }
        Context context = this.f22605f;
        int i2 = ajVar.f22455a;
        int i3 = ajVar.f22456b;
        int i4 = this.f22601b;
        this.s = new com.opos.mobad.n.c.j(context, new j.a(i2, i3, i4, i4 / this.f22604e));
        this.l = new RelativeLayout(this.f22605f);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.f22601b, -2);
        layoutParams.width = this.f22601b;
        layoutParams.height = -2;
        this.l.setId(View.generateViewId());
        this.l.setLayoutParams(layoutParams);
        this.l.setVisibility(8);
        this.s.addView(this.l, layoutParams);
        this.s.setLayoutParams(layoutParams);
        g();
        h();
        l();
        AnonymousClass1 anonymousClass1 = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.g.j.1
            AnonymousClass1() {
            }

            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (j.this.f22606g != null) {
                    j.this.f22606g.g(view, iArr);
                }
            }
        };
        this.l.setOnClickListener(anonymousClass1);
        this.l.setOnTouchListener(anonymousClass1);
    }

    public static j b(Context context, aj ajVar, int i2, com.opos.mobad.c.a aVar) {
        return new j(context, ajVar, i2, 1, aVar);
    }

    private void b(com.opos.mobad.n.d.d dVar) {
        y yVar;
        List<com.opos.mobad.n.d.g> list = dVar.f22075g;
        if (list == null || list.size() == 0 || (yVar = this.p) == null) {
            return;
        }
        yVar.a(dVar, this.t, this.f22600a, dVar.z);
    }

    public static j c(Context context, aj ajVar, int i2, com.opos.mobad.c.a aVar) {
        return new j(context, ajVar, i2, 2, aVar);
    }

    private void c(com.opos.mobad.n.d.d dVar) {
        this.n.a(dVar.l, dVar.f22074f, dVar.f22073e);
    }

    private void d(com.opos.mobad.n.d.d dVar) {
        ImageView imageView;
        List<com.opos.mobad.n.d.g> list = dVar.f22075g;
        if (list == null || list.size() == 0 || (imageView = this.k) == null) {
            return;
        }
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.t.a(dVar.f22075g.get(0).f22084a, dVar.f22075g.get(0).f22085b, this.f22601b, this.f22602c, new a.InterfaceC0426a() { // from class: com.opos.mobad.n.g.j.4

            /* renamed from: a */
            final /* synthetic */ com.opos.mobad.n.d.d f22614a;

            /* renamed from: com.opos.mobad.n.g.j$4$1 */
            class AnonymousClass1 implements Runnable {

                /* renamed from: a */
                final /* synthetic */ Bitmap f22616a;

                AnonymousClass1(Bitmap bitmap2) {
                    bitmap = bitmap2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Bitmap bitmap2;
                    if (j.this.f22600a || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                        return;
                    }
                    j.this.k.setImageBitmap(bitmap);
                }
            }

            AnonymousClass4(com.opos.mobad.n.d.d dVar2) {
                dVar = dVar2;
            }

            @Override // com.opos.mobad.c.a.InterfaceC0426a
            public void a(int i2, Bitmap bitmap2) {
                if (j.this.f22600a) {
                    return;
                }
                if (dVar.f22075g.get(0) == null) {
                    com.opos.cmn.an.f.a.b("BlockBigImage7", "null imgList");
                    return;
                }
                if (i2 != 0 && i2 != 1) {
                    if (j.this.f22606g != null) {
                        j.this.f22606g.c(i2);
                    }
                } else {
                    if (i2 == 1 && j.this.f22606g != null) {
                        j.this.f22606g.c(i2);
                    }
                    com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.g.j.4.1

                        /* renamed from: a */
                        final /* synthetic */ Bitmap f22616a;

                        AnonymousClass1(Bitmap bitmap22) {
                            bitmap = bitmap22;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Bitmap bitmap22;
                            if (j.this.f22600a || (bitmap22 = bitmap) == null || bitmap22.isRecycled()) {
                                return;
                            }
                            j.this.k.setImageBitmap(bitmap);
                        }
                    });
                }
            }
        });
    }

    private void e(com.opos.mobad.n.d.d dVar) {
        z zVar;
        com.opos.mobad.n.d.a aVar = dVar.v;
        if (aVar == null || TextUtils.isEmpty(aVar.f22065a) || TextUtils.isEmpty(aVar.f22066b) || (zVar = this.o) == null) {
            return;
        }
        zVar.setVisibility(0);
        this.o.a(aVar.f22065a, aVar.f22066b);
    }

    private void f() {
        int a2;
        this.f22603d = com.opos.cmn.an.h.f.a.a(this.f22605f, 106.67f);
        int i2 = this.f22608i;
        if (i2 == 0) {
            this.f22601b = com.opos.cmn.an.h.f.a.a(this.f22605f, 320.0f);
            a2 = com.opos.cmn.an.h.f.a.a(this.f22605f, 60.0f);
        } else {
            if (i2 != 1) {
                if (i2 == 2) {
                    this.f22601b = com.opos.cmn.an.h.f.a.a(this.f22605f, 320.0f);
                    this.f22602c = com.opos.cmn.an.h.f.a.a(this.f22605f, 70.0f);
                    this.r = true;
                }
                this.f22604e = this.f22602c + com.opos.cmn.an.h.f.a.a(this.f22605f, 16.0f) + com.opos.cmn.an.h.f.a.a(this.f22605f, 24.0f);
            }
            this.f22601b = com.opos.cmn.an.h.f.a.a(this.f22605f, 320.0f);
            a2 = com.opos.cmn.an.h.f.a.a(this.f22605f, 70.0f);
        }
        this.f22602c = a2;
        this.f22604e = this.f22602c + com.opos.cmn.an.h.f.a.a(this.f22605f, 16.0f) + com.opos.cmn.an.h.f.a.a(this.f22605f, 24.0f);
    }

    private void g() {
        this.q = new RelativeLayout(this.f22605f);
        ImageView imageView = new ImageView(this.f22605f);
        this.q.setId(View.generateViewId());
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageResource(R.drawable.opos_mobad_drawable_block_close);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f22605f, 16.0f), com.opos.cmn.an.h.f.a.a(this.f22605f, 16.0f));
        layoutParams.addRule(11);
        AnonymousClass2 anonymousClass2 = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.g.j.2
            AnonymousClass2() {
            }

            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (j.this.f22606g != null) {
                    j.this.f22606g.d(view, iArr);
                }
            }
        };
        imageView.setOnTouchListener(anonymousClass2);
        imageView.setOnClickListener(anonymousClass2);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.f22601b, -2);
        this.q.addView(imageView, layoutParams);
        this.l.addView(this.q, layoutParams2);
    }

    private void h() {
        com.opos.mobad.n.c.h hVar = new com.opos.mobad.n.c.h(this.f22605f);
        this.m = hVar;
        hVar.a(com.opos.cmn.an.h.f.a.a(this.f22605f, 10.0f));
        this.m.setId(View.generateViewId());
        this.m.setBackgroundColor(this.f22605f.getResources().getColor(R.color.opos_mobad_root_bg_color));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f22601b, this.f22602c);
        this.m.setVisibility(4);
        layoutParams.addRule(3, this.q.getId());
        this.l.addView(this.m, layoutParams);
        if (this.r) {
            j();
        } else {
            k();
        }
        i();
    }

    private void i() {
        int id;
        w a2 = w.a(this.f22605f);
        this.n = a2;
        a2.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f22601b - this.f22603d, -2);
        layoutParams.addRule(15);
        if (this.r) {
            y yVar = this.p;
            if (yVar != null) {
                id = yVar.getId();
                layoutParams.addRule(1, id);
            }
        } else {
            ImageView imageView = this.k;
            if (imageView != null) {
                id = imageView.getId();
                layoutParams.addRule(1, id);
            }
        }
        this.n.setVisibility(4);
        this.m.addView(this.n, layoutParams);
    }

    private void j() {
        y a2 = y.a(this.f22605f, this.f22603d, this.f22602c, false);
        this.p = a2;
        a2.setId(View.generateViewId());
        int i2 = this.f22603d;
        this.m.addView(this.p, new RelativeLayout.LayoutParams(i2, i2));
    }

    private void k() {
        ImageView imageView = new ImageView(this.f22605f);
        this.k = imageView;
        imageView.setId(View.generateViewId());
        this.m.addView(this.k, new RelativeLayout.LayoutParams(this.f22603d, this.f22602c));
    }

    private void l() {
        this.o = z.c(this.f22605f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f22601b, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(3, this.m.getId());
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f22605f, 10.0f);
        this.o.setGravity(1);
        this.o.setVisibility(4);
        this.l.addView(this.o, layoutParams);
    }

    private void m() {
        com.opos.mobad.c.d.a aVar = new com.opos.mobad.c.d.a(this.f22605f);
        aVar.a(new a.InterfaceC0428a() { // from class: com.opos.mobad.n.g.j.3

            /* renamed from: a */
            final /* synthetic */ com.opos.mobad.c.d.a f22612a;

            AnonymousClass3(com.opos.mobad.c.d.a aVar2) {
                aVar = aVar2;
            }

            @Override // com.opos.mobad.c.d.a.InterfaceC0428a
            public void a(boolean z) {
                if (j.this.f22609j == null) {
                    return;
                }
                if (z) {
                    j.this.n();
                    if (j.this.f22606g != null) {
                        j.this.f22606g.b();
                    }
                    aVar.a((a.InterfaceC0428a) null);
                }
                com.opos.cmn.an.f.a.b("BlockBigImage7", "blockBigImage7 onWindowVisibilityChanged：" + z);
            }
        });
        this.l.addView(aVar2, new RelativeLayout.LayoutParams(0, 0));
    }

    public void n() {
        this.m.setVisibility(0);
        this.n.setVisibility(0);
    }

    @Override // com.opos.mobad.n.a
    public void a() {
    }

    @Override // com.opos.mobad.n.a
    public void a(a.InterfaceC0458a interfaceC0458a) {
        this.f22606g = interfaceC0458a;
        this.o.a(interfaceC0458a);
        this.n.a(interfaceC0458a);
        y yVar = this.p;
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
                    com.opos.cmn.an.f.a.b("BlockBigImage7", "render");
                    if (this.f22609j == null && (interfaceC0458a = this.f22606g) != null) {
                        interfaceC0458a.e();
                    }
                    this.f22609j = a2;
                    com.opos.mobad.n.c.j jVar = this.s;
                    if (jVar != null && jVar.getVisibility() != 0) {
                        this.s.setVisibility(0);
                    }
                    RelativeLayout relativeLayout = this.l;
                    if (relativeLayout != null && relativeLayout.getVisibility() != 0) {
                        this.l.setVisibility(0);
                    }
                    a(a2);
                    return;
                }
                str = "imgList is null";
            }
        }
        com.opos.cmn.an.f.a.b("BlockBigImage7", str);
        this.f22606g.b(1);
    }

    @Override // com.opos.mobad.n.a
    public void b() {
    }

    @Override // com.opos.mobad.n.a
    public View c() {
        return this.s;
    }

    @Override // com.opos.mobad.n.a
    public void d() {
        com.opos.cmn.an.f.a.b("BlockBigImage7", "destroy");
        this.f22609j = null;
        this.f22600a = true;
        com.opos.mobad.n.c.j jVar = this.s;
        if (jVar != null) {
            jVar.removeAllViews();
        }
    }

    @Override // com.opos.mobad.n.a
    public int e() {
        return this.f22607h;
    }
}
