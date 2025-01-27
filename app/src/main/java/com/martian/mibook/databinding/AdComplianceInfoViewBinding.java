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
public final class AdComplianceInfoViewBinding implements ViewBinding {

    @NonNull
    public final ReaderThemeTextView adComplianceCompany;

    @NonNull
    public final ReaderThemeTextView adComplianceFunction;

    @NonNull
    public final ReaderThemeTextView adCompliancePermission;

    @NonNull
    public final ReaderThemeTextView adCompliancePrivacy;

    @NonNull
    public final ReaderThemeTextView adComplianceVersion;

    @NonNull
    public final LinearLayout adComplianceView;

    @NonNull
    private final LinearLayout rootView;

    private AdComplianceInfoViewBinding(@NonNull LinearLayout linearLayout, @NonNull ReaderThemeTextView readerThemeTextView, @NonNull ReaderThemeTextView readerThemeTextView2, @NonNull ReaderThemeTextView readerThemeTextView3, @NonNull ReaderThemeTextView readerThemeTextView4, @NonNull ReaderThemeTextView readerThemeTextView5, @NonNull LinearLayout linearLayout2) {
        this.rootView = linearLayout;
        this.adComplianceCompany = readerThemeTextView;
        this.adComplianceFunction = readerThemeTextView2;
        this.adCompliancePermission = readerThemeTextView3;
        this.adCompliancePrivacy = readerThemeTextView4;
        this.adComplianceVersion = readerThemeTextView5;
        this.adComplianceView = linearLayout2;
    }

    @NonNull
    public static AdComplianceInfoViewBinding bind(@NonNull View view) {
        int i10 = R.id.ad_compliance_company;
        ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
        if (readerThemeTextView != null) {
            i10 = R.id.ad_compliance_function;
            ReaderThemeTextView readerThemeTextView2 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
            if (readerThemeTextView2 != null) {
                i10 = R.id.ad_compliance_permission;
                ReaderThemeTextView readerThemeTextView3 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (readerThemeTextView3 != null) {
                    i10 = R.id.ad_compliance_privacy;
                    ReaderThemeTextView readerThemeTextView4 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                    if (readerThemeTextView4 != null) {
                        i10 = R.id.ad_compliance_version;
                        ReaderThemeTextView readerThemeTextView5 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                        if (readerThemeTextView5 != null) {
                            LinearLayout linearLayout = (LinearLayout) view;
                            return new AdComplianceInfoViewBinding(linearLayout, readerThemeTextView, readerThemeTextView2, readerThemeTextView3, readerThemeTextView4, readerThemeTextView5, linearLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static AdComplianceInfoViewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static AdComplianceInfoViewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.ad_compliance_info_view, viewGroup, false);
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
