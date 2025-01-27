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
import com.martian.libmars.ui.theme.ThemeTextView;

/* loaded from: classes2.dex */
public final class g implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final RelativeLayout f9964a;

    /* renamed from: b */
    @NonNull
    public final ThemeImageView f9965b;

    /* renamed from: c */
    @NonNull
    public final ThemeTextView f9966c;

    /* renamed from: d */
    @NonNull
    public final ThemeTextView f9967d;

    /* renamed from: e */
    @NonNull
    public final ThemeTextView f9968e;

    /* renamed from: f */
    @NonNull
    public final RelativeLayout f9969f;

    private g(@NonNull RelativeLayout rootView, @NonNull ThemeImageView dialogClose, @NonNull ThemeTextView dialogDesc, @NonNull ThemeTextView dialogNotarize, @NonNull ThemeTextView dialogTitle, @NonNull RelativeLayout dialogView) {
        this.f9964a = rootView;
        this.f9965b = dialogClose;
        this.f9966c = dialogDesc;
        this.f9967d = dialogNotarize;
        this.f9968e = dialogTitle;
        this.f9969f = dialogView;
    }

    @NonNull
    public static g a(@NonNull View rootView) {
        int i2 = R.id.dialog_close;
        ThemeImageView themeImageView = (ThemeImageView) rootView.findViewById(i2);
        if (themeImageView != null) {
            i2 = R.id.dialog_desc;
            ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(i2);
            if (themeTextView != null) {
                i2 = R.id.dialog_notarize;
                ThemeTextView themeTextView2 = (ThemeTextView) rootView.findViewById(i2);
                if (themeTextView2 != null) {
                    i2 = R.id.dialog_title;
                    ThemeTextView themeTextView3 = (ThemeTextView) rootView.findViewById(i2);
                    if (themeTextView3 != null) {
                        i2 = R.id.dialog_view;
                        RelativeLayout relativeLayout = (RelativeLayout) rootView.findViewById(i2);
                        if (relativeLayout != null) {
                            return new g((RelativeLayout) rootView, themeImageView, themeTextView, themeTextView2, themeTextView3, relativeLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static g c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static g d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.dialog_single_button, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f9964a;
    }
}
