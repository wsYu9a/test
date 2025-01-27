package com.kwad.sdk.api.core;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public class KSLifecycleObserver {
    private static volatile KSLifecycleObserver sKSLifecycleObserver;
    private WeakReference<Activity> currentActivity;
    private Application mApplication;
    private boolean mIsInBackground = true;
    private int startedActivityCount = 0;
    private final List<KSLifecycleListener> mListeners = new CopyOnWriteArrayList();
    private boolean mHasInit = false;
    private boolean mEnable = false;

    /* renamed from: com.kwad.sdk.api.core.KSLifecycleObserver$1 */
    class AnonymousClass1 implements Application.ActivityLifecycleCallbacks {
        AnonymousClass1() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
            KSLifecycleObserver.this.mEnable = true;
            try {
                Iterator it = KSLifecycleObserver.this.mListeners.iterator();
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
                Iterator it = KSLifecycleObserver.this.mListeners.iterator();
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
                if (KSLifecycleObserver.this.currentActivity != null && KSLifecycleObserver.this.currentActivity.get() != null && ((Activity) KSLifecycleObserver.this.currentActivity.get()).equals(activity)) {
                    KSLifecycleObserver.this.currentActivity = null;
                }
                Iterator it = KSLifecycleObserver.this.mListeners.iterator();
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
                KSLifecycleObserver.this.currentActivity = new WeakReference(activity);
                Iterator it = KSLifecycleObserver.this.mListeners.iterator();
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
                KSLifecycleObserver.access$208(KSLifecycleObserver.this);
                if (KSLifecycleObserver.this.startedActivityCount == 1) {
                    KSLifecycleObserver.this.onAppBackToForeground();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(@NonNull Activity activity) {
            try {
                KSLifecycleObserver.access$210(KSLifecycleObserver.this);
                if (KSLifecycleObserver.this.startedActivityCount == 0) {
                    KSLifecycleObserver.this.onAppGoToBackground();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private KSLifecycleObserver() {
    }

    static /* synthetic */ int access$208(KSLifecycleObserver kSLifecycleObserver) {
        int i2 = kSLifecycleObserver.startedActivityCount;
        kSLifecycleObserver.startedActivityCount = i2 + 1;
        return i2;
    }

    static /* synthetic */ int access$210(KSLifecycleObserver kSLifecycleObserver) {
        int i2 = kSLifecycleObserver.startedActivityCount;
        kSLifecycleObserver.startedActivityCount = i2 - 1;
        return i2;
    }

    public static KSLifecycleObserver getInstance() {
        if (sKSLifecycleObserver == null) {
            synchronized (KSLifecycleObserver.class) {
                if (sKSLifecycleObserver == null) {
                    sKSLifecycleObserver = new KSLifecycleObserver();
                }
            }
        }
        return sKSLifecycleObserver;
    }

    public void onAppBackToForeground() {
        try {
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
                application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.kwad.sdk.api.core.KSLifecycleObserver.1
                    AnonymousClass1() {
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
                        KSLifecycleObserver.this.mEnable = true;
                        try {
                            Iterator it = KSLifecycleObserver.this.mListeners.iterator();
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
                            Iterator it = KSLifecycleObserver.this.mListeners.iterator();
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
                            if (KSLifecycleObserver.this.currentActivity != null && KSLifecycleObserver.this.currentActivity.get() != null && ((Activity) KSLifecycleObserver.this.currentActivity.get()).equals(activity)) {
                                KSLifecycleObserver.this.currentActivity = null;
                            }
                            Iterator it = KSLifecycleObserver.this.mListeners.iterator();
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
                            KSLifecycleObserver.this.currentActivity = new WeakReference(activity);
                            Iterator it = KSLifecycleObserver.this.mListeners.iterator();
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
                            KSLifecycleObserver.access$208(KSLifecycleObserver.this);
                            if (KSLifecycleObserver.this.startedActivityCount == 1) {
                                KSLifecycleObserver.this.onAppBackToForeground();
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }

                    @Override // android.app.Application.ActivityLifecycleCallbacks
                    public void onActivityStopped(@NonNull Activity activity) {
                        try {
                            KSLifecycleObserver.access$210(KSLifecycleObserver.this);
                            if (KSLifecycleObserver.this.startedActivityCount == 0) {
                                KSLifecycleObserver.this.onAppGoToBackground();
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
    public boolean isEnable() {
        return this.mEnable;
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
