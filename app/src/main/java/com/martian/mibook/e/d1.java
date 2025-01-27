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
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class d1 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeLinearLayout f11824a;

    /* renamed from: b */
    @NonNull
    public final ThemeLinearLayout f11825b;

    /* renamed from: c */
    @NonNull
    public final ImageView f11826c;

    /* renamed from: d */
    @NonNull
    public final RelativeLayout f11827d;

    /* renamed from: e */
    @NonNull
    public final ImageView f11828e;

    /* renamed from: f */
    @NonNull
    public final ImageView f11829f;

    /* renamed from: g */
    @NonNull
    public final RelativeLayout f11830g;

    /* renamed from: h */
    @NonNull
    public final FrameLayout f11831h;

    /* renamed from: i */
    @NonNull
    public final View f11832i;

    /* renamed from: j */
    @NonNull
    public final RelativeLayout f11833j;

    @NonNull
    public final ThemeLinearLayout k;

    @NonNull
    public final ThemeLinearLayout l;

    @NonNull
    public final TextView m;

    @NonNull
    public final ThemeTextView n;

    @NonNull
    public final ThemeTextView o;

    private d1(@NonNull ThemeLinearLayout rootView, @NonNull ThemeLinearLayout adsContainer, @NonNull ImageView brCloseAdsIcon, @NonNull RelativeLayout flGdtContainer, @NonNull ImageView ivAdsLogo, @NonNull ImageView ivAppIcon, @NonNull RelativeLayout ivAppIconView, @NonNull FrameLayout ivVideoView, @NonNull View listAdsShade, @NonNull RelativeLayout listAdsView, @NonNull ThemeLinearLayout llAdContainer, @NonNull ThemeLinearLayout llAdView, @NonNull TextView tvAdsLogoDesc, @NonNull ThemeTextView tvAppDesc, @NonNull ThemeTextView tvAppTitle) {
        this.f11824a = rootView;
        this.f11825b = adsContainer;
        this.f11826c = brCloseAdsIcon;
        this.f11827d = flGdtContainer;
        this.f11828e = ivAdsLogo;
        this.f11829f = ivAppIcon;
        this.f11830g = ivAppIconView;
        this.f11831h = ivVideoView;
        this.f11832i = listAdsShade;
        this.f11833j = listAdsView;
        this.k = llAdContainer;
        this.l = llAdView;
        this.m = tvAdsLogoDesc;
        this.n = tvAppDesc;
        this.o = tvAppTitle;
    }

    @NonNull
    public static d1 a(@NonNull View rootView) {
        ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) rootView;
        int i2 = R.id.br_close_ads_icon;
        ImageView imageView = (ImageView) rootView.findViewById(R.id.br_close_ads_icon);
        if (imageView != null) {
            i2 = R.id.fl_gdt_container;
            RelativeLayout relativeLayout = (RelativeLayout) rootView.findViewById(R.id.fl_gdt_container);
            if (relativeLayout != null) {
                i2 = R.id.iv_ads_logo;
                ImageView imageView2 = (ImageView) rootView.findViewById(R.id.iv_ads_logo);
                if (imageView2 != null) {
                    i2 = R.id.iv_app_icon;
                    ImageView imageView3 = (ImageView) rootView.findViewById(R.id.iv_app_icon);
                    if (imageView3 != null) {
                        i2 = R.id.iv_app_icon_view;
                        RelativeLayout relativeLayout2 = (RelativeLayout) rootView.findViewById(R.id.iv_app_icon_view);
                        if (relativeLayout2 != null) {
                            i2 = R.id.iv_video_view;
                            FrameLayout frameLayout = (FrameLayout) rootView.findViewById(R.id.iv_video_view);
                            if (frameLayout != null) {
                                i2 = R.id.list_ads_shade;
                                View findViewById = rootView.findViewById(R.id.list_ads_shade);
                                if (findViewById != null) {
                                    i2 = R.id.list_ads_view;
                                    RelativeLayout relativeLayout3 = (RelativeLayout) rootView.findViewById(R.id.list_ads_view);
                                    if (relativeLayout3 != null) {
                                        i2 = R.id.ll_ad_container;
                                        ThemeLinearLayout themeLinearLayout2 = (ThemeLinearLayout) rootView.findViewById(R.id.ll_ad_container);
                                        if (themeLinearLayout2 != null) {
                                            i2 = R.id.ll_ad_view;
                                            ThemeLinearLayout themeLinearLayout3 = (ThemeLinearLayout) rootView.findViewById(R.id.ll_ad_view);
                                            if (themeLinearLayout3 != null) {
                                                i2 = R.id.tv_ads_logo_desc;
                                                TextView textView = (TextView) rootView.findViewById(R.id.tv_ads_logo_desc);
                                                if (textView != null) {
                                                    i2 = R.id.tv_app_desc;
                                                    ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.tv_app_desc);
                                                    if (themeTextView != null) {
                                                        i2 = R.id.tv_app_title;
                                                        ThemeTextView themeTextView2 = (ThemeTextView) rootView.findViewById(R.id.tv_app_title);
                                                        if (themeTextView2 != null) {
                                                            return new d1((ThemeLinearLayout) rootView, themeLinearLayout, imageView, relativeLayout, imageView2, imageView3, relativeLayout2, frameLayout, findViewById, relativeLayout3, themeLinearLayout2, themeLinearLayout3, textView, themeTextView, themeTextView2);
                                                        }
                                                    }
                                                }
                                            }
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
    public static d1 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static d1 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.book_store_list_ads_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeLinearLayout getRoot() {
        return this.f11824a;
    }
}
