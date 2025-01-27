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
public final class g0 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeLinearLayout f11986a;

    /* renamed from: b */
    @NonNull
    public final FrameLayout f11987b;

    private g0(@NonNull ThemeLinearLayout rootView, @NonNull FrameLayout fragmentContainer) {
        this.f11986a = rootView;
        this.f11987b = fragmentContainer;
    }

    @NonNull
    public static g0 a(@NonNull View rootView) {
        FrameLayout frameLayout = (FrameLayout) rootView.findViewById(R.id.fragmentContainer);
        if (frameLayout != null) {
            return new g0((ThemeLinearLayout) rootView, frameLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.fragmentContainer)));
    }

    @NonNull
    public static g0 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static g0 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.activity_ywcategories, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeLinearLayout getRoot() {
        return this.f11986a;
    }
}
