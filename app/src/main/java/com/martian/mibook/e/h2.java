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
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class h2 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f12048a;

    /* renamed from: b */
    @NonNull
    public final TextView f12049b;

    /* renamed from: c */
    @NonNull
    public final TextView f12050c;

    /* renamed from: d */
    @NonNull
    public final LinearLayout f12051d;

    /* renamed from: e */
    @NonNull
    public final ImageView f12052e;

    /* renamed from: f */
    @NonNull
    public final ImageView f12053f;

    /* renamed from: g */
    @NonNull
    public final TextView f12054g;

    /* renamed from: h */
    @NonNull
    public final FrameLayout f12055h;

    /* renamed from: i */
    @NonNull
    public final ImageView f12056i;

    /* renamed from: j */
    @NonNull
    public final TextView f12057j;

    private h2(@NonNull LinearLayout rootView, @NonNull TextView bonusAdsButton, @NonNull TextView bonusAdsDesc, @NonNull LinearLayout bonusAdsDetailView, @NonNull ImageView bonusAdsIcon, @NonNull ImageView bonusAdsImage, @NonNull TextView bonusAdsTitle, @NonNull FrameLayout ivAdsVideo, @NonNull ImageView tvAdsLogo, @NonNull TextView tvAdsLogoDesc) {
        this.f12048a = rootView;
        this.f12049b = bonusAdsButton;
        this.f12050c = bonusAdsDesc;
        this.f12051d = bonusAdsDetailView;
        this.f12052e = bonusAdsIcon;
        this.f12053f = bonusAdsImage;
        this.f12054g = bonusAdsTitle;
        this.f12055h = ivAdsVideo;
        this.f12056i = tvAdsLogo;
        this.f12057j = tvAdsLogoDesc;
    }

    @NonNull
    public static h2 a(@NonNull View rootView) {
        int i2 = R.id.bonus_ads_button;
        TextView textView = (TextView) rootView.findViewById(R.id.bonus_ads_button);
        if (textView != null) {
            i2 = R.id.bonus_ads_desc;
            TextView textView2 = (TextView) rootView.findViewById(R.id.bonus_ads_desc);
            if (textView2 != null) {
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
                            TextView textView3 = (TextView) rootView.findViewById(R.id.bonus_ads_title);
                            if (textView3 != null) {
                                i2 = R.id.iv_ads_video;
                                FrameLayout frameLayout = (FrameLayout) rootView.findViewById(R.id.iv_ads_video);
                                if (frameLayout != null) {
                                    i2 = R.id.tv_ads_logo;
                                    ImageView imageView3 = (ImageView) rootView.findViewById(R.id.tv_ads_logo);
                                    if (imageView3 != null) {
                                        i2 = R.id.tv_ads_logo_desc;
                                        TextView textView4 = (TextView) rootView.findViewById(R.id.tv_ads_logo_desc);
                                        if (textView4 != null) {
                                            return new h2((LinearLayout) rootView, textView, textView2, linearLayout, imageView, imageView2, textView3, frameLayout, imageView3, textView4);
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
    public static h2 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static h2 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.dialog_ads_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f12048a;
    }
}
