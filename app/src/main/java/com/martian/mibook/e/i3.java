package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class i3 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final NestedScrollView f12112a;

    /* renamed from: b */
    @NonNull
    public final LinearLayout f12113b;

    /* renamed from: c */
    @NonNull
    public final com.martian.libmars.e.g0 f12114c;

    /* renamed from: d */
    @NonNull
    public final TextView f12115d;

    private i3(@NonNull NestedScrollView rootView, @NonNull LinearLayout coinsMissions, @NonNull com.martian.libmars.e.g0 moneyIncomeView, @NonNull TextView myDurationRateNotice) {
        this.f12112a = rootView;
        this.f12113b = coinsMissions;
        this.f12114c = moneyIncomeView;
        this.f12115d = myDurationRateNotice;
    }

    @NonNull
    public static i3 a(@NonNull View rootView) {
        int i2 = R.id.coins_missions;
        LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.coins_missions);
        if (linearLayout != null) {
            i2 = R.id.money_income_view;
            View findViewById = rootView.findViewById(R.id.money_income_view);
            if (findViewById != null) {
                com.martian.libmars.e.g0 a2 = com.martian.libmars.e.g0.a(findViewById);
                TextView textView = (TextView) rootView.findViewById(R.id.my_duration_rate_notice);
                if (textView != null) {
                    return new i3((NestedScrollView) rootView, linearLayout, a2, textView);
                }
                i2 = R.id.my_duration_rate_notice;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static i3 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static i3 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.fragment_money_income, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public NestedScrollView getRoot() {
        return this.f12112a;
    }
}
