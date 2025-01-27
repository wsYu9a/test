package com.martian.ttbook.sdk.client.data;

import com.martian.ttbook.sdk.client.AdCommonListener;
import com.martian.ttbook.sdk.client.AdError;

/* loaded from: classes4.dex */
public interface AdDataListener extends AdCommonListener {
    public static final AdDataListener EMPTY = new AdDataListener() { // from class: com.martian.ttbook.sdk.client.data.AdDataListener.1
        AnonymousClass1() {
        }

        @Override // com.martian.ttbook.sdk.client.data.AdDataListener
        public void onADClicked() {
        }

        @Override // com.martian.ttbook.sdk.client.data.AdDataListener
        public void onADExposed() {
        }

        @Override // com.martian.ttbook.sdk.client.AdCommonListener
        public void onAdError(AdError adError) {
        }
    };

    /* renamed from: com.martian.ttbook.sdk.client.data.AdDataListener$1 */
    static class AnonymousClass1 implements AdDataListener {
        AnonymousClass1() {
        }

        @Override // com.martian.ttbook.sdk.client.data.AdDataListener
        public void onADClicked() {
        }

        @Override // com.martian.ttbook.sdk.client.data.AdDataListener
        public void onADExposed() {
        }

        @Override // com.martian.ttbook.sdk.client.AdCommonListener
        public void onAdError(AdError adError) {
        }
    }

    void onADClicked();

    void onADExposed();
}
