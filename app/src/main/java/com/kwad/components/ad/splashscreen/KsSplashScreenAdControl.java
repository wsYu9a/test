package com.kwad.components.ad.splashscreen;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.core.AbstrackKsSplashScreenAd;
import com.kwad.sdk.api.core.KsAdSdkDynamicApi;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.api.model.KSAdInfoData;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.l;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class KsSplashScreenAdControl extends AbstrackKsSplashScreenAd implements com.kwad.components.core.internal.api.a {
    private KsScene DF;
    private com.kwad.components.core.internal.api.c bz = new com.kwad.components.core.internal.api.c();

    /* renamed from: dk */
    private com.kwad.sdk.core.h.b f11897dk = new com.kwad.sdk.core.h.b() { // from class: com.kwad.components.ad.splashscreen.KsSplashScreenAdControl.1
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.core.h.b
        public final void aH() {
            KsSplashScreenAdControl.this.bz.h(KsSplashScreenAdControl.this);
        }

        @Override // com.kwad.sdk.core.h.b
        public final void aI() {
            KsSplashScreenAdControl.this.bz.i(KsSplashScreenAdControl.this);
        }
    };

    @NonNull
    private final AdResultData mAdResultData;

    @NonNull
    private final AdTemplate mAdTemplate;

    /* renamed from: com.kwad.components.ad.splashscreen.KsSplashScreenAdControl$1 */
    public class AnonymousClass1 extends com.kwad.sdk.core.h.b {
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.core.h.b
        public final void aH() {
            KsSplashScreenAdControl.this.bz.h(KsSplashScreenAdControl.this);
        }

        @Override // com.kwad.sdk.core.h.b
        public final void aI() {
            KsSplashScreenAdControl.this.bz.i(KsSplashScreenAdControl.this);
        }
    }

    public KsSplashScreenAdControl(@NonNull KsScene ksScene, @NonNull AdResultData adResultData) {
        this.mAdResultData = adResultData;
        this.DF = ksScene;
        this.mAdTemplate = adResultData.getAdTemplateList().get(0);
        com.kwad.components.ad.j.b.fc().a(this);
    }

    @Override // com.kwad.components.core.internal.api.a
    public final void b(com.kwad.components.core.internal.api.b bVar) {
        this.bz.b(bVar);
    }

    @Override // com.kwad.components.core.internal.api.a
    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public int getECPM() {
        return com.kwad.sdk.core.response.b.a.aR(com.kwad.sdk.core.response.b.e.eb(this.mAdTemplate));
    }

    @NonNull
    @KsAdSdkDynamicApi
    @Keep
    public KsFragment getFragment2(KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        com.kwad.sdk.commercial.d.c.bF(this.mAdTemplate);
        com.kwad.components.ad.splashscreen.a.a aVar = (com.kwad.components.ad.splashscreen.a.a) com.kwad.sdk.components.d.f(com.kwad.components.ad.splashscreen.a.a.class);
        if (aVar != null) {
            return aVar.a(this.mAdResultData, this.f11897dk, splashScreenAdInteractionListener);
        }
        return null;
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public int getInteractionType() {
        return com.kwad.sdk.core.response.b.a.aQ(com.kwad.sdk.core.response.b.e.eb(this.mAdTemplate));
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public KSAdInfoData getKSAdInfoData() {
        if (com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.awK)) {
            return com.kwad.sdk.core.response.b.a.dk(com.kwad.sdk.core.response.b.e.eb(this.mAdTemplate));
        }
        return null;
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public int getMaterialType() {
        return com.kwad.sdk.core.response.b.a.be(com.kwad.sdk.core.response.b.e.eb(this.mAdTemplate));
    }

    @Override // com.kwad.sdk.api.BaseKSAd
    public Map<String, Object> getMediaExtraInfo() {
        HashMap hashMap = new HashMap();
        if (com.kwad.sdk.core.config.d.Dx()) {
            hashMap.put("llsid", Long.valueOf(this.mAdTemplate.llsid));
        }
        return hashMap;
    }

    @Override // com.kwad.sdk.api.core.AbstrackKsSplashScreenAd
    @Nullable
    public View getView2(Context context, KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        if (context == null || !l.At().zE()) {
            return null;
        }
        com.kwad.sdk.commercial.d.c.bF(this.mAdTemplate);
        return c.a(context, this.mAdResultData, true, this.f11897dk, splashScreenAdInteractionListener);
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public boolean isAdEnable() {
        if (SplashPreloadManager.kQ().f(this.mAdResultData)) {
            return true;
        }
        SplashPreloadManager.kQ();
        return SplashPreloadManager.g(this.mAdResultData);
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public boolean isVideo() {
        return com.kwad.sdk.core.response.b.a.bc(com.kwad.sdk.core.response.b.e.eb(this.mAdResultData.getAdTemplateList().get(0)));
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public void reportAdExposureFailed(int i10, AdExposureFailedReason adExposureFailedReason) {
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, i10, adExposureFailedReason);
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public void setBidEcpm(int i10) {
        setBidEcpm(i10, -1L);
    }

    @Keep
    public boolean showSplashMiniWindowIfNeeded(Context context, KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener, Rect rect) {
        return false;
    }

    @Override // com.kwad.components.core.internal.api.a
    public final boolean supportPushAd() {
        return false;
    }

    @Override // com.kwad.components.core.internal.api.a
    public final void a(com.kwad.components.core.internal.api.b bVar) {
        this.bz.a(bVar);
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public void setBidEcpm(long j10, long j11) {
        AdTemplate adTemplate = this.mAdTemplate;
        adTemplate.mBidEcpm = j10;
        com.kwad.sdk.core.adlog.c.l(adTemplate, j11);
    }
}
