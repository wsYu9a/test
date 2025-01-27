package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.martian.libmars.ui.theme.ThemeBottomNavigationBar;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class ActivityHomeBinding implements ViewBinding {

    @NonNull
    public final ThemeBottomNavigationBar bottomNavigationBar;

    @NonNull
    public final ThemeLinearLayout divider;

    @NonNull
    public final ViewPager2 mainViewpager2;

    @NonNull
    private final ConstraintLayout rootView;

    private ActivityHomeBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ThemeBottomNavigationBar themeBottomNavigationBar, @NonNull ThemeLinearLayout themeLinearLayout, @NonNull ViewPager2 viewPager2) {
        this.rootView = constraintLayout;
        this.bottomNavigationBar = themeBottomNavigationBar;
        this.divider = themeLinearLayout;
        this.mainViewpager2 = viewPager2;
    }

    @NonNull
    public static ActivityHomeBinding bind(@NonNull View view) {
        int i10 = R.id.bottom_navigation_bar;
        ThemeBottomNavigationBar themeBottomNavigationBar = (ThemeBottomNavigationBar) ViewBindings.findChildViewById(view, i10);
        if (themeBottomNavigationBar != null) {
            i10 = R.id.divider;
            ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
            if (themeLinearLayout != null) {
                i10 = R.id.main_viewpager2;
                ViewPager2 viewPager2 = (ViewPager2) ViewBindings.findChildViewById(view, i10);
                if (viewPager2 != null) {
                    return new ActivityHomeBinding((ConstraintLayout) view, themeBottomNavigationBar, themeLinearLayout, viewPager2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ActivityHomeBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityHomeBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.activity_home, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
