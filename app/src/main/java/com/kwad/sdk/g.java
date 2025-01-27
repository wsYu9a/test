package com.kwad.sdk;

import androidx.annotation.NonNull;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import java.util.Random;

/* loaded from: classes3.dex */
public final class g {
    private static AdHttpProxy anQ;

    @NonNull
    public static AdHttpProxy zc() {
        AdHttpProxy adHttpProxy = anQ;
        if (adHttpProxy != null) {
            return adHttpProxy;
        }
        if (com.kwad.framework.a.a.ns.booleanValue()) {
            return zd();
        }
        try {
            if (com.kwad.sdk.core.network.a.c.Fx() != null) {
                anQ = new com.kwad.sdk.core.network.c.b();
            } else {
                anQ = new com.kwad.sdk.core.network.c.a();
            }
        } catch (Throwable unused) {
            anQ = new com.kwad.sdk.core.network.c.a();
        }
        return anQ;
    }

    private static AdHttpProxy zd() {
        com.kwad.sdk.components.d.f(DevelopMangerComponents.class);
        return new Random().nextInt(5) != 0 ? new com.kwad.sdk.core.network.c.b() : new com.kwad.sdk.core.network.c.a();
    }
}
