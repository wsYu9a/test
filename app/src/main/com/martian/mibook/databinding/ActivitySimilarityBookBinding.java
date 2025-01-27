package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeIRecyclerView;
import com.martian.libmars.widget.recyclerview.LoadingTip;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class ActivitySimilarityBookBinding implements ViewBinding {

    @NonNull
    private final RelativeLayout rootView;

    @NonNull
    public final RelativeLayout similarityBookContainer;

    @NonNull
    public final ThemeIRecyclerView similarityBookRecyclerView;

    @NonNull
    public final LoadingTip similarityLoadingTip;

    private ActivitySimilarityBookBinding(@NonNull RelativeLayout relativeLayout, @NonNull RelativeLayout relativeLayout2, @NonNull ThemeIRecyclerView themeIRecyclerView, @NonNull LoadingTip loadingTip) {
        this.rootView = relativeLayout;
        this.similarityBookContainer = relativeLayout2;
        this.similarityBookRecyclerView = themeIRecyclerView;
        this.similarityLoadingTip = loadingTip;
    }

    @NonNull
    public static ActivitySimilarityBookBinding bind(@NonNull View view) {
        RelativeLayout relativeLayout = (RelativeLayout) view;
        int i10 = R.id.similarity_book_recycler_view;
        ThemeIRecyclerView themeIRecyclerView = (ThemeIRecyclerView) ViewBindings.findChildViewById(view, i10);
        if (themeIRecyclerView != null) {
            i10 = R.id.similarity_loading_tip;
            LoadingTip loadingTip = (LoadingTip) ViewBindings.findChildViewById(view, i10);
            if (loadingTip != null) {
                return new ActivitySimilarityBookBinding(relativeLayout, relativeLayout, themeIRecyclerView, loadingTip);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ActivitySimilarityBookBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivitySimilarityBookBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.activity_similarity_book, viewGroup, false);
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
