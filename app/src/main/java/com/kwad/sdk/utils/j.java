package com.kwad.sdk.utils;

import android.content.Context;
import androidx.annotation.Nullable;

/* loaded from: classes2.dex */
public abstract class j<T> {
    protected boolean Ig;
    protected boolean azm = false;

    public j(boolean z) {
        this.Ig = z;
    }

    public final void aP(boolean z) {
        this.Ig = z;
    }

    @Nullable
    public final T bF(Context context) {
        if (!this.Ig || this.azm) {
            return null;
        }
        try {
            return bG(context);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
            return null;
        }
    }

    @Nullable
    protected abstract T bG(Context context);
}
