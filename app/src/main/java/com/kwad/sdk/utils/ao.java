package com.kwad.sdk.utils;

import android.text.TextUtils;
import androidx.annotation.Nullable;

/* loaded from: classes2.dex */
public final class ao {
    private static void a(RuntimeException runtimeException) {
        com.kwad.sdk.core.d.b.printStackTrace(runtimeException);
    }

    public static String ah(String str, @Nullable String str2) {
        if (TextUtils.isEmpty(str)) {
            a(new NullPointerException("Argument cannot be null " + str2));
        }
        return str;
    }

    public static void checkArgument(boolean z, @Nullable Object obj) {
        if (z) {
            return;
        }
        a(new IllegalArgumentException("Expression cannot be false " + obj));
    }

    public static <T> T checkNotNull(T t) {
        return (T) f(t, "");
    }

    public static void e(Object... objArr) {
        for (int i2 = 0; i2 < 2; i2++) {
            checkNotNull(objArr[i2]);
        }
    }

    public static String eK(String str) {
        return ah(str, "");
    }

    public static <T> T f(T t, @Nullable String str) {
        if (t == null) {
            a(new NullPointerException("Argument cannot be null " + str));
        }
        return t;
    }
}
