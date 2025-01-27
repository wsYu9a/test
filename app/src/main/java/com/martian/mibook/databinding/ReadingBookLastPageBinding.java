package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.widget.smartrefresh.SmartRefreshHorizontal;
import com.martian.mibook.R;
import com.martian.mibook.ui.reader.ReaderThemeImageView;
import com.martian.mibook.ui.reader.ReaderThemeLinearLayout;
import com.martian.mibook.ui.reader.ReaderThemeSwitchButton;
import com.martian.mibook.ui.reader.ReaderThemeTextView;
import de.hdodenhof.circleimageview.CircleImageView;

/* loaded from: classes3.dex */
public final class ReadingBookLastPageBinding implements ViewBinding {

    @NonNull
    public final ReaderThemeTextView bookCommentNumber;

    @NonNull
    public final ReaderThemeTextView bookCommentStatus;

    @Nullable
    public final ReaderThemeTextView bookCommentTitle;

    @NonNull
    public final ReaderThemeLinearLayout bookCommentView;

    @Nullable
    public final ReaderThemeLinearLayout bookFriendRecommendView;

    @Nullable
    public final RelativeLayout bookFriendSwitchMore;

    @NonNull
    public final ReaderThemeTextView bookVoteScore1;

    @NonNull
    public final ReaderThemeTextView bookVoteScore2;

    @NonNull
    public final ReaderThemeTextView bookVoteScoreHint;

    @Nullable
    public final ReaderThemeLinearLayout bookwormRecommendView;

    @Nullable
    public final ReaderThemeLinearLayout endCommentView;

    @NonNull
    public final ReaderThemeLinearLayout endGoBookMallView;

    @NonNull
    public final ReaderThemeLinearLayout endGoBookShelfView;

    @Nullable
    public final ReaderThemeImageView ivAllComment;

    @Nullable
    public final CircleImageView ivBookFriendAvatar;

    @Nullable
    public final ReaderThemeImageView ivGoComment;

    @Nullable
    public final ReaderThemeImageView ivMoreComment;

    @Nullable
    public final ReaderThemeImageView ivMoreFriends;

    @NonNull
    public final ReaderThemeImageView ivMyCommentVote1;

    @NonNull
    public final ReaderThemeImageView ivMyCommentVote2;

    @NonNull
    public final ReaderThemeImageView ivMyCommentVote3;

    @NonNull
    public final ReaderThemeImageView ivMyCommentVote4;

    @NonNull
    public final ReaderThemeImageView ivMyCommentVote5;

    @NonNull
    public final LinearLayout lastPageContent;

    @Nullable
    public final LinearLayout llBookCommentNumber;

    @Nullable
    public final LinearLayout llBookVoteScore;

    @Nullable
    public final ReaderThemeLinearLayout llHotCommentListView;

    @Nullable
    public final LinearLayout llMoreComment;

    @Nullable
    public final LinearLayout llMoreFriends;

    @Nullable
    public final LinearLayout llStar;

    @Nullable
    public final ReaderThemeLinearLayout llWholeBookComment;

    @NonNull
    public final NestedScrollView nestedScrollview;

    @NonNull
    public final ReaderThemeImageView readingEndBg;

    @NonNull
    public final ReaderThemeImageView readingEndClose;

    @Nullable
    public final ReaderThemeTextView readingEndCommentDesc;

    @Nullable
    public final ReaderThemeImageView readingEndCommentIcon;

    @Nullable
    public final ReaderThemeTextView readingEndCommentNumber;

    @NonNull
    public final ReaderThemeTextView readingEndDesc;

    @NonNull
    public final ReaderThemeLinearLayout readingEndFunctionView;

    @NonNull
    public final ReaderThemeTextView readingEndTitle;

    @NonNull
    public final ReaderThemeLinearLayout recommendView;

    @Nullable
    public final RelativeLayout rlBookwormRecommend;

    @Nullable
    public final RelativeLayout rlCommentEmpty;

    @Nullable
    public final RelativeLayout rlEndComment;

    @NonNull
    public final RelativeLayout rlEndGoBookMall;

    @NonNull
    public final RelativeLayout rlEndGoBookShelf;

