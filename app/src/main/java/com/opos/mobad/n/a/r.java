package com.opos.mobad.n.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.c.d.a;
import com.opos.mobad.n.a;
import com.opos.mobad.n.d;
import com.umeng.analytics.pro.am;

/* loaded from: classes4.dex */
public class r implements com.opos.mobad.n.a {
    private f A;
    private m B;

    /* renamed from: a */
    private Context f21878a;

    /* renamed from: b */
    private a.InterfaceC0458a f21879b;

    /* renamed from: c */
    private com.opos.mobad.n.d.e f21880c;

    /* renamed from: d */
    private com.opos.mobad.c.c.a f21881d;

    /* renamed from: e */
    private int f21882e;

    /* renamed from: f */
    private int f21883f;

    /* renamed from: h */
    private RelativeLayout f21885h;

    /* renamed from: i */
    private RelativeLayout f21886i;

    /* renamed from: j */
    private View f21887j;
    private ImageView k;
    private View l;
    private View m;
    private View n;
    private b o;
    private View p;
    private com.opos.mobad.n.d q;
    private Drawable s;
    private Drawable t;
    private long x;
    private long y;

    /* renamed from: g */
    private boolean f21884g = false;
    private long r = -1;
    private volatile int u = 0;
    private volatile int v = 0;
    private boolean z = false;
    private Runnable C = new Runnable() { // from class: com.opos.mobad.n.a.r.1
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (r.this.u == 6) {
                return;
            }
            if (r.this.r <= 0) {
                r.this.f21879b.d(r.this.x - r.this.r, r.this.y);
                r.this.w.a();
                r.this.a();
                r.this.p();
                r.this.r();
                return;
            }
            com.opos.cmn.an.f.a.b("SplashVideo", "countdown=" + r.this.r);
            r.this.w.a(1000L);
            if (r.this.q != null) {
                r.this.q.a((int) (r.this.r / 1000));
            }
            r.this.f21879b.d(r.this.x - r.this.r, r.this.y);
            r.this.r -= 1000;
        }
    };
    private com.opos.mobad.c.c.b D = new com.opos.mobad.c.c.b() { // from class: com.opos.mobad.n.a.r.7
        AnonymousClass7() {
        }

        private void a(long j2) {
            String str;
            if (j2 <= 0) {
                str = "error video duration";
            } else {
                r rVar = r.this;
                rVar.r = Math.min(j2, rVar.r);
                r rVar2 = r.this;
                rVar2.x = rVar2.r;
                str = "resetVideoDurationIfNeed ori = " + j2 + ",after =" + r.this.x;
            }
            com.opos.cmn.an.f.a.b("SplashVideo", str);
        }

        @Override // com.opos.mobad.c.c.b
        public void a(int i2, String str) {
            com.opos.cmn.an.f.a.b("SplashVideo", "play video error,errCode:" + i2 + ", errMsg" + str);
            r.this.u = 4;
            r.this.a();
            r.this.p();
            if (r.this.f21879b != null) {
                r.this.f21879b.b(i2);
            }
        }

        @Override // com.opos.mobad.c.c.b
        public void c() {
        }

        @Override // com.opos.mobad.c.c.b
        public void d() {
            com.opos.cmn.an.f.a.b("SplashVideo", "play video onStart");
            r.this.u = 2;
            r.this.v = 0;
            r rVar = r.this;
            rVar.y = rVar.f21881d.c();
            a(r.this.y);
            r.this.w.a(0L);
            r.this.o();
        }

        @Override // com.opos.mobad.c.c.b
        public void e() {
            com.opos.cmn.an.f.a.b("SplashVideo", "play video complete");
        }

        @Override // com.opos.mobad.c.c.b
        public void f() {
            com.opos.cmn.an.f.a.b("SplashVideo", "play video onResume");
            r.this.u = 2;
            r.this.v = 0;
        }

        @Override // com.opos.mobad.c.c.b
        public void g() {
            com.opos.cmn.an.f.a.b("SplashVideo", "play video onPause");
            r.this.u = 3;
        }

        @Override // com.opos.mobad.c.c.b
        public void h() {
        }

        @Override // com.opos.mobad.c.c.b
        public void i() {
        }

        @Override // com.opos.mobad.c.c.b
        public void j() {
        }
    };
    private com.opos.mobad.c.b.c w = new com.opos.mobad.c.b.c(com.opos.mobad.c.b.b.a(), this.C);

    /* renamed from: com.opos.mobad.n.a.r$1 */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (r.this.u == 6) {
                return;
            }
            if (r.this.r <= 0) {
                r.this.f21879b.d(r.this.x - r.this.r, r.this.y);
                r.this.w.a();
                r.this.a();
                r.this.p();
                r.this.r();
                return;
            }
            com.opos.cmn.an.f.a.b("SplashVideo", "countdown=" + r.this.r);
            r.this.w.a(1000L);
            if (r.this.q != null) {
                r.this.q.a((int) (r.this.r / 1000));
            }
            r.this.f21879b.d(r.this.x - r.this.r, r.this.y);
            r.this.r -= 1000;
        }
    }

    /* renamed from: com.opos.mobad.n.a.r$2 */
    class AnonymousClass2 implements a.InterfaceC0428a {

        /* renamed from: a */
        final /* synthetic */ com.opos.mobad.c.d.a f21889a;

        AnonymousClass2(com.opos.mobad.c.d.a aVar) {
            aVar = aVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x0064, code lost:
        
            if (com.opos.mobad.n.a.q.e(com.opos.mobad.n.a.r.this.f21878a) != false) goto L56;
         */
        @Override // com.opos.mobad.c.d.a.InterfaceC0428a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void a(boolean r8) {
            /*
                r7 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "isViewVisible = "
                r0.append(r1)
                r0.append(r8)
                java.lang.String r0 = r0.toString()
                java.lang.String r1 = "SplashVideo"
                com.opos.cmn.an.f.a.b(r1, r0)
                com.opos.mobad.n.a.r r0 = com.opos.mobad.n.a.r.this
                com.opos.mobad.n.d.e r0 = com.opos.mobad.n.a.r.j(r0)
                if (r0 != 0) goto L20
                goto Lba
            L20:
                r0 = 1
                r2 = 0
                com.opos.mobad.n.a.r r3 = com.opos.mobad.n.a.r.this
                int r3 = com.opos.mobad.n.a.r.a(r3)
                if (r8 == 0) goto L67
                if (r3 != 0) goto L51
                com.opos.mobad.n.a.r r3 = com.opos.mobad.n.a.r.this
                com.opos.mobad.n.a.r.a(r3, r0)
                com.opos.mobad.n.a.r r3 = com.opos.mobad.n.a.r.this
                com.opos.mobad.n.a.r.k(r3)
                com.opos.mobad.n.a.r r3 = com.opos.mobad.n.a.r.this
                com.opos.mobad.n.a.f r3 = com.opos.mobad.n.a.r.l(r3)
                r3.c()
                com.opos.mobad.n.a.r r3 = com.opos.mobad.n.a.r.this
                com.opos.mobad.n.a$a r3 = com.opos.mobad.n.a.r.g(r3)
                if (r3 == 0) goto L80
                com.opos.mobad.n.a.r r3 = com.opos.mobad.n.a.r.this
                com.opos.mobad.n.a$a r3 = com.opos.mobad.n.a.r.g(r3)
                r3.b()
                goto L80
            L51:
                com.opos.mobad.n.a.r r3 = com.opos.mobad.n.a.r.this
                int r3 = com.opos.mobad.n.a.r.a(r3)
                r4 = 3
                if (r3 != r4) goto L80
                com.opos.mobad.n.a.r r3 = com.opos.mobad.n.a.r.this
                android.content.Context r3 = com.opos.mobad.n.a.r.m(r3)
                boolean r3 = com.opos.mobad.n.a.q.e(r3)
                if (r3 == 0) goto L80
                goto L7b
            L67:
                r4 = 2
                if (r3 != r4) goto L80
                com.opos.mobad.n.a.r r3 = com.opos.mobad.n.a.r.this
                android.content.Context r3 = com.opos.mobad.n.a.r.m(r3)
                boolean r3 = com.opos.mobad.n.a.q.e(r3)
                if (r3 != 0) goto L80
                com.opos.mobad.n.a.r r3 = com.opos.mobad.n.a.r.this
                com.opos.mobad.n.a.r.b(r3, r2)
            L7b:
                com.opos.mobad.n.a.r r3 = com.opos.mobad.n.a.r.this
                com.opos.mobad.n.a.r.a(r3, r8)
            L80:
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = "splashView onWindowVisibilityChanged："
                r3.append(r4)
                r3.append(r8)
                java.lang.String r3 = r3.toString()
                com.opos.cmn.an.f.a.b(r1, r3)
                com.opos.mobad.n.a.r r1 = com.opos.mobad.n.a.r.this
                long r3 = com.opos.mobad.n.a.r.b(r1)
                r5 = 0
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 <= 0) goto Lab
                com.opos.mobad.n.a.r r1 = com.opos.mobad.n.a.r.this
                int r1 = com.opos.mobad.n.a.r.a(r1)
                r3 = 4
                if (r1 != r3) goto Laa
                goto Lab
            Laa:
                r0 = 0
            Lab:
                if (r8 == 0) goto Lba
                if (r0 == 0) goto Lba
                com.opos.mobad.n.a.r r8 = com.opos.mobad.n.a.r.this
                com.opos.mobad.n.a.r.i(r8)
                com.opos.mobad.c.d.a r8 = r2
                r0 = 0
                r8.a(r0)
            Lba:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.n.a.r.AnonymousClass2.a(boolean):void");
        }
    }

    /* renamed from: com.opos.mobad.n.a.r$3 */
    class AnonymousClass3 extends com.opos.mobad.n.c.g {
        AnonymousClass3() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            r.this.A.b();
            if (r.this.f21879b != null) {
                r.this.f21879b.e(view, iArr);
            }
        }
    }

    /* renamed from: com.opos.mobad.n.a.r$4 */
    class AnonymousClass4 extends com.opos.mobad.n.c.g {
        AnonymousClass4() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            if (r.this.f21879b != null) {
                r.this.f21879b.f(view, iArr);
            }
        }
    }

    /* renamed from: com.opos.mobad.n.a.r$5 */
    class AnonymousClass5 implements View.OnClickListener {
        AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            r.this.f();
        }
    }

    /* renamed from: com.opos.mobad.n.a.r$6 */
    class AnonymousClass6 implements d.a {
        AnonymousClass6() {
        }

        @Override // com.opos.mobad.n.d.a
        public void a(View view, int[] iArr) {
            if (r.this.f21879b != null) {
                r.this.a();
                r.this.p();
                r.this.f21879b.d(view, iArr);
            }
        }
    }

    /* renamed from: com.opos.mobad.n.a.r$7 */
    class AnonymousClass7 implements com.opos.mobad.c.c.b {
        AnonymousClass7() {
        }

        private void a(long j2) {
            String str;
            if (j2 <= 0) {
                str = "error video duration";
            } else {
                r rVar = r.this;
                rVar.r = Math.min(j2, rVar.r);
                r rVar2 = r.this;
                rVar2.x = rVar2.r;
                str = "resetVideoDurationIfNeed ori = " + j2 + ",after =" + r.this.x;
            }
            com.opos.cmn.an.f.a.b("SplashVideo", str);
        }

        @Override // com.opos.mobad.c.c.b
        public void a(int i2, String str) {
            com.opos.cmn.an.f.a.b("SplashVideo", "play video error,errCode:" + i2 + ", errMsg" + str);
            r.this.u = 4;
            r.this.a();
            r.this.p();
            if (r.this.f21879b != null) {
                r.this.f21879b.b(i2);
            }
        }

        @Override // com.opos.mobad.c.c.b
        public void c() {
        }

        @Override // com.opos.mobad.c.c.b
        public void d() {
            com.opos.cmn.an.f.a.b("SplashVideo", "play video onStart");
            r.this.u = 2;
            r.this.v = 0;
            r rVar = r.this;
            rVar.y = rVar.f21881d.c();
            a(r.this.y);
            r.this.w.a(0L);
            r.this.o();
        }

        @Override // com.opos.mobad.c.c.b
        public void e() {
            com.opos.cmn.an.f.a.b("SplashVideo", "play video complete");
        }

        @Override // com.opos.mobad.c.c.b
        public void f() {
            com.opos.cmn.an.f.a.b("SplashVideo", "play video onResume");
            r.this.u = 2;
            r.this.v = 0;
        }

        @Override // com.opos.mobad.c.c.b
        public void g() {
            com.opos.cmn.an.f.a.b("SplashVideo", "play video onPause");
            r.this.u = 3;
        }

        @Override // com.opos.mobad.c.c.b
        public void h() {
        }

        @Override // com.opos.mobad.c.c.b
        public void i() {
        }

        @Override // com.opos.mobad.c.c.b
        public void j() {
        }
    }

    /* renamed from: com.opos.mobad.n.a.r$8 */
    class AnonymousClass8 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ com.opos.mobad.c.c.a f21896a;

        AnonymousClass8(com.opos.mobad.c.c.a aVar) {
            aVar = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (aVar != null) {
                com.opos.cmn.an.f.a.b("SplashVideo", "video player release");
                aVar.h();
            }
        }
    }

    public class a extends com.opos.mobad.c.d.a {
        public a(Context context) {
            super(context);
        }

        @Override // com.opos.mobad.c.d.a, android.view.View
        protected void onWindowVisibilityChanged(int i2) {
            super.onWindowVisibilityChanged(i2);
            r.this.b(i2 == 0);
        }
    }

    public r(Context context, int i2, com.opos.mobad.c.c.a aVar, int i3, m mVar) {
        this.B = m.NONE;
        this.f21878a = context;
        this.B = a(mVar);
        this.f21883f = i3;
        this.f21882e = i2;
        this.f21881d = aVar;
        aVar.a(this.D);
        this.f21881d.d(0);
        this.f21881d.c(3);
        this.f21881d.a(0.0f);
        h();
        g();
    }

    private m a(m mVar) {
        Sensor sensor;
        m mVar2 = m.NONE;
        if (mVar == mVar2) {
            return mVar;
        }
        if (Build.VERSION.SDK_INT < 21) {
            return mVar2;
        }
        if (mVar != m.SHAKE) {
            return mVar;
        }
        try {
            sensor = ((SensorManager) this.f21878a.getSystemService(am.ac)).getDefaultSensor(1);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.b("SplashVideo", "check", e2);
            sensor = null;
        }
        return sensor == null ? m.NONE : mVar;
    }

    public static final com.opos.mobad.n.a a(Context context, int i2, com.opos.mobad.c.c.a aVar, m mVar) {
        return new r(context, i2, aVar, 0, mVar);
    }

    private void a(com.opos.mobad.n.d.e eVar) {
        com.opos.mobad.n.c cVar;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.f21886i.addView(this.f21887j, layoutParams);
        this.f21886i.addView(this.p, layoutParams);
        com.opos.mobad.n.d.a aVar = eVar.v;
        if (aVar != null) {
            a(aVar.f22065a, aVar.f22066b);
        }
        k();
        this.A.a(eVar.l, eVar.E, eVar.F);
        if (this.f21883f == 0 && (cVar = eVar.t) != null) {
            View a2 = cVar.a();
            this.l = a2;
            if (a2 != null && a2.getParent() != null) {
                ((ViewGroup) this.l.getParent()).removeView(this.l);
            }
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        View view = this.l;
        if (view != null) {
            view.setId(View.generateViewId());
            this.f21885h.addView(this.l, q.b(this.f21878a));
            this.l.setVisibility(0);
            layoutParams2.addRule(2, this.l.getId());
        }
        this.f21885h.addView(this.f21886i, layoutParams2);
        this.m = q.a(eVar, this.f21885h);
        eVar.u.a(new d.a() { // from class: com.opos.mobad.n.a.r.6
            AnonymousClass6() {
            }

            @Override // com.opos.mobad.n.d.a
            public void a(View view2, int[] iArr) {
                if (r.this.f21879b != null) {
                    r.this.a();
                    r.this.p();
                    r.this.f21879b.d(view2, iArr);
                }
            }
        });
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(12);
        layoutParams3.addRule(11);
        layoutParams3.rightMargin = com.opos.cmn.an.h.f.a.a(this.f21878a, 22.0f);
        layoutParams3.bottomMargin = m();
        View a3 = com.opos.mobad.n.e.a(this.f21880c, this.f21886i, layoutParams3);
        this.n = a3;
        a3.setVisibility(4);
        this.f21886i.addView(this.k, l());
    }

    private void a(String str, String str2) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        layoutParams.bottomMargin = m();
        this.f21886i.addView(this.o, layoutParams);
        this.o.a(n(), str, str2);
    }

    private void a(boolean z) {
        com.opos.mobad.c.c.a aVar = this.f21881d;
        if (aVar != null) {
            aVar.a(z ? 1.0f : 0.0f);
        }
        ImageView imageView = this.k;
        if (imageView != null) {
            imageView.setImageDrawable(z ? this.t : this.s);
        }
    }

    public static final com.opos.mobad.n.a b(Context context, int i2, com.opos.mobad.c.c.a aVar, m mVar) {
        return new r(context, i2, aVar, 1, mVar);
    }

    public void b(boolean z) {
        String str;
        if (this.z == z) {
            com.opos.cmn.an.f.a.b("SplashVideo", "view visbile not change");
            return;
        }
        this.z = z;
        try {
            com.opos.cmn.an.f.a.b("SplashVideo", "onWindowVisibilityChanged isViewVisible= " + z + "," + this.u + "," + this.v);
            if (this.u != 0 && !q()) {
                if (z) {
                    if (this.u != 1 && this.u != 2 && this.u != 4) {
                        if (this.v != 1) {
                            this.f21881d.g();
                            return;
                        }
                        str = "resetVideoPlayerByVisible but is user stop";
                    }
                    str = "resetVideoPlayerByVisible error state" + this.u;
                } else {
                    if (this.u != 3 && this.u != 4) {
                        this.f21881d.f();
                        return;
                    }
                    str = "resetVideoPlayerByVisible current state has stop =" + this.u;
                }
                com.opos.cmn.an.f.a.b("SplashVideo", str);
            }
            str = "resetVideoPlayerByVisible but no action " + this.u;
            com.opos.cmn.an.f.a.b("SplashVideo", str);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.b("SplashVideo", "reset video fail", e2);
        }
    }

    public static final com.opos.mobad.n.a c(Context context, int i2, com.opos.mobad.c.c.a aVar, m mVar) {
        return new r(context, i2, aVar, 2, mVar);
    }

    private void g() {
        a aVar = new a(this.f21878a);
        aVar.a(new a.InterfaceC0428a() { // from class: com.opos.mobad.n.a.r.2

            /* renamed from: a */
            final /* synthetic */ com.opos.mobad.c.d.a f21889a;

            AnonymousClass2(com.opos.mobad.c.d.a aVar2) {
                aVar = aVar2;
            }

            @Override // com.opos.mobad.c.d.a.InterfaceC0428a
            public void a(boolean z) {
                /*
                    this = this;
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    java.lang.String r1 = "isViewVisible = "
                    r0.append(r1)
                    r0.append(r8)
                    java.lang.String r0 = r0.toString()
                    java.lang.String r1 = "SplashVideo"
                    com.opos.cmn.an.f.a.b(r1, r0)
                    com.opos.mobad.n.a.r r0 = com.opos.mobad.n.a.r.this
                    com.opos.mobad.n.d.e r0 = com.opos.mobad.n.a.r.j(r0)
                    if (r0 != 0) goto L20
                    goto Lba
                L20:
                    r0 = 1
                    r2 = 0
                    com.opos.mobad.n.a.r r3 = com.opos.mobad.n.a.r.this
                    int r3 = com.opos.mobad.n.a.r.a(r3)
                    if (r8 == 0) goto L67
                    if (r3 != 0) goto L51
                    com.opos.mobad.n.a.r r3 = com.opos.mobad.n.a.r.this
                    com.opos.mobad.n.a.r.a(r3, r0)
                    com.opos.mobad.n.a.r r3 = com.opos.mobad.n.a.r.this
                    com.opos.mobad.n.a.r.k(r3)
                    com.opos.mobad.n.a.r r3 = com.opos.mobad.n.a.r.this
                    com.opos.mobad.n.a.f r3 = com.opos.mobad.n.a.r.l(r3)
                    r3.c()
                    com.opos.mobad.n.a.r r3 = com.opos.mobad.n.a.r.this
                    com.opos.mobad.n.a$a r3 = com.opos.mobad.n.a.r.g(r3)
                    if (r3 == 0) goto L80
                    com.opos.mobad.n.a.r r3 = com.opos.mobad.n.a.r.this
                    com.opos.mobad.n.a$a r3 = com.opos.mobad.n.a.r.g(r3)
                    r3.b()
                    goto L80
                L51:
                    com.opos.mobad.n.a.r r3 = com.opos.mobad.n.a.r.this
                    int r3 = com.opos.mobad.n.a.r.a(r3)
                    r4 = 3
                    if (r3 != r4) goto L80
                    com.opos.mobad.n.a.r r3 = com.opos.mobad.n.a.r.this
                    android.content.Context r3 = com.opos.mobad.n.a.r.m(r3)
                    boolean r3 = com.opos.mobad.n.a.q.e(r3)
                    if (r3 == 0) goto L80
                    goto L7b
                L67:
                    r4 = 2
                    if (r3 != r4) goto L80
                    com.opos.mobad.n.a.r r3 = com.opos.mobad.n.a.r.this
                    android.content.Context r3 = com.opos.mobad.n.a.r.m(r3)
                    boolean r3 = com.opos.mobad.n.a.q.e(r3)
                    if (r3 != 0) goto L80
                    com.opos.mobad.n.a.r r3 = com.opos.mobad.n.a.r.this
                    com.opos.mobad.n.a.r.b(r3, r2)
                L7b:
                    com.opos.mobad.n.a.r r3 = com.opos.mobad.n.a.r.this
                    com.opos.mobad.n.a.r.a(r3, r8)
                L80:
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder
                    r3.<init>()
                    java.lang.String r4 = "splashView onWindowVisibilityChanged："
                    r3.append(r4)
                    r3.append(r8)
                    java.lang.String r3 = r3.toString()
                    com.opos.cmn.an.f.a.b(r1, r3)
                    com.opos.mobad.n.a.r r1 = com.opos.mobad.n.a.r.this
                    long r3 = com.opos.mobad.n.a.r.b(r1)
                    r5 = 0
                    int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                    if (r1 <= 0) goto Lab
                    com.opos.mobad.n.a.r r1 = com.opos.mobad.n.a.r.this
                    int r1 = com.opos.mobad.n.a.r.a(r1)
                    r3 = 4
                    if (r1 != r3) goto Laa
                    goto Lab
                Laa:
                    r0 = 0
                Lab:
                    if (r8 == 0) goto Lba
                    if (r0 == 0) goto Lba
                    com.opos.mobad.n.a.r r8 = com.opos.mobad.n.a.r.this
                    com.opos.mobad.n.a.r.i(r8)
                    com.opos.mobad.c.d.a r8 = r2
                    r0 = 0
                    r8.a(r0)
                Lba:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.n.a.r.AnonymousClass2.a(boolean):void");
            }
        });
        this.f21885h.addView(aVar2, new RelativeLayout.LayoutParams(0, 0));
    }

    private void h() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f21878a);
        this.f21885h = relativeLayout;
        relativeLayout.setBackgroundColor(-1);
        RelativeLayout relativeLayout2 = new RelativeLayout(this.f21878a);
        this.f21886i = relativeLayout2;
        relativeLayout2.setBackgroundColor(-1);
        AnonymousClass3 anonymousClass3 = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.a.r.3
            AnonymousClass3() {
            }

            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                r.this.A.b();
                if (r.this.f21879b != null) {
                    r.this.f21879b.e(view, iArr);
                }
            }
        };
        this.f21886i.setOnTouchListener(anonymousClass3);
        this.f21886i.setOnClickListener(anonymousClass3);
        this.p = new FrameLayout(this.f21878a);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{1711276032, 16777215, 16777215, 1711276032});
        gradientDrawable.setGradientType(0);
        this.p.setBackground(gradientDrawable);
        this.p.setVisibility(4);
        View b2 = this.f21881d.b();
        this.f21887j = b2;
        b2.setVisibility(0);
        b bVar = new b(this.f21878a);
        this.o = bVar;
        bVar.setVisibility(4);
        i();
        j();
    }

    private void i() {
        f a2 = l.a(this.f21878a, this.B);
        this.A = a2;
        a2.a(new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.a.r.4
            AnonymousClass4() {
            }

            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (r.this.f21879b != null) {
                    r.this.f21879b.f(view, iArr);
                }
            }
        });
    }

    private void j() {
        ImageView imageView = new ImageView(this.f21878a);
        this.k = imageView;
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.s = this.f21878a.getResources().getDrawable(R.drawable.opos_mobad_drawable_sound_off);
        this.t = this.f21878a.getResources().getDrawable(R.drawable.opos_mobad_drawable_sound_on);
        int a2 = com.opos.cmn.an.h.f.a.a(this.f21878a, 6.0f);
        int a3 = com.opos.cmn.an.h.f.a.a(this.f21878a, 7.0f);
        this.k.setPadding(a2, a3, a2, a3);
        this.k.setImageDrawable(this.s);
        this.k.setOnClickListener(new View.OnClickListener() { // from class: com.opos.mobad.n.a.r.5
            AnonymousClass5() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                r.this.f();
            }
        });
        this.k.setVisibility(4);
    }

    private void k() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        int i2 = this.f21883f;
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f21878a, i2 != 1 ? i2 != 2 ? 72 : 37 : 79);
        this.f21886i.addView(this.A.a(), layoutParams);
    }

    private RelativeLayout.LayoutParams l() {
        int a2 = com.opos.cmn.an.h.f.a.a(this.f21878a, 26.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a2, a2);
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        int i2 = this.f21880c.o == 0 ? 96 : 22;
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f21878a, 33.0f);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.f21878a, i2);
        return layoutParams;
    }

    private int m() {
        return com.opos.cmn.an.h.f.a.a(this.f21878a, this.f21883f != 1 ? 15 : 30);
    }

    private int n() {
        return this.f21883f == 2 ? 1 : 0;
    }

    public void o() {
        this.f21887j.setVisibility(0);
        this.p.setVisibility(0);
        this.m.setVisibility(0);
        this.n.setVisibility(0);
        this.o.setVisibility(0);
        this.k.setVisibility(0);
        this.f21886i.setVisibility(0);
    }

    public void p() {
        try {
            if (q()) {
                com.opos.cmn.an.f.a.b("SplashVideo", "video player has release");
                return;
            }
            com.opos.mobad.c.c.a aVar = this.f21881d;
            if (aVar != null) {
                com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.n.a.r.8

                    /* renamed from: a */
                    final /* synthetic */ com.opos.mobad.c.c.a f21896a;

                    AnonymousClass8(com.opos.mobad.c.c.a aVar2) {
                        aVar = aVar2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (aVar != null) {
                            com.opos.cmn.an.f.a.b("SplashVideo", "video player release");
                            aVar.h();
                        }
                    }
                });
            }
            com.opos.cmn.an.f.a.b("SplashVideo", "video player release");
            this.u = 5;
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("SplashVideo", "releaseVideoPlayer", e2);
        }
    }

    private boolean q() {
        return this.u == 5 || this.u == 6;
    }

    public void r() {
        if (s()) {
            com.opos.cmn.an.f.a.b("SplashVideo", "handleAdClosed");
            a.InterfaceC0458a interfaceC0458a = this.f21879b;
            if (interfaceC0458a != null) {
                long j2 = this.x;
                interfaceC0458a.a(j2, j2);
            }
        }
    }

    private boolean s() {
        View c2 = c();
        return c2 != null && c2.isShown();
    }

    public void t() {
        com.opos.mobad.n.d.g gVar;
        com.opos.cmn.an.f.a.b("SplashVideo", "start to play video");
        com.opos.mobad.n.d.e eVar = this.f21880c;
        if (eVar == null || (gVar = eVar.f22079a) == null) {
            return;
        }
        this.f21881d.a(gVar.f22084a);
        this.f21881d.e();
    }

    @Override // com.opos.mobad.n.a
    public void a() {
        com.opos.cmn.an.f.a.b("SplashVideo", "stop countdown...");
        if (this.u == 3 || q() || this.u == 4) {
            com.opos.cmn.an.f.a.b("SplashVideo", "current state has stop =" + this.u);
            return;
        }
        this.w.a();
        this.f21881d.f();
        this.v = 1;
        this.A.d();
    }

    @Override // com.opos.mobad.n.a
    public void a(a.InterfaceC0458a interfaceC0458a) {
        this.o.a(interfaceC0458a);
        this.f21879b = interfaceC0458a;
    }

    @Override // com.opos.mobad.n.a
    public void a(com.opos.mobad.n.d.h hVar) {
        com.opos.mobad.n.d.e b2 = hVar.b();
        if (b2 == null || b2.u == null) {
            this.f21879b.b(1);
            return;
        }
        com.opos.cmn.an.f.a.b("SplashVideo", "render");
        this.f21880c = b2;
        this.q = b2.u;
        long j2 = b2.w;
        this.r = j2;
        if (j2 <= 0) {
            this.r = 3000L;
        }
        this.x = this.r;
        boolean z = b2.B == 1;
        this.f21884g = z;
        a(z);
        a(b2);
    }

    @Override // com.opos.mobad.n.a
    public void b() {
        com.opos.cmn.an.f.a.b("SplashVideo", "start countdown...");
        if (this.u != 1 && this.u != 2 && !q() && this.u != 4) {
            this.w.a(0L);
            this.f21881d.g();
            this.A.e();
        } else {
            com.opos.cmn.an.f.a.b("SplashVideo", "error state" + this.u);
        }
    }

    @Override // com.opos.mobad.n.a
    public View c() {
        return this.f21885h;
    }

    @Override // com.opos.mobad.n.a
    public void d() {
        com.opos.cmn.an.f.a.b("SplashVideo", "destroy");
        this.A.f();
        a();
        p();
        this.f21880c = null;
        this.u = 6;
        this.w.a();
        this.w.b();
    }

    @Override // com.opos.mobad.n.a
    public int e() {
        return this.f21882e;
    }

    public void f() {
        this.f21884g = !this.f21884g;
        com.opos.cmn.an.f.a.b("SplashVideo", "VolumeSwitchIconClicked: " + this.f21884g);
        a(this.f21884g);
    }
}
