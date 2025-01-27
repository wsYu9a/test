package com.martian.ttbook.sdk.client;

import android.app.Activity;
import android.view.ViewGroup;

/* loaded from: classes4.dex */
public interface AdController extends AdCommonFunction {
    public static final AdController EMPTY = new AdController() { // from class: com.martian.ttbook.sdk.client.AdController.1
        AnonymousClass1() {
        }

        @Override // com.martian.ttbook.sdk.client.AdController
        public AdExtras getAdExtras() {
            return AdExtras.EMPTY;
        }

        @Override // com.martian.ttbook.sdk.client.AdCommonFunction
        public void sendLossNotification(AdBiddingLossReason adBiddingLossReason, int i2, String str) {
        }

        @Override // com.martian.ttbook.sdk.client.AdCommonFunction
        public void sendWinNotification(int i2) {
        }

        @Override // com.martian.ttbook.sdk.client.AdCommonFunction
        public void setAdDownloadConfirmListener(AdDownloadConfirmListener adDownloadConfirmListener) {
        }

        @Override // com.martian.ttbook.sdk.client.AdController
        public boolean show() {
            return false;
        }

        @Override // com.martian.ttbook.sdk.client.AdController
        public boolean show(Activity activity) {
            return false;
        }

        @Override // com.martian.ttbook.sdk.client.AdController
        public boolean show(ViewGroup viewGroup) {
            return false;
        }
    };

    /* renamed from: com.martian.ttbook.sdk.client.AdController$1 */
    static class AnonymousClass1 implements AdController {
        AnonymousClass1() {
        }

        @Override // com.martian.ttbook.sdk.client.AdController
        public AdExtras getAdExtras() {
            return AdExtras.EMPTY;
        }

        @Override // com.martian.ttbook.sdk.client.AdCommonFunction
        public void sendLossNotification(AdBiddingLossReason adBiddingLossReason, int i2, String str) {
        }

        @Override // com.martian.ttbook.sdk.client.AdCommonFunction
        public void sendWinNotification(int i2) {
        }

        @Override // com.martian.ttbook.sdk.client.AdCommonFunction
        public void setAdDownloadConfirmListener(AdDownloadConfirmListener adDownloadConfirmListener) {
        }

        @Override // com.martian.ttbook.sdk.client.AdController
        public boolean show() {
            return false;
        }

        @Override // com.martian.ttbook.sdk.client.AdController
        public boolean show(Activity activity) {
            return false;
        }

        @Override // com.martian.ttbook.sdk.client.AdController
        public boolean show(ViewGroup viewGroup) {
            return false;
        }
    }

    AdExtras getAdExtras();

    boolean show();

    boolean show(Activity activity);

    boolean show(ViewGroup viewGroup);
}
