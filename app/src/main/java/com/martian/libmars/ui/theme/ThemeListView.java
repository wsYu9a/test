package com.martian.libmars.ui.theme;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.BaseAdapter;
import android.widget.ListView;
import androidx.core.content.ContextCompat;
import com.martian.libmars.d.h;
import com.martian.theme.yellow.R;
import g.a;

/* loaded from: classes2.dex */
public class ThemeListView extends ListView implements a {

    /* renamed from: a */
    private int f10102a;

    public ThemeListView(Context context) {
        super(context);
    }

    private void a(Context context, AttributeSet attrs) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.ThemeLinearLayout);
        this.f10102a = obtainStyledAttributes.getColor(R.styleable.ThemeLinearLayout_backgroundType, 0);
        obtainStyledAttributes.recycle();
    }

    @Override // g.a
    public void g() {
        int i2;
        if (h.F().I0()) {
            int i3 = this.f10102a;
            i2 = i3 == 1 ? com.martian.libmars.R.color.night_background_secondary : i3 == 2 ? com.martian.libmars.R.color.night_highlight_color : com.martian.libmars.R.color.night_background;
        } else {
            int i4 = this.f10102a;
            i2 = i4 == 1 ? com.martian.libmars.R.color.light_grey : i4 == 2 ? com.martian.libmars.R.color.day_highlight_color : com.martian.libmars.R.color.white;
        }
        setBackgroundColor(ContextCompat.getColor(getContext(), i2));
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

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h.F().j1(this);
    }

    public ThemeListView(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
        a(context, attrs);
    }

    public ThemeListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        a(context, attrs);
    }
}
