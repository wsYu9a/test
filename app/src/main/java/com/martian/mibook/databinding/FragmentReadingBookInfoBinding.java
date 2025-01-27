package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.mibook.R;
import com.martian.mibook.mvvm.read.widget.ReaderLoadingTip;
import com.martian.mibook.ui.FlexboxTagLayout;
import com.martian.mibook.ui.reader.ReaderGradientExpandableTextView;
import com.martian.mibook.ui.reader.ReaderThemeImageView;
import com.martian.mibook.ui.reader.ReaderThemeTextView;

/* loaded from: classes3.dex */
public final class FragmentReadingBookInfoBinding implements ViewBinding {

    @NonNull
    public final ReaderThemeTextView bdIntroMoreView;

    @NonNull
    public final ReaderGradientExpandableTextView bdIntroText;

    @NonNull
    public final ConstraintLayout bdIntroView;

    @NonNull
    public final ReaderThemeTextView bookCommentTitle;

    @NonNull
    public final FlexboxTagLayout flexboxCategory;

    @NonNull
    public final HorizontalScrollView horizontalScrollview;

    @NonNull
    public final ReaderThemeImageView ivGoComment;

    @NonNull
    public final ReaderThemeImageView ivMoreComment;

    @NonNull
    public final LinearLayout llHotCommentList;

    @NonNull
    public final LinearLayout llInfo;

    @NonNull
    public final LinearLayout llMoreComment;

    @NonNull
    public final ReaderLoadingTip loadedTip;

    @NonNull
    public final NestedScrollView nsvContent;

    @NonNull
    public final ReaderThemeTextView openBookClickCount;

    @NonNull
    public final ReaderThemeTextView openBookClickCountUnit;

    @NonNull
    public final LinearLayout openBookClickCountView;

    @NonNull
    public final LinearLayout openBookIntroView;

    @NonNull
    public final ReaderThemeTextView openBookNcomments;

    @NonNull
    public final LinearLayout openBookNcommentsView;

    @NonNull
    public final ReaderThemeTextView openBookReadingCount;

    @NonNull
    public final ReaderThemeTextView openBookReadingCountHint;

    @NonNull
    public final ReaderThemeTextView openBookReadingCountUnit;

    @NonNull
    public final RelativeLayout openBookReadingCountView;

    @NonNull
    public final ReaderThemeTextView openBookScore;

    @NonNull
    public final ReaderThemeTextView openBookScoreUnit;

    @NonNull
    public final LinearLayout openBookScoreView;

    @NonNull
    public final RelativeLayout rlEmpty;

    @NonNull
    private final RelativeLayout rootView;

    @NonNull
    public final RecyclerView rvHotComment;

    @NonNull
    public final ReaderThemeTextView tvCommentEmpty;

    @NonNull
    public final ReaderThemeTextView tvHotCommentText;

    @NonNull
    public final ReaderThemeTextView tvMoreComment;

