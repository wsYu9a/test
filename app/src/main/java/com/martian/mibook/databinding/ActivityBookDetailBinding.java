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
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.appbar.AppBarLayout;
import com.martian.libmars.ui.theme.ThemeGradientExpandableTextView;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeRelativeLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.libmars.ui.theme.ThemeView;
import com.martian.libmars.widget.BookCoverImageView;
import com.martian.libmars.widget.recyclerview.LoadingTip;
import com.martian.mibook.R;
import com.martian.mibook.ui.FlexboxTagLayout;

/* loaded from: classes3.dex */
public final class ActivityBookDetailBinding implements ViewBinding {

    @NonNull
    public final ThemeImageView actionbarBack;

    @NonNull
    public final ThemeImageView actionbarDivider;

    @NonNull
    public final ThemeImageView actionbarDownload;

    @NonNull
    public final ThemeImageView actionbarMore;

    @NonNull
    public final ThemeTextView actionbarTitle;

    @NonNull
    public final ThemeView actionbarTopView;

    @NonNull
    public final AppBarLayout appbarLayout;

    @NonNull
    public final ThemeTextView bdCategory;

    @NonNull
    public final ThemeTextView bdLatestChapter;

    @NonNull
    public final ThemeTextView bdUpdateTime;

    @NonNull
    public final ThemeImageView bookChapterIcon;

    @NonNull
    public final ThemeLinearLayout bookChapterNext;

    @NonNull
    public final ThemeTextView bookChapterReadingNext;

    @NonNull
    public final ThemeTextView bookChapterTitle;

    @NonNull
    public final ThemeTextView bookCommentStatus;

    @NonNull
    public final ThemeLinearLayout bookCommentView;

    @NonNull
    public final LinearLayout bookRankView;

    @NonNull
    public final FlexboxTagLayout flexboxCategory;

    @NonNull
    public final ThemeImageView ivAddBookshelfIcon;

    @NonNull
    public final BookCoverImageView ivBookCover;

    @NonNull
    public final ThemeImageView ivCommentMore;

    @NonNull
    public final ImageView ivMyCommentVote1;

    @NonNull
    public final ImageView ivMyCommentVote2;

    @NonNull
    public final ImageView ivMyCommentVote3;

    @NonNull
    public final ImageView ivMyCommentVote4;

    @NonNull
    public final ImageView ivMyCommentVote5;

    @NonNull
    public final ThemeView ivToolbarBg;

    @NonNull
    public final ImageView ivTopBg;

    @NonNull
    public final TextView ivUpdateSign;

    @NonNull
    public final ImageView ivVote1;

    @NonNull
    public final ImageView ivVote2;

    @NonNull
    public final ImageView ivVote3;

    @NonNull
    public final ImageView ivVote4;

    @NonNull
    public final ImageView ivVote5;

    @NonNull
    public final ThemeLinearLayout llAddBookshelf;

    @NonNull
    public final ThemeLinearLayout llAudioBook;

    @NonNull
    public final ThemeLinearLayout llAuthorBooks;

    @NonNull
    public final ThemeLinearLayout llAuthorBooksMore;

    @NonNull
    public final ThemeLinearLayout llBookChapterView;

    @NonNull
    public final LinearLayout llBookInfo;

    @NonNull
    public final ThemeLinearLayout llBookSourceInfo;

    @NonNull
    public final ThemeLinearLayout llBottomBar;

    @NonNull
    public final ThemeLinearLayout llCommentNumber;

    @NonNull
    public final LinearLayout llContent;

    @NonNull
    public final ThemeLinearLayout llDir;

    @NonNull
    public final ThemeLinearLayout llRecommendBooks;

    @NonNull
    public final ThemeLinearLayout llRecommendMore;

    @NonNull
    public final ThemeLinearLayout llWholeBookComment;

    @NonNull
    public final LoadingTip loadingTip;

    @NonNull
    public final ThemeLinearLayout myCommentView;

    @NonNull
    public final LinearLayout newBookView;

    @NonNull
    public final RelativeLayout rlDownload;

    @NonNull
    public final RelativeLayout rlMore;

    @NonNull
    private final ThemeRelativeLayout rootView;

    @NonNull
    public final RecyclerView rvAuthorBooks;

    @NonNull
    public final RecyclerView rvHotComment;

    @NonNull
    public final ThemeImageView rvHotCommentDriver;

    @NonNull
    public final RecyclerView rvRecommendBooks;

