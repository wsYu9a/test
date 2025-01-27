package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.libmars.utils.tablayout.MagicIndicator;
import com.martian.libmars.widget.RoundedLayout;
import com.martian.libmars.widget.recyclerview.LoadingTip;
import com.martian.mibook.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: classes3.dex */
public final class DialogCommentFragmentBinding implements ViewBinding {

    @NonNull
    public final ThemeTextView bookCommentScoreTips;

    @NonNull
    public final ThemeTextView bookCommentStatus;

    @NonNull
    public final ThemeLinearLayout bookCommentView;

    @NonNull
    public final ImageView bookCommentVote1;

    @NonNull
    public final ImageView bookCommentVote2;

    @NonNull
    public final ImageView bookCommentVote3;

    @NonNull
    public final ImageView bookCommentVote4;

    @NonNull
    public final ImageView bookCommentVote5;

    @NonNull
    public final ThemeTextView bookVoteScore;

    @NonNull
    public final ThemeTextView bookVoteScoreHint;

    @NonNull
    public final ThemeTextView chapterCommentDesc;

    @NonNull
    public final ThemeTextView chapterCommentNumber;

    @NonNull
    public final ThemeLinearLayout chapterCommentPost;

    @NonNull
    public final ThemeTextView chapterCommentPostHint;

    @NonNull
    public final ThemeLinearLayout chapterCommentPostView;

    @NonNull
    public final LoadingTip commentLoadingTip;

    @NonNull
    public final ThemeImageView ivBottomLine;

    @NonNull
    public final ThemeImageView ivClose;

    @NonNull
    public final MagicIndicator magicIndicatorComment;

    @NonNull
    public final SmartRefreshLayout refreshLayout;

    @NonNull
    private final RoundedLayout rootView;

    @NonNull
    public final RecyclerView rvComment;

    @NonNull
    public final ThemeTextView tvTitle;

    private DialogCommentFragmentBinding(@NonNull RoundedLayout roundedLayout, @NonNull ThemeTextView themeTextView, @NonNull ThemeTextView themeTextView2, @NonNull ThemeLinearLayout themeLinearLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull ImageView imageView4, @NonNull ImageView imageView5, @NonNull ThemeTextView themeTextView3, @NonNull ThemeTextView themeTextView4, @NonNull ThemeTextView themeTextView5, @NonNull ThemeTextView themeTextView6, @NonNull ThemeLinearLayout themeLinearLayout2, @NonNull ThemeTextView themeTextView7, @NonNull ThemeLinearLayout themeLinearLayout3, @NonNull LoadingTip loadingTip, @NonNull ThemeImageView themeImageView, @NonNull ThemeImageView themeImageView2, @NonNull MagicIndicator magicIndicator, @NonNull SmartRefreshLayout smartRefreshLayout, @NonNull RecyclerView recyclerView, @NonNull ThemeTextView themeTextView8) {
        this.rootView = roundedLayout;
        this.bookCommentScoreTips = themeTextView;
        this.bookCommentStatus = themeTextView2;
        this.bookCommentView = themeLinearLayout;
        this.bookCommentVote1 = imageView;
        this.bookCommentVote2 = imageView2;
        this.bookCommentVote3 = imageView3;
        this.bookCommentVote4 = imageView4;
        this.bookCommentVote5 = imageView5;
        this.bookVoteScore = themeTextView3;
        this.bookVoteScoreHint = themeTextView4;
        this.chapterCommentDesc = themeTextView5;
        this.chapterCommentNumber = themeTextView6;
        this.chapterCommentPost = themeLinearLayout2;
        this.chapterCommentPostHint = themeTextView7;
        this.chapterCommentPostView = themeLinearLayout3;
        this.commentLoadingTip = loadingTip;
        this.ivBottomLine = themeImageView;
        this.ivClose = themeImageView2;
        this.magicIndicatorComment = magicIndicator;
        this.refreshLayout = smartRefreshLayout;
        this.rvComment = recyclerView;
        this.tvTitle = themeTextView8;
    }

    @NonNull
    public static DialogCommentFragmentBinding bind(@NonNull View view) {
        int i10 = R.id.book_comment_score_tips;
        ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
        if (themeTextView != null) {
            i10 = R.id.book_comment_status;
            ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
            if (themeTextView2 != null) {
                i10 = R.id.book_comment_view;
                ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                if (themeLinearLayout != null) {
                    i10 = R.id.book_comment_vote_1;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
                    if (imageView != null) {
                        i10 = R.id.book_comment_vote_2;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i10);
                        if (imageView2 != null) {
                            i10 = R.id.book_comment_vote_3;
                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i10);
                            if (imageView3 != null) {
                                i10 = R.id.book_comment_vote_4;
                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i10);
                                if (imageView4 != null) {
                                    i10 = R.id.book_comment_vote_5;
                                    ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i10);
                                    if (imageView5 != null) {
                                        i10 = R.id.book_vote_score;
                                        ThemeTextView themeTextView3 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                        if (themeTextView3 != null) {
                                            i10 = R.id.book_vote_score_hint;
                                            ThemeTextView themeTextView4 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                            if (themeTextView4 != null) {
                                                i10 = R.id.chapter_comment_desc;
                                                ThemeTextView themeTextView5 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                if (themeTextView5 != null) {
                                                    i10 = R.id.chapter_comment_number;
                                                    ThemeTextView themeTextView6 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                    if (themeTextView6 != null) {
                                                        i10 = R.id.chapter_comment_post;
                                                        ThemeLinearLayout themeLinearLayout2 = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                                        if (themeLinearLayout2 != null) {
                                                            i10 = R.id.chapter_comment_post_hint;
                                                            ThemeTextView themeTextView7 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                            if (themeTextView7 != null) {
                                                                i10 = R.id.chapter_comment_post_view;
                                                                ThemeLinearLayout themeLinearLayout3 = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                if (themeLinearLayout3 != null) {
                                                                    i10 = R.id.comment_loading_tip;
                                                                    LoadingTip loadingTip = (LoadingTip) ViewBindings.findChildViewById(view, i10);
                                                                    if (loadingTip != null) {
                                                                        i10 = R.id.iv_bottom_line;
                                                                        ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                                                                        if (themeImageView != null) {
                                                                            i10 = R.id.iv_close;
                                                                            ThemeImageView themeImageView2 = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                                                                            if (themeImageView2 != null) {
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
                                                                                            ThemeTextView themeTextView8 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                            if (themeTextView8 != null) {
                                                                                                return new DialogCommentFragmentBinding((RoundedLayout) view, themeTextView, themeTextView2, themeLinearLayout, imageView, imageView2, imageView3, imageView4, imageView5, themeTextView3, themeTextView4, themeTextView5, themeTextView6, themeLinearLayout2, themeTextView7, themeLinearLayout3, loadingTip, themeImageView, themeImageView2, magicIndicator, smartRefreshLayout, recyclerView, themeTextView8);
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
    public static DialogCommentFragmentBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogCommentFragmentBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.dialog_comment_fragment, viewGroup, false);
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
