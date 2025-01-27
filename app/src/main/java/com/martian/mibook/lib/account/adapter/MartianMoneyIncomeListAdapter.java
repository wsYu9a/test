package com.martian.mibook.lib.account.adapter;

import android.content.Context;
import androidx.core.content.ContextCompat;
import ba.l;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.widget.recyclerview.ViewHolderHelper;
import com.martian.libmars.widget.recyclerview.adatper.CommonRecycleViewAdapter;
import com.martian.mibook.lib.account.R;
import com.martian.mibook.lib.account.response.HistoryMoney;
import java.util.List;
import oe.f;

/* loaded from: classes3.dex */
public class MartianMoneyIncomeListAdapter extends CommonRecycleViewAdapter<HistoryMoney> {

    /* renamed from: i */
    public final Context f13899i;

    public MartianMoneyIncomeListAdapter(Context context, List<HistoryMoney> list) {
        super(context, R.layout.martian_income_list_item, list);
        this.f13899i = context;
    }

    @Override // com.martian.libmars.widget.recyclerview.adatper.CommonRecycleViewAdapter
    /* renamed from: t */
    public void k(ViewHolderHelper viewHolderHelper, HistoryMoney historyMoney) {
        u(viewHolderHelper, historyMoney);
    }

    public final void u(ViewHolderHelper viewHolderHelper, HistoryMoney historyMoney) {
        if (historyMoney == null) {
            return;
        }
        viewHolderHelper.A(R.id.martian_income_title, l.q(historyMoney.getMoneyType()) ? "金币兑换余额" : historyMoney.getMoneyType());
        if (historyMoney.getMoney() > 0) {
            viewHolderHelper.B(R.id.martian_income_num, ContextCompat.getColor(this.f13899i, com.martian.libmars.R.color.bonus_red));
            viewHolderHelper.A(R.id.martian_income_num, "+" + f.q(Integer.valueOf(historyMoney.getMoney())) + "元");
        } else {
            viewHolderHelper.B(R.id.martian_income_num, ConfigSingleton.D().h0());
            viewHolderHelper.A(R.id.martian_income_num, f.q(Integer.valueOf(historyMoney.getMoney())) + "元");
        }
        try {
            viewHolderHelper.A(R.id.martian_income_time, ba.f.h(historyMoney.getCreatedOn().longValue()));
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }
}
