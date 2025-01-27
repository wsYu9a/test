package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class PostCommentHeaderBinding implements ViewBinding {

    @NonNull
    public final ThemeTextView bookCommentHot;

    @NonNull
    public final ThemeTextView bookCommentNumber;

    @NonNull
    public final ThemeTextView bookCommentStatus;

    @NonNull
    public final ThemeTextView bookCommentTime;

    @NonNull
    public final ThemeTextView bookCommentTitle;

    @NonNull
    public final LinearLayout bookCommentTitleView;

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
    public final ThemeTextView bookVoteScore1;

    @NonNull
    public final ThemeTextView bookVoteScore2;

    @NonNull
    public final ThemeTextView bookVoteScoreHint;

    @NonNull
    private final LinearLayout rootView;

    private PostCommentHeaderBinding(@NonNull LinearLayout linearLayout, @NonNull ThemeTextView themeTextView, @NonNull ThemeTextView themeTextView2, @NonNull ThemeTextView themeTextView3, @NonNull ThemeTextView themeTextView4, @NonNull ThemeTextView themeTextView5, @NonNull LinearLayout linearLayout2, @NonNull ThemeLinearLayout themeLinearLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull ImageView imageView4, @NonNull ImageView imageView5, @NonNull ThemeTextView themeTextView6, @NonNull ThemeTextView themeTextView7, @NonNull ThemeTextView themeTextView8) {
        this.rootView = linearLayout;
        this.bookCommentHot = themeTextView;
        this.bookCommentNumber = themeTextView2;
        this.bookCommentStatus = themeTextView3;
        this.bookCommentTime = themeTextView4;
        this.bookCommentTitle = themeTextView5;
        this.bookCommentTitleView = linearLayout2;
        this.bookCommentView = themeLinearLayout;
        this.bookCommentVote1 = imageView;
        this.bookCommentVote2 = imageView2;
        this.bookCommentVote3 = imageView3;
        this.bookCommentVote4 = imageView4;
        this.bookCommentVote5 = imageView5;
        this.bookVoteScore1 = themeTextView6;
        this.bookVoteScore2 = themeTextView7;
        this.bookVoteScoreHint = themeTextView8;
    }

    @NonNull
    public static PostCommentHeaderBinding bind(@NonNull View view) {
        int i10 = R.id.book_comment_hot;
        ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
        if (themeTextView != null) {
            i10 = R.id.book_comment_number;
            ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
            if (themeTextView2 != null) {
                i10 = R.id.book_comment_status;
                ThemeTextView themeTextView3 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (themeTextView3 != null) {
                    i10 = R.id.book_comment_time;
                    ThemeTextView themeTextView4 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                    if (themeTextView4 != null) {
                        i10 = R.id.book_comment_title;
                        ThemeTextView themeTextView5 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                        if (themeTextView5 != null) {
                            i10 = R.id.book_comment_title_view;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                            if (linearLayout != null) {
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
                                                        i10 = R.id.book_vote_score_1;
                                                        ThemeTextView themeTextView6 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                        if (themeTextView6 != null) {
                                                            i10 = R.id.book_vote_score_2;
                                                            ThemeTextView themeTextView7 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                            if (themeTextView7 != null) {
                                                                i10 = R.id.book_vote_score_hint;
                                                                ThemeTextView themeTextView8 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                if (themeTextView8 != null) {
                                                                    return new PostCommentHeaderBinding((LinearLayout) view, themeTextView, themeTextView2, themeTextView3, themeTextView4, themeTextView5, linearLayout, themeLinearLayout, imageView, imageView2, imageView3, imageView4, imageView5, themeTextView6, themeTextView7, themeTextView8);
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
    public static PostCommentHeaderBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static PostCommentHeaderBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.post_comment_header, viewGroup, false);
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
