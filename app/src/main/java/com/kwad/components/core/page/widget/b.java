package com.kwad.components.core.page.widget;

import android.content.Context;
import android.view.TextureView;
import androidx.annotation.RequiresApi;

@RequiresApi(api = 14)
/* loaded from: classes2.dex */
public final class b extends TextureView {
    public b(Context context) {
        super(context);
    }

    @Override // android.view.View
    protected final void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
