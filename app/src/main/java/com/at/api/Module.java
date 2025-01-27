package com.at.api;

import android.app.Application;
import androidx.annotation.Keep;
import com.at.sdk.AdConfigWrapper;

@Keep
/* loaded from: classes.dex */
public interface Module {
    @Keep
    Object getService(Class<?> cls);

    @Keep
    void onApplicationAttachBaseContext(Application application);

    @Keep
    void onApplicationCreate(Application application);

    @Keep
    void onApplicationLowMemory(Application application);

    @Keep
    void onLoad(Application application, AdConfigWrapper adConfigWrapper);

    @Keep
    void onUnload(Application application);
}
