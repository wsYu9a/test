package com.martian.libmars.ui.theme;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.GridView;
import androidx.core.content.ContextCompat;
import com.martian.libmars.R;
import com.martian.libmars.d.h;
import g.a;

/* loaded from: classes2.dex */
public class ThemeGridView extends GridView implements a {

    /* renamed from: a */
    private int f10094a;

    public ThemeGridView(Context context) {
        super(context);
    }

    @Override // g.a
    public void g() {
        setBackgroundColor(ContextCompat.getColor(getContext(), h.F().I0() ? R.color.night_background : R.color.white));
        if (getAdapter() instanceof BaseAdapter) {
            ((BaseAdapter) getAdapter()).notifyDataSetChanged();
        }
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        g();
        h.F().a(this);
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h.F().j1(this);
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    public ThemeGridView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ThemeGridView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
}
