package com.martian.libmars.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.R;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;

/* loaded from: classes2.dex */
public final class d implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final RelativeLayout f9930a;

    /* renamed from: b */
    @NonNull
    public final CheckBox f9931b;

    /* renamed from: c */
    @NonNull
    public final ThemeTextView f9932c;

    /* renamed from: d */
    @NonNull
    public final ThemeTextView f9933d;

    /* renamed from: e */
    @NonNull
    public final ThemeTextView f9934e;

    /* renamed from: f */
    @NonNull
    public final View f9935f;

    /* renamed from: g */
    @NonNull
    public final ThemeTextView f9936g;

    /* renamed from: h */
    @NonNull
    public final ThemeLinearLayout f9937h;

    /* renamed from: i */
    @NonNull
    public final View f9938i;

    /* renamed from: j */
    @NonNull
    public final View f9939j;

    private d(@NonNull RelativeLayout rootView, @NonNull CheckBox dialogCheck, @NonNull ThemeTextView dialogClose, @NonNull ThemeTextView dialogDesc, @NonNull ThemeTextView dialogNotarize, @NonNull View dialogShadeView, @NonNull ThemeTextView dialogTitle, @NonNull ThemeLinearLayout dialogView, @NonNull View dialogViewBottom, @NonNull View dialogViewTop) {
        this.f9930a = rootView;
        this.f9931b = dialogCheck;
        this.f9932c = dialogClose;
        this.f9933d = dialogDesc;
        this.f9934e = dialogNotarize;
        this.f9935f = dialogShadeView;
        this.f9936g = dialogTitle;
        this.f9937h = dialogView;
        this.f9938i = dialogViewBottom;
        this.f9939j = dialogViewTop;
    }

    @NonNull
    public static d a(@NonNull View rootView) {
        View findViewById;
        View findViewById2;
        View findViewById3;
        int i2 = R.id.dialog_check;
        CheckBox checkBox = (CheckBox) rootView.findViewById(i2);
        if (checkBox != null) {
            i2 = R.id.dialog_close;
            ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(i2);
            if (themeTextView != null) {
                i2 = R.id.dialog_desc;
                ThemeTextView themeTextView2 = (ThemeTextView) rootView.findViewById(i2);
                if (themeTextView2 != null) {
                    i2 = R.id.dialog_notarize;
                    ThemeTextView themeTextView3 = (ThemeTextView) rootView.findViewById(i2);
                    if (themeTextView3 != null && (findViewById = rootView.findViewById((i2 = R.id.dialog_shade_view))) != null) {
                        i2 = R.id.dialog_title;
                        ThemeTextView themeTextView4 = (ThemeTextView) rootView.findViewById(i2);
                        if (themeTextView4 != null) {
                            i2 = R.id.dialog_view;
                            ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) rootView.findViewById(i2);
                            if (themeLinearLayout != null && (findViewById2 = rootView.findViewById((i2 = R.id.dialog_view_bottom))) != null && (findViewById3 = rootView.findViewById((i2 = R.id.dialog_view_top))) != null) {
                                return new d((RelativeLayout) rootView, checkBox, themeTextView, themeTextView2, themeTextView3, findViewById, themeTextView4, themeLinearLayout, findViewById2, findViewById3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static d c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static d d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.dialog_confirm_view, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f9930a;
    }
}
