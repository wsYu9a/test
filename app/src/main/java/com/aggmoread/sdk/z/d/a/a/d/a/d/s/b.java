package com.aggmoread.sdk.z.d.a.a.d.a.d.s;

import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a */
    private static AtomicBoolean f5583a = new AtomicBoolean();

    public static void a(Context context, String str, String str2) {
        if (f5583a.compareAndSet(false, true)) {
            c.c(context, str, str2);
        }
    }
}
