package com.martian.libmars.ui.theme;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import androidx.core.content.ContextCompat;
import com.martian.libmars.R;
import com.martian.libmars.common.ConfigSingleton;
import k9.a;

/* loaded from: classes3.dex */
public class ThemeProgressBar extends ProgressBar implements a {

    /* renamed from: b */
    public int f12387b;

    public ThemeProgressBar(Context context) {
        super(context);
        a();
    }

    private void a() {
        p();
    }

    private void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ThemeProgressBar);
        this.f12387b = obtainStyledAttributes.getInt(R.styleable.ThemeProgressBar_progressBarStyleType, 0);
        obtainStyledAttributes.recycle();
    }

    public final int c(int i10, int i11) {
        return Color.argb((int) ((i11 / 100.0d) * 255.0d), Color.red(i10), Color.green(i10), Color.blue(i10));
    }

    public final void d(int i10, int i11, int i12, float f10, float f11) {
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

    public final void e(int i10, int[] iArr, int i11, float f10, float f11) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColors(iArr);
        gradientDrawable.setAlpha(i11);
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
        int i10 = this.f12387b;
        if (i10 == 0) {
            int i11 = ConfigSingleton.i(25.0f);
            int color = ContextCompat.getColor(getContext(), R.color.theme_default);
            d(c(color, 10), color, 255, 0.0f, i11);
        } else if (i10 == 1) {
            e(ContextCompat.getColor(getContext(), R.color.vip_bg_day_color), new int[]{ContextCompat.getColor(getContext(), R.color.vip_bg_start_color), ContextCompat.getColor(getContext(), R.color.vip_bg_end_color)}, 255, 0.0f, ConfigSingleton.i(25.0f));
        }
    }

    public void setProgressBarStyleType(int i10) {
        this.f12387b = i10;
        p();
    }

    public ThemeProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        b(context, attributeSet);
        a();
    }

    public ThemeProgressBar(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        b(context, attributeSet);
        a();
    }
}
