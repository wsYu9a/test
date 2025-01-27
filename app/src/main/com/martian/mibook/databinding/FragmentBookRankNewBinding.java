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
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.widget.recyclerview.LoadingTip;
import com.martian.mibook.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: classes3.dex */
public final class FragmentBookRankNewBinding implements ViewBinding {

    @NonNull
    public final SmartRefreshLayout refreshLayout;

    @NonNull
    public final RelativeLayout rlBookContainer;

    @NonNull
    private final ThemeLinearLayout rootView;

    @NonNull
    public final RecyclerView rvChild;

    @NonNull
    public final RecyclerView rvGroup;

    @NonNull
    public final LoadingTip rvLoadedTip;

    private FragmentBookRankNewBinding(@NonNull ThemeLinearLayout themeLinearLayout, @NonNull SmartRefreshLayout smartRefreshLayout, @NonNull RelativeLayout relativeLayout, @NonNull RecyclerView recyclerView, @NonNull RecyclerView recyclerView2, @NonNull LoadingTip loadingTip) {
        this.rootView = themeLinearLayout;
        this.refreshLayout = smartRefreshLayout;
        this.rlBookContainer = relativeLayout;
        this.rvChild = recyclerView;
        this.rvGroup = recyclerView2;
        this.rvLoadedTip = loadingTip;
    }

    @NonNull
    public static FragmentBookRankNewBinding bind(@NonNull View view) {
        int i10 = R.id.refreshLayout;
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) ViewBindings.findChildViewById(view, i10);
        if (smartRefreshLayout != null) {
            i10 = R.id.rl_book_container;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i10);
            if (relativeLayout != null) {
                i10 = R.id.rv_child;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i10);
                if (recyclerView != null) {
                    i10 = R.id.rv_group;
                    RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(view, i10);
                    if (recyclerView2 != null) {
                        i10 = R.id.rv_loadedTip;
                        LoadingTip loadingTip = (LoadingTip) ViewBindings.findChildViewById(view, i10);
                        if (loadingTip != null) {
                            return new FragmentBookRankNewBinding((ThemeLinearLayout) view, smartRefreshLayout, relativeLayout, recyclerView, recyclerView2, loadingTip);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static FragmentBookRankNewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static FragmentBookRankNewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.fragment_book_rank_new, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ThemeLinearLayout getRoot() {
        return this.rootView;
    }
}
