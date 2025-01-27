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
import com.martian.mibook.ui.reader.ReaderThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class k5 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final View f12255a;

    /* renamed from: b */
    @Nullable
    public final TextView f12256b;

    /* renamed from: c */
    @NonNull
    public final TextView f12257c;

    /* renamed from: d */
    @NonNull
    public final LinearLayout f12258d;

    /* renamed from: e */
    @NonNull
    public final ImageView f12259e;

    /* renamed from: f */
    @Nullable
    public final View f12260f;

    /* renamed from: g */
    @NonNull
    public final FrameLayout f12261g;

    /* renamed from: h */
    @NonNull
    public final ReaderThemeTextView f12262h;

    /* renamed from: i */
    @Nullable
    public final ImageView f12263i;

    /* renamed from: j */
    @NonNull
    public final LinearLayout f12264j;

    @NonNull
    public final ImageView k;

    @NonNull
    public final TextView l;

    @Nullable
    public final LinearLayout m;

    @NonNull
    public final ReaderThemeTextView n;

    private k5(@NonNull View rootView, @Nullable TextView adClickGuide, @NonNull TextView btnNativeCreative, @NonNull LinearLayout btnNativeCreativeView, @NonNull ImageView ivAdsImage, @Nullable View ivAdsImageShake, @NonNull FrameLayout ivAdsVideo, @NonNull ReaderThemeTextView tvAdsDesc, @Nullable ImageView tvAdsIcon, @NonNull LinearLayout tvAdsIconView, @NonNull ImageView tvAdsLogo, @NonNull TextView tvAdsLogoDesc, @Nullable LinearLayout tvAdsShakeView, @NonNull ReaderThemeTextView tvAdsTitle) {
        this.f12255a = rootView;
        this.f12256b = adClickGuide;
        this.f12257c = btnNativeCreative;
        this.f12258d = btnNativeCreativeView;
        this.f12259e = ivAdsImage;
        this.f12260f = ivAdsImageShake;
        this.f12261g = ivAdsVideo;
        this.f12262h = tvAdsDesc;
        this.f12263i = tvAdsIcon;
        this.f12264j = tvAdsIconView;
        this.k = tvAdsLogo;
        this.l = tvAdsLogoDesc;
        this.m = tvAdsShakeView;
        this.n = tvAdsTitle;
    }

    @NonNull
    public static k5 a(@NonNull View rootView) {
        TextView textView = (TextView) rootView.findViewById(R.id.ad_click_guide);
        int i2 = R.id.btn_native_creative;
        TextView textView2 = (TextView) rootView.findViewById(R.id.btn_native_creative);
        if (textView2 != null) {
            i2 = R.id.btn_native_creative_view;
            LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.btn_native_creative_view);
            if (linearLayout != null) {
                i2 = R.id.iv_ads_image;
                ImageView imageView = (ImageView) rootView.findViewById(R.id.iv_ads_image);
                if (imageView != null) {
                    View findViewById = rootView.findViewById(R.id.iv_ads_image_shake);
                    i2 = R.id.iv_ads_video;
                    FrameLayout frameLayout = (FrameLayout) rootView.findViewById(R.id.iv_ads_video);
                    if (frameLayout != null) {
                        i2 = R.id.tv_ads_desc;
                        ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) rootView.findViewById(R.id.tv_ads_desc);
                        if (readerThemeTextView != null) {
                            ImageView imageView2 = (ImageView) rootView.findViewById(R.id.tv_ads_icon);
                            i2 = R.id.tv_ads_icon_view;
                            LinearLayout linearLayout2 = (LinearLayout) rootView.findViewById(R.id.tv_ads_icon_view);
                            if (linearLayout2 != null) {
                                i2 = R.id.tv_ads_logo;
                                ImageView imageView3 = (ImageView) rootView.findViewById(R.id.tv_ads_logo);
                                if (imageView3 != null) {
                                    i2 = R.id.tv_ads_logo_desc;
                                    TextView textView3 = (TextView) rootView.findViewById(R.id.tv_ads_logo_desc);
                                    if (textView3 != null) {
                                        LinearLayout linearLayout3 = (LinearLayout) rootView.findViewById(R.id.tv_ads_shake_view);
                                        i2 = R.id.tv_ads_title;
                                        ReaderThemeTextView readerThemeTextView2 = (ReaderThemeTextView) rootView.findViewById(R.id.tv_ads_title);
                                        if (readerThemeTextView2 != null) {
                                            return new k5(rootView, textView, textView2, linearLayout, imageView, findViewById, frameLayout, readerThemeTextView, imageView2, linearLayout2, imageView3, textView3, linearLayout3, readerThemeTextView2);
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
    public static k5 b(@NonNull LayoutInflater inflater) {
        return c(inflater, null, false);
    }

    @NonNull
    public static k5 c(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.reading_ads_item_large, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f12255a;
    }
}
