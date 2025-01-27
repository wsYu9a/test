package com.snassdk.sdk.wrapper;

import android.content.Context;
import androidx.annotation.Keep;
import cg.a;
import cg.c;

@Keep
/* loaded from: classes4.dex */
public class Wrapper {
    @Keep
    public static void init(SystemConfig systemConfig) {
        a.a().k(systemConfig);
        c.d();
    }

    @Keep
    public static boolean isContextWrapped(Context context) {
        return isContextWrappedInner(context, 0);
    }

    public static boolean isContextWrappedInner(Context context, int i10) {
        if (context instanceof ContextWrapper) {
            return true;
        }
        if (!(context instanceof android.content.ContextWrapper)) {
            return false;
        }
        if (i10 >= 5) {
            return true;
        }
        return isContextWrappedInner(ContextWrapper.a(context), i10 + 1);
    }

    @Keep
    public static Context wrap(Context context) {
        return isContextWrapped(context) ? context : new ContextWrapper(context);
    }
}
