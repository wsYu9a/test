package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.widget.recyclerview.LoadingTip;
import com.martian.mibook.R;
import com.martian.mibook.ui.FlexboxTagLayout;

/* loaded from: classes3.dex */
public final class ItemBookMallTypeRankBinding implements ViewBinding {

    @NonNull
    public final FlexboxTagLayout flexboxCategory;

    @NonNull
    public final LoadingTip gridItemRankLoadingTip;

    @NonNull
    public final RelativeLayout gridItemRankVpView;

    @NonNull
    public final ThemeLinearLayout gridRankView;

    @NonNull
    public final HorizontalScrollView horizontalScrollview;

    @NonNull
    private final ThemeLinearLayout rootView;

    @NonNull
    public final BsBookStoreItemTitleBinding titleView;

    @NonNull
    public final ViewPager2 viewpager;

    private ItemBookMallTypeRankBinding(@NonNull ThemeLinearLayout themeLinearLayout, @NonNull FlexboxTagLayout flexboxTagLayout, @NonNull LoadingTip loadingTip, @NonNull RelativeLayout relativeLayout, @NonNull ThemeLinearLayout themeLinearLayout2, @NonNull HorizontalScrollView horizontalScrollView, @NonNull BsBookStoreItemTitleBinding bsBookStoreItemTitleBinding, @NonNull ViewPager2 viewPager2) {
        this.rootView = themeLinearLayout;
        this.flexboxCategory = flexboxTagLayout;
        this.gridItemRankLoadingTip = loadingTip;
        this.gridItemRankVpView = relativeLayout;
        this.gridRankView = themeLinearLayout2;
        this.horizontalScrollview = horizontalScrollView;
        this.titleView = bsBookStoreItemTitleBinding;
        this.viewpager = viewPager2;
    }

    @NonNull
    public static ItemBookMallTypeRankBinding bind(@NonNull View view) {
        View findChildViewById;
        int i10 = R.id.flexbox_category;
        FlexboxTagLayout flexboxTagLayout = (FlexboxTagLayout) ViewBindings.findChildViewById(view, i10);
        if (flexboxTagLayout != null) {
            i10 = R.id.grid_item_rank_loading_tip;
            LoadingTip loadingTip = (LoadingTip) ViewBindings.findChildViewById(view, i10);
            if (loadingTip != null) {
                i10 = R.id.grid_item_rank_vp_view;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i10);
                if (relativeLayout != null) {
                    ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) view;
                    i10 = R.id.horizontal_scrollview;
                    HorizontalScrollView horizontalScrollView = (HorizontalScrollView) ViewBindings.findChildViewById(view, i10);
                    if (horizontalScrollView != null && (findChildViewById = ViewBindings.findChildViewById(view, (i10 = R.id.title_view))) != null) {
                        BsBookStoreItemTitleBinding bind = BsBookStoreItemTitleBinding.bind(findChildViewById);
                        i10 = R.id.viewpager;
                        ViewPager2 viewPager2 = (ViewPager2) ViewBindings.findChildViewById(view, i10);
                        if (viewPager2 != null) {
                            return new ItemBookMallTypeRankBinding(themeLinearLayout, flexboxTagLayout, loadingTip, relativeLayout, themeLinearLayout, horizontalScrollView, bind, viewPager2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ItemBookMallTypeRankBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ItemBookMallTypeRankBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.item_book_mall_type_rank, viewGroup, false);
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
