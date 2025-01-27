package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeGridView;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.libmars.utils.tablayout.MagicIndicator;
import com.martian.libmars.widget.recyclerview.LoadingTip;
import com.martian.mibook.R;
import com.martian.mibook.ui.FlowLayout;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: classes3.dex */
public final class ActivitySearchBookBinding implements ViewBinding {

    @NonNull
    public final ThemeLinearLayout buttonFilter;

    @NonNull
    public final MagicIndicator filterOrder;

    @NonNull
    public final FlowLayout flSearchSearchHistory;

    @NonNull
    public final FlowLayout flSearchTags;

    @NonNull
    public final ThemeGridView gvHotBooks;

    @NonNull
    public final LinearLayout hotTagsView;

    @NonNull
    public final ThemeImageView ivFilter;

    @NonNull
    public final ThemeLinearLayout llHotSearchRank;

    @NonNull
    public final LinearLayout llSearchFilter;

    @NonNull
    public final LoadingTip loadingTipSearchBooks;

    @NonNull
    public final NestedScrollView nsvContent;

    @NonNull
    public final SmartRefreshLayout refreshLayout;

    @NonNull
    public final RelativeLayout rlSearchBooksView;

    @NonNull
    private final ThemeLinearLayout rootView;

    @NonNull
    public final RecyclerView rvSearchBooks;

    @NonNull
    public final RecyclerView rvSearchRecommendKeywords;

    @NonNull
    public final ConstraintLayout searchFindView;

    @NonNull
    public final ConstraintLayout searchHistoryView;

    @NonNull
    public final LinearLayout searchResultContainer;

    @NonNull
    public final ThemeImageView spClear;

    @NonNull
    public final TextView tvFilterCount;

    @NonNull
    public final ThemeTextView tvHotTags;

    @NonNull
    public final ThemeTextView tvSearchFind;

    @NonNull
    public final ThemeTextView tvSearchHistory;

    @NonNull
    public final ViewStub viewStubFilterView;

    private ActivitySearchBookBinding(@NonNull ThemeLinearLayout themeLinearLayout, @NonNull ThemeLinearLayout themeLinearLayout2, @NonNull MagicIndicator magicIndicator, @NonNull FlowLayout flowLayout, @NonNull FlowLayout flowLayout2, @NonNull ThemeGridView themeGridView, @NonNull LinearLayout linearLayout, @NonNull ThemeImageView themeImageView, @NonNull ThemeLinearLayout themeLinearLayout3, @NonNull LinearLayout linearLayout2, @NonNull LoadingTip loadingTip, @NonNull NestedScrollView nestedScrollView, @NonNull SmartRefreshLayout smartRefreshLayout, @NonNull RelativeLayout relativeLayout, @NonNull RecyclerView recyclerView, @NonNull RecyclerView recyclerView2, @NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull LinearLayout linearLayout3, @NonNull ThemeImageView themeImageView2, @NonNull TextView textView, @NonNull ThemeTextView themeTextView, @NonNull ThemeTextView themeTextView2, @NonNull ThemeTextView themeTextView3, @NonNull ViewStub viewStub) {
        this.rootView = themeLinearLayout;
        this.buttonFilter = themeLinearLayout2;
        this.filterOrder = magicIndicator;
        this.flSearchSearchHistory = flowLayout;
        this.flSearchTags = flowLayout2;
        this.gvHotBooks = themeGridView;
        this.hotTagsView = linearLayout;
        this.ivFilter = themeImageView;
        this.llHotSearchRank = themeLinearLayout3;
        this.llSearchFilter = linearLayout2;
        this.loadingTipSearchBooks = loadingTip;
        this.nsvContent = nestedScrollView;
        this.refreshLayout = smartRefreshLayout;
        this.rlSearchBooksView = relativeLayout;
        this.rvSearchBooks = recyclerView;
        this.rvSearchRecommendKeywords = recyclerView2;
        this.searchFindView = constraintLayout;
        this.searchHistoryView = constraintLayout2;
        this.searchResultContainer = linearLayout3;
        this.spClear = themeImageView2;
        this.tvFilterCount = textView;
        this.tvHotTags = themeTextView;
        this.tvSearchFind = themeTextView2;
        this.tvSearchHistory = themeTextView3;
        this.viewStubFilterView = viewStub;
    }

