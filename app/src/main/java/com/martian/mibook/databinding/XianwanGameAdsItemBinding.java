package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class XianwanGameAdsItemBinding implements ViewBinding {

    @NonNull
    public final ThemeTextView gameBtn;

    @NonNull
    public final ThemeImageView gameIcon;

    @NonNull
    public final ThemeTextView gameTitle;

    @NonNull
    public final ThemeLinearLayout gameView;

    @NonNull
    private final ThemeLinearLayout rootView;

    private XianwanGameAdsItemBinding(@NonNull ThemeLinearLayout themeLinearLayout, @NonNull ThemeTextView themeTextView, @NonNull ThemeImageView themeImageView, @NonNull ThemeTextView themeTextView2, @NonNull ThemeLinearLayout themeLinearLayout2) {
        this.rootView = themeLinearLayout;
        this.gameBtn = themeTextView;
        this.gameIcon = themeImageView;
        this.gameTitle = themeTextView2;
        this.gameView = themeLinearLayout2;
    }

    @NonNull
    public static XianwanGameAdsItemBinding bind(@NonNull View view) {
        int i10 = R.id.game_btn;
        ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
        if (themeTextView != null) {
            i10 = R.id.game_icon;
            ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
            if (themeImageView != null) {
                i10 = R.id.game_title;
                ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (themeTextView2 != null) {
                    ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) view;
                    return new XianwanGameAdsItemBinding(themeLinearLayout, themeTextView, themeImageView, themeTextView2, themeLinearLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static XianwanGameAdsItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static XianwanGameAdsItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.xianwan_game_ads_item, viewGroup, false);
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
