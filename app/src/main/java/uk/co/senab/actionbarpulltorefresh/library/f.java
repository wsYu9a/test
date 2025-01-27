package uk.co.senab.actionbarpulltorefresh.library;

import android.content.Context;
import android.util.Log;
import android.view.View;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes5.dex */
class f {

    /* renamed from: a */
    private static final String f37156a = "InstanceCreationUtils";

    /* renamed from: b */
    private static final Class<?>[] f37157b = new Class[0];

    /* renamed from: c */
    private static final Class<?>[] f37158c = new Class[0];

    /* renamed from: d */
    private static final HashMap<Class, Class> f37159d = new HashMap<>();

    static {
        a(uk.co.senab.actionbarpulltorefresh.library.k.a.f37187a, uk.co.senab.actionbarpulltorefresh.library.k.a.class);
        a(uk.co.senab.actionbarpulltorefresh.library.k.b.f37188a, uk.co.senab.actionbarpulltorefresh.library.k.b.class);
        a(uk.co.senab.actionbarpulltorefresh.library.k.d.f37189a, uk.co.senab.actionbarpulltorefresh.library.k.d.class);
    }

    f() {
    }

    private static void a(Class[] clsArr, Class<?> cls) {
        for (Class cls2 : clsArr) {
            f37159d.put(cls2, cls);
        }
    }

    static uk.co.senab.actionbarpulltorefresh.library.k.c b(View view) {
        for (Map.Entry<Class, Class> entry : f37159d.entrySet()) {
            if (entry.getKey().isInstance(view)) {
                return (uk.co.senab.actionbarpulltorefresh.library.k.c) e(view.getContext(), entry.getValue(), f37157b, new Object[0]);
            }
        }
        return null;
    }

    static <T> T c(Context context, String str) {
        try {
            return (T) e(context, context.getClassLoader().loadClass(str), f37158c, new Object[0]);
        } catch (Exception e2) {
            Log.w(f37156a, "Cannot instantiate class: " + str, e2);
            return null;
        }
    }

    static <T> T d(Context context, String str) {
        try {
            return (T) e(context, context.getClassLoader().loadClass(str), f37157b, new Object[0]);
        } catch (Exception e2) {
            Log.w(f37156a, "Cannot instantiate class: " + str, e2);
            return null;
        }
    }

    private static <T> T e(Context context, Class cls, Class[] clsArr, Object... objArr) {
        try {
            return cls.getConstructor(clsArr).newInstance(objArr);
        } catch (Exception e2) {
            Log.w(f37156a, "Cannot instantiate class: " + cls.getName(), e2);
            return null;
        }
    }
}
