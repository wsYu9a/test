package com.martian.mibook.ui.reader;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.R;
import com.martian.mibook.application.MiConfigSingleton;
import k9.a;

/* loaded from: classes3.dex */
public class ReaderThemeRelativeLayout extends RelativeLayout implements a {

    /* renamed from: b */
    public int f16041b;

    public ReaderThemeRelativeLayout(Context context) {
        super(context);
        a();
    }

    private void a() {
        p();
    }

    private void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ReaderThemeRelativeLayout);
        this.f16041b = obtainStyledAttributes.getInt(R.styleable.ReaderThemeRelativeLayout_rBackgroundType, 0);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        p();
        ConfigSingleton.D().h(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ConfigSingleton.D().X0(this);
    }

    @Override // k9.a
    public void p() {
        if (isInEditMode()) {
            return;
        }
        setBackgroundColor(this.f16041b == 1 ? MiConfigSingleton.b2().h2().e() : MiConfigSingleton.b2().h2().h());
    }

    public ReaderThemeRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        b(context, attributeSet);
        a();
    }

    public ReaderThemeRelativeLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        b(context, attributeSet);
        a();
    }
}
