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
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.mibook.ui.reader.ReaderThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class i5 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f12126a;

    /* renamed from: b */
    @NonNull
    public final ThemeImageView f12127b;

    /* renamed from: c */
    @NonNull
    public final TextView f12128c;

    /* renamed from: d */
    @NonNull
    public final TextView f12129d;

    /* renamed from: e */
    @NonNull
    public final LinearLayout f12130e;

    /* renamed from: f */
    @NonNull
    public final TextView f12131f;

    /* renamed from: g */
    @NonNull
    public final ImageView f12132g;

    /* renamed from: h */
    @NonNull
    public final ImageView f12133h;

    /* renamed from: i */
    @NonNull
    public final FrameLayout f12134i;

    /* renamed from: j */
    @NonNull
    public final ReaderThemeTextView f12135j;

    @NonNull
    public final ImageView k;

    @NonNull
    public final LinearLayout l;

    @NonNull
    public final ImageView m;

    @NonNull
    public final TextView n;

    @NonNull
    public final ReaderThemeTextView o;

    @NonNull
    public final LinearLayout p;

    @NonNull
    public final ReaderThemeTextView q;

    private i5(@NonNull LinearLayout rootView, @NonNull ThemeImageView actionbarDivider, @NonNull TextView adClickGuide, @NonNull TextView btnNativeCreative, @NonNull LinearLayout btnNativeCreativeView, @NonNull TextView ivAdsHint, @NonNull ImageView ivAdsImage, @NonNull ImageView ivAdsTag, @NonNull FrameLayout ivAdsVideo, @NonNull ReaderThemeTextView tvAdsDesc, @NonNull ImageView tvAdsIcon, @NonNull LinearLayout tvAdsIconView, @NonNull ImageView tvAdsLogo, @NonNull TextView tvAdsLogoDesc, @NonNull ReaderThemeTextView tvAdsPromote, @NonNull LinearLayout tvAdsShakeView, @NonNull ReaderThemeTextView tvAdsTitle) {
        this.f12126a = rootView;
        this.f12127b = actionbarDivider;
        this.f12128c = adClickGuide;
        this.f12129d = btnNativeCreative;
        this.f12130e = btnNativeCreativeView;
        this.f12131f = ivAdsHint;
        this.f12132g = ivAdsImage;
        this.f12133h = ivAdsTag;
        this.f12134i = ivAdsVideo;
        this.f12135j = tvAdsDesc;
        this.k = tvAdsIcon;
        this.l = tvAdsIconView;
        this.m = tvAdsLogo;
        this.n = tvAdsLogoDesc;
        this.o = tvAdsPromote;
        this.p = tvAdsShakeView;
        this.q = tvAdsTitle;
    }

    @NonNull
    public static i5 a(@NonNull View rootView) {
        int i2 = R.id.actionbar_divider;
        ThemeImageView themeImageView = (ThemeImageView) rootView.findViewById(R.id.actionbar_divider);
        if (themeImageView != null) {
            i2 = R.id.ad_click_guide;
            TextView textView = (TextView) rootView.findViewById(R.id.ad_click_guide);
            if (textView != null) {
                i2 = R.id.btn_native_creative;
                TextView textView2 = (TextView) rootView.findViewById(R.id.btn_native_creative);
                if (textView2 != null) {
                    i2 = R.id.btn_native_creative_view;
                    LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.btn_native_creative_view);
                    if (linearLayout != null) {
                        i2 = R.id.iv_ads_hint;
                        TextView textView3 = (TextView) rootView.findViewById(R.id.iv_ads_hint);
                        if (textView3 != null) {
                            i2 = R.id.iv_ads_image;
                            ImageView imageView = (ImageView) rootView.findViewById(R.id.iv_ads_image);
                            if (imageView != null) {
                                i2 = R.id.iv_ads_tag;
                                ImageView imageView2 = (ImageView) rootView.findViewById(R.id.iv_ads_tag);
                                if (imageView2 != null) {
                                    i2 = R.id.iv_ads_video;
                                    FrameLayout frameLayout = (FrameLayout) rootView.findViewById(R.id.iv_ads_video);
                                    if (frameLayout != null) {
                                        i2 = R.id.tv_ads_desc;
                                        ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) rootView.findViewById(R.id.tv_ads_desc);
                                        if (readerThemeTextView != null) {
                                            i2 = R.id.tv_ads_icon;
                                            ImageView imageView3 = (ImageView) rootView.findViewById(R.id.tv_ads_icon);
                                            if (imageView3 != null) {
                                                i2 = R.id.tv_ads_icon_view;
                                                LinearLayout linearLayout2 = (LinearLayout) rootView.findViewById(R.id.tv_ads_icon_view);
                                                if (linearLayout2 != null) {
                                                    i2 = R.id.tv_ads_logo;
                                                    ImageView imageView4 = (ImageView) rootView.findViewById(R.id.tv_ads_logo);
                                                    if (imageView4 != null) {
                                                        i2 = R.id.tv_ads_logo_desc;
                                                        TextView textView4 = (TextView) rootView.findViewById(R.id.tv_ads_logo_desc);
                                                        if (textView4 != null) {
                                                            i2 = R.id.tv_ads_promote;
                                                            ReaderThemeTextView readerThemeTextView2 = (ReaderThemeTextView) rootView.findViewById(R.id.tv_ads_promote);
                                                            if (readerThemeTextView2 != null) {
                                                                i2 = R.id.tv_ads_shake_view;
                                                                LinearLayout linearLayout3 = (LinearLayout) rootView.findViewById(R.id.tv_ads_shake_view);
                                                                if (linearLayout3 != null) {
                                                                    i2 = R.id.tv_ads_title;
                                                                    ReaderThemeTextView readerThemeTextView3 = (ReaderThemeTextView) rootView.findViewById(R.id.tv_ads_title);
                                                                    if (readerThemeTextView3 != null) {
                                                                        return new i5((LinearLayout) rootView, themeImageView, textView, textView2, linearLayout, textView3, imageView, imageView2, frameLayout, readerThemeTextView, imageView3, linearLayout2, imageView4, textView4, readerThemeTextView2, linearLayout3, readerThemeTextView3);
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
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static i5 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static i5 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.reading_ads_item_fullscreen, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f12126a;
    }
}
