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
import com.martian.mibook.ui.reader.ReaderThemeTextView;

/* loaded from: classes3.dex */
public final class ReadingAdsItemFullscreenPortraitBinding implements ViewBinding {

    @NonNull
    public final ReaderThemeTextView adClickGuide;

    @NonNull
    public final ViewStub adComplianceInfoView;

    @NonNull
    public final RoundedLayout adsView;

    @NonNull
    public final ReaderThemeButton btnNativeCreative;

    @NonNull
    public final ImageView btnNativeCreativeMore;

    @NonNull
    public final LinearLayout btnNativeCreativeView;

    @NonNull
    public final ImageView ivAdsImage;

    @NonNull
    public final ImageView ivAdsTag;

    @NonNull
    public final FrameLayout ivAdsVideo;

    @NonNull
    public final FlowAdView misClickView;

    @NonNull
    public final FrameLayout readingAdsFlow;

    @NonNull
    private final FrameLayout rootView;

    @NonNull
    public final ReaderThemeTextView tvAdsDesc;

    @NonNull
    public final ImageView tvAdsIcon;

    @NonNull
    public final ImageView tvAdsLogo;

    @NonNull
    public final ReaderThemeTextView tvAdsLogoDesc;

    @NonNull
    public final LinearLayout tvAdsLogoView;

    @NonNull
    public final ReaderThemeTextView tvAdsPromote;

    @NonNull
    public final LinearLayout tvAdsShakeView;

    @NonNull
    public final RelativeLayout tvAdsTextView;

    @NonNull
    public final ReaderThemeTextView tvAdsTitle;

    private ReadingAdsItemFullscreenPortraitBinding(@NonNull FrameLayout frameLayout, @NonNull ReaderThemeTextView readerThemeTextView, @NonNull ViewStub viewStub, @NonNull RoundedLayout roundedLayout, @NonNull ReaderThemeButton readerThemeButton, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull FrameLayout frameLayout2, @NonNull FlowAdView flowAdView, @NonNull FrameLayout frameLayout3, @NonNull ReaderThemeTextView readerThemeTextView2, @NonNull ImageView imageView4, @NonNull ImageView imageView5, @NonNull ReaderThemeTextView readerThemeTextView3, @NonNull LinearLayout linearLayout2, @NonNull ReaderThemeTextView readerThemeTextView4, @NonNull LinearLayout linearLayout3, @NonNull RelativeLayout relativeLayout, @NonNull ReaderThemeTextView readerThemeTextView5) {
        this.rootView = frameLayout;
        this.adClickGuide = readerThemeTextView;
        this.adComplianceInfoView = viewStub;
        this.adsView = roundedLayout;
        this.btnNativeCreative = readerThemeButton;
        this.btnNativeCreativeMore = imageView;
        this.btnNativeCreativeView = linearLayout;
        this.ivAdsImage = imageView2;
        this.ivAdsTag = imageView3;
        this.ivAdsVideo = frameLayout2;
        this.misClickView = flowAdView;
        this.readingAdsFlow = frameLayout3;
        this.tvAdsDesc = readerThemeTextView2;
        this.tvAdsIcon = imageView4;
        this.tvAdsLogo = imageView5;
        this.tvAdsLogoDesc = readerThemeTextView3;
        this.tvAdsLogoView = linearLayout2;
        this.tvAdsPromote = readerThemeTextView4;
        this.tvAdsShakeView = linearLayout3;
        this.tvAdsTextView = relativeLayout;
        this.tvAdsTitle = readerThemeTextView5;
    }

    @NonNull
    public static ReadingAdsItemFullscreenPortraitBinding bind(@NonNull View view) {
        int i10 = R.id.ad_click_guide;
        ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
        if (readerThemeTextView != null) {
            i10 = R.id.ad_compliance_info_view;
            ViewStub viewStub = (ViewStub) ViewBindings.findChildViewById(view, i10);
            if (viewStub != null) {
                i10 = R.id.ads_view;
                RoundedLayout roundedLayout = (RoundedLayout) ViewBindings.findChildViewById(view, i10);
                if (roundedLayout != null) {
                    i10 = R.id.btn_native_creative;
                    ReaderThemeButton readerThemeButton = (ReaderThemeButton) ViewBindings.findChildViewById(view, i10);
                    if (readerThemeButton != null) {
                        i10 = R.id.btn_native_creative_more;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
                        if (imageView != null) {
                            i10 = R.id.btn_native_creative_view;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                            if (linearLayout != null) {
                                i10 = R.id.iv_ads_image;
                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i10);
                                if (imageView2 != null) {
                                    i10 = R.id.iv_ads_tag;
                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i10);
                                    if (imageView3 != null) {
                                        i10 = R.id.iv_ads_video;
                                        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i10);
                                        if (frameLayout != null) {
                                            i10 = R.id.mis_click_view;
                                            FlowAdView flowAdView = (FlowAdView) ViewBindings.findChildViewById(view, i10);
                                            if (flowAdView != null) {
                                                FrameLayout frameLayout2 = (FrameLayout) view;
                                                i10 = R.id.tv_ads_desc;
                                                ReaderThemeTextView readerThemeTextView2 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                if (readerThemeTextView2 != null) {
                                                    i10 = R.id.tv_ads_icon;
                                                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i10);
                                                    if (imageView4 != null) {
                                                        i10 = R.id.tv_ads_logo;
                                                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i10);
                                                        if (imageView5 != null) {
                                                            i10 = R.id.tv_ads_logo_desc;
                                                            ReaderThemeTextView readerThemeTextView3 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                            if (readerThemeTextView3 != null) {
                                                                i10 = R.id.tv_ads_logo_view;
                                                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                if (linearLayout2 != null) {
                                                                    i10 = R.id.tv_ads_promote;
                                                                    ReaderThemeTextView readerThemeTextView4 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                    if (readerThemeTextView4 != null) {
                                                                        i10 = R.id.tv_ads_shake_view;
                                                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                        if (linearLayout3 != null) {
                                                                            i10 = R.id.tv_ads_text_view;
                                                                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i10);
                                                                            if (relativeLayout != null) {
                                                                                i10 = R.id.tv_ads_title;
                                                                                ReaderThemeTextView readerThemeTextView5 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                if (readerThemeTextView5 != null) {
                                                                                    return new ReadingAdsItemFullscreenPortraitBinding(frameLayout2, readerThemeTextView, viewStub, roundedLayout, readerThemeButton, imageView, linearLayout, imageView2, imageView3, frameLayout, flowAdView, frameLayout2, readerThemeTextView2, imageView4, imageView5, readerThemeTextView3, linearLayout2, readerThemeTextView4, linearLayout3, relativeLayout, readerThemeTextView5);
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
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ReadingAdsItemFullscreenPortraitBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ReadingAdsItemFullscreenPortraitBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.reading_ads_item_fullscreen_portrait, viewGroup, false);
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
