package com.kwad.components.ad;

import androidx.annotation.NonNull;
import com.kwad.components.ad.adbit.c;
import com.kwad.components.core.b.d;
import com.kwad.components.core.b.f;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class KsAdLoadManager {

    enum Holder {
        INSTANCE;

        private final KsAdLoadManager mInstance = new KsAdLoadManager((byte) 0);

        Holder() {
        }
    }

    private KsAdLoadManager() {
    }

    /* synthetic */ KsAdLoadManager(byte b2) {
        this();
    }

    public static void a(@NonNull com.kwad.components.core.n.kwai.a aVar) {
        if (c.b(aVar)) {
            return;
        }
        d.lZ().c(aVar);
    }

    public static KsAdLoadManager ac() {
        return Holder.INSTANCE.mInstance;
    }

    public final synchronized <T> void a(T t) {
        f.mk().add(t);
    }

    public final synchronized <T> void b(List<T> list) {
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            f.mk().add(it.next());
        }
    }
}
