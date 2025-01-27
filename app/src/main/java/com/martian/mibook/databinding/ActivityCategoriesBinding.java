package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class ActivityCategoriesBinding implements ViewBinding {

    @NonNull
    public final FrameLayout fragmentContainer;

    @NonNull
    private final ThemeLinearLayout rootView;

    private ActivityCategoriesBinding(@NonNull ThemeLinearLayout themeLinearLayout, @NonNull FrameLayout frameLayout) {
        this.rootView = themeLinearLayout;
        this.fragmentContainer = frameLayout;
    }

    @NonNull
    public static ActivityCategoriesBinding bind(@NonNull View view) {
        int i10 = R.id.fragmentContainer;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i10);
        if (frameLayout != null) {
            return new ActivityCategoriesBinding((ThemeLinearLayout) view, frameLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ActivityCategoriesBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityCategoriesBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.activity_categories, viewGroup, false);
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
