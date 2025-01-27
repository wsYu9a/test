package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class k0 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeLinearLayout f12222a;

    /* renamed from: b */
    @NonNull
    public final ImageView f12223b;

    /* renamed from: c */
    @NonNull
    public final ThemeTextView f12224c;

    /* renamed from: d */
    @NonNull
    public final ThemeTextView f12225d;

    /* renamed from: e */
    @NonNull
    public final FrameLayout f12226e;

    /* renamed from: f */
    @NonNull
    public final ImageView f12227f;

    /* renamed from: g */
    @NonNull
    public final TextView f12228g;

    private k0(@NonNull ThemeLinearLayout rootView, @NonNull ImageView bonusAdsImage, @NonNull ThemeTextView bonusAdsTitle, @NonNull ThemeTextView frOptionButton, @NonNull FrameLayout ivAdsVideo, @NonNull ImageView tvAdsLogo, @NonNull TextView tvAdsLogoDesc) {
        this.f12222a = rootView;
        this.f12223b = bonusAdsImage;
        this.f12224c = bonusAdsTitle;
        this.f12225d = frOptionButton;
        this.f12226e = ivAdsVideo;
        this.f12227f = tvAdsLogo;
        this.f12228g = tvAdsLogoDesc;
    }

    @NonNull
    public static k0 a(@NonNull View rootView) {
        int i2 = R.id.bonus_ads_image;
        ImageView imageView = (ImageView) rootView.findViewById(R.id.bonus_ads_image);
        if (imageView != null) {
            i2 = R.id.bonus_ads_title;
            ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.bonus_ads_title);
            if (themeTextView != null) {
                i2 = R.id.fr_option_button;
                ThemeTextView themeTextView2 = (ThemeTextView) rootView.findViewById(R.id.fr_option_button);
                if (themeTextView2 != null) {
                    i2 = R.id.iv_ads_video;
                    FrameLayout frameLayout = (FrameLayout) rootView.findViewById(R.id.iv_ads_video);
                    if (frameLayout != null) {
                        i2 = R.id.tv_ads_logo;
                        ImageView imageView2 = (ImageView) rootView.findViewById(R.id.tv_ads_logo);
                        if (imageView2 != null) {
                            i2 = R.id.tv_ads_logo_desc;
                            TextView textView = (TextView) rootView.findViewById(R.id.tv_ads_logo_desc);
                            if (textView != null) {
                                return new k0((ThemeLinearLayout) rootView, imageView, themeTextView, themeTextView2, frameLayout, imageView2, textView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static k0 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static k0 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.bonus_ads_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeLinearLayout getRoot() {
        return this.f12222a;
    }
}
