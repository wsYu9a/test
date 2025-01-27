package com.vivo.mobilead.unified.base.view.t;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.vivo.mobilead.j.c;
import com.vivo.mobilead.model.BackUrlInfo;
import com.vivo.mobilead.model.a;
import com.vivo.mobilead.unified.base.VivoAdError;
import com.vivo.mobilead.unified.base.callback.MediaListener;
import com.vivo.mobilead.unified.reward.UnifiedVivoRewardVideoAdListener;
import com.vivo.mobilead.util.j;
import com.vivo.mobilead.util.k0;
import com.vivo.mobilead.util.m;
import com.vivo.mobilead.util.q;
import com.vivo.mobilead.util.u;
import com.vivo.mobilead.util.u0;

/* loaded from: classes4.dex */
public class d extends com.vivo.mobilead.unified.base.view.t.c {

    /* renamed from: a */
    private com.vivo.mobilead.unified.base.view.r.d f30144a;

    /* renamed from: b */
    private g f30145b;

    /* renamed from: c */
    private com.vivo.mobilead.unified.base.view.r.c f30146c;

    /* renamed from: d */
    private int f30147d;

    /* renamed from: e */
    private int f30148e;

    /* renamed from: f */
    private UnifiedVivoRewardVideoAdListener f30149f;

    /* renamed from: g */
    private MediaListener f30150g;

    /* renamed from: h */
    private com.vivo.ad.model.b f30151h;

    /* renamed from: i */
    private String f30152i;

    /* renamed from: j */
    private int f30153j;
    private int k;
    private volatile boolean l;
    private volatile boolean m;
    private volatile boolean n;
    private volatile boolean o;
    private volatile boolean p;
    private volatile boolean q;
    private BackUrlInfo r;
    private int s;
    private boolean t;
    private ViewTreeObserver.OnPreDrawListener u;
    private com.vivo.mobilead.unified.base.callback.e v;

