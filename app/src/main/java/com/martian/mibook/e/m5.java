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
import com.martian.mibook.ui.reader.ReaderThemeLinearLayout;
import com.martian.mibook.ui.reader.ReaderThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class m5 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ReaderThemeLinearLayout f12368a;

    /* renamed from: b */
    @NonNull
    public final TextView f12369b;

    /* renamed from: c */
    @NonNull
    public final LinearLayout f12370c;

    /* renamed from: d */
    @NonNull
    public final ImageView f12371d;

    /* renamed from: e */
    @NonNull
    public final FrameLayout f12372e;

    /* renamed from: f */
    @NonNull
    public final ReaderThemeTextView f12373f;

    /* renamed from: g */
    @NonNull
    public final LinearLayout f12374g;

    /* renamed from: h */
    @NonNull
    public final ImageView f12375h;

    /* renamed from: i */
    @NonNull
    public final TextView f12376i;

    /* renamed from: j */
    @NonNull
    public final ReaderThemeTextView f12377j;

    private m5(@NonNull ReaderThemeLinearLayout rootView, @NonNull TextView btnNativeCreative, @NonNull LinearLayout btnNativeCreativeView, @NonNull ImageView ivAdsImage, @NonNull FrameLayout ivAdsVideo, @NonNull ReaderThemeTextView tvAdsDesc, @NonNull LinearLayout tvAdsIconView, @NonNull ImageView tvAdsLogo, @NonNull TextView tvAdsLogoDesc, @NonNull ReaderThemeTextView tvAdsTitle) {
        this.f12368a = rootView;
        this.f12369b = btnNativeCreative;
        this.f12370c = btnNativeCreativeView;
        this.f12371d = ivAdsImage;
        this.f12372e = ivAdsVideo;
        this.f12373f = tvAdsDesc;
        this.f12374g = tvAdsIconView;
        this.f12375h = tvAdsLogo;
        this.f12376i = tvAdsLogoDesc;
        this.f12377j = tvAdsTitle;
    }

    @NonNull
    public static m5 a(@NonNull View rootView) {
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
                    FrameLayout frameLayout = (FrameLayout) rootView.findViewById(R.id.iv_ads_video);
                    if (frameLayout != null) {
                        i2 = R.id.tv_ads_desc;
                        ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) rootView.findViewById(R.id.tv_ads_desc);
                        if (readerThemeTextView != null) {
                            i2 = R.id.tv_ads_icon_view;
                            LinearLayout linearLayout2 = (LinearLayout) rootView.findViewById(R.id.tv_ads_icon_view);
                            if (linearLayout2 != null) {
                                i2 = R.id.tv_ads_logo;
                                ImageView imageView2 = (ImageView) rootView.findViewById(R.id.tv_ads_logo);
                                if (imageView2 != null) {
                                    i2 = R.id.tv_ads_logo_desc;
                                    TextView textView2 = (TextView) rootView.findViewById(R.id.tv_ads_logo_desc);
                                    if (textView2 != null) {
                                        i2 = R.id.tv_ads_title;
                                        ReaderThemeTextView readerThemeTextView2 = (ReaderThemeTextView) rootView.findViewById(R.id.tv_ads_title);
                                        if (readerThemeTextView2 != null) {
                                            return new m5((ReaderThemeLinearLayout) rootView, textView, linearLayout, imageView, frameLayout, readerThemeTextView, linearLayout2, imageView2, textView2, readerThemeTextView2);
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
    public static m5 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static m5 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.reading_ads_item_small, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ReaderThemeLinearLayout getRoot() {
        return this.f12368a;
    }
}
