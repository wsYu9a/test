package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.utils.tablayout.MagicIndicator;
import com.martian.libmars.widget.RoundedLayout;
import com.martian.mibook.R;
import com.martian.mibook.mvvm.read.widget.ReaderLoadingTip;
import com.martian.mibook.ui.reader.ReaderThemeImageView;
import com.martian.mibook.ui.reader.ReaderThemeLinearLayout;
import com.martian.mibook.ui.reader.ReaderThemeTextView;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: classes3.dex */
public final class DialogReaderCommentFragmentBinding implements ViewBinding {

    @NonNull
    public final ReaderThemeTextView bookCommentScoreTips;

    @NonNull
    public final ReaderThemeTextView bookCommentStatus;

    @NonNull
    public final ReaderThemeLinearLayout bookCommentView;

    @NonNull
    public final ReaderThemeImageView bookCommentVote1;

    @NonNull
    public final ReaderThemeImageView bookCommentVote2;

    @NonNull
    public final ReaderThemeImageView bookCommentVote3;

    @NonNull
    public final ReaderThemeImageView bookCommentVote4;

    @NonNull
    public final ReaderThemeImageView bookCommentVote5;

    @NonNull
    public final ReaderThemeTextView bookVoteScore;

    @NonNull
    public final ReaderThemeTextView bookVoteScoreHint;

    @NonNull
    public final ReaderThemeTextView chapterCommentDesc;

    @NonNull
    public final ReaderThemeTextView chapterCommentNumber;

    @NonNull
    public final ReaderThemeLinearLayout chapterCommentPost;

    @NonNull
    public final ReaderThemeTextView chapterCommentPostHint;

    @NonNull
    public final ReaderThemeLinearLayout chapterCommentPostView;

    @NonNull
    public final ReaderLoadingTip commentLoadingTip;

    @NonNull
    public final ThemeImageView ivBottomLine;

    @NonNull
    public final ReaderThemeImageView ivClose;

    @NonNull
    public final MagicIndicator magicIndicatorComment;

    @NonNull
    public final SmartRefreshLayout refreshLayout;

    @NonNull
    private final RoundedLayout rootView;

    @NonNull
    public final RecyclerView rvComment;

    @NonNull
    public final ReaderThemeTextView tvTitle;

    private DialogReaderCommentFragmentBinding(@NonNull RoundedLayout roundedLayout, @NonNull ReaderThemeTextView readerThemeTextView, @NonNull ReaderThemeTextView readerThemeTextView2, @NonNull ReaderThemeLinearLayout readerThemeLinearLayout, @NonNull ReaderThemeImageView readerThemeImageView, @NonNull ReaderThemeImageView readerThemeImageView2, @NonNull ReaderThemeImageView readerThemeImageView3, @NonNull ReaderThemeImageView readerThemeImageView4, @NonNull ReaderThemeImageView readerThemeImageView5, @NonNull ReaderThemeTextView readerThemeTextView3, @NonNull ReaderThemeTextView readerThemeTextView4, @NonNull ReaderThemeTextView readerThemeTextView5, @NonNull ReaderThemeTextView readerThemeTextView6, @NonNull ReaderThemeLinearLayout readerThemeLinearLayout2, @NonNull ReaderThemeTextView readerThemeTextView7, @NonNull ReaderThemeLinearLayout readerThemeLinearLayout3, @NonNull ReaderLoadingTip readerLoadingTip, @NonNull ThemeImageView themeImageView, @NonNull ReaderThemeImageView readerThemeImageView6, @NonNull MagicIndicator magicIndicator, @NonNull SmartRefreshLayout smartRefreshLayout, @NonNull RecyclerView recyclerView, @NonNull ReaderThemeTextView readerThemeTextView8) {
        this.rootView = roundedLayout;
        this.bookCommentScoreTips = readerThemeTextView;
        this.bookCommentStatus = readerThemeTextView2;
        this.bookCommentView = readerThemeLinearLayout;
        this.bookCommentVote1 = readerThemeImageView;
        this.bookCommentVote2 = readerThemeImageView2;
        this.bookCommentVote3 = readerThemeImageView3;
        this.bookCommentVote4 = readerThemeImageView4;
        this.bookCommentVote5 = readerThemeImageView5;
        this.bookVoteScore = readerThemeTextView3;
        this.bookVoteScoreHint = readerThemeTextView4;
        this.chapterCommentDesc = readerThemeTextView5;
        this.chapterCommentNumber = readerThemeTextView6;
        this.chapterCommentPost = readerThemeLinearLayout2;
        this.chapterCommentPostHint = readerThemeTextView7;
        this.chapterCommentPostView = readerThemeLinearLayout3;
        this.commentLoadingTip = readerLoadingTip;
        this.ivBottomLine = themeImageView;
        this.ivClose = readerThemeImageView6;
        this.magicIndicatorComment = magicIndicator;
        this.refreshLayout = smartRefreshLayout;
        this.rvComment = recyclerView;
        this.tvTitle = readerThemeTextView8;
    }