    class b implements ViewTreeObserver.OnPreDrawListener {
        b() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (!d.this.p && d.this.isShown()) {
                d.this.p = true;
                if (d.this.f30149f != null) {
                    d.this.f30149f.onAdShow();
                }
                k0.a(d.this.f30151h, d.this.f30145b.getIconStatus(), d.this.f30152i, d.this.f30151h.i(), c.a.f28912a + "", d.this.k, -999);
                u0.a(d.this.f30151h, a.EnumC0603a.SHOW, d.this.f30152i);
            }
            return true;
        }
    }

    class c implements com.vivo.mobilead.unified.base.callback.h {
        c() {
        }

        @Override // com.vivo.mobilead.unified.base.callback.h
        public void a(View view, float f2, float f3, float f4, float f5) {
            boolean c2 = com.vivo.mobilead.util.e.c(d.this.f30151h);
            d.this.a(u.a(d.this.getContext(), d.this.f30151h, c2, true, d.this.f30152i, d.this.f30151h.i(), d.this.r, d.this.k, d.this.s), (int) f2, (int) f3, (int) f4, (int) f5, 5, 2, c2);
            if (d.this.f30149f != null) {
                d.this.f30149f.onAdClick();
            }
        }
    }

    /* renamed from: com.vivo.mobilead.unified.base.view.t.d$d */
    class C0636d extends com.vivo.mobilead.unified.base.callback.e {
        C0636d() {
        }

        @Override // com.vivo.mobilead.d.a
        public void a() {
        }

        @Override // com.vivo.mobilead.unified.base.callback.k
        public void c() {
            d.this.g();
        }

        @Override // com.vivo.mobilead.unified.base.callback.k
        public void d(int i2, int i3) {
        }

        @Override // com.vivo.mobilead.unified.base.callback.k
        public void e() {
            d.this.f();
        }

        @Override // com.vivo.mobilead.unified.base.callback.k
        public void f() {
            d.this.n = !r0.n;
            d.this.f30144a.setMute(d.this.n);
        }

        @Override // com.vivo.mobilead.unified.base.callback.k
        public void g() {
            d.this.o = false;
            d.this.f();
        }

        @Override // com.vivo.mobilead.unified.base.callback.k
        public void i() {
            d.this.o = true;
            d.this.e();
        }

        @Override // com.vivo.mobilead.unified.base.callback.k
        public void j() {
            if (d.this.l) {
                d.this.g();
            } else if (d.this.m) {
                d.this.g();
            } else {
                d.this.f30145b.d();
            }
        }
    }

    class e implements DialogInterface.OnDismissListener {
        e() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            d.this.o = false;
            d.this.f();
        }
    }

    class f implements DialogInterface.OnShowListener {
        f() {
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            d.this.o = true;
            d.this.e();
        }
    }

    public d(Context context) {
        this(context, null);
    }

    @Override // com.vivo.mobilead.unified.base.view.t.c
    public void d() {
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnPreDrawListener(this.u);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnPreDrawListener(this.u);
    }

    @Override // com.vivo.mobilead.unified.base.view.t.c
    public void setMediaListener(MediaListener mediaListener) {
        this.f30150g = mediaListener;
    }

    @Override // com.vivo.mobilead.unified.base.view.t.c
    public void setRewardVideoAdListener(UnifiedVivoRewardVideoAdListener unifiedVivoRewardVideoAdListener) {
        this.f30149f = unifiedVivoRewardVideoAdListener;
    }

    public d(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void g() {
        h();
        UnifiedVivoRewardVideoAdListener unifiedVivoRewardVideoAdListener = this.f30149f;
        if (unifiedVivoRewardVideoAdListener != null) {
            unifiedVivoRewardVideoAdListener.onAdClose();
        }
        com.vivo.ad.model.b bVar = this.f30151h;
        k0.a(bVar, this.f30152i, bVar.i(), 5, 0, 6);
    }

    private void h() {
        Context context = getContext();
        if (context instanceof Activity) {
            ((Activity) context).finish();
        }
    }

    @Override // com.vivo.mobilead.unified.base.view.t.c
    public void f() {
        com.vivo.mobilead.unified.base.view.r.d dVar;
        if (this.o || (dVar = this.f30144a) == null) {
            return;
        }
        dVar.c();
        this.t = false;
    }

    public d(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f30147d = 12;
        this.f30148e = 15;
        this.f30153j = 0;
        this.k = 0;
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = false;
        this.t = false;
        this.u = new b();
        this.v = new C0636d();
        new e();
        new f();
        a(context);
    }

    @Override // com.vivo.mobilead.unified.base.view.t.c
    public void c() {
        com.vivo.mobilead.unified.base.view.r.d dVar = this.f30144a;
        if (dVar != null) {
            dVar.destroy();
        }
        getViewTreeObserver().removeOnPreDrawListener(this.u);
    }

    @Override // com.vivo.mobilead.unified.base.view.t.c
    public void e() {
        com.vivo.mobilead.unified.base.view.r.d dVar = this.f30144a;
        if (dVar != null) {
            dVar.b();
            this.t = true;
        }
    }

    class a implements com.vivo.mobilead.unified.base.view.r.b {
        a() {
        }

        @Override // com.vivo.mobilead.unified.base.view.r.b
        public void a(String str) {
            d.this.l = false;
            if (!d.this.isShown() || d.this.t || d.this.f30144a.a()) {
                return;
            }
            d.this.f30145b.a(d.this.f30148e, 0);
            d.this.f30144a.c();
        }

        @Override // com.vivo.mobilead.unified.base.view.r.b
        public void b() {
            d.this.f30153j++;
            if (d.this.f30153j < d.this.f30148e || d.this.m) {
                d.this.f30145b.a(d.this.f30148e, d.this.f30153j);
            } else {
                d.this.m = true;
                if (d.this.f30149f != null) {
                    d.this.f30149f.onRewardVerify();
                }
                d.this.f30145b.c();
                d.this.f30144a.d();
            }
            if (d.this.f30153j >= d.this.f30147d) {
                d.this.f30145b.e();
            }
        }

        @Override // com.vivo.mobilead.unified.base.view.r.b
        public void a() {
            d.this.l = true;
            d.this.f30145b.e();
            if (d.this.f30150g != null) {
                d.this.f30150g.onVideoError(new VivoAdError(402135, "互动广告加载出错"));
            }
        }

        @Override // com.vivo.mobilead.unified.base.view.r.b
        public void a(int i2, boolean z) {
            d.this.a(i2, -999, -999, -999, -999, 6, 1, z);
            if (d.this.f30149f != null) {
                d.this.f30149f.onAdClick();
            }
        }
    }

    private void a(Context context) {
        g gVar = new g(context);
        this.f30145b = gVar;
        gVar.a(context);
        this.f30145b.a(context, 0);
        com.vivo.mobilead.unified.base.view.r.d dVar = new com.vivo.mobilead.unified.base.view.r.d(context);
        this.f30144a = dVar;
        dVar.setWebCallback(new a());
        addView(this.f30144a, new RelativeLayout.LayoutParams(-1, -1));
        addView(this.f30145b, new RelativeLayout.LayoutParams(-1, -1));
    }

    @Override // com.vivo.mobilead.unified.base.view.t.c
    public void a(com.vivo.ad.model.b bVar, BackUrlInfo backUrlInfo, String str, int i2, int i3) {
        this.f30151h = bVar;
        this.f30152i = str;
        this.k = i3;
        this.r = backUrlInfo;
        this.s = i2;
        if (bVar != null) {
            if (bVar.c() != null) {
                com.vivo.ad.model.e c2 = bVar.c();
                this.f30147d = c2.t();
                this.f30148e = c2.k();
                if (1 == j.a(c2.b(), 2)) {
                    a(true);
                } else {
                    a(false);
                }
            }
            this.f30145b.a(bVar, this.v);
            this.f30145b.a(str);
            this.f30145b.h();
            this.f30144a.a(bVar, str, backUrlInfo, i3, i2);
            if (q.a(bVar)) {
                this.f30145b.b(str);
            }
        }
    }

    private void a(boolean z) {
        if (z) {
            if (this.f30146c == null && getContext() != null) {
                Context context = getContext();
                com.vivo.mobilead.unified.base.view.r.c cVar = new com.vivo.mobilead.unified.base.view.r.c(getContext());
                this.f30146c = cVar;
                cVar.setImageBitmap(com.vivo.mobilead.util.g.a(context, "vivo_module_web_download.png"));
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(m.b(context, 52.0f), m.b(context, 52.0f));
                layoutParams.addRule(11);
                layoutParams.addRule(12);
                com.vivo.ad.model.b bVar = this.f30151h;
                if (bVar != null && bVar.t() != null && this.f30151h.t().b().intValue() == 2) {
                    layoutParams.bottomMargin = m.b(context, 86.0f);
                } else {
                    layoutParams.bottomMargin = m.b(context, 126.0f);
                }
                this.f30146c.setScaleType(ImageView.ScaleType.CENTER_CROP);
                addView(this.f30146c, layoutParams);
                this.f30146c.setDownloadListener(new c());
            }
            com.vivo.mobilead.unified.base.view.r.c cVar2 = this.f30146c;
            if (cVar2 == null || cVar2.getVisibility() == 0) {
                return;
            }
            this.f30146c.setVisibility(0);
            return;
        }
        com.vivo.mobilead.unified.base.view.r.c cVar3 = this.f30146c;
        if (cVar3 == null || cVar3.getVisibility() == 8) {
            return;
        }
        this.f30146c.setVisibility(8);
    }

    public void a(int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        if (this.q) {
            return;
        }
        this.q = true;
        k0.a(this.f30151h, this.f30145b.getIconStatus(), i7, i8, i3, i4, i5, i6, i2, this.f30152i, this.f30151h.i(), c.a.f28912a + "", this.k, z);
        u0.a(this.f30151h, a.EnumC0603a.CLICK, i3, i4, i5, i6, -999, -999, -999, -999, this.f30152i);
    }
}
