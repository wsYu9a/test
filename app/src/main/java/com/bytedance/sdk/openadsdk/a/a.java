package com.bytedance.sdk.openadsdk.a;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* loaded from: classes2.dex */
class a implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a, reason: collision with root package name */
    private static volatile boolean f7964a = false;

    /* renamed from: b, reason: collision with root package name */
    private int f7965b = 0;

    /* renamed from: c, reason: collision with root package name */
    private InterfaceC0236a f7966c;

    /* renamed from: com.bytedance.sdk.openadsdk.a.a$a, reason: collision with other inner class name */
    public interface InterfaceC0236a {
        void a();

        void b();
    }

    public Boolean a() {
        return Boolean.valueOf(f7964a);
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
        this.f7965b++;
        f7964a = false;
        InterfaceC0236a interfaceC0236a = this.f7966c;
        if (interfaceC0236a != null) {
            interfaceC0236a.b();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        int i10 = this.f7965b - 1;
        this.f7965b = i10;
        if (i10 == 0) {
            f7964a = true;
            InterfaceC0236a interfaceC0236a = this.f7966c;
            if (interfaceC0236a != null) {
                interfaceC0236a.a();
            }
        }
    }

    public void a(InterfaceC0236a interfaceC0236a) {
        this.f7966c = interfaceC0236a;
    }
}
