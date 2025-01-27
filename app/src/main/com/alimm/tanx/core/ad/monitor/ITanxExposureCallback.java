package com.alimm.tanx.core.ad.monitor;

import java.util.Map;

/* loaded from: classes.dex */
public interface ITanxExposureCallback {
    void exposure();

    void exposureTime(long j10);

    void onMonitor(Map<String, Object> map);
}
