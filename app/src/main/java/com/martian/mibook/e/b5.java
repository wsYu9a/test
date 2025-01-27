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
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.ttbookhd.R;
import de.hdodenhof.circleimageview.CircleImageView;

/* loaded from: classes3.dex */
public final class b5 implements ViewBinding {

    @NonNull
    public final ThemeTextView A;

    @NonNull
    public final ImageView B;

    @NonNull
    public final ThemeLinearLayout C;

    @NonNull
    public final LinearLayout D;

    @NonNull
    public final ThemeImageView E;

    /* renamed from: a */
    @NonNull
    private final LinearLayout f11751a;

    /* renamed from: b */
    @NonNull
    public final ThemeImageView f11752b;

    /* renamed from: c */
    @NonNull
    public final ThemeTextView f11753c;

    /* renamed from: d */
    @NonNull
    public final View f11754d;

    /* renamed from: e */
    @NonNull
    public final ThemeTextView f11755e;

    /* renamed from: f */
    @NonNull
    public final ThemeTextView f11756f;

    /* renamed from: g */
    @NonNull
    public final ThemeTextView f11757g;

    /* renamed from: h */
    @NonNull
    public final LinearLayout f11758h;

    /* renamed from: i */
    @NonNull
    public final ImageView f11759i;

    /* renamed from: j */
    @NonNull
    public final ThemeTextView f11760j;

    @NonNull
    public final LinearLayout k;

    @NonNull
    public final ThemeLinearLayout l;

    @NonNull
    public final ImageView m;

    @NonNull
    public final TextView n;

    @NonNull
    public final CircleImageView o;

    @NonNull
    public final ImageView p;

    @NonNull
    public final ImageView q;

    @NonNull
    public final ImageView r;

    @NonNull
    public final ImageView s;

    @NonNull
    public final ImageView t;

    @NonNull
    public final ImageView u;

    @NonNull
    public final TextView v;

    @NonNull
    public final ThemeImageView w;

    @NonNull
    public final LinearLayout x;

    @NonNull
    public final ThemeTextView y;

    @NonNull
    public final ThemeLinearLayout z;

    private b5(@NonNull LinearLayout rootView, @NonNull ThemeImageView bdCommentLine, @NonNull ThemeTextView bdCommentTime, @NonNull View bdIntroGradual, @NonNull ThemeTextView bdNickname, @NonNull ThemeTextView bdReadTime, @NonNull ThemeTextView bdReaderComment, @NonNull LinearLayout bdReaderCommentMore, @NonNull ImageView bdReply, @NonNull ThemeTextView bdReplyNum, @NonNull LinearLayout bdReplyView, @NonNull ThemeLinearLayout bdReport, @NonNull ImageView bdSift, @NonNull TextView bdTag, @NonNull CircleImageView bdUserHeader, @NonNull ImageView bdVipTag, @NonNull ImageView bdVote1, @NonNull ImageView bdVote2, @NonNull ImageView bdVote3, @NonNull ImageView bdVote4, @NonNull ImageView bdVote5, @NonNull TextView bdVoteUpcount, @NonNull ThemeImageView bdVoteUpcountImage, @NonNull LinearLayout bdVoteView, @NonNull ThemeTextView commentReply, @NonNull ThemeLinearLayout commentReplyMore, @NonNull ThemeTextView commentReplyMoreContent, @NonNull ImageView commentReplyMoreIcon, @NonNull ThemeLinearLayout commentReplyView, @NonNull LinearLayout commentRootView, @NonNull ThemeImageView expandCollapse) {
        this.f11751a = rootView;
        this.f11752b = bdCommentLine;
        this.f11753c = bdCommentTime;
        this.f11754d = bdIntroGradual;
        this.f11755e = bdNickname;
        this.f11756f = bdReadTime;
        this.f11757g = bdReaderComment;
        this.f11758h = bdReaderCommentMore;
        this.f11759i = bdReply;
        this.f11760j = bdReplyNum;
        this.k = bdReplyView;
        this.l = bdReport;
        this.m = bdSift;
        this.n = bdTag;
        this.o = bdUserHeader;
        this.p = bdVipTag;
        this.q = bdVote1;
        this.r = bdVote2;
        this.s = bdVote3;
        this.t = bdVote4;
        this.u = bdVote5;
        this.v = bdVoteUpcount;
        this.w = bdVoteUpcountImage;
        this.x = bdVoteView;
        this.y = commentReply;
        this.z = commentReplyMore;
        this.A = commentReplyMoreContent;
        this.B = commentReplyMoreIcon;
        this.C = commentReplyView;
        this.D = commentRootView;
        this.E = expandCollapse;
    }

