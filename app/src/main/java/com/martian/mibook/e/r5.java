package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.mibook.ui.reader.ReaderRoundColorView;
import com.martian.mibook.ui.reader.ReaderThemeCountUpTextView;
import com.martian.mibook.ui.reader.ReaderThemeImageView;
import com.martian.mibook.ui.reader.ReaderThemeLinearLayout;
import com.martian.mibook.ui.reader.ReaderThemeProgressBar;
import com.martian.mibook.ui.reader.ReaderThemeTextView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class r5 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f12618a;

    /* renamed from: b */
    @NonNull
    public final LinearLayout f12619b;

    /* renamed from: c */
    @NonNull
    public final ReaderThemeTextView f12620c;

    /* renamed from: d */
    @NonNull
    public final ReaderThemeCountUpTextView f12621d;

    /* renamed from: e */
    @NonNull
    public final ReaderThemeTextView f12622e;

    /* renamed from: f */
    @NonNull
    public final LinearLayout f12623f;

    /* renamed from: g */
    @NonNull
    public final ReaderThemeImageView f12624g;

    /* renamed from: h */
    @NonNull
    public final ReaderRoundColorView f12625h;

    /* renamed from: i */
    @NonNull
    public final RelativeLayout f12626i;

    /* renamed from: j */
    @NonNull
    public final ReaderThemeProgressBar f12627j;

    @NonNull
    public final ReaderThemeLinearLayout k;

    @NonNull
    public final RelativeLayout l;

    private r5(@NonNull LinearLayout rootView, @NonNull LinearLayout bonusFloatView, @NonNull ReaderThemeTextView durationBonus, @NonNull ReaderThemeCountUpTextView durationBonusNum, @NonNull ReaderThemeTextView durationBonusUnit, @NonNull LinearLayout durationBonusView, @NonNull ReaderThemeImageView durationCoins, @NonNull ReaderRoundColorView durationCoinsInner, @NonNull RelativeLayout durationCoinsView, @NonNull ReaderThemeProgressBar durationProgressbar, @NonNull ReaderThemeLinearLayout floatMenu, @NonNull RelativeLayout lyDurationCountFloat) {
        this.f12618a = rootView;
        this.f12619b = bonusFloatView;
        this.f12620c = durationBonus;
        this.f12621d = durationBonusNum;
        this.f12622e = durationBonusUnit;
        this.f12623f = durationBonusView;
        this.f12624g = durationCoins;
        this.f12625h = durationCoinsInner;
        this.f12626i = durationCoinsView;
        this.f12627j = durationProgressbar;
        this.k = floatMenu;
        this.l = lyDurationCountFloat;
    }

    @NonNull
    public static r5 a(@NonNull View rootView) {
        int i2 = R.id.bonus_float_view;
        LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.bonus_float_view);
        if (linearLayout != null) {
            i2 = R.id.duration_bonus;
            ReaderThemeTextView readerThemeTextView = (ReaderThemeTextView) rootView.findViewById(R.id.duration_bonus);
            if (readerThemeTextView != null) {
                i2 = R.id.duration_bonus_num;
                ReaderThemeCountUpTextView readerThemeCountUpTextView = (ReaderThemeCountUpTextView) rootView.findViewById(R.id.duration_bonus_num);
                if (readerThemeCountUpTextView != null) {
                    i2 = R.id.duration_bonus_unit;
                    ReaderThemeTextView readerThemeTextView2 = (ReaderThemeTextView) rootView.findViewById(R.id.duration_bonus_unit);
                    if (readerThemeTextView2 != null) {
                        i2 = R.id.duration_bonus_view;
                        LinearLayout linearLayout2 = (LinearLayout) rootView.findViewById(R.id.duration_bonus_view);
                        if (linearLayout2 != null) {
                            i2 = R.id.duration_coins;
                            ReaderThemeImageView readerThemeImageView = (ReaderThemeImageView) rootView.findViewById(R.id.duration_coins);
                            if (readerThemeImageView != null) {
                                i2 = R.id.duration_coins_inner;
                                ReaderRoundColorView readerRoundColorView = (ReaderRoundColorView) rootView.findViewById(R.id.duration_coins_inner);
                                if (readerRoundColorView != null) {
                                    i2 = R.id.duration_coins_view;
                                    RelativeLayout relativeLayout = (RelativeLayout) rootView.findViewById(R.id.duration_coins_view);
                                    if (relativeLayout != null) {
                                        i2 = R.id.duration_progressbar;
                                        ReaderThemeProgressBar readerThemeProgressBar = (ReaderThemeProgressBar) rootView.findViewById(R.id.duration_progressbar);
                                        if (readerThemeProgressBar != null) {
                                            i2 = R.id.float_menu;
                                            ReaderThemeLinearLayout readerThemeLinearLayout = (ReaderThemeLinearLayout) rootView.findViewById(R.id.float_menu);
                                            if (readerThemeLinearLayout != null) {
                                                i2 = R.id.ly_duration_count_float;
                                                RelativeLayout relativeLayout2 = (RelativeLayout) rootView.findViewById(R.id.ly_duration_count_float);
                                                if (relativeLayout2 != null) {
                                                    return new r5((LinearLayout) rootView, linearLayout, readerThemeTextView, readerThemeCountUpTextView, readerThemeTextView2, linearLayout2, readerThemeImageView, readerRoundColorView, relativeLayout, readerThemeProgressBar, readerThemeLinearLayout, relativeLayout2);
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
    public static r5 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static r5 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.reading_bonus, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f12618a;
    }
}
