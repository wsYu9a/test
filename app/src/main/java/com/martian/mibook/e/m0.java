package com.martian.mibook.e;

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
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class m0 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final RelativeLayout f12329a;

    /* renamed from: b */
    @NonNull
    public final ThemeTextView f12330b;

    /* renamed from: c */
    @NonNull
    public final ImageView f12331c;

    /* renamed from: d */
    @NonNull
    public final ThemeTextView f12332d;

    /* renamed from: e */
    @NonNull
    public final RelativeLayout f12333e;

    /* renamed from: f */
    @NonNull
    public final FrameLayout f12334f;

    /* renamed from: g */
    @NonNull
    public final ImageView f12335g;

    /* renamed from: h */
    @NonNull
    public final TextView f12336h;

    private m0(@NonNull RelativeLayout rootView, @NonNull ThemeTextView bonusAdsDesc, @NonNull ImageView bonusAdsImage, @NonNull ThemeTextView bonusAdsTitle, @NonNull RelativeLayout bonusAdsView, @NonNull FrameLayout ivAdsVideo, @NonNull ImageView tvAdsLogo, @NonNull TextView tvAdsLogoDesc) {
        this.f12329a = rootView;
        this.f12330b = bonusAdsDesc;
        this.f12331c = bonusAdsImage;
        this.f12332d = bonusAdsTitle;
        this.f12333e = bonusAdsView;
        this.f12334f = ivAdsVideo;
        this.f12335g = tvAdsLogo;
        this.f12336h = tvAdsLogoDesc;
    }

    @NonNull
    public static m0 a(@NonNull View rootView) {
        int i2 = R.id.bonus_ads_desc;
        ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.bonus_ads_desc);
        if (themeTextView != null) {
            i2 = R.id.bonus_ads_image;
            ImageView imageView = (ImageView) rootView.findViewById(R.id.bonus_ads_image);
            if (imageView != null) {
                i2 = R.id.bonus_ads_title;
                ThemeTextView themeTextView2 = (ThemeTextView) rootView.findViewById(R.id.bonus_ads_title);
                if (themeTextView2 != null) {
                    RelativeLayout relativeLayout = (RelativeLayout) rootView;
                    i2 = R.id.iv_ads_video;
                    FrameLayout frameLayout = (FrameLayout) rootView.findViewById(R.id.iv_ads_video);
                    if (frameLayout != null) {
                        i2 = R.id.tv_ads_logo;
                        ImageView imageView2 = (ImageView) rootView.findViewById(R.id.tv_ads_logo);
                        if (imageView2 != null) {
                            i2 = R.id.tv_ads_logo_desc;
                            TextView textView = (TextView) rootView.findViewById(R.id.tv_ads_logo_desc);
                            if (textView != null) {
                                return new m0(relativeLayout, themeTextView, imageView, themeTextView2, relativeLayout, frameLayout, imageView2, textView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static m0 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static m0 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.bonus_detail_ads_item_small, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f12329a;
    }
}
