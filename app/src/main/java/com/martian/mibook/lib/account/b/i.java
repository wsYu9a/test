package com.martian.mibook.lib.account.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.lib.account.R;
import de.hdodenhof.circleimageview.CircleImageView;

/* loaded from: classes3.dex */
public final class i implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final RelativeLayout f13864a;

    /* renamed from: b */
    @NonNull
    public final ThemeTextView f13865b;

    /* renamed from: c */
    @NonNull
    public final TextView f13866c;

    /* renamed from: d */
    @NonNull
    public final CircleImageView f13867d;

    /* renamed from: e */
    @NonNull
    public final TextView f13868e;

    /* renamed from: f */
    @NonNull
    public final TextView f13869f;

    /* renamed from: g */
    @NonNull
    public final ThemeTextView f13870g;

    /* renamed from: h */
    @NonNull
    public final TextView f13871h;

    /* renamed from: i */
    @NonNull
    public final CircleImageView f13872i;

    /* renamed from: j */
    @NonNull
    public final TextView f13873j;

    @NonNull
    public final TextView k;

    private i(@NonNull RelativeLayout rootView, @NonNull ThemeTextView cloudAccount, @NonNull TextView cloudCoins, @NonNull CircleImageView cloudHeader, @NonNull TextView cloudMoney, @NonNull TextView cloudNickname, @NonNull ThemeTextView guestAccount, @NonNull TextView guestCoins, @NonNull CircleImageView guestHeader, @NonNull TextView guestMoney, @NonNull TextView guestNickname) {
        this.f13864a = rootView;
        this.f13865b = cloudAccount;
        this.f13866c = cloudCoins;
        this.f13867d = cloudHeader;
        this.f13868e = cloudMoney;
        this.f13869f = cloudNickname;
        this.f13870g = guestAccount;
        this.f13871h = guestCoins;
        this.f13872i = guestHeader;
        this.f13873j = guestMoney;
        this.k = guestNickname;
    }

    @NonNull
    public static i a(@NonNull View rootView) {
        int i2 = R.id.cloud_account;
        ThemeTextView themeTextView = (ThemeTextView) rootView.findViewById(i2);
        if (themeTextView != null) {
            i2 = R.id.cloud_coins;
            TextView textView = (TextView) rootView.findViewById(i2);
            if (textView != null) {
                i2 = R.id.cloud_header;
                CircleImageView circleImageView = (CircleImageView) rootView.findViewById(i2);
                if (circleImageView != null) {
                    i2 = R.id.cloud_money;
                    TextView textView2 = (TextView) rootView.findViewById(i2);
                    if (textView2 != null) {
                        i2 = R.id.cloud_nickname;
                        TextView textView3 = (TextView) rootView.findViewById(i2);
                        if (textView3 != null) {
                            i2 = R.id.guest_account;
                            ThemeTextView themeTextView2 = (ThemeTextView) rootView.findViewById(i2);
                            if (themeTextView2 != null) {
                                i2 = R.id.guest_coins;
                                TextView textView4 = (TextView) rootView.findViewById(i2);
                                if (textView4 != null) {
                                    i2 = R.id.guest_header;
                                    CircleImageView circleImageView2 = (CircleImageView) rootView.findViewById(i2);
                                    if (circleImageView2 != null) {
                                        i2 = R.id.guest_money;
                                        TextView textView5 = (TextView) rootView.findViewById(i2);
                                        if (textView5 != null) {
                                            i2 = R.id.guest_nickname;
                                            TextView textView6 = (TextView) rootView.findViewById(i2);
                                            if (textView6 != null) {
                                                return new i((RelativeLayout) rootView, themeTextView, textView, circleImageView, textView2, textView3, themeTextView2, textView4, circleImageView2, textView5, textView6);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i2)));
    }

    @NonNull
    public static i c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static i d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.popupwindow_account_switch, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f13864a;
    }
}
