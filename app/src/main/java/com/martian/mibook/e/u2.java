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
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.libmars.widget.CountUpTextView;
import com.martian.mibook.ui.MyGridView;
import com.martian.ttbookhd.R;
import de.hdodenhof.circleimageview.CircleImageView;

/* loaded from: classes3.dex */
public final class u2 implements ViewBinding {

    @NonNull
    public final ImageView A;

    @NonNull
    public final LinearLayout B;

    @NonNull
    public final ImageView C;

    @NonNull
    public final ThemeTextView D;

    @NonNull
    public final TextView E;

    @NonNull
    public final RelativeLayout F;

    @NonNull
    public final ThemeLinearLayout G;

    @NonNull
    public final CircleImageView H;

    @NonNull
    public final LinearLayout I;

    @NonNull
    public final CountUpTextView J;

    @NonNull
    public final LinearLayout K;

    @NonNull
    public final CountUpTextView L;

    @NonNull
    public final LinearLayout M;

    @NonNull
    public final ThemeTextView N;

    @NonNull
    public final CountUpTextView O;

    @NonNull
    public final LinearLayout P;

    @NonNull
    public final ThemeTextView Q;

    @NonNull
    public final ImageView R;

    /* renamed from: a */
    @NonNull
    private final NestedScrollView f12769a;

    /* renamed from: b */
    @NonNull
    public final MyGridView f12770b;

    /* renamed from: c */
    @NonNull
    public final ThemeLinearLayout f12771c;

    /* renamed from: d */
    @NonNull
    public final ThemeLinearLayout f12772d;

    /* renamed from: e */
    @NonNull
    public final ThemeLinearLayout f12773e;

    /* renamed from: f */
    @NonNull
    public final ThemeImageView f12774f;

    /* renamed from: g */
    @NonNull
    public final ThemeTextView f12775g;

    /* renamed from: h */
    @NonNull
    public final LinearLayout f12776h;

    /* renamed from: i */
    @NonNull
    public final ThemeLinearLayout f12777i;

    /* renamed from: j */
    @NonNull
    public final ThemeTextView f12778j;

    @NonNull
    public final ThemeImageView k;

    @NonNull
    public final ThemeLinearLayout l;

    @NonNull
    public final ThemeLinearLayout m;

    @NonNull
    public final ImageView n;

    @NonNull
    public final RelativeLayout o;

    @NonNull
    public final ThemeLinearLayout p;

    @NonNull
    public final ThemeLinearLayout q;

    @NonNull
    public final ThemeLinearLayout r;

    @NonNull
    public final LinearLayout s;

    @NonNull
    public final ThemeLinearLayout t;

    @NonNull
    public final ThemeImageView u;

    @NonNull
    public final ThemeLinearLayout v;

    @NonNull
    public final ThemeImageView w;

    @NonNull
    public final ThemeTextView x;

    @NonNull
    public final ThemeLinearLayout y;

    @NonNull
    public final ThemeImageView z;

