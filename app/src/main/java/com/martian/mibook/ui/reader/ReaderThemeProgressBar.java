package com.martian.mibook.ui.reader;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import androidx.core.content.ContextCompat;
import com.martian.mibook.R;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.lib.model.data.MiReadingTheme;

/* loaded from: classes4.dex */
public class ReaderThemeProgressBar extends ProgressBar implements g.a {

    /* renamed from: a */
    private boolean f14841a;

    public ReaderThemeProgressBar(Context context) {
        super(context);
        this.f14841a = true;
        a();
    }

    private void a() {
        g();
    }

    private void b(Context context, AttributeSet attrs) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.ReaderThemeProgressBar);
        this.f14841a = obtainStyledAttributes.getBoolean(0, true);
        obtainStyledAttributes.recycle();
    }

    @Override // g.a
    public void g() {
        MiReadingTheme r = MiConfigSingleton.V3().J4.r();
        if (this.f14841a) {
            setProgressDrawable(ContextCompat.getDrawable(getContext(), r.getProgressBarBackground()));
            return;
        }
        ColorDrawable colorDrawable = new ColorDrawable();
        colorDrawable.setColor(r.getTextColorThirdly());
        ClipDrawable clipDrawable = new ClipDrawable(colorDrawable, 3, 1);
        ColorDrawable colorDrawable2 = new ColorDrawable();
        colorDrawable2.setColor(getResources().getColor(com.martian.ttbookhd.R.color.transparent));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{colorDrawable2, clipDrawable});
        layerDrawable.setId(0, android.R.id.background);
        layerDrawable.setId(1, android.R.id.progress);
        setProgressDrawable(layerDrawable);
    }

    public ReaderThemeProgressBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        b(context, attrs);
        a();
    }

    public ReaderThemeProgressBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f14841a = true;
        b(context, attrs);
        a();
    }
}
