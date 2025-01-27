package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.widget.RoundedLayout;
import com.martian.mibook.ui.reader.ReaderThemeImageView;
import com.martian.mibook.ui.reader.ReaderThemeLinearLayout;
import com.martian.mibook.ui.reader.ReaderThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class d5 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ReaderThemeLinearLayout f11848a;

    /* renamed from: b */
    @NonNull
    public final TextView f11849b;

    /* renamed from: c */
    @NonNull
    public final TextView f11850c;

    /* renamed from: d */
    @NonNull
    public final LinearLayout f11851d;

    /* renamed from: e */
    @NonNull
    public final RelativeLayout f11852e;

    /* renamed from: f */
    @NonNull
    public final LinearLayout f11853f;

    /* renamed from: g */
    @NonNull
    public final FrameLayout f11854g;

    /* renamed from: h */
    @NonNull
    public final ReaderThemeImageView f11855h;

    /* renamed from: i */
    @NonNull
    public final ImageView f11856i;

    /* renamed from: j */
    @NonNull
    public final ImageView f11857j;

    @NonNull
    public final RoundedLayout k;

    @NonNull
    public final TextView l;

    @NonNull
    public final LinearLayout m;

    @NonNull
    public final ReaderThemeTextView n;

    @NonNull
    public final ReaderThemeTextView o;

    private d5(@NonNull ReaderThemeLinearLayout rootView, @NonNull TextView bannerClickGuide, @NonNull TextView btnNativeCreative, @NonNull LinearLayout btnNativeCreativeButton, @NonNull RelativeLayout btnNativeCreativeView, @NonNull LinearLayout descTextView, @NonNull FrameLayout ivAdsVideo, @NonNull ReaderThemeImageView ivNativeCloseIcon, @NonNull ImageView ivNativeImage, @NonNull ImageView ivNativeLogo, @NonNull RoundedLayout picView, @NonNull TextView tvAdsLogoDesc, @NonNull LinearLayout tvAdsLogoView, @NonNull ReaderThemeTextView tvNativeAdDesc, @NonNull ReaderThemeTextView tvNativeAdTitle) {
        this.f11848a = rootView;
        this.f11849b = bannerClickGuide;
        this.f11850c = btnNativeCreative;
        this.f11851d = btnNativeCreativeButton;
        this.f11852e = btnNativeCreativeView;
        this.f11853f = descTextView;
        this.f11854g = ivAdsVideo;
        this.f11855h = ivNativeCloseIcon;
        this.f11856i = ivNativeImage;
        this.f11857j = ivNativeLogo;
        this.k = picView;
        this.l = tvAdsLogoDesc;
        this.m = tvAdsLogoView;
        this.n = tvNativeAdDesc;
        this.o = tvNativeAdTitle;
    }

    @NonNull
    public static d5 a(@NonNull View rootView) {
        int i2 = R.id.banner_click_guide;
        TextView textView = (TextView) rootView.findViewById(R.id.banner_click_guide);
        if (textView != null) {
            i2 = R.id.btn_native_creative;
            TextView textView2 = (TextView) rootView.findViewById(R.id.btn_native_creative);
            if (textView2 != null) {
                i2 = R.id.btn_native_creative_button;
                LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.btn_native_creative_button);
                if (linearLayout != null) {
                    i2 = R.id.btn_native_creative_view;
                    RelativeLayout relativeLayout = (RelativeLayout) rootView.findViewById(R.id.btn_native_creative_view);
                    if (relativeLayout != null) {
                        i2 = R.id.desc_text_view;
                        LinearLayout linearLayout2 = (LinearLayout) rootView.findViewById(R.id.desc_text_view);
                        if (linearLayout2 != null) {
                            i2 = R.id.iv_ads_video;
                            FrameLayout frameLayout = (FrameLayout) rootView.findViewById(R.id.iv_ads_video);
                            if (frameLayout != null) {
                                i2 = R.id.iv_native_close_icon;
                                ReaderThemeImageView readerThemeImageView = (ReaderThemeImageView) rootView.findViewById(R.id.iv_native_close_icon);
                                if (readerThemeImageView != null) {
                                    i2 = R.id.iv_native_image;
                                    ImageView imageView = (ImageView) rootView.findViewById(R.id.iv_native_image);
                                    if (imageView != null) {
                                        i2 = R.id.iv_native_logo;
                                        ImageView imageView2 = (ImageView) rootView.findViewById(R.id.iv_native_logo);
                                        if (imageView2 != null) {
                                            i2 = R.id.pic_view;
                                            RoundedLayout roundedLayout = (RoundedLayout) rootView.findViewById(R.id.pic_view);
                                            if (roundedLayout != null) {
                                                i2 = R.id.tv_ads_logo_desc;
                                                TextView textView3 = (TextView) rootView.findViewById(R.id.tv_ads_logo_desc);
                                                if (textView3 != null) {
                                                    i2 = R.id.tv_ads_logo_view;
                                                    LinearLayout linearLayout3 = (LinearLayout) rootView.findViewById(R.id.tv_ads_logo_view);
                                                    if (linearLayout3 != null) {
                                                        i2 = R.id.tv_native_ad_desc;
                                                        ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) rootView.findViewById(R.id.tv_native_ad_desc);
                                                        if (readerThemeTextView != null) {
                                                            i2 = R.id.tv_native_ad_title;
                                                            ReaderThemeTextView readerThemeTextView2 = (ReaderThemeTextView) rootView.findViewById(R.id.tv_native_ad_title);
                                                            if (readerThemeTextView2 != null) {
                                                                return new d5((ReaderThemeLinearLayout) rootView, textView, textView2, linearLayout, relativeLayout, linearLayout2, frameLayout, readerThemeImageView, imageView, imageView2, roundedLayout, textView3, linearLayout3, readerThemeTextView, readerThemeTextView2);
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
    public static d5 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static d5 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.reading_ads_banner, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ReaderThemeLinearLayout getRoot() {
        return this.f11848a;
    }
}