    private u2(@NonNull NestedScrollView rootView, @NonNull MyGridView accountActivities, @NonNull ThemeLinearLayout accountActivitiesView, @NonNull ThemeLinearLayout accountCheckUpdate, @NonNull ThemeLinearLayout accountClearCache, @NonNull ThemeImageView accountCommentIcon, @NonNull ThemeTextView accountCommentTitle, @NonNull LinearLayout accountContentView, @NonNull ThemeLinearLayout accountFeedback, @NonNull ThemeTextView accountFeedbackDesc, @NonNull ThemeImageView accountFeedbackIcon, @NonNull ThemeLinearLayout accountFunctionView, @NonNull ThemeLinearLayout accountGenderGuide, @NonNull ImageView accountHeaderBg, @NonNull RelativeLayout accountHeaderView, @NonNull ThemeLinearLayout accountIncomeView, @NonNull ThemeLinearLayout accountInviteFriends, @NonNull ThemeLinearLayout accountMessageCenter, @NonNull LinearLayout accountMoreFunctionSecond, @NonNull ThemeLinearLayout accountMyComment, @NonNull ThemeImageView accountNightMode, @NonNull ThemeLinearLayout accountQplayGame, @NonNull ThemeImageView accountQplayIcon, @NonNull ThemeTextView accountQplayTitle, @NonNull ThemeLinearLayout accountReadingRecord, @NonNull ThemeImageView accountSetting, @NonNull ImageView accountUpgradeTip, @NonNull LinearLayout accountUserInfo, @NonNull ImageView accountVipBg, @NonNull ThemeTextView accountVipButton, @NonNull TextView accountVipDesc, @NonNull RelativeLayout accountVipView, @NonNull ThemeLinearLayout accountWbl, @NonNull CircleImageView mcAccountHeader, @NonNull LinearLayout mcAccountInfo, @NonNull CountUpTextView mcCommission, @NonNull LinearLayout mcCommissionView, @NonNull CountUpTextView mcDuration, @NonNull LinearLayout mcDurationView, @NonNull ThemeTextView mcInviteCode, @NonNull CountUpTextView mcMoney, @NonNull LinearLayout mcMoneyView, @NonNull ThemeTextView mcNickname, @NonNull ImageView mcVipTag) {
        this.f12769a = rootView;
        this.f12770b = accountActivities;
        this.f12771c = accountActivitiesView;
        this.f12772d = accountCheckUpdate;
        this.f12773e = accountClearCache;
        this.f12774f = accountCommentIcon;
        this.f12775g = accountCommentTitle;
        this.f12776h = accountContentView;
        this.f12777i = accountFeedback;
        this.f12778j = accountFeedbackDesc;
        this.k = accountFeedbackIcon;
        this.l = accountFunctionView;
        this.m = accountGenderGuide;
        this.n = accountHeaderBg;
        this.o = accountHeaderView;
        this.p = accountIncomeView;
        this.q = accountInviteFriends;
        this.r = accountMessageCenter;
        this.s = accountMoreFunctionSecond;
        this.t = accountMyComment;
        this.u = accountNightMode;
        this.v = accountQplayGame;
        this.w = accountQplayIcon;
        this.x = accountQplayTitle;
        this.y = accountReadingRecord;
        this.z = accountSetting;
        this.A = accountUpgradeTip;
        this.B = accountUserInfo;
        this.C = accountVipBg;
        this.D = accountVipButton;
        this.E = accountVipDesc;
        this.F = accountVipView;
        this.G = accountWbl;
        this.H = mcAccountHeader;
        this.I = mcAccountInfo;
        this.J = mcCommission;
        this.K = mcCommissionView;
        this.L = mcDuration;
        this.M = mcDurationView;
        this.N = mcInviteCode;
        this.O = mcMoney;
        this.P = mcMoneyView;
        this.Q = mcNickname;
        this.R = mcVipTag;
    }

