package com.martian.mibook.ui.adapter;

import android.app.Activity;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import ba.f;
import ba.l;
import com.martian.libmars.widget.recyclerview.ViewHolderHelper;
import com.martian.libmars.widget.recyclerview.adatper.CommonRecycleViewAdapter;
import com.martian.mibook.R;
import com.martian.mibook.lib.account.response.TYInvitee;
import java.util.List;
import l9.m0;

/* loaded from: classes3.dex */
public class MartianInviteeDurationRankAdapter extends CommonRecycleViewAdapter<TYInvitee> {

    /* renamed from: i */
    public final Activity f15861i;

    public MartianInviteeDurationRankAdapter(Activity activity, List<TYInvitee> list) {
        super(activity, R.layout.martian_invitee_duration_rank_item, list);
        this.f15861i = activity;
    }

    @Override // com.martian.libmars.widget.recyclerview.adatper.CommonRecycleViewAdapter
    /* renamed from: t */
    public void k(ViewHolderHelper viewHolderHelper, TYInvitee tYInvitee) {
        u(viewHolderHelper, tYInvitee);
    }

    public final void u(ViewHolderHelper viewHolderHelper, TYInvitee tYInvitee) {
        if (tYInvitee == null) {
            return;
        }
        m0.l(this.f15861i, tYInvitee.getHeader(), (ImageView) viewHolderHelper.g(R.id.rd_invitee_header), R.drawable.icon_header);
        if (!l.q(tYInvitee.getNickname())) {
            viewHolderHelper.A(R.id.rd_invitee_nickname, tYInvitee.getNickname());
        }
        viewHolderHelper.A(R.id.rd_invitee_coins, "" + tYInvitee.getCoins());
        viewHolderHelper.A(R.id.rd_invitee_coins_today, "今日进贡" + tYInvitee.getCoinsToday() + "金币");
        viewHolderHelper.A(R.id.rd_invitee_uid, "uid:A" + tYInvitee.getUid());
        int adapterPosition = viewHolderHelper.getAdapterPosition();
        int i10 = adapterPosition + (-2);
        viewHolderHelper.A(R.id.rd_rank_idx, (adapterPosition - 1) + "");
        if (i10 == 0) {
            viewHolderHelper.j(R.id.rd_rank_idx, ContextCompat.getColor(this.f15861i, R.color.book_mall_rank_1));
        } else if (i10 == 1) {
            viewHolderHelper.j(R.id.rd_rank_idx, ContextCompat.getColor(this.f15861i, R.color.book_mall_rank_2));
        } else if (i10 == 2) {
            viewHolderHelper.j(R.id.rd_rank_idx, ContextCompat.getColor(this.f15861i, R.color.book_mall_rank_3));
        } else {
            viewHolderHelper.j(R.id.rd_rank_idx, ContextCompat.getColor(this.f15861i, R.color.book_mall_rank_4));
        }
        if (tYInvitee.getCreatOn() == -1) {
            viewHolderHelper.E(R.id.rd_invitee_time, false);
            return;
        }
        try {
            viewHolderHelper.A(R.id.rd_invitee_time, f.i(tYInvitee.getCreatOn(), "yyyy/MM/dd") + "注册");
        } catch (Exception unused) {
        }
        viewHolderHelper.E(R.id.rd_invitee_time, true);
    }
}
