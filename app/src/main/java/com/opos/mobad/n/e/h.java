package com.opos.mobad.n.e;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.c.d.a;
import com.opos.mobad.n.a;
import com.opos.mobad.n.a.q;
import com.opos.mobad.n.d;

/* loaded from: classes4.dex */
public class h extends com.opos.mobad.n.i.a {

    /* renamed from: a */
    com.opos.mobad.c.d.a f22111a;

    /* renamed from: d */
    private Context f22112d;

    /* renamed from: e */
    private com.opos.mobad.n.d.b f22113e;

    /* renamed from: f */
    private View f22114f;

    /* renamed from: g */
    private FrameLayout f22115g;

    /* renamed from: h */
    private com.opos.mobad.c.b.c f22116h;

    /* renamed from: i */
    private long f22117i;

    /* renamed from: j */
    private RelativeLayout f22118j;
    private a k;
    private com.opos.mobad.n.d l;
    private long m;
    private ViewGroup n;
    private View o;
    private ImageView p;
    private boolean q;
    private Drawable r;
    private Drawable s;
    private long t;
    private Runnable u;
    private a.InterfaceC0458a v;

    /* renamed from: com.opos.mobad.n.e.h$1 */
    class AnonymousClass1 implements d.a {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.n.d.a
        public void a(View view, int[] iArr) {
            if (h.this.v != null) {
                h.this.a();
                h.this.a(view, iArr);
            }
        }
    }

