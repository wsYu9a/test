package com.kwad.components.ad.draw.b.b;

import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: classes2.dex */
public final class a {
    private InterfaceC0365a dS;

    @Nullable
    private b dT;
    private boolean dU = false;
    private AdTemplate mAdTemplate;

    /* renamed from: com.kwad.components.ad.draw.b.b.a$a */
    public interface InterfaceC0365a {
        void aP();
    }

    public interface b {
        boolean aQ();
    }

    public a(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    @MainThread
    public final void a(InterfaceC0365a interfaceC0365a) {
        this.dS = interfaceC0365a;
    }

    public final void aO() {
        InterfaceC0365a interfaceC0365a;
        if (this.dU) {
            return;
        }
        this.dU = true;
        if (e.eb(this.mAdTemplate).status == 1 || e.eb(this.mAdTemplate).status == 2 || e.eb(this.mAdTemplate).status == 3) {
            return;
        }
        b bVar = this.dT;
        if ((bVar == null || !bVar.aQ()) && (interfaceC0365a = this.dS) != null) {
            interfaceC0365a.aP();
        }
    }

    @MainThread
    public final void a(b bVar) {
        this.dT = bVar;
    }
}
