package com.martian.ttbook.sdk.client.feedlist;

import b.d.e.a.j.c;
import com.martian.ttbook.sdk.client.AdCommonListener;
import com.martian.ttbook.sdk.client.AdError;
import java.util.List;

/* loaded from: classes4.dex */
public interface FeedListAdListener extends AdCommonListener {
    public static final FeedListAdListener EMPTY = new FeedListAdListener() { // from class: com.martian.ttbook.sdk.client.feedlist.FeedListAdListener.1
        static final String TAG = "FeedListAdEmptyListener";

        AnonymousClass1() {
        }

        @Override // com.martian.ttbook.sdk.client.feedlist.FeedListAdListener
        public void onADExposed(AdView adView) {
            c.h(TAG, "onADExposed enter");
        }

        @Override // com.martian.ttbook.sdk.client.feedlist.FeedListAdListener
        public void onAdClicked(AdView adView) {
            c.h(TAG, "onAdClicked enter");
        }

        @Override // com.martian.ttbook.sdk.client.feedlist.FeedListAdListener
        public void onAdDismissed(AdView adView) {
            c.h(TAG, "onAdDismissed enter");
        }

        @Override // com.martian.ttbook.sdk.client.AdCommonListener
        public void onAdError(AdError adError) {
            StringBuilder sb = new StringBuilder();
            sb.append("onAdError = ");
            sb.append(adError != null ? adError.toString() : "empty");
            c.h(TAG, sb.toString());
        }

        @Override // com.martian.ttbook.sdk.client.feedlist.FeedListAdListener
        public void onAdLoaded(List<AdView> list) {
            c.h(TAG, "onAdLoaded enter");
        }

        @Override // com.martian.ttbook.sdk.client.feedlist.FeedListAdListener
        public void onVideoLoad() {
            c.h(TAG, "onVideoLoad enter");
        }

        @Override // com.martian.ttbook.sdk.client.feedlist.FeedListAdListener
        public void onVideoPause() {
            c.h(TAG, "onVideoPause enter");
        }

        @Override // com.martian.ttbook.sdk.client.feedlist.FeedListAdListener
        public void onVideoStart() {
            c.h(TAG, "onVideoStart enter");
        }
    };

    /* renamed from: com.martian.ttbook.sdk.client.feedlist.FeedListAdListener$1 */
    static class AnonymousClass1 implements FeedListAdListener {
        static final String TAG = "FeedListAdEmptyListener";

        AnonymousClass1() {
        }

        @Override // com.martian.ttbook.sdk.client.feedlist.FeedListAdListener
        public void onADExposed(AdView adView) {
            c.h(TAG, "onADExposed enter");
        }

        @Override // com.martian.ttbook.sdk.client.feedlist.FeedListAdListener
        public void onAdClicked(AdView adView) {
            c.h(TAG, "onAdClicked enter");
        }

        @Override // com.martian.ttbook.sdk.client.feedlist.FeedListAdListener
        public void onAdDismissed(AdView adView) {
            c.h(TAG, "onAdDismissed enter");
        }

        @Override // com.martian.ttbook.sdk.client.AdCommonListener
        public void onAdError(AdError adError) {
            StringBuilder sb = new StringBuilder();
            sb.append("onAdError = ");
            sb.append(adError != null ? adError.toString() : "empty");
            c.h(TAG, sb.toString());
        }

        @Override // com.martian.ttbook.sdk.client.feedlist.FeedListAdListener
        public void onAdLoaded(List<AdView> list) {
            c.h(TAG, "onAdLoaded enter");
        }

        @Override // com.martian.ttbook.sdk.client.feedlist.FeedListAdListener
        public void onVideoLoad() {
            c.h(TAG, "onVideoLoad enter");
        }

        @Override // com.martian.ttbook.sdk.client.feedlist.FeedListAdListener
        public void onVideoPause() {
            c.h(TAG, "onVideoPause enter");
        }

        @Override // com.martian.ttbook.sdk.client.feedlist.FeedListAdListener
        public void onVideoStart() {
            c.h(TAG, "onVideoStart enter");
        }
    }

    void onADExposed(AdView adView);

    void onAdClicked(AdView adView);

    void onAdDismissed(AdView adView);

    void onAdLoaded(List<AdView> list);

    void onVideoLoad();

    void onVideoPause();

    void onVideoStart();
}
