package com.kwad.components.core.c;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public class g {
    private static volatile g Lh;
    private ConcurrentHashMap<String, WeakReference<Object>> Lg = new ConcurrentHashMap<>();

    private static String ap(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.b.e.dU(adTemplate) + "-" + com.kwad.sdk.core.response.b.e.el(adTemplate);
    }

    private static String b(h hVar) {
        return hVar.nv() + "-" + hVar.nB();
    }

    @NonNull
    public static g nu() {
        if (Lh == null) {
            synchronized (g.class) {
                try {
                    if (Lh == null) {
                        Lh = new g();
                    }
                } finally {
                }
            }
        }
        return Lh;
    }

    public final boolean a(h hVar) {
        String b10 = b(hVar);
        com.kwad.sdk.core.d.c.d("AdMemCachePool", "contains key: " + b10);
        boolean z10 = false;
        if (!this.Lg.containsKey(b10)) {
            return false;
        }
        WeakReference<Object> weakReference = this.Lg.get(b10);
        if (weakReference != null && weakReference.get() != null) {
            z10 = true;
        }
        if (z10) {
            com.kwad.sdk.core.d.c.d("AdMemCachePool", "contains ad: " + weakReference.get());
        }
        return z10;
    }

    public final void add(Object obj) {
        if (obj instanceof com.kwad.components.core.internal.api.a) {
            this.Lg.put(ap(((com.kwad.components.core.internal.api.a) obj).getAdTemplate()), new WeakReference<>(obj));
        }
    }

    public final void ao(AdTemplate adTemplate) {
        this.Lg.remove(ap(adTemplate));
    }
}
