package com.kwad.components.offline.b;

import com.kwad.components.offline.api.obiwan.IObiwanLogcat;

/* loaded from: classes3.dex */
public final class c implements com.kwad.sdk.core.d.a.a {
    private final IObiwanLogcat afW;

    public c(IObiwanLogcat iObiwanLogcat) {
        this.afW = iObiwanLogcat;
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void d(String str, String str2) {
        this.afW.d(str, str2);
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void e(String str, String str2) {
        this.afW.e(str, str2);
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void i(String str, String str2) {
        this.afW.i(str, str2);
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void printStackTraceOnly(Throwable th2) {
        this.afW.printStackTraceOnly(th2);
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void v(String str, String str2) {
        this.afW.v(str, str2);
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void w(String str, String str2) {
        this.afW.w(str, str2);
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void v(String str, String str2, boolean z10) {
        this.afW.v(str, str2, true);
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void w(String str, String str2, boolean z10) {
        this.afW.w(str, str2, z10);
    }
}
