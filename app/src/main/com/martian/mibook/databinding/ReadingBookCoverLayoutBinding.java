package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.widget.BookCoverImageView;
import com.martian.libmars.widget.NestedHorizontalScrollView;
import com.martian.libmars.widget.smartrefresh.SmartRefreshHorizontal;
import com.martian.mibook.R;
import com.martian.mibook.ui.FlexboxTagLayout;
import com.martian.mibook.ui.reader.ReaderFoldedTextView;
import com.martian.mibook.ui.reader.ReaderThemeImageView;
import com.martian.mibook.ui.reader.ReaderThemeLinearLayout;
import com.martian.mibook.ui.reader.ReaderThemeTextView;

/* loaded from: classes3.dex */
public final class ReadingBookCoverLayoutBinding implements ViewBinding {

    @NonNull
    public final ReaderThemeLinearLayout addShelfGuideView;

    @NonNull
    public final ReaderThemeImageView bgBookCover;

    @NonNull
    public final BookCoverImageView bookCover;

    @NonNull
    public final LinearLayout bookRankView;

    @NonNull
    public final LinearLayout bottomLayout;

    @NonNull
    public final ReaderThemeLinearLayout coverHeaderView;

    @NonNull
    public final FlexboxTagLayout flexboxCategory;

    @NonNull
    public final ReaderFoldedTextView foldTextviewIntroduction;

    @NonNull
    public final RelativeLayout headerLayout;

    @NonNull
    public final NestedHorizontalScrollView horizontalScrollview;

    @NonNull
    public final LinearLayout hotCommentsTitle;

    @NonNull
    public final LinearLayout hotCommentsView;

    @NonNull
    public final ReaderThemeImageView ivMoreComment;

    @NonNull
    public final ReaderThemeImageView ivSlide;

    @NonNull
    public final LinearLayout llHotCommentList;

    @NonNull
    public final LinearLayout llMoreComment;

    @NonNull
    public final ReaderThemeTextView openBookAuthor;

    @NonNull
    public final ReaderThemeTextView openBookClickCount;

    @NonNull
    public final ReaderThemeTextView openBookClickCountUnit;

    @NonNull
    public final LinearLayout openBookClickCountView;

    @NonNull
    public final ImageView openBookCoverShadow;

    @NonNull
    public final LinearLayout openBookIntroView;

    @NonNull
    public final ReaderThemeTextView openBookName;

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
    public final RelativeLayout rlCover;

    @NonNull
    private final SmartRefreshHorizontal rootView;

    @NonNull
    public final ReaderThemeLinearLayout slideGuideView;

    @NonNull
    public final ReaderThemeTextView tvMoreComment;

    @NonNull
    public final ReaderThemeTextView tvRankName;

    @NonNull
    public final ReaderThemeTextView tvRanking;

    @NonNull
    public final ReaderThemeTextView tvSlideText;

    @NonNull
    public final TextView tvUpdateSign;

