package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.widget.RoundedLayout;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class l5 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final RelativeLayout f12302a;

    /* renamed from: b */
    @NonNull
    public final TextView f12303b;

    /* renamed from: c */
    @NonNull
    public final LinearLayout f12304c;

    /* renamed from: d */
    @NonNull
    public final ImageView f12305d;

    /* renamed from: e */
    @NonNull
    public final RoundedLayout f12306e;

    /* renamed from: f */
    @NonNull
    public final TextView f12307f;

    /* renamed from: g */
    @NonNull
    public final ImageView f12308g;

    /* renamed from: h */
    @NonNull
    public final TextView f12309h;

    /* renamed from: i */
    @NonNull
    public final LinearLayout f12310i;

    /* renamed from: j */
    @NonNull
    public final TextView f12311j;

    private l5(@NonNull RelativeLayout rootView, @NonNull TextView btnNativeCreative, @NonNull LinearLayout btnNativeCreativeView, @NonNull ImageView ivAdsImage, @NonNull RoundedLayout ivAdsVideo, @NonNull TextView tvAdsDesc, @NonNull ImageView tvAdsLogo, @NonNull TextView tvAdsLogoDesc, @NonNull LinearLayout tvAdsShakeView, @NonNull TextView tvAdsTitle) {
        this.f12302a = rootView;
        this.f12303b = btnNativeCreative;
        this.f12304c = btnNativeCreativeView;
        this.f12305d = ivAdsImage;
        this.f12306e = ivAdsVideo;
        this.f12307f = tvAdsDesc;
        this.f12308g = tvAdsLogo;
        this.f12309h = tvAdsLogoDesc;
        this.f12310i = tvAdsShakeView;
        this.f12311j = tvAdsTitle;
    }

    @NonNull
    public static l5 a(@NonNull View rootView) {
        int i2 = R.id.btn_native_creative;
        TextView textView = (TextView) rootView.findViewById(R.id.btn_native_creative);
        if (textView != null) {
            i2 = R.id.btn_native_creative_view;
            LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.btn_native_creative_view);
            if (linearLayout != null) {
                i2 = R.id.iv_ads_image;
                ImageView imageView = (ImageView) rootView.findViewById(R.id.iv_ads_image);
                if (imageView != null) {
                    i2 = R.id.iv_ads_video;
                    RoundedLayout roundedLayout = (RoundedLayout) rootView.findViewById(R.id.iv_ads_video);
                    if (roundedLayout != null) {
                        i2 = R.id.tv_ads_desc;
                        TextView textView2 = (TextView) rootView.findViewById(R.id.tv_ads_desc);
                        if (textView2 != null) {
                            i2 = R.id.tv_ads_logo;
                            ImageView imageView2 = (ImageView) rootView.findViewById(R.id.tv_ads_logo);
                            if (imageView2 != null) {
                                i2 = R.id.tv_ads_logo_desc;
                                TextView textView3 = (TextView) rootView.findViewById(R.id.tv_ads_logo_desc);
                                if (textView3 != null) {
                                    i2 = R.id.tv_ads_shake_view;
                                    LinearLayout linearLayout2 = (LinearLayout) rootView.findViewById(R.id.tv_ads_shake_view);
                                    if (linearLayout2 != null) {
                                        i2 = R.id.tv_ads_title;
                                        TextView textView4 = (TextView) rootView.findViewById(R.id.tv_ads_title);
                                        if (textView4 != null) {
                                            return new l5((RelativeLayout) rootView, textView, linearLayout, imageView, roundedLayout, textView2, imageView2, textView3, linearLayout2, textView4);
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
    public static l5 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static l5 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.reading_ads_item_middle, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f12302a;
    }
}
