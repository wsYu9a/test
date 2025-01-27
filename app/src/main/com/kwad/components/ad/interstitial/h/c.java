package com.kwad.components.ad.interstitial.h;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.interstitial.f.c;
import com.kwad.components.ad.interstitial.f.g;
import com.kwad.components.ad.interstitial.h.d;
import com.kwad.components.core.webview.tachikoma.e.f;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.n.m;
import com.kwad.sdk.utils.an;
import com.kwad.sdk.widget.KSFrameLayout;

/* loaded from: classes2.dex */
public final class c extends a {
    private KsAdVideoPlayConfig bS;
    protected KsInterstitialAd.AdInteractionListener jr;
    private com.kwad.components.ad.interstitial.d jz;
    protected com.kwad.components.ad.interstitial.f.c kY;

    /* renamed from: lc */
    private boolean f11616lc;

    /* renamed from: ld */
    private c.a f11617ld;

    /* renamed from: lf */
    private f f11618lf;
    private int ln;
    protected AdInfo mAdInfo;

    @NonNull
    protected AdResultData mAdResultData;

    @NonNull
    protected AdTemplate mAdTemplate;

    @Nullable
    protected com.kwad.components.ad.interstitial.f.b mP;
    private boolean mQ;
    protected ViewGroup mR;

    /* renamed from: com.kwad.components.ad.interstitial.h.c$1 */
    public class AnonymousClass1 extends f {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.webview.tachikoma.e.f
        public final void a(String str, long j10, long j11, long j12) {
            c.this.kY.lm = true;
        }

        @Override // com.kwad.components.core.webview.tachikoma.e.b
        public final void s(String str) {
            if ("tk_interstitial".equals(str)) {
                c.a(c.this, false);
                com.kwad.components.ad.interstitial.f.b bVar = c.this.mP;
                if (bVar != null) {
                    bVar.mM();
                }
                c cVar = c.this;
                cVar.mP = cVar.et();
                c cVar2 = c.this;
                cVar2.mP.I(cVar2.mR);
                c cVar3 = c.this;
                cVar3.mP.k(cVar3.kY);
            }
        }
    }

    public c(@NonNull Context context) {
        this(context, null);
    }

    public static /* synthetic */ boolean a(c cVar, boolean z10) {
        cVar.mQ = false;
        return false;
    }

    private com.kwad.components.ad.interstitial.f.c es() {
        com.kwad.components.ad.interstitial.f.c cVar = new com.kwad.components.ad.interstitial.f.c();
        cVar.a(this.mAdResultData);
        cVar.jr = this.jr;
        cVar.jz = this.jz;
        cVar.mApkDownloadHelper = new com.kwad.components.core.e.d.c(this.mAdTemplate);
        cVar.bS = this.bS;
        cVar.co = new com.kwad.sdk.core.video.videoview.a(this.mContext);
        KSFrameLayout kSFrameLayout = (KSFrameLayout) this.mR.findViewById(R.id.ksad_container);
        cVar.f11594lg = kSFrameLayout;
        com.kwad.components.ad.interstitial.g.b bVar = new com.kwad.components.ad.interstitial.g.b(kSFrameLayout, com.kwad.sdk.core.config.d.Df());
        cVar.f11587jp = bVar;
        bVar.uE();
        cVar.ln = this.ln;
        cVar.f11590lc = this.f11616lc;
        cVar.f11591ld = this.f11617ld;
        cVar.f11593lf = this.f11618lf;
        cVar.kZ = a(this.mContext, com.kwad.sdk.core.response.b.e.eb(this.mAdTemplate), cVar);
        return cVar;
    }

    @Override // com.kwad.components.ad.interstitial.h.a
    public final void cN() {
        com.kwad.components.ad.interstitial.f.b bVar = this.mP;
        if (bVar != null) {
            bVar.dl();
        }
    }

    @Override // com.kwad.components.ad.interstitial.h.a
    public final void cO() {
        com.kwad.components.ad.interstitial.f.b bVar = this.mP;
        if (bVar != null) {
            bVar.dm();
        }
    }

    @NonNull
    public final com.kwad.components.ad.interstitial.f.b et() {
        com.kwad.components.ad.interstitial.f.b bVar = new com.kwad.components.ad.interstitial.f.b();
        if (this.mQ) {
            bVar.a(new com.kwad.components.ad.interstitial.f.a.b());
        } else {
            if (com.kwad.sdk.core.response.b.a.bc(this.mAdInfo)) {
                bVar.a(new com.kwad.components.ad.interstitial.f.f());
            }
            bVar.a(new g());
            bVar.a(new com.kwad.components.ad.interstitial.f.d());
            if (com.kwad.sdk.core.response.b.a.aP(this.mAdInfo)) {
                bVar.a(new com.kwad.components.ad.interstitial.f.a());
            }
            if (this.kY.L(getContext())) {
                bVar.a(new com.kwad.components.ad.interstitial.f.e());
            }
        }
        return bVar;
    }

