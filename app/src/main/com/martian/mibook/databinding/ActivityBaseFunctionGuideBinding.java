package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.MiSwitchButton;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class ActivityBaseFunctionGuideBinding implements ViewBinding {

    @NonNull
    public final MiSwitchButton baseFunction;

    @NonNull
    private final ThemeLinearLayout rootView;

    private ActivityBaseFunctionGuideBinding(@NonNull ThemeLinearLayout themeLinearLayout, @NonNull MiSwitchButton miSwitchButton) {
        this.rootView = themeLinearLayout;
        this.baseFunction = miSwitchButton;
    }

    @NonNull
    public static ActivityBaseFunctionGuideBinding bind(@NonNull View view) {
        int i10 = R.id.base_function;
        MiSwitchButton miSwitchButton = (MiSwitchButton) ViewBindings.findChildViewById(view, i10);
        if (miSwitchButton != null) {
            return new ActivityBaseFunctionGuideBinding((ThemeLinearLayout) view, miSwitchButton);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ActivityBaseFunctionGuideBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityBaseFunctionGuideBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.activity_base_function_guide, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ThemeLinearLayout getRoot() {
        return this.rootView;
    }
}
