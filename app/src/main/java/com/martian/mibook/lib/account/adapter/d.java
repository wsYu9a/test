package com.martian.mibook.lib.account.adapter;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.martian.libsupport.k;
import com.martian.mibook.lib.account.R;
import com.martian.mibook.lib.account.response.MartianWithdrawOrder;
import java.util.List;

/* loaded from: classes3.dex */
public class d extends com.martian.libmars.widget.recyclerview.e.c<MartianWithdrawOrder> {

    /* renamed from: g */
    private final Context f13809g;

    public d(Context context, List<MartianWithdrawOrder> datas) {
        super(context, R.layout.martian_withdraw_order_item, datas);
        this.f13809g = context;
    }

    private void Q(final com.martian.libmars.widget.recyclerview.d holder, final MartianWithdrawOrder rpWithdrawOrder) {
        String woname;
        if (rpWithdrawOrder == null) {
            return;
        }
        if (rpWithdrawOrder.getPaymentType() != 100) {
            woname = !k.p(rpWithdrawOrder.getWoname()) ? rpWithdrawOrder.getWoname() : rpWithdrawOrder.getWotype() == 0 ? "零钱微信提现" : "佣金微信提现";
        } else if (k.p(rpWithdrawOrder.getWoname())) {
            StringBuilder sb = new StringBuilder();
            sb.append(rpWithdrawOrder.getWotype() == 0 ? "零钱兑换" : "佣金兑换");
            sb.append(rpWithdrawOrder.getPaymentMoney());
            sb.append(this.f13809g.getString(R.string.txs_coin));
            woname = sb.toString();
        } else {
            woname = rpWithdrawOrder.getWoname();
        }
        holder.W(R.id.rd_withdraw_name, woname);
        if (rpWithdrawOrder.getWoid() != null) {
            int i2 = R.id.rd_withdraw_id;
            holder.a0(i2, true);
            holder.W(i2, "订单号：" + rpWithdrawOrder.getWoid());
        } else {
            holder.a0(R.id.rd_withdraw_id, false);
        }
        if (rpWithdrawOrder.getWostatus() == -1) {
            int i3 = R.id.rd_withdraw_status;
            holder.W(i3, P(rpWithdrawOrder.getWostatus()) + rpWithdrawOrder.getWomsg());
            holder.X(i3, ContextCompat.getColor(this.f13809g, R.color.bonus_red));
        } else {
            int i4 = R.id.rd_withdraw_status;
            holder.W(i4, P(rpWithdrawOrder.getWostatus()));
            holder.X(i4, ContextCompat.getColor(this.f13809g, R.color.theme_default));
        }
        if (rpWithdrawOrder.getMoney() != 0) {
            holder.W(R.id.rd_withdraw_money, "+" + com.martian.rpauth.d.i.m(Integer.valueOf(rpWithdrawOrder.getMoney())) + "元");
        }
        holder.W(R.id.rd_withdraw_time, com.martian.rpauth.d.i.d(Long.valueOf(rpWithdrawOrder.getCreatedOn())));
    }

    @Override // com.martian.libmars.widget.recyclerview.e.c
    /* renamed from: O */
    public void b(com.martian.libmars.widget.recyclerview.d helper, MartianWithdrawOrder martianWithdrawOrder) {
        Q(helper, martianWithdrawOrder);
    }

    public String P(int wostatus) {
        return wostatus != -1 ? wostatus != 1 ? wostatus != 2 ? "审核中" : "已支付" : "审核通过" : "审核不通过:";
    }
}
