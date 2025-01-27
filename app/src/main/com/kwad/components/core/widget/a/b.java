package com.kwad.components.core.widget.a;

import android.view.View;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.bw;

/* loaded from: classes3.dex */
public class b extends a {
    private View mRootView;

    public b(@NonNull View view, int i10) {
        super(view, i10);
        this.mRootView = view;
    }

    @Override // com.kwad.components.core.widget.a.a
    public boolean ad() {
        return bw.a(this.mRootView, 70, true);
    }
}
