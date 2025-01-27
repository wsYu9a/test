package com.martian.libmars.ui.theme;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.martian.libmars.R;
import com.martian.libmars.common.ConfigSingleton;
import k9.a;

/* loaded from: classes3.dex */
public class ThemeFrameLayout extends FrameLayout implements a {

    /* renamed from: b */
    public int f12372b;

    public ThemeFrameLayout(Context context) {
        super(context);
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ThemeFrameLayout);
        this.f12372b = obtainStyledAttributes.getColor(R.styleable.ThemeFrameLayout_frameBackgroundType, 0);
        obtainStyledAttributes.recycle();
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
        int i10;
        if (isInEditMode()) {
            return;
        }
        if (ConfigSingleton.D().A0()) {
            i10 = this.f12372b == 1 ? R.color.night_background_secondary : R.color.night_background;
        } else {
            int i11 = this.f12372b;
            i10 = i11 == 1 ? R.color.light_grey : i11 == 2 ? R.color.light_grey_bg : R.color.white;
        }
        setBackgroundColor(ContextCompat.getColor(getContext(), i10));
    }

    public ThemeFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public ThemeFrameLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        a(context, attributeSet);
    }
}
