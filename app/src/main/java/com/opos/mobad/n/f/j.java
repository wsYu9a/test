package com.opos.mobad.n.f;

import android.content.Context;
import android.graphics.Outline;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.c.d.a;
import com.opos.mobad.n.a;
import com.opos.mobad.n.a.t;
import com.tencent.bugly.beta.tinker.TinkerReport;

/* loaded from: classes4.dex */
public class j implements com.opos.mobad.n.a {

    /* renamed from: a */
    private RelativeLayout f22295a;

    /* renamed from: b */
    private Context f22296b;

    /* renamed from: c */
    private a.InterfaceC0458a f22297c;

    /* renamed from: d */
    private View f22298d;

    /* renamed from: e */
    private int f22299e;

    /* renamed from: f */
    private View f22300f;

    /* renamed from: g */
    private com.opos.mobad.c.c.a f22301g;
    private View l;
    private com.opos.mobad.n.d.e n;
    private int o;
    private View q;

    /* renamed from: h */
    private boolean f22302h = false;

    /* renamed from: i */
    private boolean f22303i = false;

    /* renamed from: j */
    private boolean f22304j = false;
    private Runnable k = new Runnable() { // from class: com.opos.mobad.n.f.j.1
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (j.this.f22302h) {
                return;
            }
            if (j.this.f22297c != null) {
                j.this.f22297c.d(j.this.f22301g.d(), j.this.f22301g.c());
            }
            j.this.m.postDelayed(this, 1000L);
        }
    };
    private com.opos.mobad.c.c.b p = new com.opos.mobad.c.c.b() { // from class: com.opos.mobad.n.f.j.3

        /* renamed from: b */
        private boolean f22308b = false;

        AnonymousClass3() {
        }

        @Override // com.opos.mobad.c.c.b
        public void a(int i2, String str) {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onError:" + i2 + "," + str);
            if (j.this.f22297c != null) {
                j.this.f22297c.a(i2, str);
            }
        }

        @Override // com.opos.mobad.c.c.b
        public void c() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onPrepare");
            if (!this.f22308b) {
                j.this.k();
            }
            if (j.this.f22297c != null) {
                j.this.f22297c.d(0L, j.this.f22301g.c());
            }
        }

        @Override // com.opos.mobad.c.c.b
        public void d() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onStart");
            j.this.m.removeCallbacks(j.this.k);
            j.this.m.postDelayed(j.this.k, 1000L);
            j.this.f22297c.d(j.this.f22301g.d(), j.this.f22301g.c());
            j.this.h();
        }

        @Override // com.opos.mobad.c.c.b
        public void e() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onComplete");
            this.f22308b = true;
            if (j.this.f22297c != null) {
                j.this.f22297c.a(j.this.f22301g.d(), j.this.f22301g.c());
            }
            if (j.this.n == null || j.this.n.f22079a == null) {
                return;
            }
            j.this.f22301g.a(j.this.n.f22079a.f22084a, true);
        }

        @Override // com.opos.mobad.c.c.b
        public void f() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onResume");
            j.this.h();
        }

        @Override // com.opos.mobad.c.c.b
        public void g() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onPause");
        }

        @Override // com.opos.mobad.c.c.b
        public void h() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onBufferingStart");
            j.this.i();
        }

        @Override // com.opos.mobad.c.c.b
        public void i() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onBufferingEnd");
            j.this.h();
        }

        @Override // com.opos.mobad.c.c.b
        public void j() {
        }
    };
    private Handler m = new Handler(Looper.getMainLooper());

    /* renamed from: com.opos.mobad.n.f.j$1 */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (j.this.f22302h) {
                return;
            }
            if (j.this.f22297c != null) {
                j.this.f22297c.d(j.this.f22301g.d(), j.this.f22301g.c());
            }
            j.this.m.postDelayed(this, 1000L);
        }
    }

    /* renamed from: com.opos.mobad.n.f.j$2 */
    class AnonymousClass2 implements a.InterfaceC0428a {
        AnonymousClass2() {
        }

        @Override // com.opos.mobad.c.d.a.InterfaceC0428a
        public void a(boolean z) {
            if (j.this.n == null) {
                return;
            }
            if (!z) {
                j.this.f22301g.f();
            } else {
                j.this.j();
                j.this.f22301g.g();
            }
        }
    }

    /* renamed from: com.opos.mobad.n.f.j$3 */
    class AnonymousClass3 implements com.opos.mobad.c.c.b {

        /* renamed from: b */
        private boolean f22308b = false;

        AnonymousClass3() {
        }

        @Override // com.opos.mobad.c.c.b
        public void a(int i2, String str) {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onError:" + i2 + "," + str);
            if (j.this.f22297c != null) {
                j.this.f22297c.a(i2, str);
            }
        }

        @Override // com.opos.mobad.c.c.b
        public void c() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onPrepare");
            if (!this.f22308b) {
                j.this.k();
            }
            if (j.this.f22297c != null) {
                j.this.f22297c.d(0L, j.this.f22301g.c());
            }
        }

        @Override // com.opos.mobad.c.c.b
        public void d() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onStart");
            j.this.m.removeCallbacks(j.this.k);
            j.this.m.postDelayed(j.this.k, 1000L);
            j.this.f22297c.d(j.this.f22301g.d(), j.this.f22301g.c());
            j.this.h();
        }

        @Override // com.opos.mobad.c.c.b
        public void e() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onComplete");
            this.f22308b = true;
            if (j.this.f22297c != null) {
                j.this.f22297c.a(j.this.f22301g.d(), j.this.f22301g.c());
            }
            if (j.this.n == null || j.this.n.f22079a == null) {
                return;
            }
            j.this.f22301g.a(j.this.n.f22079a.f22084a, true);
        }

        @Override // com.opos.mobad.c.c.b
        public void f() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onResume");
            j.this.h();
        }

        @Override // com.opos.mobad.c.c.b
        public void g() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onPause");
        }

        @Override // com.opos.mobad.c.c.b
        public void h() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onBufferingStart");
            j.this.i();
        }

        @Override // com.opos.mobad.c.c.b
        public void i() {
            com.opos.cmn.an.f.a.b("InterstitialVideo", "onBufferingEnd");
            j.this.h();
        }

        @Override // com.opos.mobad.c.c.b
        public void j() {
        }
    }

    /* renamed from: com.opos.mobad.n.f.j$4 */
    class AnonymousClass4 extends ViewOutlineProvider {
        AnonymousClass4() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), com.opos.cmn.an.h.f.a.a(j.this.f22296b, 8.0f));
        }
    }

    /* renamed from: com.opos.mobad.n.f.j$5 */
    class AnonymousClass5 extends com.opos.mobad.n.c.g {
        AnonymousClass5() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            if (j.this.f22297c != null) {
                j.this.f22297c.f(view, iArr);
            }
        }
    }

    /* renamed from: com.opos.mobad.n.f.j$6 */
    class AnonymousClass6 extends com.opos.mobad.n.c.g {
        AnonymousClass6() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            if (j.this.f22297c != null) {
                j.this.f22297c.a(view, iArr);
            }
        }
    }

    /* renamed from: com.opos.mobad.n.f.j$7 */
    class AnonymousClass7 extends com.opos.mobad.n.c.g {
        AnonymousClass7() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            if (j.this.f22297c != null) {
                j.this.f22297c.d(view, iArr);
            }
        }
    }

    public j(Context context, int i2, t tVar, com.opos.mobad.c.c.a aVar) {
        this.f22296b = context;
        this.o = i2;
        this.f22295a = new RelativeLayout(context);
        this.f22301g = aVar;
        aVar.a(this.p);
        a(tVar);
        g();
        b(tVar);
        f();
    }

    public static final com.opos.mobad.n.a a(Context context, int i2, com.opos.mobad.c.c.a aVar) {
        return new j(context.getApplicationContext(), i2, new t(320, TinkerReport.KEY_APPLIED_VERSION_CHECK, t.a.BELOW), aVar);
    }

    private void a(t tVar) {
        View b2 = this.f22301g.b();
        this.f22298d = b2;
        b2.setBackgroundColor(-16777216);
        int generateViewId = View.generateViewId();
        this.f22299e = generateViewId;
        this.f22298d.setId(generateViewId);
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                this.f22298d.setOutlineProvider(new ViewOutlineProvider() { // from class: com.opos.mobad.n.f.j.4
                    AnonymousClass4() {
                    }

                    @Override // android.view.ViewOutlineProvider
                    public void getOutline(View view, Outline outline) {
                        outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), com.opos.cmn.an.h.f.a.a(j.this.f22296b, 8.0f));
                    }
                });
                this.f22298d.setClipToOutline(true);
            } catch (Error e2) {
                com.opos.cmn.an.f.a.b("InterstitialVideo", "clip radius fail", e2);
            }
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f22296b, tVar.f21907a), com.opos.cmn.an.h.f.a.a(this.f22296b, tVar.f21908b));
        layoutParams.addRule(13);
        this.f22295a.addView(this.f22298d, layoutParams);
        View view = new View(this.f22296b);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(7, this.f22299e);
        layoutParams2.addRule(5, this.f22299e);
        layoutParams2.addRule(6, this.f22299e);
        layoutParams2.addRule(8, this.f22299e);
        this.f22295a.addView(view, layoutParams2);
        AnonymousClass5 anonymousClass5 = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.f.j.5
            AnonymousClass5() {
            }

            @Override // com.opos.mobad.n.c.g
            public void a(View view2, int[] iArr) {
                if (j.this.f22297c != null) {
                    j.this.f22297c.f(view2, iArr);
                }
            }
        };
        view.setOnTouchListener(anonymousClass5);
        view.setOnClickListener(anonymousClass5);
        this.f22300f = new ProgressBar(this.f22296b);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f22296b, 30.0f), com.opos.cmn.an.h.f.a.a(this.f22296b, 39.0f));
        layoutParams3.addRule(13);
        this.f22300f.setVisibility(0);
        this.f22295a.addView(this.f22300f, layoutParams3);
    }

    private void a(com.opos.mobad.n.d.e eVar) {
        View view;
        int i2;
        if (eVar.r) {
            view = this.q;
            i2 = 0;
        } else {
            view = this.q;
            i2 = 8;
        }
        view.setVisibility(i2);
    }

    public static final com.opos.mobad.n.a b(Context context, int i2, com.opos.mobad.c.c.a aVar) {
        return new j(context.getApplicationContext(), i2, new t(168, 298, t.a.RIGHT), aVar);
    }

    private void b(t tVar) {
        ImageView imageView = new ImageView(this.f22296b);
        imageView.setImageResource(R.drawable.opos_mobad_dialog_close);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f22296b, 42.0f), com.opos.cmn.an.h.f.a.a(this.f22296b, 42.0f));
        if (tVar.f21909c == t.a.BELOW) {
            layoutParams.addRule(3, this.f22299e);
            layoutParams.addRule(14);
            layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f22296b, 30.0f);
        } else {
            layoutParams.addRule(6, this.f22299e);
            layoutParams.addRule(1, this.f22299e);
            layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.f22296b, 8.0f);
        }
        AnonymousClass7 anonymousClass7 = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.f.j.7
            AnonymousClass7() {
            }

            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (j.this.f22297c != null) {
                    j.this.f22297c.d(view, iArr);
                }
            }
        };
        imageView.setOnTouchListener(anonymousClass7);
        imageView.setOnClickListener(anonymousClass7);
        this.f22295a.addView(imageView, layoutParams);
    }

    private void b(com.opos.mobad.n.d.e eVar) {
        this.f22301g.a(eVar.f22079a.f22084a, false);
    }

    private void c(com.opos.mobad.n.d.e eVar) {
        View view = this.l;
        if (view != null) {
            this.f22295a.removeView(view);
        }
        if (eVar.f22077i) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(7, this.f22299e);
            layoutParams.addRule(8, this.f22299e);
            layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.f22296b, 10.0f);
            layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f22296b, 10.0f);
            this.l = com.opos.mobad.n.e.a(eVar, this.f22295a, layoutParams);
        }
    }

    private void f() {
        com.opos.mobad.c.d.a aVar = new com.opos.mobad.c.d.a(this.f22296b);
        aVar.a(new a.InterfaceC0428a() { // from class: com.opos.mobad.n.f.j.2
            AnonymousClass2() {
            }

            @Override // com.opos.mobad.c.d.a.InterfaceC0428a
            public void a(boolean z) {
                if (j.this.n == null) {
                    return;
                }
                if (!z) {
                    j.this.f22301g.f();
                } else {
                    j.this.j();
                    j.this.f22301g.g();
                }
            }
        });
        this.f22295a.addView(aVar, new RelativeLayout.LayoutParams(0, 0));
    }

    private void g() {
        TextView a2 = com.opos.mobad.n.e.a(this.f22296b);
        a2.setText("反馈");
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(6, this.f22299e);
        layoutParams.addRule(7, this.f22299e);
        int a3 = com.opos.cmn.an.h.f.a.a(this.f22296b, 10.0f);
        layoutParams.rightMargin = a3;
        layoutParams.topMargin = a3;
        this.f22295a.addView(a2, layoutParams);
        AnonymousClass6 anonymousClass6 = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.f.j.6
            AnonymousClass6() {
            }

            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (j.this.f22297c != null) {
                    j.this.f22297c.a(view, iArr);
                }
            }
        };
        a2.setOnTouchListener(anonymousClass6);
        a2.setOnClickListener(anonymousClass6);
        this.q = a2;
    }

    public void h() {
        this.f22300f.setVisibility(8);
    }

    public void i() {
        this.f22300f.setVisibility(0);
    }

    public void j() {
        if (!this.f22304j || this.f22303i) {
            this.f22303i = true;
            return;
        }
        a.InterfaceC0458a interfaceC0458a = this.f22297c;
        if (interfaceC0458a != null) {
            interfaceC0458a.b();
        }
    }

    public void k() {
        this.f22304j = true;
        a.InterfaceC0458a interfaceC0458a = this.f22297c;
        if (interfaceC0458a != null) {
            interfaceC0458a.e();
            if (this.f22303i) {
                this.f22297c.b();
            }
        }
    }

    @Override // com.opos.mobad.n.a
    public void a() {
    }

    @Override // com.opos.mobad.n.a
    public void a(a.InterfaceC0458a interfaceC0458a) {
        this.f22297c = interfaceC0458a;
    }

    @Override // com.opos.mobad.n.a
    public void a(com.opos.mobad.n.d.h hVar) {
        com.opos.mobad.n.d.e b2 = hVar.b();
        if (b2 == null) {
            com.opos.cmn.an.f.a.d("interVideo", "render with data null");
            a.InterfaceC0458a interfaceC0458a = this.f22297c;
            if (interfaceC0458a != null) {
                interfaceC0458a.b(1);
                return;
            }
            return;
        }
        com.opos.mobad.n.d.g gVar = b2.f22079a;
        if (gVar != null && !TextUtils.isEmpty(gVar.f22084a) && this.n == null) {
            b(b2);
        }
        c(b2);
        a(b2);
        this.n = b2;
    }

    @Override // com.opos.mobad.n.a
    public void b() {
    }

    @Override // com.opos.mobad.n.a
    public View c() {
        return this.f22295a;
    }

    @Override // com.opos.mobad.n.a
    public void d() {
        this.n = null;
        com.opos.mobad.c.c.a aVar = this.f22301g;
        if (aVar != null) {
            aVar.f();
            this.f22301g.h();
        }
        this.f22302h = true;
    }

    @Override // com.opos.mobad.n.a
    public int e() {
        return this.o;
    }
}
