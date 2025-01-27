package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeRelativeLayout;
import com.martian.libmars.widget.recyclerview.LoadingTip;
import com.martian.mibook.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: classes3.dex */
public final class FragmentComomonRecyclerviewBinding implements ViewBinding {

    @NonNull
    public final RecyclerView recyclerview;

    @NonNull
    public final SmartRefreshLayout refreshLayout;

    @NonNull
    public final ThemeRelativeLayout rlContainer;

    @NonNull
    private final SmartRefreshLayout rootView;

    @NonNull
    public final LoadingTip rvLoadedTip;

    private FragmentComomonRecyclerviewBinding(@NonNull SmartRefreshLayout smartRefreshLayout, @NonNull RecyclerView recyclerView, @NonNull SmartRefreshLayout smartRefreshLayout2, @NonNull ThemeRelativeLayout themeRelativeLayout, @NonNull LoadingTip loadingTip) {
        this.rootView = smartRefreshLayout;
        this.recyclerview = recyclerView;
        this.refreshLayout = smartRefreshLayout2;
        this.rlContainer = themeRelativeLayout;
        this.rvLoadedTip = loadingTip;
    }

    @NonNull
    public static FragmentComomonRecyclerviewBinding bind(@NonNull View view) {
        int i10 = R.id.recyclerview;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i10);
        if (recyclerView != null) {
            SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) view;
            i10 = R.id.rl_container;
            ThemeRelativeLayout themeRelativeLayout = (ThemeRelativeLayout) ViewBindings.findChildViewById(view, i10);
            if (themeRelativeLayout != null) {
                i10 = R.id.rv_loadedTip;
                LoadingTip loadingTip = (LoadingTip) ViewBindings.findChildViewById(view, i10);
                if (loadingTip != null) {
                    return new FragmentComomonRecyclerviewBinding(smartRefreshLayout, recyclerView, smartRefreshLayout, themeRelativeLayout, loadingTip);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static FragmentComomonRecyclerviewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static FragmentComomonRecyclerviewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.fragment_comomon_recyclerview, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public SmartRefreshLayout getRoot() {
        return this.rootView;
    }
}
