package com.martian.libmars.ui.theme;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.martian.libmars.R;
import com.martian.libmars.common.ConfigSingleton;
import k9.a;

/* loaded from: classes3.dex */
public class ThemeView extends View implements a {

    /* renamed from: b */
    public int f12392b;

    public ThemeView(Context context) {
        super(context);
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ThemeView);
        this.f12392b = obtainStyledAttributes.getColor(R.styleable.ThemeView_viewBackgroundType, 0);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        p();
        ConfigSingleton.D().h(this);
    }

    @Override // android.view.View
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
            int i11 = this.f12392b;
            if (i11 == 1) {
                i10 = R.color.night_background_secondary;
            } else if (i11 == 2) {
                i10 = R.color.night_text_color_unclickable;
            } else if (i11 == 3) {
                i10 = R.color.night_divider_color;
            } else if (i11 == 4) {
                setBackgroundResource(R.drawable.bg_book_cover_shade_night);
                return;
            } else {
                if (i11 == 5) {
                    setBackgroundResource(R.drawable.bg_divider_line_top_night);
                    return;
                }
                i10 = R.color.night_background;
            }
        } else {
            int i12 = this.f12392b;
            if (i12 == 1) {
                i10 = R.color.light_grey;
            } else if (i12 == 2) {
                i10 = R.color.day_text_color_thirdly;
            } else if (i12 == 3) {
                i10 = R.color.day_divider_color;
            } else if (i12 == 4) {
                setBackgroundResource(R.drawable.bg_book_cover_shade_day);
                return;
            } else {
                if (i12 == 5) {
                    setBackgroundResource(R.drawable.bg_divider_line_top);
                    return;
                }
                i10 = R.color.white;
            }
        }
        setBackgroundColor(ContextCompat.getColor(getContext(), i10));
    }

    public void setType(int i10) {
        this.f12392b = i10;
        invalidate();
    }

    public ThemeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        a(context, attributeSet);
    }

    public ThemeView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        a(context, attributeSet);
    }
}
