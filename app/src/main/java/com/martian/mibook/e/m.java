package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.martian.mibook.ui.reader.ReaderLoadingTip;
import com.martian.mibook.ui.reader.ReaderThemeIRecyclerView;
import com.martian.mibook.ui.reader.ReaderThemeImageView;
import com.martian.mibook.ui.reader.ReaderThemeLinearLayout;
import com.martian.mibook.ui.reader.ReaderThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class m implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final CoordinatorLayout f12319a;

    /* renamed from: b */
    @NonNull
    public final RelativeLayout f12320b;

    /* renamed from: c */
    @NonNull
    public final ReaderThemeImageView f12321c;

    /* renamed from: d */
    @NonNull
    public final ReaderThemeTextView f12322d;

    /* renamed from: e */
    @NonNull
    public final ReaderThemeIRecyclerView f12323e;

    /* renamed from: f */
    @NonNull
    public final RelativeLayout f12324f;

    /* renamed from: g */
    @NonNull
    public final ReaderLoadingTip f12325g;

    /* renamed from: h */
    @NonNull
    public final ReaderThemeTextView f12326h;

    /* renamed from: i */
    @NonNull
    public final ReaderThemeLinearLayout f12327i;

    /* renamed from: j */
    @NonNull
    public final ReaderThemeLinearLayout f12328j;

    @NonNull
    public final ReaderThemeTextView k;

    @NonNull
    public final LinearLayout l;

    @NonNull
    public final ReaderThemeLinearLayout m;

    private m(@NonNull CoordinatorLayout rootView, @NonNull RelativeLayout bookDetailHeader, @NonNull ReaderThemeImageView chapterCommentClose, @NonNull ReaderThemeTextView chapterCommentHot, @NonNull ReaderThemeIRecyclerView chapterCommentIrc, @NonNull RelativeLayout chapterCommentListView, @NonNull ReaderLoadingTip chapterCommentLoadingTip, @NonNull ReaderThemeTextView chapterCommentNumber, @NonNull ReaderThemeLinearLayout chapterCommentPost, @NonNull ReaderThemeLinearLayout chapterCommentPostView, @NonNull ReaderThemeTextView chapterCommentTime, @NonNull LinearLayout chapterCommentTitleView, @NonNull ReaderThemeLinearLayout chapterCommentView) {
        this.f12319a = rootView;
        this.f12320b = bookDetailHeader;
        this.f12321c = chapterCommentClose;
        this.f12322d = chapterCommentHot;
        this.f12323e = chapterCommentIrc;
        this.f12324f = chapterCommentListView;
        this.f12325g = chapterCommentLoadingTip;
        this.f12326h = chapterCommentNumber;
        this.f12327i = chapterCommentPost;
        this.f12328j = chapterCommentPostView;
        this.k = chapterCommentTime;
        this.l = chapterCommentTitleView;
        this.m = chapterCommentView;
    }

    @NonNull
    public static m a(@NonNull View rootView) {
        int i2 = R.id.book_detail_header;
        RelativeLayout relativeLayout = (RelativeLayout) rootView.findViewById(R.id.book_detail_header);
        if (relativeLayout != null) {
            i2 = R.id.chapter_comment_close;
            ReaderThemeImageView readerThemeImageView = (ReaderThemeImageView) rootView.findViewById(R.id.chapter_comment_close);
            if (readerThemeImageView != null) {
                i2 = R.id.chapter_comment_hot;
                ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) rootView.findViewById(R.id.chapter_comment_hot);
                if (readerThemeTextView != null) {
                    i2 = R.id.chapter_comment_irc;
                    ReaderThemeIRecyclerView readerThemeIRecyclerView = (ReaderThemeIRecyclerView) rootView.findViewById(R.id.chapter_comment_irc);
                    if (readerThemeIRecyclerView != null) {
                        i2 = R.id.chapter_comment_list_view;
                        RelativeLayout relativeLayout2 = (RelativeLayout) rootView.findViewById(R.id.chapter_comment_list_view);
                        if (relativeLayout2 != null) {
                            i2 = R.id.chapter_comment_loading_tip;
                            ReaderLoadingTip readerLoadingTip = (ReaderLoadingTip) rootView.findViewById(R.id.chapter_comment_loading_tip);
                            if (readerLoadingTip != null) {
                                i2 = R.id.chapter_comment_number;
                                ReaderThemeTextView readerThemeTextView2 = (ReaderThemeTextView) rootView.findViewById(R.id.chapter_comment_number);
                                if (readerThemeTextView2 != null) {
                                    i2 = R.id.chapter_comment_post;
                                    ReaderThemeLinearLayout readerThemeLinearLayout = (ReaderThemeLinearLayout) rootView.findViewById(R.id.chapter_comment_post);
                                    if (readerThemeLinearLayout != null) {
                                        i2 = R.id.chapter_comment_post_view;
                                        ReaderThemeLinearLayout readerThemeLinearLayout2 = (ReaderThemeLinearLayout) rootView.findViewById(R.id.chapter_comment_post_view);
                                        if (readerThemeLinearLayout2 != null) {
                                            i2 = R.id.chapter_comment_time;
                                            ReaderThemeTextView readerThemeTextView3 = (ReaderThemeTextView) rootView.findViewById(R.id.chapter_comment_time);
                                            if (readerThemeTextView3 != null) {
                                                i2 = R.id.chapter_comment_title_view;
                                                LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.chapter_comment_title_view);
                                                if (linearLayout != null) {
                                                    i2 = R.id.chapter_comment_view;
                                                    ReaderThemeLinearLayout readerThemeLinearLayout3 = (ReaderThemeLinearLayout) rootView.findViewById(R.id.chapter_comment_view);
                                                    if (readerThemeLinearLayout3 != null) {
                                                        return new m((CoordinatorLayout) rootView, relativeLayout, readerThemeImageView, readerThemeTextView, readerThemeIRecyclerView, relativeLayout2, readerLoadingTip, readerThemeTextView2, readerThemeLinearLayout, readerThemeLinearLayout2, readerThemeTextView3, linearLayout, readerThemeLinearLayout3);
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
    public static m c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static m d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.activity_popupwindow_chapter_comment, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public CoordinatorLayout getRoot() {
        return this.f12319a;
    }
}
