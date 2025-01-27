package com.opos.mobad.interstitial.a;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.opos.mobad.n.a;

/* loaded from: classes4.dex */
public abstract class c implements com.opos.mobad.n.a {

    /* renamed from: a */
    protected Activity f21032a;

    /* renamed from: b */
    protected a.InterfaceC0458a f21033b;

    /* renamed from: c */
    protected RelativeLayout f21034c;

    /* renamed from: d */
    protected ImageView f21035d;

    /* renamed from: e */
    protected ImageView f21036e;

    /* renamed from: f */
    protected com.opos.cmn.e.a.a.a f21037f;

    /* renamed from: g */
    protected RelativeLayout f21038g;

    /* renamed from: h */
    protected RelativeLayout f21039h;

    /* renamed from: i */
    protected ImageView f21040i;

    /* renamed from: j */
    protected int[] f21041j = new int[4];
    private int k;
    private com.opos.mobad.n.d.h l;

    /* renamed from: com.opos.mobad.interstitial.a.c$1 */
    class AnonymousClass1 implements View.OnAttachStateChangeListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            a.InterfaceC0458a interfaceC0458a = c.this.f21033b;
            if (interfaceC0458a != null) {
                interfaceC0458a.b();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* renamed from: com.opos.mobad.interstitial.a.c$2 */
    class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c cVar = c.this;
            cVar.f21033b.f(view, cVar.f21041j);
        }
    }

    /* renamed from: com.opos.mobad.interstitial.a.c$3 */
    class AnonymousClass3 implements View.OnClickListener {
        AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c cVar = c.this;
            cVar.f21033b.g(view, cVar.f21041j);
        }
    }

    /* renamed from: com.opos.mobad.interstitial.a.c$4 */
    class AnonymousClass4 implements View.OnClickListener {
        AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.opos.cmn.an.f.a.b("BaseInterstitialCreative", "close click origin");
            c cVar = c.this;
            cVar.f21033b.d(view, cVar.f21041j);
        }
    }

    public c(Activity activity, int i2, a.InterfaceC0458a interfaceC0458a) {
        this.f21032a = activity;
        this.f21033b = interfaceC0458a;
        this.k = i2;
        h();
        f();
    }

    private void c(View view) {
        if (view != null) {
            view.setOnTouchListener(new com.opos.cmn.e.a.a.b(this.f21041j));
            view.setOnClickListener(new View.OnClickListener() { // from class: com.opos.mobad.interstitial.a.c.4
                AnonymousClass4() {
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.opos.cmn.an.f.a.b("BaseInterstitialCreative", "close click origin");
                    c cVar = c.this;
                    cVar.f21033b.d(view2, cVar.f21041j);
                }
            });
        }
    }

    private void c(RelativeLayout relativeLayout) {
        Activity activity;
        float f2;
        d(relativeLayout);
        if (this.f21036e == null) {
            ImageView imageView = new ImageView(this.f21032a);
            this.f21036e = imageView;
            imageView.setAlpha(0.7f);
            this.f21036e.setImageDrawable(com.opos.cmn.an.d.a.a.c(this.f21032a, "opos_module_biz_ui_interstitial_close_bn_bg_img.png"));
            this.f21036e.setScaleType(ImageView.ScaleType.FIT_XY);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f21032a, 37.0f), com.opos.cmn.an.h.f.a.a(this.f21032a, 37.0f));
        layoutParams.addRule(14);
        layoutParams.addRule(3, 1);
        if (com.opos.cmn.an.h.f.a.d(this.f21032a)) {
            activity = this.f21032a;
            f2 = 28.0f;
        } else {
            activity = this.f21032a;
            f2 = 21.0f;
        }
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(activity, f2);
        relativeLayout.addView(this.f21036e, layoutParams);
    }

    private void d(RelativeLayout relativeLayout) {
        if (this.f21040i == null) {
            ImageView imageView = new ImageView(this.f21032a);
            this.f21040i = imageView;
            imageView.setAlpha(0.35f);
            this.f21040i.setImageDrawable(new ColorDrawable(Color.parseColor("#808080")));
        }
        RelativeLayout.LayoutParams layoutParams = com.opos.cmn.an.h.f.a.d(this.f21032a) ? new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f21032a, 1.0f), com.opos.cmn.an.h.f.a.a(this.f21032a, 44.0f)) : new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f21032a, 1.0f), com.opos.cmn.an.h.f.a.a(this.f21032a, 37.0f));
        layoutParams.addRule(14);
        layoutParams.addRule(3, 1);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f21032a, -12.0f);
        relativeLayout.addView(this.f21040i, layoutParams);
    }

    private void h() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f21032a);
        this.f21034c = relativeLayout;
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        RelativeLayout relativeLayout2 = new RelativeLayout(this.f21032a);
        this.f21038g = relativeLayout2;
        relativeLayout2.setId(1);
        this.f21039h = new RelativeLayout(this.f21032a);
        this.f21034c.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.opos.mobad.interstitial.a.c.1
            AnonymousClass1() {
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                a.InterfaceC0458a interfaceC0458a = c.this.f21033b;
                if (interfaceC0458a != null) {
                    interfaceC0458a.b();
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
            }
        });
    }

    private void i() {
        ImageView imageView = this.f21035d;
        if (imageView != null) {
            this.f21038g.removeView(imageView);
        }
        ImageView imageView2 = this.f21040i;
        if (imageView2 != null) {
            this.f21034c.removeView(imageView2);
        }
        ImageView imageView3 = this.f21036e;
        if (imageView3 != null) {
            this.f21034c.removeView(imageView3);
        }
    }

    private void j() {
        RelativeLayout relativeLayout = this.f21038g;
        if (relativeLayout != null) {
            this.f21034c.removeView(relativeLayout);
        }
    }

    @Override // com.opos.mobad.n.a
    public void a() {
    }

    protected void a(int i2) {
        ImageView imageView;
        i();
        if (i2 == 1 || i2 != 2) {
            b(this.f21038g);
            imageView = this.f21035d;
        } else {
            c(this.f21034c);
            imageView = this.f21036e;
        }
        c(imageView);
    }

    protected void a(View view) {
        if (view != null) {
            view.setOnTouchListener(new com.opos.cmn.e.a.a.b(this.f21041j));
            view.setOnClickListener(new View.OnClickListener() { // from class: com.opos.mobad.interstitial.a.c.2
                AnonymousClass2() {
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    c cVar = c.this;
                    cVar.f21033b.f(view2, cVar.f21041j);
                }
            });
        }
    }

    protected void a(RelativeLayout relativeLayout) {
        com.opos.cmn.e.a.a.a aVar = new com.opos.cmn.e.a.a.a(this.f21032a, "opos_module_biz_ui_interstitial_click_bn_normal_yellow_bg_img.png", "opos_module_biz_ui_interstitial_click_bn_pressed_yellow_bg_img.png");
        this.f21037f = aVar;
        aVar.setId(3);
        this.f21037f.setGravity(17);
        this.f21037f.setTextColor(-1);
        this.f21037f.setTextSize(1, 16.0f);
        this.f21037f.setTypeface(Typeface.defaultFromStyle(1));
        this.f21037f.setSingleLine();
        this.f21037f.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f21032a, 240.0f), com.opos.cmn.an.h.f.a.a(this.f21032a, 34.0f));
        layoutParams.addRule(12);
        layoutParams.addRule(3, 2);
        relativeLayout.addView(this.f21037f, layoutParams);
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
        this.f21033b = interfaceC0458a;
    }

    protected void a(com.opos.mobad.n.d.d dVar) {
        if (dVar != null) {
            this.f21037f.setText(dVar.l);
            this.f21037f.setVisibility(0);
        }
    }

    protected void a(com.opos.mobad.n.d.d dVar, RelativeLayout relativeLayout) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(2, 3);
        layoutParams.addRule(11);
        a.a(dVar, relativeLayout, layoutParams);
    }

    @Override // com.opos.mobad.n.a
    public void a(com.opos.mobad.n.d.h hVar) {
        a.InterfaceC0458a interfaceC0458a;
        if (this.l == null && (interfaceC0458a = this.f21033b) != null) {
            interfaceC0458a.e();
        }
        this.l = hVar;
    }

    protected void a(boolean z, int i2) {
        a(z, i2, 264, 258);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0074, code lost:
    
        if (com.opos.cmn.an.h.f.a.a(r2.f21032a) != false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0093, code lost:
    
        r4 = com.opos.cmn.an.h.f.a.a(r2.f21032a, r5) - com.opos.cmn.an.h.f.a.k(r2.f21032a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x008c, code lost:
    
        r4 = com.opos.cmn.an.h.f.a.a(r2.f21032a, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x007f, code lost:
    
        if (com.opos.cmn.an.h.f.a.a(r2.f21032a) != false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x008a, code lost:
    
        if (com.opos.cmn.an.h.f.a.a(r2.f21032a) != false) goto L55;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void a(boolean r3, int r4, int r5, int r6) {
        /*
            r2 = this;
            r2.j()
            if (r3 == 0) goto L12
            android.widget.RelativeLayout r3 = r2.f21038g
            android.app.Activity r0 = r2.f21032a
            java.lang.String r1 = "opos_module_biz_ui_interstitial_ad_rl_bg_img.png"
            android.graphics.drawable.Drawable r0 = com.opos.cmn.an.d.a.a.c(r0, r1)
            com.opos.mobad.cmn.a.b.g.a(r3, r0)
        L12:
            android.widget.RelativeLayout$LayoutParams r3 = new android.widget.RelativeLayout$LayoutParams
            android.app.Activity r0 = r2.f21032a
            float r5 = (float) r5
            int r5 = com.opos.cmn.an.h.f.a.a(r0, r5)
            android.app.Activity r0 = r2.f21032a
            float r6 = (float) r6
            int r6 = com.opos.cmn.an.h.f.a.a(r0, r6)
            r3.<init>(r5, r6)
            android.app.Activity r5 = r2.f21032a
            boolean r5 = com.opos.cmn.an.h.f.a.d(r5)
            java.lang.String r6 = "adLP.topMargin ="
            java.lang.String r0 = "BaseInterstitialCreative"
            if (r5 == 0) goto L66
            android.app.Activity r4 = r2.f21032a
            boolean r4 = com.opos.cmn.an.h.f.a.a(r4)
            r5 = 1128202240(0x433f0000, float:191.0)
            if (r4 == 0) goto L42
            android.app.Activity r4 = r2.f21032a
            int r4 = com.opos.cmn.an.h.f.a.a(r4, r5)
            goto L4f
        L42:
            android.app.Activity r4 = r2.f21032a
            int r4 = com.opos.cmn.an.h.f.a.a(r4, r5)
            android.app.Activity r5 = r2.f21032a
            int r5 = com.opos.cmn.an.h.f.a.k(r5)
            int r4 = r4 - r5
        L4f:
            r3.topMargin = r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
        L56:
            r4.append(r6)
            int r5 = r3.topMargin
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            com.opos.cmn.an.f.a.b(r0, r4)
            goto La8
        L66:
            r5 = 1
            if (r4 == r5) goto L82
            r5 = 2
            if (r4 == r5) goto L77
            android.app.Activity r4 = r2.f21032a
            boolean r4 = com.opos.cmn.an.h.f.a.a(r4)
            r5 = 1108869120(0x42180000, float:38.0)
            if (r4 == 0) goto L93
            goto L8c
        L77:
            android.app.Activity r4 = r2.f21032a
            boolean r4 = com.opos.cmn.an.h.f.a.a(r4)
            r5 = 1105723392(0x41e80000, float:29.0)
            if (r4 == 0) goto L93
            goto L8c
        L82:
            android.app.Activity r4 = r2.f21032a
            boolean r4 = com.opos.cmn.an.h.f.a.a(r4)
            r5 = 1112801280(0x42540000, float:53.0)
            if (r4 == 0) goto L93
        L8c:
            android.app.Activity r4 = r2.f21032a
            int r4 = com.opos.cmn.an.h.f.a.a(r4, r5)
            goto La0
        L93:
            android.app.Activity r4 = r2.f21032a
            int r4 = com.opos.cmn.an.h.f.a.a(r4, r5)
            android.app.Activity r5 = r2.f21032a
            int r5 = com.opos.cmn.an.h.f.a.k(r5)
            int r4 = r4 - r5
        La0:
            r3.topMargin = r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            goto L56
        La8:
            r4 = 14
            r3.addRule(r4)
            android.widget.RelativeLayout r4 = r2.f21034c
            android.widget.RelativeLayout r5 = r2.f21038g
            r4.addView(r5, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.interstitial.a.c.a(boolean, int, int, int):void");
    }

    @Override // com.opos.mobad.n.a
    public void b() {
    }

    protected void b(View view) {
        if (view != null) {
            view.setOnTouchListener(new com.opos.cmn.e.a.a.b(this.f21041j));
            view.setOnClickListener(new View.OnClickListener() { // from class: com.opos.mobad.interstitial.a.c.3
                AnonymousClass3() {
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    c cVar = c.this;
                    cVar.f21033b.g(view2, cVar.f21041j);
                }
            });
        }
    }

    protected void b(RelativeLayout relativeLayout) {
        if (this.f21035d == null) {
            ImageView imageView = new ImageView(this.f21032a);
            this.f21035d = imageView;
            imageView.setAlpha(0.7f);
            this.f21035d.setImageDrawable(com.opos.cmn.an.d.a.a.c(this.f21032a, "opos_module_biz_ui_interstitial_close_bn_bg_img.png"));
            this.f21035d.setScaleType(ImageView.ScaleType.FIT_XY);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f21032a, 37.0f), com.opos.cmn.an.h.f.a.a(this.f21032a, 37.0f));
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f21032a, -4.0f);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.f21032a, -5.0f);
        relativeLayout.addView(this.f21035d, layoutParams);
    }

    @Override // com.opos.mobad.n.a
    public int e() {
        return this.k;
    }

    public abstract void f();

    @Override // com.opos.mobad.n.a
    /* renamed from: g */
    public RelativeLayout c() {
        return this.f21034c;
    }
}
