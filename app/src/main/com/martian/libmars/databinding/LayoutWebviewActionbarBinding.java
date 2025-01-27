package com.martian.libmars.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.R;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeTextView;

/* loaded from: classes3.dex */
public final class LayoutWebviewActionbarBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f12253a;

    /* renamed from: b */
    @NonNull
    public final ThemeImageView f12254b;

    /* renamed from: c */
    @NonNull
    public final ThemeTextView f12255c;

    public LayoutWebviewActionbarBinding(@NonNull LinearLayout linearLayout, @NonNull ThemeImageView themeImageView, @NonNull ThemeTextView themeTextView) {
        this.f12253a = linearLayout;
        this.f12254b = themeImageView;
        this.f12255c = themeTextView;
    }

    @NonNull
    public static LayoutWebviewActionbarBinding a(@NonNull View view) {
        int i10 = R.id.actionbar_webview_close;
        ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
        if (themeImageView != null) {
            i10 = R.id.actionbar_webview_title;
            ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
            if (themeTextView != null) {
                return new LayoutWebviewActionbarBinding((LinearLayout) view, themeImageView, themeTextView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static LayoutWebviewActionbarBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static LayoutWebviewActionbarBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.layout_webview_actionbar, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f12253a;
    }
}
