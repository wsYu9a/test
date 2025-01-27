package com.bytedance.sdk.openadsdk.j;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* loaded from: classes.dex */
class j implements Application.ActivityLifecycleCallbacks {

    /* renamed from: j, reason: collision with root package name */
    private static volatile boolean f6471j;

    /* renamed from: i, reason: collision with root package name */
    private InterfaceC0079j f6472i;
    private int zx = 0;

    /* renamed from: com.bytedance.sdk.openadsdk.j.j$j, reason: collision with other inner class name */
    public interface InterfaceC0079j {
        void j();

        void zx();
    }

    j() {
    }

    public Boolean j() {
        return Boolean.valueOf(f6471j);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        this.zx++;
        f6471j = false;
        InterfaceC0079j interfaceC0079j = this.f6472i;
        if (interfaceC0079j != null) {
            interfaceC0079j.zx();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        int i2 = this.zx - 1;
        this.zx = i2;
        if (i2 == 0) {
            f6471j = true;
            InterfaceC0079j interfaceC0079j = this.f6472i;
            if (interfaceC0079j != null) {
                interfaceC0079j.j();
            }
        }
    }

    public void j(InterfaceC0079j interfaceC0079j) {
        this.f6472i = interfaceC0079j;
    }
}
