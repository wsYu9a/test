package com.martian.mibook.ui.reader;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.R;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.data.theme.MiReadingTheme;
import k9.a;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes3.dex */
public class ReaderThemeItemTextView extends TextView implements View.OnTouchListener, a {

    /* renamed from: b */
    public boolean f16032b;

    /* renamed from: c */
    public int f16033c;

    /* renamed from: d */
    public Typeface f16034d;

    public ReaderThemeItemTextView(Context context) {
        super(context);
        this.f16032b = true;
        this.f16033c = 0;
        this.f16034d = Typeface.DEFAULT;
        a();
    }

    private void a() {
        if (Build.VERSION.SDK_INT >= 28) {
            setFallbackLineSpacing(false);
        }
        setOnTouchListener(this);
        p();
        if (this.f16032b) {
            setClickable(true);
        }
    }

    private void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ReaderThemeItemTextView);
        this.f16032b = obtainStyledAttributes.getBoolean(R.styleable.ReaderThemeItemTextView_itemClickable, true);
        this.f16033c = obtainStyledAttributes.getInt(R.styleable.ReaderThemeItemTextView_isButton, 0);
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

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.f16032b) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            setAlpha(0.6f);
        } else if (action == 1 || action == 3) {
            setAlpha(1.0f);
        }
        return false;
    }

    @Override // k9.a
    public void p() {
        if (isInEditMode()) {
            return;
        }
        MiReadingTheme k10 = MiConfigSingleton.b2().h2().k();
        int i10 = this.f16033c;
        if (i10 == 1) {
            setTextColor(ContextCompat.getColor(getContext(), com.martian.libmars.R.color.white));
            setBackground(k10.getBorderLineBackgroundSelectedDrawable(getContext()));
        } else if (i10 == 2) {
            setTextColor(k10.getTextColorPrimary());
            setBackground(k10.getBorderBackgroundLightButtonDrawable(getContext()));
        } else if (i10 == 3) {
            setTextColor(ContextCompat.getColor(getContext(), com.martian.libmars.R.color.white));
            if (MiConfigSingleton.b2().h2().s()) {
                setBackgroundColor(ContextCompat.getColor(getContext(), com.martian.libmars.R.color.theme_default));
            } else {
                setBackgroundColor(k10.getItemColorPrimary());
            }
        } else if (i10 == 4) {
            setTextColor(k10.getItemColorPrimary());
        } else if (i10 == 5) {
            setTextColor(k10.getTextColorThirdly());
            setBackground(k10.getBorderBackgroundLightButtonDrawable(getContext()));
        } else if (i10 == 6) {
            setTextColor(k10.getItemColorPrimary());
            setBackground(k10.getBorderBackgroundLightButtonDrawable(getContext()));
        } else if (i10 == 7) {
            setTextColor(k10.getTextColorPrimary());
            setBackground(k10.getRoundBgResTextThirdlyDrawable(getContext()));
        } else {
            setTextColor(k10.getTextColorPrimary());
        }
        Typeface g10 = MiConfigSingleton.b2().i2().g();
        if (this.f16034d != g10) {
            this.f16034d = g10;
            setTypeface(g10);
            setIncludeFontPadding(g10 == Typeface.DEFAULT);
        }
    }

    public ReaderThemeItemTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        b(context, attributeSet);
        a();
    }

    public ReaderThemeItemTextView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f16032b = true;
        this.f16033c = 0;
        this.f16034d = Typeface.DEFAULT;
        b(context, attributeSet);
        a();
    }
}
