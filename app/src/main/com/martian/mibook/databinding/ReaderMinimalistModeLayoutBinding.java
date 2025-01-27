package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.widget.RoundedLayout;
import com.martian.mibook.R;
import com.martian.mibook.ui.reader.ReaderRoundColorView;
import com.martian.mibook.ui.reader.ReaderThemeImageView;
import com.martian.mibook.ui.reader.ReaderThemeLinearLayout;
import com.martian.mibook.ui.reader.ReaderThemeProgressBar;
import com.martian.mibook.ui.reader.ReaderThemeSwitchButton;
import com.martian.mibook.ui.reader.ReaderThemeTextView;

/* loaded from: classes3.dex */
public final class ReaderMinimalistModeLayoutBinding implements ViewBinding {

    @NonNull
    public final RelativeLayout batteryView;

    @NonNull
    public final ConstraintLayout clShowBonus;

    @NonNull
    public final ConstraintLayout clShowBonusTips;

    @NonNull
    public final ConstraintLayout clShowBottomTextTips;

    @NonNull
    public final ConstraintLayout clShowMenu;

    @NonNull
    public final ConstraintLayout clShowProgressTimePower;

    @NonNull
    public final ReaderThemeTextView durationBonus;

    @NonNull
    public final ReaderThemeImageView durationCoins;

    @NonNull
    public final ReaderRoundColorView durationCoinsInner;

    @NonNull
    public final ReaderThemeProgressBar durationProgressbar;

    @NonNull
    public final ReaderThemeImageView ivClose;

    @NonNull
    public final ReaderThemeLinearLayout layoutShowMenuTips;

    @NonNull
    public final LinearLayout layoutShowProgressTimePowerTips;

    @NonNull
    public final ReaderThemeSwitchButton prefShowBonus;

    @NonNull
    public final ReaderThemeSwitchButton prefShowBottomTextTips;

    @NonNull
    public final ReaderThemeSwitchButton prefShowMenu;

    @NonNull
    public final ReaderThemeSwitchButton prefShowProgressTimePower;

    @NonNull
    public final ReaderThemeImageView rbsIvBattery;

    @NonNull
    public final ReaderThemeProgressBar rbsTvBattery;

    @NonNull
    public final ReaderThemeTextView rbsTvRightContent;

    @NonNull
    public final ReaderThemeTextView rbsTvTime;

    @NonNull
    public final ReaderThemeImageView rivCharging;

    @NonNull
    private final RoundedLayout rootView;

    @NonNull
    public final ReaderThemeTextView tvShowBonus;

    @NonNull
    public final ReaderThemeTextView tvShowBottomText;

    @NonNull
    public final ReaderThemeTextView tvShowBottomTextTips;

    @NonNull
    public final ReaderThemeTextView tvShowMenu;

    @NonNull
    public final ReaderThemeTextView tvShowMenuTips;

    @NonNull
    public final ReaderThemeTextView tvShowProgressTimePower;

    @NonNull
    public final ReaderThemeTextView tvTitle;

