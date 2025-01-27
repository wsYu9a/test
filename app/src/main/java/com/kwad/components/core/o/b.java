package com.kwad.components.core.o;

import androidx.annotation.NonNull;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.api.core.SpeedLimitApi;
import java.io.InputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes2.dex */
public class b {
    private static volatile b Pb = null;
    private static volatile int Pc = 204800;
    static volatile boolean Pd = true;
    static volatile boolean Pe = false;
    static volatile Set<c> Pf = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));

    public static synchronized void a(c cVar) {
        synchronized (b.class) {
            if (Pf.contains(cVar)) {
                Pf.remove(cVar);
            }
        }
    }

    public static void e(boolean z, int i2) {
        if (i2 > 0) {
            Pc = i2 * 1024;
        }
        Pd = z;
    }

    public static b pm() {
        if (Pb == null) {
            synchronized (b.class) {
                if (Pb == null) {
                    Pb = new b();
                }
            }
        }
        return Pb;
    }

    public static boolean pn() {
        return Pd;
    }

    public static int po() {
        return Pc / 1024;
    }

    @InvokeBy(invokerClass = com.kwad.sdk.service.a.class, methodId = "initModeImplForInvoker")
    public static void register() {
        try {
            com.kwad.sdk.service.a.b(SpeedLimitApi.class, a.class);
        } catch (Throwable unused) {
        }
    }

    private static synchronized InputStream wrap(@NonNull InputStream inputStream) {
        c cVar;
        synchronized (b.class) {
            cVar = new c(inputStream, Pc / (Pf.size() + 1));
            Pf.add(cVar);
        }
        return cVar;
    }

    public static InputStream wrapInputStream(InputStream inputStream) {
        return wrap(inputStream);
    }

    public final synchronized int pp() {
        int i2;
        i2 = 0;
        try {
            Iterator<c> it = Pf.iterator();
            while (it.hasNext()) {
                i2 += (int) it.next().pq();
            }
        } catch (Exception unused) {
        }
        return i2;
    }
}
