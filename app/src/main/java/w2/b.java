package w2;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a */
    public static final String f31562a = "IdentifierManager";

    /* renamed from: b */
    public static Object f31563b;

    /* renamed from: c */
    public static Class<?> f31564c;

    /* renamed from: d */
    public static Method f31565d;

    /* renamed from: e */
    public static Method f31566e;

    /* renamed from: f */
    public static Method f31567f;

    /* renamed from: g */
    public static Method f31568g;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            f31564c = cls;
            f31563b = cls.newInstance();
            f31565d = f31564c.getMethod("getUDID", Context.class);
            f31566e = f31564c.getMethod("getOAID", Context.class);
            f31567f = f31564c.getMethod("getVAID", Context.class);
            f31568g = f31564c.getMethod("getAAID", Context.class);
        } catch (Exception e10) {
            Log.e(f31562a, "reflect exception!", e10);
        }
    }

    public static String a(Context context) {
        return b(context, f31568g);
    }

    public static String b(Context context, Method method) {
        Object obj = f31563b;
        if (obj == null || method == null) {
            return null;
        }
        try {
            Object invoke = method.invoke(obj, context);
            if (invoke != null) {
                return (String) invoke;
            }
            return null;
        } catch (Exception e10) {
            Log.e(f31562a, "invoke exception!", e10);
            return null;
        }
    }

    public static boolean c() {
        return (f31564c == null || f31563b == null) ? false : true;
    }

    public static String d(Context context) {
        return b(context, f31566e);
    }

    public static String e(Context context) {
        return b(context, f31565d);
    }

    public static String f(Context context) {
        return b(context, f31567f);
    }
}
