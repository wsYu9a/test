package com.opos.mobad.n.f;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.c.a;
import com.opos.mobad.c.d.a;
import com.opos.mobad.n.a;
import com.opos.mobad.n.a.t;
import com.opos.mobad.n.c.m;
import com.tencent.bugly.beta.tinker.TinkerReport;
import com.vivo.ic.dm.Downloads;

/* loaded from: classes4.dex */
public class g implements com.opos.mobad.n.a {

    /* renamed from: a */
    private static int f22244a = 0;

    /* renamed from: b */
    private static int f22245b = 1;
    private c A;

    /* renamed from: c */
    private boolean f22246c;

    /* renamed from: g */
    private RelativeLayout f22250g;

    /* renamed from: h */
    private RelativeLayout f22251h;

    /* renamed from: i */
    private Context f22252i;

    /* renamed from: j */
    private a.InterfaceC0458a f22253j;
    private View k;
    private int l;
    private View m;
    private ProgressBar n;
    private View o;
    private k p;
    private com.opos.mobad.c.c.a q;
    private int s;
    private com.opos.mobad.n.d.e w;
    private int x;
    private t y;
    private com.opos.mobad.c.a z;

    /* renamed from: d */
    private boolean f22247d = false;

    /* renamed from: e */
    private boolean f22248e = false;

