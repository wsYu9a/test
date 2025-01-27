package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.ViewPager;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.utils.tablayout.MagicIndicator;
import com.martian.libmars.widget.recyclerview.LoadingTip;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class z1 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeLinearLayout f13007a;

    /* renamed from: b */
    @NonNull
    public final ThemeLinearLayout f13008b;

    /* renamed from: c */
    @NonNull
    public final LoadingTip f13009c;

    /* renamed from: d */
    @NonNull
    public final ViewPager f13010d;

    /* renamed from: e */
    @NonNull
    public final MagicIndicator f13011e;

    /* renamed from: f */
    @NonNull
    public final a2 f13012f;

    private z1(@NonNull ThemeLinearLayout rootView, @NonNull ThemeLinearLayout listCategoryView, @NonNull LoadingTip listItemCategoryLoadingTip, @NonNull ViewPager listItemCategoryVp, @NonNull MagicIndicator magicIndicator, @NonNull a2 titleView) {
        this.f13007a = rootView;
        this.f13008b = listCategoryView;
        this.f13009c = listItemCategoryLoadingTip;
        this.f13010d = listItemCategoryVp;
        this.f13011e = magicIndicator;
        this.f13012f = titleView;
    }

    @NonNull
    public static z1 a(@NonNull View rootView) {
        ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) rootView;
        int i2 = R.id.list_item_category_loading_tip;
        LoadingTip loadingTip = (LoadingTip) rootView.findViewById(R.id.list_item_category_loading_tip);
        if (loadingTip != null) {
            i2 = R.id.list_item_category_vp;
            ViewPager viewPager = (ViewPager) rootView.findViewById(R.id.list_item_category_vp);
            if (viewPager != null) {
                i2 = R.id.magic_indicator;
                MagicIndicator magicIndicator = (MagicIndicator) rootView.findViewById(R.id.magic_indicator);
                if (magicIndicator != null) {
                    i2 = R.id.title_view;
                    View findViewById = rootView.findViewById(R.id.title_view);
                    if (findViewById != null) {
                        return new z1((ThemeLinearLayout) rootView, themeLinearLayout, loadingTip, viewPager, magicIndicator, a2.a(findViewById));
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static z1 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static z1 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.bs_book_store_item_list_category, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeLinearLayout getRoot() {
        return this.f13007a;
    }
}