    private ReaderMinimalistModeLayoutBinding(@NonNull RoundedLayout roundedLayout, @NonNull RelativeLayout relativeLayout, @NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull ConstraintLayout constraintLayout3, @NonNull ConstraintLayout constraintLayout4, @NonNull ConstraintLayout constraintLayout5, @NonNull ReaderThemeTextView readerThemeTextView, @NonNull ReaderThemeImageView readerThemeImageView, @NonNull ReaderRoundColorView readerRoundColorView, @NonNull ReaderThemeProgressBar readerThemeProgressBar, @NonNull ReaderThemeImageView readerThemeImageView2, @NonNull ReaderThemeLinearLayout readerThemeLinearLayout, @NonNull LinearLayout linearLayout, @NonNull ReaderThemeSwitchButton readerThemeSwitchButton, @NonNull ReaderThemeSwitchButton readerThemeSwitchButton2, @NonNull ReaderThemeSwitchButton readerThemeSwitchButton3, @NonNull ReaderThemeSwitchButton readerThemeSwitchButton4, @NonNull ReaderThemeImageView readerThemeImageView3, @NonNull ReaderThemeProgressBar readerThemeProgressBar2, @NonNull ReaderThemeTextView readerThemeTextView2, @NonNull ReaderThemeTextView readerThemeTextView3, @NonNull ReaderThemeImageView readerThemeImageView4, @NonNull ReaderThemeTextView readerThemeTextView4, @NonNull ReaderThemeTextView readerThemeTextView5, @NonNull ReaderThemeTextView readerThemeTextView6, @NonNull ReaderThemeTextView readerThemeTextView7, @NonNull ReaderThemeTextView readerThemeTextView8, @NonNull ReaderThemeTextView readerThemeTextView9, @NonNull ReaderThemeTextView readerThemeTextView10) {
        this.rootView = roundedLayout;
        this.batteryView = relativeLayout;
        this.clShowBonus = constraintLayout;
        this.clShowBonusTips = constraintLayout2;
        this.clShowBottomTextTips = constraintLayout3;
        this.clShowMenu = constraintLayout4;
        this.clShowProgressTimePower = constraintLayout5;
        this.durationBonus = readerThemeTextView;
        this.durationCoins = readerThemeImageView;
        this.durationCoinsInner = readerRoundColorView;
        this.durationProgressbar = readerThemeProgressBar;
        this.ivClose = readerThemeImageView2;
        this.layoutShowMenuTips = readerThemeLinearLayout;
        this.layoutShowProgressTimePowerTips = linearLayout;
        this.prefShowBonus = readerThemeSwitchButton;
        this.prefShowBottomTextTips = readerThemeSwitchButton2;
        this.prefShowMenu = readerThemeSwitchButton3;
        this.prefShowProgressTimePower = readerThemeSwitchButton4;
        this.rbsIvBattery = readerThemeImageView3;
        this.rbsTvBattery = readerThemeProgressBar2;
        this.rbsTvRightContent = readerThemeTextView2;
        this.rbsTvTime = readerThemeTextView3;
        this.rivCharging = readerThemeImageView4;
        this.tvShowBonus = readerThemeTextView4;
        this.tvShowBottomText = readerThemeTextView5;
        this.tvShowBottomTextTips = readerThemeTextView6;
        this.tvShowMenu = readerThemeTextView7;
        this.tvShowMenuTips = readerThemeTextView8;
        this.tvShowProgressTimePower = readerThemeTextView9;
        this.tvTitle = readerThemeTextView10;
    }

