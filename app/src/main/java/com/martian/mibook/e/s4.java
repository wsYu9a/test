package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class s4 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final RelativeLayout f12676a;

    /* renamed from: b */
    @NonNull
    public final LinearLayout f12677b;

    /* renamed from: c */
    @NonNull
    public final View f12678c;

    /* renamed from: d */
    @NonNull
    public final ThemeTextView f12679d;

    /* renamed from: e */
    @NonNull
    public final ThemeLinearLayout f12680e;

    /* renamed from: f */
    @NonNull
    public final View f12681f;

    private s4(@NonNull RelativeLayout rootView, @NonNull LinearLayout popupwindowLinear, @NonNull View popupwindowShadeView, @NonNull ThemeTextView popupwindowTitle, @NonNull ThemeLinearLayout popupwindowView, @NonNull View popupwindowViewTop) {
        this.f12676a = rootView;
        this.f12677b = popupwindowLinear;
        this.f12678c = popupwindowShadeView;
        this.f12679d = popupwindowTitle;
        this.f12680e = popupwindowView;
        this.f12681f = popupwindowViewTop;
    }

    @NonNull
    public static s4 a(@NonNull View rootView) {
        int i2 = R.id.popupwindow_linear;
        LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.popupwindow_linear);
        if (linearLayout != null) {
            i2 = R.id.popupwindow_shade_view;
            View findViewById = rootView.findViewById(R.id.popupwindow_shade_view);
            if (findViewById != null) {
                i2 = R.id.popupwindow_title;
                ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.popupwindow_title);
                if (themeTextView != null) {
                    i2 = R.id.popupwindow_view;
                    ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) rootView.findViewById(R.id.popupwindow_view);
                    if (themeLinearLayout != null) {
                        i2 = R.id.popupwindow_view_top;
                        View findViewById2 = rootView.findViewById(R.id.popupwindow_view_top);
                        if (findViewById2 != null) {
                            return new s4((RelativeLayout) rootView, linearLayout, findViewById, themeTextView, themeLinearLayout, findViewById2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static s4 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static s4 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.popupwindow_list, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f12676a;
    }
}
