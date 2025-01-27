package com.martian.ttbook.sdk.client.video;

import android.app.Activity;
import android.view.View;
import com.martian.ttbook.sdk.client.AdController;

/* loaded from: classes4.dex */
public interface RewardVideoAdListener2 extends RewardVideoAdListener {
    View getSkipView(Activity activity);

    void onAdLoaded(AdController adController);
}
