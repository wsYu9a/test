package com.kwad.components.ad.interstitial.e;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.interstitial.c.c;
import com.kwad.components.ad.interstitial.e.f;
import com.kwad.components.core.webview.a.j;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.j.k;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.widget.KSFrameLayout;

/* loaded from: classes.dex */
public final class c extends a {
    private KsAdVideoPlayConfig dZ;
    private com.kwad.components.core.webview.a.d.e gG;
    protected KsInterstitialAd.AdInteractionListener hN;
    private com.kwad.components.ad.interstitial.d hU;
    private int jI;
    protected com.kwad.components.ad.interstitial.c.c jt;
    private boolean jy;
    private c.a jz;

    @Nullable
    protected com.kwad.components.ad.interstitial.c.b lU;
    private boolean lV;
    protected ViewGroup lW;
    protected AdInfo mAdInfo;

    @NonNull
    protected AdTemplate mAdTemplate;

    /* renamed from: com.kwad.components.ad.interstitial.e.c$1 */
    final class AnonymousClass1 extends com.kwad.components.core.webview.a.d.e {
        AnonymousClass1() {
        }

        @Override // com.kwad.components.core.webview.a.d.b
        public final void u(String str) {
            if (j.b("ksad-interstitial-card", c.this.mAdTemplate).equals(str)) {
                c.a(c.this, false);
                com.kwad.components.ad.interstitial.c.b bVar = c.this.lU;
                if (bVar != null) {
                    bVar.jW();
                }
                c cVar = c.this;
                cVar.lU = cVar.ev();
                c cVar2 = c.this;
                cVar2.lU.E(cVar2.lW);
                c cVar3 = c.this;
                cVar3.lU.f(cVar3.jt);
            }
        }
    }

    public c(@NonNull Context context) {
        this(context, null);
    }

