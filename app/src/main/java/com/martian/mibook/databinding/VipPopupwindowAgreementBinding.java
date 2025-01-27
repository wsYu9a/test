package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class VipPopupwindowAgreementBinding implements ViewBinding {

    @NonNull
    public final ThemeTextView privacyAgree;

    @NonNull
    public final TextView privacyDesc;

    @NonNull
    public final ThemeTextView privacyKnown;

    @NonNull
    public final ScrollView privacyScrollView;

    @NonNull
    public final TextView privacyTitle;

    @NonNull
    private final RelativeLayout rootView;

    private VipPopupwindowAgreementBinding(@NonNull RelativeLayout relativeLayout, @NonNull ThemeTextView themeTextView, @NonNull TextView textView, @NonNull ThemeTextView themeTextView2, @NonNull ScrollView scrollView, @NonNull TextView textView2) {
        this.rootView = relativeLayout;
        this.privacyAgree = themeTextView;
        this.privacyDesc = textView;
        this.privacyKnown = themeTextView2;
        this.privacyScrollView = scrollView;
        this.privacyTitle = textView2;
    }

    @NonNull
    public static VipPopupwindowAgreementBinding bind(@NonNull View view) {
        int i10 = R.id.privacy_agree;
        ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
        if (themeTextView != null) {
            i10 = R.id.privacy_desc;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
            if (textView != null) {
                i10 = R.id.privacy_known;
                ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (themeTextView2 != null) {
                    i10 = R.id.privacy_scroll_view;
                    ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, i10);
                    if (scrollView != null) {
                        i10 = R.id.privacy_title;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i10);
                        if (textView2 != null) {
                            return new VipPopupwindowAgreementBinding((RelativeLayout) view, themeTextView, textView, themeTextView2, scrollView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static VipPopupwindowAgreementBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static VipPopupwindowAgreementBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.vip_popupwindow_agreement, viewGroup, false);
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
