package com.aggmoread.sdk.client.feedlist;

import android.app.Activity;
import android.view.View;
import com.aggmoread.sdk.client.AMAdInterface;
import com.aggmoread.sdk.client.AMError;

/* loaded from: classes.dex */
public interface AMExpressAd extends AMAdInterface {

    public interface ExpressMediaListener {
        void onVideoCached(AMExpressAd aMExpressAd);

        void onVideoComplete(AMExpressAd aMExpressAd);

        void onVideoError(AMExpressAd aMExpressAd, AMError aMError);

        void onVideoInit(AMExpressAd aMExpressAd);

        void onVideoLoading(AMExpressAd aMExpressAd);

        void onVideoPageClose(AMExpressAd aMExpressAd);

        void onVideoPageOpen(AMExpressAd aMExpressAd);

        void onVideoPause(AMExpressAd aMExpressAd);

        void onVideoReady(AMExpressAd aMExpressAd, long j10);

        void onVideoStart(AMExpressAd aMExpressAd);
    }

    View getView();

    void recycle();

    void render();

    void renderActivity(Activity activity);

    void setInteractionListener(AMExpressInteractionListener aMExpressInteractionListener);

    void setMediaListener(ExpressMediaListener expressMediaListener);
}
