package androidx.core.text;

import android.icu.util.ULocale;
import android.os.Build;
import android.util.Log;
import androidx.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

/* loaded from: classes.dex */
public final class ICUCompat {

    /* renamed from: a, reason: collision with root package name */
    private static final String f1924a = "ICUCompat";

    /* renamed from: b, reason: collision with root package name */
    private static Method f1925b;

    /* renamed from: c, reason: collision with root package name */
    private static Method f1926c;

    static {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            if (i2 < 24) {
                try {
                    f1926c = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", Locale.class);
                    return;
                } catch (Exception e2) {
                    throw new IllegalStateException(e2);
                }
            }
            return;
        }
        try {
            Class<?> cls = Class.forName("libcore.icu.ICU");
            f1925b = cls.getMethod("getScript", String.class);
            f1926c = cls.getMethod("addLikelySubtags", String.class);
        } catch (Exception e3) {
            f1925b = null;
            f1926c = null;
            Log.w(f1924a, e3);
        }
    }

    private ICUCompat() {
    }

    private static String a(Locale locale) {
        String locale2 = locale.toString();
        try {
            Method method = f1926c;
            if (method != null) {
                return (String) method.invoke(null, locale2);
            }
        } catch (IllegalAccessException e2) {
            Log.w(f1924a, e2);
        } catch (InvocationTargetException e3) {
            Log.w(f1924a, e3);
        }
        return locale2;
    }

    private static String b(String str) {
        try {
            Method method = f1925b;
            if (method != null) {
                return (String) method.invoke(null, str);
            }
        } catch (IllegalAccessException e2) {
            Log.w(f1924a, e2);
        } catch (InvocationTargetException e3) {
            Log.w(f1924a, e3);
        }
        return null;
    }

    @Nullable
    public static String maximizeAndGetScript(Locale locale) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 24) {
            return ULocale.addLikelySubtags(ULocale.forLocale(locale)).getScript();
        }
        if (i2 < 21) {
            String a2 = a(locale);
            if (a2 != null) {
                return b(a2);
            }
            return null;
        }
        try {
            return ((Locale) f1926c.invoke(null, locale)).getScript();
        } catch (IllegalAccessException e2) {
            Log.w(f1924a, e2);
            return locale.getScript();
        } catch (InvocationTargetException e3) {
            Log.w(f1924a, e3);
            return locale.getScript();
        }
    }
}
