package cn.vlion.ad.inland.base.bid;

import android.view.View;

/* loaded from: classes.dex */
public interface VlionBiddingActionListener {
    void onAdClick();

    void onAdClose();

    void onAdExposure();

    void onAdRenderFailure(int i10, String str);

    void onAdRenderSuccess(View view);

    void onAdShowFailure(int i10, String str);

    void onAdSkip();
}
