package com.martian.mibook.ui.reader;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import com.martian.libmars.R;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.data.theme.MiReadingTheme;
import k9.a;

/* loaded from: classes3.dex */
public class ReaderThemeSwitchButton extends CompoundButton implements a {

    /* renamed from: b */
    public Typeface f16044b;

    public ReaderThemeSwitchButton(Context context) {
        super(context);
        this.f16044b = Typeface.DEFAULT;
        a();
    }

    private void a() {
        setBackgroundColor(getResources().getColor(R.color.transparent));
        setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.selector_default_day, 0);
        setSelected(isChecked());
        setClickable(true);
    }

    @Override // android.widget.TextView, android.view.View
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
        if (isInEditMode()) {
            return;
        }
        MiReadingTheme k10 = MiConfigSingleton.b2().h2().k();
        setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, k10.getSwitchButtonSelectorDrawable(getContext()), (Drawable) null);
        setTextColor(k10.getTextColorPrimary());
        Typeface g10 = MiConfigSingleton.b2().i2().g();
        if (this.f16044b != g10) {
            this.f16044b = g10;
            setTypeface(g10);
            setIncludeFontPadding(g10 == Typeface.DEFAULT);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z10) {
        super.setChecked(z10);
        setSelected(z10);
    }

    public ReaderThemeSwitchButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f16044b = Typeface.DEFAULT;
        a();
    }

    public ReaderThemeSwitchButton(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f16044b = Typeface.DEFAULT;
        a();
    }
}
