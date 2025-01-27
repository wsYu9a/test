package com.martian.libmars.ui.theme;

import android.content.Context;
import android.util.AttributeSet;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import com.martian.libmars.R;
import com.martian.libmars.common.ConfigSingleton;
import k9.a;

/* loaded from: classes3.dex */
public class ThemeCardView extends CardView implements a {
    public ThemeCardView(Context context) {
        super(context);
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
        setCardBackgroundColor(ContextCompat.getColor(getContext(), ConfigSingleton.D().A0() ? R.color.night_background_secondary : R.color.light_grey));
    }

    public ThemeCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ThemeCardView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
