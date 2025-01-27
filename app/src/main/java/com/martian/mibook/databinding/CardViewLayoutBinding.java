package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class CardViewLayoutBinding implements ViewBinding {

    @NonNull
    public final ThemeLinearLayout cardViewParent;

    @NonNull
    private final ThemeLinearLayout rootView;

    private CardViewLayoutBinding(@NonNull ThemeLinearLayout themeLinearLayout, @NonNull ThemeLinearLayout themeLinearLayout2) {
        this.rootView = themeLinearLayout;
        this.cardViewParent = themeLinearLayout2;
    }

    @NonNull
    public static CardViewLayoutBinding bind(@NonNull View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) view;
        return new CardViewLayoutBinding(themeLinearLayout, themeLinearLayout);
    }

    @NonNull
    public static CardViewLayoutBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static CardViewLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.card_view_layout, viewGroup, false);
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