    private c(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, null);
        this.jI = -1;
        this.gG = new com.kwad.components.core.webview.a.d.e() { // from class: com.kwad.components.ad.interstitial.e.c.1
            AnonymousClass1() {
            }

            @Override // com.kwad.components.core.webview.a.d.b
            public final void u(String str) {
                if (j.b("ksad-interstitial-card", c.this.mAdTemplate).equals(str)) {
                    c.a(c.this, false);
                    com.kwad.components.ad.interstitial.c.b bVar = c.this.lU;
                    if (bVar != null) {
                        bVar.jW();
                    }
                    c cVar = c.this;
                    cVar.lU = cVar.ev();
                    c cVar2 = c.this;
                    cVar2.lU.E(cVar2.lW);
                    c cVar3 = c.this;
                    cVar3.lU.f(cVar3.jt);
                }
            }
        };
        this.lW = (ViewGroup) k.inflate(context, getLayoutId(), this);
    }

    private f a(Context context, AdInfo adInfo, com.kwad.components.ad.interstitial.c.c cVar) {
        boolean a2 = com.kwad.components.ad.interstitial.c.c.a(this.mContext, adInfo);
        f.a aVar = new f.a();
        aVar.v(a2);
        boolean z = true;
        aVar.w(!cVar.M(context) && com.kwad.components.ad.interstitial.kwai.b.cI());
        aVar.I(com.kwad.components.ad.interstitial.kwai.b.cJ());
        if (com.kwad.sdk.core.response.a.a.aO(adInfo) && ai.DL()) {
            z = false;
        }
        aVar.x(z);
        return new f(context, aVar);
    }

    static /* synthetic */ boolean a(c cVar, boolean z) {
        cVar.lV = false;
        return false;
    }

    private com.kwad.components.ad.interstitial.c.c eu() {
        com.kwad.components.ad.interstitial.c.c cVar = new com.kwad.components.ad.interstitial.c.c();
        AdTemplate adTemplate = this.mAdTemplate;
        cVar.mAdTemplate = adTemplate;
        cVar.hN = this.hN;
        cVar.hU = this.hU;
        cVar.mApkDownloadHelper = new com.kwad.components.core.d.b.c(adTemplate);
        cVar.dZ = this.dZ;
        cVar.eN = new com.kwad.sdk.core.video.videoview.a(this.mContext);
        KSFrameLayout kSFrameLayout = (KSFrameLayout) this.lW.findViewById(R.id.ksad_container);
        cVar.jC = kSFrameLayout;
        com.kwad.components.ad.interstitial.d.b bVar = new com.kwad.components.ad.interstitial.d.b(kSFrameLayout, 100);
        cVar.hL = bVar;
        bVar.rD();
        cVar.jI = this.jI;
        cVar.jy = this.jy;
        cVar.jz = this.jz;
        cVar.gG = this.gG;
        cVar.ju = a(this.mContext, com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate), cVar);
        return cVar;
    }

    @Override // com.kwad.components.ad.interstitial.e.a
    public final void a(@NonNull AdTemplate adTemplate, com.kwad.components.ad.interstitial.d dVar, @NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig, KsInterstitialAd.AdInteractionListener adInteractionListener) {
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        adTemplate.realShowType = 2;
        this.dZ = ksAdVideoPlayConfig;
        this.hU = dVar;
        this.lV = com.kwad.sdk.core.response.a.b.bu(this.mAdTemplate);
        this.hN = adInteractionListener;
        this.jt = eu();
        if (this.lU == null) {
            this.lU = ev();
        }
        this.lU.E(this.lW);
        this.lU.f(this.jt);
    }

    @Override // com.kwad.components.ad.interstitial.e.a
    public final void cu() {
        com.kwad.components.ad.interstitial.c.b bVar = this.lU;
        if (bVar != null) {
            bVar.cT();
        }
    }

    @Override // com.kwad.components.ad.interstitial.e.a
    public final void cv() {
        com.kwad.components.ad.interstitial.c.b bVar = this.lU;
        if (bVar != null) {
            bVar.cU();
        }
    }

    @NonNull
    public final com.kwad.components.ad.interstitial.c.b ev() {
        Presenter gVar;
        com.kwad.components.ad.interstitial.c.b bVar = new com.kwad.components.ad.interstitial.c.b();
        if (!this.lV) {
            bVar.a(new com.kwad.components.ad.interstitial.c.d());
            if (com.kwad.sdk.core.response.a.a.aU(this.mAdInfo)) {
                bVar.a(new com.kwad.components.ad.interstitial.c.j());
            }
            bVar.a(new com.kwad.components.ad.interstitial.c.k());
            bVar.a(new com.kwad.components.ad.interstitial.c.f());
            if (com.kwad.sdk.core.response.a.a.aH(this.mAdInfo)) {
                bVar.a(new com.kwad.components.ad.interstitial.c.a());
            }
            if (this.jt.M(getContext())) {
                gVar = new com.kwad.components.ad.interstitial.c.g();
            }
            return bVar;
        }
        gVar = new com.kwad.components.ad.interstitial.c.kwai.b();
        bVar.a(gVar);
        return bVar;
    }

    public final void ew() {
        com.kwad.components.ad.interstitial.c.c cVar = this.jt;
        if (cVar == null || !cVar.jH) {
            return;
        }
        cVar.cW();
    }

    public final void ex() {
        com.kwad.components.ad.interstitial.c.c cVar = this.jt;
        if (cVar != null) {
            if (this.lV || cVar.jH) {
                cVar.cX();
            }
        }
    }

    public final void ey() {
        if (this.jt != null) {
            this.jt.a(new c.b(this.mContext).k(true).D(1).m(true).C(2));
        }
    }

    protected final int getLayoutId() {
        return R.layout.ksad_interstitial;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.components.ad.interstitial.c.c cVar = this.jt;
        if (cVar != null) {
            cVar.release();
        }
        com.kwad.components.ad.interstitial.c.b bVar = this.lU;
        if (bVar != null) {
            bVar.destroy();
        }
    }

    public final void setAdConvertListener(c.a aVar) {
        this.jz = aVar;
        com.kwad.components.ad.interstitial.c.c cVar = this.jt;
        if (cVar != null) {
            cVar.jz = aVar;
        }
    }

    @Override // com.kwad.components.ad.interstitial.e.a
    public final void setAdInteractionListener(KsInterstitialAd.AdInteractionListener adInteractionListener) {
        this.hN = adInteractionListener;
        com.kwad.components.ad.interstitial.c.c cVar = this.jt;
        if (cVar != null) {
            cVar.hN = adInteractionListener;
        }
    }

    public final void setAggregateAdView(boolean z) {
        this.jy = z;
        com.kwad.components.ad.interstitial.c.c cVar = this.jt;
        if (cVar != null) {
            cVar.jy = z;
        }
    }

    public final void setAggregateShowTriggerType(int i2) {
        this.jI = i2;
        com.kwad.components.ad.interstitial.c.c cVar = this.jt;
        if (cVar != null) {
            cVar.jI = i2;
        }
    }
}
