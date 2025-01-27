package com.martian.mibook.ui.reader;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.martian.libmars.d.h;
import com.martian.mibook.application.MiConfigSingleton;

/* loaded from: classes4.dex */
public class ReaderThemeIRecyclerView extends ReaderIRecyclerView implements g.a {
    public ReaderThemeIRecyclerView(Context context) {
        super(context);
    }

    @Override // g.a
    public void g() {
        int backgroundSecondary = MiConfigSingleton.V3().J4.r().getBackgroundSecondary();
        setBackgroundColor(ContextCompat.getColor(getContext(), backgroundSecondary));
        setLoadMoreBackgroundColor(ContextCompat.getColor(getContext(), backgroundSecondary));
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

    public ReaderThemeIRecyclerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ReaderThemeIRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
}
