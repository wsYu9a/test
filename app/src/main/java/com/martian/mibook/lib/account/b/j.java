package com.martian.mibook.lib.account.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.mibook.lib.account.R;

/* loaded from: classes3.dex */
public final class j implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f13874a;

    /* renamed from: b */
    @NonNull
    public final LinearLayout f13875b;

    /* renamed from: c */
    @NonNull
    public final TextView f13876c;

    /* renamed from: d */
    @NonNull
    public final TextView f13877d;

    /* renamed from: e */
    @NonNull
    public final TextView f13878e;

    /* renamed from: f */
    @NonNull
    public final TextView f13879f;

    private j(@NonNull LinearLayout rootView, @NonNull LinearLayout recordView, @NonNull TextView tvConsumeCoins, @NonNull TextView tvOrderId, @NonNull TextView tvPurchaseChapterCount, @NonNull TextView tvPurchaseTime) {
        this.f13874a = rootView;
        this.f13875b = recordView;
        this.f13876c = tvConsumeCoins;
        this.f13877d = tvOrderId;
        this.f13878e = tvPurchaseChapterCount;
        this.f13879f = tvPurchaseTime;
    }

    @NonNull
    public static j a(@NonNull View rootView) {
        LinearLayout linearLayout = (LinearLayout) rootView;
        int i2 = R.id.tv_consume_coins;
        TextView textView = (TextView) rootView.findViewById(i2);
        if (textView != null) {
            i2 = R.id.tv_order_id;
            TextView textView2 = (TextView) rootView.findViewById(i2);
            if (textView2 != null) {
                i2 = R.id.tv_purchase_chapter_count;
                TextView textView3 = (TextView) rootView.findViewById(i2);
                if (textView3 != null) {
                    i2 = R.id.tv_purchase_time;
                    TextView textView4 = (TextView) rootView.findViewById(i2);
                    if (textView4 != null) {
                        return new j((LinearLayout) rootView, linearLayout, textView, textView2, textView3, textView4);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static j c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static j d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.purchase_txs_record_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f13874a;
    }
}
