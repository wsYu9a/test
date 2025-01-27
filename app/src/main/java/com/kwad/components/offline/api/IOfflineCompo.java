package com.kwad.components.offline.api;

import android.content.Context;
import com.kwad.components.offline.api.IOfflineCompoInitConfig;

/* loaded from: classes3.dex */
public interface IOfflineCompo<T extends IOfflineCompoInitConfig> {

    public interface Priority {
        public static final int HIGH = -100;
        public static final int HIGHEST = -200;
        public static final int LOW = 100;
        public static final int LOWEST = 200;
        public static final int NORMAL = 0;
    }

    Class getComponentsType();

    void init(Context context, T t10, InitCallBack initCallBack);

    int priority();
}
