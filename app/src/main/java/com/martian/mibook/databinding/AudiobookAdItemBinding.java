package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.mibook.R;
import com.martian.mibook.ui.FlowAdView;

/* loaded from: classes3.dex */
public final class AudiobookAdItemBinding implements ViewBinding {

    @NonNull
    public final ViewStub audiobookAdComplianceInfoView;

    @NonNull
    public final TextView audiobookAdDesc;

    @NonNull
    public final LinearLayout audiobookAdIconView;

    @NonNull
    public final ImageView audiobookAdImage;

    @NonNull
    public final ImageView audiobookAdLogo;

    @NonNull
    public final TextView audiobookAdLogoDesc;

    @NonNull
    public final Button audiobookAdNativeCreative;

    @NonNull
    public final ImageView audiobookAdPoster;

    @NonNull
    public final LinearLayout audiobookAdShakeView;

    @NonNull
    public final TextView audiobookAdTitle;

    @NonNull
    public final FrameLayout audiobookAdVideo;

    @NonNull
    public final FrameLayout audiobookAdView;

    @NonNull
    public final FlowAdView misClickView;

    @NonNull
    private final FrameLayout rootView;

    private AudiobookAdItemBinding(@NonNull FrameLayout frameLayout, @NonNull ViewStub viewStub, @NonNull TextView textView, @NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull TextView textView2, @NonNull Button button, @NonNull ImageView imageView3, @NonNull LinearLayout linearLayout2, @NonNull TextView textView3, @NonNull FrameLayout frameLayout2, @NonNull FrameLayout frameLayout3, @NonNull FlowAdView flowAdView) {
        this.rootView = frameLayout;
        this.audiobookAdComplianceInfoView = viewStub;
        this.audiobookAdDesc = textView;
        this.audiobookAdIconView = linearLayout;
        this.audiobookAdImage = imageView;
        this.audiobookAdLogo = imageView2;
        this.audiobookAdLogoDesc = textView2;
        this.audiobookAdNativeCreative = button;
        this.audiobookAdPoster = imageView3;
        this.audiobookAdShakeView = linearLayout2;
        this.audiobookAdTitle = textView3;
        this.audiobookAdVideo = frameLayout2;
        this.audiobookAdView = frameLayout3;
        this.misClickView = flowAdView;
    }

    @NonNull
    public static AudiobookAdItemBinding bind(@NonNull View view) {
        int i10 = R.id.audiobook_ad_compliance_info_view;
        ViewStub viewStub = (ViewStub) ViewBindings.findChildViewById(view, i10);
        if (viewStub != null) {
            i10 = R.id.audiobook_ad_desc;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
            if (textView != null) {
                i10 = R.id.audiobook_ad_icon_view;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                if (linearLayout != null) {
                    i10 = R.id.audiobook_ad_image;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
                    if (imageView != null) {
                        i10 = R.id.audiobook_ad_logo;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i10);
                        if (imageView2 != null) {
                            i10 = R.id.audiobook_ad_logo_desc;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i10);
                            if (textView2 != null) {
                                i10 = R.id.audiobook_ad_native_creative;
                                Button button = (Button) ViewBindings.findChildViewById(view, i10);
                                if (button != null) {
                                    i10 = R.id.audiobook_ad_poster;
                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i10);
                                    if (imageView3 != null) {
                                        i10 = R.id.audiobook_ad_shake_view;
                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                        if (linearLayout2 != null) {
                                            i10 = R.id.audiobook_ad_title;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i10);
                                            if (textView3 != null) {
                                                i10 = R.id.audiobook_ad_video;
                                                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i10);
                                                if (frameLayout != null) {
                                                    FrameLayout frameLayout2 = (FrameLayout) view;
                                                    i10 = R.id.mis_click_view;
                                                    FlowAdView flowAdView = (FlowAdView) ViewBindings.findChildViewById(view, i10);
                                                    if (flowAdView != null) {
                                                        return new AudiobookAdItemBinding(frameLayout2, viewStub, textView, linearLayout, imageView, imageView2, textView2, button, imageView3, linearLayout2, textView3, frameLayout, frameLayout2, flowAdView);
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
    public static AudiobookAdItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static AudiobookAdItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.audiobook_ad_item, viewGroup, false);
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
