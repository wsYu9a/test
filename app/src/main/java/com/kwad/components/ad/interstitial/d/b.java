package com.kwad.components.ad.interstitial.d;

import android.view.View;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.bl;

/* loaded from: classes.dex */
public final class b extends com.kwad.components.core.widget.kwai.a {
    private View mRootView;

    public b(@NonNull View view, int i2) {
        super(view, 100);
        this.mRootView = view;
    }

    @Override // com.kwad.components.core.widget.kwai.a
    public final boolean et() {
        return bl.o(this.mRootView, 100);
    }
}
