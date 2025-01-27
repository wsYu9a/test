package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.widget.RoundedLayout;
import com.martian.mibook.R;
import com.martian.mibook.ui.FlowAdView;
import com.martian.mibook.ui.reader.ReaderThemeButton;
import com.martian.mibook.ui.reader.ReaderThemeTextView;

/* loaded from: classes3.dex */
public final class ReadingAdsItemFullscreenBinding implements ViewBinding {

    @NonNull
    public final ThemeImageView actionbarDivider;

    @NonNull
    public final TextView adClickGuide;

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
    public final FrameLayout flShakeviewContainer;

    @NonNull
    public final ReaderThemeTextView ivAdsHint;

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
    public final LinearLayout tvAdsIconView;

    @NonNull
    public final ImageView tvAdsLogo;

    @NonNull
    public final ReaderThemeTextView tvAdsLogoDesc;

    @NonNull
    public final ReaderThemeTextView tvAdsPromote;

    @NonNull
    public final LinearLayout tvAdsShakeView;

    @NonNull
    public final RoundedLayout tvAdsTextView;

    @NonNull
    public final ReaderThemeTextView tvAdsTitle;

    private ReadingAdsItemFullscreenBinding(@NonNull FrameLayout frameLayout, @NonNull ThemeImageView themeImageView, @NonNull TextView textView, @NonNull ViewStub viewStub, @NonNull RoundedLayout roundedLayout, @NonNull ReaderThemeButton readerThemeButton, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout, @NonNull FrameLayout frameLayout2, @NonNull ReaderThemeTextView readerThemeTextView, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull FrameLayout frameLayout3, @NonNull FlowAdView flowAdView, @NonNull FrameLayout frameLayout4, @NonNull ReaderThemeTextView readerThemeTextView2, @NonNull ImageView imageView4, @NonNull LinearLayout linearLayout2, @NonNull ImageView imageView5, @NonNull ReaderThemeTextView readerThemeTextView3, @NonNull ReaderThemeTextView readerThemeTextView4, @NonNull LinearLayout linearLayout3, @NonNull RoundedLayout roundedLayout2, @NonNull ReaderThemeTextView readerThemeTextView5) {
        this.rootView = frameLayout;
        this.actionbarDivider = themeImageView;
        this.adClickGuide = textView;
        this.adComplianceInfoView = viewStub;
        this.adsView = roundedLayout;
        this.btnNativeCreative = readerThemeButton;
        this.btnNativeCreativeMore = imageView;
        this.btnNativeCreativeView = linearLayout;
        this.flShakeviewContainer = frameLayout2;
        this.ivAdsHint = readerThemeTextView;
        this.ivAdsImage = imageView2;
        this.ivAdsTag = imageView3;
        this.ivAdsVideo = frameLayout3;
        this.misClickView = flowAdView;
        this.readingAdsFlow = frameLayout4;
        this.tvAdsDesc = readerThemeTextView2;
        this.tvAdsIcon = imageView4;
        this.tvAdsIconView = linearLayout2;
        this.tvAdsLogo = imageView5;
        this.tvAdsLogoDesc = readerThemeTextView3;
        this.tvAdsPromote = readerThemeTextView4;
        this.tvAdsShakeView = linearLayout3;
        this.tvAdsTextView = roundedLayout2;
        this.tvAdsTitle = readerThemeTextView5;
    }

    @NonNull
    public static ReadingAdsItemFullscreenBinding bind(@NonNull View view) {
        int i10 = R.id.actionbar_divider;
        ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
        if (themeImageView != null) {
            i10 = R.id.ad_click_guide;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
            if (textView != null) {
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
                                    i10 = R.id.fl_shakeview_container;
                                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i10);
                                    if (frameLayout != null) {
                                        i10 = R.id.iv_ads_hint;
                                        ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                        if (readerThemeTextView != null) {
                                            i10 = R.id.iv_ads_image;
                                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i10);
                                            if (imageView2 != null) {
                                                i10 = R.id.iv_ads_tag;
                                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i10);
                                                if (imageView3 != null) {
                                                    i10 = R.id.iv_ads_video;
                                                    FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, i10);
                                                    if (frameLayout2 != null) {
                                                        i10 = R.id.mis_click_view;
                                                        FlowAdView flowAdView = (FlowAdView) ViewBindings.findChildViewById(view, i10);
                                                        if (flowAdView != null) {
                                                            FrameLayout frameLayout3 = (FrameLayout) view;
                                                            i10 = R.id.tv_ads_desc;
                                                            ReaderThemeTextView readerThemeTextView2 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                            if (readerThemeTextView2 != null) {
                                                                i10 = R.id.tv_ads_icon;
                                                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i10);
                                                                if (imageView4 != null) {
                                                                    i10 = R.id.tv_ads_icon_view;
                                                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                    if (linearLayout2 != null) {
                                                                        i10 = R.id.tv_ads_logo;
                                                                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i10);
                                                                        if (imageView5 != null) {
                                                                            i10 = R.id.tv_ads_logo_desc;
                                                                            ReaderThemeTextView readerThemeTextView3 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                            if (readerThemeTextView3 != null) {
                                                                                i10 = R.id.tv_ads_promote;
                                                                                ReaderThemeTextView readerThemeTextView4 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                if (readerThemeTextView4 != null) {
                                                                                    i10 = R.id.tv_ads_shake_view;
                                                                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                                    if (linearLayout3 != null) {
                                                                                        i10 = R.id.tv_ads_text_view;
                                                                                        RoundedLayout roundedLayout2 = (RoundedLayout) ViewBindings.findChildViewById(view, i10);
                                                                                        if (roundedLayout2 != null) {
                                                                                            i10 = R.id.tv_ads_title;
                                                                                            ReaderThemeTextView readerThemeTextView5 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                            if (readerThemeTextView5 != null) {
                                                                                                return new ReadingAdsItemFullscreenBinding(frameLayout3, themeImageView, textView, viewStub, roundedLayout, readerThemeButton, imageView, linearLayout, frameLayout, readerThemeTextView, imageView2, imageView3, frameLayout2, flowAdView, frameLayout3, readerThemeTextView2, imageView4, linearLayout2, imageView5, readerThemeTextView3, readerThemeTextView4, linearLayout3, roundedLayout2, readerThemeTextView5);
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
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ReadingAdsItemFullscreenBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ReadingAdsItemFullscreenBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.reading_ads_item_fullscreen, viewGroup, false);
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
