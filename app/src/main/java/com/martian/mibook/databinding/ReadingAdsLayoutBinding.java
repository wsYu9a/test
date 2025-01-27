package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.mibook.R;
import com.martian.mibook.ui.FlowAdFrameLayout;
import com.martian.mibook.ui.reader.ReaderThemeTextView;

/* loaded from: classes3.dex */
public final class ReadingAdsLayoutBinding implements ViewBinding {

    @NonNull
    public final FlowAdFrameLayout flAdsContainer;

    @NonNull
    public final FrameLayout flAdsContainer2;

    @NonNull
    public final LinearLayout flAdsContainer3;

    @NonNull
    public final FrameLayout flAdsContainerJoint2;

    @NonNull
    public final FrameLayout flAdsContainerJoint3;

    @NonNull
    public final RelativeLayout flAdsContainerLayout;

    @NonNull
    public final LinearLayout flCloseAdsIcon;

    @NonNull
    public final LinearLayout flCloseAdsVideo;

    @NonNull
    public final ReaderThemeTextView flCloseAdsVideoTitle;

    @NonNull
    private final RelativeLayout rootView;

    private ReadingAdsLayoutBinding(@NonNull RelativeLayout relativeLayout, @NonNull FlowAdFrameLayout flowAdFrameLayout, @NonNull FrameLayout frameLayout, @NonNull LinearLayout linearLayout, @NonNull FrameLayout frameLayout2, @NonNull FrameLayout frameLayout3, @NonNull RelativeLayout relativeLayout2, @NonNull LinearLayout linearLayout2, @NonNull LinearLayout linearLayout3, @NonNull ReaderThemeTextView readerThemeTextView) {
        this.rootView = relativeLayout;
        this.flAdsContainer = flowAdFrameLayout;
        this.flAdsContainer2 = frameLayout;
        this.flAdsContainer3 = linearLayout;
        this.flAdsContainerJoint2 = frameLayout2;
        this.flAdsContainerJoint3 = frameLayout3;
        this.flAdsContainerLayout = relativeLayout2;
        this.flCloseAdsIcon = linearLayout2;
        this.flCloseAdsVideo = linearLayout3;
        this.flCloseAdsVideoTitle = readerThemeTextView;
    }

    @NonNull
    public static ReadingAdsLayoutBinding bind(@NonNull View view) {
        int i10 = R.id.fl_ads_container;
        FlowAdFrameLayout flowAdFrameLayout = (FlowAdFrameLayout) ViewBindings.findChildViewById(view, i10);
        if (flowAdFrameLayout != null) {
            i10 = R.id.fl_ads_container_2;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i10);
            if (frameLayout != null) {
                i10 = R.id.fl_ads_container_3;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                if (linearLayout != null) {
                    i10 = R.id.fl_ads_container_joint_2;
                    FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, i10);
                    if (frameLayout2 != null) {
                        i10 = R.id.fl_ads_container_joint_3;
                        FrameLayout frameLayout3 = (FrameLayout) ViewBindings.findChildViewById(view, i10);
                        if (frameLayout3 != null) {
                            i10 = R.id.fl_ads_container_layout;
                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i10);
                            if (relativeLayout != null) {
                                i10 = R.id.fl_close_ads_icon;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                if (linearLayout2 != null) {
                                    i10 = R.id.fl_close_ads_video;
                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                    if (linearLayout3 != null) {
                                        i10 = R.id.fl_close_ads_video_title;
                                        ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                        if (readerThemeTextView != null) {
                                            return new ReadingAdsLayoutBinding((RelativeLayout) view, flowAdFrameLayout, frameLayout, linearLayout, frameLayout2, frameLayout3, relativeLayout, linearLayout2, linearLayout3, readerThemeTextView);
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
    public static ReadingAdsLayoutBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ReadingAdsLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.reading_ads_layout, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
