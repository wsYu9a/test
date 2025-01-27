package com.martian.mibook.ui.reader;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.martian.libmars.d.h;
import com.martian.mibook.R;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.lib.model.data.MiReadingTheme;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes4.dex */
public class ReaderThemeItemTextView extends TextView implements View.OnTouchListener, g.a {

    /* renamed from: a */
    private boolean f14835a;

    /* renamed from: b */
    private int f14836b;

    /* renamed from: c */
    private boolean f14837c;

    public ReaderThemeItemTextView(Context context) {
        super(context);
        this.f14835a = true;
        this.f14836b = 0;
        this.f14837c = false;
        a();
    }

    private void a() {
        setOnTouchListener(this);
        g();
        if (this.f14835a) {
            setClickable(true);
        }
    }

    private void b(Context context, AttributeSet attrs) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.ReaderThemeItemTextView);
        this.f14835a = obtainStyledAttributes.getBoolean(1, true);
        this.f14836b = obtainStyledAttributes.getInt(0, 0);
        this.f14837c = obtainStyledAttributes.getBoolean(2, false);
        obtainStyledAttributes.recycle();
    }

    @Override // g.a
    public void g() {
        MiReadingTheme r = MiConfigSingleton.V3().J4.r();
        int i2 = this.f14836b;
        if (i2 == 1) {
            setTextColor(ContextCompat.getColor(getContext(), com.martian.ttbookhd.R.color.white));
            setBackgroundResource(r.getBorderLineBackgroundSelectedRes());
        } else if (i2 == 2) {
            setTextColor(r.getTextColorPrimary());
            setBackgroundResource(r.getBorderBackgroundLightButton());
        } else if (i2 == 3) {
            setTextColor(ContextCompat.getColor(getContext(), com.martian.ttbookhd.R.color.white));
            if (MiConfigSingleton.V3().J4.E()) {
                setBackgroundColor(ContextCompat.getColor(getContext(), com.martian.ttbookhd.R.color.theme_default));
            } else {
                setBackgroundColor(r.getItemColorPrimary());
            }
        } else if (i2 == 4) {
            setTextColor(r.getItemColorPrimary());
        } else if (i2 == 5) {
            setTextColor(r.getTextColorThirdly());
            setBackgroundResource(r.getBorderBackgroundLightButton());
        } else {
            setTextColor(r.getTextColorPrimary());
        }
        if (!this.f14837c || h.F().v0() == null) {
            return;
        }
        setTypeface(h.F().v0());
        setIncludeFontPadding(false);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        if (!this.f14835a) {
            return false;
        }
        int action = event.getAction();
        if (action == 0) {
            setAlpha(0.6f);
        } else if (action == 1 || action == 3) {
            setAlpha(1.0f);
        }
        return false;
    }

    public ReaderThemeItemTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        b(context, attrs);
        a();
    }

    public ReaderThemeItemTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f14835a = true;
        this.f14836b = 0;
        this.f14837c = false;
        b(context, attrs);
        a();
    }
}
