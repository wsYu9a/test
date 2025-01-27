package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.utils.tablayout.MagicIndicator;
import com.martian.mibook.R;
import com.martian.mibook.ui.IntervalCountdownTextView;
import com.martian.mibook.ui.LockableViewPager;

/* loaded from: classes3.dex */
public final class FragmentBookShelfMainBinding implements ViewBinding {

    @NonNull
    public final LinearLayout bookrackHeaderView;

    @NonNull
    public final IntervalCountdownTextView bookrackIntervalCountdown;

    @NonNull
    public final TextView bookrackIntervalGrab;

    @NonNull
    public final RelativeLayout bookrackIntervalView;

    @NonNull
    public final MagicIndicator bookrackMagicIndicator;

    @NonNull
    public final ThemeImageView bookrackMoreOptions;

    @NonNull
    public final ThemeImageView bookrackSearch;

    @NonNull
    private final ThemeLinearLayout rootView;

    @NonNull
    public final LockableViewPager viewpager;

    private FragmentBookShelfMainBinding(@NonNull ThemeLinearLayout themeLinearLayout, @NonNull LinearLayout linearLayout, @NonNull IntervalCountdownTextView intervalCountdownTextView, @NonNull TextView textView, @NonNull RelativeLayout relativeLayout, @NonNull MagicIndicator magicIndicator, @NonNull ThemeImageView themeImageView, @NonNull ThemeImageView themeImageView2, @NonNull LockableViewPager lockableViewPager) {
        this.rootView = themeLinearLayout;
        this.bookrackHeaderView = linearLayout;
        this.bookrackIntervalCountdown = intervalCountdownTextView;
        this.bookrackIntervalGrab = textView;
        this.bookrackIntervalView = relativeLayout;
        this.bookrackMagicIndicator = magicIndicator;
        this.bookrackMoreOptions = themeImageView;
        this.bookrackSearch = themeImageView2;
        this.viewpager = lockableViewPager;
    }

    @NonNull
    public static FragmentBookShelfMainBinding bind(@NonNull View view) {
        int i10 = R.id.bookrack_header_view;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
        if (linearLayout != null) {
            i10 = R.id.bookrack_interval_countdown;
            IntervalCountdownTextView intervalCountdownTextView = (IntervalCountdownTextView) ViewBindings.findChildViewById(view, i10);
            if (intervalCountdownTextView != null) {
                i10 = R.id.bookrack_interval_grab;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
                if (textView != null) {
                    i10 = R.id.bookrack_interval_view;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i10);
                    if (relativeLayout != null) {
                        i10 = R.id.bookrack_magic_indicator;
                        MagicIndicator magicIndicator = (MagicIndicator) ViewBindings.findChildViewById(view, i10);
                        if (magicIndicator != null) {
                            i10 = R.id.bookrack_more_options;
                            ThemeImageView themeImageView = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                            if (themeImageView != null) {
                                i10 = R.id.bookrack_search;
                                ThemeImageView themeImageView2 = (ThemeImageView) ViewBindings.findChildViewById(view, i10);
                                if (themeImageView2 != null) {
                                    i10 = R.id.viewpager;
                                    LockableViewPager lockableViewPager = (LockableViewPager) ViewBindings.findChildViewById(view, i10);
                                    if (lockableViewPager != null) {
                                        return new FragmentBookShelfMainBinding((ThemeLinearLayout) view, linearLayout, intervalCountdownTextView, textView, relativeLayout, magicIndicator, themeImageView, themeImageView2, lockableViewPager);
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
    public static FragmentBookShelfMainBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static FragmentBookShelfMainBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.fragment_book_shelf_main, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ThemeLinearLayout getRoot() {
        return this.rootView;
    }
}
