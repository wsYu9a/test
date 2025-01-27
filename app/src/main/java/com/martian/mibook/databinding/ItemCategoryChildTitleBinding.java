package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class ItemCategoryChildTitleBinding implements ViewBinding {

    @NonNull
    public final ThemeTextView categoryTitle;

    @NonNull
    private final ThemeTextView rootView;

    private ItemCategoryChildTitleBinding(@NonNull ThemeTextView themeTextView, @NonNull ThemeTextView themeTextView2) {
        this.rootView = themeTextView;
        this.categoryTitle = themeTextView2;
    }

    @NonNull
    public static ItemCategoryChildTitleBinding bind(@NonNull View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        ThemeTextView themeTextView = (ThemeTextView) view;
        return new ItemCategoryChildTitleBinding(themeTextView, themeTextView);
    }

    @NonNull
    public static ItemCategoryChildTitleBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ItemCategoryChildTitleBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.item_category_child_title, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ThemeTextView getRoot() {
        return this.rootView;
    }
}
