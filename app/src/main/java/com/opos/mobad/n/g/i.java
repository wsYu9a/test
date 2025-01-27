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
public class i implements com.opos.mobad.n.a {

    /* renamed from: d */
    private int f22586d;

    /* renamed from: e */
    private int f22587e;

    /* renamed from: f */
    private Context f22588f;

    /* renamed from: g */
    private a.InterfaceC0458a f22589g;

    /* renamed from: h */
    private int f22590h;

    /* renamed from: i */
    private int f22591i;

    /* renamed from: j */
    private com.opos.mobad.n.d.d f22592j;
    private ImageView k;
    private af l;
    private com.opos.mobad.n.c.h m;
    private RelativeLayout n;
    private RelativeLayout o;
    private y p;
    private TextView q;
    private com.opos.mobad.n.c.j s;
    private com.opos.mobad.c.a t;

    /* renamed from: a */
    private volatile boolean f22583a = false;

    /* renamed from: b */
    private int f22584b = 256;

    /* renamed from: c */
    private int f22585c = 144;
    private boolean r = false;

    /* renamed from: com.opos.mobad.n.g.i$1 */
    class AnonymousClass1 extends com.opos.mobad.n.c.g {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            if (i.this.f22589g != null) {
                i.this.f22589g.g(view, iArr);
            }
        }
    }

    /* renamed from: com.opos.mobad.n.g.i$2 */
    class AnonymousClass2 implements a.InterfaceC0428a {

        /* renamed from: a */
        final /* synthetic */ com.opos.mobad.c.d.a f22594a;

        AnonymousClass2(com.opos.mobad.c.d.a aVar) {
            aVar = aVar;
        }

        @Override // com.opos.mobad.c.d.a.InterfaceC0428a
        public void a(boolean z) {
            if (i.this.f22592j == null) {
                return;
            }
            if (z) {
                i.this.m();
                if (i.this.f22589g != null) {
                    i.this.f22589g.b();
                }
                aVar.a((a.InterfaceC0428a) null);
            }
            com.opos.cmn.an.f.a.b("BlockBigImage6", "blockBigImage6 onWindowVisibilityChanged：" + z);
        }
    }

    /* renamed from: com.opos.mobad.n.g.i$3 */
    class AnonymousClass3 implements a.InterfaceC0426a {

        /* renamed from: a */
        final /* synthetic */ com.opos.mobad.n.d.d f22596a;

        /* renamed from: com.opos.mobad.n.g.i$3$1 */
        class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Bitmap f22598a;

            AnonymousClass1(Bitmap bitmap) {
                bitmap = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Bitmap bitmap;
                if (i.this.f22583a || (bitmap = bitmap) == null || bitmap.isRecycled()) {
                    return;
                }
                i.this.k.setImageBitmap(bitmap);
            }
        }

        AnonymousClass3(com.opos.mobad.n.d.d dVar) {
            dVar = dVar;
        }

        @Override // com.opos.mobad.c.a.InterfaceC0426a
        public void a(int i2, Bitmap bitmap) {
            if (i.this.f22583a) {
                return;
            }
            if (dVar.f22075g.get(0) == null) {
                com.opos.cmn.an.f.a.b("BlockBigImage6", "null imgList");
                return;
            }
            if (i2 != 0 && i2 != 1) {
                if (i.this.f22589g != null) {
                    i.this.f22589g.c(i2);
                }
            } else {
                if (i2 == 1 && i.this.f22589g != null) {
                    i.this.f22589g.c(i2);
                }
                com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.g.i.3.1

                    /* renamed from: a */
                    final /* synthetic */ Bitmap f22598a;

                    AnonymousClass1(Bitmap bitmap2) {
                        bitmap = bitmap2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Bitmap bitmap2;
                        if (i.this.f22583a || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                            return;
                        }
                        i.this.k.setImageBitmap(bitmap);
                    }
                });
            }
        }
    }

    private i(Context context, aj ajVar, int i2, int i3, com.opos.mobad.c.a aVar) {
        this.f22588f = context;
        this.f22591i = i3;
        this.f22590h = i2;
        this.t = aVar;
        f();
        a(ajVar);
        l();
    }

    public static i a(Context context, aj ajVar, int i2, com.opos.mobad.c.a aVar) {
        return new i(context, ajVar, i2, 0, aVar);
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
            ajVar = aj.a(this.f22588f);
        }
        Context context = this.f22588f;
        int i2 = ajVar.f22455a;
        int i3 = ajVar.f22456b;
        int i4 = this.f22584b;
        this.s = new com.opos.mobad.n.c.j(context, new j.a(i2, i3, i4, i4 / this.f22586d));
        com.opos.mobad.n.c.h hVar = new com.opos.mobad.n.c.h(this.f22588f);
        this.m = hVar;
        hVar.a(com.opos.cmn.an.h.f.a.a(this.f22588f, 14.0f));
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.f22584b, this.f22586d);
        layoutParams.width = this.f22584b;
        layoutParams.height = this.f22586d;
        this.m.setId(View.generateViewId());
        this.m.setBackgroundColor(this.f22588f.getResources().getColor(R.color.opos_mobad_root_bg_color));
        this.m.setLayoutParams(layoutParams);
        this.m.setVisibility(8);
        this.s.addView(this.m, layoutParams);
        this.s.setLayoutParams(layoutParams);
        g();
        k();
        AnonymousClass1 anonymousClass1 = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.g.i.1
            AnonymousClass1() {
            }

            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (i.this.f22589g != null) {
                    i.this.f22589g.g(view, iArr);
                }
            }
        };
        this.m.setOnClickListener(anonymousClass1);
        this.m.setOnTouchListener(anonymousClass1);
    }

    public static i b(Context context, aj ajVar, int i2, com.opos.mobad.c.a aVar) {
        return new i(context, ajVar, i2, 1, aVar);
    }

    private void b(com.opos.mobad.n.d.d dVar) {
        y yVar;
        List<com.opos.mobad.n.d.g> list = dVar.f22075g;
        if (list == null || list.size() == 0 || (yVar = this.p) == null) {
            return;
        }
        yVar.a(dVar, this.t, this.f22583a, dVar.z);
    }

    public static i c(Context context, aj ajVar, int i2, com.opos.mobad.c.a aVar) {
        return new i(context, ajVar, i2, 2, aVar);
    }

    private void c(com.opos.mobad.n.d.d dVar) {
        String str = dVar.f22074f;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.q.setText(str);
    }

    private void d(com.opos.mobad.n.d.d dVar) {
        ImageView imageView;
        List<com.opos.mobad.n.d.g> list = dVar.f22075g;
        if (list == null || list.size() == 0 || (imageView = this.k) == null) {
            return;
        }
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.t.a(dVar.f22075g.get(0).f22084a, dVar.f22075g.get(0).f22085b, this.f22584b, this.f22585c, new a.InterfaceC0426a() { // from class: com.opos.mobad.n.g.i.3

            /* renamed from: a */
            final /* synthetic */ com.opos.mobad.n.d.d f22596a;

            /* renamed from: com.opos.mobad.n.g.i$3$1 */
            class AnonymousClass1 implements Runnable {

                /* renamed from: a */
                final /* synthetic */ Bitmap f22598a;

                AnonymousClass1(Bitmap bitmap2) {
                    bitmap = bitmap2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Bitmap bitmap2;
                    if (i.this.f22583a || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                        return;
                    }
                    i.this.k.setImageBitmap(bitmap);
                }
            }

            AnonymousClass3(com.opos.mobad.n.d.d dVar2) {
                dVar = dVar2;
            }

            @Override // com.opos.mobad.c.a.InterfaceC0426a
            public void a(int i2, Bitmap bitmap2) {
                if (i.this.f22583a) {
                    return;
                }
                if (dVar.f22075g.get(0) == null) {
                    com.opos.cmn.an.f.a.b("BlockBigImage6", "null imgList");
                    return;
                }
                if (i2 != 0 && i2 != 1) {
                    if (i.this.f22589g != null) {
                        i.this.f22589g.c(i2);
                    }
                } else {
                    if (i2 == 1 && i.this.f22589g != null) {
                        i.this.f22589g.c(i2);
                    }
                    com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.g.i.3.1

                        /* renamed from: a */
                        final /* synthetic */ Bitmap f22598a;

                        AnonymousClass1(Bitmap bitmap22) {
                            bitmap = bitmap22;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Bitmap bitmap22;
                            if (i.this.f22583a || (bitmap22 = bitmap) == null || bitmap22.isRecycled()) {
                                return;
                            }
                            i.this.k.setImageBitmap(bitmap);
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
        int i2 = this.f22591i;
        if (i2 == 0) {
            this.f22584b = com.opos.cmn.an.h.f.a.a(this.f22588f, 256.0f);
            this.f22585c = com.opos.cmn.an.h.f.a.a(this.f22588f, 144.0f);
            a2 = com.opos.cmn.an.h.f.a.a(this.f22588f, 188.0f);
        } else {
            if (i2 != 1) {
                if (i2 != 2) {
                    return;
                }
                this.f22584b = com.opos.cmn.an.h.f.a.a(this.f22588f, 256.0f);
                this.f22585c = com.opos.cmn.an.h.f.a.a(this.f22588f, 168.0f);
                this.f22586d = com.opos.cmn.an.h.f.a.a(this.f22588f, 212.0f);
                this.f22587e = this.f22584b;
                this.r = true;
                return;
            }
            this.f22584b = com.opos.cmn.an.h.f.a.a(this.f22588f, 256.0f);
            this.f22585c = com.opos.cmn.an.h.f.a.a(this.f22588f, 168.0f);
            a2 = com.opos.cmn.an.h.f.a.a(this.f22588f, 212.0f);
        }
        this.f22586d = a2;
        this.f22587e = this.f22584b;
    }

    private void g() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f22588f);
        this.n = relativeLayout;
        relativeLayout.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f22584b, this.f22585c);
        this.n.setVisibility(4);
        this.m.addView(this.n, layoutParams);
        if (this.r) {
            h();
        } else {
            i();
        }
        j();
    }

    private void h() {
        this.p = y.a(this.f22588f, this.f22584b, this.f22585c, true);
        this.n.addView(this.p, new RelativeLayout.LayoutParams(this.f22584b, this.f22585c));
    }

    private void i() {
        this.k = new ImageView(this.f22588f);
        this.n.addView(this.k, new RelativeLayout.LayoutParams(this.f22584b, this.f22585c));
    }

    private void j() {
        this.l = af.a(this.f22588f, false);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f22584b, -2);
        this.l.setVisibility(4);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f22588f, 16.0f);
        this.n.addView(this.l, layoutParams);
    }

    private void k() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f22588f);
        this.o = relativeLayout;
        relativeLayout.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f22587e, com.opos.cmn.an.h.f.a.a(this.f22588f, 44.0f));
        this.o.setVisibility(4);
        RelativeLayout relativeLayout2 = this.n;
        if (relativeLayout2 != null) {
            layoutParams.addRule(3, relativeLayout2.getId());
        }
        TextView textView = new TextView(this.f22588f);
        this.q = textView;
        textView.setTextColor(this.f22588f.getResources().getColor(R.color.opos_mobad_title_color));
        this.q.setTextSize(1, 12.0f);
        this.q.setGravity(17);
        this.q.setMaxLines(1);
        this.q.setEllipsize(TextUtils.TruncateAt.END);
        this.q.setSingleLine();
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        int a2 = com.opos.cmn.an.h.f.a.a(this.f22588f, 16.0f);
        layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(this.f22588f, 12.0f);
        layoutParams2.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f22588f, 16.0f);
        layoutParams2.leftMargin = a2;
        layoutParams2.rightMargin = a2;
        this.o.addView(this.q, layoutParams2);
        this.m.addView(this.o, layoutParams);
    }

    private void l() {
        com.opos.mobad.c.d.a aVar = new com.opos.mobad.c.d.a(this.f22588f);
        aVar.a(new a.InterfaceC0428a() { // from class: com.opos.mobad.n.g.i.2

            /* renamed from: a */
            final /* synthetic */ com.opos.mobad.c.d.a f22594a;

            AnonymousClass2(com.opos.mobad.c.d.a aVar2) {
                aVar = aVar2;
            }

            @Override // com.opos.mobad.c.d.a.InterfaceC0428a
            public void a(boolean z) {
                if (i.this.f22592j == null) {
                    return;
                }
                if (z) {
                    i.this.m();
                    if (i.this.f22589g != null) {
                        i.this.f22589g.b();
                    }
                    aVar.a((a.InterfaceC0428a) null);
                }
                com.opos.cmn.an.f.a.b("BlockBigImage6", "blockBigImage6 onWindowVisibilityChanged：" + z);
            }
        });
        this.m.addView(aVar2, new RelativeLayout.LayoutParams(0, 0));
    }

    public void m() {
        this.n.setVisibility(0);
        this.o.setVisibility(0);
        this.l.setVisibility(0);
    }

    @Override // com.opos.mobad.n.a
    public void a() {
    }

    @Override // com.opos.mobad.n.a
    public void a(a.InterfaceC0458a interfaceC0458a) {
        this.f22589g = interfaceC0458a;
        this.l.a(interfaceC0458a);
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
                    com.opos.cmn.an.f.a.b("BlockBigImage6", "render");
                    if (this.f22592j == null && (interfaceC0458a = this.f22589g) != null) {
                        interfaceC0458a.e();
                    }
                    this.f22592j = a2;
                    com.opos.mobad.n.c.j jVar = this.s;
                    if (jVar != null && jVar.getVisibility() != 0) {
                        this.s.setVisibility(0);
                    }
                    com.opos.mobad.n.c.h hVar2 = this.m;
                    if (hVar2 != null && hVar2.getVisibility() != 0) {
                        this.m.setVisibility(0);
                    }
                    a(a2);
                    return;
                }
                str = "imgList is null";
            }
        }
        com.opos.cmn.an.f.a.b("BlockBigImage6", str);
        this.f22589g.b(1);
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
        com.opos.cmn.an.f.a.b("BlockBigImage6", "destroy");
        this.f22592j = null;
        this.f22583a = true;
        com.opos.mobad.n.c.j jVar = this.s;
        if (jVar != null) {
            jVar.removeAllViews();
        }
    }

    @Override // com.opos.mobad.n.a
    public int e() {
        return this.f22590h;
    }
}
