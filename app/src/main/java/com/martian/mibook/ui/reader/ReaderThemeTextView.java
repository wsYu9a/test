package com.martian.mibook.ui.reader;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.martian.libmars.d.h;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.lib.model.data.MiReadingTheme;
import com.martian.theme.yellow.R;

/* loaded from: classes4.dex */
public class ReaderThemeTextView extends AppCompatTextView implements g.a {

    /* renamed from: e */
    private int f14843e;

    /* renamed from: f */
    private int f14844f;

    public ReaderThemeTextView(Context context) {
        super(context);
        this.f14844f = 0;
        f();
    }

    private void f() {
        g();
    }

    private void h(Context context, AttributeSet attrs) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.ThemeTextView);
        this.f14843e = obtainStyledAttributes.getColor(2, 0);
        this.f14844f = obtainStyledAttributes.getInteger(3, 0);
        obtainStyledAttributes.recycle();
    }

    @Override // g.a
    public void g() {
        Context context;
        int i2;
        Context context2;
        int i3;
        MiReadingTheme r = MiConfigSingleton.V3().J4.r();
        int i4 = this.f14843e;
        if (i4 == 5) {
            if (MiConfigSingleton.V3().J4.E()) {
                context2 = getContext();
                i3 = com.martian.ttbookhd.R.color.night_text_color_thirdly;
            } else {
                context2 = getContext();
                i3 = com.martian.ttbookhd.R.color.day_text_color_thirdly;
            }
            setTextColor(ContextCompat.getColor(context2, i3));
        } else if (i4 == 4) {
            if (MiConfigSingleton.V3().J4.E()) {
                context = getContext();
                i2 = com.martian.ttbookhd.R.color.night_text_color_primary;
            } else {
                context = getContext();
                i2 = com.martian.ttbookhd.R.color.day_text_color_primary;
            }
            setTextColor(ContextCompat.getColor(context, i2));
        } else if (i4 == 3) {
            setTextColor(r.getItemColorPrimary());
        } else if (i4 == 2) {
            setTextColor(r.getTextColorThirdly());
        } else {
            setTextColor(r.getTextColorPrimary());
        }
        if (this.f14844f == 0 || h.F().v0() == null) {
            return;
        }
        setTypeface(h.F().v0());
        setIncludeFontPadding(false);
    }

    public ReaderThemeTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        h(context, attrs);
        f();
    }

    public ReaderThemeTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f14844f = 0;
        h(context, attrs);
        f();
    }
}
