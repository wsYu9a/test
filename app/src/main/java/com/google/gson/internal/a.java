package com.google.gson.internal;

/* loaded from: classes.dex */
public final class a {
    public static void a(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static <T> T b(T t) {
        t.getClass();
        return t;
    }
}
