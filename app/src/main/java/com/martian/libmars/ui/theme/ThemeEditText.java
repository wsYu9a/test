package com.martian.libmars.ui.theme;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;
import androidx.core.content.ContextCompat;
import com.martian.libmars.R;
import com.martian.libmars.d.h;
import g.a;

/* loaded from: classes2.dex */
public class ThemeEditText extends EditText implements a {
    public ThemeEditText(Context context) {
        super(context);
        a();
    }

    private void a() {
        setFocusableInTouchMode(true);
    }

    @Override // g.a
    public void g() {
        if (h.F().I0()) {
            setTextColor(ContextCompat.getColor(getContext(), R.color.night_text_color_primary));
            setHintTextColor(ContextCompat.getColor(getContext(), R.color.night_text_color_thirdly));
        } else {
            setTextColor(ContextCompat.getColor(getContext(), R.color.day_text_color_primary));
            setHintTextColor(ContextCompat.getColor(getContext(), R.color.day_text_color_thirdly));
        }
    }

    @Override // android.widget.TextView, android.view.View
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

    public ThemeEditText(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
        a();
    }

    public ThemeEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        a();
    }
}
