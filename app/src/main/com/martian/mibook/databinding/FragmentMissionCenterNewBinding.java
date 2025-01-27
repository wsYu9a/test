package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.appbar.AppBarLayout;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeRelativeLayout;
import com.martian.libmars.utils.tablayout.MagicIndicator;
import com.martian.mibook.R;
import com.martian.mibook.ui.IntervalCountdownTextView;

/* loaded from: classes3.dex */
public final class FragmentMissionCenterNewBinding implements ViewBinding {

    @NonNull
    public final ThemeImageView actionbarBack;

    @NonNull
    public final ConstraintLayout actionbarView;

    @NonNull
    public final AppBarLayout appbarLayout;

    @NonNull
    public final IntervalCountdownTextView bookrackIntervalCountdown;

    @NonNull
    public final TextView bookrackIntervalGrab;

    @NonNull
    public final CoordinatorLayout coordinator;

    @NonNull
    public final ImageView ivTopBg;

    @NonNull
    public final MagicIndicator magicIndicator;

    @NonNull
    public final RelativeLayout rlIntervalView;

    @NonNull
    private final ThemeRelativeLayout rootView;

    @NonNull
    public final Toolbar toolbar;

    @NonNull
    public final ViewPager2 viewpager2;

    private FragmentMissionCenterNewBinding(@NonNull ThemeRelativeLayout themeRelativeLayout, @NonNull ThemeImageView themeImageView, @NonNull ConstraintLayout constraintLayout, @NonNull AppBarLayout appBarLayout, @NonNull IntervalCountdownTextView intervalCountdownTextView, @NonNull TextView textView, @NonNull CoordinatorLayout coordinatorLayout, @NonNull ImageView imageView, @NonNull MagicIndicator magicIndicator, @NonNull RelativeLayout relativeLayout, @NonNull Toolbar toolbar, @NonNull ViewPager2 viewPager2) {
        this.rootView = themeRelativeLayout;
        this.actionbarBack = themeImageView;
        this.actionbarView = constraintLayout;
        this.appbarLayout = appBarLayout;
        this.bookrackIntervalCountdown = intervalCountdownTextView;
        this.bookrackIntervalGrab = textView;
        this.coordinator = coordinatorLayout;
        this.ivTopBg = imageView;
        this.magicIndicator = magicIndicator;
        this.rlIntervalView = relativeLayout;
        this.toolbar = toolbar;
        this.viewpager2 = viewPager2;
    }

    @NonNull
    public static FragmentMissionCenterNewBinding bind(@NonNull View view) {
        int i10 = R.id.actionbar_back;
        ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
        if (themeImageView != null) {
            i10 = R.id.actionbar_view;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i10);
            if (constraintLayout != null) {
                i10 = R.id.appbar_layout;
                AppBarLayout appBarLayout = (AppBarLayout) ViewBindings.findChildViewById(view, i10);
                if (appBarLayout != null) {
                    i10 = R.id.bookrack_interval_countdown;
                    IntervalCountdownTextView intervalCountdownTextView = (IntervalCountdownTextView) ViewBindings.findChildViewById(view, i10);
                    if (intervalCountdownTextView != null) {
                        i10 = R.id.bookrack_interval_grab;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
                        if (textView != null) {
                            i10 = R.id.coordinator;
                            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) ViewBindings.findChildViewById(view, i10);
                            if (coordinatorLayout != null) {
                                i10 = R.id.iv_top_bg;
                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
                                if (imageView != null) {
                                    i10 = R.id.magic_indicator;
                                    MagicIndicator magicIndicator = (MagicIndicator) ViewBindings.findChildViewById(view, i10);
                                    if (magicIndicator != null) {
                                        i10 = R.id.rl_interval_view;
                                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i10);
                                        if (relativeLayout != null) {
                                            i10 = R.id.toolbar;
                                            Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, i10);
                                            if (toolbar != null) {
                                                i10 = R.id.viewpager2;
                                                ViewPager2 viewPager2 = (ViewPager2) ViewBindings.findChildViewById(view, i10);
                                                if (viewPager2 != null) {
                                                    return new FragmentMissionCenterNewBinding((ThemeRelativeLayout) view, themeImageView, constraintLayout, appBarLayout, intervalCountdownTextView, textView, coordinatorLayout, imageView, magicIndicator, relativeLayout, toolbar, viewPager2);
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
    public static FragmentMissionCenterNewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static FragmentMissionCenterNewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.fragment_mission_center_new, viewGroup, false);
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
