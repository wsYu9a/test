package com.martian.libmars.ui.theme;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import androidx.core.content.ContextCompat;
import com.martian.libmars.R;
import com.martian.libmars.d.h;
import g.a;

/* loaded from: classes2.dex */
public class MiSwitchButton extends CompoundButton implements a {

    /* renamed from: a */
    private int f10092a;

    public MiSwitchButton(Context context) {
        super(context);
        a();
    }

    private void a() {
        setBackgroundColor(getResources().getColor(R.color.transparent));
        setCompoundDrawablesWithIntrinsicBounds(0, 0, h.F().m0(), 0);
        setSelected(isChecked());
        setClickable(true);
    }

    private void b(Context context, AttributeSet attrs) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, com.martian.theme.yellow.R.styleable.ThemeTextView);
        this.f10092a = obtainStyledAttributes.getInteger(com.martian.theme.yellow.R.styleable.ThemeTextView_textColorType, 0);
        obtainStyledAttributes.recycle();
    }

    @Override // g.a
    public void g() {
        int i2;
        if (this.f10092a == -1) {
            return;
        }
        if (h.F().I0()) {
            int i3 = this.f10092a;
            i2 = i3 != 1 ? i3 != 2 ? R.color.night_text_color_primary : R.color.night_text_color_thirdly : R.color.night_text_color_secondary;
        } else {
            int i4 = this.f10092a;
            i2 = i4 != 1 ? i4 != 2 ? R.color.day_text_color_primary : R.color.day_text_color_thirdly : R.color.day_text_color_secondary;
        }
        setTextColor(ContextCompat.getColor(getContext(), i2));
        setCompoundDrawablesWithIntrinsicBounds(0, 0, h.F().m0(), 0);
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

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean checked) {
        super.setChecked(checked);
        setSelected(checked);
    }

    public MiSwitchButton(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
        b(context, attrs);
        a();
    }

    public MiSwitchButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        b(context, attrs);
        a();
    }
}
