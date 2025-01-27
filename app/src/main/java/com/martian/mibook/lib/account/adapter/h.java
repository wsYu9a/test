package com.martian.mibook.lib.account.adapter;

import android.view.View;
import com.martian.libmars.activity.j1;
import com.martian.mibook.lib.account.R;
import com.martian.mibook.lib.account.response.MiRechargeOrder;
import java.util.List;

/* loaded from: classes3.dex */
public class h extends com.martian.libmars.widget.recyclerview.e.c<MiRechargeOrder> {
    public h(j1 activity, final List<MiRechargeOrder> datas) {
        super(activity, R.layout.recharge_record_item, datas);
    }

    private View P(final com.martian.libmars.widget.recyclerview.d holder, final MiRechargeOrder rechargeOrder) {
        if (rechargeOrder == null) {
            return null;
        }
        holder.W(R.id.tv_purchase_chapter_count, "充值 " + com.martian.rpauth.d.i.m(Integer.valueOf(rechargeOrder.getMoney())) + "元");
        int intValue = rechargeOrder.status.intValue();
        if (intValue == -1) {
            holder.W(R.id.tv_consume_coins, "订单失效");
        } else if (intValue == 0) {
            holder.W(R.id.tv_consume_coins, "未支付");
        } else if (intValue == 1) {
            holder.W(R.id.tv_consume_coins, "正在支付");
        } else if (intValue == 2) {
            holder.W(R.id.tv_consume_coins, "支付成功");
        }
        holder.W(R.id.tv_order_id, rechargeOrder.getMoney() + " 淘书币");
        if (rechargeOrder.getCreatOn() != null) {
            try {
                holder.W(R.id.tv_purchase_time, com.martian.libsupport.d.h(rechargeOrder.getCreatOn().longValue()));
            } catch (Exception unused) {
            }
        } else {
            holder.a0(R.id.tv_purchase_time, false);
        }
        return holder.getView(R.id.recharge_view);
    }

    @Override // com.martian.libmars.widget.recyclerview.e.c
    /* renamed from: O */
    public void b(com.martian.libmars.widget.recyclerview.d helper, MiRechargeOrder rechargeOrder) {
        P(helper, rechargeOrder);
    }
}
