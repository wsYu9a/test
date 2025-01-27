package com.vivo.mobilead.unified.base.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.vivo.ad.model.AdError;
import com.vivo.ad.view.r;
import com.vivo.ad.view.u;
import com.vivo.ad.view.v;
import com.vivo.mobilead.model.VivoAdError;
import com.vivo.mobilead.unified.base.AdParams;
import com.vivo.mobilead.util.VOpenLog;
import com.vivo.mobilead.util.d1.c;
import com.vivo.mobilead.util.k0;
import com.vivo.mobilead.util.q;
import com.vivo.mobilead.util.r0;
import com.vivo.mobilead.util.x0;
import com.vivo.mobilead.util.y0;
import java.io.File;
import java.util.List;

/* loaded from: classes4.dex */
public class m extends LinearLayout implements com.vivo.ad.view.k, com.vivo.mobilead.unified.base.view.u.b {
    private ViewTreeObserver.OnPreDrawListener A;
    private View.OnAttachStateChangeListener B;
    private ViewTreeObserver.OnWindowFocusChangeListener C;

    /* renamed from: a */
    private AdParams f29894a;

    /* renamed from: b */
    protected RelativeLayout f29895b;

    /* renamed from: c */
    protected FrameLayout f29896c;

    /* renamed from: d */
    protected TextView f29897d;

    /* renamed from: e */
    protected com.vivo.ad.view.c f29898e;

    /* renamed from: f */
    protected RelativeLayout f29899f;

    /* renamed from: g */
    protected r f29900g;

    /* renamed from: h */
    private int f29901h;

    /* renamed from: i */
    protected LinearLayout f29902i;

    /* renamed from: j */
    protected com.vivo.ad.view.j f29903j;
    protected TextView k;
    protected TextView l;
    protected ImageView m;
    private int n;
    private com.vivo.mobilead.unified.base.callback.l o;
    private com.vivo.ad.model.b p;
    private String q;
    private boolean r;
    private boolean s;
    private volatile boolean t;
    v u;
    private TextView v;
    private TextView w;
    private com.vivo.ad.view.i x;
    private com.vivo.ad.view.o y;
    private Runnable z;

    class a extends com.vivo.mobilead.util.f1.b {
        a() {
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            m.b(m.this);
            m mVar = m.this;
            mVar.a(mVar.n);
            if (m.this.n > 0) {
                m.this.postDelayed(this, 1000L);
            } else {
                m.this.b();
            }
        }
    }

