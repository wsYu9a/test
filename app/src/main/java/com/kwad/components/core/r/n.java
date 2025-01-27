package com.kwad.components.core.r;

import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public final class n implements Runnable {
    private WeakReference<Runnable> weakReference;

    public n(Runnable runnable) {
        this.weakReference = new WeakReference<>(runnable);
    }

    @Override // java.lang.Runnable
    public final void run() {
        Runnable runnable = this.weakReference.get();
        if (runnable != null) {
            runnable.run();
        }
    }
}
