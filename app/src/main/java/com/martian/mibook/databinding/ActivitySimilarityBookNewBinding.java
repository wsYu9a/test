package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.appbar.AppBarLayout;
import com.martian.libmars.ui.theme.ThemeRelativeLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.libmars.widget.recyclerview.LoadingTip;
import com.martian.mibook.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: classes3.dex */
public final class ActivitySimilarityBookNewBinding implements ViewBinding {

    @NonNull
    public final AppBarLayout appbarLayout;

    @NonNull
    public final RecyclerView recyclerViewBanner;

    @NonNull
    public final SmartRefreshLayout refreshLayout;

    @NonNull
    public final RelativeLayout rlHeader;

    @NonNull
    private final ThemeRelativeLayout rootView;

    @NonNull
    public final LoadingTip rvLoadedTip;

    @NonNull
    public final RecyclerView rvSimilarityBook;

    @NonNull
    public final ThemeTextView similarityBookName;

    @NonNull
    public final View viewTopBg;

    private ActivitySimilarityBookNewBinding(@NonNull ThemeRelativeLayout themeRelativeLayout, @NonNull AppBarLayout appBarLayout, @NonNull RecyclerView recyclerView, @NonNull SmartRefreshLayout smartRefreshLayout, @NonNull RelativeLayout relativeLayout, @NonNull LoadingTip loadingTip, @NonNull RecyclerView recyclerView2, @NonNull ThemeTextView themeTextView, @NonNull View view) {
        this.rootView = themeRelativeLayout;
        this.appbarLayout = appBarLayout;
        this.recyclerViewBanner = recyclerView;
        this.refreshLayout = smartRefreshLayout;
        this.rlHeader = relativeLayout;
        this.rvLoadedTip = loadingTip;
        this.rvSimilarityBook = recyclerView2;
        this.similarityBookName = themeTextView;
        this.viewTopBg = view;
    }

    @NonNull
    public static ActivitySimilarityBookNewBinding bind(@NonNull View view) {
        View findChildViewById;
        int i10 = R.id.appbar_layout;
        AppBarLayout appBarLayout = (AppBarLayout) ViewBindings.findChildViewById(view, i10);
        if (appBarLayout != null) {
            i10 = R.id.recycler_view_banner;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i10);
            if (recyclerView != null) {
                i10 = R.id.refreshLayout;
                SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) ViewBindings.findChildViewById(view, i10);
                if (smartRefreshLayout != null) {
                    i10 = R.id.rl_header;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i10);
                    if (relativeLayout != null) {
                        i10 = R.id.rv_loadedTip;
                        LoadingTip loadingTip = (LoadingTip) ViewBindings.findChildViewById(view, i10);
                        if (loadingTip != null) {
                            i10 = R.id.rv_similarity_book;
                            RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(view, i10);
                            if (recyclerView2 != null) {
                                i10 = R.id.similarity_book_name;
                                ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                if (themeTextView != null && (findChildViewById = ViewBindings.findChildViewById(view, (i10 = R.id.view_top_bg))) != null) {
                                    return new ActivitySimilarityBookNewBinding((ThemeRelativeLayout) view, appBarLayout, recyclerView, smartRefreshLayout, relativeLayout, loadingTip, recyclerView2, themeTextView, findChildViewById);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ActivitySimilarityBookNewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivitySimilarityBookNewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.activity_similarity_book_new, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ThemeRelativeLayout getRoot() {
        return this.rootView;
    }
}
