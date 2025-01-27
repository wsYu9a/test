package com.martian.libmars.ui.theme;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.martian.libmars.d.h;
import com.martian.theme.yellow.R;
import g.a;

/* loaded from: classes2.dex */
public class ThemeView extends View implements a {

    /* renamed from: a */
    private int f10108a;

    public ThemeView(Context context) {
        super(context);
    }

    private void a(Context context, AttributeSet attrs) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.ThemeLinearLayout);
        this.f10108a = obtainStyledAttributes.getColor(R.styleable.ThemeLinearLayout_backgroundType, 0);
        obtainStyledAttributes.recycle();
    }

    @Override // g.a
    public void g() {
        int i2;
        if (h.F().I0()) {
            int i3 = this.f10108a;
            if (i3 == 1) {
                i2 = com.martian.libmars.R.color.night_background_secondary;
            } else if (i3 == 2) {
                i2 = com.martian.libmars.R.color.night_text_color_unclickable;
            } else if (i3 == 3) {
                i2 = com.martian.libmars.R.color.night_divider_color;
            } else if (i3 == 4) {
                setBackgroundResource(com.martian.libmars.R.drawable.bg_book_cover_shade_night);
                return;
            } else {
                if (i3 == 5) {
                    setBackgroundResource(com.martian.libmars.R.drawable.bg_divider_line_top_night);
                    return;
                }
                i2 = com.martian.libmars.R.color.night_background;
            }
        } else {
            int i4 = this.f10108a;
            if (i4 == 1) {
                i2 = com.martian.libmars.R.color.light_grey;
            } else if (i4 == 2) {
                i2 = com.martian.libmars.R.color.day_text_color_thirdly;
            } else if (i4 == 3) {
                i2 = com.martian.libmars.R.color.day_divider_color;
            } else if (i4 == 4) {
                setBackgroundResource(com.martian.libmars.R.drawable.bg_book_cover_shade_day);
                return;
            } else {
                if (i4 == 5) {
                    setBackgroundResource(com.martian.libmars.R.drawable.bg_divider_line_top);
                    return;
                }
                i2 = com.martian.libmars.R.color.white;
            }
        }
        setBackgroundColor(ContextCompat.getColor(getContext(), i2));
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        g();
        h.F().a(this);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h.F().j1(this);
    }

    public void setType(int type) {
        this.f10108a = type;
        invalidate();
    }

    public ThemeView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        a(context, attrs);
    }

    public ThemeView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        a(context, attrs);
    }
}
