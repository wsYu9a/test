package com.heytap.msp.mobad.api.params;

import android.view.View;
import com.heytap.msp.mobad.api.ad.IBidding;

/* loaded from: classes.dex */
public interface INativeTempletAdView extends IBidding {
    public static final String TAG = "INativeTempletAdView";

    void destroy();

    View getAdView();

    void render();
}