    @NonNull
    public final NestedScrollView scrollViewContainer;

    @NonNull
    public final NestedScrollView scrollviewChapterContent;

    @NonNull
    public final Toolbar toolbar;

    @NonNull
    public final ThemeTextView tvActionbarMore;

    @NonNull
    public final ThemeTextView tvAddBookshelfStatus;

    @NonNull
    public final ThemeTextView tvAuthor;

    @NonNull
    public final ThemeTextView tvAuthorBooksMore;

    @NonNull
    public final ThemeTextView tvBookChapterContent;

    @NonNull
    public final ThemeTextView tvBookCreateTime;

    @NonNull
    public final ThemeTextView tvBookName;

    @NonNull
    public final ThemeTextView tvBookScore;

    @NonNull
    public final ThemeTextView tvBookSource;

    @NonNull
    public final ThemeTextView tvCategory;

    @NonNull
    public final ThemeTextView tvCommentNumber;

    @NonNull
    public final ThemeTextView tvIntroMoreView;

    @NonNull
    public final ThemeGradientExpandableTextView tvIntroText;

    @NonNull
    public final ThemeTextView tvPopularityUnit;

    @NonNull
    public final ThemeTextView tvPopularityValue;

    @NonNull
    public final TextView tvRankName;

    @NonNull
    public final TextView tvRanking;

    @NonNull
    public final ThemeTextView tvReadersCount;

    @NonNull
    public final ThemeTextView tvReadersCountUnit;

    @NonNull
    public final ThemeTextView tvReading;

    @NonNull
    public final ThemeTextView tvRecommendMore;

    @NonNull
    public final ThemeTextView tvScoreTip;

