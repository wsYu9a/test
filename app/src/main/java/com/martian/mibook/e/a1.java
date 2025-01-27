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
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class a1 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final FrameLayout f11666a;

    /* renamed from: b */
    @NonNull
    public final FrameLayout f11667b;

    /* renamed from: c */
    @NonNull
    public final LinearLayout f11668c;

    /* renamed from: d */
    @NonNull
    public final View f11669d;

    /* renamed from: e */
    @NonNull
    public final ImageView f11670e;

    /* renamed from: f */
    @NonNull
    public final ImageView f11671f;

    /* renamed from: g */
    @NonNull
    public final FrameLayout f11672g;

    /* renamed from: h */
    @NonNull
    public final LinearLayout f11673h;

    /* renamed from: i */
    @NonNull
    public final LinearLayout f11674i;

    /* renamed from: j */
    @NonNull
    public final TextView f11675j;

    @NonNull
    public final ThemeTextView k;

    private a1(@NonNull FrameLayout rootView, @NonNull FrameLayout adsContainer, @NonNull LinearLayout brCloseAdsIcon, @NonNull View gridAdsShade, @NonNull ImageView ivAdsLogo, @NonNull ImageView ivAppIcon, @NonNull FrameLayout ivVideoView, @NonNull LinearLayout llAdContainer, @NonNull LinearLayout llAdView, @NonNull TextView tvAdsLogoDesc, @NonNull ThemeTextView tvAppDesc) {
        this.f11666a = rootView;
        this.f11667b = adsContainer;
        this.f11668c = brCloseAdsIcon;
        this.f11669d = gridAdsShade;
        this.f11670e = ivAdsLogo;
        this.f11671f = ivAppIcon;
        this.f11672g = ivVideoView;
        this.f11673h = llAdContainer;
        this.f11674i = llAdView;
        this.f11675j = tvAdsLogoDesc;
        this.k = tvAppDesc;
    }

    @NonNull
    public static a1 a(@NonNull View rootView) {
        FrameLayout frameLayout = (FrameLayout) rootView;
        int i2 = R.id.br_close_ads_icon;
        LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.br_close_ads_icon);
        if (linearLayout != null) {
            i2 = R.id.grid_ads_shade;
            View findViewById = rootView.findViewById(R.id.grid_ads_shade);
            if (findViewById != null) {
                i2 = R.id.iv_ads_logo;
                ImageView imageView = (ImageView) rootView.findViewById(R.id.iv_ads_logo);
                if (imageView != null) {
                    i2 = R.id.iv_app_icon;
                    ImageView imageView2 = (ImageView) rootView.findViewById(R.id.iv_app_icon);
                    if (imageView2 != null) {
                        i2 = R.id.iv_video_view;
                        FrameLayout frameLayout2 = (FrameLayout) rootView.findViewById(R.id.iv_video_view);
                        if (frameLayout2 != null) {
                            i2 = R.id.ll_ad_container;
                            LinearLayout linearLayout2 = (LinearLayout) rootView.findViewById(R.id.ll_ad_container);
                            if (linearLayout2 != null) {
                                i2 = R.id.ll_ad_view;
                                LinearLayout linearLayout3 = (LinearLayout) rootView.findViewById(R.id.ll_ad_view);
                                if (linearLayout3 != null) {
                                    i2 = R.id.tv_ads_logo_desc;
                                    TextView textView = (TextView) rootView.findViewById(R.id.tv_ads_logo_desc);
                                    if (textView != null) {
                                        i2 = R.id.tv_app_desc;
                                        ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.tv_app_desc);
                                        if (themeTextView != null) {
                                            return new a1((FrameLayout) rootView, frameLayout, linearLayout, findViewById, imageView, imageView2, frameLayout2, linearLayout2, linearLayout3, textView, themeTextView);
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
    public static a1 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static a1 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.book_store_grid_ads_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public FrameLayout getRoot() {
        return this.f11666a;
    }
}
