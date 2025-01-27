package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.widget.RoundedLayout;
import com.martian.mibook.R;
import com.martian.mibook.ui.FlowAdView;
import com.martian.mibook.ui.reader.ReaderThemeButton;
import com.martian.mibook.ui.reader.ReaderThemeImageView;
import com.martian.mibook.ui.reader.ReaderThemeTextView;

/* loaded from: classes3.dex */
public final class ReadingAdsBannerBinding implements ViewBinding {

    @NonNull
    public final ReaderThemeTextView bannerClickGuide;

    @NonNull
    public final ReaderThemeButton btnNativeCreative;

    @NonNull
    public final RelativeLayout btnNativeCreativeView;

    @NonNull
    public final LinearLayout descTextView;

    @NonNull
    public final FrameLayout ivAdsVideo;

    @NonNull
    public final ReaderThemeImageView ivNativeCloseIcon;

    @NonNull
    public final ImageView ivNativeImage;

    @NonNull
    public final ImageView ivNativeLogo;

    @NonNull
    public final FlowAdView misClickView;

    @NonNull
    public final RoundedLayout picView;

    @NonNull
    public final FrameLayout readingAdBanner;

    @NonNull
    private final FrameLayout rootView;

    @NonNull
    public final ReaderThemeTextView tvAdsLogoDesc;

    @NonNull
    public final LinearLayout tvAdsLogoView;

    @NonNull
    public final ViewStub tvNativeAdComplianceView;

    @NonNull
    public final ReaderThemeTextView tvNativeAdDesc;

    @NonNull
    public final ReaderThemeTextView tvNativeAdTitle;

    private ReadingAdsBannerBinding(@NonNull FrameLayout frameLayout, @NonNull ReaderThemeTextView readerThemeTextView, @NonNull ReaderThemeButton readerThemeButton, @NonNull RelativeLayout relativeLayout, @NonNull LinearLayout linearLayout, @NonNull FrameLayout frameLayout2, @NonNull ReaderThemeImageView readerThemeImageView, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull FlowAdView flowAdView, @NonNull RoundedLayout roundedLayout, @NonNull FrameLayout frameLayout3, @NonNull ReaderThemeTextView readerThemeTextView2, @NonNull LinearLayout linearLayout2, @NonNull ViewStub viewStub, @NonNull ReaderThemeTextView readerThemeTextView3, @NonNull ReaderThemeTextView readerThemeTextView4) {
        this.rootView = frameLayout;
        this.bannerClickGuide = readerThemeTextView;
        this.btnNativeCreative = readerThemeButton;
        this.btnNativeCreativeView = relativeLayout;
        this.descTextView = linearLayout;
        this.ivAdsVideo = frameLayout2;
        this.ivNativeCloseIcon = readerThemeImageView;
        this.ivNativeImage = imageView;
        this.ivNativeLogo = imageView2;
        this.misClickView = flowAdView;
        this.picView = roundedLayout;
        this.readingAdBanner = frameLayout3;
        this.tvAdsLogoDesc = readerThemeTextView2;
        this.tvAdsLogoView = linearLayout2;
        this.tvNativeAdComplianceView = viewStub;
        this.tvNativeAdDesc = readerThemeTextView3;
        this.tvNativeAdTitle = readerThemeTextView4;
    }

    @NonNull
    public static ReadingAdsBannerBinding bind(@NonNull View view) {
        int i10 = R.id.banner_click_guide;
        ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
        if (readerThemeTextView != null) {
            i10 = R.id.btn_native_creative;
            ReaderThemeButton readerThemeButton = (ReaderThemeButton) ViewBindings.findChildViewById(view, i10);
            if (readerThemeButton != null) {
                i10 = R.id.btn_native_creative_view;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i10);
                if (relativeLayout != null) {
                    i10 = R.id.desc_text_view;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                    if (linearLayout != null) {
                        i10 = R.id.iv_ads_video;
                        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i10);
                        if (frameLayout != null) {
                            i10 = R.id.iv_native_close_icon;
                            ReaderThemeImageView readerThemeImageView = (ReaderThemeImageView) ViewBindings.findChildViewById(view, i10);
                            if (readerThemeImageView != null) {
                                i10 = R.id.iv_native_image;
                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
                                if (imageView != null) {
                                    i10 = R.id.iv_native_logo;
                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i10);
                                    if (imageView2 != null) {
                                        i10 = R.id.mis_click_view;
                                        FlowAdView flowAdView = (FlowAdView) ViewBindings.findChildViewById(view, i10);
                                        if (flowAdView != null) {
                                            i10 = R.id.pic_view;
                                            RoundedLayout roundedLayout = (RoundedLayout) ViewBindings.findChildViewById(view, i10);
                                            if (roundedLayout != null) {
                                                FrameLayout frameLayout2 = (FrameLayout) view;
                                                i10 = R.id.tv_ads_logo_desc;
                                                ReaderThemeTextView readerThemeTextView2 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                if (readerThemeTextView2 != null) {
                                                    i10 = R.id.tv_ads_logo_view;
                                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                                    if (linearLayout2 != null) {
                                                        i10 = R.id.tv_native_ad_compliance_view;
                                                        ViewStub viewStub = (ViewStub) ViewBindings.findChildViewById(view, i10);
                                                        if (viewStub != null) {
                                                            i10 = R.id.tv_native_ad_desc;
                                                            ReaderThemeTextView readerThemeTextView3 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                            if (readerThemeTextView3 != null) {
                                                                i10 = R.id.tv_native_ad_title;
                                                                ReaderThemeTextView readerThemeTextView4 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                if (readerThemeTextView4 != null) {
                                                                    return new ReadingAdsBannerBinding(frameLayout2, readerThemeTextView, readerThemeButton, relativeLayout, linearLayout, frameLayout, readerThemeImageView, imageView, imageView2, flowAdView, roundedLayout, frameLayout2, readerThemeTextView2, linearLayout2, viewStub, readerThemeTextView3, readerThemeTextView4);
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
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ReadingAdsBannerBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ReadingAdsBannerBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.reading_ads_banner, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public FrameLayout getRoot() {
        return this.rootView;
    }
}
