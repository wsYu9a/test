package com.kwad.components.ad.splashscreen;

import java.lang.ref.WeakReference;
import java.util.HashMap;

/* loaded from: classes2.dex */
public final class SplashPlayModuleCache {
    private HashMap<String, WeakReference<com.kwad.components.ad.splashscreen.d.a>> DO;

    public enum Holder {
        INSTANCE;

        private SplashPlayModuleCache mInstance = new SplashPlayModuleCache((byte) 0);

        Holder() {
        }

        public final SplashPlayModuleCache getInstance() {
            return this.mInstance;
        }
    }

    public /* synthetic */ SplashPlayModuleCache(byte b10) {
        this();
    }

    private SplashPlayModuleCache() {
        this.DO = new HashMap<>(1);
    }
}
