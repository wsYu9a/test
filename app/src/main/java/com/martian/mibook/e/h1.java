package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class h1 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final FrameLayout f12042a;

    /* renamed from: b */
    @NonNull
    public final ThemeLinearLayout f12043b;

    /* renamed from: c */
    @NonNull
    public final ThemeLinearLayout f12044c;

    /* renamed from: d */
    @NonNull
    public final ThemeLinearLayout f12045d;

    /* renamed from: e */
    @NonNull
    public final ThemeLinearLayout f12046e;

    /* renamed from: f */
    @NonNull
    public final FrameLayout f12047f;

    private h1(@NonNull FrameLayout rootView, @NonNull ThemeLinearLayout bsCategory, @NonNull ThemeLinearLayout bsFinish, @NonNull ThemeLinearLayout bsNew, @NonNull ThemeLinearLayout bsRank, @NonNull FrameLayout svContainer) {
        this.f12042a = rootView;
        this.f12043b = bsCategory;
        this.f12044c = bsFinish;
        this.f12045d = bsNew;
        this.f12046e = bsRank;
        this.f12047f = svContainer;
    }

    @NonNull
    public static h1 a(@NonNull View rootView) {
        int i2 = R.id.bs_category;
        ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) rootView.findViewById(R.id.bs_category);
        if (themeLinearLayout != null) {
            i2 = R.id.bs_finish;
            ThemeLinearLayout themeLinearLayout2 = (ThemeLinearLayout) rootView.findViewById(R.id.bs_finish);
            if (themeLinearLayout2 != null) {
                i2 = R.id.bs_new;
                ThemeLinearLayout themeLinearLayout3 = (ThemeLinearLayout) rootView.findViewById(R.id.bs_new);
                if (themeLinearLayout3 != null) {
                    i2 = R.id.bs_rank;
                    ThemeLinearLayout themeLinearLayout4 = (ThemeLinearLayout) rootView.findViewById(R.id.bs_rank);
                    if (themeLinearLayout4 != null) {
                        FrameLayout frameLayout = (FrameLayout) rootView;
                        return new h1(frameLayout, themeLinearLayout, themeLinearLayout2, themeLinearLayout3, themeLinearLayout4, frameLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static h1 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static h1 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.bookmall_icons, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public FrameLayout getRoot() {
        return this.f12042a;
    }
}
