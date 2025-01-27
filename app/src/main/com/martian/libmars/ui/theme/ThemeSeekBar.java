package com.martian.libmars.ui.theme;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.core.content.ContextCompat;
import com.martian.libmars.common.ConfigSingleton;
import k9.a;

/* loaded from: classes3.dex */
public class ThemeSeekBar extends AppCompatSeekBar implements a {
    public ThemeSeekBar(Context context) {
        super(context);
        a();
    }

    private void a() {
        p();
    }

    @Override // k9.a
    public void p() {
        if (isInEditMode()) {
            return;
        }
        setProgressDrawable(ContextCompat.getDrawable(getContext(), ConfigSingleton.D().c0()));
        setThumb(ContextCompat.getDrawable(getContext(), ConfigSingleton.D().d0()));
    }

    public ThemeSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        a();
    }

    public ThemeSeekBar(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        a();
    }
}
