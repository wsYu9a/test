package com.martian.mibook.lib.account.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.MiSwitchButton;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.lib.account.R;

/* loaded from: classes3.dex */
public final class c implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeLinearLayout f13831a;

    /* renamed from: b */
    @NonNull
    public final MiSwitchButton f13832b;

    /* renamed from: c */
    @NonNull
    public final ThemeTextView f13833c;

    private c(@NonNull ThemeLinearLayout rootView, @NonNull MiSwitchButton baseFunction, @NonNull ThemeTextView privacyDesc1) {
        this.f13831a = rootView;
        this.f13832b = baseFunction;
        this.f13833c = privacyDesc1;
    }

    @NonNull
    public static c a(@NonNull View rootView) {
        int i2 = R.id.base_function;
        MiSwitchButton miSwitchButton = (MiSwitchButton) rootView.findViewById(i2);
        if (miSwitchButton != null) {
            i2 = R.id.privacy_desc_1;
            ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(i2);
            if (themeTextView != null) {
                return new c((ThemeLinearLayout) rootView, miSwitchButton, themeTextView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static c c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static c d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.activity_privacy_link, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeLinearLayout getRoot() {
        return this.f13831a;
    }
}
