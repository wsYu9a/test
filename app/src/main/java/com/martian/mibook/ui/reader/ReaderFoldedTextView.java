package com.martian.mibook.ui.reader;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.widget.FoldedTextView;
import com.martian.mibook.R;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.data.theme.MiReadingTheme;
import k9.a;

/* loaded from: classes3.dex */
public class ReaderFoldedTextView extends FoldedTextView implements a {
    public boolean H;
    public int I;
    public Typeface J;

    public ReaderFoldedTextView(Context context) {
        super(context);
        this.J = Typeface.DEFAULT;
        s();
    }

    private void H(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ReaderFoldedTextView);
        this.I = obtainStyledAttributes.getColor(R.styleable.ReaderFoldedTextView_readerFoldedTextColorType, 0);
        obtainStyledAttributes.recycle();
    }

    private void s() {
        p();
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.H) {
            return;
        }
        this.H = true;
        p();
        ConfigSingleton.D().h(this);
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.H = false;
        ConfigSingleton.D().X0(this);
    }

    @Override // k9.a
    public void p() {
        if (isInEditMode()) {
            return;
        }
        Typeface g10 = MiConfigSingleton.b2().i2().g();
        if (this.J != g10) {
            this.J = g10;
            setTypeface(g10);
            setIncludeFontPadding(g10 == Typeface.DEFAULT);
            y(g10);
            v(g10);
        }
        MiReadingTheme k10 = MiConfigSingleton.b2().h2().k();
        int i10 = this.I;
        if (i10 == 2) {
            setTextColor(k10.getTextColorThirdly());
        } else if (i10 == 1) {
            setTextColor(k10.getTextColorSecondary());
        } else {
            setTextColor(k10.getTextColorPrimary());
        }
        u(k10.getTextColorThirdly());
        x(k10.getTextColorThirdly());
        q();
    }

    public ReaderFoldedTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        H(context, attributeSet);
        s();
    }

    public ReaderFoldedTextView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.J = Typeface.DEFAULT;
        H(context, attributeSet);
        s();
    }
}
