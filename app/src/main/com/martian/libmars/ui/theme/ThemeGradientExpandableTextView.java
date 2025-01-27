package com.martian.libmars.ui.theme;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import com.martian.libmars.R;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.widget.GradientExpandableTextView;
import k9.a;

/* loaded from: classes3.dex */
public class ThemeGradientExpandableTextView extends GradientExpandableTextView implements a {
    public int A;
    public SpannableString B;

    /* renamed from: t */
    public int f12373t;

    /* renamed from: u */
    public int f12374u;

    /* renamed from: v */
    public int f12375v;

    /* renamed from: w */
    public int f12376w;

    /* renamed from: x */
    public int f12377x;

    /* renamed from: y */
    public int f12378y;

    /* renamed from: z */
    public String f12379z;

    public ThemeGradientExpandableTextView(Context context) {
        super(context);
        this.f12375v = 0;
        this.f12376w = 0;
        this.f12379z = "";
        this.A = 0;
    }

    private void i() {
        p();
    }

    private void j(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ThemeGradientExpandableTextView);
        this.f12373t = obtainStyledAttributes.getColor(R.styleable.ThemeGradientExpandableTextView_gradientExpandableTextColorType, 0);
        this.f12374u = obtainStyledAttributes.getColor(R.styleable.ThemeGradientExpandableTextView_gradientExpandableExtraTextColorType, 0);
        this.f12377x = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ThemeGradientExpandableTextView_gradientExpandableExtraTextSize, 0);
        this.f12378y = obtainStyledAttributes.getInteger(R.styleable.ThemeGradientExpandableTextView_gradientExpandableExtraTextStyle, 0);
        this.f12375v = obtainStyledAttributes.getInteger(R.styleable.ThemeGradientExpandableTextView_gradientExpandableTextTypeFace, 0);
        this.f12376w = obtainStyledAttributes.getColor(R.styleable.ThemeGradientExpandableTextView_gradientBackgroundColorType, 0);
        obtainStyledAttributes.recycle();
    }

    public final void k() {
        int i10 = this.f12374u;
        if (i10 == 3) {
            this.A = ConfigSingleton.D().i0();
        } else if (i10 == 2) {
            this.A = ConfigSingleton.D().j0();
        } else if (i10 == 1) {
            this.A = ConfigSingleton.D().h0();
        }
        if (this.B == null || this.A == 0) {
            return;
        }
        this.B.setSpan(new ForegroundColorSpan(this.A), 0, this.f12379z.length(), 33);
        setText(this.B);
        this.f12614d = true;
        invalidate();
    }

    public void l(String str, String str2) {
        this.f12379z = str;
        if (str.isEmpty()) {
            setText(str2);
            return;
        }
        this.B = new SpannableString(str + str2);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(this.A);
        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(this.f12377x, false);
        int i10 = this.f12378y;
        StyleSpan styleSpan = i10 == 1 ? new StyleSpan(1) : i10 == 2 ? new StyleSpan(2) : null;
        this.B.setSpan(foregroundColorSpan, 0, str.length(), 33);
        this.B.setSpan(absoluteSizeSpan, 0, str.length(), 33);
        if (styleSpan != null) {
            this.B.setSpan(styleSpan, 0, str.length(), 33);
        }
        setText(this.B);
        this.f12614d = true;
        invalidate();
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
        int i10 = this.f12373t;
        if (i10 == 3) {
            setTextColor(ConfigSingleton.D().i0());
        } else if (i10 == 2) {
            setTextColor(ConfigSingleton.D().j0());
        } else {
            setTextColor(ConfigSingleton.D().h0());
        }
        k();
        if (this.f12375v != 0 && ConfigSingleton.D().n0() != null) {
            setTypeface(ConfigSingleton.D().n0());
            setIncludeFontPadding(false);
        }
        int m10 = this.f12376w == 1 ? ConfigSingleton.D().m() : ConfigSingleton.D().n();
        setGradientColors(new int[]{0, m10, m10});
    }

    public void setGradientBackgroundColorType(int i10) {
        if (this.f12376w != i10) {
            this.f12376w = i10;
            invalidate();
        }
    }

    public ThemeGradientExpandableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12375v = 0;
        this.f12376w = 0;
        this.f12379z = "";
        this.A = 0;
        j(context, attributeSet);
        i();
    }

    public ThemeGradientExpandableTextView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f12375v = 0;
        this.f12376w = 0;
        this.f12379z = "";
        this.A = 0;
        j(context, attributeSet);
        i();
    }
}
