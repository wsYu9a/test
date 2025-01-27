package com.martian.mibook.lib.account.adapter;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.martian.libsupport.k;
import com.martian.mibook.lib.account.R;
import com.martian.mibook.lib.account.response.HistoryMoney;
import java.util.List;

/* loaded from: classes3.dex */
public class c extends com.martian.libmars.widget.recyclerview.e.c<HistoryMoney> {

    /* renamed from: g */
    private final Context f13808g;

    public c(Context context, List<HistoryMoney> datas) {
        super(context, R.layout.martian_income_list_item, datas);
        this.f13808g = context;
    }

    private void P(final com.martian.libmars.widget.recyclerview.d holder, final HistoryMoney historyMoney) {
        if (historyMoney == null) {
            return;
        }
        holder.W(R.id.martian_income_title, k.p(historyMoney.getMoneyType()) ? "金币兑换余额" : historyMoney.getMoneyType());
        if (historyMoney.getMoney() > 0) {
            int i2 = R.id.martian_income_num;
            holder.X(i2, ContextCompat.getColor(this.f13808g, R.color.bonus_red));
            holder.W(i2, "+" + com.martian.rpauth.d.i.p(Integer.valueOf(historyMoney.getMoney())) + "元");
        } else {
            int i3 = R.id.martian_income_num;
            holder.X(i3, com.martian.libmars.d.h.F().p0());
            holder.W(i3, com.martian.rpauth.d.i.p(Integer.valueOf(historyMoney.getMoney())) + "元");
        }
        try {
            holder.W(R.id.martian_income_time, com.martian.libsupport.d.h(historyMoney.getCreatedOn().longValue()));
        } catch (Exception unused) {
        }
    }

    @Override // com.martian.libmars.widget.recyclerview.e.c
    /* renamed from: O */
    public void b(com.martian.libmars.widget.recyclerview.d helper, HistoryMoney historyMoney) {
        P(helper, historyMoney);
    }
}
