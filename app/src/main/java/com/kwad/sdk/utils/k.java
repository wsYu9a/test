package com.kwad.sdk.utils;

import android.content.Context;
import androidx.annotation.Nullable;

/* loaded from: classes3.dex */
public abstract class k<T> {
    protected boolean Lc;
    protected boolean aSP = false;

    public k(boolean z10) {
        this.Lc = z10;
    }

    public final void bT(boolean z10) {
        this.Lc = z10;
    }

    @Nullable
    public final T cf(Context context) {
        if (!this.Lc || this.aSP) {
            return null;
        }
        try {
            return cg(context);
        } catch (Throwable th2) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
            return null;
        }
    }

    @Nullable
    public abstract T cg(Context context);
}
