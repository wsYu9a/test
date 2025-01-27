package com.kwad.components.ad.splashscreen;

import android.content.Context;
import android.content.DialogInterface;
import android.os.SystemClock;
import android.view.View;
import androidx.annotation.NonNull;
import com.kwad.components.ad.splashscreen.presenter.j;
import com.kwad.components.ad.splashscreen.presenter.k;
import com.kwad.components.ad.splashscreen.presenter.o;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.l;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.n.m;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bs;

/* loaded from: classes2.dex */
public final class c extends com.kwad.components.core.l.c<h> implements DialogInterface.OnDismissListener, DialogInterface.OnShowListener {
    private KsSplashScreenAd.SplashScreenAdInteractionListener DH;
    private com.kwad.components.ad.splashscreen.e.d DI;

    /* renamed from: dk */
    private com.kwad.sdk.core.h.b f11899dk;
    private AdInfo mAdInfo;
    private AdResultData mAdResultData;
    private SceneImpl mAdScene;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private DetailVideoView mDetailVideoView;
    private boolean mPageDismissCalled;
    private AdBaseFrameLayout mRootContainer;
    private KsVideoPlayConfig mVideoPlayConfig;

    /* renamed from: com.kwad.components.ad.splashscreen.c$1 */
    public class AnonymousClass1 implements com.kwad.sdk.core.h.c {
        final /* synthetic */ h DJ;

        public AnonymousClass1(h hVar) {
            hVar = hVar;
        }

        @Override // com.kwad.sdk.core.h.c
        public final void bl() {
            bs bsVar = hVar.mTimerHelper;
            if (bsVar != null) {
                bsVar.Pn();
            }
        }

        @Override // com.kwad.sdk.core.h.c
        public final void bm() {
            bs bsVar = hVar.mTimerHelper;
            if (bsVar != null) {
                bsVar.Po();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.c$2 */
    public class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (com.kwad.sdk.c.a.a.BR() || !c.n(c.this.mAdInfo) || c.this.Ox == null) {
                return;
            }
            ((h) c.this.Ox).c(1, view.getContext(), 53, 2);
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.c$3 */
    public class AnonymousClass3 extends bd {
        public AnonymousClass3() {
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            AdTemplate adTemplate = c.this.mAdTemplate;
            AdInfo unused = c.this.mAdInfo;
            if (h.X(adTemplate) || ((h) c.this.Ox).DT == null) {
                return;
            }
            ((h) c.this.Ox).DT.mx();
        }
    }

    private c(Context context, AdResultData adResultData) {
        super(context);
        this.mAdResultData = adResultData;
        AdTemplate o10 = com.kwad.sdk.core.response.b.c.o(adResultData);
        this.mAdTemplate = o10;
        this.mAdScene = o10.mAdScene;
        py();
    }

    private static Presenter W(AdTemplate adTemplate) {
        AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(adTemplate);
        Presenter presenter = new Presenter();
        a(presenter, eb2);
        if (h.X(adTemplate)) {
            presenter.a(new com.kwad.components.ad.splashscreen.presenter.playcard.a());
        } else {
            presenter.a(new j());
        }
        return presenter;
    }

    private int getSplashLayoutId() {
        return R.layout.ksad_splash_screen_layout;
    }

    @Override // com.kwad.components.core.l.c
    /* renamed from: kK */
    public h ak() {
        com.kwad.components.ad.splashscreen.e.d dVar = new com.kwad.components.ad.splashscreen.e.d(this.mR, com.kwad.sdk.core.response.b.a.cH(this.mAdInfo));
        this.DI = dVar;
        dVar.a(this.f11899dk);
        this.DI.uE();
        if (this.mVideoPlayConfig == null) {
            this.mVideoPlayConfig = new KsVideoPlayConfig.Builder().videoSoundEnable(this.mAdInfo.adSplashInfo.mute != 1).build();
        }
        h hVar = new h();
        hVar.a(this.mAdResultData);
        hVar.setSplashScreenAdListener(this.DH);
        hVar.mRootContainer = this.mRootContainer;
        hVar.mAdScene = this.mAdScene;
        hVar.mVideoPlayConfig = this.mVideoPlayConfig;
        hVar.DV = this.DI;
        hVar.mApkDownloadHelper = this.mApkDownloadHelper;
        hVar.DU = b(this.mAdTemplate);
        hVar.mTimerHelper = new bs();
        if (com.kwad.sdk.core.response.b.a.bc(this.mAdInfo)) {
            com.kwad.components.ad.splashscreen.d.a aVar = new com.kwad.components.ad.splashscreen.d.a(this.mAdTemplate, this.mDetailVideoView, this.mVideoPlayConfig);
            hVar.DT = aVar;
            hVar.DV.a(aVar);
        }
        hVar.DV.a(a(hVar));
        return hVar;
    }

    private void kL() {
        com.kwad.sdk.a.a.c.Bg().Bj();
        if (this.mPageDismissCalled) {
            return;
        }
        this.mPageDismissCalled = true;
    }

    public static boolean n(@NonNull AdInfo adInfo) {
        AdInfo.AdSplashInfo adSplashInfo = adInfo.adSplashInfo;
        return adSplashInfo != null && adSplashInfo.fullScreenClickSwitch == 1;
    }

    @Override // com.kwad.components.core.l.c, com.kwad.sdk.widget.KSFrameLayout
    public final void Z() {
        super.Z();
        post(new bd() { // from class: com.kwad.components.ad.splashscreen.c.3
            public AnonymousClass3() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                AdTemplate adTemplate = c.this.mAdTemplate;
                AdInfo unused = c.this.mAdInfo;
                if (h.X(adTemplate) || ((h) c.this.Ox).DT == null) {
                    return;
                }
                ((h) c.this.Ox).DT.mx();
            }
        });
    }

    @Override // com.kwad.components.core.l.c, com.kwad.sdk.widget.KSFrameLayout
    public final void aa() {
        super.aa();
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.setOnDismissListener(null);
            this.mApkDownloadHelper.setOnShowListener(null);
        }
        this.DI.uF();
        kL();
    }

