package com.kwad.sdk.core.webview;

import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.webview.kwai.c;

/* loaded from: classes2.dex */
public final class d {
    private long apB;
    private boolean apC;

    public static void d(c.a aVar) {
        if (aVar != null) {
            com.kwad.sdk.core.report.a.e(aVar.getAdTemplate(), aVar.getClientParams());
        }
    }

    public final void a(c.a aVar) {
        if (aVar != null) {
            com.kwad.sdk.core.report.a.b(aVar.getAdTemplate(), aVar.getClientParams());
        }
        if (aVar != null) {
            this.apB = System.currentTimeMillis();
        }
    }

    public final void b(c.a aVar) {
        if (aVar != null) {
            y.b clientParams = aVar.getClientParams();
            if (clientParams == null) {
                clientParams = new y.b();
            }
            clientParams.Jm = System.currentTimeMillis() - this.apB;
            com.kwad.sdk.core.report.a.d(aVar.getAdTemplate(), clientParams);
        }
    }

    public final void c(c.a aVar) {
        if (aVar == null || this.apC) {
            return;
        }
        this.apC = true;
        if (this.apB > 0) {
            if (aVar.getClientParams() == null) {
                aVar.b(new y.b());
            }
            aVar.getClientParams().akA = System.currentTimeMillis() - this.apB;
            this.apB = -1L;
        }
        com.kwad.sdk.core.report.a.c(aVar.getAdTemplate(), aVar.getClientParams());
    }
}
