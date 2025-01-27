package com.kwad.components.core.p;

import androidx.annotation.NonNull;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.api.core.SpeedLimitApi;
import java.io.InputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes3.dex */
public class b {
    private static volatile b UL = null;
    private static volatile int UM = 204800;
    static volatile boolean UN = true;
    static volatile boolean UO = false;
    static volatile Set<c> UP = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));

    public static synchronized void a(c cVar) {
        synchronized (b.class) {
            if (UP.contains(cVar)) {
                UP.remove(cVar);
            }
        }
    }

    public static void f(boolean z10, int i10) {
        if (i10 > 0) {
            UM = i10 * 1024;
        }
        UN = z10;
    }

    public static b rC() {
        if (UL == null) {
            synchronized (b.class) {
                try {
                    if (UL == null) {
                        UL = new b();
                    }
                } finally {
                }
            }
        }
        return UL;
    }

    public static boolean rD() {
        return UN;
    }

    public static int rE() {
        return UM / 1024;
    }

    @InvokeBy(invokerClass = com.kwad.sdk.service.b.class, methodId = "initModeImplForInvoker")
    public static void register() {
        try {
            com.kwad.sdk.service.b.b(SpeedLimitApi.class, a.class);
        } catch (Throwable unused) {
        }
    }

    private static synchronized InputStream wrap(@NonNull InputStream inputStream) {
        c cVar;
        synchronized (b.class) {
            cVar = new c(inputStream, UM / (UP.size() + 1));
            UP.add(cVar);
        }
        return cVar;
    }

    public static InputStream wrapInputStream(InputStream inputStream) {
        return wrap(inputStream);
    }

    public final synchronized int rF() {
        int i10;
        i10 = 0;
        try {
            Iterator<c> it = UP.iterator();
            while (it.hasNext()) {
                i10 += (int) it.next().rG();
            }
        } catch (Exception unused) {
        }
        return i10;
    }
}
