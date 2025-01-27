package com.kwad.components.ad.reward.e;

import com.kwad.components.ad.reward.monitor.RewardInteractionCallbackType;
import com.kwad.components.ad.reward.monitor.RewardMonitorInfo;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class i extends c {
    private static String sZ = "IS_FRAUD";

    /* renamed from: ta */
    private static String f11667ta = "IS_FRAUD_ERROR_CODE";
    private AdTemplate mAdTemplate;
    private com.kwad.components.ad.reward.g rO;
    private String sX;
    private Map<String, Object> sY = new HashMap();

    /* renamed from: com.kwad.components.ad.reward.e.i$1 */
    public class AnonymousClass1 implements com.kwad.sdk.f.a<RewardMonitorInfo> {

        /* renamed from: tb */
        final /* synthetic */ int f11668tb;

        /* renamed from: tc */
        final /* synthetic */ int f11669tc;

        public AnonymousClass1(int i10, int i11) {
            i10 = i10;
            i11 = i11;
        }

        @Override // com.kwad.sdk.f.a
        /* renamed from: a */
        public void accept(RewardMonitorInfo rewardMonitorInfo) {
            rewardMonitorInfo.setTaskType(i10).setTaskStep(i11);
        }
    }

    private String getUniqueId() {
        return this.sX;
    }

    private KsRewardVideoAd.RewardAdInteractionListener hn() {
        return f.J(getUniqueId());
    }

    public final void N(String str) {
        this.sX = str;
    }

    @Override // com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
    public void cg() {
        super.cg();
        KsRewardVideoAd.RewardAdInteractionListener hn = hn();
        if (hn != null) {
            hn.onAdClicked();
        }
        com.kwad.components.ad.reward.monitor.c.a(true, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.AD_CLICK, this.mAdTemplate, (com.kwad.sdk.f.a<RewardMonitorInfo>) null);
    }

    public final boolean h(int i10, int i11) {
        KsRewardVideoAd.RewardAdInteractionListener hn = hn();
        if (hn != null) {
            hn.onRewardStepVerify(i10, i11);
        }
        com.kwad.components.ad.reward.monitor.c.a(true, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.REWARD_STEP_VERIFY, this.mAdTemplate, (com.kwad.sdk.f.a<RewardMonitorInfo>) new com.kwad.sdk.f.a<RewardMonitorInfo>() { // from class: com.kwad.components.ad.reward.e.i.1

            /* renamed from: tb */
            final /* synthetic */ int f11668tb;

            /* renamed from: tc */
            final /* synthetic */ int f11669tc;

            public AnonymousClass1(int i102, int i112) {
                i10 = i102;
                i11 = i112;
            }

            @Override // com.kwad.sdk.f.a
            /* renamed from: a */
            public void accept(RewardMonitorInfo rewardMonitorInfo) {
                rewardMonitorInfo.setTaskType(i10).setTaskStep(i11);
            }
        });
        return hn != null;
    }

    public final boolean hm() {
        KsRewardVideoAd.RewardAdInteractionListener hn = hn();
        if (hn != null) {
            if (com.kwad.sdk.core.response.b.a.di(com.kwad.sdk.core.response.b.e.eb(this.rO.mAdTemplate))) {
                this.sY.put(sZ, Boolean.valueOf(this.rO.qC == 3));
                this.sY.put(f11667ta, Integer.valueOf(this.rO.qD));
                com.kwad.components.ad.reward.g gVar = this.rO;
                com.kwad.components.ad.reward.monitor.c.b(gVar.mAdTemplate, gVar.qC, gVar.qD);
            }
            try {
                hn.onRewardVerify(this.sY);
            } catch (Throwable unused) {
            }
            hn.onRewardVerify();
        }
        com.kwad.components.ad.reward.monitor.c.a(true, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.REWARD_VERIFY, this.mAdTemplate, (com.kwad.sdk.f.a<RewardMonitorInfo>) null);
        return hn != null;
    }

    @Override // com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
    public void i(boolean z10) {
        super.i(z10);
        KsRewardVideoAd.RewardAdInteractionListener hn = hn();
        if (hn != null) {
            hn.onPageDismiss();
        }
        com.kwad.components.ad.reward.monitor.c.a(true, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.PAGE_DISMISS, this.mAdTemplate, (com.kwad.sdk.f.a<RewardMonitorInfo>) null);
    }

    @Override // com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
    public void onRewardVerify() {
        super.onRewardVerify();
    }

    @Override // com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
    public final void onVideoPlayEnd() {
        super.onVideoPlayEnd();
        KsRewardVideoAd.RewardAdInteractionListener hn = hn();
        if (hn != null) {
            hn.onVideoPlayEnd();
        }
        com.kwad.components.ad.reward.monitor.c.a(true, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.VIDEO_PLAY_END, this.mAdTemplate, (com.kwad.sdk.f.a<RewardMonitorInfo>) null);
    }

    @Override // com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
    public final void onVideoPlayError(int i10, int i11) {
        super.onVideoPlayError(i10, i11);
        KsRewardVideoAd.RewardAdInteractionListener hn = hn();
        if (hn != null) {
            hn.onVideoPlayError(i10, i11);
        }
        com.kwad.components.ad.reward.monitor.c.a(true, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.VIDEO_PLAY_ERROR, this.mAdTemplate, (com.kwad.sdk.f.a<RewardMonitorInfo>) null);
    }

    @Override // com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
    public final void onVideoPlayStart() {
        super.onVideoPlayStart();
        KsRewardVideoAd.RewardAdInteractionListener hn = hn();
        if (hn != null) {
            hn.onVideoPlayStart();
        }
        com.kwad.components.ad.reward.monitor.c.a(true, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.VIDEO_PLAY_START, this.mAdTemplate, (com.kwad.sdk.f.a<RewardMonitorInfo>) null);
    }

    @Override // com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
    public final void onVideoSkipToEnd(long j10) {
        super.onVideoSkipToEnd(j10);
        try {
            KsRewardVideoAd.RewardAdInteractionListener hn = hn();
            if (hn != null) {
                hn.onVideoSkipToEnd(j10);
            }
            com.kwad.components.ad.reward.monitor.c.a(true, (com.kwad.components.ad.reward.monitor.a) RewardInteractionCallbackType.VIDEO_SKIP_TO_END, this.mAdTemplate, (com.kwad.sdk.f.a<RewardMonitorInfo>) null);
        } catch (Throwable unused) {
        }
    }

    public final void setAdTemplate(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    public final void setCallerContext(com.kwad.components.ad.reward.g gVar) {
        this.rO = gVar;
    }
}
