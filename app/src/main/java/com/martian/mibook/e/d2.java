package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class d2 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeLinearLayout f11834a;

    /* renamed from: b */
    @NonNull
    public final ThemeLinearLayout f11835b;

    private d2(@NonNull ThemeLinearLayout rootView, @NonNull ThemeLinearLayout cardViewParent) {
        this.f11834a = rootView;
        this.f11835b = cardViewParent;
    }

    @NonNull
    public static d2 a(@NonNull View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) rootView;
        return new d2(themeLinearLayout, themeLinearLayout);
    }

    @NonNull
    public static d2 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static d2 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.card_view_layout, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeLinearLayout getRoot() {
        return this.f11834a;
    }
}