    private ReadingBookCoverLayoutBinding(@NonNull SmartRefreshHorizontal smartRefreshHorizontal, @NonNull ReaderThemeLinearLayout readerThemeLinearLayout, @NonNull ReaderThemeImageView readerThemeImageView, @NonNull BookCoverImageView bookCoverImageView, @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull ReaderThemeLinearLayout readerThemeLinearLayout2, @NonNull FlexboxTagLayout flexboxTagLayout, @NonNull ReaderFoldedTextView readerFoldedTextView, @NonNull RelativeLayout relativeLayout, @NonNull NestedHorizontalScrollView nestedHorizontalScrollView, @NonNull LinearLayout linearLayout3, @NonNull LinearLayout linearLayout4, @NonNull ReaderThemeImageView readerThemeImageView2, @NonNull ReaderThemeImageView readerThemeImageView3, @NonNull LinearLayout linearLayout5, @NonNull LinearLayout linearLayout6, @NonNull ReaderThemeTextView readerThemeTextView, @NonNull ReaderThemeTextView readerThemeTextView2, @NonNull ReaderThemeTextView readerThemeTextView3, @NonNull LinearLayout linearLayout7, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout8, @NonNull ReaderThemeTextView readerThemeTextView4, @NonNull ReaderThemeTextView readerThemeTextView5, @NonNull LinearLayout linearLayout9, @NonNull ReaderThemeTextView readerThemeTextView6, @NonNull ReaderThemeTextView readerThemeTextView7, @NonNull ReaderThemeTextView readerThemeTextView8, @NonNull RelativeLayout relativeLayout2, @NonNull ReaderThemeTextView readerThemeTextView9, @NonNull ReaderThemeTextView readerThemeTextView10, @NonNull LinearLayout linearLayout10, @NonNull RelativeLayout relativeLayout3, @NonNull ReaderThemeLinearLayout readerThemeLinearLayout3, @NonNull ReaderThemeTextView readerThemeTextView11, @NonNull ReaderThemeTextView readerThemeTextView12, @NonNull ReaderThemeTextView readerThemeTextView13, @NonNull ReaderThemeTextView readerThemeTextView14, @NonNull TextView textView) {
        this.rootView = smartRefreshHorizontal;
        this.addShelfGuideView = readerThemeLinearLayout;
        this.bgBookCover = readerThemeImageView;
        this.bookCover = bookCoverImageView;
        this.bookRankView = linearLayout;
        this.bottomLayout = linearLayout2;
        this.coverHeaderView = readerThemeLinearLayout2;
        this.flexboxCategory = flexboxTagLayout;
        this.foldTextviewIntroduction = readerFoldedTextView;
        this.headerLayout = relativeLayout;
        this.horizontalScrollview = nestedHorizontalScrollView;
        this.hotCommentsTitle = linearLayout3;
        this.hotCommentsView = linearLayout4;
        this.ivMoreComment = readerThemeImageView2;
        this.ivSlide = readerThemeImageView3;
        this.llHotCommentList = linearLayout5;
        this.llMoreComment = linearLayout6;
        this.openBookAuthor = readerThemeTextView;
        this.openBookClickCount = readerThemeTextView2;
        this.openBookClickCountUnit = readerThemeTextView3;
        this.openBookClickCountView = linearLayout7;
        this.openBookCoverShadow = imageView;
        this.openBookIntroView = linearLayout8;
        this.openBookName = readerThemeTextView4;
        this.openBookNcomments = readerThemeTextView5;
        this.openBookNcommentsView = linearLayout9;
        this.openBookReadingCount = readerThemeTextView6;
        this.openBookReadingCountHint = readerThemeTextView7;
        this.openBookReadingCountUnit = readerThemeTextView8;
        this.openBookReadingCountView = relativeLayout2;
        this.openBookScore = readerThemeTextView9;
        this.openBookScoreUnit = readerThemeTextView10;
        this.openBookScoreView = linearLayout10;
        this.rlCover = relativeLayout3;
        this.slideGuideView = readerThemeLinearLayout3;
        this.tvMoreComment = readerThemeTextView11;
        this.tvRankName = readerThemeTextView12;
        this.tvRanking = readerThemeTextView13;
        this.tvSlideText = readerThemeTextView14;
        this.tvUpdateSign = textView;
    }

