package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class WithdrawMoneyItemBinding implements ViewBinding {

    @NonNull
    private final LinearLayout rootView;

    @NonNull
    public final ThemeLinearLayout withdrawMoney;

    @NonNull
    public final TextView withdrawMoneyDesc;

    @NonNull
    public final TextView withdrawMoneyTitle;

    private WithdrawMoneyItemBinding(@NonNull LinearLayout linearLayout, @NonNull ThemeLinearLayout themeLinearLayout, @NonNull TextView textView, @NonNull TextView textView2) {
        this.rootView = linearLayout;
        this.withdrawMoney = themeLinearLayout;
        this.withdrawMoneyDesc = textView;
        this.withdrawMoneyTitle = textView2;
    }

    @NonNull
    public static WithdrawMoneyItemBinding bind(@NonNull View view) {
        int i10 = R.id.withdraw_money;
        ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) ViewBindings.findChildViewById(view, i10);
        if (themeLinearLayout != null) {
            i10 = R.id.withdraw_money_desc;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
            if (textView != null) {
                i10 = R.id.withdraw_money_title;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i10);
                if (textView2 != null) {
                    return new WithdrawMoneyItemBinding((LinearLayout) view, themeLinearLayout, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static WithdrawMoneyItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static WithdrawMoneyItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.withdraw_money_item, viewGroup, false);
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
