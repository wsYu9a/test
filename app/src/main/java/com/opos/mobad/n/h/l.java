package com.opos.mobad.n.h;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.c.d.a;
import com.opos.mobad.n.a;
import com.opos.mobad.n.c.m;
import com.opos.mobad.n.g.ae;
import com.opos.mobad.n.h.k;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public class l extends com.opos.mobad.n.i.a {

    /* renamed from: a */
    private Bitmap f22881a;

    /* renamed from: d */
    private int f22882d;

    /* renamed from: e */
    private int f22883e;

    /* renamed from: f */
    private Context f22884f;

    /* renamed from: g */
    private com.opos.mobad.c.a f22885g;

    /* renamed from: h */
    private RelativeLayout f22886h;

    /* renamed from: i */
    private ae f22887i;

    /* renamed from: j */
    private b f22888j;
    private m k;
    private k l;
    private g m;
    private h n;
    private RelativeLayout o;
    private RelativeLayout p;
    private Handler q;
    private com.opos.mobad.n.d.e r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;
    private Runnable w;
    private com.opos.mobad.c.d.a x;
    private a y;

    /* renamed from: com.opos.mobad.n.h.l$1 */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (l.this.o() == 8) {
                return;
            }
            long f2 = l.this.k.f();
            l.this.c(f2, l.this.k.g());
            l.this.a(f2);
            l.this.q.postDelayed(this, 1000L);
        }
    }

    /* renamed from: com.opos.mobad.n.h.l$2 */
    class AnonymousClass2 implements k.a {
        AnonymousClass2() {
        }

        @Override // com.opos.mobad.n.h.k.a
        public void a(int i2) {
            l.this.k.a(i2);
        }
    }

    /* renamed from: com.opos.mobad.n.h.l$3 */
    class AnonymousClass3 extends com.opos.mobad.n.c.g {
        AnonymousClass3() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            l.this.e(view, iArr);
        }
    }

    /* renamed from: com.opos.mobad.n.h.l$4 */
    class AnonymousClass4 implements a.InterfaceC0428a {
        AnonymousClass4() {
        }

        @Override // com.opos.mobad.c.d.a.InterfaceC0428a
        public void a(boolean z) {
            if (l.this.r == null) {
                return;
            }
            if (!z) {
                l.this.l();
            } else {
                l.this.n();
                l.this.k();
            }
        }
    }

    /* renamed from: com.opos.mobad.n.h.l$5 */
    class AnonymousClass5 implements m.a {

        /* renamed from: com.opos.mobad.n.h.l$5$1 */
        class AnonymousClass1 implements Runnable {
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (l.this.o() == 8) {
                    return;
                }
                l.this.o.setBackground(new BitmapDrawable(l.this.f22881a));
            }
        }

        AnonymousClass5() {
        }

        @Override // com.opos.mobad.n.c.m.a
        public void a() {
        }

        @Override // com.opos.mobad.n.c.m.a
        public void a(Bitmap bitmap) {
            if (l.this.o() == 8) {
                return;
            }
            l lVar = l.this;
            lVar.f22881a = com.opos.mobad.n.c.d.a(lVar.f22884f, bitmap, 75, 0.25f, 56.0f);
            com.opos.mobad.c.b.b.b(new Runnable() { // from class: com.opos.mobad.n.h.l.5.1
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (l.this.o() == 8) {
                        return;
                    }
                    l.this.o.setBackground(new BitmapDrawable(l.this.f22881a));
                }
            });
        }
    }

    /* renamed from: com.opos.mobad.n.h.l$6 */
    class AnonymousClass6 implements a {

        /* renamed from: com.opos.mobad.n.h.l$6$1 */
        class AnonymousClass1 implements Callable<Boolean> {
            AnonymousClass1() {
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() throws Exception {
                l.this.t();
                l.this.s();
                return Boolean.TRUE;
            }
        }

        AnonymousClass6() {
        }

        @Override // com.opos.mobad.n.h.a
        public void a() {
            if (l.this.r == null) {
                return;
            }
            l lVar = l.this;
            lVar.a(lVar.r, l.this.k.b());
        }

        @Override // com.opos.mobad.n.a.InterfaceC0458a
        public void a(int i2, String str) {
            if (l.this.o() != 8) {
                l.this.q.removeCallbacks(l.this.w);
            }
            l.this.a(i2, str);
        }

        @Override // com.opos.mobad.n.a.InterfaceC0458a
        public void a(long j2, long j3) {
            l.this.p();
            l.this.q.removeCallbacks(l.this.w);
            l.this.r();
        }

        @Override // com.opos.mobad.n.a.InterfaceC0458a
        public void a(View view, int[] iArr) {
            l.this.h(view, iArr);
        }

        @Override // com.opos.mobad.n.a.InterfaceC0458a
        public void a(View view, int[] iArr, boolean z) {
            l.this.a(view, iArr, z);
        }

        @Override // com.opos.mobad.n.a.InterfaceC0458a
        public void b() {
        }

        @Override // com.opos.mobad.n.a.InterfaceC0458a
        public void b(int i2) {
            l.this.a(i2);
        }

        @Override // com.opos.mobad.n.a.InterfaceC0458a
        public void b(long j2, long j3) {
            l.this.b(j2, j3);
            if (l.this.o() != 8) {
                l.this.q.removeCallbacks(l.this.w);
                l.this.q.post(l.this.w);
            }
        }

        @Override // com.opos.mobad.n.a.InterfaceC0458a
        public void b(View view, int[] iArr) {
            l.this.c(view, iArr);
        }

        @Override // com.opos.mobad.n.a.InterfaceC0458a
        public void c(int i2) {
            l.this.b(i2);
        }

        @Override // com.opos.mobad.n.a.InterfaceC0458a
        public void c(long j2, long j3) {
            l.this.a(j2, j3);
            if (l.this.o() != 8) {
                l.this.q.removeCallbacks(l.this.w);
            }
        }

        @Override // com.opos.mobad.n.a.InterfaceC0458a
        public void c(View view, int[] iArr) {
            l.this.b(view, iArr);
        }

        @Override // com.opos.mobad.n.a.InterfaceC0458a
        public void d(long j2, long j3) {
            if (j2 == 0) {
                l.this.q.removeCallbacks(l.this.w);
                l.this.q.postDelayed(l.this.w, 10L);
                l.this.c(0L, r3.k.g());
                l.this.q();
            }
        }

        @Override // com.opos.mobad.n.a.InterfaceC0458a
        public void d(View view, int[] iArr) {
            l.this.a(view, iArr);
        }

        @Override // com.opos.mobad.n.a.InterfaceC0458a
        public void e() {
            l.this.a(new Callable<Boolean>() { // from class: com.opos.mobad.n.h.l.6.1
                AnonymousClass1() {
                }

                @Override // java.util.concurrent.Callable
                /* renamed from: a */
                public Boolean call() throws Exception {
                    l.this.t();
                    l.this.s();
                    return Boolean.TRUE;
                }
            });
        }

        @Override // com.opos.mobad.n.a.InterfaceC0458a
        public void e(View view, int[] iArr) {
            l.this.f(view, iArr);
        }

        @Override // com.opos.mobad.n.a.InterfaceC0458a
        public void f(View view, int[] iArr) {
            l.this.d(view, iArr);
        }

        @Override // com.opos.mobad.n.a.InterfaceC0458a
        public void g(View view, int[] iArr) {
            l.this.e(view, iArr);
        }

        @Override // com.opos.mobad.n.a.InterfaceC0458a
        public void h(View view, int[] iArr) {
            l.this.g(view, iArr);
        }

        @Override // com.opos.mobad.n.a.InterfaceC0458a
        public void i(View view, int[] iArr) {
            l.this.i(view, iArr);
        }

        @Override // com.opos.mobad.n.a.InterfaceC0458a
        public void j(View view, int[] iArr) {
        }

        @Override // com.opos.mobad.n.a.InterfaceC0458a
        public void k(View view, int[] iArr) {
        }
    }

    private l(Context context, int i2, com.opos.mobad.c.c.a aVar, com.opos.mobad.c.a aVar2, boolean z) {
        super(i2);
        this.f22881a = null;
        this.s = false;
        this.t = false;
        this.u = false;
        this.v = true;
        this.w = new Runnable() { // from class: com.opos.mobad.n.h.l.1
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (l.this.o() == 8) {
                    return;
                }
                long f2 = l.this.k.f();
                l.this.c(f2, l.this.k.g());
                l.this.a(f2);
                l.this.q.postDelayed(this, 1000L);
            }
        };
        this.y = new a() { // from class: com.opos.mobad.n.h.l.6

            /* renamed from: com.opos.mobad.n.h.l$6$1 */
            class AnonymousClass1 implements Callable<Boolean> {
                AnonymousClass1() {
                }

                @Override // java.util.concurrent.Callable
                /* renamed from: a */
                public Boolean call() throws Exception {
                    l.this.t();
                    l.this.s();
                    return Boolean.TRUE;
                }
            }

            AnonymousClass6() {
            }

            @Override // com.opos.mobad.n.h.a
            public void a() {
                if (l.this.r == null) {
                    return;
                }
                l lVar = l.this;
                lVar.a(lVar.r, l.this.k.b());
            }

            @Override // com.opos.mobad.n.a.InterfaceC0458a
            public void a(int i22, String str) {
                if (l.this.o() != 8) {
                    l.this.q.removeCallbacks(l.this.w);
                }
                l.this.a(i22, str);
            }

            @Override // com.opos.mobad.n.a.InterfaceC0458a
            public void a(long j2, long j3) {
                l.this.p();
                l.this.q.removeCallbacks(l.this.w);
                l.this.r();
            }

            @Override // com.opos.mobad.n.a.InterfaceC0458a
            public void a(View view, int[] iArr) {
                l.this.h(view, iArr);
            }

            @Override // com.opos.mobad.n.a.InterfaceC0458a
            public void a(View view, int[] iArr, boolean z2) {
                l.this.a(view, iArr, z2);
            }

            @Override // com.opos.mobad.n.a.InterfaceC0458a
            public void b() {
            }

            @Override // com.opos.mobad.n.a.InterfaceC0458a
            public void b(int i22) {
                l.this.a(i22);
            }

            @Override // com.opos.mobad.n.a.InterfaceC0458a
            public void b(long j2, long j3) {
                l.this.b(j2, j3);
                if (l.this.o() != 8) {
                    l.this.q.removeCallbacks(l.this.w);
                    l.this.q.post(l.this.w);
                }
            }

            @Override // com.opos.mobad.n.a.InterfaceC0458a
            public void b(View view, int[] iArr) {
                l.this.c(view, iArr);
            }

            @Override // com.opos.mobad.n.a.InterfaceC0458a
            public void c(int i22) {
                l.this.b(i22);
            }

            @Override // com.opos.mobad.n.a.InterfaceC0458a
            public void c(long j2, long j3) {
                l.this.a(j2, j3);
                if (l.this.o() != 8) {
                    l.this.q.removeCallbacks(l.this.w);
                }
            }

            @Override // com.opos.mobad.n.a.InterfaceC0458a
            public void c(View view, int[] iArr) {
                l.this.b(view, iArr);
            }

            @Override // com.opos.mobad.n.a.InterfaceC0458a
            public void d(long j2, long j3) {
                if (j2 == 0) {
                    l.this.q.removeCallbacks(l.this.w);
                    l.this.q.postDelayed(l.this.w, 10L);
                    l.this.c(0L, r3.k.g());
                    l.this.q();
                }
            }

            @Override // com.opos.mobad.n.a.InterfaceC0458a
            public void d(View view, int[] iArr) {
                l.this.a(view, iArr);
            }

            @Override // com.opos.mobad.n.a.InterfaceC0458a
            public void e() {
                l.this.a(new Callable<Boolean>() { // from class: com.opos.mobad.n.h.l.6.1
                    AnonymousClass1() {
                    }

                    @Override // java.util.concurrent.Callable
                    /* renamed from: a */
                    public Boolean call() throws Exception {
                        l.this.t();
                        l.this.s();
                        return Boolean.TRUE;
                    }
                });
            }

            @Override // com.opos.mobad.n.a.InterfaceC0458a
            public void e(View view, int[] iArr) {
                l.this.f(view, iArr);
            }

            @Override // com.opos.mobad.n.a.InterfaceC0458a
            public void f(View view, int[] iArr) {
                l.this.d(view, iArr);
            }

            @Override // com.opos.mobad.n.a.InterfaceC0458a
            public void g(View view, int[] iArr) {
                l.this.e(view, iArr);
            }

            @Override // com.opos.mobad.n.a.InterfaceC0458a
            public void h(View view, int[] iArr) {
                l.this.g(view, iArr);
            }

            @Override // com.opos.mobad.n.a.InterfaceC0458a
            public void i(View view, int[] iArr) {
                l.this.i(view, iArr);
            }

            @Override // com.opos.mobad.n.a.InterfaceC0458a
            public void j(View view, int[] iArr) {
            }

            @Override // com.opos.mobad.n.a.InterfaceC0458a
            public void k(View view, int[] iArr) {
            }
        };
        this.f22884f = context;
        this.q = new Handler(Looper.getMainLooper());
        this.f22885g = aVar2;
        boolean a2 = com.opos.mobad.c.b.a.a(this.f22884f);
        this.u = a2;
        z = a2 ? true : z;
        this.v = z;
        a(z);
        a(aVar, z);
    }

    public static l a(Context context, int i2, com.opos.mobad.c.c.a aVar, com.opos.mobad.c.a aVar2) {
        return new l(context, i2, aVar, aVar2, true);
    }

    public void a(long j2) {
        com.opos.mobad.n.d.e eVar = this.r;
        if (eVar == null || this.t) {
            return;
        }
        long j3 = eVar.D;
        if (j3 <= 0 || j2 >= j3) {
            this.t = true;
            this.l.a();
        }
    }

    private void a(com.opos.mobad.c.c.a aVar, boolean z) {
        this.f22886h = new RelativeLayout(this.f22884f);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        this.f22886h.setId(View.generateViewId());
        this.f22886h.setBackgroundColor(Color.parseColor("#000000"));
        this.f22886h.setLayoutParams(layoutParams);
        this.f22886h.setVisibility(8);
        b(aVar, z);
        c(z);
        b(z);
        AnonymousClass3 anonymousClass3 = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.h.l.3
            AnonymousClass3() {
            }

            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                l.this.e(view, iArr);
            }
        };
        this.f22886h.setOnClickListener(anonymousClass3);
        this.f22886h.setOnTouchListener(anonymousClass3);
    }

    private void a(com.opos.mobad.n.d.e eVar) {
        a(eVar.r, eVar.s, eVar.f22077i, eVar.f22078j, eVar.k);
        c(eVar);
        b(eVar);
    }

    public void a(com.opos.mobad.n.d.e eVar, com.opos.mobad.c.c.a aVar) {
        if (this.f22881a != null) {
            this.o.setBackground(new BitmapDrawable(this.f22881a));
        } else {
            com.opos.mobad.n.c.m.a(aVar, eVar.f22079a.f22084a, (m.a) new m.a() { // from class: com.opos.mobad.n.h.l.5

                /* renamed from: com.opos.mobad.n.h.l$5$1 */
                class AnonymousClass1 implements Runnable {
                    AnonymousClass1() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (l.this.o() == 8) {
                            return;
                        }
                        l.this.o.setBackground(new BitmapDrawable(l.this.f22881a));
                    }
                }

                AnonymousClass5() {
                }

                @Override // com.opos.mobad.n.c.m.a
                public void a() {
                }

                @Override // com.opos.mobad.n.c.m.a
                public void a(Bitmap bitmap) {
                    if (l.this.o() == 8) {
                        return;
                    }
                    l lVar = l.this;
                    lVar.f22881a = com.opos.mobad.n.c.d.a(lVar.f22884f, bitmap, 75, 0.25f, 56.0f);
                    com.opos.mobad.c.b.b.b(new Runnable() { // from class: com.opos.mobad.n.h.l.5.1
                        AnonymousClass1() {
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            if (l.this.o() == 8) {
                                return;
                            }
                            l.this.o.setBackground(new BitmapDrawable(l.this.f22881a));
                        }
                    });
                }
            });
        }
    }

    private void a(boolean z) {
        Context context;
        float f2 = 16.0f;
        if (z) {
            this.f22882d = com.opos.cmn.an.h.f.a.a(this.f22884f, 49.0f);
            context = this.f22884f;
        } else {
            this.f22882d = com.opos.cmn.an.h.f.a.a(this.f22884f, 16.0f);
            context = this.f22884f;
            f2 = 42.0f;
        }
        this.f22883e = com.opos.cmn.an.h.f.a.a(context, f2);
    }

    private void a(boolean z, String str, boolean z2, com.opos.mobad.n.d.g gVar, String str2) {
        this.f22887i.a(z, str, z2, gVar, str2);
    }

    public static l b(Context context, int i2, com.opos.mobad.c.c.a aVar, com.opos.mobad.c.a aVar2) {
        return new l(context, i2, aVar, aVar2, false);
    }

    private void b(com.opos.mobad.c.c.a aVar, boolean z) {
        c(aVar, z);
        i();
    }

    private void b(com.opos.mobad.n.d.e eVar) {
        int a2;
        this.f22888j.a(eVar.m, eVar.l, eVar.f22074f, eVar.f22073e, this.f22885g);
        this.f22888j.a(eVar);
        com.opos.mobad.n.d.g gVar = eVar.m;
        if (gVar == null || TextUtils.isEmpty(gVar.f22084a)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.k.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.p.getLayoutParams();
            if (this.v) {
                layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f22884f, 66.0f);
                a2 = com.opos.cmn.an.h.f.a.a(this.f22884f, 66.0f);
            } else {
                a2 = com.opos.cmn.an.h.f.a.a(this.f22884f, 82.0f);
            }
            layoutParams2.height = a2;
        }
    }

    private void b(boolean z) {
        this.n = z ? h.a(this.f22884f) : h.b(this.f22884f);
        this.f22886h.addView(this.n, new RelativeLayout.LayoutParams(-1, -1));
    }

    private void c(com.opos.mobad.c.c.a aVar, boolean z) {
        this.o = new RelativeLayout(this.f22884f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.k = m.a(this.f22884f, aVar);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        if (z) {
            layoutParams2.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f22884f, 76.0f);
        }
        if (z && !this.u) {
            layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(this.f22884f, 94.0f);
            aVar.c(1);
        }
        this.o.addView(this.k, layoutParams2);
        this.f22886h.addView(this.o, layoutParams);
    }

    private void c(com.opos.mobad.n.d.e eVar) {
        this.m.a(eVar.s, eVar.C);
        this.l.a(eVar.B);
    }

    private void c(boolean z) {
        int a2;
        RelativeLayout relativeLayout = new RelativeLayout(this.f22884f);
        this.p = relativeLayout;
        relativeLayout.setId(View.generateViewId());
        this.f22888j = b.a(this.f22884f);
        int a3 = this.u ? -1 : com.opos.cmn.an.h.f.a.a(this.f22884f, 360.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a3, -1);
        this.f22888j.setVisibility(4);
        this.p.addView(this.f22888j, layoutParams);
        int a4 = com.opos.cmn.an.h.f.a.a(this.f22884f, 76.0f);
        if (this.u || z) {
            this.f22888j.setBackgroundResource(R.drawable.opos_mobad_drawable_reward_no_radius_bottom_bg);
            a2 = 0;
        } else {
            a2 = com.opos.cmn.an.h.f.a.a(this.f22884f, 16.0f);
            a4 += a2;
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(a3, a4);
        layoutParams2.addRule(12);
        layoutParams2.addRule(14);
        this.p.setPadding(0, 0, 0, a2);
        this.f22886h.addView(this.p, layoutParams2);
        this.f22887i = ae.a(this.f22884f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(this.f22884f, 14.0f));
        layoutParams3.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f22884f, 16.0f);
        layoutParams3.leftMargin = com.opos.cmn.an.h.f.a.a(this.f22884f, 16.0f);
        if (z || this.u) {
            layoutParams3.addRule(2, this.p.getId());
        } else {
            layoutParams3.addRule(12);
        }
        this.f22886h.addView(this.f22887i, layoutParams3);
    }

    private void i() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f22884f);
        relativeLayout.setId(View.generateViewId());
        this.m = g.a(this.f22884f);
        int a2 = com.opos.cmn.an.h.f.a.a(this.f22884f, 28.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, a2);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.f22884f, 16.0f);
        relativeLayout.addView(this.m, layoutParams);
        RelativeLayout relativeLayout2 = new RelativeLayout(this.f22884f);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(14);
        layoutParams2.addRule(11);
        layoutParams2.rightMargin = this.f22883e;
        k a3 = k.a(this.f22884f);
        this.l = a3;
        a3.setId(View.generateViewId());
        relativeLayout2.addView(this.l, new RelativeLayout.LayoutParams(-2, a2));
        relativeLayout.addView(relativeLayout2, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.topMargin = this.f22882d;
        this.f22886h.addView(relativeLayout, layoutParams3);
    }

    public void q() {
        h hVar = this.n;
        if (hVar == null) {
            return;
        }
        hVar.removeAllViews();
        this.f22886h.removeView(this.n);
        this.n = null;
    }

    public void r() {
        com.opos.mobad.n.d.e eVar = this.r;
        if (eVar != null && eVar.G == 1) {
            this.l.b();
            return;
        }
        this.m.setVisibility(8);
        this.l.setVisibility(4);
        this.f22888j.setVisibility(8);
    }

    public void s() {
        if (this.x == null) {
            com.opos.mobad.c.d.a aVar = new com.opos.mobad.c.d.a(this.f22884f);
            this.x = aVar;
            aVar.a(new a.InterfaceC0428a() { // from class: com.opos.mobad.n.h.l.4
                AnonymousClass4() {
                }

                @Override // com.opos.mobad.c.d.a.InterfaceC0428a
                public void a(boolean z) {
                    if (l.this.r == null) {
                        return;
                    }
                    if (!z) {
                        l.this.l();
                    } else {
                        l.this.n();
                        l.this.k();
                    }
                }
            });
        }
        if (this.f22886h.indexOfChild(this.x) < 0) {
            this.f22886h.addView(this.x, new RelativeLayout.LayoutParams(0, 0));
        }
    }

    public void t() {
        this.f22888j.setVisibility(0);
        this.m.setVisibility(0);
    }

    @Override // com.opos.mobad.n.i.a, com.opos.mobad.n.a
    public void a(a.InterfaceC0458a interfaceC0458a) {
        super.a(interfaceC0458a);
        this.f22887i.a(this.y);
        this.l.a(this.y);
        this.k.a(this.y);
        this.f22888j.a(this.y);
        this.m.a(this.y);
        h hVar = this.n;
        if (hVar != null) {
            hVar.a(this.y);
        }
        this.l.a(new k.a() { // from class: com.opos.mobad.n.h.l.2
            AnonymousClass2() {
            }

            @Override // com.opos.mobad.n.h.k.a
            public void a(int i2) {
                l.this.k.a(i2);
            }
        });
    }

    @Override // com.opos.mobad.n.a
    public void a(com.opos.mobad.n.d.h hVar) {
        if (hVar == null) {
            com.opos.cmn.an.f.a.a("RewardVideoTemplate", "data is null");
        } else {
            com.opos.mobad.n.d.e b2 = hVar.b();
            if (b2 != null) {
                if (!TextUtils.isEmpty(b2.f22079a.f22084a) && this.r == null) {
                    this.k.a(b2);
                }
                this.r = b2;
                RelativeLayout relativeLayout = this.f22886h;
                if (relativeLayout != null && relativeLayout.getVisibility() != 0) {
                    this.f22886h.setVisibility(0);
                }
                a(b2);
                return;
            }
            com.opos.cmn.an.f.a.d("RewardVideoTemplate", "render with data null");
        }
        a(1);
    }

    @Override // com.opos.mobad.n.a
    public View c() {
        return this.f22886h;
    }

    @Override // com.opos.mobad.n.i.a
    protected boolean f() {
        this.k.a();
        return true;
    }

    @Override // com.opos.mobad.n.i.a
    protected boolean g() {
        com.opos.cmn.an.f.a.b("RewardVideoTemplate", "start countdown...");
        this.k.c();
        return true;
    }

    @Override // com.opos.mobad.n.i.a
    protected void h() {
        com.opos.cmn.an.f.a.b("RewardVideoTemplate", "do End");
        this.k.d();
        this.f22888j.a();
        this.q.removeCallbacks(this.w);
        RelativeLayout relativeLayout = this.f22886h;
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
        }
    }
}
