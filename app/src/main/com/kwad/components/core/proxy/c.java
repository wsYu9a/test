package com.kwad.components.core.proxy;

import android.app.Activity;
import androidx.lifecycle.Lifecycle;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public final class c implements a {
    private final WeakReference<Activity> Tf;
    private com.kwad.components.core.proxy.launchdialog.c Tg;
    private com.kwad.components.core.proxy.launchdialog.c Th;

    public c(Activity activity) {
        this.Tf = new WeakReference<>(activity);
    }

    public final void a(Lifecycle.Event event) {
        this.Tg = this.Th;
        this.Th = new com.kwad.components.core.proxy.launchdialog.c(event);
    }

    public final boolean c(Activity activity) {
        WeakReference<Activity> weakReference;
        if (activity == null || (weakReference = this.Tf) == null || weakReference.get() == null) {
            return false;
        }
        return this.Tf.get().equals(activity);
    }

    @Override // com.kwad.components.core.proxy.a
    public final String getPageName() {
        WeakReference<Activity> weakReference = this.Tf;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return this.Tf.get().toString();
    }

    @Override // com.kwad.components.core.proxy.a
    public final com.kwad.components.core.proxy.launchdialog.c qX() {
        return this.Tg;
    }

    @Override // com.kwad.components.core.proxy.a
    public final com.kwad.components.core.proxy.launchdialog.c qY() {
        return this.Th;
    }
}
