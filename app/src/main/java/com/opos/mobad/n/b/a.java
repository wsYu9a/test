package com.opos.mobad.n.b;

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
import com.opos.mobad.n.c.f;
import com.opos.mobad.n.c.g;
import com.opos.mobad.n.c.j;
import com.opos.mobad.n.d.h;
import com.opos.mobad.n.g.aj;
import com.opos.mobad.n.g.y;
import java.util.List;

/* loaded from: classes4.dex */
public class a implements com.opos.mobad.n.a {

    /* renamed from: e */
    private int f21917e;

    /* renamed from: f */
    private Context f21918f;

    /* renamed from: g */
    private a.InterfaceC0458a f21919g;

    /* renamed from: h */
    private int f21920h;

    /* renamed from: i */
    private int f21921i;

    /* renamed from: j */
    private com.opos.mobad.n.d.d f21922j;
    private ImageView k;
    private RelativeLayout l;
    private RelativeLayout m;
    private d n;
    private y o;
    private RelativeLayout p;
    private j r;
    private f s;
    private RelativeLayout t;
    private e u;
    private com.opos.mobad.c.a v;

    /* renamed from: a */
    private volatile boolean f21913a = false;

    /* renamed from: b */
    private int f21914b = 360;

    /* renamed from: c */
    private int f21915c = 60;

    /* renamed from: d */
    private int f21916d = 0;
    private boolean q = false;

