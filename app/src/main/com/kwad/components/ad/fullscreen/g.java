package com.kwad.components.ad.fullscreen;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.kwad.components.core.video.j;
import com.kwad.sdk.api.KsFullScreenVideoAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdResultData;

/* loaded from: classes2.dex */
public final class g extends com.kwad.components.ad.b implements com.kwad.components.core.internal.api.a, KsFullScreenVideoAd {
    private c hS;

    /* renamed from: com.kwad.components.ad.fullscreen.g$1 */
    public class AnonymousClass1 extends c {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.fullscreen.c, com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public final void onPageDismiss() {
            super.onPageDismiss();
            g.this.bz.i(g.this);
        }

        @Override // com.kwad.components.ad.fullscreen.c, com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public final void onVideoPlayStart() {
            super.onVideoPlayStart();
            g.this.bz.h(g.this);
        }
    }

    public g(@NonNull AdResultData adResultData) {
        super(adResultData);
        com.kwad.components.ad.j.b.fc().a(this);
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd
    public final boolean isAdEnable() {
        if (com.kwad.sdk.core.response.b.e.er(this.mAdTemplate) >= 0) {
            return true;
        }
        return j.aE(this.mAdTemplate);
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd
    public final void setFullScreenVideoAdInteractionListener(KsFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        if (this.hS == null) {
            this.hS = new c() { // from class: com.kwad.components.ad.fullscreen.g.1
                public AnonymousClass1() {
                }

                @Override // com.kwad.components.ad.fullscreen.c, com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
                public final void onPageDismiss() {
                    super.onPageDismiss();
                    g.this.bz.i(g.this);
                }

                @Override // com.kwad.components.ad.fullscreen.c, com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
                public final void onVideoPlayStart() {
                    super.onVideoPlayStart();
                    g.this.bz.h(g.this);
                }
            };
        }
        this.hS.a(fullScreenVideoAdInteractionListener);
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd
    public final void showFullScreenVideoAd(Activity activity, KsVideoPlayConfig ksVideoPlayConfig) {
        if (activity == null || activity.isFinishing()) {
            com.kwad.sdk.core.d.c.e("KsFullScreenVideoAdControl", "showFullScreenVideoAd error, activity is null or finished");
            com.kwad.components.ad.reward.monitor.c.b(false, this.mAdTemplate, "illegal_activity");
            return;
        }
        com.kwad.components.ad.reward.monitor.c.h(false, this.mAdTemplate);
        com.kwad.sdk.commercial.d.c.bF(this.mAdTemplate);
        if (!com.kwad.sdk.core.config.d.Eg() && !isAdEnable()) {
            com.kwad.sdk.core.d.c.i("KsFullScreenVideoAdControl", "isAdEnable is false");
            com.kwad.components.ad.reward.monitor.c.b(false, this.mAdTemplate, "cache_not_ready");
        } else {
            if (ksVideoPlayConfig == null) {
                ksVideoPlayConfig = new KsVideoPlayConfig.Builder().build();
            }
            KsFullScreenVideoActivityProxy.launch(activity, this.mAdResultData, ksVideoPlayConfig, this.hS);
        }
    }
}
