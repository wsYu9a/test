package com.martian.libmars.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.R;
import com.martian.libmars.widget.recyclerview.LoadMoreFooterView;

/* loaded from: classes3.dex */
public final class LayoutIrecyclerviewLoadMoreFooterBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LoadMoreFooterView f12208a;

    public LayoutIrecyclerviewLoadMoreFooterBinding(@NonNull LoadMoreFooterView loadMoreFooterView) {
        this.f12208a = loadMoreFooterView;
    }

    @NonNull
    public static LayoutIrecyclerviewLoadMoreFooterBinding a(@NonNull View view) {
        if (view != null) {
            return new LayoutIrecyclerviewLoadMoreFooterBinding((LoadMoreFooterView) view);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static LayoutIrecyclerviewLoadMoreFooterBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static LayoutIrecyclerviewLoadMoreFooterBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.layout_irecyclerview_load_more_footer, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LoadMoreFooterView getRoot() {
        return this.f12208a;
    }
}
