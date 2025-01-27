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

/* loaded from: classes3.dex */
public final class ItemCategoryPageBinding implements ViewBinding {

    @NonNull
    public final LoadingTip pageCategoryLoadingTip;

    @NonNull
    private final ThemeRelativeLayout rootView;

    @NonNull
    public final RecyclerView rvBooks;

    private ItemCategoryPageBinding(@NonNull ThemeRelativeLayout themeRelativeLayout, @NonNull LoadingTip loadingTip, @NonNull RecyclerView recyclerView) {
        this.rootView = themeRelativeLayout;
        this.pageCategoryLoadingTip = loadingTip;
        this.rvBooks = recyclerView;
    }

    @NonNull
    public static ItemCategoryPageBinding bind(@NonNull View view) {
        int i10 = R.id.page_category_loading_tip;
        LoadingTip loadingTip = (LoadingTip) ViewBindings.findChildViewById(view, i10);
        if (loadingTip != null) {
            i10 = R.id.rv_books;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i10);
            if (recyclerView != null) {
                return new ItemCategoryPageBinding((ThemeRelativeLayout) view, loadingTip, recyclerView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ItemCategoryPageBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ItemCategoryPageBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.item_category_page, viewGroup, false);
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
