package com.martian.libmars.ui.theme;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.martian.libmars.d.h;
import com.martian.libmars.widget.recyclerview.IRecyclerView;
import com.martian.theme.yellow.R;
import g.a;

/* loaded from: classes2.dex */
public class ThemeIRecyclerView extends IRecyclerView implements a {
    private int H;

    public ThemeIRecyclerView(Context context) {
        super(context);
    }

    private void N(Context context, AttributeSet attrs) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.ThemeLinearLayout);
        this.H = obtainStyledAttributes.getColor(R.styleable.ThemeLinearLayout_backgroundType, 0);
        obtainStyledAttributes.recycle();
    }

    @Override // g.a
    public void g() {
        int i2;
        if (h.F().I0()) {
            i2 = this.H == 1 ? com.martian.libmars.R.color.night_background_secondary : com.martian.libmars.R.color.night_background;
        } else {
            int i3 = this.H;
            i2 = i3 == 1 ? com.martian.libmars.R.color.light_grey : i3 == 2 ? com.martian.libmars.R.color.light_grey_bg : com.martian.libmars.R.color.white;
        }
        int color = ContextCompat.getColor(getContext(), i2);
        setBackgroundColor(color);
        setLoadMoreBackgroundColor(color);
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
        if (getHeaderContainer() != null) {
            i.a.c(getHeaderContainer());
        }
        if (getLoadMoreFooterView() != null) {
            i.a.c(getLoadMoreFooterView());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        g();
        h.F().a(this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h.F().j1(this);
    }

    public ThemeIRecyclerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
        N(context, attrs);
    }

    public ThemeIRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        N(context, attrs);
    }
}
