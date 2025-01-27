package com.martian.libmars.ui.theme;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.widget.shadowlayout.ShadowLayout;
import k9.a;

/* loaded from: classes3.dex */
public class ThemeShadowLayout extends ShadowLayout implements a {
    public ThemeShadowLayout(Context context) {
        super(context);
        M();
    }

    private void M() {
        p();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        p();
        ConfigSingleton.D().h(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ConfigSingleton.D().X0(this);
    }

    @Override // k9.a
    public void p() {
        if (isInEditMode()) {
            return;
        }
        if (ConfigSingleton.D().A0()) {
            y(Color.parseColor("#80000000"));
        } else {
            y(Color.parseColor("#1A000000"));
        }
    }

    public ThemeShadowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        M();
    }

    public ThemeShadowLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        M();
    }
}
