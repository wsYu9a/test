package com.heytap.msp.mobad.api.listener;

/* loaded from: classes.dex */
public interface IBaseAdListener {
    void onAdClick();

    void onAdFailed(int i2, String str);

    @Deprecated
    void onAdFailed(String str);

    void onAdShow();
}
