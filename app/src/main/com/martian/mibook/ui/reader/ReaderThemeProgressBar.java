package com.martian.mibook.ui.reader;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.R;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.data.theme.MiReadingTheme;
import k9.a;

/* loaded from: classes3.dex */
public class ReaderThemeProgressBar extends ProgressBar implements a {

    /* renamed from: b */
    public int f16040b;

    public ReaderThemeProgressBar(Context context) {
        super(context);
        a();
    }

    private void a() {
        p();
    }

    private void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ReaderThemeProgressBar);
        this.f16040b = obtainStyledAttributes.getInt(R.styleable.ReaderThemeProgressBar_type, 0);
        obtainStyledAttributes.recycle();
    }

    private void c(int i10, int i11, int i12, float f10, float f11) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i11);
        gradientDrawable.setAlpha(i12);
        gradientDrawable.setCornerRadius(f11);
        ClipDrawable clipDrawable = new ClipDrawable(gradientDrawable, 3, 1);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(i10);
        gradientDrawable2.setCornerRadius(f10);
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gradientDrawable2, clipDrawable});
        layerDrawable.setId(0, android.R.id.background);
        layerDrawable.setId(1, android.R.id.progress);
        setProgressDrawable(layerDrawable);
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        p();
        ConfigSingleton.D().h(this);
    }

    @Override // android.widget.ProgressBar, android.view.View
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
        int i10 = this.f16040b;
        if (i10 == 0) {
            setProgressDrawable(k10.getProgressBarBackgroundDrawable(getContext()));
            return;
        }
        if (i10 == 1) {
            c(0, k10.getItemColorPrimary(), 25, 0.0f, 0.0f);
            return;
        }
        if (i10 == 2) {
            c(0, k10.getTextColorThirdly(), 255, 0.0f, ConfigSingleton.i(0.5f));
        } else if (i10 == 3) {
            c(0, getContext().getResources().getColor(R.color.colorRed), 255, 0.0f, ConfigSingleton.i(0.5f));
        }
    }

    public void setProgressBarStyleType(int i10) {
        this.f16040b = i10;
        p();
    }

    public ReaderThemeProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        b(context, attributeSet);
        a();
    }

    public ReaderThemeProgressBar(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        b(context, attributeSet);
        a();
    }
}
