package com.kwad.components.core.widget.kwai;

import android.view.View;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.bl;

/* loaded from: classes2.dex */
public class b extends a {
    private View mRootView;

    public b(@NonNull View view, int i2) {
        super(view, i2);
        this.mRootView = view;
    }

    @Override // com.kwad.components.core.widget.kwai.a
    public boolean et() {
        return bl.a(this.mRootView, 70, true);
    }
}
