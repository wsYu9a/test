package com.martian.mibook.ui.reader;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import com.martian.libmars.d.h;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.lib.model.data.MiReadingTheme;
import com.martian.ttbookhd.R;

/* loaded from: classes4.dex */
public class ReaderThemeSwitchButton extends CompoundButton implements g.a {
    public ReaderThemeSwitchButton(Context context) {
        super(context);
        a();
    }

    private void a() {
        setBackgroundColor(getResources().getColor(R.color.transparent));
        setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.selector_default_day, 0);
        setSelected(isChecked());
        setClickable(true);
    }

    private void b(Context context, AttributeSet attrs) {
        context.obtainStyledAttributes(attrs, com.martian.theme.yellow.R.styleable.ThemeTextView).recycle();
    }

    @Override // g.a
    public void g() {
        MiReadingTheme r = MiConfigSingleton.V3().J4.r();
        setCompoundDrawablesWithIntrinsicBounds(0, 0, r.getSelectorRes(), 0);
        setTextColor(r.getTextColorPrimary());
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

    public ReaderThemeSwitchButton(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
        b(context, attrs);
        a();
    }

    public ReaderThemeSwitchButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        b(context, attrs);
        a();
    }
}
