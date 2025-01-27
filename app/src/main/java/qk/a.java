package qk;

import android.os.Build;
import android.util.Log;
import java.lang.reflect.Method;

/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a */
    public static Object f30202a;

    /* renamed from: b */
    public static Method f30203b;

    static {
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                Method declaredMethod = Class.class.getDeclaredMethod("forName", String.class);
                Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
                Class cls = (Class) declaredMethod.invoke(null, "dalvik.system.VMRuntime");
                Method method = (Method) declaredMethod2.invoke(cls, "getRuntime", null);
                f30203b = (Method) declaredMethod2.invoke(cls, "setHiddenApiExemptions", new Class[]{String[].class});
                f30202a = method.invoke(null, null);
            } catch (Throwable th2) {
                Log.w("BootstrapClass", "reflect bootstrap failed: " + th2);
            }
        }
    }

    public static boolean a() {
        Method method;
        String[] strArr = {"L"};
        Object obj = f30202a;
        if (obj == null || (method = f30203b) == null) {
            return false;
        }
        try {
            method.invoke(obj, strArr);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
