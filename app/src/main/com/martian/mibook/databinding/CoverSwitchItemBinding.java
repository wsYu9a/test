package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class CoverSwitchItemBinding implements ViewBinding {

    @NonNull
    public final ImageView ivCover;

    @NonNull
    public final ImageView ivCoverSelection;

    @NonNull
    public final View ivCoverShadow;

    @NonNull
    private final ThemeLinearLayout rootView;

    private CoverSwitchItemBinding(@NonNull ThemeLinearLayout themeLinearLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull View view) {
        this.rootView = themeLinearLayout;
        this.ivCover = imageView;
        this.ivCoverSelection = imageView2;
        this.ivCoverShadow = view;
    }

    @NonNull
    public static CoverSwitchItemBinding bind(@NonNull View view) {
        View findChildViewById;
        int i10 = R.id.iv_cover;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
        if (imageView != null) {
            i10 = R.id.iv_cover_selection;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i10);
            if (imageView2 != null && (findChildViewById = ViewBindings.findChildViewById(view, (i10 = R.id.iv_cover_shadow))) != null) {
                return new CoverSwitchItemBinding((ThemeLinearLayout) view, imageView, imageView2, findChildViewById);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static CoverSwitchItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static CoverSwitchItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.cover_switch_item, viewGroup, false);
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
