package com.vivo.mobilead.unified.interstitial.l;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.vivo.ad.e.e;
import com.vivo.ad.model.a0;
import com.vivo.ad.view.p;
import com.vivo.ad.view.v;
import com.vivo.mobilead.util.k0;
import com.vivo.mobilead.util.x0;
import com.vivo.mobilead.util.y0;
import com.vivo.mobilead.util.z;
import java.io.File;

/* loaded from: classes4.dex */
public class c extends RelativeLayout implements com.vivo.mobilead.unified.base.view.u.b {
    private boolean A;
    private v B;
    private int C;
    private int D;
    private int E;
    private com.vivo.ad.e.e F;
    private p.h G;
    private DialogInterface.OnShowListener H;
    private DialogInterface.OnDismissListener I;
    private boolean J;
    private com.vivo.mobilead.unified.base.view.f K;
    private com.vivo.mobilead.d.a L;
    private Handler M;
    private Runnable N;

    /* renamed from: a */
    private String f30395a;

    /* renamed from: b */
    private Activity f30396b;

    /* renamed from: c */
    private com.vivo.mobilead.d.e f30397c;

    /* renamed from: d */
    private ImageView f30398d;

    /* renamed from: e */
    private ImageView f30399e;

    /* renamed from: f */
    private ImageView f30400f;

    /* renamed from: g */
    private com.vivo.ad.h.b.l f30401g;

    /* renamed from: h */
    private com.vivo.ad.h.b.g f30402h;

    /* renamed from: i */
    private com.vivo.ad.h.b.c f30403i;

    /* renamed from: j */
    private boolean f30404j;
    private int k;
    private int l;
    private int m;
    private int n;
    private com.vivo.ad.model.b o;
    private int p;
    private int q;
    private int r;
    private boolean s;
    private s t;
    private int u;
    private int v;
    private com.vivo.mobilead.unified.base.view.t.a w;
    private com.vivo.mobilead.unified.base.view.p.a x;
    private View y;
    private int z;

    class a extends com.vivo.ad.view.l {

        /* renamed from: a */
        final /* synthetic */ boolean f30405a;

        a(boolean z) {
            this.f30405a = z;
        }

        @Override // com.vivo.ad.view.l
        public void a(View view, int i2, int i3, int i4, int i5, double d2, double d3, boolean z) {
            c cVar = c.this;
            cVar.a(i2, i3, i4, i5, 0.0d, 0.0d, this.f30405a, cVar.t != null, 2);
        }
    }

    class b implements com.vivo.ad.view.k {

        /* renamed from: a */
        final /* synthetic */ boolean f30407a;

        /* renamed from: b */
        final /* synthetic */ boolean f30408b;

        b(boolean z, boolean z2) {
            this.f30407a = z;
            this.f30408b = z2;
        }

        @Override // com.vivo.ad.view.k
        public void a(View view, int i2, int i3, int i4, int i5, boolean z) {
            c cVar = c.this;
            cVar.a(i2, i3, i4, i5, 0.0d, 0.0d, this.f30407a, this.f30408b && cVar.t != null, 1);
        }
    }

    /* renamed from: com.vivo.mobilead.unified.interstitial.l.c$c */
    class C0655c implements com.vivo.ad.view.k {
        C0655c() {
        }

        @Override // com.vivo.ad.view.k
        public void a(View view, int i2, int i3, int i4, int i5, boolean z) {
            if (c.this.f30397c != null) {
                c.this.f30397c.performClick();
            }
        }
    }

    class d extends com.vivo.mobilead.util.b1.a.c.b {

        class a extends com.vivo.mobilead.util.f1.b {

            /* renamed from: a */
            final /* synthetic */ byte[] f30412a;

            /* renamed from: b */
            final /* synthetic */ File f30413b;

            a(byte[] bArr, File file) {
                this.f30412a = bArr;
                this.f30413b = file;
            }

            @Override // com.vivo.mobilead.util.f1.b
            public void safelyRun() {
                c.this.f30402h.a(this.f30412a, this.f30413b);
            }
        }

        d() {
        }

        @Override // com.vivo.mobilead.util.b1.a.c.b, com.vivo.mobilead.util.b1.a.c.a
        public void a(String str, byte[] bArr, File file) {
            z.b().a(new a(bArr, file));
        }
    }

