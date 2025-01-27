package com.kwad.components.offline.api.core.soloader;

/* loaded from: classes3.dex */
public interface SoLoadListener {
    void onFailed(int i10, Throwable th2);

    void onLoaded();

    void onPreUpdate();
}
