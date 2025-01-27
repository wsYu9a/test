package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.databinding.MartianMoneyWithdrawViewBinding;
import com.martian.libmars.ui.theme.MiSwitchButton;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class FragmentAccountCoinsTxsBinding implements ViewBinding {

    @NonNull
    public final MartianMoneyWithdrawViewBinding coinsTxsView;

    @NonNull
    public final LinearLayout missionItems;

    @NonNull
    private final ThemeLinearLayout rootView;

    @NonNull
    public final MiSwitchButton txsMsbAutoBuyingSwitcher;

    private FragmentAccountCoinsTxsBinding(@NonNull ThemeLinearLayout themeLinearLayout, @NonNull MartianMoneyWithdrawViewBinding martianMoneyWithdrawViewBinding, @NonNull LinearLayout linearLayout, @NonNull MiSwitchButton miSwitchButton) {
        this.rootView = themeLinearLayout;
        this.coinsTxsView = martianMoneyWithdrawViewBinding;
        this.missionItems = linearLayout;
        this.txsMsbAutoBuyingSwitcher = miSwitchButton;
    }

    @NonNull
    public static FragmentAccountCoinsTxsBinding bind(@NonNull View view) {
        int i10 = R.id.coins_txs_view;
        View findChildViewById = ViewBindings.findChildViewById(view, i10);
        if (findChildViewById != null) {
            MartianMoneyWithdrawViewBinding a10 = MartianMoneyWithdrawViewBinding.a(findChildViewById);
            int i11 = R.id.mission_items;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i11);
            if (linearLayout != null) {
                i11 = R.id.txs_msb_auto_buying_switcher;
                MiSwitchButton miSwitchButton = (MiSwitchButton) ViewBindings.findChildViewById(view, i11);
                if (miSwitchButton != null) {
                    return new FragmentAccountCoinsTxsBinding((ThemeLinearLayout) view, a10, linearLayout, miSwitchButton);
                }
            }
            i10 = i11;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static FragmentAccountCoinsTxsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static FragmentAccountCoinsTxsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.fragment_account_coins_txs, viewGroup, false);
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
