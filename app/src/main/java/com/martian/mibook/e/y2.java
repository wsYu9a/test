package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.ViewPager;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeRelativeLayout;
import com.martian.libmars.utils.tablayout.MagicIndicator;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class y2 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeRelativeLayout f12967a;

    /* renamed from: b */
    @NonNull
    public final LinearLayout f12968b;

    /* renamed from: c */
    @NonNull
    public final MagicIndicator f12969c;

    /* renamed from: d */
    @NonNull
    public final ThemeImageView f12970d;

    /* renamed from: e */
    @NonNull
    public final ViewPager f12971e;

    /* renamed from: f */
    @NonNull
    public final ThemeRelativeLayout f12972f;

    private y2(@NonNull ThemeRelativeLayout rootView, @NonNull LinearLayout bookmallHeaderView, @NonNull MagicIndicator bookmallMagicIndicator, @NonNull ThemeImageView bookmallMainSearchIcon, @NonNull ViewPager bookmallVp, @NonNull ThemeRelativeLayout drawerLayout) {
        this.f12967a = rootView;
        this.f12968b = bookmallHeaderView;
        this.f12969c = bookmallMagicIndicator;
        this.f12970d = bookmallMainSearchIcon;
        this.f12971e = bookmallVp;
        this.f12972f = drawerLayout;
    }

    @NonNull
    public static y2 a(@NonNull View rootView) {
        int i2 = R.id.bookmall_header_view;
        LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.bookmall_header_view);
        if (linearLayout != null) {
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
                        return new y2(themeRelativeLayout, linearLayout, magicIndicator, themeImageView, viewPager, themeRelativeLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static y2 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static y2 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.fragment_bookmall_main, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeRelativeLayout getRoot() {
        return this.f12967a;
    }
}
