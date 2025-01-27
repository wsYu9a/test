package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.MiSwitchButton;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class ActivityPrivacySettingBinding implements ViewBinding {

    @NonNull
    public final ThemeTextView phoneStateStatus;

    @NonNull
    public final ThemeLinearLayout privacySetting;

    @NonNull
    public final ThemeLinearLayout privacySettingCancel;

    @NonNull
    private final ThemeLinearLayout rootView;

    @NonNull
    public final MiSwitchButton sendAdInfo;

    @NonNull
    public final MiSwitchButton sendBookInfo;

    @NonNull
    public final ThemeTextView storageStatus;

    private ActivityPrivacySettingBinding(@NonNull ThemeLinearLayout themeLinearLayout, @NonNull ThemeTextView themeTextView, @NonNull ThemeLinearLayout themeLinearLayout2, @NonNull ThemeLinearLayout themeLinearLayout3, @NonNull MiSwitchButton miSwitchButton, @NonNull MiSwitchButton miSwitchButton2, @NonNull ThemeTextView themeTextView2) {
        this.rootView = themeLinearLayout;
        this.phoneStateStatus = themeTextView;
        this.privacySetting = themeLinearLayout2;
        this.privacySettingCancel = themeLinearLayout3;
        this.sendAdInfo = miSwitchButton;
        this.sendBookInfo = miSwitchButton2;
        this.storageStatus = themeTextView2;
    }

    @NonNull
    public static ActivityPrivacySettingBinding bind(@NonNull View view) {
        int i10 = R.id.phone_state_status;
        ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
        if (themeTextView != null) {
            i10 = R.id.privacy_setting;
            ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
            if (themeLinearLayout != null) {
                i10 = R.id.privacy_setting_cancel;
                ThemeLinearLayout themeLinearLayout2 = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                if (themeLinearLayout2 != null) {
                    i10 = R.id.send_ad_info;
                    MiSwitchButton miSwitchButton = (MiSwitchButton) ViewBindings.findChildViewById(view, i10);
                    if (miSwitchButton != null) {
                        i10 = R.id.send_book_info;
                        MiSwitchButton miSwitchButton2 = (MiSwitchButton) ViewBindings.findChildViewById(view, i10);
                        if (miSwitchButton2 != null) {
                            i10 = R.id.storage_status;
                            ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                            if (themeTextView2 != null) {
                                return new ActivityPrivacySettingBinding((ThemeLinearLayout) view, themeTextView, themeLinearLayout, themeLinearLayout2, miSwitchButton, miSwitchButton2, themeTextView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ActivityPrivacySettingBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityPrivacySettingBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.activity_privacy_setting, viewGroup, false);
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
