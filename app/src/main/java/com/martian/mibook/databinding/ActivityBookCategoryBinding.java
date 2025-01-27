package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class ActivityBookCategoryBinding implements ViewBinding {

    @NonNull
    private final ThemeLinearLayout rootView;

    @NonNull
    public final ViewPager viewpager;

    private ActivityBookCategoryBinding(@NonNull ThemeLinearLayout themeLinearLayout, @NonNull ViewPager viewPager) {
        this.rootView = themeLinearLayout;
        this.viewpager = viewPager;
    }

    @NonNull
    public static ActivityBookCategoryBinding bind(@NonNull View view) {
        int i10 = R.id.viewpager;
        ViewPager viewPager = (ViewPager) ViewBindings.findChildViewById(view, i10);
        if (viewPager != null) {
            return new ActivityBookCategoryBinding((ThemeLinearLayout) view, viewPager);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ActivityBookCategoryBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityBookCategoryBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.activity_book_category, viewGroup, false);
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
