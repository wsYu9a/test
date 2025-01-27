package com.martian.mibook.e;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.martian.ttbookhd.R;
import de.hdodenhof.circleimageview.CircleImageView;

/* loaded from: classes3.dex */
public final class b4 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    private final LinearLayout f11741a;

    /* renamed from: b */
    @NonNull
    public final LinearLayout f11742b;

    /* renamed from: c */
    @NonNull
    public final TextView f11743c;

    /* renamed from: d */
    @NonNull
    public final TextView f11744d;

    /* renamed from: e */
    @NonNull
    public final CircleImageView f11745e;

    /* renamed from: f */
    @NonNull
    public final TextView f11746f;

    /* renamed from: g */
    @NonNull
    public final TextView f11747g;

    /* renamed from: h */
    @NonNull
    public final TextView f11748h;

    /* renamed from: i */
    @NonNull
    public final TextView f11749i;

    /* renamed from: j */
    @NonNull
    public final TextView f11750j;

    private b4(@NonNull LinearLayout rootView, @NonNull LinearLayout inviteeView, @NonNull TextView rdInviteeCoins, @NonNull TextView rdInviteeCoinsToday, @NonNull CircleImageView rdInviteeHeader, @NonNull TextView rdInviteeNickname, @NonNull TextView rdInviteeTime, @NonNull TextView rdInviteeUid, @NonNull TextView rdInviteeUnit, @NonNull TextView rdRankIdx) {
        this.f11741a = rootView;
        this.f11742b = inviteeView;
        this.f11743c = rdInviteeCoins;
        this.f11744d = rdInviteeCoinsToday;
        this.f11745e = rdInviteeHeader;
        this.f11746f = rdInviteeNickname;
        this.f11747g = rdInviteeTime;
        this.f11748h = rdInviteeUid;
        this.f11749i = rdInviteeUnit;
        this.f11750j = rdRankIdx;
    }

    @NonNull
    public static b4 a(@NonNull View rootView) {
        LinearLayout linearLayout = (LinearLayout) rootView;
        int i2 = R.id.rd_invitee_coins;
        TextView textView = (TextView) rootView.findViewById(R.id.rd_invitee_coins);
        if (textView != null) {
            i2 = R.id.rd_invitee_coins_today;
            TextView textView2 = (TextView) rootView.findViewById(R.id.rd_invitee_coins_today);
            if (textView2 != null) {
                i2 = R.id.rd_invitee_header;
                CircleImageView circleImageView = (CircleImageView) rootView.findViewById(R.id.rd_invitee_header);
                if (circleImageView != null) {
                    i2 = R.id.rd_invitee_nickname;
                    TextView textView3 = (TextView) rootView.findViewById(R.id.rd_invitee_nickname);
                    if (textView3 != null) {
                        i2 = R.id.rd_invitee_time;
                        TextView textView4 = (TextView) rootView.findViewById(R.id.rd_invitee_time);
                        if (textView4 != null) {
                            i2 = R.id.rd_invitee_uid;
                            TextView textView5 = (TextView) rootView.findViewById(R.id.rd_invitee_uid);
                            if (textView5 != null) {
                                i2 = R.id.rd_invitee_unit;
                                TextView textView6 = (TextView) rootView.findViewById(R.id.rd_invitee_unit);
                                if (textView6 != null) {
                                    i2 = R.id.rd_rank_idx;
                                    TextView textView7 = (TextView) rootView.findViewById(R.id.rd_rank_idx);
                                    if (textView7 != null) {
                                        return new b4((LinearLayout) rootView, linearLayout, textView, textView2, circleImageView, textView3, textView4, textView5, textView6, textView7);
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
    public static b4 c(@NonNull LayoutInflater inflater) {
        return d(inflater, null, false);
    }

    @NonNull
    public static b4 d(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.martian_invitee_duration_rank_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return a(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: b */
    public LinearLayout getRoot() {
        return this.f11741a;
    }
}
