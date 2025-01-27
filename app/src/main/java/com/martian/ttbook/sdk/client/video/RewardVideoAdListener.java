package com.martian.ttbook.sdk.client.video;

import b.d.e.a.j.c;
import com.martian.ttbook.sdk.client.AdCommonListener;
import com.martian.ttbook.sdk.client.AdError;

/* loaded from: classes4.dex */
public interface RewardVideoAdListener extends AdCommonListener {
    public static final RewardVideoAdListener EMPTY = new RewardVideoAdListener() { // from class: com.martian.ttbook.sdk.client.video.RewardVideoAdListener.1
        static final String TAG = "RewardVideoAdEmptyListener";

        AnonymousClass1() {
        }

        @Override // com.martian.ttbook.sdk.client.video.RewardVideoAdListener
        public void onAdClicked() {
            c.h(TAG, "onAdClicked enter");
        }

        @Override // com.martian.ttbook.sdk.client.video.RewardVideoAdListener
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

        @Override // com.martian.ttbook.sdk.client.video.RewardVideoAdListener
        public void onAdExposure() {
            c.h(TAG, "onAdExposure enter");
        }

        @Override // com.martian.ttbook.sdk.client.video.RewardVideoAdListener
        public void onAdShow() {
            c.h(TAG, "onAdShow enter");
        }

        @Override // com.martian.ttbook.sdk.client.video.RewardVideoAdListener
        public void onAdVideoCompleted() {
            c.h(TAG, "onAdVideoCompleted enter");
        }

        @Override // com.martian.ttbook.sdk.client.video.RewardVideoAdListener
        public void onReward() {
            c.h(TAG, "onReward enter");
        }
    };

    /* renamed from: com.martian.ttbook.sdk.client.video.RewardVideoAdListener$1 */
    static class AnonymousClass1 implements RewardVideoAdListener {
        static final String TAG = "RewardVideoAdEmptyListener";

        AnonymousClass1() {
        }

        @Override // com.martian.ttbook.sdk.client.video.RewardVideoAdListener
        public void onAdClicked() {
            c.h(TAG, "onAdClicked enter");
        }

        @Override // com.martian.ttbook.sdk.client.video.RewardVideoAdListener
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

        @Override // com.martian.ttbook.sdk.client.video.RewardVideoAdListener
        public void onAdExposure() {
            c.h(TAG, "onAdExposure enter");
        }

        @Override // com.martian.ttbook.sdk.client.video.RewardVideoAdListener
        public void onAdShow() {
            c.h(TAG, "onAdShow enter");
        }

        @Override // com.martian.ttbook.sdk.client.video.RewardVideoAdListener
        public void onAdVideoCompleted() {
            c.h(TAG, "onAdVideoCompleted enter");
        }

        @Override // com.martian.ttbook.sdk.client.video.RewardVideoAdListener
        public void onReward() {
            c.h(TAG, "onReward enter");
        }
    }

    void onAdClicked();

    void onAdDismissed();

    void onAdExposure();

    void onAdShow();

    void onAdVideoCompleted();

    void onReward();
}
