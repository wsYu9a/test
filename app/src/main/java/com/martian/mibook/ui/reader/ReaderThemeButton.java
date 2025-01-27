package com.martian.mibook.ui.reader;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.R;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.data.theme.MiReadingTheme;
import k9.a;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes3.dex */
public class ReaderThemeButton extends Button implements a {

    /* renamed from: b */
    public boolean f16024b;

    /* renamed from: c */
    public int f16025c;

    /* renamed from: d */
    public Typeface f16026d;

    public ReaderThemeButton(Context context) {
        super(context);
        this.f16024b = true;
        this.f16026d = Typeface.DEFAULT;
        a();
    }

    private void a() {
        p();
    }

    private void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ReaderThemeButton);
        this.f16025c = obtainStyledAttributes.getInt(R.styleable.ReaderThemeButton_buttonType, 0);
        obtainStyledAttributes.recycle();
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
        if (this.f16024b && this.f16025c > 0) {
            MiReadingTheme k10 = MiConfigSingleton.b2().h2().k();
            setTextColor(k10.getItemColorPrimary());
            setBackground(k10.getBorderBackgroundLightButtonDrawable(getContext()));
        }
        Typeface g10 = MiConfigSingleton.b2().i2().g();
        if (this.f16026d != g10) {
            this.f16026d = g10;
            setTypeface(g10);
            setIncludeFontPadding(g10 == Typeface.DEFAULT);
        }
    }

    public void setFollowTheme(boolean z10) {
        this.f16024b = z10;
    }

    public ReaderThemeButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        b(context, attributeSet);
        a();
    }

    public ReaderThemeButton(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f16024b = true;
        this.f16026d = Typeface.DEFAULT;
        b(context, attributeSet);
        a();
    }
}
