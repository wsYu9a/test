package com.google.gason.internal;

/* renamed from: com.google.gason.internal.$Gson$Preconditions, reason: invalid class name */
/* loaded from: classes7.dex */
public final class C$Gson$Preconditions {
    public static void checkArgument(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static <T> T checkNotNull(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    public static void checkState(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }
}
