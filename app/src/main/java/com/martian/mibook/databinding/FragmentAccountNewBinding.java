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
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeRelativeLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.libmars.widget.CountUpTextView;
import com.martian.mibook.R;
import com.martian.mibook.mvvm.widget.ExpLevelLabel;
import com.martian.mibook.ui.MyGridView;
import de.hdodenhof.circleimageview.CircleImageView;

/* loaded from: classes3.dex */
public final class FragmentAccountNewBinding implements ViewBinding {

    @NonNull
    public final MyGridView accountActivities;

    @NonNull
    public final ThemeLinearLayout accountActivitiesView;

    @NonNull
    public final ThemeLinearLayout accountAdTest;

    @NonNull
    public final ThemeTextView accountBookCoins;

    @NonNull
    public final ThemeTextView accountBookCoinsRecharge;

    @NonNull
    public final ThemeLinearLayout accountBookCoinsView;

    @NonNull
    public final ThemeLinearLayout accountCheckUpdate;

    @NonNull
    public final ThemeLinearLayout accountClearCache;

    @NonNull
    public final ExpLevelLabel accountExpLevel;

    @NonNull
    public final ThemeLinearLayout accountFeedback;

    @NonNull
    public final ThemeTextView accountFeedbackDesc;

    @NonNull
    public final ThemeImageView accountFeedbackIcon;

    @NonNull
    public final ThemeLinearLayout accountFunctionTest;

    @NonNull
    public final ThemeLinearLayout accountFunctionView;

    @NonNull
    public final ThemeLinearLayout accountGenderGuide;

    @NonNull
    public final ThemeLinearLayout accountIncomeView;

    @NonNull
    public final ThemeLinearLayout accountMessageCenter;

    @NonNull
    public final ThemeLinearLayout accountMoreServiceView;

    @NonNull
    public final ThemeLinearLayout accountMyComment;

    @NonNull
    public final ThemeImageView accountNightMode;

    @NonNull
    public final ThemeLinearLayout accountReadingRecordView;

    @NonNull
    public final ThemeImageView accountSetting;

    @NonNull
    public final ThemeLinearLayout accountTestMode;

    @NonNull
    public final ImageView accountUpgradeTip;

    @NonNull
    public final ImageView accountVipBg;

    @NonNull
    public final ThemeTextView accountVipButton;

    @NonNull
    public final TextView accountVipDesc;

    @NonNull
    public final RelativeLayout accountVipView;

    @NonNull
    public final ThemeLinearLayout accountWechatCustomer;

    @NonNull
    public final AppBarLayout appbarLayout;

    @NonNull
    public final CoordinatorLayout coordinator;

    @NonNull
    public final ConstraintLayout cslUserInfo;

    @NonNull
    public final ImageView ivAccountTopBg;

    @NonNull
    public final CircleImageView ivAvatar;

    @NonNull
    public final LinearLayout llSetting;

    @NonNull
    public final ImageView llUserId;

    @NonNull
    public final LinearLayout llUserIdView;

    @NonNull
    public final ConstraintLayout llUserName;

    @NonNull
    public final CountUpTextView mcCommission;

    @NonNull
    public final LinearLayout mcCommissionView;

    @NonNull
    public final CountUpTextView mcDuration;

    @NonNull
    public final LinearLayout mcDurationView;

    @NonNull
    public final CountUpTextView mcMoney;

    @NonNull
    public final LinearLayout mcMoneyView;

    @NonNull
    public final NestedScrollView nsvContent;

    @NonNull
    public final RelativeLayout rlUserId;

    @NonNull
    private final ThemeRelativeLayout rootView;

    @NonNull
    public final RecyclerView rvReadingRecord;

    @NonNull
    public final Toolbar toolbar;

    @NonNull
    public final CollapsingToolbarLayout toolbarLayout;

    @NonNull
    public final ThemeLinearLayout tvBindWechat;

    @NonNull
    public final ThemeTextView tvUserId;

    @NonNull
    public final ThemeTextView tvUserLoginTips;

    @NonNull
    public final ThemeTextView tvUserNickname;

