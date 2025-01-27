package com.martian.libmars.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.R;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;

/* loaded from: classes2.dex */
public final class c implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final RelativeLayout f9917a;

    /* renamed from: b */
    @NonNull
    public final ThemeTextView f9918b;

    /* renamed from: c */
    @NonNull
    public final ThemeImageView f9919c;

    /* renamed from: d */
    @NonNull
    public final ThemeTextView f9920d;

    /* renamed from: e */
    @NonNull
    public final ThemeTextView f9921e;

    /* renamed from: f */
    @NonNull
    public final View f9922f;

    /* renamed from: g */
    @NonNull
    public final ThemeTextView f9923g;

    /* renamed from: h */
    @NonNull
    public final ThemeLinearLayout f9924h;

    /* renamed from: i */
    @NonNull
    public final View f9925i;

    /* renamed from: j */
    @NonNull
    public final View f9926j;

    private c(@NonNull RelativeLayout rootView, @NonNull ThemeTextView dialogClose, @NonNull ThemeImageView dialogCloseImage, @NonNull ThemeTextView dialogDesc, @NonNull ThemeTextView dialogNotarize, @NonNull View dialogShadeView, @NonNull ThemeTextView dialogTitle, @NonNull ThemeLinearLayout dialogView, @NonNull View dialogViewBottom, @NonNull View dialogViewTop) {
        this.f9917a = rootView;
        this.f9918b = dialogClose;
        this.f9919c = dialogCloseImage;
        this.f9920d = dialogDesc;
        this.f9921e = dialogNotarize;
        this.f9922f = dialogShadeView;
        this.f9923g = dialogTitle;
        this.f9924h = dialogView;
        this.f9925i = dialogViewBottom;
        this.f9926j = dialogViewTop;
    }

    @NonNull
    public static c a(@NonNull View rootView) {
        View findViewById;
        View findViewById2;
        View findViewById3;
        int i2 = R.id.dialog_close;
        ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(i2);
        if (themeTextView != null) {
            i2 = R.id.dialog_close_image;
            ThemeImageView themeImageView = (ThemeImageView) rootView.findViewById(i2);
            if (themeImageView != null) {
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
                                return new c((RelativeLayout) rootView, themeTextView, themeImageView, themeTextView2, themeTextView3, findViewById, themeTextView4, themeLinearLayout, findViewById2, findViewById3);
                            }
                        }
                    }
                }
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
        View inflate = inflater.inflate(R.layout.dialog_confirm_hint, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f9917a;
    }
}
