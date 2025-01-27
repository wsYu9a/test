package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class y4 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f12983a;

    /* renamed from: b */
    @NonNull
    public final ThemeTextView f12984b;

    /* renamed from: c */
    @NonNull
    public final ThemeTextView f12985c;

    /* renamed from: d */
    @NonNull
    public final ThemeTextView f12986d;

    /* renamed from: e */
    @NonNull
    public final ThemeTextView f12987e;

    /* renamed from: f */
    @NonNull
    public final ThemeTextView f12988f;

    /* renamed from: g */
    @NonNull
    public final LinearLayout f12989g;

    /* renamed from: h */
    @NonNull
    public final ThemeLinearLayout f12990h;

    /* renamed from: i */
    @NonNull
    public final ImageView f12991i;

    /* renamed from: j */
    @NonNull
    public final ImageView f12992j;

    @NonNull
    public final ImageView k;

    @NonNull
    public final ImageView l;

    @NonNull
    public final ImageView m;

    @NonNull
    public final ThemeTextView n;

    @NonNull
    public final ThemeTextView o;

    @NonNull
    public final ThemeTextView p;

    private y4(@NonNull LinearLayout rootView, @NonNull ThemeTextView bookCommentHot, @NonNull ThemeTextView bookCommentNumber, @NonNull ThemeTextView bookCommentStatus, @NonNull ThemeTextView bookCommentTime, @NonNull ThemeTextView bookCommentTitle, @NonNull LinearLayout bookCommentTitleView, @NonNull ThemeLinearLayout bookCommentView, @NonNull ImageView bookCommentVote1, @NonNull ImageView bookCommentVote2, @NonNull ImageView bookCommentVote3, @NonNull ImageView bookCommentVote4, @NonNull ImageView bookCommentVote5, @NonNull ThemeTextView bookVoteScore1, @NonNull ThemeTextView bookVoteScore2, @NonNull ThemeTextView bookVoteScoreHint) {
        this.f12983a = rootView;
        this.f12984b = bookCommentHot;
        this.f12985c = bookCommentNumber;
        this.f12986d = bookCommentStatus;
        this.f12987e = bookCommentTime;
        this.f12988f = bookCommentTitle;
        this.f12989g = bookCommentTitleView;
        this.f12990h = bookCommentView;
        this.f12991i = bookCommentVote1;
        this.f12992j = bookCommentVote2;
        this.k = bookCommentVote3;
        this.l = bookCommentVote4;
        this.m = bookCommentVote5;
        this.n = bookVoteScore1;
        this.o = bookVoteScore2;
        this.p = bookVoteScoreHint;
    }

    @NonNull
    public static y4 a(@NonNull View rootView) {
        int i2 = R.id.book_comment_hot;
        ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.book_comment_hot);
        if (themeTextView != null) {
            i2 = R.id.book_comment_number;
            ThemeTextView themeTextView2 = (ThemeTextView) rootView.findViewById(R.id.book_comment_number);
            if (themeTextView2 != null) {
                i2 = R.id.book_comment_status;
                ThemeTextView themeTextView3 = (ThemeTextView) rootView.findViewById(R.id.book_comment_status);
                if (themeTextView3 != null) {
                    i2 = R.id.book_comment_time;
                    ThemeTextView themeTextView4 = (ThemeTextView) rootView.findViewById(R.id.book_comment_time);
                    if (themeTextView4 != null) {
                        i2 = R.id.book_comment_title;
                        ThemeTextView themeTextView5 = (ThemeTextView) rootView.findViewById(R.id.book_comment_title);
                        if (themeTextView5 != null) {
                            i2 = R.id.book_comment_title_view;
                            LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.book_comment_title_view);
                            if (linearLayout != null) {
                                i2 = R.id.book_comment_view;
                                ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) rootView.findViewById(R.id.book_comment_view);
                                if (themeLinearLayout != null) {
                                    i2 = R.id.book_comment_vote_1;
                                    ImageView imageView = (ImageView) rootView.findViewById(R.id.book_comment_vote_1);
                                    if (imageView != null) {
                                        i2 = R.id.book_comment_vote_2;
                                        ImageView imageView2 = (ImageView) rootView.findViewById(R.id.book_comment_vote_2);
                                        if (imageView2 != null) {
                                            i2 = R.id.book_comment_vote_3;
                                            ImageView imageView3 = (ImageView) rootView.findViewById(R.id.book_comment_vote_3);
                                            if (imageView3 != null) {
                                                i2 = R.id.book_comment_vote_4;
                                                ImageView imageView4 = (ImageView) rootView.findViewById(R.id.book_comment_vote_4);
                                                if (imageView4 != null) {
                                                    i2 = R.id.book_comment_vote_5;
                                                    ImageView imageView5 = (ImageView) rootView.findViewById(R.id.book_comment_vote_5);
                                                    if (imageView5 != null) {
                                                        i2 = R.id.book_vote_score_1;
                                                        ThemeTextView themeTextView6 = (ThemeTextView) rootView.findViewById(R.id.book_vote_score_1);
                                                        if (themeTextView6 != null) {
                                                            i2 = R.id.book_vote_score_2;
                                                            ThemeTextView themeTextView7 = (ThemeTextView) rootView.findViewById(R.id.book_vote_score_2);
                                                            if (themeTextView7 != null) {
                                                                i2 = R.id.book_vote_score_hint;
                                                                ThemeTextView themeTextView8 = (ThemeTextView) rootView.findViewById(R.id.book_vote_score_hint);
                                                                if (themeTextView8 != null) {
                                                                    return new y4((LinearLayout) rootView, themeTextView, themeTextView2, themeTextView3, themeTextView4, themeTextView5, linearLayout, themeLinearLayout, imageView, imageView2, imageView3, imageView4, imageView5, themeTextView6, themeTextView7, themeTextView8);
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
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static y4 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static y4 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.post_comment_header, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f12983a;
    }
}
