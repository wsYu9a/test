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
import de.hdodenhof.circleimageview.CircleImageView;

/* loaded from: classes3.dex */
public final class l implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final ThemeLinearLayout f13886a;

    /* renamed from: b */
    @NonNull
    public final ThemeTextView f13887b;

    /* renamed from: c */
    @NonNull
    public final TextView f13888c;

    /* renamed from: d */
    @NonNull
    public final ThemeTextView f13889d;

    /* renamed from: e */
    @NonNull
    public final ThemeTextView f13890e;

    /* renamed from: f */
    @NonNull
    public final CircleImageView f13891f;

    private l(@NonNull ThemeLinearLayout rootView, @NonNull ThemeTextView rdWithdrawInviteeNum, @NonNull TextView rdWithdrawMoney, @NonNull ThemeTextView rdWithdrawName, @NonNull ThemeTextView rdWithdrawStatus, @NonNull CircleImageView rdWithdrawType) {
        this.f13886a = rootView;
        this.f13887b = rdWithdrawInviteeNum;
        this.f13888c = rdWithdrawMoney;
        this.f13889d = rdWithdrawName;
        this.f13890e = rdWithdrawStatus;
        this.f13891f = rdWithdrawType;
    }

    @NonNull
    public static l a(@NonNull View rootView) {
        int i2 = R.id.rd_withdraw_invitee_num;
        ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(i2);
        if (themeTextView != null) {
            i2 = R.id.rd_withdraw_money;
            TextView textView = (TextView) rootView.findViewById(i2);
            if (textView != null) {
                i2 = R.id.rd_withdraw_name;
                ThemeTextView themeTextView2 = (ThemeTextView) rootView.findViewById(i2);
                if (themeTextView2 != null) {
                    i2 = R.id.rd_withdraw_status;
                    ThemeTextView themeTextView3 = (ThemeTextView) rootView.findViewById(i2);
                    if (themeTextView3 != null) {
                        i2 = R.id.rd_withdraw_type;
                        CircleImageView circleImageView = (CircleImageView) rootView.findViewById(i2);
                        if (circleImageView != null) {
                            return new l((ThemeLinearLayout) rootView, themeTextView, textView, themeTextView2, themeTextView3, circleImageView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static l c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static l d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.withdraw_rank_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public ThemeLinearLayout getRoot() {
        return this.f13886a;
    }
}
