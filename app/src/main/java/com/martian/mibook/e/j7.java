package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.ttbookhd.R;

/* loaded from: classes3.dex */
public final class j7 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f12208a;

    /* renamed from: b */
    @NonNull
    public final ThemeLinearLayout f12209b;

    /* renamed from: c */
    @NonNull
    public final TextView f12210c;

    /* renamed from: d */
    @NonNull
    public final TextView f12211d;

    private j7(@NonNull LinearLayout rootView, @NonNull ThemeLinearLayout withdrawMoney, @NonNull TextView withdrawMoneyDesc, @NonNull TextView withdrawMoneyTitle) {
        this.f12208a = rootView;
        this.f12209b = withdrawMoney;
        this.f12210c = withdrawMoneyDesc;
        this.f12211d = withdrawMoneyTitle;
    }

    @NonNull
    public static j7 a(@NonNull View rootView) {
        int i2 = R.id.withdraw_money;
        ThemeLinearLayout themeLinearLayout = (ThemeLinearLayout) rootView.findViewById(R.id.withdraw_money);
        if (themeLinearLayout != null) {
            i2 = R.id.withdraw_money_desc;
            TextView textView = (TextView) rootView.findViewById(R.id.withdraw_money_desc);
            if (textView != null) {
                i2 = R.id.withdraw_money_title;
                TextView textView2 = (TextView) rootView.findViewById(R.id.withdraw_money_title);
                if (textView2 != null) {
                    return new j7((LinearLayout) rootView, themeLinearLayout, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static j7 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static j7 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.withdraw_money_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f12208a;
    }
}