    private FragmentAccountNewBinding(@NonNull ThemeRelativeLayout themeRelativeLayout, @NonNull MyGridView myGridView, @NonNull ThemeLinearLayout themeLinearLayout, @NonNull ThemeLinearLayout themeLinearLayout2, @NonNull ThemeTextView themeTextView, @NonNull ThemeTextView themeTextView2, @NonNull ThemeLinearLayout themeLinearLayout3, @NonNull ThemeLinearLayout themeLinearLayout4, @NonNull ThemeLinearLayout themeLinearLayout5, @NonNull ExpLevelLabel expLevelLabel, @NonNull ThemeLinearLayout themeLinearLayout6, @NonNull ThemeTextView themeTextView3, @NonNull ThemeImageView themeImageView, @NonNull ThemeLinearLayout themeLinearLayout7, @NonNull ThemeLinearLayout themeLinearLayout8, @NonNull ThemeLinearLayout themeLinearLayout9, @NonNull ThemeLinearLayout themeLinearLayout10, @NonNull ThemeLinearLayout themeLinearLayout11, @NonNull ThemeLinearLayout themeLinearLayout12, @NonNull ThemeLinearLayout themeLinearLayout13, @NonNull ThemeImageView themeImageView2, @NonNull ThemeLinearLayout themeLinearLayout14, @NonNull ThemeImageView themeImageView3, @NonNull ThemeLinearLayout themeLinearLayout15, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ThemeTextView themeTextView4, @NonNull TextView textView, @NonNull RelativeLayout relativeLayout, @NonNull ThemeLinearLayout themeLinearLayout16, @NonNull AppBarLayout appBarLayout, @NonNull CoordinatorLayout coordinatorLayout, @NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView3, @NonNull CircleImageView circleImageView, @NonNull LinearLayout linearLayout, @NonNull ImageView imageView4, @NonNull LinearLayout linearLayout2, @NonNull ConstraintLayout constraintLayout2, @NonNull CountUpTextView countUpTextView, @NonNull LinearLayout linearLayout3, @NonNull CountUpTextView countUpTextView2, @NonNull LinearLayout linearLayout4, @NonNull CountUpTextView countUpTextView3, @NonNull LinearLayout linearLayout5, @NonNull NestedScrollView nestedScrollView, @NonNull RelativeLayout relativeLayout2, @NonNull RecyclerView recyclerView, @NonNull Toolbar toolbar, @NonNull CollapsingToolbarLayout collapsingToolbarLayout, @NonNull ThemeLinearLayout themeLinearLayout17, @NonNull ThemeTextView themeTextView5, @NonNull ThemeTextView themeTextView6, @NonNull ThemeTextView themeTextView7) {
        this.rootView = themeRelativeLayout;
        this.accountActivities = myGridView;
        this.accountActivitiesView = themeLinearLayout;
        this.accountAdTest = themeLinearLayout2;
        this.accountBookCoins = themeTextView;
        this.accountBookCoinsRecharge = themeTextView2;
        this.accountBookCoinsView = themeLinearLayout3;
        this.accountCheckUpdate = themeLinearLayout4;
        this.accountClearCache = themeLinearLayout5;
        this.accountExpLevel = expLevelLabel;
        this.accountFeedback = themeLinearLayout6;
        this.accountFeedbackDesc = themeTextView3;
        this.accountFeedbackIcon = themeImageView;
        this.accountFunctionTest = themeLinearLayout7;
        this.accountFunctionView = themeLinearLayout8;
        this.accountGenderGuide = themeLinearLayout9;
        this.accountIncomeView = themeLinearLayout10;
        this.accountMessageCenter = themeLinearLayout11;
        this.accountMoreServiceView = themeLinearLayout12;
        this.accountMyComment = themeLinearLayout13;
        this.accountNightMode = themeImageView2;
        this.accountReadingRecordView = themeLinearLayout14;
        this.accountSetting = themeImageView3;
        this.accountTestMode = themeLinearLayout15;
        this.accountUpgradeTip = imageView;
        this.accountVipBg = imageView2;
        this.accountVipButton = themeTextView4;
        this.accountVipDesc = textView;
        this.accountVipView = relativeLayout;
        this.accountWechatCustomer = themeLinearLayout16;
        this.appbarLayout = appBarLayout;
        this.coordinator = coordinatorLayout;
        this.cslUserInfo = constraintLayout;
        this.ivAccountTopBg = imageView3;
        this.ivAvatar = circleImageView;
        this.llSetting = linearLayout;
        this.llUserId = imageView4;
        this.llUserIdView = linearLayout2;
        this.llUserName = constraintLayout2;
        this.mcCommission = countUpTextView;
        this.mcCommissionView = linearLayout3;
        this.mcDuration = countUpTextView2;
        this.mcDurationView = linearLayout4;
        this.mcMoney = countUpTextView3;
        this.mcMoneyView = linearLayout5;
        this.nsvContent = nestedScrollView;
        this.rlUserId = relativeLayout2;
        this.rvReadingRecord = recyclerView;
        this.toolbar = toolbar;
        this.toolbarLayout = collapsingToolbarLayout;
        this.tvBindWechat = themeLinearLayout17;
        this.tvUserId = themeTextView5;
        this.tvUserLoginTips = themeTextView6;
        this.tvUserNickname = themeTextView7;
    }

