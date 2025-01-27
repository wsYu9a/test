package com.kwad.components.core.widget;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.RequiresApi;

@RequiresApi(api = 21)
/* loaded from: classes2.dex */
public final class f extends ViewOutlineProvider {
    private float Xb;

    private f(float f2) {
        this.Xb = f2;
    }

    @RequiresApi(api = 21)
    public static void b(View view, float f2) {
        boolean z;
        if (f2 <= 0.0f) {
            view.setOutlineProvider(null);
            z = false;
        } else {
            view.setOutlineProvider(new f(f2));
            z = true;
        }
        view.setClipToOutline(z);
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View view, Outline outline) {
        outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.Xb);
    }
}
