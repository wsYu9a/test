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
public final class k0 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final RelativeLayout f10015a;

    /* renamed from: b */
    @NonNull
    public final ThemeImageView f10016b;

    /* renamed from: c */
    @NonNull
    public final ThemeTextView f10017c;

    /* renamed from: d */
    @NonNull
    public final ThemeLinearLayout f10018d;

    /* renamed from: e */
    @NonNull
    public final ThemeTextView f10019e;

    /* renamed from: f */
    @NonNull
    public final ThemeTextView f10020f;

    private k0(@NonNull RelativeLayout rootView, @NonNull ThemeImageView closeAdsCancel, @NonNull ThemeTextView closeAdsTitle, @NonNull ThemeLinearLayout closeAdsView, @NonNull ThemeTextView firstOption, @NonNull ThemeTextView secondOption) {
        this.f10015a = rootView;
        this.f10016b = closeAdsCancel;
        this.f10017c = closeAdsTitle;
        this.f10018d = closeAdsView;
        this.f10019e = firstOption;
        this.f10020f = secondOption;
    }

    @NonNull
    public static k0 a(@NonNull View rootView) {
        int i2 = R.id.close_ads_cancel;
        ThemeImageView themeImageView = (ThemeImageView) rootView.findViewById(i2);
        if (themeImageView != null) {
            i2 = R.id.close_ads_title;
            ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(i2);
            if (themeTextView != null) {
                i2 = R.id.close_ads_view;
                ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) rootView.findViewById(i2);
                if (themeLinearLayout != null) {
                    i2 = R.id.first_option;
                    ThemeTextView themeTextView2 = (ThemeTextView) rootView.findViewById(i2);
                    if (themeTextView2 != null) {
                        i2 = R.id.second_option;
                        ThemeTextView themeTextView3 = (ThemeTextView) rootView.findViewById(i2);
                        if (themeTextView3 != null) {
                            return new k0((RelativeLayout) rootView, themeImageView, themeTextView, themeLinearLayout, themeTextView2, themeTextView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static k0 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static k0 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.popupwindow_options, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f10015a;
    }
}
