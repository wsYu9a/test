package com.martian.mibook.lib.account.adapter;

import android.view.View;
import com.martian.libmars.activity.j1;
import com.martian.libsupport.k;
import com.martian.mibook.lib.account.R;
import com.martian.mibook.lib.account.response.TYConsumeOrder;
import java.util.List;

/* loaded from: classes3.dex */
public class g extends com.martian.libmars.widget.recyclerview.e.c<TYConsumeOrder> {
    public g(j1 activity, final List<TYConsumeOrder> datas) {
        super(activity, R.layout.purchase_txs_record_item, datas);
    }

    private View P(final com.martian.libmars.widget.recyclerview.d holder, final TYConsumeOrder tyConsumeOrder) {
        if (tyConsumeOrder == null) {
            return null;
        }
        holder.W(R.id.tv_consume_coins, "消费 " + tyConsumeOrder.getBookCoins() + " 书币");
        holder.W(R.id.tv_order_id, " (订单" + tyConsumeOrder.getCoid() + ")");
        if (!k.p(tyConsumeOrder.getSubject())) {
            holder.W(R.id.tv_purchase_time, tyConsumeOrder.getSubject());
        }
        if (tyConsumeOrder.getCotype() == null || tyConsumeOrder.getCotype().intValue() != 2) {
            holder.W(R.id.tv_purchase_chapter_count, "章节购买");
        } else {
            holder.W(R.id.tv_purchase_chapter_count, "整本购买");
        }
        return holder.getView(R.id.record_view);
    }

    @Override // com.martian.libmars.widget.recyclerview.e.c
    /* renamed from: O */
    public void b(com.martian.libmars.widget.recyclerview.d helper, TYConsumeOrder tyConsumeOrder) {
        P(helper, tyConsumeOrder);
    }
}
