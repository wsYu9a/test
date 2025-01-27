package com.kwad.components.core.proxy.launchdialog;

import androidx.lifecycle.Lifecycle;

/* loaded from: classes3.dex */
public final class c {
    private final Lifecycle.Event TA;
    private final long TB = System.currentTimeMillis();

    public c(Lifecycle.Event event) {
        this.TA = event;
    }

    public final Lifecycle.Event re() {
        return this.TA;
    }

    public final long rf() {
        return this.TB;
    }

    public final String toString() {
        return "LifecycleStamp{mEvent=" + this.TA + ", mEventTimestamp=" + this.TB + '}';
    }
}
