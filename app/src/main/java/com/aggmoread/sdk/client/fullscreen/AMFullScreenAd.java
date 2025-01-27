package com.aggmoread.sdk.client.fullscreen;

import android.app.Activity;
import com.aggmoread.sdk.client.AMAdInterface;

/* loaded from: classes.dex */
public interface AMFullScreenAd extends AMAdInterface {
    void show(Activity activity, AMFullScreenAdInteractionListener aMFullScreenAdInteractionListener);

    void show(AMFullScreenAdInteractionListener aMFullScreenAdInteractionListener);
}
