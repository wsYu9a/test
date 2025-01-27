package com.alimm.tanx.core.ad.ad.template.rendering.reward;

import android.app.Activity;
import com.alimm.tanx.core.ad.ad.reward.ITanxRewardVideoInteractionListener;
import com.alimm.tanx.core.ad.ad.reward.model.VideoParam;
import com.alimm.tanx.core.ad.listener.INewTanxExpressAd;

/* loaded from: classes.dex */
public interface ITanxRewardExpressAd extends INewTanxExpressAd {

    public interface OnRewardAdListener extends ITanxRewardVideoInteractionListener {
    }

    @Override // com.alimm.tanx.core.ad.ITanxAd
    void destroy();

    void setOnRewardAdListener(OnRewardAdListener onRewardAdListener);

    void showAd(Activity activity);

    void showAd(Activity activity, VideoParam videoParam);

    void showAd(Activity activity, VideoParam videoParam, boolean z10);
}
