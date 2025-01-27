package com.opos.mobad.n.g;

import android.content.Context;
import android.graphics.Bitmap;
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
import java.util.List;

/* loaded from: classes4.dex */
public class b implements com.opos.mobad.n.a {

    /* renamed from: b */
    private int f22458b;

    /* renamed from: c */
    private int f22459c;

    /* renamed from: f */
    private int f22462f;

    /* renamed from: h */
    private Context f22464h;

    /* renamed from: i */
    private a.InterfaceC0458a f22465i;

    /* renamed from: j */
    private int f22466j;
    private int k;
    private com.opos.mobad.n.d.d l;
    private ImageView m;
    private ad n;
    private TextView o;
    private x p;
    private RelativeLayout q;
    private com.opos.mobad.n.c.h r;
    private com.opos.mobad.n.c.j s;
    private com.opos.mobad.c.a t;

    /* renamed from: a */
    private volatile boolean f22457a = false;

    /* renamed from: d */
    private int f22460d = 0;

    /* renamed from: e */
    private int f22461e = 0;

    /* renamed from: g */
    private boolean f22463g = false;

    /* renamed from: com.opos.mobad.n.g.b$1 */
    class AnonymousClass1 extends com.opos.mobad.n.c.g {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            if (b.this.f22465i != null) {
                b.this.f22465i.g(view, iArr);
            }
        }
    }

    /* renamed from: com.opos.mobad.n.g.b$2 */
    class AnonymousClass2 implements a.InterfaceC0428a {

        /* renamed from: a */
        final /* synthetic */ com.opos.mobad.c.d.a f22468a;

        AnonymousClass2(com.opos.mobad.c.d.a aVar) {
            aVar = aVar;
        }

        @Override // com.opos.mobad.c.d.a.InterfaceC0428a
        public void a(boolean z) {
            if (b.this.l == null) {
                return;
            }
            if (z) {
                b.this.j();
                if (b.this.f22465i != null) {
                    b.this.f22465i.b();
                }
                aVar.a((a.InterfaceC0428a) null);
            }
            com.opos.cmn.an.f.a.b("BlockBigImage10", "BlockBigImage10 onWindowVisibilityChanged：" + z);
        }
    }

    /* renamed from: com.opos.mobad.n.g.b$3 */
    class AnonymousClass3 implements a.InterfaceC0426a {

        /* renamed from: a */
        final /* synthetic */ com.opos.mobad.n.d.g f22470a;

        /* renamed from: b */
        final /* synthetic */ ImageView f22471b;

        /* renamed from: com.opos.mobad.n.g.b$3$1 */
        class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Bitmap f22473a;

            AnonymousClass1(Bitmap bitmap) {
                bitmap = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Bitmap bitmap;
                if (b.this.f22457a || (bitmap = bitmap) == null || bitmap.isRecycled()) {
                    return;
                }
                imageView.setImageBitmap(bitmap);
            }
        }

        AnonymousClass3(com.opos.mobad.n.d.g gVar, ImageView imageView) {
            gVar = gVar;
            imageView = imageView;
        }

        @Override // com.opos.mobad.c.a.InterfaceC0426a
        public void a(int i2, Bitmap bitmap) {
            if (b.this.f22457a) {
                return;
            }
            if (gVar == null) {
                com.opos.cmn.an.f.a.b("BlockBigImage10", "null imgList");
                return;
            }
            if (i2 != 0 && i2 != 1) {
                if (b.this.f22465i != null) {
                    b.this.f22465i.c(i2);
                }
            } else {
                if (i2 == 1 && b.this.f22465i != null) {
                    b.this.f22465i.c(i2);
                }
                com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.g.b.3.1

                    /* renamed from: a */
                    final /* synthetic */ Bitmap f22473a;

                    AnonymousClass1(Bitmap bitmap2) {
                        bitmap = bitmap2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Bitmap bitmap2;
                        if (b.this.f22457a || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                            return;
                        }
                        imageView.setImageBitmap(bitmap);
                    }
                });
            }
        }
    }

    private b(Context context, aj ajVar, int i2, int i3, com.opos.mobad.c.a aVar) {
        this.f22464h = context;
        this.k = i3;
        this.f22466j = i2;
        this.t = aVar;
        f();
        a(ajVar);
        i();
    }

    public static b a(Context context, aj ajVar, int i2, com.opos.mobad.c.a aVar) {
        return new b(context, ajVar, i2, 0, aVar);
    }

    private void a(ImageView imageView, com.opos.mobad.n.d.g gVar) {
        if (imageView == null || gVar == null || TextUtils.isEmpty(gVar.f22084a)) {
            return;
        }
        imageView.setVisibility(0);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.t.a(gVar.f22084a, gVar.f22085b, this.f22458b, this.f22459c, new a.InterfaceC0426a() { // from class: com.opos.mobad.n.g.b.3

            /* renamed from: a */
            final /* synthetic */ com.opos.mobad.n.d.g f22470a;

            /* renamed from: b */
            final /* synthetic */ ImageView f22471b;

            /* renamed from: com.opos.mobad.n.g.b$3$1 */
            class AnonymousClass1 implements Runnable {

                /* renamed from: a */
                final /* synthetic */ Bitmap f22473a;

                AnonymousClass1(Bitmap bitmap2) {
                    bitmap = bitmap2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Bitmap bitmap2;
                    if (b.this.f22457a || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                        return;
                    }
                    imageView.setImageBitmap(bitmap);
                }
            }

            AnonymousClass3(com.opos.mobad.n.d.g gVar2, ImageView imageView2) {
                gVar = gVar2;
                imageView = imageView2;
            }

            @Override // com.opos.mobad.c.a.InterfaceC0426a
            public void a(int i2, Bitmap bitmap2) {
                if (b.this.f22457a) {
                    return;
                }
                if (gVar == null) {
                    com.opos.cmn.an.f.a.b("BlockBigImage10", "null imgList");
                    return;
                }
                if (i2 != 0 && i2 != 1) {
                    if (b.this.f22465i != null) {
                        b.this.f22465i.c(i2);
                    }
                } else {
                    if (i2 == 1 && b.this.f22465i != null) {
                        b.this.f22465i.c(i2);
                    }
                    com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.g.b.3.1

                        /* renamed from: a */
                        final /* synthetic */ Bitmap f22473a;

                        AnonymousClass1(Bitmap bitmap22) {
                            bitmap = bitmap22;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Bitmap bitmap22;
                            if (b.this.f22457a || (bitmap22 = bitmap) == null || bitmap22.isRecycled()) {
                                return;
                            }
                            imageView.setImageBitmap(bitmap);
                        }
                    });
                }
            }
        });
    }

    private void a(com.opos.mobad.n.c.h hVar) {
        this.m = new ImageView(this.f22464h);
        hVar.addView(this.m, new RelativeLayout.LayoutParams(this.f22460d, this.f22461e));
        this.m.setVisibility(8);
    }

    private void a(com.opos.mobad.n.d.d dVar) {
        if (this.f22463g) {
            d(dVar);
        } else {
            c(dVar);
        }
        this.n.a(dVar.r, dVar.s, dVar.f22077i, dVar.f22078j, dVar.k, dVar.B, dVar.f22074f);
        b(dVar);
    }

    private void a(aj ajVar) {
        if (ajVar == null) {
            ajVar = aj.a(this.f22464h);
        }
        Context context = this.f22464h;
        int i2 = ajVar.f22455a;
        int i3 = ajVar.f22456b;
        int i4 = this.f22458b;
        this.s = new com.opos.mobad.n.c.j(context, new j.a(i2, i3, i4, i4 / this.f22462f));
        this.q = new RelativeLayout(this.f22464h);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.f22458b, -2);
        layoutParams.width = this.f22458b;
        layoutParams.height = -2;
        this.q.setId(View.generateViewId());
        this.q.setLayoutParams(layoutParams);
        this.q.setVisibility(8);
        this.s.addView(this.q, layoutParams);
        this.s.setLayoutParams(layoutParams);
        g();
        AnonymousClass1 anonymousClass1 = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.g.b.1
            AnonymousClass1() {
            }

            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (b.this.f22465i != null) {
                    b.this.f22465i.g(view, iArr);
                }
            }
        };
        this.q.setOnClickListener(anonymousClass1);
        this.q.setOnTouchListener(anonymousClass1);
    }

    public static b b(Context context, aj ajVar, int i2, com.opos.mobad.c.a aVar) {
        return new b(context, ajVar, i2, 1, aVar);
    }

    private void b(com.opos.mobad.n.c.h hVar) {
        this.p = x.a(this.f22464h, this.f22460d, this.f22461e);
        hVar.addView(this.p, new RelativeLayout.LayoutParams(this.f22460d, this.f22461e));
    }

    private void b(com.opos.mobad.n.d.d dVar) {
        String str = dVar.f22073e;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.o.setText(str);
    }

    public static b c(Context context, aj ajVar, int i2, com.opos.mobad.c.a aVar) {
        return new b(context, ajVar, i2, 2, aVar);
    }

    private void c(com.opos.mobad.n.d.d dVar) {
        List<com.opos.mobad.n.d.g> list = dVar.f22075g;
        if (list == null || list.size() == 0) {
            return;
        }
        a(this.m, dVar.f22075g.get(0));
    }

    private void d(com.opos.mobad.n.d.d dVar) {
        x xVar;
        List<com.opos.mobad.n.d.g> list = dVar.f22075g;
        if (list == null || list.size() == 0 || (xVar = this.p) == null) {
            return;
        }
        xVar.a(dVar, this.t, this.f22457a);
    }

    private void f() {
        int a2;
        this.f22460d = com.opos.cmn.an.h.f.a.a(this.f22464h, 320.0f);
        int i2 = this.k;
        if (i2 == 0) {
            this.f22458b = com.opos.cmn.an.h.f.a.a(this.f22464h, 320.0f);
            this.f22459c = com.opos.cmn.an.h.f.a.a(this.f22464h, 258.0f);
            a2 = com.opos.cmn.an.h.f.a.a(this.f22464h, 180.0f);
        } else {
            if (i2 != 1) {
                if (i2 == 2) {
                    this.f22458b = com.opos.cmn.an.h.f.a.a(this.f22464h, 320.0f);
                    this.f22459c = com.opos.cmn.an.h.f.a.a(this.f22464h, 288.0f);
                    this.f22461e = com.opos.cmn.an.h.f.a.a(this.f22464h, 210.0f);
                    this.f22463g = true;
                }
                this.f22462f = this.f22459c;
            }
            this.f22458b = com.opos.cmn.an.h.f.a.a(this.f22464h, 320.0f);
            this.f22459c = com.opos.cmn.an.h.f.a.a(this.f22464h, 288.0f);
            a2 = com.opos.cmn.an.h.f.a.a(this.f22464h, 210.0f);
        }
        this.f22461e = a2;
        this.f22462f = this.f22459c;
    }

    private void g() {
        com.opos.mobad.n.c.h hVar = new com.opos.mobad.n.c.h(this.f22464h);
        this.r = hVar;
        hVar.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f22458b, this.f22459c);
        this.r.setVisibility(4);
        this.q.addView(this.r, layoutParams);
        h();
    }

    private void h() {
        TextView textView = new TextView(this.f22464h);
        this.o = textView;
        textView.setId(View.generateViewId());
        this.o.setTextColor(this.f22464h.getResources().getColor(R.color.opos_mobad_small_top_title_color));
        this.o.setTextSize(1, 17.0f);
        this.o.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.o.setMaxLines(2);
        this.r.addView(this.o, new RelativeLayout.LayoutParams(-1, -2));
        com.opos.mobad.n.c.h hVar = new com.opos.mobad.n.c.h(this.f22464h);
        hVar.a(com.opos.cmn.an.h.f.a.a(this.f22464h, 6.0f));
        hVar.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f22458b, this.f22461e);
        layoutParams.addRule(3, this.o.getId());
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f22464h, 8.0f);
        if (this.f22463g) {
            b(hVar);
        } else {
            a(hVar);
        }
        this.r.addView(hVar, layoutParams);
        this.n = ad.a(this.f22464h);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f22464h, 320.0f), -2);
        layoutParams2.addRule(3, hVar.getId());
        layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(this.f22464h, 6.0f);
        this.r.addView(this.n, layoutParams2);
    }

    private void i() {
        com.opos.mobad.c.d.a aVar = new com.opos.mobad.c.d.a(this.f22464h);
        aVar.a(new a.InterfaceC0428a() { // from class: com.opos.mobad.n.g.b.2

            /* renamed from: a */
            final /* synthetic */ com.opos.mobad.c.d.a f22468a;

            AnonymousClass2(com.opos.mobad.c.d.a aVar2) {
                aVar = aVar2;
            }

            @Override // com.opos.mobad.c.d.a.InterfaceC0428a
            public void a(boolean z) {
                if (b.this.l == null) {
                    return;
                }
                if (z) {
                    b.this.j();
                    if (b.this.f22465i != null) {
                        b.this.f22465i.b();
                    }
                    aVar.a((a.InterfaceC0428a) null);
                }
                com.opos.cmn.an.f.a.b("BlockBigImage10", "BlockBigImage10 onWindowVisibilityChanged：" + z);
            }
        });
        this.q.addView(aVar2, new RelativeLayout.LayoutParams(0, 0));
    }

    public void j() {
        this.r.setVisibility(0);
    }

    @Override // com.opos.mobad.n.a
    public void a() {
    }

    @Override // com.opos.mobad.n.a
    public void a(a.InterfaceC0458a interfaceC0458a) {
        this.f22465i = interfaceC0458a;
        this.n.a(interfaceC0458a);
        x xVar = this.p;
        if (xVar != null) {
            xVar.a(interfaceC0458a);
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
                    com.opos.cmn.an.f.a.b("BlockBigImage10", "render");
                    if (this.l == null && (interfaceC0458a = this.f22465i) != null) {
                        interfaceC0458a.e();
                    }
                    this.l = a2;
                    com.opos.mobad.n.c.j jVar = this.s;
                    if (jVar != null && jVar.getVisibility() != 0) {
                        this.s.setVisibility(0);
                    }
                    RelativeLayout relativeLayout = this.q;
                    if (relativeLayout != null && relativeLayout.getVisibility() != 0) {
                        this.q.setVisibility(0);
                    }
                    a(a2);
                    return;
                }
                str = "imgList is null";
            }
        }
        com.opos.cmn.an.f.a.b("BlockBigImage10", str);
        this.f22465i.b(1);
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
        com.opos.cmn.an.f.a.b("BlockBigImage10", "destroy");
        this.l = null;
        this.f22457a = true;
        com.opos.mobad.n.c.j jVar = this.s;
        if (jVar != null) {
            jVar.removeAllViews();
        }
    }

    @Override // com.opos.mobad.n.a
    public int e() {
        return this.f22466j;
    }
}
