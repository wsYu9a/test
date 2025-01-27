package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeGridView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;
import com.martian.mibook.ui.TagItemLayout;

/* loaded from: classes3.dex */
public final class CategoryTagItemBinding implements ViewBinding {

    @NonNull
    public final LinearLayout categoryHotView;

    @NonNull
    public final ThemeGridView categoryItem;

    @NonNull
    public final ThemeTextView categoryTitle;

    @NonNull
    public final ThemeLinearLayout gridItemRoot;

    @NonNull
    public final TagItemLayout hotTags;

    @NonNull
    private final ThemeLinearLayout rootView;

    private CategoryTagItemBinding(@NonNull ThemeLinearLayout themeLinearLayout, @NonNull LinearLayout linearLayout, @NonNull ThemeGridView themeGridView, @NonNull ThemeTextView themeTextView, @NonNull ThemeLinearLayout themeLinearLayout2, @NonNull TagItemLayout tagItemLayout) {
        this.rootView = themeLinearLayout;
        this.categoryHotView = linearLayout;
        this.categoryItem = themeGridView;
        this.categoryTitle = themeTextView;
        this.gridItemRoot = themeLinearLayout2;
        this.hotTags = tagItemLayout;
    }

    @NonNull
    public static CategoryTagItemBinding bind(@NonNull View view) {
        int i10 = R.id.category_hot_view;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
        if (linearLayout != null) {
            i10 = R.id.category_item;
            ThemeGridView themeGridView = (ThemeGridView) ViewBindings.findChildViewById(view, i10);
            if (themeGridView != null) {
                i10 = R.id.category_title;
                ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (themeTextView != null) {
                    ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) view;
                    i10 = R.id.hot_tags;
                    TagItemLayout tagItemLayout = (TagItemLayout) ViewBindings.findChildViewById(view, i10);
                    if (tagItemLayout != null) {
                        return new CategoryTagItemBinding(themeLinearLayout, linearLayout, themeGridView, themeTextView, themeLinearLayout, tagItemLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static CategoryTagItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static CategoryTagItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.category_tag_item, viewGroup, false);
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
