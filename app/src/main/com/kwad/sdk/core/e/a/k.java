package com.kwad.sdk.core.e.a;

import android.content.Context;
import com.kwad.sdk.utils.w;

/* loaded from: classes3.dex */
public final class k {
    private Context mContext;

    public k(Context context) {
        this.mContext = context;
    }

    public final String getOAID() {
        try {
            return (String) w.callMethod(w.h("com.android.id.impl.IdProviderImpl", new Object[0]), "getOAID", this.mContext);
        } catch (Exception unused) {
            return "";
        }
    }
}
