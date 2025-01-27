package cn.vlion.ad.inland.core.draw;

import android.view.View;
import cn.vlion.ad.inland.core.config.VlionAdError;

/* loaded from: classes.dex */
public interface VlionDrawListener {
    void onAdClick();

    void onAdExposure();

    void onAdLoadFailure(VlionAdError vlionAdError);

    void onAdLoadSuccess(double d10);

    void onAdRenderFailure(VlionAdError vlionAdError);

    void onAdRenderSuccess(View view);

    void onAdShowFailure(VlionAdError vlionAdError);
}
