package com.martian.mibook.ui.reader;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.R;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.data.theme.MiReadingTheme;
import k9.a;

/* loaded from: classes3.dex */
public class ReaderThemeTextView extends AppCompatTextView implements a {

    /* renamed from: b */
    public int f16045b;

    /* renamed from: c */
    public Typeface f16046c;

    public ReaderThemeTextView(Context context) {
        super(context);
        this.f16046c = Typeface.DEFAULT;
        a();
    }

    private void a() {
        if (Build.VERSION.SDK_INT >= 28) {
            setFallbackLineSpacing(false);
        }
        p();
    }

    private void f(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ReaderThemeTextView);
        this.f16045b = obtainStyledAttributes.getColor(R.styleable.ReaderThemeTextView_readerTextColorType, 0);
        obtainStyledAttributes.recycle();
    }

    public int getType() {
        return this.f16045b;
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
        Context context;
        int i10;
        Context context2;
        int i11;
        if (isInEditMode()) {
            return;
        }
        Typeface g10 = MiConfigSingleton.b2().i2().g();
        if (this.f16046c != g10) {
            this.f16046c = g10;
            setTypeface(g10);
            setIncludeFontPadding(g10 == Typeface.DEFAULT);
        }
        if (this.f16045b < 0) {
            return;
        }
        MiReadingTheme k10 = MiConfigSingleton.b2().h2().k();
        int i12 = this.f16045b;
        if (i12 == 6) {
            setTextColor(k10.getTextColorSecondary());
            return;
        }
        if (i12 == 5) {
            if (MiConfigSingleton.b2().h2().s()) {
                context2 = getContext();
                i11 = com.martian.libmars.R.color.night_text_color_thirdly;
            } else {
                context2 = getContext();
                i11 = com.martian.libmars.R.color.day_text_color_thirdly;
            }
            setTextColor(ContextCompat.getColor(context2, i11));
            return;
        }
        if (i12 == 4) {
            if (MiConfigSingleton.b2().h2().s()) {
                context = getContext();
                i10 = com.martian.libmars.R.color.night_text_color_primary;
            } else {
                context = getContext();
                i10 = com.martian.libmars.R.color.day_text_color_primary;
            }
            setTextColor(ContextCompat.getColor(context, i10));
            return;
        }
        if (i12 == 3) {
            setTextColor(k10.getItemColorPrimary());
        } else if (i12 == 2) {
            setTextColor(k10.getTextColorThirdly());
        } else {
            setTextColor(k10.getTextColorPrimary());
        }
    }

    public void setType(int i10) {
        this.f16045b = i10;
    }

    public ReaderThemeTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        f(context, attributeSet);
        a();
    }

    public ReaderThemeTextView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f16046c = Typeface.DEFAULT;
        f(context, attributeSet);
        a();
    }
}
