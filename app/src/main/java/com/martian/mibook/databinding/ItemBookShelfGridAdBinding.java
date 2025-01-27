package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class ItemBookShelfGridAdBinding implements ViewBinding {

    @NonNull
    public final FrameLayout adsContainer;

    @NonNull
    public final LinearLayout brCloseAdsIcon;

    @NonNull
    public final View gridAdsShade;

    @NonNull
    public final ImageView ivAdsLogo;

    @NonNull
    public final ImageView ivAppIcon;

    @NonNull
    public final FrameLayout ivVideoView;

    @NonNull
    public final LinearLayout llAdContainer;

    @NonNull
    public final LinearLayout llAdView;

    @NonNull
    private final FrameLayout rootView;

    @NonNull
    public final TextView tvAdsLogoDesc;

    @NonNull
    public final ThemeTextView tvAppDesc;

    private ItemBookShelfGridAdBinding(@NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2, @NonNull LinearLayout linearLayout, @NonNull View view, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull FrameLayout frameLayout3, @NonNull LinearLayout linearLayout2, @NonNull LinearLayout linearLayout3, @NonNull TextView textView, @NonNull ThemeTextView themeTextView) {
        this.rootView = frameLayout;
        this.adsContainer = frameLayout2;
        this.brCloseAdsIcon = linearLayout;
        this.gridAdsShade = view;
        this.ivAdsLogo = imageView;
        this.ivAppIcon = imageView2;
        this.ivVideoView = frameLayout3;
        this.llAdContainer = linearLayout2;
        this.llAdView = linearLayout3;
        this.tvAdsLogoDesc = textView;
        this.tvAppDesc = themeTextView;
    }

    @NonNull
    public static ItemBookShelfGridAdBinding bind(@NonNull View view) {
        View findChildViewById;
        FrameLayout frameLayout = (FrameLayout) view;
        int i10 = R.id.br_close_ads_icon;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
        if (linearLayout != null && (findChildViewById = ViewBindings.findChildViewById(view, (i10 = R.id.grid_ads_shade))) != null) {
            i10 = R.id.iv_ads_logo;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
            if (imageView != null) {
                i10 = R.id.iv_app_icon;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i10);
                if (imageView2 != null) {
                    i10 = R.id.iv_video_view;
                    FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, i10);
                    if (frameLayout2 != null) {
                        i10 = R.id.ll_ad_container;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                        if (linearLayout2 != null) {
                            i10 = R.id.ll_ad_view;
                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                            if (linearLayout3 != null) {
                                i10 = R.id.tv_ads_logo_desc;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
                                if (textView != null) {
                                    i10 = R.id.tv_app_desc;
                                    ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                    if (themeTextView != null) {
                                        return new ItemBookShelfGridAdBinding(frameLayout, frameLayout, linearLayout, findChildViewById, imageView, imageView2, frameLayout2, linearLayout2, linearLayout3, textView, themeTextView);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ItemBookShelfGridAdBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ItemBookShelfGridAdBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.item_book_shelf_grid_ad, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public FrameLayout getRoot() {
        return this.rootView;
    }
}
