package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.MiSwitchButton;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class o implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeLinearLayout f12445a;

    /* renamed from: b */
    @NonNull
    public final ThemeTextView f12446b;

    /* renamed from: c */
    @NonNull
    public final ThemeLinearLayout f12447c;

    /* renamed from: d */
    @NonNull
    public final ThemeLinearLayout f12448d;

    /* renamed from: e */
    @NonNull
    public final MiSwitchButton f12449e;

    /* renamed from: f */
    @NonNull
    public final MiSwitchButton f12450f;

    /* renamed from: g */
    @NonNull
    public final ThemeTextView f12451g;

    private o(@NonNull ThemeLinearLayout rootView, @NonNull ThemeTextView phoneStateStatus, @NonNull ThemeLinearLayout privacySetting, @NonNull ThemeLinearLayout privacySettingCancel, @NonNull MiSwitchButton sendAdInfo, @NonNull MiSwitchButton sendBookInfo, @NonNull ThemeTextView storageStatus) {
        this.f12445a = rootView;
        this.f12446b = phoneStateStatus;
        this.f12447c = privacySetting;
        this.f12448d = privacySettingCancel;
        this.f12449e = sendAdInfo;
        this.f12450f = sendBookInfo;
        this.f12451g = storageStatus;
    }

    @NonNull
    public static o a(@NonNull View rootView) {
        int i2 = R.id.phone_state_status;
        ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.phone_state_status);
        if (themeTextView != null) {
            i2 = R.id.privacy_setting;
            ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) rootView.findViewById(R.id.privacy_setting);
            if (themeLinearLayout != null) {
                i2 = R.id.privacy_setting_cancel;
                ThemeLinearLayout themeLinearLayout2 = (ThemeLinearLayout) rootView.findViewById(R.id.privacy_setting_cancel);
                if (themeLinearLayout2 != null) {
                    i2 = R.id.send_ad_info;
                    MiSwitchButton miSwitchButton = (MiSwitchButton) rootView.findViewById(R.id.send_ad_info);
                    if (miSwitchButton != null) {
                        i2 = R.id.send_book_info;
                        MiSwitchButton miSwitchButton2 = (MiSwitchButton) rootView.findViewById(R.id.send_book_info);
                        if (miSwitchButton2 != null) {
                            i2 = R.id.storage_status;
                            ThemeTextView themeTextView2 = (ThemeTextView) rootView.findViewById(R.id.storage_status);
                            if (themeTextView2 != null) {
                                return new o((ThemeLinearLayout) rootView, themeTextView, themeLinearLayout, themeLinearLayout2, miSwitchButton, miSwitchButton2, themeTextView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static o c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static o d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.activity_privacy_setting, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeLinearLayout getRoot() {
        return this.f12445a;
    }
}
