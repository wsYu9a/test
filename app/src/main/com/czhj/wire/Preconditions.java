package com.czhj.wire;

/* loaded from: classes2.dex */
final class Preconditions {
    public static void a(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }
}
