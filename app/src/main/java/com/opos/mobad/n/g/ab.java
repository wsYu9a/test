package com.opos.mobad.n.g;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.c.a;
import com.opos.mobad.c.d.a;
import com.opos.mobad.n.a;
import com.opos.mobad.n.c.j;
import java.util.List;

/* loaded from: classes4.dex */
public class ab implements com.opos.mobad.n.a {

    /* renamed from: a */
    private volatile boolean f22370a = false;

    /* renamed from: b */
    private int f22371b = 320;

    /* renamed from: c */
    private int f22372c = 141;

    /* renamed from: d */
    private int f22373d = 0;

    /* renamed from: e */
    private int f22374e = 0;

    /* renamed from: f */
    private int f22375f;

    /* renamed from: g */
    private Context f22376g;

    /* renamed from: h */
    private a.InterfaceC0458a f22377h;

    /* renamed from: i */
    private int f22378i;

    /* renamed from: j */
    private int f22379j;
    private com.opos.mobad.n.d.d k;
    private com.opos.mobad.n.c.f l;
    private com.opos.mobad.n.c.f m;
    private com.opos.mobad.n.c.f n;
    private ad o;
    private TextView p;
    private RelativeLayout q;
    private com.opos.mobad.n.c.h r;
    private com.opos.mobad.n.c.j s;
    private com.opos.mobad.c.a t;

