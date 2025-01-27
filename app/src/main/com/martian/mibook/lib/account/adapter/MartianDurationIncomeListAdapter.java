package com.martian.mibook.lib.account.adapter;

import android.content.Context;
import androidx.core.content.ContextCompat;
import ba.l;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.widget.recyclerview.ViewHolderHelper;
import com.martian.libmars.widget.recyclerview.adatper.CommonRecycleViewAdapter;
import com.martian.mibook.lib.account.R;
import com.martian.mibook.lib.account.response.HistoryDuration;
import java.util.List;
import oe.f;

/* loaded from: classes3.dex */
public class MartianDurationIncomeListAdapter extends CommonRecycleViewAdapter<HistoryDuration> {

    /* renamed from: i */
    public final Context f13898i;

    public MartianDurationIncomeListAdapter(Context context, List<HistoryDuration> list) {
        super(context, R.layout.martian_income_list_item, list);
        this.f13898i = context;
    }

    @Override // com.martian.libmars.widget.recyclerview.adatper.CommonRecycleViewAdapter
    /* renamed from: t */
    public void k(ViewHolderHelper viewHolderHelper, HistoryDuration historyDuration) {
        u(viewHolderHelper, historyDuration);
    }

    public final void u(ViewHolderHelper viewHolderHelper, HistoryDuration historyDuration) {
        if (historyDuration == null) {
            return;
        }
        viewHolderHelper.A(R.id.martian_income_title, l.q(historyDuration.getType()) ? "金币收入" : historyDuration.getType());
        if (historyDuration.getCoins().intValue() >= 0) {
            viewHolderHelper.A(R.id.martian_income_num, "+" + historyDuration.getCoins() + "金币");
            viewHolderHelper.B(R.id.martian_income_num, ContextCompat.getColor(this.f13898i, com.martian.libmars.R.color.bonus_red));
        } else {
            viewHolderHelper.A(R.id.martian_income_num, historyDuration.getCoins() + "金币");
            viewHolderHelper.B(R.id.martian_income_num, ConfigSingleton.D().h0());
        }
        viewHolderHelper.A(R.id.martian_income_time, f.e(historyDuration.getCreatedOn()));
    }
}
