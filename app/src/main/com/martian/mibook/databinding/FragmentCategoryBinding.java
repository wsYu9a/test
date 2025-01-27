package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.widget.recyclerview.LoadingTip;
import com.martian.mibook.R;
import com.martian.mibook.mvvm.category.fragment.LinkageRecyclerView;

/* loaded from: classes3.dex */
public final class FragmentCategoryBinding implements ViewBinding {

    @NonNull
    public final LinkageRecyclerView linkageRecyclerview;

    @NonNull
    public final LoadingTip loadingTip;

    @NonNull
    private final RelativeLayout rootView;

    private FragmentCategoryBinding(@NonNull RelativeLayout relativeLayout, @NonNull LinkageRecyclerView linkageRecyclerView, @NonNull LoadingTip loadingTip) {
        this.rootView = relativeLayout;
        this.linkageRecyclerview = linkageRecyclerView;
        this.loadingTip = loadingTip;
    }

    @NonNull
    public static FragmentCategoryBinding bind(@NonNull View view) {
        int i10 = R.id.linkage_recyclerview;
        LinkageRecyclerView linkageRecyclerView = (LinkageRecyclerView) ViewBindings.findChildViewById(view, i10);
        if (linkageRecyclerView != null) {
            i10 = R.id.loading_tip;
            LoadingTip loadingTip = (LoadingTip) ViewBindings.findChildViewById(view, i10);
            if (loadingTip != null) {
                return new FragmentCategoryBinding((RelativeLayout) view, linkageRecyclerView, loadingTip);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static FragmentCategoryBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static FragmentCategoryBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.fragment_category, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
