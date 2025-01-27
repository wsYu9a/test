package com.jd.ad.sdk.bl.exposuremonitor;

/* loaded from: classes2.dex */
public interface JADExposureListener {
    void onDelayExposure(long j10, String str, int i10);

    void onExposure(String str);

    void onFinishExposure();

    void onPreExposure(String str);
}
