package com.kwad.components.core.s;

import androidx.annotation.Nullable;

/* loaded from: classes3.dex */
public final class f {
    public static String a(StackTraceElement stackTraceElement) {
        return stackTraceElement.getClassName() + p1.b.f29697h + stackTraceElement.getMethodName();
    }

    public static boolean aC(@Nullable String str) {
        if (str == null) {
            return false;
        }
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            if (a(stackTraceElement).equals(str)) {
                return true;
            }
        }
        return false;
    }
}
