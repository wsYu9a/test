package com.martian.mibook.ui.reader;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.core.content.ContextCompat;
import com.martian.mibook.application.MiConfigSingleton;

/* loaded from: classes4.dex */
public class ReaderThemeSeekBar extends AppCompatSeekBar implements g.a {
    public ReaderThemeSeekBar(Context context) {
        super(context);
        a();
    }

    private void a() {
        g();
    }

    @Override // g.a
    public void g() {
        setProgressDrawable(ContextCompat.getDrawable(getContext(), MiConfigSingleton.V3().J4.w()));
        setThumb(ContextCompat.getDrawable(getContext(), MiConfigSingleton.V3().J4.x()));
    }

    public ReaderThemeSeekBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        a();
    }

    public ReaderThemeSeekBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        a();
    }
}
