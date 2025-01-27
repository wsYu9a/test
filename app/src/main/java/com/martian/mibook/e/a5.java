package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.mibook.ui.reader.ReaderThemeImageView;
import com.martian.mibook.ui.reader.ReaderThemeLinearLayout;
import com.martian.mibook.ui.reader.ReaderThemeTextView;
import com.martian.ttbookhd.R;
import de.hdodenhof.circleimageview.CircleImageView;

/* loaded from: classes3.dex */
public final class a5 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f11692a;

    /* renamed from: b */
    @NonNull
    public final ThemeImageView f11693b;

    /* renamed from: c */
    @NonNull
    public final ReaderThemeTextView f11694c;

    /* renamed from: d */
    @NonNull
    public final View f11695d;

    /* renamed from: e */
    @NonNull
    public final ReaderThemeTextView f11696e;

    /* renamed from: f */
    @NonNull
    public final ReaderThemeTextView f11697f;

    /* renamed from: g */
    @NonNull
    public final LinearLayout f11698g;

    /* renamed from: h */
    @NonNull
    public final ReaderThemeImageView f11699h;

    /* renamed from: i */
    @NonNull
    public final ReaderThemeTextView f11700i;

    /* renamed from: j */
    @NonNull
    public final LinearLayout f11701j;

    @NonNull
    public final ReaderThemeLinearLayout k;

    @NonNull
    public final ImageView l;

    @NonNull
    public final TextView m;

    @NonNull
    public final CircleImageView n;

    @NonNull
    public final ImageView o;

    @NonNull
    public final TextView p;

    @NonNull
    public final ImageView q;

    @NonNull
    public final LinearLayout r;

    @NonNull
    public final ReaderThemeTextView s;

    @NonNull
    public final ReaderThemeLinearLayout t;

    @NonNull
    public final ReaderThemeTextView u;

    @NonNull
    public final ReaderThemeLinearLayout v;

    @NonNull
    public final LinearLayout w;

    @NonNull
    public final ReaderThemeImageView x;

    private a5(@NonNull LinearLayout rootView, @NonNull ThemeImageView bdCommentLine, @NonNull ReaderThemeTextView bdCommentTime, @NonNull View bdIntroGradual, @NonNull ReaderThemeTextView bdNickname, @NonNull ReaderThemeTextView bdReaderComment, @NonNull LinearLayout bdReaderCommentMore, @NonNull ReaderThemeImageView bdReply, @NonNull ReaderThemeTextView bdReplyNum, @NonNull LinearLayout bdReplyView, @NonNull ReaderThemeLinearLayout bdReport, @NonNull ImageView bdSift, @NonNull TextView bdTag, @NonNull CircleImageView bdUserHeader, @NonNull ImageView bdVipTag, @NonNull TextView bdVoteUpcount, @NonNull ImageView bdVoteUpcountImage, @NonNull LinearLayout bdVoteView, @NonNull ReaderThemeTextView commentReply, @NonNull ReaderThemeLinearLayout commentReplyMore, @NonNull ReaderThemeTextView commentReplyMoreContent, @NonNull ReaderThemeLinearLayout commentReplyView, @NonNull LinearLayout commentRootView, @NonNull ReaderThemeImageView expandCollapse) {
        this.f11692a = rootView;
        this.f11693b = bdCommentLine;
        this.f11694c = bdCommentTime;
        this.f11695d = bdIntroGradual;
        this.f11696e = bdNickname;
        this.f11697f = bdReaderComment;
        this.f11698g = bdReaderCommentMore;
        this.f11699h = bdReply;
        this.f11700i = bdReplyNum;
        this.f11701j = bdReplyView;
        this.k = bdReport;
        this.l = bdSift;
        this.m = bdTag;
        this.n = bdUserHeader;
        this.o = bdVipTag;
        this.p = bdVoteUpcount;
        this.q = bdVoteUpcountImage;
        this.r = bdVoteView;
        this.s = commentReply;
        this.t = commentReplyMore;
        this.u = commentReplyMoreContent;
        this.v = commentReplyView;
        this.w = commentRootView;
        this.x = expandCollapse;
    }

    @NonNull
    public static a5 a(@NonNull View rootView) {
        int i2 = R.id.bd_comment_line;
        ThemeImageView themeImageView = (ThemeImageView) rootView.findViewById(R.id.bd_comment_line);
        if (themeImageView != null) {
            i2 = R.id.bd_comment_time;
            ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) rootView.findViewById(R.id.bd_comment_time);
            if (readerThemeTextView != null) {
                i2 = R.id.bd_intro_gradual;
                View findViewById = rootView.findViewById(R.id.bd_intro_gradual);
                if (findViewById != null) {
                    i2 = R.id.bd_nickname;
                    ReaderThemeTextView readerThemeTextView2 = (ReaderThemeTextView) rootView.findViewById(R.id.bd_nickname);
                    if (readerThemeTextView2 != null) {
                        i2 = R.id.bd_reader_comment;
                        ReaderThemeTextView readerThemeTextView3 = (ReaderThemeTextView) rootView.findViewById(R.id.bd_reader_comment);
                        if (readerThemeTextView3 != null) {
                            i2 = R.id.bd_reader_comment_more;
                            LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.bd_reader_comment_more);
                            if (linearLayout != null) {
                                i2 = R.id.bd_reply;
                                ReaderThemeImageView readerThemeImageView = (ReaderThemeImageView) rootView.findViewById(R.id.bd_reply);
                                if (readerThemeImageView != null) {
                                    i2 = R.id.bd_reply_num;
                                    ReaderThemeTextView readerThemeTextView4 = (ReaderThemeTextView) rootView.findViewById(R.id.bd_reply_num);
                                    if (readerThemeTextView4 != null) {
                                        i2 = R.id.bd_reply_view;
                                        LinearLayout linearLayout2 = (LinearLayout) rootView.findViewById(R.id.bd_reply_view);
                                        if (linearLayout2 != null) {
                                            i2 = R.id.bd_report;
                                            ReaderThemeLinearLayout readerThemeLinearLayout = (ReaderThemeLinearLayout) rootView.findViewById(R.id.bd_report);
                                            if (readerThemeLinearLayout != null) {
                                                i2 = R.id.bd_sift;
                                                ImageView imageView = (ImageView) rootView.findViewById(R.id.bd_sift);
                                                if (imageView != null) {
                                                    i2 = R.id.bd_tag;
                                                    TextView textView = (TextView) rootView.findViewById(R.id.bd_tag);
                                                    if (textView != null) {
                                                        i2 = R.id.bd_user_header;
                                                        CircleImageView circleImageView = (CircleImageView) rootView.findViewById(R.id.bd_user_header);
                                                        if (circleImageView != null) {
                                                            i2 = R.id.bd_vip_tag;
                                                            ImageView imageView2 = (ImageView) rootView.findViewById(R.id.bd_vip_tag);
                                                            if (imageView2 != null) {
                                                                i2 = R.id.bd_vote_upcount;
                                                                TextView textView2 = (TextView) rootView.findViewById(R.id.bd_vote_upcount);
                                                                if (textView2 != null) {
                                                                    i2 = R.id.bd_vote_upcount_image;
                                                                    ImageView imageView3 = (ImageView) rootView.findViewById(R.id.bd_vote_upcount_image);
                                                                    if (imageView3 != null) {
                                                                        i2 = R.id.bd_vote_view;
                                                                        LinearLayout linearLayout3 = (LinearLayout) rootView.findViewById(R.id.bd_vote_view);
                                                                        if (linearLayout3 != null) {
                                                                            i2 = R.id.comment_reply;
                                                                            ReaderThemeTextView readerThemeTextView5 = (ReaderThemeTextView) rootView.findViewById(R.id.comment_reply);
                                                                            if (readerThemeTextView5 != null) {
                                                                                i2 = R.id.comment_reply_more;
                                                                                ReaderThemeLinearLayout readerThemeLinearLayout2 = (ReaderThemeLinearLayout) rootView.findViewById(R.id.comment_reply_more);
                                                                                if (readerThemeLinearLayout2 != null) {
                                                                                    i2 = R.id.comment_reply_more_content;
                                                                                    ReaderThemeTextView readerThemeTextView6 = (ReaderThemeTextView) rootView.findViewById(R.id.comment_reply_more_content);
                                                                                    if (readerThemeTextView6 != null) {
                                                                                        i2 = R.id.comment_reply_view;
                                                                                        ReaderThemeLinearLayout readerThemeLinearLayout3 = (ReaderThemeLinearLayout) rootView.findViewById(R.id.comment_reply_view);
                                                                                        if (readerThemeLinearLayout3 != null) {
                                                                                            LinearLayout linearLayout4 = (LinearLayout) rootView;
                                                                                            i2 = R.id.expand_collapse;
                                                                                            ReaderThemeImageView readerThemeImageView2 = (ReaderThemeImageView) rootView.findViewById(R.id.expand_collapse);
                                                                                            if (readerThemeImageView2 != null) {
                                                                                                return new a5(linearLayout4, themeImageView, readerThemeTextView, findViewById, readerThemeTextView2, readerThemeTextView3, linearLayout, readerThemeImageView, readerThemeTextView4, linearLayout2, readerThemeLinearLayout, imageView, textView, circleImageView, imageView2, textView2, imageView3, linearLayout3, readerThemeTextView5, readerThemeLinearLayout2, readerThemeTextView6, readerThemeLinearLayout3, linearLayout4, readerThemeImageView2);
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
    public static a5 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static a5 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.reader_chapter_comment_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f11692a;
    }
}
