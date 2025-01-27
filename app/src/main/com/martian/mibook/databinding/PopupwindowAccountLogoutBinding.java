package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class PopupwindowAccountLogoutBinding implements ViewBinding {

    @NonNull
    public final ThemeLinearLayout acpCancelLayout;

    @NonNull
    public final ThemeLinearLayout acpLogoutLayout;

    @NonNull
    public final ThemeTextView acpLogoutTitle;

    @NonNull
    private final ThemeLinearLayout rootView;

    private PopupwindowAccountLogoutBinding(@NonNull ThemeLinearLayout themeLinearLayout, @NonNull ThemeLinearLayout themeLinearLayout2, @NonNull ThemeLinearLayout themeLinearLayout3, @NonNull ThemeTextView themeTextView) {
        this.rootView = themeLinearLayout;
        this.acpCancelLayout = themeLinearLayout2;
        this.acpLogoutLayout = themeLinearLayout3;
        this.acpLogoutTitle = themeTextView;
    }

    @NonNull
    public static PopupwindowAccountLogoutBinding bind(@NonNull View view) {
        int i10 = R.id.acp_cancel_layout;
        ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
        if (themeLinearLayout != null) {
            i10 = R.id.acp_logout_layout;
            ThemeLinearLayout themeLinearLayout2 = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
            if (themeLinearLayout2 != null) {
                i10 = R.id.acp_logout_title;
                ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (themeTextView != null) {
                    return new PopupwindowAccountLogoutBinding((ThemeLinearLayout) view, themeLinearLayout, themeLinearLayout2, themeTextView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static PopupwindowAccountLogoutBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static PopupwindowAccountLogoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.popupwindow_account_logout, viewGroup, false);
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
