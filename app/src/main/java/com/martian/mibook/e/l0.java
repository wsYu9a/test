package com.martian.mibook.e;

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
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class l0 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeLinearLayout f12275a;

    /* renamed from: b */
    @NonNull
    public final TextView f12276b;

    /* renamed from: c */
    @NonNull
    public final ThemeTextView f12277c;

    /* renamed from: d */
    @NonNull
    public final LinearLayout f12278d;

    /* renamed from: e */
    @NonNull
    public final ImageView f12279e;

    /* renamed from: f */
    @NonNull
    public final ImageView f12280f;

    /* renamed from: g */
    @NonNull
    public final ThemeTextView f12281g;

    /* renamed from: h */
    @NonNull
    public final FrameLayout f12282h;

    /* renamed from: i */
    @NonNull
    public final ImageView f12283i;

    /* renamed from: j */
    @NonNull
    public final TextView f12284j;

    private l0(@NonNull ThemeLinearLayout rootView, @NonNull TextView bonusAdsButton, @NonNull ThemeTextView bonusAdsDesc, @NonNull LinearLayout bonusAdsDetailView, @NonNull ImageView bonusAdsIcon, @NonNull ImageView bonusAdsImage, @NonNull ThemeTextView bonusAdsTitle, @NonNull FrameLayout ivAdsVideo, @NonNull ImageView tvAdsLogo, @NonNull TextView tvAdsLogoDesc) {
        this.f12275a = rootView;
        this.f12276b = bonusAdsButton;
        this.f12277c = bonusAdsDesc;
        this.f12278d = bonusAdsDetailView;
        this.f12279e = bonusAdsIcon;
        this.f12280f = bonusAdsImage;
        this.f12281g = bonusAdsTitle;
        this.f12282h = ivAdsVideo;
        this.f12283i = tvAdsLogo;
        this.f12284j = tvAdsLogoDesc;
    }

    @NonNull
    public static l0 a(@NonNull View rootView) {
        int i2 = R.id.bonus_ads_button;
        TextView textView = (TextView) rootView.findViewById(R.id.bonus_ads_button);
        if (textView != null) {
            i2 = R.id.bonus_ads_desc;
            ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.bonus_ads_desc);
            if (themeTextView != null) {
                i2 = R.id.bonus_ads_detail_view;
                LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.bonus_ads_detail_view);
                if (linearLayout != null) {
                    i2 = R.id.bonus_ads_icon;
                    ImageView imageView = (ImageView) rootView.findViewById(R.id.bonus_ads_icon);
                    if (imageView != null) {
                        i2 = R.id.bonus_ads_image;
                        ImageView imageView2 = (ImageView) rootView.findViewById(R.id.bonus_ads_image);
                        if (imageView2 != null) {
                            i2 = R.id.bonus_ads_title;
                            ThemeTextView themeTextView2 = (ThemeTextView) rootView.findViewById(R.id.bonus_ads_title);
                            if (themeTextView2 != null) {
                                i2 = R.id.iv_ads_video;
                                FrameLayout frameLayout = (FrameLayout) rootView.findViewById(R.id.iv_ads_video);
                                if (frameLayout != null) {
                                    i2 = R.id.tv_ads_logo;
                                    ImageView imageView3 = (ImageView) rootView.findViewById(R.id.tv_ads_logo);
                                    if (imageView3 != null) {
                                        i2 = R.id.tv_ads_logo_desc;
                                        TextView textView2 = (TextView) rootView.findViewById(R.id.tv_ads_logo_desc);
                                        if (textView2 != null) {
                                            return new l0((ThemeLinearLayout) rootView, textView, themeTextView, linearLayout, imageView, imageView2, themeTextView2, frameLayout, imageView3, textView2);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static l0 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static l0 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.bonus_detail_ads_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeLinearLayout getRoot() {
        return this.f12275a;
    }
}
