package com.opos.mobad.interstitial.a;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.opos.mobad.n.a;

/* loaded from: classes4.dex */
public abstract class b implements com.opos.mobad.n.a {

    /* renamed from: a */
    protected RelativeLayout f21018a;

    /* renamed from: b */
    protected RelativeLayout f21019b;

    /* renamed from: c */
    protected RelativeLayout f21020c;

    /* renamed from: d */
    protected RelativeLayout f21021d;

    /* renamed from: e */
    protected ImageView f21022e;

    /* renamed from: f */
    protected ImageView f21023f;

    /* renamed from: g */
    protected ImageView f21024g;

    /* renamed from: h */
    protected TextView f21025h;

    /* renamed from: i */
    protected TextView f21026i;

    /* renamed from: j */
    protected com.opos.cmn.e.a.a.a f21027j;
    protected Context k;
    protected int[] l = new int[4];
    private a.InterfaceC0458a m;
    private int n;
    private com.opos.mobad.n.d.h o;

    /* renamed from: com.opos.mobad.interstitial.a.b$1 */
    class AnonymousClass1 implements View.OnAttachStateChangeListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            if (b.this.m != null) {
                b.this.m.b();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* renamed from: com.opos.mobad.interstitial.a.b$2 */
    class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.m.f(view, b.this.l);
        }
    }

    /* renamed from: com.opos.mobad.interstitial.a.b$3 */
    class AnonymousClass3 implements View.OnClickListener {
        AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.m.g(view, b.this.l);
        }
    }

    /* renamed from: com.opos.mobad.interstitial.a.b$4 */
    class AnonymousClass4 implements View.OnClickListener {
        AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.opos.cmn.an.f.a.b("BaseGMCreative", "close click origin");
            b.this.m.d(view, b.this.l);
        }
    }

    public b(Context context, int i2, a.InterfaceC0458a interfaceC0458a) {
        this.k = context;
        this.m = interfaceC0458a;
        this.n = i2;
        h();
        f();
    }

    private void a(RelativeLayout relativeLayout) {
        if (this.f21024g == null) {
            ImageView imageView = new ImageView(this.k);
            this.f21024g = imageView;
            imageView.setAlpha(0.35f);
            this.f21024g.setImageDrawable(new ColorDrawable(Color.parseColor("#808080")));
        }
        RelativeLayout.LayoutParams layoutParams = com.opos.cmn.an.h.f.a.d(this.k) ? new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.k, 1.0f), com.opos.cmn.an.h.f.a.a(this.k, 44.0f)) : new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.k, 1.0f), com.opos.cmn.an.h.f.a.a(this.k, 37.0f));
        layoutParams.addRule(14);
        layoutParams.addRule(3, 1);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.k, -12.0f);
        relativeLayout.addView(this.f21024g, layoutParams);
    }

    private void c(View view) {
        if (view != null) {
            view.setOnTouchListener(new com.opos.cmn.e.a.a.b(this.l));
            view.setOnClickListener(new View.OnClickListener() { // from class: com.opos.mobad.interstitial.a.b.4
                AnonymousClass4() {
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.opos.cmn.an.f.a.b("BaseGMCreative", "close click origin");
                    b.this.m.d(view2, b.this.l);
                }
            });
        }
    }

    private void c(RelativeLayout.LayoutParams layoutParams) {
        k();
        this.f21019b.addView(this.f21020c, layoutParams);
    }

    private void h() {
        RelativeLayout relativeLayout = new RelativeLayout(this.k);
        this.f21018a = relativeLayout;
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f21019b = new RelativeLayout(this.k);
        RelativeLayout relativeLayout2 = new RelativeLayout(this.k);
        this.f21020c = relativeLayout2;
        relativeLayout2.setId(1);
        this.f21021d = new RelativeLayout(this.k);
        i();
        this.f21018a.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.opos.mobad.interstitial.a.b.1
            AnonymousClass1() {
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (b.this.m != null) {
                    b.this.m.b();
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
            }
        });
    }

    private void i() {
        com.opos.cmn.e.a.a.c cVar = new com.opos.cmn.e.a.a.c(this.k, 14.0f);
        cVar.setScaleType(ImageView.ScaleType.FIT_XY);
        cVar.setImageDrawable(new ColorDrawable(-1));
        this.f21021d.addView(cVar, new RelativeLayout.LayoutParams(-1, -1));
    }

    private void j() {
        RelativeLayout relativeLayout = this.f21019b;
        if (relativeLayout != null) {
            this.f21018a.removeView(relativeLayout);
        }
    }

    private void k() {
        RelativeLayout relativeLayout = this.f21020c;
        if (relativeLayout != null) {
            this.f21019b.removeView(relativeLayout);
        }
    }

    private void l() {
        ImageView imageView = this.f21023f;
        if (imageView != null) {
            this.f21020c.removeView(imageView);
        }
        ImageView imageView2 = this.f21024g;
        if (imageView2 != null) {
            this.f21019b.removeView(imageView2);
        }
        ImageView imageView3 = this.f21022e;
        if (imageView3 != null) {
            this.f21019b.removeView(imageView3);
        }
    }

    private void m() {
        if (this.f21023f == null) {
            ImageView imageView = new ImageView(this.k);
            this.f21023f = imageView;
            imageView.setAlpha(0.7f);
            this.f21023f.setImageDrawable(com.opos.cmn.an.d.a.a.c(this.k, "opos_module_biz_ui_interstitial_close_bn_bg_img.png"));
            this.f21023f.setScaleType(ImageView.ScaleType.FIT_XY);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.k, 37.0f), com.opos.cmn.an.h.f.a.a(this.k, 37.0f));
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.k, -4.0f);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.k, -5.0f);
        this.f21020c.addView(this.f21023f, layoutParams);
    }

    private void n() {
        Context context;
        float f2;
        a(this.f21019b);
        if (this.f21022e == null) {
            ImageView imageView = new ImageView(this.k);
            this.f21022e = imageView;
            imageView.setAlpha(0.7f);
            this.f21022e.setImageDrawable(com.opos.cmn.an.d.a.a.c(this.k, "opos_module_biz_ui_interstitial_close_bn_bg_img.png"));
            this.f21022e.setScaleType(ImageView.ScaleType.FIT_XY);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.k, 37.0f), com.opos.cmn.an.h.f.a.a(this.k, 37.0f));
        layoutParams.addRule(14);
        layoutParams.addRule(3, 1);
        if (com.opos.cmn.an.h.f.a.d(this.k)) {
            context = this.k;
            f2 = 28.0f;
        } else {
            context = this.k;
            f2 = 21.0f;
        }
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(context, f2);
        this.f21019b.addView(this.f21022e, layoutParams);
    }

    @Override // com.opos.mobad.n.a
    public void a() {
    }

    protected void a(int i2) {
        ImageView imageView;
        l();
        if (i2 == 1 || i2 != 2) {
            m();
            imageView = this.f21023f;
        } else {
            n();
            imageView = this.f21022e;
        }
        c(imageView);
    }

    protected void a(View view) {
        if (view != null) {
            view.setOnTouchListener(new com.opos.cmn.e.a.a.b(this.l));
            view.setOnClickListener(new View.OnClickListener() { // from class: com.opos.mobad.interstitial.a.b.2
                AnonymousClass2() {
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.m.f(view2, b.this.l);
                }
            });
        }
    }

    protected void a(RelativeLayout.LayoutParams layoutParams) {
        this.f21020c.addView(this.f21021d, layoutParams);
    }

    protected void a(TextView textView, String str) {
        if (textView != null) {
            if (com.opos.cmn.an.c.a.a(str)) {
                str = "";
            }
            textView.setText(str);
        }
    }

    @Override // com.opos.mobad.n.a
    public void a(a.InterfaceC0458a interfaceC0458a) {
        this.m = interfaceC0458a;
    }

    protected void a(com.opos.mobad.n.d.d dVar) {
        this.f21027j.setText(dVar.l);
    }

    protected void a(com.opos.mobad.n.d.d dVar, RelativeLayout relativeLayout, RelativeLayout.LayoutParams layoutParams) {
        View a2 = com.opos.mobad.n.e.a(dVar, relativeLayout, layoutParams);
        if (a2 != null) {
            a2.setId(5);
        }
    }

    @Override // com.opos.mobad.n.a
    public void a(com.opos.mobad.n.d.h hVar) {
        a.InterfaceC0458a interfaceC0458a;
        if (this.o == null && (interfaceC0458a = this.m) != null) {
            interfaceC0458a.e();
        }
        this.o = hVar;
    }

    @Override // com.opos.mobad.n.a
    public void b() {
    }

    protected void b(View view) {
        if (view != null) {
            view.setOnTouchListener(new com.opos.cmn.e.a.a.b(this.l));
            view.setOnClickListener(new View.OnClickListener() { // from class: com.opos.mobad.interstitial.a.b.3
                AnonymousClass3() {
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    b.this.m.g(view2, b.this.l);
                }
            });
        }
    }

    protected void b(RelativeLayout.LayoutParams layoutParams) {
        j();
        c(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.f21018a.addView(this.f21019b, layoutParams2);
    }

    @Override // com.opos.mobad.n.a
    public int e() {
        return this.n;
    }

    public abstract void f();

    @Override // com.opos.mobad.n.a
    /* renamed from: g */
    public RelativeLayout c() {
        return this.f21018a;
    }
}
