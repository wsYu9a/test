package com.kwad.components.core.s;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: classes3.dex */
public final class j {
    public static boolean d(@NonNull AdTemplate adTemplate, boolean z10) {
        if (!z10 && com.kwad.sdk.core.response.b.b.dA(com.kwad.sdk.core.response.b.e.eb(adTemplate))) {
            return com.kwad.sdk.core.config.d.Ee();
        }
        return false;
    }

    public static void f(@NonNull Context context, @NonNull AdTemplate adTemplate) {
        com.kwad.components.core.e.d.a.a(new a.C0427a(context).an(true).au(adTemplate));
    }
}
