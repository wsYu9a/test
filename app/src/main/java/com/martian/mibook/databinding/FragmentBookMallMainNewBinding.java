package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeRelativeLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.libmars.utils.tablayout.MagicIndicator;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class FragmentBookMallMainNewBinding implements ViewBinding {

    @NonNull
    public final AppBarLayout appbarLayout;

    @NonNull
    public final LinearLayout bookMallHeaderView;

    @NonNull
    public final MagicIndicator bookMallMagicIndicator;

    @NonNull
    public final ThemeImageView bookMallMainSearchIcon;

    @NonNull
    public final ThemeImageView btnClearSearchText;

    @NonNull
    public final CollapsingToolbarLayout collapsingToolbar;

    @NonNull
    public final CoordinatorLayout coordinator;

    @NonNull
    public final ImageView ivBookMallTopBg;

    @NonNull
    public final ViewStub readingRecord;

    @NonNull
    public final RelativeLayout rlSearch;

    @NonNull
    private final ThemeRelativeLayout rootView;

    @NonNull
    public final ThemeTextView scEditText;

    @NonNull
    public final ThemeLinearLayout searchView;

    @NonNull
    public final ViewPager2 viewpager2;

    private FragmentBookMallMainNewBinding(@NonNull ThemeRelativeLayout themeRelativeLayout, @NonNull AppBarLayout appBarLayout, @NonNull LinearLayout linearLayout, @NonNull MagicIndicator magicIndicator, @NonNull ThemeImageView themeImageView, @NonNull ThemeImageView themeImageView2, @NonNull CollapsingToolbarLayout collapsingToolbarLayout, @NonNull CoordinatorLayout coordinatorLayout, @NonNull ImageView imageView, @NonNull ViewStub viewStub, @NonNull RelativeLayout relativeLayout, @NonNull ThemeTextView themeTextView, @NonNull ThemeLinearLayout themeLinearLayout, @NonNull ViewPager2 viewPager2) {
        this.rootView = themeRelativeLayout;
        this.appbarLayout = appBarLayout;
        this.bookMallHeaderView = linearLayout;
        this.bookMallMagicIndicator = magicIndicator;
        this.bookMallMainSearchIcon = themeImageView;
        this.btnClearSearchText = themeImageView2;
        this.collapsingToolbar = collapsingToolbarLayout;
        this.coordinator = coordinatorLayout;
        this.ivBookMallTopBg = imageView;
        this.readingRecord = viewStub;
        this.rlSearch = relativeLayout;
        this.scEditText = themeTextView;
        this.searchView = themeLinearLayout;
        this.viewpager2 = viewPager2;
    }

    @NonNull
    public static FragmentBookMallMainNewBinding bind(@NonNull View view) {
        int i10 = R.id.appbar_layout;
        AppBarLayout appBarLayout = (AppBarLayout) ViewBindings.findChildViewById(view, i10);
        if (appBarLayout != null) {
            i10 = R.id.book_mall_header_view;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
            if (linearLayout != null) {
                i10 = R.id.book_mall_magic_indicator;
                MagicIndicator magicIndicator = (MagicIndicator) ViewBindings.findChildViewById(view, i10);
                if (magicIndicator != null) {
                    i10 = R.id.book_mall_main_search_icon;
                    ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                    if (themeImageView != null) {
                        i10 = R.id.btn_clear_search_text;
                        ThemeImageView themeImageView2 = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                        if (themeImageView2 != null) {
                            i10 = R.id.collapsing_toolbar;
                            CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) ViewBindings.findChildViewById(view, i10);
                            if (collapsingToolbarLayout != null) {
                                i10 = R.id.coordinator;
                                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) ViewBindings.findChildViewById(view, i10);
                                if (coordinatorLayout != null) {
                                    i10 = R.id.iv_book_mall_top_bg;
                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
                                    if (imageView != null) {
                                        i10 = R.id.reading_record;
                                        ViewStub viewStub = (ViewStub) ViewBindings.findChildViewById(view, i10);
                                        if (viewStub != null) {
                                            i10 = R.id.rl_search;
                                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i10);
                                            if (relativeLayout != null) {
                                                i10 = R.id.sc_edit_text;
                                                ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                if (themeTextView != null) {
                                                    i10 = R.id.search_view;
                                                    ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                                    if (themeLinearLayout != null) {
                                                        i10 = R.id.viewpager2;
                                                        ViewPager2 viewPager2 = (ViewPager2) ViewBindings.findChildViewById(view, i10);
                                                        if (viewPager2 != null) {
                                                            return new FragmentBookMallMainNewBinding((ThemeRelativeLayout) view, appBarLayout, linearLayout, magicIndicator, themeImageView, themeImageView2, collapsingToolbarLayout, coordinatorLayout, imageView, viewStub, relativeLayout, themeTextView, themeLinearLayout, viewPager2);
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
    public static FragmentBookMallMainNewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static FragmentBookMallMainNewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.fragment_book_mall_main_new, viewGroup, false);
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