    /* renamed from: com.opos.mobad.n.e.h$2 */
    class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (h.this.o() == 8) {
                return;
            }
            com.opos.cmn.an.f.a.b("SplashDyTemplate", "countdown=" + h.this.m + "," + h.this.o());
            if (h.this.o() <= 2) {
                h.this.f22116h.a(1000L);
                return;
            }
            long j2 = h.this.m;
            h hVar = h.this;
            if (j2 <= 0) {
                hVar.r();
                return;
            }
            hVar.f22116h.a(1000L);
            if (h.this.l != null) {
                h.this.l.a((int) (h.this.m / 1000));
            }
            h hVar2 = h.this;
            hVar2.c(hVar2.f22117i - h.this.m, h.this.t);
            h.this.m -= 1000;
        }
    }

    /* renamed from: com.opos.mobad.n.e.h$3 */
    class AnonymousClass3 implements View.OnClickListener {
        AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h.this.i();
        }
    }

    /* renamed from: com.opos.mobad.n.e.h$4 */
    class AnonymousClass4 implements a.InterfaceC0428a {
        AnonymousClass4() {
        }

        @Override // com.opos.mobad.c.d.a.InterfaceC0428a
        public void a(boolean z) {
            com.opos.cmn.an.f.a.b("SplashDyTemplate", "visible change:" + z);
            h hVar = h.this;
            if (z) {
                hVar.n();
                h.this.k();
            } else {
                hVar.l();
            }
            boolean z2 = true;
            if (h.this.m > 0 && h.this.o() != 1) {
                z2 = false;
            }
            if (z && z2) {
                h.this.r();
                h.this.f22111a.a((a.InterfaceC0428a) null);
            }
        }
    }

    /* renamed from: com.opos.mobad.n.e.h$5 */
    class AnonymousClass5 implements a.InterfaceC0458a {
        AnonymousClass5() {
        }

        @Override // com.opos.mobad.n.a.InterfaceC0458a
        public void a(int i2, String str) {
            h.this.a(i2, str);
        }

        @Override // com.opos.mobad.n.a.InterfaceC0458a
        public void a(long j2, long j3) {
        }

        @Override // com.opos.mobad.n.a.InterfaceC0458a
        public void a(View view, int[] iArr) {
            h.this.h(view, iArr);
        }

        @Override // com.opos.mobad.n.a.InterfaceC0458a
        public void a(View view, int[] iArr, boolean z) {
        }

        @Override // com.opos.mobad.n.a.InterfaceC0458a
        public void b() {
        }

        @Override // com.opos.mobad.n.a.InterfaceC0458a
        public void b(int i2) {
            h.this.a(i2);
        }

        @Override // com.opos.mobad.n.a.InterfaceC0458a
        public void b(long j2, long j3) {
        }

        @Override // com.opos.mobad.n.a.InterfaceC0458a
        public void b(View view, int[] iArr) {
            h.this.c(view, iArr);
        }

        @Override // com.opos.mobad.n.a.InterfaceC0458a
        public void c(int i2) {
        }

        @Override // com.opos.mobad.n.a.InterfaceC0458a
        public void c(long j2, long j3) {
        }

        @Override // com.opos.mobad.n.a.InterfaceC0458a
        public void c(View view, int[] iArr) {
            h.this.b(view, iArr);
        }

        @Override // com.opos.mobad.n.a.InterfaceC0458a
        public void d(long j2, long j3) {
        }

        @Override // com.opos.mobad.n.a.InterfaceC0458a
        public void d(View view, int[] iArr) {
            h.this.a(view, iArr);
        }

        @Override // com.opos.mobad.n.a.InterfaceC0458a
        public void e() {
            h.this.m();
            h.this.q();
            h.this.t();
        }

        @Override // com.opos.mobad.n.a.InterfaceC0458a
        public void e(View view, int[] iArr) {
            h.this.d(view, iArr);
        }

        @Override // com.opos.mobad.n.a.InterfaceC0458a
        public void f(View view, int[] iArr) {
            h.this.d(view, iArr);
        }

        @Override // com.opos.mobad.n.a.InterfaceC0458a
        public void g(View view, int[] iArr) {
            h.this.e(view, iArr);
        }

        @Override // com.opos.mobad.n.a.InterfaceC0458a
        public void h(View view, int[] iArr) {
            h.this.g(view, iArr);
        }

        @Override // com.opos.mobad.n.a.InterfaceC0458a
        public void i(View view, int[] iArr) {
        }

        @Override // com.opos.mobad.n.a.InterfaceC0458a
        public void j(View view, int[] iArr) {
        }

        @Override // com.opos.mobad.n.a.InterfaceC0458a
        public void k(View view, int[] iArr) {
        }
    }

    public h(Context context, int i2) {
        super(i2);
        this.q = false;
        this.u = new Runnable() { // from class: com.opos.mobad.n.e.h.2
            AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (h.this.o() == 8) {
                    return;
                }
                com.opos.cmn.an.f.a.b("SplashDyTemplate", "countdown=" + h.this.m + "," + h.this.o());
                if (h.this.o() <= 2) {
                    h.this.f22116h.a(1000L);
                    return;
                }
                long j2 = h.this.m;
                h hVar = h.this;
                if (j2 <= 0) {
                    hVar.r();
                    return;
                }
                hVar.f22116h.a(1000L);
                if (h.this.l != null) {
                    h.this.l.a((int) (h.this.m / 1000));
                }
                h hVar2 = h.this;
                hVar2.c(hVar2.f22117i - h.this.m, h.this.t);
                h.this.m -= 1000;
            }
        };
        this.v = new a.InterfaceC0458a() { // from class: com.opos.mobad.n.e.h.5
            AnonymousClass5() {
            }

            @Override // com.opos.mobad.n.a.InterfaceC0458a
            public void a(int i22, String str) {
                h.this.a(i22, str);
            }

            @Override // com.opos.mobad.n.a.InterfaceC0458a
            public void a(long j2, long j3) {
            }

            @Override // com.opos.mobad.n.a.InterfaceC0458a
            public void a(View view, int[] iArr) {
                h.this.h(view, iArr);
            }

            @Override // com.opos.mobad.n.a.InterfaceC0458a
            public void a(View view, int[] iArr, boolean z) {
            }

            @Override // com.opos.mobad.n.a.InterfaceC0458a
            public void b() {
            }

            @Override // com.opos.mobad.n.a.InterfaceC0458a
            public void b(int i22) {
                h.this.a(i22);
            }

            @Override // com.opos.mobad.n.a.InterfaceC0458a
            public void b(long j2, long j3) {
            }

            @Override // com.opos.mobad.n.a.InterfaceC0458a
            public void b(View view, int[] iArr) {
                h.this.c(view, iArr);
            }

            @Override // com.opos.mobad.n.a.InterfaceC0458a
            public void c(int i22) {
            }

            @Override // com.opos.mobad.n.a.InterfaceC0458a
            public void c(long j2, long j3) {
            }

            @Override // com.opos.mobad.n.a.InterfaceC0458a
            public void c(View view, int[] iArr) {
                h.this.b(view, iArr);
            }

            @Override // com.opos.mobad.n.a.InterfaceC0458a
            public void d(long j2, long j3) {
            }

            @Override // com.opos.mobad.n.a.InterfaceC0458a
            public void d(View view, int[] iArr) {
                h.this.a(view, iArr);
            }

            @Override // com.opos.mobad.n.a.InterfaceC0458a
            public void e() {
                h.this.m();
                h.this.q();
                h.this.t();
            }

            @Override // com.opos.mobad.n.a.InterfaceC0458a
            public void e(View view, int[] iArr) {
                h.this.d(view, iArr);
            }

            @Override // com.opos.mobad.n.a.InterfaceC0458a
            public void f(View view, int[] iArr) {
                h.this.d(view, iArr);
            }

            @Override // com.opos.mobad.n.a.InterfaceC0458a
            public void g(View view, int[] iArr) {
                h.this.e(view, iArr);
            }

            @Override // com.opos.mobad.n.a.InterfaceC0458a
            public void h(View view, int[] iArr) {
                h.this.g(view, iArr);
            }

            @Override // com.opos.mobad.n.a.InterfaceC0458a
            public void i(View view, int[] iArr) {
            }

            @Override // com.opos.mobad.n.a.InterfaceC0458a
            public void j(View view, int[] iArr) {
            }

            @Override // com.opos.mobad.n.a.InterfaceC0458a
            public void k(View view, int[] iArr) {
            }
        };
        this.f22112d = context;
        this.f22116h = new com.opos.mobad.c.b.c(com.opos.mobad.c.b.b.a(), this.u);
        a aVar = new a(context, i2);
        this.k = aVar;
        aVar.a(this.v);
        a(context);
    }

    private void a(Context context) {
        this.f22118j = new RelativeLayout(context);
        this.f22115g = new FrameLayout(context);
    }

    private void a(com.opos.mobad.n.d.b bVar, com.opos.mobad.n.d.h hVar) {
        this.l = bVar.u;
        if (this.f22113e == null) {
            long j2 = bVar.w;
            this.m = j2;
            if (j2 <= 0) {
                this.m = 3000L;
            }
            long j3 = this.m;
            this.f22117i = j3;
            this.t = j3;
        }
    }

    private void a(com.opos.mobad.n.d.d dVar) {
        this.f22118j.setBackgroundColor(-1);
        com.opos.mobad.n.d dVar2 = dVar.u;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (b(dVar)) {
            FrameLayout frameLayout = new FrameLayout(this.f22112d);
            this.n = frameLayout;
            frameLayout.setId(View.generateViewId());
            ViewGroup.LayoutParams b2 = q.b(this.f22112d);
            this.n.setVisibility(0);
            this.f22118j.addView(this.n, b2);
            View a2 = dVar.t.a();
            if (a2 != null) {
                if (a2.getParent() != null) {
                    ((ViewGroup) a2.getParent()).removeView(a2);
                }
                this.n.addView(a2);
            }
            layoutParams.addRule(2, this.n.getId());
        }
        this.f22118j.addView(this.f22115g, layoutParams);
        View a3 = dVar.u.a();
        this.o = a3;
        this.f22118j.addView(this.o, q.a(this.f22112d, dVar, a3));
        this.o.setVisibility(4);
        dVar2.a(new d.a() { // from class: com.opos.mobad.n.e.h.1
            AnonymousClass1() {
            }

            @Override // com.opos.mobad.n.d.a
            public void a(View view, int[] iArr) {
                if (h.this.v != null) {
                    h.this.a();
                    h.this.a(view, iArr);
                }
            }
        });
        if (s()) {
            com.opos.cmn.an.f.a.b("SplashDyTemplate", "is video splash");
            b(this.f22112d);
            this.f22118j.addView(this.p, q.a(dVar, this.f22112d));
        }
    }

    private void a(com.opos.mobad.n.d.d dVar, com.opos.mobad.n.d.h hVar) {
        if (this.f22113e != null) {
            return;
        }
        this.k.a(hVar);
        View c2 = this.k.c();
        this.f22114f = c2;
        this.f22115g.addView(c2, new RelativeLayout.LayoutParams(-1, -1));
        a(dVar);
    }

    private void b(Context context) {
        if (s()) {
            ImageView imageView = new ImageView(context);
            this.p = imageView;
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            this.r = this.f22112d.getResources().getDrawable(R.drawable.opos_mobad_drawable_sound_off);
            this.s = this.f22112d.getResources().getDrawable(R.drawable.opos_mobad_drawable_sound_on);
            int a2 = com.opos.cmn.an.h.f.a.a(this.f22112d, 6.0f);
            int a3 = com.opos.cmn.an.h.f.a.a(this.f22112d, 7.0f);
            this.p.setPadding(a2, a3, a2, a3);
            this.p.setImageDrawable(this.r);
            this.p.setOnClickListener(new View.OnClickListener() { // from class: com.opos.mobad.n.e.h.3
                AnonymousClass3() {
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    h.this.i();
                }
            });
            this.p.setVisibility(4);
        }
    }

    private boolean b(com.opos.mobad.n.d.d dVar) {
        return (dVar == null || dVar.t == null) ? false : true;
    }

    public void q() {
        View view = this.o;
        if (view != null) {
            view.setVisibility(0);
        }
        ImageView imageView = this.p;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        this.f22114f.setVisibility(0);
    }

    public void r() {
        if (this.f22118j.isShown()) {
            com.opos.cmn.an.f.a.b("SplashDyTemplate", "handleAdClosed");
            this.f22116h.a();
            p();
        }
    }

    private boolean s() {
        com.opos.mobad.n.d.b bVar = this.f22113e;
        return (bVar == null || bVar.f22068b == null) ? false : true;
    }

    public void t() {
        if (this.f22111a == null) {
            com.opos.mobad.c.d.a aVar = new com.opos.mobad.c.d.a(this.f22112d);
            this.f22111a = aVar;
            aVar.a(new a.InterfaceC0428a() { // from class: com.opos.mobad.n.e.h.4
                AnonymousClass4() {
                }

                @Override // com.opos.mobad.c.d.a.InterfaceC0428a
                public void a(boolean z) {
                    com.opos.cmn.an.f.a.b("SplashDyTemplate", "visible change:" + z);
                    h hVar = h.this;
                    if (z) {
                        hVar.n();
                        h.this.k();
                    } else {
                        hVar.l();
                    }
                    boolean z2 = true;
                    if (h.this.m > 0 && h.this.o() != 1) {
                        z2 = false;
                    }
                    if (z && z2) {
                        h.this.r();
                        h.this.f22111a.a((a.InterfaceC0428a) null);
                    }
                }
            });
        }
        if (this.f22115g.indexOfChild(this.f22111a) < 0) {
            this.f22115g.addView(this.f22111a, new ViewGroup.LayoutParams(0, 0));
        }
    }

    @Override // com.opos.mobad.n.a
    public void a(com.opos.mobad.n.d.h hVar) {
        com.opos.mobad.n.d.b d2 = hVar.d();
        if (d2 == null) {
            com.opos.cmn.an.f.a.b("SplashDyTemplate", "adShowData is null");
            a(1);
        } else {
            com.opos.cmn.an.f.a.b("SplashDyTemplate", "render");
            a(d2, hVar);
            a((com.opos.mobad.n.d.d) d2, hVar);
            this.f22113e = d2;
        }
    }

    @Override // com.opos.mobad.n.a
    public View c() {
        return this.f22118j;
    }

    @Override // com.opos.mobad.n.i.a
    public boolean f() {
        a aVar = this.k;
        if (aVar == null) {
            return false;
        }
        aVar.a();
        this.f22116h.a();
        return true;
    }

    @Override // com.opos.mobad.n.i.a
    public boolean g() {
        a aVar = this.k;
        if (aVar == null) {
            return false;
        }
        aVar.b();
        this.f22116h.a(0L);
        return true;
    }

    @Override // com.opos.mobad.n.i.a
    protected void h() {
        com.opos.cmn.an.f.a.b("SplashDyTemplate", "destroy");
        this.f22118j.removeAllViews();
        a aVar = this.k;
        if (aVar != null) {
            aVar.d();
        }
        this.f22116h.a();
        this.f22116h.b();
    }

    public void i() {
        this.q = !this.q;
        com.opos.cmn.an.f.a.b("SplashDyTemplate", "VolumeSwitchIconClicked: " + this.q);
        ImageView imageView = this.p;
        if (imageView != null) {
            imageView.setImageDrawable(this.q ? this.s : this.r);
        }
        a aVar = this.k;
        if (aVar != null) {
            aVar.a(!this.q);
        }
    }
}
