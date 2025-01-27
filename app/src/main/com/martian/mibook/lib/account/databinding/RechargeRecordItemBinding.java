package com.martian.mibook.lib.account.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.lib.account.R;

/* loaded from: classes3.dex */
public final class RechargeRecordItemBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f13954a;

    /* renamed from: b */
    @NonNull
    public final LinearLayout f13955b;

    /* renamed from: c */
    @NonNull
    public final ThemeTextView f13956c;

    /* renamed from: d */
    @NonNull
    public final ThemeTextView f13957d;

    /* renamed from: e */
    @NonNull
    public final ThemeTextView f13958e;

    /* renamed from: f */
    @NonNull
    public final ThemeTextView f13959f;

    public RechargeRecordItemBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull ThemeTextView themeTextView, @NonNull ThemeTextView themeTextView2, @NonNull ThemeTextView themeTextView3, @NonNull ThemeTextView themeTextView4) {
        this.f13954a = linearLayout;
        this.f13955b = linearLayout2;
        this.f13956c = themeTextView;
        this.f13957d = themeTextView2;
        this.f13958e = themeTextView3;
        this.f13959f = themeTextView4;
    }

    @NonNull
    public static RechargeRecordItemBinding a(@NonNull View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i10 = R.id.tv_consume_coins;
        ThemeTextView themeTextView = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
        if (themeTextView != null) {
            i10 = R.id.tv_order_id;
            ThemeTextView themeTextView2 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
            if (themeTextView2 != null) {
                i10 = R.id.tv_purchase_chapter_count;
                ThemeTextView themeTextView3 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                if (themeTextView3 != null) {
                    i10 = R.id.tv_purchase_time;
                    ThemeTextView themeTextView4 = (ThemeTextView) ViewBindings.findChildViewById(view, i10);
                    if (themeTextView4 != null) {
                        return new RechargeRecordItemBinding(linearLayout, linearLayout, themeTextView, themeTextView2, themeTextView3, themeTextView4);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static RechargeRecordItemBinding c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static RechargeRecordItemBinding d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.recharge_record_item, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f13954a;
    }
}
