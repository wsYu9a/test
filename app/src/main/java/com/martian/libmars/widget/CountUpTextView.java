package com.martian.libmars.widget;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.martian.libmars.R;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.widget.CountUpTextView;
import java.util.Locale;
import k9.a;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes3.dex */
public class CountUpTextView extends TextView implements a {

    /* renamed from: e */
    public static final int f12522e = 1000;

    /* renamed from: b */
    public int f12523b;

    /* renamed from: c */
    public float f12524c;

    /* renamed from: d */
    public int f12525d;

    public CountUpTextView(Context context) {
        super(context);
        this.f12523b = 0;
        this.f12524c = 0.0f;
        c();
    }

    private void c() {
        p();
    }

    private void f(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ThemeCountUpTextView);
        this.f12525d = obtainStyledAttributes.getColor(R.styleable.ThemeCountUpTextView_countUpTextViewBackgroundType, 0);
        obtainStyledAttributes.recycle();
    }

    public final /* synthetic */ void d(int i10, ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        if (((int) floatValue) - floatValue == 0.0f) {
            setText(String.valueOf(floatValue));
            return;
        }
        setText(String.format(Locale.getDefault(), "%." + i10 + "f", valueAnimator.getAnimatedValue()));
    }

    public final /* synthetic */ void e(String str, ValueAnimator valueAnimator) {
        setText(str + valueAnimator.getAnimatedValue().toString());
    }

    public void g(float f10, float f11, int i10) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f10, f11);
        ofFloat.setDuration(1000L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: n9.d

            /* renamed from: c */
            public final /* synthetic */ int f28808c;

            public /* synthetic */ d(int i102) {
                i10 = i102;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                CountUpTextView.this.d(i10, valueAnimator);
            }
        });
        ofFloat.start();
    }

    public void h(int i10, int i11) {
        i(i10, i11, "");
    }

    public void i(int i10, int i11, String str) {
        ValueAnimator ofInt = ValueAnimator.ofInt(i10, i11);
        ofInt.setDuration(1000L);
        ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: n9.c

            /* renamed from: c */
            public final /* synthetic */ String f28806c;

            public /* synthetic */ c(String str2) {
                str = str2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                CountUpTextView.this.e(str, valueAnimator);
            }
        });
        ofInt.start();
    }

    public void j(float f10, int i10) {
        float f11 = this.f12524c;
        if (f10 > f11) {
            g(f11, f10, i10);
        } else if (((int) f10) - f10 == 0.0f) {
            setText(String.valueOf(f10));
        } else {
            setText(String.format(Locale.getDefault(), "%." + i10 + "f", Float.valueOf(f10)));
        }
        this.f12524c = f10;
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
        int i10;
        if (isInEditMode() || this.f12525d == -1) {
            return;
        }
        if (ConfigSingleton.D().A0()) {
            int i11 = this.f12525d;
            i10 = i11 == 3 ? R.color.night_text_color_unclickable : i11 == 2 ? R.color.night_text_color_thirdly : i11 == 1 ? R.color.night_text_color_secondary : R.color.night_text_color_primary;
        } else {
            int i12 = this.f12525d;
            i10 = i12 == 3 ? R.color.day_text_color_unclickable : i12 == 2 ? R.color.day_text_color_thirdly : i12 == 1 ? R.color.day_text_color_secondary : R.color.day_text_color_primary;
        }
        setTextColor(ContextCompat.getColor(getContext(), i10));
    }

    public void setNumber(int i10) {
        this.f12523b = i10;
        this.f12524c = i10;
    }

    public void setNumberText(int i10) {
        int i11 = this.f12523b;
        if (i10 > i11) {
            h(i11, i10);
        } else {
            setText(String.valueOf(i10));
        }
        this.f12523b = i10;
    }

    public void setNumber(float f10) {
        this.f12523b = (int) f10;
        this.f12524c = f10;
    }

    public CountUpTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12523b = 0;
        this.f12524c = 0.0f;
        f(context, attributeSet);
        c();
    }

    public CountUpTextView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f12523b = 0;
        this.f12524c = 0.0f;
        f(context, attributeSet);
        c();
    }
}
