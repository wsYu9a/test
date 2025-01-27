package androidx.media3.common.util;

import android.os.Bundle;
import android.os.IBinder;
import androidx.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@UnstableApi
/* loaded from: classes.dex */
public final class BundleUtil {
    private static final String TAG = "BundleUtil";

    @Nullable
    private static Method getIBinderMethod;

    @Nullable
    private static Method putIBinderMethod;

    private BundleUtil() {
    }

    @Nullable
    public static IBinder getBinder(Bundle bundle, @Nullable String str) {
        return Util.SDK_INT >= 18 ? bundle.getBinder(str) : getBinderByReflection(bundle, str);
    }

    @Nullable
    private static IBinder getBinderByReflection(Bundle bundle, @Nullable String str) {
        Method method = getIBinderMethod;
        if (method == null) {
            try {
                Method method2 = Bundle.class.getMethod("getIBinder", String.class);
                getIBinderMethod = method2;
                method2.setAccessible(true);
                method = getIBinderMethod;
            } catch (NoSuchMethodException e10) {
                Log.i(TAG, "Failed to retrieve getIBinder method", e10);
                return null;
            }
        }
        try {
            return (IBinder) method.invoke(bundle, str);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e11) {
            Log.i(TAG, "Failed to invoke getIBinder via reflection", e11);
            return null;
        }
    }

    public static void putBinder(Bundle bundle, @Nullable String str, @Nullable IBinder iBinder) {
        if (Util.SDK_INT >= 18) {
            bundle.putBinder(str, iBinder);
        } else {
            putBinderByReflection(bundle, str, iBinder);
        }
    }

    private static void putBinderByReflection(Bundle bundle, @Nullable String str, @Nullable IBinder iBinder) {
        Method method = putIBinderMethod;
        if (method == null) {
            try {
                Method method2 = Bundle.class.getMethod("putIBinder", String.class, IBinder.class);
                putIBinderMethod = method2;
                method2.setAccessible(true);
                method = putIBinderMethod;
            } catch (NoSuchMethodException e10) {
                Log.i(TAG, "Failed to retrieve putIBinder method", e10);
                return;
            }
        }
        try {
            method.invoke(bundle, str, iBinder);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e11) {
            Log.i(TAG, "Failed to invoke putIBinder via reflection", e11);
        }
    }
}
