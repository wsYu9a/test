package com.baidu.mobads.sdk.api;

import android.view.View;
import java.util.List;

/* loaded from: classes.dex */
public interface EntryResponse {

    public interface EntryAdInteractionListener {
        void onADExposed();

        void onADExposureFailed(int i2);

        void onAdClick();

        void onAdUnionClick();
    }

    String getAdLogoUrl();

    String getBaiduLogoUrl();

    String getTitle();

    boolean isAdAvailable();

    void registerViewForInteraction(View view, List<View> list, List<View> list2, EntryAdInteractionListener entryAdInteractionListener);

    void unionLogoClick();
}
