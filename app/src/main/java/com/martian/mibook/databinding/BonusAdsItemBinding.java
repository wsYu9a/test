package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class BonusAdsItemBinding implements ViewBinding {

    @NonNull
    public final ImageView bonusAdsImage;

    @NonNull
    public final ThemeTextView bonusAdsTitle;

    @NonNull
    public final ThemeTextView frOptionButton;

    @NonNull
    public final FrameLayout ivAdsVideo;

    @NonNull
    private final ThemeLinearLayout rootView;

    @NonNull
    public final ImageView tvAdsLogo;

    @NonNull
    public final TextView tvAdsLogoDesc;

    private BonusAdsItemBinding(@NonNull ThemeLinearLayout themeLinearLayout, @NonNull ImageView imageView, @NonNull ThemeTextView themeTextView, @NonNull ThemeTextView themeTextView2, @NonNull FrameLayout frameLayout, @NonNull ImageView imageView2, @NonNull TextView textView) {
        this.rootView = themeLinearLayout;
        this.bonusAdsImage = imageView;
        this.bonusAdsTitle = themeTextView;
        this.frOptionButton = themeTextView2;
        this.ivAdsVideo = frameLayout;
        this.tvAdsLogo = imageView2;
        this.tvAdsLogoDesc = textView;
    }

    @NonNull
    public static BonusAdsItemBinding bind(@NonNull View view) {
        int i10 = R.id.bonus_ads_image;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
        if (imageView != null) {
            i10 = R.id.bonus_ads_title;
            ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
            if (themeTextView != null) {
                i10 = R.id.fr_option_button;
                ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (themeTextView2 != null) {
                    i10 = R.id.iv_ads_video;
                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i10);
                    if (frameLayout != null) {
                        i10 = R.id.tv_ads_logo;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i10);
                        if (imageView2 != null) {
                            i10 = R.id.tv_ads_logo_desc;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
                            if (textView != null) {
                                return new BonusAdsItemBinding((ThemeLinearLayout) view, imageView, themeTextView, themeTextView2, frameLayout, imageView2, textView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static BonusAdsItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static BonusAdsItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.bonus_ads_item, viewGroup, false);
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
