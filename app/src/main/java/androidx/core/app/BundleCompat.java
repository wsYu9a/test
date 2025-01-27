package androidx.core.app;

import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class BundleCompat {

    static class BundleCompatBaseImpl {

        /* renamed from: a, reason: collision with root package name */
        private static final String f1403a = "BundleCompatBaseImpl";

        /* renamed from: b, reason: collision with root package name */
        private static Method f1404b;

        /* renamed from: c, reason: collision with root package name */
        private static boolean f1405c;

        /* renamed from: d, reason: collision with root package name */
        private static Method f1406d;

        /* renamed from: e, reason: collision with root package name */
        private static boolean f1407e;

        private BundleCompatBaseImpl() {
        }

        public static IBinder getBinder(Bundle bundle, String str) {
            if (!f1405c) {
                try {
                    Method method = Bundle.class.getMethod("getIBinder", String.class);
                    f1404b = method;
                    method.setAccessible(true);
                } catch (NoSuchMethodException e2) {
                    Log.i(f1403a, "Failed to retrieve getIBinder method", e2);
                }
                f1405c = true;
            }
            Method method2 = f1404b;
            if (method2 != null) {
                try {
                    return (IBinder) method2.invoke(bundle, str);
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e3) {
                    Log.i(f1403a, "Failed to invoke getIBinder via reflection", e3);
                    f1404b = null;
                }
            }
            return null;
        }

        public static void putBinder(Bundle bundle, String str, IBinder iBinder) {
            if (!f1407e) {
                try {
                    Method method = Bundle.class.getMethod("putIBinder", String.class, IBinder.class);
                    f1406d = method;
                    method.setAccessible(true);
                } catch (NoSuchMethodException e2) {
                    Log.i(f1403a, "Failed to retrieve putIBinder method", e2);
                }
                f1407e = true;
            }
            Method method2 = f1406d;
            if (method2 != null) {
                try {
                    method2.invoke(bundle, str, iBinder);
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e3) {
                    Log.i(f1403a, "Failed to invoke putIBinder via reflection", e3);
                    f1406d = null;
                }
            }
        }
    }

    private BundleCompat() {
    }

    @Nullable
    public static IBinder getBinder(@NonNull Bundle bundle, @Nullable String str) {
        return Build.VERSION.SDK_INT >= 18 ? bundle.getBinder(str) : BundleCompatBaseImpl.getBinder(bundle, str);
    }

    public static void putBinder(@NonNull Bundle bundle, @Nullable String str, @Nullable IBinder iBinder) {
        if (Build.VERSION.SDK_INT >= 18) {
            bundle.putBinder(str, iBinder);
        } else {
            BundleCompatBaseImpl.putBinder(bundle, str, iBinder);
        }
    }
}
