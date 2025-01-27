package com.kwad.sdk.utils;

import androidx.annotation.Nullable;
import java.util.List;

/* loaded from: classes2.dex */
public final class ah {
    public static boolean D(@Nullable List<?> list) {
        return (list == null || list.isEmpty()) ? false : true;
    }

    public static void checkUiThread() {
        SystemUtil.checkUiThread();
    }
}
