package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.appbar.AppBarLayout;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeRelativeLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.libmars.ui.theme.ThemeView;
import com.martian.libmars.widget.recyclerview.LoadingTip;
import com.martian.mibook.R;
import com.martian.mibook.ui.FlexboxTagLayout;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: classes3.dex */
public final class FragmentCategoryBookListBinding implements ViewBinding {

    @NonNull
    public final AppBarLayout appbarLayout;

    @NonNull
    public final ThemeView categoryDivider;

    @NonNull
    public final CoordinatorLayout coordinator;

    @NonNull
    public final FlexboxTagLayout flexboxCategory;

    @NonNull
    public final FlexboxTagLayout flexboxComplete;

    @NonNull
    public final FlexboxTagLayout flexboxNumber;

    @NonNull
    public final FlexboxTagLayout flexboxOrder;

    @NonNull
    public final FlexboxTagLayout flexboxPublic;

    @NonNull
    public final FlexboxTagLayout flexboxStatus;

    @NonNull
    public final HorizontalScrollView hsvCategory;

    @NonNull
    public final HorizontalScrollView hsvComplete;

    @NonNull
    public final HorizontalScrollView hsvNumber;

    @NonNull
    public final HorizontalScrollView hsvOrder;

    @NonNull
    public final HorizontalScrollView hsvPublic;

    @NonNull
    public final HorizontalScrollView hsvStatus;

    @NonNull
    public final ThemeLinearLayout llCeiling;

    @NonNull
    public final LinearLayout llTopFilter;

    @NonNull
    public final RecyclerView recyclerviewTagBooks;

    @NonNull
    public final SmartRefreshLayout refreshLayout;

    @NonNull
    public final ThemeRelativeLayout rlBookContainer;

    @NonNull
    private final ThemeRelativeLayout rootView;

    @NonNull
    public final LoadingTip rvLoadedTip;

    @NonNull
    public final ThemeTextView tvFlg;

    private FragmentCategoryBookListBinding(@NonNull ThemeRelativeLayout themeRelativeLayout, @NonNull AppBarLayout appBarLayout, @NonNull ThemeView themeView, @NonNull CoordinatorLayout coordinatorLayout, @NonNull FlexboxTagLayout flexboxTagLayout, @NonNull FlexboxTagLayout flexboxTagLayout2, @NonNull FlexboxTagLayout flexboxTagLayout3, @NonNull FlexboxTagLayout flexboxTagLayout4, @NonNull FlexboxTagLayout flexboxTagLayout5, @NonNull FlexboxTagLayout flexboxTagLayout6, @NonNull HorizontalScrollView horizontalScrollView, @NonNull HorizontalScrollView horizontalScrollView2, @NonNull HorizontalScrollView horizontalScrollView3, @NonNull HorizontalScrollView horizontalScrollView4, @NonNull HorizontalScrollView horizontalScrollView5, @NonNull HorizontalScrollView horizontalScrollView6, @NonNull ThemeLinearLayout themeLinearLayout, @NonNull LinearLayout linearLayout, @NonNull RecyclerView recyclerView, @NonNull SmartRefreshLayout smartRefreshLayout, @NonNull ThemeRelativeLayout themeRelativeLayout2, @NonNull LoadingTip loadingTip, @NonNull ThemeTextView themeTextView) {
        this.rootView = themeRelativeLayout;
        this.appbarLayout = appBarLayout;
        this.categoryDivider = themeView;
        this.coordinator = coordinatorLayout;
        this.flexboxCategory = flexboxTagLayout;
        this.flexboxComplete = flexboxTagLayout2;
        this.flexboxNumber = flexboxTagLayout3;
        this.flexboxOrder = flexboxTagLayout4;
        this.flexboxPublic = flexboxTagLayout5;
        this.flexboxStatus = flexboxTagLayout6;
        this.hsvCategory = horizontalScrollView;
        this.hsvComplete = horizontalScrollView2;
        this.hsvNumber = horizontalScrollView3;
        this.hsvOrder = horizontalScrollView4;
        this.hsvPublic = horizontalScrollView5;
        this.hsvStatus = horizontalScrollView6;
        this.llCeiling = themeLinearLayout;
        this.llTopFilter = linearLayout;
        this.recyclerviewTagBooks = recyclerView;
        this.refreshLayout = smartRefreshLayout;
        this.rlBookContainer = themeRelativeLayout2;
        this.rvLoadedTip = loadingTip;
        this.tvFlg = themeTextView;
    }

