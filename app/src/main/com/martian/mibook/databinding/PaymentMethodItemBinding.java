package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;
import com.martian.mibook.mvvm.payment.ui.ThemeVipLinearLayout;

/* loaded from: classes3.dex */
public final class PaymentMethodItemBinding implements ViewBinding {

    @NonNull
    public final ImageView paymentMethodIcon;

    @NonNull
    public final ThemeTextView paymentMethodTitle;

    @NonNull
    public final ThemeVipLinearLayout paymentMethodView;

    @NonNull
    private final ThemeVipLinearLayout rootView;

    private PaymentMethodItemBinding(@NonNull ThemeVipLinearLayout themeVipLinearLayout, @NonNull ImageView imageView, @NonNull ThemeTextView themeTextView, @NonNull ThemeVipLinearLayout themeVipLinearLayout2) {
        this.rootView = themeVipLinearLayout;
        this.paymentMethodIcon = imageView;
        this.paymentMethodTitle = themeTextView;
        this.paymentMethodView = themeVipLinearLayout2;
    }

    @NonNull
    public static PaymentMethodItemBinding bind(@NonNull View view) {
        int i10 = R.id.paymentMethodIcon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i10);
        if (imageView != null) {
            i10 = R.id.paymentMethodTitle;
            ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
            if (themeTextView != null) {
                ThemeVipLinearLayout themeVipLinearLayout = (ThemeVipLinearLayout) view;
                return new PaymentMethodItemBinding(themeVipLinearLayout, imageView, themeTextView, themeVipLinearLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static PaymentMethodItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static PaymentMethodItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.payment_method_item, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ThemeVipLinearLayout getRoot() {
        return this.rootView;
    }
}
