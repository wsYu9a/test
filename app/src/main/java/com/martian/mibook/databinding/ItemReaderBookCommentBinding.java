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
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.mibook.R;
import com.martian.mibook.mvvm.widget.ExpLevelLabel;
import com.martian.mibook.ui.reader.ReaderGradientExpandableTextView;
import com.martian.mibook.ui.reader.ReaderThemeImageView;
import com.martian.mibook.ui.reader.ReaderThemeTextView;
import de.hdodenhof.circleimageview.CircleImageView;

/* loaded from: classes3.dex */
public final class ItemReaderBookCommentBinding implements ViewBinding {

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
    public final ReaderThemeImageView ivMoreReply;

    @NonNull
    public final ImageView ivSift;

    @NonNull
    public final CircleImageView ivUserHeader;

    @NonNull
    public final ImageView ivVipTag;

    @NonNull
    public final ReaderThemeImageView ivVote1;

    @NonNull
    public final ReaderThemeImageView ivVote2;

    @NonNull
    public final ReaderThemeImageView ivVote3;

    @NonNull
    public final ReaderThemeImageView ivVote4;

    @NonNull
    public final ReaderThemeImageView ivVote5;

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
    public final ReaderThemeTextView tvCommentTime;

    @NonNull
    public final ReaderThemeTextView tvMoreReply;

    @NonNull
    public final ReaderThemeTextView tvNickname;

    @NonNull
    public final ReaderThemeTextView tvReadTime;

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

