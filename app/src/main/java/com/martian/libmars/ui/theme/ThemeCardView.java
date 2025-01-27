package com.martian.libmars.ui.theme;

import android.content.Context;
import android.util.AttributeSet;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import com.martian.libmars.R;
import com.martian.libmars.d.h;
import g.a;

/* loaded from: classes2.dex */
public class ThemeCardView extends CardView implements a {

    /* renamed from: j */
    private int f10093j;

    public ThemeCardView(Context context) {
        super(context);
    }

    @Override // g.a
    public void g() {
        setCardBackgroundColor(ContextCompat.getColor(getContext(), h.F().I0() ? R.color.night_background_secondary : R.color.light_grey));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        g();
        h.F().a(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h.F().j1(this);
    }

    public ThemeCardView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ThemeCardView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
}
