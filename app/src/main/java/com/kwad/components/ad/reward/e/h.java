package com.kwad.components.ad.reward.e;

import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsRewardVideoAd;
import java.util.Map;

/* loaded from: classes2.dex */
public class h implements KsRewardVideoAd.RewardAdInteractionListener {

    @Nullable
    private KsRewardVideoAd.RewardAdInteractionListener sW;

    public final void b(@Nullable KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        this.sW = rewardAdInteractionListener;
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onAdClicked() {
        KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.sW;
        if (rewardAdInteractionListener != null) {
            rewardAdInteractionListener.onAdClicked();
        }
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onExtraRewardVerify(int i10) {
        KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.sW;
        if (rewardAdInteractionListener != null) {
            rewardAdInteractionListener.onExtraRewardVerify(i10);
        }
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onPageDismiss() {
        KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.sW;
        if (rewardAdInteractionListener != null) {
            rewardAdInteractionListener.onPageDismiss();
        }
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onRewardStepVerify(int i10, int i11) {
        KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.sW;
        if (rewardAdInteractionListener != null) {
            rewardAdInteractionListener.onRewardStepVerify(i10, i11);
        }
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onRewardVerify() {
        KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.sW;
        if (rewardAdInteractionListener != null) {
            rewardAdInteractionListener.onRewardVerify();
        }
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onVideoPlayEnd() {
        KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.sW;
        if (rewardAdInteractionListener != null) {
            rewardAdInteractionListener.onVideoPlayEnd();
        }
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onVideoPlayError(int i10, int i11) {
        KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.sW;
        if (rewardAdInteractionListener != null) {
            rewardAdInteractionListener.onVideoPlayError(i10, i11);
        }
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onVideoPlayStart() {
        try {
            KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.sW;
            if (rewardAdInteractionListener != null) {
                rewardAdInteractionListener.onVideoPlayStart();
            }
        } catch (Throwable th2) {
            com.kwad.components.core.d.a.reportSdkCaughtException(th2);
        }
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onVideoSkipToEnd(long j10) {
        KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.sW;
        if (rewardAdInteractionListener != null) {
            rewardAdInteractionListener.onVideoSkipToEnd(j10);
        }
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
    public void onRewardVerify(Map<String, Object> map) {
        KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.sW;
        if (rewardAdInteractionListener != null) {
            rewardAdInteractionListener.onRewardVerify(map);
        }
    }
}
