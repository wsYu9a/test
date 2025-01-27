package b.h.a.e;

import android.text.TextUtils;
import android.util.Log;
import java.lang.reflect.Method;

/* loaded from: classes4.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f4991a = false;

    /* renamed from: b, reason: collision with root package name */
    private static String f4992b = "ReflectHelp";

    public static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable th) {
            if (f4991a) {
                Log.w(f4992b, "reflect:" + th.getMessage());
            }
            return null;
        }
    }

    public static Object b(Class cls, String str, Class[] clsArr, Object[] objArr) {
        if (cls == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Method c2 = c(cls, str, clsArr);
            if (c2 == null) {
                return null;
            }
            c2.setAccessible(true);
            return c2.invoke(null, objArr);
        } catch (Throwable th) {
            if (!f4991a) {
                return null;
            }
            Log.w(f4992b, "reflect:" + th.getMessage());
            return null;
        }
    }

    private static Method c(Class cls, String str, Class[] clsArr) {
        if (cls != null && !TextUtils.isEmpty(str)) {
            try {
                try {
                    return cls.getDeclaredMethod(str, clsArr);
                } catch (Exception unused) {
                    if (cls.getSuperclass() != null) {
                        return c(cls.getSuperclass(), str, clsArr);
                    }
                }
            } catch (Exception unused2) {
                return cls.getMethod(str, clsArr);
            }
        }
        return null;
    }
}
