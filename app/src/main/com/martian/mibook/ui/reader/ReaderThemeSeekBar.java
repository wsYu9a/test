package com.martian.mibook.ui.reader;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatSeekBar;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.data.theme.MiReadingTheme;
import k9.a;

/* loaded from: classes3.dex */
public class ReaderThemeSeekBar extends AppCompatSeekBar implements a {

    /* renamed from: b */
    public Drawable f16042b;

    /* renamed from: c */
    public Drawable f16043c;

    public ReaderThemeSeekBar(Context context) {
        super(context);
        a();
    }

    private void a() {
        p();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        p();
        ConfigSingleton.D().h(this);
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ConfigSingleton.D().X0(this);
    }

    @Override // k9.a
    public void p() {
        if (isInEditMode()) {
            return;
        }
        MiReadingTheme k10 = MiConfigSingleton.b2().h2().k();
        Drawable seekBarProgressBackgroundDrawable = k10.getSeekBarProgressBackgroundDrawable(getContext());
        if (this.f16042b != seekBarProgressBackgroundDrawable) {
            this.f16042b = seekBarProgressBackgroundDrawable;
            int progress = getProgress();
            Rect bounds = getProgressDrawable().getBounds();
            setProgressDrawable(seekBarProgressBackgroundDrawable);
            getProgressDrawable().setBounds(bounds);
            setProgress(progress);
        }
        Drawable seekBarThumbDrawable = k10.getSeekBarThumbDrawable(getContext());
        if (this.f16043c != seekBarThumbDrawable) {
            this.f16043c = seekBarThumbDrawable;
            Rect bounds2 = getThumb().getBounds();
            int thumbOffset = getThumbOffset();
            setThumb(seekBarThumbDrawable);
            getThumb().setBounds(bounds2);
            setThumbOffset(thumbOffset);
        }
    }

    public ReaderThemeSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        a();
    }

    public ReaderThemeSeekBar(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        a();
    }
}
