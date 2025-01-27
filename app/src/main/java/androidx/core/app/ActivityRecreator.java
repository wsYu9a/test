package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
final class ActivityRecreator {

    /* renamed from: a, reason: collision with root package name */
    private static final String f1382a = "ActivityRecreator";

    /* renamed from: b, reason: collision with root package name */
    protected static final Class<?> f1383b;

    /* renamed from: c, reason: collision with root package name */
    protected static final Field f1384c;

    /* renamed from: d, reason: collision with root package name */
    protected static final Field f1385d;

    /* renamed from: e, reason: collision with root package name */
    protected static final Method f1386e;

    /* renamed from: f, reason: collision with root package name */
    protected static final Method f1387f;

    /* renamed from: g, reason: collision with root package name */
    protected static final Method f1388g;

    /* renamed from: h, reason: collision with root package name */
    private static final Handler f1389h = new Handler(Looper.getMainLooper());

    private static final class LifecycleCheckCallbacks implements Application.ActivityLifecycleCallbacks {

        /* renamed from: a, reason: collision with root package name */
        Object f1396a;

        /* renamed from: b, reason: collision with root package name */
        private Activity f1397b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f1398c = false;

        /* renamed from: d, reason: collision with root package name */
        private boolean f1399d = false;

        /* renamed from: e, reason: collision with root package name */
        private boolean f1400e = false;

        LifecycleCheckCallbacks(@NonNull Activity activity) {
            this.f1397b = activity;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (this.f1397b == activity) {
                this.f1397b = null;
                this.f1399d = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            if (!this.f1399d || this.f1400e || this.f1398c || !ActivityRecreator.h(this.f1396a, activity)) {
                return;
            }
            this.f1400e = true;
            this.f1396a = null;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            if (this.f1397b == activity) {
                this.f1398c = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    static {
        Class<?> a2 = a();
        f1383b = a2;
        f1384c = b();
        f1385d = f();
        f1386e = d(a2);
        f1387f = c(a2);
        f1388g = e(a2);
    }

    private ActivityRecreator() {
    }

    private static Class<?> a() {
        try {
            return Class.forName("android.app.ActivityThread");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Field b() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mMainThread");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method c(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method d(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE, String.class);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method e(Class<?> cls) {
        if (g() && cls != null) {
            try {
                Class<?> cls2 = Boolean.TYPE;
                Method declaredMethod = cls.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, Integer.TYPE, cls2, Configuration.class, Configuration.class, cls2, cls2);
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private static Field f() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mToken");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean g() {
        int i2 = Build.VERSION.SDK_INT;
        return i2 == 26 || i2 == 27;
    }

    protected static boolean h(Object obj, Activity activity) {
        try {
            final Object obj2 = f1385d.get(activity);
            if (obj2 != obj) {
                return false;
            }
            final Object obj3 = f1384c.get(activity);
            f1389h.postAtFrontOfQueue(new Runnable() { // from class: androidx.core.app.ActivityRecreator.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Method method = ActivityRecreator.f1386e;
                        if (method != null) {
                            method.invoke(obj3, obj2, Boolean.FALSE, "AppCompat recreation");
                        } else {
                            ActivityRecreator.f1387f.invoke(obj3, obj2, Boolean.FALSE);
                        }
                    } catch (RuntimeException e2) {
                        if (e2.getClass() == RuntimeException.class && e2.getMessage() != null && e2.getMessage().startsWith("Unable to stop")) {
                            throw e2;
                        }
                    } catch (Throwable th) {
                        Log.e(ActivityRecreator.f1382a, "Exception while invoking performStopActivity", th);
                    }
                }
            });
            return true;
        } catch (Throwable th) {
            Log.e(f1382a, "Exception while fetching field values", th);
            return false;
        }
    }

    static boolean i(@NonNull Activity activity) {
        Object obj;
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
            return true;
        }
        if (g() && f1388g == null) {
            return false;
        }
        if (f1387f == null && f1386e == null) {
            return false;
        }
        try {
            final Object obj2 = f1385d.get(activity);
            if (obj2 == null || (obj = f1384c.get(activity)) == null) {
                return false;
            }
            final Application application = activity.getApplication();
            final LifecycleCheckCallbacks lifecycleCheckCallbacks = new LifecycleCheckCallbacks(activity);
            application.registerActivityLifecycleCallbacks(lifecycleCheckCallbacks);
            Handler handler = f1389h;
            handler.post(new Runnable() { // from class: androidx.core.app.ActivityRecreator.1
                @Override // java.lang.Runnable
                public void run() {
                    LifecycleCheckCallbacks.this.f1396a = obj2;
                }
            });
            try {
                if (g()) {
                    Method method = f1388g;
                    Boolean bool = Boolean.FALSE;
                    method.invoke(obj, obj2, null, null, 0, bool, null, null, bool, bool);
                } else {
                    activity.recreate();
                }
                handler.post(new Runnable() { // from class: androidx.core.app.ActivityRecreator.2
                    @Override // java.lang.Runnable
                    public void run() {
                        application.unregisterActivityLifecycleCallbacks(lifecycleCheckCallbacks);
                    }
                });
                return true;
            } catch (Throwable th) {
                f1389h.post(new Runnable() { // from class: androidx.core.app.ActivityRecreator.2
                    @Override // java.lang.Runnable
                    public void run() {
                        application.unregisterActivityLifecycleCallbacks(lifecycleCheckCallbacks);
                    }
                });
                throw th;
            }
        } catch (Throwable unused) {
            return false;
        }
    }
}