    @NonNull
    public static ReadingBookCoverLayoutBinding bind(@NonNull View view) {
        int i10 = R.id.add_shelf_guide_view;
        ReaderThemeLinearLayout readerThemeLinearLayout = (ReaderThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
        if (readerThemeLinearLayout != null) {
            i10 = R.id.bg_book_cover;
            ReaderThemeImageView readerThemeImageView = (ReaderThemeImageView) ViewBindings.findChildViewById(view, i10);
            if (readerThemeImageView != null) {
                i10 = R.id.book_cover;
                BookCoverImageView bookCoverImageView = (BookCoverImageView) ViewBindings.findChildViewById(view, i10);
                if (bookCoverImageView != null) {
                    i10 = R.id.book_rank_view;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                    if (linearLayout != null) {
                        i10 = R.id.bottom_layout;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                        if (linearLayout2 != null) {
                            i10 = R.id.cover_header_view;
                            ReaderThemeLinearLayout readerThemeLinearLayout2 = (ReaderThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                            if (readerThemeLinearLayout2 != null) {
                                i10 = R.id.flexbox_category;
                                FlexboxTagLayout flexboxTagLayout = (FlexboxTagLayout) ViewBindings.findChildViewById(view, i10);
                                if (flexboxTagLayout != null) {
                                    i10 = R.id.fold_textview_introduction;
                                    ReaderFoldedTextView readerFoldedTextView = (ReaderFoldedTextView) ViewBindings.findChildViewById(view, i10);
                                    if (readerFoldedTextView != null) {
                                        i10 = R.id.header_layout;
                                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i10);
                                        if (relativeLayout != null) {
                                            i10 = R.id.horizontal_scrollview;
                                            NestedHorizontalScrollView nestedHorizontalScrollView = (NestedHorizontalScrollView) ViewBindings.findChildViewById(view, i10);
                                            if (nestedHorizontalScrollView != null) {
                                                i10 = R.id.hot_comments_title;
                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                                if (linearLayout3 != null) {
                                                    i10 = R.id.hot_comments_view;
                                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                                    if (linearLayout4 != null) {
                                                        i10 = R.id.iv_more_comment;
                                                        ReaderThemeImageView readerThemeImageView2 = (ReaderThemeImageView) ViewBindings.findChildViewById(view, i10);
                                                        if (readerThemeImageView2 != null) {
                                                            i10 = R.id.iv_slide;
                                                            ReaderThemeImageView readerThemeImageView3 = (ReaderThemeImageView) ViewBindings.findChildViewById(view, i10);
                                                            if (readerThemeImageView3 != null) {
                                                                i10 = R.id.ll_hot_comment_list;
                                                                LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                if (linearLayout5 != null) {
                                                                    i10 = R.id.ll_more_comment;
                                                                    LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                    if (linearLayout6 != null) {
                                                                        i10 = R.id.open_book_author;
                                                                        ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                        if (readerThemeTextView != null) {
                                                                            i10 = R.id.open_book_click_count;
                                                                            ReaderThemeTextView readerThemeTextView2 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                            if (readerThemeTextView2 != null) {
                                                                                i10 = R.id.open_book_click_count_unit;
                                                                                ReaderThemeTextView readerThemeTextView3 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                if (readerThemeTextView3 != null) {
                                                                                    i10 = R.id.open_book_click_count_view;
                                                                                    LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                                    if (linearLayout7 != null) {
                                                                                        i10 = R.id.open_book_cover_shadow;
                                                                                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
                                                                                        if (imageView != null) {
                                                                                            i10 = R.id.open_book_intro_view;
                                                                                            LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                                            if (linearLayout8 != null) {
                                                                                                i10 = R.id.open_book_name;
                                                                                                ReaderThemeTextView readerThemeTextView4 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                if (readerThemeTextView4 != null) {
                                                                                                    i10 = R.id.open_book_ncomments;
                                                                                                    ReaderThemeTextView readerThemeTextView5 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                    if (readerThemeTextView5 != null) {
                                                                                                        i10 = R.id.open_book_ncomments_view;
                                                                                                        LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                                                        if (linearLayout9 != null) {
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
                                                                                                                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i10);
                                                                                                                        if (relativeLayout2 != null) {
                                                                                                                            i10 = R.id.open_book_score;
                                                                                                                            ReaderThemeTextView readerThemeTextView9 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                            if (readerThemeTextView9 != null) {
                                                                                                                                i10 = R.id.open_book_score_unit;
                                                                                                                                ReaderThemeTextView readerThemeTextView10 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                if (readerThemeTextView10 != null) {
                                                                                                                                    i10 = R.id.open_book_score_view;
                                                                                                                                    LinearLayout linearLayout10 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                                                                                    if (linearLayout10 != null) {
                                                                                                                                        i10 = R.id.rl_cover;
                                                                                                                                        RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, i10);
                                                                                                                                        if (relativeLayout3 != null) {
                                                                                                                                            i10 = R.id.slide_guide_view;
                                                                                                                                            ReaderThemeLinearLayout readerThemeLinearLayout3 = (ReaderThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                                                                                            if (readerThemeLinearLayout3 != null) {
                                                                                                                                                i10 = R.id.tv_more_comment;
                                                                                                                                                ReaderThemeTextView readerThemeTextView11 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                if (readerThemeTextView11 != null) {
                                                                                                                                                    i10 = R.id.tv_rank_name;
                                                                                                                                                    ReaderThemeTextView readerThemeTextView12 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                    if (readerThemeTextView12 != null) {
                                                                                                                                                        i10 = R.id.tv_ranking;
                                                                                                                                                        ReaderThemeTextView readerThemeTextView13 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                        if (readerThemeTextView13 != null) {
                                                                                                                                                            i10 = R.id.tv_slide_text;
                                                                                                                                                            ReaderThemeTextView readerThemeTextView14 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                            if (readerThemeTextView14 != null) {
                                                                                                                                                                i10 = R.id.tv_update_sign;
                                                                                                                                                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                if (textView != null) {
                                                                                                                                                                    return new ReadingBookCoverLayoutBinding((SmartRefreshHorizontal) view, readerThemeLinearLayout, readerThemeImageView, bookCoverImageView, linearLayout, linearLayout2, readerThemeLinearLayout2, flexboxTagLayout, readerFoldedTextView, relativeLayout, nestedHorizontalScrollView, linearLayout3, linearLayout4, readerThemeImageView2, readerThemeImageView3, linearLayout5, linearLayout6, readerThemeTextView, readerThemeTextView2, readerThemeTextView3, linearLayout7, imageView, linearLayout8, readerThemeTextView4, readerThemeTextView5, linearLayout9, readerThemeTextView6, readerThemeTextView7, readerThemeTextView8, relativeLayout2, readerThemeTextView9, readerThemeTextView10, linearLayout10, relativeLayout3, readerThemeLinearLayout3, readerThemeTextView11, readerThemeTextView12, readerThemeTextView13, readerThemeTextView14, textView);
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
    public static ReadingBookCoverLayoutBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ReadingBookCoverLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.reading_book_cover_layout, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public SmartRefreshHorizontal getRoot() {
        return this.rootView;
    }
}
