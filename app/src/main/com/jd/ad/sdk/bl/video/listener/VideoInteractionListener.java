package com.jd.ad.sdk.bl.video.listener;

import android.view.View;

/* loaded from: classes2.dex */
public interface VideoInteractionListener {
    void onAdClicked(int i10, int i11);

    void onAdCountdown(int i10);

    void onAdSkip(View view);

    void onAdTimeOver();

    void onVideoAnimationEnd();
}
