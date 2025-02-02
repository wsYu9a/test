package com.kwad.components.offline.api.core.api;

import android.app.Activity;

/* loaded from: classes3.dex */
public interface ILifeCycle {
    Activity getCurrentActivity();

    boolean isAppOnForeground();

    int registerLifeCycleListener(ILifeCycleListener iLifeCycleListener);

    void unregisterLifeCycleListener(int i10);
}
