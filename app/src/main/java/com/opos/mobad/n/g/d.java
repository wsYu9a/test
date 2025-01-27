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
public class d implements com.opos.mobad.n.a {

    /* renamed from: b */
    private int f22494b;

    /* renamed from: c */
    private int f22495c;

    /* renamed from: f */
    private int f22498f;

    /* renamed from: h */
    private Context f22500h;

    /* renamed from: i */
    private a.InterfaceC0458a f22501i;

    /* renamed from: j */
    private int f22502j;
    private int k;
    private com.opos.mobad.n.d.d l;
    private ImageView m;
    private ad n;
    private TextView o;
    private x p;
    private com.opos.mobad.n.c.f q;
    private TextView r;
    private RelativeLayout s;
    private com.opos.mobad.n.c.h t;
    private com.opos.mobad.n.c.j u;
    private com.opos.mobad.c.a v;

    /* renamed from: a */
    private volatile boolean f22493a = false;

    /* renamed from: d */
    private int f22496d = 0;

    /* renamed from: e */
    private int f22497e = 0;

    /* renamed from: g */
    private boolean f22499g = false;

    /* renamed from: com.opos.mobad.n.g.d$1 */
    class AnonymousClass1 extends com.opos.mobad.n.c.g {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            if (d.this.f22501i != null) {
                d.this.f22501i.g(view, iArr);
            }
        }
    }

    /* renamed from: com.opos.mobad.n.g.d$2 */
    class AnonymousClass2 implements a.InterfaceC0428a {

        /* renamed from: a */
        final /* synthetic */ com.opos.mobad.c.d.a f22504a;

        AnonymousClass2(com.opos.mobad.c.d.a aVar) {
            aVar = aVar;
        }

        @Override // com.opos.mobad.c.d.a.InterfaceC0428a
        public void a(boolean z) {
            if (d.this.l == null) {
                return;
            }
            if (z) {
                d.this.j();
                if (d.this.f22501i != null) {
                    d.this.f22501i.b();
                }
                aVar.a((a.InterfaceC0428a) null);
            }
            com.opos.cmn.an.f.a.b("BlockBigImage12", "BlockBigImage12 onWindowVisibilityChanged：" + z);
        }
    }

    /* renamed from: com.opos.mobad.n.g.d$3 */
    class AnonymousClass3 implements a.InterfaceC0426a {

        /* renamed from: a */
        final /* synthetic */ com.opos.mobad.n.d.g f22506a;

        /* renamed from: b */
        final /* synthetic */ ImageView f22507b;

        /* renamed from: com.opos.mobad.n.g.d$3$1 */
        class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Bitmap f22509a;

            AnonymousClass1(Bitmap bitmap) {
                bitmap = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Bitmap bitmap;
                if (d.this.f22493a || (bitmap = bitmap) == null || bitmap.isRecycled()) {
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
            if (d.this.f22493a) {
                return;
            }
            if (gVar == null) {
                com.opos.cmn.an.f.a.b("BlockBigImage12", "null imgList");
                return;
            }
            if (i2 != 0 && i2 != 1) {
                if (d.this.f22501i != null) {
                    d.this.f22501i.c(i2);
                }
            } else {
                if (i2 == 1 && d.this.f22501i != null) {
                    d.this.f22501i.c(i2);
                }
                com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.g.d.3.1

                    /* renamed from: a */
                    final /* synthetic */ Bitmap f22509a;

                    AnonymousClass1(Bitmap bitmap2) {
                        bitmap = bitmap2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Bitmap bitmap2;
                        if (d.this.f22493a || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                            return;
                        }
                        imageView.setImageBitmap(bitmap);
                    }
                });
            }
        }
    }

    /* renamed from: com.opos.mobad.n.g.d$4 */
    class AnonymousClass4 implements a.InterfaceC0426a {

        /* renamed from: a */
        final /* synthetic */ boolean f22511a;

        /* renamed from: com.opos.mobad.n.g.d$4$1 */
        class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Bitmap f22513a;

            AnonymousClass1(Bitmap bitmap) {
                bitmap = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Bitmap bitmap;
                if (z || (bitmap = bitmap) == null || bitmap.isRecycled()) {
                    return;
                }
                d.this.q.setImageBitmap(bitmap);
            }
        }

        AnonymousClass4(boolean z) {
            z = z;
        }

        @Override // com.opos.mobad.c.a.InterfaceC0426a
        public void a(int i2, Bitmap bitmap) {
            if (z) {
                return;
            }
            if (i2 != 0 && i2 != 1) {
                if (d.this.f22501i != null) {
                    d.this.f22501i.c(i2);
                }
            } else {
                if (i2 == 1 && d.this.f22501i != null) {
                    d.this.f22501i.c(i2);
                }
                com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.g.d.4.1

                    /* renamed from: a */
                    final /* synthetic */ Bitmap f22513a;

                    AnonymousClass1(Bitmap bitmap2) {
                        bitmap = bitmap2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Bitmap bitmap2;
                        if (z || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                            return;
                        }
                        d.this.q.setImageBitmap(bitmap);
                    }
                });
            }
        }
    }

    private d(Context context, aj ajVar, int i2, int i3, com.opos.mobad.c.a aVar) {
        this.f22500h = context;
        this.k = i3;
        this.f22502j = i2;
        this.v = aVar;
        f();
        a(ajVar);
        i();
    }

    public static d a(Context context, aj ajVar, int i2, com.opos.mobad.c.a aVar) {
        return new d(context, ajVar, i2, 0, aVar);
    }

    private void a(ImageView imageView, com.opos.mobad.n.d.g gVar) {
        if (imageView == null || gVar == null || TextUtils.isEmpty(gVar.f22084a)) {
            return;
        }
        imageView.setVisibility(0);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.v.a(gVar.f22084a, gVar.f22085b, this.f22494b, this.f22495c, new a.InterfaceC0426a() { // from class: com.opos.mobad.n.g.d.3

            /* renamed from: a */
            final /* synthetic */ com.opos.mobad.n.d.g f22506a;

            /* renamed from: b */
            final /* synthetic */ ImageView f22507b;

            /* renamed from: com.opos.mobad.n.g.d$3$1 */
            class AnonymousClass1 implements Runnable {

                /* renamed from: a */
                final /* synthetic */ Bitmap f22509a;

                AnonymousClass1(Bitmap bitmap2) {
                    bitmap = bitmap2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Bitmap bitmap2;
                    if (d.this.f22493a || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
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
                if (d.this.f22493a) {
                    return;
                }
                if (gVar == null) {
                    com.opos.cmn.an.f.a.b("BlockBigImage12", "null imgList");
                    return;
                }
                if (i2 != 0 && i2 != 1) {
                    if (d.this.f22501i != null) {
                        d.this.f22501i.c(i2);
                    }
                } else {
                    if (i2 == 1 && d.this.f22501i != null) {
                        d.this.f22501i.c(i2);
                    }
                    com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.g.d.3.1

                        /* renamed from: a */
                        final /* synthetic */ Bitmap f22509a;

                        AnonymousClass1(Bitmap bitmap22) {
                            bitmap = bitmap22;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Bitmap bitmap22;
                            if (d.this.f22493a || (bitmap22 = bitmap) == null || bitmap22.isRecycled()) {
                                return;
                            }
                            imageView.setImageBitmap(bitmap);
                        }
                    });
                }
            }
        });
    }

    private void a(RelativeLayout relativeLayout) {
        relativeLayout.setId(View.generateViewId());
        int a2 = com.opos.cmn.an.h.f.a.a(this.f22500h, 36.0f);
        this.t.addView(relativeLayout, new RelativeLayout.LayoutParams(this.f22494b, a2));
        com.opos.mobad.n.c.f fVar = new com.opos.mobad.n.c.f(this.f22500h, com.opos.cmn.an.h.f.a.a(r2, 33.33f));
        this.q = fVar;
        fVar.setId(View.generateViewId());
        relativeLayout.addView(this.q, new RelativeLayout.LayoutParams(a2, a2));
        TextView textView = new TextView(this.f22500h);
        this.r = textView;
        textView.setTextColor(this.f22500h.getResources().getColor(R.color.opos_mobad_small_top_title_color));
        this.r.setTextSize(1, 14.0f);
        this.r.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.r.setSingleLine(true);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.f22500h, 8.0f);
        layoutParams.addRule(15);
        layoutParams.addRule(1, this.q.getId());
        relativeLayout.addView(this.r, layoutParams);
    }

    private void a(com.opos.mobad.n.c.h hVar) {
        hVar.a(com.opos.cmn.an.h.f.a.a(this.f22500h, 6.0f));
        hVar.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f22494b, this.f22497e);
        layoutParams.addRule(3, this.o.getId());
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f22500h, 8.0f);
        if (this.f22499g) {
            d(hVar);
        } else {
            c(hVar);
        }
        this.t.addView(hVar, layoutParams);
    }

    private void a(com.opos.mobad.n.d.d dVar) {
        if (this.f22499g) {
            e(dVar);
        } else {
            d(dVar);
        }
        this.n.a(dVar.r, dVar.s, dVar.f22077i, dVar.f22078j, dVar.k, dVar.B, dVar.f22074f);
        c(dVar);
        b(dVar);
    }

    private void a(com.opos.mobad.n.d.g gVar, com.opos.mobad.c.a aVar, boolean z) {
        com.opos.mobad.n.c.f fVar;
        if (gVar == null || (fVar = this.q) == null) {
            com.opos.cmn.an.f.a.b("BlockBigImage12", "iconUrl is null");
            return;
        }
        fVar.setVisibility(0);
        this.q.setScaleType(ImageView.ScaleType.FIT_XY);
        int a2 = com.opos.cmn.an.h.f.a.a(this.f22500h, 36.0f);
        aVar.a(gVar.f22084a, gVar.f22085b, a2, a2, new a.InterfaceC0426a() { // from class: com.opos.mobad.n.g.d.4

            /* renamed from: a */
            final /* synthetic */ boolean f22511a;

            /* renamed from: com.opos.mobad.n.g.d$4$1 */
            class AnonymousClass1 implements Runnable {

                /* renamed from: a */
                final /* synthetic */ Bitmap f22513a;

                AnonymousClass1(Bitmap bitmap2) {
                    bitmap = bitmap2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Bitmap bitmap2;
                    if (z || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                        return;
                    }
                    d.this.q.setImageBitmap(bitmap);
                }
            }

            AnonymousClass4(boolean z2) {
                z = z2;
            }

            @Override // com.opos.mobad.c.a.InterfaceC0426a
            public void a(int i2, Bitmap bitmap2) {
                if (z) {
                    return;
                }
                if (i2 != 0 && i2 != 1) {
                    if (d.this.f22501i != null) {
                        d.this.f22501i.c(i2);
                    }
                } else {
                    if (i2 == 1 && d.this.f22501i != null) {
                        d.this.f22501i.c(i2);
                    }
                    com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.g.d.4.1

                        /* renamed from: a */
                        final /* synthetic */ Bitmap f22513a;

                        AnonymousClass1(Bitmap bitmap22) {
                            bitmap = bitmap22;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Bitmap bitmap22;
                            if (z || (bitmap22 = bitmap) == null || bitmap22.isRecycled()) {
                                return;
                            }
                            d.this.q.setImageBitmap(bitmap);
                        }
                    });
                }
            }
        });
    }

    private void a(aj ajVar) {
        if (ajVar == null) {
            ajVar = aj.a(this.f22500h);
        }
        Context context = this.f22500h;
        int i2 = ajVar.f22455a;
        int i3 = ajVar.f22456b;
        int i4 = this.f22494b;
        this.u = new com.opos.mobad.n.c.j(context, new j.a(i2, i3, i4, i4 / this.f22498f));
        this.s = new RelativeLayout(this.f22500h);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.f22494b, -2);
        layoutParams.width = this.f22494b;
        layoutParams.height = -2;
        this.s.setId(View.generateViewId());
        this.s.setLayoutParams(layoutParams);
        this.s.setVisibility(8);
        this.u.addView(this.s, layoutParams);
        this.u.setLayoutParams(layoutParams);
        g();
        AnonymousClass1 anonymousClass1 = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.g.d.1
            AnonymousClass1() {
            }

            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (d.this.f22501i != null) {
                    d.this.f22501i.g(view, iArr);
                }
            }
        };
        this.s.setOnClickListener(anonymousClass1);
        this.s.setOnTouchListener(anonymousClass1);
    }

    public static d b(Context context, aj ajVar, int i2, com.opos.mobad.c.a aVar) {
        return new d(context, ajVar, i2, 1, aVar);
    }

    private void b(RelativeLayout relativeLayout) {
        TextView textView = new TextView(this.f22500h);
        this.o = textView;
        textView.setId(View.generateViewId());
        this.o.setTextColor(this.f22500h.getResources().getColor(R.color.opos_mobad_small_top_title_color));
        this.o.setTextSize(1, 17.0f);
        this.o.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.o.setMaxLines(2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(3, relativeLayout.getId());
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f22500h, 12.0f);
        this.t.addView(this.o, layoutParams);
    }

    private void b(com.opos.mobad.n.c.h hVar) {
        this.n = ad.b(this.f22500h);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f22500h, 320.0f), -2);
        layoutParams.addRule(3, hVar.getId());
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f22500h, 6.0f);
        this.t.addView(this.n, layoutParams);
    }

    private void b(com.opos.mobad.n.d.d dVar) {
        com.opos.mobad.c.a aVar;
        String str = dVar.f22074f;
        if (!TextUtils.isEmpty(str)) {
            this.r.setText(str);
        }
        if (dVar.m != null && !TextUtils.isEmpty(this.l.m.f22084a) && (aVar = this.v) != null) {
            a(dVar.m, aVar, this.f22493a);
            return;
        }
        com.opos.cmn.an.f.a.b("BlockBigImage12", "BlockBigImage12 iconUrl is null");
        this.q.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.r.getLayoutParams();
        layoutParams.leftMargin = 0;
        this.r.setLayoutParams(layoutParams);
    }

    public static d c(Context context, aj ajVar, int i2, com.opos.mobad.c.a aVar) {
        return new d(context, ajVar, i2, 2, aVar);
    }

    private void c(com.opos.mobad.n.c.h hVar) {
        this.m = new ImageView(this.f22500h);
        hVar.addView(this.m, new RelativeLayout.LayoutParams(this.f22496d, this.f22497e));
        this.m.setVisibility(8);
    }

    private void c(com.opos.mobad.n.d.d dVar) {
        String str = dVar.f22073e;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.o.setText(str);
    }

    private void d(com.opos.mobad.n.c.h hVar) {
        this.p = x.a(this.f22500h, this.f22496d, this.f22497e);
        hVar.addView(this.p, new RelativeLayout.LayoutParams(this.f22496d, this.f22497e));
    }

    private void d(com.opos.mobad.n.d.d dVar) {
        List<com.opos.mobad.n.d.g> list = dVar.f22075g;
        if (list == null || list.size() == 0) {
            return;
        }
        a(this.m, dVar.f22075g.get(0));
    }

    private void e(com.opos.mobad.n.d.d dVar) {
        x xVar;
        List<com.opos.mobad.n.d.g> list = dVar.f22075g;
        if (list == null || list.size() == 0 || (xVar = this.p) == null) {
            return;
        }
        xVar.a(dVar, this.v, this.f22493a);
    }

    private void f() {
        int a2;
        this.f22496d = com.opos.cmn.an.h.f.a.a(this.f22500h, 320.0f);
        int i2 = this.k;
        if (i2 == 0) {
            this.f22494b = com.opos.cmn.an.h.f.a.a(this.f22500h, 320.0f);
            this.f22495c = com.opos.cmn.an.h.f.a.a(this.f22500h, 306.0f);
            a2 = com.opos.cmn.an.h.f.a.a(this.f22500h, 180.0f);
        } else {
            if (i2 != 1) {
                if (i2 == 2) {
                    this.f22494b = com.opos.cmn.an.h.f.a.a(this.f22500h, 320.0f);
                    this.f22495c = com.opos.cmn.an.h.f.a.a(this.f22500h, 338.0f);
                    this.f22497e = com.opos.cmn.an.h.f.a.a(this.f22500h, 210.0f);
                    this.f22499g = true;
                }
                this.f22498f = this.f22495c;
            }
            this.f22494b = com.opos.cmn.an.h.f.a.a(this.f22500h, 320.0f);
            this.f22495c = com.opos.cmn.an.h.f.a.a(this.f22500h, 338.0f);
            a2 = com.opos.cmn.an.h.f.a.a(this.f22500h, 210.0f);
        }
        this.f22497e = a2;
        this.f22498f = this.f22495c;
    }

    private void g() {
        com.opos.mobad.n.c.h hVar = new com.opos.mobad.n.c.h(this.f22500h);
        this.t = hVar;
        hVar.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f22494b, this.f22495c);
        this.t.setVisibility(4);
        this.s.addView(this.t, layoutParams);
        h();
    }

    private void h() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f22500h);
        a(relativeLayout);
        b(relativeLayout);
        com.opos.mobad.n.c.h hVar = new com.opos.mobad.n.c.h(this.f22500h);
        a(hVar);
        b(hVar);
    }

    private void i() {
        com.opos.mobad.c.d.a aVar = new com.opos.mobad.c.d.a(this.f22500h);
        aVar.a(new a.InterfaceC0428a() { // from class: com.opos.mobad.n.g.d.2

            /* renamed from: a */
            final /* synthetic */ com.opos.mobad.c.d.a f22504a;

            AnonymousClass2(com.opos.mobad.c.d.a aVar2) {
                aVar = aVar2;
            }

            @Override // com.opos.mobad.c.d.a.InterfaceC0428a
            public void a(boolean z) {
                if (d.this.l == null) {
                    return;
                }
                if (z) {
                    d.this.j();
                    if (d.this.f22501i != null) {
                        d.this.f22501i.b();
                    }
                    aVar.a((a.InterfaceC0428a) null);
                }
                com.opos.cmn.an.f.a.b("BlockBigImage12", "BlockBigImage12 onWindowVisibilityChanged：" + z);
            }
        });
        this.s.addView(aVar2, new RelativeLayout.LayoutParams(0, 0));
    }

    public void j() {
        this.t.setVisibility(0);
    }

    @Override // com.opos.mobad.n.a
    public void a() {
    }

    @Override // com.opos.mobad.n.a
    public void a(a.InterfaceC0458a interfaceC0458a) {
        this.f22501i = interfaceC0458a;
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
                    com.opos.cmn.an.f.a.b("BlockBigImage12", "render");
                    if (this.l == null && (interfaceC0458a = this.f22501i) != null) {
                        interfaceC0458a.e();
                    }
                    this.l = a2;
                    com.opos.mobad.n.c.j jVar = this.u;
                    if (jVar != null && jVar.getVisibility() != 0) {
                        this.u.setVisibility(0);
                    }
                    RelativeLayout relativeLayout = this.s;
                    if (relativeLayout != null && relativeLayout.getVisibility() != 0) {
                        this.s.setVisibility(0);
                    }
                    a(a2);
                    return;
                }
                str = "imgList is null";
            }
        }
        com.opos.cmn.an.f.a.b("BlockBigImage12", str);
        this.f22501i.b(1);
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
        com.opos.cmn.an.f.a.b("BlockBigImage12", "destroy");
        this.l = null;
        this.f22493a = true;
        com.opos.mobad.n.c.j jVar = this.u;
        if (jVar != null) {
            jVar.removeAllViews();
        }
    }

    @Override // com.opos.mobad.n.a
    public int e() {
        return this.f22502j;
    }
}
