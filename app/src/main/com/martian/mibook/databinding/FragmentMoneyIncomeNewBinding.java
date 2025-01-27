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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.MiSwitchButton;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.libmars.widget.CountUpTextView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class FragmentMoneyIncomeNewBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout clExchangeLayout;

    @NonNull
    public final CountUpTextView ctvMoney;

    @NonNull
    public final ImageView ivCoins;

    @NonNull
    public final ImageView ivCoinsQuestion;

    @NonNull
    public final ThemeImageView ivSignInReminderBg;

    @NonNull
    public final LinearLayout llCoin;

    @NonNull
    public final LinearLayout missionItems;

    @NonNull
    public final RelativeLayout rlSignIn;

    @NonNull
    private final NestedScrollView rootView;

    @NonNull
    public final RecyclerView rvSign;

    @NonNull
    public final MiSwitchButton switchButton;

    @NonNull
    public final TextView tvCoinsNum;

    @NonNull
    public final ThemeTextView tvMoneyIncomeText;

    @NonNull
    public final ThemeImageView tvMore;

    @NonNull
    public final ThemeTextView tvNowExchange;

    @NonNull
    public final ThemeTextView tvSignInTitle;

    @NonNull
    public final ThemeTextView tvWithdrawal;

    private FragmentMoneyIncomeNewBinding(@NonNull NestedScrollView nestedScrollView, @NonNull ConstraintLayout constraintLayout, @NonNull CountUpTextView countUpTextView, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ThemeImageView themeImageView, @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull RelativeLayout relativeLayout, @NonNull RecyclerView recyclerView, @NonNull MiSwitchButton miSwitchButton, @NonNull TextView textView, @NonNull ThemeTextView themeTextView, @NonNull ThemeImageView themeImageView2, @NonNull ThemeTextView themeTextView2, @NonNull ThemeTextView themeTextView3, @NonNull ThemeTextView themeTextView4) {
        this.rootView = nestedScrollView;
        this.clExchangeLayout = constraintLayout;
        this.ctvMoney = countUpTextView;
        this.ivCoins = imageView;
        this.ivCoinsQuestion = imageView2;
        this.ivSignInReminderBg = themeImageView;
        this.llCoin = linearLayout;
        this.missionItems = linearLayout2;
        this.rlSignIn = relativeLayout;
        this.rvSign = recyclerView;
        this.switchButton = miSwitchButton;
        this.tvCoinsNum = textView;
        this.tvMoneyIncomeText = themeTextView;
        this.tvMore = themeImageView2;
        this.tvNowExchange = themeTextView2;
        this.tvSignInTitle = themeTextView3;
        this.tvWithdrawal = themeTextView4;
    }

    @NonNull
    public static FragmentMoneyIncomeNewBinding bind(@NonNull View view) {
        int i10 = R.id.cl_exchange_layout;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i10);
        if (constraintLayout != null) {
            i10 = R.id.ctv_money;
            CountUpTextView countUpTextView = (CountUpTextView) ViewBindings.findChildViewById(view, i10);
            if (countUpTextView != null) {
                i10 = R.id.iv_coins;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
                if (imageView != null) {
                    i10 = R.id.iv_coins_question;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i10);
                    if (imageView2 != null) {
                        i10 = R.id.iv_sign_in_reminder_bg;
                        ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                        if (themeImageView != null) {
                            i10 = R.id.ll_coin;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                            if (linearLayout != null) {
                                i10 = R.id.mission_items;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                if (linearLayout2 != null) {
                                    i10 = R.id.rl_sign_in;
                                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i10);
                                    if (relativeLayout != null) {
                                        i10 = R.id.rv_sign;
                                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i10);
                                        if (recyclerView != null) {
                                            i10 = R.id.switch_button;
                                            MiSwitchButton miSwitchButton = (MiSwitchButton) ViewBindings.findChildViewById(view, i10);
                                            if (miSwitchButton != null) {
                                                i10 = R.id.tv_coins_num;
                                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
                                                if (textView != null) {
                                                    i10 = R.id.tv_money_income_text;
                                                    ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                    if (themeTextView != null) {
                                                        i10 = R.id.tv_more;
                                                        ThemeImageView themeImageView2 = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                                                        if (themeImageView2 != null) {
                                                            i10 = R.id.tv_now_exchange;
                                                            ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                            if (themeTextView2 != null) {
                                                                i10 = R.id.tv_sign_in_title;
                                                                ThemeTextView themeTextView3 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                if (themeTextView3 != null) {
                                                                    i10 = R.id.tv_withdrawal;
                                                                    ThemeTextView themeTextView4 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                    if (themeTextView4 != null) {
                                                                        return new FragmentMoneyIncomeNewBinding((NestedScrollView) view, constraintLayout, countUpTextView, imageView, imageView2, themeImageView, linearLayout, linearLayout2, relativeLayout, recyclerView, miSwitchButton, textView, themeTextView, themeImageView2, themeTextView2, themeTextView3, themeTextView4);
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
    public static FragmentMoneyIncomeNewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static FragmentMoneyIncomeNewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.fragment_money_income_new, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public NestedScrollView getRoot() {
        return this.rootView;
    }
}