    private ItemReaderBookCommentBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull ConstraintLayout constraintLayout3, @NonNull ThemeImageView themeImageView, @NonNull ExpLevelLabel expLevelLabel, @NonNull ThemeImageView themeImageView2, @NonNull ReaderThemeImageView readerThemeImageView, @NonNull ImageView imageView, @NonNull CircleImageView circleImageView, @NonNull ImageView imageView2, @NonNull ReaderThemeImageView readerThemeImageView2, @NonNull ReaderThemeImageView readerThemeImageView3, @NonNull ReaderThemeImageView readerThemeImageView4, @NonNull ReaderThemeImageView readerThemeImageView5, @NonNull ReaderThemeImageView readerThemeImageView6, @NonNull ImageView imageView3, @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull LinearLayout linearLayout3, @NonNull RelativeLayout relativeLayout, @NonNull ReaderThemeTextView readerThemeTextView, @NonNull ReaderThemeTextView readerThemeTextView2, @NonNull ReaderThemeTextView readerThemeTextView3, @NonNull ReaderThemeTextView readerThemeTextView4, @NonNull ReaderGradientExpandableTextView readerGradientExpandableTextView, @NonNull ReaderThemeTextView readerThemeTextView5, @NonNull ReaderThemeTextView readerThemeTextView6, @NonNull TextView textView, @NonNull TextView textView2) {
        this.rootView = constraintLayout;
        this.clTimeReplyVote = constraintLayout2;
        this.cslUserInfo = constraintLayout3;
        this.ivCommentLine = themeImageView;
        this.ivExpLevel = expLevelLabel;
        this.ivMoreLine = themeImageView2;
        this.ivMoreReply = readerThemeImageView;
        this.ivSift = imageView;
        this.ivUserHeader = circleImageView;
        this.ivVipTag = imageView2;
        this.ivVote1 = readerThemeImageView2;
        this.ivVote2 = readerThemeImageView3;
        this.ivVote3 = readerThemeImageView4;
        this.ivVote4 = readerThemeImageView5;
        this.ivVote5 = readerThemeImageView6;
        this.ivVoteUpCount = imageView3;
        this.llMoreReply = linearLayout;
        this.llScore = linearLayout2;
        this.llVoteView = linearLayout3;
        this.rlReaderComment = relativeLayout;
        this.tvCommentTime = readerThemeTextView;
        this.tvMoreReply = readerThemeTextView2;
        this.tvNickname = readerThemeTextView3;
        this.tvReadTime = readerThemeTextView4;
        this.tvReaderComment = readerGradientExpandableTextView;
        this.tvReaderCommentMore = readerThemeTextView5;
        this.tvReplyNum = readerThemeTextView6;
        this.tvTag = textView;
        this.tvVoteUpCount = textView2;
    }

    @NonNull
    public static ItemReaderBookCommentBinding bind(@NonNull View view) {
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
                            ReaderThemeImageView readerThemeImageView = (ReaderThemeImageView) ViewBindings.findChildViewById(view, i10);
                            if (readerThemeImageView != null) {
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
                                            ReaderThemeImageView readerThemeImageView2 = (ReaderThemeImageView) ViewBindings.findChildViewById(view, i10);
                                            if (readerThemeImageView2 != null) {
                                                i10 = R.id.iv_vote_2;
                                                ReaderThemeImageView readerThemeImageView3 = (ReaderThemeImageView) ViewBindings.findChildViewById(view, i10);
                                                if (readerThemeImageView3 != null) {
                                                    i10 = R.id.iv_vote_3;
                                                    ReaderThemeImageView readerThemeImageView4 = (ReaderThemeImageView) ViewBindings.findChildViewById(view, i10);
                                                    if (readerThemeImageView4 != null) {
                                                        i10 = R.id.iv_vote_4;
                                                        ReaderThemeImageView readerThemeImageView5 = (ReaderThemeImageView) ViewBindings.findChildViewById(view, i10);
                                                        if (readerThemeImageView5 != null) {
                                                            i10 = R.id.iv_vote_5;
                                                            ReaderThemeImageView readerThemeImageView6 = (ReaderThemeImageView) ViewBindings.findChildViewById(view, i10);
                                                            if (readerThemeImageView6 != null) {
                                                                i10 = R.id.iv_vote_up_count;
                                                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i10);
                                                                if (imageView3 != null) {
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
                                                                                    ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                    if (readerThemeTextView != null) {
                                                                                        i10 = R.id.tv_more_reply;
                                                                                        ReaderThemeTextView readerThemeTextView2 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                        if (readerThemeTextView2 != null) {
                                                                                            i10 = R.id.tv_nickname;
                                                                                            ReaderThemeTextView readerThemeTextView3 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                            if (readerThemeTextView3 != null) {
                                                                                                i10 = R.id.tv_read_time;
                                                                                                ReaderThemeTextView readerThemeTextView4 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                if (readerThemeTextView4 != null) {
                                                                                                    i10 = R.id.tv_reader_comment;
                                                                                                    ReaderGradientExpandableTextView readerGradientExpandableTextView = (ReaderGradientExpandableTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                    if (readerGradientExpandableTextView != null) {
                                                                                                        i10 = R.id.tv_reader_comment_more;
                                                                                                        ReaderThemeTextView readerThemeTextView5 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                        if (readerThemeTextView5 != null) {
                                                                                                            i10 = R.id.tv_reply_num;
                                                                                                            ReaderThemeTextView readerThemeTextView6 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                            if (readerThemeTextView6 != null) {
                                                                                                                i10 = R.id.tv_tag;
                                                                                                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                if (textView != null) {
                                                                                                                    i10 = R.id.tv_vote_up_count;
                                                                                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                    if (textView2 != null) {
                                                                                                                        return new ItemReaderBookCommentBinding((ConstraintLayout) view, constraintLayout, constraintLayout2, themeImageView, expLevelLabel, themeImageView2, readerThemeImageView, imageView, circleImageView, imageView2, readerThemeImageView2, readerThemeImageView3, readerThemeImageView4, readerThemeImageView5, readerThemeImageView6, imageView3, linearLayout, linearLayout2, linearLayout3, relativeLayout, readerThemeTextView, readerThemeTextView2, readerThemeTextView3, readerThemeTextView4, readerGradientExpandableTextView, readerThemeTextView5, readerThemeTextView6, textView, textView2);
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
    public static ItemReaderBookCommentBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ItemReaderBookCommentBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.item_reader_book_comment, viewGroup, false);
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
