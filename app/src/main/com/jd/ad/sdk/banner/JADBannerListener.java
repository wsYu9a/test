package com.jd.ad.sdk.banner;

import android.view.View;

/* loaded from: classes2.dex */
public interface JADBannerListener {
    void onClick();

    void onClose();

    void onExposure();

    void onLoadFailure(int i10, String str);

    void onLoadSuccess();

    void onRenderFailure(int i10, String str);

    void onRenderSuccess(View view);
}
