package com.kwad.sdk.api.proxy;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.Keep;

@Keep
/* loaded from: classes3.dex */
public interface KSLifecycleListener {
    @Keep
    void onActivityCreated(Activity activity, Bundle bundle);

    @Keep
    void onActivityDestroyed(Activity activity);

    @Keep
    void onActivityPaused(Activity activity);

    @Keep
    void onActivityResumed(Activity activity);

    @Keep
    void onBackToBackground();

    @Keep
    void onBackToForeground();
}
