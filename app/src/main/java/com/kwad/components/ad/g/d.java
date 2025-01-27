package com.kwad.components.ad.g;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.g.b;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.e.d.c;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.widget.a;
import com.kwad.components.core.widget.c;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.api.KsImage;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.core.AbstractKsNativeAd;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.api.model.KsLiveInfo;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.NativeAdExtraDataImpl;
import com.kwad.sdk.l;
import com.kwad.sdk.n.m;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.bs;
import com.kwad.sdk.utils.bt;
import com.tencent.bugly.beta.tinker.TinkerReport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class d extends AbstractKsNativeAd implements DialogInterface.OnDismissListener, DialogInterface.OnShowListener, com.kwad.components.core.internal.api.a {
    private Vibrator fx;
    private AdInfo mAdInfo;

    @NonNull
    private AdTemplate mAdTemplate;

    @Nullable
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private bs mTimerHelper;
    private boolean nC;

    @Nullable
    private KsNativeAd.AdInteractionListener nD;
    private f nE;
    private e nF;

    @Nullable
    private KsNativeAd.VideoPlayListener nG;
    private b.c ny;
    private boolean nH = false;
    private com.kwad.components.core.internal.api.c bz = new com.kwad.components.core.internal.api.c();
    private int nI = 0;
    private int nJ = 0;
    private boolean nK = true;
    private boolean nL = true;
    private KsNativeAd.VideoPlayListener nM = new KsNativeAd.VideoPlayListener() { // from class: com.kwad.components.ad.g.d.8
        public AnonymousClass8() {
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayComplete() {
            if (d.this.nG != null) {
                d.this.nG.onVideoPlayComplete();
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayError(int i10, int i11) {
            if (d.this.nG != null) {
                d.this.nG.onVideoPlayError(i10, i11);
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayPause() {
            if (d.this.nG != null) {
                try {
                    d.this.nG.onVideoPlayPause();
                } catch (Throwable th2) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayReady() {
            if (d.this.nG != null) {
                try {
                    d.this.nG.onVideoPlayReady();
                } catch (Throwable th2) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayResume() {
            if (d.this.nG != null) {
                try {
                    d.this.nG.onVideoPlayResume();
                } catch (Throwable th2) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayStart() {
            if (d.this.nG != null) {
                d.this.nG.onVideoPlayStart();
            }
        }
    };
    private a nN = new a() { // from class: com.kwad.components.ad.g.d.9
        public AnonymousClass9() {
        }

        @Override // com.kwad.components.ad.g.d.a
        public final void eL() {
            if (d.this.nD != null) {
                d.this.nD.onAdShow(d.this);
            }
        }

        @Override // com.kwad.components.ad.g.d.a
        public final boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
            if (d.this.nD == null) {
                return false;
            }
            try {
                return d.this.nD.handleDownloadDialog(onClickListener);
            } catch (Throwable th2) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
                return false;
            }
        }

        @Override // com.kwad.components.ad.g.d.a
        public final void l(View view) {
            if (d.this.nD != null) {
                d.this.nD.onAdClicked(new FrameLayout(m.dJ(view.getContext())), d.this);
            }
        }

        @Override // com.kwad.components.ad.g.d.a
        public final void onDownloadTipsDialogDismiss() {
            if (d.this.nD != null) {
                try {
                    d.this.nD.onDownloadTipsDialogDismiss();
                } catch (Throwable unused) {
                }
            }
        }

        @Override // com.kwad.components.ad.g.d.a
        public final void onDownloadTipsDialogShow() {
            if (d.this.nD != null) {
                try {
                    d.this.nD.onDownloadTipsDialogShow();
                } catch (Throwable unused) {
                }
            }
        }
    };

    /* renamed from: com.kwad.components.ad.g.d$1 */
    public class AnonymousClass1 implements c.a {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.e.d.c.a
        public final boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
            return d.this.nN.handleDownloadDialog(onClickListener);
        }
    }

    /* renamed from: com.kwad.components.ad.g.d$2 */
    public class AnonymousClass2 implements View.OnTouchListener {
        final /* synthetic */ ViewGroup lO;
        private int[] nP = new int[2];
        final /* synthetic */ ag.a nQ;
        final /* synthetic */ View nR;
        final /* synthetic */ Activity nS;
        final /* synthetic */ int nT;
        final /* synthetic */ boolean nU;

        public AnonymousClass2(ag.a aVar, ViewGroup viewGroup, View view, Activity activity, int i10, boolean z10) {
            aVar = aVar;
            viewGroup = viewGroup;
            view = view;
            activity = activity;
            G = i10;
            z10 = z10;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                aVar.z(viewGroup.getWidth(), viewGroup.getHeight());
                viewGroup.getLocationOnScreen(this.nP);
                aVar.f(Math.abs(motionEvent.getRawX() - this.nP[0]), Math.abs(motionEvent.getRawY() - this.nP[1]));
            } else if (action == 1) {
                aVar.g(Math.abs(motionEvent.getRawX() - this.nP[0]), Math.abs(motionEvent.getRawY() - this.nP[1]));
                if (d.this.nK && d.this.b(aVar)) {
                    view.setPressed(false);
                    d.this.a(activity, view, aVar, G, z10, 153);
                } else if (d.this.nL && com.kwad.sdk.core.config.d.CV()) {
                    if (d.b(d.this, aVar)) {
                        d.this.a(activity, view, aVar, G, z10, 0);
                    }
                    return true;
                }
            }
            return false;
        }
    }

    /* renamed from: com.kwad.components.ad.g.d$3 */
    public class AnonymousClass3 implements View.OnClickListener {
        final /* synthetic */ ag.a nQ;
        final /* synthetic */ Activity nS;
        final /* synthetic */ int nT;
        final /* synthetic */ boolean nU;

        public AnonymousClass3(Activity activity, ag.a aVar, int i10, boolean z10) {
            activity = activity;
            aVar = aVar;
            G = i10;
            z10 = z10;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (d.this.nL) {
                d.this.a(activity, view, aVar, G, z10, 0);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.g.d$4 */
    public class AnonymousClass4 implements a.b {
        final /* synthetic */ int cO;
        final /* synthetic */ View gv;
        final /* synthetic */ ag.a nQ;

        public AnonymousClass4(ag.a aVar, int i10, View view) {
            aVar = aVar;
            i11 = i10;
            view = view;
        }

        @Override // com.kwad.components.core.e.d.a.b
        public final void onAdClicked() {
            com.kwad.sdk.core.adlog.c.a(d.this.mAdTemplate, new com.kwad.sdk.core.adlog.c.b().f(aVar).cL(i11), (JSONObject) null);
            d.this.nN.l(view);
        }
    }

    /* renamed from: com.kwad.components.ad.g.d$5 */
    public class AnonymousClass5 implements a.InterfaceC0457a {
        final /* synthetic */ ViewGroup lO;

        public AnonymousClass5(ViewGroup viewGroup) {
            viewGroup = viewGroup;
        }

        @Override // com.kwad.components.core.widget.a.InterfaceC0457a
        public final void Z() {
            com.kwad.components.ad.j.b.fc().a(d.this);
        }

        @Override // com.kwad.components.core.widget.a.InterfaceC0457a
        public final void aa() {
            try {
                long Pp = d.this.getTimerHelper().Pp();
                if (d.this.mAdTemplate.mPvReported && d.this.nH) {
                    com.kwad.sdk.core.adlog.c.a(d.this.mAdTemplate, Pp, (JSONObject) null);
                    d.this.nH = false;
                }
                if (com.kwad.sdk.core.response.b.a.cT(d.this.mAdInfo)) {
                    com.kwad.sdk.core.adlog.c.m(d.this.mAdTemplate, ((int) Pp) / 1000);
                }
                d.this.bz.i(d.this);
                b.eG().a(d.this.ny);
                com.kwad.components.ad.j.b.fc().b(d.this);
            } catch (Throwable th2) {
                ServiceProvider.reportSdkCaughtException(th2);
            }
        }

        @Override // com.kwad.components.core.widget.a.InterfaceC0457a
        public final void ax() {
            try {
                if (d.this.mAdTemplate.mPvReported && d.this.nH) {
                    com.kwad.sdk.core.adlog.c.a(d.this.mAdTemplate, d.this.getTimerHelper().Pp(), (JSONObject) null);
                    d.this.nH = false;
                    b.eG().a(d.this.ny);
                }
            } catch (Throwable th2) {
                ServiceProvider.reportSdkCaughtException(th2);
            }
        }

        @Override // com.kwad.components.core.widget.a.InterfaceC0457a
        public final void c(View view) {
            if (!d.this.mAdTemplate.mPvReported) {
                d.this.nN.eL();
                d.this.eJ();
                com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                bVar.v(viewGroup.getHeight(), viewGroup.getWidth());
                if (com.kwad.sdk.core.response.b.a.cS(d.this.mAdInfo)) {
                    a.C0484a c0484a = new a.C0484a();
                    c0484a.showLiveStyle = d.this.nJ;
                    c0484a.showLiveStatus = d.this.nI;
                    bVar.b(c0484a);
                }
                com.kwad.components.core.s.b.sc().a(d.this.mAdTemplate, null, bVar);
            }
            if (!d.this.nH) {
                d.this.k(view);
                d.this.getTimerHelper().startTiming();
                d.this.bz.h(d.this);
            }
            d.this.nH = true;
        }

        @Override // com.kwad.components.core.widget.a.InterfaceC0457a
        public final void onWindowFocusChanged(boolean z10) {
        }
    }

    /* renamed from: com.kwad.components.ad.g.d$6 */
    public class AnonymousClass6 implements c.a {
        final /* synthetic */ ViewGroup lO;

        public AnonymousClass6(ViewGroup viewGroup) {
            viewGroup = viewGroup;
        }

        @Override // com.kwad.components.core.widget.c.a
        public final void eK() {
            if (!d.this.mAdTemplate.mPvReported) {
                d.this.nN.eL();
            }
            d.this.eJ();
            com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
            bVar.v(viewGroup.getHeight(), viewGroup.getWidth());
            if (com.kwad.sdk.core.response.b.a.cS(d.this.mAdInfo)) {
                a.C0484a c0484a = new a.C0484a();
                c0484a.showLiveStyle = d.this.nJ;
                c0484a.showLiveStatus = d.this.nI;
                bVar.b(c0484a);
            }
            com.kwad.components.core.s.b.sc().a(d.this.mAdTemplate, null, bVar);
            com.kwad.sdk.commercial.d.c.bG(d.this.mAdTemplate);
        }
    }

    /* renamed from: com.kwad.components.ad.g.d$7 */
    public class AnonymousClass7 implements b.c {
        final /* synthetic */ View nV;

        /* renamed from: com.kwad.components.ad.g.d$7$1 */
        public class AnonymousClass1 implements a.b {
            final /* synthetic */ double hu;

            public AnonymousClass1(double d10) {
                d10 = d10;
            }

            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                com.kwad.sdk.core.adlog.c.a(d.this.mAdTemplate, new com.kwad.sdk.core.adlog.c.b().cL(TinkerReport.KEY_APPLIED_PACKAGE_CHECK_RES_META).l(d10), (JSONObject) null);
                d.this.nN.l(view);
            }
        }

        public AnonymousClass7(View view) {
            view = view;
        }

        @Override // com.kwad.components.ad.g.b.c
        public final void f(double d10) {
            if (d.this.mAdInfo.status == 3 || d.this.mAdInfo.status == 2) {
                return;
            }
            com.kwad.components.core.e.d.a.a(new a.C0427a(m.wrapContextIfNeed(view.getContext())).au(d.this.mAdTemplate).b(d.this.mApkDownloadHelper).aw(false).a(new a.b() { // from class: com.kwad.components.ad.g.d.7.1
                final /* synthetic */ double hu;

                public AnonymousClass1(double d102) {
                    d10 = d102;
                }

                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    com.kwad.sdk.core.adlog.c.a(d.this.mAdTemplate, new com.kwad.sdk.core.adlog.c.b().cL(TinkerReport.KEY_APPLIED_PACKAGE_CHECK_RES_META).l(d10), (JSONObject) null);
                    d.this.nN.l(view);
                }
            }));
            bt.a(view.getContext(), d.this.E(view.getContext()));
        }
    }

    /* renamed from: com.kwad.components.ad.g.d$8 */
    public class AnonymousClass8 implements KsNativeAd.VideoPlayListener {
        public AnonymousClass8() {
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayComplete() {
            if (d.this.nG != null) {
                d.this.nG.onVideoPlayComplete();
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayError(int i10, int i11) {
            if (d.this.nG != null) {
                d.this.nG.onVideoPlayError(i10, i11);
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayPause() {
            if (d.this.nG != null) {
                try {
                    d.this.nG.onVideoPlayPause();
                } catch (Throwable th2) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayReady() {
            if (d.this.nG != null) {
                try {
                    d.this.nG.onVideoPlayReady();
                } catch (Throwable th2) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayResume() {
            if (d.this.nG != null) {
                try {
                    d.this.nG.onVideoPlayResume();
                } catch (Throwable th2) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayStart() {
            if (d.this.nG != null) {
                d.this.nG.onVideoPlayStart();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.g.d$9 */
    public class AnonymousClass9 implements a {
        public AnonymousClass9() {
        }

        @Override // com.kwad.components.ad.g.d.a
        public final void eL() {
            if (d.this.nD != null) {
                d.this.nD.onAdShow(d.this);
            }
        }

        @Override // com.kwad.components.ad.g.d.a
        public final boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
            if (d.this.nD == null) {
                return false;
            }
            try {
                return d.this.nD.handleDownloadDialog(onClickListener);
            } catch (Throwable th2) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
                return false;
            }
        }

        @Override // com.kwad.components.ad.g.d.a
        public final void l(View view) {
            if (d.this.nD != null) {
                d.this.nD.onAdClicked(new FrameLayout(m.dJ(view.getContext())), d.this);
            }
        }

        @Override // com.kwad.components.ad.g.d.a
        public final void onDownloadTipsDialogDismiss() {
            if (d.this.nD != null) {
                try {
                    d.this.nD.onDownloadTipsDialogDismiss();
                } catch (Throwable unused) {
                }
            }
        }

        @Override // com.kwad.components.ad.g.d.a
        public final void onDownloadTipsDialogShow() {
            if (d.this.nD != null) {
                try {
                    d.this.nD.onDownloadTipsDialogShow();
                } catch (Throwable unused) {
                }
            }
        }
    }

    public interface a {
        void eL();

        boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener);

        void l(View view);

        void onDownloadTipsDialogDismiss();

        void onDownloadTipsDialogShow();
    }

    public d(@NonNull AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(adTemplate);
        this.mAdInfo = eb2;
        if (com.kwad.sdk.core.response.b.a.aF(eb2)) {
            com.kwad.components.core.e.d.c cVar = new com.kwad.components.core.e.d.c(this.mAdTemplate);
            this.mApkDownloadHelper = cVar;
            cVar.setOnShowListener(this);
            this.mApkDownloadHelper.setOnDismissListener(this);
            this.mApkDownloadHelper.a(new c.a() { // from class: com.kwad.components.ad.g.d.1
                public AnonymousClass1() {
                }

                @Override // com.kwad.components.core.e.d.c.a
                public final boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
                    return d.this.nN.handleDownloadDialog(onClickListener);
                }
            });
        }
        KSImageLoader.preloadImage(com.kwad.sdk.core.response.b.a.O(this.mAdInfo), this.mAdTemplate);
    }

    public Vibrator E(Context context) {
        if (this.fx == null) {
            this.fx = (Vibrator) context.getSystemService("vibrator");
        }
        return this.fx;
    }

    private int G(int i10) {
        if (i10 == 3 || i10 == 4) {
            this.nK = false;
        } else if (i10 == 5 || i10 == 6) {
            this.nL = false;
        } else {
            this.nL = true;
            this.nK = true;
        }
        return i10 % 2 == 0 ? 2 : 1;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    /* renamed from: eI */
    public com.kwad.components.core.internal.api.d getVideoCoverImage() {
        AdInfo.AdMaterialInfo.MaterialFeature aV = com.kwad.sdk.core.response.b.a.aV(this.mAdInfo);
        if (TextUtils.isEmpty(aV.coverUrl)) {
            return null;
        }
        return new com.kwad.components.core.internal.api.d(aV.width, aV.height, aV.coverUrl);
    }

    public void eJ() {
        try {
            NativeAdExtraDataImpl nativeAdExtraDataImpl = this.mAdTemplate.mAdScene.nativeAdExtraData;
            this.nI = nativeAdExtraDataImpl.showLiveStatus;
            this.nJ = nativeAdExtraDataImpl.showLiveStyle;
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getActionDescription() {
        return com.kwad.sdk.core.response.b.a.aE(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getAdDescription() {
        return com.kwad.sdk.core.response.b.a.au(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getAdSource() {
        return com.kwad.sdk.core.response.b.a.aD(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getAdSourceLogoUrl(int i10) {
        AdInfo adInfo = this.mAdInfo;
        if (adInfo == null) {
            return null;
        }
        return i10 != 1 ? adInfo.adBaseInfo.adMarkIcon : adInfo.adBaseInfo.adGrayMarkIcon;
    }

    @Override // com.kwad.components.core.internal.api.a
    @NonNull
    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getAppDownloadCountDes() {
        return com.kwad.sdk.core.response.b.a.az(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getAppIconUrl() {
        return com.kwad.sdk.core.response.b.a.cm(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final String getAppName() {
        return com.kwad.sdk.core.response.b.a.av(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getAppPackageName() {
        return com.kwad.sdk.core.response.b.a.ay(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final long getAppPackageSize() {
        return com.kwad.sdk.core.response.b.a.bI(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getAppPrivacyUrl() {
        return com.kwad.sdk.core.response.b.a.bG(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final float getAppScore() {
        return com.kwad.sdk.core.response.b.a.aA(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getAppVersion() {
        return com.kwad.sdk.core.response.b.a.bH(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getCorporationName() {
        return com.kwad.sdk.core.response.b.a.bB(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final int getECPM() {
        return com.kwad.sdk.core.response.b.a.aR(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final List<KsImage> getImageList() {
        ArrayList arrayList = new ArrayList();
        AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(this.mAdTemplate);
        int be2 = com.kwad.sdk.core.response.b.a.be(this.mAdInfo);
        if (be2 == 2 || be2 == 3) {
            for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : eb2.adMaterialInfo.materialFeatureList) {
                if (materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                    arrayList.add(new com.kwad.components.core.internal.api.d(materialFeature.width, materialFeature.height, materialFeature.materialUrl));
                }
            }
        }
        return arrayList;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final int getInteractionType() {
        return com.kwad.sdk.core.response.b.a.aQ(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getIntroductionInfo() {
        return com.kwad.sdk.core.response.b.a.bE(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getIntroductionInfoUrl() {
        return com.kwad.sdk.core.response.b.a.bF(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final KsLiveInfo getLiveInfo() {
        if (com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.awL)) {
            return com.kwad.sdk.core.response.b.e.es(this.mAdTemplate);
        }
        return null;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final int getMaterialType() {
        return com.kwad.sdk.core.response.b.a.be(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.BaseKSAd
    public final Map<String, Object> getMediaExtraInfo() {
        HashMap hashMap = new HashMap();
        if (com.kwad.sdk.core.config.d.Dx()) {
            hashMap.put("llsid", Long.valueOf(this.mAdTemplate.llsid));
        }
        return hashMap;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getPermissionInfo() {
        return com.kwad.sdk.core.response.b.a.bC(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getPermissionInfoUrl() {
        return com.kwad.sdk.core.response.b.a.bD(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final String getProductName() {
        return com.kwad.sdk.core.response.b.a.ax(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.core.AbstractKsNativeAd
    public final Bitmap getSdkLogo() {
        return BitmapFactory.decodeResource(ServiceProvider.getContext().getResources(), R.drawable.ksad_sdk_logo);
    }

    public final bs getTimerHelper() {
        if (this.mTimerHelper == null) {
            this.mTimerHelper = new bs();
        }
        return this.mTimerHelper;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final int getVideoDuration() {
        return com.kwad.sdk.core.response.b.a.L(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final int getVideoHeight() {
        if (com.kwad.sdk.core.response.b.a.cS(this.mAdInfo)) {
            return 1280;
        }
        return com.kwad.sdk.core.response.b.a.aV(this.mAdInfo).videoHeight;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final String getVideoUrl() {
        return com.kwad.sdk.core.response.b.a.K(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.core.AbstractKsNativeAd
    public final View getVideoView2(Context context, boolean z10) {
        if (context == null || !l.At().zE()) {
            return null;
        }
        return getVideoView2(context, new KsAdVideoPlayConfig.Builder().videoSoundEnable(z10).build());
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final int getVideoWidth() {
        if (com.kwad.sdk.core.response.b.a.cS(this.mAdInfo)) {
            return 720;
        }
        return com.kwad.sdk.core.response.b.a.aV(this.mAdInfo).videoWidth;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        this.nN.onDownloadTipsDialogDismiss();
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface dialogInterface) {
        a aVar = this.nN;
        if (aVar != null) {
            aVar.onDownloadTipsDialogShow();
        }
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void registerViewForInteraction(@NonNull ViewGroup viewGroup, @NonNull List<View> list, KsNativeAd.AdInteractionListener adInteractionListener) {
        registerViewForInteraction((Activity) null, viewGroup, list, adInteractionListener);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void reportAdExposureFailed(int i10, AdExposureFailedReason adExposureFailedReason) {
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, i10, adExposureFailedReason);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void reportAdVideoPlayEnd() {
        com.kwad.sdk.core.adlog.c.bT(getAdTemplate());
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void reportAdVideoPlayStart() {
        com.kwad.sdk.core.adlog.c.bS(getAdTemplate());
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void setBidEcpm(int i10) {
        setBidEcpm(i10, -1L);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void setDownloadListener(KsAppDownloadListener ksAppDownloadListener) {
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar == null || ksAppDownloadListener == null) {
            return;
        }
        cVar.b(ksAppDownloadListener);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void setVideoPlayListener(KsNativeAd.VideoPlayListener videoPlayListener) {
        this.nG = videoPlayListener;
    }

    @Override // com.kwad.components.core.internal.api.a
    public final boolean supportPushAd() {
        return true;
    }

    public static /* synthetic */ boolean b(d dVar, ag.a aVar) {
        return c(aVar);
    }

    private static boolean c(ag.a aVar) {
        return (Math.abs(aVar.NK() - aVar.NM()) < 20) && (Math.abs(aVar.NL() - aVar.NN()) < 20);
    }

    public void k(View view) {
        if (com.kwad.sdk.core.response.b.a.ai(this.mAdInfo)) {
            float aj2 = com.kwad.sdk.core.response.b.a.aj(this.mAdInfo);
            this.ny = new b.c() { // from class: com.kwad.components.ad.g.d.7
                final /* synthetic */ View nV;

                /* renamed from: com.kwad.components.ad.g.d$7$1 */
                public class AnonymousClass1 implements a.b {
                    final /* synthetic */ double hu;

                    public AnonymousClass1(double d102) {
                        d10 = d102;
                    }

                    @Override // com.kwad.components.core.e.d.a.b
                    public final void onAdClicked() {
                        com.kwad.sdk.core.adlog.c.a(d.this.mAdTemplate, new com.kwad.sdk.core.adlog.c.b().cL(TinkerReport.KEY_APPLIED_PACKAGE_CHECK_RES_META).l(d10), (JSONObject) null);
                        d.this.nN.l(view);
                    }
                }

                public AnonymousClass7(View view2) {
                    view = view2;
                }

                @Override // com.kwad.components.ad.g.b.c
                public final void f(double d102) {
                    if (d.this.mAdInfo.status == 3 || d.this.mAdInfo.status == 2) {
                        return;
                    }
                    com.kwad.components.core.e.d.a.a(new a.C0427a(m.wrapContextIfNeed(view.getContext())).au(d.this.mAdTemplate).b(d.this.mApkDownloadHelper).aw(false).a(new a.b() { // from class: com.kwad.components.ad.g.d.7.1
                        final /* synthetic */ double hu;

                        public AnonymousClass1(double d1022) {
                            d10 = d1022;
                        }

                        @Override // com.kwad.components.core.e.d.a.b
                        public final void onAdClicked() {
                            com.kwad.sdk.core.adlog.c.a(d.this.mAdTemplate, new com.kwad.sdk.core.adlog.c.b().cL(TinkerReport.KEY_APPLIED_PACKAGE_CHECK_RES_META).l(d10), (JSONObject) null);
                            d.this.nN.l(view);
                        }
                    }));
                    bt.a(view.getContext(), d.this.E(view.getContext()));
                }
            };
            b.eG().a(aj2, view2, this.ny);
        }
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void registerViewForInteraction(Activity activity, @NonNull ViewGroup viewGroup, @NonNull List<View> list, KsNativeAd.AdInteractionListener adInteractionListener) {
        this.nD = adInteractionListener;
        a(viewGroup);
        a(activity, viewGroup, list);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void setBidEcpm(long j10, long j11) {
        AdTemplate adTemplate = this.mAdTemplate;
        adTemplate.mBidEcpm = j10;
        com.kwad.sdk.core.adlog.c.l(adTemplate, j11);
    }

    public boolean b(ag.a aVar) {
        if (com.kwad.sdk.core.response.b.d.dQ(this.mAdTemplate)) {
            return com.kwad.sdk.utils.b.a(aVar, com.kwad.sdk.core.response.b.a.U(this.mAdInfo));
        }
        return false;
    }

    private static void c(ViewGroup viewGroup) {
        for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
            View childAt = viewGroup.getChildAt(i10);
            if (childAt instanceof com.kwad.components.core.widget.a) {
                viewGroup.removeView(childAt);
            }
        }
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void registerViewForInteraction(Activity activity, @NonNull ViewGroup viewGroup, @NonNull Map<View, Integer> map, KsNativeAd.AdInteractionListener adInteractionListener) {
        this.nD = adInteractionListener;
        a(viewGroup);
        a(activity, viewGroup, map);
    }

    private static com.kwad.components.core.widget.c b(ViewGroup viewGroup) {
        for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
            View childAt = viewGroup.getChildAt(i10);
            if (childAt instanceof com.kwad.components.core.widget.c) {
                return (com.kwad.components.core.widget.c) childAt;
            }
        }
        return null;
    }

    @Override // com.kwad.sdk.api.core.AbstractKsNativeAd
    @Nullable
    public final View getVideoView2(Context context, @Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl;
        if (context == null || !l.At().zE()) {
            return null;
        }
        try {
            Context wrapContextIfNeed = m.wrapContextIfNeed(context);
            if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
                kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            } else {
                kSAdVideoPlayConfigImpl = new KSAdVideoPlayConfigImpl();
            }
            if (com.kwad.sdk.core.response.b.a.cS(this.mAdInfo)) {
                return a(wrapContextIfNeed, kSAdVideoPlayConfigImpl);
            }
            return b(wrapContextIfNeed, kSAdVideoPlayConfigImpl);
        } catch (Throwable th2) {
            RuntimeException runtimeException = new RuntimeException("getVideoView fail--context:" + context.getClass().getName() + "--classloader:" + context.getClassLoader().getClass().getName());
            if (l.At().zB()) {
                runtimeException.addSuppressed(th2);
                com.kwad.components.core.d.a.reportSdkCaughtException(runtimeException);
                return null;
            }
            throw th2;
        }
    }

    private void a(@Nullable Activity activity, @NonNull ViewGroup viewGroup, @NonNull List<View> list) {
        Iterator<View> it = list.iterator();
        while (it.hasNext()) {
            a(activity, viewGroup, 0, it.next(), false);
        }
    }

    private void a(@Nullable Activity activity, @NonNull ViewGroup viewGroup, @NonNull Map<View, Integer> map) {
        for (View view : map.keySet()) {
            if (map.get(view) != null) {
                a(activity, viewGroup, map.get(view).intValue(), view, true);
            }
        }
    }

    @Override // com.kwad.components.core.internal.api.a
    public final void b(com.kwad.components.core.internal.api.b bVar) {
        this.bz.b(bVar);
    }

    private View b(Context context, @NonNull KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl) {
        if (TextUtils.isEmpty(getVideoUrl())) {
            com.kwad.sdk.core.d.c.w("KsNativeAdControl", "videoUrl is empty");
            return null;
        }
        if (this.nE == null) {
            f fVar = new f(context);
            this.nE = fVar;
            fVar.setInnerAdInteractionListener(this.nN);
            this.nE.setVideoPlayListener(this.nM);
            this.nE.a(this.mAdTemplate, this.mApkDownloadHelper, kSAdVideoPlayConfigImpl);
        }
        return this.nE;
    }

    private void a(Activity activity, @NonNull ViewGroup viewGroup, int i10, View view, boolean z10) {
        ag.a aVar = new ag.a();
        if (view == null) {
            return;
        }
        int G = G(i10);
        if (view instanceof f) {
            ((f) view).d(this.nL, this.nK);
        } else {
            view.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.components.ad.g.d.2
                final /* synthetic */ ViewGroup lO;
                private int[] nP = new int[2];
                final /* synthetic */ ag.a nQ;
                final /* synthetic */ View nR;
                final /* synthetic */ Activity nS;
                final /* synthetic */ int nT;
                final /* synthetic */ boolean nU;

                public AnonymousClass2(ag.a aVar2, ViewGroup viewGroup2, View view2, Activity activity2, int G2, boolean z102) {
                    aVar = aVar2;
                    viewGroup = viewGroup2;
                    view = view2;
                    activity = activity2;
                    G = G2;
                    z10 = z102;
                }

                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view2, MotionEvent motionEvent) {
                    int action = motionEvent.getAction();
                    if (action == 0) {
                        aVar.z(viewGroup.getWidth(), viewGroup.getHeight());
                        viewGroup.getLocationOnScreen(this.nP);
                        aVar.f(Math.abs(motionEvent.getRawX() - this.nP[0]), Math.abs(motionEvent.getRawY() - this.nP[1]));
                    } else if (action == 1) {
                        aVar.g(Math.abs(motionEvent.getRawX() - this.nP[0]), Math.abs(motionEvent.getRawY() - this.nP[1]));
                        if (d.this.nK && d.this.b(aVar)) {
                            view.setPressed(false);
                            d.this.a(activity, view2, aVar, G, z10, 153);
                        } else if (d.this.nL && com.kwad.sdk.core.config.d.CV()) {
                            if (d.b(d.this, aVar)) {
                                d.this.a(activity, view2, aVar, G, z10, 0);
                            }
                            return true;
                        }
                    }
                    return false;
                }
            });
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.g.d.3
                final /* synthetic */ ag.a nQ;
                final /* synthetic */ Activity nS;
                final /* synthetic */ int nT;
                final /* synthetic */ boolean nU;

                public AnonymousClass3(Activity activity2, ag.a aVar2, int G2, boolean z102) {
                    activity = activity2;
                    aVar = aVar2;
                    G = G2;
                    z10 = z102;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    if (d.this.nL) {
                        d.this.a(activity, view2, aVar, G, z10, 0);
                    }
                }
            });
        }
    }

    public void a(@Nullable Activity activity, View view, ag.a aVar, int i10, boolean z10, int i11) {
        long playDuration;
        com.kwad.components.ad.g.c.a aVar2;
        IAdLivePlayModule iAdLivePlayModule;
        Context context = activity;
        if (activity == null) {
            context = view.getContext();
        }
        Context wrapContextIfNeed = m.wrapContextIfNeed(context);
        e eVar = this.nF;
        if (eVar != null && (iAdLivePlayModule = eVar.go) != null) {
            playDuration = iAdLivePlayModule.getPlayDuration();
        } else {
            f fVar = this.nE;
            playDuration = (fVar == null || (aVar2 = fVar.f11563of) == null) ? 0L : aVar2.getPlayDuration();
        }
        com.kwad.components.core.e.d.a.a(new a.C0427a(wrapContextIfNeed).au(this.mAdTemplate).b(this.mApkDownloadHelper).ar(i10).ap(true).v(playDuration).aw(z10).a(new a.b() { // from class: com.kwad.components.ad.g.d.4
            final /* synthetic */ int cO;
            final /* synthetic */ View gv;
            final /* synthetic */ ag.a nQ;

            public AnonymousClass4(ag.a aVar3, int i112, View view2) {
                aVar = aVar3;
                i11 = i112;
                view = view2;
            }

            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                com.kwad.sdk.core.adlog.c.a(d.this.mAdTemplate, new com.kwad.sdk.core.adlog.c.b().f(aVar).cL(i11), (JSONObject) null);
                d.this.nN.l(view);
            }
        }));
    }

    private void a(ViewGroup viewGroup) {
        if (!this.nC) {
            this.nC = true;
            com.kwad.sdk.commercial.d.c.bF(this.mAdTemplate);
        }
        if (!com.kwad.sdk.core.config.d.DN() && com.kwad.sdk.core.config.d.DM() >= 0.0f) {
            c(viewGroup);
            com.kwad.components.core.widget.a aVar = new com.kwad.components.core.widget.a(viewGroup.getContext(), viewGroup);
            viewGroup.addView(aVar);
            aVar.setViewCallback(new a.InterfaceC0457a() { // from class: com.kwad.components.ad.g.d.5
                final /* synthetic */ ViewGroup lO;

                public AnonymousClass5(ViewGroup viewGroup2) {
                    viewGroup = viewGroup2;
                }

                @Override // com.kwad.components.core.widget.a.InterfaceC0457a
                public final void Z() {
                    com.kwad.components.ad.j.b.fc().a(d.this);
                }

                @Override // com.kwad.components.core.widget.a.InterfaceC0457a
                public final void aa() {
                    try {
                        long Pp = d.this.getTimerHelper().Pp();
                        if (d.this.mAdTemplate.mPvReported && d.this.nH) {
                            com.kwad.sdk.core.adlog.c.a(d.this.mAdTemplate, Pp, (JSONObject) null);
                            d.this.nH = false;
                        }
                        if (com.kwad.sdk.core.response.b.a.cT(d.this.mAdInfo)) {
                            com.kwad.sdk.core.adlog.c.m(d.this.mAdTemplate, ((int) Pp) / 1000);
                        }
                        d.this.bz.i(d.this);
                        b.eG().a(d.this.ny);
                        com.kwad.components.ad.j.b.fc().b(d.this);
                    } catch (Throwable th2) {
                        ServiceProvider.reportSdkCaughtException(th2);
                    }
                }

                @Override // com.kwad.components.core.widget.a.InterfaceC0457a
                public final void ax() {
                    try {
                        if (d.this.mAdTemplate.mPvReported && d.this.nH) {
                            com.kwad.sdk.core.adlog.c.a(d.this.mAdTemplate, d.this.getTimerHelper().Pp(), (JSONObject) null);
                            d.this.nH = false;
                            b.eG().a(d.this.ny);
                        }
                    } catch (Throwable th2) {
                        ServiceProvider.reportSdkCaughtException(th2);
                    }
                }

                @Override // com.kwad.components.core.widget.a.InterfaceC0457a
                public final void c(View view) {
                    if (!d.this.mAdTemplate.mPvReported) {
                        d.this.nN.eL();
                        d.this.eJ();
                        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                        bVar.v(viewGroup.getHeight(), viewGroup.getWidth());
                        if (com.kwad.sdk.core.response.b.a.cS(d.this.mAdInfo)) {
                            a.C0484a c0484a = new a.C0484a();
                            c0484a.showLiveStyle = d.this.nJ;
                            c0484a.showLiveStatus = d.this.nI;
                            bVar.b(c0484a);
                        }
                        com.kwad.components.core.s.b.sc().a(d.this.mAdTemplate, null, bVar);
                    }
                    if (!d.this.nH) {
                        d.this.k(view);
                        d.this.getTimerHelper().startTiming();
                        d.this.bz.h(d.this);
                    }
                    d.this.nH = true;
                }

                @Override // com.kwad.components.core.widget.a.InterfaceC0457a
                public final void onWindowFocusChanged(boolean z10) {
                }
            });
            aVar.up();
            return;
        }
        com.kwad.components.core.widget.c b10 = b(viewGroup2);
        if (b10 == null) {
            b10 = new com.kwad.components.core.widget.c(viewGroup2.getContext(), viewGroup2);
            viewGroup2.addView(b10);
        }
        b10.setViewCallback(new c.a() { // from class: com.kwad.components.ad.g.d.6
            final /* synthetic */ ViewGroup lO;

            public AnonymousClass6(ViewGroup viewGroup2) {
                viewGroup = viewGroup2;
            }

            @Override // com.kwad.components.core.widget.c.a
            public final void eK() {
                if (!d.this.mAdTemplate.mPvReported) {
                    d.this.nN.eL();
                }
                d.this.eJ();
                com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                bVar.v(viewGroup.getHeight(), viewGroup.getWidth());
                if (com.kwad.sdk.core.response.b.a.cS(d.this.mAdInfo)) {
                    a.C0484a c0484a = new a.C0484a();
                    c0484a.showLiveStyle = d.this.nJ;
                    c0484a.showLiveStatus = d.this.nI;
                    bVar.b(c0484a);
                }
                com.kwad.components.core.s.b.sc().a(d.this.mAdTemplate, null, bVar);
                com.kwad.sdk.commercial.d.c.bG(d.this.mAdTemplate);
            }
        });
        b10.setNeedCheckingShow(true);
    }

    @Override // com.kwad.components.core.internal.api.a
    public final void a(com.kwad.components.core.internal.api.b bVar) {
        this.bz.a(bVar);
    }

    private View a(Context context, @NonNull KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl) {
        com.kwad.components.core.n.a.a.a aVar = (com.kwad.components.core.n.a.a.a) com.kwad.sdk.components.d.f(com.kwad.components.core.n.a.a.a.class);
        if (aVar == null || !aVar.pz()) {
            return null;
        }
        if (this.nF == null) {
            e eVar = new e(context);
            this.nF = eVar;
            eVar.setInnerAdInteractionListener(this.nN);
            this.nF.setVideoPlayListener(this.nM);
            this.nF.a(context, this.mAdTemplate, this.mApkDownloadHelper, kSAdVideoPlayConfigImpl);
        }
        return this.nF;
    }
}
