package com.martian.libmars.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.R;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;

/* loaded from: classes2.dex */
public final class e implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final RelativeLayout f9945a;

    /* renamed from: b */
    @NonNull
    public final ThemeTextView f9946b;

    /* renamed from: c */
    @NonNull
    public final ThemeTextView f9947c;

    /* renamed from: d */
    @NonNull
    public final EditText f9948d;

    /* renamed from: e */
    @NonNull
    public final ThemeTextView f9949e;

    /* renamed from: f */
    @NonNull
    public final ThemeImageView f9950f;

    /* renamed from: g */
    @NonNull
    public final View f9951g;

    /* renamed from: h */
    @NonNull
    public final ThemeLinearLayout f9952h;

    /* renamed from: i */
    @NonNull
    public final View f9953i;

    /* renamed from: j */
    @NonNull
    public final View f9954j;

    @NonNull
    public final ThemeLinearLayout k;

    private e(@NonNull RelativeLayout rootView, @NonNull ThemeTextView dialogClose, @NonNull ThemeTextView dialogCreateTitle, @NonNull EditText dialogEdit, @NonNull ThemeTextView dialogNotarize, @NonNull ThemeImageView dialogSearchClose, @NonNull View dialogShadeView, @NonNull ThemeLinearLayout dialogView, @NonNull View dialogViewBottom, @NonNull View dialogViewTop, @NonNull ThemeLinearLayout searchView) {
        this.f9945a = rootView;
        this.f9946b = dialogClose;
        this.f9947c = dialogCreateTitle;
        this.f9948d = dialogEdit;
        this.f9949e = dialogNotarize;
        this.f9950f = dialogSearchClose;
        this.f9951g = dialogShadeView;
        this.f9952h = dialogView;
        this.f9953i = dialogViewBottom;
        this.f9954j = dialogViewTop;
        this.k = searchView;
    }

    @NonNull
    public static e a(@NonNull View rootView) {
        View findViewById;
        View findViewById2;
        View findViewById3;
        int i2 = R.id.dialog_close;
        ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(i2);
        if (themeTextView != null) {
            i2 = R.id.dialog_create_title;
            ThemeTextView themeTextView2 = (ThemeTextView) rootView.findViewById(i2);
            if (themeTextView2 != null) {
                i2 = R.id.dialog_edit;
                EditText editText = (EditText) rootView.findViewById(i2);
                if (editText != null) {
                    i2 = R.id.dialog_notarize;
                    ThemeTextView themeTextView3 = (ThemeTextView) rootView.findViewById(i2);
                    if (themeTextView3 != null) {
                        i2 = R.id.dialog_search_close;
                        ThemeImageView themeImageView = (ThemeImageView) rootView.findViewById(i2);
                        if (themeImageView != null && (findViewById = rootView.findViewById((i2 = R.id.dialog_shade_view))) != null) {
                            i2 = R.id.dialog_view;
                            ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) rootView.findViewById(i2);
                            if (themeLinearLayout != null && (findViewById2 = rootView.findViewById((i2 = R.id.dialog_view_bottom))) != null && (findViewById3 = rootView.findViewById((i2 = R.id.dialog_view_top))) != null) {
                                i2 = R.id.search_view;
                                ThemeLinearLayout themeLinearLayout2 = (ThemeLinearLayout) rootView.findViewById(i2);
                                if (themeLinearLayout2 != null) {
                                    return new e((RelativeLayout) rootView, themeTextView, themeTextView2, editText, themeTextView3, themeImageView, findViewById, themeLinearLayout, findViewById2, findViewById3, themeLinearLayout2);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static e c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static e d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.dialog_input_view, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f9945a;
    }
}
