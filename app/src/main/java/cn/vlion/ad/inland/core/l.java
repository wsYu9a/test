package cn.vlion.ad.inland.core;

import android.view.View;
import cn.vlion.ad.inland.core.config.VlionAdError;

/* loaded from: classes.dex */
public interface l {
    void a(double d10);

    void a(VlionAdError vlionAdError);

    void onAdClick();

    void onAdClose();

    void onAdExposure();

    void onAdRenderFailure(VlionAdError vlionAdError);

    void onAdRenderSuccess(View view);

    void onAdShowFailure(VlionAdError vlionAdError);

    void onAdSkip();
}
