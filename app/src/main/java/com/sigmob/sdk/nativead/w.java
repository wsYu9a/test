package com.sigmob.sdk.nativead;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.ClickCommon;
import com.sigmob.sdk.base.models.IntentActions;
import com.sigmob.sdk.base.models.PlacementType;
import com.sigmob.sdk.base.views.q;
import com.sigmob.sdk.mraid.a;
import com.sigmob.sdk.mraid.d;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.natives.WindNativeAdData;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class w extends com.sigmob.sdk.base.common.j {

    /* renamed from: x */
    public static o f20079x;

    /* renamed from: i */
    public final long f20080i;

    /* renamed from: j */
    public b0 f20081j;

    /* renamed from: k */
    public b0 f20082k;

    /* renamed from: l */
    public RelativeLayout f20083l;

    /* renamed from: m */
    public FrameLayout f20084m;

    /* renamed from: n */
    public BaseAdUnit f20085n;

    /* renamed from: o */
    public com.sigmob.sdk.nativead.c f20086o;

    /* renamed from: p */
    public com.sigmob.sdk.mraid.d f20087p;

    /* renamed from: q */
    public View f20088q;

    /* renamed from: r */
    public WindNativeAdData f20089r;

    /* renamed from: s */
    public APKStatusBroadcastReceiver f20090s;

    /* renamed from: t */
    public ImageView f20091t;

    /* renamed from: u */
    public com.sigmob.sdk.base.views.q f20092u;

    /* renamed from: v */
    public boolean f20093v;

    /* renamed from: w */
    public boolean f20094w;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            w.this.g().onBackPressed();
        }
    }

    public class b implements ViewTreeObserver.OnPreDrawListener {
        public b() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (w.f20079x == null || w.this.f20084m == null) {
                return false;
            }
            w.this.f20084m.getViewTreeObserver().removeOnPreDrawListener(this);
            w.f20079x.setUIStyle(com.sigmob.sdk.nativead.g.DETAIL_PAGE);
            ViewGroup videoContainer = w.f20079x.getVideoContainer();
            if (videoContainer != null) {
                com.sigmob.sdk.base.utils.e.e(videoContainer);
                w.this.f20084m.addView(videoContainer, new FrameLayout.LayoutParams(-1, -1));
            }
            w.this.f20082k = new b0();
            int[] iArr = new int[2];
            w.this.f20084m.getLocationOnScreen(iArr);
            w.this.f20082k.c(iArr[0]);
            w.this.f20082k.d(0);
            w.this.f20082k.b(w.this.f20084m.getMeasuredWidth());
            w.this.f20082k.a(w.this.f20084m.getMeasuredHeight());
            new c0(w.this.f20084m, w.this.f20081j, w.this.f20082k, 300L).a();
            w.this.f20081j.d(w.this.f20081j.d() - iArr[1]);
            if (w.this.f20083l != null) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(300L);
                w.this.f20083l.setAnimation(alphaAnimation);
                alphaAnimation.start();
            }
            return true;
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            w.this.g().onBackPressed();
        }
    }

    public class d implements d.g {

        public class a implements q.g {
            public a() {
            }

            @Override // com.sigmob.sdk.base.views.q.g
            public void a(String str, String str2) {
                w.this.f20085n.getClickCommon().click_area = ClickCommon.CLICK_AREA_BTN;
                w.this.f20085n.getClickCommon().click_scene = "appinfo";
                w.this.f20085n.getClickCommon().is_final_click = true;
                if (w.this.f20086o != null) {
                    w.this.f20086o.b(com.sigmob.sdk.base.a.COMPANION, str, str2, true);
                    w.this.a(IntentActions.ACTION_NATIVE_TEMPLE_CLICK);
                }
            }

            @Override // com.sigmob.sdk.base.views.q.g
            public void b() {
                w.this.t().a(com.sigmob.sdk.base.common.a.f17653f, 0);
            }

            @Override // com.sigmob.sdk.base.views.q.g
            public void a() {
                if (w.this.f20092u != null) {
                    w.this.f20092u.dismiss();
                    w.this.f20092u.b();
                    w.this.f20092u = null;
                    w.this.f20093v = false;
                }
                w.this.f20085n.getClickCommon().click_scene = "template";
                w.this.t().a(com.sigmob.sdk.base.common.a.f17654g, 0);
            }
        }

        public d() {
        }

        @Override // com.sigmob.sdk.mraid.d.g
        public void a() {
            SigmobLog.i("SigNativeAdLandViewController onClose()");
            w.this.g().onBackPressed();
        }

        @Override // com.sigmob.sdk.mraid.d.g
        public void b(float f10) {
            SigmobLog.d("SigNativeAdLandViewController onSkip()");
        }

        @Override // com.sigmob.sdk.mraid.d.g
        public void c() {
            SigmobLog.i("SigNativeAdLandViewController onUnload()");
        }

        @Override // com.sigmob.sdk.mraid.d.g
        public void d() {
        }

        @Override // com.sigmob.sdk.mraid.d.g
        public void e() {
            SigmobLog.i("SigNativeAdLandViewController onFailedToLoad()");
        }

        @Override // com.sigmob.sdk.mraid.d.g
        public void f() {
            SigmobLog.i("SigNativeAdLandViewController onOpenFourElements()");
            if (w.this.f20092u == null) {
                w.this.f20092u = new com.sigmob.sdk.base.views.q(w.this.f(), w.this.f20085n);
                w.this.f20092u.a(new a());
            }
            if (w.this.f20092u == null || !w.this.f20092u.e() || w.this.f20093v) {
                return;
            }
            w.this.f20085n.getClickCommon().click_area = "appinfo";
            w.this.f20085n.getClickCommon().is_final_click = false;
            w.this.t().a("click", 0);
            w.this.f20092u.show();
            w.this.f20093v = true;
        }

        @Override // com.sigmob.sdk.mraid.d.g
        public void g() {
            SigmobLog.d("SigNativeAdLandViewController onExpand()");
        }

        @Override // com.sigmob.sdk.mraid.d.g
        public void h() {
            SigmobLog.d("SigNativeAdLandViewController onShowSkipTime()");
        }

        @Override // com.sigmob.sdk.mraid.d.g
        public void i() {
            SigmobLog.d("SigNativeAdLandViewController onEndCardShow()");
        }

        @Override // com.sigmob.sdk.mraid.d.g
        public void a(String str) {
            SigmobLog.i("SigNativeAdLandViewController onCompanionClick:" + str);
            boolean z10 = true;
            if (!TextUtils.isEmpty(str)) {
                try {
                    w.this.f20085n.getClickCommon().click_area = ClickCommon.CLICK_AREA_BTN;
                    w.this.f20085n.getClickCommon().is_final_click = true;
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("type");
                    w.this.f20087p.a(String.valueOf(jSONObject.optInt("x")), String.valueOf(jSONObject.optInt("y")));
                    if (optInt != 1) {
                        w.this.t().a("click", 0);
                    } else {
                        z10 = false;
                    }
                } catch (Exception unused) {
                    w.this.f20087p.a("0", "0");
                    w.this.t().a("click", 0);
                }
            }
            w.this.f20086o.a(com.sigmob.sdk.base.a.COMPANION, w.this.f20087p.g(), z10);
            w.this.a(IntentActions.ACTION_NATIVE_TEMPLE_CLICK);
        }

        @Override // com.sigmob.sdk.mraid.d.g
        public void a(View view) {
            SigmobLog.d("SigNativeAdLandViewController onLoaded()");
        }

        @Override // com.sigmob.sdk.mraid.d.g
        public void a(boolean z10) {
            SigmobLog.d("SigNativeAdLandViewController onMute()");
        }

        /* JADX WARN: Removed duplicated region for block: B:5:0x0092  */
        @Override // com.sigmob.sdk.mraid.d.g
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void a(java.net.URI r9, int r10, java.lang.String r11) {
            /*
                r8 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "SigNativeAdLandViewController  onOpen:"
                r0.append(r1)
                r0.append(r9)
                java.lang.String r1 = "======"
                r0.append(r1)
                r0.append(r10)
                java.lang.String r10 = "====="
                r0.append(r10)
                r0.append(r11)
                java.lang.String r10 = r0.toString()
                com.czhj.sdk.logger.SigmobLog.i(r10)
                boolean r10 = android.text.TextUtils.isEmpty(r11)
                r0 = 1
                r1 = 0
                if (r10 != 0) goto L8e
                com.sigmob.sdk.nativead.w r10 = com.sigmob.sdk.nativead.w.this     // Catch: java.lang.Exception -> L8a
                com.sigmob.sdk.base.models.BaseAdUnit r10 = com.sigmob.sdk.nativead.w.p(r10)     // Catch: java.lang.Exception -> L8a
                com.sigmob.sdk.base.models.ClickCommon r10 = r10.getClickCommon()     // Catch: java.lang.Exception -> L8a
                java.lang.String r2 = "btn"
                r10.click_area = r2     // Catch: java.lang.Exception -> L8a
                com.sigmob.sdk.nativead.w r10 = com.sigmob.sdk.nativead.w.this     // Catch: java.lang.Exception -> L8a
                com.sigmob.sdk.base.models.BaseAdUnit r10 = com.sigmob.sdk.nativead.w.p(r10)     // Catch: java.lang.Exception -> L8a
                com.sigmob.sdk.base.models.ClickCommon r10 = r10.getClickCommon()     // Catch: java.lang.Exception -> L8a
                r10.is_final_click = r0     // Catch: java.lang.Exception -> L8a
                org.json.JSONObject r10 = new org.json.JSONObject     // Catch: java.lang.Exception -> L8a
                r10.<init>(r11)     // Catch: java.lang.Exception -> L8a
                java.lang.String r11 = "type"
                int r11 = r10.optInt(r11)     // Catch: java.lang.Exception -> L8a
                java.lang.String r2 = "x"
                int r2 = r10.optInt(r2)     // Catch: java.lang.Exception -> L8a
                java.lang.String r3 = "y"
                int r3 = r10.optInt(r3)     // Catch: java.lang.Exception -> L8a
                java.lang.String r4 = "disable_landing"
                boolean r4 = r10.optBoolean(r4)     // Catch: java.lang.Exception -> L8a
                java.lang.String r5 = "feDisable"
                boolean r10 = r10.optBoolean(r5)     // Catch: java.lang.Exception -> L86
                r10 = r10 ^ r0
                com.sigmob.sdk.nativead.w r5 = com.sigmob.sdk.nativead.w.this     // Catch: java.lang.Exception -> L83
                com.sigmob.sdk.mraid.d r5 = com.sigmob.sdk.nativead.w.e(r5)     // Catch: java.lang.Exception -> L83
                java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch: java.lang.Exception -> L83
                java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch: java.lang.Exception -> L83
                r5.a(r2, r3)     // Catch: java.lang.Exception -> L83
                r7 = r10
                r1 = r4
                if (r11 != r0) goto L81
                r6 = 0
                goto L90
            L81:
                r6 = 1
                goto L90
            L83:
                r1 = r4
                goto L8c
            L86:
                r1 = r4
            L88:
                r10 = 1
                goto L8c
            L8a:
                goto L88
            L8c:
                r7 = r10
                goto L81
            L8e:
                r6 = 1
                r7 = 1
            L90:
                if (r1 != 0) goto Lba
                com.sigmob.sdk.nativead.w r10 = com.sigmob.sdk.nativead.w.this
                com.sigmob.sdk.base.models.BaseAdUnit r10 = com.sigmob.sdk.nativead.w.p(r10)
                java.lang.String r10 = r10.getLanding_page()
                boolean r10 = android.text.TextUtils.isEmpty(r10)
                if (r10 == 0) goto La3
                goto Lba
            La3:
                com.sigmob.sdk.nativead.w r9 = com.sigmob.sdk.nativead.w.this
                com.sigmob.sdk.nativead.c r2 = com.sigmob.sdk.nativead.w.c(r9)
                com.sigmob.sdk.base.a r3 = com.sigmob.sdk.base.a.ENDCARD
                com.sigmob.sdk.nativead.w r9 = com.sigmob.sdk.nativead.w.this
                com.sigmob.sdk.mraid.d r9 = com.sigmob.sdk.nativead.w.e(r9)
                java.lang.String r5 = r9.g()
                r4 = 0
            Lb6:
                r2.a(r3, r4, r5, r6, r7)
                goto Ld1
            Lba:
                com.sigmob.sdk.nativead.w r10 = com.sigmob.sdk.nativead.w.this
                com.sigmob.sdk.nativead.c r2 = com.sigmob.sdk.nativead.w.c(r10)
                com.sigmob.sdk.base.a r3 = com.sigmob.sdk.base.a.ENDCARD
                java.lang.String r4 = r9.toString()
                com.sigmob.sdk.nativead.w r9 = com.sigmob.sdk.nativead.w.this
                com.sigmob.sdk.mraid.d r9 = com.sigmob.sdk.nativead.w.e(r9)
                java.lang.String r5 = r9.g()
                goto Lb6
            Ld1:
                com.sigmob.sdk.nativead.w r9 = com.sigmob.sdk.nativead.w.this
                java.lang.String r10 = "action.native.temple.click"
                com.sigmob.sdk.nativead.w.c(r9, r10)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.nativead.w.d.a(java.net.URI, int, java.lang.String):void");
        }

        @Override // com.sigmob.sdk.mraid.d.g
        public void a(WindAdError windAdError) {
            SigmobLog.i("SigNativeAdLandViewController onRenderProcessGone:" + windAdError.toString());
        }

        @Override // com.sigmob.sdk.mraid.d.g
        public void a(int i10, int i11, int i12, int i13, a.b bVar, boolean z10) {
            SigmobLog.i("SigNativeAdLandViewController onResize()");
        }

        @Override // com.sigmob.sdk.mraid.d.g
        public void a(float f10) {
            SigmobLog.d("SigNativeAdLandViewController onReward()");
        }
    }

    public class e implements d.h {
        public e() {
        }

        @Override // com.sigmob.sdk.mraid.d.h
        public void a(com.sigmob.sdk.mraid.p pVar, com.sigmob.sdk.base.common.t tVar) {
        }
    }

    public class f implements d.h {
        public f() {
        }

        @Override // com.sigmob.sdk.mraid.d.h
        public void a(com.sigmob.sdk.mraid.p pVar, com.sigmob.sdk.base.common.t tVar) {
        }
    }

    public class g implements d.k {
        public g() {
        }

        @Override // com.sigmob.sdk.mraid.d.k
        public void a(boolean z10) {
            if (z10) {
                w.this.v();
            } else if (w.f20079x == null) {
                w.this.w();
            }
        }
    }

    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (w.f20079x != null) {
                w.f20079x.setUIStyle(com.sigmob.sdk.nativead.g.PREVIEW);
            }
            w.this.g().a();
        }
    }

    public w(Activity activity, BaseAdUnit baseAdUnit, Bundle bundle, Bundle bundle2, String str, com.sigmob.sdk.base.common.k kVar) {
        super(activity, str, kVar);
        this.f20080i = 300L;
        this.f20093v = false;
        this.f20085n = baseAdUnit;
        com.sigmob.sdk.nativead.c cVar = (com.sigmob.sdk.nativead.c) baseAdUnit.getAdConfig();
        this.f20086o = cVar;
        cVar.a(f(), this.f20085n, (q.g) null);
        this.f20081j = (b0) bundle.getParcelable("attr");
        g().a(1);
        int m10 = com.sigmob.sdk.base.g.m();
        if (m10 != 0) {
            f().getTheme().applyStyle(m10, true);
        }
    }

    @Override // com.sigmob.sdk.base.common.j
    public void a(Configuration configuration) {
    }

    @Override // com.sigmob.sdk.base.common.j
    public void j() {
    }

    @Override // com.sigmob.sdk.base.common.j
    public void o() {
    }

    public final void r() {
        this.f20094w = true;
        if (f20079x == null) {
            g().a();
            return;
        }
        new c0(this.f20084m, this.f20082k, this.f20081j, 300L).a();
        this.f20083l.setVisibility(8);
        this.f20084m.postDelayed(new h(), 300L);
    }

    public View s() {
        if (this.f20087p == null) {
            this.f20087p = new com.sigmob.sdk.mraid.d(this.f17899b, this.f20085n, PlacementType.INTERSTITIAL);
        }
        this.f20087p.a(new d());
        if (!TextUtils.isEmpty(this.f20085n.getHtmlUrl())) {
            this.f20087p.b(this.f20085n.getHtmlUrl(), new e());
        } else if (!TextUtils.isEmpty(this.f20085n.getHtmlData())) {
            this.f20087p.a(this.f20085n.getHtmlData(), new f());
        }
        this.f20087p.a(new g());
        return this.f20087p.d();
    }

    public com.sigmob.sdk.base.common.d0 t() {
        com.sigmob.sdk.base.common.d0 sessionManager = this.f20085n.getSessionManager();
        if (sessionManager != null) {
            return sessionManager;
        }
        com.sigmob.sdk.nativead.f fVar = new com.sigmob.sdk.nativead.f();
        fVar.a(this.f20085n);
        return fVar;
    }

    public final int u() {
        DisplayMetrics displayMetrics = ClientMetadata.getInstance().getDisplayMetrics();
        return Math.min((int) (Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels) / this.f20085n.getAdPercent()), Math.max(displayMetrics.heightPixels, displayMetrics.widthPixels) / 2);
    }

    public final void v() {
        ImageView imageView = this.f20091t;
        if (imageView != null) {
            imageView.setVisibility(4);
        }
    }

    public final void w() {
        if (this.f20091t == null) {
            a(f());
        }
        this.f20091t.setVisibility(0);
    }

    @Override // com.sigmob.sdk.base.common.j
    public void a(Bundle bundle) {
    }

    @Override // com.sigmob.sdk.base.common.j
    public void k() {
        i().removeAllViews();
        g().onSetContentView(i());
        this.f20085n.getClickCommon().click_scene = "template";
        RelativeLayout relativeLayout = new RelativeLayout(h());
        this.f20083l = relativeLayout;
        relativeLayout.setBackgroundColor(-1);
        this.f20088q = s();
        com.sigmob.sdk.mraid.d dVar = this.f20087p;
        if (dVar != null) {
            dVar.a(f());
        }
        this.f20083l.addView(this.f20088q, new RelativeLayout.LayoutParams(-1, -1));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        o oVar = f20079x;
        if (oVar != null) {
            WindNativeAdData nativeAdUnit = oVar.getNativeAdUnit();
            this.f20089r = nativeAdUnit;
            if (nativeAdUnit != null) {
                layoutParams.setMargins(0, u(), 0, 0);
            }
        }
        i().addView(this.f20083l, layoutParams);
        if (f20079x != null) {
            this.f20084m = new FrameLayout(f());
            f20079x.setBackClickListener(new a());
            i().addView(this.f20084m, new RelativeLayout.LayoutParams(-1, u()));
            f20079x.getSigVideoAdController().start();
            this.f20084m.getViewTreeObserver().addOnPreDrawListener(new b());
        }
        a(IntentActions.ACTION_NATIVE_TEMPLIE_SHOW, 100);
    }

    @Override // com.sigmob.sdk.base.common.j
    public void l() {
        APKStatusBroadcastReceiver aPKStatusBroadcastReceiver = this.f20090s;
        if (aPKStatusBroadcastReceiver != null) {
            aPKStatusBroadcastReceiver.b(aPKStatusBroadcastReceiver);
            this.f20090s = null;
        }
        com.sigmob.sdk.base.views.q qVar = this.f20092u;
        if (qVar != null) {
            qVar.dismiss();
            this.f20092u.b();
            this.f20092u = null;
        }
        com.sigmob.sdk.mraid.d dVar = this.f20087p;
        if (dVar != null) {
            dVar.b();
            this.f20087p = null;
        }
        o oVar = f20079x;
        if (oVar != null) {
            oVar.setBackClickListener(null);
            f20079x = null;
        }
        a(IntentActions.ACTION_NATIVE_TEMPLE_DISMISS);
        super.l();
    }

    @Override // com.sigmob.sdk.base.common.j
    public void m() {
        q sigVideoAdController;
        o oVar = f20079x;
        if (oVar == null || this.f20094w || (sigVideoAdController = oVar.getSigVideoAdController()) == null) {
            return;
        }
        sigVideoAdController.pause();
    }

    @Override // com.sigmob.sdk.base.common.j
    public void n() {
        q sigVideoAdController;
        o oVar = f20079x;
        if (oVar != null && (sigVideoAdController = oVar.getSigVideoAdController()) != null) {
            sigVideoAdController.start();
        }
        com.sigmob.sdk.mraid.d dVar = this.f20087p;
        if (dVar != null) {
            dVar.x();
        }
    }

    @Override // com.sigmob.sdk.base.common.j
    public boolean b() {
        o oVar = f20079x;
        if (oVar != null && oVar.onBackPressed()) {
            return false;
        }
        r();
        return false;
    }

    public final void a(Context context) {
        if (this.f20091t != null) {
            return;
        }
        ImageView imageView = new ImageView(context);
        this.f20091t = imageView;
        imageView.setImageBitmap(com.sigmob.sdk.base.views.s.CLOSE.b());
        this.f20091t.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f20091t.setImageAlpha(127);
        this.f20091t.setClickable(true);
        this.f20091t.setOnClickListener(new c());
        int dipsToIntPixels = Dips.dipsToIntPixels(20.0f, this.f17899b);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dipsToIntPixels, dipsToIntPixels);
        layoutParams.addRule(10);
        layoutParams.addRule(9);
        int i10 = dipsToIntPixels / 2;
        layoutParams.setMargins(i10, i10, 0, 0);
        RelativeLayout relativeLayout = this.f20083l;
        if (relativeLayout != null) {
            relativeLayout.addView(this.f20091t, layoutParams);
        }
    }

    public static void a(j jVar) {
        if (jVar instanceof o) {
            f20079x = (o) jVar;
        }
    }
}
