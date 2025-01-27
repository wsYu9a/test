package com.kwad.sdk.core.d;

import android.util.Log;

/* loaded from: classes3.dex */
final class b implements com.kwad.sdk.core.d.a.a {
    @Override // com.kwad.sdk.core.d.a.a
    public final void d(String str, String str2) {
        if (c.azl && a.ns.booleanValue()) {
            Log.d(str, str2);
        }
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void e(String str, String str2) {
        if (c.azl) {
            Log.e(str, str2);
        }
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void i(String str, String str2) {
        if (c.azl) {
            Log.i(str, str2);
        }
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void printStackTraceOnly(Throwable th2) {
        if (c.azl && a.ns.booleanValue() && th2 != null) {
            th2.printStackTrace();
        }
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void v(String str, String str2) {
        if (c.azl && a.ns.booleanValue()) {
            Log.v(str, str2);
        }
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void w(String str, String str2) {
        if (c.azl) {
            Log.w(str, str2);
        }
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void v(String str, String str2, boolean z10) {
        Log.v(str, str2);
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void w(String str, String str2, boolean z10) {
        if (z10) {
            Log.w(str, str2);
        }
    }
}
