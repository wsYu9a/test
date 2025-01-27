package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class PageItemCategoryTagBinding implements ViewBinding {

    @NonNull
    public final ThemeTextView categoryTitle;

    @NonNull
    public final LinearLayout gridItemRoot;

    @NonNull
    private final LinearLayout rootView;

    @NonNull
    public final RecyclerView rvTags;

    private PageItemCategoryTagBinding(@NonNull LinearLayout linearLayout, @NonNull ThemeTextView themeTextView, @NonNull LinearLayout linearLayout2, @NonNull RecyclerView recyclerView) {
        this.rootView = linearLayout;
        this.categoryTitle = themeTextView;
        this.gridItemRoot = linearLayout2;
        this.rvTags = recyclerView;
    }

    @NonNull
    public static PageItemCategoryTagBinding bind(@NonNull View view) {
        int i10 = R.id.category_title;
        ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
        if (themeTextView != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            int i11 = R.id.rv_tags;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i11);
            if (recyclerView != null) {
                return new PageItemCategoryTagBinding(linearLayout, themeTextView, linearLayout, recyclerView);
            }
            i10 = i11;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static PageItemCategoryTagBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static PageItemCategoryTagBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.page_item_category_tag, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
