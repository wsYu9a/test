package com.martian.libmars.ui.theme;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.core.content.ContextCompat;
import com.martian.libmars.d.h;
import g.a;

/* loaded from: classes2.dex */
public class ThemeSeekBar extends AppCompatSeekBar implements a {
    public ThemeSeekBar(Context context) {
        super(context);
        a();
    }

    private void a() {
        g();
    }

    @Override // g.a
    public void g() {
        setProgressDrawable(ContextCompat.getDrawable(getContext(), h.F().k0()));
        setThumb(ContextCompat.getDrawable(getContext(), h.F().l0()));
    }

    public ThemeSeekBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        a();
    }

    public ThemeSeekBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        a();
    }
}