    private FragmentReadingBookInfoBinding(@NonNull RelativeLayout relativeLayout, @NonNull ReaderThemeTextView readerThemeTextView, @NonNull ReaderGradientExpandableTextView readerGradientExpandableTextView, @NonNull ConstraintLayout constraintLayout, @NonNull ReaderThemeTextView readerThemeTextView2, @NonNull FlexboxTagLayout flexboxTagLayout, @NonNull HorizontalScrollView horizontalScrollView, @NonNull ReaderThemeImageView readerThemeImageView, @NonNull ReaderThemeImageView readerThemeImageView2, @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull LinearLayout linearLayout3, @NonNull ReaderLoadingTip readerLoadingTip, @NonNull NestedScrollView nestedScrollView, @NonNull ReaderThemeTextView readerThemeTextView3, @NonNull ReaderThemeTextView readerThemeTextView4, @NonNull LinearLayout linearLayout4, @NonNull LinearLayout linearLayout5, @NonNull ReaderThemeTextView readerThemeTextView5, @NonNull LinearLayout linearLayout6, @NonNull ReaderThemeTextView readerThemeTextView6, @NonNull ReaderThemeTextView readerThemeTextView7, @NonNull ReaderThemeTextView readerThemeTextView8, @NonNull RelativeLayout relativeLayout2, @NonNull ReaderThemeTextView readerThemeTextView9, @NonNull ReaderThemeTextView readerThemeTextView10, @NonNull LinearLayout linearLayout7, @NonNull RelativeLayout relativeLayout3, @NonNull RecyclerView recyclerView, @NonNull ReaderThemeTextView readerThemeTextView11, @NonNull ReaderThemeTextView readerThemeTextView12, @NonNull ReaderThemeTextView readerThemeTextView13) {
        this.rootView = relativeLayout;
        this.bdIntroMoreView = readerThemeTextView;
        this.bdIntroText = readerGradientExpandableTextView;
        this.bdIntroView = constraintLayout;
        this.bookCommentTitle = readerThemeTextView2;
        this.flexboxCategory = flexboxTagLayout;
        this.horizontalScrollview = horizontalScrollView;
        this.ivGoComment = readerThemeImageView;
        this.ivMoreComment = readerThemeImageView2;
        this.llHotCommentList = linearLayout;
        this.llInfo = linearLayout2;
        this.llMoreComment = linearLayout3;
        this.loadedTip = readerLoadingTip;
        this.nsvContent = nestedScrollView;
        this.openBookClickCount = readerThemeTextView3;
        this.openBookClickCountUnit = readerThemeTextView4;
        this.openBookClickCountView = linearLayout4;
        this.openBookIntroView = linearLayout5;
        this.openBookNcomments = readerThemeTextView5;
        this.openBookNcommentsView = linearLayout6;
        this.openBookReadingCount = readerThemeTextView6;
        this.openBookReadingCountHint = readerThemeTextView7;
        this.openBookReadingCountUnit = readerThemeTextView8;
        this.openBookReadingCountView = relativeLayout2;
        this.openBookScore = readerThemeTextView9;
        this.openBookScoreUnit = readerThemeTextView10;
        this.openBookScoreView = linearLayout7;
        this.rlEmpty = relativeLayout3;
        this.rvHotComment = recyclerView;
        this.tvCommentEmpty = readerThemeTextView11;
        this.tvHotCommentText = readerThemeTextView12;
        this.tvMoreComment = readerThemeTextView13;
    }

