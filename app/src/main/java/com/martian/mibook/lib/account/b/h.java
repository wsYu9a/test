package com.martian.mibook.lib.account.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.lib.account.R;

/* loaded from: classes3.dex */
public final class h implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeLinearLayout f13858a;

    /* renamed from: b */
    @NonNull
    public final ThemeTextView f13859b;

    /* renamed from: c */
    @NonNull
    public final TextView f13860c;

    /* renamed from: d */
    @NonNull
    public final ThemeTextView f13861d;

    /* renamed from: e */
    @NonNull
    public final TextView f13862e;

    /* renamed from: f */
    @NonNull
    public final ThemeTextView f13863f;

    private h(@NonNull ThemeLinearLayout rootView, @NonNull ThemeTextView rdWithdrawId, @NonNull TextView rdWithdrawMoney, @NonNull ThemeTextView rdWithdrawName, @NonNull TextView rdWithdrawStatus, @NonNull ThemeTextView rdWithdrawTime) {
        this.f13858a = rootView;
        this.f13859b = rdWithdrawId;
        this.f13860c = rdWithdrawMoney;
        this.f13861d = rdWithdrawName;
        this.f13862e = rdWithdrawStatus;
        this.f13863f = rdWithdrawTime;
    }

    @NonNull
    public static h a(@NonNull View rootView) {
        int i2 = R.id.rd_withdraw_id;
        ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(i2);
        if (themeTextView != null) {
            i2 = R.id.rd_withdraw_money;
            TextView textView = (TextView) rootView.findViewById(i2);
            if (textView != null) {
                i2 = R.id.rd_withdraw_name;
                ThemeTextView themeTextView2 = (ThemeTextView) rootView.findViewById(i2);
                if (themeTextView2 != null) {
                    i2 = R.id.rd_withdraw_status;
                    TextView textView2 = (TextView) rootView.findViewById(i2);
                    if (textView2 != null) {
                        i2 = R.id.rd_withdraw_time;
                        ThemeTextView themeTextView3 = (ThemeTextView) rootView.findViewById(i2);
                        if (themeTextView3 != null) {
                            return new h((ThemeLinearLayout) rootView, themeTextView, textView, themeTextView2, textView2, themeTextView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static h c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static h d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.martian_withdraw_order_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeLinearLayout getRoot() {
        return this.f13858a;
    }
}
