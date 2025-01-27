package com.martian.mibook.lib.account.databinding;

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
import com.martian.mibook.lib.account.R;

/* loaded from: classes3.dex */
public final class MartianWithdrawOrderItemBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final ThemeLinearLayout f13948a;

    /* renamed from: b */
    @NonNull
    public final ThemeTextView f13949b;

    /* renamed from: c */
    @NonNull
    public final TextView f13950c;

    /* renamed from: d */
    @NonNull
    public final ThemeTextView f13951d;

    /* renamed from: e */
    @NonNull
    public final TextView f13952e;

    /* renamed from: f */
    @NonNull
    public final ThemeTextView f13953f;

    public MartianWithdrawOrderItemBinding(@NonNull ThemeLinearLayout themeLinearLayout, @NonNull ThemeTextView themeTextView, @NonNull TextView textView, @NonNull ThemeTextView themeTextView2, @NonNull TextView textView2, @NonNull ThemeTextView themeTextView3) {
        this.f13948a = themeLinearLayout;
        this.f13949b = themeTextView;
        this.f13950c = textView;
        this.f13951d = themeTextView2;
        this.f13952e = textView2;
        this.f13953f = themeTextView3;
    }

    @NonNull
    public static MartianWithdrawOrderItemBinding a(@NonNull View view) {
        int i10 = R.id.rd_withdraw_id;
        ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
        if (themeTextView != null) {
            i10 = R.id.rd_withdraw_money;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
            if (textView != null) {
                i10 = R.id.rd_withdraw_name;
                ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (themeTextView2 != null) {
                    i10 = R.id.rd_withdraw_status;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i10);
                    if (textView2 != null) {
                        i10 = R.id.rd_withdraw_time;
                        ThemeTextView themeTextView3 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                        if (themeTextView3 != null) {
                            return new MartianWithdrawOrderItemBinding((ThemeLinearLayout) view, themeTextView, textView, themeTextView2, textView2, themeTextView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static MartianWithdrawOrderItemBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static MartianWithdrawOrderItemBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.martian_withdraw_order_item, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeLinearLayout getRoot() {
        return this.f13948a;
    }
}
