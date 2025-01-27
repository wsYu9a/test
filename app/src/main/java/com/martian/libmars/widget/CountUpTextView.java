package com.martian.libmars.widget;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.martian.theme.yellow.R;
import java.util.Locale;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes2.dex */
public class CountUpTextView extends TextView implements g.a {

    /* renamed from: a */
    private static final int f10311a = 1000;

    /* renamed from: b */
    private int f10312b;

    /* renamed from: c */
    private float f10313c;

    /* renamed from: d */
    private int f10314d;

    public CountUpTextView(Context context) {
        super(context);
        this.f10312b = 0;
        this.f10313c = 0.0f;
        a();
    }

    private void a() {
        g();
    }

    /* renamed from: b */
    public /* synthetic */ void c(final int dot, ValueAnimator valueAnimator1) {
        float floatValue = ((Float) valueAnimator1.getAnimatedValue()).floatValue();
        if (((int) floatValue) - floatValue == 0.0f) {
            setText(String.valueOf(floatValue));
            return;
        }
        setText(String.format(Locale.getDefault(), "%." + dot + "f", valueAnimator1.getAnimatedValue()));
    }

    /* renamed from: d */
    public /* synthetic */ void e(final String str, ValueAnimator valueAnimator1) {
        setText(str + valueAnimator1.getAnimatedValue().toString());
    }

    private void f(Context context, AttributeSet attrs) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.ThemeTextView);
        this.f10314d = obtainStyledAttributes.getColor(R.styleable.ThemeTextView_textColorType, 0);
        obtainStyledAttributes.recycle();
    }

    @Override // g.a
    public void g() {
        int i2;
        if (this.f10314d == -1) {
            return;
        }
        if (com.martian.libmars.d.h.F().I0()) {
            int i3 = this.f10314d;
            i2 = i3 == 3 ? com.martian.libmars.R.color.night_text_color_unclickable : i3 == 2 ? com.martian.libmars.R.color.night_text_color_thirdly : i3 == 1 ? com.martian.libmars.R.color.night_text_color_secondary : com.martian.libmars.R.color.night_text_color_primary;
        } else {
            int i4 = this.f10314d;
            i2 = i4 == 3 ? com.martian.libmars.R.color.day_text_color_unclickable : i4 == 2 ? com.martian.libmars.R.color.day_text_color_thirdly : i4 == 1 ? com.martian.libmars.R.color.day_text_color_secondary : com.martian.libmars.R.color.day_text_color_primary;
        }
        setTextColor(ContextCompat.getColor(getContext(), i2));
    }

    public void h() {
        this.f10312b = 0;
        this.f10313c = 0.0f;
    }

    public void i(float oldNumber, float newNumber, final int dot) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(oldNumber, newNumber);
        ofFloat.setDuration(1000L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.martian.libmars.widget.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                CountUpTextView.this.c(dot, valueAnimator);
            }
        });
        ofFloat.start();
    }

    public void j(int oldNumber, int newNumber) {
        k(oldNumber, newNumber, "");
    }

    public void k(int oldNumber, int newNumber, final String str) {
        if (!com.martian.libsupport.l.q()) {
            setText(str);
            return;
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(oldNumber, newNumber);
        ofInt.setDuration(1000L);
        ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.martian.libmars.widget.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                CountUpTextView.this.e(str, valueAnimator);
            }
        });
        ofInt.start();
    }

    public void l(float newNumber, int dot) {
        if (newNumber > this.f10313c && com.martian.libsupport.l.q()) {
            i(this.f10313c, newNumber, dot);
        } else if (((int) newNumber) - newNumber == 0.0f) {
            setText(String.valueOf(newNumber));
        } else {
            setText(String.format(Locale.getDefault(), "%." + dot + "f", Float.valueOf(newNumber)));
        }
        this.f10313c = newNumber;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        g();
        com.martian.libmars.d.h.F().a(this);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.martian.libmars.d.h.F().j1(this);
    }

    public void setNumber(int newNumber) {
        this.f10312b = newNumber;
        this.f10313c = newNumber;
    }

    public void setNumberText(int newNumber) {
        int i2 = this.f10312b;
        if (newNumber > i2) {
            j(i2, newNumber);
        } else {
            setText(String.valueOf(newNumber));
        }
        this.f10312b = newNumber;
    }

    public void setNumber(float newNumber) {
        this.f10312b = (int) newNumber;
        this.f10313c = newNumber;
    }

    public CountUpTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f10312b = 0;
        this.f10313c = 0.0f;
        f(context, attrs);
        a();
    }

    public CountUpTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f10312b = 0;
        this.f10313c = 0.0f;
        f(context, attrs);
        a();
    }
}
