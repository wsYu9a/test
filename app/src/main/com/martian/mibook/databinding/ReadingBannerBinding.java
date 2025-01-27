package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.mibook.R;
import com.martian.mibook.ui.BannerAdFrameLayout;

/* loaded from: classes3.dex */
public final class ReadingBannerBinding implements ViewBinding {

    @NonNull
    public final BannerAdFrameLayout readingBanner;

    @NonNull
    public final BannerAdFrameLayout readingBannerJoint;

    @NonNull
    public final LinearLayout readingBannerLayout;

    @NonNull
    private final LinearLayout rootView;

    private ReadingBannerBinding(@NonNull LinearLayout linearLayout, @NonNull BannerAdFrameLayout bannerAdFrameLayout, @NonNull BannerAdFrameLayout bannerAdFrameLayout2, @NonNull LinearLayout linearLayout2) {
        this.rootView = linearLayout;
        this.readingBanner = bannerAdFrameLayout;
        this.readingBannerJoint = bannerAdFrameLayout2;
        this.readingBannerLayout = linearLayout2;
    }

    @NonNull
    public static ReadingBannerBinding bind(@NonNull View view) {
        int i10 = R.id.reading_banner;
        BannerAdFrameLayout bannerAdFrameLayout = (BannerAdFrameLayout) ViewBindings.findChildViewById(view, i10);
        if (bannerAdFrameLayout != null) {
            i10 = R.id.reading_banner_joint;
            BannerAdFrameLayout bannerAdFrameLayout2 = (BannerAdFrameLayout) ViewBindings.findChildViewById(view, i10);
            if (bannerAdFrameLayout2 != null) {
                LinearLayout linearLayout = (LinearLayout) view;
                return new ReadingBannerBinding(linearLayout, bannerAdFrameLayout, bannerAdFrameLayout2, linearLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ReadingBannerBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ReadingBannerBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.reading_banner, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
