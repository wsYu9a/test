package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class BonusDetailAdsItemSmallBinding implements ViewBinding {

    @NonNull
    public final ThemeTextView bonusAdsDesc;

    @NonNull
    public final ImageView bonusAdsImage;

    @NonNull
    public final ThemeTextView bonusAdsTitle;

    @NonNull
    public final RelativeLayout bonusAdsView;

    @NonNull
    public final FrameLayout ivAdsVideo;

    @NonNull
    private final RelativeLayout rootView;

    @NonNull
    public final ImageView tvAdsLogo;

    @NonNull
    public final TextView tvAdsLogoDesc;

    private BonusDetailAdsItemSmallBinding(@NonNull RelativeLayout relativeLayout, @NonNull ThemeTextView themeTextView, @NonNull ImageView imageView, @NonNull ThemeTextView themeTextView2, @NonNull RelativeLayout relativeLayout2, @NonNull FrameLayout frameLayout, @NonNull ImageView imageView2, @NonNull TextView textView) {
        this.rootView = relativeLayout;
        this.bonusAdsDesc = themeTextView;
        this.bonusAdsImage = imageView;
        this.bonusAdsTitle = themeTextView2;
        this.bonusAdsView = relativeLayout2;
        this.ivAdsVideo = frameLayout;
        this.tvAdsLogo = imageView2;
        this.tvAdsLogoDesc = textView;
    }

    @NonNull
    public static BonusDetailAdsItemSmallBinding bind(@NonNull View view) {
        int i10 = R.id.bonus_ads_desc;
        ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
        if (themeTextView != null) {
            i10 = R.id.bonus_ads_image;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
            if (imageView != null) {
                i10 = R.id.bonus_ads_title;
                ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (themeTextView2 != null) {
                    RelativeLayout relativeLayout = (RelativeLayout) view;
                    i10 = R.id.iv_ads_video;
                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i10);
                    if (frameLayout != null) {
                        i10 = R.id.tv_ads_logo;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i10);
                        if (imageView2 != null) {
                            i10 = R.id.tv_ads_logo_desc;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
                            if (textView != null) {
                                return new BonusDetailAdsItemSmallBinding(relativeLayout, themeTextView, imageView, themeTextView2, relativeLayout, frameLayout, imageView2, textView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static BonusDetailAdsItemSmallBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static BonusDetailAdsItemSmallBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.bonus_detail_ads_item_small, viewGroup, false);
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
