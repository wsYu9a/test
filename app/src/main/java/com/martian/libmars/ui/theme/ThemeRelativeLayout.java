package com.martian.libmars.ui.theme;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import com.martian.libmars.d.h;
import com.martian.theme.yellow.R;
import g.a;

/* loaded from: classes2.dex */
public class ThemeRelativeLayout extends RelativeLayout implements a {

    /* renamed from: a */
    private int f10103a;

    public ThemeRelativeLayout(Context context) {
        super(context);
    }

    private void a(Context context, AttributeSet attrs) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.ThemeLinearLayout);
        this.f10103a = obtainStyledAttributes.getColor(R.styleable.ThemeLinearLayout_backgroundType, 0);
        obtainStyledAttributes.recycle();
    }

    @Override // g.a
    public void g() {
        int i2;
        if (h.F().I0()) {
            i2 = this.f10103a == 1 ? com.martian.libmars.R.color.night_background_secondary : com.martian.libmars.R.color.night_background;
        } else {
            int i3 = this.f10103a;
            i2 = i3 == 1 ? com.martian.libmars.R.color.light_grey : i3 == 2 ? com.martian.libmars.R.color.light_grey_bg : com.martian.libmars.R.color.white;
        }
        setBackgroundColor(ContextCompat.getColor(getContext(), i2));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        g();
        h.F().a(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h.F().j1(this);
    }

    public ThemeRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        a(context, attrs);
    }

    public ThemeRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        a(context, attrs);
    }
}
