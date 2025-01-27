package com.vivo.mobilead.unified.banner;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.vivo.ad.model.AdError;
import com.vivo.ad.model.w;
import com.vivo.mobilead.i.m;
import com.vivo.mobilead.model.a;
import com.vivo.mobilead.unified.base.AdParams;
import com.vivo.mobilead.unified.base.VivoAdError;
import com.vivo.mobilead.util.VOpenLog;
import com.vivo.mobilead.util.i;
import com.vivo.mobilead.util.j;
import com.vivo.mobilead.util.k0;
import com.vivo.mobilead.util.n;
import com.vivo.mobilead.util.u;
import com.vivo.mobilead.util.y0;
import com.vivo.mobilead.util.z;

/* loaded from: classes4.dex */
public class b extends com.vivo.mobilead.unified.a {
    private static final String M = "b";
    private int A;
    private boolean B;
    private int C;
    private int D;
    private float E;
    private com.vivo.ad.model.b F;
    private com.vivo.ad.model.b G;
    private ViewTreeObserver.OnPreDrawListener H;
    private View.OnAttachStateChangeListener I;
    private com.vivo.mobilead.unified.base.callback.b J;
    private ViewTreeObserver.OnWindowFocusChangeListener K;
    private Runnable L;
    protected UnifiedVivoBannerAdListener t;
    protected Activity u;
    protected com.vivo.mobilead.unified.base.view.p.d v;
    private boolean w;
    private boolean x;
    private boolean y;
    private long z;

