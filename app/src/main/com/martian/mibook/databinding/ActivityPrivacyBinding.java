package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class ActivityPrivacyBinding implements ViewBinding {

    @NonNull
    public final ThemeLinearLayout appAuthority;

    @NonNull
    public final ThemeLinearLayout personalInfoLink;

    @NonNull
    public final ThemeLinearLayout privacyLink;

    @NonNull
    public final ThemeLinearLayout privacySetting;

    @NonNull
    private final ThemeLinearLayout rootView;

    @NonNull
    public final ThemeLinearLayout shareLink;

    private ActivityPrivacyBinding(@NonNull ThemeLinearLayout themeLinearLayout, @NonNull ThemeLinearLayout themeLinearLayout2, @NonNull ThemeLinearLayout themeLinearLayout3, @NonNull ThemeLinearLayout themeLinearLayout4, @NonNull ThemeLinearLayout themeLinearLayout5, @NonNull ThemeLinearLayout themeLinearLayout6) {
        this.rootView = themeLinearLayout;
        this.appAuthority = themeLinearLayout2;
        this.personalInfoLink = themeLinearLayout3;
        this.privacyLink = themeLinearLayout4;
        this.privacySetting = themeLinearLayout5;
        this.shareLink = themeLinearLayout6;
    }

    @NonNull
    public static ActivityPrivacyBinding bind(@NonNull View view) {
        int i10 = R.id.app_authority;
        ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
        if (themeLinearLayout != null) {
            i10 = R.id.personal_info_link;
            ThemeLinearLayout themeLinearLayout2 = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
            if (themeLinearLayout2 != null) {
                i10 = R.id.privacy_link;
                ThemeLinearLayout themeLinearLayout3 = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                if (themeLinearLayout3 != null) {
                    i10 = R.id.privacy_setting;
                    ThemeLinearLayout themeLinearLayout4 = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                    if (themeLinearLayout4 != null) {
                        i10 = R.id.share_link;
                        ThemeLinearLayout themeLinearLayout5 = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                        if (themeLinearLayout5 != null) {
                            return new ActivityPrivacyBinding((ThemeLinearLayout) view, themeLinearLayout, themeLinearLayout2, themeLinearLayout3, themeLinearLayout4, themeLinearLayout5);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ActivityPrivacyBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityPrivacyBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.activity_privacy, viewGroup, false);
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