    class b implements ViewTreeObserver.OnPreDrawListener {
        b() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (m.this.isShown() && m.this.o != null && !m.this.s) {
                m.this.s = true;
                m.this.o.onAdShow();
                m.this.getViewTreeObserver().removeOnPreDrawListener(m.this.A);
            }
            return true;
        }
    }

    class c implements View.OnAttachStateChangeListener {
        c() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            m.this.getViewTreeObserver().addOnPreDrawListener(m.this.A);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            m.this.removeOnAttachStateChangeListener(this);
            m.this.getViewTreeObserver().removeOnWindowFocusChangeListener(m.this.C);
        }
    }

    class d implements ViewTreeObserver.OnWindowFocusChangeListener {
        d() {
        }

        @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
        public void onWindowFocusChanged(boolean z) {
            m.this.h();
            if (z) {
                m mVar = m.this;
                mVar.postDelayed(mVar.z, 1000L);
                return;
            }
            Context context = m.this.getContext();
            if ((context instanceof Activity) && com.vivo.mobilead.util.n.a((Activity) context)) {
                m mVar2 = m.this;
                mVar2.postDelayed(mVar2.z, 1000L);
            }
        }
    }

    class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (m.this.o != null) {
                m.this.o.a();
                m.this.h();
            }
        }
    }

    class f extends com.vivo.mobilead.util.b1.a.c.b {

        /* renamed from: a */
        final /* synthetic */ com.vivo.ad.model.b f29909a;

        class a extends com.vivo.mobilead.util.f1.b {

            /* renamed from: a */
            final /* synthetic */ byte[] f29911a;

            /* renamed from: b */
            final /* synthetic */ File f29912b;

            a(byte[] bArr, File file) {
                this.f29911a = bArr;
                this.f29912b = file;
            }

            @Override // com.vivo.mobilead.util.f1.b
            public void safelyRun() {
                m.this.f29903j.a(this.f29911a, this.f29912b);
            }
        }

        f(com.vivo.ad.model.b bVar) {
            this.f29909a = bVar;
        }

        @Override // com.vivo.mobilead.util.b1.a.c.b, com.vivo.mobilead.util.b1.a.c.a
        public void a(String str, byte[] bArr, File file) {
            m.this.f29903j.post(new a(bArr, file));
        }

        @Override // com.vivo.mobilead.util.b1.a.c.b, com.vivo.mobilead.util.b1.a.c.a
        public void a(VivoAdError vivoAdError) {
            super.a(vivoAdError);
            m.this.a(new AdError(40219, "没有广告素材，建议重试", this.f29909a.P(), this.f29909a.J()));
        }
    }

    class g implements c.d {

        /* renamed from: a */
        final /* synthetic */ Bitmap f29914a;

        g(Bitmap bitmap) {
            this.f29914a = bitmap;
        }

        @Override // com.vivo.mobilead.util.d1.c.d
        public void a(com.vivo.mobilead.util.d1.c cVar) {
            m.this.a(this.f29914a, cVar.a(Color.parseColor("#55C5FF")));
        }
    }

    class h implements com.vivo.ad.view.k {
        h() {
        }

        @Override // com.vivo.ad.view.k
        public void a(View view, int i2, int i3, int i4, int i5, boolean z) {
            if (m.this.o != null) {
                m.this.o.a(m.this.p, i2, i3, i4, i5, z, true);
            }
        }
    }

    public m(Activity activity, AdParams adParams) {
        super(activity);
        this.f29901h = -1;
        this.n = 3;
        this.t = false;
        this.z = new a();
        this.A = new b();
        this.B = new c();
        this.C = new d();
        this.f29894a = adParams;
        if (adParams.getSplashOrientation() == 2) {
            c();
        } else if (adParams.getSplashOrientation() == 1) {
            d();
        }
        addOnAttachStateChangeListener(this.B);
    }

    static /* synthetic */ int b(m mVar) {
        int i2 = mVar.n;
        mVar.n = i2 - 1;
        return i2;
    }

    private void i() {
        com.vivo.ad.view.c cVar = new com.vivo.ad.view.c(getContext());
        this.f29898e = cVar;
        cVar.a(Color.parseColor("#26000000"), new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f});
        this.f29898e.a(10, -1);
        this.f29898e.setId(y0.a());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(9);
        layoutParams.leftMargin = com.vivo.mobilead.util.m.b(getContext(), 25.0f);
        layoutParams.topMargin = com.vivo.mobilead.util.m.b(getContext(), 20.0f);
        this.f29898e.setLayoutParams(layoutParams);
    }

    private void j() {
        r rVar = new r(getContext());
        this.f29900g = rVar;
        rVar.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f29895b.addView(this.f29900g);
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f29902i = linearLayout;
        linearLayout.setOrientation(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.f29902i.setLayoutParams(layoutParams);
        this.f29902i.setGravity(17);
        com.vivo.ad.view.j jVar = new com.vivo.ad.view.j(getContext(), com.vivo.mobilead.util.m.b(getContext(), 15.0f));
        this.f29903j = jVar;
        jVar.setLayoutParams(new LinearLayout.LayoutParams(com.vivo.mobilead.util.m.b(getContext(), 85.33f), com.vivo.mobilead.util.m.b(getContext(), 85.33f)));
        this.f29902i.addView(this.f29903j);
        TextView textView = new TextView(getContext());
        this.k = textView;
        textView.setSingleLine();
        this.k.setTextColor(-1);
        this.k.setTextSize(1, 23.33f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(0, com.vivo.mobilead.util.m.b(getContext(), 20.0f), 0, 0);
        this.k.setLayoutParams(layoutParams2);
        this.f29902i.addView(this.k);
        TextView textView2 = new TextView(getContext());
        this.l = textView2;
        textView2.setSingleLine();
        this.l.setTextColor(-1);
        this.l.setTextSize(1, 14.67f);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.setMargins(0, com.vivo.mobilead.util.m.b(getContext(), 10.0f), 0, 0);
        this.l.setLayoutParams(layoutParams3);
        this.f29902i.addView(this.l);
        this.f29900g.addView(this.f29902i);
        ImageView imageView = new ImageView(getContext());
        this.m = imageView;
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.m.setEnabled(false);
        this.m.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f29900g.addView(this.m);
    }

    private void k() {
        com.vivo.ad.view.i iVar = new com.vivo.ad.view.i(getContext());
        this.x = iVar;
        iVar.setVisibility(8);
        this.x.setOrientation(1);
        this.x.setId(y0.a());
        this.w = new TextView(getContext());
        this.v = new TextView(getContext());
        this.w.setTextSize(1, 11.0f);
        this.w.setSingleLine();
        this.w.setTextColor(Color.parseColor("#B3ffffff"));
        this.w.setShadowLayer(com.vivo.mobilead.util.m.b(getContext(), 1.0f), 0.0f, com.vivo.mobilead.util.m.b(getContext(), 1.0f), Color.parseColor("#B34D4D4D"));
        this.x.addView(this.w);
        TextView textView = new TextView(getContext());
        this.v = textView;
        textView.setTextSize(1, 11.0f);
        this.w.setSingleLine();
        this.v.setTextColor(Color.parseColor("#B3ffffff"));
        this.v.setShadowLayer(com.vivo.mobilead.util.m.b(getContext(), 1.0f), 0.0f, com.vivo.mobilead.util.m.b(getContext(), 1.0f), Color.parseColor("#B34D4D4D"));
        this.x.addView(this.v);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(3, this.f29898e.getId());
        layoutParams.leftMargin = com.vivo.mobilead.util.m.b(getContext(), 25.0f);
        this.f29895b.addView(this.x, layoutParams);
        this.x.setOnADWidgetClickListener(new h());
        l();
    }

    private void l() {
        com.vivo.ad.view.o oVar = new com.vivo.ad.view.o(getContext());
        this.y = oVar;
        oVar.setVisibility(8);
        this.y.setTextColor(Color.parseColor("#B3ffffff"));
        this.y.a(com.vivo.mobilead.util.m.b(getContext(), 1.0f), 0.0f, com.vivo.mobilead.util.m.b(getContext(), 1.0f), Color.parseColor("#B34D4D4D"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(3, this.x.getId());
        layoutParams.leftMargin = com.vivo.mobilead.util.m.b(getContext(), 18.0f);
        layoutParams.topMargin = com.vivo.mobilead.util.m.b(getContext(), 5.0f);
        this.y.setLayoutParams(layoutParams);
        this.f29895b.addView(this.y);
    }

    private void m() {
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        this.f29899f = relativeLayout;
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f29895b.addView(this.f29899f);
    }

    private void n() {
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        this.f29895b = relativeLayout;
        relativeLayout.setBackgroundColor(-1);
        this.f29895b.setVisibility(8);
        this.f29895b.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    }

    private void o() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.f29896c = frameLayout;
        frameLayout.setOnClickListener(new e());
        TextView textView = new TextView(getContext());
        this.f29897d = textView;
        textView.setTextSize(1, 11.0f);
        this.f29897d.setTextColor(-1);
        this.f29897d.setGravity(17);
        this.f29897d.setBackground(com.vivo.ad.h.b.f.b(getContext(), 12.0f, "#7A222222"));
        this.f29897d.setPadding(com.vivo.mobilead.util.m.b(getContext(), 10.33f), com.vivo.mobilead.util.m.b(getContext(), 4.67f), com.vivo.mobilead.util.m.b(getContext(), 10.33f), com.vivo.mobilead.util.m.b(getContext(), 4.67f));
        this.f29897d.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(21);
        layoutParams.addRule(10);
        this.f29896c.setPadding(com.vivo.mobilead.util.m.b(getContext(), 10.0f), com.vivo.mobilead.util.m.b(getContext(), 10.0f), com.vivo.mobilead.util.m.b(getContext(), 10.0f), com.vivo.mobilead.util.m.b(getContext(), 10.0f));
        layoutParams.topMargin = com.vivo.mobilead.util.m.b(getContext(), 14.0f);
        layoutParams.rightMargin = com.vivo.mobilead.util.m.b(getContext(), 14.0f);
        this.f29896c.setLayoutParams(layoutParams);
        this.f29896c.addView(this.f29897d);
        this.f29895b.addView(this.f29896c);
    }

    private void p() {
        if (q.a(this.p)) {
            com.vivo.ad.model.q y = this.p.y();
            TextView textView = this.w;
            if (textView != null) {
                textView.setText(y.d() + " V" + y.s() + " " + (y.q() / 1024) + "MB");
            }
            TextView textView2 = this.v;
            if (textView2 != null) {
                textView2.setText(y.g());
            }
            com.vivo.ad.view.i iVar = this.x;
            if (iVar != null) {
                iVar.setVisibility(0);
            }
            com.vivo.ad.view.o oVar = this.y;
            if (oVar != null) {
                oVar.a(this.p, this.q);
                this.y.setVisibility(0);
            }
        }
    }

    private void setAppIcon(Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        new c.b(bitmap).a(new g(bitmap));
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return super.generateDefaultLayoutParams();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return super.generateLayoutParams(attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public /* bridge */ /* synthetic */ ViewOverlay getOverlay() {
        return super.getOverlay();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if ((getContext() instanceof Activity) && com.vivo.mobilead.util.n.a((Activity) getContext()) && this.n > 0) {
            h();
            postDelayed(this.z, 1000L);
        }
    }

    public void setSplashClickListener(com.vivo.mobilead.unified.base.callback.l lVar) {
        this.o = lVar;
    }

    protected void b() {
        com.vivo.mobilead.unified.base.callback.l lVar = this.o;
        if (lVar != null) {
            lVar.b();
        }
    }

    public void c() {
        n();
        m();
        j();
        o();
        i();
        k();
        this.f29899f.setVisibility(8);
        this.f29900g.setVisibility(8);
        this.f29900g.setOnADWidgetClickListener(this);
    }

    public void d() {
        n();
        m();
        j();
        o();
        i();
        k();
        this.f29899f.setVisibility(8);
        this.f29900g.setVisibility(8);
        this.f29900g.setOnADWidgetClickListener(this);
    }

    public void e() {
        setVisibility(8);
        this.o = null;
        h();
    }

    public void f() {
        FrameLayout frameLayout = this.f29896c;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
    }

    protected void g() {
        if (this.p.K() > this.n) {
            this.n = this.p.K();
        }
        a(this.n);
        postDelayed(this.z, 1000L);
        getViewTreeObserver().addOnWindowFocusChangeListener(this.C);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.generateLayoutParams(layoutParams);
    }

    protected void h() {
        removeCallbacks(this.z);
    }

    public void a(boolean z) {
        try {
            v vVar = this.u;
            if (this.t) {
                return;
            }
            AdParams adParams = this.f29894a;
            String sourceAppend = adParams != null ? adParams.getSourceAppend() : "";
            String str = TextUtils.isEmpty(sourceAppend) ? "" : sourceAppend;
            if (z) {
                k0.a(this.p, str, 0.0d, 0.0d, 0.0d);
            } else if (vVar != null) {
                k0.a(this.p, str, vVar.b(), vVar.d(), vVar.c());
            } else {
                k0.a(this.p, str, 0.0d, 0.0d, 0.0d);
            }
            this.t = true;
        } catch (Throwable th) {
            VOpenLog.d("SplashAd", "reportSplashOver" + th.getMessage());
        }
    }

    public void a(com.vivo.ad.model.b bVar, String str) {
        Context context;
        String b2;
        if (bVar == null || (context = getContext()) == null) {
            return;
        }
        this.q = str;
        this.p = bVar;
        addView(this.f29895b, new ViewGroup.LayoutParams(-1, -1));
        this.f29895b.setVisibility(0);
        if (q.a(bVar)) {
            p();
        }
        v vVar = new v(context, this.p, this, this);
        this.u = vVar;
        View a2 = vVar.a();
        com.vivo.ad.model.f f2 = bVar.f();
        if (!bVar.T() && !bVar.Z() && !bVar.U()) {
            this.f29899f.setVisibility(0);
            this.f29900g.setVisibility(8);
            Bitmap a3 = com.vivo.mobilead.h.b.a().a(f2.c().get(0));
            if (a3 == null) {
                a(new AdError(40219, "没有广告素材，建议重试", bVar.P(), bVar.J()));
            }
            a(this.f29899f, a3, bVar);
            this.f29901h = com.vivo.mobilead.unified.base.view.u.c.a(this, this.f29901h, this.p, context, this.f29899f, this.u);
        } else {
            this.f29899f.setVisibility(8);
            this.f29900g.setVisibility(0);
            if (!bVar.Y()) {
                List<String> c2 = f2.c();
                b2 = (c2 == null || c2.isEmpty()) ? "" : c2.get(0);
            } else {
                b2 = com.vivo.mobilead.util.f.b(bVar);
            }
            boolean z = !TextUtils.isEmpty(b2) && b2.endsWith(".gif");
            Bitmap a4 = z ? null : com.vivo.mobilead.h.b.a().a(b2);
            if (a4 == null && !z) {
                a(new AdError(40219, "没有广告素材，建议重试", bVar.P(), bVar.J()));
            }
            if (bVar.x() == 20) {
                this.f29902i.setVisibility(0);
                this.m.setVisibility(0);
                this.f29903j.setOnADWidgetClickListener(this);
                if (!z) {
                    setAppIcon(a4);
                } else {
                    com.vivo.mobilead.util.b1.a.b.b().a(b2, new f(bVar));
                }
                this.k.setText(r0.a(f2.e(), 8));
                this.l.setText(r0.a(f2.d(), 15));
                if (this.f29894a.getSplashOrientation() == 1) {
                    this.m.setImageDrawable(com.vivo.mobilead.util.g.b(getContext(), "vivo_module_biz_ui_splash_mask_portart.png"));
                } else if (this.f29894a.getSplashOrientation() == 2) {
                    this.m.setImageDrawable(com.vivo.mobilead.util.g.b(getContext(), "vivo_module_biz_ui_splash_mask_landscape.png"));
                }
                int parseColor = Color.parseColor("#CCCCCC");
                this.k.setTextColor(Color.parseColor("#252525"));
                this.l.setTextColor(Color.parseColor("#aa252525"));
                a(Color.red(parseColor), Color.green(parseColor), Color.blue(parseColor));
            } else {
                this.f29902i.setVisibility(8);
                this.m.setVisibility(8);
                a(this.f29900g, a4, bVar);
            }
            this.f29901h = com.vivo.mobilead.unified.base.view.u.c.a(this, this.f29901h, this.p, context, this.f29900g, this.u);
        }
        if (a2 != null) {
            this.f29895b.addView(a2);
        }
        a(bVar);
        g();
    }

    protected void a(ViewGroup viewGroup, Bitmap bitmap, com.vivo.ad.model.b bVar) {
        if (bVar == null || bitmap == null || bitmap.isRecycled()) {
            return;
        }
        com.vivo.ad.model.e c2 = bVar.c();
        int v = c2 != null ? c2.v() : 0;
        if (v == 1) {
            viewGroup.addView(a(bitmap, false));
        } else if (v == 2) {
            viewGroup.addView(a(bitmap, true));
        } else {
            viewGroup.addView(a(bitmap));
        }
    }

    protected void a(AdError adError) {
        if (this.o == null || this.r) {
            return;
        }
        this.r = true;
        adError.setRequestId(this.p.G());
        this.o.a(new VivoAdError(adError.getErrorMsg(), adError.getErrorCode()));
    }

    private View a(Bitmap bitmap, boolean z) {
        u uVar = new u(getContext());
        uVar.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        uVar.setOnADWidgetClickListener(this);
        uVar.a(bitmap, z);
        return uVar;
    }

    private View a(Bitmap bitmap) {
        com.vivo.ad.view.b bVar = new com.vivo.ad.view.b(getContext());
        bVar.setScaleType(ImageView.ScaleType.CENTER_CROP);
        bVar.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        bVar.setOnADWidgetClickListener(this);
        bVar.setImageBitmap(bitmap);
        return bVar;
    }

    protected void a(com.vivo.ad.model.b bVar) {
        if (bVar != null) {
            this.f29898e.a(com.vivo.mobilead.h.b.a().a(bVar.e()), bVar.k(), bVar.O());
            this.f29895b.addView(this.f29898e);
        }
    }

    protected void a(int i2) {
        this.f29897d.setText(String.format("点击跳过 %d", Integer.valueOf(i2)));
    }

    protected void a(int i2, int i3, int i4) {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.argb(179, i2, i3, i4), Color.argb(90, i2, i3, i4)});
        if (Build.VERSION.SDK_INT >= 16) {
            this.f29900g.setBackground(gradientDrawable);
        } else {
            this.f29900g.setBackgroundDrawable(gradientDrawable);
        }
    }

    protected void a(Bitmap bitmap, int i2) {
        this.f29903j.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f29903j.setImageBitmap(bitmap);
        boolean z = Color.red(i2) - Color.red(-16777216) < 30 && Color.green(i2) - Color.green(-16777216) < 30 && Color.blue(i2) - Color.red(-16777216) < 30;
        boolean z2 = Color.red(-1) - Color.red(i2) < 30 && Color.blue(-1) - Color.blue(i2) < 30 && Color.green(-1) - Color.green(i2) < 30;
        if (z || z2) {
            i2 = Color.parseColor("#CCCCCC");
            this.k.setTextColor(Color.parseColor("#252525"));
            this.l.setTextColor(Color.parseColor("#aa252525"));
        }
        a(Color.red(i2), Color.green(i2), Color.blue(i2));
    }

    @Override // com.vivo.ad.view.k
    public void a(View view, int i2, int i3, int i4, int i5, boolean z) {
        x0.a("SplashAd", "ad click:" + i2 + " " + i3);
        com.vivo.mobilead.unified.base.callback.l lVar = this.o;
        if (lVar != null) {
            lVar.a(this.p, i2, i3, i4, i5, z);
        }
    }

    @Override // com.vivo.mobilead.unified.base.view.u.b
    public void a(int i2, double d2, View view, int i3, int i4, int i5, int i6) {
        com.vivo.mobilead.unified.base.callback.l lVar = this.o;
        if (lVar != null) {
            lVar.a(i2, d2, view, i3, i4, i5, i6);
        }
    }

    @Override // com.vivo.mobilead.unified.base.view.u.b
    public void a(double d2, double d3) {
        com.vivo.mobilead.unified.base.callback.l lVar = this.o;
        if (lVar != null) {
            lVar.a(d2, d3);
        }
    }
}
