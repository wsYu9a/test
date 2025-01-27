package com.kwad.components.ad.e;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.kuaishou.pushad.KsAdGlobalWatcher;
import com.kwad.components.ad.e.b;
import com.kwad.components.core.d.b.a;
import com.kwad.components.core.d.b.c;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.widget.a;
import com.kwad.components.core.widget.c;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.api.KsImage;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.core.AbstractKsNativeAd;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.report.i;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.NativeAdExtraDataImpl;
import com.kwad.sdk.j.k;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bi;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import com.martian.ads.ad.AdConfig;
import com.tencent.bugly.beta.tinker.TinkerReport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class d extends AbstractKsNativeAd implements DialogInterface.OnDismissListener, DialogInterface.OnShowListener, com.kwad.components.core.internal.api.a {
    private Vibrator eg;
    private AdInfo mAdInfo;

    @NonNull
    private AdTemplate mAdTemplate;

    @Nullable
    private com.kwad.components.core.d.b.c mApkDownloadHelper;
    private b.c mE;
    private boolean mI;

    @Nullable
    private KsNativeAd.AdInteractionListener mJ;
    private f mK;
    private e mL;

    @Nullable
    private KsNativeAd.VideoPlayListener mM;
    private bh mTimerHelper;
    private boolean mN = false;
    private com.kwad.components.core.internal.api.c cg = new com.kwad.components.core.internal.api.c();
    private int mO = 0;
    private int mP = 0;
    private KsNativeAd.VideoPlayListener mQ = new KsNativeAd.VideoPlayListener() { // from class: com.kwad.components.ad.e.d.8
        AnonymousClass8() {
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayComplete() {
            if (d.this.mM != null) {
                d.this.mM.onVideoPlayComplete();
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayError(int i2, int i3) {
            if (d.this.mM != null) {
                d.this.mM.onVideoPlayError(i2, i3);
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayPause() {
            if (d.this.mM != null) {
                try {
                    d.this.mM.onVideoPlayPause();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayReady() {
            if (d.this.mM != null) {
                try {
                    d.this.mM.onVideoPlayReady();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayResume() {
            if (d.this.mM != null) {
                try {
                    d.this.mM.onVideoPlayResume();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayStart() {
            if (d.this.mM != null) {
                d.this.mM.onVideoPlayStart();
            }
        }
    };
    private a mR = new a() { // from class: com.kwad.components.ad.e.d.9
        AnonymousClass9() {
        }

        @Override // com.kwad.components.ad.e.d.a
        public final void eO() {
            if (d.this.mJ != null) {
                d.this.mJ.onAdShow(d.this);
            }
        }

        @Override // com.kwad.components.ad.e.d.a
        public final boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
            if (d.this.mJ == null) {
                return false;
            }
            try {
                return d.this.mJ.handleDownloadDialog(onClickListener);
            } catch (Throwable th) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                return false;
            }
        }

        @Override // com.kwad.components.ad.e.d.a
        public final void l(View view) {
            if (d.this.mJ != null) {
                d.this.mJ.onAdClicked(new FrameLayout(k.dl(view.getContext())), d.this);
            }
        }

        @Override // com.kwad.components.ad.e.d.a
        public final void onDownloadTipsDialogDismiss() {
            if (d.this.mJ != null) {
                try {
                    d.this.mJ.onDownloadTipsDialogDismiss();
                } catch (Throwable unused) {
                }
            }
        }

        @Override // com.kwad.components.ad.e.d.a
        public final void onDownloadTipsDialogShow() {
            if (d.this.mJ != null) {
                try {
                    d.this.mJ.onDownloadTipsDialogShow();
                } catch (Throwable unused) {
                }
            }
        }
    };

    /* renamed from: com.kwad.components.ad.e.d$1 */
    final class AnonymousClass1 implements c.a {
        AnonymousClass1() {
        }

        @Override // com.kwad.components.core.d.b.c.a
        public final boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
            return d.this.mR.handleDownloadDialog(onClickListener);
        }
    }

    /* renamed from: com.kwad.components.ad.e.d$2 */
    final class AnonymousClass2 implements View.OnTouchListener {
        final /* synthetic */ ViewGroup kA;
        private int[] mT = new int[2];
        final /* synthetic */ ac.a mU;
        final /* synthetic */ View mV;
        final /* synthetic */ Activity mW;
        final /* synthetic */ int mX;
        final /* synthetic */ boolean mY;

        AnonymousClass2(ac.a aVar, ViewGroup viewGroup, View view, Activity activity, int i2, boolean z) {
            aVar = aVar;
            viewGroup = viewGroup;
            view = view;
            activity = activity;
            i2 = i2;
            z = z;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                aVar.u(viewGroup.getWidth(), viewGroup.getHeight());
                viewGroup.getLocationOnScreen(this.mT);
                aVar.f(Math.abs(motionEvent.getRawX() - this.mT[0]), Math.abs(motionEvent.getRawY() - this.mT[1]));
            } else if (action == 1) {
                aVar.g(Math.abs(motionEvent.getRawX() - this.mT[0]), Math.abs(motionEvent.getRawY() - this.mT[1]));
                if (d.this.b(aVar)) {
                    view.setPressed(false);
                    d.this.a(activity, view, aVar, i2, z, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND);
                }
            }
            return false;
        }
    }

    /* renamed from: com.kwad.components.ad.e.d$3 */
    final class AnonymousClass3 implements View.OnClickListener {
        final /* synthetic */ ac.a mU;
        final /* synthetic */ Activity mW;
        final /* synthetic */ int mX;
        final /* synthetic */ boolean mY;

        AnonymousClass3(Activity activity, ac.a aVar, int i2, boolean z) {
            activity = activity;
            aVar = aVar;
            i2 = i2;
            z = z;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            d.this.a(activity, view, aVar, i2, z, 0);
        }
    }

    /* renamed from: com.kwad.components.ad.e.d$4 */
    final class AnonymousClass4 implements a.b {
        final /* synthetic */ int eK;
        final /* synthetic */ View fe;
        final /* synthetic */ ac.a mU;

        AnonymousClass4(ac.a aVar, int i2, View view) {
            aVar = aVar;
            i3 = i2;
            view = view;
        }

        @Override // com.kwad.components.core.d.b.a.b
        public final void onAdClicked() {
            com.kwad.sdk.core.report.a.a(d.this.mAdTemplate, new i().c(aVar).bj(i3), (JSONObject) null);
            d.this.mR.l(view);
        }
    }

    /* renamed from: com.kwad.components.ad.e.d$5 */
    final class AnonymousClass5 implements a.InterfaceC0197a {
        final /* synthetic */ ViewGroup kA;

        AnonymousClass5(ViewGroup viewGroup) {
            viewGroup = viewGroup;
        }

        @Override // com.kwad.components.core.widget.a.InterfaceC0197a
        public final void eM() {
            if (d.this.mAdTemplate.mPvReported && d.this.mN) {
                com.kwad.sdk.core.report.a.a(d.this.mAdTemplate, d.this.getTimerHelper().EZ(), (JSONObject) null);
                d.this.mN = false;
                b.eI().a(d.this.mE);
            }
        }

        @Override // com.kwad.components.core.widget.a.InterfaceC0197a
        public final void k(View view) {
            if (!d.this.mAdTemplate.mPvReported) {
                d.this.mR.eO();
                d.this.eL();
                i iVar = new i();
                iVar.q(viewGroup.getHeight(), viewGroup.getWidth());
                if (com.kwad.sdk.core.response.a.a.cq(d.this.mAdInfo)) {
                    y.a aVar = new y.a();
                    aVar.showLiveStyle = d.this.mP;
                    aVar.showLiveStatus = d.this.mO;
                    iVar.a(aVar);
                }
                com.kwad.components.core.r.b.pK().a(d.this.mAdTemplate, null, iVar);
            }
            if (!d.this.mN) {
                d.this.j(view);
                d.this.getTimerHelper().startTiming();
                d.this.cg.a(d.this);
            }
            d.this.mN = true;
        }

        @Override // com.kwad.components.core.widget.a.InterfaceC0197a
        public final void onViewAttached() {
            KsAdGlobalWatcher.getInstance().watch(d.this);
        }

        @Override // com.kwad.components.core.widget.a.InterfaceC0197a
        public final void onViewDetached() {
            if (d.this.mAdTemplate.mPvReported && d.this.mN) {
                com.kwad.sdk.core.report.a.a(d.this.mAdTemplate, d.this.getTimerHelper().EZ(), (JSONObject) null);
                d.this.mN = false;
            }
            d.this.getTimerHelper().EZ();
            d.this.cg.b(d.this);
            b.eI().a(d.this.mE);
            KsAdGlobalWatcher.getInstance().unwatch(d.this);
        }
    }

    /* renamed from: com.kwad.components.ad.e.d$6 */
    final class AnonymousClass6 implements c.a {
        final /* synthetic */ ViewGroup kA;

        AnonymousClass6(ViewGroup viewGroup) {
            viewGroup = viewGroup;
        }

        @Override // com.kwad.components.core.widget.c.a
        public final void eN() {
            if (!d.this.mAdTemplate.mPvReported) {
                d.this.mR.eO();
            }
            d.this.eL();
            i iVar = new i();
            iVar.q(viewGroup.getHeight(), viewGroup.getWidth());
            if (com.kwad.sdk.core.response.a.a.cq(d.this.mAdInfo)) {
                y.a aVar = new y.a();
                aVar.showLiveStyle = d.this.mP;
                aVar.showLiveStatus = d.this.mO;
                iVar.a(aVar);
            }
            com.kwad.components.core.r.b.pK().a(d.this.mAdTemplate, null, iVar);
            KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_NATIVE, "adShowSuccess").report();
        }
    }

    /* renamed from: com.kwad.components.ad.e.d$7 */
    final class AnonymousClass7 implements b.c {
        final /* synthetic */ View mZ;

        /* renamed from: com.kwad.components.ad.e.d$7$1 */
        final class AnonymousClass1 implements a.b {
            final /* synthetic */ double fZ;

            AnonymousClass1(double d2) {
                d2 = d2;
            }

            @Override // com.kwad.components.core.d.b.a.b
            public final void onAdClicked() {
                com.kwad.sdk.core.report.a.a(d.this.mAdTemplate, new i().bj(TinkerReport.KEY_APPLIED_PACKAGE_CHECK_RES_META).i(d2), (JSONObject) null);
                d.this.mR.l(view);
            }
        }

        AnonymousClass7(View view) {
            view = view;
        }

        @Override // com.kwad.components.ad.e.b.c
        public final void f(double d2) {
            if (d.this.mAdInfo.status == 3 || d.this.mAdInfo.status == 2) {
                return;
            }
            com.kwad.components.core.d.b.a.a(new a.C0172a(k.wrapContextIfNeed(view.getContext())).I(d.this.mAdTemplate).b(d.this.mApkDownloadHelper).av(false).a(new a.b() { // from class: com.kwad.components.ad.e.d.7.1
                final /* synthetic */ double fZ;

                AnonymousClass1(double d22) {
                    d2 = d22;
                }

                @Override // com.kwad.components.core.d.b.a.b
                public final void onAdClicked() {
                    com.kwad.sdk.core.report.a.a(d.this.mAdTemplate, new i().bj(TinkerReport.KEY_APPLIED_PACKAGE_CHECK_RES_META).i(d2), (JSONObject) null);
                    d.this.mR.l(view);
                }
            }));
            bi.a(view.getContext(), d.this.F(view.getContext()));
        }
    }

    /* renamed from: com.kwad.components.ad.e.d$8 */
    final class AnonymousClass8 implements KsNativeAd.VideoPlayListener {
        AnonymousClass8() {
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayComplete() {
            if (d.this.mM != null) {
                d.this.mM.onVideoPlayComplete();
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayError(int i2, int i3) {
            if (d.this.mM != null) {
                d.this.mM.onVideoPlayError(i2, i3);
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayPause() {
            if (d.this.mM != null) {
                try {
                    d.this.mM.onVideoPlayPause();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayReady() {
            if (d.this.mM != null) {
                try {
                    d.this.mM.onVideoPlayReady();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayResume() {
            if (d.this.mM != null) {
                try {
                    d.this.mM.onVideoPlayResume();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        public final void onVideoPlayStart() {
            if (d.this.mM != null) {
                d.this.mM.onVideoPlayStart();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.e.d$9 */
    final class AnonymousClass9 implements a {
        AnonymousClass9() {
        }

        @Override // com.kwad.components.ad.e.d.a
        public final void eO() {
            if (d.this.mJ != null) {
                d.this.mJ.onAdShow(d.this);
            }
        }

        @Override // com.kwad.components.ad.e.d.a
        public final boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
            if (d.this.mJ == null) {
                return false;
            }
            try {
                return d.this.mJ.handleDownloadDialog(onClickListener);
            } catch (Throwable th) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                return false;
            }
        }

        @Override // com.kwad.components.ad.e.d.a
        public final void l(View view) {
            if (d.this.mJ != null) {
                d.this.mJ.onAdClicked(new FrameLayout(k.dl(view.getContext())), d.this);
            }
        }

        @Override // com.kwad.components.ad.e.d.a
        public final void onDownloadTipsDialogDismiss() {
            if (d.this.mJ != null) {
                try {
                    d.this.mJ.onDownloadTipsDialogDismiss();
                } catch (Throwable unused) {
                }
            }
        }

        @Override // com.kwad.components.ad.e.d.a
        public final void onDownloadTipsDialogShow() {
            if (d.this.mJ != null) {
                try {
                    d.this.mJ.onDownloadTipsDialogShow();
                } catch (Throwable unused) {
                }
            }
        }
    }

    public interface a {
        void eO();

        boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener);

        void l(View view);

        void onDownloadTipsDialogDismiss();

        void onDownloadTipsDialogShow();
    }

    public d(@NonNull AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        this.mAdInfo = cb;
        if (com.kwad.sdk.core.response.a.a.ax(cb)) {
            com.kwad.components.core.d.b.c cVar = new com.kwad.components.core.d.b.c(this.mAdTemplate);
            this.mApkDownloadHelper = cVar;
            cVar.setOnShowListener(this);
            this.mApkDownloadHelper.setOnDismissListener(this);
            this.mApkDownloadHelper.a(new c.a() { // from class: com.kwad.components.ad.e.d.1
                AnonymousClass1() {
                }

                @Override // com.kwad.components.core.d.b.c.a
                public final boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
                    return d.this.mR.handleDownloadDialog(onClickListener);
                }
            });
        }
        KSImageLoader.preloadImage(com.kwad.sdk.core.response.a.a.H(this.mAdInfo), this.mAdTemplate);
    }

    public Vibrator F(Context context) {
        if (this.eg == null) {
            this.eg = (Vibrator) context.getSystemService("vibrator");
        }
        return this.eg;
    }

    private View a(Context context, @NonNull KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl) {
        com.kwad.components.core.offline.api.kwai.a aVar = (com.kwad.components.core.offline.api.kwai.a) com.kwad.sdk.components.c.f(com.kwad.components.core.offline.api.kwai.a.class);
        if (aVar == null || !aVar.hasLiveCompoReady()) {
            return null;
        }
        if (this.mL == null) {
            e eVar = new e(context);
            this.mL = eVar;
            eVar.setInnerAdInteractionListener(this.mR);
            this.mL.setVideoPlayListener(this.mQ);
            this.mL.a(context, this.mAdTemplate, this.mApkDownloadHelper, kSAdVideoPlayConfigImpl);
        }
        return this.mL;
    }

    public void a(@Nullable Activity activity, View view, ac.a aVar, int i2, boolean z, int i3) {
        IAdLivePlayModule iAdLivePlayModule;
        Context context = activity;
        if (activity == null) {
            context = view.getContext();
        }
        a.C0172a ao = new a.C0172a(k.wrapContextIfNeed(context)).I(this.mAdTemplate).b(this.mApkDownloadHelper).aq(i2).ao(true);
        e eVar = this.mL;
        com.kwad.components.core.d.b.a.a(ao.q((eVar == null || (iAdLivePlayModule = eVar.eV) == null) ? 0L : iAdLivePlayModule.getPlayDuration()).av(z).a(new a.b() { // from class: com.kwad.components.ad.e.d.4
            final /* synthetic */ int eK;
            final /* synthetic */ View fe;
            final /* synthetic */ ac.a mU;

            AnonymousClass4(ac.a aVar2, int i32, View view2) {
                aVar = aVar2;
                i3 = i32;
                view = view2;
            }

            @Override // com.kwad.components.core.d.b.a.b
            public final void onAdClicked() {
                com.kwad.sdk.core.report.a.a(d.this.mAdTemplate, new i().c(aVar).bj(i3), (JSONObject) null);
                d.this.mR.l(view);
            }
        }));
    }

    private void a(Activity activity, @NonNull ViewGroup viewGroup, int i2, View view, boolean z) {
        ac.a aVar = new ac.a();
        if (view == null) {
            return;
        }
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.components.ad.e.d.2
            final /* synthetic */ ViewGroup kA;
            private int[] mT = new int[2];
            final /* synthetic */ ac.a mU;
            final /* synthetic */ View mV;
            final /* synthetic */ Activity mW;
            final /* synthetic */ int mX;
            final /* synthetic */ boolean mY;

            AnonymousClass2(ac.a aVar2, ViewGroup viewGroup2, View view2, Activity activity2, int i22, boolean z2) {
                aVar = aVar2;
                viewGroup = viewGroup2;
                view = view2;
                activity = activity2;
                i2 = i22;
                z = z2;
            }

            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    aVar.u(viewGroup.getWidth(), viewGroup.getHeight());
                    viewGroup.getLocationOnScreen(this.mT);
                    aVar.f(Math.abs(motionEvent.getRawX() - this.mT[0]), Math.abs(motionEvent.getRawY() - this.mT[1]));
                } else if (action == 1) {
                    aVar.g(Math.abs(motionEvent.getRawX() - this.mT[0]), Math.abs(motionEvent.getRawY() - this.mT[1]));
                    if (d.this.b(aVar)) {
                        view.setPressed(false);
                        d.this.a(activity, view2, aVar, i2, z, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_APK_TINKER_ID_NOT_FOUND);
                    }
                }
                return false;
            }
        });
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.e.d.3
            final /* synthetic */ ac.a mU;
            final /* synthetic */ Activity mW;
            final /* synthetic */ int mX;
            final /* synthetic */ boolean mY;

            AnonymousClass3(Activity activity2, ac.a aVar2, int i22, boolean z2) {
                activity = activity2;
                aVar = aVar2;
                i2 = i22;
                z = z2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                d.this.a(activity, view2, aVar, i2, z, 0);
            }
        });
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

    private void a(ViewGroup viewGroup) {
        if (!this.mI) {
            this.mI = true;
            KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_NATIVE, "callShow").report();
        }
        if (!com.kwad.sdk.core.config.d.uH() && com.kwad.sdk.core.config.d.uG() >= 0.0f) {
            c(viewGroup);
            com.kwad.components.core.widget.a aVar = new com.kwad.components.core.widget.a(viewGroup.getContext(), viewGroup);
            viewGroup.addView(aVar);
            aVar.setViewCallback(new a.InterfaceC0197a() { // from class: com.kwad.components.ad.e.d.5
                final /* synthetic */ ViewGroup kA;

                AnonymousClass5(ViewGroup viewGroup2) {
                    viewGroup = viewGroup2;
                }

                @Override // com.kwad.components.core.widget.a.InterfaceC0197a
                public final void eM() {
                    if (d.this.mAdTemplate.mPvReported && d.this.mN) {
                        com.kwad.sdk.core.report.a.a(d.this.mAdTemplate, d.this.getTimerHelper().EZ(), (JSONObject) null);
                        d.this.mN = false;
                        b.eI().a(d.this.mE);
                    }
                }

                @Override // com.kwad.components.core.widget.a.InterfaceC0197a
                public final void k(View view) {
                    if (!d.this.mAdTemplate.mPvReported) {
                        d.this.mR.eO();
                        d.this.eL();
                        i iVar = new i();
                        iVar.q(viewGroup.getHeight(), viewGroup.getWidth());
                        if (com.kwad.sdk.core.response.a.a.cq(d.this.mAdInfo)) {
                            y.a aVar2 = new y.a();
                            aVar2.showLiveStyle = d.this.mP;
                            aVar2.showLiveStatus = d.this.mO;
                            iVar.a(aVar2);
                        }
                        com.kwad.components.core.r.b.pK().a(d.this.mAdTemplate, null, iVar);
                    }
                    if (!d.this.mN) {
                        d.this.j(view);
                        d.this.getTimerHelper().startTiming();
                        d.this.cg.a(d.this);
                    }
                    d.this.mN = true;
                }

                @Override // com.kwad.components.core.widget.a.InterfaceC0197a
                public final void onViewAttached() {
                    KsAdGlobalWatcher.getInstance().watch(d.this);
                }

                @Override // com.kwad.components.core.widget.a.InterfaceC0197a
                public final void onViewDetached() {
                    if (d.this.mAdTemplate.mPvReported && d.this.mN) {
                        com.kwad.sdk.core.report.a.a(d.this.mAdTemplate, d.this.getTimerHelper().EZ(), (JSONObject) null);
                        d.this.mN = false;
                    }
                    d.this.getTimerHelper().EZ();
                    d.this.cg.b(d.this);
                    b.eI().a(d.this.mE);
                    KsAdGlobalWatcher.getInstance().unwatch(d.this);
                }
            });
            aVar.rt();
            return;
        }
        com.kwad.components.core.widget.c b2 = b(viewGroup2);
        if (b2 == null) {
            b2 = new com.kwad.components.core.widget.c(viewGroup2.getContext(), viewGroup2);
            viewGroup2.addView(b2);
        }
        b2.setViewCallback(new c.a() { // from class: com.kwad.components.ad.e.d.6
            final /* synthetic */ ViewGroup kA;

            AnonymousClass6(ViewGroup viewGroup2) {
                viewGroup = viewGroup2;
            }

            @Override // com.kwad.components.core.widget.c.a
            public final void eN() {
                if (!d.this.mAdTemplate.mPvReported) {
                    d.this.mR.eO();
                }
                d.this.eL();
                i iVar = new i();
                iVar.q(viewGroup.getHeight(), viewGroup.getWidth());
                if (com.kwad.sdk.core.response.a.a.cq(d.this.mAdInfo)) {
                    y.a aVar2 = new y.a();
                    aVar2.showLiveStyle = d.this.mP;
                    aVar2.showLiveStatus = d.this.mO;
                    iVar.a(aVar2);
                }
                com.kwad.components.core.r.b.pK().a(d.this.mAdTemplate, null, iVar);
                KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_NATIVE, "adShowSuccess").report();
            }
        });
        b2.setNeedCheckingShow(true);
    }

    private View b(Context context, @NonNull KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl) {
        if (TextUtils.isEmpty(getVideoUrl())) {
            com.kwad.sdk.core.d.b.w("KsNativeAdControl", "videoUrl is empty");
            return null;
        }
        if (this.mK == null) {
            f fVar = new f(context);
            this.mK = fVar;
            fVar.setInnerAdInteractionListener(this.mR);
            this.mK.setVideoPlayListener(this.mQ);
            this.mK.a(this.mAdTemplate, this.mApkDownloadHelper, kSAdVideoPlayConfigImpl);
        }
        return this.mK;
    }

    private static com.kwad.components.core.widget.c b(ViewGroup viewGroup) {
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt instanceof com.kwad.components.core.widget.c) {
                return (com.kwad.components.core.widget.c) childAt;
            }
        }
        return null;
    }

    public boolean b(ac.a aVar) {
        return ((Math.abs(aVar.DH() - aVar.DJ()) > 20) || (Math.abs(aVar.DI() - aVar.DK()) > 20)) && com.kwad.sdk.core.response.a.c.bQ(this.mAdTemplate);
    }

    private static void c(ViewGroup viewGroup) {
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt instanceof com.kwad.components.core.widget.a) {
                viewGroup.removeView(childAt);
            }
        }
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    /* renamed from: eK */
    public com.kwad.components.core.internal.api.d getVideoCoverImage() {
        AdInfo.AdMaterialInfo.MaterialFeature aN = com.kwad.sdk.core.response.a.a.aN(this.mAdInfo);
        if (TextUtils.isEmpty(aN.coverUrl)) {
            return null;
        }
        return new com.kwad.components.core.internal.api.d(aN.width, aN.height, aN.coverUrl);
    }

    public void eL() {
        try {
            NativeAdExtraDataImpl nativeAdExtraDataImpl = this.mAdTemplate.mAdScene.nativeAdExtraData;
            this.mO = nativeAdExtraDataImpl.showLiveStatus;
            this.mP = nativeAdExtraDataImpl.showLiveStyle;
        } catch (Throwable unused) {
        }
    }

    public void j(View view) {
        if (com.kwad.sdk.core.response.a.a.Z(this.mAdInfo)) {
            float aa = com.kwad.sdk.core.response.a.a.aa(this.mAdInfo);
            this.mE = new b.c() { // from class: com.kwad.components.ad.e.d.7
                final /* synthetic */ View mZ;

                /* renamed from: com.kwad.components.ad.e.d$7$1 */
                final class AnonymousClass1 implements a.b {
                    final /* synthetic */ double fZ;

                    AnonymousClass1(double d22) {
                        d2 = d22;
                    }

                    @Override // com.kwad.components.core.d.b.a.b
                    public final void onAdClicked() {
                        com.kwad.sdk.core.report.a.a(d.this.mAdTemplate, new i().bj(TinkerReport.KEY_APPLIED_PACKAGE_CHECK_RES_META).i(d2), (JSONObject) null);
                        d.this.mR.l(view);
                    }
                }

                AnonymousClass7(View view2) {
                    view = view2;
                }

                @Override // com.kwad.components.ad.e.b.c
                public final void f(double d22) {
                    if (d.this.mAdInfo.status == 3 || d.this.mAdInfo.status == 2) {
                        return;
                    }
                    com.kwad.components.core.d.b.a.a(new a.C0172a(k.wrapContextIfNeed(view.getContext())).I(d.this.mAdTemplate).b(d.this.mApkDownloadHelper).av(false).a(new a.b() { // from class: com.kwad.components.ad.e.d.7.1
                        final /* synthetic */ double fZ;

                        AnonymousClass1(double d222) {
                            d2 = d222;
                        }

                        @Override // com.kwad.components.core.d.b.a.b
                        public final void onAdClicked() {
                            com.kwad.sdk.core.report.a.a(d.this.mAdTemplate, new i().bj(TinkerReport.KEY_APPLIED_PACKAGE_CHECK_RES_META).i(d2), (JSONObject) null);
                            d.this.mR.l(view);
                        }
                    }));
                    bi.a(view.getContext(), d.this.F(view.getContext()));
                }
            };
            b.eI().a(aa, view2, this.mE);
        }
    }

    @Override // com.kwad.components.core.internal.api.a
    public final void a(com.kwad.components.core.internal.api.b bVar) {
        this.cg.a(bVar);
    }

    @Override // com.kwad.components.core.internal.api.a
    public final boolean ao() {
        return true;
    }

    @Override // com.kwad.components.core.internal.api.a
    public final void b(com.kwad.components.core.internal.api.b bVar) {
        this.cg.b(bVar);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getActionDescription() {
        return com.kwad.sdk.core.response.a.a.aw(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getAdDescription() {
        return com.kwad.sdk.core.response.a.a.an(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getAdSource() {
        return com.kwad.sdk.core.response.a.a.av(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getAdSourceLogoUrl(int i2) {
        AdInfo adInfo = this.mAdInfo;
        if (adInfo == null) {
            return null;
        }
        return i2 != 1 ? adInfo.adBaseInfo.adMarkIcon : adInfo.adBaseInfo.adGrayMarkIcon;
    }

    @Override // com.kwad.components.core.internal.api.a
    @NonNull
    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getAppDownloadCountDes() {
        return com.kwad.sdk.core.response.a.a.ar(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getAppIconUrl() {
        return com.kwad.sdk.core.response.a.a.bM(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final String getAppName() {
        return com.kwad.sdk.core.response.a.a.ao(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getAppPackageName() {
        return com.kwad.sdk.core.response.a.a.aq(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final long getAppPackageSize() {
        return com.kwad.sdk.core.response.a.a.bu(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getAppPrivacyUrl() {
        return com.kwad.sdk.core.response.a.a.bs(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final float getAppScore() {
        return com.kwad.sdk.core.response.a.a.as(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getAppVersion() {
        return com.kwad.sdk.core.response.a.a.bt(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getCorporationName() {
        return com.kwad.sdk.core.response.a.a.bp(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final int getECPM() {
        return com.kwad.sdk.core.response.a.a.aJ(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final List<KsImage> getImageList() {
        ArrayList arrayList = new ArrayList();
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate);
        int aW = com.kwad.sdk.core.response.a.a.aW(this.mAdInfo);
        if (aW == 2 || aW == 3) {
            for (AdInfo.AdMaterialInfo.MaterialFeature materialFeature : cb.adMaterialInfo.materialFeatureList) {
                if (materialFeature.featureType == 2 && !TextUtils.isEmpty(materialFeature.materialUrl)) {
                    arrayList.add(new com.kwad.components.core.internal.api.d(materialFeature.width, materialFeature.height, materialFeature.materialUrl));
                }
            }
        }
        return arrayList;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final int getInteractionType() {
        return com.kwad.sdk.core.response.a.a.aI(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final int getMaterialType() {
        return com.kwad.sdk.core.response.a.a.aW(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.BaseKSAd
    public final Map<String, Object> getMediaExtraInfo() {
        HashMap hashMap = new HashMap();
        if (com.kwad.sdk.core.config.d.ur()) {
            hashMap.put("llsid", Long.valueOf(this.mAdTemplate.llsid));
        }
        return hashMap;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getPermissionInfo() {
        return com.kwad.sdk.core.response.a.a.bq(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    @Nullable
    public final String getPermissionInfoUrl() {
        return com.kwad.sdk.core.response.a.a.br(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final String getProductName() {
        return com.kwad.sdk.core.response.a.a.ap(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.core.AbstractKsNativeAd
    public final Bitmap getSdkLogo() {
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null) {
            return null;
        }
        return BitmapFactory.decodeResource(context.getResources(), R.drawable.ksad_sdk_logo);
    }

    public final bh getTimerHelper() {
        if (this.mTimerHelper == null) {
            this.mTimerHelper = new bh();
        }
        return this.mTimerHelper;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final int getVideoDuration() {
        return com.kwad.sdk.core.response.a.a.F(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final int getVideoHeight() {
        return com.kwad.sdk.core.response.a.a.cq(this.mAdInfo) ? TTAdConstant.EXT_PLUGIN_UNINSTALL : com.kwad.sdk.core.response.a.a.aN(this.mAdInfo).videoHeight;
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final String getVideoUrl() {
        return com.kwad.sdk.core.response.a.a.E(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.core.AbstractKsNativeAd
    @Nullable
    public final View getVideoView2(Context context, @Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        View view = null;
        if (context == null || !KsAdSDKImpl.get().hasInitFinish()) {
            return null;
        }
        try {
            context = k.wrapContextIfNeed(context);
            com.kwad.sdk.g.a.U(AdConfig.AdType.NATIVE, "show");
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl ? (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig : new KSAdVideoPlayConfigImpl();
            view = com.kwad.sdk.core.response.a.a.cq(this.mAdInfo) ? a(context, kSAdVideoPlayConfigImpl) : b(context, kSAdVideoPlayConfigImpl);
            com.kwad.sdk.g.a.V(AdConfig.AdType.NATIVE, "show");
            return view;
        } catch (Throwable th) {
            RuntimeException runtimeException = new RuntimeException("getVideoView fail--context:" + context.getClass().getName() + "--classloader:" + context.getClassLoader().getClass().getName());
            if (!KsAdSDKImpl.get().getIsExternal()) {
                throw th;
            }
            int i2 = Build.VERSION.SDK_INT;
            com.kwad.components.core.c.a.b(runtimeException);
            return view;
        }
    }

    @Override // com.kwad.sdk.api.core.AbstractKsNativeAd
    public final View getVideoView2(Context context, boolean z) {
        if (context == null || !KsAdSDKImpl.get().hasInitFinish()) {
            return null;
        }
        return getVideoView(context, new KsAdVideoPlayConfig.Builder().videoSoundEnable(z).build());
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final int getVideoWidth() {
        if (com.kwad.sdk.core.response.a.a.cq(this.mAdInfo)) {
            return 720;
        }
        return com.kwad.sdk.core.response.a.a.aN(this.mAdInfo).videoWidth;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        this.mR.onDownloadTipsDialogDismiss();
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface dialogInterface) {
        a aVar = this.mR;
        if (aVar != null) {
            aVar.onDownloadTipsDialogShow();
        }
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void registerViewForInteraction(Activity activity, @NonNull ViewGroup viewGroup, @NonNull List<View> list, KsNativeAd.AdInteractionListener adInteractionListener) {
        this.mJ = adInteractionListener;
        a(viewGroup);
        a(activity, viewGroup, list);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void registerViewForInteraction(Activity activity, @NonNull ViewGroup viewGroup, @NonNull Map<View, Integer> map, KsNativeAd.AdInteractionListener adInteractionListener) {
        this.mJ = adInteractionListener;
        a(viewGroup);
        a(activity, viewGroup, map);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void registerViewForInteraction(@NonNull ViewGroup viewGroup, @NonNull List<View> list, KsNativeAd.AdInteractionListener adInteractionListener) {
        registerViewForInteraction((Activity) null, viewGroup, list, adInteractionListener);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void reportAdExposureFailed(int i2, AdExposureFailedReason adExposureFailedReason) {
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, i2, adExposureFailedReason);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void reportAdVideoPlayEnd() {
        com.kwad.sdk.core.report.a.av(getAdTemplate());
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void reportAdVideoPlayStart() {
        com.kwad.sdk.core.report.a.h(getAdTemplate());
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void setBidEcpm(int i2) {
        setBidEcpm(i2, -1L);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void setBidEcpm(long j2, long j3) {
        AdTemplate adTemplate = this.mAdTemplate;
        adTemplate.mBidEcpm = j2;
        com.kwad.sdk.core.report.a.i(adTemplate, j3);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void setDownloadListener(KsAppDownloadListener ksAppDownloadListener) {
        com.kwad.components.core.d.b.c cVar = this.mApkDownloadHelper;
        if (cVar == null || ksAppDownloadListener == null) {
            return;
        }
        cVar.b(ksAppDownloadListener);
    }

    @Override // com.kwad.sdk.api.KsNativeAd
    public final void setVideoPlayListener(KsNativeAd.VideoPlayListener videoPlayListener) {
        this.mM = videoPlayListener;
    }
}
