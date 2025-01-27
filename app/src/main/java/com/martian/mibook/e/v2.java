package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.MiSwitchButton;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class v2 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeLinearLayout f12820a;

    /* renamed from: b */
    @NonNull
    public final com.martian.libmars.e.h0 f12821b;

    /* renamed from: c */
    @NonNull
    public final LinearLayout f12822c;

    /* renamed from: d */
    @NonNull
    public final MiSwitchButton f12823d;

    private v2(@NonNull ThemeLinearLayout rootView, @NonNull com.martian.libmars.e.h0 coinsTxsView, @NonNull LinearLayout missionItems, @NonNull MiSwitchButton txsMsbAutoBuyingSwitcher) {
        this.f12820a = rootView;
        this.f12821b = coinsTxsView;
        this.f12822c = missionItems;
        this.f12823d = txsMsbAutoBuyingSwitcher;
    }

    @NonNull
    public static v2 a(@NonNull View rootView) {
        int i2 = R.id.coins_txs_view;
        View findViewById = rootView.findViewById(R.id.coins_txs_view);
        if (findViewById != null) {
            com.martian.libmars.e.h0 a2 = com.martian.libmars.e.h0.a(findViewById);
            LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.mission_items);
            if (linearLayout != null) {
                MiSwitchButton miSwitchButton = (MiSwitchButton) rootView.findViewById(R.id.txs_msb_auto_buying_switcher);
                if (miSwitchButton != null) {
                    return new v2((ThemeLinearLayout) rootView, a2, linearLayout, miSwitchButton);
                }
                i2 = R.id.txs_msb_auto_buying_switcher;
            } else {
                i2 = R.id.mission_items;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static v2 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static v2 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.fragment_account_coins_txs, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeLinearLayout getRoot() {
        return this.f12820a;
    }
}
