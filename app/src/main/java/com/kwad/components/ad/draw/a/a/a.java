package com.kwad.components.ad.draw.a.a;

import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: classes.dex */
public final class a {
    private InterfaceC0119a cM;

    @Nullable
    private b cN;
    private boolean cO = false;
    private AdTemplate mAdTemplate;

    /* renamed from: com.kwad.components.ad.draw.a.a.a$a */
    public interface InterfaceC0119a {
        void ay();
    }

    public interface b {
        boolean az();
    }

    public a(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    @MainThread
    public final void a(InterfaceC0119a interfaceC0119a) {
        this.cM = interfaceC0119a;
    }

    @MainThread
    public final void a(b bVar) {
        this.cN = bVar;
    }

    public final void ax() {
        InterfaceC0119a interfaceC0119a;
        if (this.cO) {
            return;
        }
        this.cO = true;
        if (d.cb(this.mAdTemplate).status == 1 || d.cb(this.mAdTemplate).status == 2 || d.cb(this.mAdTemplate).status == 3) {
            return;
        }
        b bVar = this.cN;
        if ((bVar == null || !bVar.az()) && (interfaceC0119a = this.cM) != null) {
            interfaceC0119a.ay();
        }
    }
}
