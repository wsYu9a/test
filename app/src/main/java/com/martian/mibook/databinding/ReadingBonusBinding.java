package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.mibook.R;
import com.martian.mibook.ui.reader.ReaderRoundColorView;
import com.martian.mibook.ui.reader.ReaderThemeCountUpTextView;
import com.martian.mibook.ui.reader.ReaderThemeImageView;
import com.martian.mibook.ui.reader.ReaderThemeLinearLayout;
import com.martian.mibook.ui.reader.ReaderThemeProgressBar;
import com.martian.mibook.ui.reader.ReaderThemeTextView;

/* loaded from: classes3.dex */
public final class ReadingBonusBinding implements ViewBinding {

    @NonNull
    public final LinearLayout bonusFloatView;

    @NonNull
    public final ReaderThemeTextView durationBonus;

    @NonNull
    public final ReaderThemeCountUpTextView durationBonusNum;

    @NonNull
    public final ReaderThemeTextView durationBonusUnit;

    @NonNull
    public final LinearLayout durationBonusView;

    @NonNull
    public final ReaderThemeImageView durationCoins;

    @NonNull
    public final ReaderRoundColorView durationCoinsInner;

    @NonNull
    public final ReaderThemeProgressBar durationProgressbar;

    @NonNull
    public final ReaderThemeLinearLayout floatMenu;

    @NonNull
    public final ConstraintLayout lyDurationCountFloat;

    @NonNull
    private final LinearLayout rootView;

    private ReadingBonusBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull ReaderThemeTextView readerThemeTextView, @NonNull ReaderThemeCountUpTextView readerThemeCountUpTextView, @NonNull ReaderThemeTextView readerThemeTextView2, @NonNull LinearLayout linearLayout3, @NonNull ReaderThemeImageView readerThemeImageView, @NonNull ReaderRoundColorView readerRoundColorView, @NonNull ReaderThemeProgressBar readerThemeProgressBar, @NonNull ReaderThemeLinearLayout readerThemeLinearLayout, @NonNull ConstraintLayout constraintLayout) {
        this.rootView = linearLayout;
        this.bonusFloatView = linearLayout2;
        this.durationBonus = readerThemeTextView;
        this.durationBonusNum = readerThemeCountUpTextView;
        this.durationBonusUnit = readerThemeTextView2;
        this.durationBonusView = linearLayout3;
        this.durationCoins = readerThemeImageView;
        this.durationCoinsInner = readerRoundColorView;
        this.durationProgressbar = readerThemeProgressBar;
        this.floatMenu = readerThemeLinearLayout;
        this.lyDurationCountFloat = constraintLayout;
    }

    @NonNull
    public static ReadingBonusBinding bind(@NonNull View view) {
        int i10 = R.id.bonus_float_view;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
        if (linearLayout != null) {
            i10 = R.id.duration_bonus;
            ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
            if (readerThemeTextView != null) {
                i10 = R.id.duration_bonus_num;
                ReaderThemeCountUpTextView readerThemeCountUpTextView = (ReaderThemeCountUpTextView) ViewBindings.findChildViewById(view, i10);
                if (readerThemeCountUpTextView != null) {
                    i10 = R.id.duration_bonus_unit;
                    ReaderThemeTextView readerThemeTextView2 = (ReaderThemeTextView) ViewBindings.findChildViewById(view, i10);
                    if (readerThemeTextView2 != null) {
                        i10 = R.id.duration_bonus_view;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                        if (linearLayout2 != null) {
                            i10 = R.id.duration_coins;
                            ReaderThemeImageView readerThemeImageView = (ReaderThemeImageView) ViewBindings.findChildViewById(view, i10);
                            if (readerThemeImageView != null) {
                                i10 = R.id.duration_coins_inner;
                                ReaderRoundColorView readerRoundColorView = (ReaderRoundColorView) ViewBindings.findChildViewById(view, i10);
                                if (readerRoundColorView != null) {
                                    i10 = R.id.duration_progressbar;
                                    ReaderThemeProgressBar readerThemeProgressBar = (ReaderThemeProgressBar) ViewBindings.findChildViewById(view, i10);
                                    if (readerThemeProgressBar != null) {
                                        i10 = R.id.float_menu;
                                        ReaderThemeLinearLayout readerThemeLinearLayout = (ReaderThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
                                        if (readerThemeLinearLayout != null) {
                                            i10 = R.id.ly_duration_count_float;
                                            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i10);
                                            if (constraintLayout != null) {
                                                return new ReadingBonusBinding((LinearLayout) view, linearLayout, readerThemeTextView, readerThemeCountUpTextView, readerThemeTextView2, linearLayout2, readerThemeImageView, readerRoundColorView, readerThemeProgressBar, readerThemeLinearLayout, constraintLayout);
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
    public static ReadingBonusBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ReadingBonusBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.reading_bonus, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