    @NonNull
    public final RelativeLayout rlSwitchMore;

    @NonNull
    private final SmartRefreshHorizontal rootView;

    @Nullable
    public final RecyclerView rvBookFriendGridBooks;

    @NonNull
    public final RecyclerView rvGridBooks;

    @Nullable
    public final RecyclerView rvHotComment;

    @Nullable
    public final ThemeImageView rvHotCommentDriver;

    @NonNull
    public final ReaderThemeSwitchButton switchButtonUpdateNotify;

    @Nullable
    public final ReaderThemeTextView tvBookFriendDes;

    @Nullable
    public final ReaderThemeTextView tvBookFriendRecommend;

    @Nullable
    public final ReaderThemeTextView tvBookFriendSwitchMore;

    @Nullable
    public final ReaderThemeImageView tvBookFriendSwitchMoreLoan;

    @Nullable
    public final ProgressBar tvBookFriendSwitchMoreProgressbar;

    @Nullable
    public final ReaderThemeTextView tvCommentEmpty;

    @Nullable
    public final ReaderThemeTextView tvHotCommentText;

    @Nullable
    public final ReaderThemeTextView tvMoreComment;

    @Nullable
    public final ReaderThemeTextView tvMoreFriends;

    @NonNull
    public final ReaderThemeTextView tvSwitchMore;

    @NonNull
    public final ReaderThemeImageView tvSwitchMoreLoan;

    @NonNull
    public final ProgressBar tvSwitchMoreProgressbar;

