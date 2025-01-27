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
import com.martian.mibook.ui.reader.ReaderThemeTextView;

/* loaded from: classes3.dex */
public final class AdBannerComplianceInfoViewBinding implements ViewBinding {

    @NonNull
    private final LinearLayout rootView;

    @NonNull
    public final ReaderThemeTextView tvNativeAdFunction;

    @NonNull
    public final ReaderThemeTextView tvNativeAdPermission;

    @NonNull
    public final ReaderThemeTextView tvNativeAdPrivacy;

    @NonNull
    public final LinearLayout tvNativeAdPrivacyView;

    @NonNull
    public final ReaderThemeTextView tvNativeAdVersion;

    private AdBannerComplianceInfoViewBinding(@NonNull LinearLayout linearLayout, @NonNull ReaderThemeTextView readerThemeTextView, @NonNull ReaderThemeTextView readerThemeTextView2, @NonNull ReaderThemeTextView readerThemeTextView3, @NonNull LinearLayout linearLayout2, @NonNull ReaderThemeTextView readerThemeTextView4) {
        this.rootView = linearLayout;
        this.tvNativeAdFunction = readerThemeTextView;
        this.tvNativeAdPermission = readerThemeTextView2;
        this.tvNativeAdPrivacy = readerThemeTextView3;
        this.tvNativeAdPrivacyView = linearLayout2;
        this.tvNativeAdVersion = readerThemeTextView4;
    }

    @NonNull
    public static AdBannerComplianceInfoViewBinding bind(@NonNull View view) {
        int i10 = R.id.tv_native_ad_function;
        ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
        if (readerThemeTextView != null) {
            i10 = R.id.tv_native_ad_permission;
            ReaderThemeTextView readerThemeTextView2 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
            if (readerThemeTextView2 != null) {
                i10 = R.id.tv_native_ad_privacy;
                ReaderThemeTextView readerThemeTextView3 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (readerThemeTextView3 != null) {
                    LinearLayout linearLayout = (LinearLayout) view;
                    i10 = R.id.tv_native_ad_version;
                    ReaderThemeTextView readerThemeTextView4 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                    if (readerThemeTextView4 != null) {
                        return new AdBannerComplianceInfoViewBinding(linearLayout, readerThemeTextView, readerThemeTextView2, readerThemeTextView3, linearLayout, readerThemeTextView4);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static AdBannerComplianceInfoViewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static AdBannerComplianceInfoViewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.ad_banner_compliance_info_view, viewGroup, false);
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
