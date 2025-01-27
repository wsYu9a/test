package com.sigmob.windad.natives;

import com.sigmob.windad.WindAdError;

/* loaded from: classes4.dex */
public interface NativeADEventListener {
    void onAdClicked();

    void onAdDetailDismiss();

    void onAdDetailShow();

    void onAdError(WindAdError windAdError);

    void onAdExposed();
}
