package com.czhj.sdk.common.utils;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowInsets;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.logger.SigmobLog;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes2.dex */
public class AdLifecycleManager {

    /* renamed from: c */
    public static AdLifecycleManager f8571c;

    /* renamed from: a */
    public final Set<WeakReference<LifecycleListener>> f8572a = new HashSet();

    /* renamed from: b */
    public boolean f8573b;

    /* renamed from: com.czhj.sdk.common.utils.AdLifecycleManager$1 */
    public class AnonymousClass1 implements Application.ActivityLifecycleCallbacks {
        public AnonymousClass1() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            SigmobLog.d("onActivityCreated() called with: activity = [" + activity + "], savedInstanceState = [" + bundle + "]");
            AdLifecycleManager.this.a(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            SigmobLog.d("onActivityDestroyed() called with: activity = [" + activity + "]");
            AdLifecycleManager.this.b(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            SigmobLog.d("onActivityPaused() called with: activity = [" + activity + "]");
            AdLifecycleManager.this.c(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            WindowInsets rootWindowInsets;
            SigmobLog.d("onActivityResumed() called with: activity = [" + activity + "]");
            if (Build.VERSION.SDK_INT >= 23) {
                rootWindowInsets = activity.getWindow().getDecorView().getRootWindowInsets();
                ClientMetadata.getInstance().setWindInsets(rootWindowInsets);
            }
            AdLifecycleManager.this.d(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            SigmobLog.d("onActivitySaveInstanceState() called with: activity = [" + activity + "], outState = [" + bundle + "]");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            SigmobLog.d("onActivityStarted() called with: activity = [" + activity + "]");
            AdLifecycleManager.this.e(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            SigmobLog.d("onActivityStopped() called with: activity = [" + activity + "]");
            AdLifecycleManager.this.f(activity);
        }
    }

    public interface LifecycleListener {
        void onCreate(Activity activity);

        void onDestroy(Activity activity);

        void onPause(Activity activity);

        void onResume(Activity activity);

        void onStart(Activity activity);

        void onStop(Activity activity);
    }

    public static AdLifecycleManager getInstance() {
        if (f8571c == null) {
            synchronized (AdLifecycleManager.class) {
                try {
                    if (f8571c == null) {
                        f8571c = new AdLifecycleManager();
                    }
                } finally {
                }
            }
        }
        return f8571c;
    }

    public void addLifecycleListener(LifecycleListener lifecycleListener) {
        if (lifecycleListener == null || this.f8572a == null || b(lifecycleListener)) {
            return;
        }
        this.f8572a.add(new WeakReference<>(lifecycleListener));
    }

    public void initialize(Application application) {
        try {
            if (this.f8573b) {
                return;
            }
            a(application);
            this.f8573b = true;
        } catch (Throwable th2) {
            SigmobLog.e(th2.getMessage());
        }
    }

    public void removeLifecycleListener(LifecycleListener lifecycleListener) {
        WeakReference<LifecycleListener> a10;
        if (lifecycleListener == null || this.f8572a == null || (a10 = a(lifecycleListener)) == null) {
            return;
        }
        this.f8572a.remove(a10);
    }

    public final void a(Application application) {
        if (application == null) {
            SigmobLog.e("activityCallBack error, application is null");
        } else {
            application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.czhj.sdk.common.utils.AdLifecycleManager.1
                public AnonymousClass1() {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityCreated(Activity activity, Bundle bundle) {
                    SigmobLog.d("onActivityCreated() called with: activity = [" + activity + "], savedInstanceState = [" + bundle + "]");
                    AdLifecycleManager.this.a(activity);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity) {
                    SigmobLog.d("onActivityDestroyed() called with: activity = [" + activity + "]");
                    AdLifecycleManager.this.b(activity);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPaused(Activity activity) {
                    SigmobLog.d("onActivityPaused() called with: activity = [" + activity + "]");
                    AdLifecycleManager.this.c(activity);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityResumed(Activity activity) {
                    WindowInsets rootWindowInsets;
                    SigmobLog.d("onActivityResumed() called with: activity = [" + activity + "]");
                    if (Build.VERSION.SDK_INT >= 23) {
                        rootWindowInsets = activity.getWindow().getDecorView().getRootWindowInsets();
                        ClientMetadata.getInstance().setWindInsets(rootWindowInsets);
                    }
                    AdLifecycleManager.this.d(activity);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                    SigmobLog.d("onActivitySaveInstanceState() called with: activity = [" + activity + "], outState = [" + bundle + "]");
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStarted(Activity activity) {
                    SigmobLog.d("onActivityStarted() called with: activity = [" + activity + "]");
                    AdLifecycleManager.this.e(activity);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStopped(Activity activity) {
                    SigmobLog.d("onActivityStopped() called with: activity = [" + activity + "]");
                    AdLifecycleManager.this.f(activity);
                }
            });
        }
    }

    public final synchronized boolean b(LifecycleListener lifecycleListener) {
        return a(lifecycleListener) != null;
    }

    public final synchronized void c(Activity activity) {
        try {
            Iterator it = new CopyOnWriteArraySet(this.f8572a).iterator();
            while (it.hasNext()) {
                LifecycleListener lifecycleListener = (LifecycleListener) ((WeakReference) it.next()).get();
                if (lifecycleListener != null) {
                    lifecycleListener.onPause(activity);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final synchronized void d(Activity activity) {
        try {
            Iterator it = new CopyOnWriteArraySet(this.f8572a).iterator();
            while (it.hasNext()) {
                LifecycleListener lifecycleListener = (LifecycleListener) ((WeakReference) it.next()).get();
                if (lifecycleListener != null) {
                    lifecycleListener.onResume(activity);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final synchronized void e(Activity activity) {
        try {
            Iterator it = new CopyOnWriteArraySet(this.f8572a).iterator();
            while (it.hasNext()) {
                LifecycleListener lifecycleListener = (LifecycleListener) ((WeakReference) it.next()).get();
                if (lifecycleListener != null) {
                    lifecycleListener.onStart(activity);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final synchronized void f(Activity activity) {
        try {
            Iterator it = new CopyOnWriteArraySet(this.f8572a).iterator();
            while (it.hasNext()) {
                LifecycleListener lifecycleListener = (LifecycleListener) ((WeakReference) it.next()).get();
                if (lifecycleListener != null) {
                    lifecycleListener.onStop(activity);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final synchronized WeakReference<LifecycleListener> a(LifecycleListener lifecycleListener) {
        try {
            Iterator it = new CopyOnWriteArraySet(this.f8572a).iterator();
            while (it.hasNext()) {
                WeakReference<LifecycleListener> weakReference = (WeakReference) it.next();
                if (weakReference.get() == lifecycleListener) {
                    return weakReference;
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public final synchronized void b(Activity activity) {
        try {
            Iterator it = new CopyOnWriteArraySet(this.f8572a).iterator();
            while (it.hasNext()) {
                LifecycleListener lifecycleListener = (LifecycleListener) ((WeakReference) it.next()).get();
                if (lifecycleListener != null) {
                    lifecycleListener.onDestroy(activity);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final synchronized void a(Activity activity) {
        try {
            Iterator it = new CopyOnWriteArraySet(this.f8572a).iterator();
            while (it.hasNext()) {
                LifecycleListener lifecycleListener = (LifecycleListener) ((WeakReference) it.next()).get();
                if (lifecycleListener != null) {
                    lifecycleListener.onCreate(activity);
                }
            }
        } catch (Throwable unused) {
        }
    }
}
