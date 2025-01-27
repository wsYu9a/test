package com.opos.mobad.n.g;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.opos.mobad.c.a;
import com.opos.mobad.c.d.a;
import com.opos.mobad.n.a;
import com.opos.mobad.n.c.j;
import java.util.List;

/* loaded from: classes4.dex */
public class aa implements com.opos.mobad.n.a {

    /* renamed from: a */
    private volatile boolean f22353a = false;

    /* renamed from: b */
    private int f22354b = 320;

    /* renamed from: c */
    private int f22355c = 84;

    /* renamed from: d */
    private int f22356d = 0;

    /* renamed from: e */
    private int f22357e;

    /* renamed from: f */
    private Context f22358f;

    /* renamed from: g */
    private a.InterfaceC0458a f22359g;

    /* renamed from: h */
    private int f22360h;

    /* renamed from: i */
    private int f22361i;

    /* renamed from: j */
    private com.opos.mobad.n.d.d f22362j;
    private com.opos.mobad.n.c.f k;
    private ac l;
    private RelativeLayout m;
    private com.opos.mobad.n.c.h n;
    private com.opos.mobad.n.c.j o;
    private com.opos.mobad.c.a p;

    /* renamed from: com.opos.mobad.n.g.aa$1 */
    class AnonymousClass1 extends com.opos.mobad.n.c.g {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            if (aa.this.f22359g != null) {
                aa.this.f22359g.g(view, iArr);
            }
        }
    }

    /* renamed from: com.opos.mobad.n.g.aa$2 */
    class AnonymousClass2 implements a.InterfaceC0428a {

        /* renamed from: a */
        final /* synthetic */ com.opos.mobad.c.d.a f22364a;

        AnonymousClass2(com.opos.mobad.c.d.a aVar) {
            aVar = aVar;
        }

        @Override // com.opos.mobad.c.d.a.InterfaceC0428a
        public void a(boolean z) {
            if (aa.this.f22362j == null) {
                return;
            }
            if (z) {
                aa.this.j();
                if (aa.this.f22359g != null) {
                    aa.this.f22359g.b();
                }
                aVar.a((a.InterfaceC0428a) null);
            }
            com.opos.cmn.an.f.a.b("BlockSmallImage7", "BlockSmallImage7 onWindowVisibilityChanged：" + z);
        }
    }

    /* renamed from: com.opos.mobad.n.g.aa$3 */
    class AnonymousClass3 implements a.InterfaceC0426a {

        /* renamed from: a */
        final /* synthetic */ com.opos.mobad.n.d.d f22366a;

        /* renamed from: com.opos.mobad.n.g.aa$3$1 */
        class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Bitmap f22368a;

            AnonymousClass1(Bitmap bitmap) {
                bitmap = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Bitmap bitmap;
                if (aa.this.f22353a || (bitmap = bitmap) == null || bitmap.isRecycled()) {
                    return;
                }
                aa.this.k.setImageBitmap(bitmap);
            }
        }

        AnonymousClass3(com.opos.mobad.n.d.d dVar) {
            dVar = dVar;
        }

        @Override // com.opos.mobad.c.a.InterfaceC0426a
        public void a(int i2, Bitmap bitmap) {
            if (aa.this.f22353a) {
                return;
            }
            if (dVar.f22075g.get(0) == null) {
                com.opos.cmn.an.f.a.b("BlockSmallImage7", "null imgList");
                return;
            }
            if (i2 != 0 && i2 != 1) {
                if (aa.this.f22359g != null) {
                    aa.this.f22359g.c(i2);
                }
            } else {
                if (i2 == 1 && aa.this.f22359g != null) {
                    aa.this.f22359g.c(i2);
                }
                com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.g.aa.3.1

                    /* renamed from: a */
                    final /* synthetic */ Bitmap f22368a;

                    AnonymousClass1(Bitmap bitmap2) {
                        bitmap = bitmap2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Bitmap bitmap2;
                        if (aa.this.f22353a || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                            return;
                        }
                        aa.this.k.setImageBitmap(bitmap);
                    }
                });
            }
        }
    }

    private aa(Context context, aj ajVar, int i2, int i3, com.opos.mobad.c.a aVar) {
        this.f22358f = context;
        this.f22361i = i3;
        this.f22360h = i2;
        this.p = aVar;
        f();
        a(ajVar);
        i();
    }

    public static aa a(Context context, aj ajVar, int i2, com.opos.mobad.c.a aVar) {
        return new aa(context, ajVar, i2, 1, aVar);
    }

    private void a(com.opos.mobad.n.d.d dVar) {
        b(dVar);
        this.l.a(dVar);
    }

    private void a(aj ajVar) {
        if (ajVar == null) {
            ajVar = aj.a(this.f22358f);
        }
        Context context = this.f22358f;
        int i2 = ajVar.f22455a;
        int i3 = ajVar.f22456b;
        int i4 = this.f22354b;
        this.o = new com.opos.mobad.n.c.j(context, new j.a(i2, i3, i4, i4 / this.f22357e));
        this.m = new RelativeLayout(this.f22358f);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.f22354b, -2);
        layoutParams.width = this.f22354b;
        layoutParams.height = -2;
        this.m.setId(View.generateViewId());
        this.m.setLayoutParams(layoutParams);
        this.m.setVisibility(8);
        this.o.addView(this.m, layoutParams);
        this.o.setLayoutParams(layoutParams);
        g();
        AnonymousClass1 anonymousClass1 = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.g.aa.1
            AnonymousClass1() {
            }

            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (aa.this.f22359g != null) {
                    aa.this.f22359g.g(view, iArr);
                }
            }
        };
        this.m.setOnClickListener(anonymousClass1);
        this.m.setOnTouchListener(anonymousClass1);
    }

    public static aa b(Context context, aj ajVar, int i2, com.opos.mobad.c.a aVar) {
        return new aa(context, ajVar, i2, 2, aVar);
    }

    private void b(com.opos.mobad.n.d.d dVar) {
        com.opos.mobad.n.c.f fVar;
        List<com.opos.mobad.n.d.g> list = dVar.f22075g;
        if (list == null || list.size() == 0 || (fVar = this.k) == null) {
            return;
        }
        fVar.setScaleType(ImageView.ScaleType.FIT_XY);
        this.p.a(dVar.f22075g.get(0).f22084a, dVar.f22075g.get(0).f22085b, this.f22354b, this.f22355c, new a.InterfaceC0426a() { // from class: com.opos.mobad.n.g.aa.3

            /* renamed from: a */
            final /* synthetic */ com.opos.mobad.n.d.d f22366a;

            /* renamed from: com.opos.mobad.n.g.aa$3$1 */
            class AnonymousClass1 implements Runnable {

                /* renamed from: a */
                final /* synthetic */ Bitmap f22368a;

                AnonymousClass1(Bitmap bitmap2) {
                    bitmap = bitmap2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Bitmap bitmap2;
                    if (aa.this.f22353a || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                        return;
                    }
                    aa.this.k.setImageBitmap(bitmap);
                }
            }

            AnonymousClass3(com.opos.mobad.n.d.d dVar2) {
                dVar = dVar2;
            }

            @Override // com.opos.mobad.c.a.InterfaceC0426a
            public void a(int i2, Bitmap bitmap2) {
                if (aa.this.f22353a) {
                    return;
                }
                if (dVar.f22075g.get(0) == null) {
                    com.opos.cmn.an.f.a.b("BlockSmallImage7", "null imgList");
                    return;
                }
                if (i2 != 0 && i2 != 1) {
                    if (aa.this.f22359g != null) {
                        aa.this.f22359g.c(i2);
                    }
                } else {
                    if (i2 == 1 && aa.this.f22359g != null) {
                        aa.this.f22359g.c(i2);
                    }
                    com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.g.aa.3.1

                        /* renamed from: a */
                        final /* synthetic */ Bitmap f22368a;

                        AnonymousClass1(Bitmap bitmap22) {
                            bitmap = bitmap22;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Bitmap bitmap22;
                            if (aa.this.f22353a || (bitmap22 = bitmap) == null || bitmap22.isRecycled()) {
                                return;
                            }
                            aa.this.k.setImageBitmap(bitmap);
                        }
                    });
                }
            }
        });
    }

    private void f() {
        this.f22356d = com.opos.cmn.an.h.f.a.a(this.f22358f, 128.0f);
        int i2 = this.f22361i;
        if (i2 == 1 || i2 == 2) {
            this.f22354b = com.opos.cmn.an.h.f.a.a(this.f22358f, 320.0f);
            this.f22355c = com.opos.cmn.an.h.f.a.a(this.f22358f, 84.0f);
        }
        this.f22357e = this.f22355c;
    }

    private void g() {
        com.opos.mobad.n.c.h hVar = new com.opos.mobad.n.c.h(this.f22358f);
        this.n = hVar;
        hVar.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f22354b, this.f22355c);
        this.n.setVisibility(4);
        this.m.addView(this.n, layoutParams);
        h();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void h() {
        /*
            r5 = this;
            com.opos.mobad.n.c.f r0 = new com.opos.mobad.n.c.f
            android.content.Context r1 = r5.f22358f
            r2 = 1082130432(0x40800000, float:4.0)
            int r2 = com.opos.cmn.an.h.f.a.a(r1, r2)
            float r2 = (float) r2
            r0.<init>(r1, r2)
            r5.k = r0
            int r1 = android.view.View.generateViewId()
            r0.setId(r1)
            android.widget.RelativeLayout$LayoutParams r0 = new android.widget.RelativeLayout$LayoutParams
            int r1 = r5.f22356d
            int r2 = r5.f22355c
            r0.<init>(r1, r2)
            int r1 = r5.f22361i
            r2 = 2
            r3 = 1
            if (r1 != r3) goto L2c
            r1 = 11
        L28:
            r0.addRule(r1)
            goto L31
        L2c:
            if (r1 != r2) goto L31
            r1 = 9
            goto L28
        L31:
            com.opos.mobad.n.c.h r1 = r5.n
            com.opos.mobad.n.c.f r4 = r5.k
            r1.addView(r4, r0)
            android.content.Context r0 = r5.f22358f
            com.opos.mobad.n.g.ac r0 = com.opos.mobad.n.g.ac.a(r0)
            r5.l = r0
            android.widget.RelativeLayout$LayoutParams r0 = new android.widget.RelativeLayout$LayoutParams
            android.content.Context r1 = r5.f22358f
            r4 = 1127743488(0x43380000, float:184.0)
            int r1 = com.opos.cmn.an.h.f.a.a(r1, r4)
            int r4 = r5.f22355c
            r0.<init>(r1, r4)
            int r1 = r5.f22361i
            r4 = 1090519040(0x41000000, float:8.0)
            if (r1 != r3) goto L68
            r1 = 0
            com.opos.mobad.n.c.f r2 = r5.k
            int r2 = r2.getId()
            r0.addRule(r1, r2)
            android.content.Context r1 = r5.f22358f
            int r1 = com.opos.cmn.an.h.f.a.a(r1, r4)
            r0.rightMargin = r1
            goto L7b
        L68:
            if (r1 != r2) goto L7b
            com.opos.mobad.n.c.f r1 = r5.k
            int r1 = r1.getId()
            r0.addRule(r3, r1)
            android.content.Context r1 = r5.f22358f
            int r1 = com.opos.cmn.an.h.f.a.a(r1, r4)
            r0.leftMargin = r1
        L7b:
            com.opos.mobad.n.c.h r1 = r5.n
            com.opos.mobad.n.g.ac r2 = r5.l
            r1.addView(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.n.g.aa.h():void");
    }

    private void i() {
        com.opos.mobad.c.d.a aVar = new com.opos.mobad.c.d.a(this.f22358f);
        aVar.a(new a.InterfaceC0428a() { // from class: com.opos.mobad.n.g.aa.2

            /* renamed from: a */
            final /* synthetic */ com.opos.mobad.c.d.a f22364a;

            AnonymousClass2(com.opos.mobad.c.d.a aVar2) {
                aVar = aVar2;
            }

            @Override // com.opos.mobad.c.d.a.InterfaceC0428a
            public void a(boolean z) {
                if (aa.this.f22362j == null) {
                    return;
                }
                if (z) {
                    aa.this.j();
                    if (aa.this.f22359g != null) {
                        aa.this.f22359g.b();
                    }
                    aVar.a((a.InterfaceC0428a) null);
                }
                com.opos.cmn.an.f.a.b("BlockSmallImage7", "BlockSmallImage7 onWindowVisibilityChanged：" + z);
            }
        });
        this.m.addView(aVar2, new RelativeLayout.LayoutParams(0, 0));
    }

    public void j() {
        this.n.setVisibility(0);
    }

    @Override // com.opos.mobad.n.a
    public void a() {
    }

    @Override // com.opos.mobad.n.a
    public void a(a.InterfaceC0458a interfaceC0458a) {
        this.f22359g = interfaceC0458a;
        this.l.a(interfaceC0458a);
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
                    com.opos.cmn.an.f.a.b("BlockSmallImage7", "render");
                    if (this.f22362j == null && (interfaceC0458a = this.f22359g) != null) {
                        interfaceC0458a.e();
                    }
                    this.f22362j = a2;
                    com.opos.mobad.n.c.j jVar = this.o;
                    if (jVar != null && jVar.getVisibility() != 0) {
                        this.o.setVisibility(0);
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
        com.opos.cmn.an.f.a.b("BlockSmallImage7", str);
        this.f22359g.b(1);
    }

    @Override // com.opos.mobad.n.a
    public void b() {
    }

    @Override // com.opos.mobad.n.a
    public View c() {
        return this.o;
    }

    @Override // com.opos.mobad.n.a
    public void d() {
        com.opos.cmn.an.f.a.b("BlockSmallImage7", "destroy");
        this.f22362j = null;
        this.f22353a = true;
        com.opos.mobad.n.c.j jVar = this.o;
        if (jVar != null) {
            jVar.removeAllViews();
        }
    }

    @Override // com.opos.mobad.n.a
    public int e() {
        return this.f22360h;
    }
}
