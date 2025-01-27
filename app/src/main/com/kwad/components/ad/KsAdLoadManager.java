package com.kwad.components.ad;

import androidx.annotation.NonNull;
import com.kwad.components.ad.adbit.c;
import com.kwad.components.core.c.g;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.components.d;
import com.kwad.sdk.core.network.e;
import com.kwad.sdk.l;
import com.kwad.sdk.service.ServiceProvider;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class KsAdLoadManager {

    public enum Holder {
        INSTANCE;

        private final KsAdLoadManager mInstance = new KsAdLoadManager((byte) 0);

        Holder() {
        }
    }

    public /* synthetic */ KsAdLoadManager(byte b10) {
        this();
    }

    public static KsAdLoadManager M() {
        return Holder.INSTANCE.mInstance;
    }

    private static boolean b(com.kwad.components.core.request.model.a aVar) {
        try {
            d.f(DevelopMangerComponents.class);
            return false;
        } catch (Exception e10) {
            ServiceProvider.reportSdkCaughtException(e10);
            return false;
        }
    }

    public final void a(@NonNull com.kwad.components.core.request.model.a aVar) {
        if (!l.At().AS()) {
            e eVar = e.azx;
            com.kwad.components.core.request.model.a.a(aVar, eVar.errorCode, eVar.msg, true);
        } else {
            if (c.c(aVar) || b(aVar)) {
                return;
            }
            com.kwad.components.core.c.d.nm().d(aVar);
        }
    }

    private KsAdLoadManager() {
    }

    public final synchronized <T> void b(List<T> list) {
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            g.nu().add(it.next());
        }
    }

    public final synchronized <T> void a(T t10) {
        g.nu().add(t10);
    }
}