    @NonNull
    public static DialogReaderCommentFragmentBinding bind(@NonNull View view) {
        int i10 = R.id.book_comment_score_tips;
        ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
        if (readerThemeTextView != null) {
            i10 = R.id.book_comment_status;
            ReaderThemeTextView readerThemeTextView2 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
            if (readerThemeTextView2 != null) {
                i10 = R.id.book_comment_view;
                ReaderThemeLinearLayout readerThemeLinearLayout = (ReaderThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                if (readerThemeLinearLayout != null) {
                    i10 = R.id.book_comment_vote_1;
                    ReaderThemeImageView readerThemeImageView = (ReaderThemeImageView) ViewBindings.findChildViewById(view, i10);
                    if (readerThemeImageView != null) {
                        i10 = R.id.book_comment_vote_2;
                        ReaderThemeImageView readerThemeImageView2 = (ReaderThemeImageView) ViewBindings.findChildViewById(view, i10);
                        if (readerThemeImageView2 != null) {
                            i10 = R.id.book_comment_vote_3;
                            ReaderThemeImageView readerThemeImageView3 = (ReaderThemeImageView) ViewBindings.findChildViewById(view, i10);
                            if (readerThemeImageView3 != null) {
                                i10 = R.id.book_comment_vote_4;
                                ReaderThemeImageView readerThemeImageView4 = (ReaderThemeImageView) ViewBindings.findChildViewById(view, i10);
                                if (readerThemeImageView4 != null) {
                                    i10 = R.id.book_comment_vote_5;
                                    ReaderThemeImageView readerThemeImageView5 = (ReaderThemeImageView) ViewBindings.findChildViewById(view, i10);
                                    if (readerThemeImageView5 != null) {
                                        i10 = R.id.book_vote_score;
                                        ReaderThemeTextView readerThemeTextView3 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                        if (readerThemeTextView3 != null) {
                                            i10 = R.id.book_vote_score_hint;
                                            ReaderThemeTextView readerThemeTextView4 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                            if (readerThemeTextView4 != null) {
                                                i10 = R.id.chapter_comment_desc;
                                                ReaderThemeTextView readerThemeTextView5 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                if (readerThemeTextView5 != null) {
                                                    i10 = R.id.chapter_comment_number;
                                                    ReaderThemeTextView readerThemeTextView6 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                    if (readerThemeTextView6 != null) {
                                                        i10 = R.id.chapter_comment_post;
                                                        ReaderThemeLinearLayout readerThemeLinearLayout2 = (ReaderThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                                        if (readerThemeLinearLayout2 != null) {
                                                            i10 = R.id.chapter_comment_post_hint;
                                                            ReaderThemeTextView readerThemeTextView7 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                            if (readerThemeTextView7 != null) {
                                                                i10 = R.id.chapter_comment_post_view;
                                                                ReaderThemeLinearLayout readerThemeLinearLayout3 = (ReaderThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                if (readerThemeLinearLayout3 != null) {
                                                                    i10 = R.id.comment_loading_tip;
                                                                    ReaderLoadingTip readerLoadingTip = (ReaderLoadingTip) ViewBindings.findChildViewById(view, i10);
                                                                    if (readerLoadingTip != null) {
                                                                        i10 = R.id.iv_bottom_line;
                                                                        ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                                                                        if (themeImageView != null) {
                                                                            i10 = R.id.iv_close;
                                                                            ReaderThemeImageView readerThemeImageView6 = (ReaderThemeImageView) ViewBindings.findChildViewById(view, i10);
                                                                            if (readerThemeImageView6 != null) {
                                                                                i10 = R.id.magic_indicator_comment;
                                                                                MagicIndicator magicIndicator = (MagicIndicator) ViewBindings.findChildViewById(view, i10);
                                                                                if (magicIndicator != null) {
                                                                                    i10 = R.id.refreshLayout;
                                                                                    SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) ViewBindings.findChildViewById(view, i10);
                                                                                    if (smartRefreshLayout != null) {
                                                                                        i10 = R.id.rv_comment;
                                                                                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i10);
                                                                                        if (recyclerView != null) {
                                                                                            i10 = R.id.tv_title;
                                                                                            ReaderThemeTextView readerThemeTextView8 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                            if (readerThemeTextView8 != null) {
                                                                                                return new DialogReaderCommentFragmentBinding((RoundedLayout) view, readerThemeTextView, readerThemeTextView2, readerThemeLinearLayout, readerThemeImageView, readerThemeImageView2, readerThemeImageView3, readerThemeImageView4, readerThemeImageView5, readerThemeTextView3, readerThemeTextView4, readerThemeTextView5, readerThemeTextView6, readerThemeLinearLayout2, readerThemeTextView7, readerThemeLinearLayout3, readerLoadingTip, themeImageView, readerThemeImageView6, magicIndicator, smartRefreshLayout, recyclerView, readerThemeTextView8);
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
    public static DialogReaderCommentFragmentBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogReaderCommentFragmentBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.dialog_reader_comment_fragment, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public RoundedLayout getRoot() {
        return this.rootView;
    }
}
