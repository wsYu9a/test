package com.kwad.components.ad.fullscreen;

import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.monitor.RewardLoadCallbackType;
import com.kwad.components.ad.reward.monitor.RewardMonitorInfo;
import com.kwad.sdk.api.KsFullScreenVideoAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;

/* loaded from: classes2.dex */
public final class e {
    private long hJ;
    private KsLoadManager.FullScreenVideoAdListener hK;

    public e(long j10, KsLoadManager.FullScreenVideoAdListener fullScreenVideoAdListener) {
        this.hJ = j10;
        this.hK = fullScreenVideoAdListener;
    }

    public final void a(AdTemplate adTemplate, @Nullable List<KsFullScreenVideoAd> list) {
        com.kwad.components.ad.reward.monitor.c.a(false, adTemplate, (com.kwad.components.ad.reward.monitor.a) RewardLoadCallbackType.LOAD_SUCCESS_BEFORE, this.hJ, (com.kwad.sdk.f.a<RewardMonitorInfo>) null);
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace != null && stackTrace.length > 3 && adTemplate != null) {
            adTemplate.mDataLoadTraceElement = com.kwad.components.core.s.f.a(stackTrace[2]);
        }
        KsLoadManager.FullScreenVideoAdListener fullScreenVideoAdListener = this.hK;
        if (fullScreenVideoAdListener != null) {
            fullScreenVideoAdListener.onFullScreenVideoResult(list);
        }
        com.kwad.components.ad.reward.monitor.c.a(false, adTemplate, (com.kwad.components.ad.reward.monitor.a) RewardLoadCallbackType.LOAD_SUCCESS, this.hJ, (com.kwad.sdk.f.a<RewardMonitorInfo>) null);
    }

    public final void b(AdTemplate adTemplate, @Nullable List<KsFullScreenVideoAd> list) {
        com.kwad.components.ad.reward.monitor.c.a(false, adTemplate, (com.kwad.components.ad.reward.monitor.a) RewardLoadCallbackType.LOAD_CACHE_SUCCESS_BEFORE, this.hJ, (com.kwad.sdk.f.a<RewardMonitorInfo>) null);
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace != null && stackTrace.length > 3 && adTemplate != null) {
            adTemplate.mDataCacheTraceElement = com.kwad.components.core.s.f.a(stackTrace[2]);
        }
        KsLoadManager.FullScreenVideoAdListener fullScreenVideoAdListener = this.hK;
        if (fullScreenVideoAdListener != null) {
            fullScreenVideoAdListener.onFullScreenVideoAdLoad(list);
        }
        com.kwad.components.ad.reward.monitor.c.a(false, adTemplate, (com.kwad.components.ad.reward.monitor.a) RewardLoadCallbackType.LOAD_CACHE_SUCCESS, this.hJ, (com.kwad.sdk.f.a<RewardMonitorInfo>) null);
    }

    public final void onError(int i10, String str) {
        KsLoadManager.FullScreenVideoAdListener fullScreenVideoAdListener = this.hK;
        if (fullScreenVideoAdListener != null) {
            fullScreenVideoAdListener.onError(i10, str);
        }
        com.kwad.components.ad.reward.monitor.c.a(false, (AdTemplate) null, (com.kwad.components.ad.reward.monitor.a) RewardLoadCallbackType.LOAD_ERROR, this.hJ, (com.kwad.sdk.f.a<RewardMonitorInfo>) null);
    }
}
