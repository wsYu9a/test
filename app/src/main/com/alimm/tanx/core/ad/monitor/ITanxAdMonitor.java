package com.alimm.tanx.core.ad.monitor;

/* loaded from: classes.dex */
public interface ITanxAdMonitor {
    void onAttachedToWindow();

    void onDetachedFromWindow();

    void onVisibilityAggregated(boolean z10);

    void onWindowFocusChanged(boolean z10);
}
