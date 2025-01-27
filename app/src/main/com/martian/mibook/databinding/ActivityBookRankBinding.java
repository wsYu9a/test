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
import com.martian.libmars.widget.recyclerview.LoadingTip;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class ActivityBookRankBinding implements ViewBinding {

    @NonNull
    public final LoadingTip rlLoadedTip;

    @NonNull
    private final ThemeLinearLayout rootView;

    @NonNull
    public final ViewPager viewpager;

    private ActivityBookRankBinding(@NonNull ThemeLinearLayout themeLinearLayout, @NonNull LoadingTip loadingTip, @NonNull ViewPager viewPager) {
        this.rootView = themeLinearLayout;
        this.rlLoadedTip = loadingTip;
        this.viewpager = viewPager;
    }

    @NonNull
    public static ActivityBookRankBinding bind(@NonNull View view) {
        int i10 = R.id.rl_loadedTip;
        LoadingTip loadingTip = (LoadingTip) ViewBindings.findChildViewById(view, i10);
        if (loadingTip != null) {
            i10 = R.id.viewpager;
            ViewPager viewPager = (ViewPager) ViewBindings.findChildViewById(view, i10);
            if (viewPager != null) {
                return new ActivityBookRankBinding((ThemeLinearLayout) view, loadingTip, viewPager);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ActivityBookRankBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityBookRankBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.activity_book_rank, viewGroup, false);
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
