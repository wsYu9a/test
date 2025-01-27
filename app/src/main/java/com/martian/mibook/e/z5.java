package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.mibook.ui.reader.ReaderThemeImageView;
import com.martian.mibook.ui.reader.ReaderThemeItemTextView;
import com.martian.mibook.ui.reader.ReaderThemeLinearLayout;
import com.martian.mibook.ui.reader.ReaderThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class z5 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final FrameLayout f13021a;

    /* renamed from: b */
    @NonNull
    public final LinearLayout f13022b;

    /* renamed from: c */
    @NonNull
    public final LinearLayout f13023c;

    /* renamed from: d */
    @Nullable
    public final LinearLayout f13024d;

    /* renamed from: e */
    @NonNull
    public final ReaderThemeImageView f13025e;

    /* renamed from: f */
    @NonNull
    public final LinearLayout f13026f;

    /* renamed from: g */
    @NonNull
    public final ReaderThemeTextView f13027g;

    /* renamed from: h */
    @NonNull
    public final ReaderThemeImageView f13028h;

    /* renamed from: i */
    @NonNull
    public final ReaderThemeTextView f13029i;

    /* renamed from: j */
    @NonNull
    public final ReaderThemeLinearLayout f13030j;

    @NonNull
    public final ReaderThemeTextView k;

    @NonNull
    public final LinearLayout l;

    @Nullable
    public final RelativeLayout m;

    @NonNull
    public final ReaderThemeTextView n;

    @NonNull
    public final LinearLayout o;

    @NonNull
    public final ReaderThemeImageView p;

    @NonNull
    public final ReaderThemeLinearLayout q;

    @Nullable
    public final ReaderThemeTextView r;

    @NonNull
    public final ReaderThemeItemTextView s;

    @NonNull
    public final ReaderThemeTextView t;

    @NonNull
    public final ReaderThemeImageView u;

    @NonNull
    public final ProgressBar v;

    private z5(@NonNull FrameLayout rootView, @NonNull LinearLayout llLastPageAdsContainer, @NonNull LinearLayout llLastPageBooksContainer, @Nullable LinearLayout lyLastPageBackground, @NonNull ReaderThemeImageView readingEndClose, @NonNull LinearLayout readingEndComment, @NonNull ReaderThemeTextView readingEndCommentDesc, @NonNull ReaderThemeImageView readingEndCommentIcon, @NonNull ReaderThemeTextView readingEndCommentNumber, @NonNull ReaderThemeLinearLayout readingEndCommentView, @NonNull ReaderThemeTextView readingEndDesc, @NonNull LinearLayout readingEndFunctionView, @Nullable RelativeLayout readingEndHeaderView, @NonNull ReaderThemeTextView readingEndTitle, @NonNull LinearLayout recommendView, @NonNull ReaderThemeImageView rulesIcon, @NonNull ReaderThemeLinearLayout rulesView, @Nullable ReaderThemeTextView tvAlikeDesc, @NonNull ReaderThemeItemTextView tvPostComment, @NonNull ReaderThemeTextView tvSwitchMore, @NonNull ReaderThemeImageView tvSwitchMoreLoan, @NonNull ProgressBar tvSwitchMoreProgressbar) {
        this.f13021a = rootView;
        this.f13022b = llLastPageAdsContainer;
        this.f13023c = llLastPageBooksContainer;
        this.f13024d = lyLastPageBackground;
        this.f13025e = readingEndClose;
        this.f13026f = readingEndComment;
        this.f13027g = readingEndCommentDesc;
        this.f13028h = readingEndCommentIcon;
        this.f13029i = readingEndCommentNumber;
        this.f13030j = readingEndCommentView;
        this.k = readingEndDesc;
        this.l = readingEndFunctionView;
        this.m = readingEndHeaderView;
        this.n = readingEndTitle;
        this.o = recommendView;
        this.p = rulesIcon;
        this.q = rulesView;
        this.r = tvAlikeDesc;
        this.s = tvPostComment;
        this.t = tvSwitchMore;
        this.u = tvSwitchMoreLoan;
        this.v = tvSwitchMoreProgressbar;
    }

    @NonNull
    public static z5 a(@NonNull View rootView) {
        int i2 = R.id.ll_last_page_ads_container;
        LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.ll_last_page_ads_container);
        if (linearLayout != null) {
            i2 = R.id.ll_last_page_books_container;
            LinearLayout linearLayout2 = (LinearLayout) rootView.findViewById(R.id.ll_last_page_books_container);
            if (linearLayout2 != null) {
                LinearLayout linearLayout3 = (LinearLayout) rootView.findViewById(R.id.ly_last_page_background);
                i2 = R.id.reading_end_close;
                ReaderThemeImageView readerThemeImageView = (ReaderThemeImageView) rootView.findViewById(R.id.reading_end_close);
                if (readerThemeImageView != null) {
                    i2 = R.id.reading_end_comment;
                    LinearLayout linearLayout4 = (LinearLayout) rootView.findViewById(R.id.reading_end_comment);
                    if (linearLayout4 != null) {
                        i2 = R.id.reading_end_comment_desc;
                        ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) rootView.findViewById(R.id.reading_end_comment_desc);
                        if (readerThemeTextView != null) {
                            i2 = R.id.reading_end_comment_icon;
                            ReaderThemeImageView readerThemeImageView2 = (ReaderThemeImageView) rootView.findViewById(R.id.reading_end_comment_icon);
                            if (readerThemeImageView2 != null) {
                                i2 = R.id.reading_end_comment_number;
                                ReaderThemeTextView readerThemeTextView2 = (ReaderThemeTextView) rootView.findViewById(R.id.reading_end_comment_number);
                                if (readerThemeTextView2 != null) {
                                    i2 = R.id.reading_end_comment_view;
                                    ReaderThemeLinearLayout readerThemeLinearLayout = (ReaderThemeLinearLayout) rootView.findViewById(R.id.reading_end_comment_view);
                                    if (readerThemeLinearLayout != null) {
                                        i2 = R.id.reading_end_desc;
                                        ReaderThemeTextView readerThemeTextView3 = (ReaderThemeTextView) rootView.findViewById(R.id.reading_end_desc);
                                        if (readerThemeTextView3 != null) {
                                            i2 = R.id.reading_end_function_view;
                                            LinearLayout linearLayout5 = (LinearLayout) rootView.findViewById(R.id.reading_end_function_view);
                                            if (linearLayout5 != null) {
                                                RelativeLayout relativeLayout = (RelativeLayout) rootView.findViewById(R.id.reading_end_header_view);
                                                i2 = R.id.reading_end_title;
                                                ReaderThemeTextView readerThemeTextView4 = (ReaderThemeTextView) rootView.findViewById(R.id.reading_end_title);
                                                if (readerThemeTextView4 != null) {
                                                    i2 = R.id.recommend_view;
                                                    LinearLayout linearLayout6 = (LinearLayout) rootView.findViewById(R.id.recommend_view);
                                                    if (linearLayout6 != null) {
                                                        i2 = R.id.rules_icon;
                                                        ReaderThemeImageView readerThemeImageView3 = (ReaderThemeImageView) rootView.findViewById(R.id.rules_icon);
                                                        if (readerThemeImageView3 != null) {
                                                            i2 = R.id.rules_view;
                                                            ReaderThemeLinearLayout readerThemeLinearLayout2 = (ReaderThemeLinearLayout) rootView.findViewById(R.id.rules_view);
                                                            if (readerThemeLinearLayout2 != null) {
                                                                ReaderThemeTextView readerThemeTextView5 = (ReaderThemeTextView) rootView.findViewById(R.id.tv_alike_desc);
                                                                i2 = R.id.tv_post_comment;
                                                                ReaderThemeItemTextView readerThemeItemTextView = (ReaderThemeItemTextView) rootView.findViewById(R.id.tv_post_comment);
                                                                if (readerThemeItemTextView != null) {
                                                                    i2 = R.id.tv_switch_more;
                                                                    ReaderThemeTextView readerThemeTextView6 = (ReaderThemeTextView) rootView.findViewById(R.id.tv_switch_more);
                                                                    if (readerThemeTextView6 != null) {
                                                                        i2 = R.id.tv_switch_more_loan;
                                                                        ReaderThemeImageView readerThemeImageView4 = (ReaderThemeImageView) rootView.findViewById(R.id.tv_switch_more_loan);
                                                                        if (readerThemeImageView4 != null) {
                                                                            i2 = R.id.tv_switch_more_progressbar;
                                                                            ProgressBar progressBar = (ProgressBar) rootView.findViewById(R.id.tv_switch_more_progressbar);
                                                                            if (progressBar != null) {
                                                                                return new z5((FrameLayout) rootView, linearLayout, linearLayout2, linearLayout3, readerThemeImageView, linearLayout4, readerThemeTextView, readerThemeImageView2, readerThemeTextView2, readerThemeLinearLayout, readerThemeTextView3, linearLayout5, relativeLayout, readerThemeTextView4, linearLayout6, readerThemeImageView3, readerThemeLinearLayout2, readerThemeTextView5, readerThemeItemTextView, readerThemeTextView6, readerThemeImageView4, progressBar);
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
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static z5 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static z5 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.reading_last_page, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public FrameLayout getRoot() {
        return this.f13021a;
    }
}
