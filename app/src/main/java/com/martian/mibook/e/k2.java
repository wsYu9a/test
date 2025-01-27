package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class k2 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final RelativeLayout f12233a;

    /* renamed from: b */
    @NonNull
    public final ThemeTextView f12234b;

    /* renamed from: c */
    @NonNull
    public final ThemeTextView f12235c;

    /* renamed from: d */
    @NonNull
    public final View f12236d;

    /* renamed from: e */
    @NonNull
    public final ThemeTextView f12237e;

    /* renamed from: f */
    @NonNull
    public final ThemeLinearLayout f12238f;

    /* renamed from: g */
    @NonNull
    public final View f12239g;

    /* renamed from: h */
    @NonNull
    public final View f12240h;

    private k2(@NonNull RelativeLayout rootView, @NonNull ThemeTextView dialogDesc, @NonNull ThemeTextView dialogNotarize, @NonNull View dialogShadeView, @NonNull ThemeTextView dialogTitle, @NonNull ThemeLinearLayout dialogView, @NonNull View dialogViewBottom, @NonNull View dialogViewTop) {
        this.f12233a = rootView;
        this.f12234b = dialogDesc;
        this.f12235c = dialogNotarize;
        this.f12236d = dialogShadeView;
        this.f12237e = dialogTitle;
        this.f12238f = dialogView;
        this.f12239g = dialogViewBottom;
        this.f12240h = dialogViewTop;
    }

    @NonNull
    public static k2 a(@NonNull View rootView) {
        int i2 = R.id.dialog_desc;
        ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.dialog_desc);
        if (themeTextView != null) {
            i2 = R.id.dialog_notarize;
            ThemeTextView themeTextView2 = (ThemeTextView) rootView.findViewById(R.id.dialog_notarize);
            if (themeTextView2 != null) {
                i2 = R.id.dialog_shade_view;
                View findViewById = rootView.findViewById(R.id.dialog_shade_view);
                if (findViewById != null) {
                    i2 = R.id.dialog_title;
                    ThemeTextView themeTextView3 = (ThemeTextView) rootView.findViewById(R.id.dialog_title);
                    if (themeTextView3 != null) {
                        i2 = R.id.dialog_view;
                        ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) rootView.findViewById(R.id.dialog_view);
                        if (themeLinearLayout != null) {
                            i2 = R.id.dialog_view_bottom;
                            View findViewById2 = rootView.findViewById(R.id.dialog_view_bottom);
                            if (findViewById2 != null) {
                                i2 = R.id.dialog_view_top;
                                View findViewById3 = rootView.findViewById(R.id.dialog_view_top);
                                if (findViewById3 != null) {
                                    return new k2((RelativeLayout) rootView, themeTextView, themeTextView2, findViewById, themeTextView3, themeLinearLayout, findViewById2, findViewById3);
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
    public static k2 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static k2 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.dialog_coins_explain, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f12233a;
    }
}