    /* renamed from: com.opos.mobad.n.g.ab$1 */
    class AnonymousClass1 extends com.opos.mobad.n.c.g {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            if (ab.this.f22377h != null) {
                ab.this.f22377h.g(view, iArr);
            }
        }
    }

    /* renamed from: com.opos.mobad.n.g.ab$2 */
    class AnonymousClass2 implements a.InterfaceC0428a {

        /* renamed from: a */
        final /* synthetic */ com.opos.mobad.c.d.a f22381a;

        AnonymousClass2(com.opos.mobad.c.d.a aVar) {
            aVar = aVar;
        }

        @Override // com.opos.mobad.c.d.a.InterfaceC0428a
        public void a(boolean z) {
            if (ab.this.k == null) {
                return;
            }
            if (z) {
                ab.this.j();
                if (ab.this.f22377h != null) {
                    ab.this.f22377h.b();
                }
                aVar.a((a.InterfaceC0428a) null);
            }
            com.opos.cmn.an.f.a.b("BlockSmallImage9", "BlockSmallImage9 onWindowVisibilityChanged：" + z);
        }
    }

    /* renamed from: com.opos.mobad.n.g.ab$3 */
    class AnonymousClass3 implements a.InterfaceC0426a {

        /* renamed from: a */
        final /* synthetic */ com.opos.mobad.n.d.g f22383a;

        /* renamed from: b */
        final /* synthetic */ com.opos.mobad.n.c.f f22384b;

        /* renamed from: com.opos.mobad.n.g.ab$3$1 */
        class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Bitmap f22386a;

            AnonymousClass1(Bitmap bitmap) {
                bitmap = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Bitmap bitmap;
                if (ab.this.f22370a || (bitmap = bitmap) == null || bitmap.isRecycled()) {
                    return;
                }
                fVar.setImageBitmap(bitmap);
            }
        }

        AnonymousClass3(com.opos.mobad.n.d.g gVar, com.opos.mobad.n.c.f fVar) {
            gVar = gVar;
            fVar = fVar;
        }

        @Override // com.opos.mobad.c.a.InterfaceC0426a
        public void a(int i2, Bitmap bitmap) {
            if (ab.this.f22370a) {
                return;
            }
            if (gVar == null) {
                com.opos.cmn.an.f.a.b("BlockSmallImage9", "null imgList");
                return;
            }
            if (i2 != 0 && i2 != 1) {
                if (ab.this.f22377h != null) {
                    ab.this.f22377h.c(i2);
                }
            } else {
                if (i2 == 1 && ab.this.f22377h != null) {
                    ab.this.f22377h.c(i2);
                }
                com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.g.ab.3.1

                    /* renamed from: a */
                    final /* synthetic */ Bitmap f22386a;

                    AnonymousClass1(Bitmap bitmap2) {
                        bitmap = bitmap2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Bitmap bitmap2;
                        if (ab.this.f22370a || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                            return;
                        }
                        fVar.setImageBitmap(bitmap);
                    }
                });
            }
        }
    }

    private ab(Context context, aj ajVar, int i2, int i3, com.opos.mobad.c.a aVar) {
        this.f22376g = context;
        this.f22379j = i3;
        this.f22378i = i2;
        this.t = aVar;
        f();
        a(ajVar);
        i();
    }

    public static ab a(Context context, aj ajVar, int i2, com.opos.mobad.c.a aVar) {
        return new ab(context, ajVar, i2, 1, aVar);
    }

    private void a(LinearLayout linearLayout) {
        this.l = new com.opos.mobad.n.c.f(this.f22376g, com.opos.cmn.an.h.f.a.a(r1, 4.0f));
        linearLayout.addView(this.l, new LinearLayout.LayoutParams(this.f22373d, this.f22374e));
        this.l.setVisibility(8);
        this.m = new com.opos.mobad.n.c.f(this.f22376g, com.opos.cmn.an.h.f.a.a(r3, 4.0f));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.f22373d, this.f22374e);
        int a2 = com.opos.cmn.an.h.f.a.a(this.f22376g, 10.0f);
        layoutParams.leftMargin = a2;
        linearLayout.addView(this.m, layoutParams);
        this.m.setVisibility(8);
        this.n = new com.opos.mobad.n.c.f(this.f22376g, com.opos.cmn.an.h.f.a.a(r4, 4.0f));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.f22373d, this.f22374e);
        layoutParams2.leftMargin = a2;
        linearLayout.addView(this.n, layoutParams2);
        this.n.setVisibility(8);
    }

    private void a(com.opos.mobad.n.c.f fVar, com.opos.mobad.n.d.g gVar) {
        if (fVar == null || gVar == null || TextUtils.isEmpty(gVar.f22084a)) {
            return;
        }
        fVar.setVisibility(0);
        fVar.setScaleType(ImageView.ScaleType.FIT_XY);
        this.t.a(gVar.f22084a, gVar.f22085b, this.f22371b, this.f22372c, new a.InterfaceC0426a() { // from class: com.opos.mobad.n.g.ab.3

            /* renamed from: a */
            final /* synthetic */ com.opos.mobad.n.d.g f22383a;

            /* renamed from: b */
            final /* synthetic */ com.opos.mobad.n.c.f f22384b;

            /* renamed from: com.opos.mobad.n.g.ab$3$1 */
            class AnonymousClass1 implements Runnable {

                /* renamed from: a */
                final /* synthetic */ Bitmap f22386a;

                AnonymousClass1(Bitmap bitmap2) {
                    bitmap = bitmap2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Bitmap bitmap2;
                    if (ab.this.f22370a || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                        return;
                    }
                    fVar.setImageBitmap(bitmap);
                }
            }

            AnonymousClass3(com.opos.mobad.n.d.g gVar2, com.opos.mobad.n.c.f fVar2) {
                gVar = gVar2;
                fVar = fVar2;
            }

            @Override // com.opos.mobad.c.a.InterfaceC0426a
            public void a(int i2, Bitmap bitmap2) {
                if (ab.this.f22370a) {
                    return;
                }
                if (gVar == null) {
                    com.opos.cmn.an.f.a.b("BlockSmallImage9", "null imgList");
                    return;
                }
                if (i2 != 0 && i2 != 1) {
                    if (ab.this.f22377h != null) {
                        ab.this.f22377h.c(i2);
                    }
                } else {
                    if (i2 == 1 && ab.this.f22377h != null) {
                        ab.this.f22377h.c(i2);
                    }
                    com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.g.ab.3.1

                        /* renamed from: a */
                        final /* synthetic */ Bitmap f22386a;

                        AnonymousClass1(Bitmap bitmap22) {
                            bitmap = bitmap22;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Bitmap bitmap22;
                            if (ab.this.f22370a || (bitmap22 = bitmap) == null || bitmap22.isRecycled()) {
                                return;
                            }
                            fVar.setImageBitmap(bitmap);
                        }
                    });
                }
            }
        });
    }

    private void a(com.opos.mobad.n.d.d dVar) {
        c(dVar);
        this.o.a(dVar.r, dVar.s, dVar.f22077i, dVar.f22078j, dVar.k, dVar.B, dVar.f22074f);
        b(dVar);
    }

    private void a(aj ajVar) {
        if (ajVar == null) {
            ajVar = aj.a(this.f22376g);
        }
        Context context = this.f22376g;
        int i2 = ajVar.f22455a;
        int i3 = ajVar.f22456b;
        int i4 = this.f22371b;
        this.s = new com.opos.mobad.n.c.j(context, new j.a(i2, i3, i4, i4 / this.f22375f));
        this.q = new RelativeLayout(this.f22376g);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.f22371b, -2);
        layoutParams.width = this.f22371b;
        layoutParams.height = -2;
        this.q.setId(View.generateViewId());
        this.q.setLayoutParams(layoutParams);
        this.q.setVisibility(8);
        this.s.addView(this.q, layoutParams);
        this.s.setLayoutParams(layoutParams);
        g();
        AnonymousClass1 anonymousClass1 = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.g.ab.1
            AnonymousClass1() {
            }

            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (ab.this.f22377h != null) {
                    ab.this.f22377h.g(view, iArr);
                }
            }
        };
        this.q.setOnClickListener(anonymousClass1);
        this.q.setOnTouchListener(anonymousClass1);
    }

    private void b(com.opos.mobad.n.d.d dVar) {
        String str = dVar.f22073e;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.p.setText(str);
    }

    private void c(com.opos.mobad.n.d.d dVar) {
        List<com.opos.mobad.n.d.g> list = dVar.f22075g;
        if (list == null || list.size() == 0) {
            return;
        }
        a(this.l, dVar.f22075g.get(0));
        if (dVar.f22075g.size() >= 2) {
            a(this.m, dVar.f22075g.get(1));
        }
        if (dVar.f22075g.size() >= 3) {
            a(this.n, dVar.f22075g.get(2));
        }
    }

    private void f() {
        this.f22373d = com.opos.cmn.an.h.f.a.a(this.f22376g, 100.0f);
        this.f22374e = com.opos.cmn.an.h.f.a.a(this.f22376g, 65.62f);
        if (this.f22379j == 1) {
            this.f22371b = com.opos.cmn.an.h.f.a.a(this.f22376g, 320.0f);
            this.f22372c = com.opos.cmn.an.h.f.a.a(this.f22376g, 141.62f);
        }
        this.f22375f = this.f22372c;
    }

    private void g() {
        com.opos.mobad.n.c.h hVar = new com.opos.mobad.n.c.h(this.f22376g);
        this.r = hVar;
        hVar.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f22371b, this.f22372c);
        this.r.setVisibility(4);
        this.q.addView(this.r, layoutParams);
        h();
    }

    private void h() {
        TextView textView = new TextView(this.f22376g);
        this.p = textView;
        textView.setId(View.generateViewId());
        this.p.setTextColor(this.f22376g.getResources().getColor(R.color.opos_mobad_small_top_title_color));
        this.p.setTextSize(1, 17.0f);
        this.p.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.p.setMaxLines(2);
        this.r.addView(this.p, new RelativeLayout.LayoutParams(-1, -2));
        LinearLayout linearLayout = new LinearLayout(this.f22376g);
        linearLayout.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f22371b, this.f22374e);
        layoutParams.addRule(3, this.p.getId());
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f22376g, 8.0f);
        a(linearLayout);
        this.r.addView(linearLayout, layoutParams);
        this.o = ad.a(this.f22376g);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f22376g, 320.0f), -2);
        layoutParams2.addRule(3, linearLayout.getId());
        layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(this.f22376g, 6.0f);
        this.r.addView(this.o, layoutParams2);
    }

    private void i() {
        com.opos.mobad.c.d.a aVar = new com.opos.mobad.c.d.a(this.f22376g);
        aVar.a(new a.InterfaceC0428a() { // from class: com.opos.mobad.n.g.ab.2

            /* renamed from: a */
            final /* synthetic */ com.opos.mobad.c.d.a f22381a;

            AnonymousClass2(com.opos.mobad.c.d.a aVar2) {
                aVar = aVar2;
            }

            @Override // com.opos.mobad.c.d.a.InterfaceC0428a
            public void a(boolean z) {
                if (ab.this.k == null) {
                    return;
                }
                if (z) {
                    ab.this.j();
                    if (ab.this.f22377h != null) {
                        ab.this.f22377h.b();
                    }
                    aVar.a((a.InterfaceC0428a) null);
                }
                com.opos.cmn.an.f.a.b("BlockSmallImage9", "BlockSmallImage9 onWindowVisibilityChanged：" + z);
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
        this.f22377h = interfaceC0458a;
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
                    com.opos.cmn.an.f.a.b("BlockSmallImage9", "render");
                    if (this.k == null && (interfaceC0458a = this.f22377h) != null) {
                        interfaceC0458a.e();
                    }
                    this.k = a2;
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
        com.opos.cmn.an.f.a.b("BlockSmallImage9", str);
        this.f22377h.b(1);
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
        com.opos.cmn.an.f.a.b("BlockSmallImage9", "destroy");
        this.k = null;
        this.f22370a = true;
        com.opos.mobad.n.c.j jVar = this.s;
        if (jVar != null) {
            jVar.removeAllViews();
        }
    }

    @Override // com.opos.mobad.n.a
    public int e() {
        return this.f22378i;
    }
}
