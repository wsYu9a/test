package com.opos.mobad.n.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.opos.mobad.c.d.a;
import com.opos.mobad.n.a;
import com.opos.mobad.n.d;
import com.umeng.analytics.pro.am;
import java.util.List;

/* loaded from: classes4.dex */
public class h implements com.opos.mobad.n.a {

    /* renamed from: b */
    private a f21778b;

    /* renamed from: c */
    private g f21779c;

    /* renamed from: d */
    private ImageView f21780d;

    /* renamed from: e */
    private int f21781e;

    /* renamed from: g */
    private long f21783g;

    /* renamed from: h */
    private f f21784h;

    /* renamed from: i */
    private Context f21785i;

    /* renamed from: j */
    private a.InterfaceC0458a f21786j;
    private com.opos.mobad.n.d.d k;
    private int l;
    private int m;
    private RelativeLayout n;
    private RelativeLayout o;
    private ViewGroup p;
    private View q;
    private View r;
    private b s;
    private com.opos.mobad.n.d t;
    private long u;
    private m v;

    /* renamed from: a */
    private volatile int f21777a = 0;
    private Runnable w = new Runnable() { // from class: com.opos.mobad.n.a.h.1
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (h.this.f21777a == 4) {
                return;
            }
            if (h.this.u <= 0) {
                h.this.f21786j.d(h.this.f21783g - h.this.u, h.this.f21783g);
                h.this.f21782f.a();
                h.this.a();
                h.this.r();
                return;
            }
            com.opos.cmn.an.f.a.b("LogoSplash", "countdown=" + h.this.u);
            h.this.f21782f.a(1000L);
            if (h.this.t != null) {
                h.this.t.a((int) (h.this.u / 1000));
            }
            h.this.f21786j.d(h.this.f21783g - h.this.u, h.this.f21783g);
            h.this.u -= 1000;
        }
    };

    /* renamed from: f */
    private com.opos.mobad.c.b.c f21782f = new com.opos.mobad.c.b.c(com.opos.mobad.c.b.b.a(), this.w);

    /* renamed from: com.opos.mobad.n.a.h$1 */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (h.this.f21777a == 4) {
                return;
            }
            if (h.this.u <= 0) {
                h.this.f21786j.d(h.this.f21783g - h.this.u, h.this.f21783g);
                h.this.f21782f.a();
                h.this.a();
                h.this.r();
                return;
            }
            com.opos.cmn.an.f.a.b("LogoSplash", "countdown=" + h.this.u);
            h.this.f21782f.a(1000L);
            if (h.this.t != null) {
                h.this.t.a((int) (h.this.u / 1000));
            }
            h.this.f21786j.d(h.this.f21783g - h.this.u, h.this.f21783g);
            h.this.u -= 1000;
        }
    }

    /* renamed from: com.opos.mobad.n.a.h$2 */
    class AnonymousClass2 implements a.InterfaceC0428a {

        /* renamed from: a */
        final /* synthetic */ com.opos.mobad.c.d.a f21788a;

        AnonymousClass2(com.opos.mobad.c.d.a aVar) {
            aVar = aVar;
        }

        @Override // com.opos.mobad.c.d.a.InterfaceC0428a
        public void a(boolean z) {
            if (h.this.k == null) {
                return;
            }
            if (z && h.this.f21777a == 0) {
                h.this.b();
                h.this.f21784h.c();
                if (h.this.f21786j != null) {
                    h.this.f21786j.b();
                }
            }
            com.opos.cmn.an.f.a.b("LogoSplash", "splashView onWindowVisibilityChanged：" + z);
            boolean z2 = h.this.u <= 0 || h.this.f21777a == 3;
            if (z && z2) {
                h.this.r();
                aVar.a((a.InterfaceC0428a) null);
            }
        }
    }

    /* renamed from: com.opos.mobad.n.a.h$3 */
    class AnonymousClass3 extends com.opos.mobad.n.c.g {
        AnonymousClass3() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            h.this.f21784h.b();
            if (h.this.f21786j != null) {
                h.this.f21786j.g(view, iArr);
            }
        }
    }

    /* renamed from: com.opos.mobad.n.a.h$4 */
    class AnonymousClass4 extends com.opos.mobad.n.c.g {
        AnonymousClass4() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            if (h.this.f21786j != null) {
                h.this.f21786j.f(view, iArr);
            }
        }
    }

    /* renamed from: com.opos.mobad.n.a.h$5 */
    class AnonymousClass5 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ com.opos.mobad.n.d.d f21792a;

        /* renamed from: com.opos.mobad.n.a.h$5$1 */
        class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Bitmap f21794a;

            /* renamed from: b */
            final /* synthetic */ Bitmap f21795b;

            AnonymousClass1(Bitmap bitmap, Bitmap bitmap2) {
                b2 = bitmap;
                a2 = bitmap2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (h.this.f21777a == 4) {
                    com.opos.cmn.an.f.a.b("LogoSplash", "load bitmap but has destroy");
                    return;
                }
                a aVar = h.this.f21778b;
                int p = h.this.p();
                Bitmap bitmap = b2;
                com.opos.mobad.n.d.d dVar = dVar;
                aVar.a(p, bitmap, dVar.f22074f, dVar.f22073e);
                h.this.f21778b.setVisibility(0);
                h.this.f21780d.setImageBitmap(a2);
            }
        }

        AnonymousClass5(com.opos.mobad.n.d.d dVar) {
            dVar = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            if (h.this.f21777a == 4) {
                str = "load ima but has destroyed";
            } else {
                Bitmap b2 = com.opos.mobad.n.e.b(dVar.m.f22084a, com.opos.cmn.an.h.f.a.a(h.this.f21785i, 85.0f), com.opos.cmn.an.h.f.a.a(h.this.f21785i, 85.0f));
                Bitmap a2 = com.opos.mobad.n.c.d.a(h.this.f21785i, b2, 75, 0.25f, 56.0f);
                if (a2 != null) {
                    com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.a.h.5.1

                        /* renamed from: a */
                        final /* synthetic */ Bitmap f21794a;

                        /* renamed from: b */
                        final /* synthetic */ Bitmap f21795b;

                        AnonymousClass1(Bitmap b22, Bitmap a22) {
                            b2 = b22;
                            a2 = a22;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.this.f21777a == 4) {
                                com.opos.cmn.an.f.a.b("LogoSplash", "load bitmap but has destroy");
                                return;
                            }
                            a aVar = h.this.f21778b;
                            int p = h.this.p();
                            Bitmap bitmap = b2;
                            com.opos.mobad.n.d.d dVar = dVar;
                            aVar.a(p, bitmap, dVar.f22074f, dVar.f22073e);
                            h.this.f21778b.setVisibility(0);
                            h.this.f21780d.setImageBitmap(a2);
                        }
                    });
                    return;
                }
                str = "null blur bitmap";
            }
            com.opos.cmn.an.f.a.b("LogoSplash", str);
        }
    }

    /* renamed from: com.opos.mobad.n.a.h$6 */
    class AnonymousClass6 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ com.opos.mobad.n.d.d f21797a;

        /* renamed from: com.opos.mobad.n.a.h$6$1 */
        class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ boolean f21799a;

            /* renamed from: b */
            final /* synthetic */ Bitmap f21800b;

            AnonymousClass1(boolean z, Bitmap bitmap) {
                a3 = z;
                a2 = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (h.this.f21777a == 4) {
                    com.opos.cmn.an.f.a.b("LogoSplash", "load ima but has destroyed");
                    return;
                }
                if (a3) {
                    h.this.f21780d.setScaleType(ImageView.ScaleType.MATRIX);
                }
                h.this.f21780d.setImageBitmap(a2);
            }
        }

        AnonymousClass6(com.opos.mobad.n.d.d dVar) {
            dVar = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            if (h.this.f21777a == 4) {
                str = "load ima but has destroyed";
            } else if (dVar.f22075g.get(0) == null) {
                str = "null imgList";
            } else {
                Bitmap a2 = com.opos.mobad.n.e.a(dVar.f22075g.get(0).f22084a, com.opos.cmn.an.h.f.a.b(h.this.f21785i), h.this.f21781e);
                if (a2 != null) {
                    h hVar = h.this;
                    com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.a.h.6.1

                        /* renamed from: a */
                        final /* synthetic */ boolean f21799a;

                        /* renamed from: b */
                        final /* synthetic */ Bitmap f21800b;

                        AnonymousClass1(boolean z, Bitmap a22) {
                            a3 = z;
                            a2 = a22;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.this.f21777a == 4) {
                                com.opos.cmn.an.f.a.b("LogoSplash", "load ima but has destroyed");
                                return;
                            }
                            if (a3) {
                                h.this.f21780d.setScaleType(ImageView.ScaleType.MATRIX);
                            }
                            h.this.f21780d.setImageBitmap(a2);
                        }
                    });
                    return;
                }
                str = "null bitmap";
            }
            com.opos.cmn.an.f.a.b("LogoSplash", str);
        }
    }

    /* renamed from: com.opos.mobad.n.a.h$7 */
    class AnonymousClass7 implements d.a {
        AnonymousClass7() {
        }

        @Override // com.opos.mobad.n.d.a
        public void a(View view, int[] iArr) {
            if (h.this.f21786j != null) {
                h.this.a();
                h.this.f21786j.d(view, iArr);
            }
        }
    }

    private h(Context context, int i2, int i3, m mVar) {
        this.v = m.NONE;
        this.f21785i = context;
        this.v = a(mVar);
        this.m = i3;
        this.l = i2;
        g();
        f();
    }

    public static h a(Context context, int i2, m mVar) {
        return new h(context, i2, 1, mVar);
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
            sensor = ((SensorManager) this.f21785i.getSystemService(am.ac)).getDefaultSensor(1);
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.b("LogoSplash", "check", th);
            sensor = null;
        }
        return sensor == null ? m.NONE : mVar;
    }

    private void a(com.opos.mobad.n.d.d dVar) {
        com.opos.mobad.n.c cVar;
        ViewGroup viewGroup;
        int i2;
        int i3 = this.m;
        if ((i3 == 0 || i3 == 1) && (cVar = dVar.t) != null) {
            View a2 = cVar.a();
            if (a2 == null) {
                return;
            }
            if (a2.getParent() != null) {
                ((ViewGroup) a2.getParent()).removeView(a2);
            }
            this.p.addView(a2);
            viewGroup = this.p;
            i2 = 0;
        } else {
            viewGroup = this.p;
            i2 = 8;
        }
        viewGroup.setVisibility(i2);
    }

    public boolean a(int i2, int i3, int i4, int i5) {
        return i2 * i5 < i3 * i4;
    }

    public static h b(Context context, int i2, m mVar) {
        return new h(context, i2, 4, mVar);
    }

    private void b(com.opos.mobad.n.d.d dVar) {
        if (dVar.m != null) {
            this.f21780d.setScaleType(ImageView.ScaleType.FIT_XY);
            com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.n.a.h.5

                /* renamed from: a */
                final /* synthetic */ com.opos.mobad.n.d.d f21792a;

                /* renamed from: com.opos.mobad.n.a.h$5$1 */
                class AnonymousClass1 implements Runnable {

                    /* renamed from: a */
                    final /* synthetic */ Bitmap f21794a;

                    /* renamed from: b */
                    final /* synthetic */ Bitmap f21795b;

                    AnonymousClass1(Bitmap b22, Bitmap a22) {
                        b2 = b22;
                        a2 = a22;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (h.this.f21777a == 4) {
                            com.opos.cmn.an.f.a.b("LogoSplash", "load bitmap but has destroy");
                            return;
                        }
                        a aVar = h.this.f21778b;
                        int p = h.this.p();
                        Bitmap bitmap = b2;
                        com.opos.mobad.n.d.d dVar = dVar;
                        aVar.a(p, bitmap, dVar.f22074f, dVar.f22073e);
                        h.this.f21778b.setVisibility(0);
                        h.this.f21780d.setImageBitmap(a2);
                    }
                }

                AnonymousClass5(com.opos.mobad.n.d.d dVar2) {
                    dVar = dVar2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    String str;
                    if (h.this.f21777a == 4) {
                        str = "load ima but has destroyed";
                    } else {
                        Bitmap b22 = com.opos.mobad.n.e.b(dVar.m.f22084a, com.opos.cmn.an.h.f.a.a(h.this.f21785i, 85.0f), com.opos.cmn.an.h.f.a.a(h.this.f21785i, 85.0f));
                        Bitmap a22 = com.opos.mobad.n.c.d.a(h.this.f21785i, b22, 75, 0.25f, 56.0f);
                        if (a22 != null) {
                            com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.a.h.5.1

                                /* renamed from: a */
                                final /* synthetic */ Bitmap f21794a;

                                /* renamed from: b */
                                final /* synthetic */ Bitmap f21795b;

                                AnonymousClass1(Bitmap b222, Bitmap a222) {
                                    b2 = b222;
                                    a2 = a222;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    if (h.this.f21777a == 4) {
                                        com.opos.cmn.an.f.a.b("LogoSplash", "load bitmap but has destroy");
                                        return;
                                    }
                                    a aVar = h.this.f21778b;
                                    int p = h.this.p();
                                    Bitmap bitmap = b2;
                                    com.opos.mobad.n.d.d dVar2 = dVar;
                                    aVar.a(p, bitmap, dVar2.f22074f, dVar2.f22073e);
                                    h.this.f21778b.setVisibility(0);
                                    h.this.f21780d.setImageBitmap(a2);
                                }
                            });
                            return;
                        }
                        str = "null blur bitmap";
                    }
                    com.opos.cmn.an.f.a.b("LogoSplash", str);
                }
            });
        }
    }

    public static h c(Context context, int i2, m mVar) {
        return new h(context, i2, 0, mVar);
    }

    private void c(com.opos.mobad.n.d.d dVar) {
        this.f21780d.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f21781e = this.p != null ? com.opos.cmn.an.h.f.a.c(this.f21785i) - q.c(this.f21785i) : com.opos.cmn.an.h.f.a.c(this.f21785i);
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.n.a.h.6

            /* renamed from: a */
            final /* synthetic */ com.opos.mobad.n.d.d f21797a;

            /* renamed from: com.opos.mobad.n.a.h$6$1 */
            class AnonymousClass1 implements Runnable {

                /* renamed from: a */
                final /* synthetic */ boolean f21799a;

                /* renamed from: b */
                final /* synthetic */ Bitmap f21800b;

                AnonymousClass1(boolean z, Bitmap a22) {
                    a3 = z;
                    a2 = a22;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (h.this.f21777a == 4) {
                        com.opos.cmn.an.f.a.b("LogoSplash", "load ima but has destroyed");
                        return;
                    }
                    if (a3) {
                        h.this.f21780d.setScaleType(ImageView.ScaleType.MATRIX);
                    }
                    h.this.f21780d.setImageBitmap(a2);
                }
            }

            AnonymousClass6(com.opos.mobad.n.d.d dVar2) {
                dVar = dVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                String str;
                if (h.this.f21777a == 4) {
                    str = "load ima but has destroyed";
                } else if (dVar.f22075g.get(0) == null) {
                    str = "null imgList";
                } else {
                    Bitmap a22 = com.opos.mobad.n.e.a(dVar.f22075g.get(0).f22084a, com.opos.cmn.an.h.f.a.b(h.this.f21785i), h.this.f21781e);
                    if (a22 != null) {
                        h hVar = h.this;
                        com.opos.mobad.c.b.b.a(new Runnable() { // from class: com.opos.mobad.n.a.h.6.1

                            /* renamed from: a */
                            final /* synthetic */ boolean f21799a;

                            /* renamed from: b */
                            final /* synthetic */ Bitmap f21800b;

                            AnonymousClass1(boolean z, Bitmap a222) {
                                a3 = z;
                                a2 = a222;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                if (h.this.f21777a == 4) {
                                    com.opos.cmn.an.f.a.b("LogoSplash", "load ima but has destroyed");
                                    return;
                                }
                                if (a3) {
                                    h.this.f21780d.setScaleType(ImageView.ScaleType.MATRIX);
                                }
                                h.this.f21780d.setImageBitmap(a2);
                            }
                        });
                        return;
                    }
                    str = "null bitmap";
                }
                com.opos.cmn.an.f.a.b("LogoSplash", str);
            }
        });
    }

    public static h d(Context context, int i2, m mVar) {
        return new h(context, i2, 2, mVar);
    }

    private void d(com.opos.mobad.n.d.d dVar) {
        if (dVar.v != null) {
            b bVar = this.s;
            int p = p();
            com.opos.mobad.n.d.a aVar = dVar.v;
            bVar.a(p, aVar.f22065a, aVar.f22066b);
        }
        if (TextUtils.isEmpty(dVar.l)) {
            return;
        }
        this.f21784h.a(dVar.l, dVar.E, dVar.F);
    }

    public static h e(Context context, int i2, m mVar) {
        return new h(context, i2, 3, mVar);
    }

    private void e(com.opos.mobad.n.d.d dVar) {
        a(dVar);
        if (t()) {
            b(dVar);
        } else {
            c(dVar);
        }
        d(dVar);
        this.q = q.a(dVar, this.n);
        dVar.u.a(new d.a() { // from class: com.opos.mobad.n.a.h.7
            AnonymousClass7() {
            }

            @Override // com.opos.mobad.n.d.a
            public void a(View view, int[] iArr) {
                if (h.this.f21786j != null) {
                    h.this.a();
                    h.this.f21786j.d(view, iArr);
                }
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.f21785i, 22.0f);
        layoutParams.bottomMargin = o();
        this.r = com.opos.mobad.n.e.a(this.k, this.o, layoutParams);
    }

    private void f() {
        com.opos.mobad.c.d.a aVar = new com.opos.mobad.c.d.a(this.f21785i);
        aVar.a(new a.InterfaceC0428a() { // from class: com.opos.mobad.n.a.h.2

            /* renamed from: a */
            final /* synthetic */ com.opos.mobad.c.d.a f21788a;

            AnonymousClass2(com.opos.mobad.c.d.a aVar2) {
                aVar = aVar2;
            }

            @Override // com.opos.mobad.c.d.a.InterfaceC0428a
            public void a(boolean z) {
                if (h.this.k == null) {
                    return;
                }
                if (z && h.this.f21777a == 0) {
                    h.this.b();
                    h.this.f21784h.c();
                    if (h.this.f21786j != null) {
                        h.this.f21786j.b();
                    }
                }
                com.opos.cmn.an.f.a.b("LogoSplash", "splashView onWindowVisibilityChanged：" + z);
                boolean z2 = h.this.u <= 0 || h.this.f21777a == 3;
                if (z && z2) {
                    h.this.r();
                    aVar.a((a.InterfaceC0428a) null);
                }
            }
        });
        this.n.addView(aVar2, new RelativeLayout.LayoutParams(0, 0));
    }

    private void g() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f21785i);
        this.n = relativeLayout;
        relativeLayout.setBackgroundColor(-1);
        n();
        h();
        AnonymousClass3 anonymousClass3 = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.a.h.3
            AnonymousClass3() {
            }

            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                h.this.f21784h.b();
                if (h.this.f21786j != null) {
                    h.this.f21786j.g(view, iArr);
                }
            }
        };
        this.n.setOnClickListener(anonymousClass3);
        this.n.setOnTouchListener(anonymousClass3);
    }

    private void h() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f21785i);
        this.o = relativeLayout;
        relativeLayout.setBackgroundColor(-1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        ViewGroup viewGroup = this.p;
        if (viewGroup != null) {
            layoutParams.addRule(2, viewGroup.getId());
        }
        this.n.addView(this.o, layoutParams);
        if (t()) {
            j();
        } else {
            i();
        }
        k();
        m();
    }

    private void i() {
        this.f21780d = new ImageView(this.f21785i);
        this.o.addView(this.f21780d, new RelativeLayout.LayoutParams(-1, -1));
    }

    private void j() {
        this.f21778b = new a(this.f21785i);
        this.f21780d = new ImageView(this.f21785i);
        this.o.addView(this.f21780d, new RelativeLayout.LayoutParams(-1, -1));
        g gVar = new g(this.f21785i);
        this.f21779c = gVar;
        this.o.addView(gVar);
        this.o.addView(this.f21778b);
    }

    private void k() {
        View frameLayout = new FrameLayout(this.f21785i);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{1711276032, 16777215, 16777215, 1711276032});
        gradientDrawable.setGradientType(0);
        frameLayout.setBackground(gradientDrawable);
        this.o.addView(frameLayout, new RelativeLayout.LayoutParams(-1, -1));
    }

    private void l() {
        f a2 = l.a(this.f21785i, this.v);
        this.f21784h = a2;
        a2.a(new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.a.h.4
            AnonymousClass4() {
            }

            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (h.this.f21786j != null) {
                    h.this.f21786j.f(view, iArr);
                }
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        int i2 = this.m;
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f21785i, i2 != 2 ? (i2 == 3 || i2 == 4) ? 37 : 72 : 79);
        this.o.addView(this.f21784h.a(), layoutParams);
    }

    private void m() {
        l();
        this.s = new b(this.f21785i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        layoutParams.bottomMargin = o();
        this.o.addView(this.s, layoutParams);
    }

    private void n() {
        FrameLayout frameLayout = new FrameLayout(this.f21785i);
        this.p = frameLayout;
        frameLayout.setId(View.generateViewId());
        this.n.addView(this.p, q.b(this.f21785i));
        this.p.setVisibility(0);
    }

    private int o() {
        return com.opos.cmn.an.h.f.a.a(this.f21785i, this.m != 2 ? 15 : 30);
    }

    public int p() {
        return u() ? 1 : 0;
    }

    private void q() {
        this.o.setVisibility(0);
        this.f21784h.a().setVisibility(0);
        this.q.setVisibility(0);
        this.r.setVisibility(0);
    }

    public void r() {
        if (s()) {
            com.opos.cmn.an.f.a.b("LogoSplash", "handleAdClosed");
            a.InterfaceC0458a interfaceC0458a = this.f21786j;
            if (interfaceC0458a != null) {
                long j2 = this.f21783g;
                interfaceC0458a.a(j2, j2);
            }
        }
    }

    private boolean s() {
        View c2 = c();
        return c2 != null && c2.isShown();
    }

    private boolean t() {
        int i2 = this.m;
        return i2 == 1 || i2 == 4;
    }

    private boolean u() {
        int i2 = this.m;
        return i2 == 4 || i2 == 3;
    }

    @Override // com.opos.mobad.n.a
    public void a() {
        if (this.f21777a != 2 && this.f21777a != 4) {
            this.f21777a = 2;
            this.f21782f.a();
            this.f21784h.d();
        } else {
            com.opos.cmn.an.f.a.b("LogoSplash", "current state has stop =" + this.f21777a);
        }
    }

    @Override // com.opos.mobad.n.a
    public void a(a.InterfaceC0458a interfaceC0458a) {
        this.s.a(interfaceC0458a);
        this.f21786j = interfaceC0458a;
    }

    @Override // com.opos.mobad.n.a
    public void a(com.opos.mobad.n.d.h hVar) {
        String str;
        List<com.opos.mobad.n.d.g> list;
        com.opos.mobad.n.d.g gVar;
        com.opos.mobad.n.d.d a2 = hVar.a();
        if (a2 == null || a2.u == null) {
            str = "adShowData is null";
        } else if (t() && ((gVar = a2.m) == null || TextUtils.isEmpty(gVar.f22084a))) {
            str = "iconUrl is null";
        } else {
            if (t() || ((list = a2.f22075g) != null && list.size() > 0)) {
                com.opos.cmn.an.f.a.b("LogoSplash", "render");
                this.k = a2;
                this.t = a2.u;
                long j2 = a2.w;
                this.u = j2;
                if (j2 <= 0) {
                    this.u = 3000L;
                }
                this.f21783g = this.u;
                e(a2);
                return;
            }
            str = "imgList is null";
        }
        com.opos.cmn.an.f.a.b("LogoSplash", str);
        this.f21786j.b(1);
    }

    @Override // com.opos.mobad.n.a
    public void b() {
        q();
        com.opos.cmn.an.f.a.b("LogoSplash", "start countdown...");
        if (this.f21777a != 1 && this.f21777a != 4) {
            this.f21777a = 1;
            this.f21782f.a(0L);
            this.f21784h.e();
        } else {
            com.opos.cmn.an.f.a.b("LogoSplash", "error state" + this.f21777a);
        }
    }

    @Override // com.opos.mobad.n.a
    public View c() {
        return this.n;
    }

    @Override // com.opos.mobad.n.a
    public void d() {
        com.opos.cmn.an.f.a.b("LogoSplash", "destroy");
        this.f21784h.f();
        a();
        this.k = null;
        this.f21777a = 4;
        this.f21782f.a();
        this.f21782f.b();
    }

    @Override // com.opos.mobad.n.a
    public int e() {
        return this.l;
    }
}