    /* renamed from: f */
    private boolean f22249f = false;
    private boolean r = false;
    private boolean t = false;
    private Runnable u = new Runnable() { // from class: com.opos.mobad.n.f.g.1
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (g.this.r) {
                return;
            }
            if (g.this.f22253j != null) {
                g.this.f22253j.d(g.this.q.d(), g.this.q.c());
            }
            g.this.n.setProgress(g.this.f());
            com.opos.cmn.an.f.a.b("InterstitialPortVideo", "on progress" + g.this.n.getProgress());
            g.this.v.postDelayed(this, 500L);
        }
    };
    private com.opos.mobad.c.c.b B = new com.opos.mobad.c.c.b() { // from class: com.opos.mobad.n.f.g.3
        AnonymousClass3() {
        }

        @Override // com.opos.mobad.c.c.b
        public void a(int i2, String str) {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onError:" + i2 + "," + str);
            if (g.this.f22253j != null) {
                g.this.f22253j.a(i2, str);
            }
        }

        @Override // com.opos.mobad.c.c.b
        public void c() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onPrepare");
            g.this.m();
            if (g.this.f22253j != null) {
                g.this.f22253j.d(0L, g.this.q.c());
            }
        }

        @Override // com.opos.mobad.c.c.b
        public void d() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onStart");
            g.this.v.removeCallbacks(g.this.u);
            g.this.v.postDelayed(g.this.u, 500L);
            g.this.f22253j.d(g.this.q.d(), g.this.q.c());
            g.this.n.setProgress(0);
            g.this.i();
        }

        @Override // com.opos.mobad.c.c.b
        public void e() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onComplete");
            if (g.this.f22253j != null) {
                g.this.f22253j.a(g.this.q.c(), g.this.q.c());
            }
            g.this.v.removeCallbacks(g.this.u);
            g.this.k();
        }

        @Override // com.opos.mobad.c.c.b
        public void f() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onResume");
            g.this.t = false;
            g.this.i();
        }

        @Override // com.opos.mobad.c.c.b
        public void g() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onPause");
            g.this.o.setVisibility(0);
        }

        @Override // com.opos.mobad.c.c.b
        public void h() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onBufferingStart");
            g.this.j();
        }

        @Override // com.opos.mobad.c.c.b
        public void i() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onBufferingEnd");
            g.this.i();
        }

        @Override // com.opos.mobad.c.c.b
        public void j() {
        }
    };
    private Handler v = new Handler(Looper.getMainLooper());

    /* renamed from: com.opos.mobad.n.f.g$1 */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (g.this.r) {
                return;
            }
            if (g.this.f22253j != null) {
                g.this.f22253j.d(g.this.q.d(), g.this.q.c());
            }
            g.this.n.setProgress(g.this.f());
            com.opos.cmn.an.f.a.b("InterstitialPortVideo", "on progress" + g.this.n.getProgress());
            g.this.v.postDelayed(this, 500L);
        }
    }

    /* renamed from: com.opos.mobad.n.f.g$2 */
    class AnonymousClass2 implements a.InterfaceC0428a {
        AnonymousClass2() {
        }

        @Override // com.opos.mobad.c.d.a.InterfaceC0428a
        public void a(boolean z) {
            if (g.this.w == null) {
                return;
            }
            if (!z) {
                g.this.q.f();
                return;
            }
            g.this.l();
            if (g.this.q.i() != 5) {
                if (g.this.q.i() == 3 && g.this.t) {
                    com.opos.cmn.an.f.a.b("InterstitialPortVideo", "resume but user pause");
                } else {
                    g.this.q.g();
                }
            }
        }
    }

    /* renamed from: com.opos.mobad.n.f.g$3 */
    class AnonymousClass3 implements com.opos.mobad.c.c.b {
        AnonymousClass3() {
        }

        @Override // com.opos.mobad.c.c.b
        public void a(int i2, String str) {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onError:" + i2 + "," + str);
            if (g.this.f22253j != null) {
                g.this.f22253j.a(i2, str);
            }
        }

        @Override // com.opos.mobad.c.c.b
        public void c() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onPrepare");
            g.this.m();
            if (g.this.f22253j != null) {
                g.this.f22253j.d(0L, g.this.q.c());
            }
        }

        @Override // com.opos.mobad.c.c.b
        public void d() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onStart");
            g.this.v.removeCallbacks(g.this.u);
            g.this.v.postDelayed(g.this.u, 500L);
            g.this.f22253j.d(g.this.q.d(), g.this.q.c());
            g.this.n.setProgress(0);
            g.this.i();
        }

        @Override // com.opos.mobad.c.c.b
        public void e() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onComplete");
            if (g.this.f22253j != null) {
                g.this.f22253j.a(g.this.q.c(), g.this.q.c());
            }
            g.this.v.removeCallbacks(g.this.u);
            g.this.k();
        }

        @Override // com.opos.mobad.c.c.b
        public void f() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onResume");
            g.this.t = false;
            g.this.i();
        }

        @Override // com.opos.mobad.c.c.b
        public void g() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onPause");
            g.this.o.setVisibility(0);
        }

        @Override // com.opos.mobad.c.c.b
        public void h() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onBufferingStart");
            g.this.j();
        }

        @Override // com.opos.mobad.c.c.b
        public void i() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onBufferingEnd");
            g.this.i();
        }

        @Override // com.opos.mobad.c.c.b
        public void j() {
        }
    }

    /* renamed from: com.opos.mobad.n.f.g$4 */
    class AnonymousClass4 extends com.opos.mobad.n.c.g {
        AnonymousClass4() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            if (g.this.f22253j != null) {
                g.this.f22253j.e(view, iArr);
            }
        }
    }

    /* renamed from: com.opos.mobad.n.f.g$5 */
    class AnonymousClass5 extends com.opos.mobad.n.c.g {
        AnonymousClass5() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            if (g.this.f22253j != null) {
                g.this.f22253j.g(view, iArr);
            }
        }
    }

    /* renamed from: com.opos.mobad.n.f.g$6 */
    class AnonymousClass6 extends com.opos.mobad.n.c.g {
        AnonymousClass6() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            if (g.this.f22253j != null) {
                g.this.f22253j.f(view, iArr);
            }
        }
    }

    /* renamed from: com.opos.mobad.n.f.g$7 */
    class AnonymousClass7 implements a.InterfaceC0426a {

        /* renamed from: com.opos.mobad.n.f.g$7$1 */
        class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Bitmap f22261a;

            AnonymousClass1(Bitmap bitmap) {
                bitmap = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Bitmap bitmap;
                if (g.this.r || (bitmap = bitmap) == null || bitmap.isRecycled()) {
                    return;
                }
                g.this.A.a(bitmap);
            }
        }

        AnonymousClass7() {
        }

        @Override // com.opos.mobad.c.a.InterfaceC0426a
        public void a(int i2, Bitmap bitmap) {
            if (g.this.r) {
                return;
            }
            if (i2 != 0 && i2 != 1) {
                if (g.this.f22253j != null) {
                    g.this.f22253j.c(i2);
                }
            } else {
                if (i2 == 1 && g.this.f22253j != null) {
                    g.this.f22253j.c(i2);
                }
                com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.f.g.7.1

                    /* renamed from: a */
                    final /* synthetic */ Bitmap f22261a;

                    AnonymousClass1(Bitmap bitmap2) {
                        bitmap = bitmap2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Bitmap bitmap2;
                        if (g.this.r || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                            return;
                        }
                        g.this.A.a(bitmap);
                    }
                });
            }
        }
    }

    /* renamed from: com.opos.mobad.n.f.g$8 */
    class AnonymousClass8 implements a.InterfaceC0426a {

        /* renamed from: com.opos.mobad.n.f.g$8$1 */
        class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Bitmap f22264a;

            AnonymousClass1(Bitmap bitmap) {
                bitmap = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Bitmap bitmap;
                if (g.this.r || (bitmap = bitmap) == null || bitmap.isRecycled()) {
                    return;
                }
                g.this.p.a(bitmap);
            }
        }

        AnonymousClass8() {
        }

        @Override // com.opos.mobad.c.a.InterfaceC0426a
        public void a(int i2, Bitmap bitmap) {
            if (g.this.r) {
                return;
            }
            if (i2 != 0 && i2 != 1) {
                if (g.this.f22253j != null) {
                    g.this.f22253j.c(i2);
                }
            } else {
                if (i2 == 1 && g.this.f22253j != null) {
                    g.this.f22253j.c(i2);
                }
                com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.f.g.8.1

                    /* renamed from: a */
                    final /* synthetic */ Bitmap f22264a;

                    AnonymousClass1(Bitmap bitmap2) {
                        bitmap = bitmap2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Bitmap bitmap2;
                        if (g.this.r || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                            return;
                        }
                        g.this.p.a(bitmap);
                    }
                });
            }
        }
    }

    public g(Context context, int i2, t tVar, int i3, com.opos.mobad.c.c.a aVar, com.opos.mobad.c.a aVar2) {
        this.f22252i = context;
        this.x = i2;
        this.f22250g = new RelativeLayout(context);
        this.q = aVar;
        aVar.a(this.B);
        this.s = i3;
        this.y = tVar;
        this.z = aVar2;
        this.f22246c = m.a(context, 2.12f) >= 0;
        a(tVar, i3);
        g();
        h();
    }

    public static final com.opos.mobad.n.a a(Context context, int i2, com.opos.mobad.c.c.a aVar, com.opos.mobad.c.a aVar2) {
        return new g(context.getApplicationContext(), i2, new t(275, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_META_NOT_FOUND, t.a.BELOW), f22244a, aVar, aVar2);
    }

    private void a(t tVar, int i2) {
        RelativeLayout.LayoutParams layoutParams;
        this.f22251h = new RelativeLayout(this.f22252i);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f22252i, 275.0f), com.opos.cmn.an.h.f.a.a(this.f22252i, 489.0f));
        layoutParams2.addRule(13);
        this.f22250g.addView(this.f22251h, layoutParams2);
        this.k = this.q.b();
        this.q.d(-16777216);
        this.k.setBackgroundColor(-16777216);
        int generateViewId = View.generateViewId();
        this.l = generateViewId;
        this.k.setId(generateViewId);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f22252i, tVar.f21907a), com.opos.cmn.an.h.f.a.a(this.f22252i, tVar.f21908b));
        layoutParams3.addRule(10);
        this.f22251h.addView(this.k, layoutParams3);
        FrameLayout frameLayout = new FrameLayout(this.f22252i);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(7, this.l);
        layoutParams4.addRule(5, this.l);
        layoutParams4.addRule(6, this.l);
        layoutParams4.addRule(8, this.l);
        this.f22251h.addView(frameLayout, layoutParams4);
        AnonymousClass4 anonymousClass4 = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.f.g.4
            AnonymousClass4() {
            }

            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (g.this.f22253j != null) {
                    g.this.f22253j.e(view, iArr);
                }
            }
        };
        frameLayout.setOnTouchListener(anonymousClass4);
        frameLayout.setOnClickListener(anonymousClass4);
        this.m = new ProgressBar(this.f22252i);
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f22252i, 30.0f), com.opos.cmn.an.h.f.a.a(this.f22252i, 39.0f));
        layoutParams5.gravity = 17;
        this.m.setVisibility(0);
        frameLayout.addView(this.m, layoutParams5);
        View view = new View(this.f22252i);
        this.o = view;
        view.setBackground(this.f22252i.getResources().getDrawable(R.drawable.opos_mobad_continue_bn));
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f22252i, 60.0f), com.opos.cmn.an.h.f.a.a(this.f22252i, 60.0f));
        layoutParams6.gravity = 17;
        this.o.setVisibility(4);
        frameLayout.addView(this.o, layoutParams6);
        if (i2 == f22245b) {
            this.p = this.f22246c ? k.a(this.f22252i, 44, 14, 12, -1946157056) : k.c(this.f22252i, 44, 14, 12, -1946157056);
            layoutParams = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.f22252i, 76.0f));
            layoutParams.addRule(8, this.l);
            layoutParams.addRule(7, this.l);
            layoutParams.addRule(5, this.l);
        } else {
            this.p = this.f22246c ? k.b(this.f22252i, 64, 18, 14, -1) : k.d(this.f22252i, 67, 24, 14, -1);
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(3, this.l);
        }
        this.f22251h.addView(this.p, layoutParams);
        AnonymousClass5 anonymousClass5 = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.f.g.5
            AnonymousClass5() {
            }

            @Override // com.opos.mobad.n.c.g
            public void a(View view2, int[] iArr) {
                if (g.this.f22253j != null) {
                    g.this.f22253j.g(view2, iArr);
                }
            }
        };
        this.p.setOnClickListener(anonymousClass5);
        this.p.setOnTouchListener(anonymousClass5);
        AnonymousClass6 anonymousClass6 = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.f.g.6
            AnonymousClass6() {
            }

            @Override // com.opos.mobad.n.c.g
            public void a(View view2, int[] iArr) {
                if (g.this.f22253j != null) {
                    g.this.f22253j.f(view2, iArr);
                }
            }
        };
        this.p.c().setOnClickListener(anonymousClass6);
        this.p.c().setOnTouchListener(anonymousClass6);
        ProgressBar progressBar = new ProgressBar(this.f22252i);
        this.n = progressBar;
        progressBar.setId(View.generateViewId());
        m.a(this.n, "mOnlyIndeterminate", new Boolean(false));
        this.n.setIndeterminate(false);
        this.n.setProgressDrawable(new ClipDrawable(new ColorDrawable(-1), 3, 1));
        this.n.setBackgroundColor(0);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.f22252i, 2.0f));
        layoutParams7.addRule(8, this.l);
        layoutParams7.addRule(7, this.l);
        layoutParams7.addRule(5, this.l);
        this.n.setVisibility(0);
        this.f22251h.addView(this.n, layoutParams7);
    }

    private void a(com.opos.mobad.n.d.e eVar) {
        if (this.w != null) {
            return;
        }
        this.A.a(eVar.f22074f, eVar.f22073e, eVar.l);
        com.opos.mobad.n.d.g gVar = eVar.m;
        if (gVar == null || TextUtils.isEmpty(gVar.f22084a)) {
            this.p.a();
            return;
        }
        int a2 = com.opos.cmn.an.h.f.a.a(this.f22252i, 44.0f);
        com.opos.mobad.c.a aVar = this.z;
        com.opos.mobad.n.d.g gVar2 = eVar.m;
        aVar.a(gVar2.f22084a, gVar2.f22085b, a2, a2, new a.InterfaceC0426a() { // from class: com.opos.mobad.n.f.g.7

            /* renamed from: com.opos.mobad.n.f.g$7$1 */
            class AnonymousClass1 implements Runnable {

                /* renamed from: a */
                final /* synthetic */ Bitmap f22261a;

                AnonymousClass1(Bitmap bitmap2) {
                    bitmap = bitmap2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Bitmap bitmap2;
                    if (g.this.r || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                        return;
                    }
                    g.this.A.a(bitmap);
                }
            }

            AnonymousClass7() {
            }

            @Override // com.opos.mobad.c.a.InterfaceC0426a
            public void a(int i2, Bitmap bitmap2) {
                if (g.this.r) {
                    return;
                }
                if (i2 != 0 && i2 != 1) {
                    if (g.this.f22253j != null) {
                        g.this.f22253j.c(i2);
                    }
                } else {
                    if (i2 == 1 && g.this.f22253j != null) {
                        g.this.f22253j.c(i2);
                    }
                    com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.f.g.7.1

                        /* renamed from: a */
                        final /* synthetic */ Bitmap f22261a;

                        AnonymousClass1(Bitmap bitmap22) {
                            bitmap = bitmap22;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Bitmap bitmap22;
                            if (g.this.r || (bitmap22 = bitmap) == null || bitmap22.isRecycled()) {
                                return;
                            }
                            g.this.A.a(bitmap);
                        }
                    });
                }
            }
        });
    }

    public static final com.opos.mobad.n.a b(Context context, int i2, com.opos.mobad.c.c.a aVar, com.opos.mobad.c.a aVar2) {
        return new g(context.getApplicationContext(), i2, new t(275, Downloads.Impl.STATUS_CANNOT_RESUME, t.a.BELOW), f22245b, aVar, aVar2);
    }

    private void b(com.opos.mobad.n.d.e eVar) {
        if (this.w != null) {
            return;
        }
        int i2 = eVar.A;
        if (this.s == f22244a) {
            i2 = 0;
        }
        this.p.a(eVar.f22074f, eVar.f22073e, eVar.l, i2);
        com.opos.mobad.n.d.g gVar = eVar.m;
        if (gVar == null || TextUtils.isEmpty(gVar.f22084a)) {
            this.p.a();
            return;
        }
        int a2 = com.opos.cmn.an.h.f.a.a(this.f22252i, 44.0f);
        com.opos.mobad.c.a aVar = this.z;
        com.opos.mobad.n.d.g gVar2 = eVar.m;
        aVar.a(gVar2.f22084a, gVar2.f22085b, a2, a2, new a.InterfaceC0426a() { // from class: com.opos.mobad.n.f.g.8

            /* renamed from: com.opos.mobad.n.f.g$8$1 */
            class AnonymousClass1 implements Runnable {

                /* renamed from: a */
                final /* synthetic */ Bitmap f22264a;

                AnonymousClass1(Bitmap bitmap2) {
                    bitmap = bitmap2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Bitmap bitmap2;
                    if (g.this.r || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                        return;
                    }
                    g.this.p.a(bitmap);
                }
            }

            AnonymousClass8() {
            }

            @Override // com.opos.mobad.c.a.InterfaceC0426a
            public void a(int i22, Bitmap bitmap2) {
                if (g.this.r) {
                    return;
                }
                if (i22 != 0 && i22 != 1) {
                    if (g.this.f22253j != null) {
                        g.this.f22253j.c(i22);
                    }
                } else {
                    if (i22 == 1 && g.this.f22253j != null) {
                        g.this.f22253j.c(i22);
                    }
                    com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.f.g.8.1

                        /* renamed from: a */
                        final /* synthetic */ Bitmap f22264a;

                        AnonymousClass1(Bitmap bitmap22) {
                            bitmap = bitmap22;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Bitmap bitmap22;
                            if (g.this.r || (bitmap22 = bitmap) == null || bitmap22.isRecycled()) {
                                return;
                            }
                            g.this.p.a(bitmap);
                        }
                    });
                }
            }
        });
    }

    private void c(com.opos.mobad.n.d.e eVar) {
        this.q.a(eVar.f22079a.f22084a, false);
    }

    public int f() {
        if (0 == this.q.c()) {
            return 0;
        }
        return (int) Math.min(100L, Math.max(0L, (this.q.d() * 100) / this.q.c()));
    }

    private void g() {
        this.A = this.s == f22245b ? this.f22246c ? c.a(this.f22252i) : c.c(this.f22252i) : this.f22246c ? c.b(this.f22252i) : c.d(this.f22252i);
    }

    private void h() {
        com.opos.mobad.c.d.a aVar = new com.opos.mobad.c.d.a(this.f22252i);
        aVar.a(new a.InterfaceC0428a() { // from class: com.opos.mobad.n.f.g.2
            AnonymousClass2() {
            }

            @Override // com.opos.mobad.c.d.a.InterfaceC0428a
            public void a(boolean z) {
                if (g.this.w == null) {
                    return;
                }
                if (!z) {
                    g.this.q.f();
                    return;
                }
                g.this.l();
                if (g.this.q.i() != 5) {
                    if (g.this.q.i() == 3 && g.this.t) {
                        com.opos.cmn.an.f.a.b("InterstitialPortVideo", "resume but user pause");
                    } else {
                        g.this.q.g();
                    }
                }
            }
        });
        this.f22250g.addView(aVar, new RelativeLayout.LayoutParams(0, 0));
    }

    public void i() {
        this.m.setVisibility(8);
        this.o.setVisibility(8);
    }

    public void j() {
        this.m.setVisibility(0);
    }

    public void k() {
        this.f22247d = true;
        this.n.setProgress(100);
        if (this.s == f22245b) {
            this.p.setVisibility(4);
        }
        if (this.f22251h.indexOfChild(this.A) < 0) {
            this.f22251h.addView(this.A);
        }
    }

    public void l() {
        if (!this.f22249f || this.f22248e) {
            this.f22248e = true;
            return;
        }
        a.InterfaceC0458a interfaceC0458a = this.f22253j;
        if (interfaceC0458a != null) {
            interfaceC0458a.b();
        }
    }

    public void m() {
        this.f22249f = true;
        a.InterfaceC0458a interfaceC0458a = this.f22253j;
        if (interfaceC0458a != null) {
            interfaceC0458a.e();
            if (this.f22248e) {
                this.f22253j.b();
            }
        }
    }

    @Override // com.opos.mobad.n.a
    public void a() {
        com.opos.cmn.an.f.a.b("InterstitialPortVideo", "stop");
        if (this.f22247d) {
            com.opos.cmn.an.f.a.b("InterstitialPortVideo", "do nothing for has complete");
            return;
        }
        this.t = true;
        this.q.f();
        this.v.removeCallbacks(this.u);
    }

    @Override // com.opos.mobad.n.a
    public void a(a.InterfaceC0458a interfaceC0458a) {
        this.f22253j = interfaceC0458a;
        this.A.a(interfaceC0458a);
    }

    @Override // com.opos.mobad.n.a
    public void a(com.opos.mobad.n.d.h hVar) {
        com.opos.mobad.n.d.e b2 = hVar.b();
        if (b2 == null) {
            com.opos.cmn.an.f.a.d("InterstitialPortVideo", "render with data null");
            a.InterfaceC0458a interfaceC0458a = this.f22253j;
            if (interfaceC0458a != null) {
                interfaceC0458a.b(1);
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(b2.f22079a.f22084a) && this.w == null) {
            c(b2);
        }
        this.q.a(b2.B == 1 ? 1.0f : 0.0f);
        b(b2);
        a(b2);
        this.w = b2;
    }

    @Override // com.opos.mobad.n.a
    public void b() {
        com.opos.cmn.an.f.a.b("InterstitialPortVideo", "start");
        if (this.f22247d) {
            com.opos.cmn.an.f.a.b("InterstitialPortVideo", "do nothing for has complete");
        } else {
            this.q.g();
            this.v.post(this.u);
        }
    }

    @Override // com.opos.mobad.n.a
    public View c() {
        return this.f22250g;
    }

    @Override // com.opos.mobad.n.a
    public void d() {
        this.w = null;
        com.opos.mobad.c.c.a aVar = this.q;
        if (aVar != null) {
            aVar.f();
            this.q.h();
        }
        this.r = true;
    }

    @Override // com.opos.mobad.n.a
    public int e() {
        return this.x;
    }
}
