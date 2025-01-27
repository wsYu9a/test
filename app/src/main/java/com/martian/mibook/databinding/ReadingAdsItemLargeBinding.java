package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
public final class ReadingAdsItemLargeBinding implements ViewBinding {

    @Nullable
    public final ReaderThemeTextView adClickGuide;

    @NonNull
    public final ViewStub adComplianceInfoView;

    @NonNull
    public final ReaderThemeButton btnNativeCreative;

    @NonNull
    public final LinearLayout btnNativeCreativeView;

    @NonNull
    public final ImageView ivAdsImage;

    @NonNull
    public final FrameLayout ivAdsVideo;

    @Nullable
    public final FlowAdView misClickView;

    @NonNull
    public final FrameLayout readingAdsFlow;

    @NonNull
    private final FrameLayout rootView;

    @Nullable
    public final ViewStub tvAdsCompliance;

    @NonNull
    public final ReaderThemeTextView tvAdsDesc;

    @Nullable
    public final ImageView tvAdsIcon;

    @NonNull
    public final ImageView tvAdsLogo;

    @NonNull
    public final ReaderThemeTextView tvAdsLogoDesc;

    @Nullable
    public final LinearLayout tvAdsShakeView;

    @NonNull
    public final RoundedLayout tvAdsTextView;

    @NonNull
    public final ReaderThemeTextView tvAdsTitle;

    private ReadingAdsItemLargeBinding(@NonNull FrameLayout frameLayout, @Nullable ReaderThemeTextView readerThemeTextView, @NonNull ViewStub viewStub, @NonNull ReaderThemeButton readerThemeButton, @NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull FrameLayout frameLayout2, @Nullable FlowAdView flowAdView, @NonNull FrameLayout frameLayout3, @Nullable ViewStub viewStub2, @NonNull ReaderThemeTextView readerThemeTextView2, @Nullable ImageView imageView2, @NonNull ImageView imageView3, @NonNull ReaderThemeTextView readerThemeTextView3, @Nullable LinearLayout linearLayout2, @NonNull RoundedLayout roundedLayout, @NonNull ReaderThemeTextView readerThemeTextView4) {
        this.rootView = frameLayout;
        this.adClickGuide = readerThemeTextView;
        this.adComplianceInfoView = viewStub;
        this.btnNativeCreative = readerThemeButton;
        this.btnNativeCreativeView = linearLayout;
        this.ivAdsImage = imageView;
        this.ivAdsVideo = frameLayout2;
        this.misClickView = flowAdView;
        this.readingAdsFlow = frameLayout3;
        this.tvAdsCompliance = viewStub2;
        this.tvAdsDesc = readerThemeTextView2;
        this.tvAdsIcon = imageView2;
        this.tvAdsLogo = imageView3;
        this.tvAdsLogoDesc = readerThemeTextView3;
        this.tvAdsShakeView = linearLayout2;
        this.tvAdsTextView = roundedLayout;
        this.tvAdsTitle = readerThemeTextView4;
    }

    @NonNull
    public static ReadingAdsItemLargeBinding bind(@NonNull View view) {
        ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) ViewBindings.findChildViewById(view, R.id.ad_click_guide);
        int i10 = R.id.ad_compliance_info_view;
        ViewStub viewStub = (ViewStub) ViewBindings.findChildViewById(view, i10);
        if (viewStub != null) {
            i10 = R.id.btn_native_creative;
            ReaderThemeButton readerThemeButton = (ReaderThemeButton) ViewBindings.findChildViewById(view, i10);
            if (readerThemeButton != null) {
                i10 = R.id.btn_native_creative_view;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                if (linearLayout != null) {
                    i10 = R.id.iv_ads_image;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
                    if (imageView != null) {
                        i10 = R.id.iv_ads_video;
                        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i10);
                        if (frameLayout != null) {
                            FlowAdView flowAdView = (FlowAdView) ViewBindings.findChildViewById(view, R.id.mis_click_view);
                            FrameLayout frameLayout2 = (FrameLayout) view;
                            ViewStub viewStub2 = (ViewStub) ViewBindings.findChildViewById(view, R.id.tv_ads_compliance);
                            i10 = R.id.tv_ads_desc;
                            ReaderThemeTextView readerThemeTextView2 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                            if (readerThemeTextView2 != null) {
                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.tv_ads_icon);
                                i10 = R.id.tv_ads_logo;
                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i10);
                                if (imageView3 != null) {
                                    i10 = R.id.tv_ads_logo_desc;
                                    ReaderThemeTextView readerThemeTextView3 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                    if (readerThemeTextView3 != null) {
                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.tv_ads_shake_view);
                                        i10 = R.id.tv_ads_text_view;
                                        RoundedLayout roundedLayout = (RoundedLayout) ViewBindings.findChildViewById(view, i10);
                                        if (roundedLayout != null) {
                                            i10 = R.id.tv_ads_title;
                                            ReaderThemeTextView readerThemeTextView4 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                            if (readerThemeTextView4 != null) {
                                                return new ReadingAdsItemLargeBinding(frameLayout2, readerThemeTextView, viewStub, readerThemeButton, linearLayout, imageView, frameLayout, flowAdView, frameLayout2, viewStub2, readerThemeTextView2, imageView2, imageView3, readerThemeTextView3, linearLayout2, roundedLayout, readerThemeTextView4);
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
    public static ReadingAdsItemLargeBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ReadingAdsItemLargeBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.reading_ads_item_large, viewGroup, false);
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
