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
import com.martian.libmars.ui.theme.ThemeGradientExpandableTextView;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;
import com.martian.mibook.mvvm.widget.ExpLevelLabel;
import de.hdodenhof.circleimageview.CircleImageView;

/* loaded from: classes3.dex */
public final class ItemBookCommentReplyBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout clCommentReply;

    @NonNull
    public final ConstraintLayout clTimeReplyVote;

    @NonNull
    public final ExpLevelLabel ivExpLevel;

    @NonNull
    public final ThemeImageView ivMoreLine;

    @NonNull
    public final ThemeImageView ivMoreReply;

    @NonNull
    public final CircleImageView ivUserHeader;

    @NonNull
    public final ImageView ivVipTag;

    @NonNull
    public final ImageView ivVoteUpCount;

    @NonNull
    public final ThemeLinearLayout llCommentReplyView;

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
    public final ThemeTextView tvCommentReplyContent;

    @NonNull
    public final ThemeTextView tvCommentTime;

    @NonNull
    public final ThemeTextView tvFold;

    @NonNull
    public final ThemeTextView tvMoreReply;

    @NonNull
    public final ThemeTextView tvNickname;

    @NonNull
    public final ThemeGradientExpandableTextView tvReaderComment;

    @NonNull
    public final ThemeTextView tvReaderCommentMore;

    @NonNull
    public final ThemeTextView tvReplyNum;

    @NonNull
    public final TextView tvTag;

    @NonNull
    public final TextView tvVoteUpCount;

    private ItemBookCommentReplyBinding(@NonNull LinearLayout linearLayout, @NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull ExpLevelLabel expLevelLabel, @NonNull ThemeImageView themeImageView, @NonNull ThemeImageView themeImageView2, @NonNull CircleImageView circleImageView, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ThemeLinearLayout themeLinearLayout, @NonNull LinearLayout linearLayout2, @NonNull LinearLayout linearLayout3, @NonNull LinearLayout linearLayout4, @NonNull ProgressBar progressBar, @NonNull RelativeLayout relativeLayout, @NonNull ThemeTextView themeTextView, @NonNull ThemeTextView themeTextView2, @NonNull ThemeTextView themeTextView3, @NonNull ThemeTextView themeTextView4, @NonNull ThemeTextView themeTextView5, @NonNull ThemeGradientExpandableTextView themeGradientExpandableTextView, @NonNull ThemeTextView themeTextView6, @NonNull ThemeTextView themeTextView7, @NonNull TextView textView, @NonNull TextView textView2) {
        this.rootView = linearLayout;
        this.clCommentReply = constraintLayout;
        this.clTimeReplyVote = constraintLayout2;
        this.ivExpLevel = expLevelLabel;
        this.ivMoreLine = themeImageView;
        this.ivMoreReply = themeImageView2;
        this.ivUserHeader = circleImageView;
        this.ivVipTag = imageView;
        this.ivVoteUpCount = imageView2;
        this.llCommentReplyView = themeLinearLayout;
        this.llFold = linearLayout2;
        this.llMoreReply = linearLayout3;
        this.llVoteView = linearLayout4;
        this.pbExpandLoading = progressBar;
        this.rlReaderComment = relativeLayout;
        this.tvCommentReplyContent = themeTextView;
        this.tvCommentTime = themeTextView2;
        this.tvFold = themeTextView3;
        this.tvMoreReply = themeTextView4;
        this.tvNickname = themeTextView5;
        this.tvReaderComment = themeGradientExpandableTextView;
        this.tvReaderCommentMore = themeTextView6;
        this.tvReplyNum = themeTextView7;
        this.tvTag = textView;
        this.tvVoteUpCount = textView2;
    }

    @NonNull
    public static ItemBookCommentReplyBinding bind(@NonNull View view) {
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
                        ThemeImageView themeImageView2 = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                        if (themeImageView2 != null) {
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
                                        ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                        if (themeLinearLayout != null) {
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
                                                                ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                if (themeTextView != null) {
                                                                    i10 = R.id.tv_comment_time;
                                                                    ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                    if (themeTextView2 != null) {
                                                                        i10 = R.id.tv_fold;
                                                                        ThemeTextView themeTextView3 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                        if (themeTextView3 != null) {
                                                                            i10 = R.id.tv_more_reply;
                                                                            ThemeTextView themeTextView4 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                            if (themeTextView4 != null) {
                                                                                i10 = R.id.tv_nickname;
                                                                                ThemeTextView themeTextView5 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                if (themeTextView5 != null) {
                                                                                    i10 = R.id.tv_reader_comment;
                                                                                    ThemeGradientExpandableTextView themeGradientExpandableTextView = (ThemeGradientExpandableTextView) ViewBindings.findChildViewById(view, i10);
                                                                                    if (themeGradientExpandableTextView != null) {
                                                                                        i10 = R.id.tv_reader_comment_more;
                                                                                        ThemeTextView themeTextView6 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                        if (themeTextView6 != null) {
                                                                                            i10 = R.id.tv_reply_num;
                                                                                            ThemeTextView themeTextView7 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                            if (themeTextView7 != null) {
                                                                                                i10 = R.id.tv_tag;
                                                                                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
                                                                                                if (textView != null) {
                                                                                                    i10 = R.id.tv_vote_up_count;
                                                                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i10);
                                                                                                    if (textView2 != null) {
                                                                                                        return new ItemBookCommentReplyBinding((LinearLayout) view, constraintLayout, constraintLayout2, expLevelLabel, themeImageView, themeImageView2, circleImageView, imageView, imageView2, themeLinearLayout, linearLayout, linearLayout2, linearLayout3, progressBar, relativeLayout, themeTextView, themeTextView2, themeTextView3, themeTextView4, themeTextView5, themeGradientExpandableTextView, themeTextView6, themeTextView7, textView, textView2);
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
    public static ItemBookCommentReplyBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ItemBookCommentReplyBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.item_book_comment_reply, viewGroup, false);
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
