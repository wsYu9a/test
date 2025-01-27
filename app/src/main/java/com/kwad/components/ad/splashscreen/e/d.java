package com.kwad.components.ad.splashscreen.e;

import android.view.View;
import androidx.annotation.NonNull;

/* loaded from: classes2.dex */
public final class d extends com.kwad.components.core.widget.kwai.b {
    public d(@NonNull View view, int i2) {
        super(view, 70);
    }

    @Override // com.kwad.components.core.widget.kwai.b, com.kwad.components.core.widget.kwai.a
    public final boolean et() {
        com.kwad.sdk.core.b.b.vS();
        if (!com.kwad.sdk.core.b.b.isEnable()) {
            return super.et();
        }
        com.kwad.sdk.core.b.b.vS();
        return com.kwad.sdk.core.b.b.isAppOnForeground() && super.et();
    }
}
