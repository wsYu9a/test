package com.martian.mibook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.martian.mibook.R;
import de.hdodenhof.circleimageview.CircleImageView;

/* loaded from: classes3.dex */
public final class MartianInviteeDurationRankItemBinding implements ViewBinding {

    @NonNull
    public final LinearLayout inviteeView;

    @NonNull
    public final TextView rdInviteeCoins;

    @NonNull
    public final TextView rdInviteeCoinsToday;

    @NonNull
    public final CircleImageView rdInviteeHeader;

    @NonNull
    public final TextView rdInviteeNickname;

    @NonNull
    public final TextView rdInviteeTime;

    @NonNull
    public final TextView rdInviteeUid;

    @NonNull
    public final TextView rdInviteeUnit;

    @NonNull
    public final TextView rdRankIdx;

    @NonNull
    private final LinearLayout rootView;

    private MartianInviteeDurationRankItemBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull CircleImageView circleImageView, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull TextView textView6, @NonNull TextView textView7) {
        this.rootView = linearLayout;
        this.inviteeView = linearLayout2;
        this.rdInviteeCoins = textView;
        this.rdInviteeCoinsToday = textView2;
        this.rdInviteeHeader = circleImageView;
        this.rdInviteeNickname = textView3;
        this.rdInviteeTime = textView4;
        this.rdInviteeUid = textView5;
        this.rdInviteeUnit = textView6;
        this.rdRankIdx = textView7;
    }

    @NonNull
    public static MartianInviteeDurationRankItemBinding bind(@NonNull View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i10 = R.id.rd_invitee_coins;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i10);
        if (textView != null) {
            i10 = R.id.rd_invitee_coins_today;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i10);
            if (textView2 != null) {
                i10 = R.id.rd_invitee_header;
                CircleImageView circleImageView = (CircleImageView) ViewBindings.findChildViewById(view, i10);
                if (circleImageView != null) {
                    i10 = R.id.rd_invitee_nickname;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i10);
                    if (textView3 != null) {
                        i10 = R.id.rd_invitee_time;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i10);
                        if (textView4 != null) {
                            i10 = R.id.rd_invitee_uid;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i10);
                            if (textView5 != null) {
                                i10 = R.id.rd_invitee_unit;
                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i10);
                                if (textView6 != null) {
                                    i10 = R.id.rd_rank_idx;
                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i10);
                                    if (textView7 != null) {
                                        return new MartianInviteeDurationRankItemBinding(linearLayout, linearLayout, textView, textView2, circleImageView, textView3, textView4, textView5, textView6, textView7);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    @NonNull
    public static MartianInviteeDurationRankItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static MartianInviteeDurationRankItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.martian_invitee_duration_rank_item, viewGroup, false);
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
