package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class ItemBookMallTypeRecommendTitleBinding implements ViewBinding {

    @NonNull
    private final ThemeLinearLayout rootView;

    @NonNull
    public final BsBookStoreItemTitleBinding titleView;

    private ItemBookMallTypeRecommendTitleBinding(@NonNull ThemeLinearLayout themeLinearLayout, @NonNull BsBookStoreItemTitleBinding bsBookStoreItemTitleBinding) {
        this.rootView = themeLinearLayout;
        this.titleView = bsBookStoreItemTitleBinding;
    }

    @NonNull
    public static ItemBookMallTypeRecommendTitleBinding bind(@NonNull View view) {
        int i10 = R.id.title_view;
        View findChildViewById = ViewBindings.findChildViewById(view, i10);
        if (findChildViewById == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
        }
        return new ItemBookMallTypeRecommendTitleBinding((ThemeLinearLayout) view, BsBookStoreItemTitleBinding.bind(findChildViewById));
    }

    @NonNull
    public static ItemBookMallTypeRecommendTitleBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ItemBookMallTypeRecommendTitleBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.item_book_mall_type_recommend_title, viewGroup, false);
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
