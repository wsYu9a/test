package com.martian.mibook.lib.account.adapter;

import android.content.Context;
import com.martian.libmars.utils.n0;
import com.martian.mibook.lib.account.R;
import com.martian.mibook.lib.account.response.WithdrawRank;
import de.hdodenhof.circleimageview.CircleImageView;
import java.util.List;

/* loaded from: classes3.dex */
public class i extends com.martian.libmars.widget.recyclerview.e.c<WithdrawRank> {

    /* renamed from: g */
    private final Context f13811g;

    public i(Context context, List<WithdrawRank> datas) {
        super(context, R.layout.withdraw_rank_item, datas);
        this.f13811g = context;
    }

    private void P(final com.martian.libmars.widget.recyclerview.d holder, final WithdrawRank withdrawRank) {
        if (withdrawRank == null) {
            return;
        }
        n0.l(this.f13811g, withdrawRank.getHeader(), (CircleImageView) holder.getView(R.id.rd_withdraw_type), R.drawable.day_img_heads);
        holder.W(R.id.rd_withdraw_name, withdrawRank.getNickname());
        if (withdrawRank.getTotalMoney() != 0) {
            holder.W(R.id.rd_withdraw_money, com.martian.rpauth.d.i.p(Integer.valueOf(withdrawRank.getTotalMoney())));
        }
        holder.W(R.id.rd_withdraw_invitee_num, "有效徒弟:" + withdrawRank.getValidInviteeNum() + "人");
    }

    @Override // com.martian.libmars.widget.recyclerview.e.c
    /* renamed from: O */
    public void b(com.martian.libmars.widget.recyclerview.d helper, WithdrawRank withdrawRank) {
        P(helper, withdrawRank);
    }
}