    @NonNull
    public static ActivitySearchBookBinding bind(@NonNull View view) {
        int i10 = R.id.button_filter;
        ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
        if (themeLinearLayout != null) {
            i10 = R.id.filter_order;
            MagicIndicator magicIndicator = (MagicIndicator) ViewBindings.findChildViewById(view, i10);
            if (magicIndicator != null) {
                i10 = R.id.fl_search_search_history;
                FlowLayout flowLayout = (FlowLayout) ViewBindings.findChildViewById(view, i10);
                if (flowLayout != null) {
                    i10 = R.id.fl_search_tags;
                    FlowLayout flowLayout2 = (FlowLayout) ViewBindings.findChildViewById(view, i10);
                    if (flowLayout2 != null) {
                        i10 = R.id.gv_hot_books;
                        ThemeGridView themeGridView = (ThemeGridView) ViewBindings.findChildViewById(view, i10);
                        if (themeGridView != null) {
                            i10 = R.id.hot_tags_view;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                            if (linearLayout != null) {
                                i10 = R.id.iv_filter;
                                ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                                if (themeImageView != null) {
                                    i10 = R.id.ll_hot_search_rank;
                                    ThemeLinearLayout themeLinearLayout2 = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                    if (themeLinearLayout2 != null) {
                                        i10 = R.id.ll_search_filter;
                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                        if (linearLayout2 != null) {
                                            i10 = R.id.loading_tip_search_books;
                                            LoadingTip loadingTip = (LoadingTip) ViewBindings.findChildViewById(view, i10);
                                            if (loadingTip != null) {
                                                i10 = R.id.nsv_content;
                                                NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view, i10);
                                                if (nestedScrollView != null) {
                                                    i10 = R.id.refresh_layout;
                                                    SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) ViewBindings.findChildViewById(view, i10);
                                                    if (smartRefreshLayout != null) {
                                                        i10 = R.id.rl_search_books_view;
                                                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i10);
                                                        if (relativeLayout != null) {
                                                            i10 = R.id.rv_search_books;
                                                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i10);
                                                            if (recyclerView != null) {
                                                                i10 = R.id.rv_search_recommend_keywords;
                                                                RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(view, i10);
                                                                if (recyclerView2 != null) {
                                                                    i10 = R.id.search_find_view;
                                                                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i10);
                                                                    if (constraintLayout != null) {
                                                                        i10 = R.id.search_history_view;
                                                                        ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i10);
                                                                        if (constraintLayout2 != null) {
                                                                            i10 = R.id.search_result_container;
                                                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                            if (linearLayout3 != null) {
                                                                                i10 = R.id.sp_clear;
                                                                                ThemeImageView themeImageView2 = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                                                                                if (themeImageView2 != null) {
                                                                                    i10 = R.id.tv_filter_count;
                                                                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
                                                                                    if (textView != null) {
                                                                                        i10 = R.id.tv_hot_tags;
                                                                                        ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                        if (themeTextView != null) {
                                                                                            i10 = R.id.tv_search_find;
                                                                                            ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                            if (themeTextView2 != null) {
                                                                                                i10 = R.id.tv_search_history;
                                                                                                ThemeTextView themeTextView3 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                if (themeTextView3 != null) {
                                                                                                    i10 = R.id.view_stub_filter_view;
                                                                                                    ViewStub viewStub = (ViewStub) ViewBindings.findChildViewById(view, i10);
                                                                                                    if (viewStub != null) {
                                                                                                        return new ActivitySearchBookBinding((ThemeLinearLayout) view, themeLinearLayout, magicIndicator, flowLayout, flowLayout2, themeGridView, linearLayout, themeImageView, themeLinearLayout2, linearLayout2, loadingTip, nestedScrollView, smartRefreshLayout, relativeLayout, recyclerView, recyclerView2, constraintLayout, constraintLayout2, linearLayout3, themeImageView2, textView, themeTextView, themeTextView2, themeTextView3, viewStub);
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
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ActivitySearchBookBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivitySearchBookBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.activity_search_book, viewGroup, false);
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
