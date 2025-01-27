package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.ui.FlowLayout;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class y0 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f12952a;

    /* renamed from: b */
    @NonNull
    public final RelativeLayout f12953b;

    /* renamed from: c */
    @NonNull
    public final LinearLayout f12954c;

    /* renamed from: d */
    @NonNull
    public final FlowLayout f12955d;

    /* renamed from: e */
    @NonNull
    public final FlowLayout f12956e;

    /* renamed from: f */
    @NonNull
    public final TextView f12957f;

    /* renamed from: g */
    @NonNull
    public final LinearLayout f12958g;

    /* renamed from: h */
    @NonNull
    public final LinearLayout f12959h;

    /* renamed from: i */
    @NonNull
    public final ThemeImageView f12960i;

    /* renamed from: j */
    @NonNull
    public final ImageView f12961j;

    @NonNull
    public final RecyclerView k;

    @NonNull
    public final ThemeImageView l;

    @NonNull
    public final ThemeImageView m;

    @NonNull
    public final ThemeImageView n;

    @NonNull
    public final ThemeTextView o;

    @NonNull
    public final ThemeTextView p;

    @NonNull
    public final ThemeTextView q;

    @NonNull
    public final ThemeTextView r;

    @NonNull
    public final ThemeTextView s;

    @NonNull
    public final ThemeTextView t;

    @NonNull
    public final LinearLayout u;

    @NonNull
    public final LinearLayout v;

    @NonNull
    public final LinearLayout w;

    private y0(@NonNull LinearLayout rootView, @NonNull RelativeLayout bookGrabRankView, @NonNull LinearLayout bookRankTopView, @NonNull FlowLayout categoryBookStatusView, @NonNull FlowLayout categoryBookType, @NonNull TextView categoryRank, @NonNull LinearLayout categoryRankTitleView, @NonNull LinearLayout categoryRankView, @NonNull ThemeImageView categoryStatusIcon, @NonNull ImageView categoryStatusMore, @NonNull RecyclerView categoryTitleIrc, @NonNull ThemeImageView lvAccountImage1, @NonNull ThemeImageView lvAccountImage2, @NonNull ThemeImageView lvAccountImage3, @NonNull ThemeTextView lvAccountMoods1, @NonNull ThemeTextView lvAccountMoods2, @NonNull ThemeTextView lvAccountMoods3, @NonNull ThemeTextView lvAccountNickname1, @NonNull ThemeTextView lvAccountNickname2, @NonNull ThemeTextView lvAccountNickname3, @NonNull LinearLayout lvAccountView1, @NonNull LinearLayout lvAccountView2, @NonNull LinearLayout lvAccountView3) {
        this.f12952a = rootView;
        this.f12953b = bookGrabRankView;
        this.f12954c = bookRankTopView;
        this.f12955d = categoryBookStatusView;
        this.f12956e = categoryBookType;
        this.f12957f = categoryRank;
        this.f12958g = categoryRankTitleView;
        this.f12959h = categoryRankView;
        this.f12960i = categoryStatusIcon;
        this.f12961j = categoryStatusMore;
        this.k = categoryTitleIrc;
        this.l = lvAccountImage1;
        this.m = lvAccountImage2;
        this.n = lvAccountImage3;
        this.o = lvAccountMoods1;
        this.p = lvAccountMoods2;
        this.q = lvAccountMoods3;
        this.r = lvAccountNickname1;
        this.s = lvAccountNickname2;
        this.t = lvAccountNickname3;
        this.u = lvAccountView1;
        this.v = lvAccountView2;
        this.w = lvAccountView3;
    }

    @NonNull
    public static y0 a(@NonNull View rootView) {
        int i2 = R.id.book_grab_rank_view;
        RelativeLayout relativeLayout = (RelativeLayout) rootView.findViewById(R.id.book_grab_rank_view);
        if (relativeLayout != null) {
            i2 = R.id.book_rank_top_view;
            LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.book_rank_top_view);
            if (linearLayout != null) {
                i2 = R.id.category_book_status_view;
                FlowLayout flowLayout = (FlowLayout) rootView.findViewById(R.id.category_book_status_view);
                if (flowLayout != null) {
                    i2 = R.id.category_book_type;
                    FlowLayout flowLayout2 = (FlowLayout) rootView.findViewById(R.id.category_book_type);
                    if (flowLayout2 != null) {
                        i2 = R.id.category_rank;
                        TextView textView = (TextView) rootView.findViewById(R.id.category_rank);
                        if (textView != null) {
                            i2 = R.id.category_rank_title_view;
                            LinearLayout linearLayout2 = (LinearLayout) rootView.findViewById(R.id.category_rank_title_view);
                            if (linearLayout2 != null) {
                                i2 = R.id.category_rank_view;
                                LinearLayout linearLayout3 = (LinearLayout) rootView.findViewById(R.id.category_rank_view);
                                if (linearLayout3 != null) {
                                    i2 = R.id.category_status_icon;
                                    ThemeImageView themeImageView = (ThemeImageView) rootView.findViewById(R.id.category_status_icon);
                                    if (themeImageView != null) {
                                        i2 = R.id.category_status_more;
                                        ImageView imageView = (ImageView) rootView.findViewById(R.id.category_status_more);
                                        if (imageView != null) {
                                            i2 = R.id.category_title_irc;
                                            RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.category_title_irc);
                                            if (recyclerView != null) {
                                                i2 = R.id.lv_account_image_1;
                                                ThemeImageView themeImageView2 = (ThemeImageView) rootView.findViewById(R.id.lv_account_image_1);
                                                if (themeImageView2 != null) {
                                                    i2 = R.id.lv_account_image_2;
                                                    ThemeImageView themeImageView3 = (ThemeImageView) rootView.findViewById(R.id.lv_account_image_2);
                                                    if (themeImageView3 != null) {
                                                        i2 = R.id.lv_account_image_3;
                                                        ThemeImageView themeImageView4 = (ThemeImageView) rootView.findViewById(R.id.lv_account_image_3);
                                                        if (themeImageView4 != null) {
                                                            i2 = R.id.lv_account_moods_1;
                                                            ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.lv_account_moods_1);
                                                            if (themeTextView != null) {
                                                                i2 = R.id.lv_account_moods_2;
                                                                ThemeTextView themeTextView2 = (ThemeTextView) rootView.findViewById(R.id.lv_account_moods_2);
                                                                if (themeTextView2 != null) {
                                                                    i2 = R.id.lv_account_moods_3;
                                                                    ThemeTextView themeTextView3 = (ThemeTextView) rootView.findViewById(R.id.lv_account_moods_3);
                                                                    if (themeTextView3 != null) {
                                                                        i2 = R.id.lv_account_nickname_1;
                                                                        ThemeTextView themeTextView4 = (ThemeTextView) rootView.findViewById(R.id.lv_account_nickname_1);
                                                                        if (themeTextView4 != null) {
                                                                            i2 = R.id.lv_account_nickname_2;
                                                                            ThemeTextView themeTextView5 = (ThemeTextView) rootView.findViewById(R.id.lv_account_nickname_2);
                                                                            if (themeTextView5 != null) {
                                                                                i2 = R.id.lv_account_nickname_3;
                                                                                ThemeTextView themeTextView6 = (ThemeTextView) rootView.findViewById(R.id.lv_account_nickname_3);
                                                                                if (themeTextView6 != null) {
                                                                                    i2 = R.id.lv_account_view1;
                                                                                    LinearLayout linearLayout4 = (LinearLayout) rootView.findViewById(R.id.lv_account_view1);
                                                                                    if (linearLayout4 != null) {
                                                                                        i2 = R.id.lv_account_view2;
                                                                                        LinearLayout linearLayout5 = (LinearLayout) rootView.findViewById(R.id.lv_account_view2);
                                                                                        if (linearLayout5 != null) {
                                                                                            i2 = R.id.lv_account_view3;
                                                                                            LinearLayout linearLayout6 = (LinearLayout) rootView.findViewById(R.id.lv_account_view3);
                                                                                            if (linearLayout6 != null) {
                                                                                                return new y0((LinearLayout) rootView, relativeLayout, linearLayout, flowLayout, flowLayout2, textView, linearLayout2, linearLayout3, themeImageView, imageView, recyclerView, themeImageView2, themeImageView3, themeImageView4, themeTextView, themeTextView2, themeTextView3, themeTextView4, themeTextView5, themeTextView6, linearLayout4, linearLayout5, linearLayout6);
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
    public static y0 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static y0 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.book_rank_top, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f12952a;
    }
}
