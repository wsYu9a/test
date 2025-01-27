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
import de.hdodenhof.circleimageview.CircleImageView;

/* loaded from: classes3.dex */
public final class f implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f13847a;

    /* renamed from: b */
    @NonNull
    public final TextView f13848b;

    /* renamed from: c */
    @NonNull
    public final TextView f13849c;

    /* renamed from: d */
    @NonNull
    public final TextView f13850d;

    /* renamed from: e */
    @NonNull
    public final TextView f13851e;

    /* renamed from: f */
    @NonNull
    public final TextView f13852f;

    /* renamed from: g */
    @NonNull
    public final CircleImageView f13853g;

    private f(@NonNull LinearLayout rootView, @NonNull TextView rdWithdrawMoney, @NonNull TextView rdWithdrawMsg, @NonNull TextView rdWithdrawName, @NonNull TextView rdWithdrawStatus, @NonNull TextView rdWithdrawTime, @NonNull CircleImageView rdWithdrawType) {
        this.f13847a = rootView;
        this.f13848b = rdWithdrawMoney;
        this.f13849c = rdWithdrawMsg;
        this.f13850d = rdWithdrawName;
        this.f13851e = rdWithdrawStatus;
        this.f13852f = rdWithdrawTime;
        this.f13853g = rdWithdrawType;
    }

    @NonNull
    public static f a(@NonNull View rootView) {
        int i2 = R.id.rd_withdraw_money;
        TextView textView = (TextView) rootView.findViewById(i2);
        if (textView != null) {
            i2 = R.id.rd_withdraw_msg;
            TextView textView2 = (TextView) rootView.findViewById(i2);
            if (textView2 != null) {
                i2 = R.id.rd_withdraw_name;
                TextView textView3 = (TextView) rootView.findViewById(i2);
                if (textView3 != null) {
                    i2 = R.id.rd_withdraw_status;
                    TextView textView4 = (TextView) rootView.findViewById(i2);
                    if (textView4 != null) {
                        i2 = R.id.rd_withdraw_time;
                        TextView textView5 = (TextView) rootView.findViewById(i2);
                        if (textView5 != null) {
                            i2 = R.id.rd_withdraw_type;
                            CircleImageView circleImageView = (CircleImageView) rootView.findViewById(i2);
                            if (circleImageView != null) {
                                return new f((LinearLayout) rootView, textView, textView2, textView3, textView4, textView5, circleImageView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static f c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static f d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.martian_all_withdraw_order_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f13847a;
    }
}
