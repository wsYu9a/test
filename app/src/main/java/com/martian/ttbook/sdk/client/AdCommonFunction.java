package com.martian.ttbook.sdk.client;

/* loaded from: classes4.dex */
public interface AdCommonFunction {
    void sendLossNotification(AdBiddingLossReason adBiddingLossReason, int i2, String str);

    void sendWinNotification(int i2);

    void setAdDownloadConfirmListener(AdDownloadConfirmListener adDownloadConfirmListener);
}