    private ActivityBookDetailBinding(@NonNull ThemeRelativeLayout themeRelativeLayout, @NonNull ThemeImageView themeImageView, @NonNull ThemeImageView themeImageView2, @NonNull ThemeImageView themeImageView3, @NonNull ThemeImageView themeImageView4, @NonNull ThemeTextView themeTextView, @NonNull ThemeView themeView, @NonNull AppBarLayout appBarLayout, @NonNull ThemeTextView themeTextView2, @NonNull ThemeTextView themeTextView3, @NonNull ThemeTextView themeTextView4, @NonNull ThemeImageView themeImageView5, @NonNull ThemeLinearLayout themeLinearLayout, @NonNull ThemeTextView themeTextView5, @NonNull ThemeTextView themeTextView6, @NonNull ThemeTextView themeTextView7, @NonNull ThemeLinearLayout themeLinearLayout2, @NonNull LinearLayout linearLayout, @NonNull FlexboxTagLayout flexboxTagLayout, @NonNull ThemeImageView themeImageView6, @NonNull BookCoverImageView bookCoverImageView, @NonNull ThemeImageView themeImageView7, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull ImageView imageView4, @NonNull ImageView imageView5, @NonNull ThemeView themeView2, @NonNull ImageView imageView6, @NonNull TextView textView, @NonNull ImageView imageView7, @NonNull ImageView imageView8, @NonNull ImageView imageView9, @NonNull ImageView imageView10, @NonNull ImageView imageView11, @NonNull ThemeLinearLayout themeLinearLayout3, @NonNull ThemeLinearLayout themeLinearLayout4, @NonNull ThemeLinearLayout themeLinearLayout5, @NonNull ThemeLinearLayout themeLinearLayout6, @NonNull ThemeLinearLayout themeLinearLayout7, @NonNull LinearLayout linearLayout2, @NonNull ThemeLinearLayout themeLinearLayout8, @NonNull ThemeLinearLayout themeLinearLayout9, @NonNull ThemeLinearLayout themeLinearLayout10, @NonNull LinearLayout linearLayout3, @NonNull ThemeLinearLayout themeLinearLayout11, @NonNull ThemeLinearLayout themeLinearLayout12, @NonNull ThemeLinearLayout themeLinearLayout13, @NonNull ThemeLinearLayout themeLinearLayout14, @NonNull LoadingTip loadingTip, @NonNull ThemeLinearLayout themeLinearLayout15, @NonNull LinearLayout linearLayout4, @NonNull RelativeLayout relativeLayout, @NonNull RelativeLayout relativeLayout2, @NonNull RecyclerView recyclerView, @NonNull RecyclerView recyclerView2, @NonNull ThemeImageView themeImageView8, @NonNull RecyclerView recyclerView3, @NonNull NestedScrollView nestedScrollView, @NonNull NestedScrollView nestedScrollView2, @NonNull Toolbar toolbar, @NonNull ThemeTextView themeTextView8, @NonNull ThemeTextView themeTextView9, @NonNull ThemeTextView themeTextView10, @NonNull ThemeTextView themeTextView11, @NonNull ThemeTextView themeTextView12, @NonNull ThemeTextView themeTextView13, @NonNull ThemeTextView themeTextView14, @NonNull ThemeTextView themeTextView15, @NonNull ThemeTextView themeTextView16, @NonNull ThemeTextView themeTextView17, @NonNull ThemeTextView themeTextView18, @NonNull ThemeTextView themeTextView19, @NonNull ThemeGradientExpandableTextView themeGradientExpandableTextView, @NonNull ThemeTextView themeTextView20, @NonNull ThemeTextView themeTextView21, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull ThemeTextView themeTextView22, @NonNull ThemeTextView themeTextView23, @NonNull ThemeTextView themeTextView24, @NonNull ThemeTextView themeTextView25, @NonNull ThemeTextView themeTextView26) {
        this.rootView = themeRelativeLayout;
        this.actionbarBack = themeImageView;
        this.actionbarDivider = themeImageView2;
        this.actionbarDownload = themeImageView3;
        this.actionbarMore = themeImageView4;
        this.actionbarTitle = themeTextView;
        this.actionbarTopView = themeView;
        this.appbarLayout = appBarLayout;
        this.bdCategory = themeTextView2;
        this.bdLatestChapter = themeTextView3;
        this.bdUpdateTime = themeTextView4;
        this.bookChapterIcon = themeImageView5;
        this.bookChapterNext = themeLinearLayout;
        this.bookChapterReadingNext = themeTextView5;
        this.bookChapterTitle = themeTextView6;
        this.bookCommentStatus = themeTextView7;
        this.bookCommentView = themeLinearLayout2;
        this.bookRankView = linearLayout;
        this.flexboxCategory = flexboxTagLayout;
        this.ivAddBookshelfIcon = themeImageView6;
        this.ivBookCover = bookCoverImageView;
        this.ivCommentMore = themeImageView7;
        this.ivMyCommentVote1 = imageView;
        this.ivMyCommentVote2 = imageView2;
        this.ivMyCommentVote3 = imageView3;
        this.ivMyCommentVote4 = imageView4;
        this.ivMyCommentVote5 = imageView5;
        this.ivToolbarBg = themeView2;
        this.ivTopBg = imageView6;
        this.ivUpdateSign = textView;
        this.ivVote1 = imageView7;
        this.ivVote2 = imageView8;
        this.ivVote3 = imageView9;
        this.ivVote4 = imageView10;
        this.ivVote5 = imageView11;
        this.llAddBookshelf = themeLinearLayout3;
        this.llAudioBook = themeLinearLayout4;
        this.llAuthorBooks = themeLinearLayout5;
        this.llAuthorBooksMore = themeLinearLayout6;
        this.llBookChapterView = themeLinearLayout7;
        this.llBookInfo = linearLayout2;
        this.llBookSourceInfo = themeLinearLayout8;
        this.llBottomBar = themeLinearLayout9;
        this.llCommentNumber = themeLinearLayout10;
        this.llContent = linearLayout3;
        this.llDir = themeLinearLayout11;
        this.llRecommendBooks = themeLinearLayout12;
        this.llRecommendMore = themeLinearLayout13;
        this.llWholeBookComment = themeLinearLayout14;
        this.loadingTip = loadingTip;
        this.myCommentView = themeLinearLayout15;
        this.newBookView = linearLayout4;
        this.rlDownload = relativeLayout;
        this.rlMore = relativeLayout2;
        this.rvAuthorBooks = recyclerView;
        this.rvHotComment = recyclerView2;
        this.rvHotCommentDriver = themeImageView8;
        this.rvRecommendBooks = recyclerView3;
        this.scrollViewContainer = nestedScrollView;
        this.scrollviewChapterContent = nestedScrollView2;
        this.toolbar = toolbar;
        this.tvActionbarMore = themeTextView8;
        this.tvAddBookshelfStatus = themeTextView9;
        this.tvAuthor = themeTextView10;
        this.tvAuthorBooksMore = themeTextView11;
        this.tvBookChapterContent = themeTextView12;
        this.tvBookCreateTime = themeTextView13;
        this.tvBookName = themeTextView14;
        this.tvBookScore = themeTextView15;
        this.tvBookSource = themeTextView16;
        this.tvCategory = themeTextView17;
        this.tvCommentNumber = themeTextView18;
        this.tvIntroMoreView = themeTextView19;
        this.tvIntroText = themeGradientExpandableTextView;
        this.tvPopularityUnit = themeTextView20;
        this.tvPopularityValue = themeTextView21;
        this.tvRankName = textView2;
        this.tvRanking = textView3;
        this.tvReadersCount = themeTextView22;
        this.tvReadersCountUnit = themeTextView23;
        this.tvReading = themeTextView24;
        this.tvRecommendMore = themeTextView25;
        this.tvScoreTip = themeTextView26;
    }

