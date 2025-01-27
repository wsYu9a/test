package com.vivo.mobilead.unified.base.view.t;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import com.vivo.mobilead.j.c;
import com.vivo.mobilead.model.BackUrlInfo;
import com.vivo.mobilead.model.a;
import com.vivo.mobilead.unified.base.VivoAdError;
import com.vivo.mobilead.unified.base.callback.MediaListener;
import com.vivo.mobilead.unified.reward.UnifiedVivoRewardVideoAdListener;
import com.vivo.mobilead.util.k0;
import com.vivo.mobilead.util.u0;

/* loaded from: classes4.dex */
public class b extends com.vivo.mobilead.unified.base.view.t.c {

    /* renamed from: a */
    private UnifiedVivoRewardVideoAdListener f30126a;

    /* renamed from: b */
    private MediaListener f30127b;

    /* renamed from: c */
    private com.vivo.ad.model.b f30128c;

    /* renamed from: d */
    private com.vivo.mobilead.unified.base.view.i f30129d;

    /* renamed from: e */
    private com.vivo.mobilead.unified.base.view.t.j.b f30130e;

    /* renamed from: f */
    private g f30131f;

    /* renamed from: g */
    private boolean f30132g;

    /* renamed from: h */
    private String f30133h;

    /* renamed from: i */
    private boolean f30134i;

