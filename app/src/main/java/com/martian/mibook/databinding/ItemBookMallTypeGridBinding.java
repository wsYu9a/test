package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class ItemBookMallTypeGridBinding implements ViewBinding {

    @NonNull
    public final ThemeLinearLayout llItemRoot;

    @NonNull
    private final ThemeLinearLayout rootView;

    @NonNull
    public final RecyclerView rvGridBooks;

    @NonNull
    public final BsBookStoreItemTitleBinding titleView;

    private ItemBookMallTypeGridBinding(@NonNull ThemeLinearLayout themeLinearLayout, @NonNull ThemeLinearLayout themeLinearLayout2, @NonNull RecyclerView recyclerView, @NonNull BsBookStoreItemTitleBinding bsBookStoreItemTitleBinding) {
        this.rootView = themeLinearLayout;
        this.llItemRoot = themeLinearLayout2;
        this.rvGridBooks = recyclerView;
        this.titleView = bsBookStoreItemTitleBinding;
    }

    @NonNull
    public static ItemBookMallTypeGridBinding bind(@NonNull View view) {
        View findChildViewById;
        ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) view;
        int i10 = R.id.rv_grid_books;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i10);
        if (recyclerView == null || (findChildViewById = ViewBindings.findChildViewById(view, (i10 = R.id.title_view))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
        }
        return new ItemBookMallTypeGridBinding(themeLinearLayout, themeLinearLayout, recyclerView, BsBookStoreItemTitleBinding.bind(findChildViewById));
    }

    @NonNull
    public static ItemBookMallTypeGridBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ItemBookMallTypeGridBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.item_book_mall_type_grid, viewGroup, false);
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
