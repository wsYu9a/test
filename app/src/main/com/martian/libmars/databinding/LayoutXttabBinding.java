package com.martian.libmars.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.R;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.utils.tablayout.MagicIndicator;

/* loaded from: classes3.dex */
public final class LayoutXttabBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final ThemeLinearLayout f12256a;

    /* renamed from: b */
    @NonNull
    public final ThemeLinearLayout f12257b;

    /* renamed from: c */
    @NonNull
    public final MagicIndicator f12258c;

    public LayoutXttabBinding(@NonNull ThemeLinearLayout themeLinearLayout, @NonNull ThemeLinearLayout themeLinearLayout2, @NonNull MagicIndicator magicIndicator) {
        this.f12256a = themeLinearLayout;
        this.f12257b = themeLinearLayout2;
        this.f12258c = magicIndicator;
    }

    @NonNull
    public static LayoutXttabBinding a(@NonNull View view) {
        ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) view;
        int i10 = R.id.magic_indicator;
        MagicIndicator magicIndicator = (MagicIndicator) ViewBindings.findChildViewById(view, i10);
        if (magicIndicator != null) {
            return new LayoutXttabBinding(themeLinearLayout, themeLinearLayout, magicIndicator);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static LayoutXttabBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static LayoutXttabBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.layout_xttab, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeLinearLayout getRoot() {
        return this.f12256a;
    }
}
