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
public final class ActivityRecommendBookFriendsBinding implements ViewBinding {

    @NonNull
    public final RecyclerView recyclerview;

    @NonNull
    public final SmartRefreshLayout refreshLayout;

    @NonNull
    public final RelativeLayout rlContainer;

    @NonNull
    private final ThemeLinearLayout rootView;

    @NonNull
    public final LoadingTip rvLoadedTip;

    private ActivityRecommendBookFriendsBinding(@NonNull ThemeLinearLayout themeLinearLayout, @NonNull RecyclerView recyclerView, @NonNull SmartRefreshLayout smartRefreshLayout, @NonNull RelativeLayout relativeLayout, @NonNull LoadingTip loadingTip) {
        this.rootView = themeLinearLayout;
        this.recyclerview = recyclerView;
        this.refreshLayout = smartRefreshLayout;
        this.rlContainer = relativeLayout;
        this.rvLoadedTip = loadingTip;
    }

    @NonNull
    public static ActivityRecommendBookFriendsBinding bind(@NonNull View view) {
        int i10 = R.id.recyclerview;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i10);
        if (recyclerView != null) {
            i10 = R.id.refreshLayout;
            SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) ViewBindings.findChildViewById(view, i10);
            if (smartRefreshLayout != null) {
                i10 = R.id.rl_container;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i10);
                if (relativeLayout != null) {
                    i10 = R.id.rv_loadedTip;
                    LoadingTip loadingTip = (LoadingTip) ViewBindings.findChildViewById(view, i10);
                    if (loadingTip != null) {
                        return new ActivityRecommendBookFriendsBinding((ThemeLinearLayout) view, recyclerView, smartRefreshLayout, relativeLayout, loadingTip);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ActivityRecommendBookFriendsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityRecommendBookFriendsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.activity_recommend_book_friends, viewGroup, false);
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
