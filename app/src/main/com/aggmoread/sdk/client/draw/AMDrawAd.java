package com.aggmoread.sdk.client.draw;

import android.app.Activity;
import android.view.View;
import com.aggmoread.sdk.client.AMAdInterface;
import com.aggmoread.sdk.client.AMError;

/* loaded from: classes.dex */
public interface AMDrawAd extends AMAdInterface {

    public interface DrawVideoListener {
        void onVideoComplete();

        void onVideoError(AMError aMError);

        void onVideoPause();

        void onVideoStart();
    }

    View getView();

    void recycle();

    void render();

    void renderActivity(Activity activity);

    void setInteractionListener(AMDrawAdInteractionListener aMDrawAdInteractionListener);

    void setVideoListener(DrawVideoListener drawVideoListener);
}
