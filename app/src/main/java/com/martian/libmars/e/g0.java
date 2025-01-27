package com.martian.libmars.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.R;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.libmars.widget.CountUpTextView;

/* loaded from: classes2.dex */
public final class g0 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f9970a;

    /* renamed from: b */
    @NonNull
    public final ImageView f9971b;

    /* renamed from: c */
    @NonNull
    public final ThemeLinearLayout f9972c;

    /* renamed from: d */
    @NonNull
    public final CountUpTextView f9973d;

    /* renamed from: e */
    @NonNull
    public final CountUpTextView f9974e;

    /* renamed from: f */
    @NonNull
    public final ThemeTextView f9975f;

    /* renamed from: g */
    @NonNull
    public final TextView f9976g;

    /* renamed from: h */
    @NonNull
    public final CountUpTextView f9977h;

    /* renamed from: i */
    @NonNull
    public final TextView f9978i;

    /* renamed from: j */
    @NonNull
    public final ThemeTextView f9979j;

    @NonNull
    public final ThemeImageView k;

    @NonNull
    public final ThemeImageView l;

    @NonNull
    public final RelativeLayout m;

    private g0(@NonNull LinearLayout rootView, @NonNull ImageView incomeBg, @NonNull ThemeLinearLayout incomeCoinsMore, @NonNull CountUpTextView incomeCoinsNumber, @NonNull CountUpTextView incomeCoinsTitle, @NonNull ThemeTextView incomeExchange, @NonNull TextView incomeHint, @NonNull CountUpTextView incomeMoneyNumber, @NonNull TextView incomeMoneyTitle, @NonNull ThemeTextView incomeMoneyWithdraw, @NonNull ThemeImageView incomeMoreIcon, @NonNull ThemeImageView incomeRateHint, @NonNull RelativeLayout incomeView) {
        this.f9970a = rootView;
        this.f9971b = incomeBg;
        this.f9972c = incomeCoinsMore;
        this.f9973d = incomeCoinsNumber;
        this.f9974e = incomeCoinsTitle;
        this.f9975f = incomeExchange;
        this.f9976g = incomeHint;
        this.f9977h = incomeMoneyNumber;
        this.f9978i = incomeMoneyTitle;
        this.f9979j = incomeMoneyWithdraw;
        this.k = incomeMoreIcon;
        this.l = incomeRateHint;
        this.m = incomeView;
    }

    @NonNull
    public static g0 a(@NonNull View rootView) {
        int i2 = R.id.income_bg;
        ImageView imageView = (ImageView) rootView.findViewById(i2);
        if (imageView != null) {
            i2 = R.id.income_coins_more;
            ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) rootView.findViewById(i2);
            if (themeLinearLayout != null) {
                i2 = R.id.income_coins_number;
                CountUpTextView countUpTextView = (CountUpTextView) rootView.findViewById(i2);
                if (countUpTextView != null) {
                    i2 = R.id.income_coins_title;
                    CountUpTextView countUpTextView2 = (CountUpTextView) rootView.findViewById(i2);
                    if (countUpTextView2 != null) {
                        i2 = R.id.income_exchange;
                        ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(i2);
                        if (themeTextView != null) {
                            i2 = R.id.income_hint;
                            TextView textView = (TextView) rootView.findViewById(i2);
                            if (textView != null) {
                                i2 = R.id.income_money_number;
                                CountUpTextView countUpTextView3 = (CountUpTextView) rootView.findViewById(i2);
                                if (countUpTextView3 != null) {
                                    i2 = R.id.income_money_title;
                                    TextView textView2 = (TextView) rootView.findViewById(i2);
                                    if (textView2 != null) {
                                        i2 = R.id.income_money_withdraw;
                                        ThemeTextView themeTextView2 = (ThemeTextView) rootView.findViewById(i2);
                                        if (themeTextView2 != null) {
                                            i2 = R.id.income_more_icon;
                                            ThemeImageView themeImageView = (ThemeImageView) rootView.findViewById(i2);
                                            if (themeImageView != null) {
                                                i2 = R.id.income_rate_hint;
                                                ThemeImageView themeImageView2 = (ThemeImageView) rootView.findViewById(i2);
                                                if (themeImageView2 != null) {
                                                    i2 = R.id.income_view;
                                                    RelativeLayout relativeLayout = (RelativeLayout) rootView.findViewById(i2);
                                                    if (relativeLayout != null) {
                                                        return new g0((LinearLayout) rootView, imageView, themeLinearLayout, countUpTextView, countUpTextView2, themeTextView, textView, countUpTextView3, textView2, themeTextView2, themeImageView, themeImageView2, relativeLayout);
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
    public static g0 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static g0 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.martian_income_view, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f9970a;
    }
}
