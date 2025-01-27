package com.martian.libmars.ui.theme;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import com.martian.libmars.R;
import com.martian.libmars.common.ConfigSingleton;
import k9.a;

/* loaded from: classes3.dex */
public class ThemeRelativeLayout extends RelativeLayout implements a {

    /* renamed from: b */
    public int f12388b;

    public ThemeRelativeLayout(Context context) {
        super(context);
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ThemeRelativeLayout);
        this.f12388b = obtainStyledAttributes.getColor(R.styleable.ThemeRelativeLayout_relativeBackgroundType, 0);
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
        if (isInEditMode() || this.f12388b < 0) {
            return;
        }
        if (ConfigSingleton.D().A0()) {
            int i11 = this.f12388b;
            if (i11 == 1) {
                i10 = R.color.night_background_secondary;
            } else {
                if (i11 == 3) {
                    setBackgroundResource(R.drawable.border_background_top_round_night_16dp);
                    return;
                }
                i10 = i11 == 4 ? R.color.night_background_card : R.color.night_background;
            }
        } else {
            int i12 = this.f12388b;
            if (i12 == 1) {
                i10 = R.color.light_grey;
            } else if (i12 == 2) {
                i10 = R.color.light_grey_bg;
            } else {
                if (i12 == 3) {
                    setBackgroundResource(R.drawable.border_background_top_round_day_16dp);
                    return;
                }
                i10 = i12 == 4 ? R.color.white : R.color.white;
            }
        }
        setBackgroundColor(ContextCompat.getColor(getContext(), i10));
    }

    public void setType(int i10) {
        this.f12388b = i10;
    }

    public ThemeRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public ThemeRelativeLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        a(context, attributeSet);
    }
}
