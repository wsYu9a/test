package com.kwad.components.ad.interstitial.g;

import android.view.View;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.bw;

/* loaded from: classes2.dex */
public final class b extends com.kwad.components.core.widget.a.a {
    private View mRootView;

    public b(@NonNull View view, int i10) {
        super(view, i10);
        this.mRootView = view;
    }

    @Override // com.kwad.components.core.widget.a.a
    public final boolean ad() {
        return bw.o(this.mRootView, 100);
    }
}
