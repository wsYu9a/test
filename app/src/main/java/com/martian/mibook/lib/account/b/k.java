package com.martian.mibook.lib.account.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.lib.account.R;

/* loaded from: classes3.dex */
public final class k implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f13880a;

    /* renamed from: b */
    @NonNull
    public final LinearLayout f13881b;

    /* renamed from: c */
    @NonNull
    public final ThemeTextView f13882c;

    /* renamed from: d */
    @NonNull
    public final ThemeTextView f13883d;

    /* renamed from: e */
    @NonNull
    public final ThemeTextView f13884e;

    /* renamed from: f */
    @NonNull
    public final ThemeTextView f13885f;

    private k(@NonNull LinearLayout rootView, @NonNull LinearLayout rechargeView, @NonNull ThemeTextView tvConsumeCoins, @NonNull ThemeTextView tvOrderId, @NonNull ThemeTextView tvPurchaseChapterCount, @NonNull ThemeTextView tvPurchaseTime) {
        this.f13880a = rootView;
        this.f13881b = rechargeView;
        this.f13882c = tvConsumeCoins;
        this.f13883d = tvOrderId;
        this.f13884e = tvPurchaseChapterCount;
        this.f13885f = tvPurchaseTime;
    }

    @NonNull
    public static k a(@NonNull View rootView) {
        LinearLayout linearLayout = (LinearLayout) rootView;
        int i2 = R.id.tv_consume_coins;
        ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(i2);
        if (themeTextView != null) {
            i2 = R.id.tv_order_id;
            ThemeTextView themeTextView2 = (ThemeTextView) rootView.findViewById(i2);
            if (themeTextView2 != null) {
                i2 = R.id.tv_purchase_chapter_count;
                ThemeTextView themeTextView3 = (ThemeTextView) rootView.findViewById(i2);
                if (themeTextView3 != null) {
                    i2 = R.id.tv_purchase_time;
                    ThemeTextView themeTextView4 = (ThemeTextView) rootView.findViewById(i2);
                    if (themeTextView4 != null) {
                        return new k((LinearLayout) rootView, linearLayout, themeTextView, themeTextView2, themeTextView3, themeTextView4);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static k c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static k d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.recharge_record_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f13880a;
    }
}
