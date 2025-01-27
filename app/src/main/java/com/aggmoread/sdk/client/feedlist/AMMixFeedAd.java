package com.aggmoread.sdk.client.feedlist;

import android.app.Activity;
import android.view.View;
import com.aggmoread.sdk.client.feedlist.AMExpressAd;

/* loaded from: classes.dex */
public interface AMMixFeedAd extends AMNativeAd {
    View getExpressView();

    boolean isExpressAd();

    void renderExpressAd();

    void renderExpressAd(Activity activity);

    void setExpressInteractionListener(AMExpressInteractionListener aMExpressInteractionListener);

    void setExpressMediaListener(AMExpressAd.ExpressMediaListener expressMediaListener);
}
