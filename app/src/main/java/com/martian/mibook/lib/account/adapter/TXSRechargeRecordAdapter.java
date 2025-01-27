package com.martian.mibook.lib.account.adapter;

import android.app.Activity;
import android.view.View;
import com.martian.libmars.widget.recyclerview.ViewHolderHelper;
import com.martian.libmars.widget.recyclerview.adatper.CommonRecycleViewAdapter;
import com.martian.mibook.lib.account.R;
import com.martian.mibook.lib.account.response.MiRechargeOrder;
import java.util.List;
import oe.f;

/* loaded from: classes3.dex */
public class TXSRechargeRecordAdapter extends CommonRecycleViewAdapter<MiRechargeOrder> {
    public TXSRechargeRecordAdapter(Activity activity, List<MiRechargeOrder> list) {
        super(activity, R.layout.recharge_record_item, list);
    }

    @Override // com.martian.libmars.widget.recyclerview.adatper.CommonRecycleViewAdapter
    /* renamed from: t */
    public void k(ViewHolderHelper viewHolderHelper, MiRechargeOrder miRechargeOrder) {
        u(viewHolderHelper, miRechargeOrder);
    }

    public final View u(ViewHolderHelper viewHolderHelper, MiRechargeOrder miRechargeOrder) {
        if (miRechargeOrder == null) {
            return null;
        }
        viewHolderHelper.A(R.id.tv_purchase_chapter_count, "充值 " + f.n(Integer.valueOf(miRechargeOrder.getMoney())) + "元");
        int intValue = miRechargeOrder.status.intValue();
        if (intValue == -1) {
            viewHolderHelper.A(R.id.tv_consume_coins, "订单失效");
        } else if (intValue == 0) {
            viewHolderHelper.A(R.id.tv_consume_coins, "未支付");
        } else if (intValue == 1) {
            viewHolderHelper.A(R.id.tv_consume_coins, "正在支付");
        } else if (intValue == 2) {
            viewHolderHelper.A(R.id.tv_consume_coins, "支付成功");
        }
        viewHolderHelper.A(R.id.tv_order_id, miRechargeOrder.getMoney() + " 淘书币");
        if (miRechargeOrder.getCreatOn() != null) {
            try {
                viewHolderHelper.A(R.id.tv_purchase_time, ba.f.h(miRechargeOrder.getCreatOn().longValue()));
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        } else {
            viewHolderHelper.E(R.id.tv_purchase_time, false);
        }
        return viewHolderHelper.g(R.id.recharge_view);
    }
}
