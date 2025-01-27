package com.kwad.components.ad.c;

import android.view.View;
import androidx.annotation.NonNull;

/* loaded from: classes2.dex */
public final class e extends com.kwad.components.core.widget.a.b {
    public e(@NonNull View view, int i10) {
        super(view, i10);
    }

    @Override // com.kwad.components.core.widget.a.b, com.kwad.components.core.widget.a.a
    public final boolean ad() {
        com.kwad.sdk.core.c.b.Fi();
        if (!com.kwad.sdk.core.c.b.isEnable()) {
            return super.ad();
        }
        com.kwad.sdk.core.c.b.Fi();
        return com.kwad.sdk.core.c.b.isAppOnForeground() && super.ad();
    }
}
