package com.martian.ttbook.sdk.client;

import com.martian.ttbook.sdk.client.data.AdDataListener;

/* loaded from: classes4.dex */
public abstract class NativeAdCallbackInterceptor implements NativeAdListener {
    private AdDataListener nativeAdListener;

    public NativeAdCallbackInterceptor(AdDataListener adDataListener) {
        this.nativeAdListener = adDataListener;
    }

    @Override // com.martian.ttbook.sdk.client.data.AdDataListener
    public void onADClicked() {
        onCallbackADClickedBefore();
        this.nativeAdListener.onADClicked();
    }

    @Override // com.martian.ttbook.sdk.client.data.AdDataListener
    public void onADExposed() {
        onCallbackADExposedBefore();
        this.nativeAdListener.onADExposed();
    }

    @Override // com.martian.ttbook.sdk.client.AdCommonListener
    public void onAdError(AdError adError) {
        this.nativeAdListener.onAdError(adError);
    }

    protected abstract void onCallbackADClickedBefore();

    protected abstract void onCallbackADExposedBefore();
}
