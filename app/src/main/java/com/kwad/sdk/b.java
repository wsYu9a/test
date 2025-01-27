package com.kwad.sdk;

import androidx.annotation.NonNull;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import java.util.Random;

/* loaded from: classes2.dex */
public final class b {
    private static AdHttpProxy Yk;

    @NonNull
    public static AdHttpProxy rZ() {
        AdHttpProxy adHttpProxy = Yk;
        if (adHttpProxy != null) {
            return adHttpProxy;
        }
        if (com.kwad.b.kwai.a.bI.booleanValue()) {
            return sa();
        }
        try {
            Yk = com.kwad.sdk.core.network.kwai.c.wk() != null ? new com.kwad.sdk.core.network.b.b() : new com.kwad.sdk.core.network.b.a();
        } catch (Throwable unused) {
            Yk = new com.kwad.sdk.core.network.b.a();
        }
        return Yk;
    }

    private static AdHttpProxy sa() {
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        return new Random().nextInt(5) != 0 ? new com.kwad.sdk.core.network.b.b() : new com.kwad.sdk.core.network.b.a();
    }
}