    class a implements ViewTreeObserver.OnPreDrawListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (b.this.v.isShown() && !b.this.w) {
                b.this.w = true;
                b bVar = b.this;
                bVar.a(bVar.G, b.this.v);
                com.vivo.ad.model.e c2 = b.this.G.c();
                if (c2 != null) {
                    int e2 = c2.e();
                    if (e2 == 1) {
                        b.this.v.a();
                    }
                    b bVar2 = b.this;
                    bVar2.a((ViewGroup) bVar2.v.getParent(), e2);
                }
                b.this.q();
            }
            return true;
        }
    }

    /* renamed from: com.vivo.mobilead.unified.banner.b$b */
    class ViewOnAttachStateChangeListenerC0608b implements View.OnAttachStateChangeListener {
        ViewOnAttachStateChangeListenerC0608b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            b.this.v.getViewTreeObserver().addOnWindowFocusChangeListener(b.this.K);
            b.this.v.getViewTreeObserver().addOnPreDrawListener(b.this.H);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            b.this.v.removeOnAttachStateChangeListener(this);
            b.this.v.getViewTreeObserver().removeOnWindowFocusChangeListener(b.this.K);
            b.this.v.getViewTreeObserver().removeOnPreDrawListener(b.this.H);
        }
    }

    class d implements ViewTreeObserver.OnWindowFocusChangeListener {
        d() {
        }

        @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
        public void onWindowFocusChanged(boolean z) {
            b.this.B = z;
        }
    }

    class e extends com.vivo.mobilead.util.f1.b {
        e() {
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            if (b.this.x) {
                return;
            }
            if (!j.a(((com.vivo.mobilead.unified.a) b.this).f29661a, b.this.v) || !b.this.B) {
                b.this.z = 5000L;
                b.this.q();
            } else {
                b.this.z = r0.A;
                b.this.y = true;
                b.this.l();
            }
        }
    }

    public b(Activity activity, AdParams adParams) {
        super(activity, adParams);
        this.w = false;
        this.x = false;
        this.y = false;
        this.z = com.vivo.mobilead.manager.b.l().b() * 1000;
        this.A = com.vivo.mobilead.manager.b.l().b() * 1000;
        this.B = true;
        this.H = new a();
        this.I = new ViewOnAttachStateChangeListenerC0608b();
        this.J = new c();
        this.K = new d();
        this.L = new e();
        this.u = activity;
        if (adParams.getRefreshIntervalSeconds() > this.A) {
            this.A = adParams.getRefreshIntervalSeconds();
        }
    }

    private boolean p() {
        return this.f29661a.getResources().getConfiguration().orientation == 1;
    }

    public void q() {
        z.b().a().removeCallbacks(this.L);
        z.b().a().postDelayed(this.L, this.z);
    }

    @Override // com.vivo.mobilead.unified.a
    protected void c() {
    }

    @Override // com.vivo.mobilead.unified.a
    protected int f() {
        return 3;
    }

    @Override // com.vivo.mobilead.unified.a
    protected String k() {
        return "2";
    }

    protected void o() {
        if (this.t != null) {
            RelativeLayout relativeLayout = new RelativeLayout(this.f29661a);
            relativeLayout.addView(this.v);
            this.t.onAdReady(relativeLayout);
        }
    }

    class c implements com.vivo.mobilead.unified.base.callback.b {
        c() {
        }

        @Override // com.vivo.mobilead.unified.base.callback.b
        public void a(int i2, int i3, int i4, int i5) {
            if (com.vivo.mobilead.util.c.a(((com.vivo.mobilead.unified.a) b.this).f29666f)) {
                b bVar = b.this;
                bVar.a(bVar.G, i2, i3, i4, i5, false, 0.0d, 0.0d);
            }
        }

        @Override // com.vivo.mobilead.unified.base.callback.b
        public void b(int i2, int i3, int i4, int i5) {
            b bVar = b.this;
            bVar.a(bVar.G, i2, i3, i4, i5, true, 0.0d, 0.0d);
        }

        @Override // com.vivo.mobilead.unified.base.callback.b
        public void a() {
            b bVar = b.this;
            bVar.c(bVar.G);
            b.this.d();
        }
    }

    protected void d(@NonNull AdError adError) {
        UnifiedVivoBannerAdListener unifiedVivoBannerAdListener = this.t;
        if (unifiedVivoBannerAdListener != null) {
            unifiedVivoBannerAdListener.onAdFailed(new VivoAdError(adError.getErrorCode(), adError.getErrorMsg()));
        }
    }

    private void b(com.vivo.ad.model.b bVar, int i2) {
        if (bVar == null || bVar.a() == null || bVar.a().d()) {
            return;
        }
        bVar.a().b(true);
        k0.a(bVar, this.f29662b.getSourceAppend(), k(), -1, -1, i2);
    }

    public void c(com.vivo.ad.model.b bVar) {
        UnifiedVivoBannerAdListener unifiedVivoBannerAdListener = this.t;
        if (unifiedVivoBannerAdListener != null) {
            unifiedVivoBannerAdListener.onAdClose();
        }
        b(bVar, 4);
        d();
    }

    @Override // com.vivo.mobilead.unified.a
    public void d() {
        this.w = false;
        this.x = true;
        this.y = false;
        com.vivo.mobilead.unified.base.view.p.d dVar = this.v;
        if (dVar != null) {
            dVar.removeOnAttachStateChangeListener(this.I);
            this.v.getViewTreeObserver().removeOnPreDrawListener(this.H);
            this.v.getViewTreeObserver().removeOnWindowFocusChangeListener(this.K);
            this.v.setBannerClickListener(null);
            this.v.setVisibility(8);
            this.v = null;
        }
        z.b().a().removeCallbacks(this.L);
    }

    @Override // com.vivo.mobilead.unified.a
    protected boolean a(long j2) {
        y0.a(this.f29666f, (m) null);
        return super.a(j2);
    }

    @Override // com.vivo.mobilead.unified.a, com.vivo.mobilead.unified.base.callback.f
    public void a(@NonNull com.vivo.ad.model.b bVar) {
        super.a(bVar);
        this.F = this.G;
        this.G = bVar;
        this.w = false;
        if (this.v == null) {
            if (bVar.F() == 32) {
                this.v = new com.vivo.mobilead.unified.base.view.p.b(this.f29661a);
            } else {
                this.v = new com.vivo.mobilead.unified.base.view.b(this.f29661a, true);
            }
            this.C = this.v.getDefaultWidth();
            int defaultHeight = this.v.getDefaultHeight();
            this.D = defaultHeight;
            this.E = defaultHeight / this.C;
            this.v.setSourceAppend(this.f29662b.getSourceAppend());
            this.v.addOnAttachStateChangeListener(this.I);
            this.v.setBannerClickListener(this.J);
        }
        this.v.a(this.G, i.a("#E6FFFFFF"));
        if (!this.y) {
            o();
        } else {
            b(this.F, 5);
        }
    }

    @Override // com.vivo.mobilead.unified.a, com.vivo.mobilead.unified.base.callback.j
    public void a(@NonNull AdError adError) {
        super.a(adError);
        if (!this.y) {
            d(adError);
        } else {
            q();
        }
    }

    public void a(@NonNull ViewGroup viewGroup, int i2) {
        int a2 = a(viewGroup);
        if (a2 == 1) {
            if (i2 == 1 && p()) {
                this.v.b();
                return;
            }
            return;
        }
        if (a2 == 2) {
            if (i2 == 1) {
                VOpenLog.e(M, "banner容器不符合规范！");
            }
            k0.a(this.G, 1, this.f29662b.getSourceAppend());
        }
    }

    private int a(ViewGroup viewGroup) {
        int[] b2 = n.b(viewGroup);
        int[] a2 = n.a(viewGroup);
        if (a2 != null && a2.length > 1 && b2 != null && b2.length > 1) {
            int abs = Math.abs(a2[0] - b2[0]);
            int abs2 = Math.abs(a2[1] - b2[1]);
            if (abs2 == 0 || abs == 0) {
                return 0;
            }
            float f2 = abs2;
            float f3 = abs;
            if (f2 / f3 != 0.0f && Math.abs(r5 - this.E) / r5 > 0.07d) {
                return 2;
            }
            float abs3 = Math.abs(abs - this.C) / f3;
            float abs4 = Math.abs(abs2 - this.D) / f2;
            if (abs3 > 0.5d || abs4 > 0.5d) {
                return 2;
            }
            if (this.C == abs && this.D == abs2) {
                return 0;
            }
        }
        return 1;
    }

    public void a(UnifiedVivoBannerAdListener unifiedVivoBannerAdListener) {
        this.t = unifiedVivoBannerAdListener;
    }

    protected void a(com.vivo.ad.model.b bVar, int i2, int i3, int i4, int i5, boolean z, double d2, double d3) {
        boolean a2 = com.vivo.mobilead.util.e.a(z, bVar);
        int a3 = u.a(this.f29661a, bVar, a2, z, this.f29662b.getSourceAppend(), k(), this.f29662b.getBackUrlInfo(), 1, this.f29668h);
        if (this.t == null || bVar == null) {
            return;
        }
        w wVar = new w(bVar.b());
        wVar.a(d2);
        wVar.b(d3);
        k0.a(bVar, z, i2, i3, i4, i5, k(), a3, this.f29662b.getSourceAppend(), 1, a2);
        if (!bVar.a().c()) {
            k0.a(bVar, a.EnumC0603a.CLICK, i2, i3, i4, i5, wVar, -999, -999, -999, -999, this.f29662b.getSourceAppend());
            bVar.a().a(true);
        }
        this.t.onAdClick();
    }

    protected void a(com.vivo.ad.model.b bVar, View view) {
        int i2;
        int i3;
        int i4;
        int i5;
        if (this.t == null || bVar == null || view == null) {
            return;
        }
        int[] a2 = n.a(view);
        int[] b2 = n.b(view);
        if (a2.length <= 1 || b2.length <= 1) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            int i6 = a2[0];
            int i7 = a2[1];
            int i8 = b2[0];
            i3 = i7;
            i5 = b2[1];
            i2 = i6;
            i4 = i8;
        }
        k0.a(bVar, i2, i3, i4, i5, k(), this.f29662b.getSourceAppend(), 1);
        if (!bVar.a().f()) {
            bVar.a().d(true);
            k0.a(bVar, a.EnumC0603a.SHOW, -999, -999, -999, -999, i2, i3, i4, i5, this.f29662b.getSourceAppend());
        }
        this.t.onAdShow();
    }
}
