package com.kwad.components.ad.fullscreen;

import com.kwad.components.ad.reward.monitor.RewardInteractionCallbackType;
import com.kwad.components.ad.reward.monitor.RewardMonitorInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: classes2.dex */
public class d extends com.kwad.components.ad.reward.e.c {
    private boolean hI = false;
    private AdTemplate mAdTemplate;
    private c mInteractionListener;

    private void onAdClosed() {
        c cVar = this.mInteractionListener;
        if (cVar != null) {
            cVar.onAdClosed();
        }
    }

    private void onAdShow() {
        c cVar = this.mInteractionListener;
        if (cVar != null) {
            cVar.onAdShow();
        }
    }

    public final void a(c cVar) {
        this.mInteractionListener = cVar;
    }

    @Override // com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
    public final void cg() {
        c cVar = this.mInteractionListener;
        if (cVar != null) {
            cVar.onAdClicked();
        }
        com.kwad.components.ad.reward.monitor.c.a(false, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.AD_CLICK, this.mAdTemplate, (com.kwad.sdk.f.a<RewardMonitorInfo>) null);
    }

    @Override // com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
    public void i(boolean z10) {
        onAdClosed();
        c cVar = this.mInteractionListener;
        if (cVar != null) {
            cVar.onPageDismiss();
        }
        com.kwad.components.ad.reward.monitor.c.a(false, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.PAGE_DISMISS, this.mAdTemplate, (com.kwad.sdk.f.a<RewardMonitorInfo>) null);
    }

    @Override // com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
    public final void onVideoPlayEnd() {
        c cVar = this.mInteractionListener;
        if (cVar != null) {
            cVar.onVideoPlayEnd();
        }
        com.kwad.components.ad.reward.monitor.c.a(false, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.VIDEO_PLAY_END, this.mAdTemplate, (com.kwad.sdk.f.a<RewardMonitorInfo>) null);
    }

    @Override // com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
    public final void onVideoPlayError(int i10, int i11) {
        c cVar = this.mInteractionListener;
        if (cVar != null) {
            cVar.onVideoPlayError(i10, i11);
        }
        com.kwad.components.ad.reward.monitor.c.a(false, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.VIDEO_PLAY_ERROR, this.mAdTemplate, (com.kwad.sdk.f.a<RewardMonitorInfo>) null);
    }

    @Override // com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
    public final void onVideoPlayStart() {
        c cVar = this.mInteractionListener;
        if (cVar != null) {
            cVar.onVideoPlayStart();
        }
        if (!this.hI) {
            this.hI = true;
            onAdShow();
        }
        com.kwad.components.ad.reward.monitor.c.a(false, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.VIDEO_PLAY_START, this.mAdTemplate, (com.kwad.sdk.f.a<RewardMonitorInfo>) null);
    }

    @Override // com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
    public final void onVideoSkipToEnd(long j10) {
        c cVar = this.mInteractionListener;
        if (cVar != null) {
            cVar.onSkippedVideo();
        }
        com.kwad.components.ad.reward.monitor.c.a(false, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.VIDEO_SKIP_TO_END, this.mAdTemplate, (com.kwad.sdk.f.a<RewardMonitorInfo>) null);
    }

    public final void setAdTemplate(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }
}
