package com.kwad.components.core.c;

import com.kwad.sdk.core.response.model.AdResultData;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public final class f {
    private Map<Integer, AdResultData> Ld = new ConcurrentHashMap();
    private AtomicInteger Le = new AtomicInteger(0);

    public static class a {
        static f Lf = new f();
    }

    public static f nt() {
        return a.Lf;
    }

    public final AdResultData d(int i10, boolean z10) {
        AdResultData adResultData = this.Ld.get(Integer.valueOf(i10));
        this.Ld.remove(Integer.valueOf(i10));
        return adResultData;
    }

    public final int j(AdResultData adResultData) {
        if (adResultData == null) {
            return 0;
        }
        int incrementAndGet = this.Le.incrementAndGet();
        this.Ld.put(Integer.valueOf(incrementAndGet), adResultData);
        return incrementAndGet;
    }
}
