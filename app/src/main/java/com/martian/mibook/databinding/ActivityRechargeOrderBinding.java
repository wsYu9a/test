package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeRelativeLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;

/* loaded from: classes3.dex */
public final class ActivityRechargeOrderBinding implements ViewBinding {

    @NonNull
    public final ThemeTextView orderBack;

    @NonNull
    public final ThemeTextView orderMoney;

    @NonNull
    public final LinearLayout orderMoneyView;

    @NonNull
    public final TextView orderStatus;

    @NonNull
    public final ImageView orderStatusLogo;

    @NonNull
    private final ThemeRelativeLayout rootView;

    private ActivityRechargeOrderBinding(@NonNull ThemeRelativeLayout themeRelativeLayout, @NonNull ThemeTextView themeTextView, @NonNull ThemeTextView themeTextView2, @NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull ImageView imageView) {
        this.rootView = themeRelativeLayout;
        this.orderBack = themeTextView;
        this.orderMoney = themeTextView2;
        this.orderMoneyView = linearLayout;
        this.orderStatus = textView;
        this.orderStatusLogo = imageView;
    }

    @NonNull
    public static ActivityRechargeOrderBinding bind(@NonNull View view) {
        int i10 = R.id.order_back;
        ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
        if (themeTextView != null) {
            i10 = R.id.order_money;
            ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
            if (themeTextView2 != null) {
                i10 = R.id.order_money_view;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i10);
                if (linearLayout != null) {
                    i10 = R.id.order_status;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
                    if (textView != null) {
                        i10 = R.id.order_status_logo;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
                        if (imageView != null) {
                            return new ActivityRechargeOrderBinding((ThemeRelativeLayout) view, themeTextView, themeTextView2, linearLayout, textView, imageView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static ActivityRechargeOrderBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityRechargeOrderBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.activity_recharge_order, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ThemeRelativeLayout getRoot() {
        return this.rootView;
    }
}
