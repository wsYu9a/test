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
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;
import com.martian.mibook.ui.CircleImageView;

/* loaded from: classes3.dex */
public final class ItemCategoryChildTagBinding implements ViewBinding {

    @NonNull
    public final ThemeLinearLayout categoryRootView;

    @NonNull
    private final RelativeLayout rootView;

    @NonNull
    public final ImageView tvPageCover;

    @NonNull
    public final CircleImageView tvPageIcon;

    @NonNull
    public final ThemeTextView tvPageName;

    private ItemCategoryChildTagBinding(@NonNull RelativeLayout relativeLayout, @NonNull ThemeLinearLayout themeLinearLayout, @NonNull ImageView imageView, @NonNull CircleImageView circleImageView, @NonNull ThemeTextView themeTextView) {
        this.rootView = relativeLayout;
        this.categoryRootView = themeLinearLayout;
        this.tvPageCover = imageView;
        this.tvPageIcon = circleImageView;
        this.tvPageName = themeTextView;
    }

    @NonNull
    public static ItemCategoryChildTagBinding bind(@NonNull View view) {
        int i10 = R.id.category_root_view;
        ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
        if (themeLinearLayout != null) {
            i10 = R.id.tv_page_cover;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
            if (imageView != null) {
                i10 = R.id.tv_page_icon;
                CircleImageView circleImageView = (CircleImageView) ViewBindings.findChildViewById(view, i10);
                if (circleImageView != null) {
                    i10 = R.id.tv_page_name;
                    ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                    if (themeTextView != null) {
                        return new ItemCategoryChildTagBinding((RelativeLayout) view, themeLinearLayout, imageView, circleImageView, themeTextView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ItemCategoryChildTagBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ItemCategoryChildTagBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.item_category_child_tag, viewGroup, false);
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
