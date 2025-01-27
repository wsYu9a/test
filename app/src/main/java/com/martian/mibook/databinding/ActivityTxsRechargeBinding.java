package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;
import com.martian.mibook.ui.MyGridView;

/* loaded from: classes3.dex */
public final class ActivityTxsRechargeBinding implements ViewBinding {

    @NonNull
    private final ThemeLinearLayout rootView;

    @NonNull
    public final TextView txsCoinsAmount;

    @NonNull
    public final MyGridView txsRechargeList;

    @NonNull
    public final ThemeTextView txsRechargeMoney;

    @NonNull
    public final ThemeTextView txsRechargeRule;

    @NonNull
    public final ThemeTextView txsRechargeType;

    private ActivityTxsRechargeBinding(@NonNull ThemeLinearLayout themeLinearLayout, @NonNull TextView textView, @NonNull MyGridView myGridView, @NonNull ThemeTextView themeTextView, @NonNull ThemeTextView themeTextView2, @NonNull ThemeTextView themeTextView3) {
        this.rootView = themeLinearLayout;
        this.txsCoinsAmount = textView;
        this.txsRechargeList = myGridView;
        this.txsRechargeMoney = themeTextView;
        this.txsRechargeRule = themeTextView2;
        this.txsRechargeType = themeTextView3;
    }

    @NonNull
    public static ActivityTxsRechargeBinding bind(@NonNull View view) {
        int i10 = R.id.txs_coins_amount;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
        if (textView != null) {
            i10 = R.id.txs_recharge_list;
            MyGridView myGridView = (MyGridView) ViewBindings.findChildViewById(view, i10);
            if (myGridView != null) {
                i10 = R.id.txs_recharge_money;
                ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (themeTextView != null) {
                    i10 = R.id.txs_recharge_rule;
                    ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                    if (themeTextView2 != null) {
                        i10 = R.id.txs_recharge_type;
                        ThemeTextView themeTextView3 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                        if (themeTextView3 != null) {
                            return new ActivityTxsRechargeBinding((ThemeLinearLayout) view, textView, myGridView, themeTextView, themeTextView2, themeTextView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ActivityTxsRechargeBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityTxsRechargeBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.activity_txs_recharge, viewGroup, false);
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
