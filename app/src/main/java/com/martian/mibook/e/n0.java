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
public final class n0 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f12394a;

    /* renamed from: b */
    @NonNull
    public final TextView f12395b;

    /* renamed from: c */
    @NonNull
    public final ImageView f12396c;

    /* renamed from: d */
    @NonNull
    public final TextView f12397d;

    /* renamed from: e */
    @NonNull
    public final TextView f12398e;

    /* renamed from: f */
    @NonNull
    public final FrameLayout f12399f;

    /* renamed from: g */
    @NonNull
    public final ImageView f12400g;

    /* renamed from: h */
    @NonNull
    public final TextView f12401h;

    private n0(@NonNull LinearLayout rootView, @NonNull TextView bonusAdsDesc, @NonNull ImageView bonusAdsImage, @NonNull TextView bonusAdsTitle, @NonNull TextView frOptionButton, @NonNull FrameLayout ivAdsVideo, @NonNull ImageView tvAdsLogo, @NonNull TextView tvAdsLogoDesc) {
        this.f12394a = rootView;
        this.f12395b = bonusAdsDesc;
        this.f12396c = bonusAdsImage;
        this.f12397d = bonusAdsTitle;
        this.f12398e = frOptionButton;
        this.f12399f = ivAdsVideo;
        this.f12400g = tvAdsLogo;
        this.f12401h = tvAdsLogoDesc;
    }

    @NonNull
    public static n0 a(@NonNull View rootView) {
        int i2 = R.id.bonus_ads_desc;
        TextView textView = (TextView) rootView.findViewById(R.id.bonus_ads_desc);
        if (textView != null) {
            i2 = R.id.bonus_ads_image;
            ImageView imageView = (ImageView) rootView.findViewById(R.id.bonus_ads_image);
            if (imageView != null) {
                i2 = R.id.bonus_ads_title;
                TextView textView2 = (TextView) rootView.findViewById(R.id.bonus_ads_title);
                if (textView2 != null) {
                    i2 = R.id.fr_option_button;
                    TextView textView3 = (TextView) rootView.findViewById(R.id.fr_option_button);
                    if (textView3 != null) {
                        i2 = R.id.iv_ads_video;
                        FrameLayout frameLayout = (FrameLayout) rootView.findViewById(R.id.iv_ads_video);
                        if (frameLayout != null) {
                            i2 = R.id.tv_ads_logo;
                            ImageView imageView2 = (ImageView) rootView.findViewById(R.id.tv_ads_logo);
                            if (imageView2 != null) {
                                i2 = R.id.tv_ads_logo_desc;
                                TextView textView4 = (TextView) rootView.findViewById(R.id.tv_ads_logo_desc);
                                if (textView4 != null) {
                                    return new n0((LinearLayout) rootView, textView, imageView, textView2, textView3, frameLayout, imageView2, textView4);
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
    public static n0 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static n0 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.bonus_dialog_ads_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f12394a;
    }
}
