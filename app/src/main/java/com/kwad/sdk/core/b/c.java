package com.kwad.sdk.core.b;

import android.os.Bundle;

/* loaded from: classes2.dex */
public interface c<T> {
    void onActivityCreated(T t, Bundle bundle);

    void onActivityDestroyed(T t);

    void onActivityPaused(T t);

    void onActivityResumed(T t);

    void onBackToBackground();

    void onBackToForeground();
}