    @NonNull
    public static FragmentAccountNewBinding bind(@NonNull View view) {
        int i10 = R.id.account_activities;
        MyGridView myGridView = (MyGridView) ViewBindings.findChildViewById(view, i10);
        if (myGridView != null) {
            i10 = R.id.account_activities_view;
            ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
            if (themeLinearLayout != null) {
                i10 = R.id.account_ad_test;
                ThemeLinearLayout themeLinearLayout2 = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                if (themeLinearLayout2 != null) {
                    i10 = R.id.account_book_coins;
                    ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                    if (themeTextView != null) {
                        i10 = R.id.account_book_coins_recharge;
                        ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                        if (themeTextView2 != null) {
                            i10 = R.id.account_book_coins_view;
                            ThemeLinearLayout themeLinearLayout3 = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                            if (themeLinearLayout3 != null) {
                                i10 = R.id.account_check_update;
                                ThemeLinearLayout themeLinearLayout4 = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                if (themeLinearLayout4 != null) {
                                    i10 = R.id.account_clear_cache;
                                    ThemeLinearLayout themeLinearLayout5 = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                    if (themeLinearLayout5 != null) {
                                        i10 = R.id.account_exp_level;
                                        ExpLevelLabel expLevelLabel = (ExpLevelLabel) ViewBindings.findChildViewById(view, i10);
                                        if (expLevelLabel != null) {
                                            i10 = R.id.account_feedback;
                                            ThemeLinearLayout themeLinearLayout6 = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                            if (themeLinearLayout6 != null) {
                                                i10 = R.id.account_feedback_desc;
                                                ThemeTextView themeTextView3 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                if (themeTextView3 != null) {
                                                    i10 = R.id.account_feedback_icon;
                                                    ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                                                    if (themeImageView != null) {
                                                        i10 = R.id.account_function_test;
                                                        ThemeLinearLayout themeLinearLayout7 = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                                        if (themeLinearLayout7 != null) {
                                                            i10 = R.id.account_function_view;
                                                            ThemeLinearLayout themeLinearLayout8 = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                                            if (themeLinearLayout8 != null) {
                                                                i10 = R.id.account_gender_guide;
                                                                ThemeLinearLayout themeLinearLayout9 = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                if (themeLinearLayout9 != null) {
                                                                    i10 = R.id.account_income_view;
                                                                    ThemeLinearLayout themeLinearLayout10 = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                    if (themeLinearLayout10 != null) {
                                                                        i10 = R.id.account_message_center;
                                                                        ThemeLinearLayout themeLinearLayout11 = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                        if (themeLinearLayout11 != null) {
                                                                            i10 = R.id.account_more_service_view;
                                                                            ThemeLinearLayout themeLinearLayout12 = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                            if (themeLinearLayout12 != null) {
                                                                                i10 = R.id.account_my_comment;
                                                                                ThemeLinearLayout themeLinearLayout13 = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                                if (themeLinearLayout13 != null) {
                                                                                    i10 = R.id.account_night_mode;
                                                                                    ThemeImageView themeImageView2 = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                                                                                    if (themeImageView2 != null) {
                                                                                        i10 = R.id.account_reading_record_view;
                                                                                        ThemeLinearLayout themeLinearLayout14 = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                                        if (themeLinearLayout14 != null) {
                                                                                            i10 = R.id.account_setting;
                                                                                            ThemeImageView themeImageView3 = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                                                                                            if (themeImageView3 != null) {
                                                                                                i10 = R.id.account_test_mode;
                                                                                                ThemeLinearLayout themeLinearLayout15 = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                                                if (themeLinearLayout15 != null) {
                                                                                                    i10 = R.id.account_upgrade_tip;
                                                                                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
                                                                                                    if (imageView != null) {
                                                                                                        i10 = R.id.account_vip_bg;
                                                                                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i10);
                                                                                                        if (imageView2 != null) {
                                                                                                            i10 = R.id.account_vip_button;
                                                                                                            ThemeTextView themeTextView4 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                            if (themeTextView4 != null) {
                                                                                                                i10 = R.id.account_vip_desc;
                                                                                                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                if (textView != null) {
                                                                                                                    i10 = R.id.account_vip_view;
                                                                                                                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i10);
                                                                                                                    if (relativeLayout != null) {
                                                                                                                        i10 = R.id.account_wechat_customer;
                                                                                                                        ThemeLinearLayout themeLinearLayout16 = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                                                                        if (themeLinearLayout16 != null) {
                                                                                                                            i10 = R.id.appbar_layout;
                                                                                                                            AppBarLayout appBarLayout = (AppBarLayout) ViewBindings.findChildViewById(view, i10);
                                                                                                                            if (appBarLayout != null) {
                                                                                                                                i10 = R.id.coordinator;
                                                                                                                                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) ViewBindings.findChildViewById(view, i10);
                                                                                                                                if (coordinatorLayout != null) {
                                                                                                                                    i10 = R.id.csl_user_info;
                                                                                                                                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i10);
                                                                                                                                    if (constraintLayout != null) {
                                                                                                                                        i10 = R.id.iv_account_top_bg;
                                                                                                                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                        if (imageView3 != null) {
                                                                                                                                            i10 = R.id.iv_avatar;
                                                                                                                                            CircleImageView circleImageView = (CircleImageView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                            if (circleImageView != null) {
                                                                                                                                                i10 = R.id.ll_setting;
                                                                                                                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                if (linearLayout != null) {
                                                                                                                                                    i10 = R.id.ll_user_id;
                                                                                                                                                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                    if (imageView4 != null) {
                                                                                                                                                        i10 = R.id.ll_user_id_view;
                                                                                                                                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                        if (linearLayout2 != null) {
                                                                                                                                                            i10 = R.id.ll_user_name;
                                                                                                                                                            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                            if (constraintLayout2 != null) {
                                                                                                                                                                i10 = R.id.mc_commission;
                                                                                                                                                                CountUpTextView countUpTextView = (CountUpTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                if (countUpTextView != null) {
                                                                                                                                                                    i10 = R.id.mc_commission_view;
                                                                                                                                                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                    if (linearLayout3 != null) {
                                                                                                                                                                        i10 = R.id.mc_duration;
                                                                                                                                                                        CountUpTextView countUpTextView2 = (CountUpTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                        if (countUpTextView2 != null) {
                                                                                                                                                                            i10 = R.id.mc_duration_view;
                                                                                                                                                                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                            if (linearLayout4 != null) {
                                                                                                                                                                                i10 = R.id.mc_money;
                                                                                                                                                                                CountUpTextView countUpTextView3 = (CountUpTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                                if (countUpTextView3 != null) {
                                                                                                                                                                                    i10 = R.id.mc_money_view;
                                                                                                                                                                                    LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                                    if (linearLayout5 != null) {
                                                                                                                                                                                        i10 = R.id.nsv_content;
                                                                                                                                                                                        NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                                        if (nestedScrollView != null) {
                                                                                                                                                                                            i10 = R.id.rl_user_id;
                                                                                                                                                                                            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                                            if (relativeLayout2 != null) {
                                                                                                                                                                                                i10 = R.id.rv_reading_record;
                                                                                                                                                                                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                                                if (recyclerView != null) {
                                                                                                                                                                                                    i10 = R.id.toolbar;
                                                                                                                                                                                                    Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                                                    if (toolbar != null) {
                                                                                                                                                                                                        i10 = R.id.toolbarLayout;
                                                                                                                                                                                                        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                                                        if (collapsingToolbarLayout != null) {
                                                                                                                                                                                                            i10 = R.id.tv_bind_wechat;
                                                                                                                                                                                                            ThemeLinearLayout themeLinearLayout17 = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                                                            if (themeLinearLayout17 != null) {
                                                                                                                                                                                                                i10 = R.id.tv_user_id;
                                                                                                                                                                                                                ThemeTextView themeTextView5 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                                                                if (themeTextView5 != null) {
                                                                                                                                                                                                                    i10 = R.id.tv_user_login_tips;
                                                                                                                                                                                                                    ThemeTextView themeTextView6 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                                                                    if (themeTextView6 != null) {
                                                                                                                                                                                                                        i10 = R.id.tv_user_nickname;
                                                                                                                                                                                                                        ThemeTextView themeTextView7 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                                                                                                                        if (themeTextView7 != null) {
                                                                                                                                                                                                                            return new FragmentAccountNewBinding((ThemeRelativeLayout) view, myGridView, themeLinearLayout, themeLinearLayout2, themeTextView, themeTextView2, themeLinearLayout3, themeLinearLayout4, themeLinearLayout5, expLevelLabel, themeLinearLayout6, themeTextView3, themeImageView, themeLinearLayout7, themeLinearLayout8, themeLinearLayout9, themeLinearLayout10, themeLinearLayout11, themeLinearLayout12, themeLinearLayout13, themeImageView2, themeLinearLayout14, themeImageView3, themeLinearLayout15, imageView, imageView2, themeTextView4, textView, relativeLayout, themeLinearLayout16, appBarLayout, coordinatorLayout, constraintLayout, imageView3, circleImageView, linearLayout, imageView4, linearLayout2, constraintLayout2, countUpTextView, linearLayout3, countUpTextView2, linearLayout4, countUpTextView3, linearLayout5, nestedScrollView, relativeLayout2, recyclerView, toolbar, collapsingToolbarLayout, themeLinearLayout17, themeTextView5, themeTextView6, themeTextView7);
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
    public static FragmentAccountNewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static FragmentAccountNewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.fragment_account_new, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ThemeRelativeLayout getRoot() {
        return this.rootView;
    }
}
