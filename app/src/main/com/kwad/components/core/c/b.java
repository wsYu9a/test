package com.kwad.components.core.c;

import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.z;

/* loaded from: classes3.dex */
public final class b {
    private static void aa(String str) {
        if (nl() && com.kwad.sdk.l.At().zE()) {
            z.P(ServiceProvider.getContext(), str);
        }
    }

    public static void b(e eVar) {
        aa("使用缓存策略: " + eVar.np());
    }

    public static boolean nl() {
        return false;
    }
}
