package com.martian.libmars.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.R;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;

/* loaded from: classes3.dex */
public final class PopupwindowOptionsBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final RelativeLayout f12334a;

    /* renamed from: b */
    @NonNull
    public final ThemeImageView f12335b;

    /* renamed from: c */
    @NonNull
    public final ThemeTextView f12336c;

    /* renamed from: d */
    @NonNull
    public final ThemeLinearLayout f12337d;

    /* renamed from: e */
    @NonNull
    public final ThemeTextView f12338e;

    /* renamed from: f */
    @NonNull
    public final ThemeTextView f12339f;

    public PopupwindowOptionsBinding(@NonNull RelativeLayout relativeLayout, @NonNull ThemeImageView themeImageView, @NonNull ThemeTextView themeTextView, @NonNull ThemeLinearLayout themeLinearLayout, @NonNull ThemeTextView themeTextView2, @NonNull ThemeTextView themeTextView3) {
        this.f12334a = relativeLayout;
        this.f12335b = themeImageView;
        this.f12336c = themeTextView;
        this.f12337d = themeLinearLayout;
        this.f12338e = themeTextView2;
        this.f12339f = themeTextView3;
    }

    @NonNull
    public static PopupwindowOptionsBinding a(@NonNull View view) {
        int i10 = R.id.close_ads_cancel;
        ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
        if (themeImageView != null) {
            i10 = R.id.close_ads_title;
            ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
            if (themeTextView != null) {
                i10 = R.id.close_ads_view;
                ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                if (themeLinearLayout != null) {
                    i10 = R.id.first_option;
                    ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                    if (themeTextView2 != null) {
                        i10 = R.id.second_option;
                        ThemeTextView themeTextView3 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                        if (themeTextView3 != null) {
                            return new PopupwindowOptionsBinding((RelativeLayout) view, themeImageView, themeTextView, themeLinearLayout, themeTextView2, themeTextView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static PopupwindowOptionsBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static PopupwindowOptionsBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.popupwindow_options, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f12334a;
    }
}