    class e implements com.vivo.ad.view.k {

        /* renamed from: a */
        final /* synthetic */ boolean f30415a;

        e(boolean z) {
            this.f30415a = z;
        }

        @Override // com.vivo.ad.view.k
        public void a(View view, int i2, int i3, int i4, int i5, boolean z) {
            if (c.this.t != null) {
                c.this.t.a(i2, i3, i4, i5, 0.0d, 0.0d, false, this.f30415a, 1, 2, false);
            }
        }
    }

    class f implements com.vivo.mobilead.unified.base.callback.i {

        /* renamed from: a */
        final /* synthetic */ boolean f30417a;

        /* renamed from: b */
        final /* synthetic */ boolean f30418b;

        f(boolean z, boolean z2) {
            this.f30417a = z;
            this.f30418b = z2;
        }

        @Override // com.vivo.mobilead.unified.base.callback.i
        public void a(View view, int i2, int i3) {
            if (!this.f30417a || c.this.t == null) {
                return;
            }
            c.this.t.a(c.this.k, c.this.l, i2, i3, 0.0d, 0.0d, false, this.f30418b, 1, 1, false);
        }
    }

    class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.t != null) {
                c.this.t.onAdClose();
            }
        }
    }

    class h implements com.vivo.mobilead.d.a {

        class a extends com.vivo.mobilead.util.f1.b {
            a() {
            }

            @Override // com.vivo.mobilead.util.f1.b
            public void safelyRun() {
                c.this.f30403i.setVisibility(0);
                c.this.f30403i.setShowCloseButton(true);
            }
        }

        h() {
        }

        @Override // com.vivo.mobilead.d.a
        public void a() {
        }

        @Override // com.vivo.mobilead.d.a
        public void a(int i2) {
        }

        @Override // com.vivo.mobilead.d.a
        public void a(int i2, int i3, String str) {
            c.this.M.removeCallbacks(c.this.N);
            c.this.M.post(new a());
            c.this.s = false;
            if (c.this.t != null) {
                c.this.t.a(i2, i3, str);
            }
        }

        @Override // com.vivo.mobilead.d.a
        public void a(long j2, long j3) {
        }

        @Override // com.vivo.mobilead.d.a
        public void b() {
            c cVar = c.this;
            cVar.r = cVar.f30397c.getDuration();
            c.this.f30403i.setVisibility(0);
            c.this.f30403i.setVideoLength(c.this.r / 1000);
            if (c.this.f30398d != null) {
                c.this.f30397c.removeView(c.this.f30398d);
            }
            if (c.this.t != null) {
                c.this.t.b();
            }
        }

        @Override // com.vivo.mobilead.d.a
        public void onVideoCompletion() {
            c.this.M.removeCallbacks(c.this.N);
            c.this.s = false;
            if (c.this.t != null) {
                c.this.t.onVideoCompletion();
            }
        }

        @Override // com.vivo.mobilead.d.a
        public void onVideoPause() {
            c.this.M.removeCallbacks(c.this.N);
            if (c.this.t != null) {
                c.this.t.onVideoPause();
            }
        }

        @Override // com.vivo.mobilead.d.a
        public void onVideoResume() {
            c.this.M.removeCallbacks(c.this.N);
            c.this.M.postDelayed(c.this.N, 1000L);
            if (c.this.t != null) {
                c.this.t.onVideoResume();
            }
        }

        @Override // com.vivo.mobilead.d.a
        public void onVideoStart() {
            if (c.this.t != null) {
                c.this.t.onVideoStart();
            }
        }
    }

    class i extends com.vivo.mobilead.util.f1.b {

        /* renamed from: a */
        private int f30423a = 0;

        i() {
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            this.f30423a++;
            int currentPosition = c.this.f30397c.getCurrentPosition();
            if ((this.f30423a * 1000) % c.this.v == 0) {
                if (currentPosition - c.this.u < 1000) {
                    c.this.j();
                    return;
                }
                c.this.u = currentPosition;
            }
            if (c.this.r == 0 && this.f30423a > c.this.q) {
                x0.b(com.vivo.mobilead.util.f1.b.TAG, "videoLoadCloseBtn:" + c.this.q + ",count=" + this.f30423a);
                c.this.f30403i.setVisibility(0);
                c.this.f30403i.setShowCloseButton(true);
            }
            if (c.this.r > 0) {
                if (currentPosition + 1000 > c.this.r * (c.this.p / 100.0f)) {
                    c.this.f30403i.setVisibility(0);
                    c.this.f30403i.setShowCloseButton(true);
                }
                c.this.f30403i.setVisibility(0);
                c.this.f30403i.setVideoLength((c.this.r - currentPosition) / 1000);
            }
            c.this.M.postDelayed(this, 1000L);
        }
    }

    class j implements View.OnClickListener {
        j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.t != null) {
                c.this.t.a(c.this.k, c.this.l, c.this.m, c.this.n, 0.0d, 0.0d, true, com.vivo.mobilead.util.e.i(c.this.o), 1, 3, false);
            }
        }
    }

    class k implements View.OnClickListener {
        k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.f30397c != null) {
                c.this.f30397c.g();
            }
            if (c.this.M != null) {
                c.this.M.removeCallbacks(c.this.N);
            }
            if (c.this.t != null) {
                c.this.t.onAdClose();
            }
        }
    }

    class l implements View.OnClickListener {
        l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            x0.b("InterstitialPlayer", "isMute = " + c.this.f30404j);
            c cVar = c.this;
            cVar.f30404j = cVar.f30404j ^ true;
            c.this.l();
        }
    }

    class m implements View.OnClickListener {
        m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c cVar = c.this;
            cVar.removeView(cVar.f30399e);
            c.this.i();
        }
    }

    class n extends com.vivo.mobilead.util.b1.a.c.b {

        class a extends com.vivo.mobilead.util.f1.b {

            /* renamed from: a */
            final /* synthetic */ byte[] f30430a;

            /* renamed from: b */
            final /* synthetic */ File f30431b;

            a(byte[] bArr, File file) {
                this.f30430a = bArr;
                this.f30431b = file;
            }

            @Override // com.vivo.mobilead.util.f1.b
            public void safelyRun() {
                c.this.f30401g.setIconGifRoundWithOverlayColor(c.this.C);
                c.this.f30401g.a(this.f30430a, this.f30431b);
            }
        }

        n() {
        }

        @Override // com.vivo.mobilead.util.b1.a.c.b, com.vivo.mobilead.util.b1.a.c.a
        public void a(String str, byte[] bArr, File file) {
            super.a(str, bArr, file);
            c.this.post(new a(bArr, file));
        }
    }

    class o implements com.vivo.ad.view.k {

        /* renamed from: a */
        final /* synthetic */ boolean f30433a;

        o(boolean z) {
            this.f30433a = z;
        }

        @Override // com.vivo.ad.view.k
        public void a(View view, int i2, int i3, int i4, int i5, boolean z) {
            if (c.this.t != null) {
                c.this.t.a(i2, i3, i4, i5, 0.0d, 0.0d, false, this.f30433a, 1, 2, false);
            }
        }
    }

    class p implements com.vivo.mobilead.unified.base.callback.i {

        /* renamed from: a */
        final /* synthetic */ boolean f30435a;

        /* renamed from: b */
        final /* synthetic */ boolean f30436b;

        p(boolean z, boolean z2) {
            this.f30435a = z;
            this.f30436b = z2;
        }

        @Override // com.vivo.mobilead.unified.base.callback.i
        public void a(View view, int i2, int i3) {
            if (!this.f30435a || c.this.t == null) {
                return;
            }
            c.this.t.a(c.this.k, c.this.l, i2, i3, 0.0d, 0.0d, false, this.f30436b, 1, 1, false);
        }
    }

    class q implements com.vivo.ad.view.k {

        /* renamed from: a */
        final /* synthetic */ boolean f30438a;

        /* renamed from: b */
        final /* synthetic */ boolean f30439b;

        q(boolean z, boolean z2) {
            this.f30438a = z;
            this.f30439b = z2;
        }

        @Override // com.vivo.ad.view.k
        public void a(View view, int i2, int i3, int i4, int i5, boolean z) {
            if (!this.f30438a || c.this.t == null) {
                return;
            }
            if (com.vivo.mobilead.util.q.a(c.this.o)) {
                c.this.t.a(i2, i3, i4, i5, 0.0d, 0.0d, false, this.f30439b, 1, 1, true);
            } else {
                c.this.t.a(i2, i3, i4, i5, 0.0d, 0.0d, false, this.f30439b, 1, 1, false);
            }
        }
    }

    class r implements com.vivo.mobilead.unified.base.callback.b {

        /* renamed from: a */
        final /* synthetic */ boolean f30441a;

        /* renamed from: b */
        final /* synthetic */ boolean f30442b;

        /* renamed from: c */
        final /* synthetic */ boolean f30443c;

        r(boolean z, boolean z2, boolean z3) {
            this.f30441a = z;
            this.f30442b = z2;
            this.f30443c = z3;
        }

        @Override // com.vivo.mobilead.unified.base.callback.b
        public void a() {
        }

        @Override // com.vivo.mobilead.unified.base.callback.b
        public void a(int i2, int i3, int i4, int i5) {
            c cVar = c.this;
            cVar.a(i2, i3, i4, i5, 0.0d, 0.0d, this.f30442b, this.f30443c && cVar.t != null, 1);
        }

        @Override // com.vivo.mobilead.unified.base.callback.b
        public void b(int i2, int i3, int i4, int i5) {
            c cVar = c.this;
            cVar.a(i2, i3, i4, i5, 0.0d, 0.0d, this.f30441a, cVar.t != null, 2);
        }
    }

    public interface s extends com.vivo.mobilead.d.a {
        void a(int i2, int i3, int i4, int i5, double d2, double d3, boolean z, boolean z2, int i6, int i7, boolean z3);

        void onAdClose();
    }

    public c(Activity activity, String str) {
        this(activity, null, 0);
        this.f30396b = activity;
        this.f30395a = str;
    }

    @Override // com.vivo.mobilead.unified.base.view.u.b
    public void a(int i2, double d2, View view, int i3, int i4, int i5, int i6) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.k = (int) motionEvent.getRawX();
            this.l = (int) motionEvent.getRawY();
            this.m = (int) motionEvent.getX();
            this.n = (int) motionEvent.getY();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return super.generateLayoutParams(attributeSet);
    }

    public int getCurrentPosition() {
        com.vivo.mobilead.d.e eVar = this.f30397c;
        if (eVar == null) {
            return 0;
        }
        return eVar.getCurrentPosition();
    }

    public int getDuration() {
        return this.r;
    }

    protected int getMaterialStyle() {
        return this.z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public /* bridge */ /* synthetic */ ViewOverlay getOverlay() {
        return super.getOverlay();
    }

    public Rect getVideoVisibleRect() {
        Rect rect = new Rect();
        this.f30397c.getGlobalVisibleRect(rect);
        if (this.f30401g != null) {
            Rect rect2 = new Rect();
            this.f30401g.getGlobalVisibleRect(rect2);
            rect.bottom = rect2.top;
        }
        return rect;
    }

    public void setCallback(s sVar) {
        this.t = sVar;
    }

    public void setData(com.vivo.ad.model.b bVar) {
        if (bVar != null) {
            this.o = bVar;
            if (bVar.c() != null) {
                this.D = this.o.c().f26882g;
                this.E = this.o.c().f26883h;
                this.p = this.o.c().p();
                int A = this.o.c().A();
                this.q = A;
                if (A > 0) {
                    this.v = A * 1000;
                }
                this.f30397c.a(this.E, this.D);
            }
        }
    }

    public void setFeedBackDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.I = onDismissListener;
    }

    public void setFeedBackShowListener(DialogInterface.OnShowListener onShowListener) {
        this.H = onShowListener;
    }

    public void j() {
        Handler handler = this.M;
        if (handler != null) {
            handler.removeCallbacks(this.N);
        }
        com.vivo.mobilead.d.e eVar = this.f30397c;
        if (eVar != null) {
            eVar.g();
        }
        this.s = false;
        s sVar = this.t;
        if (sVar != null) {
            sVar.a(-99, -99, "视频播放卡顿");
        }
    }

    private boolean k() {
        return getContext().getResources().getConfiguration().orientation == 2;
    }

    public void l() {
        if (this.f30404j) {
            this.f30400f.setImageBitmap(com.vivo.mobilead.util.g.a(getContext(), "vivo_module_afk_ctrl_mute.png"));
        } else {
            this.f30400f.setImageBitmap(com.vivo.mobilead.util.g.a(getContext(), "vivo_module_afk_ctrl_vol_resume.png"));
        }
        this.f30397c.setMute(this.f30404j);
    }

    public void c() {
        double d2;
        double d3;
        double d4;
        v vVar = this.B;
        if (vVar != null) {
            d2 = vVar.b();
            d3 = this.B.d();
            d4 = this.B.c();
        } else {
            d2 = 0.0d;
            d3 = 0.0d;
            d4 = 0.0d;
        }
        k0.a(this.o, this.f30395a, d2, d3, d4);
        com.vivo.mobilead.d.e eVar = this.f30397c;
        if (eVar != null) {
            eVar.g();
        }
        com.vivo.mobilead.unified.base.view.f fVar = this.K;
        if (fVar != null) {
            fVar.a();
            this.K = null;
        }
        removeAllViews();
        this.M.removeCallbacks(this.N);
    }

    public void d() {
        com.vivo.mobilead.d.e eVar = this.f30397c;
        if (eVar != null) {
            eVar.d();
        }
    }

    public void e() {
        com.vivo.mobilead.d.e eVar = this.f30397c;
        if (eVar == null || !this.s) {
            return;
        }
        eVar.h();
    }

    public void f() {
        if (getContext() == null || this.J) {
            return;
        }
        if (this.K == null) {
            this.K = new com.vivo.mobilead.unified.base.view.f(getContext());
        }
        this.K.a(this.f30403i.a() ? "请点击关闭按钮进行关闭" : "请待关闭按钮出现进行关闭");
    }

    public void g() {
        e.g gVar = new e.g(this.f30396b, this.o, this.f30395a);
        gVar.a(this.G);
        gVar.a(this.H);
        gVar.a(this.I);
        com.vivo.ad.e.e eVar = this.F;
        if (eVar != null) {
            eVar.a(gVar);
            return;
        }
        this.F = gVar.b();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(9);
        int a2 = com.vivo.mobilead.util.m.a(getContext(), 20.0f);
        layoutParams.leftMargin = a2;
        layoutParams.topMargin = a2;
        addView(this.F, layoutParams);
    }

    public void h() {
        ImageView imageView = new ImageView(getContext());
        this.f30399e = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.f30399e.setImageBitmap(com.vivo.mobilead.util.g.a(getContext(), "vivo_module_video_pause.png"));
        Bitmap a2 = com.vivo.mobilead.h.b.a().a(this.o.Q().d());
        ImageView imageView2 = new ImageView(getContext());
        this.f30398d = imageView2;
        imageView2.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.f30398d.setImageBitmap(a2);
        this.f30398d.setOnClickListener(new m());
        this.f30397c.addView(this.f30398d, 1, new RelativeLayout.LayoutParams(-1, -1));
        int a3 = com.vivo.mobilead.util.m.a(getContext(), 64.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a3, a3);
        layoutParams.addRule(13);
        addView(this.f30399e, layoutParams);
        this.f30403i.setVisibility(0);
        this.f30403i.setShowCloseButton(true);
    }

    public void i() {
        com.vivo.ad.model.b bVar = this.o;
        if (bVar == null) {
            s sVar = this.t;
            if (sVar != null) {
                sVar.a(-99, -99, "video data error!");
                return;
            }
            return;
        }
        this.f30397c.a(bVar.Q().g(), this.o.C(), this.o.G());
        this.f30397c.e();
        this.f30397c.h();
        this.f30397c.setMute(this.f30404j);
        this.J = false;
        this.M.removeCallbacks(this.N);
        this.M.postDelayed(this.N, 1000L);
    }

    public c(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f30404j = false;
        this.p = 80;
        this.q = 5;
        this.r = 0;
        this.s = true;
        this.u = 0;
        this.v = 5000;
        this.C = 0;
        this.J = false;
        this.L = new h();
        this.M = new Handler(Looper.getMainLooper());
        this.N = new i();
        a(context);
    }

    private void b(String str, boolean z, String str2, boolean z2, boolean z3, p.h hVar) {
        this.C = com.vivo.mobilead.util.i.a("#E6FFFFFF");
        a(str, z, str2, z2, z3, hVar);
        this.f30401g.setBackgroundColor(com.vivo.mobilead.util.i.a("#E6FFFFFF"));
        this.f30401g.b();
        View a2 = a(z3);
        this.y = a2;
        if (a2 != null) {
            if (a2.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) this.y.getLayoutParams()).addRule(2, this.f30401g.getId());
            }
            addView(this.y);
        }
    }

    private void a(Context context) {
        com.vivo.mobilead.d.e eVar = new com.vivo.mobilead.d.e(context);
        this.f30397c = eVar;
        eVar.setMediaCallback(this.L);
        this.f30397c.setOnClickListener(new j());
        addView(this.f30397c, new RelativeLayout.LayoutParams(-1, -1));
        int a2 = com.vivo.mobilead.util.m.a(getContext(), 15.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        com.vivo.ad.h.b.c cVar = new com.vivo.ad.h.b.c(getContext());
        this.f30403i = cVar;
        cVar.setId(y0.a());
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, a2, a2, 0);
        this.f30403i.setLayoutParams(layoutParams);
        this.f30403i.setShowCloseButton(false);
        this.f30403i.setOnCloseClickListener(new k());
        this.f30403i.setVisibility(8);
        addView(this.f30403i);
        ImageView imageView = new ImageView(getContext());
        this.f30400f = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.f30400f.setOnClickListener(new l());
        this.f30400f.setId(y0.a());
    }

    private void b(boolean z, String str, boolean z2, boolean z3, p.h hVar) {
        com.vivo.mobilead.unified.base.view.p.a aVar = new com.vivo.mobilead.unified.base.view.p.a(this.f30396b, com.vivo.mobilead.util.m.e(getContext()));
        this.x = aVar;
        aVar.b(this.o, this.C);
        this.x.setId(y0.a());
        this.x.setBannerClickListener(new r(z3, z2, z));
        this.x.setFiveElementDialogListener(hVar);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        addView(this.x, layoutParams);
        View a2 = a(z3);
        this.y = a2;
        if (a2 != null) {
            a2.setId(y0.a());
            if (this.y.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) this.y.getLayoutParams()).addRule(2, this.x.getId());
            }
            addView(this.y);
        }
        a(0, this.x);
    }

    public void a(String str, p.h hVar, String str2) {
        this.G = hVar;
        boolean b2 = com.vivo.mobilead.util.c.b(this.o);
        boolean d2 = com.vivo.mobilead.util.e.d(this.o);
        this.A = com.vivo.mobilead.util.e.e(this.o);
        this.z = -999;
        if (k()) {
            if (this.o.u() == 101) {
                this.z = 101;
                a(b2, str2, d2, this.A, hVar);
                return;
            } else if (this.o.u() == 102) {
                this.z = 102;
                b(str, b2, str2, d2, this.A, hVar);
                return;
            } else {
                this.C = -1;
                a(str, b2, str2, d2, this.A, hVar);
                return;
            }
        }
        if (this.o.B() == 1) {
            this.z = 1;
            this.C = com.vivo.mobilead.util.i.a("#E6FFFFFF");
            b(b2, str2, d2, this.A, hVar);
        } else {
            this.C = -1;
            a(str, b2, str2, d2, this.A, hVar);
        }
    }

    private void a(String str, boolean z, String str2, boolean z2, boolean z3, p.h hVar) {
        Bitmap a2;
        a0 Q = this.o.Q();
        this.o.j();
        String e2 = Q.e();
        String a3 = Q.a();
        String b2 = com.vivo.mobilead.util.f.b(this.o);
        com.vivo.ad.h.b.l lVar = new com.vivo.ad.h.b.l(getContext(), k());
        this.f30401g = lVar;
        lVar.a();
        this.f30401g.setId(y0.a());
        this.f30401g.a(this.o, k(), this.C);
        this.f30401g.setId(y0.a());
        if (!TextUtils.isEmpty(b2) && b2.endsWith(".gif")) {
            com.vivo.mobilead.util.b1.a.b.b().a(b2, new n());
            a2 = null;
        } else {
            a2 = com.vivo.mobilead.h.b.a().a(b2);
        }
        if (a2 != null) {
            this.f30401g.setIcon(a2);
        }
        this.f30401g.setTitle(e2);
        this.f30401g.setDesc(a3);
        this.f30401g.setBtnText(str);
        this.f30401g.setBtnClick(new o(z3));
        this.f30401g.setBgClick(new p(z, z2));
        this.f30401g.setFiveElementClickListener(new q(z, z2));
        this.f30401g.a(this.o, hVar, str2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.vivo.mobilead.util.m.a(getContext(), (!com.vivo.mobilead.util.q.a(this.o) || 2 == com.vivo.mobilead.util.m.c(getContext())) ? 75 : 90));
        layoutParams.addRule(12);
        addView(this.f30401g, layoutParams);
        View a4 = a(z3);
        this.y = a4;
        if (a4 != null) {
            if (a4.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) this.y.getLayoutParams()).addRule(2, this.f30401g.getId());
            }
            addView(this.y);
        }
        a(0, this.f30401g);
    }

    private void a(boolean z, String str, boolean z2, boolean z3, p.h hVar) {
        com.vivo.mobilead.unified.base.view.t.a aVar = new com.vivo.mobilead.unified.base.view.t.a(this.f30396b);
        this.w = aVar;
        aVar.a(this.o, str);
        this.w.setBtnClick(new a(z3));
        this.w.setBgClick(new b(z2, z));
        this.w.setFiveElementDialogListener(hVar);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(21);
        layoutParams.addRule(12);
        addView(this.w, layoutParams);
        View a2 = a(z3);
        this.y = a2;
        if (a2 != null) {
            if (a2.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) this.y.getLayoutParams()).addRule(12);
            }
            addView(this.y);
        }
        a(com.vivo.mobilead.util.m.b(getContext(), 20.0f), (View) null);
    }

    private View a(boolean z) {
        v vVar = new v(getContext(), this.o, new C0655c(), this);
        this.B = vVar;
        return vVar.a();
    }

    public void a(int i2, int i3, int i4, int i5, double d2, double d3, boolean z, boolean z2, int i6) {
        if (z2) {
            this.t.a(i2, i3, i4, i5, d2, d3, false, z, 1, i6, false);
        }
    }

    private void a(int i2, View view) {
        this.f30400f.setVisibility(0);
        int b2 = com.vivo.mobilead.util.m.b(getContext(), 27.0f);
        int a2 = com.vivo.mobilead.util.m.a(getContext(), 15.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(b2, b2);
        layoutParams.setMargins(a2, 0, 0, i2 + a2);
        if (view != null) {
            layoutParams.addRule(2, view.getId());
        } else {
            layoutParams.addRule(12);
        }
        layoutParams.addRule(9);
        addView(this.f30400f, layoutParams);
        l();
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, String str, String str2, float f2, String str3, com.vivo.ad.model.b bVar, String str4, String str5, String str6, boolean z, boolean z2, boolean z3, String str7) {
        View view = this.y;
        if (view instanceof com.vivo.ad.view.h) {
            ((com.vivo.ad.view.h) view).a();
        }
        this.J = true;
        if (k()) {
            this.f30402h = new com.vivo.ad.h.b.h(getContext());
        } else {
            this.f30402h = new com.vivo.ad.h.b.j(getContext());
        }
        this.f30402h.setBg(bitmap);
        this.f30402h.a(str4, str5, str6);
        if (bitmap2 != null) {
            this.f30402h.setIcon(bitmap2);
        } else {
            com.vivo.mobilead.util.b1.a.b.b().a(str7, new d());
        }
        this.f30402h.setTitle(str);
        this.f30402h.setDesc(str2);
        if (f2 == -1.0f) {
            this.f30402h.setScoreState(false);
        } else {
            this.f30402h.setScoreState(true);
            this.f30402h.setScore(f2);
            this.f30402h.setDownloadCount(str3);
        }
        this.f30402h.setBtnText(bVar);
        this.f30402h.setBtnClick(new e(z3));
        this.f30402h.setBgClick(new f(z, z2));
        this.f30402h.setCloseClick(new g());
        addView(this.f30402h.getView(), new RelativeLayout.LayoutParams(-1, -1));
        this.s = false;
    }

    @Override // com.vivo.mobilead.unified.base.view.u.b
    public void a(double d2, double d3) {
        a(this.k, this.l, this.m, this.n, d2, d3, com.vivo.mobilead.util.e.e(this.o), this.t != null, 3);
    }
}
