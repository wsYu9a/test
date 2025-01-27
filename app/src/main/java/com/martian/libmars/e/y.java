package com.martian.libmars.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.R;
import com.martian.libmars.ui.theme.ThemeTextView;

/* loaded from: classes2.dex */
public final class y implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final RelativeLayout f10069a;

    /* renamed from: b */
    @NonNull
    public final ThemeTextView f10070b;

    /* renamed from: c */
    @NonNull
    public final TextView f10071c;

    /* renamed from: d */
    @NonNull
    public final ThemeTextView f10072d;

    /* renamed from: e */
    @NonNull
    public final TextView f10073e;

    private y(@NonNull RelativeLayout rootView, @NonNull ThemeTextView privacyAgree, @NonNull TextView privacyDeac, @NonNull ThemeTextView privacyKnown, @NonNull TextView privacyTitle) {
        this.f10069a = rootView;
        this.f10070b = privacyAgree;
        this.f10071c = privacyDeac;
        this.f10072d = privacyKnown;
        this.f10073e = privacyTitle;
    }

    @NonNull
    public static y a(@NonNull View rootView) {
        int i2 = R.id.privacy_agree;
        ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(i2);
        if (themeTextView != null) {
            i2 = R.id.privacy_deac;
            TextView textView = (TextView) rootView.findViewById(i2);
            if (textView != null) {
                i2 = R.id.privacy_known;
                ThemeTextView themeTextView2 = (ThemeTextView) rootView.findViewById(i2);
                if (themeTextView2 != null) {
                    i2 = R.id.privacy_title;
                    TextView textView2 = (TextView) rootView.findViewById(i2);
                    if (textView2 != null) {
                        return new y((RelativeLayout) rootView, themeTextView, textView, themeTextView2, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static y c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static y d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.libmars_popupwindow_permission, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f10069a;
    }
}
