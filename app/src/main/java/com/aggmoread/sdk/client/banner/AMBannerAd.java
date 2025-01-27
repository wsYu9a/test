package com.aggmoread.sdk.client.banner;

import android.view.ViewGroup;
import com.aggmoread.sdk.client.AMAdInterface;

/* loaded from: classes.dex */
public interface AMBannerAd extends AMAdInterface {
    void show(AMBannerAdInteractionListener aMBannerAdInteractionListener);

    void showInContainer(ViewGroup viewGroup, AMBannerAdInteractionListener aMBannerAdInteractionListener);
}
