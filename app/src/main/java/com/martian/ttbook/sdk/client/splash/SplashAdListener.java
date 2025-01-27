package com.martian.ttbook.sdk.client.splash;

import b.d.e.a.j.c;
import com.martian.ttbook.sdk.client.AdCommonListener;
import com.martian.ttbook.sdk.client.AdError;

/* loaded from: classes4.dex */
public interface SplashAdListener extends AdCommonListener {
    public static final SplashAdListener EMPTY = new SplashAdListener() { // from class: com.martian.ttbook.sdk.client.splash.SplashAdListener.1
        static final String TAG = "SplashAdEmptyListener";

        AnonymousClass1() {
        }

        @Override // com.martian.ttbook.sdk.client.splash.SplashAdListener
        public void onAdClicked() {
            c.h(TAG, "onAdClicked enter");
        }

        @Override // com.martian.ttbook.sdk.client.splash.SplashAdListener
        public void onAdDismissed() {
            c.h(TAG, "onAdDismissed enter");
        }

        @Override // com.martian.ttbook.sdk.client.splash.SplashAdListener, com.martian.ttbook.sdk.client.AdCommonListener
        public void onAdError(AdError adError) {
            StringBuilder sb = new StringBuilder();
            sb.append("onAdError = ");
            sb.append(adError != null ? adError.toString() : "empty");
            c.h(TAG, sb.toString());
        }

        @Override // com.martian.ttbook.sdk.client.splash.SplashAdListener
        public void onAdExposure() {
            c.h(TAG, "onAdExposure enter");
        }

        @Override // com.martian.ttbook.sdk.client.splash.SplashAdListener
        public void onAdShow() {
            c.h(TAG, "onAdShow enter");
        }
    };

    /* renamed from: com.martian.ttbook.sdk.client.splash.SplashAdListener$1 */
    static class AnonymousClass1 implements SplashAdListener {
        static final String TAG = "SplashAdEmptyListener";

        AnonymousClass1() {
        }

        @Override // com.martian.ttbook.sdk.client.splash.SplashAdListener
        public void onAdClicked() {
            c.h(TAG, "onAdClicked enter");
        }

        @Override // com.martian.ttbook.sdk.client.splash.SplashAdListener
        public void onAdDismissed() {
            c.h(TAG, "onAdDismissed enter");
        }

        @Override // com.martian.ttbook.sdk.client.splash.SplashAdListener, com.martian.ttbook.sdk.client.AdCommonListener
        public void onAdError(AdError adError) {
            StringBuilder sb = new StringBuilder();
            sb.append("onAdError = ");
            sb.append(adError != null ? adError.toString() : "empty");
            c.h(TAG, sb.toString());
        }

        @Override // com.martian.ttbook.sdk.client.splash.SplashAdListener
        public void onAdExposure() {
            c.h(TAG, "onAdExposure enter");
        }

        @Override // com.martian.ttbook.sdk.client.splash.SplashAdListener
        public void onAdShow() {
            c.h(TAG, "onAdShow enter");
        }
    }

    void onAdClicked();

    void onAdDismissed();

    @Override // com.martian.ttbook.sdk.client.AdCommonListener
    void onAdError(AdError adError);

    void onAdExposure();

    @Deprecated
    void onAdShow();
}
