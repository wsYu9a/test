package com.kwad.components.ad.interstitial.c;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Outline;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.f.kwai.kwai.b;
import com.kwad.components.ad.interstitial.c.c;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.video.a;
import com.kwad.components.core.webview.a.a.m;
import com.kwad.components.core.webview.a.a.z;
import com.kwad.components.core.webview.a.kwai.o;
import com.kwad.components.core.webview.a.kwai.p;
import com.kwad.components.core.webview.a.kwai.u;
import com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler;
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.components.core.webview.jshandler.ab;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.ag;
import com.kwad.components.core.webview.jshandler.ai;
import com.kwad.components.core.webview.jshandler.an;
import com.kwad.components.core.webview.jshandler.ap;
import com.kwad.components.core.webview.jshandler.aq;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.jshandler.s;
import com.kwad.components.core.webview.jshandler.u;
import com.kwad.components.core.webview.jshandler.v;
import com.kwad.components.core.webview.jshandler.y;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.core.webview.kwai.c;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.bl;
import com.kwad.sdk.widget.KSFrameLayout;
import com.tencent.bugly.beta.tinker.TinkerReport;

/* loaded from: classes.dex */
public final class d extends b {
    private static long ka = 400;
    private static float kb = 0.8f;
    private static float kc = 1.0f;
    private static float kd = 0.749f;
    private com.kwad.components.core.webview.a cU;
    private com.kwad.sdk.core.webview.b cV;

    @NonNull
    private KsAdVideoPlayConfig dZ;
    private ImageView eM;
    private com.kwad.sdk.core.video.videoview.a eN;
    private com.kwad.sdk.core.f.d ef;
    private Vibrator eg;
    private an fC;
    private boolean fG;
    private ap jZ;
    private c jt;
    private KSFrameLayout ke;
    private KSFrameLayout kf;
    private Dialog kg;

    @Nullable
    private KsAdWebView kh;
    private ImageView ki;
    private a.c kj;
    private p kk;
    private c.a kl;

    @Nullable
    private com.kwad.components.ad.f.kwai.kwai.b km;
    protected AdInfo mAdInfo;
    private AdTemplate mAdTemplate;

    @Nullable
    private com.kwad.components.core.d.b.c mApkDownloadHelper;

