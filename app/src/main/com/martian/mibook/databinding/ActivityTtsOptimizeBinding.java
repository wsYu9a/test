package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class ActivityTtsOptimizeBinding implements ViewBinding {

    @NonNull
    public final ThemeTextView bdReading;

    @NonNull
    public final ConstraintLayout clGuide;

    @NonNull
    public final ThemeLinearLayout downloadGoogleTtsEngine;

    @NonNull
    public final ThemeTextView downloadStatus;

    @NonNull
    public final ThemeImageView ivGoogleTtsMore;

    @NonNull
    public final ImageView ivVip;

    @NonNull
    private final ThemeLinearLayout rootView;

    @NonNull
    public final LinearLayout ttsOptimizeView;

    @NonNull
    public final ImageView tvGuidePicture;

    @NonNull
    public final ThemeTextView tvGuideTitle;

    private ActivityTtsOptimizeBinding(@NonNull ThemeLinearLayout themeLinearLayout, @NonNull ThemeTextView themeTextView, @NonNull ConstraintLayout constraintLayout, @NonNull ThemeLinearLayout themeLinearLayout2, @NonNull ThemeTextView themeTextView2, @NonNull ThemeImageView themeImageView, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout, @NonNull ImageView imageView2, @NonNull ThemeTextView themeTextView3) {
        this.rootView = themeLinearLayout;
        this.bdReading = themeTextView;
        this.clGuide = constraintLayout;
        this.downloadGoogleTtsEngine = themeLinearLayout2;
        this.downloadStatus = themeTextView2;
        this.ivGoogleTtsMore = themeImageView;
        this.ivVip = imageView;
        this.ttsOptimizeView = linearLayout;
        this.tvGuidePicture = imageView2;
        this.tvGuideTitle = themeTextView3;
    }

    @NonNull
    public static ActivityTtsOptimizeBinding bind(@NonNull View view) {
        int i10 = R.id.bd_reading;
        ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
        if (themeTextView != null) {
            i10 = R.id.cl_guide;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i10);
            if (constraintLayout != null) {
                i10 = R.id.download_google_tts_engine;
                ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                if (themeLinearLayout != null) {
                    i10 = R.id.download_status;
                    ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                    if (themeTextView2 != null) {
                        i10 = R.id.iv_google_tts_more;
                        ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                        if (themeImageView != null) {
                            i10 = R.id.iv_vip;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
                            if (imageView != null) {
                                i10 = R.id.tts_optimize_view;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                if (linearLayout != null) {
                                    i10 = R.id.tv_guide_picture;
                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i10);
                                    if (imageView2 != null) {
                                        i10 = R.id.tv_guide_title;
                                        ThemeTextView themeTextView3 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                        if (themeTextView3 != null) {
                                            return new ActivityTtsOptimizeBinding((ThemeLinearLayout) view, themeTextView, constraintLayout, themeLinearLayout, themeTextView2, themeImageView, imageView, linearLayout, imageView2, themeTextView3);
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
    public static ActivityTtsOptimizeBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityTtsOptimizeBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.activity_tts_optimize, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ThemeLinearLayout getRoot() {
        return this.rootView;
    }
}
