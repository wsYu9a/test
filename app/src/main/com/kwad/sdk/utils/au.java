package com.kwad.sdk.utils;

import android.text.TextUtils;
import androidx.annotation.Nullable;

/* loaded from: classes3.dex */
public final class au {
    private static void a(RuntimeException runtimeException) {
        com.kwad.sdk.core.d.c.printStackTrace(runtimeException);
    }

    public static String av(String str, @Nullable String str2) {
        if (TextUtils.isEmpty(str)) {
            a(new NullPointerException("Argument cannot be null " + str2));
        }
        return str;
    }

    public static void checkArgument(boolean z10, @Nullable Object obj) {
        if (z10) {
            return;
        }
        a(new IllegalArgumentException("Expression cannot be false " + obj));
    }

    public static <T> T checkNotNull(T t10) {
        return (T) g(t10, "");
    }

    public static void f(Object... objArr) {
        for (int i10 = 0; i10 < 2; i10++) {
            checkNotNull(objArr[i10]);
        }
    }

    public static <T> T g(T t10, @Nullable String str) {
        if (t10 == null) {
            a(new NullPointerException("Argument cannot be null " + str));
        }
        return t10;
    }

    public static String gV(String str) {
        return av(str, "");
    }
}