    /* renamed from: com.opos.mobad.n.b.a$1 */
    class AnonymousClass1 extends g {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            if (a.this.f21919g != null) {
                a.this.f21919g.g(view, iArr);
            }
        }
    }

    /* renamed from: com.opos.mobad.n.b.a$2 */
    class AnonymousClass2 extends g {
        AnonymousClass2() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            if (a.this.f21919g != null) {
                a.this.f21919g.d(view, iArr);
            }
        }
    }

    /* renamed from: com.opos.mobad.n.b.a$3 */
    class AnonymousClass3 implements a.InterfaceC0428a {

        /* renamed from: a */
        final /* synthetic */ com.opos.mobad.c.d.a f21925a;

        AnonymousClass3(com.opos.mobad.c.d.a aVar) {
            aVar = aVar;
        }

        @Override // com.opos.mobad.c.d.a.InterfaceC0428a
        public void a(boolean z) {
            if (a.this.f21922j == null) {
                return;
            }
            if (z) {
                if (a.this.f21919g != null) {
                    a.this.f21919g.b();
                }
                aVar.a((a.InterfaceC0428a) null);
            }
            com.opos.cmn.an.f.a.b("BannerBigImage", "blockBigImage7 onWindowVisibilityChanged：" + z);
        }
    }

    /* renamed from: com.opos.mobad.n.b.a$4 */
    class AnonymousClass4 implements a.InterfaceC0426a {

        /* renamed from: a */
        final /* synthetic */ boolean f21927a;

        AnonymousClass4(boolean z) {
            z = z;
        }

        @Override // com.opos.mobad.c.a.InterfaceC0426a
        public void a(int i2, Bitmap bitmap) {
            if (z) {
                return;
            }
            if (i2 != 0 && i2 != 1) {
                if (a.this.f21919g != null) {
                    a.this.f21919g.c(i2);
                }
            } else {
                if (i2 == 1 && a.this.f21919g != null) {
                    a.this.f21919g.c(i2);
                }
                a.this.a(bitmap);
            }
        }
    }

    /* renamed from: com.opos.mobad.n.b.a$5 */
    class AnonymousClass5 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Bitmap f21929a;

        AnonymousClass5(Bitmap bitmap) {
            bitmap = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bitmap bitmap;
            if (a.this.f21913a || (bitmap = bitmap) == null || bitmap.isRecycled()) {
                return;
            }
            a.this.s.setImageBitmap(bitmap);
        }
    }

    /* renamed from: com.opos.mobad.n.b.a$6 */
    class AnonymousClass6 implements a.InterfaceC0426a {

        /* renamed from: a */
        final /* synthetic */ com.opos.mobad.n.d.d f21931a;

        AnonymousClass6(com.opos.mobad.n.d.d dVar) {
            dVar = dVar;
        }

        @Override // com.opos.mobad.c.a.InterfaceC0426a
        public void a(int i2, Bitmap bitmap) {
            if (a.this.f21913a) {
                return;
            }
            if (dVar.f22075g.get(0) == null) {
                com.opos.cmn.an.f.a.b("BannerBigImage", "null imgList");
                return;
            }
            if (i2 != 0 && i2 != 1) {
                if (a.this.f21919g != null) {
                    a.this.f21919g.c(i2);
                }
            } else {
                if (i2 == 1 && a.this.f21919g != null) {
                    a.this.f21919g.c(i2);
                }
                a.this.b(bitmap);
            }
        }
    }

    /* renamed from: com.opos.mobad.n.b.a$7 */
    class AnonymousClass7 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Bitmap f21933a;

        AnonymousClass7(Bitmap bitmap) {
            bitmap = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bitmap bitmap;
            if (a.this.f21913a || (bitmap = bitmap) == null || bitmap.isRecycled()) {
                return;
            }
            a.this.k.setImageBitmap(bitmap);
        }
    }

    private a(Context context, aj ajVar, int i2, int i3, com.opos.mobad.c.a aVar) {
        this.f21918f = context;
        this.f21921i = i3;
        this.f21920h = i2;
        this.v = aVar;
        f();
        a(ajVar);
        n();
    }

    public static a a(Context context, aj ajVar, int i2, com.opos.mobad.c.a aVar) {
        return new a(context, ajVar, i2, 0, aVar);
    }

    public void a(Bitmap bitmap) {
        com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.b.a.5

            /* renamed from: a */
            final /* synthetic */ Bitmap f21929a;

            AnonymousClass5(Bitmap bitmap2) {
                bitmap = bitmap2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Bitmap bitmap2;
                if (a.this.f21913a || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                    return;
                }
                a.this.s.setImageBitmap(bitmap);
            }
        });
    }

    private void a(RelativeLayout.LayoutParams layoutParams) {
        RelativeLayout relativeLayout = this.t;
        if (relativeLayout != null) {
            layoutParams.addRule(1, relativeLayout.getId());
        }
    }

    private void a(com.opos.mobad.n.d.d dVar) {
        d(dVar);
        if (this.f21921i == 3) {
            a(dVar.m);
            return;
        }
        if (this.q) {
            c(dVar);
        } else {
            e(dVar);
        }
        b(dVar);
    }

    private void a(com.opos.mobad.n.d.g gVar) {
        if (this.t == null) {
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.f22084a)) {
            this.t.setVisibility(0);
            a(gVar, this.v, this.f21913a);
            return;
        }
        this.t.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.n.getLayoutParams();
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.f21918f, 8.0f);
        layoutParams.width = this.f21914b;
        this.n.setLayoutParams(layoutParams);
    }

    private void a(com.opos.mobad.n.d.g gVar, com.opos.mobad.c.a aVar, boolean z) {
        this.s.setScaleType(ImageView.ScaleType.FIT_XY);
        if (gVar == null) {
            com.opos.cmn.an.f.a.b("BannerBigImage", "iconUrl is null");
        } else {
            int a2 = com.opos.cmn.an.h.f.a.a(this.f21918f, 48.0f);
            aVar.a(gVar.f22084a, gVar.f22085b, a2, a2, new a.InterfaceC0426a() { // from class: com.opos.mobad.n.b.a.4

                /* renamed from: a */
                final /* synthetic */ boolean f21927a;

                AnonymousClass4(boolean z2) {
                    z = z2;
                }

                @Override // com.opos.mobad.c.a.InterfaceC0426a
                public void a(int i2, Bitmap bitmap) {
                    if (z) {
                        return;
                    }
                    if (i2 != 0 && i2 != 1) {
                        if (a.this.f21919g != null) {
                            a.this.f21919g.c(i2);
                        }
                    } else {
                        if (i2 == 1 && a.this.f21919g != null) {
                            a.this.f21919g.c(i2);
                        }
                        a.this.a(bitmap);
                    }
                }
            });
        }
    }

    private void a(aj ajVar) {
        if (ajVar == null) {
            ajVar = aj.a(this.f21918f);
        }
        Context context = this.f21918f;
        int i2 = ajVar.f22455a;
        int i3 = ajVar.f22456b;
        int i4 = this.f21914b;
        this.r = new j(context, new j.a(i2, i3, i4, i4 / this.f21917e));
        this.l = new RelativeLayout(this.f21918f);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.f21914b, -2);
        layoutParams.width = this.f21914b;
        layoutParams.height = -2;
        this.l.setId(View.generateViewId());
        this.l.setLayoutParams(layoutParams);
        this.l.setVisibility(8);
        this.r.addView(this.l, layoutParams);
        this.r.setLayoutParams(layoutParams);
        h();
        g();
        AnonymousClass1 anonymousClass1 = new g() { // from class: com.opos.mobad.n.b.a.1
            AnonymousClass1() {
            }

            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (a.this.f21919g != null) {
                    a.this.f21919g.g(view, iArr);
                }
            }
        };
        this.l.setOnClickListener(anonymousClass1);
        this.l.setOnTouchListener(anonymousClass1);
        o();
    }

    public static a b(Context context, aj ajVar, int i2, com.opos.mobad.c.a aVar) {
        return new a(context, ajVar, i2, 1, aVar);
    }

    public void b(Bitmap bitmap) {
        com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.b.a.7

            /* renamed from: a */
            final /* synthetic */ Bitmap f21933a;

            AnonymousClass7(Bitmap bitmap2) {
                bitmap = bitmap2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Bitmap bitmap2;
                if (a.this.f21913a || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                    return;
                }
                a.this.k.setImageBitmap(bitmap);
            }
        });
    }

    private void b(RelativeLayout.LayoutParams layoutParams) {
        int id;
        if (this.q) {
            y yVar = this.o;
            if (yVar == null) {
                return;
            } else {
                id = yVar.getId();
            }
        } else {
            ImageView imageView = this.k;
            if (imageView == null) {
                return;
            } else {
                id = imageView.getId();
            }
        }
        layoutParams.addRule(1, id);
    }

    private void b(com.opos.mobad.n.d.d dVar) {
        e eVar = this.u;
        if (eVar == null) {
            return;
        }
        eVar.a(dVar.r, dVar.s, dVar.f22077i, dVar.f22078j, dVar.k);
    }

    public static a c(Context context, aj ajVar, int i2, com.opos.mobad.c.a aVar) {
        return new a(context, ajVar, i2, 2, aVar);
    }

    private void c(com.opos.mobad.n.d.d dVar) {
        if (this.o == null) {
            return;
        }
        List<com.opos.mobad.n.d.g> list = dVar.f22075g;
        if (list != null && list.size() > 0) {
            this.o.a(dVar, this.v, this.f21913a, 3000);
        } else {
            com.opos.cmn.an.f.a.b("BannerBigImage", "imgList is null");
            this.f21919g.b(1);
        }
    }

    public static a d(Context context, aj ajVar, int i2, com.opos.mobad.c.a aVar) {
        return new a(context, ajVar, i2, 3, aVar);
    }

    private void d(com.opos.mobad.n.d.d dVar) {
        this.n.a(dVar.l, dVar.f22074f, dVar.f22073e);
        this.n.a(dVar);
        if (this.f21921i == 3) {
            this.n.b(dVar);
        }
    }

    private void e(com.opos.mobad.n.d.d dVar) {
        if (this.k == null) {
            return;
        }
        List<com.opos.mobad.n.d.g> list = dVar.f22075g;
        if (list == null || list.size() <= 0) {
            com.opos.cmn.an.f.a.b("BannerBigImage", "imgList is null");
            this.f21919g.b(1);
        } else {
            this.k.setScaleType(ImageView.ScaleType.FIT_XY);
            this.v.a(dVar.f22075g.get(0).f22084a, dVar.f22075g.get(0).f22085b, this.f21914b, this.f21915c, new a.InterfaceC0426a() { // from class: com.opos.mobad.n.b.a.6

                /* renamed from: a */
                final /* synthetic */ com.opos.mobad.n.d.d f21931a;

                AnonymousClass6(com.opos.mobad.n.d.d dVar2) {
                    dVar = dVar2;
                }

                @Override // com.opos.mobad.c.a.InterfaceC0426a
                public void a(int i2, Bitmap bitmap) {
                    if (a.this.f21913a) {
                        return;
                    }
                    if (dVar.f22075g.get(0) == null) {
                        com.opos.cmn.an.f.a.b("BannerBigImage", "null imgList");
                        return;
                    }
                    if (i2 != 0 && i2 != 1) {
                        if (a.this.f21919g != null) {
                            a.this.f21919g.c(i2);
                        }
                    } else {
                        if (i2 == 1 && a.this.f21919g != null) {
                            a.this.f21919g.c(i2);
                        }
                        a.this.b(bitmap);
                    }
                }
            });
        }
    }

    private void f() {
        Context context;
        float f2;
        this.f21914b = com.opos.cmn.an.h.f.a.a(this.f21918f, 360.0f);
        this.f21915c = com.opos.cmn.an.h.f.a.a(this.f21918f, 60.0f);
        int i2 = this.f21921i;
        if (i2 != 0) {
            f2 = 91.43f;
            if (i2 != 1) {
                if (i2 == 2) {
                    this.f21916d = com.opos.cmn.an.h.f.a.a(this.f21918f, 91.43f);
                    this.q = true;
                } else if (i2 == 3) {
                    context = this.f21918f;
                    f2 = 48.0f;
                }
                this.f21917e = this.f21915c;
            }
            context = this.f21918f;
        } else {
            context = this.f21918f;
            f2 = 106.67f;
        }
        this.f21916d = com.opos.cmn.an.h.f.a.a(context, f2);
        this.f21917e = this.f21915c;
    }

    private void g() {
        this.p = new RelativeLayout(this.f21918f);
        ImageView imageView = new ImageView(this.f21918f);
        this.p.setId(View.generateViewId());
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageResource(R.drawable.opos_mobad_drawable_block_close);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f21918f, 16.0f), com.opos.cmn.an.h.f.a.a(this.f21918f, 16.0f));
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.f21918f, 4.0f);
        AnonymousClass2 anonymousClass2 = new g() { // from class: com.opos.mobad.n.b.a.2
            AnonymousClass2() {
            }

            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (a.this.f21919g != null) {
                    a.this.f21919g.d(view, iArr);
                }
            }
        };
        imageView.setOnTouchListener(anonymousClass2);
        imageView.setOnClickListener(anonymousClass2);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.f21914b, -2);
        this.p.addView(imageView, layoutParams);
        this.l.addView(this.p, layoutParams2);
    }

    private void h() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f21918f);
        this.m = relativeLayout;
        relativeLayout.setId(View.generateViewId());
        this.m.setBackgroundColor(this.f21918f.getResources().getColor(R.color.opos_mobad_root_bg_color));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f21914b, this.f21915c);
        this.m.setVisibility(4);
        this.l.addView(this.m, layoutParams);
        if (this.f21921i == 3) {
            j();
        } else {
            if (this.q) {
                l();
            } else {
                m();
            }
            i();
        }
        k();
    }

    private void i() {
        this.u = e.a(this.f21918f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(this.f21918f, 11.0f));
        layoutParams.addRule(9);
        this.m.addView(this.u, layoutParams);
    }

    private void j() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f21918f);
        this.t = relativeLayout;
        relativeLayout.setId(View.generateViewId());
        int a2 = com.opos.cmn.an.h.f.a.a(this.f21918f, 0.33f);
        this.t.setPadding(a2, a2, a2, a2);
        this.t.setBackgroundResource(R.drawable.opos_mobad_drawable_block_icon_stroke);
        int i2 = this.f21916d;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i2, i2);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.f21918f, 16.0f);
        layoutParams.addRule(15);
        this.t.setVisibility(8);
        f fVar = new f(this.f21918f, com.opos.cmn.an.h.f.a.a(r2, 8.0f));
        this.s = fVar;
        fVar.setScaleType(ImageView.ScaleType.FIT_XY);
        this.t.addView(this.s, new RelativeLayout.LayoutParams(-1, -1));
        this.m.addView(this.t, layoutParams);
    }

    private void k() {
        this.n = this.f21921i == 3 ? d.b(this.f21918f) : d.a(this.f21918f);
        this.n.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f21914b - this.f21916d, -2);
        layoutParams.addRule(15);
        if (this.f21921i == 3) {
            a(layoutParams);
        } else {
            b(layoutParams);
        }
        this.n.setVisibility(4);
        this.m.addView(this.n, layoutParams);
    }

    private void l() {
        y b2 = y.b(this.f21918f, this.f21916d, this.f21915c, false);
        this.o = b2;
        b2.setId(View.generateViewId());
        int i2 = this.f21916d;
        this.m.addView(this.o, new RelativeLayout.LayoutParams(i2, i2));
    }

    private void m() {
        ImageView imageView = new ImageView(this.f21918f);
        this.k = imageView;
        imageView.setId(View.generateViewId());
        this.m.addView(this.k, new RelativeLayout.LayoutParams(this.f21916d, this.f21915c));
    }

    private void n() {
        com.opos.mobad.c.d.a aVar = new com.opos.mobad.c.d.a(this.f21918f);
        aVar.a(new a.InterfaceC0428a() { // from class: com.opos.mobad.n.b.a.3

            /* renamed from: a */
            final /* synthetic */ com.opos.mobad.c.d.a f21925a;

            AnonymousClass3(com.opos.mobad.c.d.a aVar2) {
                aVar = aVar2;
            }

            @Override // com.opos.mobad.c.d.a.InterfaceC0428a
            public void a(boolean z) {
                if (a.this.f21922j == null) {
                    return;
                }
                if (z) {
                    if (a.this.f21919g != null) {
                        a.this.f21919g.b();
                    }
                    aVar.a((a.InterfaceC0428a) null);
                }
                com.opos.cmn.an.f.a.b("BannerBigImage", "blockBigImage7 onWindowVisibilityChanged：" + z);
            }
        });
        this.l.addView(aVar2, new RelativeLayout.LayoutParams(0, 0));
    }

    private void o() {
        this.m.setVisibility(0);
        this.n.setVisibility(0);
    }

    @Override // com.opos.mobad.n.a
    public void a() {
    }

    @Override // com.opos.mobad.n.a
    public void a(a.InterfaceC0458a interfaceC0458a) {
        this.f21919g = interfaceC0458a;
        this.n.a(interfaceC0458a);
        y yVar = this.o;
        if (yVar != null) {
            yVar.a(interfaceC0458a);
        }
        e eVar = this.u;
        if (eVar != null) {
            eVar.a(interfaceC0458a);
        }
    }

    @Override // com.opos.mobad.n.a
    public void a(h hVar) {
        a.InterfaceC0458a interfaceC0458a;
        com.opos.mobad.n.d.g gVar;
        String str;
        List<com.opos.mobad.n.d.g> list;
        if (hVar == null) {
            str = "data is null";
        } else {
            com.opos.mobad.n.d.d a2 = hVar.a();
            if (a2 == null) {
                str = "adShowData is null";
            } else if (this.f21921i != 3 && ((list = a2.f22075g) == null || list.size() <= 0)) {
                str = "imgList is null";
            } else {
                if (this.f21921i != 3 || ((gVar = a2.m) != null && !TextUtils.isEmpty(gVar.f22084a))) {
                    com.opos.cmn.an.f.a.b("BannerBigImage", "render");
                    if (this.f21922j == null && (interfaceC0458a = this.f21919g) != null) {
                        interfaceC0458a.e();
                    }
                    this.f21922j = a2;
                    j jVar = this.r;
                    if (jVar != null && jVar.getVisibility() != 0) {
                        this.r.setVisibility(0);
                    }
                    RelativeLayout relativeLayout = this.l;
                    if (relativeLayout != null && relativeLayout.getVisibility() != 0) {
                        this.l.setVisibility(0);
                    }
                    a(a2);
                    return;
                }
                str = "icon is null";
            }
        }
        com.opos.cmn.an.f.a.b("BannerBigImage", str);
        this.f21919g.b(1);
    }

    @Override // com.opos.mobad.n.a
    public void b() {
    }

    @Override // com.opos.mobad.n.a
    public View c() {
        return this.r;
    }

    @Override // com.opos.mobad.n.a
    public void d() {
        com.opos.cmn.an.f.a.b("BannerBigImage", "destroy");
        this.f21922j = null;
        this.f21913a = true;
        j jVar = this.r;
        if (jVar != null) {
            jVar.removeAllViews();
        }
    }

    @Override // com.opos.mobad.n.a
    public int e() {
        return this.f21920h;
    }
}
