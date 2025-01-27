package com.kwad.components.core.proxy;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes3.dex */
public final class b implements Application.ActivityLifecycleCallbacks {
    private k Td;
    private Set<c> Te = new HashSet();

    public b(k kVar) {
        this.Td = kVar;
    }

    private c b(Activity activity) {
        for (c cVar : this.Te) {
            if (cVar.c(activity)) {
                return cVar;
            }
        }
        return null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
        c b10 = b(activity);
        if (b10 != null) {
            b10.a(Lifecycle.Event.ON_CREATE);
            k kVar = this.Td;
            if (kVar != null) {
                kVar.a(b10);
            }
        }
        com.kwad.sdk.core.d.c.d("ActivityLifecycleAdapter", "onActivityCreated : " + activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(@NonNull Activity activity) {
        c b10 = b(activity);
        if (b10 != null) {
            k kVar = this.Td;
            if (kVar != null) {
                kVar.f(b10);
            }
            this.Te.remove(b10);
        }
        com.kwad.sdk.core.d.c.d("ActivityLifecycleAdapter", "onActivityDestroyed : " + activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(@NonNull Activity activity) {
        c b10 = b(activity);
        if (b10 != null) {
            b10.a(Lifecycle.Event.ON_PAUSE);
            k kVar = this.Td;
            if (kVar != null) {
                kVar.d(b10);
            }
        }
        com.kwad.sdk.core.d.c.d("ActivityLifecycleAdapter", "onActivityPaused : " + activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPreCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
        this.Te.add(new c(activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(@NonNull Activity activity) {
        c b10 = b(activity);
        if (b10 != null) {
            b10.a(Lifecycle.Event.ON_RESUME);
            k kVar = this.Td;
            if (kVar != null) {
                kVar.c(b10);
            }
        }
        com.kwad.sdk.core.d.c.d("ActivityLifecycleAdapter", "onActivityResumed : " + activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(@NonNull Activity activity) {
        c b10 = b(activity);
        if (b10 != null) {
            b10.a(Lifecycle.Event.ON_START);
            k kVar = this.Td;
            if (kVar != null) {
                kVar.b(b10);
            }
        }
        com.kwad.sdk.core.d.c.d("ActivityLifecycleAdapter", "onActivityStarted : " + activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(@NonNull Activity activity) {
        c b10 = b(activity);
        if (b10 != null) {
            b10.a(Lifecycle.Event.ON_STOP);
            k kVar = this.Td;
            if (kVar != null) {
                kVar.e(b10);
            }
        }
        com.kwad.sdk.core.d.c.d("ActivityLifecycleAdapter", "onActivityStopped : " + activity);
    }
}
