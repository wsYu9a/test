package com.martian.mibook.ui.o;

import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.martian.mibook.lib.account.response.TYInvitee;
import com.martian.ttbookhd.R;
import java.util.List;

/* loaded from: classes4.dex */
public class c4 extends com.martian.libmars.widget.recyclerview.e.c<TYInvitee> {

    /* renamed from: g */
    private final com.martian.libmars.activity.j1 f14314g;

    public c4(com.martian.libmars.activity.j1 activity, final List<TYInvitee> datas) {
        super(activity, R.layout.martian_invitee_duration_rank_item, datas);
        this.f14314g = activity;
    }

    private void P(final com.martian.libmars.widget.recyclerview.d holder, final TYInvitee rcInvitee) {
        if (rcInvitee == null) {
            return;
        }
        com.martian.libmars.utils.n0.l(this.f14314g, rcInvitee.getHeader(), (ImageView) holder.getView(R.id.rd_invitee_header), R.drawable.icon_header);
        if (!com.martian.libsupport.k.p(rcInvitee.getNickname())) {
            holder.W(R.id.rd_invitee_nickname, rcInvitee.getNickname());
        }
        holder.W(R.id.rd_invitee_coins, "" + rcInvitee.getCoins());
        holder.W(R.id.rd_invitee_coins_today, "今日进贡" + rcInvitee.getCoinsToday() + "金币");
        StringBuilder sb = new StringBuilder();
        sb.append("uid:A");
        sb.append(rcInvitee.getUid());
        holder.W(R.id.rd_invitee_uid, sb.toString());
        int adapterPosition = holder.getAdapterPosition() - 2;
        holder.W(R.id.rd_rank_idx, (adapterPosition + 1) + "");
        if (adapterPosition == 0) {
            holder.G(R.id.rd_rank_idx, ContextCompat.getColor(this.f14314g, R.color.search_rank_1));
        } else if (adapterPosition == 1) {
            holder.G(R.id.rd_rank_idx, ContextCompat.getColor(this.f14314g, R.color.search_rank_2));
        } else if (adapterPosition == 2) {
            holder.G(R.id.rd_rank_idx, ContextCompat.getColor(this.f14314g, R.color.search_rank_3));
        } else {
            holder.G(R.id.rd_rank_idx, ContextCompat.getColor(this.f14314g, R.color.search_rank_4));
        }
        if (rcInvitee.getCreatOn() == -1) {
            holder.a0(R.id.rd_invitee_time, false);
            return;
        }
        try {
            holder.W(R.id.rd_invitee_time, com.martian.libsupport.d.i(rcInvitee.getCreatOn(), "yyyy/MM/dd") + "注册");
        } catch (Exception unused) {
        }
        holder.a0(R.id.rd_invitee_time, true);
    }

    @Override // com.martian.libmars.widget.recyclerview.e.c
    /* renamed from: O */
    public void b(com.martian.libmars.widget.recyclerview.d helper, TYInvitee tyInvitee) {
        P(helper, tyInvitee);
    }
}
