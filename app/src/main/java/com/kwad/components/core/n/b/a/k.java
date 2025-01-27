package com.kwad.components.core.n.b.a;

import com.kwad.components.offline.api.core.api.IOfflineCompoLogcat;

/* loaded from: classes3.dex */
final class k implements IOfflineCompoLogcat {
    @Override // com.kwad.components.offline.api.core.api.ILogcat
    public final void d(String str, String str2) {
        com.kwad.sdk.core.d.c.d(str, str2);
    }

    @Override // com.kwad.components.offline.api.core.api.ILogcat
    public final void e(String str, String str2) {
        com.kwad.sdk.core.d.c.e(str, str2);
    }

    @Override // com.kwad.components.offline.api.core.api.ILogcat
    public final void i(String str, String str2) {
        com.kwad.sdk.core.d.c.i(str, str2);
    }

    @Override // com.kwad.components.offline.api.core.api.IOfflineCompoLogcat
    public final boolean isLoggable() {
        return com.kwad.sdk.core.d.c.azl;
    }

    @Override // com.kwad.components.offline.api.core.api.ILogcat
    public final void printStackTrace(Throwable th2) {
        com.kwad.sdk.core.d.c.printStackTrace(th2);
    }

    @Override // com.kwad.components.offline.api.core.api.ILogcat
    public final void printStackTraceOnly(Throwable th2) {
        com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
    }

    @Override // com.kwad.components.offline.api.core.api.ILogcat
    public final void v(String str, String str2) {
        com.kwad.sdk.core.d.c.v(str, str2);
    }

    @Override // com.kwad.components.offline.api.core.api.ILogcat
    public final void w(String str, String str2) {
        com.kwad.sdk.core.d.c.w(str, str2);
    }

    @Override // com.kwad.components.offline.api.core.api.ILogcat
    public final void e(String str, String str2, Throwable th2) {
        com.kwad.sdk.core.d.c.e(str, str2, th2);
    }

    @Override // com.kwad.components.offline.api.core.api.ILogcat
    public final void v(String str, String str2, boolean z10) {
        if (z10) {
            com.kwad.sdk.core.d.c.T(str, str2);
        } else {
            com.kwad.sdk.core.d.c.v(str, str2);
        }
    }

    @Override // com.kwad.components.offline.api.core.api.ILogcat
    public final void w(String str, String str2, boolean z10) {
        if (z10 || com.kwad.components.core.a.ns.booleanValue()) {
            com.kwad.sdk.core.d.c.w(str, str2);
        }
    }
}
