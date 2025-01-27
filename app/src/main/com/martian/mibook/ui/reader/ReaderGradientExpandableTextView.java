package com.martian.mibook.ui.reader;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.AttributeSet;
import androidx.core.content.ContextCompat;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.widget.GradientExpandableTextView;
import com.martian.mibook.R;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.data.theme.MiReadingTheme;
import k9.a;

/* loaded from: classes3.dex */
public class ReaderGradientExpandableTextView extends GradientExpandableTextView implements a {

    /* renamed from: t */
    public boolean f16016t;

    /* renamed from: u */
    public int f16017u;

    /* renamed from: v */
    public int f16018v;

    /* renamed from: w */
    public Typeface f16019w;

    public ReaderGradientExpandableTextView(Context context) {
        super(context);
        this.f16019w = Typeface.DEFAULT;
        i();
    }

    private void i() {
        p();
    }

    private void j(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ReaderGradientExpandableTextView);
        this.f16017u = obtainStyledAttributes.getColor(R.styleable.ReaderGradientExpandableTextView_readerGradientExpandableTextColorType, 0);
        this.f16018v = obtainStyledAttributes.getColor(R.styleable.ReaderGradientExpandableTextView_readerGradientExpandableBackgroundColorType, 0);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f16016t) {
            return;
        }
        this.f16016t = true;
        p();
        ConfigSingleton.D().h(this);
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f16016t = false;
        ConfigSingleton.D().X0(this);
    }

    @Override // k9.a
    public void p() {
        Context context;
        int i10;
        Context context2;
        int i11;
        if (isInEditMode()) {
            return;
        }
        MiReadingTheme k10 = MiConfigSingleton.b2().h2().k();
        int i12 = this.f16017u;
        if (i12 == 6) {
            setTextColor(k10.getTextColorSecondary());
        } else if (i12 == 5) {
            if (MiConfigSingleton.b2().h2().s()) {
                context2 = getContext();
                i11 = com.martian.libmars.R.color.night_text_color_thirdly;
            } else {
                context2 = getContext();
                i11 = com.martian.libmars.R.color.day_text_color_thirdly;
            }
            setTextColor(ContextCompat.getColor(context2, i11));
        } else if (i12 == 4) {
            if (MiConfigSingleton.b2().h2().s()) {
                context = getContext();
                i10 = com.martian.libmars.R.color.night_text_color_primary;
            } else {
                context = getContext();
                i10 = com.martian.libmars.R.color.day_text_color_primary;
            }
            setTextColor(ContextCompat.getColor(context, i10));
        } else if (i12 == 3) {
            setTextColor(k10.getItemColorPrimary());
        } else if (i12 == 2) {
            setTextColor(k10.getTextColorThirdly());
        } else {
            setTextColor(k10.getTextColorPrimary());
        }
        Typeface g10 = MiConfigSingleton.b2().i2().g();
        if (this.f16019w != g10) {
            this.f16019w = g10;
            setTypeface(g10);
            setIncludeFontPadding(g10 == Typeface.DEFAULT);
        }
        int e10 = this.f16018v == 1 ? MiConfigSingleton.b2().h2().e() : MiConfigSingleton.b2().h2().h();
        setGradientColors(new int[]{Color.argb(16777216, Color.red(e10), Color.green(e10), Color.blue(e10)), e10, e10});
    }

    public ReaderGradientExpandableTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        j(context, attributeSet);
        i();
    }

    public ReaderGradientExpandableTextView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f16019w = Typeface.DEFAULT;
        j(context, attributeSet);
        i();
    }
}