    private ReadingBookLastPageBinding(@NonNull SmartRefreshHorizontal smartRefreshHorizontal, @NonNull ReaderThemeTextView readerThemeTextView, @NonNull ReaderThemeTextView readerThemeTextView2, @Nullable ReaderThemeTextView readerThemeTextView3, @NonNull ReaderThemeLinearLayout readerThemeLinearLayout, @Nullable ReaderThemeLinearLayout readerThemeLinearLayout2, @Nullable RelativeLayout relativeLayout, @NonNull ReaderThemeTextView readerThemeTextView4, @NonNull ReaderThemeTextView readerThemeTextView5, @NonNull ReaderThemeTextView readerThemeTextView6, @Nullable ReaderThemeLinearLayout readerThemeLinearLayout3, @Nullable ReaderThemeLinearLayout readerThemeLinearLayout4, @NonNull ReaderThemeLinearLayout readerThemeLinearLayout5, @NonNull ReaderThemeLinearLayout readerThemeLinearLayout6, @Nullable ReaderThemeImageView readerThemeImageView, @Nullable CircleImageView circleImageView, @Nullable ReaderThemeImageView readerThemeImageView2, @Nullable ReaderThemeImageView readerThemeImageView3, @Nullable ReaderThemeImageView readerThemeImageView4, @NonNull ReaderThemeImageView readerThemeImageView5, @NonNull ReaderThemeImageView readerThemeImageView6, @NonNull ReaderThemeImageView readerThemeImageView7, @NonNull ReaderThemeImageView readerThemeImageView8, @NonNull ReaderThemeImageView readerThemeImageView9, @NonNull LinearLayout linearLayout, @Nullable LinearLayout linearLayout2, @Nullable LinearLayout linearLayout3, @Nullable ReaderThemeLinearLayout readerThemeLinearLayout7, @Nullable LinearLayout linearLayout4, @Nullable LinearLayout linearLayout5, @Nullable LinearLayout linearLayout6, @Nullable ReaderThemeLinearLayout readerThemeLinearLayout8, @NonNull NestedScrollView nestedScrollView, @NonNull ReaderThemeImageView readerThemeImageView10, @NonNull ReaderThemeImageView readerThemeImageView11, @Nullable ReaderThemeTextView readerThemeTextView7, @Nullable ReaderThemeImageView readerThemeImageView12, @Nullable ReaderThemeTextView readerThemeTextView8, @NonNull ReaderThemeTextView readerThemeTextView9, @NonNull ReaderThemeLinearLayout readerThemeLinearLayout9, @NonNull ReaderThemeTextView readerThemeTextView10, @NonNull ReaderThemeLinearLayout readerThemeLinearLayout10, @Nullable RelativeLayout relativeLayout2, @Nullable RelativeLayout relativeLayout3, @Nullable RelativeLayout relativeLayout4, @NonNull RelativeLayout relativeLayout5, @NonNull RelativeLayout relativeLayout6, @NonNull RelativeLayout relativeLayout7, @Nullable RecyclerView recyclerView, @NonNull RecyclerView recyclerView2, @Nullable RecyclerView recyclerView3, @Nullable ThemeImageView themeImageView, @NonNull ReaderThemeSwitchButton readerThemeSwitchButton, @Nullable ReaderThemeTextView readerThemeTextView11, @Nullable ReaderThemeTextView readerThemeTextView12, @Nullable ReaderThemeTextView readerThemeTextView13, @Nullable ReaderThemeImageView readerThemeImageView13, @Nullable ProgressBar progressBar, @Nullable ReaderThemeTextView readerThemeTextView14, @Nullable ReaderThemeTextView readerThemeTextView15, @Nullable ReaderThemeTextView readerThemeTextView16, @Nullable ReaderThemeTextView readerThemeTextView17, @NonNull ReaderThemeTextView readerThemeTextView18, @NonNull ReaderThemeImageView readerThemeImageView14, @NonNull ProgressBar progressBar2) {
        this.rootView = smartRefreshHorizontal;
        this.bookCommentNumber = readerThemeTextView;
        this.bookCommentStatus = readerThemeTextView2;
        this.bookCommentTitle = readerThemeTextView3;
        this.bookCommentView = readerThemeLinearLayout;
        this.bookFriendRecommendView = readerThemeLinearLayout2;
        this.bookFriendSwitchMore = relativeLayout;
        this.bookVoteScore1 = readerThemeTextView4;
        this.bookVoteScore2 = readerThemeTextView5;
        this.bookVoteScoreHint = readerThemeTextView6;
        this.bookwormRecommendView = readerThemeLinearLayout3;
        this.endCommentView = readerThemeLinearLayout4;
        this.endGoBookMallView = readerThemeLinearLayout5;
        this.endGoBookShelfView = readerThemeLinearLayout6;
        this.ivAllComment = readerThemeImageView;
        this.ivBookFriendAvatar = circleImageView;
        this.ivGoComment = readerThemeImageView2;
        this.ivMoreComment = readerThemeImageView3;
        this.ivMoreFriends = readerThemeImageView4;
        this.ivMyCommentVote1 = readerThemeImageView5;
        this.ivMyCommentVote2 = readerThemeImageView6;
        this.ivMyCommentVote3 = readerThemeImageView7;
        this.ivMyCommentVote4 = readerThemeImageView8;
        this.ivMyCommentVote5 = readerThemeImageView9;
        this.lastPageContent = linearLayout;
        this.llBookCommentNumber = linearLayout2;
        this.llBookVoteScore = linearLayout3;
        this.llHotCommentListView = readerThemeLinearLayout7;
        this.llMoreComment = linearLayout4;
        this.llMoreFriends = linearLayout5;
        this.llStar = linearLayout6;
        this.llWholeBookComment = readerThemeLinearLayout8;
        this.nestedScrollview = nestedScrollView;
        this.readingEndBg = readerThemeImageView10;
        this.readingEndClose = readerThemeImageView11;
        this.readingEndCommentDesc = readerThemeTextView7;
        this.readingEndCommentIcon = readerThemeImageView12;
        this.readingEndCommentNumber = readerThemeTextView8;
        this.readingEndDesc = readerThemeTextView9;
        this.readingEndFunctionView = readerThemeLinearLayout9;
        this.readingEndTitle = readerThemeTextView10;
        this.recommendView = readerThemeLinearLayout10;
        this.rlBookwormRecommend = relativeLayout2;
        this.rlCommentEmpty = relativeLayout3;
        this.rlEndComment = relativeLayout4;
        this.rlEndGoBookMall = relativeLayout5;
        this.rlEndGoBookShelf = relativeLayout6;
        this.rlSwitchMore = relativeLayout7;
        this.rvBookFriendGridBooks = recyclerView;
        this.rvGridBooks = recyclerView2;
        this.rvHotComment = recyclerView3;
        this.rvHotCommentDriver = themeImageView;
        this.switchButtonUpdateNotify = readerThemeSwitchButton;
        this.tvBookFriendDes = readerThemeTextView11;
        this.tvBookFriendRecommend = readerThemeTextView12;
        this.tvBookFriendSwitchMore = readerThemeTextView13;
        this.tvBookFriendSwitchMoreLoan = readerThemeImageView13;
        this.tvBookFriendSwitchMoreProgressbar = progressBar;
        this.tvCommentEmpty = readerThemeTextView14;
        this.tvHotCommentText = readerThemeTextView15;
        this.tvMoreComment = readerThemeTextView16;
        this.tvMoreFriends = readerThemeTextView17;
        this.tvSwitchMore = readerThemeTextView18;
        this.tvSwitchMoreLoan = readerThemeImageView14;
        this.tvSwitchMoreProgressbar = progressBar2;
    }

