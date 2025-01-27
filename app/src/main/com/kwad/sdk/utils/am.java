package com.kwad.sdk.utils;

import androidx.annotation.Nullable;
import java.util.List;

/* loaded from: classes3.dex */
public final class am {
    public static boolean H(@Nullable List<?> list) {
        return list == null || list.isEmpty();
    }

    public static boolean O(@Nullable List<?> list) {
        return (list == null || list.isEmpty()) ? false : true;
    }

    public static boolean a(@Nullable Object obj, @Nullable Object obj2) {
        return obj != null && obj.equals(obj2);
    }

    public static void checkUiThread() {
        SystemUtil.checkUiThread();
    }
}
