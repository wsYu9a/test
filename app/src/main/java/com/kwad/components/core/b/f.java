package com.kwad.components.core.b;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public class f {
    private static volatile f Ii;
    private ConcurrentHashMap<String, WeakReference<Object>> Ih = new ConcurrentHashMap<>();

    private static String G(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.a.d.bU(adTemplate) + "-" + com.kwad.sdk.core.response.a.d.cl(adTemplate);
    }

    private static String b(g gVar) {
        return gVar.ml() + "-" + gVar.mr();
    }

    @NonNull
    public static f mk() {
        if (Ii == null) {
            synchronized (f.class) {
                if (Ii == null) {
                    Ii = new f();
                }
            }
        }
        return Ii;
    }

    public final void F(AdTemplate adTemplate) {
        this.Ih.remove(G(adTemplate));
    }

    public final boolean a(g gVar) {
        String b2 = b(gVar);
        com.kwad.sdk.core.d.b.d("AdMemCachePool", "contains key: " + b2);
        boolean z = false;
        if (!this.Ih.containsKey(b2)) {
            return false;
        }
        WeakReference<Object> weakReference = this.Ih.get(b2);
        if (weakReference != null && weakReference.get() != null) {
            z = true;
        }
        if (z) {
            com.kwad.sdk.core.d.b.d("AdMemCachePool", "contains ad: " + weakReference.get());
        }
        return z;
    }

    public final void add(Object obj) {
        if (obj instanceof com.kwad.components.core.internal.api.a) {
            this.Ih.put(G(((com.kwad.components.core.internal.api.a) obj).getAdTemplate()), new WeakReference<>(obj));
        }
    }
}
