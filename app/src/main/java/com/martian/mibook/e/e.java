package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.MiSwitchButton;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class e implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeLinearLayout f11871a;

    /* renamed from: b */
    @NonNull
    public final MiSwitchButton f11872b;

    private e(@NonNull ThemeLinearLayout rootView, @NonNull MiSwitchButton baseFunction) {
        this.f11871a = rootView;
        this.f11872b = baseFunction;
    }

    @NonNull
    public static e a(@NonNull View rootView) {
        MiSwitchButton miSwitchButton = (MiSwitchButton) rootView.findViewById(R.id.base_function);
        if (miSwitchButton != null) {
            return new e((ThemeLinearLayout) rootView, miSwitchButton);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(R.id.base_function)));
    }

    @NonNull
    public static e c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static e d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.activity_base_function_guide, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeLinearLayout getRoot() {
        return this.f11871a;
    }
}
