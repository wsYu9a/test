package com.kwad.components.core.widget;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.RequiresApi;

@RequiresApi(api = 21)
/* loaded from: classes3.dex */
public final class h extends ViewOutlineProvider {
    private float afy;

    private h(float f10) {
        this.afy = f10;
    }

    @RequiresApi(api = 21)
    public static void b(View view, float f10) {
        if (f10 <= 0.0f) {
            view.setOutlineProvider(null);
            view.setClipToOutline(false);
        } else {
            view.setOutlineProvider(new h(f10));
            view.setClipToOutline(true);
        }
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View view, Outline outline) {
        outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.afy);
    }
}
