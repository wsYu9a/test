package com.martian.mibook.ui.reader;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.lib.model.data.MiReadingTheme;
import com.martian.theme.yellow.R;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes4.dex */
public class ReaderThemeImageView extends ImageView implements g.a, View.OnTouchListener {

    /* renamed from: a */
    private int f14832a;

    /* renamed from: b */
    private int f14833b;

    /* renamed from: c */
    private boolean f14834c;

    public ReaderThemeImageView(Context context) {
        super(context);
        this.f14834c = true;
        a();
    }

    private void a() {
        if (b()) {
            setOnTouchListener(this);
            setClickable(true);
        }
        g();
    }

    private boolean b() {
        return this.f14833b > 0;
    }

    private void c(Context context, AttributeSet attrs) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.ThemeImageView);
        this.f14832a = obtainStyledAttributes.getColor(0, 0);
        this.f14833b = obtainStyledAttributes.getInt(2, 0);
        obtainStyledAttributes.recycle();
    }

    @Override // g.a
    public void g() {
        if (this.f14834c) {
            MiReadingTheme r = MiConfigSingleton.V3().J4.r();
            int i2 = this.f14832a;
            if (i2 == 6) {
                setColorFilter(r.getBackgroundPrimary());
                return;
            }
            if (i2 == 5) {
                setBackgroundResource(com.martian.ttbookhd.R.drawable.bg_book_more_setting);
                ((GradientDrawable) getBackground()).setColor(r.getBackgroundPrimary());
                setColorFilter(r.getItemColorPrimary());
            } else if (i2 == 4) {
                setBackgroundResource(com.martian.ttbookhd.R.drawable.bg_book_more_setting);
                ((GradientDrawable) getBackground()).setColor(r.getBackgroundPrimary());
            } else if (i2 == 3) {
                setColorFilter(r.getItemColorPrimary());
            } else if (i2 == 2) {
                setColorFilter(r.getTextColorThirdly());
            } else if (i2 >= 0) {
                setColorFilter(r.getTextColorPrimary());
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        int action = event.getAction();
        if (action == 0) {
            if (!b()) {
                return false;
            }
            setAlpha(0.6f);
            return false;
        }
        if ((action != 1 && action != 3) || !b()) {
            return false;
        }
        setAlpha(1.0f);
        return false;
    }

    public void setEnableColorFilter(boolean enableColorFilter) {
        this.f14834c = enableColorFilter;
        if (enableColorFilter) {
            g();
        }
    }

    public ReaderThemeImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        c(context, attrs);
        a();
    }

    public ReaderThemeImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f14834c = true;
        c(context, attrs);
        a();
    }
}
