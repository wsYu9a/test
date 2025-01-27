package com.bytedance.sdk.openadsdk;

/* loaded from: classes2.dex */
public interface TTClientBidding {
    void loss(Double d10, String str, String str2);

    void setAdInteractionListener(TTAdInteractionListener tTAdInteractionListener);

    void setPrice(Double d10);

    void win(Double d10);
}
