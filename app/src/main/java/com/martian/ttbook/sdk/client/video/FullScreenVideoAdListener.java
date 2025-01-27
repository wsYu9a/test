package com.martian.ttbook.sdk.client.video;

import com.martian.ttbook.sdk.client.AdCommonListener;
import com.martian.ttbook.sdk.client.AdError;

/* loaded from: classes4.dex */
public interface FullScreenVideoAdListener extends AdCommonListener {
    public static final FullScreenVideoAdListener EMPTY = new FullScreenVideoAdListener() { // from class: com.martian.ttbook.sdk.client.video.FullScreenVideoAdListener.1
        AnonymousClass1() {
        }

        @Override // com.martian.ttbook.sdk.client.video.FullScreenVideoAdListener
        public void onAdClicked() {
        }

        @Override // com.martian.ttbook.sdk.client.video.FullScreenVideoAdListener
        public void onAdDismissed() {
        }

        @Override // com.martian.ttbook.sdk.client.AdCommonListener
        public void onAdError(AdError adError) {
        }

        @Override // com.martian.ttbook.sdk.client.video.FullScreenVideoAdListener
        public void onAdExposure() {
        }

        @Override // com.martian.ttbook.sdk.client.video.FullScreenVideoAdListener
        public void onAdShow() {
        }

        @Override // com.martian.ttbook.sdk.client.video.FullScreenVideoAdListener
        public void onAdVideoCompleted() {
        }

        public String toString() {
            return "FullScreenVideoAdListener_Emtpy";
        }
    };

    /* renamed from: com.martian.ttbook.sdk.client.video.FullScreenVideoAdListener$1 */
    static class AnonymousClass1 implements FullScreenVideoAdListener {
        AnonymousClass1() {
        }

        @Override // com.martian.ttbook.sdk.client.video.FullScreenVideoAdListener
        public void onAdClicked() {
        }

        @Override // com.martian.ttbook.sdk.client.video.FullScreenVideoAdListener
        public void onAdDismissed() {
        }

        @Override // com.martian.ttbook.sdk.client.AdCommonListener
        public void onAdError(AdError adError) {
        }

        @Override // com.martian.ttbook.sdk.client.video.FullScreenVideoAdListener
        public void onAdExposure() {
        }

        @Override // com.martian.ttbook.sdk.client.video.FullScreenVideoAdListener
        public void onAdShow() {
        }

        @Override // com.martian.ttbook.sdk.client.video.FullScreenVideoAdListener
        public void onAdVideoCompleted() {
        }

        public String toString() {
            return "FullScreenVideoAdListener_Emtpy";
        }
    }

    void onAdClicked();

    void onAdDismissed();

    void onAdExposure();

    void onAdShow();

    void onAdVideoCompleted();
}