    public final void eu() {
        com.kwad.components.ad.interstitial.f.c cVar = this.kY;
        if (cVar == null || !cVar.ll) {
            return;
        }
        cVar.dn();
    }

    public final void ev() {
        com.kwad.components.ad.interstitial.f.c cVar = this.kY;
        if (cVar != null) {
            if (this.mQ || cVar.ll) {
                cVar.m33do();
            }
        }
    }

    public final void ew() {
        if (this.kY != null) {
            this.kY.a(new c.b(this.mContext).l(true).A(1).n(true).z(2));
        }
    }

    public final boolean ex() {
        com.kwad.components.ad.interstitial.f.c cVar = this.kY;
        if (cVar != null) {
            return cVar.lm;
        }
        return false;
    }

    public final int getLayoutId() {
        return R.layout.ksad_interstitial;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.components.ad.interstitial.f.c cVar = this.kY;
        if (cVar != null) {
            cVar.release();
        }
        com.kwad.components.ad.interstitial.f.b bVar = this.mP;
        if (bVar != null) {
            bVar.destroy();
        }
    }

    public final void setAdConvertListener(c.a aVar) {
        this.f11617ld = aVar;
        com.kwad.components.ad.interstitial.f.c cVar = this.kY;
        if (cVar != null) {
            cVar.f11591ld = aVar;
        }
    }

    @Override // com.kwad.components.ad.interstitial.h.a
    public final void setAdInteractionListener(KsInterstitialAd.AdInteractionListener adInteractionListener) {
        this.jr = adInteractionListener;
        com.kwad.components.ad.interstitial.f.c cVar = this.kY;
        if (cVar != null) {
            cVar.jr = adInteractionListener;
        }
    }

    public final void setAggregateAdView(boolean z10) {
        this.f11616lc = z10;
        com.kwad.components.ad.interstitial.f.c cVar = this.kY;
        if (cVar != null) {
            cVar.f11590lc = z10;
        }
    }

    public final void setAggregateShowTriggerType(int i10) {
        this.ln = i10;
        com.kwad.components.ad.interstitial.f.c cVar = this.kY;
        if (cVar != null) {
            cVar.ln = i10;
        }
    }

    private c(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, null);
        this.ln = -1;
        this.f11618lf = new f() { // from class: com.kwad.components.ad.interstitial.h.c.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.components.core.webview.tachikoma.e.f
            public final void a(String str, long j10, long j11, long j12) {
                c.this.kY.lm = true;
            }

            @Override // com.kwad.components.core.webview.tachikoma.e.b
            public final void s(String str) {
                if ("tk_interstitial".equals(str)) {
                    c.a(c.this, false);
                    com.kwad.components.ad.interstitial.f.b bVar = c.this.mP;
                    if (bVar != null) {
                        bVar.mM();
                    }
                    c cVar = c.this;
                    cVar.mP = cVar.et();
                    c cVar2 = c.this;
                    cVar2.mP.I(cVar2.mR);
                    c cVar3 = c.this;
                    cVar3.mP.k(cVar3.kY);
                }
            }
        };
        this.mR = (ViewGroup) m.inflate(context, getLayoutId(), this);
    }

    private d a(Context context, AdInfo adInfo, com.kwad.components.ad.interstitial.f.c cVar) {
        boolean a10 = com.kwad.components.ad.interstitial.f.c.a(this.mContext, adInfo);
        d.a aVar = new d.a();
        aVar.w(a10);
        aVar.x(!cVar.L(context) && com.kwad.components.ad.interstitial.b.b.db());
        aVar.F(com.kwad.components.ad.interstitial.b.b.dc());
        aVar.y((com.kwad.sdk.core.response.b.a.aW(adInfo) && an.NS()) ? false : true);
        return new d(context, aVar);
    }

    @Override // com.kwad.components.ad.interstitial.h.a
    public final void a(@NonNull AdResultData adResultData, com.kwad.components.ad.interstitial.d dVar, @NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig, KsInterstitialAd.AdInteractionListener adInteractionListener) {
        this.mAdResultData = adResultData;
        AdTemplate o10 = com.kwad.sdk.core.response.b.c.o(adResultData);
        this.mAdTemplate = o10;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.eb(o10);
        AdTemplate adTemplate = this.mAdTemplate;
        adTemplate.realShowType = 2;
        this.bS = ksAdVideoPlayConfig;
        this.jz = dVar;
        this.mQ = com.kwad.sdk.core.response.b.b.da(adTemplate);
        this.jr = adInteractionListener;
        this.kY = es();
        if (this.mP == null) {
            this.mP = et();
        }
        this.mP.I(this.mR);
        this.mP.k(this.kY);
    }
}
