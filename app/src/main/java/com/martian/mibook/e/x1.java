package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.ViewPager;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.utils.tablayout.MagicIndicator;
import com.martian.libmars.widget.recyclerview.LoadingTip;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class x1 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeLinearLayout f12916a;

    /* renamed from: b */
    @NonNull
    public final LoadingTip f12917b;

    /* renamed from: c */
    @NonNull
    public final ViewPager f12918c;

    /* renamed from: d */
    @NonNull
    public final RelativeLayout f12919d;

    /* renamed from: e */
    @NonNull
    public final MagicIndicator f12920e;

    /* renamed from: f */
    @NonNull
    public final ThemeLinearLayout f12921f;

    /* renamed from: g */
    @NonNull
    public final a2 f12922g;

    private x1(@NonNull ThemeLinearLayout rootView, @NonNull LoadingTip gridItemRankLoadingTip, @NonNull ViewPager gridItemRankVp, @NonNull RelativeLayout gridItemRankVpView, @NonNull MagicIndicator gridMagicIndicator, @NonNull ThemeLinearLayout gridRankView, @NonNull a2 titleView) {
        this.f12916a = rootView;
        this.f12917b = gridItemRankLoadingTip;
        this.f12918c = gridItemRankVp;
        this.f12919d = gridItemRankVpView;
        this.f12920e = gridMagicIndicator;
        this.f12921f = gridRankView;
        this.f12922g = titleView;
    }

    @NonNull
    public static x1 a(@NonNull View rootView) {
        int i2 = R.id.grid_item_rank_loading_tip;
        LoadingTip loadingTip = (LoadingTip) rootView.findViewById(R.id.grid_item_rank_loading_tip);
        if (loadingTip != null) {
            i2 = R.id.grid_item_rank_vp;
            ViewPager viewPager = (ViewPager) rootView.findViewById(R.id.grid_item_rank_vp);
            if (viewPager != null) {
                i2 = R.id.grid_item_rank_vp_view;
                RelativeLayout relativeLayout = (RelativeLayout) rootView.findViewById(R.id.grid_item_rank_vp_view);
                if (relativeLayout != null) {
                    i2 = R.id.grid_magic_indicator;
                    MagicIndicator magicIndicator = (MagicIndicator) rootView.findViewById(R.id.grid_magic_indicator);
                    if (magicIndicator != null) {
                        ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) rootView;
                        i2 = R.id.title_view;
                        View findViewById = rootView.findViewById(R.id.title_view);
                        if (findViewById != null) {
                            return new x1(themeLinearLayout, loadingTip, viewPager, relativeLayout, magicIndicator, themeLinearLayout, a2.a(findViewById));
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static x1 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static x1 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.bs_book_store_item_grid_rank, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeLinearLayout getRoot() {
        return this.f12916a;
    }
}