    @NonNull
    protected Context mContext;
    private com.kwad.components.core.widget.kwai.b mViewVisibleHelper;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private int cW = -1;
    private boolean kn = false;
    private h ko = new h() { // from class: com.kwad.components.ad.interstitial.c.d.1
        AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.interstitial.c.h
        public final void dA() {
            d.this.dk.onPageVisible();
        }

        @Override // com.kwad.components.ad.interstitial.c.h
        public final void dB() {
            d.this.dk.onPageInvisible();
        }
    };
    private com.kwad.sdk.core.g.c dk = new com.kwad.sdk.core.g.d() { // from class: com.kwad.components.ad.interstitial.c.d.12
        AnonymousClass12() {
        }

        @Override // com.kwad.sdk.core.g.d, com.kwad.sdk.core.g.c
        public final void onPageInvisible() {
            com.kwad.sdk.core.d.b.d("InterstitialWebViewPresenter", "onPageInvisible");
            if (d.this.fC != null) {
                d.this.fC.rb();
                d.this.fC.rc();
            }
        }

        @Override // com.kwad.sdk.core.g.d, com.kwad.sdk.core.g.c
        public final void onPageVisible() {
            com.kwad.sdk.core.d.b.d("InterstitialWebViewPresenter", "onPageVisible");
            if (d.this.fC != null) {
                d.this.fC.qZ();
                d.this.fC.ra();
            }
        }
    };
    private final Runnable kp = new Runnable() { // from class: com.kwad.components.ad.interstitial.c.d.20
        AnonymousClass20() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.sdk.core.d.b.d("InterstitialWebViewPresenter", "rollBackRunnable run");
            d.this.w("4");
        }
    };
    private ac.a kq = new ac.a() { // from class: com.kwad.components.ad.interstitial.c.d.25
        AnonymousClass25() {
        }

        @Override // com.kwad.components.core.webview.jshandler.ac.a
        public final void onAdShow() {
            if (d.this.mAdTemplate.mPvReported || d.this.jt.jy || d.this.jt.hN == null) {
                return;
            }
            d.this.jt.hN.onAdShow();
            d.this.jt.hU.getTimerHelper().startTiming();
            com.kwad.components.ad.interstitial.monitor.b.cR();
            com.kwad.components.ad.interstitial.monitor.b.b(d.this.mAdTemplate, 2);
        }
    };
    private ai.b cZ = new ai.b() { // from class: com.kwad.components.ad.interstitial.c.d.18
        AnonymousClass18() {
        }

        @Override // com.kwad.components.core.webview.jshandler.ai.b
        public final void a(ai.a aVar) {
            if (d.this.fG || d.this.kn) {
                return;
            }
            d.this.cW = aVar.status;
            if (d.this.cW != 1) {
                d.this.w("3");
                return;
            }
            d.this.kh.setVisibility(0);
            com.kwad.components.core.m.a.pb().N(d.this.mAdTemplate);
            d.this.mHandler.removeCallbacksAndMessages(null);
            bi.b(d.this.kp);
            if (d.this.km != null) {
                d.this.km.fc();
            }
        }
    };

    /* renamed from: com.kwad.components.ad.interstitial.c.d$1 */
    final class AnonymousClass1 implements h {
        AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.interstitial.c.h
        public final void dA() {
            d.this.dk.onPageVisible();
        }

        @Override // com.kwad.components.ad.interstitial.c.h
        public final void dB() {
            d.this.dk.onPageInvisible();
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.c.d$10 */
    final class AnonymousClass10 implements aw.a {

        /* renamed from: com.kwad.components.ad.interstitial.c.d$10$1 */
        final class AnonymousClass1 implements Runnable {
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                d.this.dx();
            }
        }

        AnonymousClass10() {
        }

        @Override // com.kwad.components.core.webview.jshandler.aw.a
        public final boolean dC() {
            if (d.this.kk != null) {
                d.this.kk.aP(false);
            }
            bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.interstitial.c.d.10.1
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    d.this.dx();
                }
            });
            boolean z = !d.this.jt.jG;
            if (z) {
                d.this.jt.a(true, -1, d.this.jt.eN);
            }
            return z;
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.c.d$11 */
    final class AnonymousClass11 implements ag.a {
        AnonymousClass11() {
        }

        @Override // com.kwad.components.core.webview.jshandler.ag.a
        public final void a(com.kwad.components.core.webview.kwai.b bVar) {
            AdWebViewActivityProxy.launch(d.this.mContext, new AdWebViewActivityProxy.a.C0182a().au(bVar.title).av(bVar.url).aA(true).L(d.this.mAdTemplate).oc());
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.c.d$12 */
    final class AnonymousClass12 extends com.kwad.sdk.core.g.d {
        AnonymousClass12() {
        }

        @Override // com.kwad.sdk.core.g.d, com.kwad.sdk.core.g.c
        public final void onPageInvisible() {
            com.kwad.sdk.core.d.b.d("InterstitialWebViewPresenter", "onPageInvisible");
            if (d.this.fC != null) {
                d.this.fC.rb();
                d.this.fC.rc();
            }
        }

        @Override // com.kwad.sdk.core.g.d, com.kwad.sdk.core.g.c
        public final void onPageVisible() {
            com.kwad.sdk.core.d.b.d("InterstitialWebViewPresenter", "onPageVisible");
            if (d.this.fC != null) {
                d.this.fC.qZ();
                d.this.fC.ra();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.c.d$13 */
    final class AnonymousClass13 implements aa.b {

        /* renamed from: com.kwad.components.ad.interstitial.c.d$13$1 */
        final class AnonymousClass1 implements Runnable {
            final /* synthetic */ aa.a kv;

            AnonymousClass1(aa.a aVar) {
                aVar = aVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (d.this.jt.jy || aVar.type != 0 || d.this.jt.jw || d.this.jt.jx || !com.kwad.components.ad.interstitial.d.a.c(d.this.jt)) {
                    d.this.jt.a(aVar.type == 3, -1, d.this.eN);
                    d.this.dx();
                } else {
                    d.this.jt.jx = true;
                    com.kwad.components.ad.interstitial.a.b.K(d.this.mContext);
                }
            }
        }

        AnonymousClass13() {
        }

        @Override // com.kwad.components.core.webview.jshandler.aa.b
        public final void a(aa.a aVar) {
            if (d.this.kg != null) {
                d.this.mHandler.post(new Runnable() { // from class: com.kwad.components.ad.interstitial.c.d.13.1
                    final /* synthetic */ aa.a kv;

                    AnonymousClass1(aa.a aVar2) {
                        aVar = aVar2;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        if (d.this.jt.jy || aVar.type != 0 || d.this.jt.jw || d.this.jt.jx || !com.kwad.components.ad.interstitial.d.a.c(d.this.jt)) {
                            d.this.jt.a(aVar.type == 3, -1, d.this.eN);
                            d.this.dx();
                        } else {
                            d.this.jt.jx = true;
                            com.kwad.components.ad.interstitial.a.b.K(d.this.mContext);
                        }
                    }
                });
            }
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.c.d$14 */
    final class AnonymousClass14 extends p {
        AnonymousClass14() {
        }

        @Override // com.kwad.components.core.webview.a.kwai.p, com.kwad.components.core.webview.a.kwai.v, com.kwad.sdk.core.webview.b.a
        public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
            super.handleJsCall(str, cVar);
            if (d.this.eN.isIdle()) {
                z zVar = new z();
                zVar.Vq = false;
                zVar.Vm = false;
                zVar.nZ = 0;
                cVar.a(zVar);
            }
            if (d.this.eN.isCompleted()) {
                z zVar2 = new z();
                zVar2.Vq = false;
                zVar2.Vm = true;
                zVar2.nZ = com.kwad.sdk.core.response.a.a.F(com.kwad.sdk.core.response.a.d.cb(d.this.cV.getAdTemplate()));
                cVar.a(zVar2);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.c.d$15 */
    final class AnonymousClass15 implements com.kwad.sdk.core.webview.c.kwai.a {
        AnonymousClass15() {
        }

        @Override // com.kwad.sdk.core.webview.c.kwai.a
        public final void onAdClicked(com.kwad.sdk.core.webview.c.a.a aVar) {
            if (aVar != null) {
                if (!d.this.jt.jy && d.this.jt.hN != null) {
                    d.this.jt.hN.onAdClicked();
                }
                d.this.jt.jw = true;
                if (!d.this.jt.jy) {
                    d.this.jt.cr();
                }
                if (d.this.jt.hU == null || !com.kwad.components.ad.interstitial.kwai.b.cN()) {
                    return;
                }
                d.this.jt.a(false, -1, d.this.jt.eN);
                d.this.jt.hU.dismiss();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.c.d$16 */
    final class AnonymousClass16 implements com.kwad.sdk.core.webview.c.kwai.a {
        AnonymousClass16() {
        }

        @Override // com.kwad.sdk.core.webview.c.kwai.a
        public final void onAdClicked(com.kwad.sdk.core.webview.c.a.a aVar) {
            if (aVar != null) {
                if (!d.this.jt.jy && d.this.jt.hN != null) {
                    d.this.jt.hN.onAdClicked();
                }
                d.this.jt.jw = true;
                if (!d.this.jt.jy) {
                    d.this.jt.cr();
                }
                if (d.this.jt.hU == null || !com.kwad.components.ad.interstitial.kwai.b.cN()) {
                    return;
                }
                d.this.jt.a(false, -1, d.this.jt.eN);
                d.this.jt.hU.dismiss();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.c.d$17 */
    final class AnonymousClass17 extends ViewOutlineProvider {
        AnonymousClass17() {
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View view, Outline outline) {
            outline.setRect(0, 0, view.getWidth(), view.getHeight());
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.c.d$18 */
    final class AnonymousClass18 implements ai.b {
        AnonymousClass18() {
        }

        @Override // com.kwad.components.core.webview.jshandler.ai.b
        public final void a(ai.a aVar) {
            if (d.this.fG || d.this.kn) {
                return;
            }
            d.this.cW = aVar.status;
            if (d.this.cW != 1) {
                d.this.w("3");
                return;
            }
            d.this.kh.setVisibility(0);
            com.kwad.components.core.m.a.pb().N(d.this.mAdTemplate);
            d.this.mHandler.removeCallbacksAndMessages(null);
            bi.b(d.this.kp);
            if (d.this.km != null) {
                d.this.km.fc();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.c.d$19 */
    final class AnonymousClass19 implements com.kwad.sdk.core.f.b {

        /* renamed from: com.kwad.components.ad.interstitial.c.d$19$1 */
        final class AnonymousClass1 implements Runnable {
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.core.d.b.d("InterstitialWebViewPresenter", "onShakeEvent openGate2");
                d.this.ef.xD();
            }
        }

        AnonymousClass19() {
        }

        @Override // com.kwad.sdk.core.f.b
        public final void a(double d2) {
            if (bl.o(d.this.ke, 100)) {
                d.this.d(d2);
            }
            bi.a(new Runnable() { // from class: com.kwad.components.ad.interstitial.c.d.19.1
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    com.kwad.sdk.core.d.b.d("InterstitialWebViewPresenter", "onShakeEvent openGate2");
                    d.this.ef.xD();
                }
            }, null, 500L);
        }

        @Override // com.kwad.sdk.core.f.b
        public final void bd() {
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.c.d$2 */
    final class AnonymousClass2 implements u.b {
        AnonymousClass2() {
        }

        @Override // com.kwad.components.core.webview.jshandler.u.b
        public final void a(u.a aVar) {
            aVar.height = com.kwad.sdk.c.kwai.a.getScreenHeight(d.this.mContext);
            aVar.width = com.kwad.sdk.c.kwai.a.getScreenHeight(d.this.mContext);
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.c.d$20 */
    final class AnonymousClass20 implements Runnable {
        AnonymousClass20() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.sdk.core.d.b.d("InterstitialWebViewPresenter", "rollBackRunnable run");
            d.this.w("4");
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.c.d$21 */
    final class AnonymousClass21 implements Runnable {
        AnonymousClass21() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.this.di();
            d.this.jt.cV();
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.c.d$22 */
    final class AnonymousClass22 implements KsAdWebView.d {
        AnonymousClass22() {
        }

        @Override // com.kwad.sdk.core.webview.KsAdWebView.d
        public final void onPageFinished() {
        }

        @Override // com.kwad.sdk.core.webview.KsAdWebView.d
        public final void onPageStart() {
        }

        @Override // com.kwad.sdk.core.webview.KsAdWebView.d
        public final void onReceivedHttpError(int i2, String str, String str2) {
            d.this.w("1");
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.c.d$23 */
    final class AnonymousClass23 implements Runnable {
        AnonymousClass23() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.this.di();
            d.this.jt.cV();
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.c.d$24 */
    final class AnonymousClass24 implements Runnable {
        final /* synthetic */ ViewGroup kA;
        final /* synthetic */ boolean ky;
        final /* synthetic */ boolean kz;

        AnonymousClass24(boolean z, boolean z2, ViewGroup viewGroup) {
            DL = z;
            aO = z2;
            viewGroup = viewGroup;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ViewGroup.LayoutParams a2 = DL ? d.a(d.this.ke.getWidth(), aO) : d.E(d.this.ke.getHeight());
            if (d.this.kh != null) {
                d.this.kh.setVisibility(8);
            }
            d.this.kf.setVisibility(8);
            ViewParent parent = d.this.jt.ju.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(d.this.jt.ju);
            }
            viewGroup.addView(d.this.jt.ju);
            d.this.jt.ju.f(a2.width, a2.height);
            d.this.eN.requestLayout();
            d.a(d.this, true);
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.c.d$25 */
    final class AnonymousClass25 implements ac.a {
        AnonymousClass25() {
        }

        @Override // com.kwad.components.core.webview.jshandler.ac.a
        public final void onAdShow() {
            if (d.this.mAdTemplate.mPvReported || d.this.jt.jy || d.this.jt.hN == null) {
                return;
            }
            d.this.jt.hN.onAdShow();
            d.this.jt.hU.getTimerHelper().startTiming();
            com.kwad.components.ad.interstitial.monitor.b.cR();
            com.kwad.components.ad.interstitial.monitor.b.b(d.this.mAdTemplate, 2);
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.c.d$26 */
    final class AnonymousClass26 implements ap.a {
        AnonymousClass26() {
        }

        @Override // com.kwad.components.core.webview.jshandler.ap.a
        public final void bJ() {
            d.this.bB();
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.c.d$3 */
    final class AnonymousClass3 implements b.InterfaceC0125b {
        AnonymousClass3() {
        }

        @Override // com.kwad.components.ad.f.kwai.kwai.b.InterfaceC0125b
        public final void G(int i2) {
            if (i2 == com.kwad.components.ad.f.kwai.kwai.b.nP) {
                d.this.jt.b(d.this.getContext(), d.this.mAdTemplate);
                d.this.jt.a(true, -1, d.this.jt.eN);
            }
            d.this.dx();
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.c.d$4 */
    final class AnonymousClass4 implements c.InterfaceC0137c {
        final /* synthetic */ com.kwad.components.ad.f.kwai.kwai.a ks;

        AnonymousClass4(com.kwad.components.ad.f.kwai.kwai.a aVar) {
            aVar = aVar;
        }

        @Override // com.kwad.components.ad.interstitial.c.c.InterfaceC0137c
        public final void dg() {
            aVar.fb();
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.c.d$5 */
    final class AnonymousClass5 implements u.a {
        AnonymousClass5() {
        }

        @Override // com.kwad.components.core.webview.a.kwai.u.a
        public final void a(m mVar) {
            d.this.eN.setVideoSoundEnable(!mVar.Vf);
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.c.d$6 */
    final class AnonymousClass6 extends o {
        AnonymousClass6() {
        }

        @Override // com.kwad.components.core.webview.a.kwai.o, com.kwad.components.core.webview.a.kwai.v, com.kwad.sdk.core.webview.b.a
        public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
            super.handleJsCall(str, cVar);
            m mVar = new m();
            mVar.Vf = !d.this.dZ.isVideoSoundEnable();
            cVar.a(mVar);
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.c.d$7 */
    final class AnonymousClass7 implements ab.b {
        AnonymousClass7() {
        }

        @Override // com.kwad.components.core.webview.jshandler.ab.b
        public final void a(ab.a aVar) {
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.c.d$8 */
    final class AnonymousClass8 implements a.c {
        final /* synthetic */ z kt;

        AnonymousClass8(z zVar) {
            zVar = zVar;
        }

        @Override // com.kwad.components.core.video.a.c
        public final void bt() {
            z zVar = zVar;
            zVar.Vq = false;
            zVar.Vm = true;
            zVar.nZ = com.kwad.sdk.core.response.a.a.F(com.kwad.sdk.core.response.a.d.cb(d.this.cV.getAdTemplate()));
            d.this.kk.a(zVar);
        }

        @Override // com.kwad.components.core.video.a.c
        public final void d(long j2) {
            z zVar = zVar;
            zVar.Vq = false;
            zVar.Vm = false;
            zVar.nZ = (int) Math.ceil(j2 / 1000.0f);
            d.this.kk.a(zVar);
        }

        @Override // com.kwad.components.core.video.a.c
        public final void onVideoPlayStart() {
            z zVar = zVar;
            zVar.Vq = false;
            zVar.Vm = false;
            zVar.nZ = 0;
            d.this.kk.a(zVar);
        }

        @Override // com.kwad.components.core.video.a.c
        public final void onVideoPlaying() {
            if (d.this.eM.getVisibility() == 0) {
                d.this.eM.setVisibility(8);
            }
            z zVar = zVar;
            zVar.Vq = false;
            zVar.Vm = false;
            zVar.nZ = (int) Math.ceil(d.this.eN.getCurrentPosition() / 1000.0f);
            d.this.kk.a(zVar);
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.c.d$9 */
    final class AnonymousClass9 implements WebCardVideoPositionHandler.a {
        AnonymousClass9() {
        }

        @Override // com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler.a
        public final void a(WebCardVideoPositionHandler.VideoPosition videoPosition) {
            AdInfo adInfo;
            com.kwad.sdk.core.d.b.d("InterstitialWebViewPresenter", "onVideoSetPosition hadRollBackToNative: " + d.this.kn);
            if (d.this.kn || (adInfo = d.this.mAdInfo) == null || !com.kwad.sdk.core.response.a.a.aU(adInfo)) {
                return;
            }
            c unused = d.this.jt;
            d dVar = d.this;
            boolean a2 = c.a(dVar.mContext, dVar.mAdInfo);
            d dVar2 = d.this;
            dVar2.a(dVar2.mAdInfo, videoPosition, dVar2.kf, a2);
            d.this.kf.setVisibility(0);
            d.this.kh.setVisibility(0);
        }
    }

    public static ViewGroup.LayoutParams E(int i2) {
        int i3 = (int) (i2 * kd);
        return new ViewGroup.LayoutParams((int) (i3 / 0.749f), i3);
    }

    private static float a(boolean z, boolean z2) {
        return (z && z2) ? 1.7777778f : 0.749f;
    }

    public static ViewGroup.LayoutParams a(int i2, boolean z) {
        int i3 = (int) (i2 * (z ? kb : kc));
        return new ViewGroup.LayoutParams(i3, (int) (i3 * (z ? 1.7777778f : 0.749f)));
    }

    private static ViewGroup.MarginLayoutParams a(WebCardVideoPositionHandler.VideoPosition videoPosition, ViewGroup.MarginLayoutParams marginLayoutParams) {
        marginLayoutParams.topMargin = videoPosition.topMargin;
        marginLayoutParams.leftMargin = videoPosition.leftMargin;
        marginLayoutParams.width = videoPosition.width;
        marginLayoutParams.height = videoPosition.height;
        return marginLayoutParams;
    }

    private static void a(ViewGroup.MarginLayoutParams marginLayoutParams, ViewGroup.MarginLayoutParams marginLayoutParams2) {
        marginLayoutParams2.leftMargin = marginLayoutParams.leftMargin;
        marginLayoutParams2.rightMargin = marginLayoutParams.rightMargin;
        marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
        marginLayoutParams2.bottomMargin = marginLayoutParams.bottomMargin;
        marginLayoutParams2.width = marginLayoutParams.width;
        marginLayoutParams2.height = marginLayoutParams.height;
    }

    private void a(com.kwad.components.core.webview.a aVar, String str) {
        aVar.a(dz());
        aVar.a(dy());
        aVar.a(new com.kwad.components.core.webview.a.kwai.f());
        aVar.a(dr());
        aVar.a(new v(this.cV));
        aVar.a(dq());
        aVar.a(dp());
        aVar.a(dv());
        an anVar = new an();
        this.fC = anVar;
        aVar.a(anVar);
        this.jt.a(ds());
        aVar.a(dw());
        aVar.a(dt());
        aVar.a(new y(this.cV));
        aVar.a(dm());
        aVar.a(new ai(this.cZ, str));
        aVar.a(dk());
        ac acVar = new ac(this.cV);
        acVar.a(this.kq);
        aVar.a(acVar);
        aVar.a(du());
        aVar.a(new ag(getOpenNewPageListener()));
        if (com.kwad.sdk.core.response.a.b.cS(com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate))) {
            aVar.a(dj());
        }
        if (dn() != null) {
            aVar.a(this.km);
        }
        aVar.a(dl());
        aVar.a(m55do());
    }

    public void a(AdInfo adInfo, WebCardVideoPositionHandler.VideoPosition videoPosition, KSFrameLayout kSFrameLayout, boolean z) {
        kSFrameLayout.setWidthBasedRatio(!z);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) kSFrameLayout.getLayoutParams();
        com.kwad.sdk.core.d.b.d("InterstitialWebViewPresenter", "updateVideoContainerSize before size: " + marginLayoutParams.width + ", " + marginLayoutParams.height);
        a(videoPosition, marginLayoutParams);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams);
        float aP = com.kwad.sdk.core.response.a.a.aP(adInfo);
        com.kwad.sdk.core.d.b.d("InterstitialWebViewPresenter", "updateVideoContainerSize materialRatio: " + aP);
        if (!z || aP <= 0.0f) {
            kSFrameLayout.setRatio(0.0f);
        } else {
            int i2 = marginLayoutParams.width;
            int i3 = marginLayoutParams.height;
            int i4 = (int) (i3 / aP);
            marginLayoutParams.width = i4;
            marginLayoutParams.leftMargin += (i2 - i4) / 2;
            if (i4 != 0) {
                float f2 = i3 / i4;
                com.kwad.sdk.core.d.b.d("InterstitialWebViewPresenter", "cardParams ratio: " + f2);
                kSFrameLayout.setRatio(f2);
            }
        }
        com.kwad.sdk.core.d.b.d("InterstitialWebViewPresenter", "cardParams width: " + marginLayoutParams.width + ", height: " + marginLayoutParams.height);
        kSFrameLayout.setLayoutParams(marginLayoutParams);
        float dimension = getContext().getResources().getDimension(R.dimen.ksad_interstitial_card_radius);
        WebCardVideoPositionHandler.VideoPosition.KSAdJSCornerModel kSAdJSCornerModel = videoPosition.cornerRadius;
        if (kSAdJSCornerModel != null) {
            kSFrameLayout.setRadius((float) kSAdJSCornerModel.topLeft, (float) kSAdJSCornerModel.topRight, (float) kSAdJSCornerModel.bottomRight, (float) kSAdJSCornerModel.bottomLeft);
        } else if (marginLayoutParams.width > marginLayoutParams.height) {
            kSFrameLayout.setRadius(dimension, dimension, 0.0f, 0.0f);
        } else {
            kSFrameLayout.setRadius(dimension, dimension, dimension, dimension);
        }
        if (z) {
            this.ki.setVisibility(0);
            ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) this.ki.getLayoutParams();
            a(marginLayoutParams2, marginLayoutParams3);
            this.ki.setLayoutParams(marginLayoutParams3);
            this.jt.a(this.mContext, adInfo, this.mAdTemplate, this.ki);
        } else {
            this.ki.setVisibility(8);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            kSFrameLayout.setOutlineProvider(new ViewOutlineProvider() { // from class: com.kwad.components.ad.interstitial.c.d.17
                AnonymousClass17() {
                }

                @Override // android.view.ViewOutlineProvider
                public final void getOutline(View view, Outline outline) {
                    outline.setRect(0, 0, view.getWidth(), view.getHeight());
                }
            });
            kSFrameLayout.setClipToOutline(true);
        }
    }

    static /* synthetic */ boolean a(d dVar, boolean z) {
        dVar.kn = true;
        return true;
    }

    private void aF() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.cV = bVar;
        bVar.setAdTemplate(this.jt.mAdTemplate);
        int i2 = !com.kwad.sdk.utils.ai.DL() ? 1 : 0;
        com.kwad.sdk.core.webview.b bVar2 = this.cV;
        bVar2.mScreenOrientation = i2;
        KSFrameLayout kSFrameLayout = this.ke;
        bVar2.app = kSFrameLayout;
        bVar2.LD = kSFrameLayout;
        bVar2.Lc = this.kh;
        bVar2.mReportExtData = null;
    }

    private void aG() {
        String bw = com.kwad.sdk.core.response.a.b.bw(this.mAdTemplate);
        if (TextUtils.isEmpty(bw) || this.kh == null) {
            w("1");
        } else {
            v(bw);
        }
    }

    private void aI() {
        com.kwad.components.core.webview.a aVar = this.cU;
        if (aVar != null) {
            aVar.destroy();
            this.cU = null;
        }
    }

    public void bB() {
        float bt = com.kwad.sdk.core.response.a.b.bt(this.mAdTemplate);
        if (this.ef == null) {
            com.kwad.sdk.core.f.d dVar = new com.kwad.sdk.core.f.d(bt);
            this.ef = dVar;
            dVar.a(new com.kwad.sdk.core.f.b() { // from class: com.kwad.components.ad.interstitial.c.d.19

                /* renamed from: com.kwad.components.ad.interstitial.c.d$19$1 */
                final class AnonymousClass1 implements Runnable {
                    AnonymousClass1() {
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.sdk.core.d.b.d("InterstitialWebViewPresenter", "onShakeEvent openGate2");
                        d.this.ef.xD();
                    }
                }

                AnonymousClass19() {
                }

                @Override // com.kwad.sdk.core.f.b
                public final void a(double d2) {
                    if (bl.o(d.this.ke, 100)) {
                        d.this.d(d2);
                    }
                    bi.a(new Runnable() { // from class: com.kwad.components.ad.interstitial.c.d.19.1
                        AnonymousClass1() {
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            com.kwad.sdk.core.d.b.d("InterstitialWebViewPresenter", "onShakeEvent openGate2");
                            d.this.ef.xD();
                        }
                    }, null, 500L);
                }

                @Override // com.kwad.sdk.core.f.b
                public final void bd() {
                }
            });
        }
        this.ef.e(bt);
        this.ef.aX(getContext());
    }

    public void d(double d2) {
        this.jt.a(new c.b(getContext()).l(true).c(d2).C(2).a(this.ke.getTouchCoords()).D(TinkerReport.KEY_APPLIED_PACKAGE_CHECK_RES_META));
        bi.a(getContext(), this.eg);
    }

    public void di() {
        boolean aO = com.kwad.sdk.core.response.a.a.aO(this.mAdInfo);
        boolean DL = com.kwad.sdk.utils.ai.DL();
        float a2 = a(DL, aO);
        com.kwad.sdk.core.d.b.d("InterstitialWebViewPresenter", "replaceNativeView cardRatio: " + a2);
        this.jt.ju.setRatio(a2);
        ViewGroup viewGroup = (ViewGroup) this.ke.findViewById(R.id.ksad_interstitial_native);
        viewGroup.setVisibility(0);
        viewGroup.post(new Runnable() { // from class: com.kwad.components.ad.interstitial.c.d.24
            final /* synthetic */ ViewGroup kA;
            final /* synthetic */ boolean ky;
            final /* synthetic */ boolean kz;

            AnonymousClass24(boolean DL2, boolean aO2, ViewGroup viewGroup2) {
                DL = DL2;
                aO = aO2;
                viewGroup = viewGroup2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                ViewGroup.LayoutParams a22 = DL ? d.a(d.this.ke.getWidth(), aO) : d.E(d.this.ke.getHeight());
                if (d.this.kh != null) {
                    d.this.kh.setVisibility(8);
                }
                d.this.kf.setVisibility(8);
                ViewParent parent = d.this.jt.ju.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(d.this.jt.ju);
                }
                viewGroup.addView(d.this.jt.ju);
                d.this.jt.ju.f(a22.width, a22.height);
                d.this.eN.requestLayout();
                d.a(d.this, true);
            }
        });
    }

    @NonNull
    private ap dj() {
        ap apVar = new ap(new ap.a() { // from class: com.kwad.components.ad.interstitial.c.d.26
            AnonymousClass26() {
            }

            @Override // com.kwad.components.core.webview.jshandler.ap.a
            public final void bJ() {
                d.this.bB();
            }
        });
        this.jZ = apVar;
        return apVar;
    }

    private aq dk() {
        return new aq(this.cV, this.mApkDownloadHelper);
    }

    private com.kwad.components.core.webview.a.kwai.g dl() {
        com.kwad.components.core.webview.a.a.k kVar = new com.kwad.components.core.webview.a.a.k();
        kVar.Vc = this.jt.jI;
        return new com.kwad.components.core.webview.a.kwai.g(kVar);
    }

    private com.kwad.components.core.webview.jshandler.u dm() {
        com.kwad.components.core.webview.jshandler.u uVar = new com.kwad.components.core.webview.jshandler.u(this.cV);
        uVar.a(new u.b() { // from class: com.kwad.components.ad.interstitial.c.d.2
            AnonymousClass2() {
            }

            @Override // com.kwad.components.core.webview.jshandler.u.b
            public final void a(u.a aVar) {
                aVar.height = com.kwad.sdk.c.kwai.a.getScreenHeight(d.this.mContext);
                aVar.width = com.kwad.sdk.c.kwai.a.getScreenHeight(d.this.mContext);
            }
        });
        return uVar;
    }

    private com.kwad.components.ad.f.kwai.kwai.b dn() {
        com.kwad.components.ad.f.kwai.kwai.b k = com.kwad.components.ad.f.kwai.kwai.b.k(this.mAdTemplate);
        this.km = k;
        if (k != null) {
            k.a(new b.InterfaceC0125b() { // from class: com.kwad.components.ad.interstitial.c.d.3
                AnonymousClass3() {
                }

                @Override // com.kwad.components.ad.f.kwai.kwai.b.InterfaceC0125b
                public final void G(int i2) {
                    if (i2 == com.kwad.components.ad.f.kwai.kwai.b.nP) {
                        d.this.jt.b(d.this.getContext(), d.this.mAdTemplate);
                        d.this.jt.a(true, -1, d.this.jt.eN);
                    }
                    d.this.dx();
                }
            });
        }
        return this.km;
    }

    /* renamed from: do */
    private com.kwad.components.ad.f.kwai.kwai.a m55do() {
        com.kwad.components.ad.f.kwai.kwai.a aVar = new com.kwad.components.ad.f.kwai.kwai.a();
        this.jt.jE.add(new c.InterfaceC0137c() { // from class: com.kwad.components.ad.interstitial.c.d.4
            final /* synthetic */ com.kwad.components.ad.f.kwai.kwai.a ks;

            AnonymousClass4(com.kwad.components.ad.f.kwai.kwai.a aVar2) {
                aVar = aVar2;
            }

            @Override // com.kwad.components.ad.interstitial.c.c.InterfaceC0137c
            public final void dg() {
                aVar.fb();
            }
        });
        return aVar2;
    }

    private com.kwad.components.core.webview.a.kwai.u dp() {
        com.kwad.components.core.webview.a.kwai.u uVar = new com.kwad.components.core.webview.a.kwai.u();
        uVar.a(new u.a() { // from class: com.kwad.components.ad.interstitial.c.d.5
            AnonymousClass5() {
            }

            @Override // com.kwad.components.core.webview.a.kwai.u.a
            public final void a(m mVar) {
                d.this.eN.setVideoSoundEnable(!mVar.Vf);
            }
        });
        return uVar;
    }

    @NonNull
    private o dq() {
        return new o() { // from class: com.kwad.components.ad.interstitial.c.d.6
            AnonymousClass6() {
            }

            @Override // com.kwad.components.core.webview.a.kwai.o, com.kwad.components.core.webview.a.kwai.v, com.kwad.sdk.core.webview.b.a
            public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
                super.handleJsCall(str, cVar);
                m mVar = new m();
                mVar.Vf = !d.this.dZ.isVideoSoundEnable();
                cVar.a(mVar);
            }
        };
    }

    @NonNull
    private ab dr() {
        return new ab(this.cV, new ab.b() { // from class: com.kwad.components.ad.interstitial.c.d.7
            AnonymousClass7() {
            }

            @Override // com.kwad.components.core.webview.jshandler.ab.b
            public final void a(ab.a aVar) {
            }
        });
    }

    private a.c ds() {
        AnonymousClass8 anonymousClass8 = new a.c() { // from class: com.kwad.components.ad.interstitial.c.d.8
            final /* synthetic */ z kt;

            AnonymousClass8(z zVar) {
                zVar = zVar;
            }

            @Override // com.kwad.components.core.video.a.c
            public final void bt() {
                z zVar = zVar;
                zVar.Vq = false;
                zVar.Vm = true;
                zVar.nZ = com.kwad.sdk.core.response.a.a.F(com.kwad.sdk.core.response.a.d.cb(d.this.cV.getAdTemplate()));
                d.this.kk.a(zVar);
            }

            @Override // com.kwad.components.core.video.a.c
            public final void d(long j2) {
                z zVar = zVar;
                zVar.Vq = false;
                zVar.Vm = false;
                zVar.nZ = (int) Math.ceil(j2 / 1000.0f);
                d.this.kk.a(zVar);
            }

            @Override // com.kwad.components.core.video.a.c
            public final void onVideoPlayStart() {
                z zVar = zVar;
                zVar.Vq = false;
                zVar.Vm = false;
                zVar.nZ = 0;
                d.this.kk.a(zVar);
            }

            @Override // com.kwad.components.core.video.a.c
            public final void onVideoPlaying() {
                if (d.this.eM.getVisibility() == 0) {
                    d.this.eM.setVisibility(8);
                }
                z zVar = zVar;
                zVar.Vq = false;
                zVar.Vm = false;
                zVar.nZ = (int) Math.ceil(d.this.eN.getCurrentPosition() / 1000.0f);
                d.this.kk.a(zVar);
            }
        };
        this.kj = anonymousClass8;
        return anonymousClass8;
    }

    @NonNull
    private WebCardVideoPositionHandler dt() {
        return new WebCardVideoPositionHandler(new WebCardVideoPositionHandler.a() { // from class: com.kwad.components.ad.interstitial.c.d.9
            AnonymousClass9() {
            }

            @Override // com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler.a
            public final void a(WebCardVideoPositionHandler.VideoPosition videoPosition) {
                AdInfo adInfo;
                com.kwad.sdk.core.d.b.d("InterstitialWebViewPresenter", "onVideoSetPosition hadRollBackToNative: " + d.this.kn);
                if (d.this.kn || (adInfo = d.this.mAdInfo) == null || !com.kwad.sdk.core.response.a.a.aU(adInfo)) {
                    return;
                }
                c unused = d.this.jt;
                d dVar = d.this;
                boolean a2 = c.a(dVar.mContext, dVar.mAdInfo);
                d dVar2 = d.this;
                dVar2.a(dVar2.mAdInfo, videoPosition, dVar2.kf, a2);
                d.this.kf.setVisibility(0);
                d.this.kh.setVisibility(0);
            }
        });
    }

    private aw du() {
        aw awVar = new aw(getContext(), this.mAdTemplate);
        awVar.a(new aw.a() { // from class: com.kwad.components.ad.interstitial.c.d.10

            /* renamed from: com.kwad.components.ad.interstitial.c.d$10$1 */
            final class AnonymousClass1 implements Runnable {
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    d.this.dx();
                }
            }

            AnonymousClass10() {
            }

            @Override // com.kwad.components.core.webview.jshandler.aw.a
            public final boolean dC() {
                if (d.this.kk != null) {
                    d.this.kk.aP(false);
                }
                bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.interstitial.c.d.10.1
                    AnonymousClass1() {
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        d.this.dx();
                    }
                });
                boolean z = !d.this.jt.jG;
                if (z) {
                    d.this.jt.a(true, -1, d.this.jt.eN);
                }
                return z;
            }
        });
        return awVar;
    }

    @NonNull
    private aa dv() {
        return new aa(new aa.b() { // from class: com.kwad.components.ad.interstitial.c.d.13

            /* renamed from: com.kwad.components.ad.interstitial.c.d$13$1 */
            final class AnonymousClass1 implements Runnable {
                final /* synthetic */ aa.a kv;

                AnonymousClass1(aa.a aVar2) {
                    aVar = aVar2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    if (d.this.jt.jy || aVar.type != 0 || d.this.jt.jw || d.this.jt.jx || !com.kwad.components.ad.interstitial.d.a.c(d.this.jt)) {
                        d.this.jt.a(aVar.type == 3, -1, d.this.eN);
                        d.this.dx();
                    } else {
                        d.this.jt.jx = true;
                        com.kwad.components.ad.interstitial.a.b.K(d.this.mContext);
                    }
                }
            }

            AnonymousClass13() {
            }

            @Override // com.kwad.components.core.webview.jshandler.aa.b
            public final void a(aa.a aVar2) {
                if (d.this.kg != null) {
                    d.this.mHandler.post(new Runnable() { // from class: com.kwad.components.ad.interstitial.c.d.13.1
                        final /* synthetic */ aa.a kv;

                        AnonymousClass1(aa.a aVar22) {
                            aVar = aVar22;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            if (d.this.jt.jy || aVar.type != 0 || d.this.jt.jw || d.this.jt.jx || !com.kwad.components.ad.interstitial.d.a.c(d.this.jt)) {
                                d.this.jt.a(aVar.type == 3, -1, d.this.eN);
                                d.this.dx();
                            } else {
                                d.this.jt.jx = true;
                                com.kwad.components.ad.interstitial.a.b.K(d.this.mContext);
                            }
                        }
                    });
                }
            }
        });
    }

    private p dw() {
        AnonymousClass14 anonymousClass14 = new p() { // from class: com.kwad.components.ad.interstitial.c.d.14
            AnonymousClass14() {
            }

            @Override // com.kwad.components.core.webview.a.kwai.p, com.kwad.components.core.webview.a.kwai.v, com.kwad.sdk.core.webview.b.a
            public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
                super.handleJsCall(str, cVar);
                if (d.this.eN.isIdle()) {
                    z zVar = new z();
                    zVar.Vq = false;
                    zVar.Vm = false;
                    zVar.nZ = 0;
                    cVar.a(zVar);
                }
                if (d.this.eN.isCompleted()) {
                    z zVar2 = new z();
                    zVar2.Vq = false;
                    zVar2.Vm = true;
                    zVar2.nZ = com.kwad.sdk.core.response.a.a.F(com.kwad.sdk.core.response.a.d.cb(d.this.cV.getAdTemplate()));
                    cVar.a(zVar2);
                }
            }
        };
        this.kk = anonymousClass14;
        return anonymousClass14;
    }

    public void dx() {
        Activity ownerActivity;
        KsInterstitialAd.AdInteractionListener adInteractionListener;
        Dialog dialog = this.kg;
        if (dialog == null || (ownerActivity = dialog.getOwnerActivity()) == null || ownerActivity.isFinishing()) {
            return;
        }
        this.kg.dismiss();
        c cVar = this.jt;
        if (!cVar.jy && (adInteractionListener = cVar.hN) != null) {
            adInteractionListener.onAdClosed();
        }
        com.kwad.sdk.core.video.videoview.a aVar = this.jt.eN;
        if (aVar != null) {
            aVar.release();
        }
    }

    @NonNull
    private com.kwad.components.core.webview.jshandler.p dy() {
        return new com.kwad.components.core.webview.jshandler.p(this.cV, this.mApkDownloadHelper, new com.kwad.sdk.core.webview.c.kwai.a() { // from class: com.kwad.components.ad.interstitial.c.d.15
            AnonymousClass15() {
            }

            @Override // com.kwad.sdk.core.webview.c.kwai.a
            public final void onAdClicked(com.kwad.sdk.core.webview.c.a.a aVar) {
                if (aVar != null) {
                    if (!d.this.jt.jy && d.this.jt.hN != null) {
                        d.this.jt.hN.onAdClicked();
                    }
                    d.this.jt.jw = true;
                    if (!d.this.jt.jy) {
                        d.this.jt.cr();
                    }
                    if (d.this.jt.hU == null || !com.kwad.components.ad.interstitial.kwai.b.cN()) {
                        return;
                    }
                    d.this.jt.a(false, -1, d.this.jt.eN);
                    d.this.jt.hU.dismiss();
                }
            }
        });
    }

    @NonNull
    private s dz() {
        return new s(this.cV, this.mApkDownloadHelper, new com.kwad.sdk.core.webview.c.kwai.a() { // from class: com.kwad.components.ad.interstitial.c.d.16
            AnonymousClass16() {
            }

            @Override // com.kwad.sdk.core.webview.c.kwai.a
            public final void onAdClicked(com.kwad.sdk.core.webview.c.a.a aVar) {
                if (aVar != null) {
                    if (!d.this.jt.jy && d.this.jt.hN != null) {
                        d.this.jt.hN.onAdClicked();
                    }
                    d.this.jt.jw = true;
                    if (!d.this.jt.jy) {
                        d.this.jt.cr();
                    }
                    if (d.this.jt.hU == null || !com.kwad.components.ad.interstitial.kwai.b.cN()) {
                        return;
                    }
                    d.this.jt.a(false, -1, d.this.jt.eN);
                    d.this.jt.hU.dismiss();
                }
            }
        });
    }

    private ag.a getOpenNewPageListener() {
        return new ag.a() { // from class: com.kwad.components.ad.interstitial.c.d.11
            AnonymousClass11() {
            }

            @Override // com.kwad.components.core.webview.jshandler.ag.a
            public final void a(com.kwad.components.core.webview.kwai.b bVar) {
                AdWebViewActivityProxy.launch(d.this.mContext, new AdWebViewActivityProxy.a.C0182a().au(bVar.title).av(bVar.url).aA(true).L(d.this.mAdTemplate).oc());
            }
        };
    }

    @NonNull
    private KsAdWebView.d getWebListener() {
        return new KsAdWebView.d() { // from class: com.kwad.components.ad.interstitial.c.d.22
            AnonymousClass22() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageFinished() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageStart() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onReceivedHttpError(int i2, String str, String str2) {
                d.this.w("1");
            }
        };
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void v(String str) {
        aI();
        c.a b2 = this.kh.getClientConfig().ct(this.mAdTemplate).b(getWebListener());
        this.kl = b2;
        this.kh.setClientConfig(b2);
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.kh);
        this.cU = aVar;
        a(aVar, str);
        this.kh.addJavascriptInterface(this.cU, "KwaiAd");
        this.kh.setBackgroundColor(0);
        this.kh.setVisibility(4);
        this.kh.loadUrl(str);
        bi.a(this.kp, null, 3000L);
    }

    public void w(String str) {
        com.kwad.sdk.core.d.b.d("InterstitialWebViewPresenter", "handleWebViewError " + str);
        com.kwad.sdk.core.f.d dVar = this.ef;
        if (dVar != null) {
            dVar.aY(getContext());
        }
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.fG) {
            return;
        }
        this.fG = true;
        com.kwad.components.core.m.a pb = com.kwad.components.core.m.a.pb();
        AdTemplate adTemplate = this.mAdTemplate;
        pb.b(adTemplate, com.kwad.sdk.core.response.a.b.bw(adTemplate), str);
        this.mHandler.post(new Runnable() { // from class: com.kwad.components.ad.interstitial.c.d.23
            AnonymousClass23() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                d.this.di();
                d.this.jt.cV();
            }
        });
        c.a aVar = this.kl;
        if (aVar != null) {
            aVar.b((KsAdWebView.d) null);
        }
    }

    @Override // com.kwad.components.ad.interstitial.c.b, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        c cVar = (c) Bh();
        this.jt = cVar;
        this.kn = false;
        this.kg = cVar.hU;
        this.dZ = cVar.dZ;
        this.mApkDownloadHelper = cVar.mApkDownloadHelper;
        AdTemplate adTemplate = cVar.mAdTemplate;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        this.eN = this.jt.eN;
        this.mViewVisibleHelper.rD();
        this.mViewVisibleHelper.a(this.dk);
        this.jt.a(this.ko);
        if (com.kwad.sdk.core.response.a.b.bu(this.mAdTemplate)) {
            this.mHandler.post(new Runnable() { // from class: com.kwad.components.ad.interstitial.c.d.21
                AnonymousClass21() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    d.this.di();
                    d.this.jt.cV();
                }
            });
        } else {
            aF();
            aG();
        }
    }

    @Override // com.kwad.components.ad.interstitial.c.b
    public final void cT() {
        super.cT();
        com.kwad.components.ad.f.kwai.kwai.b bVar = this.km;
        if (bVar != null) {
            bVar.fe();
        }
    }

    @Override // com.kwad.components.ad.interstitial.c.b
    public final void cU() {
        super.cU();
        com.kwad.components.ad.f.kwai.kwai.b bVar = this.km;
        if (bVar != null) {
            bVar.fd();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.kh = (KsAdWebView) getRootView().findViewById(R.id.ksad_web_card_webView);
        this.mViewVisibleHelper = new com.kwad.components.core.widget.kwai.b(getRootView(), 100);
        this.ke = (KSFrameLayout) getRootView().findViewById(R.id.ksad_container);
        this.kf = (KSFrameLayout) getRootView().findViewById(R.id.ksad_video_container);
        this.eM = (ImageView) getRootView().findViewById(R.id.ksad_video_first_frame_container);
        this.ki = (ImageView) getRootView().findViewById(R.id.ksad_interstitial_video_blur);
        Context context = getContext();
        this.mContext = context;
        if (context != null) {
            this.eg = (Vibrator) context.getSystemService("vibrator");
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.mHandler.removeCallbacksAndMessages(null);
        this.mViewVisibleHelper.b(this.dk);
        this.mViewVisibleHelper.rE();
        com.kwad.sdk.core.f.d dVar = this.ef;
        if (dVar != null) {
            dVar.aY(getContext());
        }
        c.a aVar = this.kl;
        if (aVar != null) {
            aVar.b((KsAdWebView.d) null);
        }
        this.jt.b(this.ko);
    }
}
