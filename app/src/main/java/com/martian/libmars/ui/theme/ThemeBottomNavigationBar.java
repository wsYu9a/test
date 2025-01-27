package com.martian.libmars.ui.theme;

import android.content.Context;
import android.util.AttributeSet;
import androidx.core.content.ContextCompat;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.martian.libmars.R;
import com.martian.libmars.common.ConfigSingleton;
import k9.a;

/* loaded from: classes3.dex */
public class ThemeBottomNavigationBar extends BottomNavigationView implements a {
    public ThemeBottomNavigationBar(Context context) {
        super(context);
        a();
    }

    private void a() {
        p();
    }

    @Override // com.google.android.material.bottomnavigation.BottomNavigationView, android.view.ViewGroup, android.view.View
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
        setBackgroundColor(ContextCompat.getColor(getContext(), ConfigSingleton.D().A0() ? R.color.night_background_card : R.color.white));
    }

    public ThemeBottomNavigationBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        a();
    }

    public ThemeBottomNavigationBar(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        a();
    }
}
