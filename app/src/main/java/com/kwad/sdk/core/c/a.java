package com.kwad.sdk.core.c;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
final class a implements Application.ActivityLifecycleCallbacks {
    private final List<WeakReference<Activity>> azd;
    private WeakReference<Activity> currentActivity;
    private Application mApplication;
    private boolean mEnable;
    private boolean mIsInBackground;
    private final List<c> mListeners;

    /* renamed from: com.kwad.sdk.core.c.a$a */
    public static final class C0485a {
        static final a aze = new a((byte) 0);
    }

    public /* synthetic */ a(byte b10) {
        this();
    }

    public static a Fg() {
        return C0485a.aze;
    }

    private boolean Fh() {
        return b.Fj() || !this.mEnable;
    }

    private void h(Activity activity) {
        Iterator<WeakReference<Activity>> it = this.azd.iterator();
        while (it.hasNext()) {
            if (it.next().get() == activity) {
                return;
            }
        }
        this.azd.add(new WeakReference<>(activity));
    }

    private void i(Activity activity) {
        Activity activity2;
        if (activity == null) {
            return;
        }
        Iterator<WeakReference<Activity>> it = this.azd.iterator();
        while (it.hasNext()) {
            WeakReference<Activity> next = it.next();
            if (next != null && ((activity2 = next.get()) == activity || activity2 == null)) {
                it.remove();
            }
        }
    }

    public final void a(c cVar) {
        this.mListeners.add(cVar);
    }

    public final Activity getCurrentActivity() {
        WeakReference<Activity> weakReference = this.currentActivity;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public final void init(@NonNull Context context) {
        try {
            Application application = (Application) context;
            this.mApplication = application;
            application.registerActivityLifecycleCallbacks(this);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final boolean isAppOnForeground() {
        return !this.mIsInBackground;
    }

    public final boolean isEnable() {
        return this.mEnable;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        this.mEnable = true;
        if (Fh()) {
            return;
        }
        try {
            Iterator<c> it = this.mListeners.iterator();
            while (it.hasNext()) {
                it.next().a(activity, bundle);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        if (Fh()) {
            return;
        }
        try {
            Iterator<c> it = this.mListeners.iterator();
            while (it.hasNext()) {
                it.next().b(activity);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        if (Fh()) {
            return;
        }
        try {
            Iterator<c> it = this.mListeners.iterator();
            while (it.hasNext()) {
                it.next().c(activity);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        if (Fh()) {
            return;
        }
        try {
            this.currentActivity = new WeakReference<>(activity);
            Iterator<c> it = this.mListeners.iterator();
            while (it.hasNext()) {
                it.next().d(activity);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        if (Fh()) {
            return;
        }
        try {
            h(activity);
            if (this.azd.size() == 1) {
                this.mIsInBackground = false;
                Iterator<c> it = this.mListeners.iterator();
                while (it.hasNext()) {
                    it.next().onBackToForeground();
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        if (Fh()) {
            return;
        }
        try {
            i(activity);
            if (this.azd.size() == 0) {
                this.mIsInBackground = true;
                Iterator<c> it = this.mListeners.iterator();
                while (it.hasNext()) {
                    it.next().onBackToBackground();
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    private a() {
        this.mIsInBackground = true;
        this.mListeners = new CopyOnWriteArrayList();
        this.azd = new ArrayList();
        this.mEnable = false;
    }
}
