package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.ui.MyGridView;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class z implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeLinearLayout f12999a;

    /* renamed from: b */
    @NonNull
    public final TextView f13000b;

    /* renamed from: c */
    @NonNull
    public final MyGridView f13001c;

    /* renamed from: d */
    @NonNull
    public final ThemeTextView f13002d;

    /* renamed from: e */
    @NonNull
    public final ThemeTextView f13003e;

    /* renamed from: f */
    @NonNull
    public final ThemeTextView f13004f;

    private z(@NonNull ThemeLinearLayout rootView, @NonNull TextView txsCoinsAmount, @NonNull MyGridView txsRechargeList, @NonNull ThemeTextView txsRechargeMoney, @NonNull ThemeTextView txsRechargeRule, @NonNull ThemeTextView txsRechargeType) {
        this.f12999a = rootView;
        this.f13000b = txsCoinsAmount;
        this.f13001c = txsRechargeList;
        this.f13002d = txsRechargeMoney;
        this.f13003e = txsRechargeRule;
        this.f13004f = txsRechargeType;
    }

    @NonNull
    public static z a(@NonNull View rootView) {
        int i2 = R.id.txs_coins_amount;
        TextView textView = (TextView) rootView.findViewById(R.id.txs_coins_amount);
        if (textView != null) {
            i2 = R.id.txs_recharge_list;
            MyGridView myGridView = (MyGridView) rootView.findViewById(R.id.txs_recharge_list);
            if (myGridView != null) {
                i2 = R.id.txs_recharge_money;
                ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(R.id.txs_recharge_money);
                if (themeTextView != null) {
                    i2 = R.id.txs_recharge_rule;
                    ThemeTextView themeTextView2 = (ThemeTextView) rootView.findViewById(R.id.txs_recharge_rule);
                    if (themeTextView2 != null) {
                        i2 = R.id.txs_recharge_type;
                        ThemeTextView themeTextView3 = (ThemeTextView) rootView.findViewById(R.id.txs_recharge_type);
                        if (themeTextView3 != null) {
                            return new z((ThemeLinearLayout) rootView, textView, myGridView, themeTextView, themeTextView2, themeTextView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static z c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static z d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.activity_txs_recharge, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeLinearLayout getRoot() {
        return this.f12999a;
    }
}
