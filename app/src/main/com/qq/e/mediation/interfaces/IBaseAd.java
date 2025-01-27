package com.qq.e.mediation.interfaces;

import java.util.Map;

@Deprecated
/* loaded from: classes3.dex */
public interface IBaseAd {
    int getECPM();

    Map<String, Object> getExtraInfo();

    String getReqId();

    void sendLossNotification(int i10, int i11, String str);

    void sendWinNotification(int i10);

    void setBidECPM(int i10);

    void setPayload(String str);
}
