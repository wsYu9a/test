package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class ItemBookShelfCategoryBinding implements ViewBinding {

    @NonNull
    public final ThemeImageView ivIcon;

    @NonNull
    public final ImageView ivVip;

    @NonNull
    private final RelativeLayout rootView;

    @NonNull
    public final ThemeTextView tvBookCount;

    @NonNull
    public final ThemeTextView tvCategoryName;

    private ItemBookShelfCategoryBinding(@NonNull RelativeLayout relativeLayout, @NonNull ThemeImageView themeImageView, @NonNull ImageView imageView, @NonNull ThemeTextView themeTextView, @NonNull ThemeTextView themeTextView2) {
        this.rootView = relativeLayout;
        this.ivIcon = themeImageView;
        this.ivVip = imageView;
        this.tvBookCount = themeTextView;
        this.tvCategoryName = themeTextView2;
    }

    @NonNull
    public static ItemBookShelfCategoryBinding bind(@NonNull View view) {
        int i10 = R.id.iv_icon;
        ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
        if (themeImageView != null) {
            i10 = R.id.iv_vip;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
            if (imageView != null) {
                i10 = R.id.tv_book_count;
                ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (themeTextView != null) {
                    i10 = R.id.tv_category_name;
                    ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                    if (themeTextView2 != null) {
                        return new ItemBookShelfCategoryBinding((RelativeLayout) view, themeImageView, imageView, themeTextView, themeTextView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ItemBookShelfCategoryBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ItemBookShelfCategoryBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.item_book_shelf_category, viewGroup, false);
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
