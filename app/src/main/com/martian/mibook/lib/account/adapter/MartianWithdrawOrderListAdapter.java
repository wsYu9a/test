package com.martian.mibook.lib.account.adapter;

import android.content.Context;
import androidx.core.content.ContextCompat;
import ba.l;
import com.martian.libmars.widget.recyclerview.ViewHolderHelper;
import com.martian.libmars.widget.recyclerview.adatper.CommonRecycleViewAdapter;
import com.martian.mibook.lib.account.R;
import com.martian.mibook.lib.account.response.MartianWithdrawOrder;
import java.util.List;
import oe.f;

/* loaded from: classes3.dex */
public class MartianWithdrawOrderListAdapter extends CommonRecycleViewAdapter<MartianWithdrawOrder> {

    /* renamed from: i */
    public final Context f13900i;

    public MartianWithdrawOrderListAdapter(Context context, List<MartianWithdrawOrder> list) {
        super(context, R.layout.martian_withdraw_order_item, list);
        this.f13900i = context;
    }

    @Override // com.martian.libmars.widget.recyclerview.adatper.CommonRecycleViewAdapter
    /* renamed from: t */
    public void k(ViewHolderHelper viewHolderHelper, MartianWithdrawOrder martianWithdrawOrder) {
        v(viewHolderHelper, martianWithdrawOrder);
    }

    public String u(int i10) {
        return i10 != -1 ? i10 != 1 ? i10 != 2 ? "审核中" : "已支付" : "审核通过" : "审核不通过:";
    }

    public final void v(ViewHolderHelper viewHolderHelper, MartianWithdrawOrder martianWithdrawOrder) {
        String woname;
        if (martianWithdrawOrder == null) {
            return;
        }
        if (martianWithdrawOrder.getPaymentType() != 100) {
            woname = !l.q(martianWithdrawOrder.getWoname()) ? martianWithdrawOrder.getWoname() : martianWithdrawOrder.getWotype() == 0 ? "零钱微信提现" : "佣金微信提现";
        } else if (l.q(martianWithdrawOrder.getWoname())) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(martianWithdrawOrder.getWotype() == 0 ? "零钱兑换" : "佣金兑换");
            sb2.append(martianWithdrawOrder.getPaymentMoney());
            sb2.append(this.f13900i.getString(R.string.txs_coin));
            woname = sb2.toString();
        } else {
            woname = martianWithdrawOrder.getWoname();
        }
        viewHolderHelper.A(R.id.rd_withdraw_name, woname);
        if (martianWithdrawOrder.getWoid() != null) {
            viewHolderHelper.E(R.id.rd_withdraw_id, true);
            viewHolderHelper.A(R.id.rd_withdraw_id, "订单号：" + martianWithdrawOrder.getWoid());
        } else {
            viewHolderHelper.E(R.id.rd_withdraw_id, false);
        }
        if (martianWithdrawOrder.getWostatus() == -1) {
            viewHolderHelper.A(R.id.rd_withdraw_status, u(martianWithdrawOrder.getWostatus()) + martianWithdrawOrder.getWomsg());
            viewHolderHelper.B(R.id.rd_withdraw_status, ContextCompat.getColor(this.f13900i, com.martian.libmars.R.color.bonus_red));
        } else {
            viewHolderHelper.A(R.id.rd_withdraw_status, u(martianWithdrawOrder.getWostatus()));
            viewHolderHelper.B(R.id.rd_withdraw_status, ContextCompat.getColor(this.f13900i, com.martian.libmars.R.color.theme_default));
        }
        if (martianWithdrawOrder.getMoney() != 0) {
            viewHolderHelper.A(R.id.rd_withdraw_money, "+" + f.n(Integer.valueOf(martianWithdrawOrder.getMoney())) + "元");
        }
        viewHolderHelper.A(R.id.rd_withdraw_time, f.e(Long.valueOf(martianWithdrawOrder.getCreatedOn())));
    }
}
