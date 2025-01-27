package com.kwad.components.ad.k;

import com.kwad.sdk.core.network.e;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.h;
import com.kwad.sdk.internal.api.SceneImpl;

/* loaded from: classes2.dex */
public class c implements h.a {
    private static volatile c Jr;

    private c() {
    }

    public static c mT() {
        if (Jr == null) {
            synchronized (c.class) {
                try {
                    if (Jr == null) {
                        Jr = new c();
                    }
                } finally {
                }
            }
        }
        return Jr;
    }

    @Override // com.kwad.sdk.core.network.h.a
    public final void a(f fVar, int i10) {
        SceneImpl scene;
        if (!(fVar instanceof com.kwad.components.core.request.a) || i10 == e.azA.errorCode || (scene = fVar.getScene()) == null) {
            return;
        }
        com.kwad.components.core.o.a.ri().a(scene.getPosId(), i10 == e.azv.errorCode ? 21001 : i10 == e.azz.errorCode ? 21003 : (i10 <= 0 || i10 >= 1000) ? 21004 : 21002);
    }

    public final void init() {
        h.Fs().a(this);
    }
}
