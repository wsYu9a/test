package com.aggmoread.sdk.client.feedlist;

import com.aggmoread.sdk.client.IAMAdInteractionListener;

/* loaded from: classes.dex */
public interface AMNativeInteractionListener extends IAMAdInteractionListener {
    void onADStatusChanged(int i10);

    void onAdClicked();

    void onAdExposed();

    void onLoadApkProgress(int i10);
}
