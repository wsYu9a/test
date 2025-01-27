package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class p4 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeLinearLayout f12523a;

    /* renamed from: b */
    @NonNull
    public final ThemeLinearLayout f12524b;

    /* renamed from: c */
    @NonNull
    public final ThemeLinearLayout f12525c;

    /* renamed from: d */
    @NonNull
    public final ThemeTextView f12526d;

    private p4(@NonNull ThemeLinearLayout rootView, @NonNull ThemeLinearLayout acpCancelLayout, @NonNull ThemeLinearLayout acpLogoutLayout, @NonNull ThemeTextView acpLogoutTitle) {
        this.f12523a = rootView;
        this.f12524b = acpCancelLayout;
        this.f12525c = acpLogoutLayout;
        this.f12526d = acpLogoutTitle;
    }

    @NonNull
    public static p4 a(@NonNull View rootView) {
        int i2 = R.id.acp_cancel_layout;
        ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) rootView.findViewById(R.id.acp_cancel_layout);
        if (themeLinearLayout != null) {
            i2 = R.id.acp_logout_layout;
            ThemeLinearLayout themeLinearLayout2 = (ThemeLinearLayout) rootView.findViewById(R.id.acp_logout_layout);
            if (themeLinearLayout2 != null) {
                i2 = R.id.acp_logout_title;
                ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.acp_logout_title);
                if (themeTextView != null) {
                    return new p4((ThemeLinearLayout) rootView, themeLinearLayout, themeLinearLayout2, themeTextView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static p4 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static p4 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.popupwindow_account_logout, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeLinearLayout getRoot() {
        return this.f12523a;
    }
}
