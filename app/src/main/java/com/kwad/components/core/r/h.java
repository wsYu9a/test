package com.kwad.components.core.r;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: classes2.dex */
public final class h {
    public static boolean e(@NonNull AdTemplate adTemplate, boolean z) {
        if (!z && com.kwad.sdk.core.response.a.b.cK(com.kwad.sdk.core.response.a.d.cb(adTemplate))) {
            return com.kwad.sdk.core.config.d.uW();
        }
        return false;
    }

    public static void g(@NonNull Context context, @NonNull AdTemplate adTemplate) {
        AdWebViewActivityProxy.launch(context, new AdWebViewActivityProxy.a.C0182a().av(com.kwad.sdk.core.response.a.b.bg(adTemplate)).L(adTemplate).aB(true).oc());
    }
}
