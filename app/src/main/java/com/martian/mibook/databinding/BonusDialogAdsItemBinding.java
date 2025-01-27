package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class BonusDialogAdsItemBinding implements ViewBinding {

    @NonNull
    public final TextView bonusAdsDesc;

    @NonNull
    public final ImageView bonusAdsImage;

    @NonNull
    public final TextView bonusAdsTitle;

    @NonNull
    public final FrameLayout bonusAdsView;

    @NonNull
    public final Button frOptionButton;

    @NonNull
    public final FrameLayout ivAdsVideo;

    @NonNull
    private final FrameLayout rootView;

    @NonNull
    public final ImageView tvAdsLogo;

    @NonNull
    public final TextView tvAdsLogoDesc;

    private BonusDialogAdsItemBinding(@NonNull FrameLayout frameLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull TextView textView2, @NonNull FrameLayout frameLayout2, @NonNull Button button, @NonNull FrameLayout frameLayout3, @NonNull ImageView imageView2, @NonNull TextView textView3) {
        this.rootView = frameLayout;
        this.bonusAdsDesc = textView;
        this.bonusAdsImage = imageView;
        this.bonusAdsTitle = textView2;
        this.bonusAdsView = frameLayout2;
        this.frOptionButton = button;
        this.ivAdsVideo = frameLayout3;
        this.tvAdsLogo = imageView2;
        this.tvAdsLogoDesc = textView3;
    }

    @NonNull
    public static BonusDialogAdsItemBinding bind(@NonNull View view) {
        int i10 = R.id.bonus_ads_desc;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
        if (textView != null) {
            i10 = R.id.bonus_ads_image;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
            if (imageView != null) {
                i10 = R.id.bonus_ads_title;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i10);
                if (textView2 != null) {
                    FrameLayout frameLayout = (FrameLayout) view;
                    i10 = R.id.fr_option_button;
                    Button button = (Button) ViewBindings.findChildViewById(view, i10);
                    if (button != null) {
                        i10 = R.id.iv_ads_video;
                        FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, i10);
                        if (frameLayout2 != null) {
                            i10 = R.id.tv_ads_logo;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i10);
                            if (imageView2 != null) {
                                i10 = R.id.tv_ads_logo_desc;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i10);
                                if (textView3 != null) {
                                    return new BonusDialogAdsItemBinding(frameLayout, textView, imageView, textView2, frameLayout, button, frameLayout2, imageView2, textView3);
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
    public static BonusDialogAdsItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static BonusDialogAdsItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.bonus_dialog_ads_item, viewGroup, false);
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
