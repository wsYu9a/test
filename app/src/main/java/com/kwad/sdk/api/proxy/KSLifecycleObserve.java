package com.kwad.sdk.api.proxy;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public class KSLifecycleObserve {
    private static final String TAG = "KSLifecycleObserve";
    private static KSLifecycleObserve sKSLifecycleObserve;
    private WeakReference<Activity> currentActivity;
    private Application mApplication;
    private boolean mIsInBackground = true;
    private int startedActivityCount = 0;
    private final List<KSLifecycleListener> mListeners = new CopyOnWriteArrayList();
    private boolean mHasInit = false;

    /* renamed from: com.kwad.sdk.api.proxy.KSLifecycleObserve$1 */
    class AnonymousClass1 implements Application.ActivityLifecycleCallbacks {
        AnonymousClass1() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
            try {
                Iterator it = KSLifecycleObserve.this.mListeners.iterator();
                while (it.hasNext()) {
                    ((KSLifecycleListener) it.next()).onActivityCreated(activity, bundle);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(@NonNull Activity activity) {
            try {
                Iterator it = KSLifecycleObserve.this.mListeners.iterator();
                while (it.hasNext()) {
                    ((KSLifecycleListener) it.next()).onActivityDestroyed(activity);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(@NonNull Activity activity) {
            try {
                if (KSLifecycleObserve.this.currentActivity != null && KSLifecycleObserve.this.currentActivity.get() != null && ((Activity) KSLifecycleObserve.this.currentActivity.get()).equals(activity)) {
                    KSLifecycleObserve.this.currentActivity = null;
                }
                Iterator it = KSLifecycleObserve.this.mListeners.iterator();
                while (it.hasNext()) {
                    ((KSLifecycleListener) it.next()).onActivityPaused(activity);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(@NonNull Activity activity) {
            try {
                KSLifecycleObserve.this.currentActivity = new WeakReference(activity);
                Iterator it = KSLifecycleObserve.this.mListeners.iterator();
                while (it.hasNext()) {
                    ((KSLifecycleListener) it.next()).onActivityResumed(activity);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(@NonNull Activity activity) {
            try {
                KSLifecycleObserve.access$108(KSLifecycleObserve.this);
                if (KSLifecycleObserve.this.startedActivityCount == 1) {
                    KSLifecycleObserve.this.onAppBackToForeground();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(@NonNull Activity activity) {
            try {
                KSLifecycleObserve.access$110(KSLifecycleObserve.this);
                if (KSLifecycleObserve.this.startedActivityCount == 0) {
                    KSLifecycleObserve.this.onAppGoToBackground();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private KSLifecycleObserve() {
    }

    static /* synthetic */ int access$108(KSLifecycleObserve kSLifecycleObserve) {
        int i2 = kSLifecycleObserve.startedActivityCount;
        kSLifecycleObserve.startedActivityCount = i2 + 1;
        return i2;
    }

    static /* synthetic */ int access$110(KSLifecycleObserve kSLifecycleObserve) {
        int i2 = kSLifecycleObserve.startedActivityCount;
        kSLifecycleObserve.startedActivityCount = i2 - 1;
        return i2;
    }

    public static KSLifecycleObserve getInstance() {
        if (sKSLifecycleObserve == null) {
            synchronized (KSLifecycleObserve.class) {
                if (sKSLifecycleObserve == null) {
                    sKSLifecycleObserve = new KSLifecycleObserve();
                }
            }
        }
        return sKSLifecycleObserve;
    }

    public void onAppBackToForeground() {
        try {
            Log.i(TAG, "App switch to foreground");
            this.mIsInBackground = false;
            Iterator<KSLifecycleListener> it = this.mListeners.iterator();
            while (it.hasNext()) {
                it.next().onBackToForeground();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onAppGoToBackground() {
        try {
            Log.i(TAG, "App switch to background");
            this.mIsInBackground = true;
            Iterator<KSLifecycleListener> it = this.mListeners.iterator();
            while (it.hasNext()) {
                it.next().onBackToBackground();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Keep
    public Application getApplication() {
        return this.mApplication;
    }

    @Keep
    public Activity getCurrentActivity() {
        WeakReference<Activity> weakReference = this.currentActivity;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public void init(@NonNull Context context) {
        try {
            if ((context instanceof Application) && !this.mHasInit) {
                this.mHasInit = true;
                Application application = (Application) context;
                this.mApplication = application;
                application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.kwad.sdk.api.proxy.KSLifecycleObserve.1
                    AnonymousClass1() {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
                        try {
                            Iterator it = KSLifecycleObserve.this.mListeners.iterator();
                            while (it.hasNext()) {
                                ((KSLifecycleListener) it.next()).onActivityCreated(activity, bundle);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityDestroyed(@NonNull Activity activity) {
                        try {
                            Iterator it = KSLifecycleObserve.this.mListeners.iterator();
                            while (it.hasNext()) {
                                ((KSLifecycleListener) it.next()).onActivityDestroyed(activity);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityPaused(@NonNull Activity activity) {
                        try {
                            if (KSLifecycleObserve.this.currentActivity != null && KSLifecycleObserve.this.currentActivity.get() != null && ((Activity) KSLifecycleObserve.this.currentActivity.get()).equals(activity)) {
                                KSLifecycleObserve.this.currentActivity = null;
                            }
                            Iterator it = KSLifecycleObserve.this.mListeners.iterator();
                            while (it.hasNext()) {
                                ((KSLifecycleListener) it.next()).onActivityPaused(activity);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityResumed(@NonNull Activity activity) {
                        try {
                            KSLifecycleObserve.this.currentActivity = new WeakReference(activity);
                            Iterator it = KSLifecycleObserve.this.mListeners.iterator();
                            while (it.hasNext()) {
                                ((KSLifecycleListener) it.next()).onActivityResumed(activity);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityStarted(@NonNull Activity activity) {
                        try {
                            KSLifecycleObserve.access$108(KSLifecycleObserve.this);
                            if (KSLifecycleObserve.this.startedActivityCount == 1) {
                                KSLifecycleObserve.this.onAppBackToForeground();
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityStopped(@NonNull Activity activity) {
                        try {
                            KSLifecycleObserve.access$110(KSLifecycleObserve.this);
                            if (KSLifecycleObserve.this.startedActivityCount == 0) {
                                KSLifecycleObserve.this.onAppGoToBackground();
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Keep
    public boolean isAppOnForeground() {
        return !this.mIsInBackground;
    }

    @Keep
    public void registerLifecycleListener(KSLifecycleListener kSLifecycleListener) {
        this.mListeners.add(kSLifecycleListener);
    }

    @Keep
    public void unRegisterLifecycleListener(KSLifecycleListener kSLifecycleListener) {
        this.mListeners.remove(kSLifecycleListener);
    }
}
