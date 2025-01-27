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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeGradientExpandableTextView;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;
import com.martian.mibook.mvvm.widget.ExpLevelLabel;
import de.hdodenhof.circleimageview.CircleImageView;

/* loaded from: classes3.dex */
public final class ItemBookCommentBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout clTimeReplyVote;

    @NonNull
    public final ConstraintLayout cslUserInfo;

    @NonNull
    public final ThemeImageView ivCommentLine;

    @NonNull
    public final ExpLevelLabel ivExpLevel;

    @NonNull
    public final ThemeImageView ivMoreLine;

    @NonNull
    public final ThemeImageView ivMoreReply;

    @NonNull
    public final ImageView ivSift;

    @NonNull
    public final CircleImageView ivUserHeader;

    @NonNull
    public final ImageView ivVipTag;

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
    public final ImageView ivVoteUpCount;

    @NonNull
    public final LinearLayout llMoreReply;

    @NonNull
    public final LinearLayout llScore;

    @NonNull
    public final LinearLayout llVoteView;

    @NonNull
    public final RelativeLayout rlReaderComment;

    @NonNull
    private final ConstraintLayout rootView;

    @NonNull
    public final ThemeTextView tvCommentTime;

    @NonNull
    public final ThemeTextView tvMoreReply;

    @NonNull
    public final ThemeTextView tvNickname;

    @NonNull
    public final ThemeTextView tvReadTime;

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

    private ItemBookCommentBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull ConstraintLayout constraintLayout3, @NonNull ThemeImageView themeImageView, @NonNull ExpLevelLabel expLevelLabel, @NonNull ThemeImageView themeImageView2, @NonNull ThemeImageView themeImageView3, @NonNull ImageView imageView, @NonNull CircleImageView circleImageView, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull ImageView imageView4, @NonNull ImageView imageView5, @NonNull ImageView imageView6, @NonNull ImageView imageView7, @NonNull ImageView imageView8, @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull LinearLayout linearLayout3, @NonNull RelativeLayout relativeLayout, @NonNull ThemeTextView themeTextView, @NonNull ThemeTextView themeTextView2, @NonNull ThemeTextView themeTextView3, @NonNull ThemeTextView themeTextView4, @NonNull ThemeGradientExpandableTextView themeGradientExpandableTextView, @NonNull ThemeTextView themeTextView5, @NonNull ThemeTextView themeTextView6, @NonNull TextView textView, @NonNull TextView textView2) {
        this.rootView = constraintLayout;
        this.clTimeReplyVote = constraintLayout2;
        this.cslUserInfo = constraintLayout3;
        this.ivCommentLine = themeImageView;
        this.ivExpLevel = expLevelLabel;
        this.ivMoreLine = themeImageView2;
        this.ivMoreReply = themeImageView3;
        this.ivSift = imageView;
        this.ivUserHeader = circleImageView;
        this.ivVipTag = imageView2;
        this.ivVote1 = imageView3;
        this.ivVote2 = imageView4;
        this.ivVote3 = imageView5;
        this.ivVote4 = imageView6;
        this.ivVote5 = imageView7;
        this.ivVoteUpCount = imageView8;
        this.llMoreReply = linearLayout;
        this.llScore = linearLayout2;
        this.llVoteView = linearLayout3;
        this.rlReaderComment = relativeLayout;
        this.tvCommentTime = themeTextView;
        this.tvMoreReply = themeTextView2;
        this.tvNickname = themeTextView3;
        this.tvReadTime = themeTextView4;
        this.tvReaderComment = themeGradientExpandableTextView;
        this.tvReaderCommentMore = themeTextView5;
        this.tvReplyNum = themeTextView6;
        this.tvTag = textView;
        this.tvVoteUpCount = textView2;
    }

    @NonNull
    public static ItemBookCommentBinding bind(@NonNull View view) {
        int i10 = R.id.cl_time_reply_vote;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i10);
        if (constraintLayout != null) {
            i10 = R.id.csl_user_info;
            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i10);
            if (constraintLayout2 != null) {
                i10 = R.id.iv_comment_line;
                ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                if (themeImageView != null) {
                    i10 = R.id.iv_exp_level;
                    ExpLevelLabel expLevelLabel = (ExpLevelLabel) ViewBindings.findChildViewById(view, i10);
                    if (expLevelLabel != null) {
                        i10 = R.id.iv_more_line;
                        ThemeImageView themeImageView2 = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                        if (themeImageView2 != null) {
                            i10 = R.id.iv_more_reply;
                            ThemeImageView themeImageView3 = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                            if (themeImageView3 != null) {
                                i10 = R.id.iv_sift;
                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
                                if (imageView != null) {
                                    i10 = R.id.iv_user_header;
                                    CircleImageView circleImageView = (CircleImageView) ViewBindings.findChildViewById(view, i10);
                                    if (circleImageView != null) {
                                        i10 = R.id.iv_vip_tag;
                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i10);
                                        if (imageView2 != null) {
                                            i10 = R.id.iv_vote_1;
                                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i10);
                                            if (imageView3 != null) {
                                                i10 = R.id.iv_vote_2;
                                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i10);
                                                if (imageView4 != null) {
                                                    i10 = R.id.iv_vote_3;
                                                    ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i10);
                                                    if (imageView5 != null) {
                                                        i10 = R.id.iv_vote_4;
                                                        ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, i10);
                                                        if (imageView6 != null) {
                                                            i10 = R.id.iv_vote_5;
                                                            ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view, i10);
                                                            if (imageView7 != null) {
                                                                i10 = R.id.iv_vote_up_count;
                                                                ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(view, i10);
                                                                if (imageView8 != null) {
                                                                    i10 = R.id.ll_more_reply;
                                                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                    if (linearLayout != null) {
                                                                        i10 = R.id.ll_score;
                                                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                        if (linearLayout2 != null) {
                                                                            i10 = R.id.ll_vote_view;
                                                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                            if (linearLayout3 != null) {
                                                                                i10 = R.id.rl_reader_comment;
                                                                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i10);
                                                                                if (relativeLayout != null) {
                                                                                    i10 = R.id.tv_comment_time;
                                                                                    ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                    if (themeTextView != null) {
                                                                                        i10 = R.id.tv_more_reply;
                                                                                        ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                        if (themeTextView2 != null) {
                                                                                            i10 = R.id.tv_nickname;
                                                                                            ThemeTextView themeTextView3 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                            if (themeTextView3 != null) {
                                                                                                i10 = R.id.tv_read_time;
                                                                                                ThemeTextView themeTextView4 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                if (themeTextView4 != null) {
                                                                                                    i10 = R.id.tv_reader_comment;
                                                                                                    ThemeGradientExpandableTextView themeGradientExpandableTextView = (ThemeGradientExpandableTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                    if (themeGradientExpandableTextView != null) {
                                                                                                        i10 = R.id.tv_reader_comment_more;
                                                                                                        ThemeTextView themeTextView5 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                        if (themeTextView5 != null) {
                                                                                                            i10 = R.id.tv_reply_num;
                                                                                                            ThemeTextView themeTextView6 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                            if (themeTextView6 != null) {
                                                                                                                i10 = R.id.tv_tag;
                                                                                                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                if (textView != null) {
                                                                                                                    i10 = R.id.tv_vote_up_count;
                                                                                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                    if (textView2 != null) {
                                                                                                                        return new ItemBookCommentBinding((ConstraintLayout) view, constraintLayout, constraintLayout2, themeImageView, expLevelLabel, themeImageView2, themeImageView3, imageView, circleImageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, linearLayout, linearLayout2, linearLayout3, relativeLayout, themeTextView, themeTextView2, themeTextView3, themeTextView4, themeGradientExpandableTextView, themeTextView5, themeTextView6, textView, textView2);
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
    public static ItemBookCommentBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ItemBookCommentBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.item_book_comment, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
