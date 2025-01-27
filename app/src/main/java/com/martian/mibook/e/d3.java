package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.ViewPager;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeRelativeLayout;
import com.martian.libmars.utils.tablayout.MagicIndicator;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class d3 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeRelativeLayout f11836a;

    /* renamed from: b */
    @NonNull
    public final ThemeLinearLayout f11837b;

    /* renamed from: c */
    @NonNull
    public final MagicIndicator f11838c;

    /* renamed from: d */
    @NonNull
    public final ThemeImageView f11839d;

    /* renamed from: e */
    @NonNull
    public final ViewPager f11840e;

    /* renamed from: f */
    @NonNull
    public final ThemeRelativeLayout f11841f;

    private d3(@NonNull ThemeRelativeLayout rootView, @NonNull ThemeLinearLayout bookmallHeaderView, @NonNull MagicIndicator bookmallMagicIndicator, @NonNull ThemeImageView bookmallMainSearchIcon, @NonNull ViewPager bookmallVp, @NonNull ThemeRelativeLayout drawerLayout) {
        this.f11836a = rootView;
        this.f11837b = bookmallHeaderView;
        this.f11838c = bookmallMagicIndicator;
        this.f11839d = bookmallMainSearchIcon;
        this.f11840e = bookmallVp;
        this.f11841f = drawerLayout;
    }

    @NonNull
    public static d3 a(@NonNull View rootView) {
        int i2 = R.id.bookmall_header_view;
        ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) rootView.findViewById(R.id.bookmall_header_view);
        if (themeLinearLayout != null) {
            i2 = R.id.bookmall_magic_indicator;
            MagicIndicator magicIndicator = (MagicIndicator) rootView.findViewById(R.id.bookmall_magic_indicator);
            if (magicIndicator != null) {
                i2 = R.id.bookmall_main_search_icon;
                ThemeImageView themeImageView = (ThemeImageView) rootView.findViewById(R.id.bookmall_main_search_icon);
                if (themeImageView != null) {
                    i2 = R.id.bookmall_vp;
                    ViewPager viewPager = (ViewPager) rootView.findViewById(R.id.bookmall_vp);
                    if (viewPager != null) {
                        ThemeRelativeLayout themeRelativeLayout = (ThemeRelativeLayout) rootView;
                        return new d3(themeRelativeLayout, themeLinearLayout, magicIndicator, themeImageView, viewPager, themeRelativeLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static d3 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static d3 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.fragment_category_main, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeRelativeLayout getRoot() {
        return this.f11836a;
    }
}
