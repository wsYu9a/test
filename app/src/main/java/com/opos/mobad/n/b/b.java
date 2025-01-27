package com.opos.mobad.n.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.c.a;
import com.opos.mobad.c.d.a;
import com.opos.mobad.n.a;
import com.opos.mobad.n.c.g;
import com.opos.mobad.n.c.h;
import com.opos.mobad.n.c.j;
import com.opos.mobad.n.g.aj;
import java.util.List;

/* loaded from: classes4.dex */
public class b implements com.opos.mobad.n.a {

    /* renamed from: a */
    private volatile boolean f21935a = false;

    /* renamed from: b */
    private int f21936b = 360;

    /* renamed from: c */
    private int f21937c = 57;

    /* renamed from: d */
    private int f21938d;

    /* renamed from: e */
    private Context f21939e;

    /* renamed from: f */
    private a.InterfaceC0458a f21940f;

    /* renamed from: g */
    private int f21941g;

    /* renamed from: h */
    private int f21942h;

    /* renamed from: i */
    private com.opos.mobad.n.d.d f21943i;

    /* renamed from: j */
    private ImageView f21944j;
    private RelativeLayout k;
    private h l;
    private RelativeLayout m;
    private j n;
    private e o;
    private com.opos.mobad.c.a p;

    /* renamed from: com.opos.mobad.n.b.b$1 */
    class AnonymousClass1 extends g {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            if (b.this.f21940f != null) {
                b.this.f21940f.g(view, iArr);
            }
        }
    }

    /* renamed from: com.opos.mobad.n.b.b$2 */
    class AnonymousClass2 extends g {
        AnonymousClass2() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            if (b.this.f21940f != null) {
                b.this.f21940f.d(view, iArr);
            }
        }
    }

    /* renamed from: com.opos.mobad.n.b.b$3 */
    class AnonymousClass3 implements a.InterfaceC0428a {

        /* renamed from: a */
        final /* synthetic */ com.opos.mobad.c.d.a f21947a;

        AnonymousClass3(com.opos.mobad.c.d.a aVar) {
            aVar = aVar;
        }

        @Override // com.opos.mobad.c.d.a.InterfaceC0428a
        public void a(boolean z) {
            if (b.this.f21943i == null) {
                return;
            }
            if (z) {
                b.this.l();
                if (b.this.f21940f != null) {
                    b.this.f21940f.b();
                }
                aVar.a((a.InterfaceC0428a) null);
            }
            com.opos.cmn.an.f.a.b("BannerFullImage", "BannerFullImage onWindowVisibilityChanged：" + z);
        }
    }

    /* renamed from: com.opos.mobad.n.b.b$4 */
    class AnonymousClass4 implements a.InterfaceC0426a {

        /* renamed from: a */
        final /* synthetic */ com.opos.mobad.n.d.d f21949a;

        AnonymousClass4(com.opos.mobad.n.d.d dVar) {
            dVar = dVar;
        }

        @Override // com.opos.mobad.c.a.InterfaceC0426a
        public void a(int i2, Bitmap bitmap) {
            if (b.this.f21935a) {
                return;
            }
            if (dVar.f22075g.get(0) == null) {
                com.opos.cmn.an.f.a.b("BannerFullImage", "null imgList");
                return;
            }
            if (i2 != 0 && i2 != 1) {
                if (b.this.f21940f != null) {
                    b.this.f21940f.c(i2);
                }
            } else {
                if (i2 == 1 && b.this.f21940f != null) {
                    b.this.f21940f.c(i2);
                }
                b.this.a(bitmap);
            }
        }
    }

    /* renamed from: com.opos.mobad.n.b.b$5 */
    class AnonymousClass5 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Bitmap f21951a;

        AnonymousClass5(Bitmap bitmap) {
            bitmap = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bitmap bitmap;
            if (b.this.f21935a || (bitmap = bitmap) == null || bitmap.isRecycled()) {
                return;
            }
            b.this.f21944j.setImageBitmap(bitmap);
        }
    }

    private b(Context context, aj ajVar, int i2, int i3, com.opos.mobad.c.a aVar) {
        this.f21939e = context;
        this.f21942h = i3;
        this.f21941g = i2;
        this.p = aVar;
        f();
        a(ajVar);
        k();
    }

    public static b a(Context context, aj ajVar, int i2, com.opos.mobad.c.a aVar) {
        return new b(context, ajVar, i2, 0, aVar);
    }

    public void a(Bitmap bitmap) {
        com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.b.b.5

            /* renamed from: a */
            final /* synthetic */ Bitmap f21951a;

            AnonymousClass5(Bitmap bitmap2) {
                bitmap = bitmap2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Bitmap bitmap2;
                if (b.this.f21935a || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                    return;
                }
                b.this.f21944j.setImageBitmap(bitmap);
            }
        });
    }

    private void a(com.opos.mobad.n.d.d dVar) {
        c(dVar);
        b(dVar);
    }

    private void a(aj ajVar) {
        if (ajVar == null) {
            ajVar = aj.a(this.f21939e);
        }
        Context context = this.f21939e;
        int i2 = ajVar.f22455a;
        int i3 = ajVar.f22456b;
        int i4 = this.f21936b;
        this.n = new j(context, new j.a(i2, i3, i4, i4 / this.f21938d));
        this.k = new RelativeLayout(this.f21939e);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.f21936b, -2);
        layoutParams.width = this.f21936b;
        layoutParams.height = -2;
        this.k.setId(View.generateViewId());
        this.k.setLayoutParams(layoutParams);
        this.k.setVisibility(8);
        this.n.addView(this.k, layoutParams);
        this.n.setLayoutParams(layoutParams);
        i();
        h();
        g();
        AnonymousClass1 anonymousClass1 = new g() { // from class: com.opos.mobad.n.b.b.1
            AnonymousClass1() {
            }

            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (b.this.f21940f != null) {
                    b.this.f21940f.g(view, iArr);
                }
            }
        };
        this.k.setOnClickListener(anonymousClass1);
        this.k.setOnTouchListener(anonymousClass1);
    }

    private void b(com.opos.mobad.n.d.d dVar) {
        this.o.a(dVar.r, dVar.s, dVar.f22077i, dVar.f22078j, dVar.k);
    }

    private void c(com.opos.mobad.n.d.d dVar) {
        ImageView imageView;
        List<com.opos.mobad.n.d.g> list = dVar.f22075g;
        if (list == null || list.size() == 0 || (imageView = this.f21944j) == null) {
            return;
        }
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.p.a(dVar.f22075g.get(0).f22084a, dVar.f22075g.get(0).f22085b, this.f21936b, this.f21937c, new a.InterfaceC0426a() { // from class: com.opos.mobad.n.b.b.4

            /* renamed from: a */
            final /* synthetic */ com.opos.mobad.n.d.d f21949a;

            AnonymousClass4(com.opos.mobad.n.d.d dVar2) {
                dVar = dVar2;
            }

            @Override // com.opos.mobad.c.a.InterfaceC0426a
            public void a(int i2, Bitmap bitmap) {
                if (b.this.f21935a) {
                    return;
                }
                if (dVar.f22075g.get(0) == null) {
                    com.opos.cmn.an.f.a.b("BannerFullImage", "null imgList");
                    return;
                }
                if (i2 != 0 && i2 != 1) {
                    if (b.this.f21940f != null) {
                        b.this.f21940f.c(i2);
                    }
                } else {
                    if (i2 == 1 && b.this.f21940f != null) {
                        b.this.f21940f.c(i2);
                    }
                    b.this.a(bitmap);
                }
            }
        });
    }

    private void f() {
        if (this.f21942h == 0) {
            this.f21936b = com.opos.cmn.an.h.f.a.a(this.f21939e, 360.0f);
            this.f21937c = com.opos.cmn.an.h.f.a.a(this.f21939e, 57.0f);
        }
        this.f21938d = this.f21937c;
    }

    private void g() {
        this.m = new RelativeLayout(this.f21939e);
        ImageView imageView = new ImageView(this.f21939e);
        this.m.setId(View.generateViewId());
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageResource(R.drawable.opos_mobad_drawable_block_close);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f21939e, 16.0f), com.opos.cmn.an.h.f.a.a(this.f21939e, 16.0f));
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.f21939e, 4.0f);
        AnonymousClass2 anonymousClass2 = new g() { // from class: com.opos.mobad.n.b.b.2
            AnonymousClass2() {
            }

            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (b.this.f21940f != null) {
                    b.this.f21940f.d(view, iArr);
                }
            }
        };
        imageView.setOnTouchListener(anonymousClass2);
        imageView.setOnClickListener(anonymousClass2);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.f21936b, -2);
        this.m.addView(imageView, layoutParams);
        this.k.addView(this.m, layoutParams2);
    }

    private void h() {
        this.o = e.a(this.f21939e);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(this.f21939e, 11.0f));
        layoutParams.addRule(9);
        this.k.addView(this.o, layoutParams);
    }

    private void i() {
        h hVar = new h(this.f21939e);
        this.l = hVar;
        hVar.setId(View.generateViewId());
        this.l.setBackgroundColor(this.f21939e.getResources().getColor(R.color.opos_mobad_root_bg_color));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f21936b, this.f21937c);
        this.l.setVisibility(4);
        this.k.addView(this.l, layoutParams);
        j();
    }

    private void j() {
        ImageView imageView = new ImageView(this.f21939e);
        this.f21944j = imageView;
        imageView.setId(View.generateViewId());
        this.l.addView(this.f21944j, new RelativeLayout.LayoutParams(this.f21936b, this.f21937c));
    }

    private void k() {
        com.opos.mobad.c.d.a aVar = new com.opos.mobad.c.d.a(this.f21939e);
        aVar.a(new a.InterfaceC0428a() { // from class: com.opos.mobad.n.b.b.3

            /* renamed from: a */
            final /* synthetic */ com.opos.mobad.c.d.a f21947a;

            AnonymousClass3(com.opos.mobad.c.d.a aVar2) {
                aVar = aVar2;
            }

            @Override // com.opos.mobad.c.d.a.InterfaceC0428a
            public void a(boolean z) {
                if (b.this.f21943i == null) {
                    return;
                }
                if (z) {
                    b.this.l();
                    if (b.this.f21940f != null) {
                        b.this.f21940f.b();
                    }
                    aVar.a((a.InterfaceC0428a) null);
                }
                com.opos.cmn.an.f.a.b("BannerFullImage", "BannerFullImage onWindowVisibilityChanged：" + z);
            }
        });
        this.k.addView(aVar2, new RelativeLayout.LayoutParams(0, 0));
    }

    public void l() {
        this.l.setVisibility(0);
    }

    @Override // com.opos.mobad.n.a
    public void a() {
    }

    @Override // com.opos.mobad.n.a
    public void a(a.InterfaceC0458a interfaceC0458a) {
        this.f21940f = interfaceC0458a;
        this.o.a(interfaceC0458a);
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
                    com.opos.cmn.an.f.a.b("BannerFullImage", "render");
                    if (this.f21943i == null && (interfaceC0458a = this.f21940f) != null) {
                        interfaceC0458a.e();
                    }
                    this.f21943i = a2;
                    j jVar = this.n;
                    if (jVar != null && jVar.getVisibility() != 0) {
                        this.n.setVisibility(0);
                    }
                    RelativeLayout relativeLayout = this.k;
                    if (relativeLayout != null && relativeLayout.getVisibility() != 0) {
                        this.k.setVisibility(0);
                    }
                    a(a2);
                    return;
                }
                str = "imgList is null";
            }
        }
        com.opos.cmn.an.f.a.b("BannerFullImage", str);
        this.f21940f.b(1);
    }

    @Override // com.opos.mobad.n.a
    public void b() {
    }

    @Override // com.opos.mobad.n.a
    public View c() {
        return this.n;
    }

    @Override // com.opos.mobad.n.a
    public void d() {
        com.opos.cmn.an.f.a.b("BannerFullImage", "destroy");
        this.f21943i = null;
        this.f21935a = true;
        j jVar = this.n;
        if (jVar != null) {
            jVar.removeAllViews();
        }
    }

    @Override // com.opos.mobad.n.a
    public int e() {
        return this.f21941g;
    }
}
