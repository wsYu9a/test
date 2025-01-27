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
import com.martian.libmars.ui.theme.ThemeTextView;

/* loaded from: classes3.dex */
public final class DialogSingleButtonBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final RelativeLayout f12171a;

    /* renamed from: b */
    @NonNull
    public final ThemeImageView f12172b;

    /* renamed from: c */
    @NonNull
    public final ThemeTextView f12173c;

    /* renamed from: d */
    @NonNull
    public final ThemeTextView f12174d;

    /* renamed from: e */
    @NonNull
    public final ThemeTextView f12175e;

    /* renamed from: f */
    @NonNull
    public final RelativeLayout f12176f;

    public DialogSingleButtonBinding(@NonNull RelativeLayout relativeLayout, @NonNull ThemeImageView themeImageView, @NonNull ThemeTextView themeTextView, @NonNull ThemeTextView themeTextView2, @NonNull ThemeTextView themeTextView3, @NonNull RelativeLayout relativeLayout2) {
        this.f12171a = relativeLayout;
        this.f12172b = themeImageView;
        this.f12173c = themeTextView;
        this.f12174d = themeTextView2;
        this.f12175e = themeTextView3;
        this.f12176f = relativeLayout2;
    }

    @NonNull
    public static DialogSingleButtonBinding a(@NonNull View view) {
        int i10 = R.id.dialog_close;
        ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
        if (themeImageView != null) {
            i10 = R.id.dialog_desc;
            ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
            if (themeTextView != null) {
                i10 = R.id.dialog_notarize;
                ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (themeTextView2 != null) {
                    i10 = R.id.dialog_title;
                    ThemeTextView themeTextView3 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                    if (themeTextView3 != null) {
                        i10 = R.id.dialog_view;
                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i10);
                        if (relativeLayout != null) {
                            return new DialogSingleButtonBinding((RelativeLayout) view, themeImageView, themeTextView, themeTextView2, themeTextView3, relativeLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static DialogSingleButtonBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static DialogSingleButtonBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.dialog_single_button, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f12171a;
    }
}