    @NonNull
    public static ReadingBookLastPageBinding bind(@NonNull View view) {
        int i10 = R.id.book_comment_number;
        ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
        if (readerThemeTextView != null) {
            i10 = R.id.book_comment_status;
            ReaderThemeTextView readerThemeTextView2 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
            if (readerThemeTextView2 != null) {
                ReaderThemeTextView readerThemeTextView3 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, R.id.book_comment_title);
                i10 = R.id.book_comment_view;
                ReaderThemeLinearLayout readerThemeLinearLayout = (ReaderThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                if (readerThemeLinearLayout != null) {
                    ReaderThemeLinearLayout readerThemeLinearLayout2 = (ReaderThemeLinearLayout) ViewBindings.findChildViewById(view, R.id.book_friend_recommend_view);
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.book_friend_switch_more);
                    i10 = R.id.book_vote_score_1;
                    ReaderThemeTextView readerThemeTextView4 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                    if (readerThemeTextView4 != null) {
                        i10 = R.id.book_vote_score_2;
                        ReaderThemeTextView readerThemeTextView5 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                        if (readerThemeTextView5 != null) {
                            i10 = R.id.book_vote_score_hint;
                            ReaderThemeTextView readerThemeTextView6 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                            if (readerThemeTextView6 != null) {
                                ReaderThemeLinearLayout readerThemeLinearLayout3 = (ReaderThemeLinearLayout) ViewBindings.findChildViewById(view, R.id.bookworm_recommend_view);
                                ReaderThemeLinearLayout readerThemeLinearLayout4 = (ReaderThemeLinearLayout) ViewBindings.findChildViewById(view, R.id.end_comment_view);
                                i10 = R.id.end_go_book_mall_view;
                                ReaderThemeLinearLayout readerThemeLinearLayout5 = (ReaderThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                if (readerThemeLinearLayout5 != null) {
                                    i10 = R.id.end_go_book_shelf_view;
                                    ReaderThemeLinearLayout readerThemeLinearLayout6 = (ReaderThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                    if (readerThemeLinearLayout6 != null) {
                                        ReaderThemeImageView readerThemeImageView = (ReaderThemeImageView) ViewBindings.findChildViewById(view, R.id.iv_all_comment);
                                        CircleImageView circleImageView = (CircleImageView) ViewBindings.findChildViewById(view, R.id.iv_book_friend_avatar);
                                        ReaderThemeImageView readerThemeImageView2 = (ReaderThemeImageView) ViewBindings.findChildViewById(view, R.id.iv_go_comment);
                                        ReaderThemeImageView readerThemeImageView3 = (ReaderThemeImageView) ViewBindings.findChildViewById(view, R.id.iv_more_comment);
                                        ReaderThemeImageView readerThemeImageView4 = (ReaderThemeImageView) ViewBindings.findChildViewById(view, R.id.iv_more_friends);
                                        i10 = R.id.iv_my_comment_vote_1;
                                        ReaderThemeImageView readerThemeImageView5 = (ReaderThemeImageView) ViewBindings.findChildViewById(view, i10);
                                        if (readerThemeImageView5 != null) {
                                            i10 = R.id.iv_my_comment_vote_2;
                                            ReaderThemeImageView readerThemeImageView6 = (ReaderThemeImageView) ViewBindings.findChildViewById(view, i10);
                                            if (readerThemeImageView6 != null) {
                                                i10 = R.id.iv_my_comment_vote_3;
                                                ReaderThemeImageView readerThemeImageView7 = (ReaderThemeImageView) ViewBindings.findChildViewById(view, i10);
                                                if (readerThemeImageView7 != null) {
                                                    i10 = R.id.iv_my_comment_vote_4;
                                                    ReaderThemeImageView readerThemeImageView8 = (ReaderThemeImageView) ViewBindings.findChildViewById(view, i10);
                                                    if (readerThemeImageView8 != null) {
                                                        i10 = R.id.iv_my_comment_vote_5;
                                                        ReaderThemeImageView readerThemeImageView9 = (ReaderThemeImageView) ViewBindings.findChildViewById(view, i10);
                                                        if (readerThemeImageView9 != null) {
                                                            i10 = R.id.last_page_content;
                                                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                                            if (linearLayout != null) {
                                                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.ll_book_comment_number);
                                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.ll_book_vote_score);
                                                                ReaderThemeLinearLayout readerThemeLinearLayout7 = (ReaderThemeLinearLayout) ViewBindings.findChildViewById(view, R.id.ll_hot_comment_list_view);
                                                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.ll_more_comment);
                                                                LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.ll_more_friends);
                                                                LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.ll_star);
                                                                ReaderThemeLinearLayout readerThemeLinearLayout8 = (ReaderThemeLinearLayout) ViewBindings.findChildViewById(view, R.id.ll_whole_book_comment);
                                                                i10 = R.id.nested_scrollview;
                                                                NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view, i10);
                                                                if (nestedScrollView != null) {
                                                                    i10 = R.id.reading_end_bg;
                                                                    ReaderThemeImageView readerThemeImageView10 = (ReaderThemeImageView) ViewBindings.findChildViewById(view, i10);
                                                                    if (readerThemeImageView10 != null) {
                                                                        i10 = R.id.reading_end_close;
                                                                        ReaderThemeImageView readerThemeImageView11 = (ReaderThemeImageView) ViewBindings.findChildViewById(view, i10);
                                                                        if (readerThemeImageView11 != null) {
                                                                            ReaderThemeTextView readerThemeTextView7 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, R.id.reading_end_comment_desc);
                                                                            ReaderThemeImageView readerThemeImageView12 = (ReaderThemeImageView) ViewBindings.findChildViewById(view, R.id.reading_end_comment_icon);
                                                                            ReaderThemeTextView readerThemeTextView8 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, R.id.reading_end_comment_number);
                                                                            i10 = R.id.reading_end_desc;
                                                                            ReaderThemeTextView readerThemeTextView9 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                            if (readerThemeTextView9 != null) {
                                                                                i10 = R.id.reading_end_function_view;
                                                                                ReaderThemeLinearLayout readerThemeLinearLayout9 = (ReaderThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                                if (readerThemeLinearLayout9 != null) {
                                                                                    i10 = R.id.reading_end_title;
                                                                                    ReaderThemeTextView readerThemeTextView10 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                    if (readerThemeTextView10 != null) {
                                                                                        i10 = R.id.recommend_view;
                                                                                        ReaderThemeLinearLayout readerThemeLinearLayout10 = (ReaderThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                                        if (readerThemeLinearLayout10 != null) {
                                                                                            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.rl_bookworm_recommend);
                                                                                            RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.rl_comment_empty);
                                                                                            RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.rl_end_comment);
                                                                                            i10 = R.id.rl_end_go_book_mall;
                                                                                            RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(view, i10);
                                                                                            if (relativeLayout5 != null) {
                                                                                                i10 = R.id.rl_end_go_book_shelf;
                                                                                                RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(view, i10);
                                                                                                if (relativeLayout6 != null) {
                                                                                                    i10 = R.id.rl_switch_more;
                                                                                                    RelativeLayout relativeLayout7 = (RelativeLayout) ViewBindings.findChildViewById(view, i10);
                                                                                                    if (relativeLayout7 != null) {
                                                                                                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rv_book_friend_grid_books);
                                                                                                        i10 = R.id.rv_grid_books;
                                                                                                        RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(view, i10);
                                                                                                        if (recyclerView2 != null) {
                                                                                                            RecyclerView recyclerView3 = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rv_hot_comment);
                                                                                                            ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, R.id.rv_hot_comment_driver);
                                                                                                            i10 = R.id.switch_button_update_notify;
                                                                                                            ReaderThemeSwitchButton readerThemeSwitchButton = (ReaderThemeSwitchButton) ViewBindings.findChildViewById(view, i10);
                                                                                                            if (readerThemeSwitchButton != null) {
                                                                                                                ReaderThemeTextView readerThemeTextView11 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, R.id.tv_book_friend_des);
                                                                                                                ReaderThemeTextView readerThemeTextView12 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, R.id.tv_book_friend_recommend);
                                                                                                                ReaderThemeTextView readerThemeTextView13 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, R.id.tv_book_friend_switch_more);
                                                                                                                ReaderThemeImageView readerThemeImageView13 = (ReaderThemeImageView) ViewBindings.findChildViewById(view, R.id.tv_book_friend_switch_more_loan);
                                                                                                                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.tv_book_friend_switch_more_progressbar);
                                                                                                                ReaderThemeTextView readerThemeTextView14 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, R.id.tv_comment_empty);
                                                                                                                ReaderThemeTextView readerThemeTextView15 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, R.id.tv_hot_comment_text);
                                                                                                                ReaderThemeTextView readerThemeTextView16 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, R.id.tv_more_comment);
                                                                                                                ReaderThemeTextView readerThemeTextView17 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, R.id.tv_more_friends);
                                                                                                                i10 = R.id.tv_switch_more;
                                                                                                                ReaderThemeTextView readerThemeTextView18 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                if (readerThemeTextView18 != null) {
                                                                                                                    i10 = R.id.tv_switch_more_loan;
                                                                                                                    ReaderThemeImageView readerThemeImageView14 = (ReaderThemeImageView) ViewBindings.findChildViewById(view, i10);
                                                                                                                    if (readerThemeImageView14 != null) {
                                                                                                                        i10 = R.id.tv_switch_more_progressbar;
                                                                                                                        ProgressBar progressBar2 = (ProgressBar) ViewBindings.findChildViewById(view, i10);
                                                                                                                        if (progressBar2 != null) {
                                                                                                                            return new ReadingBookLastPageBinding((SmartRefreshHorizontal) view, readerThemeTextView, readerThemeTextView2, readerThemeTextView3, readerThemeLinearLayout, readerThemeLinearLayout2, relativeLayout, readerThemeTextView4, readerThemeTextView5, readerThemeTextView6, readerThemeLinearLayout3, readerThemeLinearLayout4, readerThemeLinearLayout5, readerThemeLinearLayout6, readerThemeImageView, circleImageView, readerThemeImageView2, readerThemeImageView3, readerThemeImageView4, readerThemeImageView5, readerThemeImageView6, readerThemeImageView7, readerThemeImageView8, readerThemeImageView9, linearLayout, linearLayout2, linearLayout3, readerThemeLinearLayout7, linearLayout4, linearLayout5, linearLayout6, readerThemeLinearLayout8, nestedScrollView, readerThemeImageView10, readerThemeImageView11, readerThemeTextView7, readerThemeImageView12, readerThemeTextView8, readerThemeTextView9, readerThemeLinearLayout9, readerThemeTextView10, readerThemeLinearLayout10, relativeLayout2, relativeLayout3, relativeLayout4, relativeLayout5, relativeLayout6, relativeLayout7, recyclerView, recyclerView2, recyclerView3, themeImageView, readerThemeSwitchButton, readerThemeTextView11, readerThemeTextView12, readerThemeTextView13, readerThemeImageView13, progressBar, readerThemeTextView14, readerThemeTextView15, readerThemeTextView16, readerThemeTextView17, readerThemeTextView18, readerThemeImageView14, progressBar2);
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
    public static ReadingBookLastPageBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ReadingBookLastPageBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.reading_book_last_page, viewGroup, false);
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
