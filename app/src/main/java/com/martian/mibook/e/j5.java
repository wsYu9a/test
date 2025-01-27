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
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class j5 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final RelativeLayout f12188a;

    /* renamed from: b */
    @NonNull
    public final TextView f12189b;

    /* renamed from: c */
    @NonNull
    public final TextView f12190c;

    /* renamed from: d */
    @NonNull
    public final LinearLayout f12191d;

    /* renamed from: e */
    @NonNull
    public final ImageView f12192e;

    /* renamed from: f */
    @NonNull
    public final ImageView f12193f;

    /* renamed from: g */
    @NonNull
    public final FrameLayout f12194g;

    /* renamed from: h */
    @NonNull
    public final TextView f12195h;

    /* renamed from: i */
    @NonNull
    public final ImageView f12196i;

    /* renamed from: j */
    @NonNull
    public final ImageView f12197j;

    @NonNull
    public final TextView k;

    @NonNull
    public final TextView l;

    @NonNull
    public final LinearLayout m;

    @NonNull
    public final TextView n;

    private j5(@NonNull RelativeLayout rootView, @NonNull TextView adClickGuide, @NonNull TextView btnNativeCreative, @NonNull LinearLayout btnNativeCreativeView, @NonNull ImageView ivAdsImage, @NonNull ImageView ivAdsTag, @NonNull FrameLayout ivAdsVideo, @NonNull TextView tvAdsDesc, @NonNull ImageView tvAdsIcon, @NonNull ImageView tvAdsLogo, @NonNull TextView tvAdsLogoDesc, @NonNull TextView tvAdsPromote, @NonNull LinearLayout tvAdsShakeView, @NonNull TextView tvAdsTitle) {
        this.f12188a = rootView;
        this.f12189b = adClickGuide;
        this.f12190c = btnNativeCreative;
        this.f12191d = btnNativeCreativeView;
        this.f12192e = ivAdsImage;
        this.f12193f = ivAdsTag;
        this.f12194g = ivAdsVideo;
        this.f12195h = tvAdsDesc;
        this.f12196i = tvAdsIcon;
        this.f12197j = tvAdsLogo;
        this.k = tvAdsLogoDesc;
        this.l = tvAdsPromote;
        this.m = tvAdsShakeView;
        this.n = tvAdsTitle;
    }

    @NonNull
    public static j5 a(@NonNull View rootView) {
        int i2 = R.id.ad_click_guide;
        TextView textView = (TextView) rootView.findViewById(R.id.ad_click_guide);
        if (textView != null) {
            i2 = R.id.btn_native_creative;
            TextView textView2 = (TextView) rootView.findViewById(R.id.btn_native_creative);
            if (textView2 != null) {
                i2 = R.id.btn_native_creative_view;
                LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.btn_native_creative_view);
                if (linearLayout != null) {
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
                                TextView textView3 = (TextView) rootView.findViewById(R.id.tv_ads_desc);
                                if (textView3 != null) {
                                    i2 = R.id.tv_ads_icon;
                                    ImageView imageView3 = (ImageView) rootView.findViewById(R.id.tv_ads_icon);
                                    if (imageView3 != null) {
                                        i2 = R.id.tv_ads_logo;
                                        ImageView imageView4 = (ImageView) rootView.findViewById(R.id.tv_ads_logo);
                                        if (imageView4 != null) {
                                            i2 = R.id.tv_ads_logo_desc;
                                            TextView textView4 = (TextView) rootView.findViewById(R.id.tv_ads_logo_desc);
                                            if (textView4 != null) {
                                                i2 = R.id.tv_ads_promote;
                                                TextView textView5 = (TextView) rootView.findViewById(R.id.tv_ads_promote);
                                                if (textView5 != null) {
                                                    i2 = R.id.tv_ads_shake_view;
                                                    LinearLayout linearLayout2 = (LinearLayout) rootView.findViewById(R.id.tv_ads_shake_view);
                                                    if (linearLayout2 != null) {
                                                        i2 = R.id.tv_ads_title;
                                                        TextView textView6 = (TextView) rootView.findViewById(R.id.tv_ads_title);
                                                        if (textView6 != null) {
                                                            return new j5((RelativeLayout) rootView, textView, textView2, linearLayout, imageView, imageView2, frameLayout, textView3, imageView3, imageView4, textView4, textView5, linearLayout2, textView6);
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
    public static j5 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static j5 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.reading_ads_item_fullscreen_portrait, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f12188a;
    }
}