    @NonNull
    public static u2 a(@NonNull View rootView) {
        int i2 = R.id.account_activities;
        MyGridView myGridView = (MyGridView) rootView.findViewById(R.id.account_activities);
        if (myGridView != null) {
            i2 = R.id.account_activities_view;
            ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) rootView.findViewById(R.id.account_activities_view);
            if (themeLinearLayout != null) {
                i2 = R.id.account_check_update;
                ThemeLinearLayout themeLinearLayout2 = (ThemeLinearLayout) rootView.findViewById(R.id.account_check_update);
                if (themeLinearLayout2 != null) {
                    i2 = R.id.account_clear_cache;
                    ThemeLinearLayout themeLinearLayout3 = (ThemeLinearLayout) rootView.findViewById(R.id.account_clear_cache);
                    if (themeLinearLayout3 != null) {
                        i2 = R.id.account_comment_icon;
                        ThemeImageView themeImageView = (ThemeImageView) rootView.findViewById(R.id.account_comment_icon);
                        if (themeImageView != null) {
                            i2 = R.id.account_comment_title;
                            ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.account_comment_title);
                            if (themeTextView != null) {
                                i2 = R.id.account_content_view;
                                LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.account_content_view);
                                if (linearLayout != null) {
                                    i2 = R.id.account_feedback;
                                    ThemeLinearLayout themeLinearLayout4 = (ThemeLinearLayout) rootView.findViewById(R.id.account_feedback);
                                    if (themeLinearLayout4 != null) {
                                        i2 = R.id.account_feedback_desc;
                                        ThemeTextView themeTextView2 = (ThemeTextView) rootView.findViewById(R.id.account_feedback_desc);
                                        if (themeTextView2 != null) {
                                            i2 = R.id.account_feedback_icon;
                                            ThemeImageView themeImageView2 = (ThemeImageView) rootView.findViewById(R.id.account_feedback_icon);
                                            if (themeImageView2 != null) {
                                                i2 = R.id.account_function_view;
                                                ThemeLinearLayout themeLinearLayout5 = (ThemeLinearLayout) rootView.findViewById(R.id.account_function_view);
                                                if (themeLinearLayout5 != null) {
                                                    i2 = R.id.account_gender_guide;
                                                    ThemeLinearLayout themeLinearLayout6 = (ThemeLinearLayout) rootView.findViewById(R.id.account_gender_guide);
                                                    if (themeLinearLayout6 != null) {
                                                        i2 = R.id.account_header_bg;
                                                        ImageView imageView = (ImageView) rootView.findViewById(R.id.account_header_bg);
                                                        if (imageView != null) {
                                                            i2 = R.id.account_header_view;
                                                            RelativeLayout relativeLayout = (RelativeLayout) rootView.findViewById(R.id.account_header_view);
                                                            if (relativeLayout != null) {
                                                                i2 = R.id.account_income_view;
                                                                ThemeLinearLayout themeLinearLayout7 = (ThemeLinearLayout) rootView.findViewById(R.id.account_income_view);
                                                                if (themeLinearLayout7 != null) {
                                                                    i2 = R.id.account_invite_friends;
                                                                    ThemeLinearLayout themeLinearLayout8 = (ThemeLinearLayout) rootView.findViewById(R.id.account_invite_friends);
                                                                    if (themeLinearLayout8 != null) {
                                                                        i2 = R.id.account_message_center;
                                                                        ThemeLinearLayout themeLinearLayout9 = (ThemeLinearLayout) rootView.findViewById(R.id.account_message_center);
                                                                        if (themeLinearLayout9 != null) {
                                                                            i2 = R.id.account_more_function_second;
                                                                            LinearLayout linearLayout2 = (LinearLayout) rootView.findViewById(R.id.account_more_function_second);
                                                                            if (linearLayout2 != null) {
                                                                                i2 = R.id.account_my_comment;
                                                                                ThemeLinearLayout themeLinearLayout10 = (ThemeLinearLayout) rootView.findViewById(R.id.account_my_comment);
                                                                                if (themeLinearLayout10 != null) {
                                                                                    i2 = R.id.account_night_mode;
                                                                                    ThemeImageView themeImageView3 = (ThemeImageView) rootView.findViewById(R.id.account_night_mode);
                                                                                    if (themeImageView3 != null) {
                                                                                        i2 = R.id.account_qplay_game;
                                                                                        ThemeLinearLayout themeLinearLayout11 = (ThemeLinearLayout) rootView.findViewById(R.id.account_qplay_game);
                                                                                        if (themeLinearLayout11 != null) {
                                                                                            i2 = R.id.account_qplay_icon;
                                                                                            ThemeImageView themeImageView4 = (ThemeImageView) rootView.findViewById(R.id.account_qplay_icon);
                                                                                            if (themeImageView4 != null) {
                                                                                                i2 = R.id.account_qplay_title;
                                                                                                ThemeTextView themeTextView3 = (ThemeTextView) rootView.findViewById(R.id.account_qplay_title);
                                                                                                if (themeTextView3 != null) {
                                                                                                    i2 = R.id.account_reading_record;
                                                                                                    ThemeLinearLayout themeLinearLayout12 = (ThemeLinearLayout) rootView.findViewById(R.id.account_reading_record);
                                                                                                    if (themeLinearLayout12 != null) {
                                                                                                        i2 = R.id.account_setting;
                                                                                                        ThemeImageView themeImageView5 = (ThemeImageView) rootView.findViewById(R.id.account_setting);
                                                                                                        if (themeImageView5 != null) {
                                                                                                            i2 = R.id.account_upgrade_tip;
                                                                                                            ImageView imageView2 = (ImageView) rootView.findViewById(R.id.account_upgrade_tip);
                                                                                                            if (imageView2 != null) {
                                                                                                                i2 = R.id.account_user_info;
                                                                                                                LinearLayout linearLayout3 = (LinearLayout) rootView.findViewById(R.id.account_user_info);
                                                                                                                if (linearLayout3 != null) {
                                                                                                                    i2 = R.id.account_vip_bg;
                                                                                                                    ImageView imageView3 = (ImageView) rootView.findViewById(R.id.account_vip_bg);
                                                                                                                    if (imageView3 != null) {
                                                                                                                        i2 = R.id.account_vip_button;
                                                                                                                        ThemeTextView themeTextView4 = (ThemeTextView) rootView.findViewById(R.id.account_vip_button);
                                                                                                                        if (themeTextView4 != null) {
                                                                                                                            i2 = R.id.account_vip_desc;
                                                                                                                            TextView textView = (TextView) rootView.findViewById(R.id.account_vip_desc);
                                                                                                                            if (textView != null) {
                                                                                                                                i2 = R.id.account_vip_view;
                                                                                                                                RelativeLayout relativeLayout2 = (RelativeLayout) rootView.findViewById(R.id.account_vip_view);
                                                                                                                                if (relativeLayout2 != null) {
                                                                                                                                    i2 = R.id.account_wbl;
                                                                                                                                    ThemeLinearLayout themeLinearLayout13 = (ThemeLinearLayout) rootView.findViewById(R.id.account_wbl);
                                                                                                                                    if (themeLinearLayout13 != null) {
                                                                                                                                        i2 = R.id.mc_account_header;
                                                                                                                                        CircleImageView circleImageView = (CircleImageView) rootView.findViewById(R.id.mc_account_header);
                                                                                                                                        if (circleImageView != null) {
                                                                                                                                            i2 = R.id.mc_account_info;
                                                                                                                                            LinearLayout linearLayout4 = (LinearLayout) rootView.findViewById(R.id.mc_account_info);
                                                                                                                                            if (linearLayout4 != null) {
                                                                                                                                                i2 = R.id.mc_commission;
                                                                                                                                                CountUpTextView countUpTextView = (CountUpTextView) rootView.findViewById(R.id.mc_commission);
                                                                                                                                                if (countUpTextView != null) {
                                                                                                                                                    i2 = R.id.mc_commission_view;
                                                                                                                                                    LinearLayout linearLayout5 = (LinearLayout) rootView.findViewById(R.id.mc_commission_view);
                                                                                                                                                    if (linearLayout5 != null) {
                                                                                                                                                        i2 = R.id.mc_duration;
                                                                                                                                                        CountUpTextView countUpTextView2 = (CountUpTextView) rootView.findViewById(R.id.mc_duration);
                                                                                                                                                        if (countUpTextView2 != null) {
                                                                                                                                                            i2 = R.id.mc_duration_view;
                                                                                                                                                            LinearLayout linearLayout6 = (LinearLayout) rootView.findViewById(R.id.mc_duration_view);
                                                                                                                                                            if (linearLayout6 != null) {
                                                                                                                                                                i2 = R.id.mc_invite_code;
                                                                                                                                                                ThemeTextView themeTextView5 = (ThemeTextView) rootView.findViewById(R.id.mc_invite_code);
                                                                                                                                                                if (themeTextView5 != null) {
                                                                                                                                                                    i2 = R.id.mc_money;
                                                                                                                                                                    CountUpTextView countUpTextView3 = (CountUpTextView) rootView.findViewById(R.id.mc_money);
                                                                                                                                                                    if (countUpTextView3 != null) {
                                                                                                                                                                        i2 = R.id.mc_money_view;
                                                                                                                                                                        LinearLayout linearLayout7 = (LinearLayout) rootView.findViewById(R.id.mc_money_view);
                                                                                                                                                                        if (linearLayout7 != null) {
                                                                                                                                                                            i2 = R.id.mc_nickname;
                                                                                                                                                                            ThemeTextView themeTextView6 = (ThemeTextView) rootView.findViewById(R.id.mc_nickname);
                                                                                                                                                                            if (themeTextView6 != null) {
                                                                                                                                                                                i2 = R.id.mc_vip_tag;
                                                                                                                                                                                ImageView imageView4 = (ImageView) rootView.findViewById(R.id.mc_vip_tag);
                                                                                                                                                                                if (imageView4 != null) {
                                                                                                                                                                                    return new u2((NestedScrollView) rootView, myGridView, themeLinearLayout, themeLinearLayout2, themeLinearLayout3, themeImageView, themeTextView, linearLayout, themeLinearLayout4, themeTextView2, themeImageView2, themeLinearLayout5, themeLinearLayout6, imageView, relativeLayout, themeLinearLayout7, themeLinearLayout8, themeLinearLayout9, linearLayout2, themeLinearLayout10, themeImageView3, themeLinearLayout11, themeImageView4, themeTextView3, themeLinearLayout12, themeImageView5, imageView2, linearLayout3, imageView3, themeTextView4, textView, relativeLayout2, themeLinearLayout13, circleImageView, linearLayout4, countUpTextView, linearLayout5, countUpTextView2, linearLayout6, themeTextView5, countUpTextView3, linearLayout7, themeTextView6, imageView4);
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
    public static u2 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static u2 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.fragment_account, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public NestedScrollView getRoot() {
        return this.f12769a;
    }
}
