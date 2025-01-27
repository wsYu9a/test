package com.alimm.tanx.core.ad.ad.reward;

import com.alimm.tanx.core.ad.listener.ITanxInteractionListener;
import com.alimm.tanx.core.request.TanxError;
import com.alimm.tanx.core.request.TanxPlayerError;
import java.util.Map;

/* loaded from: classes.dex */
public interface ITanxRewardVideoInteractionListener extends ITanxInteractionListener<ITanxRewardVideoAd> {
    void onAdClose();

    void onError(TanxError tanxError);

    void onRewardArrived(boolean z10, int i10, Map<String, Object> map);

    void onSkippedVideo();

    void onVideoComplete();

    void onVideoError(TanxPlayerError tanxPlayerError);
}