    @NonNull
    public static FragmentReadingBookInfoBinding bind(@NonNull View view) {
        int i10 = R.id.bd_intro_more_view;
        ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
        if (readerThemeTextView != null) {
            i10 = R.id.bd_intro_text;
            ReaderGradientExpandableTextView readerGradientExpandableTextView = (ReaderGradientExpandableTextView) ViewBindings.findChildViewById(view, i10);
            if (readerGradientExpandableTextView != null) {
                i10 = R.id.bd_intro_view;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i10);
                if (constraintLayout != null) {
                    i10 = R.id.book_comment_title;
                    ReaderThemeTextView readerThemeTextView2 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                    if (readerThemeTextView2 != null) {
                        i10 = R.id.flexbox_category;
                        FlexboxTagLayout flexboxTagLayout = (FlexboxTagLayout) ViewBindings.findChildViewById(view, i10);
                        if (flexboxTagLayout != null) {
                            i10 = R.id.horizontal_scrollview;
                            HorizontalScrollView horizontalScrollView = (HorizontalScrollView) ViewBindings.findChildViewById(view, i10);
                            if (horizontalScrollView != null) {
                                i10 = R.id.iv_go_comment;
                                ReaderThemeImageView readerThemeImageView = (ReaderThemeImageView) ViewBindings.findChildViewById(view, i10);
                                if (readerThemeImageView != null) {
                                    i10 = R.id.iv_more_comment;
                                    ReaderThemeImageView readerThemeImageView2 = (ReaderThemeImageView) ViewBindings.findChildViewById(view, i10);
                                    if (readerThemeImageView2 != null) {
                                        i10 = R.id.ll_hot_comment_list;
                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                        if (linearLayout != null) {
                                            i10 = R.id.ll_info;
                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                            if (linearLayout2 != null) {
                                                i10 = R.id.ll_more_comment;
                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                                if (linearLayout3 != null) {
                                                    i10 = R.id.loadedTip;
                                                    ReaderLoadingTip readerLoadingTip = (ReaderLoadingTip) ViewBindings.findChildViewById(view, i10);
                                                    if (readerLoadingTip != null) {
                                                        i10 = R.id.nsv_content;
                                                        NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view, i10);
                                                        if (nestedScrollView != null) {
                                                            i10 = R.id.open_book_click_count;
                                                            ReaderThemeTextView readerThemeTextView3 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                            if (readerThemeTextView3 != null) {
                                                                i10 = R.id.open_book_click_count_unit;
                                                                ReaderThemeTextView readerThemeTextView4 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                if (readerThemeTextView4 != null) {
                                                                    i10 = R.id.open_book_click_count_view;
                                                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                    if (linearLayout4 != null) {
                                                                        i10 = R.id.open_book_intro_view;
                                                                        LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                        if (linearLayout5 != null) {
                                                                            i10 = R.id.open_book_ncomments;
                                                                            ReaderThemeTextView readerThemeTextView5 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                            if (readerThemeTextView5 != null) {
                                                                                i10 = R.id.open_book_ncomments_view;
                                                                                LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                                if (linearLayout6 != null) {
                                                                                    i10 = R.id.open_book_reading_count;
                                                                                    ReaderThemeTextView readerThemeTextView6 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                    if (readerThemeTextView6 != null) {
                                                                                        i10 = R.id.open_book_reading_count_hint;
                                                                                        ReaderThemeTextView readerThemeTextView7 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                        if (readerThemeTextView7 != null) {
                                                                                            i10 = R.id.open_book_reading_count_unit;
                                                                                            ReaderThemeTextView readerThemeTextView8 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                            if (readerThemeTextView8 != null) {
                                                                                                i10 = R.id.open_book_reading_count_view;
                                                                                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i10);
                                                                                                if (relativeLayout != null) {
                                                                                                    i10 = R.id.open_book_score;
                                                                                                    ReaderThemeTextView readerThemeTextView9 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                    if (readerThemeTextView9 != null) {
                                                                                                        i10 = R.id.open_book_score_unit;
                                                                                                        ReaderThemeTextView readerThemeTextView10 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                        if (readerThemeTextView10 != null) {
                                                                                                            i10 = R.id.open_book_score_view;
                                                                                                            LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                                                            if (linearLayout7 != null) {
                                                                                                                i10 = R.id.rl_empty;
                                                                                                                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i10);
                                                                                                                if (relativeLayout2 != null) {
                                                                                                                    i10 = R.id.rv_hot_comment;
                                                                                                                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i10);
                                                                                                                    if (recyclerView != null) {
                                                                                                                        i10 = R.id.tv_comment_empty;
                                                                                                                        ReaderThemeTextView readerThemeTextView11 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                        if (readerThemeTextView11 != null) {
                                                                                                                            i10 = R.id.tv_hot_comment_text;
                                                                                                                            ReaderThemeTextView readerThemeTextView12 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                            if (readerThemeTextView12 != null) {
                                                                                                                                i10 = R.id.tv_more_comment;
                                                                                                                                ReaderThemeTextView readerThemeTextView13 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                if (readerThemeTextView13 != null) {
                                                                                                                                    return new FragmentReadingBookInfoBinding((RelativeLayout) view, readerThemeTextView, readerGradientExpandableTextView, constraintLayout, readerThemeTextView2, flexboxTagLayout, horizontalScrollView, readerThemeImageView, readerThemeImageView2, linearLayout, linearLayout2, linearLayout3, readerLoadingTip, nestedScrollView, readerThemeTextView3, readerThemeTextView4, linearLayout4, linearLayout5, readerThemeTextView5, linearLayout6, readerThemeTextView6, readerThemeTextView7, readerThemeTextView8, relativeLayout, readerThemeTextView9, readerThemeTextView10, linearLayout7, relativeLayout2, recyclerView, readerThemeTextView11, readerThemeTextView12, readerThemeTextView13);
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
    public static FragmentReadingBookInfoBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static FragmentReadingBookInfoBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.fragment_reading_book_info, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
