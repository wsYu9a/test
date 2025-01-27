package com.martian.ttbook.sdk.client.interstitial;

import b.d.e.a.j.c;
import com.martian.ttbook.sdk.client.AdController;
import com.martian.ttbook.sdk.client.AdError;

/* loaded from: classes4.dex */
public interface InterstitialAdExtListener extends InterstitialAdListener {
    public static final InterstitialAdExtListener EMPTY = new InterstitialAdExtListener() { // from class: com.martian.ttbook.sdk.client.interstitial.InterstitialAdExtListener.1
        static final String TAG = "InterstitialAdExtEmptyListener";

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

        @Override // com.martian.ttbook.sdk.client.interstitial.InterstitialAdExtListener
        public void onAdLoaded(AdController adController) {
            c.h(TAG, "onAdLoaed enter");
        }

        @Override // com.martian.ttbook.sdk.client.interstitial.InterstitialAdListener
        public void onAdShow() {
            c.h(TAG, "onAdShow enter");
        }
    };

    /* renamed from: com.martian.ttbook.sdk.client.interstitial.InterstitialAdExtListener$1 */
    static class AnonymousClass1 implements InterstitialAdExtListener {
        static final String TAG = "InterstitialAdExtEmptyListener";

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

        @Override // com.martian.ttbook.sdk.client.interstitial.InterstitialAdExtListener
        public void onAdLoaded(AdController adController) {
            c.h(TAG, "onAdLoaed enter");
        }

        @Override // com.martian.ttbook.sdk.client.interstitial.InterstitialAdListener
        public void onAdShow() {
            c.h(TAG, "onAdShow enter");
        }
    }

    void onAdLoaded(AdController adController);
}
