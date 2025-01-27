package com.martian.ttbook.sdk.client.interstitial;

import b.d.e.a.j.c;
import com.martian.ttbook.sdk.client.AdCommonListener;
import com.martian.ttbook.sdk.client.AdError;

/* loaded from: classes4.dex */
public interface InterstitialAdListener extends AdCommonListener {
    public static final InterstitialAdListener EMPTY = new InterstitialAdListener() { // from class: com.martian.ttbook.sdk.client.interstitial.InterstitialAdListener.1
        static final String TAG = "InterstitialAdEmptyListener";

        AnonymousClass1() {
        }

        @Override // com.martian.ttbook.sdk.client.interstitial.InterstitialAdListener
        public void onAdClicked() {
            c.h(TAG, "onAdClicked enter");
        }

        @Override // com.martian.ttbook.sdk.client.interstitial.InterstitialAdListener
        public void onAdDismissed() {
            c.h(TAG, "onAdDismissed enter");
        }

        @Override // com.martian.ttbook.sdk.client.AdCommonListener
        public void onAdError(AdError adError) {
            StringBuilder sb = new StringBuilder();
            sb.append("onAdError = ");
            sb.append(adError != null ? adError.toString() : "empty");
            c.h(TAG, sb.toString());
        }

        @Override // com.martian.ttbook.sdk.client.interstitial.InterstitialAdListener
        public void onAdExposure() {
            c.h(TAG, "onAdExposure enter");
        }

        @Override // com.martian.ttbook.sdk.client.interstitial.InterstitialAdListener
        public void onAdShow() {
            c.h(TAG, "onAdShow enter");
        }
    };

    /* renamed from: com.martian.ttbook.sdk.client.interstitial.InterstitialAdListener$1 */
    static class AnonymousClass1 implements InterstitialAdListener {
        static final String TAG = "InterstitialAdEmptyListener";

        AnonymousClass1() {
        }

        @Override // com.martian.ttbook.sdk.client.interstitial.InterstitialAdListener
        public void onAdClicked() {
            c.h(TAG, "onAdClicked enter");
        }

        @Override // com.martian.ttbook.sdk.client.interstitial.InterstitialAdListener
        public void onAdDismissed() {
            c.h(TAG, "onAdDismissed enter");
        }

        @Override // com.martian.ttbook.sdk.client.AdCommonListener
        public void onAdError(AdError adError) {
            StringBuilder sb = new StringBuilder();
            sb.append("onAdError = ");
            sb.append(adError != null ? adError.toString() : "empty");
            c.h(TAG, sb.toString());
        }

        @Override // com.martian.ttbook.sdk.client.interstitial.InterstitialAdListener
        public void onAdExposure() {
            c.h(TAG, "onAdExposure enter");
        }

        @Override // com.martian.ttbook.sdk.client.interstitial.InterstitialAdListener
        public void onAdShow() {
            c.h(TAG, "onAdShow enter");
        }
    }

    void onAdClicked();

    void onAdDismissed();

    void onAdExposure();

    void onAdShow();
}
