package com.martian.libmars.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.R;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;

/* loaded from: classes2.dex */
public final class h implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final RelativeLayout f9980a;

    /* renamed from: b */
    @NonNull
    public final RadioGroup f9981b;

    /* renamed from: c */
    @NonNull
    public final View f9982c;

    /* renamed from: d */
    @NonNull
    public final ThemeTextView f9983d;

    /* renamed from: e */
    @NonNull
    public final ThemeLinearLayout f9984e;

    /* renamed from: f */
    @NonNull
    public final View f9985f;

    /* renamed from: g */
    @NonNull
    public final View f9986g;

    private h(@NonNull RelativeLayout rootView, @NonNull RadioGroup dialogRadioGroup, @NonNull View dialogShadeView, @NonNull ThemeTextView dialogTitle, @NonNull ThemeLinearLayout dialogView, @NonNull View dialogViewBottom, @NonNull View dialogViewTop) {
        this.f9980a = rootView;
        this.f9981b = dialogRadioGroup;
        this.f9982c = dialogShadeView;
        this.f9983d = dialogTitle;
        this.f9984e = dialogView;
        this.f9985f = dialogViewBottom;
        this.f9986g = dialogViewTop;
    }

    @NonNull
    public static h a(@NonNull View rootView) {
        View findViewById;
        View findViewById2;
        View findViewById3;
        int i2 = R.id.dialog_radio_group;
        RadioGroup radioGroup = (RadioGroup) rootView.findViewById(i2);
        if (radioGroup != null && (findViewById = rootView.findViewById((i2 = R.id.dialog_shade_view))) != null) {
            i2 = R.id.dialog_title;
            ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(i2);
            if (themeTextView != null) {
                i2 = R.id.dialog_view;
                ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) rootView.findViewById(i2);
                if (themeLinearLayout != null && (findViewById2 = rootView.findViewById((i2 = R.id.dialog_view_bottom))) != null && (findViewById3 = rootView.findViewById((i2 = R.id.dialog_view_top))) != null) {
                    return new h((RelativeLayout) rootView, radioGroup, findViewById, themeTextView, themeLinearLayout, findViewById2, findViewById3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static h c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static h d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.dialog_single_choice, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f9980a;
    }
}
