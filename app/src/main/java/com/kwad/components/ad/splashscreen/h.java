package com.kwad.components.ad.splashscreen;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.splashscreen.monitor.SplashMonitorInfo;
import com.kwad.components.core.e.d.a;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bs;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class h extends com.kwad.sdk.mvp.a {
    private KsSplashScreenAd.SplashScreenAdInteractionListener DH;

    @Nullable
    public com.kwad.components.ad.splashscreen.d.a DT;
    public StyleTemplate DU;
    public com.kwad.sdk.core.h.a DV;
    public int Ed;
    public int Ee;
    public long Ef;
    public long Eg;
    public long Eh;
    public long Ei;
    public long Ej;
    public long Ek;
    public long El;
    public AdResultData mAdResultData;

    @NonNull
    public SceneImpl mAdScene;
    public com.kwad.components.core.e.d.c mApkDownloadHelper;

    @NonNull
    public AdBaseFrameLayout mRootContainer;
    public bs mTimerHelper;

    @NonNull
    public KsVideoPlayConfig mVideoPlayConfig;
    private List<g> DW = new CopyOnWriteArrayList();
    private List<f> DX = new CopyOnWriteArrayList();
    public boolean DY = false;
    private boolean DZ = false;
    public boolean Ea = false;
    public boolean Eb = false;
    public boolean bM = false;
    public long Ec = SystemClock.elapsedRealtime();
    public boolean isWebTimeout = false;

    /* renamed from: com.kwad.components.ad.splashscreen.h$1 */
    public class AnonymousClass1 implements a.b {
        final /* synthetic */ int Em;
        final /* synthetic */ a En;
        final /* synthetic */ int cO;

        public AnonymousClass1(int i10, int i11, a aVar) {
            i11 = i10;
            i10 = i11;
            aVar = aVar;
        }

        @Override // com.kwad.components.core.e.d.a.b
        public final void onAdClicked() {
            com.kwad.components.ad.splashscreen.monitor.a.lk().ab(h.this.mAdTemplate);
            if (h.this.DH != null) {
                h.this.DH.onAdClicked();
            }
            com.kwad.components.ad.splashscreen.monitor.a.lk().Z(h.this.mAdTemplate);
            JSONObject jSONObject = new JSONObject();
            try {
                com.kwad.components.ad.splashscreen.d.a aVar = h.this.DT;
                if (aVar != null) {
                    jSONObject.put("duration", aVar.getCurrentPosition());
                }
            } catch (JSONException e10) {
                com.kwad.sdk.core.d.c.printStackTrace(e10);
            }
            com.kwad.sdk.core.adlog.c.b f10 = new com.kwad.sdk.core.adlog.c.b().cL(i11).f(h.this.mRootContainer.getTouchCoords());
            if (i10 == 2) {
                f10.cU(6);
            }
            com.kwad.sdk.core.adlog.c.a(h.this.mAdTemplate, f10, jSONObject);
            a aVar2 = aVar;
            if (aVar2 != null) {
                aVar2.b(f10);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.splashscreen.h$2 */
    public class AnonymousClass2 extends bd {
        public AnonymousClass2() {
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            if (com.kwad.components.core.e.c.b.of()) {
                h.this.mRootContainer.postDelayed(this, 1000L);
            } else {
                h.this.le();
            }
        }
    }

    public interface a {
        void b(@NonNull com.kwad.sdk.core.adlog.c.b bVar);
    }

    public static boolean X(AdTemplate adTemplate) {
        AdMatrixInfo.SplashPlayCardTKInfo dm;
        return com.kwad.sdk.core.config.d.Du() && (dm = com.kwad.sdk.core.response.b.b.dm(adTemplate)) != null && !TextUtils.isEmpty(dm.templateId) && dm.renderType == 1;
    }

    private void lg() {
        lh();
        Iterator<g> it = this.DW.iterator();
        while (it.hasNext()) {
            it.next().kS();
        }
    }

    private void lh() {
        AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(this.mAdTemplate);
        SplashMonitorInfo elementTypes = new SplashMonitorInfo().setStatus(8).setElementTypes(com.kwad.components.core.webview.tachikoma.d.a.uf().ug());
        bs bsVar = this.mTimerHelper;
        com.kwad.sdk.commercial.b.l(elementTypes.setShowEndTime(bsVar != null ? bsVar.getTime() : -1L).setRotateComposeTimeout(this.bM).setTkDefaultTimeout(X(this.mAdTemplate) ? com.kwad.sdk.core.response.b.b.dn(this.mAdTemplate) : com.kwad.sdk.core.response.b.b.dC(com.kwad.sdk.core.response.b.e.eb(this.mAdTemplate))).setSoSource(this.Ed).setSoLoadTime(this.Ef).setOfflineSource(this.Ee).setOfflineLoadTime(this.Eg).setTkFileLoadTime(this.Eh).setTkInitTime(this.Ei).setTkRenderTime(this.Ej).setNativeLoadTime(this.Ek).setWebTimeout(this.isWebTimeout).setWebLoadTime(this.El).setInteractiveStyle(com.kwad.sdk.core.response.b.b.dM(eb2)).setInteractivityDefaultStyle(com.kwad.sdk.core.response.b.b.dN(eb2)).setCreativeId(com.kwad.sdk.core.response.b.a.J(eb2)).setAdTemplate(this.mAdTemplate));
        com.kwad.components.core.webview.tachikoma.d.a.uf().uh();
    }

    private void li() {
        Iterator<f> it = this.DX.iterator();
        while (it.hasNext()) {
            it.next().kO();
        }
    }

    public static boolean n(@NonNull AdInfo adInfo) {
        return adInfo.adSplashInfo.fullScreenClickSwitch == 1;
    }

    public static boolean r(AdInfo adInfo) {
        return com.kwad.sdk.core.response.b.b.dv(adInfo) && com.kwad.sdk.core.response.b.a.bd(adInfo);
    }

    public final void S(Context context) {
        if (this.mAdTemplate.mPvReported) {
            return;
        }
        com.kwad.components.ad.splashscreen.local.a.T(context);
        com.kwad.components.core.s.b.sc().a(this.mAdTemplate, null, null);
        com.kwad.sdk.commercial.d.c.bG(this.mAdTemplate);
        kT();
    }

    @MainThread
    public final void W() {
        this.mAdTemplate.converted = true;
        com.kwad.components.ad.splashscreen.monitor.a.lk().ab(this.mAdTemplate);
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.DH;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdClicked();
        }
        com.kwad.components.ad.splashscreen.monitor.a.lk().Z(this.mAdTemplate);
    }

    public final void Y(int i10) {
        Iterator<g> it = this.DW.iterator();
        while (it.hasNext()) {
            it.next().X(i10);
        }
    }

    public final void a(AdResultData adResultData) {
        this.mAdResultData = adResultData;
        this.mAdTemplate = com.kwad.sdk.core.response.b.c.o(adResultData);
    }

    public final void c(int i10, Context context, int i11, int i12) {
        a(i10, context, i11, i12, null);
    }

    @MainThread
    public final void kT() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.DH;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdShowStart();
        }
        if (this.DZ) {
            return;
        }
        this.DZ = true;
        com.kwad.components.ad.splashscreen.monitor.b.lm();
        com.kwad.components.ad.splashscreen.monitor.b.f(this.mAdTemplate, SystemClock.elapsedRealtime() - this.mAdTemplate.showStartTime);
        com.kwad.components.ad.splashscreen.monitor.c.aj(this.mAdTemplate);
        com.kwad.components.ad.splashscreen.monitor.a.lk().q(this.mAdTemplate);
        com.kwad.sdk.a.a.c.Bg().bk(true);
        bs bsVar = this.mTimerHelper;
        if (bsVar != null) {
            bsVar.startTiming();
        }
    }

    @MainThread
    public final void kU() {
        com.kwad.components.ad.splashscreen.monitor.a.lk().ac(this.mAdTemplate);
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.DH;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdShowEnd();
        }
        com.kwad.components.ad.splashscreen.monitor.a.lk().r(this.mAdTemplate);
    }

    public final void kV() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.DH;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdShowError(0, "onMediaPlayError");
        }
    }

    public final void kW() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.DH;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdShowStart();
        }
    }

    public final void kX() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.DH;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdShowEnd();
        }
    }

    public final void kY() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.DH;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onSkippedAd();
        }
    }

    public final void kZ() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.DH;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdClicked();
        }
    }

    public final void la() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.DH;
        if (splashScreenAdInteractionListener != null) {
            try {
                splashScreenAdInteractionListener.onDownloadTipsDialogShow();
            } catch (Throwable th2) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
            }
        }
    }

    public final void lb() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.DH;
        if (splashScreenAdInteractionListener != null) {
            try {
                splashScreenAdInteractionListener.onDownloadTipsDialogCancel();
            } catch (Throwable th2) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
            }
        }
    }

    public final void lc() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.DH;
        if (splashScreenAdInteractionListener != null) {
            try {
                splashScreenAdInteractionListener.onDownloadTipsDialogDismiss();
            } catch (Throwable th2) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
            }
        }
    }

    @MainThread
    public final void ld() {
        if (this.DY) {
            return;
        }
        this.DY = true;
        if (!r(com.kwad.sdk.core.response.b.e.eb(this.mAdTemplate)) || this.mAdTemplate.converted) {
            a.C0484a c0484a = new a.C0484a();
            bs bsVar = this.mTimerHelper;
            if (bsVar != null) {
                c0484a.duration = bsVar.getTime();
            }
            com.kwad.sdk.core.adlog.c.b(this.mAdTemplate, new com.kwad.sdk.core.adlog.c.b().cM(14).cU(22).b(c0484a), (JSONObject) null);
            com.kwad.components.ad.splashscreen.monitor.a.lk().ac(this.mAdTemplate);
            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.DH;
            if (splashScreenAdInteractionListener != null) {
                splashScreenAdInteractionListener.onAdShowEnd();
            }
            com.kwad.components.ad.splashscreen.monitor.a.lk().r(this.mAdTemplate);
        } else {
            li();
        }
        lg();
    }

    @MainThread
    public final void le() {
        com.kwad.components.ad.splashscreen.monitor.a.lk().ac(this.mAdTemplate);
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.DH;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdShowEnd();
        }
        com.kwad.components.ad.splashscreen.monitor.a.lk().r(this.mAdTemplate);
    }

    @MainThread
    public final void lf() {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.DH;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onSkippedAd();
        }
        com.kwad.components.ad.splashscreen.monitor.a.lk().r(this.mAdTemplate);
        lg();
    }

    public final void lj() {
        this.mRootContainer.post(new bd() { // from class: com.kwad.components.ad.splashscreen.h.2
            public AnonymousClass2() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                if (com.kwad.components.core.e.c.b.of()) {
                    h.this.mRootContainer.postDelayed(this, 1000L);
                } else {
                    h.this.le();
                }
            }
        });
    }

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
        com.kwad.components.ad.splashscreen.d.a aVar = this.DT;
        if (aVar != null) {
            aVar.release();
        }
        com.kwad.sdk.core.h.a aVar2 = this.DV;
        if (aVar2 != null) {
            aVar2.release();
        }
    }

    public final void setSplashScreenAdListener(KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        this.DH = splashScreenAdInteractionListener;
    }

    public final void b(g gVar) {
        this.DW.remove(gVar);
    }

    @MainThread
    public final void c(int i10, String str) {
        KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.DH;
        if (splashScreenAdInteractionListener != null) {
            splashScreenAdInteractionListener.onAdShowError(i10, str);
        }
        com.kwad.components.ad.splashscreen.monitor.b.lm();
        com.kwad.components.ad.splashscreen.monitor.b.e(this.mAdTemplate, i10, String.valueOf(str));
        lg();
    }

    public final void a(int i10, Context context, int i11, int i12, a aVar) {
        com.kwad.sdk.core.response.b.e.eb(this.mAdTemplate);
        com.kwad.components.core.e.d.a.a(new a.C0427a(context).au(this.mAdTemplate).b(this.mApkDownloadHelper).ao(i12).ap(i12 == 1).an(i11).am(i10).a(new a.b() { // from class: com.kwad.components.ad.splashscreen.h.1
            final /* synthetic */ int Em;
            final /* synthetic */ a En;
            final /* synthetic */ int cO;

            public AnonymousClass1(int i112, int i102, a aVar2) {
                i11 = i112;
                i10 = i102;
                aVar = aVar2;
            }

            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                com.kwad.components.ad.splashscreen.monitor.a.lk().ab(h.this.mAdTemplate);
                if (h.this.DH != null) {
                    h.this.DH.onAdClicked();
                }
                com.kwad.components.ad.splashscreen.monitor.a.lk().Z(h.this.mAdTemplate);
                JSONObject jSONObject = new JSONObject();
                try {
                    com.kwad.components.ad.splashscreen.d.a aVar2 = h.this.DT;
                    if (aVar2 != null) {
                        jSONObject.put("duration", aVar2.getCurrentPosition());
                    }
                } catch (JSONException e10) {
                    com.kwad.sdk.core.d.c.printStackTrace(e10);
                }
                com.kwad.sdk.core.adlog.c.b f10 = new com.kwad.sdk.core.adlog.c.b().cL(i11).f(h.this.mRootContainer.getTouchCoords());
                if (i10 == 2) {
                    f10.cU(6);
                }
                com.kwad.sdk.core.adlog.c.a(h.this.mAdTemplate, f10, jSONObject);
                a aVar22 = aVar;
                if (aVar22 != null) {
                    aVar22.b(f10);
                }
            }
        }));
    }

    public final void b(f fVar) {
        if (fVar == null) {
            return;
        }
        this.DX.remove(fVar);
    }

    public final void a(g gVar) {
        this.DW.add(gVar);
    }

    public final void a(f fVar) {
        if (fVar == null) {
            return;
        }
        this.DX.add(fVar);
    }
}
