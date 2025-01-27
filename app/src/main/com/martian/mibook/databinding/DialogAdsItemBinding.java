package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class DialogAdsItemBinding implements ViewBinding {

    @NonNull
    public final Button bonusAdsButton;

    @NonNull
    public final TextView bonusAdsDesc;

    @NonNull
    public final LinearLayout bonusAdsDetailView;

    @NonNull
    public final ImageView bonusAdsIcon;

    @NonNull
    public final ImageView bonusAdsImage;

    @NonNull
    public final TextView bonusAdsTitle;

    @NonNull
    public final FrameLayout bonusAdsView;

    @NonNull
    public final FrameLayout ivAdsVideo;

    @NonNull
    private final FrameLayout rootView;

    @NonNull
    public final ImageView tvAdsLogo;

    @NonNull
    public final TextView tvAdsLogoDesc;

    private DialogAdsItemBinding(@NonNull FrameLayout frameLayout, @NonNull Button button, @NonNull TextView textView, @NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull TextView textView2, @NonNull FrameLayout frameLayout2, @NonNull FrameLayout frameLayout3, @NonNull ImageView imageView3, @NonNull TextView textView3) {
        this.rootView = frameLayout;
        this.bonusAdsButton = button;
        this.bonusAdsDesc = textView;
        this.bonusAdsDetailView = linearLayout;
        this.bonusAdsIcon = imageView;
        this.bonusAdsImage = imageView2;
        this.bonusAdsTitle = textView2;
        this.bonusAdsView = frameLayout2;
        this.ivAdsVideo = frameLayout3;
        this.tvAdsLogo = imageView3;
        this.tvAdsLogoDesc = textView3;
    }

    @NonNull
    public static DialogAdsItemBinding bind(@NonNull View view) {
        int i10 = R.id.bonus_ads_button;
        Button button = (Button) ViewBindings.findChildViewById(view, i10);
        if (button != null) {
            i10 = R.id.bonus_ads_desc;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
            if (textView != null) {
                i10 = R.id.bonus_ads_detail_view;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                if (linearLayout != null) {
                    i10 = R.id.bonus_ads_icon;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
                    if (imageView != null) {
                        i10 = R.id.bonus_ads_image;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i10);
                        if (imageView2 != null) {
                            i10 = R.id.bonus_ads_title;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i10);
                            if (textView2 != null) {
                                FrameLayout frameLayout = (FrameLayout) view;
                                i10 = R.id.iv_ads_video;
                                FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, i10);
                                if (frameLayout2 != null) {
                                    i10 = R.id.tv_ads_logo;
                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i10);
                                    if (imageView3 != null) {
                                        i10 = R.id.tv_ads_logo_desc;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i10);
                                        if (textView3 != null) {
                                            return new DialogAdsItemBinding(frameLayout, button, textView, linearLayout, imageView, imageView2, textView2, frameLayout, frameLayout2, imageView3, textView3);
                                        }
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
    public static DialogAdsItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogAdsItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.dialog_ads_item, viewGroup, false);
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
