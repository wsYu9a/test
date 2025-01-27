package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeRelativeLayout;
import com.martian.libmars.utils.tablayout.MagicIndicator;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class FragmentBookmallMainBinding implements ViewBinding {

    @NonNull
    public final LinearLayout bookmallHeaderView;

    @NonNull
    public final MagicIndicator bookmallMagicIndicator;

    @NonNull
    public final ThemeImageView bookmallMainSearchIcon;

    @NonNull
    public final ViewPager bookmallVp;

    @NonNull
    public final ThemeRelativeLayout drawerLayout;

    @NonNull
    public final ViewStub readingRecord;

    @NonNull
    private final ThemeRelativeLayout rootView;

    private FragmentBookmallMainBinding(@NonNull ThemeRelativeLayout themeRelativeLayout, @NonNull LinearLayout linearLayout, @NonNull MagicIndicator magicIndicator, @NonNull ThemeImageView themeImageView, @NonNull ViewPager viewPager, @NonNull ThemeRelativeLayout themeRelativeLayout2, @NonNull ViewStub viewStub) {
        this.rootView = themeRelativeLayout;
        this.bookmallHeaderView = linearLayout;
        this.bookmallMagicIndicator = magicIndicator;
        this.bookmallMainSearchIcon = themeImageView;
        this.bookmallVp = viewPager;
        this.drawerLayout = themeRelativeLayout2;
        this.readingRecord = viewStub;
    }

    @NonNull
    public static FragmentBookmallMainBinding bind(@NonNull View view) {
        int i10 = R.id.bookmall_header_view;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
        if (linearLayout != null) {
            i10 = R.id.bookmall_magic_indicator;
            MagicIndicator magicIndicator = (MagicIndicator) ViewBindings.findChildViewById(view, i10);
            if (magicIndicator != null) {
                i10 = R.id.bookmall_main_search_icon;
                ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                if (themeImageView != null) {
                    i10 = R.id.bookmall_vp;
                    ViewPager viewPager = (ViewPager) ViewBindings.findChildViewById(view, i10);
                    if (viewPager != null) {
                        ThemeRelativeLayout themeRelativeLayout = (ThemeRelativeLayout) view;
                        i10 = R.id.reading_record;
                        ViewStub viewStub = (ViewStub) ViewBindings.findChildViewById(view, i10);
                        if (viewStub != null) {
                            return new FragmentBookmallMainBinding(themeRelativeLayout, linearLayout, magicIndicator, themeImageView, viewPager, themeRelativeLayout, viewStub);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static FragmentBookmallMainBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static FragmentBookmallMainBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.fragment_bookmall_main, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ThemeRelativeLayout getRoot() {
        return this.rootView;
    }
}