    @NonNull
    public static ActivityBookDetailBinding bind(@NonNull View view) {
        int i10 = R.id.actionbar_back;
        ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
        if (themeImageView != null) {
            i10 = R.id.actionbar_divider;
            ThemeImageView themeImageView2 = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
            if (themeImageView2 != null) {
                i10 = R.id.actionbar_download;
                ThemeImageView themeImageView3 = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                if (themeImageView3 != null) {
                    i10 = R.id.actionbar_more;
                    ThemeImageView themeImageView4 = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                    if (themeImageView4 != null) {
                        i10 = R.id.actionbar_title;
                        ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                        if (themeTextView != null) {
                            i10 = R.id.actionbar_top_view;
                            ThemeView themeView = (ThemeView) ViewBindings.findChildViewById(view, i10);
                            if (themeView != null) {
                                i10 = R.id.appbar_layout;
                                AppBarLayout appBarLayout = (AppBarLayout) ViewBindings.findChildViewById(view, i10);
                                if (appBarLayout != null) {
                                    i10 = R.id.bd_category;
                                    ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                    if (themeTextView2 != null) {
                                        i10 = R.id.bd_latest_chapter;
                                        ThemeTextView themeTextView3 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                        if (themeTextView3 != null) {
                                            i10 = R.id.bd_update_time;
                                            ThemeTextView themeTextView4 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                            if (themeTextView4 != null) {
                                                i10 = R.id.book_chapter_icon;
                                                ThemeImageView themeImageView5 = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                                                if (themeImageView5 != null) {
                                                    i10 = R.id.book_chapter_next;
                                                    ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                                    if (themeLinearLayout != null) {
                                                        i10 = R.id.book_chapter_readingNext;
                                                        ThemeTextView themeTextView5 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                        if (themeTextView5 != null) {
                                                            i10 = R.id.book_chapter_title;
                                                            ThemeTextView themeTextView6 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                            if (themeTextView6 != null) {
                                                                i10 = R.id.book_comment_status;
                                                                ThemeTextView themeTextView7 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                if (themeTextView7 != null) {
                                                                    i10 = R.id.book_comment_view;
                                                                    ThemeLinearLayout themeLinearLayout2 = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                    if (themeLinearLayout2 != null) {
                                                                        i10 = R.id.book_rank_view;
                                                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                        if (linearLayout != null) {
                                                                            i10 = R.id.flexbox_category;
                                                                            FlexboxTagLayout flexboxTagLayout = (FlexboxTagLayout) ViewBindings.findChildViewById(view, i10);
                                                                            if (flexboxTagLayout != null) {
                                                                                i10 = R.id.iv_add_bookshelf_icon;
                                                                                ThemeImageView themeImageView6 = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                                                                                if (themeImageView6 != null) {
                                                                                    i10 = R.id.iv_book_cover;
                                                                                    BookCoverImageView bookCoverImageView = (BookCoverImageView) ViewBindings.findChildViewById(view, i10);
                                                                                    if (bookCoverImageView != null) {
                                                                                        i10 = R.id.iv_comment_more;
                                                                                        ThemeImageView themeImageView7 = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                                                                                        if (themeImageView7 != null) {
                                                                                            i10 = R.id.iv_my_comment_vote1;
                                                                                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
                                                                                            if (imageView != null) {
                                                                                                i10 = R.id.iv_my_comment_vote2;
                                                                                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i10);
                                                                                                if (imageView2 != null) {
                                                                                                    i10 = R.id.iv_my_comment_vote3;
                                                                                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i10);
                                                                                                    if (imageView3 != null) {
                                                                                                        i10 = R.id.iv_my_comment_vote4;
                                                                                                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i10);
                                                                                                        if (imageView4 != null) {
                                                                                                            i10 = R.id.iv_my_comment_vote5;
                                                                                                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i10);
                                                                                                            if (imageView5 != null) {
                                                                                                                i10 = R.id.iv_toolbar_bg;
                                                                                                                ThemeView themeView2 = (ThemeView) ViewBindings.findChildViewById(view, i10);
                                                                                                                if (themeView2 != null) {
                                                                                                                    i10 = R.id.iv_top_bg;
                                                                                                                    ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, i10);
                                                                                                                    if (imageView6 != null) {
                                                                                                                        i10 = R.id.iv_update_sign;
                                                                                                                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                        if (textView != null) {
                                                                                                                            i10 = R.id.iv_vote_1;
                                                                                                                            ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view, i10);
                                                                                                                            if (imageView7 != null) {
                                                                                                                                i10 = R.id.iv_vote_2;
                                                                                                                                ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                if (imageView8 != null) {
                                                                                                                                    i10 = R.id.iv_vote_3;
                                                                                                                                    ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                    if (imageView9 != null) {
                                                                                                                                        i10 = R.id.iv_vote_4;
                                                                                                                                        ImageView imageView10 = (ImageView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                        if (imageView10 != null) {
                                                                                                                                            i10 = R.id.iv_vote_5;
                                                                                                                                            ImageView imageView11 = (ImageView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                            if (imageView11 != null) {
                                                                                                                                                i10 = R.id.ll_add_bookshelf;
                                                                                                                                                ThemeLinearLayout themeLinearLayout3 = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                if (themeLinearLayout3 != null) {
                                                                                                                                                    i10 = R.id.ll_audio_book;
                                                                                                                                                    ThemeLinearLayout themeLinearLayout4 = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                    if (themeLinearLayout4 != null) {
                                                                                                                                                        i10 = R.id.ll_author_books;
                                                                                                                                                        ThemeLinearLayout themeLinearLayout5 = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                        if (themeLinearLayout5 != null) {
                                                                                                                                                            i10 = R.id.ll_author_books_more;
                                                                                                                                                            ThemeLinearLayout themeLinearLayout6 = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                            if (themeLinearLayout6 != null) {
                                                                                                                                                                i10 = R.id.ll_book_chapter_view;
                                                                                                                                                                ThemeLinearLayout themeLinearLayout7 = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                if (themeLinearLayout7 != null) {
                                                                                                                                                                    i10 = R.id.ll_book_info;
                                                                                                                                                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                    if (linearLayout2 != null) {
                                                                                                                                                                        i10 = R.id.ll_book_source_info;
                                                                                                                                                                        ThemeLinearLayout themeLinearLayout8 = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                        if (themeLinearLayout8 != null) {
                                                                                                                                                                            i10 = R.id.ll_bottom_bar;
                                                                                                                                                                            ThemeLinearLayout themeLinearLayout9 = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                            if (themeLinearLayout9 != null) {
                                                                                                                                                                                i10 = R.id.ll_comment_number;
                                                                                                                                                                                ThemeLinearLayout themeLinearLayout10 = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                                if (themeLinearLayout10 != null) {
                                                                                                                                                                                    i10 = R.id.ll_content;
                                                                                                                                                                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                                    if (linearLayout3 != null) {
                                                                                                                                                                                        i10 = R.id.ll_dir;
                                                                                                                                                                                        ThemeLinearLayout themeLinearLayout11 = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                                        if (themeLinearLayout11 != null) {
                                                                                                                                                                                            i10 = R.id.ll_recommend_books;
                                                                                                                                                                                            ThemeLinearLayout themeLinearLayout12 = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                                            if (themeLinearLayout12 != null) {
                                                                                                                                                                                                i10 = R.id.ll_recommend_more;
                                                                                                                                                                                                ThemeLinearLayout themeLinearLayout13 = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                                                if (themeLinearLayout13 != null) {
                                                                                                                                                                                                    i10 = R.id.ll_whole_book_comment;
                                                                                                                                                                                                    ThemeLinearLayout themeLinearLayout14 = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                                                    if (themeLinearLayout14 != null) {
                                                                                                                                                                                                        i10 = R.id.loading_tip;
                                                                                                                                                                                                        LoadingTip loadingTip = (LoadingTip) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                                                        if (loadingTip != null) {
                                                                                                                                                                                                            i10 = R.id.my_comment_view;
                                                                                                                                                                                                            ThemeLinearLayout themeLinearLayout15 = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                                                            if (themeLinearLayout15 != null) {
                                                                                                                                                                                                                i10 = R.id.new_book_view;
                                                                                                                                                                                                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                                                                if (linearLayout4 != null) {
                                                                                                                                                                                                                    i10 = R.id.rl_download;
                                                                                                                                                                                                                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                                                                    if (relativeLayout != null) {
                                                                                                                                                                                                                        i10 = R.id.rl_more;
                                                                                                                                                                                                                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                                                                        if (relativeLayout2 != null) {
                                                                                                                                                                                                                            i10 = R.id.rv_author_books;
                                                                                                                                                                                                                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                                                                            if (recyclerView != null) {
                                                                                                                                                                                                                                i10 = R.id.rv_hot_comment;
                                                                                                                                                                                                                                RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                                                                                if (recyclerView2 != null) {
                                                                                                                                                                                                                                    i10 = R.id.rv_hot_comment_driver;
                                                                                                                                                                                                                                    ThemeImageView themeImageView8 = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                                                                                    if (themeImageView8 != null) {
                                                                                                                                                                                                                                        i10 = R.id.rv_recommend_books;
                                                                                                                                                                                                                                        RecyclerView recyclerView3 = (RecyclerView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                                                                                        if (recyclerView3 != null) {
                                                                                                                                                                                                                                            i10 = R.id.scroll_view_container;
                                                                                                                                                                                                                                            NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                                                                                            if (nestedScrollView != null) {
                                                                                                                                                                                                                                                i10 = R.id.scrollview_chapter_content;
                                                                                                                                                                                                                                                NestedScrollView nestedScrollView2 = (NestedScrollView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                                                                                                if (nestedScrollView2 != null) {
                                                                                                                                                                                                                                                    i10 = R.id.toolbar;
                                                                                                                                                                                                                                                    Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                                                                                                    if (toolbar != null) {
                                                                                                                                                                                                                                                        i10 = R.id.tv_actionbar_more;
                                                                                                                                                                                                                                                        ThemeTextView themeTextView8 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                                                                                                        if (themeTextView8 != null) {
                                                                                                                                                                                                                                                            i10 = R.id.tv_add_bookshelf_status;
                                                                                                                                                                                                                                                            ThemeTextView themeTextView9 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                                                                                                            if (themeTextView9 != null) {
                                                                                                                                                                                                                                                                i10 = R.id.tv_author;
                                                                                                                                                                                                                                                                ThemeTextView themeTextView10 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                                                                                                                if (themeTextView10 != null) {
                                                                                                                                                                                                                                                                    i10 = R.id.tv_author_books_more;
                                                                                                                                                                                                                                                                    ThemeTextView themeTextView11 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                                                                                                                    if (themeTextView11 != null) {
                                                                                                                                                                                                                                                                        i10 = R.id.tv_book_chapter_content;
                                                                                                                                                                                                                                                                        ThemeTextView themeTextView12 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                                                                                                                        if (themeTextView12 != null) {
                                                                                                                                                                                                                                                                            i10 = R.id.tv_book_create_time;
                                                                                                                                                                                                                                                                            ThemeTextView themeTextView13 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                                                                                                                            if (themeTextView13 != null) {
                                                                                                                                                                                                                                                                                i10 = R.id.tv_book_name;
                                                                                                                                                                                                                                                                                ThemeTextView themeTextView14 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                                                                                                                                if (themeTextView14 != null) {
                                                                                                                                                                                                                                                                                    i10 = R.id.tv_book_score;
                                                                                                                                                                                                                                                                                    ThemeTextView themeTextView15 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                                                                                                                                    if (themeTextView15 != null) {
                                                                                                                                                                                                                                                                                        i10 = R.id.tv_book_source;
                                                                                                                                                                                                                                                                                        ThemeTextView themeTextView16 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                                                                                                                                        if (themeTextView16 != null) {
                                                                                                                                                                                                                                                                                            i10 = R.id.tv_category;
                                                                                                                                                                                                                                                                                            ThemeTextView themeTextView17 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                                                                                                                                            if (themeTextView17 != null) {
                                                                                                                                                                                                                                                                                                i10 = R.id.tv_comment_number;
                                                                                                                                                                                                                                                                                                ThemeTextView themeTextView18 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                                                                                                                                                if (themeTextView18 != null) {
                                                                                                                                                                                                                                                                                                    i10 = R.id.tv_intro_more_view;
                                                                                                                                                                                                                                                                                                    ThemeTextView themeTextView19 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                                                                                                                                                    if (themeTextView19 != null) {
                                                                                                                                                                                                                                                                                                        i10 = R.id.tv_intro_text;
                                                                                                                                                                                                                                                                                                        ThemeGradientExpandableTextView themeGradientExpandableTextView = (ThemeGradientExpandableTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                                                                                                                                                        if (themeGradientExpandableTextView != null) {
                                                                                                                                                                                                                                                                                                            i10 = R.id.tv_popularity_unit;
                                                                                                                                                                                                                                                                                                            ThemeTextView themeTextView20 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                                                                                                                                                            if (themeTextView20 != null) {
                                                                                                                                                                                                                                                                                                                i10 = R.id.tv_popularity_value;
                                                                                                                                                                                                                                                                                                                ThemeTextView themeTextView21 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                                                                                                                                                                if (themeTextView21 != null) {
                                                                                                                                                                                                                                                                                                                    i10 = R.id.tv_rank_name;
                                                                                                                                                                                                                                                                                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                                                                                                                                                                    if (textView2 != null) {
                                                                                                                                                                                                                                                                                                                        i10 = R.id.tv_ranking;
                                                                                                                                                                                                                                                                                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                                                                                                                                                                        if (textView3 != null) {
                                                                                                                                                                                                                                                                                                                            i10 = R.id.tv_readers_count;
                                                                                                                                                                                                                                                                                                                            ThemeTextView themeTextView22 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                                                                                                                                                                            if (themeTextView22 != null) {
                                                                                                                                                                                                                                                                                                                                i10 = R.id.tv_readers_count_unit;
                                                                                                                                                                                                                                                                                                                                ThemeTextView themeTextView23 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                                                                                                                                                                                if (themeTextView23 != null) {
                                                                                                                                                                                                                                                                                                                                    i10 = R.id.tv_reading;
                                                                                                                                                                                                                                                                                                                                    ThemeTextView themeTextView24 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                                                                                                                                                                                    if (themeTextView24 != null) {
                                                                                                                                                                                                                                                                                                                                        i10 = R.id.tv_recommend_more;
                                                                                                                                                                                                                                                                                                                                        ThemeTextView themeTextView25 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                                                                                                                                                                                        if (themeTextView25 != null) {
                                                                                                                                                                                                                                                                                                                                            i10 = R.id.tv_score_tip;
                                                                                                                                                                                                                                                                                                                                            ThemeTextView themeTextView26 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                                                                                                                                                                                            if (themeTextView26 != null) {
                                                                                                                                                                                                                                                                                                                                                return new ActivityBookDetailBinding((ThemeRelativeLayout) view, themeImageView, themeImageView2, themeImageView3, themeImageView4, themeTextView, themeView, appBarLayout, themeTextView2, themeTextView3, themeTextView4, themeImageView5, themeLinearLayout, themeTextView5, themeTextView6, themeTextView7, themeLinearLayout2, linearLayout, flexboxTagLayout, themeImageView6, bookCoverImageView, themeImageView7, imageView, imageView2, imageView3, imageView4, imageView5, themeView2, imageView6, textView, imageView7, imageView8, imageView9, imageView10, imageView11, themeLinearLayout3, themeLinearLayout4, themeLinearLayout5, themeLinearLayout6, themeLinearLayout7, linearLayout2, themeLinearLayout8, themeLinearLayout9, themeLinearLayout10, linearLayout3, themeLinearLayout11, themeLinearLayout12, themeLinearLayout13, themeLinearLayout14, loadingTip, themeLinearLayout15, linearLayout4, relativeLayout, relativeLayout2, recyclerView, recyclerView2, themeImageView8, recyclerView3, nestedScrollView, nestedScrollView2, toolbar, themeTextView8, themeTextView9, themeTextView10, themeTextView11, themeTextView12, themeTextView13, themeTextView14, themeTextView15, themeTextView16, themeTextView17, themeTextView18, themeTextView19, themeGradientExpandableTextView, themeTextView20, themeTextView21, textView2, textView3, themeTextView22, themeTextView23, themeTextView24, themeTextView25, themeTextView26);
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
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ActivityBookDetailBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityBookDetailBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.activity_book_detail, viewGroup, false);
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
