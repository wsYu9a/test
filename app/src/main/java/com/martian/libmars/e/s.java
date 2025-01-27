package com.martian.libmars.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.R;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeTextView;

/* loaded from: classes2.dex */
public final class s implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f10044a;

    /* renamed from: b */
    @NonNull
    public final ThemeImageView f10045b;

    /* renamed from: c */
    @NonNull
    public final ThemeTextView f10046c;

    private s(@NonNull LinearLayout rootView, @NonNull ThemeImageView actionbarWebviewClose, @NonNull ThemeTextView actionbarWebviewTitle) {
        this.f10044a = rootView;
        this.f10045b = actionbarWebviewClose;
        this.f10046c = actionbarWebviewTitle;
    }

    @NonNull
    public static s a(@NonNull View rootView) {
        int i2 = R.id.actionbar_webview_close;
        ThemeImageView themeImageView = (ThemeImageView) rootView.findViewById(i2);
        if (themeImageView != null) {
            i2 = R.id.actionbar_webview_title;
            ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(i2);
            if (themeTextView != null) {
                return new s((LinearLayout) rootView, themeImageView, themeTextView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static s c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static s d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.layout_webview_actionbar, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f10044a;
    }
}
