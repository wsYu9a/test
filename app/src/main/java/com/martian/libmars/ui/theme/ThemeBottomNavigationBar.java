package com.martian.libmars.ui.theme;

import android.content.Context;
import android.util.AttributeSet;
import androidx.core.content.ContextCompat;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.martian.libmars.R;
import com.martian.libmars.d.h;
import g.a;

/* loaded from: classes2.dex */
public class ThemeBottomNavigationBar extends BottomNavigationView implements a {
    public ThemeBottomNavigationBar(Context context) {
        super(context);
        l();
    }

    private void l() {
        g();
    }

    @Override // g.a
    public void g() {
        setBackgroundColor(ContextCompat.getColor(getContext(), h.F().I0() ? R.color.night_background_card : R.color.white));
    }

    @Override // com.google.android.material.bottomnavigation.BottomNavigationView, android.view.ViewGroup, android.view.View
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

    public ThemeBottomNavigationBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        l();
    }

    public ThemeBottomNavigationBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        l();
    }
}
