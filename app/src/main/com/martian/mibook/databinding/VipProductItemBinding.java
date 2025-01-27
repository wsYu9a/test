package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;
import com.martian.mibook.mvvm.payment.ui.ThemeVipLinearLayout;
import com.martian.mibook.mvvm.payment.ui.ThemeVipTextView;

/* loaded from: classes3.dex */
public final class VipProductItemBinding implements ViewBinding {

    @NonNull
    public final ThemeVipTextView discountTag;

    @NonNull
    public final ThemeTextView productCurrency;

    @NonNull
    public final ThemeTextView productOriginalPrice;

    @NonNull
    public final ThemeTextView productPrice;

    @NonNull
    public final ThemeTextView productTitle;

    @NonNull
    public final ThemeVipLinearLayout productView;

    @NonNull
    private final LinearLayout rootView;

    private VipProductItemBinding(@NonNull LinearLayout linearLayout, @NonNull ThemeVipTextView themeVipTextView, @NonNull ThemeTextView themeTextView, @NonNull ThemeTextView themeTextView2, @NonNull ThemeTextView themeTextView3, @NonNull ThemeTextView themeTextView4, @NonNull ThemeVipLinearLayout themeVipLinearLayout) {
        this.rootView = linearLayout;
        this.discountTag = themeVipTextView;
        this.productCurrency = themeTextView;
        this.productOriginalPrice = themeTextView2;
        this.productPrice = themeTextView3;
        this.productTitle = themeTextView4;
        this.productView = themeVipLinearLayout;
    }

    @NonNull
    public static VipProductItemBinding bind(@NonNull View view) {
        int i10 = R.id.discountTag;
        ThemeVipTextView themeVipTextView = (ThemeVipTextView) ViewBindings.findChildViewById(view, i10);
        if (themeVipTextView != null) {
            i10 = R.id.productCurrency;
            ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
            if (themeTextView != null) {
                i10 = R.id.productOriginalPrice;
                ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (themeTextView2 != null) {
                    i10 = R.id.productPrice;
                    ThemeTextView themeTextView3 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                    if (themeTextView3 != null) {
                        i10 = R.id.productTitle;
                        ThemeTextView themeTextView4 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                        if (themeTextView4 != null) {
                            i10 = R.id.productView;
                            ThemeVipLinearLayout themeVipLinearLayout = (ThemeVipLinearLayout) ViewBindings.findChildViewById(view, i10);
                            if (themeVipLinearLayout != null) {
                                return new VipProductItemBinding((LinearLayout) view, themeVipTextView, themeTextView, themeTextView2, themeTextView3, themeTextView4, themeVipLinearLayout);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static VipProductItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static VipProductItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.vip_product_item, viewGroup, false);
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
