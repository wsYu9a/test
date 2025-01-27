package com.martian.ttbook.sdk.client.feedlist;

import b.d.e.a.j.c;
import com.martian.ttbook.sdk.client.AdCommonListener;
import com.martian.ttbook.sdk.client.AdError;
import com.martian.ttbook.sdk.client.NativeAdData;
import java.util.List;

/* loaded from: classes4.dex */
public interface FeedListNativeAdListener extends AdCommonListener {
    public static final FeedListNativeAdListener EMPTY = new FeedListNativeAdListener() { // from class: com.martian.ttbook.sdk.client.feedlist.FeedListNativeAdListener.1
        static final String TAG = "FeedListNativeAdEmptyListener";

        AnonymousClass1() {
        }

        @Override // com.martian.ttbook.sdk.client.AdCommonListener
        public void onAdError(AdError adError) {
            StringBuilder sb = new StringBuilder();
            sb.append("onAdError = ");
            sb.append(adError != null ? adError.toString() : "empty");
            c.h(TAG, sb.toString());
        }

        @Override // com.martian.ttbook.sdk.client.feedlist.FeedListNativeAdListener
        public void onAdLoaded(List<NativeAdData> list) {
            c.h(TAG, "onAdLoaded enter");
        }

        public String toString() {
            return TAG;
        }
    };

    /* renamed from: com.martian.ttbook.sdk.client.feedlist.FeedListNativeAdListener$1 */
    static class AnonymousClass1 implements FeedListNativeAdListener {
        static final String TAG = "FeedListNativeAdEmptyListener";

        AnonymousClass1() {
        }

        @Override // com.martian.ttbook.sdk.client.AdCommonListener
        public void onAdError(AdError adError) {
            StringBuilder sb = new StringBuilder();
            sb.append("onAdError = ");
            sb.append(adError != null ? adError.toString() : "empty");
            c.h(TAG, sb.toString());
        }

        @Override // com.martian.ttbook.sdk.client.feedlist.FeedListNativeAdListener
        public void onAdLoaded(List<NativeAdData> list) {
            c.h(TAG, "onAdLoaded enter");
        }

        public String toString() {
            return TAG;
        }
    }

    void onAdLoaded(List<NativeAdData> list);
}
