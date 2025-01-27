package com.sn.catpie;

import android.app.Application;
import androidx.annotation.Keep;
import com.sntech.ads.SNAdConfig;

@Keep
/* loaded from: classes4.dex */
public interface IModule {
    @Keep
    Object getService(Class<?> cls);

    @Keep
    void onApplicationAttachBaseContext(Application application);

    @Keep
    void onApplicationCreate(Application application);

    @Keep
    void onApplicationLowMemory(Application application);

    @Keep
    void onLoad(Application application, SNAdConfig sNAdConfig);

    @Keep
    void onUnload(Application application);
}
