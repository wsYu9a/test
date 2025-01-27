package com.martian.libmars.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.R;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.utils.tablayout.MagicIndicator;

/* loaded from: classes2.dex */
public final class t implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeLinearLayout f10047a;

    /* renamed from: b */
    @NonNull
    public final MagicIndicator f10048b;

    private t(@NonNull ThemeLinearLayout rootView, @NonNull MagicIndicator magicIndicator) {
        this.f10047a = rootView;
        this.f10048b = magicIndicator;
    }

    @NonNull
    public static t a(@NonNull View rootView) {
        int i2 = R.id.magic_indicator;
        MagicIndicator magicIndicator = (MagicIndicator) rootView.findViewById(i2);
        if (magicIndicator != null) {
            return new t((ThemeLinearLayout) rootView, magicIndicator);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static t c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static t d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.layout_xttab, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeLinearLayout getRoot() {
        return this.f10047a;
    }
}
