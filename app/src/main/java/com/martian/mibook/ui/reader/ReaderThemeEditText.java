package com.martian.mibook.ui.reader;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatEditText;
import com.martian.libmars.d.h;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.lib.model.data.MiReadingTheme;

/* loaded from: classes4.dex */
public class ReaderThemeEditText extends AppCompatEditText implements g.a {
    public ReaderThemeEditText(Context context) {
        super(context);
        a();
    }

    private void a() {
        setFocusableInTouchMode(true);
    }

    @Override // g.a
    public void g() {
        MiReadingTheme r = MiConfigSingleton.V3().J4.r();
        setTextColor(r.getTextColorPrimary(getContext()));
        setHintTextColor(r.getTextColorThirdly(getContext()));
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        g();
        h.F().a(this);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h.F().j1(this);
    }

    public ReaderThemeEditText(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
        a();
    }

    public ReaderThemeEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        a();
    }
}