    @NonNull
    public static b5 a(@NonNull View rootView) {
        int i2 = R.id.bd_comment_line;
        ThemeImageView themeImageView = (ThemeImageView) rootView.findViewById(R.id.bd_comment_line);
        if (themeImageView != null) {
            i2 = R.id.bd_comment_time;
            ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.bd_comment_time);
            if (themeTextView != null) {
                i2 = R.id.bd_intro_gradual;
                View findViewById = rootView.findViewById(R.id.bd_intro_gradual);
                if (findViewById != null) {
                    i2 = R.id.bd_nickname;
                    ThemeTextView themeTextView2 = (ThemeTextView) rootView.findViewById(R.id.bd_nickname);
                    if (themeTextView2 != null) {
                        i2 = R.id.bd_read_time;
                        ThemeTextView themeTextView3 = (ThemeTextView) rootView.findViewById(R.id.bd_read_time);
                        if (themeTextView3 != null) {
                            i2 = R.id.bd_reader_comment;
                            ThemeTextView themeTextView4 = (ThemeTextView) rootView.findViewById(R.id.bd_reader_comment);
                            if (themeTextView4 != null) {
                                i2 = R.id.bd_reader_comment_more;
                                LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.bd_reader_comment_more);
                                if (linearLayout != null) {
                                    i2 = R.id.bd_reply;
                                    ImageView imageView = (ImageView) rootView.findViewById(R.id.bd_reply);
                                    if (imageView != null) {
                                        i2 = R.id.bd_reply_num;
                                        ThemeTextView themeTextView5 = (ThemeTextView) rootView.findViewById(R.id.bd_reply_num);
                                        if (themeTextView5 != null) {
                                            i2 = R.id.bd_reply_view;
                                            LinearLayout linearLayout2 = (LinearLayout) rootView.findViewById(R.id.bd_reply_view);
                                            if (linearLayout2 != null) {
                                                i2 = R.id.bd_report;
                                                ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) rootView.findViewById(R.id.bd_report);
                                                if (themeLinearLayout != null) {
                                                    i2 = R.id.bd_sift;
                                                    ImageView imageView2 = (ImageView) rootView.findViewById(R.id.bd_sift);
                                                    if (imageView2 != null) {
                                                        i2 = R.id.bd_tag;
                                                        TextView textView = (TextView) rootView.findViewById(R.id.bd_tag);
                                                        if (textView != null) {
                                                            i2 = R.id.bd_user_header;
                                                            CircleImageView circleImageView = (CircleImageView) rootView.findViewById(R.id.bd_user_header);
                                                            if (circleImageView != null) {
                                                                i2 = R.id.bd_vip_tag;
                                                                ImageView imageView3 = (ImageView) rootView.findViewById(R.id.bd_vip_tag);
                                                                if (imageView3 != null) {
                                                                    i2 = R.id.bd_vote_1;
                                                                    ImageView imageView4 = (ImageView) rootView.findViewById(R.id.bd_vote_1);
                                                                    if (imageView4 != null) {
                                                                        i2 = R.id.bd_vote_2;
                                                                        ImageView imageView5 = (ImageView) rootView.findViewById(R.id.bd_vote_2);
                                                                        if (imageView5 != null) {
                                                                            i2 = R.id.bd_vote_3;
                                                                            ImageView imageView6 = (ImageView) rootView.findViewById(R.id.bd_vote_3);
                                                                            if (imageView6 != null) {
                                                                                i2 = R.id.bd_vote_4;
                                                                                ImageView imageView7 = (ImageView) rootView.findViewById(R.id.bd_vote_4);
                                                                                if (imageView7 != null) {
                                                                                    i2 = R.id.bd_vote_5;
                                                                                    ImageView imageView8 = (ImageView) rootView.findViewById(R.id.bd_vote_5);
                                                                                    if (imageView8 != null) {
                                                                                        i2 = R.id.bd_vote_upcount;
                                                                                        TextView textView2 = (TextView) rootView.findViewById(R.id.bd_vote_upcount);
                                                                                        if (textView2 != null) {
                                                                                            i2 = R.id.bd_vote_upcount_image;
                                                                                            ThemeImageView themeImageView2 = (ThemeImageView) rootView.findViewById(R.id.bd_vote_upcount_image);
                                                                                            if (themeImageView2 != null) {
                                                                                                i2 = R.id.bd_vote_view;
                                                                                                LinearLayout linearLayout3 = (LinearLayout) rootView.findViewById(R.id.bd_vote_view);
                                                                                                if (linearLayout3 != null) {
                                                                                                    i2 = R.id.comment_reply;
                                                                                                    ThemeTextView themeTextView6 = (ThemeTextView) rootView.findViewById(R.id.comment_reply);
                                                                                                    if (themeTextView6 != null) {
                                                                                                        i2 = R.id.comment_reply_more;
                                                                                                        ThemeLinearLayout themeLinearLayout2 = (ThemeLinearLayout) rootView.findViewById(R.id.comment_reply_more);
                                                                                                        if (themeLinearLayout2 != null) {
                                                                                                            i2 = R.id.comment_reply_more_content;
                                                                                                            ThemeTextView themeTextView7 = (ThemeTextView) rootView.findViewById(R.id.comment_reply_more_content);
                                                                                                            if (themeTextView7 != null) {
                                                                                                                i2 = R.id.comment_reply_more_icon;
                                                                                                                ImageView imageView9 = (ImageView) rootView.findViewById(R.id.comment_reply_more_icon);
                                                                                                                if (imageView9 != null) {
                                                                                                                    i2 = R.id.comment_reply_view;
                                                                                                                    ThemeLinearLayout themeLinearLayout3 = (ThemeLinearLayout) rootView.findViewById(R.id.comment_reply_view);
                                                                                                                    if (themeLinearLayout3 != null) {
                                                                                                                        LinearLayout linearLayout4 = (LinearLayout) rootView;
                                                                                                                        i2 = R.id.expand_collapse;
                                                                                                                        ThemeImageView themeImageView3 = (ThemeImageView) rootView.findViewById(R.id.expand_collapse);
                                                                                                                        if (themeImageView3 != null) {
                                                                                                                            return new b5(linearLayout4, themeImageView, themeTextView, findViewById, themeTextView2, themeTextView3, themeTextView4, linearLayout, imageView, themeTextView5, linearLayout2, themeLinearLayout, imageView2, textView, circleImageView, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, textView2, themeImageView2, linearLayout3, themeTextView6, themeLinearLayout2, themeTextView7, imageView9, themeLinearLayout3, linearLayout4, themeImageView3);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static b5 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static b5 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.reader_comment_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f11751a;
    }
}