    /* renamed from: j */
    private boolean f30135j;
    private boolean k;
    private boolean l;
    private boolean m;
    private int n;
    private int o;
    private int p;
    private com.vivo.mobilead.unified.base.callback.e q;
    private ViewTreeObserver.OnPreDrawListener r;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.f30129d != null) {
                b.this.f30129d.setVisibility(8);
            }
            b.this.f30134i = false;
            b.this.i();
        }
    }

    class c extends com.vivo.mobilead.unified.base.callback.e {
        c() {
        }

        @Override // com.vivo.mobilead.d.a
        public void a() {
        }

        @Override // com.vivo.mobilead.unified.base.callback.k
        public void c() {
            b.this.g();
        }

        @Override // com.vivo.mobilead.unified.base.callback.k
        public void d(int i2, int i3) {
        }

        @Override // com.vivo.mobilead.unified.base.callback.k
        public void e() {
            b.this.f();
        }

        @Override // com.vivo.mobilead.unified.base.callback.k
        public void f() {
        }

        @Override // com.vivo.mobilead.unified.base.callback.k
        public void g() {
            b.this.k = false;
            b.this.f();
        }

        @Override // com.vivo.mobilead.unified.base.callback.k
        public void i() {
            b.this.k = true;
            b.this.e();
        }

        @Override // com.vivo.mobilead.unified.base.callback.k
        public void j() {
            if (b.this.f30134i) {
                b.this.g();
            } else if (b.this.f30135j) {
                b.this.g();
            } else {
                b.this.f30131f.d();
            }
        }
    }

    class d implements ViewTreeObserver.OnPreDrawListener {
        d() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (!b.this.f30132g && b.this.isShown()) {
                b.this.f30132g = true;
                if (b.this.f30126a != null) {
                    b.this.f30126a.onAdShow();
                }
                if (b.this.f30128c != null) {
                    int iconStatus = b.this.f30131f == null ? 1 : b.this.f30131f.getIconStatus();
                    k0.a(b.this.f30128c, iconStatus, b.this.f30133h, b.this.f30128c.i(), c.a.f28912a + "", 1, -999);
                    u0.a(b.this.f30128c, a.EnumC0603a.SHOW, b.this.f30133h);
                }
            }
            return true;
        }
    }

    public b(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnPreDrawListener(this.r);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnPreDrawListener(this.r);
    }

    @Override // com.vivo.mobilead.unified.base.view.t.c
    public void setMediaListener(MediaListener mediaListener) {
        this.f30127b = mediaListener;
    }

    @Override // com.vivo.mobilead.unified.base.view.t.c
    public void setRewardVideoAdListener(UnifiedVivoRewardVideoAdListener unifiedVivoRewardVideoAdListener) {
        this.f30126a = unifiedVivoRewardVideoAdListener;
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void g() {
        h();
        UnifiedVivoRewardVideoAdListener unifiedVivoRewardVideoAdListener = this.f30126a;
        if (unifiedVivoRewardVideoAdListener != null) {
            unifiedVivoRewardVideoAdListener.onAdClose();
        }
        com.vivo.ad.model.b bVar = this.f30128c;
        k0.a(bVar, this.f30133h, bVar.i(), 7, 0, 16);
    }

    private void h() {
        Context context = getContext();
        if (context instanceof Activity) {
            ((Activity) context).finish();
        }
    }

    public void i() {
        com.vivo.mobilead.unified.base.view.t.j.b bVar = this.f30130e;
        if (bVar != null) {
            if (bVar.getVisibility() == 8) {
                this.f30130e.setVisibility(0);
            }
            this.f30130e.setData(this.f30128c);
        }
    }

    @Override // com.vivo.mobilead.unified.base.view.t.c
    public void f() {
        com.vivo.mobilead.unified.base.view.t.j.b bVar;
        if (this.k || (bVar = this.f30130e) == null || bVar.getVisibility() != 0) {
            return;
        }
        this.f30130e.b();
    }

    /* renamed from: com.vivo.mobilead.unified.base.view.t.b$b */
    class C0634b implements com.vivo.mobilead.unified.base.view.r.b {

        /* renamed from: com.vivo.mobilead.unified.base.view.t.b$b$a */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!b.this.isShown() || b.this.f30134i) {
                    return;
                }
                b.this.f30131f.a(b.this.o, 0);
            }
        }

        /* renamed from: com.vivo.mobilead.unified.base.view.t.b$b$b */
        class RunnableC0635b implements Runnable {
            RunnableC0635b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f30134i = true;
                if (b.this.f30129d == null || b.this.f30129d.getVisibility() != 8) {
                    return;
                }
                b.this.f30129d.setVisibility(0);
                if (b.this.f30130e != null) {
                    b.this.f30130e.setVisibility(8);
                    b.this.f30130e.c();
                }
                if (b.this.f30131f != null) {
                    b.this.f30131f.c();
                }
                if (b.this.f30127b != null) {
                    b.this.f30127b.onVideoError(new VivoAdError(402139, "网页加载异常"));
                }
            }
        }

        /* renamed from: com.vivo.mobilead.unified.base.view.t.b$b$c */
        class c implements Runnable {
            c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.p++;
                if (b.this.p < b.this.o || b.this.f30135j) {
                    b.this.f30131f.a(b.this.o, b.this.p);
                } else {
                    b.this.f30135j = true;
                    if (b.this.f30126a != null) {
                        b.this.f30126a.onRewardVerify();
                    }
                    b.this.f30131f.c();
                    b.this.f30130e.c();
                }
                if (b.this.p >= b.this.n) {
                    b.this.f30131f.e();
                }
            }
        }

        /* renamed from: com.vivo.mobilead.unified.base.view.t.b$b$d */
        class d implements Runnable {
            d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (b.this.f30126a != null) {
                    b.this.f30126a.onAdClick();
                }
            }
        }

        C0634b() {
        }

        @Override // com.vivo.mobilead.unified.base.view.r.b
        public void a(String str) {
            if (b.this.m) {
                return;
            }
            b.this.m = true;
            com.vivo.mobilead.util.f1.c.d(new a());
        }

        @Override // com.vivo.mobilead.unified.base.view.r.b
        public void b() {
            com.vivo.mobilead.util.f1.c.d(new c());
        }

        @Override // com.vivo.mobilead.unified.base.view.r.b
        public void a() {
            com.vivo.mobilead.util.f1.c.d(new RunnableC0635b());
        }

        @Override // com.vivo.mobilead.unified.base.view.r.b
        public void a(int i2, boolean z) {
            b.this.a(i2, -999, -999, -999, -999, 7, 3, z);
            com.vivo.mobilead.util.f1.c.d(new d());
        }
    }

    public b(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f30132g = false;
        this.f30134i = false;
        this.f30135j = false;
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = 10;
        this.o = 15;
        this.p = 0;
        this.q = new c();
        this.r = new d();
        a(context);
    }

    @Override // com.vivo.mobilead.unified.base.view.t.c
    public void c() {
        com.vivo.mobilead.unified.base.view.t.j.b bVar = this.f30130e;
        if (bVar != null) {
            bVar.destroy();
        }
        getViewTreeObserver().removeOnPreDrawListener(this.r);
    }

    @Override // com.vivo.mobilead.unified.base.view.t.c
    public void d() {
        g gVar;
        if (getContext() == null || (gVar = this.f30131f) == null) {
            return;
        }
        this.f30131f.c(gVar.b() ? "请点击关闭按钮进行关闭" : "请待关闭按钮出现进行关闭");
    }

    @Override // com.vivo.mobilead.unified.base.view.t.c
    public void e() {
        com.vivo.mobilead.unified.base.view.t.j.b bVar = this.f30130e;
        if (bVar == null || bVar.getVisibility() != 0) {
            return;
        }
        this.f30130e.a();
    }

    private void a(Context context) {
        this.f30129d = new com.vivo.mobilead.unified.base.view.i(context);
        this.f30130e = new com.vivo.mobilead.unified.base.view.t.j.b(context);
        this.f30131f = new g(context);
        this.f30129d.setReryClickListener(new a());
        this.f30129d.setBackgroundColor(-16777216);
        this.f30129d.setVisibility(8);
        addView(this.f30129d, new RelativeLayout.LayoutParams(-1, -1));
        addView(this.f30130e, new RelativeLayout.LayoutParams(-1, -1));
        this.f30130e.setWebCallback(new C0634b());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.f30131f.a(context);
        addView(this.f30131f, layoutParams);
    }

    public void a(int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        if (this.l) {
            return;
        }
        this.l = true;
        k0.a(this.f30128c, this.f30131f.getIconStatus(), i7, i8, i3, i4, i5, i6, i2, this.f30133h, this.f30128c.i(), c.a.f28912a + "", 1, z);
        u0.a(this.f30128c, a.EnumC0603a.CLICK, i3, i4, i5, i6, -999, -999, -999, -999, this.f30133h);
    }

    @Override // com.vivo.mobilead.unified.base.view.t.c
    public void a(com.vivo.ad.model.b bVar, BackUrlInfo backUrlInfo, String str, int i2, int i3) {
        this.f30128c = bVar;
        this.f30133h = str;
        if (bVar != null) {
            bVar.b(70001);
            if (bVar.c() != null) {
                com.vivo.ad.model.e c2 = bVar.c();
                this.n = c2.t();
                this.o = c2.k();
            }
            this.f30131f.a(bVar, this.q);
            this.f30131f.a(str);
            this.f30131f.h();
            i();
        }
    }
}