    @NonNull
    public static FragmentCategoryBookListBinding bind(@NonNull View view) {
        int i10 = R.id.appbar_layout;
        AppBarLayout appBarLayout = (AppBarLayout) ViewBindings.findChildViewById(view, i10);
        if (appBarLayout != null) {
            i10 = R.id.category_divider;
            ThemeView themeView = (ThemeView) ViewBindings.findChildViewById(view, i10);
            if (themeView != null) {
                i10 = R.id.coordinator;
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) ViewBindings.findChildViewById(view, i10);
                if (coordinatorLayout != null) {
                    i10 = R.id.flexbox_category;
                    FlexboxTagLayout flexboxTagLayout = (FlexboxTagLayout) ViewBindings.findChildViewById(view, i10);
                    if (flexboxTagLayout != null) {
                        i10 = R.id.flexbox_complete;
                        FlexboxTagLayout flexboxTagLayout2 = (FlexboxTagLayout) ViewBindings.findChildViewById(view, i10);
                        if (flexboxTagLayout2 != null) {
                            i10 = R.id.flexbox_number;
                            FlexboxTagLayout flexboxTagLayout3 = (FlexboxTagLayout) ViewBindings.findChildViewById(view, i10);
                            if (flexboxTagLayout3 != null) {
                                i10 = R.id.flexbox_order;
                                FlexboxTagLayout flexboxTagLayout4 = (FlexboxTagLayout) ViewBindings.findChildViewById(view, i10);
                                if (flexboxTagLayout4 != null) {
                                    i10 = R.id.flexbox_public;
                                    FlexboxTagLayout flexboxTagLayout5 = (FlexboxTagLayout) ViewBindings.findChildViewById(view, i10);
                                    if (flexboxTagLayout5 != null) {
                                        i10 = R.id.flexbox_status;
                                        FlexboxTagLayout flexboxTagLayout6 = (FlexboxTagLayout) ViewBindings.findChildViewById(view, i10);
                                        if (flexboxTagLayout6 != null) {
                                            i10 = R.id.hsv_category;
                                            HorizontalScrollView horizontalScrollView = (HorizontalScrollView) ViewBindings.findChildViewById(view, i10);
                                            if (horizontalScrollView != null) {
                                                i10 = R.id.hsv_complete;
                                                HorizontalScrollView horizontalScrollView2 = (HorizontalScrollView) ViewBindings.findChildViewById(view, i10);
                                                if (horizontalScrollView2 != null) {
                                                    i10 = R.id.hsv_number;
                                                    HorizontalScrollView horizontalScrollView3 = (HorizontalScrollView) ViewBindings.findChildViewById(view, i10);
                                                    if (horizontalScrollView3 != null) {
                                                        i10 = R.id.hsv_order;
                                                        HorizontalScrollView horizontalScrollView4 = (HorizontalScrollView) ViewBindings.findChildViewById(view, i10);
                                                        if (horizontalScrollView4 != null) {
                                                            i10 = R.id.hsv_public;
                                                            HorizontalScrollView horizontalScrollView5 = (HorizontalScrollView) ViewBindings.findChildViewById(view, i10);
                                                            if (horizontalScrollView5 != null) {
                                                                i10 = R.id.hsv_status;
                                                                HorizontalScrollView horizontalScrollView6 = (HorizontalScrollView) ViewBindings.findChildViewById(view, i10);
                                                                if (horizontalScrollView6 != null) {
                                                                    i10 = R.id.ll_ceiling;
                                                                    ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                    if (themeLinearLayout != null) {
                                                                        i10 = R.id.ll_top_filter;
                                                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                        if (linearLayout != null) {
                                                                            i10 = R.id.recyclerview_tag_books;
                                                                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i10);
                                                                            if (recyclerView != null) {
                                                                                i10 = R.id.refreshLayout;
                                                                                SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) ViewBindings.findChildViewById(view, i10);
                                                                                if (smartRefreshLayout != null) {
                                                                                    i10 = R.id.rl_book_container;
                                                                                    ThemeRelativeLayout themeRelativeLayout = (ThemeRelativeLayout) ViewBindings.findChildViewById(view, i10);
                                                                                    if (themeRelativeLayout != null) {
                                                                                        i10 = R.id.rv_loadedTip;
                                                                                        LoadingTip loadingTip = (LoadingTip) ViewBindings.findChildViewById(view, i10);
                                                                                        if (loadingTip != null) {
                                                                                            i10 = R.id.tv_flg;
                                                                                            ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                            if (themeTextView != null) {
                                                                                                return new FragmentCategoryBookListBinding((ThemeRelativeLayout) view, appBarLayout, themeView, coordinatorLayout, flexboxTagLayout, flexboxTagLayout2, flexboxTagLayout3, flexboxTagLayout4, flexboxTagLayout5, flexboxTagLayout6, horizontalScrollView, horizontalScrollView2, horizontalScrollView3, horizontalScrollView4, horizontalScrollView5, horizontalScrollView6, themeLinearLayout, linearLayout, recyclerView, smartRefreshLayout, themeRelativeLayout, loadingTip, themeTextView);
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static FragmentCategoryBookListBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static FragmentCategoryBookListBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.fragment_category_book_list, viewGroup, false);
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
