package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.mibook.R;
import com.martian.mibook.mvvm.widget.ExpLevelLabel;
import com.martian.mibook.ui.reader.ReaderGradientExpandableTextView;
import com.martian.mibook.ui.reader.ReaderThemeImageView;
import com.martian.mibook.ui.reader.ReaderThemeLinearLayout;
import com.martian.mibook.ui.reader.ReaderThemeTextView;
import de.hdodenhof.circleimageview.CircleImageView;

/* loaded from: classes3.dex */
public final class ItemReaderBookCommentReplyBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout clCommentReply;

    @NonNull
    public final ConstraintLayout clTimeReplyVote;

    @NonNull
    public final ExpLevelLabel ivExpLevel;

    @NonNull
    public final ThemeImageView ivMoreLine;

    @NonNull
    public final ReaderThemeImageView ivMoreReply;

    @NonNull
    public final CircleImageView ivUserHeader;

    @NonNull
    public final ImageView ivVipTag;

    @NonNull
    public final ImageView ivVoteUpCount;

    @NonNull
    public final ReaderThemeLinearLayout llCommentReplyView;

    @NonNull
    public final LinearLayout llFold;

    @NonNull
    public final LinearLayout llMoreReply;

    @NonNull
    public final LinearLayout llVoteView;

    @NonNull
    public final ProgressBar pbExpandLoading;

    @NonNull
    public final RelativeLayout rlReaderComment;

    @NonNull
    private final LinearLayout rootView;

    @NonNull
    public final ReaderThemeTextView tvCommentReplyContent;

    @NonNull
    public final ReaderThemeTextView tvCommentTime;

    @NonNull
    public final ReaderThemeTextView tvFold;

    @NonNull
    public final ReaderThemeTextView tvMoreReply;

    @NonNull
    public final ReaderThemeTextView tvNickname;

    @NonNull
    public final ReaderGradientExpandableTextView tvReaderComment;

    @NonNull
    public final ReaderThemeTextView tvReaderCommentMore;

    @NonNull
    public final ReaderThemeTextView tvReplyNum;

    @NonNull
    public final TextView tvTag;

    @NonNull
    public final TextView tvVoteUpCount;

    private ItemReaderBookCommentReplyBinding(@NonNull LinearLayout linearLayout, @NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull ExpLevelLabel expLevelLabel, @NonNull ThemeImageView themeImageView, @NonNull ReaderThemeImageView readerThemeImageView, @NonNull CircleImageView circleImageView, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ReaderThemeLinearLayout readerThemeLinearLayout, @NonNull LinearLayout linearLayout2, @NonNull LinearLayout linearLayout3, @NonNull LinearLayout linearLayout4, @NonNull ProgressBar progressBar, @NonNull RelativeLayout relativeLayout, @NonNull ReaderThemeTextView readerThemeTextView, @NonNull ReaderThemeTextView readerThemeTextView2, @NonNull ReaderThemeTextView readerThemeTextView3, @NonNull ReaderThemeTextView readerThemeTextView4, @NonNull ReaderThemeTextView readerThemeTextView5, @NonNull ReaderGradientExpandableTextView readerGradientExpandableTextView, @NonNull ReaderThemeTextView readerThemeTextView6, @NonNull ReaderThemeTextView readerThemeTextView7, @NonNull TextView textView, @NonNull TextView textView2) {
        this.rootView = linearLayout;
        this.clCommentReply = constraintLayout;
        this.clTimeReplyVote = constraintLayout2;
        this.ivExpLevel = expLevelLabel;
        this.ivMoreLine = themeImageView;
        this.ivMoreReply = readerThemeImageView;
        this.ivUserHeader = circleImageView;
        this.ivVipTag = imageView;
        this.ivVoteUpCount = imageView2;
        this.llCommentReplyView = readerThemeLinearLayout;
        this.llFold = linearLayout2;
        this.llMoreReply = linearLayout3;
        this.llVoteView = linearLayout4;
        this.pbExpandLoading = progressBar;
        this.rlReaderComment = relativeLayout;
        this.tvCommentReplyContent = readerThemeTextView;
        this.tvCommentTime = readerThemeTextView2;
        this.tvFold = readerThemeTextView3;
        this.tvMoreReply = readerThemeTextView4;
        this.tvNickname = readerThemeTextView5;
        this.tvReaderComment = readerGradientExpandableTextView;
        this.tvReaderCommentMore = readerThemeTextView6;
        this.tvReplyNum = readerThemeTextView7;
        this.tvTag = textView;
        this.tvVoteUpCount = textView2;
    }

    @NonNull
    public static ItemReaderBookCommentReplyBinding bind(@NonNull View view) {
        int i10 = R.id.cl_comment_reply;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i10);
        if (constraintLayout != null) {
            i10 = R.id.cl_time_reply_vote;
            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i10);
            if (constraintLayout2 != null) {
                i10 = R.id.iv_exp_level;
                ExpLevelLabel expLevelLabel = (ExpLevelLabel) ViewBindings.findChildViewById(view, i10);
                if (expLevelLabel != null) {
                    i10 = R.id.iv_more_line;
                    ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                    if (themeImageView != null) {
                        i10 = R.id.iv_more_reply;
                        ReaderThemeImageView readerThemeImageView = (ReaderThemeImageView) ViewBindings.findChildViewById(view, i10);
                        if (readerThemeImageView != null) {
                            i10 = R.id.iv_user_header;
                            CircleImageView circleImageView = (CircleImageView) ViewBindings.findChildViewById(view, i10);
                            if (circleImageView != null) {
                                i10 = R.id.iv_vip_tag;
                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
                                if (imageView != null) {
                                    i10 = R.id.iv_vote_up_count;
                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i10);
                                    if (imageView2 != null) {
                                        i10 = R.id.ll_comment_reply_view;
                                        ReaderThemeLinearLayout readerThemeLinearLayout = (ReaderThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                        if (readerThemeLinearLayout != null) {
                                            i10 = R.id.ll_fold;
                                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                            if (linearLayout != null) {
                                                i10 = R.id.ll_more_reply;
                                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                                if (linearLayout2 != null) {
                                                    i10 = R.id.ll_vote_view;
                                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                                    if (linearLayout3 != null) {
                                                        i10 = R.id.pb_expand_loading;
                                                        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i10);
                                                        if (progressBar != null) {
                                                            i10 = R.id.rl_reader_comment;
                                                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i10);
                                                            if (relativeLayout != null) {
                                                                i10 = R.id.tv_comment_reply_content;
                                                                ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                if (readerThemeTextView != null) {
                                                                    i10 = R.id.tv_comment_time;
                                                                    ReaderThemeTextView readerThemeTextView2 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                    if (readerThemeTextView2 != null) {
                                                                        i10 = R.id.tv_fold;
                                                                        ReaderThemeTextView readerThemeTextView3 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                        if (readerThemeTextView3 != null) {
                                                                            i10 = R.id.tv_more_reply;
                                                                            ReaderThemeTextView readerThemeTextView4 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                            if (readerThemeTextView4 != null) {
                                                                                i10 = R.id.tv_nickname;
                                                                                ReaderThemeTextView readerThemeTextView5 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                if (readerThemeTextView5 != null) {
                                                                                    i10 = R.id.tv_reader_comment;
                                                                                    ReaderGradientExpandableTextView readerGradientExpandableTextView = (ReaderGradientExpandableTextView) ViewBindings.findChildViewById(view, i10);
                                                                                    if (readerGradientExpandableTextView != null) {
                                                                                        i10 = R.id.tv_reader_comment_more;
                                                                                        ReaderThemeTextView readerThemeTextView6 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                        if (readerThemeTextView6 != null) {
                                                                                            i10 = R.id.tv_reply_num;
                                                                                            ReaderThemeTextView readerThemeTextView7 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                            if (readerThemeTextView7 != null) {
                                                                                                i10 = R.id.tv_tag;
                                                                                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
                                                                                                if (textView != null) {
                                                                                                    i10 = R.id.tv_vote_up_count;
                                                                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i10);
                                                                                                    if (textView2 != null) {
                                                                                                        return new ItemReaderBookCommentReplyBinding((LinearLayout) view, constraintLayout, constraintLayout2, expLevelLabel, themeImageView, readerThemeImageView, circleImageView, imageView, imageView2, readerThemeLinearLayout, linearLayout, linearLayout2, linearLayout3, progressBar, relativeLayout, readerThemeTextView, readerThemeTextView2, readerThemeTextView3, readerThemeTextView4, readerThemeTextView5, readerGradientExpandableTextView, readerThemeTextView6, readerThemeTextView7, textView, textView2);
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
    public static ItemReaderBookCommentReplyBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ItemReaderBookCommentReplyBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.item_reader_book_comment_reply, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
