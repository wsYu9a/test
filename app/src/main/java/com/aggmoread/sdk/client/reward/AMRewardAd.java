package com.aggmoread.sdk.client.reward;

import android.app.Activity;
import com.aggmoread.sdk.client.AMAdInterface;

/* loaded from: classes.dex */
public interface AMRewardAd extends AMAdInterface {
    void show(Activity activity, AMRewardInteractionListener aMRewardInteractionListener);

    void show(AMRewardInteractionListener aMRewardInteractionListener);
}