    @Override // com.kwad.components.core.l.c
    public final boolean ah() {
        return true;
    }

    @Override // com.kwad.components.core.l.c
    public final void aj() {
        this.mRootContainer = (AdBaseFrameLayout) this.mR.findViewById(R.id.ksad_splash_root_container);
        DetailVideoView detailVideoView = (DetailVideoView) this.mR.findViewById(R.id.ksad_splash_video_player);
        this.mDetailVideoView = detailVideoView;
        detailVideoView.setAd(true);
        this.mDetailVideoView.setVisibility(8);
        this.mRootContainer.findViewById(R.id.splash_play_card_view).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.splashscreen.c.2
            public AnonymousClass2() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (com.kwad.sdk.c.a.a.BR() || !c.n(c.this.mAdInfo) || c.this.Ox == null) {
                    return;
                }
                ((h) c.this.Ox).c(1, view.getContext(), 53, 2);
            }
        });
    }

    @Override // com.kwad.components.core.l.c
    public final int getLayoutId() {
        return getSplashLayoutId();
    }

    @Override // com.kwad.components.core.l.c
    public final void initData() {
        this.mAdInfo = com.kwad.sdk.core.response.b.e.eb(this.mAdTemplate);
        KsVideoPlayConfig build = new KsVideoPlayConfig.Builder().videoSoundEnable(this.mAdInfo.adSplashInfo.mute != 1).build();
        this.mVideoPlayConfig = build;
        this.mAdTemplate.mInitVoiceStatus = build.isVideoSoundEnable() ? 2 : 1;
        com.kwad.components.core.e.d.c cVar = new com.kwad.components.core.e.d.c(this.mAdTemplate);
        this.mApkDownloadHelper = cVar;
        cVar.setOnDismissListener(this);
        this.mApkDownloadHelper.setOnShowListener(this);
    }

    @Override // com.kwad.components.core.l.c
    @NonNull
    public final Presenter onCreatePresenter() {
        getContext();
        return W(this.mAdTemplate);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        boolean oh2 = dialogInterface instanceof com.kwad.components.core.e.c.b ? ((com.kwad.components.core.e.c.b) dialogInterface).oh() : false;
        try {
            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.DH;
            if (splashScreenAdInteractionListener != null) {
                if (oh2) {
                    splashScreenAdInteractionListener.onDownloadTipsDialogDismiss();
                } else {
                    splashScreenAdInteractionListener.onDownloadTipsDialogCancel();
                }
            }
        } catch (Throwable th2) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
        }
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface dialogInterface) {
        try {
            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.DH;
            if (splashScreenAdInteractionListener != null) {
                splashScreenAdInteractionListener.onDownloadTipsDialogShow();
            }
        } catch (Throwable th2) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
        }
    }

    @Override // android.view.View
    public final void onVisibilityChanged(@NonNull View view, int i10) {
        super.onVisibilityChanged(view, i10);
    }

    public final void setPageExitListener(com.kwad.sdk.core.h.b bVar) {
        this.f11899dk = bVar;
    }

    public final void setSplashScreenAdListener(KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        this.DH = splashScreenAdInteractionListener;
        T t10 = this.Ox;
        if (t10 != 0) {
            ((h) t10).setSplashScreenAdListener(splashScreenAdInteractionListener);
        }
    }

    public static c a(Context context, @NonNull AdResultData adResultData, boolean z10, com.kwad.sdk.core.h.b bVar, KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        AdTemplate o10 = com.kwad.sdk.core.response.b.c.o(adResultData);
        c cVar = null;
        try {
            o10.showStartTime = SystemClock.elapsedRealtime();
            com.kwad.components.ad.splashscreen.monitor.b.lm();
            com.kwad.components.ad.splashscreen.monitor.b.ae(o10);
            com.kwad.components.ad.splashscreen.monitor.b.lm();
            com.kwad.components.ad.splashscreen.monitor.b.a(o10, l.At().AT(), z10);
            c cVar2 = new c(m.wrapContextIfNeed(context), adResultData);
            try {
                cVar2.setPageExitListener(bVar);
                cVar2.setSplashScreenAdListener(splashScreenAdInteractionListener);
                return cVar2;
            } catch (Throwable th2) {
                th = th2;
                cVar = cVar2;
                com.kwad.components.ad.splashscreen.monitor.b.lm();
                com.kwad.components.ad.splashscreen.monitor.b.a(o10, th.toString(), z10);
                if (!l.At().zB()) {
                    throw th;
                }
                com.kwad.components.core.d.a.reportSdkCaughtException(th);
                return cVar;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private static StyleTemplate b(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate k10 = com.kwad.sdk.core.response.b.b.k(adTemplate, com.kwad.sdk.core.response.b.b.dB(adTemplate));
        StyleTemplate styleTemplate = new StyleTemplate();
        if (k10 != null) {
            styleTemplate.templateId = k10.templateId;
            styleTemplate.templateMd5 = k10.templateMd5;
            styleTemplate.templateUrl = k10.templateUrl;
            styleTemplate.templateVersionCode = (int) k10.templateVersionCode;
        }
        return styleTemplate;
    }

    private com.kwad.sdk.core.h.c a(h hVar) {
        return new com.kwad.sdk.core.h.c() { // from class: com.kwad.components.ad.splashscreen.c.1
            final /* synthetic */ h DJ;

            public AnonymousClass1(h hVar2) {
                hVar = hVar2;
            }

            @Override // com.kwad.sdk.core.h.c
            public final void bl() {
                bs bsVar = hVar.mTimerHelper;
                if (bsVar != null) {
                    bsVar.Pn();
                }
            }

            @Override // com.kwad.sdk.core.h.c
            public final void bm() {
                bs bsVar = hVar.mTimerHelper;
                if (bsVar != null) {
                    bsVar.Po();
                }
            }
        };
    }

    private static void a(Presenter presenter, AdInfo adInfo) {
        presenter.a(new k());
        presenter.a(new o());
        if (h.r(adInfo)) {
            presenter.a(new com.kwad.components.ad.splashscreen.presenter.endcard.f());
        }
    }
}
