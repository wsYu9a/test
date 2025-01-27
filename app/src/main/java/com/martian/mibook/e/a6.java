package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.widget.RoundedLayout;
import com.martian.mibook.ui.MyDrawTextView;
import com.martian.mibook.ui.reader.ReaderThemeLinearLayout;
import com.martian.mibook.ui.reader.ReaderThemeTextView;
import com.martian.ttbookhd.R;
import de.hdodenhof.circleimageview.CircleImageView;

/* loaded from: classes3.dex */
public final class a6 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final RelativeLayout f11702a;

    /* renamed from: b */
    @NonNull
    public final s5 f11703b;

    /* renamed from: c */
    @NonNull
    public final ReaderThemeTextView f11704c;

    /* renamed from: d */
    @NonNull
    public final LinearLayout f11705d;

    /* renamed from: e */
    @NonNull
    public final ReaderThemeLinearLayout f11706e;

    /* renamed from: f */
    @NonNull
    public final ReaderThemeTextView f11707f;

    /* renamed from: g */
    @NonNull
    public final CircleImageView f11708g;

    /* renamed from: h */
    @NonNull
    public final ReaderThemeTextView f11709h;

    /* renamed from: i */
    @NonNull
    public final ReaderThemeTextView f11710i;

    /* renamed from: j */
    @NonNull
    public final ReaderThemeLinearLayout f11711j;

    @NonNull
    public final RoundedLayout k;

    @NonNull
    public final ReaderThemeLinearLayout l;

    @NonNull
    public final LinearLayout m;

    @NonNull
    public final w3 n;

    @NonNull
    public final x3 o;

    @NonNull
    public final y3 p;

    @NonNull
    public final LinearLayout q;

    @NonNull
    public final u5 r;

    @NonNull
    public final z5 s;

    @NonNull
    public final LinearLayout t;

    @NonNull
    public final n5 u;

    @NonNull
    public final RelativeLayout v;

    @NonNull
    public final MyDrawTextView w;

    @NonNull
    public final ReaderThemeTextView x;

    @NonNull
    public final LinearLayout y;

    private a6(@NonNull RelativeLayout rootView, @NonNull s5 bookCoverView, @NonNull ReaderThemeTextView chapterComment, @NonNull LinearLayout chapterCommentRealView, @NonNull ReaderThemeLinearLayout chapterEndCommentsClickView, @NonNull ReaderThemeTextView chapterEndCommentsContent, @NonNull CircleImageView chapterEndCommentsHeader, @NonNull ReaderThemeTextView chapterEndCommentsNickname, @NonNull ReaderThemeTextView chapterEndCommentsNumber, @NonNull ReaderThemeLinearLayout chapterEndCommentsPost, @NonNull RoundedLayout chapterEndCommentsView, @NonNull ReaderThemeLinearLayout chapterPostCommentView, @NonNull LinearLayout llReadingContent, @NonNull w3 lyChapterLoadingActive, @NonNull x3 lyChapterLoadingFailure, @NonNull y3 lyChapterLoadingPurchase, @NonNull LinearLayout lyReadingBackground, @NonNull u5 lyReadingBottomStatus, @NonNull z5 lyReadingLastPage, @NonNull LinearLayout pbContentLoading, @NonNull n5 readingAdsLayout, @NonNull RelativeLayout rlReadingClick, @NonNull MyDrawTextView rtvContent, @NonNull ReaderThemeTextView tvReadingTitle, @NonNull LinearLayout tvReadingTitleView) {
        this.f11702a = rootView;
        this.f11703b = bookCoverView;
        this.f11704c = chapterComment;
        this.f11705d = chapterCommentRealView;
        this.f11706e = chapterEndCommentsClickView;
        this.f11707f = chapterEndCommentsContent;
        this.f11708g = chapterEndCommentsHeader;
        this.f11709h = chapterEndCommentsNickname;
        this.f11710i = chapterEndCommentsNumber;
        this.f11711j = chapterEndCommentsPost;
        this.k = chapterEndCommentsView;
        this.l = chapterPostCommentView;
        this.m = llReadingContent;
        this.n = lyChapterLoadingActive;
        this.o = lyChapterLoadingFailure;
        this.p = lyChapterLoadingPurchase;
        this.q = lyReadingBackground;
        this.r = lyReadingBottomStatus;
        this.s = lyReadingLastPage;
        this.t = pbContentLoading;
        this.u = readingAdsLayout;
        this.v = rlReadingClick;
        this.w = rtvContent;
        this.x = tvReadingTitle;
        this.y = tvReadingTitleView;
    }

    @NonNull
    public static a6 a(@NonNull View rootView) {
        int i2 = R.id.book_cover_view;
        View findViewById = rootView.findViewById(R.id.book_cover_view);
        if (findViewById != null) {
            s5 a2 = s5.a(findViewById);
            i2 = R.id.chapter_comment;
            ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) rootView.findViewById(R.id.chapter_comment);
            if (readerThemeTextView != null) {
                i2 = R.id.chapter_comment_real_view;
                LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.chapter_comment_real_view);
                if (linearLayout != null) {
                    i2 = R.id.chapter_end_comments_click_view;
                    ReaderThemeLinearLayout readerThemeLinearLayout = (ReaderThemeLinearLayout) rootView.findViewById(R.id.chapter_end_comments_click_view);
                    if (readerThemeLinearLayout != null) {
                        i2 = R.id.chapter_end_comments_content;
                        ReaderThemeTextView readerThemeTextView2 = (ReaderThemeTextView) rootView.findViewById(R.id.chapter_end_comments_content);
                        if (readerThemeTextView2 != null) {
                            i2 = R.id.chapter_end_comments_header;
                            CircleImageView circleImageView = (CircleImageView) rootView.findViewById(R.id.chapter_end_comments_header);
                            if (circleImageView != null) {
                                i2 = R.id.chapter_end_comments_nickname;
                                ReaderThemeTextView readerThemeTextView3 = (ReaderThemeTextView) rootView.findViewById(R.id.chapter_end_comments_nickname);
                                if (readerThemeTextView3 != null) {
                                    i2 = R.id.chapter_end_comments_number;
                                    ReaderThemeTextView readerThemeTextView4 = (ReaderThemeTextView) rootView.findViewById(R.id.chapter_end_comments_number);
                                    if (readerThemeTextView4 != null) {
                                        i2 = R.id.chapter_end_comments_post;
                                        ReaderThemeLinearLayout readerThemeLinearLayout2 = (ReaderThemeLinearLayout) rootView.findViewById(R.id.chapter_end_comments_post);
                                        if (readerThemeLinearLayout2 != null) {
                                            i2 = R.id.chapter_end_comments_view;
                                            RoundedLayout roundedLayout = (RoundedLayout) rootView.findViewById(R.id.chapter_end_comments_view);
                                            if (roundedLayout != null) {
                                                i2 = R.id.chapter_post_comment_view;
                                                ReaderThemeLinearLayout readerThemeLinearLayout3 = (ReaderThemeLinearLayout) rootView.findViewById(R.id.chapter_post_comment_view);
                                                if (readerThemeLinearLayout3 != null) {
                                                    i2 = R.id.ll_reading_content;
                                                    LinearLayout linearLayout2 = (LinearLayout) rootView.findViewById(R.id.ll_reading_content);
                                                    if (linearLayout2 != null) {
                                                        i2 = R.id.ly_chapter_loading_active;
                                                        View findViewById2 = rootView.findViewById(R.id.ly_chapter_loading_active);
                                                        if (findViewById2 != null) {
                                                            w3 a3 = w3.a(findViewById2);
                                                            i2 = R.id.ly_chapter_loading_failure;
                                                            View findViewById3 = rootView.findViewById(R.id.ly_chapter_loading_failure);
                                                            if (findViewById3 != null) {
                                                                x3 a4 = x3.a(findViewById3);
                                                                i2 = R.id.ly_chapter_loading_purchase;
                                                                View findViewById4 = rootView.findViewById(R.id.ly_chapter_loading_purchase);
                                                                if (findViewById4 != null) {
                                                                    y3 a5 = y3.a(findViewById4);
                                                                    i2 = R.id.ly_reading_background;
                                                                    LinearLayout linearLayout3 = (LinearLayout) rootView.findViewById(R.id.ly_reading_background);
                                                                    if (linearLayout3 != null) {
                                                                        i2 = R.id.ly_reading_bottom_status;
                                                                        View findViewById5 = rootView.findViewById(R.id.ly_reading_bottom_status);
                                                                        if (findViewById5 != null) {
                                                                            u5 a6 = u5.a(findViewById5);
                                                                            i2 = R.id.ly_reading_last_page;
                                                                            View findViewById6 = rootView.findViewById(R.id.ly_reading_last_page);
                                                                            if (findViewById6 != null) {
                                                                                z5 a7 = z5.a(findViewById6);
                                                                                i2 = R.id.pb_content_loading;
                                                                                LinearLayout linearLayout4 = (LinearLayout) rootView.findViewById(R.id.pb_content_loading);
                                                                                if (linearLayout4 != null) {
                                                                                    i2 = R.id.reading_ads_layout;
                                                                                    View findViewById7 = rootView.findViewById(R.id.reading_ads_layout);
                                                                                    if (findViewById7 != null) {
                                                                                        n5 a8 = n5.a(findViewById7);
                                                                                        i2 = R.id.rl_reading_click;
                                                                                        RelativeLayout relativeLayout = (RelativeLayout) rootView.findViewById(R.id.rl_reading_click);
                                                                                        if (relativeLayout != null) {
                                                                                            i2 = R.id.rtv_content;
                                                                                            MyDrawTextView myDrawTextView = (MyDrawTextView) rootView.findViewById(R.id.rtv_content);
                                                                                            if (myDrawTextView != null) {
                                                                                                i2 = R.id.tv_reading_title;
                                                                                                ReaderThemeTextView readerThemeTextView5 = (ReaderThemeTextView) rootView.findViewById(R.id.tv_reading_title);
                                                                                                if (readerThemeTextView5 != null) {
                                                                                                    i2 = R.id.tv_reading_title_view;
                                                                                                    LinearLayout linearLayout5 = (LinearLayout) rootView.findViewById(R.id.tv_reading_title_view);
                                                                                                    if (linearLayout5 != null) {
                                                                                                        return new a6((RelativeLayout) rootView, a2, readerThemeTextView, linearLayout, readerThemeLinearLayout, readerThemeTextView2, circleImageView, readerThemeTextView3, readerThemeTextView4, readerThemeLinearLayout2, roundedLayout, readerThemeLinearLayout3, linearLayout2, a3, a4, a5, linearLayout3, a6, a7, linearLayout4, a8, relativeLayout, myDrawTextView, readerThemeTextView5, linearLayout5);
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
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static a6 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static a6 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.reading_layout, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f11702a;
    }
}