    @NonNull
    public static ReaderMinimalistModeLayoutBinding bind(@NonNull View view) {
        int i10 = R.id.battery_view;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i10);
        if (relativeLayout != null) {
            i10 = R.id.cl_show_bonus;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i10);
            if (constraintLayout != null) {
                i10 = R.id.cl_show_bonus_tips;
                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i10);
                if (constraintLayout2 != null) {
                    i10 = R.id.cl_show_bottom_text_tips;
                    ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i10);
                    if (constraintLayout3 != null) {
                        i10 = R.id.cl_show_menu;
                        ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i10);
                        if (constraintLayout4 != null) {
                            i10 = R.id.cl_show_progress_time_power;
                            ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(view, i10);
                            if (constraintLayout5 != null) {
                                i10 = R.id.duration_bonus;
                                ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                if (readerThemeTextView != null) {
                                    i10 = R.id.duration_coins;
                                    ReaderThemeImageView readerThemeImageView = (ReaderThemeImageView) ViewBindings.findChildViewById(view, i10);
                                    if (readerThemeImageView != null) {
                                        i10 = R.id.duration_coins_inner;
                                        ReaderRoundColorView readerRoundColorView = (ReaderRoundColorView) ViewBindings.findChildViewById(view, i10);
                                        if (readerRoundColorView != null) {
                                            i10 = R.id.duration_progressbar;
                                            ReaderThemeProgressBar readerThemeProgressBar = (ReaderThemeProgressBar) ViewBindings.findChildViewById(view, i10);
                                            if (readerThemeProgressBar != null) {
                                                i10 = R.id.iv_close;
                                                ReaderThemeImageView readerThemeImageView2 = (ReaderThemeImageView) ViewBindings.findChildViewById(view, i10);
                                                if (readerThemeImageView2 != null) {
                                                    i10 = R.id.layout_show_menu_tips;
                                                    ReaderThemeLinearLayout readerThemeLinearLayout = (ReaderThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                                    if (readerThemeLinearLayout != null) {
                                                        i10 = R.id.layout_show_progress_time_power_tips;
                                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                                                        if (linearLayout != null) {
                                                            i10 = R.id.pref_show_bonus;
                                                            ReaderThemeSwitchButton readerThemeSwitchButton = (ReaderThemeSwitchButton) ViewBindings.findChildViewById(view, i10);
                                                            if (readerThemeSwitchButton != null) {
                                                                i10 = R.id.pref_show_bottom_text_tips;
                                                                ReaderThemeSwitchButton readerThemeSwitchButton2 = (ReaderThemeSwitchButton) ViewBindings.findChildViewById(view, i10);
                                                                if (readerThemeSwitchButton2 != null) {
                                                                    i10 = R.id.pref_show_menu;
                                                                    ReaderThemeSwitchButton readerThemeSwitchButton3 = (ReaderThemeSwitchButton) ViewBindings.findChildViewById(view, i10);
                                                                    if (readerThemeSwitchButton3 != null) {
                                                                        i10 = R.id.pref_show_progress_time_power;
                                                                        ReaderThemeSwitchButton readerThemeSwitchButton4 = (ReaderThemeSwitchButton) ViewBindings.findChildViewById(view, i10);
                                                                        if (readerThemeSwitchButton4 != null) {
                                                                            i10 = R.id.rbs_iv_battery;
                                                                            ReaderThemeImageView readerThemeImageView3 = (ReaderThemeImageView) ViewBindings.findChildViewById(view, i10);
                                                                            if (readerThemeImageView3 != null) {
                                                                                i10 = R.id.rbs_tv_battery;
                                                                                ReaderThemeProgressBar readerThemeProgressBar2 = (ReaderThemeProgressBar) ViewBindings.findChildViewById(view, i10);
                                                                                if (readerThemeProgressBar2 != null) {
                                                                                    i10 = R.id.rbs_tv_right_content;
                                                                                    ReaderThemeTextView readerThemeTextView2 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                    if (readerThemeTextView2 != null) {
                                                                                        i10 = R.id.rbs_tv_time;
                                                                                        ReaderThemeTextView readerThemeTextView3 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                        if (readerThemeTextView3 != null) {
                                                                                            i10 = R.id.riv_charging;
                                                                                            ReaderThemeImageView readerThemeImageView4 = (ReaderThemeImageView) ViewBindings.findChildViewById(view, i10);
                                                                                            if (readerThemeImageView4 != null) {
                                                                                                i10 = R.id.tv_show_bonus;
                                                                                                ReaderThemeTextView readerThemeTextView4 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                if (readerThemeTextView4 != null) {
                                                                                                    i10 = R.id.tv_show_bottom_text;
                                                                                                    ReaderThemeTextView readerThemeTextView5 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                    if (readerThemeTextView5 != null) {
                                                                                                        i10 = R.id.tv_show_bottom_text_tips;
                                                                                                        ReaderThemeTextView readerThemeTextView6 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                        if (readerThemeTextView6 != null) {
                                                                                                            i10 = R.id.tv_show_menu;
                                                                                                            ReaderThemeTextView readerThemeTextView7 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                            if (readerThemeTextView7 != null) {
                                                                                                                i10 = R.id.tv_show_menu_tips;
                                                                                                                ReaderThemeTextView readerThemeTextView8 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                if (readerThemeTextView8 != null) {
                                                                                                                    i10 = R.id.tv_show_progress_time_power;
                                                                                                                    ReaderThemeTextView readerThemeTextView9 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                    if (readerThemeTextView9 != null) {
                                                                                                                        i10 = R.id.tv_title;
                                                                                                                        ReaderThemeTextView readerThemeTextView10 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                                                                                                                        if (readerThemeTextView10 != null) {
                                                                                                                            return new ReaderMinimalistModeLayoutBinding((RoundedLayout) view, relativeLayout, constraintLayout, constraintLayout2, constraintLayout3, constraintLayout4, constraintLayout5, readerThemeTextView, readerThemeImageView, readerRoundColorView, readerThemeProgressBar, readerThemeImageView2, readerThemeLinearLayout, linearLayout, readerThemeSwitchButton, readerThemeSwitchButton2, readerThemeSwitchButton3, readerThemeSwitchButton4, readerThemeImageView3, readerThemeProgressBar2, readerThemeTextView2, readerThemeTextView3, readerThemeImageView4, readerThemeTextView4, readerThemeTextView5, readerThemeTextView6, readerThemeTextView7, readerThemeTextView8, readerThemeTextView9, readerThemeTextView10);
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
    public static ReaderMinimalistModeLayoutBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ReaderMinimalistModeLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.reader_minimalist_mode_layout, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public RoundedLayout getRoot() {
        return this.rootView;
    }
}
