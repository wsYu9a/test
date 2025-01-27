package com.opos.mobad.n.f;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
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
public class e implements com.opos.mobad.n.a {

    /* renamed from: a */
    private static int f22197a = 0;

    /* renamed from: b */
    private static int f22198b = 1;

    /* renamed from: c */
    private com.opos.mobad.c.a f22199c;

    /* renamed from: e */
    private RelativeLayout f22201e;

    /* renamed from: f */
    private RelativeLayout f22202f;

    /* renamed from: g */
    private Context f22203g;

    /* renamed from: h */
    private a.InterfaceC0458a f22204h;

    /* renamed from: i */
    private View f22205i;

    /* renamed from: j */
    private int f22206j;
    private View k;
    private ProgressBar l;
    private View m;
    private k n;
    private com.opos.mobad.c.c.a o;
    private int q;
    private com.opos.mobad.n.d.e v;
    private int w;
    private t x;
    private c z;

    /* renamed from: d */
    private boolean f22200d = false;
    private boolean p = false;
    private boolean r = false;
    private boolean s = false;
    private Runnable t = new Runnable() { // from class: com.opos.mobad.n.f.e.1
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.p) {
                return;
            }
            if (e.this.f22204h != null) {
                e.this.f22204h.d(e.this.o.d(), e.this.o.c());
            }
            e.this.l.setProgress(e.this.f());
            com.opos.cmn.an.f.a.b("InterstitialLandVideo", "on progress" + e.this.l.getProgress());
            e.this.u.postDelayed(this, 500L);
        }
    };
    private boolean y = false;
    private com.opos.mobad.c.c.b A = new com.opos.mobad.c.c.b() { // from class: com.opos.mobad.n.f.e.3
        AnonymousClass3() {
        }

        @Override // com.opos.mobad.c.c.b
        public void a(int i2, String str) {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onError:" + i2 + "," + str);
            if (e.this.f22204h != null) {
                e.this.f22204h.a(i2, str);
            }
        }

        @Override // com.opos.mobad.c.c.b
        public void c() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onPrepare");
            e.this.m();
            if (e.this.f22204h != null) {
                e.this.f22204h.d(0L, e.this.o.c());
            }
        }

        @Override // com.opos.mobad.c.c.b
        public void d() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onStart");
            e.this.u.removeCallbacks(e.this.t);
            e.this.u.postDelayed(e.this.t, 500L);
            e.this.f22204h.d(e.this.o.d(), e.this.o.c());
            e.this.l.setProgress(0);
            e.this.i();
        }

        @Override // com.opos.mobad.c.c.b
        public void e() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onComplete");
            if (e.this.f22204h != null) {
                e.this.f22204h.a(e.this.o.c(), e.this.o.c());
            }
            e.this.u.removeCallbacks(e.this.t);
            e.this.k();
        }

        @Override // com.opos.mobad.c.c.b
        public void f() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onResume");
            e.this.y = false;
            e.this.i();
        }

        @Override // com.opos.mobad.c.c.b
        public void g() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onPause");
            e.this.m.setVisibility(0);
        }

        @Override // com.opos.mobad.c.c.b
        public void h() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onBufferingStart");
            e.this.j();
        }

        @Override // com.opos.mobad.c.c.b
        public void i() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onBufferingEnd");
            e.this.i();
        }

        @Override // com.opos.mobad.c.c.b
        public void j() {
            if (e.this.v == null) {
                return;
            }
            e eVar = e.this;
            eVar.b(eVar.v);
        }
    };
    private Bitmap B = null;
    private Handler u = new Handler(Looper.getMainLooper());

    /* renamed from: com.opos.mobad.n.f.e$1 */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.p) {
                return;
            }
            if (e.this.f22204h != null) {
                e.this.f22204h.d(e.this.o.d(), e.this.o.c());
            }
            e.this.l.setProgress(e.this.f());
            com.opos.cmn.an.f.a.b("InterstitialLandVideo", "on progress" + e.this.l.getProgress());
            e.this.u.postDelayed(this, 500L);
        }
    }

    /* renamed from: com.opos.mobad.n.f.e$2 */
    class AnonymousClass2 implements a.InterfaceC0428a {
        AnonymousClass2() {
        }

        @Override // com.opos.mobad.c.d.a.InterfaceC0428a
        public void a(boolean z) {
            if (e.this.v == null) {
                return;
            }
            if (!z) {
                e.this.o.f();
                return;
            }
            e.this.l();
            if (e.this.o.i() != 5) {
                if (e.this.o.i() == 3 && e.this.y) {
                    com.opos.cmn.an.f.a.b("InterstitialLandVideo", "resume but user pause");
                } else {
                    e.this.o.g();
                }
            }
        }
    }

    /* renamed from: com.opos.mobad.n.f.e$3 */
    class AnonymousClass3 implements com.opos.mobad.c.c.b {
        AnonymousClass3() {
        }

        @Override // com.opos.mobad.c.c.b
        public void a(int i2, String str) {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onError:" + i2 + "," + str);
            if (e.this.f22204h != null) {
                e.this.f22204h.a(i2, str);
            }
        }

        @Override // com.opos.mobad.c.c.b
        public void c() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onPrepare");
            e.this.m();
            if (e.this.f22204h != null) {
                e.this.f22204h.d(0L, e.this.o.c());
            }
        }

        @Override // com.opos.mobad.c.c.b
        public void d() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onStart");
            e.this.u.removeCallbacks(e.this.t);
            e.this.u.postDelayed(e.this.t, 500L);
            e.this.f22204h.d(e.this.o.d(), e.this.o.c());
            e.this.l.setProgress(0);
            e.this.i();
        }

        @Override // com.opos.mobad.c.c.b
        public void e() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onComplete");
            if (e.this.f22204h != null) {
                e.this.f22204h.a(e.this.o.c(), e.this.o.c());
            }
            e.this.u.removeCallbacks(e.this.t);
            e.this.k();
        }

        @Override // com.opos.mobad.c.c.b
        public void f() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onResume");
            e.this.y = false;
            e.this.i();
        }

        @Override // com.opos.mobad.c.c.b
        public void g() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onPause");
            e.this.m.setVisibility(0);
        }

        @Override // com.opos.mobad.c.c.b
        public void h() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onBufferingStart");
            e.this.j();
        }

        @Override // com.opos.mobad.c.c.b
        public void i() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onBufferingEnd");
            e.this.i();
        }

        @Override // com.opos.mobad.c.c.b
        public void j() {
            if (e.this.v == null) {
                return;
            }
            e eVar = e.this;
            eVar.b(eVar.v);
        }
    }

    /* renamed from: com.opos.mobad.n.f.e$4 */
    class AnonymousClass4 extends com.opos.mobad.n.c.g {
        AnonymousClass4() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            if (e.this.f22204h != null) {
                e.this.f22204h.e(view, iArr);
            }
        }
    }

    /* renamed from: com.opos.mobad.n.f.e$5 */
    class AnonymousClass5 extends com.opos.mobad.n.c.g {
        AnonymousClass5() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            if (e.this.f22204h != null) {
                e.this.f22204h.g(view, iArr);
            }
        }
    }

    /* renamed from: com.opos.mobad.n.f.e$6 */
    class AnonymousClass6 extends com.opos.mobad.n.c.g {
        AnonymousClass6() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            if (e.this.f22204h != null) {
                e.this.f22204h.f(view, iArr);
            }
        }
    }

    /* renamed from: com.opos.mobad.n.f.e$7 */
    class AnonymousClass7 implements m.a {

        /* renamed from: com.opos.mobad.n.f.e$7$1 */
        class AnonymousClass1 implements Runnable {
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (e.this.p) {
                    return;
                }
                e.this.f22202f.setBackground(new BitmapDrawable(e.this.B));
            }
        }

        AnonymousClass7() {
        }

        @Override // com.opos.mobad.n.c.m.a
        public void a() {
        }

        @Override // com.opos.mobad.n.c.m.a
        public void a(Bitmap bitmap) {
            if (e.this.p) {
                return;
            }
            e eVar = e.this;
            eVar.B = com.opos.mobad.n.c.d.a(eVar.f22203g, bitmap, 75, 0.25f, 56.0f);
            com.opos.mobad.c.b.b.b(new Runnable() { // from class: com.opos.mobad.n.f.e.7.1
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (e.this.p) {
                        return;
                    }
                    e.this.f22202f.setBackground(new BitmapDrawable(e.this.B));
                }
            });
        }
    }

    /* renamed from: com.opos.mobad.n.f.e$8 */
    class AnonymousClass8 implements a.InterfaceC0426a {

        /* renamed from: com.opos.mobad.n.f.e$8$1 */
        class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Bitmap f22216a;

            AnonymousClass1(Bitmap bitmap) {
                bitmap = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Bitmap bitmap;
                if (e.this.p || (bitmap = bitmap) == null || bitmap.isRecycled()) {
                    return;
                }
                e.this.z.a(bitmap);
            }
        }

        AnonymousClass8() {
        }

        @Override // com.opos.mobad.c.a.InterfaceC0426a
        public void a(int i2, Bitmap bitmap) {
            if (i2 != 0 && i2 != 1) {
                if (e.this.f22204h != null) {
                    e.this.f22204h.c(i2);
                }
            } else {
                if (i2 == 1 && e.this.f22204h != null) {
                    e.this.f22204h.c(i2);
                }
                com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.f.e.8.1

                    /* renamed from: a */
                    final /* synthetic */ Bitmap f22216a;

                    AnonymousClass1(Bitmap bitmap2) {
                        bitmap = bitmap2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Bitmap bitmap2;
                        if (e.this.p || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                            return;
                        }
                        e.this.z.a(bitmap);
                    }
                });
            }
        }
    }

    /* renamed from: com.opos.mobad.n.f.e$9 */
    class AnonymousClass9 implements a.InterfaceC0426a {

        /* renamed from: com.opos.mobad.n.f.e$9$1 */
        class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Bitmap f22219a;

            AnonymousClass1(Bitmap bitmap) {
                bitmap = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (e.this.p) {
                    return;
                }
                e.this.n.a(bitmap);
            }
        }

        AnonymousClass9() {
        }

        @Override // com.opos.mobad.c.a.InterfaceC0426a
        public void a(int i2, Bitmap bitmap) {
            if (i2 != 0 && i2 != 1) {
                if (e.this.f22204h != null) {
                    e.this.f22204h.c(i2);
                }
            } else {
                if (e.this.p || bitmap == null || bitmap.isRecycled()) {
                    return;
                }
                if (i2 == 1 && e.this.f22204h != null) {
                    e.this.f22204h.c(i2);
                }
                com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.f.e.9.1

                    /* renamed from: a */
                    final /* synthetic */ Bitmap f22219a;

                    AnonymousClass1(Bitmap bitmap2) {
                        bitmap = bitmap2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.this.p) {
                            return;
                        }
                        e.this.n.a(bitmap);
                    }
                });
            }
        }
    }

    public e(Context context, int i2, t tVar, int i3, com.opos.mobad.c.c.a aVar, com.opos.mobad.c.a aVar2) {
        this.f22203g = context;
        this.w = i2;
        this.f22201e = new RelativeLayout(context);
        this.o = aVar;
        aVar.a(this.A);
        this.q = i3;
        this.x = tVar;
        this.f22199c = aVar2;
        a(tVar, i3);
        g();
        h();
    }

    public static final com.opos.mobad.n.a a(Context context, int i2, com.opos.mobad.c.c.a aVar, com.opos.mobad.c.a aVar2) {
        return new e(context.getApplicationContext(), i2, new t(Downloads.Impl.STATUS_CANNOT_RESUME, 275, t.a.RIGHT), f22197a, aVar, aVar2);
    }

    private void a(t tVar, int i2) {
        this.f22206j = View.generateViewId();
        RelativeLayout relativeLayout = new RelativeLayout(this.f22203g);
        this.f22202f = relativeLayout;
        relativeLayout.setId(this.f22206j);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f22203g, 489.0f), com.opos.cmn.an.h.f.a.a(this.f22203g, 275.0f));
        layoutParams.addRule(13);
        this.f22201e.addView(this.f22202f, layoutParams);
        this.f22201e.setBackgroundColor(-16777216);
        this.f22205i = this.o.b();
        this.o.d(-16777216);
        this.f22205i.setBackgroundColor(-16777216);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f22203g, tVar.f21907a), com.opos.cmn.an.h.f.a.a(this.f22203g, tVar.f21908b));
        layoutParams2.addRule(13);
        this.f22202f.addView(this.f22205i, layoutParams2);
        View view = new View(this.f22203g);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(7, this.f22206j);
        layoutParams3.addRule(5, this.f22206j);
        layoutParams3.addRule(6, this.f22206j);
        layoutParams3.addRule(8, this.f22206j);
        this.f22202f.addView(view, layoutParams3);
        AnonymousClass4 anonymousClass4 = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.f.e.4
            AnonymousClass4() {
            }

            @Override // com.opos.mobad.n.c.g
            public void a(View view2, int[] iArr) {
                if (e.this.f22204h != null) {
                    e.this.f22204h.e(view2, iArr);
                }
            }
        };
        view.setOnTouchListener(anonymousClass4);
        view.setOnClickListener(anonymousClass4);
        this.k = new ProgressBar(this.f22203g);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f22203g, 30.0f), com.opos.cmn.an.h.f.a.a(this.f22203g, 39.0f));
        layoutParams4.addRule(13);
        this.k.setVisibility(0);
        this.f22202f.addView(this.k, layoutParams4);
        View view2 = new View(this.f22203g);
        this.m = view2;
        view2.setBackground(this.f22203g.getResources().getDrawable(R.drawable.opos_mobad_continue_bn));
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f22203g, 60.0f), com.opos.cmn.an.h.f.a.a(this.f22203g, 60.0f));
        layoutParams5.addRule(13);
        this.m.setVisibility(4);
        this.f22202f.addView(this.m, layoutParams5);
        this.n = k.e(this.f22203g, 36, 12, 10, -1275068416);
        AnonymousClass5 anonymousClass5 = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.f.e.5
            AnonymousClass5() {
            }

            @Override // com.opos.mobad.n.c.g
            public void a(View view3, int[] iArr) {
                if (e.this.f22204h != null) {
                    e.this.f22204h.g(view3, iArr);
                }
            }
        };
        this.n.setOnClickListener(anonymousClass5);
        this.n.setOnTouchListener(anonymousClass5);
        AnonymousClass6 anonymousClass6 = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.f.e.6
            AnonymousClass6() {
            }

            @Override // com.opos.mobad.n.c.g
            public void a(View view3, int[] iArr) {
                if (e.this.f22204h != null) {
                    e.this.f22204h.f(view3, iArr);
                }
            }
        };
        this.n.c().setOnClickListener(anonymousClass6);
        this.n.c().setOnTouchListener(anonymousClass6);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.f22203g, 68.0f));
        layoutParams6.addRule(12);
        this.f22202f.addView(this.n, layoutParams6);
        ProgressBar progressBar = new ProgressBar(this.f22203g);
        this.l = progressBar;
        progressBar.setId(View.generateViewId());
        m.a(this.l, "mOnlyIndeterminate", new Boolean(false));
        this.l.setIndeterminate(false);
        this.l.setProgressDrawable(new ClipDrawable(new ColorDrawable(-1), 3, 1));
        this.l.setBackgroundColor(0);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.f22203g, 2.0f));
        layoutParams7.addRule(12);
        this.l.setVisibility(0);
        this.f22202f.addView(this.l, layoutParams7);
    }

    private void a(com.opos.mobad.n.d.e eVar) {
        if (this.v != null) {
            return;
        }
        b(eVar);
    }

    public static final com.opos.mobad.n.a b(Context context, int i2, com.opos.mobad.c.c.a aVar, com.opos.mobad.c.a aVar2) {
        return new e(context.getApplicationContext(), i2, new t(TinkerReport.KEY_APPLIED_PACKAGE_CHECK_META_NOT_FOUND, 275, t.a.RIGHT), f22198b, aVar, aVar2);
    }

    public void b(com.opos.mobad.n.d.e eVar) {
        if (this.q == f22198b) {
            if (this.B != null) {
                this.f22202f.setBackground(new BitmapDrawable(this.B));
            } else {
                m.a(this.o, eVar.f22079a.f22084a, (m.a) new m.a() { // from class: com.opos.mobad.n.f.e.7

                    /* renamed from: com.opos.mobad.n.f.e$7$1 */
                    class AnonymousClass1 implements Runnable {
                        AnonymousClass1() {
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            if (e.this.p) {
                                return;
                            }
                            e.this.f22202f.setBackground(new BitmapDrawable(e.this.B));
                        }
                    }

                    AnonymousClass7() {
                    }

                    @Override // com.opos.mobad.n.c.m.a
                    public void a() {
                    }

                    @Override // com.opos.mobad.n.c.m.a
                    public void a(Bitmap bitmap) {
                        if (e.this.p) {
                            return;
                        }
                        e eVar2 = e.this;
                        eVar2.B = com.opos.mobad.n.c.d.a(eVar2.f22203g, bitmap, 75, 0.25f, 56.0f);
                        com.opos.mobad.c.b.b.b(new Runnable() { // from class: com.opos.mobad.n.f.e.7.1
                            AnonymousClass1() {
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                if (e.this.p) {
                                    return;
                                }
                                e.this.f22202f.setBackground(new BitmapDrawable(e.this.B));
                            }
                        });
                    }
                });
            }
        }
    }

    private void c(com.opos.mobad.n.d.e eVar) {
        this.z.a(eVar.f22074f, eVar.f22073e, eVar.l);
        if (this.v != null) {
            return;
        }
        com.opos.mobad.n.d.g gVar = eVar.m;
        if (gVar == null || TextUtils.isEmpty(gVar.f22084a)) {
            this.n.a();
            return;
        }
        int a2 = com.opos.cmn.an.h.f.a.a(this.f22203g, 44.0f);
        com.opos.mobad.c.a aVar = this.f22199c;
        com.opos.mobad.n.d.g gVar2 = eVar.m;
        aVar.a(gVar2.f22084a, gVar2.f22085b, a2, a2, new a.InterfaceC0426a() { // from class: com.opos.mobad.n.f.e.8

            /* renamed from: com.opos.mobad.n.f.e$8$1 */
            class AnonymousClass1 implements Runnable {

                /* renamed from: a */
                final /* synthetic */ Bitmap f22216a;

                AnonymousClass1(Bitmap bitmap2) {
                    bitmap = bitmap2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Bitmap bitmap2;
                    if (e.this.p || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                        return;
                    }
                    e.this.z.a(bitmap);
                }
            }

            AnonymousClass8() {
            }

            @Override // com.opos.mobad.c.a.InterfaceC0426a
            public void a(int i2, Bitmap bitmap2) {
                if (i2 != 0 && i2 != 1) {
                    if (e.this.f22204h != null) {
                        e.this.f22204h.c(i2);
                    }
                } else {
                    if (i2 == 1 && e.this.f22204h != null) {
                        e.this.f22204h.c(i2);
                    }
                    com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.f.e.8.1

                        /* renamed from: a */
                        final /* synthetic */ Bitmap f22216a;

                        AnonymousClass1(Bitmap bitmap22) {
                            bitmap = bitmap22;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Bitmap bitmap22;
                            if (e.this.p || (bitmap22 = bitmap) == null || bitmap22.isRecycled()) {
                                return;
                            }
                            e.this.z.a(bitmap);
                        }
                    });
                }
            }
        });
    }

    private void d(com.opos.mobad.n.d.e eVar) {
        this.n.a(eVar.f22074f, eVar.f22073e, eVar.l, eVar.A);
        if (this.v != null) {
            return;
        }
        com.opos.mobad.n.d.g gVar = eVar.m;
        if (gVar == null || TextUtils.isEmpty(gVar.f22084a)) {
            this.n.a();
            return;
        }
        int a2 = com.opos.cmn.an.h.f.a.a(this.f22203g, 44.0f);
        com.opos.mobad.c.a aVar = this.f22199c;
        com.opos.mobad.n.d.g gVar2 = eVar.m;
        aVar.a(gVar2.f22084a, gVar2.f22085b, a2, a2, new a.InterfaceC0426a() { // from class: com.opos.mobad.n.f.e.9

            /* renamed from: com.opos.mobad.n.f.e$9$1 */
            class AnonymousClass1 implements Runnable {

                /* renamed from: a */
                final /* synthetic */ Bitmap f22219a;

                AnonymousClass1(Bitmap bitmap2) {
                    bitmap = bitmap2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (e.this.p) {
                        return;
                    }
                    e.this.n.a(bitmap);
                }
            }

            AnonymousClass9() {
            }

            @Override // com.opos.mobad.c.a.InterfaceC0426a
            public void a(int i2, Bitmap bitmap2) {
                if (i2 != 0 && i2 != 1) {
                    if (e.this.f22204h != null) {
                        e.this.f22204h.c(i2);
                    }
                } else {
                    if (e.this.p || bitmap2 == null || bitmap2.isRecycled()) {
                        return;
                    }
                    if (i2 == 1 && e.this.f22204h != null) {
                        e.this.f22204h.c(i2);
                    }
                    com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.f.e.9.1

                        /* renamed from: a */
                        final /* synthetic */ Bitmap f22219a;

                        AnonymousClass1(Bitmap bitmap22) {
                            bitmap = bitmap22;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            if (e.this.p) {
                                return;
                            }
                            e.this.n.a(bitmap);
                        }
                    });
                }
            }
        });
    }

    private void e(com.opos.mobad.n.d.e eVar) {
        this.o.a(eVar.f22079a.f22084a, false);
    }

    public int f() {
        if (0 == this.o.c()) {
            return 0;
        }
        return (int) Math.min(100L, Math.max(0L, (this.o.d() * 100) / this.o.c()));
    }

    private void g() {
        this.z = this.q == f22198b ? c.f(this.f22203g) : c.e(this.f22203g);
    }

    private void h() {
        com.opos.mobad.c.d.a aVar = new com.opos.mobad.c.d.a(this.f22203g);
        aVar.a(new a.InterfaceC0428a() { // from class: com.opos.mobad.n.f.e.2
            AnonymousClass2() {
            }

            @Override // com.opos.mobad.c.d.a.InterfaceC0428a
            public void a(boolean z) {
                if (e.this.v == null) {
                    return;
                }
                if (!z) {
                    e.this.o.f();
                    return;
                }
                e.this.l();
                if (e.this.o.i() != 5) {
                    if (e.this.o.i() == 3 && e.this.y) {
                        com.opos.cmn.an.f.a.b("InterstitialLandVideo", "resume but user pause");
                    } else {
                        e.this.o.g();
                    }
                }
            }
        });
        this.f22201e.addView(aVar, new RelativeLayout.LayoutParams(0, 0));
    }

    public void i() {
        this.k.setVisibility(8);
        this.m.setVisibility(8);
    }

    public void j() {
        this.k.setVisibility(0);
    }

    public void k() {
        this.f22200d = true;
        this.l.setProgress(100);
        this.n.setVisibility(4);
        if (this.f22202f.indexOfChild(this.z) < 0) {
            this.f22202f.addView(this.z);
        }
    }

    public void l() {
        if (!this.s || this.r) {
            this.r = true;
            return;
        }
        a.InterfaceC0458a interfaceC0458a = this.f22204h;
        if (interfaceC0458a != null) {
            interfaceC0458a.b();
        }
    }

    public void m() {
        this.s = true;
        a.InterfaceC0458a interfaceC0458a = this.f22204h;
        if (interfaceC0458a != null) {
            interfaceC0458a.e();
            if (this.r) {
                this.f22204h.b();
            }
        }
    }

    @Override // com.opos.mobad.n.a
    public void a() {
        if (this.f22200d) {
            com.opos.cmn.an.f.a.b("InterstitialLandVideo", "do no stop for has complete");
            return;
        }
        this.y = true;
        this.o.f();
        this.u.removeCallbacks(this.t);
    }

    @Override // com.opos.mobad.n.a
    public void a(a.InterfaceC0458a interfaceC0458a) {
        this.f22204h = interfaceC0458a;
        this.z.a(interfaceC0458a);
    }

    @Override // com.opos.mobad.n.a
    public void a(com.opos.mobad.n.d.h hVar) {
        com.opos.mobad.n.d.e b2 = hVar.b();
        if (b2 == null) {
            com.opos.cmn.an.f.a.d("InterstitialLandVideo", "render with data null");
            a.InterfaceC0458a interfaceC0458a = this.f22204h;
            if (interfaceC0458a != null) {
                interfaceC0458a.b(1);
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(b2.f22079a.f22084a) && this.v == null) {
            e(b2);
        }
        this.o.a(b2.B == 1 ? 1.0f : 0.0f);
        d(b2);
        a(b2);
        c(b2);
        this.v = b2;
    }

    @Override // com.opos.mobad.n.a
    public void b() {
        if (this.f22200d) {
            com.opos.cmn.an.f.a.b("InterstitialLandVideo", "do no start for has complete");
        } else {
            this.o.g();
            this.u.post(this.t);
        }
    }

    @Override // com.opos.mobad.n.a
    public View c() {
        return this.f22201e;
    }

    @Override // com.opos.mobad.n.a
    public void d() {
        this.v = null;
        com.opos.mobad.c.c.a aVar = this.o;
        if (aVar != null) {
            aVar.f();
            this.o.h();
        }
        this.p = true;
    }

    @Override // com.opos.mobad.n.a
    public int e() {
        return this.w;
    }
}
